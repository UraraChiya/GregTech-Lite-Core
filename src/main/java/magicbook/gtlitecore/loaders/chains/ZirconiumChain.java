package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.IV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.gem;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.CVD_UNIT_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.CubicZirconia;

public class ZirconiumChain {

    public static void init() {

        //  Zr + 2O -> c-ZrO2
        CVD_UNIT_RECIPES.recipeBuilder()
                .notConsumable(dust, Yttrium)
                .input(dust, Zirconium)
                .fluidInputs(Oxygen.getFluid(2000))
                .output(gem, CubicZirconia)
                .EUt(VA[IV])
                .duration(200)
                .temperature(1132)
                .buildAndRegister();
    }
}
