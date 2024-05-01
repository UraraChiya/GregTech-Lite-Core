package magicbook.gtlitecore.api.pattern;

import gregtech.api.block.VariantActiveBlock;
import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import gregtech.common.blocks.BlockFireboxCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.multi.electric.MetaTileEntityPowerSubstation;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.api.metatileentity.multi.GTLiteMultiblockAbility;
import magicbook.gtlitecore.api.metatileentity.multi.IYottaTankData;
import magicbook.gtlitecore.api.pattern.predicates.TierTraceabilityPredicate;
import magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityIndustrialRoaster;
import magicbook.gtlitecore.common.metatileentities.multi.part.MetaTileEntityReinforcedRotorHolder;
import magicbook.gtlitecore.common.metatileentities.multi.storage.MetaTileEntityYottaFluidTank;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static magicbook.gtlitecore.api.GTLiteAPI.*;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getCandidates;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getTileEntity;

/**
 * Traceability Predicate for gtlitecore
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     Traceability Predicate class like {@link TraceabilityPredicate},
 *     used to load all traceability predicate for multiblocks.
 * </p>
 *
 * @since 2.8.7-beta
 */
public class GTLiteTraceabilityPredicate {

    //////////////////////////////////////
    //  Common Traceability Predicates  //
    //////////////////////////////////////

    /**
     * Firebox Casing Predicate.
     *
     * <p>
     *     This is a heating coil like predicate, used in {@link MetaTileEntityIndustrialRoaster}.
     *     Extended predicate related {@code temperature} parameter is init in {@code formStructure()},
     *     and each firebox (in {@link BlockFireboxCasing}) get a special temperature by oridinal.
     * </p>
     */
    public static Supplier<TraceabilityPredicate> FIRE_BOX = () -> new TraceabilityPredicate(blockWorldState -> {
        IBlockState blockState = blockWorldState.getBlockState();
        if ((blockState.getBlock() instanceof BlockFireboxCasing BlockFireboxCasing)) {
            BlockFireboxCasing.FireboxCasingType casingType = BlockFireboxCasing.getState(blockState);
            Object currentCasingType = blockWorldState.getMatchContext().getOrPut("CasingType", casingType);
            if (!currentCasingType.toString().equals(casingType.toString())) {
                blockWorldState.setError(new PatternStringError("gtlitecore.machine.pattern.firebox"));
                return false;
            }
            blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>()).add(blockWorldState.getPos());
            return true;
        }
        return false;
    }, () -> ArrayUtils.addAll(Arrays.stream(BlockFireboxCasing.FireboxCasingType.values())
            .map(type -> new BlockInfo(MetaBlocks.BOILER_FIREBOX_CASING.getState(type), null))
            .toArray(BlockInfo[]::new)))
            .addTooltips("gtlitecore.machine.pattern.firebox");

    /**
     * Yotta Fluid Tank Cell Predicate.
     *
     * <p>
     *     This is the basic predicate of Yotta Tank, please see: {@code BATTERY_PREDICATE},
     *     this predicate is another predicate in {@link MetaTileEntityPowerSubstation},
     *     but two predicates use same method. Yotta Tank Cells init in {@link GTLiteAPI}.
     * </p>
     *
     */
    public static final Supplier<TraceabilityPredicate> CELL_PREDICATE = () -> new TraceabilityPredicate(blockWorldState -> {
        IBlockState state = blockWorldState.getBlockState();
        if (MAP_YOT_TANK_CELL.containsKey(state)) {
            IYottaTankData cells = MAP_YOT_TANK_CELL.get(state);
            if (cells.getTier() != -1 && cells.getCapacity() > 0) {
                String key = MetaTileEntityYottaFluidTank.YOT_CELL_HEADER + cells.getFluidCellName();
                MetaTileEntityYottaFluidTank.YOTTankMatchWrapper wrapper = blockWorldState.getMatchContext().get(key);
                if (wrapper == null)
                    wrapper = new MetaTileEntityYottaFluidTank.YOTTankMatchWrapper(cells);
                blockWorldState.getMatchContext().set(key, wrapper.increment());
            }
            return true;
        }
        return false;
    }, () -> MAP_YOT_TANK_CELL.entrySet().stream()
            .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
            .map(entry -> new BlockInfo(entry.getKey(), null))
            .toArray(BlockInfo[]::new))
            .addTooltips("gtlitecore.machine.yotta_fluid_tank.error.cells");

    /**
     * (Reinforced) Rotor Holder Predicate.
     *
     * <p>
     *     Just a rotor holder predicate rewrite for {@link MetaTileEntityReinforcedRotorHolder}.
     * </p>
     */
    public static Supplier<TraceabilityPredicate> ROTOR_HOLDER = () -> new TraceabilityPredicate(blockWorldState -> {
        TileEntity tileEntity = blockWorldState.getTileEntity();
        if (tileEntity instanceof IGregTechTileEntity) {
            List<ResourceLocation> list = MultiblockAbility.REGISTRY.get(GTLiteMultiblockAbility.REINFORCED_ROTOR_HOLDER_ABILITY).stream()
                    .map(mte -> mte.metaTileEntityId)
                    .collect(Collectors.toList());
            MetaTileEntity mte = ((IGregTechTileEntity)tileEntity).getMetaTileEntity();
            if (list.contains(mte.metaTileEntityId)) {
                int tier = ((ITieredMetaTileEntity) mte).getTier();
                Object currentTier = blockWorldState.getMatchContext().getOrPut("RotorHolderTier", tier);
                if (!currentTier.equals(tier)) {
                    blockWorldState.setError(new PatternStringError("gtlitecore.machine.reinforced_rotor_holder.error"));
                    return false;
                }
                Set<IMultiblockPart> partsFound = blockWorldState.getMatchContext().getOrCreate("MultiblockParts", HashSet::new);
                partsFound.add((IMultiblockPart) mte);
                return true;
            }
        }
        return false;
    }, () -> MultiblockAbility.REGISTRY.get(GTLiteMultiblockAbility.REINFORCED_ROTOR_HOLDER_ABILITY).stream()
            .sorted(Comparator.comparingInt(mte -> ((ITieredMetaTileEntity) mte).getTier()))
            .map(mte -> new BlockInfo(MetaBlocks.MACHINE.getDefaultState(), getTileEntity(mte)))
            .toArray(BlockInfo[]::new))
            .addTooltips("gtlitecore.machine.reinforced_rotor_holder.error");

    /**
     * Optional State in Multiblock Structure.
     *
     * <p>
     *     This is a special state for {@link FactoryBlockPattern},
     *     used for some update meta tile entities.
     * </p>
     *
     * @param mark           Symbol to get these infoes in formStructure().
     * @param allowedStates  Allowed state, i.e. block mean of this symbol (like: 'S', getCasingState()),
     *                       and getCasingState() is a {@link IBlockState} getter.
     * @return               Just like blockMatcher parameter in {@link FactoryBlockPattern},
     *                       you can use correspond text (mark) to check if the aisle is your upgrade structure part.
     */
    public static TraceabilityPredicate optionalStates(String mark, IBlockState... allowedStates) {
        return new TraceabilityPredicate(blockWorldState -> {
            IBlockState state = blockWorldState.getBlockState();
            if (state.getBlock() instanceof VariantActiveBlock) {
                blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>()).add(blockWorldState.getPos());
            }
            if (ArrayUtils.contains(allowedStates, state)) {
                return (blockWorldState.getMatchContext().getOrPut(mark, true));
            }
            return blockWorldState.getMatchContext().get(mark) == null;
        }, getCandidates(allowedStates));
    }

    /**
     * Optional Ability in Multiblock Structure.
     *
     * <p>This is a special ability for {@link FactoryBlockPattern},
     * used for some update meta tile entities.</p>
     *
     * @param mark              Symbol to get these infoes in formStructure().
     * @param allowedAbilities  Allowed ability, i.e. ability mean of this symbol,
     *                          like: {@code abilities(MultiblockAbility.IMPORT_ITEM},
     *                          please use abilities in {@link MultiblockAbility}) and gtlitecore's ability class,
     *                          i.e. {@link GTLiteMultiblockAbility}.
     * @return                  Just like abilities() in {@link MultiblockControllerBase},
     *                          you can use correspond text (mark) to check if the ability is your upgrade structure part.
     */
    public static TraceabilityPredicate optionalAbilities(String mark, MultiblockAbility<?>... allowedAbilities) {
        return new TraceabilityPredicate(blockWorldState -> {
            TileEntity tileEntity = blockWorldState.getTileEntity();
            if (tileEntity instanceof IGregTechTileEntity) {
                MetaTileEntity metaTileEntity = ((IGregTechTileEntity) tileEntity).getMetaTileEntity();
                if (metaTileEntity instanceof IMultiblockAbilityPart<?> && ArrayUtils.contains(allowedAbilities, ((IMultiblockAbilityPart<?>) metaTileEntity).getAbility())) {
                    Set<IMultiblockPart> partsFound = blockWorldState.getMatchContext().getOrCreate("MultiblockParts", HashSet::new);
                    partsFound.add((IMultiblockPart) metaTileEntity);
                    return (blockWorldState.getMatchContext().getOrPut(mark, true));
                }
            }
            return blockWorldState.getMatchContext().get(mark) == null;
        }, getCandidates(Arrays.stream(allowedAbilities).flatMap(ability -> MultiblockAbility.REGISTRY.get(ability).stream()).toArray(MetaTileEntity[]::new)));
    }

    ////////////////////////////////////
    //  Tier Traceability Predicates  //
    ////////////////////////////////////

    //  Precise Assembler Predicate
    public static Supplier<TierTraceabilityPredicate> PA_CASING = () -> new TierTraceabilityPredicate(MAP_PA_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_PA_CASING.get(s)).getIntTier()), "PACasing", null);

    public static Supplier<TierTraceabilityPredicate> PA_INTERNAL_CASING = () -> new TierTraceabilityPredicate(MAP_PA_INTERNAL_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_PA_INTERNAL_CASING.get(s)).getIntTier()), "PAInternalCasing", null);

    //  Component Assembly Line Predicate
    public static Supplier<TierTraceabilityPredicate> CA_CASING = () -> new TierTraceabilityPredicate(MAP_CA_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_CA_CASING.get(s)).getIntTier()), "CACasing", null);

    //  Field Casing Predicate
    public static Supplier<TierTraceabilityPredicate> FIELD_CASING = () -> new TierTraceabilityPredicate(MAP_FIELD_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_FIELD_CASING.get(s)).getIntTier()), "FieldCasing", null);

    //  Space Elevator Motor Casing Predicate
    public static Supplier<TierTraceabilityPredicate> SPACE_ELEVATOR_MOTOR = () -> new TierTraceabilityPredicate(MAP_SPACE_ELEVATOR_MOTOR,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_SPACE_ELEVATOR_MOTOR.get(s)).getIntTier()), "SpaceElevatorMotor", null);

    //  Cooling Core Predicate
    public static Supplier<TierTraceabilityPredicate> COOLING_CORE = () -> new TierTraceabilityPredicate(MAP_COOLING_CORE,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_COOLING_CORE.get(s)).getIntTier()), "CoolingCore", null);

    //  Graviton Casing Predicate
    public static Supplier<TierTraceabilityPredicate> GRAVITON_CASING = () -> new TierTraceabilityPredicate(MAP_GRAVITON_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_GRAVITON_CASING.get(s)).getIntTier()), "GravitonCasing", null);
}