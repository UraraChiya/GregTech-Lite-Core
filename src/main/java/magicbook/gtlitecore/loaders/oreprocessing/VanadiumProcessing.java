package magicbook.gtlitecore.loaders.oreprocessing;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.ingot;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

/**
 * The Vanadium Processing
 *
 * @author Magic_Sweepy (2023/11/26)
 *
 * <p>
 *     Produces Bismuth Vanadate from Vanadium Magnetite
 * </p>
 *
 * <p>Main Products: Bismuth Vanadate</p>
 * <p>Side Products: Some Nitrogenous compounds</p>
 *
 * <p> 2 Vanadium Magnetite + 1 Bismuth -> 1 Bismuth Vanadate</p>
 */
public class VanadiumProcessing {

    public static void init() {

        //  2(Fe3O4)V + 6C -> 2Fe + 2VO + 6CO
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, VanadiumMagnetite, 4)
                .input(dust, Carbon, 6)
                .output(dust, RoastedVanadiumMagnetite, 4)
                .output(ingot, Iron, 2)
                .fluidOutputs(CarbonMonoxide.getFluid(6000))
                .EUt(VA[HV])
                .duration(200)
                .temperature(1994)
                .buildAndRegister();

        //  2VO + 3Na2CO3 -> 2Na3VO4 + 3CO
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, RoastedVanadiumMagnetite, 4)
                .input(dust, SodaAsh, 18)
                .output(dust, SodiumVanadate, 16)
                .fluidOutputs(CarbonMonoxide.getFluid(3000))
                .temperature(700)
                .duration(140)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Na3VO4 + NH4Cl + H2SO4 -> 3Na + NH4VO3 + SO3 + H2O + O (lost)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumVanadate, 8)
                .fluidInputs(AmmoniumChloride.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .circuitMeta(1)
                .output(dust, AmmoniumVanadate, 9)
                .output(dust, Sodium, 3)
                .fluidOutputs(SulfurTrioxide.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[MV])
                .duration(120)
                .buildAndRegister();

        //  Bi + 6HNO3 -> Bi(NO3)3(H2O) + 3NO2 + 2H2O (lost)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Bismuth)
                .fluidInputs(NitricAcid.getFluid(6000))
                .fluidOutputs(BismuthNitrateSolution.getFluid(1000))
                .fluidOutputs(NitrogenDioxide.getFluid(3000))
                .EUt(VA[LV])
                .duration(200)
                .buildAndRegister();

        //  NH4VO3 + Bi(NO3)3(H2O) + 2NH3 + H2O -> BiVO4(H2O) + 3NH4Cl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, AmmoniumVanadate, 9)
                .fluidInputs(BismuthNitrateSolution.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(BismuthVanadateSolution.getFluid(1000))
                .fluidOutputs(AmmoniumNitrate.getFluid(3000))
                .EUt(640)
                .duration(220)
                .buildAndRegister();

        //  BiVO4(H2O) -> BiVO4 + H2O
        CHEMICAL_DRYER_RECIPES.recipeBuilder()
                .fluidInputs(BismuthVanadateSolution.getFluid(1000))
                .output(dust, BismuthVanadate, 6)
                .fluidOutputs(Water.getFluid(200))
                .EUt(VA[HV])
                .duration(180)
                .buildAndRegister();
    }
}
