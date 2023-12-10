package magicbook.gtlitecore.loaders.oreprocessing;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

/**
 * The Strontium Process
 *
 * @author Magic_Sweepy (2023/12/05)
 *
 * <p>Produces Strontium from Pyrochlore</p>
 *
 * <p>Main Products: Strontium</p>
 * <p>Side Products: Niobium, Tantalum</p>
 *
 * <p>1 Pyrochlore -> 2 Strontium </p>
 */
public class StrontiumProcessing {

    public static void init() {

        //  Ca2Nb2O7 + 4HCl -> Nb2O5 + 1/7 Ta2O5 + 2SrCl2 + 2H2O
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, Pyrochlore, 11)
                .fluidInputs(HydrochloricAcid.getFluid(4000))
                .output(dust, NiobiumPentoxide, 7)
                .output(dust, TantalumPentoxide)
                .output(dust, StrontiumDichloride, 6)
                .fluidOutputs(Steam.getFluid(2000))
                .EUt(VA[IV])
                .duration(200)
                .temperature(2480)
                .buildAndRegister();

        //  SrCl2 + H2SO4 -> SrSO4 + 2HCl
        CVD_UNIT_RECIPES.recipeBuilder()
                .input(dust, StrontiumDichloride, 3)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, Celestite, 6)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .EUt(VA[LuV])
                .duration(100)
                .temperature(1145)
                .buildAndRegister();

        //  SrSO4 + NaHCO3 -> SrCO3 + NaHSO4
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Celestite, 6)
                .fluidInputs(SodiumBicarbonate.getFluid(1000))
                .output(dust, StrontiumCarbonate, 5)
                .fluidOutputs(SodiumBisulfate.getFluid(1000))
                .EUt(VA[IV])
                .duration(20)
                .buildAndRegister();
    }
}