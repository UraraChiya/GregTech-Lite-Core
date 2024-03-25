package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.common.items.MetaItems.BLACKLIGHT;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.BURNER_REACTOR_RECIPES;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.CRYOGENIC_REACTOR_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class RubberChain {

    public static void init() {
        NBRChain();
        PPFRChain();
    }

    private static void NBRChain() {

        //  C3H6 + NH3 + 2H2O -> 6C3H3N + 2H
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Sodium)
                .fluidInputs(Propene.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidInputs(Air.getFluid(4000))
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(Acrylonitrile.getFluid(6000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[LuV])
                .duration(120)
                .buildAndRegister();

        //  C4H6 + C3H3N -> C7H9N
        CRYOGENIC_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, Iron)
                .fluidInputs(Butadiene.getFluid(1000))
                .fluidInputs(Acrylonitrile.getFluid(1000))
                .notConsumable(HydrogenPeroxide.getFluid(1))
                .fluidOutputs(NitrileButadieneRubber.getFluid(1000))
                .EUt(VA[LuV])
                .duration(200)
                .temperature(286)
                .buildAndRegister();
    }

    private static void PPFRChain() {

        //  6C + 3POCl3 + 3NH4Cl -> Cl6N3P3 + 3H2O + 6HCl
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Carbon, 6)
                .fluidInputs(PhosphorylChloride.getFluid(3000))
                .fluidInputs(AmmoniumChloride.getFluid(3000))
                .fluidOutputs(PhosphonitrilicChlorideTrimer.getFluid(1000))
                .fluidOutputs(Steam.getFluid(3000))
                .fluidOutputs(HydrochloricAcid.getFluid(6000))
                .EUt(VA[HV])
                .duration(140)
                .temperature(796)
                .buildAndRegister();

        //  NaF + C2H6O + 2F -> NaC2H4OF3 + 2H
        CRYOGENIC_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumFluoride, 2)
                .fluidInputs(Ethanol.getFluid(1000))
                .fluidInputs(Fluorine.getFluid(2000))
                .output(dust, SodiumTrifluoroethanolate, 11)
                .fluidOutputs(Hydrogen.getFluid(2000))
                .temperature(344)
                .EUt(VA[EV])
                .duration(140)
                .buildAndRegister();

        //  C6H6 + 2F -> C6H5F + HF
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Benzene.getFluid(1000))
                .fluidInputs(Fluorine.getFluid(2000))
                .circuitMeta(1)
                .fluidOutputs(Fluorobenzene.getFluid(1000))
                .fluidOutputs(HydrofluoricAcid.getFluid(1000))
                .EUt(VA[HV])
                .duration(60)
                .buildAndRegister();

        //  2C6H5F + 6HF + O -> C5H4F8O + 2C3H6
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(BLACKLIGHT)
                .fluidInputs(Fluorobenzene.getFluid(2000))
                .fluidInputs(HydrofluoricAcid.getFluid(6000))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidOutputs(OctafluoroPentanol.getFluid(1000))
                .fluidOutputs(Propene.getFluid(2000))
                .EUt(VA[ZPM])
                .duration(340)
                .buildAndRegister();

        //  NaC2H4OF3 + Cl6N3P3 + 4C5H4F8O -> C24H16O8N4P4F40 + NaF (cycle) + 3POCl3 (cycle)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumTrifluoroethanolate, 11)
                .fluidInputs(PhosphonitrilicChlorideTrimer.getFluid(1000))
                .fluidInputs(OctafluoroPentanol.getFluid(4000))
                .output(dust, SodiumFluoride, 2)
                .fluidOutputs(PolyPhosphonitrileFluoroRubber.getFluid(1000))
                .fluidOutputs(PhosphorylChloride.getFluid(3000))
                .EUt(VA[UV])
                .duration(400)
                .buildAndRegister();
    }
}
