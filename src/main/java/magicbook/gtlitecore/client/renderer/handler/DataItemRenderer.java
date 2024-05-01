package magicbook.gtlitecore.client.renderer.handler;

import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.render.item.IItemRenderer;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.machines.IResearchRecipeMap;
import gregtech.api.util.AssemblyLineManager;
import magicbook.gtlitecore.common.items.behaviors.renderer.DataRenderItemBehavior;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.model.IModelState;
import org.lwjgl.input.Keyboard;

import java.util.Collection;

/**
 * Data Item Renderer
 *
 * @author Gate Guardian
 *
 * <p>
 *     Renderer of data item extra behavior.
 * </p>
 */
public class DataItemRenderer implements IItemRenderer {

    protected IBakedModel wrapped;
    private final IModelState state;

    public DataItemRenderer(IModelState state,
                            WrappedItemRenderer.IWrappedModelGetter getter) {
        this.state = state;
        ModelRegistryHelper.registerPreBakeCallback(modelRegistry -> wrapped = getter.getWrappedModel(modelRegistry));
    }

    /**
     * @param stack          Item stack, should check if it in gregtech's {@link MetaItem} class,
     *                       otherwise cause crash when it in AE2 Pattern,
     *                       please see: {@link appeng.items.misc.ItemEncodedPattern}.
     * @param transformType  Transform type, used to check if it in GUI.
     */
    @Override
    public void renderItem(ItemStack stack,
                           ItemCameraTransforms.TransformType transformType) {
        if (stack.getItem() instanceof MetaItem) {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            GlStateManager.translate(0.5F, 0.5F, 0.5F);
            boolean needSpecialRender = false;

            do {
                if (transformType != ItemCameraTransforms.TransformType.GUI)
                    break;
                MetaItem<?>.MetaValueItem valueItem = ((MetaItem<?>) stack.getItem()).getItem(stack);
                DataRenderItemBehavior dri = null;

                if (valueItem != null) {
                    dri = (DataRenderItemBehavior) ((magicbook.gtlitecore.api.item.IItemRenderer) valueItem).getRendererManager();
                }

                if (dri == null || !Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
                    break;

                //  Get Research ID in assembly line by item stack.
                String researchId = AssemblyLineManager.readResearchId(stack);
                if (researchId == null)
                    break;

                Collection<Recipe> recipes = ((IResearchRecipeMap) RecipeMaps.ASSEMBLY_LINE_RECIPES).getDataStickEntry(researchId);
                if (recipes == null || recipes.isEmpty())
                    break;

                for (Recipe recipe : recipes) {
                    renderItem.renderItem(recipe.getOutputs().get(0), transformType);
                }

                needSpecialRender = true;

            } while (!needSpecialRender);

            if (!needSpecialRender) {
                renderItem.renderItem(stack, wrapped);
            }
        }
    }

    @Override
    public IModelState getTransforms() {
        return state;
    }

    @Override
    public boolean isAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }
}
