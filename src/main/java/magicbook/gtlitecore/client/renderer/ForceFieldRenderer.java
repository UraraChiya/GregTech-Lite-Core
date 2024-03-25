package magicbook.gtlitecore.client.renderer;

import gregtech.client.shader.postprocessing.BloomEffect;
import gregtech.client.utils.BloomEffectUtil;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Force Field Renderer for Quantum Force Transformer.
 *
 * @author Gate Guardian, Magic_Sweepy, tong-ge
 *
 * <p>Used for {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityQuantumForceTransformer}.</p>
 */
@SuppressWarnings("all")
@SideOnly(Side.CLIENT)
public enum ForceFieldRenderer implements BloomEffectUtil.IBloomRenderFast {

    INSTANCE;

    @Override
    public int customBloomStyle() {
        return 2;
    }

    float lastBrightnessX;
    float lastBrightnessY;

    @Override
    @SideOnly(Side.CLIENT)
    public void preDraw(BufferBuilder buffer) {
        BloomEffect.strength = 1.5F;
        BloomEffect.baseBrightness = 0.0F;
        BloomEffect.highBrightnessThreshold = 1.3F;
        BloomEffect.lowBrightnessThreshold = 0.3F;
        BloomEffect.step = 1;

        lastBrightnessX = OpenGlHelper.lastBrightnessX;
        lastBrightnessY = OpenGlHelper.lastBrightnessY;
        GlStateManager.color(1, 1, 1, 1);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void postDraw(BufferBuilder buffer) {
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lastBrightnessX, lastBrightnessY);
    }
}
