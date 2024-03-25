package magicbook.gtlitecore.loaders.oreprocessing;

import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_BATH_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

/**
 * The Niobium-Tantalum Process
 *
 * <p>
 *     Produces Niobium and Tantalum from Tantalite and Pyrochlore
 * </p>
 *
 * <p>Main Products: Niobium, Tantalum</p>
 * <p>Side Products: None</p>
 *
 * <p>11 Pyrochlore -> 2 Niobium + 2/7 Tantalum </p>
 * <p>9 Tantalite -> 2 Tantalum + 2/7 Niobium </p>
 */
public class NiobiumTantalumProcessing {

    public static void init() {
        NiobiumProcess();
        TantalumProcess();
    }

    private static void NiobiumProcess() {
        //  Ca2Nb2O7 + 4HF -> Nb2O5 + 2CaF2 + 2H2O
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Pyrochlore, 11)
                .fluidInputs(HydrofluoricAcid.getFluid(4000))
                .output(dust, NiobiumPentoxide, 7)
                .output(dust, TantalumPentoxide)
                .output(dust, CalciumDifluoride, 6)
                .fluidOutputs(Water.getFluid(2000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();
    }

    private static void TantalumProcess() {
        //  MnTa2O6 + 2HF -> Ta2O5 + MnF2 + H2O
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Tantalite, 9)
                .fluidInputs(HydrofluoricAcid.getFluid(2000))
                .output(dust, TantalumPentoxide, 7)
                .output(dust, NiobiumPentoxide)
                .output(dust, ManganeseDifluoride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();
    }
}