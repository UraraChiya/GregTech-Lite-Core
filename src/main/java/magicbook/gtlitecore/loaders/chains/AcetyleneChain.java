package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.gem;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.INDUSTRIAL_ROASTER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class AcetyleneChain {

    public static void init() {

        // CaO + 3C -> CaC2 + CO
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, Quicklime, 2)
                .input(dust, Carbon, 3)
                .output(dust, CalciumCarbide, 3)
                .fluidOutputs(CarbonMonoxide.getFluid(1000))
                .temperature(2473)
                .duration(500)
                .EUt(VA[MV])
                .buildAndRegister();

        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, Quicklime, 2)
                .input(gem, Coke)
                .output(dust, CalciumCarbide, 3)
                .fluidOutputs(CarbonMonoxide.getFluid(1000))
                .temperature(2473)
                .duration(200)
                .EUt(VA[MV])
                .buildAndRegister();

        //  CaC2 + 2H2O -> Ca(OH)2 + C2H2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CalciumCarbide, 3)
                .fluidInputs(Water.getFluid(2000))
                .output(dust, CalciumHydroxide, 5)
                .fluidOutputs(Acetylene.getFluid(1000))
                .duration(80)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Ca(OH)2 + CO2 -> CaCO3 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CalciumHydroxide, 5)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .output(dust, Calcite, 5)
                .fluidOutputs(Water.getFluid(1000))
                .duration(80)
                .EUt(VA[LV])
                .buildAndRegister();
    }
}
