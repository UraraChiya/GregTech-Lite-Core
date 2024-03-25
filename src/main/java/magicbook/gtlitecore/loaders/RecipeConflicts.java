package magicbook.gtlitecore.loaders;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtechfoodoption.GTFOMaterialHandler.IsopropylChloride;

public class RecipeConflicts {

    public static void init() {

        //  Conflict between Dichloroethane and Vinyl Chloride
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES, Ethylene.getFluid(1000), Chlorine.getFluid(2000));
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES, Ethylene.getFluid(1000), Chlorine.getFluid(2000));
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(2000))
                .circuitMeta(1)
                .fluidOutputs(VinylChloride.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .duration(160)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Conflict between 2-Ethylanthraquinone and Styrene
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES, Ethylbenzene.getFluid(1000));
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES, Ethylbenzene.getFluid(1000));
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylbenzene.getFluid(1000))
                .notConsumable(dust, Pyrite)
                .fluidOutputs(Styrene.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .duration(30)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Conflict between Potassium Hydroxide and Rock Salt Electrolysis
        //  Hint: property redo
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, RockSalt, 2)
                .circuitMeta(1)
                .output(dust, Potassium)
                .fluidOutputs(Chlorine.getFluid(1000))
                .duration(72)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Conflict between Salt Electrolysis and Sodium Chlorate
        //  Hint: property redo
        GTRecipeHandler.removeRecipesByInputs(ELECTROLYZER_RECIPES, OreDictUnifier.get(dust, Salt, 2));

        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, Salt, 2)
                .circuitMeta(1)
                .output(dust, Sodium)
                .fluidOutputs(Chlorine.getFluid(1000))
                .duration(56)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Conflict between Polydimethylsiloxane and Carbon Tetrachloride
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Silicon), IntCircuitIngredient.getIntegratedCircuit(2)},
                new FluidStack[]{Water.getFluid(1000), Chlorine.getFluid(4000), Methane.getFluid(2000)});
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Silicon), IntCircuitIngredient.getIntegratedCircuit(2)},
                new FluidStack[]{Water.getFluid(1000), Chlorine.getFluid(4000), Methane.getFluid(2000)});

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Silicon, 3)
                .fluidInputs(Water.getFluid(3000))
                .fluidInputs(Methane.getFluid(6000))
                .fluidInputs(Chlorine.getFluid(12000))
                .circuitMeta(24)
                .output(dust, Polydimethylsiloxane, 9)
                .fluidOutputs(HydrochloricAcid.getFluid(6000))
                .fluidOutputs(DilutedHydrochloricAcid.getFluid(6000))
                .duration(2880)
                .EUt(96)
                .buildAndRegister();

        //  Conflict between Methyltrichlorosilane and Dimethyldichlorosilane
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Silicon)},
                new FluidStack[]{Chloromethane.getFluid(2000)});

        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Silicon)},
                new FluidStack[]{Chloromethane.getFluid(2000)});

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Silicon)
                .circuitMeta(1)
                .fluidInputs(Chloromethane.getFluid(2000))
                .fluidOutputs(Dimethyldichlorosilane.getFluid(1000))
                .EUt(96)
                .duration(240)
                .buildAndRegister();

        //  Conflict between Calcite and Sodium Ethoxide
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Quicklime, 2)},
                new FluidStack[]{CarbonDioxide.getFluid(1000)});

        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Quicklime, 2)},
                new FluidStack[]{CarbonDioxide.getFluid(1000)});

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Quicklime, 2)
                .circuitMeta(2)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .output(dust, Calcite, 5)
                .EUt(30)
                .duration(80)
                .buildAndRegister();

        //  Conflict between Acetic acid and Dimethyl carbonate
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES, CarbonMonoxide.getFluid(1000), Methanol.getFluid(1000));
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES, CarbonMonoxide.getFluid(1000), Methanol.getFluid(1000));

        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidInputs(Methanol.getFluid(1000))
                .circuitMeta(1)
                .fluidOutputs(AceticAcid.getFluid(1000))
                .EUt(VH[LV])
                .duration(300)
                .buildAndRegister();

        //  Conflict between Isopropyl Chloride (GTFO) and Isochloropropane
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES, Propene.getFluid(1000), HydrochloricAcid.getFluid(1000));
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES, Propene.getFluid(1000), HydrochloricAcid.getFluid(1000));

        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Propene.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .circuitMeta(1)
                .fluidOutputs(IsopropylChloride.getFluid(1000))
                .EUt(VA[LV])
                .duration(200)
                .buildAndRegister();

        //  Conflict between Carbon Monoxide and Toluene Diisocyanate
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Carbon)},
                new FluidStack[]{CarbonDioxide.getFluid(1000)});

        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Carbon)},
                new FluidStack[]{CarbonDioxide.getFluid(1000)});

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Carbon)
                .circuitMeta(1)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(CarbonMonoxide.getFluid(2000))
                .EUt(VA[ULV])
                .duration(800)
                .buildAndRegister();
    }
}
