package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregtech.api.unification.ore.OrePrefix.ring;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.DIMENSIONAL_OSCILLATOR_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class DimensionalOscillator {

    public static void init() {

        //  Manifold Oscillatory Power Cell
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .input(QUANTUM_ANOMALY)
                .input(plate, AstralTitanium)
                .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(L))
                .output(MANIFOLD_OSCILLATORY_POWER_CELL, 16)
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(16000))
                .EUt(VA[UIV])
                .duration(200)
                .buildAndRegister();

        //  Raw Star Matter
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .input(QUANTUM_ANOMALY)
                .input(QCD_PROTECTIVE_PLATING)
                .fluidInputs(RawStarMatter.getFluid(8000))
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(8000))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(16000))
                .EUt(VA[UIV])
                .duration(400)
                .buildAndRegister();

        //  Galaxium
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .notConsumable(ring, Spacetime)
                .fluidInputs(Solarium.getFluid(L * 8))
                .fluidInputs(LunaSilver.getFluid(L * 8))
                .fluidInputs(DimensionallyTranscendentResidue.getFluid(4000))
                .fluidOutputs(Galaxium.getFluid(L * 4))
                .EUt(VA[UXV])
                .duration(20)
                .buildAndRegister();

        //  Hyperdimensional Oscillating Matter
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .input(DIMENSION_GAP)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .output(HYPERDIMENSIONAL_OSCILLATING_MATTER)
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(16000))
                .EUt(VA[UXV])
                .duration(100)
                .buildAndRegister();

        //  Fatalium Plasma -> Fatalium
        //  Fatalium plasma recipe back to fusion reactor recipe
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .notConsumable(plate, Galaxium)
                .fluidInputs(Fatalium.getPlasma(L))
                .fluidInputs(Hypogen.getFluid(L * 4))
                .fluidInputs(DimensionallyTranscendentResidue.getFluid(16000))
                .fluidOutputs(Fatalium.getFluid(L))
                .EUt(VA[OpV])
                .duration(20)
                .buildAndRegister();
    }
}
