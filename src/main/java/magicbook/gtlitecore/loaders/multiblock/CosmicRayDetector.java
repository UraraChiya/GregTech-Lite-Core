package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class CosmicRayDetector {

    public static void init() {

        //  Easy Starlight Liquid recipe
        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .circuitMeta(0)
                .fluidOutputs(StarlightLiquid.getFluid(100))
                .Altitude(100)
                .EUt(VA[UHV])
                .duration(1)
                .buildAndRegister();

        //  Heavy Lepton
        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidOutputs(HeavyLepton.getFluid(40))
                .Altitude(80)
                .EUt((int) V[UHV])
                .duration(1)
                .buildAndRegister();

        //  Algae
        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .notConsumable(FIELD_GENERATOR_UHV)
                .notConsumable(gemExquisite, CelestialCrystal)
                .notConsumable(swarm, Tritanium)
                .circuitMeta(2)
                .output(BARNARDA_C_BASE, 64)
                .fluidOutputs(Blood.getFluid(L / 4))
                .Altitude(100)
                .EUt((int) V[UHV])
                .duration(1)
                .buildAndRegister();

        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .notConsumable(FIELD_GENERATOR_UHV)
                .notConsumable(gemExquisite, CelestialCrystal)
                .notConsumable(swarm, Naquadria)
                .circuitMeta(3)
                .output(PROXIMA_B_BASE, 64)
                .fluidOutputs(Blood.getFluid(L / 4))
                .Altitude(100)
                .EUt((int) V[UHV])
                .duration(1)
                .buildAndRegister();

        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .notConsumable(FIELD_GENERATOR_UHV)
                .notConsumable(gemExquisite, CelestialCrystal)
                .notConsumable(swarm, Orichalcum)
                .circuitMeta(4)
                .output(TAU_CETI_F_BASE, 64)
                .fluidOutputs(Blood.getFluid(L / 4))
                .Altitude(100)
                .EUt((int) V[UHV])
                .duration(1)
                .buildAndRegister();
    }
}
