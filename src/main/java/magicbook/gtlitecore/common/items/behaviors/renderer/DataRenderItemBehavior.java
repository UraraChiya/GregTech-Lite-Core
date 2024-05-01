package magicbook.gtlitecore.common.items.behaviors.renderer;

import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.util.TransformUtils;
import magicbook.gtlitecore.api.item.IItemRendererManager;
import magicbook.gtlitecore.client.renderer.handler.DataItemRenderer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

/**
 * Data Render Item Behavior
 *
 * @author Gate Guardian
 *
 * <p>
 *     Add new render about vanilla data items (e.g. data stick),
 *     now data stick will render the product when SHIFT is pressed.
 * </p>
 */
public class DataRenderItemBehavior implements IItemRendererManager {

    @Override
    public void onRendererRegistry(ResourceLocation location) {
        ModelRegistryHelper.register(new ModelResourceLocation(location, "inventory"), new DataItemRenderer(TransformUtils.DEFAULT_ITEM, modelRegistry -> modelRegistry.getObject(new ModelResourceLocation(location, "inventory"))));
    }
}
