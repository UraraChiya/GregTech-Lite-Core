package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.MOLECULAR_TRANSFORMER_RECIPES;

public class MolecularTransformer {

    public static void init() {

        //  Coal -> Diamond
        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder()
                .input(gem, Coal)
                .output(gem, Diamond)
                .EUt(VA[HV])
                .duration(300)
                .buildAndRegister();

        //  Cu -> Au
        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder()
                .input(ingot, Copper)
                .output(ingot, Gold)
                .EUt(VA[EV])
                .duration(600)
                .buildAndRegister();

        //  Sn -> Ag
        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder()
                .input(ingot, Tin)
                .output(ingot, Silver)
                .EUt(VA[EV])
                .duration(600)
                .buildAndRegister();

        //  Graphite -> Graphene
        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .output(dust, Graphene)
                .EUt(VA[EV])
                .duration(600)
                .buildAndRegister();

        //  Cr -> Ti
        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder()
                .input(ingot, Chrome)
                .output(ingot, Titanium)
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Au -> Pt
        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder()
                .input(ingot, Gold)
                .output(ingot, Platinum)
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Pb -> Pd
        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder()
                .input(ingot, Lead)
                .output(ingot, Palladium)
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Fe -> Ir
        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder()
                .input(ingot, Iron)
                .output(ingot, Iridium)
                .EUt(VA[UV])
                .duration(2400)
                .buildAndRegister();

        //  Al -> Os
        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder()
                .input(ingot, Aluminium)
                .output(ingot, Osmium)
                .EUt(VA[UV])
                .duration(2400)
                .buildAndRegister();
    }
}
