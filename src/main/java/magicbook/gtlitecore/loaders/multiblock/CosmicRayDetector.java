package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.Naquadria;
import static gregtech.api.unification.material.Materials.Tritanium;
import static gregtech.api.unification.ore.OrePrefix.gemExquisite;
import static gregtech.common.items.MetaItems.FIELD_GENERATOR_UHV;
import static gregtechfoodoption.GTFOMaterialHandler.Blood;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.COSMIC_RAY_DETECTOR_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class CosmicRayDetector {

    public static void init() {

        //  Easy Starlight Liquid recipe
        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .circuitMeta(0)
                .fluidOutputs(StarlightLiquid.getFluid(100))
                .EUt(VA[UHV])
                .duration(1)
                .altitude(100)
                .buildAndRegister();

        //  Heavy Lepton
        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidOutputs(HeavyLepton.getFluid(40))
                .EUt((int) V[UHV])
                .duration(1)
                .altitude(80)
                .buildAndRegister();

        //  Algae
        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .notConsumable(FIELD_GENERATOR_UHV)
                .notConsumable(gemExquisite, CelestialCrystal)
                .notConsumable(swarm, Tritanium)
                .circuitMeta(2)
                .output(BARNARDA_C_BASE, 64)
                .fluidOutputs(Blood.getFluid(L / 4))
                .EUt((int) V[UHV])
                .duration(1)
                .altitude(100)
                .buildAndRegister();

        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .notConsumable(FIELD_GENERATOR_UHV)
                .notConsumable(gemExquisite, CelestialCrystal)
                .notConsumable(swarm, Naquadria)
                .circuitMeta(3)
                .output(PROXIMA_B_BASE, 64)
                .fluidOutputs(Blood.getFluid(L / 4))
                .EUt((int) V[UHV])
                .duration(1)
                .altitude(100)
                .buildAndRegister();

        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .notConsumable(FIELD_GENERATOR_UHV)
                .notConsumable(gemExquisite, CelestialCrystal)
                .notConsumable(swarm, Orichalcum)
                .circuitMeta(4)
                .output(TAU_CETI_F_BASE, 64)
                .fluidOutputs(Blood.getFluid(L / 4))
                .EUt((int) V[UHV])
                .duration(1)
                .altitude(100)
                .buildAndRegister();
    }
}
