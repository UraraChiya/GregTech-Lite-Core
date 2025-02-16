package magicbook.gtlitecore.common.metatileentities.multi.part;

import gregtech.api.capability.IControllable;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityFluidHatch;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.IFluidTank;

public class MetaTileEntityAdvancedFluidHatch extends MetaTileEntityFluidHatch implements IMultiblockAbilityPart<IFluidTank>, IControllable {

    /**
     * @param metaTileEntityId Number of meta tile entity.
     * @param tier Hint: we use mixin to extend its capacity, so this tier is extend to OpV.
     * @param isExport Check hatch is export.
     */
    public MetaTileEntityAdvancedFluidHatch(ResourceLocation metaTileEntityId,
                                            int tier,
                                            boolean isExport) {
        super(metaTileEntityId, tier, isExport);
    }

    @Override
    public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> subItems) {

        for (MetaTileEntityFluidHatch hatch : GTLiteMetaTileEntities.IMPORT_FLUID_HATCH) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());
        }

        for (MetaTileEntityFluidHatch hatch : GTLiteMetaTileEntities.EXPORT_FLUID_HATCH) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());
        }
    }
}