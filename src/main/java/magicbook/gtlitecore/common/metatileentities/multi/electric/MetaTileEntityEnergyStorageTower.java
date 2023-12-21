package magicbook.gtlitecore.common.metatileentities.multi.electric;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import com.google.common.annotations.VisibleForTesting;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.capability.IControllable;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.*;
import gregtech.api.pattern.*;
import gregtech.api.util.BlockInfo;
import gregtech.api.util.RelativeDirection;
import gregtech.api.util.TextComponentUtil;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.api.metatileentity.multi.IBatteryCellData;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockMultiblockCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.math.BigInteger;
import java.time.Duration;
import java.util.*;
import java.util.function.Supplier;

import static gregtech.api.GTValues.*;

public class MetaTileEntityEnergyStorageTower extends MultiblockWithDisplayBase implements IControllable, IProgressBarMultiblock {

    public static final int maxLayer = 16;
    private static final int minCasingRequired = 25;
    public static final long passiveDrainDivisor = 172800000L;
    public static final long passiveDrainMaxPerStorage = 100000L;
    private static final String energyBankNBT = "ESTEnergyBank";
    private static final String BatteryHeader = "ESTBattery_";
    private static final BigInteger LONG_MAX_VALUE = BigInteger.valueOf(Long.MAX_VALUE);
    private ESTEnergyBank energyBank;
    private EnergyContainerList inputHatches;
    private EnergyContainerList outputHatches;
    private long passiveDrain;
    private boolean isActive;
    private boolean isWorkingEnabled = true;
    private long netIOLastSec;
    private long averageIOLastSec;

    //  Predicate
    protected static final Supplier<TraceabilityPredicate> BATTERY_PREDICATE = () -> {
        return (new TraceabilityPredicate((blockWorldState) -> {
            IBlockState state = blockWorldState.getBlockState();
            if (GTLiteAPI.MAP_EST_BATTERIES.containsKey(state)) {
                IBatteryCellData battery = GTLiteAPI.MAP_EST_BATTERIES.get(state);

                if (battery.getTier() != -1 && battery.getCapacity() > 0L) {
                    String key = "ESTBattery_" + battery.getBatteryName();
                    BatteryMatchWrapper wrapper = (BatteryMatchWrapper) blockWorldState.getMatchContext().get(key);
                    if (wrapper == null) {
                        wrapper = new BatteryMatchWrapper(battery);
                    }

                    blockWorldState.getMatchContext().set(key, wrapper.increment());
                }

                return true;
            } else {
                return false;
            }
        }, () -> {
            return GTLiteAPI.MAP_EST_BATTERIES.entrySet().stream()
                    .sorted(Comparator.comparingInt((entry) -> {
                        return (entry.getValue()).getTier();
                    }))
                    .map((entry) -> {
                        return new BlockInfo(entry.getKey(), null);
                    })
                    .toArray((x$0) -> {
                        return new BlockInfo[x$0];
                    });
        }));
    };

    public MetaTileEntityEnergyStorageTower(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityEnergyStorageTower(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        List<IEnergyContainer> inputs = new ArrayList();
        inputs.addAll(this.getAbilities(MultiblockAbility.INPUT_ENERGY));
        inputs.addAll(this.getAbilities(MultiblockAbility.SUBSTATION_INPUT_ENERGY));
        inputs.addAll(this.getAbilities(MultiblockAbility.INPUT_LASER));
        this.inputHatches = new EnergyContainerList(inputs);
        List<IEnergyContainer> outputs = new ArrayList();
        outputs.addAll(this.getAbilities(MultiblockAbility.OUTPUT_ENERGY));
        outputs.addAll(this.getAbilities(MultiblockAbility.SUBSTATION_OUTPUT_ENERGY));
        outputs.addAll(this.getAbilities(MultiblockAbility.OUTPUT_LASER));
        this.outputHatches = new EnergyContainerList(outputs);
        List<IBatteryCellData> parts = new ArrayList();
        Iterator var5 = context.entrySet().iterator();

        while (true) {
            Object var8;
            do {
                Map.Entry battery;
                do {
                    if (!var5.hasNext()) {
                        if (parts.isEmpty()) {
                            this.invalidateStructure();
                            return;
                        }

                        if (this.energyBank == null) {
                            this.energyBank = new ESTEnergyBank(parts);
                        } else {
                            this.energyBank = this.energyBank.rebuild(parts);
                        }

                        this.passiveDrain = this.energyBank.getPassiveDrainPerTick();
                        return;
                    }

                    battery = (Map.Entry)var5.next();
                } while(!((String)battery.getKey()).startsWith("PSSBattery_"));

                var8 = battery.getValue();
            } while(!(var8 instanceof BatteryMatchWrapper));

            BatteryMatchWrapper wrapper = (BatteryMatchWrapper) var8;

            for(int i = 0; i < wrapper.amount; ++i) {
                parts.add(wrapper.partType);
            }
        }
    }

    @Override
    public void invalidateStructure() {
        this.inputHatches = null;
        this.outputHatches = null;
        this.passiveDrain = 0L;
        this.netIOLastSec = 0L;
        this.averageIOLastSec = 0L;
        super.invalidateStructure();
    }

    @Override
    protected void updateFormedValid() {
        if (!this.getWorld().isRemote) {
            if (this.getOffsetTimer() % 20L == 0L) {
                this.setActive(this.energyBank.hasEnergy());
                this.averageIOLastSec = this.netIOLastSec / 20L;
                this.netIOLastSec = 0L;
            }

            if (this.isWorkingEnabled()) {
                long energyBanked = this.energyBank.fill(this.inputHatches.getEnergyStored());
                this.inputHatches.changeEnergy(-energyBanked);
                this.netIOLastSec += energyBanked;
                long energyPassiveDrained = this.energyBank.drain(this.getPassiveDrain());
                this.netIOLastSec -= energyPassiveDrained;
                long energyDebanked = this.energyBank.drain(this.outputHatches.getEnergyCapacity() - this.outputHatches.getEnergyStored());
                this.outputHatches.changeEnergy(energyDebanked);
                this.netIOLastSec -= energyDebanked;
            }
        }
    }

    public long getPassiveDrain() {
        if (ConfigHolder.machines.enableMaintenance) {
            int multiplier = 1 + this.getNumMaintenanceProblems();
            double modifier = this.getMaintenanceDurationMultiplier();
            return (long)((double)(this.passiveDrain * (long) multiplier) * modifier);
        } else {
            return this.passiveDrain;
        }
    }

    public boolean isActive() {
        return super.isActive() && this.isActive;
    }

    public void setActive(boolean active) {
        if (this.isActive != active) {
            this.isActive = active;
            this.markDirty();
            World world = this.getWorld();
            if (world != null && !world.isRemote) {
                this.writeCustomData(GregtechDataCodes.WORKABLE_ACTIVE, (buf) -> {
                    buf.writeBoolean(active);
                });
            }
        }

    }

    public boolean isWorkingEnabled() {
        return this.isWorkingEnabled;
    }

    public void setWorkingEnabled(boolean isWorkingAllowed) {
        this.isWorkingEnabled = isWorkingAllowed;
        this.markDirty();
        World world = this.getWorld();
        if (world != null && !world.isRemote) {
            this.writeCustomData(GregtechDataCodes.WORKING_ENABLED, (buf) -> {
                buf.writeBoolean(this.isWorkingEnabled);
            });
        }

    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.FRONT, RelativeDirection.UP)
                .aisle("CCSCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC")
                .aisle("GGGGG", "GBBBG", "GBBBG", "GBBBG", "GGGGG")
                .setRepeatable(4, 16)
                .aisle("CCCCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(minCasingRequired)
                        .or(maintenancePredicate())
                        .or(abilities(MultiblockAbility.INPUT_ENERGY, MultiblockAbility.INPUT_LASER, MultiblockAbility.SUBSTATION_INPUT_ENERGY)
                                .setMinGlobalLimited(1))
                        .or(abilities(MultiblockAbility.OUTPUT_ENERGY, MultiblockAbility.OUTPUT_LASER, MultiblockAbility.SUBSTATION_OUTPUT_ENERGY)
                                .setMinGlobalLimited(1)))
                .where('G', states(getGlassState()))
                .where('B', BATTERY_PREDICATE.get())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.TALONITE_CASING);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.TEMPERED_GLASS);
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        List<MultiblockShapeInfo> shapeInfo = new ArrayList();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("MIJKL", "GGGGG", "GGGGG", "GGGGG", "GGGGG", "CCCCC")
                .aisle("CCCCC", "GBBBG", "GBBBG", "GBBBG", "GBBBG", "CCCCC")
                .aisle("CCCCC", "GBBBG", "GBBBG", "GBBBG", "GBBBG", "CCCCC")
                .aisle("CCCCC", "GBBBG", "GBBBG", "GBBBG", "GBBBG", "CCCCC")
                .aisle("CCSCC", "GGGGG", "GGGGG", "GGGGG", "GGGGG", "CCCCC")
                .where('S', GTLiteMetaTileEntities.ENERGY_STORAGE_TOWER, EnumFacing.SOUTH)
                .where('C', getCasingState())
                .where('G', getGlassState())
                .where('I', MetaTileEntities.ENERGY_INPUT_HATCH[HV], EnumFacing.NORTH)
                .where('J', MetaTileEntities.ENERGY_OUTPUT_HATCH[HV], EnumFacing.NORTH)
                .where('K', MetaTileEntities.SUBSTATION_ENERGY_INPUT_HATCH[HV], EnumFacing.NORTH)
                .where('L', MetaTileEntities.SUBSTATION_ENERGY_OUTPUT_HATCH[HV], EnumFacing.NORTH)
                .where('M', () -> {
                    return ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : getCasingState();
                }, EnumFacing.NORTH);
        GTLiteAPI.MAP_EST_BATTERIES.entrySet().stream()
                .filter((entry) -> {
                    return (entry.getValue()).getCapacity() > 0L;
                })
                .sorted(Comparator.comparingInt((entry) -> {
                    return (entry.getValue()).getTier();
                }))
                .forEach((entry) -> {
                    shapeInfo.add(builder.where('B', entry.getKey()).build());
                });
        return shapeInfo;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.TALONITE_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.ENERGY_STORAGE_TOWER_OVERLAY;
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState,
                                     Matrix4 translation,
                                     IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        this.getFrontOverlay().renderOrientedState(renderState, translation, pipeline, this.getFrontFacing(), this.isActive(), this.isWorkingEnabled());
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        MultiblockDisplayText.builder(textList, this.isStructureFormed()).setWorkingStatus(true, this.isActive() && this.isWorkingEnabled()).setWorkingStatusKeys("gregtech.multiblock.idling", "gregtech.multiblock.idling", "gregtech.machine.active_transformer.routing").addCustom((tl) -> {
            if (this.isStructureFormed() && this.energyBank != null) {
                BigInteger energyStored = this.energyBank.getStored();
                BigInteger energyCapacity = this.energyBank.getCapacity();
                ITextComponent storedFormatted = TextComponentUtil.stringWithColor(TextFormatting.GOLD, TextFormattingUtil.formatNumbers(energyStored) + " EU");
                tl.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.energy_storage_tower.stored", storedFormatted));
                ITextComponent capacityFormatted = TextComponentUtil.stringWithColor(TextFormatting.GOLD, TextFormattingUtil.formatNumbers(energyCapacity) + " EU");
                tl.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.energy_storage_tower.capacity", capacityFormatted));
                ITextComponent passiveDrain = TextComponentUtil.stringWithColor(TextFormatting.DARK_RED, TextFormattingUtil.formatNumbers(this.getPassiveDrain()) + " EU/t");
                tl.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.energy_storage_tower.passive_drain", passiveDrain));
                TextFormatting averageIOColor = TextFormatting.GRAY;
                if (this.isActive() && this.isWorkingEnabled() && this.averageIOLastSec == 0L) {
                    averageIOColor = TextFormatting.YELLOW;
                } else if (this.averageIOLastSec > 0L) {
                    averageIOColor = TextFormatting.GREEN;
                } else if (this.averageIOLastSec < 0L) {
                    averageIOColor = TextFormatting.RED;
                }

                ITextComponent averageIO = TextComponentUtil.stringWithColor(averageIOColor, TextFormattingUtil.formatNumbers(this.averageIOLastSec) + " EU/t");
                ITextComponent base = TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.energy_storage_tower.average_io", averageIO);
                ITextComponent hover = TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.energy_storage_tower.average_io_hover");
                tl.add(TextComponentUtil.setHover(base, hover));
                ITextComponent timeToDrain;

                if (this.averageIOLastSec > 0L) {
                    timeToDrain = getTimeToFillDrainText(energyCapacity.subtract(energyStored).divide(BigInteger.valueOf(this.averageIOLastSec * 20L)));
                    TextComponentUtil.setColor(timeToDrain, TextFormatting.GREEN);
                    tl.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.energy_storage_tower.time_to_fill", timeToDrain));
                } else if (this.averageIOLastSec < 0L) {
                    timeToDrain = getTimeToFillDrainText(energyStored.divide(BigInteger.valueOf(Math.abs(this.averageIOLastSec) * 20L)));
                    TextComponentUtil.setColor(timeToDrain, TextFormatting.RED);
                    tl.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.energy_storage_tower.time_to_drain", timeToDrain));
                }
            }

        }).addWorkingStatusLine();
    }

    @Override
    protected void addWarningText(List<ITextComponent> textList) {
        super.addWarningText(textList);
        if (this.isStructureFormed() && this.averageIOLastSec < 0L) {
            BigInteger timeToDrainSeconds = this.energyBank.getStored().divide(BigInteger.valueOf(Math.abs(this.averageIOLastSec) * 20L));
            if (timeToDrainSeconds.compareTo(BigInteger.valueOf(3600L)) < 0) {
                textList.add(TextComponentUtil.translationWithColor(TextFormatting.YELLOW, "gtlitecore.machine.energy_storage_tower.under_one_hour_left"));
            }
        }

    }

    private static ITextComponent getTimeToFillDrainText(BigInteger timeToFillSeconds) {
        if (timeToFillSeconds.compareTo(LONG_MAX_VALUE) > 0) {
            timeToFillSeconds = LONG_MAX_VALUE;
        }

        Duration duration = Duration.ofSeconds(timeToFillSeconds.longValue());
        String key;
        long fillTime;
        if (duration.getSeconds() <= 180L) {
            fillTime = duration.getSeconds();
            key = "gtlitecore.machine.energy_storage_tower.time_seconds";
        } else if (duration.toMinutes() <= 180L) {
            fillTime = duration.toMinutes();
            key = "gtlitecore.machine.energy_storage_tower.time_minutes";
        } else if (duration.toHours() <= 72L) {
            fillTime = duration.toHours();
            key = "gtlitecore.machine.energy_storage_tower.time_hours";
        } else if (duration.toDays() <= 730L) {
            fillTime = duration.toDays();
            key = "gtlitecore.machine.energy_storage_tower.time_days";
        } else {
            if (duration.toDays() / 365L >= 1000000L) {
                return new TextComponentTranslation("gtlitecore.machine.energy_storage_tower.time_years");
            }

            fillTime = duration.toDays() / 365L;
            key = "gtlitecore.machine.energy_storage_tower.time_forever";
        }

        return new TextComponentTranslation(key, TextFormattingUtil.formatNumbers(fillTime));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setBoolean("isActive", this.isActive);
        data.setBoolean("isWorkingEnabled", this.isWorkingEnabled);
        if (this.energyBank != null) {
            data.setTag("ESTEnergyBank", this.energyBank.writeToNBT(new NBTTagCompound()));
        }

        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.isActive = data.getBoolean("isActive");
        this.isWorkingEnabled = data.getBoolean("isWorkingEnabled");
        if (data.hasKey("ESTEnergyBank")) {
            this.energyBank = new ESTEnergyBank(data.getCompoundTag("ESTEnergyBank"));
        }
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
        }

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        return capability == GregtechTileCapabilities.CAPABILITY_CONTROLLABLE ? GregtechTileCapabilities.CAPABILITY_CONTROLLABLE.cast(this) : super.getCapability(capability, side);
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World world,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        tooltip.add(I18n.format("gtlitecore.machine.energy_storage_tower.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.energy_storage_tower.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.energy_storage_tower.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.energy_storage_tower.tooltip.4"));
        tooltip.add(I18n.format("gtlitecore.machine.energy_storage_tower.tooltip.5", 100000L));
        tooltip.add(I18n.format("gtlitecore.machine.energy_storage_tower.tooltip.6"));
    }

    public String getStored() {
        return this.energyBank == null ? "0" : TextFormattingUtil.formatNumbers(this.energyBank.getStored());
    }

    public long getStoredLong() {
        return this.energyBank == null ? 0L : this.energyBank.getStored().longValue() & Long.MAX_VALUE;
    }

    public long getCapacityLong() {
        return this.energyBank == null ? 0L : this.energyBank.getCapacity().longValue() & Long.MAX_VALUE;
    }

    public String getCapacity() {
        return this.energyBank == null ? "0" : TextFormattingUtil.formatNumbers(this.energyBank.getCapacity());
    }

    public long getAverageIOLastSec() {
        return this.averageIOLastSec;
    }

    public double getFillPercentage(int index) {
        return this.energyBank == null ? 0.0 : this.energyBank.getStored().doubleValue() / this.energyBank.getCapacity().doubleValue();
    }

    @Override
    public void addBarHoverText(List<ITextComponent> hoverList, int index) {
        String stored = this.energyBank != null ? TextFormattingUtil.formatNumbers(this.energyBank.getStored()) : "0";
        String capacity = this.energyBank != null ? TextFormattingUtil.formatNumbers(this.energyBank.getCapacity()) : "0";
        ITextComponent energyInfo = TextComponentUtil.stringWithColor(TextFormatting.YELLOW, stored + " / " + capacity + " EU");
        hoverList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.energy_storage_tower.energy_stored", energyInfo));
    }



    private static class BatteryMatchWrapper {
        private final IBatteryCellData partType;
        private int amount;

        public BatteryMatchWrapper(IBatteryCellData partType) {
            this.partType = partType;
        }

        public BatteryMatchWrapper increment() {
            ++ this.amount;
            return this;
        }
    }

    public static class ESTEnergyBank {

        private static final String sizeNBT = "Size";
        private static final String storedNBT = "Stored";
        private static final String maxNBT = "Max";
        private final long[] storage;
        private final long[] maximums;
        private final BigInteger capacity;
        private int index;

        public ESTEnergyBank(List<IBatteryCellData> batteries) {
            this.storage = new long[batteries.size()];
            this.maximums = new long[batteries.size()];

            for(int i = 0; i < batteries.size(); ++i) {
                this.maximums[i] = ((IBatteryData)batteries.get(i)).getCapacity();
            }

            this.capacity = summarize(this.maximums);
        }

        public ESTEnergyBank(NBTTagCompound storageTag) {
            int size = storageTag.getInteger(sizeNBT);
            this.storage = new long[size];
            this.maximums = new long[size];

            for(int i = 0; i < size; ++i) {
                NBTTagCompound subtag = storageTag.getCompoundTag(String.valueOf(i));
                if (subtag.hasKey(storedNBT)) {
                    this.storage[i] = subtag.getLong(storedNBT);
                }

                this.maximums[i] = subtag.getLong(maxNBT);
            }

            this.capacity = summarize(this.maximums);
        }

        private NBTTagCompound writeToNBT(NBTTagCompound compound) {
            compound.setInteger(sizeNBT, this.storage.length);

            for(int i = 0; i < this.storage.length; ++i) {
                NBTTagCompound subtag = new NBTTagCompound();
                if (this.storage[i] > 0L) {
                    subtag.setLong(storedNBT, this.storage[i]);
                }

                subtag.setLong(maxNBT, this.maximums[i]);
                compound.setTag(String.valueOf(i), subtag);
            }

            return compound;
        }

        public ESTEnergyBank rebuild(@Nonnull List<IBatteryCellData> batteries) {

            if (batteries.isEmpty()) {
                throw new IllegalArgumentException("Cannot rebuild Energy Storage Tower power bank with no batteries!");
            } else {
                ESTEnergyBank newStorage = new ESTEnergyBank(batteries);
                long[] var3 = this.storage;
                int var4 = var3.length;

                for (int var5 = 0; var5 < var4; ++var5) {
                    long stored = var3[var5];
                    newStorage.fill(stored);
                }

                return newStorage;
            }
        }

        public long fill(long amount) {

            if (amount < 0L) {
                throw new IllegalArgumentException("Amount cannot be negative!");
            } else {
                if (this.index != this.storage.length - 1 && this.storage[this.index] == this.maximums[this.index]) {
                    ++this.index;
                }

                long maxFill = Math.min(this.maximums[this.index] - this.storage[this.index], amount);
                if (maxFill == 0L && this.index == this.storage.length - 1) {
                    return 0L;
                } else {
                    long[] var10000 = this.storage;
                    int var10001 = this.index;
                    var10000[var10001] += maxFill;
                    amount -= maxFill;
                    return amount > 0L && this.index != this.storage.length - 1 ? maxFill + this.fill(amount) : maxFill;
                }
            }
        }

        public long drain(long amount) {
            if (amount < 0L) {
                throw new IllegalArgumentException("Amount cannot be negative!");
            } else {
                if (this.index != 0 && this.storage[this.index] == 0L) {
                    --this.index;
                }

                long maxDrain = Math.min(this.storage[this.index], amount);
                if (maxDrain == 0L && this.index == 0) {
                    return 0L;
                } else {
                    long[] var10000 = this.storage;
                    int var10001 = this.index;
                    var10000[var10001] -= maxDrain;
                    amount -= maxDrain;
                    if (amount > 0L && this.index != 0) {
                        --this.index;
                        return maxDrain + this.drain(amount);
                    } else {
                        return maxDrain;
                    }
                }
            }
        }

        public BigInteger getCapacity() {
            return this.capacity;
        }

        public BigInteger getStored() {
            return summarize(this.storage);
        }

        public boolean hasEnergy() {
            long[] var1 = this.storage;
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                long l = var1[var3];
                if (l > 0L) {
                    return true;
                }
            }

            return false;
        }

        private static BigInteger summarize(long[] values) {
            BigInteger retVal = BigInteger.ZERO;
            long currentSum = 0L;
            long[] var4 = values;
            int var5 = values.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                long value = var4[var6];
                if (currentSum != 0L && value > Long.MAX_VALUE - currentSum) {
                    retVal = retVal.add(BigInteger.valueOf(currentSum));
                    currentSum = 0L;
                }

                currentSum += value;
            }

            if (currentSum != 0L) {
                retVal = retVal.add(BigInteger.valueOf(currentSum));
            }

            return retVal;
        }

        @VisibleForTesting
        public long getPassiveDrainPerTick() {
            long[] maximumsExcl = new long[this.maximums.length];
            int index = 0;
            int numExcl = 0;
            long[] var4 = this.maximums;
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                long maximum = var4[var6];
                if (maximum / 172800000L >= 100000L) {
                    ++numExcl;
                } else {
                    maximumsExcl[index++] = maximum;
                }
            }

            maximumsExcl = Arrays.copyOf(maximumsExcl, index);
            BigInteger capacityExcl = summarize(maximumsExcl);
            return capacityExcl.divide(BigInteger.valueOf(172800000L)).add(BigInteger.valueOf(100000L * (long)numExcl)).longValue();
        }
    }
}
