package magicbook.gtlitecore.client.renderer.texture.custom;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.texture.TextureUtils;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Matrix4;
import gregtech.client.renderer.texture.Textures;
import magicbook.gtlitecore.api.GTLiteValues;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Industrial Centrifuge Controller Renderer.
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     Used for {@link magicbook.gtlitecore.common.metatileentities.multi.electric.adv.MetaTileEntityIndustrialCentrifuge}.
 * </p>
 */
public class IndustrialCentrifugeRenderer implements TextureUtils.IIconRegister {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite baseBackgroundSprite;

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite activeBladeSprite;

    public IndustrialCentrifugeRenderer() {
        Textures.iconRegisters.add(this);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(TextureMap textureMap) {
        this.baseBackgroundSprite = textureMap.registerSprite(new ResourceLocation(GTLiteValues.MODID, "blocks/multiblocks/industrial_centrifuge/base_background"));
        this.activeBladeSprite = textureMap.registerSprite(new ResourceLocation(GTLiteValues.MODID, "blocks/multiblocks/industrial_centrifuge/rotor_spinning"));
    }

    @SideOnly(Side.CLIENT)
    public void renderSided(CCRenderState renderState,
                            Matrix4 translation,
                            IVertexOperation[] pipeline,
                            EnumFacing side,
                            boolean hasBase,
                            boolean isActive) {
        Matrix4 cornerOffset = null;
        switch (side.getAxis()) {
            case X:
                cornerOffset = translation.copy().translate(0.01 * side.getXOffset(), -1.0, -1.0);
                cornerOffset.scale(1.0, 3.0, 3.0);
                break;
            case Z:
                cornerOffset = translation.copy().translate(-1.0, -1.0, 0.01 * side.getZOffset());
                cornerOffset.scale(3.0, 3.0, 1.0);
                break;
            case Y:
                cornerOffset = translation.copy().translate(-1.0, 0.01 * side.getYOffset(), -1.0);
                cornerOffset.scale(3.0, 1.0, 3.0);
                break;
        }
        if (hasBase && !isActive) {
            Textures.renderFace(renderState, cornerOffset, /*ArrayUtils.addAll(pipeline, new LightMapOperation(240, 240))*/pipeline, side, Cuboid6.full, baseBackgroundSprite, BlockRenderLayer.CUTOUT_MIPPED);
        }
        if (isActive) {
            Textures.renderFace(renderState, cornerOffset, pipeline, side, Cuboid6.full, activeBladeSprite, BlockRenderLayer.CUTOUT_MIPPED);
        }
    }
}
