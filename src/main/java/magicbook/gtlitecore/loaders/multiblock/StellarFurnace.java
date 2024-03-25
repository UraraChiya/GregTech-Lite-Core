package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import magicbook.gtlitecore.common.blocks.BlockExplosive;
import magicbook.gtlitecore.common.blocks.BlockTransparentCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;

import java.math.BigInteger;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.STELLAR_FURNACE_RECIPES;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class StellarFurnace {

    public static void init() {
        BasicComponent();
        Recipes();
    }

    private static void BasicComponent() {

        //  Plasma Containment Cell
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(FIELD_GENERATOR_UV)
                .input(stickLong, NaquadahAlloy)
                .input(plate, Osmiridium, 4)
                .inputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.PMMA_GLASS, 2))
                .fluidInputs(TinAlloy.getFluid(L * 2))
                .output(PLASMA_CONTAINMENT_CELL)
                .EUt(VA[ZPM])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Extremely Durable Plasma Containment Cell
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(FIELD_GENERATOR_UEV)
                .input(stickLong, Tritanium)
                .input(QCD_PROTECTIVE_PLATING, 4)
                .inputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.INFINITY_GLASS, 2))
                .fluidInputs(TinAlloy.getFluid(L * 2))
                .output(EXTREMELY_DURABLE_PLASMA_CONTAINMENT_CELL)
                .EUt(VA[UV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Time Dilation Containment Cell
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(FIELD_GENERATOR_UIV)
                .input(stickLong, Hypogen)
                .input(plate, CosmicNeutronium, 4)
                .inputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.QUANTUM_GLASS, 2))
                .fluidInputs(TinAlloy.getFluid(L * 2))
                .output(TIME_DILATION_CONTAINMENT_UNIT)
                .EUt(VA[UHV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Separation Electromagnet
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETRON)
                .input(plate, NiobiumNitride, 4)
                .input(stickLong, VanadiumGallium)
                .input(foil, Polybenzimidazole, 8)
                .input(wireFine, YttriumBariumCuprate, 16)
                .fluidInputs(BlackSteel.getFluid(L * 2))
                .output(SEPARATION_ELECTROMAGNET)
                .EUt(VA[ZPM])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

    }

    private static void Recipes() {
        DegenerateRheniumChain();
        CosmicComputingMixtureChain();
        HeavyQuarkDegenerateMatterChain();
        CosmicNeutroniumChain();
        QuantumchromodynamicallyConfinedMatterChain();
        DwarfMattersChain();
        CosmicFabricChain();
        SupracausalCircuitComponents();
        HypercubeChain();
        HikariumChain();
        ShirabonEternityChain();
        UniversiumChain();
        EdeniumChain();
    }

    private static void DegenerateRheniumChain() {

        //  Rhenium -> Degenerate Rhenium
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(ingot, Rhenium)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.NAQUADRIA_CHARGE))
                .fluidOutputs(DegenerateRhenium.getPlasma(1000))
                .EUt(VA[UIV])
                .duration(20)
                .temperature(BigInteger.valueOf(3932160))
                .buildAndRegister();

        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(plateDense, Rhenium)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.NAQUADRIA_CHARGE))
                .fluidOutputs(DegenerateRhenium.getPlasma(10000))
                .EUt(VA[UXV])
                .duration(20)
                .temperature(BigInteger.valueOf(3932160 * 9)) // for 9x material input
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(PLASMA_CONTAINMENT_CELL)
                .fluidInputs(DegenerateRhenium.getPlasma(1000))
                .output(RHENIUM_PLASMA_CONTAINMENT_CELL)
                .EUt(VA[LuV])
                .duration(20)
                .buildAndRegister();
    }

    private static void CosmicComputingMixtureChain() {

        //  Quark Gluon Plasma
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(plate, DegenerateRhenium)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.LEPTONIC_CHARGE))
                .fluidOutputs(QuarkGluonPlasma.getPlasma(1000))
                .EUt(VA[UIV])
                .duration(60)
                .temperature(BigInteger.valueOf(19668800))
                .buildAndRegister();

        //  Quark Gluon Plasma -> Heavy Quarks + Light Quarks + Gluons
        CENTRIFUGE_RECIPES.recipeBuilder()
                .notConsumable(SEPARATION_ELECTROMAGNET)
                .fluidInputs(QuarkGluonPlasma.getPlasma(1000))
                .fluidOutputs(HeavyQuarks.getFluid(200))
                .fluidOutputs(LightQuarks.getFluid(600))
                .fluidOutputs(Gluons.getFluid(200))
                .EUt(VA[UEV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cosmic Computing Mixture
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .fluidInputs(HeavyLepton.getFluid(32000))
                .fluidInputs(HeavyQuarks.getFluid(8000))
                .fluidInputs(Gluons.getFluid(8000))
                .fluidInputs(Instantons.getFluid(4000))
                .fluidInputs(TemporalFluid.getFluid(4000))
                .fluidInputs(HiggsBosons.getFluid(4000))
                .fluidOutputs(CosmicComputingMixture.getFluid(60000))
                .EUt(VA[UIV])
                .duration(1200)
                .temperature(BigInteger.valueOf(988436750))
                .buildAndRegister();
    }

    private static void HeavyQuarkDegenerateMatterChain() {

        //  Heavy Quark Enriched Mixture
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(LightQuarks.getFluid(1000))
                .fluidInputs(HeavyQuarks.getFluid(3000))
                .fluidOutputs(HeavyQuarkEnrichedMixture.getFluid(1000))
                .EUt(VA[UIV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Deuterium-Superheavy Mixture
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.LEPTONIC_CHARGE))
                .fluidInputs(Deuterium.getFluid(2000))
                .fluidInputs(MetastableHassium.getFluid(L))
                .fluidInputs(MetastableFlerovium.getFluid(L))
                .fluidInputs(MetastableOganesson.getFluid(L))
                .fluidOutputs(DeuteriumSuperheavyMixture.getFluid(2592))
                .EUt(VA[UIV])
                .duration(100)
                .temperature(BigInteger.valueOf(8257530))
                .buildAndRegister();

        //  Heavy Quark Degenerate Matter
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.LEPTONIC_CHARGE))
                .fluidInputs(DeuteriumSuperheavyMixture.getFluid(1000))
                .fluidInputs(HeavyQuarkEnrichedMixture.getFluid(1000))
                .fluidOutputs(HeavyQuarkDegenerateMatter.getPlasma(1000))
                .EUt(VA[UIV])
                .duration(20)
                .temperature(BigInteger.valueOf((13887430)))
                .buildAndRegister();
    }

    private static void CosmicNeutroniumChain() {

        //  Step 1: Neutron Plasma Containment Cell
        //  Pay attention, Neutron Plasma Containment Cell is not used to product Neutronium.
        //  This item is just a material for Cosmic Neutronium processing.
        CANNER_RECIPES.recipeBuilder()
                .input(PLASMA_CONTAINMENT_CELL)
                .fluidInputs(Neutronium.getFluid(1000))
                .output(NEUTRON_PLASMA_CONTAINMENT_CELL)
                .EUt(VA[ZPM])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Step 2: Dense Neutron Plasma
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(NEUTRON_PLASMA_CONTAINMENT_CELL)
                .input(ingot, HeavyQuarkDegenerateMatter)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .fluidInputs(HeavyLepton.getFluid(6000))
                .fluidInputs(Gluons.getFluid(6000))
                .fluidInputs(Periodicium.getFluid(2736))
                .output(PLASMA_CONTAINMENT_CELL)
                .fluidOutputs(DenseNeutronPlasma.getPlasma(6000))
                .EUt(VA[UIV])
                .duration(20)
                .temperature(BigInteger.valueOf(603486550))
                .buildAndRegister();

        //  Step3: Cosmic Neutron Plasma

        //  Canning Dense Neutron Plasma with containment cell, and prepare it to stellar furnace.
        CANNER_RECIPES.recipeBuilder()
                .input(EXTREMELY_DURABLE_PLASMA_CONTAINMENT_CELL)
                .fluidInputs(DenseNeutronPlasma.getPlasma(1000))
                .output(DENSE_NEUTRON_PLASMA_CONTAINMENT_CELL)
                .EUt(VA[UEV])
                .duration(90)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  2 Dense Neutron Plasma Containment Cell -> 1 Cosmic Neutron Plasma Cell (and return empty containment cell)
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(DENSE_NEUTRON_PLASMA_CONTAINMENT_CELL, 2)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .fluidInputs(AstralTitanium.getPlasma(6000))
                .fluidInputs(CelestialTungsten.getPlasma(6000))
                .output(COSMIC_NEUTRON_PLASMA_CONTAINMENT_CELL)
                .output(EXTREMELY_DURABLE_PLASMA_CONTAINMENT_CELL)
                .EUt(VA[UIV])
                .duration(10)
                .temperature(BigInteger.valueOf(886544780))
                .buildAndRegister();

        //  back to Plasma condenser recipe
    }

    private static void QuantumchromodynamicallyConfinedMatterChain() {

        //  Heavy Quark Degenerate Matter -> High Energy Quark Gluon Plasma
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(plate, HeavyQuarkDegenerateMatter)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .fluidOutputs(HighEnergyQuarkGluonPlasma.getPlasma(L))
                .EUt(VA[UIV])
                .duration(200)
                .temperature(BigInteger.valueOf(24479620))
                .buildAndRegister();

        //  back to plasma condenser recipe

        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(plate, QuantumchromodynamicallyConfinedMatter)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .output(QCD_PROTECTIVE_PLATING)
                .EUt(VA[UIV])
                .duration(10)
                .temperature(BigInteger.valueOf(67054330))
                .buildAndRegister();
    }

    private static void DwarfMattersChain() {

        //  From Space Elevator Recipes to Stellar Furnace Recipes
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .fluidInputs(StarCoreMatter.getPlasma(32000))
                .fluidOutputs(BlackDwarfMatter.getFluid(8000))
                .fluidOutputs(WhiteDwarfMatter.getFluid(8000))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(16000))
                .EUt(VA[UXV])
                .duration(20)
                .temperature(BigInteger.valueOf(104857020))
                .buildAndRegister();
    }

    private static void CosmicFabricChain() {

        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(COSMIC_FABRIC)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .fluidOutputs(CosmicFabric.getPlasma(1000))
                .EUt(VA[UXV])
                .duration(20)
                .temperature(BigInteger.valueOf(993378960))
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(TIME_DILATION_CONTAINMENT_UNIT)
                .fluidInputs(CosmicFabric.getPlasma(1000))
                .output(COSMIC_FABRIC_PLASMA_CONTAINMENT_CELL)
                .EUt(VA[UXV])
                .duration(20)
                .buildAndRegister();

        //  back to Plasma Condenser recipe
    }

    private static void SupracausalCircuitComponents() {

        //  Neutronium -> Neutronium Sphere
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_BALL)
                .fluidInputs(Neutronium.getFluid(1000))
                .output(NEUTRONIUM_SPHERE, 4)
                .EUt(VA[UXV])
                .duration(5)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Neutronium Sphere -> Triplet Neutronium Sphere
        POLARIZER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_SPHERE)
                .output(TRIPLET_NEUTRONIUM_SPHERE)
                .EUt(VA[UXV])
                .duration(10)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Triplet Neutronium Sphere -> Charged Triplet Neutronium Sphere
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(TRIPLET_NEUTRONIUM_SPHERE)
                .fluidInputs(FreeElectronGas.getFluid(1000))
                .output(CHARGED_TRIPLET_NEUTRONIUM_SPHERE)
                .EUt(VA[UXV])
                .duration(10)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Charged Triplet Neutronium Sphere -> Contained RN Singularity
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(TIME_DILATION_CONTAINMENT_UNIT, 64)
                .input(CHARGED_TRIPLET_NEUTRONIUM_SPHERE, 64)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.TARANIUM_CHARGE))
                .output(CONTAINED_RN_SINGULARITY, 64)
                .EUt(VA[UXV])
                .duration(200)
                .temperature(BigInteger.valueOf(834267850))
                .buildAndRegister();

        //  Contained RN Singularity -> Contained KN Singularity
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(CONTAINED_RN_SINGULARITY, 64)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.LEPTONIC_CHARGE))
                .output(CONTAINED_KN_SINGULARITY)
                .output(TIME_DILATION_CONTAINMENT_UNIT, 63)
                .EUt(6000000)
                .duration(200)
                .temperature(BigInteger.valueOf(857455690))
                .buildAndRegister();

        //  Macrowormhole Generator -> Recursively Folded Negative Space
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(MACROWORMHOLE_GENERATOR, 2)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .output(RECURSIVELY_FOLDED_NEGATIVE_SPACE)
                .EUt(VA[UXV])
                .duration(200)
                .temperature(BigInteger.valueOf(939256740))
                .buildAndRegister();

        //  Recursively Folded Negative Space -> Eigenfolded Spacetime Manifold
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(STABILIZED_WORMHOLE_GENERATOR)
                .input(RECURSIVELY_FOLDED_NEGATIVE_SPACE)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .output(EIGENFOLDED_SPACETIME_MANIFOLD)
                .EUt(VA[UXV])
                .duration(20)
                .temperature(BigInteger.valueOf(991744530))
                .buildAndRegister();

        //  Neutronium Sphere + Time Dilation Containment Unit -> Contained High Density Protonic Matter
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_SPHERE)
                .input(TIME_DILATION_CONTAINMENT_UNIT)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.LEPTONIC_CHARGE))
                .output(CONTAINED_HIGH_DENSITY_PROTONIC_MATTER)
                .EUt(VA[UXV])
                .duration(20)
                .temperature(BigInteger.valueOf(764459680))
                .buildAndRegister();

        //  Contained High Density Protonic Matter -> Contained Exotic Matter
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(dust, DegenerateRhenium)
                .input(CONTAINED_HIGH_DENSITY_PROTONIC_MATTER)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.LEPTONIC_CHARGE))
                .output(CONTAINED_EXOTIC_MATTER)
                .EUt(VA[UXV])
                .duration(20)
                .temperature(BigInteger.valueOf(809943570))
                .buildAndRegister();
    }

    private static void HypercubeChain() {

        //  Crude Hypercube
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(stick, CosmicNeutronium, 8)
                .input(stick, Octiron, 8)
                .input(stick, Tairitsium, 8)
                .input(stick, Solarium, 8)
                .input(plate, Abyssalloy, 24)
                .input(screw, Botmium, 16)
                .fluidInputs(AstralTitanium.getPlasma(1000))
                .fluidInputs(CelestialTungsten.getPlasma(1000))
                .fluidInputs(Tin.getPlasma(1000))
                .fluidInputs(Iron.getPlasma(1000))
                .fluidInputs(Nickel.getPlasma(1000))
                .fluidInputs(Americium.getPlasma(1000))
                .output(CRUDE_HYPERCUBE, 4)
                .EUt(VA[UXV])
                .duration(120)
                .temperature(BigInteger.valueOf(999876890))
                .buildAndRegister();

        //  back to Quantum Force Transformer Recipe

        //  Charged Hypercube -> Spacetime
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(CHARGED_HYPERCUBE)
                .notConsumable(QUANTUM_ANOMALY)
                .notConsumable(FIELD_GENERATOR_UXV)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .fluidInputs(Hypogen.getFluid(1152))
                .fluidInputs(Infinity.getFluid(2304))
                .fluidInputs(DimensionallyTranscendentResidue.getFluid(16000))
                .fluidOutputs(Spacetime.getFluid(L))
                .EUt(VA[UXV])
                .duration(20)
                .temperature(BigInteger.valueOf(1000000000))
                .buildAndRegister();

        //  Crude Hyper cube -> Transcendent Metal
        MACERATOR_RECIPES.recipeBuilder()
                .input(CRUDE_HYPERCUBE)
                .output(dust, TranscendentMetal, 8)
                .EUt(VA[UXV])
                .duration(20)
                .buildAndRegister();

    }

    private static void HikariumChain() {

        //  Instanton -> Superluminal Tachyon Jet
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(Instantons.getFluid(1000))
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .notConsumable(TOPOLOGICAL_INSULATOR_TUBE)
                .fluidOutputs(SuperluminalTachyonJet.getFluid(1000))
                .EUt(VA[UIV])
                .duration(10)
                .temperature(BigInteger.valueOf(639400000))
                .buildAndRegister();

        //  Superluminal Tachyon Jet -> Hikarium
        CENTRIFUGE_RECIPES.recipeBuilder()
                .notConsumable(SEPARATION_ELECTROMAGNET)
                .fluidInputs(SuperluminalTachyonJet.getFluid(1000))
                .fluidOutputs(Hikarium.getFluid(800))
                .fluidOutputs(LightQuarks.getFluid(200))
                .EUt(VA[UIV])
                .duration(25)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void ShirabonEternityChain() {

        //  You can both get Shirabon and Eternity, but needs to use more materials.
        //  Dimensionally Transcendent Residue is cycle in this recipe.
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(CHARGED_HYPERCUBE)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .fluidInputs(DimensionallyTranscendentResidue.getFluid(16000))
                .fluidInputs(CosmicComputingMixture.getFluid(L * 8))
                .fluidInputs(Spacetime.getFluid(L * 4))
                .output(DIMENSION_GAP)
                .chancedOutput(dust, Shirabon, 64, 2500, 0)
                .fluidOutputs(Eternity.getFluid(9216))
                .EUt(VH[MAX])
                .duration(200)
                .temperature(BigInteger.valueOf(Integer.MAX_VALUE))
                .buildAndRegister();

        //  About Dimension Gap, there are two choice for players:
        //  1) Back to Dimension Oscillator recipe to make Hyperdimensional Oscillating Matter，
        //  2) Cycle, you can get Crude Hypercube and some Dimensionally Transcendent Residue.
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(DIMENSION_GAP)
                .notConsumable(EXCITATION_MAINTAINER)
                .output(CRUDE_HYPERCUBE)
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(16000))
                .EUt(VA[OpV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void UniversiumChain() {

        //  Maybe add a new fantastic gem: Stone of the Philosophers and Emerald Tablet processing.
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(CONTAINED_EXOTIC_MATTER) // todo another more fantastic material?
                .input(ingot, Galaxium)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .fluidInputs(DimensionallyTranscendentResidue.getFluid(16000))
                .fluidInputs(CosmicComputingMixture.getFluid(L * 8))
                .fluidInputs(CosmicNeutronium.getFluid(L * 4))
                .output(TIME_DILATION_CONTAINMENT_UNIT)
                .fluidOutputs(Universium.getFluid(9216))
                .EUt(VH[MAX])
                .duration(200)
                .temperature(BigInteger.valueOf(Integer.MAX_VALUE))
                .buildAndRegister();
    }

    private static void EdeniumChain() {

        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(plate, CosmicNeutronium, 8)
                .input(plate, WhiteDwarfMatter, 8)
                .input(plate, BlackDwarfMatter, 8)
                .input(plate, Legendarium, 8)
                .input(stick, HeavyQuarkDegenerateMatter, 24)
                .input(screw, BlackPlutonium, 16)
                .fluidInputs(HiggsBosons.getFluid(1000))
                .fluidInputs(Instantons.getFluid(1000))
                .fluidInputs(Hikarium.getFluid(1000))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(1000))
                .fluidInputs(VoidMetal.getFluid(1000))
                .fluidInputs(Astralium.getFluid(1000))
                .fluidOutputs(Edenium.getFluid(9216))
                .EUt(VH[MAX])
                .duration(200)
                .temperature(BigInteger.valueOf(Integer.MAX_VALUE))
                .buildAndRegister();
    }
}