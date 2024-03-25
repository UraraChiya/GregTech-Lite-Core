package magicbook.gtlitecore.api.capability.impl;

import gregtech.api.GTValues;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.IWorkable;
import gregtech.api.metatileentity.multiblock.IMaintenance;
import gregtech.common.ConfigHolder;
import magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityZhuHaiFishingPond;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Fishing Pond Recipe Logic.
 *
 * @author Gate Guardian
 *
 * <p>
 *     This class is basic logic for ZhuHai Fishing Pond.
 *     Thanks for my friend Gate Guardian create it, I just redo something.
 * </p>
 */
public class FishingPondRecipeLogic implements IWorkable {

    public static final int maxProgress = 20;
    private int progressTime = 0;
    private int MaxProgress = 0;
    private int minEnergyTier;
    private final MetaTileEntityZhuHaiFishingPond tileEntity;
    private int output;
    private String loots = "";
    private int mode = 0;
    private boolean isActive;
    private boolean isWorkingEnabled = true;
    private boolean wasActiveAndNeedsUpdate;
    private boolean isDone = false;
    protected boolean isInventoryFull;
    private boolean isEnergyNotEnough;
    private final boolean hasMaintenance;

    public FishingPondRecipeLogic(MetaTileEntityZhuHaiFishingPond tileEntity,
                                  int minEnergyTier) {
        this.tileEntity = tileEntity;
        this.minEnergyTier = minEnergyTier;
        this.hasMaintenance = ConfigHolder.machines.enableMaintenance && ((IMaintenance) tileEntity).hasMaintenanceMechanics();
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    //  check if block is air or flowing water.
    private boolean isNotStaticWater(Block block) {
        return block == Blocks.AIR || block == Blocks.FLOWING_WATER;
    }

    private boolean depleteInput(FluidStack fluid) {

        if (fluid == null) {
            return false;
        }

        IMultipleTankHandler inputTank = tileEntity.getImportFluids();

        if (fluid.isFluidStackIdentical(inputTank.drain(fluid, false))) {
            inputTank.drain(fluid, true);
            return true;
        }

        return false;
    }

    //  check if water exist in multiblock structure
    public Boolean checkWater() {

        int currentDirectionX;
        int currentDirectionZ;
        int offsetLowerX;
        int offsetUpperX;
        int offsetLowerZ;
        int offsetUpperZ;

        currentDirectionX = 4;
        currentDirectionZ = 4;
        offsetLowerX = -4;
        offsetUpperX = 4;
        offsetLowerZ = -4;
        offsetUpperZ = 4;

        final int directionX = this.tileEntity.getFrontFacing().getOpposite().getXOffset() * currentDirectionX;
        final int directionZ = this.tileEntity.getFrontFacing().getOpposite().getZOffset() * currentDirectionZ;

        int amount = 0;

        for (int i = offsetLowerX + 1; i <= offsetUpperX - 1; ++i) {
            for (int j = offsetLowerZ + 1; j <= offsetUpperZ - 1; ++j) {
                for (int k = 0; k < 2; k++) {
                    BlockPos waterCheckPos = this.tileEntity.getPos().add(directionX + i, k, directionZ + j);
                    Block block = this.tileEntity.getWorld().getBlockState(waterCheckPos).getBlock();

                    if (isNotStaticWater(block)) {
                        if (this.tileEntity.getImportFluids() != null) {
                            if (depleteInput(FluidRegistry.getFluidStack("water", 1000)))
                                this.tileEntity.getWorld().setBlockState(waterCheckPos, Blocks.WATER.getDefaultState());
                        }
                    }

                    block = this.tileEntity.getWorld().getBlockState(this.tileEntity.getPos().add(directionX + i, k, directionZ + j)).getBlock();
                    if (block == Blocks.WATER || block == Blocks.FLOWING_WATER) {
                        ++ amount;
                        //GTLiteLog.logger.info("Found Water!");
                    }
                }
            }
        }

        boolean isValidWater = amount >= 60;
        //if (isValidWater) {
        //  GTLiteLog.logger.info("Filled structure.");
        //} else {
        //  GTLiteLog.logger.info("Did not fill structure.");
        //}

        return isValidWater;
    }

    /**
     * @return Obtain loots according to mode:
     *         Mode 0 -> Fish
     *         Mode 1 -> Junk
     *         Mode 2 -> Treasure
     */
    public String getLootTable() {

        if (this.mode == 0) { //  Fish
            output = 8 + (tileEntity.getMaxParallelRecipes() - 2);
            this.loots = "gameplay/fishing/fish";
        } else if (this.mode == 1) { //  Junk
            output = 4;
            this.loots = "gameplay/fishing/junk";
        } else if (this.mode == 2) { // Treasure
            output = 4;
            this.loots = "gameplay/fishing/treasure";
        } else {
            this.mode = 0;
        }

        return loots;
    }

    public void update() {
        if (tileEntity.getWorld().isRemote) return;
        if (!checkWater()) return;
        if (hasMaintenance && ((IMaintenance) tileEntity).getNumMaintenanceProblems() > 5) return;
        if (!this.isWorkingEnabled) return;
        if (!checkCanFishing()) return;

        //  if inventory is not full, drain energy etc. from it
        if (!isInventoryFull) {
            //  actually drain the energy
            consumeEnergy(false);
            //  since energy is being consumed, it is now active
            if (!this.isActive)
                setActive(true);
        } else {
            //  it cannot drain, therefore it is inactive
            if (this.isActive)
                setActive(false);
            return;
        }

        //  increase progress
        progressTime++;
        if (progressTime % maxProgress != 0) return;
        progressTime = 0;

        World world = this.tileEntity.getWorld();
        int l = world.rand.nextInt(output);
        while (l < output) {

            LootTable loots = world.getLootTableManager().getLootTableFromLocation(new ResourceLocation(getLootTable()));
            LootContext ctxs = new LootContext.Builder((WorldServer) world).build();
            List<ItemStack> stacks = loots.generateLootForPools(world.rand, ctxs);

            for (ItemStack stack: stacks) {
                if (tileEntity.fillTanks(stack, true)) {
                    tileEntity.fillTanks(stack, false);
                } else {
                    isInventoryFull = true;
                    setActive(false);
                    setWasActiveAndNeedsUpdate(true);
                }
                l++;
            }
        }
    }

    protected boolean consumeEnergy(boolean energy) {
        return tileEntity.drainEnergy(energy);
    }

    protected boolean checkCanFishing() {

        if (!consumeEnergy(true)) {
            if (progressTime >= 2) {
                if (ConfigHolder.machines.recipeProgressLowEnergy)
                    this.progressTime = 1;
                else
                    this.progressTime = Math.max(1, progressTime - 2);

                isEnergyNotEnough = true;
            }
            return false;
        }

        if (this.isEnergyNotEnough && tileEntity.getEnergyInputPerSecond() > 19L * GTValues.VA[tileEntity.getEnergyTier()]) {
            this.isEnergyNotEnough = false;
        }

        World world = this.tileEntity.getWorld();
        LootTable loots = world.getLootTableManager().getLootTableFromLocation(new ResourceLocation(getLootTable()));
        LootContext ctxs = new LootContext.Builder((WorldServer) world).build();
        List<ItemStack> stacks = loots.generateLootForPools(world.rand, ctxs);

        for (ItemStack stack : stacks)
            if (tileEntity.fillChest(stack, true)) {
                this.isInventoryFull = false;
                return true;
            }
        this.isInventoryFull = true;

        if (isActive()) {
            setActive(false);
            setWasActiveAndNeedsUpdate(true);
        }
        return false;
    }

    @Override
    public int getProgress() {
        return progressTime;
    }

    public int getMaxProgress() {
        return MaxProgress;
    }

    public void setMaxProgress(int maxProgress) {
        MaxProgress = maxProgress;
    }

    public void invalidate() {
        this.progressTime = 0;
        this.MaxProgress = 0;
        setActive(false);
    }

    public boolean isActive() {
        return this.isActive;
    }

    /**
     * @param active new state of tile entity:
     *               true -> change to active,
     *               false -> else situation.
     */
    public void setActive(boolean active) {
        if (this.isActive != active) {
            this.isActive = active;
            this.tileEntity.markDirty();
            if (tileEntity.getWorld() != null && !tileEntity.getWorld().isRemote) {
                this.tileEntity.writeCustomData(GregtechDataCodes.WORKABLE_ACTIVE, buf -> buf.writeBoolean(active));
            }
        }
    }

    /**
     * @param isWorkingEnabled new state of tile entity ability to work:
     *                         true -> change to enabled,
     *                         false -> else situation
     */
    public void setWorkingEnabled(boolean isWorkingEnabled) {
        if (this.isWorkingEnabled != isWorkingEnabled) {
            this.isWorkingEnabled = isWorkingEnabled;
            tileEntity.markDirty();
            if (tileEntity.getWorld() != null && !tileEntity.getWorld().isRemote) {
                this.tileEntity.writeCustomData(GregtechDataCodes.WORKING_ENABLED, buf -> buf.writeBoolean(isWorkingEnabled));
            }
        }
    }

    /**
     * @return whether working is enabled for the logic
     */
    @Override
    public boolean isWorkingEnabled() {
        return isWorkingEnabled;
    }

    /**
     * @return whether it is currently working
     */
    public boolean isWorking() {
        return isActive && !isEnergyNotEnough && isWorkingEnabled;
    }

    public double getProgressPercent() {
        return getProgress() * 1.0 / maxProgress;
    }

    protected boolean isOverclocked() {
        return tileEntity.getEnergyTier() > minEnergyTier;
    }

    /**
     * @return whether the inventory is full
     */
    public boolean isInventoryFull() {
        return this.isInventoryFull;
    }

    /**
     * writes all needed values to NBT
     * This MUST be called and returned in the MetaTileEntity's
     * {@link gregtech.api.metatileentity.MetaTileEntity#writeToNBT(NBTTagCompound)} method
     */
    public NBTTagCompound writeToNBT(@Nonnull NBTTagCompound data) {
        data.setBoolean("isActive", this.isActive);
        data.setBoolean("isWorkingEnabled", this.isWorkingEnabled);
        data.setBoolean("wasActiveAndNeedsUpdate", this.wasActiveAndNeedsUpdate);
        data.setBoolean("isDone", isDone);
        data.setInteger("progressTime", progressTime);
        data.setInteger("MaxProgress", MaxProgress);
        data.setBoolean("isInventoryFull", isInventoryFull);
        data.setInteger("mode", mode);
        return data;
    }

    /**
     * reads all needed values from NBT
     * This MUST be called and returned in the MetaTileEntity's
     * {@link gregtech.api.metatileentity.MetaTileEntity#readFromNBT(NBTTagCompound)} method
     */
    public void readFromNBT(@Nonnull NBTTagCompound data) {
        this.isActive = data.getBoolean("isActive");
        this.isWorkingEnabled = data.getBoolean("isWorkingEnabled");
        this.wasActiveAndNeedsUpdate = data.getBoolean("wasActiveAndNeedsUpdate");
        this.isDone = data.getBoolean("isDone");
        this.progressTime = data.getInteger("progressTime");
        this.MaxProgress = data.getInteger("MaxProgress");
        this.isInventoryFull = data.getBoolean("isInventoryFull");
        this.mode = data.getInteger("mode");
    }

    /**
     * writes all needed values to InitialSyncData
     * This MUST be called and returned in the MetaTileEntity's
     * {@link gregtech.api.metatileentity.MetaTileEntity#writeInitialSyncData(PacketBuffer)} method
     */
    public void writeInitialSyncData(@Nonnull PacketBuffer buf) {
        buf.writeBoolean(this.isActive);
        buf.writeBoolean(this.isWorkingEnabled);
        buf.writeBoolean(this.wasActiveAndNeedsUpdate);
        buf.writeInt(this.progressTime);
        buf.writeInt(this.MaxProgress);
        buf.writeBoolean(this.isInventoryFull);
    }

    /**
     * reads all needed values from InitialSyncData
     * This MUST be called and returned in the MetaTileEntity's
     * {@link gregtech.api.metatileentity.MetaTileEntity#receiveInitialSyncData(PacketBuffer)} method
     */
    public void receiveInitialSyncData(@Nonnull PacketBuffer buf) {
        setActive(buf.readBoolean());
        setWorkingEnabled(buf.readBoolean());
        setWasActiveAndNeedsUpdate(buf.readBoolean());
        this.progressTime = buf.readInt();
        this.MaxProgress = buf.readInt();
        this.isInventoryFull = buf.readBoolean();
    }

    /**
     * reads all needed values from CustomData
     * This MUST be called and returned in the MetaTileEntity's
     * {@link gregtech.api.metatileentity.MetaTileEntity#receiveCustomData(int, PacketBuffer)} method
     */
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        if (dataId == GregtechDataCodes.WORKABLE_ACTIVE) {
            this.isActive = buf.readBoolean();
            tileEntity.scheduleRenderUpdate();
        } else if (dataId == GregtechDataCodes.WORKING_ENABLED) {
            this.isWorkingEnabled = buf.readBoolean();
            tileEntity.scheduleRenderUpdate();
        }
    }

    /**
     * @return  whether the rig was active and needs an update
     */
    public boolean wasActiveAndNeedsUpdate() {
        return this.wasActiveAndNeedsUpdate;
    }

    /**
     * @param wasActiveAndNeedsUpdate  the state to set
     */
    public void setWasActiveAndNeedsUpdate(boolean wasActiveAndNeedsUpdate) {
        this.wasActiveAndNeedsUpdate = wasActiveAndNeedsUpdate;
    }
}
