package magicbook.gtlitecore.loaders.chains;

import magicbook.gtlitecore.common.GTLiteConfigHolder;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtechfoodoption.GTFOMaterialHandler.HydrogenCyanide;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.BURNER_REACTOR_RECIPES;

public class CyanogenChain {

    public static void init() {

        if (GTLiteConfigHolder.recipes.enableEasierHydrogenCyanideProcess) {
            //  H + NH3 + CH4 -> HCN + 4H + 3H (lost)
            CHEMICAL_RECIPES.recipeBuilder()
                    .fluidInputs(Hydrogen.getFluid(1000))
                    .fluidInputs(Ammonia.getFluid(1000))
                    .fluidInputs(Methane.getFluid(1000))
                    .circuitMeta(3)
                    .fluidOutputs(HydrogenCyanide.getFluid(1000))
                    .fluidOutputs(Hydrogen.getFluid(4000))
                    .EUt(VA[MV])
                    .duration(120)
                    .buildAndRegister();

            //  3CH4 + 3NH3 + 8O -> 3HCN + 8H2O + H (lost)
            BURNER_REACTOR_RECIPES.recipeBuilder()
                    .notConsumable(dust, Platinum)
                    .fluidInputs(Methane.getFluid(3000))
                    .fluidInputs(Ammonia.getFluid(3000))
                    .fluidInputs(Oxygen.getFluid(1000))
                    .fluidOutputs(HydrogenCyanide.getFluid(3000))
                    .fluidOutputs(Steam.getFluid(8000))
                    .temperature(1473)
                    .duration(60)
                    .EUt(VA[HV])
                    .buildAndRegister();
        }
    }
}
