package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.fluids.store.FluidStorageKeys;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class PlasmaCondenser {

    public static void init() {

        //  Adamantium
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(Adamantium.getPlasma(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 8000))
                .circuitMeta(1)
                .fluidOutputs(Adamantium.getFluid(L))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 8000))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(Adamantium.getPlasma(L))
                .fluidInputs(GelidCryotheum.getFluid(4000))
                .circuitMeta(1)
                .fluidOutputs(Adamantium.getFluid(L))
                .fluidOutputs(Ice.getFluid(4000))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(Adamantium.getPlasma(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 8000))
                .circuitMeta(10)
                .output(ingot, Adamantium)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 8000))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(Adamantium.getPlasma(L))
                .fluidInputs(GelidCryotheum.getFluid(4000))
                .circuitMeta(10)
                .output(ingot, Adamantium)
                .fluidOutputs(Ice.getFluid(4000))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  Vibranium
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(Vibranium.getPlasma(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 12000))
                .circuitMeta(1)
                .fluidOutputs(Vibranium.getFluid(L))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 12000))
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(Vibranium.getPlasma(L))
                .fluidInputs(GelidCryotheum.getFluid(6000))
                .circuitMeta(1)
                .fluidOutputs(Vibranium.getFluid(L))
                .fluidOutputs(Ice.getFluid(6000))
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(Vibranium.getPlasma(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 12000))
                .circuitMeta(10)
                .output(ingot, Vibranium)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 12000))
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(Vibranium.getPlasma(L))
                .fluidInputs(GelidCryotheum.getFluid(6000))
                .circuitMeta(10)
                .output(ingot, Vibranium)
                .fluidOutputs(Ice.getFluid(6000))
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        //  Mithril
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(Mithril.getPlasma(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 12000))
                .circuitMeta(1)
                .fluidOutputs(Mithril.getFluid(L))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 12000))
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(Mithril.getPlasma(L))
                .fluidInputs(GelidCryotheum.getFluid(6000))
                .circuitMeta(1)
                .fluidOutputs(Mithril.getFluid(L))
                .fluidOutputs(Ice.getFluid(6000))
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(Mithril.getPlasma(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 12000))
                .circuitMeta(10)
                .output(ingot, Mithril)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 12000))
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(Mithril.getPlasma(L))
                .fluidInputs(GelidCryotheum.getFluid(6000))
                .circuitMeta(10)
                .output(ingot, Mithril)
                .fluidOutputs(Ice.getFluid(6000))
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        //  Hypogen
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(Hypogen.getPlasma(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 16000))
                .circuitMeta(1)
                .fluidOutputs(Hypogen.getFluid(L))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 16000))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(Hypogen.getPlasma(L))
                .fluidInputs(GelidCryotheum.getFluid(8000))
                .circuitMeta(1)
                .fluidOutputs(Hypogen.getFluid(L))
                .fluidOutputs(Ice.getFluid(8000))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(Hypogen.getPlasma(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 16000))
                .circuitMeta(10)
                .output(ingot, Hypogen)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 16000))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(Hypogen.getPlasma(L))
                .fluidInputs(GelidCryotheum.getFluid(8000))
                .circuitMeta(10)
                .output(ingot, Hypogen)
                .fluidOutputs(Ice.getFluid(8000))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

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

        //  Heavy Quark Degenerate Matter
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(HeavyQuarkDegenerateMatter.getPlasma(1000))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 24000))
                .circuitMeta(1)
                .fluidOutputs(HeavyQuarkDegenerateMatter.getFluid(1000))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 24000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(HeavyQuarkDegenerateMatter.getPlasma(1000))
                .fluidInputs(GelidCryotheum.getFluid(12000))
                .circuitMeta(1)
                .fluidOutputs(HeavyQuarkDegenerateMatter.getFluid(1000))
                .fluidOutputs(Ice.getFluid(12000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(HeavyQuarkDegenerateMatter.getPlasma(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 24000))
                .circuitMeta(10)
                .output(ingot, HeavyQuarkDegenerateMatter)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 24000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(HeavyQuarkDegenerateMatter.getPlasma(L))
                .fluidInputs(GelidCryotheum.getFluid(12000))
                .circuitMeta(10)
                .output(ingot, HeavyQuarkDegenerateMatter)
                .fluidOutputs(Ice.getFluid(12000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();
      
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
                .circuitMeta(10)
                .output(ingot, QuantumchromodynamicallyConfinedMatter)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 24000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(HighEnergyQuarkGluonPlasma.getPlasma(L))
                .fluidInputs(GelidCryotheum.getFluid(12000))
                .circuitMeta(10)
                .output(ingot, QuantumchromodynamicallyConfinedMatter)
                .fluidOutputs(Ice.getFluid(12000))
                .EUt(VA[UIV])
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

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .input(COSMIC_NEUTRON_PLASMA_CONTAINMENT_CELL)
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 32000))
                .circuitMeta(10)
                .output(ingot, CosmicNeutronium)
                .output(EXTREMELY_DURABLE_PLASMA_CONTAINMENT_CELL)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 32000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .input(COSMIC_NEUTRON_PLASMA_CONTAINMENT_CELL)
                .fluidInputs(GelidCryotheum.getFluid(16000))
                .circuitMeta(10)
                .output(ingot, CosmicNeutronium)
                .output(EXTREMELY_DURABLE_PLASMA_CONTAINMENT_CELL)
                .fluidOutputs(Ice.getFluid(16000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

    }
}
