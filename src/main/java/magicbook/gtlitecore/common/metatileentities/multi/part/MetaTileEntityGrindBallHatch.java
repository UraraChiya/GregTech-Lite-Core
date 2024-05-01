package magicbook.gtlitecore.common.metatileentities.multi.part;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.LabelWidget;
import gregtech.api.gui.widgets.SlotWidget;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiblockPart;
import magicbook.gtlitecore.api.capability.IGrindBallHatch;
import magicbook.gtlitecore.api.metatileentity.multi.GTLiteMultiblockAbility;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import magicbook.gtlitecore.common.items.behaviors.GrindBallBehavior;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.util.List;

public class MetaTileEntityGrindBallHatch extends MetaTileEntityMultiblockPart implements IMultiblockAbilityPart<IGrindBallHatch>, IGrindBallHatch {

    private final ItemGrindBallHolder itemHolder;
    private boolean needUpdate;

    public MetaTileEntityGrindBallHatch(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, 4);
        this.itemHolder = new ItemGrindBallHolder();
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityGrindBallHatch(this.metaTileEntityId);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderMetaTileEntity(CCRenderState renderState,
                                     Matrix4 translation,
                                     IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        if (this.shouldRenderOverlay()){
            GTLiteTextures.MULTIPART_GRIND_BALL_HATCH.renderSided(getFrontFacing(), renderState, translation, pipeline);
        }
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 209)
                .bindPlayerInventory(entityPlayer.inventory, 126)
                .widget(new SlotWidget(this.itemHolder,0, 88 - 9,50,true,true,true)
                        .setBackgroundTexture(GuiTextures.SLOT)
                        .setChangeListener(this::markDirty))
                .widget(new LabelWidget(88,20,"gtlitecore.machine.isa_mill.grindball_hatch.only")
                        .setXCentered(true));

        return builder.build(this.getHolder(),entityPlayer);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World world,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.isa_mill.grindball_hatch.only"));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addToolUsages(ItemStack stack,
                              @Nullable World world,
                              List<String> tooltip,
                              boolean advanced) {
        tooltip.add(I18n.format("gregtech.tool_action.screwdriver.access_covers"));
        tooltip.add(I18n.format("gregtech.tool_action.wrench.set_facing"));
        super.addToolUsages(stack, world, tooltip, advanced);
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeBoolean(this.needUpdate);
        buf.writeCompoundTag(itemHolder.serializeNBT());
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.needUpdate = buf.readBoolean();
        try {
            itemHolder.deserializeNBT(buf.readCompoundTag());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setBoolean("needUpdate", this.needUpdate);
        data.setTag("item", this.itemHolder.serializeNBT());
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        if (data.hasKey("needUpdate")) {
            this.needUpdate = data.getBoolean("needUpdate");
        }

        if (data.hasKey("item")) {
            itemHolder.deserializeNBT(data.getCompoundTag("item"));
        }
    }

    @Override
    public void clearMachineInventory(NonNullList<ItemStack> itemBuffer) {
        clearInventory(itemBuffer, this.itemHolder);
    }

    @Override
    protected boolean shouldSerializeInventories() {
        return false;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ?
                CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(itemHolder) : super.getCapability(capability, side);
    }

    @Override
    public boolean hasBall() {
        return itemHolder.hasBall();
    }

    @Override
    public int getGrinderTier() {
        return itemHolder.getBallTier();
    }

    @Override
    public void damageGrinder(int amount) {
        itemHolder.damageBall(amount);
    }

    @Override
    public MultiblockAbility<IGrindBallHatch> getAbility() {
        return GTLiteMultiblockAbility.GRINDBALL_MULTIBLOCK_ABILITY;
    }

    @Override
    public void registerAbilities(List<IGrindBallHatch> list) {list.add(this);}

    private class ItemGrindBallHolder extends ItemStackHandler {

        @Nullable
        private GrindBallBehavior getBallBehavior() {
            ItemStack stack = getStackInSlot(0);
            if (stack.isEmpty()) return null;

            return GrindBallBehavior.getInstanceFor(stack);
        }

        @Override
        public int getSlotLimit(int slot) {
            return 1;
        }

        private boolean hasBall() {
            return getBallBehavior() != null;
        }

        private void damageBall(int damageAmount) {
            if (!hasBall())
                return;
            //noinspection ConstantConditions
            getBallBehavior().applyGrindBallDamage(getStackInSlot(0), damageAmount);
        }

        @Nullable
        private ItemStack getBallStack() {
            if (!hasBall())
                return null;
            return getStackInSlot(0);
        }

        private int getBallTier(){
            if(getBallStack() == null)
                return 0;
            else
                return GTLiteMetaItems.GRINDBALL_SOAPSTONE.isItemEqual(getBallStack()) ? 1 : 2;
        }

        @Override
        public boolean isItemValid(int slot,
                                   @Nonnull ItemStack stack) {
            return GrindBallBehavior.getInstanceFor(stack) != null && super.isItemValid(slot, stack);
        }

        @Override
        protected void onLoad() {
            onContentsChanged(0);
        }

        @Override
        protected void onContentsChanged(int slot) {
            needUpdate = true;
        }

    }
}