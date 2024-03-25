package magicbook.gtlitecore.common.items.behaviors.renderer;

import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.util.TransformUtils;
import magicbook.gtlitecore.api.item.IHaloRenderBehavior;
import magicbook.gtlitecore.client.renderer.HaloItemRenderer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.function.Supplier;

/**
 * Halo Render Item Behavior.
 *
 * @author Gate Guardian
 *
 * <p>
 *     This renderer is transplanted from <a href="https://github.com/GTNewHorizons/GT5-Unofficial">GT5u</a>.
 *     Use {@link HaloItemRenderer} to add a extra renderer to items (should mixin gregtech's item renderer, please see e.g. {@link magicbook.gtlitecore.mixin.gregtech.MixinMetaItem}).
 *     Thanks for tong-ge to fix problem of getHaloTexture() cause server side crash (problem of {@link TextureAtlasSprite}).
 * </p>
 */
@SuppressWarnings("rawtypes")
public class HaloRenderItemBehavior implements IHaloRenderBehavior {

    private final int haloSize;
    private final int haloColour;
    private final Supplier supplier;
    private final boolean drawPulse;

    public HaloRenderItemBehavior(int haloSize,
                                  int haloColour,
                                  Supplier supplier,
                                  boolean drawPulse) {
        this.haloSize = haloSize;
        this.haloColour = haloColour;
        this.supplier = supplier;
        this.drawPulse = drawPulse;
    }

    @Override
    public boolean shouldDrawHalo() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public TextureAtlasSprite getHaloTexture() {
        return (TextureAtlasSprite) supplier.get();
    }

    @Override
    public int getHaloColour() {
        return haloColour;
    }

    @Override
    public int getHaloSize() {
        return haloSize;
    }

    @Override
    public boolean shouldDrawPulse() {
        return drawPulse;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onRendererRegistry(ResourceLocation location) {
        ModelRegistryHelper.register(new ModelResourceLocation(location, "inventory"), new HaloItemRenderer(TransformUtils.DEFAULT_ITEM, modelRegistry -> modelRegistry.getObject(new ModelResourceLocation(location, "inventory"))));
    }
}
