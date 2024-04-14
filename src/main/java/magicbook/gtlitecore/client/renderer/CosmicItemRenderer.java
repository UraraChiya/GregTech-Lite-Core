package magicbook.gtlitecore.client.renderer;

import codechicken.lib.model.ItemQuadBakery;
import codechicken.lib.model.bakedmodels.ModelProperties;
import codechicken.lib.model.bakedmodels.PerspectiveAwareBakedModel;
import codechicken.lib.util.ResourceUtils;
import codechicken.lib.util.TransformUtils;
import com.google.common.collect.ImmutableList;
import gregtech.api.items.metaitem.MetaItem;
import magicbook.gtlitecore.api.item.ICosmicRenderBehavior;
import magicbook.gtlitecore.api.item.IItemRenderer;
import magicbook.gtlitecore.client.shader.CosmicShaderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.model.IModelState;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.List;

/**
 * Cosmic Item Renderer.
 *
 * @author Gate Guardian
 *
 * <p>
 *     This renderer is transplanted from <a href="https://github.com/GTNewHorizons/GT5-Unofficial">GT5u</a>.
 *     Please see {@link magicbook.gtlitecore.common.items.behaviors.renderer.CosmicRenderItemBehavior}.
 * </p>
 */
public class CosmicItemRenderer extends WrappedItemRenderer {

    private static final HashMap<TextureAtlasSprite, IBakedModel> spriteQuadCache = new HashMap<>();

    static {
        ResourceUtils.registerReloadListener(resourceManager -> spriteQuadCache.clear());
    }

    public CosmicItemRenderer(IModelState state, IBakedModel wrapped) {
        super(state, wrapped);

    }

    public CosmicItemRenderer(IModelState state, IWrappedModelGetter getter) {
        super(state, getter);
    }

    /**
     * @param stack          Item stack, should check if it in gregtech's {@link MetaItem} class,
     *                       otherwise cause crash when it in AE2 Pattern,
     *                       please see: {@link appeng.items.misc.ItemEncodedPattern}.
     * @param transformType  Transform type, used to check if it in GUI.
     */
    @Override
    public void renderItem(ItemStack stack, ItemCameraTransforms.TransformType transformType) {
        if (stack.getItem() instanceof MetaItem) {
            processLightLevel(transformType);
            if (transformType == ItemCameraTransforms.TransformType.GUI) {
                renderInventory(stack, renderEntity);
            } else { //  Common renderer
                renderSimple(stack, renderEntity);
            }
        }
    }

    /**
     * Simple Renderer for common situation.
     *
     * @param stack   Item stack.
     * @param player  Player.
     */
    protected void renderSimple(ItemStack stack, EntityLivingBase player) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1F, 1F, 1F, 1F);

        World world = player != null ? player.world : null;
        IBakedModel model = wrapped.getOverrides().handleItemState(wrapped, stack, world, player);

        renderModel(model, stack);

        MetaItem<?>.MetaValueItem valueItem = ((MetaItem<?>)stack.getItem()).getItem(stack);
        ICosmicRenderBehavior cri = null;
        if (valueItem != null) {
            cri = (ICosmicRenderBehavior) ((IItemRenderer) valueItem).getRendererManager();
        }

        if (cri != null) {
            GlStateManager.disableAlpha();
            GlStateManager.depthFunc(GL11.GL_EQUAL);

            TextureAtlasSprite cosmicSprite = cri.getMaskTexture(stack, player);

            IBakedModel cosmicModel = spriteQuadCache.computeIfAbsent(cosmicSprite, CosmicItemRenderer::computeModel);

            CosmicShaderHelper.cosmicOpacity = cri.getMaskOpacity(stack, player);
            CosmicShaderHelper.useShader();

            renderModel(cosmicModel, stack);

            CosmicShaderHelper.releaseShader();

            GlStateManager.depthFunc(GL11.GL_LEQUAL);
            GlStateManager.enableAlpha();
        }
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    /**
     * Renderer for GUI Internal situation.
     *
     * @param stack   Item stack.
     * @param player  Player.
     */
    protected void renderInventory(ItemStack stack, EntityLivingBase player) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();

        World world = player != null ? player.world : null;
        IBakedModel model = wrapped.getOverrides().handleItemState(wrapped, stack, world, player);
        renderModel(model, stack);

        MetaItem<?>.MetaValueItem valueItem = ((MetaItem<?>)stack.getItem()).getItem(stack);
        ICosmicRenderBehavior cri = null;
        if (valueItem != null) {
            cri = (ICosmicRenderBehavior) ((IItemRenderer) valueItem).getRendererManager();
        }

        if (cri != null) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

            GlStateManager.disableAlpha();
            GlStateManager.disableDepth();

            TextureAtlasSprite sprite = cri.getMaskTexture(stack, player);
            IBakedModel cosmicModel = spriteQuadCache.computeIfAbsent(sprite, CosmicItemRenderer::computeModel);

            GlStateManager.color(1F, 1F, 1F, 1F);
            CosmicShaderHelper.cosmicOpacity = cri.getMaskOpacity(stack, player);
            CosmicShaderHelper.inventoryRender = true;
            CosmicShaderHelper.useShader();

            renderModel(cosmicModel, stack);

            CosmicShaderHelper.releaseShader();
            CosmicShaderHelper.inventoryRender = false;
            GlStateManager.popMatrix();
        }

        GlStateManager.enableAlpha();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableDepth();

        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    private static IBakedModel computeModel(TextureAtlasSprite sprite) {
        List<BakedQuad> quads = ItemQuadBakery.bakeItem(ImmutableList.of(sprite));
        return new PerspectiveAwareBakedModel(quads, TransformUtils.DEFAULT_ITEM, new ModelProperties(true, false));
    }

    protected void processLightLevel(ItemCameraTransforms.TransformType transformType) {
        switch (transformType) {
            case GROUND:
                if (entityPos != null) {
                    CosmicShaderHelper.setLightFromLocation(world, entityPos);
                    return;
                }
                break;
            case THIRD_PERSON_LEFT_HAND:
            case THIRD_PERSON_RIGHT_HAND:
            case FIRST_PERSON_LEFT_HAND:
            case FIRST_PERSON_RIGHT_HAND:
            case HEAD:
                if (renderEntity != null) {
                    CosmicShaderHelper.setLightFromLocation(world, entityPos);
                    return;
                }
                break;
            case GUI:
                CosmicShaderHelper.setLightLevel(1.2F);
                return;
            default:
                break;
        }
        CosmicShaderHelper.setLightLevel(1.0F);
    }
}
