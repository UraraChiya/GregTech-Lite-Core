package magicbook.gtlitecore.loaders.chain;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class AmmoniaChain {

    public static void init() {

        //  Minimized Haber-Bosch Process

        //  CH4 + N -> CH4N
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Methane.getFluid(1000))
                .fluidInputs(Air.getFluid(1500))
                .fluidOutputs(RichNitrogenMixture.getFluid(2500))
                .duration(80)
                .EUt(VA[MV])
                .buildAndRegister();

        //  CH4N + 2H2O -> NH4 + CH4 + O2 (loss)
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, GTLiteConfigHolder.chainOverrides.enableAmmoniaProcessing ? Chrome : Ruthenium)
                .fluidInputs(RichNitrogenMixture.getFluid(2500))
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(RichAmmoniaMixture.getFluid(GTLiteConfigHolder.chainOverrides.enableAmmoniaProcessing ? 1000 : 3000))
                .fluidOutputs(Methane.getFluid(1000))
                .duration(80)
                .EUt(VA[MV])
                .buildAndRegister();

        //  NH4 -> NH3 + H (loss)
        BREWING_RECIPES.recipeBuilder()
                .notConsumable(dust, Magnetite)
                .fluidInputs(RichAmmoniaMixture.getFluid(1000))
                .fluidOutputs(Ammonia.getFluid(1000))
                .duration(160)
                .EUt(VA[LV])
                .buildAndRegister();

        if (GTLiteConfigHolder.chainOverrides.enableAmmoniaProcessing) {
            GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                    new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(1)},
                    new FluidStack[]{Nitrogen.getFluid(1000), Hydrogen.getFluid(3000)}
            );
            GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                    new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(1)},
                    new FluidStack[]{Nitrogen.getFluid(1000), Hydrogen.getFluid(3000)}
            );
        }
    }
}
