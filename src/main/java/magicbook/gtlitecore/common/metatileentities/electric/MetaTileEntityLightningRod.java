package magicbook.gtlitecore.common.metatileentities.electric;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.ColourMultiplier;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.impl.EnergyContainerHandler;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.TieredMetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.util.GTUtility;
import gregtech.api.util.XSTR;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.SimpleSidedCubeRenderer;
import gregtech.client.utils.PipelineUtil;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Lightning Rod for GregTech CEu
 *
 * @author Oganesson897
 *
 * <p>
 *     This machine is based on my friend Oganesson897's work about the same name machine.
 * </p>
 */
public class MetaTileEntityLightningRod extends TieredMetaTileEntity {

    private boolean isActive = false;

    public MetaTileEntityLightningRod(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, tier);
        this.reinitializeEnergyContainer();
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLightningRod(metaTileEntityId, this.getTier());
    }

    @Override
    protected void reinitializeEnergyContainer() {
        if (isEnergyEmitter()) {
            this.energyContainer = EnergyContainerHandler.emitterContainer(this, getEnergyCapacity(), GTValues.V[this.getTier()], getMaxInputOutputAmperage());
        }
    }

    @Override
    public void update() {
        super.update();
        if (this.getWorld().isRemote)
            return;

        XSTR xstr = new XSTR();
        if (this.getWorld().isRemote) {
            if (this.energyContainer.getEnergyStored() > 0) {
                this.setActive(true);
                this.energyContainer.removeEnergy(this.energyContainer.getEnergyStored() / 100 + 1);
            } else {
                this.setActive(false);
            }

            if (getOffsetTimer() % 256 == 0 && this.getWorld().isThundering() || (this.getWorld().isRaining() && xstr.nextInt(10) == 0)) {
                int length = 0;
                boolean valid = true;
                int posX = this.getPos().getX();
                int posY = this.getPos().getY();
                int posZ = this.getPos().getZ();

                for (int i = posY + 1; i < this.getWorld().getHeight() - 1; i++) {
                    if (valid && this.getWorld().getBlockState(new BlockPos(posX, i, posZ)).getBlock().equals(Blocks.IRON_BARS)) {
                        length++;
                    } else {
                        valid = false;
                        if (this.getWorld().getBlockState(new BlockPos(posX, i, posZ)).getBlock() != Blocks.AIR) {
                            length = 0;
                            break;
                        }
                    }
                }

                if (!this.getWorld().isThundering() && ((posY + length) < 128))
                    length = 0;

                if (xstr.nextInt(4 * this.getWorld().getHeight()) < (length * (posY + length))) {
                    this.energyContainer.addEnergy(energyContainer.getEnergyCapacity()- energyContainer.getEnergyStored());
                    this.getWorld().addWeatherEffect(new EntityLightningBolt(this.getWorld(), posX, posY + length, posZ, false));
                }
            }
        }
    }

    private void setActive(boolean isActive) {
        if (this.isActive != isActive) {
            this.isActive = isActive;
            if (!this.getWorld().isRaining()) {
                writeCustomData(GregtechDataCodes.IS_WORKING, buf -> buf.writeBoolean(isActive));
            }
        }
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    @Override
    public void receiveCustomData(int dataId, @Nonnull PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == GregtechDataCodes.IS_WORKING)
            this.isActive = buf.readBoolean();
    }

    @Override
    public void writeInitialSyncData(@Nonnull PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeBoolean(isActive);
    }

    @Override
    public void receiveInitialSyncData(@Nonnull PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.isActive = buf.readBoolean();
    }

    @Override
    protected boolean isEnergyEmitter() {
        return true;
    }

    @Override
    public boolean getIsWeatherOrTerrainResistant() {
        return true;
    }

    @Override
    protected boolean openGUIOnRightClick() {
        return false;
    }

    public long getEnergyCapacity() {
        return 50000000;
    }

    protected long getMaxInputOutputAmperage() {
        return 512;
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderMetaTileEntity(CCRenderState renderState,
                                     Matrix4 translation,
                                     IVertexOperation[] pipeline) {
        IVertexOperation[] colouredPipeline = ArrayUtils.add(pipeline, new ColourMultiplier(GTUtility.convertRGBtoOpaqueRGBA_CL(getPaintingColorForRendering())));
        getBaseRenderer().render(renderState, translation, colouredPipeline);
        GTLiteTextures.LIGHTNING_ROD_OVERLAY.renderOrientedState(renderState, translation, pipeline, getFrontFacing(), isActive, isActive);
        for (EnumFacing facing : EnumFacing.HORIZONTALS)
            Textures.ENERGY_OUT_MULTI.renderSided(facing, renderState, translation, PipelineUtil.color(pipeline, GTValues.VC[getTier()]));
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected SimpleSidedCubeRenderer getBaseRenderer() {
        return Textures.VOLTAGE_CASINGS[getTier()];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Pair<TextureAtlasSprite, Integer> getParticleTexture() {
        return Pair.of(getBaseRenderer().getParticleSprite(), getPaintingColorForRendering());
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        String key = this.metaTileEntityId.getPath().split("\\.")[0];
        String mainKey = String.format("gregtech.machine.%s.tooltip", key);
        if (I18n.hasKey(mainKey)) {
            tooltip.add(1, I18n.format(mainKey));
        }
        tooltip.add(I18n.format("gregtech.universal.tooltip.voltage_out", energyContainer.getOutputVoltage(), GTValues.VNF[getTier()]));
        tooltip.add(I18n.format("gregtech.universal.tooltip.energy_storage_capacity", energyContainer.getEnergyCapacity()));
        tooltip.add(I18n.format("gtlitecore.machine.lightning_rod.usage"));
    }
}
