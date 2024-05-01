package magicbook.gtlitecore.common.metatileentities.multi.electric;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.capability.*;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.resources.IGuiTexture;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.SuppliedImageWidget;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.*;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.api.util.RelativeDirection;
import gregtech.api.util.TextComponentUtil;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.ConfigHolder;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.core.sound.GTSoundEvents;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import magicbook.gtlitecore.api.capability.IQCComponentHatch;
import magicbook.gtlitecore.api.capability.IQCComputationProvider;
import magicbook.gtlitecore.api.capability.IQCCoolantProvider;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import magicbook.gtlitecore.api.metatileentity.multi.GTLiteMultiblockAbility;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockQuantumComputerCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Supplier;

/**
 * Quantum Computer
 *
 * <p>
 *     Just an Advanced HPCA, used to provide more CWU for UHV+ stages.
 * </p>
 *
 * @since 2.8.7-beta
 */
public class MetaTileEntityQuantumComputer extends MultiblockWithDisplayBase implements IOpticalComputationProvider, IControllable, IProgressBarMultiblock {

    private IEnergyContainer energyContainer = new EnergyContainerList(new ArrayList<>());
    private IFluidHandler coolantHandler;

    private final QCGridHandler qcHandler = new QCGridHandler(this);

    private boolean isActive;
    private boolean isWorkingEnabled = true;
    private boolean hasNotEnoughEnergy;

    private double temperature = 200.0;

    private final ProgressWidget.TimedProgressSupplier progressSupplier = new ProgressWidget.TimedProgressSupplier(200, 47, false);

    public MetaTileEntityQuantumComputer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityQuantumComputer(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        this.energyContainer = new EnergyContainerList(this.getAbilities(MultiblockAbility.INPUT_ENERGY));
        this.coolantHandler = new FluidTankList(false, this.getAbilities(MultiblockAbility.IMPORT_FLUIDS));
        this.qcHandler.onStructureForm(this.getAbilities(GTLiteMultiblockAbility.QC_COMPONENT));
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.energyContainer = new EnergyContainerList(new ArrayList());
        this.qcHandler.onStructureInvalidate();
    }

    @Override
    public int requestCWUt(int CWUt,
                           boolean simulate,
                           @Nonnull Collection<IOpticalComputationProvider> seen) {
        seen.add(this);
        return this.isActive() && this.isWorkingEnabled() && !this.hasNotEnoughEnergy ? this.qcHandler.allocateCWUt(CWUt, simulate) : 0;
    }

    @Override
    public int getMaxCWUt(@Nonnull Collection<IOpticalComputationProvider> seen) {
        seen.add(this);
        return this.isActive() && this.isWorkingEnabled() ? this.qcHandler.getMaxCWUt() : 0;
    }

    @Override
    public boolean canBridge(@Nonnull Collection<IOpticalComputationProvider> seen) {
        seen.add(this);
        return !this.isStructureFormed() || this.qcHandler.hasQCBridge();
    }

    @Override
    public void update() {
        super.update();
        if (this.getWorld().isRemote) {
            if (this.isStructureFormed()) {
                this.qcHandler.tryGatherClientComponents(this.getWorld(), this.getPos(), this.getFrontFacing(), this.getUpwardsFacing(), this.isFlipped());
            } else {
                this.qcHandler.clearClientComponents();
            }
        }
    }

    @Override
    protected void updateFormedValid() {
        if (this.isWorkingEnabled()) {
            this.consumeEnergy();
        }

        if (this.isActive()) {
            double midpoint = 400.0;
            double temperatureChange = this.qcHandler.calculateTemperatureChange(this.coolantHandler, this.temperature >= midpoint) / 2.0;
            if (this.temperature + temperatureChange <= 200.0) {
                this.temperature = 200.0;
            } else {
                this.temperature += temperatureChange;
            }

            if (this.temperature >= 1000.0) {
                this.qcHandler.attemptDamageQC();
            }

            this.qcHandler.tick();
        } else {
            this.qcHandler.clearComputationCache();
            this.temperature = Math.max(200.0, this.temperature - 0.25);
        }
    }

    private void consumeEnergy() {
        int energyToConsume = this.qcHandler.getCurrentEUt();
        boolean hasMaintenance = ConfigHolder.machines.enableMaintenance && this.hasMaintenanceMechanics();
        if (hasMaintenance) {
            energyToConsume += this.getNumMaintenanceProblems() * energyToConsume / 10;
        }

        if (this.hasNotEnoughEnergy && this.energyContainer.getInputPerSec() > 19L * (long)energyToConsume) {
            this.hasNotEnoughEnergy = false;
        }

        if (this.energyContainer.getEnergyStored() >= (long) energyToConsume) {
            if (!this.hasNotEnoughEnergy) {
                long consumed = this.energyContainer.removeEnergy(energyToConsume);
                if (consumed == (long) (- energyToConsume)) {
                    this.setActive(true);
                } else {
                    this.hasNotEnoughEnergy = true;
                    this.setActive(false);
                }
            }
        } else {
            this.hasNotEnoughEnergy = true;
            this.setActive(false);
        }

    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("AA", "CC", "CC", "CC", "AA")
                .aisle("VA", "XV", "XV", "XV", "VA")
                .aisle("VA", "XV", "XV", "XV", "VA")
                .aisle("VA", "XV", "XV", "XV", "VA")
                .aisle("SA", "CC", "CC", "CC", "AA")
                .where('S', this.selfPredicate())
                .where('A', states(getSecondCasingState()))
                .where('V', states(getUniqueCasingState()))
                .where('X', abilities(GTLiteMultiblockAbility.QC_COMPONENT))
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(5)
                        .or(maintenancePredicate())
                        .or(abilities(MultiblockAbility.INPUT_ENERGY)
                                .setMinGlobalLimited(1))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS)
                                .setMaxGlobalLimited(1))
                        .or(abilities(MultiblockAbility.COMPUTATION_DATA_TRANSMISSION)
                                .setExactLimit(1)))
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.QUANTUM_COMPUTER_CASING.getState(BlockQuantumComputerCasing.QCCasingType.COMPUTER_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GTLiteMetaBlocks.QUANTUM_COMPUTER_CASING.getState(BlockQuantumComputerCasing.QCCasingType.ADVANCED_COMPUTER_CASING);
    }

    private static IBlockState getUniqueCasingState() {
        return GTLiteMetaBlocks.QUANTUM_COMPUTER_CASING.getState(BlockQuantumComputerCasing.QCCasingType.HEAT_VENT);
    }

    @SuppressWarnings({"rawtypes"})
    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        List<MultiblockShapeInfo> shapeInfo = new ArrayList();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("AA", "EC", "MC", "HC", "AA")
                .aisle("VA", "6V", "3V", "0V", "VA")
                .aisle("VA", "7V", "4V", "1V", "VA")
                .aisle("VA", "8V", "5V", "2V", "VA")
                .aisle("SA", "CC", "CC", "OC", "AA")
                .where('S', GTLiteMetaTileEntities.QUANTUM_COMPUTER, EnumFacing.SOUTH)
                .where('A', getSecondCasingState())
                .where('V', getUniqueCasingState())
                .where('C', getCasingState())
                .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.UHV], EnumFacing.NORTH)
                .where('H', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.UHV], EnumFacing.NORTH)
                .where('O', MetaTileEntities.COMPUTATION_HATCH_TRANSMITTER, EnumFacing.SOUTH)
                .where('M', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : getCasingState(), EnumFacing.NORTH);
        shapeInfo.add(builder.shallowCopy()
                .where('0', GTLiteMetaTileEntities.QC_EMPTY_COMPONENT, EnumFacing.WEST)
                .where('1', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .where('2', GTLiteMetaTileEntities.QC_EMPTY_COMPONENT, EnumFacing.WEST)
                .where('3', GTLiteMetaTileEntities.QC_EMPTY_COMPONENT, EnumFacing.WEST)
                .where('4', GTLiteMetaTileEntities.QC_COMPUTATION_COMPONENT[0], EnumFacing.WEST)
                .where('5', GTLiteMetaTileEntities.QC_EMPTY_COMPONENT, EnumFacing.WEST)
                .where('6', GTLiteMetaTileEntities.QC_EMPTY_COMPONENT, EnumFacing.WEST)
                .where('7', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .where('8', GTLiteMetaTileEntities.QC_EMPTY_COMPONENT, EnumFacing.WEST).build());
        shapeInfo.add(builder.shallowCopy()
                .where('0', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .where('1', GTLiteMetaTileEntities.QC_COMPUTATION_COMPONENT[0], EnumFacing.WEST)
                .where('2', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .where('3', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[1], EnumFacing.WEST)
                .where('4', GTLiteMetaTileEntities.QC_COMPUTATION_COMPONENT[0], EnumFacing.WEST)
                .where('5', GTLiteMetaTileEntities.QC_BRIDGE_COMPONENT, EnumFacing.WEST)
                .where('6', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .where('7', GTLiteMetaTileEntities.QC_COMPUTATION_COMPONENT[0], EnumFacing.WEST)
                .where('8', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .build());
        shapeInfo.add(builder.shallowCopy()
                .where('0', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .where('1', GTLiteMetaTileEntities.QC_COMPUTATION_COMPONENT[0], EnumFacing.WEST)
                .where('2', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .where('3', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .where('4', GTLiteMetaTileEntities.QC_COMPUTATION_COMPONENT[1], EnumFacing.WEST)
                .where('5', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .where('6', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .where('7', GTLiteMetaTileEntities.QC_BRIDGE_COMPONENT, EnumFacing.WEST)
                .where('8', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .build());
        shapeInfo.add(builder.shallowCopy()
                .where('0', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .where('1', GTLiteMetaTileEntities.QC_COMPUTATION_COMPONENT[1], EnumFacing.WEST)
                .where('2', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .where('3', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[1], EnumFacing.WEST)
                .where('4', GTLiteMetaTileEntities.QC_BRIDGE_COMPONENT, EnumFacing.WEST)
                .where('5', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[1], EnumFacing.WEST)
                .where('6', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .where('7', GTLiteMetaTileEntities.QC_COMPUTATION_COMPONENT[1], EnumFacing.WEST)
                .where('8', GTLiteMetaTileEntities.QC_COOLER_COMPONENT[0], EnumFacing.WEST)
                .build());
        return shapeInfo;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return iMultiblockPart == null ? GTLiteTextures.ADVANCED_COMPUTER_CASING : GTLiteTextures.COMPUTER_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.QUANTUM_COMPUTER_OVERLAY;
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState,
                                     Matrix4 translation,
                                     IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        this.getFrontOverlay().renderOrientedState(renderState, translation, pipeline, this.getFrontFacing(), this.isActive(), this.isWorkingEnabled());
    }

    @Override
    public boolean isActive() {
        return super.isActive() && this.isActive;
    }

    public void setActive(boolean active) {
        if (this.isActive != active) {
            this.isActive = active;
            this.markDirty();
            if (this.getWorld() != null && !this.getWorld().isRemote) {
                this.writeCustomData(GregtechDataCodes.WORKABLE_ACTIVE, (buf) -> {
                    buf.writeBoolean(active);
                });
            }
        }
    }

    @Override
    public boolean isWorkingEnabled() {
        return this.isWorkingEnabled;
    }

    public void setWorkingEnabled(boolean isWorkingAllowed) {
        if (this.isWorkingEnabled != isWorkingAllowed) {
            this.isWorkingEnabled = isWorkingAllowed;
            this.markDirty();
            if (this.getWorld() != null && !this.getWorld().isRemote) {
                this.writeCustomData(GregtechDataCodes.WORKING_ENABLED, (buf) -> {
                    buf.writeBoolean(this.isWorkingEnabled);
                });
            }
        }
    }

    @Override
    protected ModularUI.Builder createUITemplate(EntityPlayer entityPlayer) {
        ModularUI.Builder builder = super.createUITemplate(entityPlayer);
        ProgressWidget var10001 = (new ProgressWidget(() -> this.qcHandler.getAllocatedCWUt() > 0 ? this.progressSupplier.getAsDouble() : 0.0,
                74, 57, 47, 47, GTLiteGuiTextures.QC_COMPONENT_OUTLINE, ProgressWidget.MoveType.HORIZONTAL))
                .setIgnoreColor(true);

        QCGridHandler var10002 = this.qcHandler;
        Objects.requireNonNull(var10002);
        builder.widget(var10001.setHoverTextConsumer(var10002::addInfo));

        int startX = 76;
        int startY = 59;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int index = i * 3 + j;
                Supplier<IGuiTexture> textureSupplier = () -> this.qcHandler.getComponentTexture(index);
                builder.widget((new SuppliedImageWidget(startX + 15 * j, startY + 15 * i, 13, 13, textureSupplier))
                        .setIgnoreColor(true));
            }
        }

        return builder;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        MultiblockDisplayText.builder(textList, this.isStructureFormed())
                .setWorkingStatus(true, this.qcHandler.getAllocatedCWUt() > 0)
                .setWorkingStatusKeys("gregtech.multiblock.idling", "gregtech.multiblock.idling", "gregtech.multiblock.data_bank.providing")
                .addCustom((tl) -> {
                    if (this.isStructureFormed()) {
                        ITextComponent voltageName = new TextComponentString(GTValues.VNF[GTUtility.getTierByVoltage(this.qcHandler.getMaxEUt())]);
                        tl.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.multiblock.hpca.energy", TextFormattingUtil.formatNumbers(this.qcHandler.cachedEUt), TextFormattingUtil.formatNumbers(this.qcHandler.getMaxEUt()), voltageName));
                        ITextComponent cwutInfo = TextComponentUtil.stringWithColor(TextFormatting.AQUA, this.qcHandler.cachedCWUt + " / " + this.qcHandler.getMaxCWUt() + " CWU/t");
                        tl.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.multiblock.hpca.computation", cwutInfo));}})
                .addWorkingStatusLine();
    }

    private TextFormatting getDisplayTemperatureColor() {
        if (this.temperature < 1000.0) {
            return TextFormatting.GREEN;
        } else {
            return this.temperature < 1500.0 ? TextFormatting.YELLOW : TextFormatting.RED;
        }
    }

    @Override
    protected void addWarningText(List<ITextComponent> textList) {
        MultiblockDisplayText.builder(textList, this.isStructureFormed(), false)
                .addLowPowerLine(this.hasNotEnoughEnergy)
                .addCustom((tl) -> {
                    if (this.isStructureFormed()) {
                        if (this.temperature > 1000.0) {
                            tl.add(TextComponentUtil.translationWithColor(TextFormatting.YELLOW, "gtlitecore.machine.quantum_computer.warning.high_temperature"));
                        }
                        this.qcHandler.addWarnings(tl);}})
                .addMaintenanceProblemLines(this.getMaintenanceProblems());
    }

    @Override
    protected void addErrorText(List<ITextComponent> textList) {
        super.addErrorText(textList);
        if (this.isStructureFormed()) {
            if (this.temperature > 2000.0) {
                textList.add(TextComponentUtil.translationWithColor(TextFormatting.RED, "gtlitecore.machine.quantum_computer.error.overheat"));
            }
            this.qcHandler.addErrors(textList);
        }
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World world,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.quantum_computer.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.quantum_computer.tooltip.2"));
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public SoundEvent getSound() {
        return GTSoundEvents.COMPUTATION;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setBoolean("isActive", this.isActive);
        data.setBoolean("isWorkingEnabled", this.isWorkingEnabled);
        data.setDouble("temperature", this.temperature);
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.isActive = data.getBoolean("isActive");
        this.isWorkingEnabled = data.getBoolean("isWorkingEnabled");
        this.temperature = data.getDouble("temperature");
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeBoolean(this.isActive);
        buf.writeBoolean(this.isWorkingEnabled);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.isActive = buf.readBoolean();
        this.isWorkingEnabled = buf.readBoolean();
    }

    @Override
    public void receiveCustomData(int dataId, @Nonnull PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == GregtechDataCodes.WORKABLE_ACTIVE) {
            this.isActive = buf.readBoolean();
            this.scheduleRenderUpdate();
        } else if (dataId == GregtechDataCodes.WORKING_ENABLED) {
            this.isWorkingEnabled = buf.readBoolean();
            this.scheduleRenderUpdate();
        } else if (dataId == GregtechDataCodes.CACHED_CWU) {
            this.qcHandler.cachedCWUt = buf.readInt();
        }
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        return capability == GregtechTileCapabilities.CAPABILITY_CONTROLLABLE ? GregtechTileCapabilities.CAPABILITY_CONTROLLABLE.cast(this) : super.getCapability(capability, side);
    }

    @Override
    public int getNumProgressBars() {
        return 2;
    }

    @Override
    public double getFillPercentage(int index) {
        return index == 0 ? 1.0 * (double) this.qcHandler.cachedCWUt / (double) this.qcHandler.getMaxCWUt() : Math.min(1.0, this.temperature / 2000.0);
    }

    @Override
    public TextureArea getProgressBarTexture(int index) {
        return index == 0 ? GuiTextures.PROGRESS_BAR_HPCA_COMPUTATION : GuiTextures.PROGRESS_BAR_FUSION_HEAT;
    }

    @Override
    public void addBarHoverText(List<ITextComponent> hoverList, int index) {
        TextComponentString cwutInfo;
        if (index == 0) {
            cwutInfo = TextComponentUtil.stringWithColor(TextFormatting.AQUA, this.qcHandler.cachedCWUt + " / " + this.qcHandler.getMaxCWUt() + " CWU/t");
            hoverList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.multiblock.hpca.computation", cwutInfo));
        } else {
            cwutInfo = TextComponentUtil.stringWithColor(this.getDisplayTemperatureColor(), Math.round(this.temperature / 10.0) + "°C");
            hoverList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.multiblock.hpca.temperature", cwutInfo));
        }
    }

    public static class QCGridHandler {

        private final @Nullable MetaTileEntityQuantumComputer controller;

        private final List<IQCComponentHatch> components = new ObjectArrayList<>();
        private final Set<IQCCoolantProvider> coolantProviders = new ObjectOpenHashSet<>();
        private final Set<IQCComputationProvider> computationProviders = new ObjectOpenHashSet<>();

        private int numBridges;
        private int allocatedCWUt;
        private int cachedEUt;
        private int cachedCWUt;

        public QCGridHandler(@Nullable MetaTileEntityQuantumComputer controller) {
            this.controller = controller;
        }

        @SuppressWarnings("rawtypes")
        public void onStructureForm(Collection<IQCComponentHatch> components) {
            this.reset();

            Iterator var2 = components.iterator();
            while(var2.hasNext()) {
                IQCComponentHatch component = (IQCComponentHatch) var2.next();
                this.components.add(component);
                //  Coolant component
                if (component instanceof IQCCoolantProvider) {
                    IQCCoolantProvider coolantProvider = (IQCCoolantProvider) component;
                    this.coolantProviders.add(coolantProvider);
                }
                //  Computation component
                if (component instanceof IQCComputationProvider) {
                    IQCComputationProvider computationProvider = (IQCComputationProvider) component;
                    this.computationProviders.add(computationProvider);
                }
                //  Bridge component
                if (component.isBridge()) {
                    ++this.numBridges;
                }
            }
        }

        private void onStructureInvalidate() {
            this.reset();
        }

        private void reset() {
            this.clearComputationCache();
            this.components.clear();
            this.coolantProviders.clear();
            this.computationProviders.clear();
            this.numBridges = 0;
        }

        private void clearComputationCache() {
            this.allocatedCWUt = 0;
        }

        public void tick() {
            if (this.cachedCWUt != this.allocatedCWUt) {
                this.cachedCWUt = this.allocatedCWUt;
                if (this.controller != null) {
                    this.controller.writeCustomData(GregtechDataCodes.CACHED_CWU, (buf) -> {
                        buf.writeInt(this.cachedCWUt);
                    });
                }
            }

            this.cachedEUt = this.getCurrentEUt();
            if (this.allocatedCWUt != 0) {
                this.allocatedCWUt = 0;
            }

        }

        @SuppressWarnings("rawtypes")
        public double calculateTemperatureChange(IFluidHandler coolantTank,
                                                 boolean forceCoolWithActive) {
            int maxCWUt = Math.max(1, this.getMaxCWUt());
            int maxCoolingDemand = this.getMaxCoolingDemand();
            int temperatureIncrease = (int) Math.round(1.0 * (double) maxCoolingDemand * (double) this.allocatedCWUt / (double) maxCWUt);
            int maxPassiveCooling = 0;
            int maxActiveCooling = 0;
            int maxCoolantDrain = 0;

            Iterator var9 = this.coolantProviders.iterator();
            while (var9.hasNext()) {
                IQCCoolantProvider coolantProvider = (IQCCoolantProvider) var9.next();
                if (coolantProvider.isActiveCooler()) {
                    maxActiveCooling += coolantProvider.getCoolingAmount();
                    maxCoolantDrain += coolantProvider.getMaxCoolantPerTick();
                } else {
                    maxPassiveCooling += coolantProvider.getCoolingAmount();
                }
            }

            double temperatureChange = temperatureIncrease - maxPassiveCooling;

            if (maxActiveCooling == 0 && maxCoolantDrain == 0) {
                return temperatureChange;
            } else {
                if (!forceCoolWithActive && !((double) maxActiveCooling <= temperatureChange)) {
                    if (temperatureChange > 0.0) {
                        double temperatureToDecrease = Math.min(temperatureChange, maxActiveCooling);
                        int coolantToDrain = Math.max(1, (int) ((double) maxCoolantDrain * (temperatureToDecrease / (double) maxActiveCooling)));
                        FluidStack coolantStack = coolantTank.drain(this.getCoolantStack(coolantToDrain), true);
                        if (coolantStack != null) {
                            int coolantDrained = coolantStack.amount;
                            if (coolantDrained == coolantToDrain) {
                                return 0.0;
                            }
                            temperatureChange -= temperatureToDecrease * (1.0 * (double) coolantDrained / (double) coolantToDrain);
                        }
                    }
                } else {
                    FluidStack coolantStack = coolantTank.drain(this.getCoolantStack(maxCoolantDrain), true);
                    if (coolantStack != null) {
                        int coolantDrained = coolantStack.amount;
                        if (coolantDrained == maxCoolantDrain) {
                            temperatureChange -= maxActiveCooling;
                        } else {
                            temperatureChange -= (double) maxActiveCooling * (1.0 * (double) coolantDrained / (double) maxCoolantDrain);
                        }
                    }
                }
                return temperatureChange;
            }
        }

        public FluidStack getCoolantStack(int amount) {
            return new FluidStack(this.getCoolant(), amount);
        }

        private Fluid getCoolant() {
            return Materials.PCBCoolant.getFluid();
        }

        @SuppressWarnings("rawtypes")
        public void attemptDamageQC() {
            if (GTValues.RNG.nextInt(200) == 0) {
                List<IQCComponentHatch> candidates = new ArrayList<>();

                Iterator var2 = this.components.iterator();
                while (var2.hasNext()) {
                    IQCComponentHatch component = (IQCComponentHatch) var2.next();
                    if (component.canBeDamaged()) {
                        candidates.add(component);
                    }
                }

                if (!candidates.isEmpty()) {
                    candidates.get(GTValues.RNG.nextInt(candidates.size())).setDamaged(true);
                }
            }
        }

        public int allocateCWUt(int cwut, boolean simulate) {
            int maxCWUt = this.getMaxCWUt();
            int availableCWUt = maxCWUt - this.allocatedCWUt;
            int toAllocate = Math.min(cwut, availableCWUt);
            if (!simulate) {
                this.allocatedCWUt += toAllocate;
            }
            return toAllocate;
        }

        public int getAllocatedCWUt() {
            return this.allocatedCWUt;
        }

        @SuppressWarnings("rawtypes")
        public int getMaxCWUt() {
            int maxCWUt = 0;
            IQCComputationProvider computationProvider;
            for (Iterator var2 = this.computationProviders.iterator(); var2.hasNext(); maxCWUt += computationProvider.getCWUPerTick()) {
                computationProvider = (IQCComputationProvider) var2.next();
            }
            return maxCWUt;
        }

        public int getCurrentEUt() {
            int maximumCWUt = Math.max(1, this.getMaxCWUt());
            int maximumEUt = this.getMaxEUt();
            int upkeepEUt = this.getUpkeepEUt();
            return maximumEUt == upkeepEUt ? maximumEUt : upkeepEUt + (maximumEUt - upkeepEUt) * this.allocatedCWUt / maximumCWUt;
        }

        @SuppressWarnings("rawtypes")
        public int getUpkeepEUt() {
            int upkeedEUt = 0;
            IQCComponentHatch component;
            for (Iterator var2 = this.components.iterator(); var2.hasNext(); upkeedEUt += component.getUpkeepEUt()) {
                component = (IQCComponentHatch) var2.next();
            }
            return upkeedEUt;
        }

        @SuppressWarnings("rawtypes")
        public int getMaxEUt() {
            int maximumEUt = 0;
            IQCComponentHatch component;
            for (Iterator var2 = this.components.iterator(); var2.hasNext(); maximumEUt += component.getMaxEUt()) {
                component = (IQCComponentHatch) var2.next();
            }
            return maximumEUt;
        }

        public boolean hasQCBridge() {
            return this.numBridges > 0;
        }

        @SuppressWarnings("rawtypes")
        public boolean hasActiveCoolers() {
            Iterator var1 = this.coolantProviders.iterator();
            IQCCoolantProvider coolantProvider;
            do {
                if (!var1.hasNext()) {
                    return false;
                }
                coolantProvider = (IQCCoolantProvider) var1.next();
            } while (!coolantProvider.isActiveCooler());
            return true;
        }

        @SuppressWarnings("rawtypes")
        public int getMaxCoolingAmount() {
            int maxCooling = 0;
            IQCCoolantProvider coolantProvider;
            for (Iterator var2 = this.coolantProviders.iterator(); var2.hasNext(); maxCooling += coolantProvider.getCoolingAmount()) {
                coolantProvider = (IQCCoolantProvider) var2.next();
            }
            return maxCooling;
        }

        @SuppressWarnings("rawtypes")
        public int getMaxCoolingDemand() {
            int maxCooling = 0;
            IQCComputationProvider computationProvider;
            for (Iterator var2 = this.computationProviders.iterator(); var2.hasNext(); maxCooling += computationProvider.getCoolingPerTick()) {
                computationProvider = (IQCComputationProvider) var2.next();
            }
            return maxCooling;
        }

        @SuppressWarnings("rawtypes")
        public int getMaxCoolantDemand() {
            int maxCoolant = 0;
            IQCCoolantProvider coolantProvider;
            for (Iterator var2 =this.coolantProviders.iterator(); var2.hasNext(); maxCoolant += coolantProvider.getMaxCoolantPerTick()) {
                coolantProvider = (IQCCoolantProvider) var2.next();
            }
            return maxCoolant;
        }

        public void addInfo(List<ITextComponent> textList) {
            //  Max Computation
            ITextComponent data = TextComponentUtil.stringWithColor(TextFormatting.AQUA, Integer.toString(this.getMaxCWUt()));
            textList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.quantum_computer.max_computation", data));

            //  Max Cooling Demand
            TextFormatting coolingColor = this.getMaxCoolingAmount() < this.getMaxCoolingDemand() ? TextFormatting.RED : TextFormatting.GREEN;
            data = TextComponentUtil.stringWithColor(coolingColor, Integer.toString(this.getMaxCoolingDemand()));
            textList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.quantum_computer.max_cooling_demand", data));

            //  Max Cooling Available
            data = TextComponentUtil.stringWithColor(coolingColor, Integer.toString(this.getMaxCoolingAmount()));
            textList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.quantum_computer.max_cooling_available", data));

            //  Coolant Name
            if (this.getMaxCoolantDemand() > 0) {
                data = TextComponentUtil.stringWithColor(TextFormatting.YELLOW, this.getMaxCoolantDemand() + "L ");
                ITextComponent coolantName = TextComponentUtil.translationWithColor(TextFormatting.YELLOW, "gtlitecore.machine.quantum_computer.coolant_name");
                data.appendSibling(coolantName);
            } else {
                data = TextComponentUtil.stringWithColor(TextFormatting.GREEN, "0");
            }

            //  Max Cooling Required
            textList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.quantum_computer.max_coolant_required", data));

            //  Bridge Component
            if (this.numBridges > 0) {
                textList.add(TextComponentUtil.translationWithColor(TextFormatting.GREEN, "gtlitecore.machine.quantum_computer.bridging_enabled"));
            } else {
                textList.add(TextComponentUtil.translationWithColor(TextFormatting.RED, "gtlitecore.machine.quantum_computer.bridging_disabled"));
            }

        }

        public void addWarnings(List<ITextComponent> textList) {
            List<ITextComponent> warnings = new ArrayList();

            //  Multi Bridge Component warning
            if (this.numBridges > 1) {
                warnings.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.quantum_computer.warning.multiple_bridges"));
            }

            //  No Computation warning
            if (this.computationProviders.isEmpty()) {
                warnings.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.quantum_computer.warning.no_computation"));
            }

            //  Low Cooling warning
            if (this.getMaxCoolingDemand() > this.getMaxCoolingAmount()) {
                warnings.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.quantum_computer.warning.low_cooling"));
            }

            if (!warnings.isEmpty()) {
                textList.add(TextComponentUtil.translationWithColor(TextFormatting.YELLOW, "gtlitecore.machine.quantum_computer.warning.title"));
                textList.addAll(warnings);
            }
        }

        public void addErrors(List<ITextComponent> textList) {
            if (this.components.stream().anyMatch(IQCComponentHatch::isDamaged)) {
                textList.add(TextComponentUtil.translationWithColor(TextFormatting.RED, "gtlitecore.machine.quantum_computer.error.computation_damaged"));
            }
        }

        public TextureArea getComponentTexture(int index) {
            return this.components.size() <= index ? GuiTextures.BLANK_TRANSPARENT : this.components.get(index).getComponentIcon();
        }

        public void tryGatherClientComponents(World world,
                                              BlockPos pos,
                                              EnumFacing frontFacing,
                                              EnumFacing upwardsFacing,
                                              boolean flip) {
            EnumFacing relativeUp = RelativeDirection.UP.getRelativeFacing(frontFacing, upwardsFacing, flip);
            if (this.components.isEmpty()) {
                BlockPos testPos = pos.offset(frontFacing.getOpposite(), 3).offset(relativeUp, 3);
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        BlockPos tempPos = testPos.offset(frontFacing, j).offset(relativeUp.getOpposite(), i);
                        TileEntity te = world.getTileEntity(tempPos);
                        //  Component Hatch
                        if (te instanceof IQCComponentHatch) {
                            IQCComponentHatch hatch = (IQCComponentHatch) te;
                            this.components.add(hatch);
                        } else if (te instanceof IGregTechTileEntity) {
                            IGregTechTileEntity tileEntity = (IGregTechTileEntity) te;
                            MetaTileEntity mte = tileEntity.getMetaTileEntity();
                            if (mte instanceof IQCComponentHatch) {
                                IQCComponentHatch hatch = (IQCComponentHatch) mte;
                                this.components.add(hatch);
                            }
                        }
                    }
                }
            }
        }

        public void clearClientComponents() {
            this.components.clear();
        }
    }

}
