package magicbook.gtlitecore.loaders.chains;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import magicbook.gtlitecore.common.GTLiteConfigHolder;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.MAGNETRON;

public class GrapheneChain {

    public static void init() {
        removeVanillaRecipes();
        HydrogenPeroxideGrapheneChain();
        SimpleGrapheneChain();
    }

    private static void removeVanillaRecipes() {
        if (GTLiteConfigHolder.recipes.enableHarderGrapheneProcess) {
            GTRecipeHandler.removeRecipesByInputs(MIXER_RECIPES,
                    OreDictUnifier.get(dust, Graphite),
                    OreDictUnifier.get(dust, Carbon, 4),
                    OreDictUnifier.get(dust, Silicon),
                    IntCircuitIngredient.getIntegratedCircuit(1));
        }
    }

    private static void HydrogenPeroxideGrapheneChain() {

        //  2NH3 + H2O2 -> N2H4 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .fluidOutputs(Hydrazine.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[HV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  Graphite -> Graphene Oxide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .fluidInputs(NitrationMixture.getFluid(2000))
                .notConsumable(dust, SodiumHydroxide)
                .output(dust, GrapheneOxide)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .fluidOutputs(NitricAcid.getFluid(1000))
                .EUt(VA[HV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Graphene Oxide -> Graphene
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GrapheneOxide)
                .fluidInputs(Hydrazine.getFluid(100))
                .fluidInputs(Argon.getFluid(50))
                .output(dust, Graphene)
                .EUt(VA[HV])
                .duration(5 * SECOND)
                .buildAndRegister();
    }

    private static void SimpleGrapheneChain() {

        //  Be + O -> BeO
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Beryllium)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, BerylliumOxide, 2)
                .EUt(VA[LV])
                .duration(3 * SECOND)
                .buildAndRegister();

        //  Graphite -> Graphene
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .fluidInputs(NitrationMixture.getFluid(2000))
                .notConsumable(MAGNETRON.getStackForm())
                .output(dust, Graphene)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .fluidOutputs(NitricAcid.getFluid(1000))
                .EUt(VA[HV])
                .duration(5 * SECOND)
                .buildAndRegister();
    }
}
