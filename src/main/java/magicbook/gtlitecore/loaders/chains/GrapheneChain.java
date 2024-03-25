package magicbook.gtlitecore.loaders.chains;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import magicbook.gtlitecore.common.GTLiteConfigHolder;

import static gregicality.multiblocks.api.unification.GCYMMaterials.HSLASteel;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.VACUUM_TUBE;
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
                .duration(80)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Graphite -> Graphene Oxide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .fluidInputs(NitrationMixture.getFluid(2000))
                .notConsumable(dust, SodiumHydroxide)
                .output(dust, GrapheneOxide)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .fluidOutputs(NitricAcid.getFluid(1000))
                .duration(100)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Graphene Oxide -> Graphene
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GrapheneOxide)
                .fluidInputs(Hydrazine.getFluid(100))
                .fluidInputs(Argon.getFluid(50))
                .output(dust, Graphene)
                .duration(100)
                .EUt(VA[HV])
                .buildAndRegister();
    }

    private static void SimpleGrapheneChain() {

        // Be + O -> BeO
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Beryllium)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, BerylliumOxide, 2)
                .duration(60).EUt(VA[LV]).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ring, BerylliumOxide, 64)
                .input(ring, BerylliumOxide, 64)
                .input(plate, HSLASteel, 6)
                .inputs(VACUUM_TUBE.getStackForm())
                .outputs(MAGNETRON.getStackForm())
                .duration(600)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Graphite -> Graphene
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .fluidInputs(NitrationMixture.getFluid(2000))
                .notConsumable(MAGNETRON.getStackForm())
                .output(dust, Graphene)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .fluidOutputs(NitricAcid.getFluid(1000))
                .duration(100)
                .EUt(VA[HV])
                .buildAndRegister();
    }
}
