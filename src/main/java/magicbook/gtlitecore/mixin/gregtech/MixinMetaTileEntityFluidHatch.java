package magicbook.gtlitecore.mixin.gregtech;

import gregtech.api.capability.IControllable;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityFluidHatch;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiblockNotifiablePart;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.IFluidTank;
import org.spongepowered.asm.mixin.Mixin;

/**
 * @author Magic_Sweepy
 *
 * @since 2.8.7-beta
 */
@Mixin(MetaTileEntityFluidHatch.class)
public abstract class MixinMetaTileEntityFluidHatch extends MetaTileEntityMultiblockNotifiablePart implements IMultiblockAbilityPart<IFluidTank>, IControllable {

    public MixinMetaTileEntityFluidHatch(ResourceLocation metaTileEntityId,
                                         int tier,
                                         boolean isExport) {
        super(metaTileEntityId, tier, isExport);
    }

    /**
     * <p>
     *     Used to change max value of tier in this method.
     * </p>
     *
     * @return  Inventory size of Fluid Hatch.
     */
    @SuppressWarnings("unused")
    private int getInventorySize() {
        return 8000 * (1 << Math.min(14, this.getTier()));
    }
}
