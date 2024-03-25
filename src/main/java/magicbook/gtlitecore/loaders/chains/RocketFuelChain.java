package magicbook.gtlitecore.loaders.chains;

import gregtech.api.recipes.GTRecipeHandler;
import magicbook.gtlitecore.common.GTLiteConfigHolder;

import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.COMBUSTION_GENERATOR_FUELS;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.ROCKET_ENGINE_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class RocketFuelChain {

    public static void init() {

        //  Remove rocket fuel Combustion generator recipe
        if (!GTLiteConfigHolder.misc.enableRocketFuelEngineRecipe) {
            GTRecipeHandler.removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, RocketFuel.getFluid(16));
        }

        //  Rocket Fuel
        ROCKET_ENGINE_RECIPES.recipeBuilder()
                .fluidInputs(RocketFuel.getFluid(16))
                .EUt(GTLiteConfigHolder.misc.heatValueRocketFuel)
                .duration(40)
                .buildAndRegister();

        //  RP-1 Rocket Fuel
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(CoalTar.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidOutputs(RP1RocketFuel.getFluid(1000))
                .EUt(VA[HV])
                .duration(16)
                .buildAndRegister();

        ROCKET_ENGINE_RECIPES.recipeBuilder()
                .fluidInputs(RP1RocketFuel.getFluid(12))
                .EUt(GTLiteConfigHolder.misc.heatValueRP1RocketFuel)
                .duration(20)
                .buildAndRegister();

        //  Dense Hydrazine Mixture Fuel
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Dimethylhydrazine.getFluid(1000))
                .fluidInputs(Methanol.getFluid(1000))
                .fluidOutputs(DenseHydrazineMixtureFuel.getFluid(1000))
                .EUt(240)
                .duration(120)
                .buildAndRegister();

        ROCKET_ENGINE_RECIPES.recipeBuilder()
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(9))
                .EUt(GTLiteConfigHolder.misc.heatValueDenseHydrazineMixtureRocketFuel)
                .duration(80)
                .buildAndRegister();

        //  C + N2H4 + H2 -> CH6N2
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Carbon)
                .fluidInputs(Hydrazine.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(2000))
                .fluidOutputs(Methylhydrazine.getFluid(1000))
                .EUt(VA[HV])
                .duration(480)
                .buildAndRegister();

        //  Methylhydrazine Nitrate Rocket Fuel
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Methylhydrazine.getFluid(1000))
                .fluidInputs(Tetranitromethane.getFluid(1000))
                .fluidOutputs(MethylhydrazineNitrateRocketFuel.getFluid(1000))
                .EUt(VA[HV])
                .duration(200)
                .buildAndRegister();

        ROCKET_ENGINE_RECIPES.recipeBuilder()
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(6))
                .EUt(GTLiteConfigHolder.misc.heatValueMethylhydrazineNitrateRocketFuel)
                .duration(120)
                .buildAndRegister();
    }
}
