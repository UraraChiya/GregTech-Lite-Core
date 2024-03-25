package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.EV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.CATALYTIC_REFORMER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class ChlorineChain {

    public static void init() {

        //  2CH4 + 5Cl -> 7(CH4)2Cl5
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Methane.getFluid(2000))
                .fluidInputs(Chlorine.getFluid(5000))
                .fluidOutputs(ChlorinatedSolvents.getFluid(7000))
                .EUt(VA[EV])
                .duration(240)
                .buildAndRegister();

        //  14(CH4)2Cl5 -> CH3Cl + CH2Cl2 + CHCl3 + CCl4
        CATALYTIC_REFORMER_RECIPES.recipeBuilder()
                .notConsumable(plate, Palladium)
                .fluidInputs(ChlorinatedSolvents.getFluid(14000))
                .fluidOutputs(Chloromethane.getFluid(1330))
                .fluidOutputs(Dichloromethane.getFluid(2170))
                .fluidOutputs(Chloroform.getFluid(2170))
                .fluidOutputs(CarbonTetrachloride.getFluid(1330))
                .duration(360)
                .EUt(VA[EV])
                .buildAndRegister();
    }
}
