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
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * Fluid Output Info Provider
 *
 * @author vfyjxf
 *
 * <p>
 *     Integrated from <a href="https://github.com/vfyjxf/GregicProbe">Gregic Probe</a> for GTCE,
 *     this mod use MIT License and is stop updating now (so we integrated it in gtlitecore).
 * </p>
 */
public class RecipeFluidOutputInfoProvider extends CapabilityInfoProvider<IWorkable> {

    public RecipeFluidOutputInfoProvider() {}

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
        if (capability.getProgress() > 0 && capability instanceof  AbstractRecipeLogic) {
            IProbeInfo horizontalPane = info.horizontal(info.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER));
            List<FluidStack> fluidOutputs = new ArrayList<>(ObfuscationReflectionHelper.getPrivateValue(AbstractRecipeLogic.class, (AbstractRecipeLogic) capability, "fluidOutputs"));
            //  check if fluid output is empty.
            if (!fluidOutputs.isEmpty()) {
                horizontalPane.text(TextStyleClass.INFO + "{*gtlitecore.top.fluid_outputs*}");
                //  if recipe outputs have many fluids, then view all fluids (so we ergodic it).
                for (FluidStack fluidStack : fluidOutputs) {
                    IProbeInfo HorizontalPane = info.horizontal(info.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER));
                    HorizontalPane.icon(fluidStack.getFluid().getStill(), -1, -1, 16, 16, info.defaultIconStyle().width(20));
                    HorizontalPane.text(TextStyleClass.INFO + fluidStack.getLocalizedName());
                    if (fluidStack.amount >= 1000) {
                        HorizontalPane.text(TextStyleClass.INFO + " * " + (fluidStack.amount / 1000) + "B");
                    } else {
                        HorizontalPane.text(TextStyleClass.INFO + " * " + fluidStack.amount + "mB");
                    }
                }
            }
        }
    }

    @Override
    public String getID() {
        return "gtlitecore:recipe_info_fluid_output";
    }
}
