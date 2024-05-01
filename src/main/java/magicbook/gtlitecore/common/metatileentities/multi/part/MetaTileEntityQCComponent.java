package magicbook.gtlitecore.common.metatileentities.multi.part;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.RelativeDirection;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiblockPart;
import magicbook.gtlitecore.api.capability.IQCComponentHatch;
import magicbook.gtlitecore.api.capability.IQCComputationProvider;
import magicbook.gtlitecore.api.capability.IQCCoolantProvider;
import magicbook.gtlitecore.api.metatileentity.multi.GTLiteMultiblockAbility;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockQuantumComputerCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityQuantumComputer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public abstract class MetaTileEntityQCComponent extends MetaTileEntityMultiblockPart implements IMultiblockAbilityPart<IQCComponentHatch>, IQCComponentHatch {

    /**
     * Used to predicate component if damaged.
     */
    private boolean damaged;

    /**
     * Used to prdicate component if advanced.
     *
     * @return  If component is advanced, then return true.
     *          Used to provide two versions of one part.
     */
    public abstract boolean isAdvanced();

    public MetaTileEntityQCComponent(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTValues.UHV);
    }

    public boolean doesAllowBridging() {
        return false;
    }

    public abstract SimpleOverlayRenderer getFrontOverlay();

    public SimpleOverlayRenderer getFrontActiveOverlay() {
        return this.getFrontOverlay();
    }

    @Override
    protected boolean openGUIOnRightClick() {
        return false;
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }

    public MultiblockAbility<IQCComponentHatch> getAbility() {
        return GTLiteMultiblockAbility.QC_COMPONENT;
    }

    public void registerAbilities(List<IQCComponentHatch> ability) {
        ability.add(this);
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState,
                                     Matrix4 translation,
                                     IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        if (this.shouldRenderOverlay()) {
            MultiblockControllerBase controller = this.getController();
            SimpleOverlayRenderer renderer;
            if (controller != null && controller.isActive()) {
                renderer = this.getFrontActiveOverlay();
            } else {
                renderer = this.getFrontOverlay();
            }

            if (renderer != null) {
                EnumFacing facing = this.getFrontFacing();
                if (controller instanceof MetaTileEntityQuantumComputer) {
                    facing = RelativeDirection.RIGHT.getRelativeFacing(controller.getFrontFacing(), controller.getUpwardsFacing(), controller.isFlipped());
                }
                renderer.renderSided(facing, renderState, translation, pipeline);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture() {
        return this.isAdvanced() ? GTLiteTextures.ADVANCED_COMPUTER_CASING : GTLiteTextures.COMPUTER_CASING;
    }

    @Override
    public int getDefaultPaintingColor() {
        return 16777215;
    }

    @Override
    public boolean canPartShare() {
        return false;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World world,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        if (this.isBridge()) {
            tooltip.add(I18n.format("gtlitecore.machine.qc_bridge_component.desc"));
        }

        int upkeepEUt = this.getUpkeepEUt();
        int maxEUt = this.getMaxEUt();

        if (upkeepEUt != 0 && upkeepEUt != maxEUt) {
            tooltip.add(I18n.format("gregtech.machine.hpca.component_general.upkeep_eut", upkeepEUt));
        }

        if (maxEUt != 0) {
            tooltip.add(I18n.format("gregtech.machine.hpca.component_general.max_eut", maxEUt));
        }

        if (this instanceof IQCCoolantProvider) {
            IQCCoolantProvider provider = (IQCCoolantProvider) this;
            if (provider.isActiveCooler()) {
                tooltip.add(I18n.format("gregtech.machine.hpca.component_type.cooler_active"));
                tooltip.add(I18n.format("gregtech.machine.hpca.component_type.cooler_active_coolant", provider.getMaxCoolantPerTick(), I18n.format(Materials.PCBCoolant.getUnlocalizedName())));
            } else {
                tooltip.add(I18n.format("gregtech.machine.hpca.component_type.cooler_passive"));
            }
            tooltip.add(I18n.format("gregtech.machine.hpca.component_type.cooler_cooling", provider.getCoolingAmount()));
        }

        if (this instanceof IQCComputationProvider) {
            IQCComputationProvider provider = (IQCComputationProvider) this;
            tooltip.add(I18n.format("gregtech.machine.hpca.component_type.computation_cwut", provider.getCWUPerTick()));
            tooltip.add(I18n.format("gregtech.machine.hpca.component_type.computation_cooling", provider.getCoolingPerTick()));
        }

        if (this.canBeDamaged()) {
            tooltip.add(TooltipHelper.BLINKING_ORANGE + I18n.format("gtlitecore.machine.quantum_computer.error.damaged"));
        }

    }

    @Override
    public boolean showToolUsages() {
        return false;
    }

    @Override
    public final boolean isBridge() {
        return this.doesAllowBridging() && (!this.canBeDamaged() || !this.isDamaged());
    }

    @Override
    public boolean isDamaged() {
        return this.canBeDamaged() && this.damaged;
    }

    @Override
    public void setDamaged(boolean damaged) {
        if (this.canBeDamaged()) {
            if (this.damaged != damaged) {
                this.damaged = damaged;
                this.markDirty();
                if (this.getWorld() != null && !this.getWorld().isRemote) {
                    this.writeCustomData(GregtechDataCodes.DAMAGE_STATE, (buf) -> {
                        buf.writeBoolean(damaged);
                    });
                }
            }

        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        if (this.canBeDamaged()) {
            data.setBoolean("Damaged", this.damaged);
        }
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        if (this.canBeDamaged()) {
            this.damaged = data.getBoolean("Damaged");
        }
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        if (this.canBeDamaged()) {
            buf.writeBoolean(this.damaged);
        }
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        if (this.canBeDamaged()) {
            this.damaged = buf.readBoolean();
        }
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (this.canBeDamaged() && dataId == GregtechDataCodes.DAMAGE_STATE) {
            this.damaged = buf.readBoolean();
            this.scheduleRenderUpdate();
        }
    }

    @Override
    public boolean shouldDropWhenDestroyed() {
        return super.shouldDropWhenDestroyed() && (!this.canBeDamaged() || !this.isDamaged());
    }

    @Override
    public void getDrops(NonNullList<ItemStack> dropsList,
                         @Nullable EntityPlayer harvester) {
        if (this.canBeDamaged() && this.isDamaged()) {
            if (this.isAdvanced()) {
                dropsList.add(GTLiteMetaBlocks.QUANTUM_COMPUTER_CASING.getItemVariant(BlockQuantumComputerCasing.QCCasingType.ADVANCED_COMPUTER_CASING));
            } else {
                dropsList.add(GTLiteMetaBlocks.QUANTUM_COMPUTER_CASING.getItemVariant(BlockQuantumComputerCasing.QCCasingType.COMPUTER_CASING));
            }
        }
    }

    @Override
    public String getMetaName() {
        return this.canBeDamaged() && this.isDamaged() ? super.getMetaName() + ".damaged" : super.getMetaName();
    }
}
