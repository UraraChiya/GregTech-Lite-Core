package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.BURNER_REACTOR_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.EthyleneGlycol;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.EthyleneOxide;

public class EthyleneGlycolChain {

    public static void init() {

        //  7C2H4 + 12O -> 6C2H4O + 2CO2 + 2H2O
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, Silver)
                .fluidInputs(Ethylene.getFluid(7000))
                .fluidOutputs(EthyleneOxide.getFluid(6000))
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[HV])
                .duration(7 * SECOND + 10)
                .temperature(450)
                .buildAndRegister();

        //  C2H4O + H2O -> C2H6O2
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(EthyleneOxide.getFluid(1000))
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidInputs(CarbonDioxide.getFluid(100))
                .fluidOutputs(EthyleneGlycol.getFluid(1000))
                .EUt(VA[HV])
                .duration(20 * SECOND)
                .buildAndRegister();
    }
}
