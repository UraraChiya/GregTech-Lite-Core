package magicbook.gtlitecore.integration.theoneprobe.provider;

import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.capability.IWorkable;
import gregtech.api.capability.impl.AbstractRecipeLogic;
import gregtech.integration.theoneprobe.provider.CapabilityInfoProvider;
import mcjty.theoneprobe.api.ElementAlignment;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.TextStyleClass;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * Item Output Info Provider
 *
 * @author vfyjxf
 *
 * <p>
 *     Integrated from <a href="https://github.com/vfyjxf/GregicProbe">Gregic Probe</a> for GTCE,
 *     this mod use MIT License and is stop updating now (so we integrated it in gtlitecore).
 * </p>
 */
public class RecipeItemOutputInfoProvider extends CapabilityInfoProvider<IWorkable> {

    @Override
    protected @Nonnull Capability<IWorkable> getCapability() {
        return GregtechTileCapabilities.CAPABILITY_WORKABLE;
    }

    @Override
    protected void addProbeInfo(IWorkable capability,
                                IProbeInfo info,
                                EntityPlayer player,
                                TileEntity tileEntity,
                                IProbeHitData data) {
        if (capability.getProgress() > 0 && capability instanceof AbstractRecipeLogic) {
            IProbeInfo horizontalPane = info.horizontal(info.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER));
            List<ItemStack> itemOutputs = new ArrayList<>(ObfuscationReflectionHelper.getPrivateValue(AbstractRecipeLogic.class, (AbstractRecipeLogic) capability, "itemOutputs"));
            if (!itemOutputs.isEmpty()) {
                horizontalPane.text(TextStyleClass.INFO + "{*gtlitecore.top.item_outputs*}");
                for (ItemStack itemStack : itemOutputs) {
                    if (itemStack != null) {
                        horizontalPane.item(itemStack);
                        if (itemOutputs.size() <= 2) {
                            horizontalPane.itemLabel(itemStack);
                        }
                    }
                }
            }
        }
    }

    @Override
    public String getID() {
        return "gtlitecore:recipe_info_item_output";
    }
}
