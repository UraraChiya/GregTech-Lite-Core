package magicbook.gtlitecore.client.utils;

import magicbook.gtlitecore.client.renderer.texture.cube.GTLiteOverlayRenderer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

import static gregtech.client.utils.BloomEffectUtil.getEffectiveBloomLayer;

/**
 * Bloom Effect Utility.
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     Some Bloom utils for overlay renderer,
 *     please see {@link GTLiteOverlayRenderer}.
 * </p>
 */
@SideOnly(Side.CLIENT)
public class BloomEffectUtils {

    public static @Nonnull BlockRenderLayer getRealBloomLayer() {
        return getEffectiveBloomLayer();
    }
}
