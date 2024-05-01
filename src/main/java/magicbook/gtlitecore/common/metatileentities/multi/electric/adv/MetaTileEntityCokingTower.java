package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.GregTechAPI;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.*;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.core.sound.GTSoundEvents;
import magicbook.gtlitecore.api.utils.GTLiteUtils;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static gregtech.api.GTValues.EV;
import static gregtech.api.GTValues.LV;

public class MetaTileEntityCokingTower extends RecipeMapMultiblockController {

    protected int heatingCoilLevel;
    protected int coilTier;
    private static boolean init = false;
    private static List<IBlockState> finalListCoil;

    public MetaTileEntityCokingTower(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.PYROLYSE_RECIPES);
        this.recipeMapWorkable = new CokingTowerRecipeLogic(this);
        initMap();
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityCokingTower(metaTileEntityId);
    }

    private void initMap() {
        if (init) return;

        List<IBlockState> listCoil = GregTechAPI.HEATING_COILS.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int maxLeng = GTLiteUtils.maxLength(new ArrayList<List<IBlockState>>() {{
            add(listCoil);
        }});
        finalListCoil = GTLiteUtils.consistentList(listCoil, maxLeng);

        init = true;
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object coilType = context.get("CoilType");
        if (coilType instanceof IHeatingCoilBlockStats) {
            this.heatingCoilLevel = ((IHeatingCoilBlockStats) coilType).getLevel();
            this.coilTier = ((IHeatingCoilBlockStats) coilType).getTier();
        } else {
            this.heatingCoilLevel = BlockWireCoil.CoilType.CUPRONICKEL.getLevel();
            this.coilTier = BlockWireCoil.CoilType.CUPRONICKEL.getTier();
        }
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        heatingCoilLevel = 0;
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("F   F", "FCCCF", "CCCCC", " CCC ", "     ", "     ", "     ", "     ", "     ")
                .aisle(" DDD ", "CHHHC", "C###C", "CHHHC", " ccc ", "  c  ", "  c  ", "  c  ", "  c  ")
                .aisle(" DDD ", "CHPHC", "V#P#V", "CHPHC", " cPc ", " cPc ", " cPc ", " cPc ", " cOc ")
                .aisle(" DDD ", "CHHHC", "C###C", "CHHHC", " ccc ", "  c  ", "  c  ", "  c  ", "  c  ")
                .aisle("F   F", "FCCCF", "CCSCC", " CCC ", "     ", "     ", "     ", "     ", "     ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(25)
                        .or(autoAbilities()))
                .where('c', states(getCasingState()))
                .where('D', states(getBoilerCasingState()))
                .where('F', states(getFrameState()))
                .where('P', states(getSecondBoilerCasingState()))
                .where('V', states(getUniqueCasingState()))
                .where('H', heatingCoils())
                .where('O', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('#', air())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_FIREBOX_CASING.getState(BlockFireboxCasing.FireboxCasingType.STEEL_FIREBOX);
    }

    private static IBlockState getSecondBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE);
    }

    private static IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(GCYMMaterials.HSLASteel).getBlock(GCYMMaterials.HSLASteel);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.COKING_TOWER_OVERLAY;
    }

    public SoundEvent getBreakdownSound() {
        return GTSoundEvents.BREAKDOWN_ELECTRICAL;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.coking_tower.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.coking_tower.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.coking_tower.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.coking_tower.tooltip.4"));
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle("F   F", "FMEEF", "CCCCC", " CCC ", "     ", "     ", "     ", "     ", "     ")
                    .aisle(" DDD ", "CHHHC", "C###C", "CHHHC", " ccc ", "  c  ", "  c  ", "  c  ", "  c  ")
                    .aisle(" DDD ", "CHPHC", "V#P#V", "CHPHC", " cPc ", " cPc ", " cPc ", " cPc ", " cOc ")
                    .aisle(" DDD ", "CHHHC", "C###C", "CHHHC", " ccc ", "  c  ", "  c  ", "  c  ", "  c  ")
                    .aisle("F   F", "FCCCF", "XYSZW", " CCC ", "     ", "     ", "     ", "     ", "     ")
                    .where('S', GTLiteMetaTileEntities.COKING_TOWER, EnumFacing.SOUTH)
                    .where('C', getCasingState())
                    .where('c', getCasingState())
                    .where('D', getBoilerCasingState())
                    .where('F', getFrameState())
                    .where('P', getSecondBoilerCasingState())
                    .where('V', getUniqueCasingState())
                    .where('O', MetaTileEntities.MUFFLER_HATCH[LV], EnumFacing.UP)
                    .where('X', MetaTileEntities.ITEM_IMPORT_BUS[EV], EnumFacing.SOUTH)
                    .where('Y', MetaTileEntities.FLUID_IMPORT_HATCH[EV], EnumFacing.SOUTH)
                    .where('Z', MetaTileEntities.ITEM_EXPORT_BUS[EV], EnumFacing.SOUTH)
                    .where('W', MetaTileEntities.FLUID_EXPORT_HATCH[EV], EnumFacing.SOUTH)
                    .where('M', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : getCasingState(), EnumFacing.NORTH)
                    .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[EV], EnumFacing.NORTH)
                    .where('#', Blocks.AIR.getDefaultState());
        }
        MultiblockShapeInfo.Builder finalBuilder = builder;
        AtomicInteger count = new AtomicInteger();
        finalListCoil.stream()
                .map(b -> {
                    if (finalBuilder != null) {
                        finalBuilder.where('H', b);
                        count.getAndIncrement();
                    }
                    return finalBuilder;
                })
                .filter(Objects::nonNull)
                .forEach(b -> shapeInfo.add(b.build()));
        return shapeInfo;
    }

    public static int getMaxParallel(int heatingCoilLevel) {
        return heatingCoilLevel * 16;
    }

    protected class CokingTowerRecipeLogic extends MultiblockRecipeLogic {

        public CokingTowerRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        /**
         * @return Get (16 * heatingCoilLevel) parallel.
         *         Max Parallel: 2048 (Astralium wire coil block).
         */
        @Override
        public int getParallelLimit() {
            return getMaxParallel(heatingCoilLevel);
        }

        /**
         * @param maxProgress Get reduction for recipe duration from coil tier.
         *                    When coil tier increases, duration becomes 0.8 origin.
         */
        @Override
        public void setMaxProgress(int maxProgress) {
            int MaxProgress = (int) Math.floor(maxProgress * Math.pow(0.8, coilTier));
            // GTLiteLog.logger.info("check");
            super.setMaxProgress(MaxProgress);
        }
    }

}
