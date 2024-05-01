package magicbook.gtlitecore.common.items.behaviors.renderer;

import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.util.TransformUtils;
import magicbook.gtlitecore.api.item.ICosmicRenderBehavior;
import magicbook.gtlitecore.client.renderer.handler.CosmicItemRenderer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.function.Supplier;

/**
 * Cosmic Render Item Behavior.
 *
 * @author Gate Guardian
 *
 * <p>
 *     This renderer is transplanted from <a href="https://github.com/GTNewHorizons/GT5-Unofficial">GT5u</a>.
 *     Use {@link CosmicItemRenderer} to add a extra renderer to items (should mixin gregtech's item renderer, please see e.g. {@link magicbook.gtlitecore.mixin.gregtech.MixinMetaItem}).
 *     Thanks for tong-ge to fix problem of getMaskTexture() cause server side crash (problem of {@link TextureAtlasSprite}).
 * </p>
 */
@SuppressWarnings("rawtypes")
public class CosmicRenderItemBehavior implements ICosmicRenderBehavior {

    private final Supplier supplier;
    private final int maskOpacity;

    public CosmicRenderItemBehavior(Supplier<TextureAtlasSprite> supplier,
                                    int maskOpacity) {
        this.supplier = supplier;
        this.maskOpacity = maskOpacity;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public TextureAtlasSprite getMaskTexture(ItemStack stack,
                                             @Nullable EntityLivingBase player) {
        return (TextureAtlasSprite) supplier.get();
    }

    @Override
    public float getMaskOpacity(ItemStack stack,
                                @Nullable EntityLivingBase player) {
        return maskOpacity;
    }

    @Override
    public void onRendererRegistry(ResourceLocation location) {
        ModelRegistryHelper.register(new ModelResourceLocation(location, "inventory"), new CosmicItemRenderer(TransformUtils.DEFAULT_ITEM, modelRegistry -> modelRegistry.getObject(new ModelResourceLocation(location, "inventory"))));
    }
}