package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.unification.material.Material;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.Helium;
import static gregtech.api.unification.material.Materials.Ice;
import static gregtech.api.unification.ore.OrePrefix.ingot;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_INGOT;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_PLATE;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.PLASMA_CONDENSER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class PlasmaCondenser {

    public static void init() {
        Materials();
        PlasmaContainmentCells();
    }

    private static void Materials() {
        createPCRecipe(Adamantium, L, 8000, VA[UV], 100, true);
        createPCRecipe(Vibranium, L, 12000, VA[UHV], 150, true);
        createPCRecipe(Mithril, L, 12000, VA[UHV], 150, true);
        createPCRecipe(AstralTitanium, L, 14000, VA[UEV], 200, true);
        createPCRecipe(CelestialTungsten, L, 14000, VA[UEV], 200, true);
        createPCRecipe(HeavyQuarkDegenerateMatter, L, 16000, VA[UIV], 250, true);

        //  Quantumchromodynamically Confined Matter
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(HighEnergyQuarkGluonPlasma.getPlasma(1000))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 24000))
                .circuitMeta(1)
                .fluidOutputs(QuantumchromodynamicallyConfinedMatter.getFluid(1000))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 24000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(HighEnergyQuarkGluonPlasma.getPlasma(1000))
                .fluidInputs(GelidCryotheum.getFluid(12000))
                .circuitMeta(1)
                .fluidOutputs(QuantumchromodynamicallyConfinedMatter.getFluid(1000))
                .fluidOutputs(Ice.getFluid(12000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(HighEnergyQuarkGluonPlasma.getPlasma(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 24000))
                .circuitMeta(2)
                .output(ingot, QuantumchromodynamicallyConfinedMatter)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 24000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(HighEnergyQuarkGluonPlasma.getPlasma(L))
                .fluidInputs(GelidCryotheum.getFluid(12000))
                .circuitMeta(2)
                .output(ingot, QuantumchromodynamicallyConfinedMatter)
                .fluidOutputs(Ice.getFluid(12000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_PLATE)
                .fluidInputs(HighEnergyQuarkGluonPlasma.getPlasma(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 24000))
                .circuitMeta(3)
                .output(plate, QuantumchromodynamicallyConfinedMatter)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 24000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_PLATE)
                .fluidInputs(HighEnergyQuarkGluonPlasma.getPlasma(L))
                .fluidInputs(GelidCryotheum.getFluid(12000))
                .circuitMeta(3)
                .output(plate, QuantumchromodynamicallyConfinedMatter)
                .fluidOutputs(Ice.getFluid(12000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        createPCRecipe(Hypogen, L, 18000, VA[UXV], 300, true);
    }

    private static void PlasmaContainmentCells() {

        //  Degenerate Rhenium
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .input(RHENIUM_PLASMA_CONTAINMENT_CELL)
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 16000))
                .circuitMeta(1)
                .output(PLASMA_CONTAINMENT_CELL)
                .fluidOutputs(DegenerateRhenium.getFluid(1000))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 16000))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .input(RHENIUM_PLASMA_CONTAINMENT_CELL)
                .fluidInputs(GelidCryotheum.getFluid(8000))
                .circuitMeta(1)
                .output(PLASMA_CONTAINMENT_CELL)
                .fluidOutputs(DegenerateRhenium.getFluid(1000))
                .fluidOutputs(Ice.getFluid(8000))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        //  Cosmic Neutronium
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .input(COSMIC_NEUTRON_PLASMA_CONTAINMENT_CELL)
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 32000))
                .circuitMeta(1)
                .output(EXTREMELY_DURABLE_PLASMA_CONTAINMENT_CELL)
                .fluidOutputs(CosmicNeutronium.getFluid(1000))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 32000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .input(COSMIC_NEUTRON_PLASMA_CONTAINMENT_CELL)
                .fluidInputs(GelidCryotheum.getFluid(16000))
                .circuitMeta(1)
                .output(EXTREMELY_DURABLE_PLASMA_CONTAINMENT_CELL)
                .fluidOutputs(CosmicNeutronium.getFluid(1000))
                .fluidOutputs(Ice.getFluid(16000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        //  Cosmic Fabric
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .input(COSMIC_FABRIC_PLASMA_CONTAINMENT_CELL)
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 64000))
                .circuitMeta(1)
                .output(TIME_DILATION_CONTAINMENT_UNIT)
                .fluidOutputs(CosmicFabric.getFluid(1000))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 64000))
                .EUt(VA[UXV])
                .duration(20)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .input(COSMIC_FABRIC_PLASMA_CONTAINMENT_CELL)
                .fluidInputs(GelidCryotheum.getFluid(32000))
                .circuitMeta(1)
                .output(TIME_DILATION_CONTAINMENT_UNIT)
                .fluidOutputs(CosmicFabric.getFluid(1000))
                .fluidOutputs(Ice.getFluid(32000))
                .EUt(VA[UXV])
                .duration(20)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .input(COSMIC_FABRIC_PLASMA_CONTAINMENT_CELL)
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 64000))
                .circuitMeta(2)
                .output(ingot, CosmicFabric)
                .output(TIME_DILATION_CONTAINMENT_UNIT)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 64000))
                .EUt(VA[UXV])
                .duration(20)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .input(COSMIC_FABRIC_PLASMA_CONTAINMENT_CELL)
                .fluidInputs(GelidCryotheum.getFluid(32000))
                .circuitMeta(2)
                .output(ingot, CosmicFabric)
                .output(TIME_DILATION_CONTAINMENT_UNIT)
                .fluidOutputs(Ice.getFluid(32000))
                .EUt(VA[UXV])
                .duration(20)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_PLATE)
                .input(COSMIC_FABRIC_PLASMA_CONTAINMENT_CELL)
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 64000))
                .circuitMeta(3)
                .output(plate, CosmicFabric)
                .output(TIME_DILATION_CONTAINMENT_UNIT)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 64000))
                .EUt(VA[UXV])
                .duration(20)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_PLATE)
                .input(COSMIC_FABRIC_PLASMA_CONTAINMENT_CELL)
                .fluidInputs(GelidCryotheum.getFluid(32000))
                .circuitMeta(3)
                .output(plate, CosmicFabric)
                .output(TIME_DILATION_CONTAINMENT_UNIT)
                .fluidOutputs(Ice.getFluid(32000))
                .EUt(VA[UXV])
                .duration(20)
                .buildAndRegister();

    }

    /**
     * @param input Input material
     * @param inputAmount Input material amount
     * @param coolantAmount Coolant Amoun (Helium and Gelid Cryotheum)
     * @param voltage Recipe voltage
     * @param duration Recipe duration
     * @param hasIngot If input material has ingot property, then generate recipes about ingot.
     */
    public static void createPCRecipe(Material input,
                                      int inputAmount,
                                      int coolantAmount,
                                      int voltage,
                                      int duration,
                                      boolean hasIngot) {

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(input.getPlasma(inputAmount))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, coolantAmount))
                .circuitMeta(1)
                .fluidOutputs(input.getFluid(inputAmount))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, coolantAmount))
                .EUt(voltage)
                .duration(duration)
                .buildAndRegister();


        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(input.getPlasma(inputAmount))
                .fluidInputs(GelidCryotheum.getFluid(coolantAmount / 2))
                .circuitMeta(1)
                .fluidOutputs(input.getFluid(inputAmount))
                .fluidOutputs(Ice.getFluid(coolantAmount / 2))
                .EUt(voltage)
                .duration(duration)
                .buildAndRegister();

        if (hasIngot) {
            //  Ingot
            PLASMA_CONDENSER_RECIPES.recipeBuilder()
                    .notConsumable(SHAPE_MOLD_INGOT)
                    .fluidInputs(input.getPlasma(inputAmount))
                    .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, coolantAmount))
                    .circuitMeta(2)
                    .output(ingot, input)
                    .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, coolantAmount))
                    .EUt(voltage)
                    .duration(duration)
                    .buildAndRegister();

            PLASMA_CONDENSER_RECIPES.recipeBuilder()
                    .notConsumable(SHAPE_MOLD_INGOT)
                    .fluidInputs(input.getPlasma(inputAmount))
                    .fluidInputs(GelidCryotheum.getFluid(coolantAmount / 2))
                    .circuitMeta(2)
                    .output(ingot, input)
                    .fluidOutputs(Ice.getFluid(coolantAmount / 2))
                    .EUt(voltage)
                    .duration(duration)
                    .buildAndRegister();

            //  Plate
            PLASMA_CONDENSER_RECIPES.recipeBuilder()
                    .notConsumable(SHAPE_MOLD_PLATE)
                    .fluidInputs(input.getPlasma(inputAmount))
                    .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, coolantAmount))
                    .circuitMeta(3)
                    .output(plate, input)
                    .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, coolantAmount))
                    .EUt(voltage)
                    .duration(duration)
                    .buildAndRegister();

            PLASMA_CONDENSER_RECIPES.recipeBuilder()
                    .notConsumable(SHAPE_MOLD_PLATE)
                    .fluidInputs(input.getPlasma(inputAmount))
                    .fluidInputs(GelidCryotheum.getFluid(coolantAmount / 2))
                    .circuitMeta(3)
                    .output(plate, input)
                    .fluidOutputs(Ice.getFluid(coolantAmount / 2))
                    .EUt(voltage)
                    .duration(duration)
                    .buildAndRegister();
        }
    }
}
