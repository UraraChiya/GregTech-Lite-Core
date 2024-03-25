package magicbook.gtlitecore.client.utils;

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
 *     please see {@link magicbook.gtlitecore.client.renderer.GTLiteOverlayRenderer}.
 * </p>
 */
@SideOnly(Side.CLIENT)
public class BloomEffectUtils {

    public static @Nonnull BlockRenderLayer getRealBloomLayer() {
        return getEffectiveBloomLayer();
    }
}
