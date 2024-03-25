package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class EtchingMaterialsChain {

    public static void init() {
        TMAHChain();
        EDPChain();
        HSQChain();
        KPRChain();
    }

    private static void TMAHChain() {

        //  N(CH3)3 + CH3Cl -> N(CH3)4Cl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Trimethylamine.getFluid(1000))
                .fluidInputs(Chloromethane.getFluid(1000))
                .notConsumable(Ethanol.getFluid(4000))
                .output(dust, TetramethylammoniumChloride, 6)
                .duration(200)
                .EUt(VA[IV])
                .buildAndRegister();

        //  N(CH3)4Cl + KOH -> N(CH3)4OH + KCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TetramethylammoniumChloride, 6)
                .input(dust, PotassiumHydroxide, 3)
                .fluidInputs(Water.getFluid(5000))
                .output(dust, RockSalt, 2)
                .fluidOutputs(TetramethylammoniumHydroxide.getFluid(5000))
                .duration(200)
                .EUt(VA[IV])
                .buildAndRegister();
    }

    private static void EDPChain() {

        // C6H5OH + H2O2 -> C6H4(OH)2 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Phenol.getFluid(1000))
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .output(dust, Pyrocatechol, 12)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(VA[IV])
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Pyrocatechol, 3)
                .fluidInputs(DistilledWater.getFluid(500))
                .fluidInputs(Ethylenediamine.getFluid(500))
                .fluidOutputs(EDP.getFluid(1000))
                .duration(200)
                .EUt(VA[IV])
                .buildAndRegister();
    }

    private static void HSQChain() {

        //  Si + CH3Cl + 2HCl -> CH3Cl3Si + 2H
        //  This recipe has some conflict, it's other part resolved in RecipeConflicts.
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Silicon)
                .circuitMeta(2)
                .fluidInputs(Chloromethane.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(Methyltrichlorosilane.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[MV])
                .duration(280)
                .buildAndRegister();

        //  CH3Cl3Si + 3CH4O -> CH3Si(CH3O)3 + 3HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Methyltrichlorosilane.getFluid(1000))
                .fluidInputs(Methanol.getFluid(3000))
                .fluidOutputs(Methyltrimethoxysilane.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(3000))
                .EUt(VA[HV])
                .duration(20)
                .buildAndRegister();

        //  CH3Si(CH3O)3 + 3C2H6O -> CH3Si(OCH3)3 + C3H6 + 3CH4O (cycle)
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Methyltrimethoxysilane.getFluid(1000))
                .fluidInputs(Ethanol.getFluid(3000))
                .fluidOutputs(Polymethylsilesquioxane.getFluid(1000))
                .fluidOutputs(Propene.getFluid(1000))
                .fluidOutputs(Methanol.getFluid(3000))
                .EUt(VA[EV])
                .duration(100)
                .buildAndRegister();

        //  CH3Si(OCH3)3 + H -> -[-HSiO1.5-]-
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Polymethylsilesquioxane.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(1000))
                .circuitMeta(1)
                .fluidOutputs(HSQ.getFluid(1000))
                .EUt(VA[MV])
                .duration(20)
                .buildAndRegister();
    }

    private static void KPRChain() {

        //  CH4O + C6H6 -> C7H6O + 4H
        //  Another C7H6O recipe (other recipe from HNIW chain byproduct)
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, CobaltOxide)
                .fluidInputs(Methanol.getFluid(1000))
                .fluidInputs(Benzene.getFluid(1000))
                .fluidOutputs(Benzaldehyde.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(4000))
                .EUt(VA[EV])
                .duration(100)
                .buildAndRegister();

        //  C7H6O + C2H2O-> C9H8O2
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Benzaldehyde.getFluid(1000))
                .fluidInputs(Ethenone.getFluid(1000))
                .fluidOutputs(CinnamicAcid.getFluid(1000))
                .EUt(VA[HV])
                .duration(160)
                .buildAndRegister();

        //  C9H8O2 -> C8H8
        //  Just another C9H8O2 application
        FLUID_HEATER_RECIPES.recipeBuilder()
                .fluidInputs(CinnamicAcid.getFluid(100))
                .circuitMeta(1)
                .fluidOutputs(Styrene.getFluid(100))
                .EUt(VA[EV])
                .duration(40)
                .buildAndRegister();

        //  Na2CO3 + 2C9H8O2 -> 2C9H7NaO2 + H2O + CO2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodaAsh, 6)
                .fluidInputs(CinnamicAcid.getFluid(1000))
                .output(dust, SodiumCinnamate, 38)
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();


        //  2C9H7NaO2 + CHCl3 -> C9H7ClO + C4H6 + Na2CO3 (cycle) + 2HCl + 5C (lost)
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumCinnamate, 19)
                .fluidInputs(Chloromethane.getFluid(1000))
                .output(dust, SodaAsh, 6)
                .fluidOutputs(CinnamoylChloride.getFluid(1000))
                .fluidOutputs(Butadiene.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .EUt(VA[LuV])
                .duration(200)
                .buildAndRegister();

        //  C9H7ClO + C2H4 + 2H2O -> C11H12O3 + HCl + 2H (lost)
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, SodiumHydroxide)
                .fluidInputs(CinnamoylChloride.getFluid(1000))
                .fluidInputs(Polyethylene.getFluid(1000))
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(KPR.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .EUt(VA[IV])
                .duration(100)
                .buildAndRegister();
    }
}
