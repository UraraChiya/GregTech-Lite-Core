package magicbook.gtlitecore.common.metatileentities.multi.part;

import gregtech.api.capability.IControllable;
import gregtech.api.capability.IGhostSlotConfigurable;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityItemBus;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.IItemHandlerModifiable;

public class MetaTileEntityAdvancedItemBus extends MetaTileEntityItemBus implements IMultiblockAbilityPart<IItemHandlerModifiable>, IControllable, IGhostSlotConfigurable {

    /**
     * @param metaTileEntityId Number of meta tile entity.
     * @param tier Hint: we use mixin to extend its capacity, so this tier is extend to OpV.
     * @param isExport Check hatch is export.
     */
    public MetaTileEntityAdvancedItemBus(ResourceLocation metaTileEntityId,
                                         int tier,
                                         boolean isExport) {
        super(metaTileEntityId, tier, isExport);
    }

    @Override
    public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> subItems) {
        for (MetaTileEntityItemBus bus : GTLiteMetaTileEntities.IMPORT_ITEM_HATCH) {
            if (bus != null)
                subItems.add(bus.getStackForm());
        }

        for (MetaTileEntityItemBus bus : GTLiteMetaTileEntities.EXPORT_ITEM_HATCH) {
            if (bus != null)
                subItems.add(bus.getStackForm());
        }
    }
}