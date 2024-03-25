package magicbook.gtlitecore.loaders.oreprocessing;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_BATH_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtechfoodoption.GTFOMaterialHandler.SodiumSulfate;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

/**
 * The Polonium Radium Process
 *
 * @author Magic_Sweepy (2024/02/01)
 *
 * <p>
 *     Produces Polonium and Radium from Pitchblende
 * </p>
 *
 * <p>Main Products: Polonium, Radium</p>
 * <p>Side Products: Uraninite</p>
 */
public class PoloniumRadiumProcessing {

    public static void init() {
        PoloniumProcessing();
        RadiumProcessing();
    }

    private static void PoloniumProcessing() {

        //  (UO2)3ThPb + 4HNO3 -> UO2 + Po(NO3)4
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Pitchblende, 5)
                .fluidInputs(NitricAcid.getFluid(4000))
                .output(dust, Uraninite, 3)
                .fluidOutputs(PoloniumNitrate.getFluid(1000))
                .EUt(VA[EV])
                .duration(400)
                .buildAndRegister();

        //  Po(NO3)4 + 2HCl + 2H -> PoCl2 + 4HNO3 (cycle)
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(PoloniumNitrate.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidInputs(Hydrogen.getFluid(2000))
                .output(dust, PoloniumDichloride, 3)
                .fluidOutputs(NitricAcid.getFluid(4000))
                .EUt(VA[HV])
                .duration(200)
                .temperature(2866)
                .buildAndRegister();

        //  PoCl2 + 2H -> Po + 2HCl (cycle)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PoloniumDichloride, 3)
                .fluidInputs(Hydrogen.getFluid(2000))
                .output(dust, Polonium)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .EUt(VA[IV])
                .duration(100)
                .buildAndRegister();
    }

    private static void RadiumProcessing() {

        //  (UO2)3ThPb + 2HCl -> UO2 + RaCl2
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Pitchblende, 5)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .output(dust, Uraninite, 3)
                .output(dust, RadiumDichloride, 3)
                .EUt(VA[EV])
                .duration(400)
                .buildAndRegister();

        //  Another Na2SO4 recipe
        //  Because in GTFO, Na2SO4 is just a byproduct in Scheele's Green chain.

        //  Na2S2O8 + 2H -> Na2SO4 + H2SO4 (cycle, if you use salt and sulfur acid to make Na2S2O8)
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumPersulfate.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(2000))
                .output(dust, SodiumSulfate, 7)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .EUt(VA[HV])
                .duration(140)
                .temperature(375)
                .buildAndRegister();

        //  RaCl2 + Na2SO4 -> RaSO4 + 2NaCl
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, RadiumDichloride, 3)
                .input(dust, SodiumSulfate, 7)
                .output(dust, RadiumSulfate, 6)
                .output(dust, Salt, 4)
                .EUt(VA[HV])
                .duration(250)
                .temperature(650)
                .buildAndRegister();

        //  RaSO4 + 2KOH -> Ra(OH)2 + K2SO4
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, RadiumSulfate, 6)
                .input(dust, PotassiumHydroxide, 6)
                .output(dust, RadiumHydroxide, 5)
                .output(dust, PotassiumSulfate, 7)
                .EUt(VA[IV])
                .duration(350)
                .buildAndRegister();

        //  Ra(OH)2 -> RaO + H2O
        CHEMICAL_DRYER_RECIPES.recipeBuilder()
                .input(dust, RadiumHydroxide, 5)
                .output(dust, RadiumOxide, 2)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[MV])
                .duration(40)
                .buildAndRegister();

        //  RaO + C -> Ra + CO
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, RadiumOxide, 2)
                .input(dust, Carbon)
                .output(dust, Radium)
                .fluidOutputs(CarbonMonoxide.getFluid(1000))
                .EUt(VA[LuV])
                .duration(200)
                .temperature(498)
                .buildAndRegister();

    }

}
