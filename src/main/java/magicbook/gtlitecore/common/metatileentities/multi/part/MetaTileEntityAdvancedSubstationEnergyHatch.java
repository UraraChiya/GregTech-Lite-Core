package magicbook.gtlitecore.common.metatileentities.multi.part;

import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntitySubstationEnergyHatch;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityAdvancedSubstationEnergyHatch extends MetaTileEntitySubstationEnergyHatch {

    public MetaTileEntityAdvancedSubstationEnergyHatch(ResourceLocation metaTileEntityId,
                                                       int tier,
                                                       int amperage,
                                                       boolean isExport) {
        super(metaTileEntityId, tier, amperage, isExport);
    }

    @Override
    public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> subItems) {
        for (MetaTileEntitySubstationEnergyHatch hatch : GTLiteMetaTileEntities.SUBSTATION_INPUT_ENERGY_HATCH) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());
        }

        for (MetaTileEntitySubstationEnergyHatch hatch : GTLiteMetaTileEntities.SUBSTATION_OUTPUT_ENERGY_HATCH) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());
        }
    }
}
