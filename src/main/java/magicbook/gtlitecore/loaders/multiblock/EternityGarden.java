package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.Neutronium;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.ETERNITY_GARDEN_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.singularity;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class EternityGarden {

    public static void init() {

        ETERNITY_GARDEN_RECIPES.recipeBuilder()
                .input(SUPERSOLID_SPACETIME_CONTINUUM)
                .input(CHARGED_HYPERCUBE)
                .input(FLUID_CORE_T10)
                .input(singularity, Eternity)
                .input(EIGENFOLDED_SPACETIME_MANIFOLD)
                .input(QUANTUM_ANOMALY)
                .input(HIGGS_BOSON)
                .fluidInputs(ZenithDimensionallyTranscendentCatalyst.getFluid(L * 16))
                .fluidInputs(CosmicNeutronium.getFluid(L * 64))
                .fluidInputs(CosmicNeutronium.getFluid(L * 64))
                .fluidInputs(CrystalMatrix.getFluid(L * 256))
                .fluidInputs(Infinity.getFluid(L * 32))
                .fluidInputs(Spacetime.getFluid(L * 16))
                .fluidInputs(Eternity.getFluid(L * 8))
                .output(dust, Hikarium, 64)
                .output(dust, Tairitsium, 64)
                .output(dust, Neutronium, 64)
                .output(dust, TranscendentMetal, 64)
                .output(dust, AstralTitanium, 64)
                .output(dust, CelestialTungsten, 64)
                .output(dust, BlackPlutonium, 64)
                .fluidOutputs(Edenium.getFluid(L * 32))
                .fluidOutputs(Fatalium.getFluid(L * 16))
                .fluidOutputs(Shirabon.getFluid(L * 8))
                .fluidOutputs(Omnium.getFluid(L * 4))
                .fluidOutputs(Universium.getFluid(L * 8))
                .fluidOutputs(Galaxium.getFluid(L * 16))
                .fluidOutputs(Astralium.getFluid(L * 32))
                .EUt((int) V[MAX])
                .duration(200)
                .buildAndRegister();
    }
}
