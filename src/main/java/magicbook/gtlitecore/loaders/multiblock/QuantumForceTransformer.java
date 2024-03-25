package magicbook.gtlitecore.loaders.multiblock;

import static gregicality.multiblocks.api.unification.GCYMMaterials.TitaniumCarbide;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.QUANTUM_FORCE_TRANSFORMER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class QuantumForceTransformer {

    public static void init() {

        //  T1 Rubber recipe
        //  Use some carbon, hydrogen, oxygen and chlorine, make all vanilla rubbers
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .notConsumable(swarm, Graphene)
                .input(dust, Carbon, 64)
                .fluidInputs(Chlorine.getFluid(16000))
                .fluidInputs(Hydrogen.getFluid(16000))
                .fluidInputs(Oxygen.getFluid(16000))
                .fluidOutputs(SiliconeRubber.getFluid(9216))
                .fluidOutputs(StyreneButadieneRubber.getFluid(9216))
                .fluidOutputs(PolyphenyleneSulfide.getFluid(18432))
                .fluidOutputs(Rubber.getFluid(36864))
                .EUt(VA[ZPM])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        //  T2 Rubber recipe
        //  New rubbers! but need to use advanced swarm!
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(11)
                .notConsumable(swarm, Fullerene)
                .input(dust, Carbon, 64)
                .fluidInputs(Chlorine.getFluid(16000))
                .fluidInputs(Hydrogen.getFluid(16000))
                .fluidInputs(Oxygen.getFluid(16000))
                .fluidOutputs(NitrileButadieneRubber.getFluid(9216))
                .fluidOutputs(PolyPhosphonitrileFluoroRubber.getFluid(9216))
                .fluidOutputs(Polyetheretherketone.getFluid(18432))
                .fluidOutputs(Rubber.getFluid(36864))
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(2)
                .buildAndRegister();

        //  T1 Plastic recipe
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Carbon)
                .fluidInputs(Chlorine.getFluid(16000))
                .fluidInputs(Hydrogen.getFluid(16000))
                .fluidInputs(Oxygen.getFluid(16000))
                .fluidInputs(Fluorine.getFluid(16000))
                .fluidOutputs(Polyethylene.getFluid(36864))
                .fluidOutputs(PolyvinylChloride.getFluid(18432))
                .fluidOutputs(Polystyrene.getFluid(9216))
                .fluidOutputs(Polytetrafluoroethylene.getFluid(18432))
                .fluidOutputs(Epoxy.getFluid(9216))
                .fluidOutputs(Polybenzimidazole.getFluid(9216))
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(2)
                .buildAndRegister();

        //  T2 Plastic recipe
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, CarbonNanotube)
                .fluidInputs(Chlorine.getFluid(16000))
                .fluidInputs(Hydrogen.getFluid(16000))
                .fluidInputs(Oxygen.getFluid(16000))
                .fluidInputs(Fluorine.getFluid(16000))
                .fluidOutputs(Epoxy.getFluid(36864))
                .fluidOutputs(Polybenzimidazole.getFluid(18432))
                .fluidOutputs(PolystyreneSulfonate.getFluid(9216))
                .fluidOutputs(FluorinatedEthylenePropylene.getFluid(18432))
                .fluidOutputs(Zylon.getFluid(9216))
                .fluidOutputs(Kevlar.getFluid(9216))
                .EUt(VA[UHV])
                .duration(400)
                .CasingTier(3)
                .buildAndRegister();

        //  Platinum group
        //  hmm... why not use isa mill?
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Platinum)
                .input(dust, PlatinumGroupSludge, 64)
                .output(dust, Platinum, 64)
                .output(dust, Palladium, 64)
                .output(dust, Iridium, 64)
                .output(dust, Osmium, 64)
                .output(dust, Rhodium, 64)
                .output(dust, Ruthenium, 64)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(2)
                .buildAndRegister();

        //  Thorium-Uranium group
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .notConsumable(swarm, Europium)
                .input(dust, Thorium, 64)
                .output(dust, Uranium235, 64)
                .output(dust, Uranium238, 64)
                .output(dust, Plutonium239, 64)
                .output(dust, Plutonium241, 64)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(2)
                .buildAndRegister();

        //  Titanium-Tungsten-Indium Group
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .notConsumable(swarm, Titanium)
                .input(dust, Scheelite, 16)
                .input(dust, Bauxite, 32)
                .input(dust, Lead, 16)
                .output(dust, Titanium, 64)
                .output(dust, TungstenSteel, 64)
                .output(dust, TungstenCarbide, 64)
                .output(dust, Indium, 64)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(2)
                .buildAndRegister();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .notConsumable(swarm, Tungsten)
                .input(dust, Tungstate, 16)
                .input(dust, Rutile, 32)
                .input(dust, Antimony, 16)
                .output(dust, Tungsten, 64)
                .output(dust, NiobiumTitanium, 64)
                .output(dust, TitaniumCarbide, 64)
                .output(dust, Indium, 64)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(2)
                .buildAndRegister();

        //  Rare Earth Group
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .notConsumable(swarm, Neodymium)
                .input(dust, Bastnasite, 64)
                .output(dust, Lanthanum, 64)
                .output(dust, Cerium, 64)
                .output(dust, Praseodymium, 64)
                .output(dust, Neodymium, 64)
                .output(dust, Promethium, 64)
                .output(dust, Samarium, 64)
                .EUt(VA[UHV])
                .duration(400)
                .CasingTier(3)
                .buildAndRegister();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .notConsumable(swarm, Americium)
                .input(dust, Monazite, 64)
                .output(dust, Europium, 64)
                .output(dust, Gadolinium, 64)
                .output(dust, Terbium, 64)
                .output(dust, Dysprosium, 64)
                .output(dust, Holmium, 64)
                .output(dust, Erbium, 64)
                .EUt(VA[UHV])
                .duration(400)
                .CasingTier(3)
                .buildAndRegister();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(9)
                .notConsumable(swarm, Dubnium)
                .input(dust, Bastnasite, 32)
                .input(dust, Monazite, 32)
                .output(dust, Thulium, 64)
                .output(dust, Ytterbium, 64)
                .output(dust, Lutetium, 64)
                .output(dust, Zirconium, 64)
                .output(dust, Hafnium, 64)
                .output(dust, Gallium, 64)
                .EUt(VA[UHV])
                .duration(400)
                .CasingTier(3)
                .buildAndRegister();

        //  Naquadah group
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(10)
                .notConsumable(swarm, Naquadah)
                .input(dust, Naquadah, 64)
                .fluidInputs(Oxygen.getFluid(16000))
                .fluidInputs(Fluorine.getFluid(64000))
                .fluidInputs(Hydrogen.getFluid(64000))
                .output(dust, NaquadahEnriched, 64)
                .output(dust ,Naquadria, 64)
                .output(dust, Trinium, 64)
                .output(dust, Taranium, 64)
                .output(dust, Orichalcum, 64)
                .output(dust, Adamantium, 64)
                .EUt(VA[UEV])
                .duration(400)
                .CasingTier(4)
                .buildAndRegister();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(20)
                .notConsumable(swarm, NaquadahEnriched)
                .input(dust, Naquadah, 64)
                .fluidInputs(Oxygen.getFluid(16000))
                .fluidInputs(Helium.getFluid(16000))
                .fluidInputs(Fluorine.getFluid(64000))
                .fluidInputs(Hydrogen.getFluid(64000))
                .output(dust, Orichalcum, 64)
                .output(dust, Adamantium, 64)
                .output(dust, Vibranium, 64)
                .output(dust, Taranium, 64)
                .output(dust, AstralTitanium, 64)
                .output(dust, CelestialTungsten, 64)
                .EUt(VA[UIV])
                .duration(400)
                .CasingTier(5)
                .buildAndRegister();

        //  Biological Items
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(11)
                .notConsumable(swarm, Naquadria)
                .input(dust, Meat, 64)
                .input(dust, Calcium, 16)
                .input(dust, Carbon, 16)
                .fluidInputs(Hydrogen.getFluid(16000))
                .fluidInputs(Nitrogen.getFluid(16000))
                .fluidInputs(Oxygen.getFluid(16000))
                .output(STEM_CELLS, 64)
                .output(STEM_CELLS, 64)
                .output(STEM_CELLS, 64)
                .output(STEM_CELLS, 64)
                .output(STEM_CELLS, 64)
                .output(STEM_CELLS, 64)
                .fluidOutputs(SterileGrowthMedium.getFluid(64000))
                .fluidOutputs(RawGrowthMedium.getFluid(64000))
                .fluidOutputs(BZMedium.getFluid(16000))
                .fluidOutputs(Biotin.getFluid(32000))
                .fluidOutputs(VitaminA.getFluid(16000))
                .fluidOutputs(LinoleicAcid.getFluid(64000))
                .EUt(VA[UEV])
                .duration(400)
                .CasingTier(4)
                .buildAndRegister();

        //  Adhesives
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(12)
                .notConsumable(swarm, Tin)
                .input(dust, Carbon, 64)
                .fluidInputs(Hydrogen.getFluid(16000))
                .fluidInputs(Oxygen.getFluid(16000))
                .fluidOutputs(Glue.getFluid(64000))
                .fluidOutputs(Tin.getFluid(6144))
                .fluidOutputs(Lead.getFluid(6144))
                .fluidOutputs(Antimony.getFluid(6144))
                .fluidOutputs(SolderingAlloy.getFluid(18432))
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(2)
                .buildAndRegister();

        //  Others, free circuit meta: 13-19

        //  Higgs Bosons
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(20)
                .notConsumable(swarm, Tritanium)
                .fluidInputs(Americium.getFluid(30000))
                .fluidInputs(Helium.getPlasma(30000))
                .fluidInputs(Oxygen.getPlasma(30000))
                .fluidInputs(CelestialTungsten.getPlasma(30000))
                .fluidOutputs(HiggsBosons.getFluid(3000))
                .EUt(VA[UEV])
                .duration(400)
                .CasingTier(4)
                .buildAndRegister();

        //  Instantons
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(21)
                .notConsumable(swarm, Orichalcum)
                .fluidInputs(Duranium.getFluid(30000))
                .fluidInputs(Argon.getPlasma(30000))
                .fluidInputs(Nitrogen.getPlasma(30000))
                .fluidInputs(AstralTitanium.getPlasma(30000))
                .fluidOutputs(Instantons.getFluid(3000))
                .EUt(VA[UEV])
                .duration(400)
                .CasingTier(4)
                .buildAndRegister();

        //  Hypercube
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(22)
                .notConsumable(QUANTUM_ANOMALY)
                .input(CRUDE_HYPERCUBE)
                .fluidInputs(StarCoreMatter.getPlasma(1000))
                .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(1000))
                .fluidInputs(QuantumchromodynamicallyConfinedMatter.getFluid(1000))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(1000))
                .fluidInputs(CosmicComputingMixture.getFluid(1000))
                .fluidInputs(CosmicNeutronium.getFluid(1000))
                .output(CHARGED_HYPERCUBE)
                .fluidOutputs(AstralTitanium.getPlasma(250))
                .fluidOutputs(CelestialTungsten.getPlasma(250))
                .fluidOutputs(Tin.getPlasma(250))
                .fluidOutputs(Iron.getPlasma(250))
                .fluidOutputs(Nickel.getPlasma(250))
                .fluidOutputs(Americium.getPlasma(250))
                .EUt(VA[UXV])
                .duration(20)
                .CasingTier(6)
                .buildAndRegister();

        //  Temporal Fluid
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(23)
                .notConsumable(QUANTUM_ANOMALY)
                .notConsumable(EMITTER_UEV)
                .notConsumable(SENSOR_UEV)
                .fluidInputs(LiquidAir.getFluid(120000))
                .fluidInputs(LiquidNetherAir.getFluid(120000))
                .fluidInputs(LiquidEnderAir.getFluid(120000))
                .fluidInputs(StarlightLiquid.getFluid(1000))
                .fluidInputs(Bedrock.getFluid(1000))
                .fluidInputs(DragonBlood.getFluid(1000))
                .fluidOutputs(TemporalFluid.getFluid(6000))
                .EUt(VA[UIV])
                .duration(120)
                .CasingTier(5)
                .buildAndRegister();

        //  Quantum Anomaly
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .circuitMeta(25)
                .fluidInputs(DimensionallyTranscendentResidue.getFluid(1000))
                .chancedOutput(QUANTUM_ANOMALY, 5000, 0)
                .EUt(VA[UIV])
                .duration(200)
                .CasingTier(5)
                .buildAndRegister();

    }
}
