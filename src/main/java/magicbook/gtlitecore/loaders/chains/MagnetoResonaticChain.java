package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.seedCrystal;

public class MagnetoResonaticChain {

    public static void init() {

        //  2.5 SiO2 + Fe -> (SiO2)5Fe
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, SiliconDioxide, 5)
                .input(dust, Iron)
                .fluidInputs(DistilledWater.getFluid(L))
                .output(seedCrystal, Prasiolite)
                .duration(400)
                .EUt(VA[MV])
                .buildAndRegister();

        //  3Te + 2Bi -> Be2Te3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Tellurium, 3)
                .input(dust, Bismuth, 2)
                .notConsumable(SulfuricAcid.getFluid(1))
                .output(dust, BismuthTellurite, 5)
                .EUt(VA[MV])
                .duration(160)
                .buildAndRegister();

        //  Magneto Resonatic
        MIXER_RECIPES.recipeBuilder()
                .input(dust, BismuthTellurite, 4)
                .input(dust, Prasiolite, 3)
                .input(dust, CubicZirconia)
                .input(dust, SteelMagnetic)
                .circuitMeta(4)
                .output(dust, MagnetoResonatic, 9)
                .EUt(VA[MV])
                .duration(80)
                .buildAndRegister();
    }
}
