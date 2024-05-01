package magicbook.gtlitecore.common.metatileentities.multi.storage;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.capability.IControllable;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.Widget;
import gregtech.api.gui.widgets.ImageCycleButtonWidget;
import gregtech.api.gui.widgets.WidgetGroup;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.*;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.*;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import magicbook.gtlitecore.api.metatileentity.multi.IYottaTankData;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockStructureCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate.CELL_PREDICATE;
import static magicbook.gtlitecore.api.utils.BigMath.summarizedValue;

/**
 * Yotta Fluid Tank for GregTech CEu
 *
 * @author GlodBlock (original author)
 *
 * <p>
 *     Based on my friend Gate Guardian's work for GregTech CEu Modern.
 *     This machine is transplanted from GlodBlock's mod GoodGenerator.
 * </p>
 * <p>
 *     For the overall writing style, you can see
 *      {@link gregtech.common.metatileentities.multi.electric.MetaTileEntityPowerSubstation}
 *     this machine is just a rewrite of this machine.
 * </p>
 */
public class MetaTileEntityYottaFluidTank extends MultiblockWithDisplayBase implements IControllable, IProgressBarMultiblock {

    private static final String NBT_YOT_TANK = "YOTTank";
    public static final String YOT_CELL_HEADER = "YOTCell_";
    private static final String NBT_FLUID = "Fluid";
    private boolean isActive = true;
    private boolean isWorkingEnabled = true;
    public FluidStack fluid;
    private IMultipleTankHandler inputFluidInventory;
    private IMultipleTankHandler outputFluidInventory;
    public YOTFluidTank fluidTank;
    private int mode = 0;

    public MetaTileEntityYottaFluidTank(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityYottaFluidTank(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        initializeAbilities();
        List<IYottaTankData> cells = new ArrayList<>();
        for (Map.Entry<String, Object> cell : context.entrySet()) {
            if (cell.getKey().startsWith(YOT_CELL_HEADER) && cell.getValue() instanceof MetaTileEntityYottaFluidTank.YOTTankMatchWrapper wrapper) {
                for (int i = 0; i < wrapper.amount; i++) {
                    cells.add(wrapper.cellTier);
                }
            }
        }
        if (cells.isEmpty()) {
            invalidateStructure();
            return;
        }
        if (this.fluidTank == null) {
            this.fluidTank = new YOTFluidTank(cells);
        } else {
            this.fluidTank = fluidTank.rebuild(cells);
        }
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        resetTileAbilities();
    }

    private void initializeAbilities() {
        this.inputFluidInventory = new FluidTankList(true, getAbilities(MultiblockAbility.IMPORT_FLUIDS));
        this.outputFluidInventory = new FluidTankList(true, getAbilities(MultiblockAbility.EXPORT_FLUIDS));
    }

    private void resetTileAbilities() {
        this.inputFluidInventory = new FluidTankList(true);
        this.outputFluidInventory = new FluidTankList(true);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.FRONT, RelativeDirection.UP)
                .aisle("     ", " CCC ", " CCC ", " CCC ", "     ")
                .aisle("MM~MM", "MCCCM", "MCCCM", "MCCCM", "MMMMM")
                .aisle("GGGGG", "GRRRG", "GRRRG", "GRRRG", "GGGGG")
                .setRepeatable(1, 14)
                .aisle("MMMMM", "MMMMM", "MMMMM", "MMMMM", "MMMMM")
                .aisle("FFFFF", "F   F", "F   F", "F   F", "FFFFF")
                .where('~', this.selfPredicate())
                .where('C', states(getCasingState()))
                .where('M', states(getCasingState())
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH)
                                .setExactLimit(1))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS)
                                .setMaxGlobalLimited(2)
                                .setPreviewCount(1))
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS)
                                .setMaxGlobalLimited(2)
                                .setPreviewCount(1)))
                .where('G', states(getGlassState()))
                .where('F', states(getFrameState()))
                .where('R', CELL_PREDICATE.get())
                .build();
    }

    @Nonnull
    @Override
    protected Widget getFlexButton(int x, int y, int width, int height) {
        WidgetGroup group = new WidgetGroup(x, y, width, height);
        group.addWidget(new ImageCycleButtonWidget(0, 0, width, height, GTLiteGuiTextures.BUTTON_YOTTA_MODE, 2, this::getMode, this::setMode)
                .setTooltipHoverString(i -> LocalizationUtils.format("gtlitecore.machine.yotta_fluid_tank.mode." + getMode())));
        return group;
    }

    private int getMode() {
        return this.mode;
    }

    private void setMode(int mode) {
        if( this.mode == 0)
            this.mode = 1;
        else if (this.mode == 1) {
            this.mode = 0;
        }
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.STRUCTURE_CASING.getState(BlockStructureCasing.StructureCasingType.FORCE_FIELD_CONSTRAINED_CASING);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.LAMINATED_GLASS);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.Steel).getBlock(Materials.Steel);
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.yotta_fluid_tank.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.yotta_fluid_tank.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.yotta_fluid_tank.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.yotta_fluid_tank.tooltip.4"));
        tooltip.add(I18n.format("gtlitecore.machine.yotta_fluid_tank.tooltip.5"));
    }
    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        MultiblockDisplayText.builder(textList, isStructureFormed())
                .setWorkingStatus(true, isActive() && isWorkingEnabled)
                .setWorkingStatusKeys(
                        "gregtech.multiblock.idling",
                        "gregtech.multiblock.idling",
                        "gtlitecore.machine.yotta_fluid_tank.running")
                .addCustom(tl -> {
                    if (isStructureFormed() && fluidTank != null) {
                        BigInteger fluidStored = fluidTank.getStored();
                        BigInteger fluidCapacity = fluidTank.getCapacity();
                        ITextComponent storedFormatted = TextComponentUtil.stringWithColor(TextFormatting.AQUA, TextFormattingUtil.formatNumbers(fluidStored) + " L");
                        ITextComponent capacityFormatted = TextComponentUtil.stringWithColor(TextFormatting.AQUA, TextFormattingUtil.formatNumbers(fluidCapacity) + " L");

                        tl.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.yotta_fluid_tank.stored", storedFormatted));
                        tl.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.yotta_fluid_tank.capacity", capacityFormatted));
                        tl.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.yotta_fluid_tank.type", this.fluid == null ? I18n.format("gtlitecore.machine.yotta_fluid_tank.type.empty") : TextComponentUtil.stringWithColor(TextFormatting.AQUA, this.fluid.getLocalizedName())));
                        tl.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.yotta_fluid_tank.mode", this.mode == 1 ? TextComponentUtil.translationWithColor(TextFormatting.GREEN, "gtlitecore.machine.yotta_fluid_tank.mode.enable") : TextComponentUtil.translationWithColor(TextFormatting.RED,"gtlitecore.machine.yotta_fluid_tank.mode.disable")));
                    }
                })
                .addWorkingStatusLine();
    }

    @Override
    public boolean isWorkingEnabled() {
        return this.isWorkingEnabled;
    }

    @Override
    public void setWorkingEnabled(boolean workingEnabled) {
        this.isWorkingEnabled = workingEnabled;
        markDirty();
        if (this.getWorld() != null && !this.getWorld().isRemote) {
            writeCustomData(GregtechDataCodes.WORKING_ENABLED, buf -> buf.writeBoolean(isWorkingEnabled));
        }
    }

    @Override
    public boolean isActive() {
        return super.isActive() && this.isActive;
    }

    public void setActive(boolean active) {
        if (this.isActive != active) {
            this.isActive = active;
            markDirty();
            if (this.getWorld() != null && !this.getWorld().isRemote) {
                writeCustomData(GregtechDataCodes.WORKABLE_ACTIVE, buf -> buf.writeBoolean(active));
            }
        }
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeBoolean(isActive);
        buf.writeBoolean(isWorkingEnabled);
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
            scheduleRenderUpdate();
        } else if (dataId == GregtechDataCodes.WORKING_ENABLED) {
            isWorkingEnabled = buf.readBoolean();
            scheduleRenderUpdate();
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setBoolean("isActive", isActive);
        data.setBoolean("isWorkingEnabled", isWorkingEnabled);
        data.setInteger("mode", mode);
        if (fluid != null) {
            NBTTagCompound fluidNBT = new NBTTagCompound();
            fluid.writeToNBT(fluidNBT);
            data.setTag(NBT_FLUID, fluidNBT);
            if (fluidTank != null) {
                data.setTag(NBT_YOT_TANK, fluidTank.writeToNBT(new NBTTagCompound()));
            }
        }
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.isActive = data.getBoolean("isActive");
        this.isWorkingEnabled = data.getBoolean("isWorkingEnabled");
        this.mode = data.getInteger("mode");
        NBTTagCompound fluidNBT = (NBTTagCompound) data.getTag(NBT_FLUID);
        fluid = FluidStack.loadFluidStackFromNBT(fluidNBT);
        if (data.hasKey(NBT_YOT_TANK)) {
            fluidTank = new YOTFluidTank(data.getCompoundTag(NBT_YOT_TANK));
        }
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        if (capability == GregtechTileCapabilities.CAPABILITY_CONTROLLABLE) {
            return GregtechTileCapabilities.CAPABILITY_CONTROLLABLE.cast(this);
        }
        return super.getCapability(capability, side);
    }

    @Override
    protected void updateFormedValid() {
        if (!this.getWorld().isRemote ) {
            if (getOffsetTimer() % 20 == 0) {
                setActive(fluidTank.hasFluid());
            }

            if (isWorkingEnabled()) {
                if (inputFluidInventory.getTanks() > 0) {
                    for (int i = 0; i < inputFluidInventory.getTanks(); i++) {
                        if (this.fluid == null || this.fluid.isFluidEqual(inputFluidInventory.getTankAt(i).getFluid())) {
                            if (this.fluid == null)
                                this.fluid = inputFluidInventory.getTankAt(i).getFluid();
                            long amount = fluidTank.fill(inputFluidInventory.getTankAt(i).getFluidAmount());
                            inputFluidInventory.getTankAt(i).drain((int) amount,true);
                        }
                    }
                }
                if (outputFluidInventory.getTanks() > 0 && fluid != null && this.mode == 1) {
                    List<FluidStack> Outputs = new ArrayList<>();
                    for (int i = 0; i < outputFluidInventory.getTanks(); i++) {
                        long energyDebanked = fluidTank.drain(outputFluidInventory.getTankAt(i).getCapacity() - outputFluidInventory.getTankAt(i).getFluidAmount());
                        Outputs.add(new FluidStack(this.fluid.getFluid(), (int) energyDebanked));
                    }
                    GTTransferUtils.addFluidsToFluidHandler(outputFluidInventory ,false, Outputs);

                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.FORCE_FIELD_CONSTRAINED_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        if (this.isActive()) {
            return Textures.QUANTUM_TANK_OVERLAY;
        } else {
            return Textures.QUANTUM_CHEST_OVERLAY;
        }
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState,
                                     Matrix4 translation,
                                     IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), this.isActive(), this.isWorkingEnabled());
    }

    @Override
    public double getFillPercentage(int i) {
        return 0;
    }

    @Override
    public boolean showProgressBar() {
        return false;
    }

    public static class YOTTankMatchWrapper {

        private final IYottaTankData cellTier;
        private int amount;

        public YOTTankMatchWrapper(IYottaTankData cellTier) {
            this.cellTier = cellTier;
        }

        public MetaTileEntityYottaFluidTank.YOTTankMatchWrapper increment() {
            amount++;
            return this;
        }
    }

    @SuppressWarnings("all")
    public static class YOTFluidTank {

        private static final String NBT_SIZE = "Size";
        private static final String NBT_STORED = "Stored";
        private static final String NBT_MAX = "Max";
        private final long[] storage;
        private final long[] maxCapacity;
        private final BigInteger capacity;
        private int index;

        public YOTFluidTank(List<IYottaTankData> cells) {
            this.storage = new long[cells.size()];
            this.maxCapacity = new long[cells.size()];

            for (int i = 0; i < cells.size(); i++) {
                maxCapacity[i] = cells.get(i).getCapacity();
            }
            capacity = summarizedValue(maxCapacity);
        }

        public YOTFluidTank(NBTTagCompound nbtTagCompound) {
            int size = nbtTagCompound.getInteger(NBT_SIZE);
            storage = new long[size];
            maxCapacity = new long[size];

            for (int i = 0; i < size; i++) {
                NBTTagCompound NbtTagCompound = nbtTagCompound.getCompoundTag(String.valueOf(i));

                if (NbtTagCompound.hasKey(NBT_STORED)) {
                    storage[i] = NbtTagCompound.getLong(NBT_STORED);
                }

                maxCapacity[i] = NbtTagCompound.getLong(NBT_MAX);
            }

            capacity = summarizedValue(maxCapacity);
        }

        private NBTTagCompound writeToNBT(NBTTagCompound compound) {
            compound.setInteger(NBT_SIZE, storage.length);
            for (int i = 0; i < storage.length; i++) {
                NBTTagCompound nbtTagCompound = new NBTTagCompound();
                if (storage[i] > 0) {
                    nbtTagCompound.setLong(NBT_STORED, storage[i]);
                }
                nbtTagCompound.setLong(NBT_MAX, maxCapacity[i]);
                compound.setTag(String.valueOf(i), nbtTagCompound);
            }
            return compound;
        }

        public YOTFluidTank rebuild(@Nonnull List<IYottaTankData> cells) {
            if (cells.isEmpty()) {
                throw new IllegalArgumentException("Cannot rebuild Yotta Fluid Tank with no cells!");
            }
            YOTFluidTank Storage = new YOTFluidTank(cells);
            for (long stored : storage) {
                Storage.fill(stored);
            }
            return Storage;
        }

        public long fill(long amount) {
            if (amount < 0)
                throw new IllegalArgumentException("Amount cannot be negative!");

            if (index != storage.length - 1 && storage[index] == maxCapacity[index]) {
                index++;
            }

            long maxFill = Math.min(maxCapacity[index] - storage[index], amount);

            if (maxFill == 0 && index == storage.length - 1) {
                return 0;
            }

            storage[index] += maxFill;
            amount -= maxFill;

            if (amount > 0 && index != storage.length - 1) {
                return maxFill + fill(amount);
            }

            return maxFill;
        }

        public long drain(long amount) {
            if (amount < 0)
                throw new IllegalArgumentException("Amount cannot be negative!");

            if (index != 0 && storage[index] == 0) {
                index--;
            }

            long maxDrain = Math.min(storage[index], amount);

            if (maxDrain == 0 && index == 0) {
                return 0;
            }

            storage[index] -= maxDrain;
            amount -= maxDrain;

            if (amount > 0 && index != 0) {
                index--;
                return maxDrain + drain(amount);
            }

            return maxDrain;
        }

        public BigInteger getCapacity() {
            return capacity;
        }

        public BigInteger getStored() {
            return summarizedValue(storage);
        }

        public boolean hasFluid() {
            for (long l : storage) {
                if (l > 0) return true;
            }
            return false;
        }

    }
}
