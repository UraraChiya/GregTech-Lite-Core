package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class BPAPolycarbonateChain {

    public static void init() {

        //  CO + O + 2CH4O -> C3H6O3 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidInputs(Methanol.getFluid(2000))
                .circuitMeta(2)
                .fluidOutputs(DimethylCarbonate.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[HV])
                .duration(120)
                .buildAndRegister();

        //  C3H6O3 + 2C6H6O -> C13H10O3 + 2CH4O (cycle)
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(DimethylCarbonate.getFluid(1000))
                .fluidInputs(Phenol.getFluid(2000))
                .fluidOutputs(DiphenylCarbonate.getFluid(1000))
                .fluidOutputs(Methanol.getFluid(2000))
                .EUt(VA[EV])
                .duration(120)
                .buildAndRegister();

        //  C13H10O3 + C15H16O2 -> BPA Polycarbonate + 2C6H6O (cycle)
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(DiphenylCarbonate.getFluid(1000))
                .fluidInputs(BisphenolA.getFluid(1000))
                .fluidOutputs(BPAPolycarbonate.getFluid(L))
                .fluidOutputs(Phenol.getFluid(2000))
                .EUt(VA[IV])
                .duration(160)
                .buildAndRegister();
    }
}
