package magicbook.gtlitecore.loaders.multiblock;

import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.common.blocks.*;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.FIELD_GENERATOR_OpV;
import static magicbook.gtlitecore.api.GTLiteValues.VZ;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.singularity;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class NicollDysonBeamer {

    public static void init() {
        BurningModule();
        ForgingModule();
        OscillatingModule();
    }

    private static void BurningModule() {

        //  Aluminium -> Crystal Matrix (UHV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Aluminium.getFluid(73728))
                .fluidInputs(CosmicComputingMixture.getFluid(65017))
                .fluidOutputs(CrystalMatrix.getFluid(73728))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(8127))
                .EUt(VA[UHV])
                .duration(200)
                .tier(1)
                .buildAndRegister();

        //  Aluminium -> Crystal Matrix (UEV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(11)
                .fluidInputs(Aluminium.getFluid(147456))
                .fluidInputs(CosmicComputingMixture.getFluid(25442))
                .fluidOutputs(CrystalMatrix.getFluid(147456))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(6360))
                .EUt(VA[UEV])
                .duration(200)
                .tier(2)
                .buildAndRegister();

        //  Aluminium -> Crystal Matrix (UIV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(21)
                .fluidInputs(Aluminium.getFluid(589824))
                .fluidInputs(CosmicComputingMixture.getFluid(4632))
                .fluidOutputs(CrystalMatrix.getFluid(589824))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(4632))
                .EUt(VA[UIV])
                .duration(200)
                .tier(3)
                .buildAndRegister();

        //  Crystal Matrix -> Infinity (UEV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(CrystalMatrix.getFluid(73728))
                .fluidInputs(CosmicComputingMixture.getFluid(65017))
                .fluidOutputs(Infinity.getFluid(73728))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(8127))
                .EUt(VA[UEV])
                .duration(200)
                .tier(1)
                .buildAndRegister();

        //  Crystal Matrix -> Infinity (UIV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(12)
                .fluidInputs(CrystalMatrix.getFluid(147456))
                .fluidInputs(CosmicComputingMixture.getFluid(25442))
                .fluidOutputs(Infinity.getFluid(147456))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(6360))
                .EUt(VA[UIV])
                .duration(200)
                .tier(2)
                .buildAndRegister();

        //  Crystal Matrix -> Infinity (UXV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(22)
                .fluidInputs(CrystalMatrix.getFluid(589824))
                .fluidInputs(CosmicComputingMixture.getFluid(4632))
                .fluidOutputs(Infinity.getFluid(589824))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(4632))
                .EUt(VA[UXV])
                .duration(200)
                .tier(3)
                .buildAndRegister();

        //  Iron -> Neutronium (UIV)
        //  Better than Fusion Reactor recipe, but when you have this machine,
        //  you do not need more neutronium lol.
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(3)
                .fluidInputs(Iron.getPlasma(73728))
                .fluidInputs(CosmicComputingMixture.getFluid(65017))
                .fluidOutputs(Neutronium.getFluid(73728))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(8127))
                .EUt(VA[UIV])
                .duration(200)
                .tier(1)
                .buildAndRegister();

        //  Iron -> Neutronium (UXV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(13)
                .fluidInputs(Iron.getPlasma(147456))
                .fluidInputs(CosmicComputingMixture.getFluid(25442))
                .fluidOutputs(Neutronium.getFluid(147456))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(6360))
                .EUt(VA[UXV])
                .duration(200)
                .tier(2)
                .buildAndRegister();

        //  Iron -> Neutronium (OpV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(23)
                .fluidInputs(Iron.getPlasma(589824))
                .fluidInputs(CosmicComputingMixture.getFluid(4632))
                .fluidOutputs(Neutronium.getFluid(589824))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(4632))
                .EUt(VA[OpV])
                .duration(200)
                .tier(3)
                .buildAndRegister();

        //  Neutronium -> Cosmic Neutronium (UXV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(4)
                .fluidInputs(Neutronium.getFluid(73728))
                .fluidInputs(CosmicComputingMixture.getFluid(65017))
                .fluidOutputs(CosmicNeutronium.getFluid(73728))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(8127))
                .EUt(VA[UXV])
                .duration(200)
                .tier(1)
                .buildAndRegister();

        //  Neutronium -> Cosmic Neutronium (OpV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(14)
                .fluidInputs(Neutronium.getFluid(147456))
                .fluidInputs(CosmicComputingMixture.getFluid(25442))
                .fluidOutputs(CosmicNeutronium.getFluid(147456))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(6360))
                .EUt(VA[OpV])
                .duration(200)
                .tier(2)
                .buildAndRegister();

        //  Neutronium -> Cosmic Neutronium (MAX)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(24)
                .fluidInputs(Neutronium.getFluid(589824))
                .fluidInputs(CosmicComputingMixture.getFluid(4632))
                .fluidOutputs(CosmicNeutronium.getFluid(589824))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(4632))
                .EUt(VA[MAX])
                .duration(200)
                .tier(3)
                .buildAndRegister();

        //  Copper -> Ichorium (UEV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(5)
                .fluidInputs(Copper.getFluid(73728))
                .fluidInputs(CosmicComputingMixture.getFluid(65017))
                .fluidOutputs(Ichorium.getFluid(73728))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(8127))
                .EUt(VA[UEV])
                .duration(200)
                .tier(1)
                .buildAndRegister();

        //  Copper -> Ichorium (UIV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(15)
                .fluidInputs(Copper.getFluid(147456))
                .fluidInputs(CosmicComputingMixture.getFluid(25442))
                .fluidOutputs(Ichorium.getFluid(147456))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(6360))
                .EUt(VA[UIV])
                .duration(200)
                .tier(2)
                .buildAndRegister();

        //  Copper -> Ichorium (UXV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(25)
                .fluidInputs(Copper.getFluid(589824))
                .fluidInputs(CosmicComputingMixture.getFluid(4632))
                .fluidOutputs(Ichorium.getFluid(589824))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(4632))
                .EUt(VA[UXV])
                .duration(200)
                .tier(3)
                .buildAndRegister();

        //  Ichorium -> Hypogen (UXV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(6)
                .fluidInputs(Ichorium.getFluid(73728))
                .fluidInputs(CosmicComputingMixture.getFluid(65017))
                .fluidOutputs(Hypogen.getFluid(73728))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(8127))
                .EUt(VA[UXV])
                .duration(200)
                .tier(1)
                .buildAndRegister();

        //  Ichorium -> Hypogen (OpV)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(16)
                .fluidInputs(Ichorium.getFluid(147456))
                .fluidInputs(CosmicComputingMixture.getFluid(25442))
                .fluidOutputs(Hypogen.getFluid(147456))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(6360))
                .EUt(VA[OpV])
                .duration(200)
                .tier(2)
                .buildAndRegister();

        //  Ichorium -> Hypogen (MAX)
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(26)
                .fluidInputs(Ichorium.getFluid(589824))
                .fluidInputs(CosmicComputingMixture.getFluid(4632))
                .fluidOutputs(Hypogen.getFluid(589824))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(4632))
                .EUt(VA[MAX])
                .duration(200)
                .tier(3)
                .buildAndRegister();

        //  7

        //  Advanced Shirabon recipe
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(8)
                .notConsumable(CHARGED_HYPERCUBE)
                .notConsumable(swarm, HSSG)
                .notConsumable(CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT)
                .input(dust, Rhodium, 64)
                .input(DIMENSION_GAP, 4)
                .input(swarm, WhiteDwarfMatter, 2)
                .fluidInputs(Spacetime.getFluid(L * 40))
                .fluidInputs(Eternity.getFluid(L * 4))
                .fluidInputs(CosmicComputingMixture.getFluid(65017))
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .fluidOutputs(Galaxium.getFluid(73728))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(8127))
                .EUt(VZ[UXV])
                .duration(200)
                .tier(1)
                .buildAndRegister();

        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(18)
                .notConsumable(CHARGED_HYPERCUBE)
                .notConsumable(swarm, HSSS)
                .notConsumable(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.SPACETIME_CASING))
                .notConsumable(CHARGED_LEPTON_TRAP_CRYSTAL)
                .input(singularity, Rhodium)
                .input(DIMENSION_GAP, 4)
                .input(swarm, Galaxium, 2)
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(160000))
                .fluidInputs(Infinity.getFluid(80000))
                .fluidInputs(Spacetime.getFluid(L * 20))
                .fluidInputs(Eternity.getFluid(L * 10))
                .fluidInputs(CosmicComputingMixture.getFluid(25442))
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .fluidOutputs(Galaxium.getFluid(147456))
                .fluidOutputs(Edenium.getFluid(73728))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(6360))
                .EUt(VZ[OpV])
                .duration(200)
                .tier(2)
                .buildAndRegister();

        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(28)
                .notConsumable(CHARGED_HYPERCUBE)
                .notConsumable(RELATIVISTIC_SPINORIAL_MEMORY_SYSTEM)
                .notConsumable(singularity, TranscendentMetal)
                .notConsumable(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.MAX))
                .notConsumable(TOPOLOGICAL_INSULATOR_TUBE)
                .input(plateDense, PlatinumGroupAlloy, 16)
                .input(PHOTON)
                .input(swarm, Eternity, 2)
                .fluidInputs(CrystalMatrix.getFluid(L * 160))
                .fluidInputs(Infinity.getFluid(L * 80))
                .fluidInputs(CosmicNeutronium.getFluid(L * 40))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(18000))
                .fluidInputs(Spacetime.getFluid(L * 8))
                .fluidInputs(Eternity.getFluid(L * 4))
                .fluidInputs(Magmatter.getFluid(L))
                .fluidInputs(CosmicComputingMixture.getFluid(4632))
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .output(dust, Shirabon, 64)
                .fluidOutputs(Galaxium.getFluid(589824))
                .fluidOutputs(Edenium.getFluid(147456))
                .fluidOutputs(Arcanium.getFluid(73728))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(4632))
                .EUt(VZ[MAX])
                .duration(200)
                .tier(3)
                .buildAndRegister();

        //  Advanced Crude Hypercube recipe
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(9)
                .input(stick, CosmicNeutronium, 12)
                .input(stick, Tairitsium, 12)
                .input(stick, TranscendentMetal, 8)
                .input(plate, Botmium, 24)
                .input(ring, FluxedElectrum,4)
                .input(screw, Orichalcum, 16)
                .fluidInputs(CosmicComputingMixture.getFluid(1000))
                .output(CRUDE_HYPERCUBE, 8)
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(1000))
                .EUt(128000000) //  UXV
                .duration(20)
                .tier(2)
                .buildAndRegister();

        //  Ultimate Crude Hypercube recipe
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(19)
                .input(stick, TranscendentMetal, 32)
                .input(plate, BlackTitanium, 24)
                .input(screw, TitanSteel, 16)
                .input(QUANTUM_ANOMALY)
                .fluidInputs(CosmicComputingMixture.getFluid(1000))
                .output(CRUDE_HYPERCUBE, 16)
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(2000))
                .EUt(512000000) //  OpV
                .duration(20)
                .tier(3)
                .buildAndRegister();

        //  Quantum Anomaly
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .notConsumable(CHROMATIC_LENS)
                .notConsumable(TOPOLOGICAL_MANIPULATOR_UNIT)
                .input(ALPHA_PARTICLE)
                .fluidInputs(Duranium.getFluid(L))
                .fluidInputs(CosmicComputingMixture.getFluid(92))
                .output(QUANTUM_ANOMALY)
                .EUt(VA[UEV])
                .duration(20)
                .tier(1)
                .buildAndRegister();

        //  Dimension Gap
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .notConsumable(GTLiteMetaBlocks.COOLING_CORE.getItemVariant(BlockCoolingCore.CoolingCoreTier.MK4))
                .input(plateDense, Hypogen)
                .input(gem, CubicZirconia, 32)
                .input(swarm, BlackDwarfMatter, 2)
                .fluidInputs(TemporalFluid.getFluid(147456))
                .fluidInputs(Spacetime.getFluid(100000))
                .output(DIMENSION_GAP, 64)
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(200000))
                .fluidOutputs(HiggsBosons.getFluid(147456))
                .EUt(VA[MAX])
                .duration(20)
                .tier(3)
                .buildAndRegister();


        //  Crude Dimensionally Transcendent Catalyst
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .notConsumable(lens, CrystalMatrix)
                .fluidInputs(DimensionallyTranscendentResidue.getFluid(1000))
                .fluidInputs(Helium.getPlasma(1000))
                .fluidInputs(Oxygen.getPlasma(1000))
                .fluidInputs(Iron.getPlasma(1000))
                .fluidOutputs(CrudeDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[UEV])
                .duration(200)
                .tier(1)
                .buildAndRegister();

        //  Prosaic Dimensionally Transcendent Catalyst
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .notConsumable(QUANTUM_ANOMALY)
                .notConsumable(lens, Infinity)
                .fluidInputs(CrudeDimensionallyTranscendentCatalyst.getFluid(1000))
                .fluidInputs(Argon.getPlasma(1000))
                .fluidInputs(Nitrogen.getPlasma(1000))
                .fluidInputs(Americium.getPlasma(1000))
                .fluidOutputs(ProsaicDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[UIV])
                .duration(200)
                .tier(1)
                .buildAndRegister();

        //  Resplendent Dimensionally Transcendent Catalyst
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .notConsumable(QUANTUM_ANOMALY)
                .notConsumable(lens, MagnetoHydrodynamicallyConstrainedStarMatter)
                .notConsumable(CHROMATIC_LENS)
                .fluidInputs(ProsaicDimensionallyTranscendentCatalyst.getFluid(1000))
                .fluidInputs(Tin.getPlasma(1000))
                .fluidInputs(Nickel.getPlasma(1000))
                .fluidInputs(FleroviumYtterbiumPlasma.getPlasma(1000))
                .fluidOutputs(ResplendentDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[UXV])
                .duration(200)
                .tier(2)
                .buildAndRegister();

        //  Exotic Dimensionally Transcendent Catalyst
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .notConsumable(CHARGED_HYPERCUBE)
                .notConsumable(RECURSIVELY_FOLDED_NEGATIVE_SPACE)
                .notConsumable(lens, Spacetime)
                .notConsumable(SUPERSOLID_SPACETIME_CONTINUUM)
                .fluidInputs(ResplendentDimensionallyTranscendentCatalyst.getFluid(1000))
                .fluidInputs(Taranium.getPlasma(1000))
                .fluidInputs(Adamantium.getPlasma(1000))
                .fluidInputs(Vibranium.getPlasma(1000))
                .fluidInputs(Mithril.getPlasma(1000))
                .fluidInputs(Hypogen.getPlasma(1000))
                .fluidInputs(IchorLiquid.getPlasma(1000))
                .fluidInputs(DegenerateRhenium.getPlasma(1000))
                .fluidInputs(QuarkGluonPlasma.getPlasma(1000))
                .fluidOutputs(ExoticDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[OpV])
                .duration(200)
                .tier(3)
                .buildAndRegister();

        //  Zenith Dimensionally Transcendent Catalyst
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .notConsumable(CHARGED_HYPERCUBE)
                .notConsumable(LIGHT_CONE_MODULE)
                .notConsumable(lens, Eternity)
                .notConsumable(FIELD_GENERATOR_OpV)
                .notConsumable(swarm, Galaxium)
                .fluidInputs(ExoticDimensionallyTranscendentCatalyst.getFluid(1000))
                .fluidInputs(AstralTitanium.getPlasma(1000))
                .fluidInputs(CelestialTungsten.getPlasma(1000))
                .fluidInputs(DenseNeutronPlasma.getPlasma(1000))
                .fluidInputs(HeavyQuarkDegenerateMatter.getPlasma(1000))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(1000))
                .fluidInputs(Fatalium.getPlasma(1000))
                .fluidInputs(CosmicFabric.getPlasma(1000))
                .fluidInputs(CosmicComputingMixture.getFluid(1000))
                .fluidOutputs(ZenithDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[MAX])
                .duration(200)
                .tier(3)
                .buildAndRegister();

        //  1x Magmatter Wire
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(1)
                .input(wireFine, Magmatter, 4)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 16)
                .fluidInputs(Magmatter.getFluid(L))
                .fluidInputs(Spacetime.getFluid(L * 4))
                .fluidInputs(CosmicNeutronium.getFluid(1000))
                .output(wireGtSingle, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(3)
                .buildAndRegister();

        //  1x Magmatter cable
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(1)
                .input(wireGtSingle, Magmatter)
                .input(foil, CosmicFabric, 2)
                .input(MetaBlocks.OPTICAL_PIPES[0])
                .input(OPTICAL_FIBER, 4)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 16)
                .fluidInputs(NitrileButadieneRubber.getFluid(5000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(5000))
                .fluidInputs(Spacetime.getFluid(L * 4))
                .fluidInputs(Magmatter.getFluid(L))
                .output(cableGtSingle, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(2)
                .buildAndRegister();

        //  2x Magmatter cable
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(2)
                .input(wireGtDouble, Magmatter)
                .input(foil, CosmicFabric, 4)
                .input(MetaBlocks.OPTICAL_PIPES[0], 2)
                .input(OPTICAL_FIBER, 8)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 32)
                .fluidInputs(NitrileButadieneRubber.getFluid(10000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(10000))
                .fluidInputs(Spacetime.getFluid(L * 8))
                .fluidInputs(Magmatter.getFluid(L * 2))
                .output(cableGtDouble, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(2)
                .buildAndRegister();

        //  4x Magmatter cable
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(4)
                .input(wireGtQuadruple, Magmatter)
                .input(foil, CosmicFabric, 8)
                .input(MetaBlocks.OPTICAL_PIPES[0], 4)
                .input(OPTICAL_FIBER, 16)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE, 4)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 64)
                .fluidInputs(NitrileButadieneRubber.getFluid(20000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(20000))
                .fluidInputs(Spacetime.getFluid(L * 16))
                .fluidInputs(Magmatter.getFluid(L * 4))
                .output(cableGtQuadruple, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(2)
                .buildAndRegister();

        //  8x Magmatter cable
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(8)
                .input(wireGtOctal, Magmatter)
                .input(foil, CosmicFabric, 16)
                .input(MetaBlocks.OPTICAL_PIPES[0], 8)
                .input(OPTICAL_FIBER, 32)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE, 8)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 128)
                .fluidInputs(NitrileButadieneRubber.getFluid(40000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(40000))
                .fluidInputs(Spacetime.getFluid(L * 32))
                .fluidInputs(Magmatter.getFluid(L * 8))
                .output(cableGtOctal, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(2)
                .buildAndRegister();

        //  16x Magmatter cable
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .circuitMeta(16)
                .input(wireGtHex, Magmatter)
                .input(foil, CosmicFabric, 32)
                .input(MetaBlocks.OPTICAL_PIPES[0], 16)
                .input(OPTICAL_FIBER, 64)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE, 16)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 256)
                .fluidInputs(NitrileButadieneRubber.getFluid(80000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(80000))
                .fluidInputs(Spacetime.getFluid(L * 64))
                .fluidInputs(Magmatter.getFluid(L * 16))
                .output(cableGtHex, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(2)
                .buildAndRegister();
    }

    private static void ForgingModule() {

        //  Magmatter Dust
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(dust, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(dust, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(3)
                .buildAndRegister();

        //  Magmatter Dust Small
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(dustSmall, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(dustSmall, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(3)
                .buildAndRegister();

        //  Magmatter Dust Tiny
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(dustTiny, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(dustTiny, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(3)
                .buildAndRegister();

        //  Magmatter Nugget
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(nugget, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(nugget, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(3)
                .buildAndRegister();

        //  Magmatter Ingot
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(ingot, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(ingot, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(3)
                .buildAndRegister();

        //  Magmatter Block
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(block, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(block, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(3)
                .buildAndRegister();

        //  Magmatter Plate
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(plate, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(plate, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(3)
                .buildAndRegister();

        //  Magmatter Foil
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(foil, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(foil, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(3)
                .buildAndRegister();

        //  Magmatter Wire Fine
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(wireFine, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(wireFine, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .tier(3)
                .buildAndRegister();
    }

    private static void OscillatingModule() {

        //  Hyperstable Self-Healing Adhesive
        //  Basic materials for some recipe of this machine, and T2 casings.
        NICOLL_DYSON_BEAMER_OSCILLATING_MODULE.recipeBuilder()
                .notConsumable(lens, CelestialCrystal)
                .notConsumable(DIMENSION_GAP)
                .input(GLUON)
                .input(singularity, Clay)
                .input(QUANTUM_ANOMALY)
                .input(wireFine, SolderingAlloy, 8)
                .fluidInputs(Lubricant.getFluid(5760000))
                .fluidInputs(SodiumPotassium.getFluid(5760000))
                .fluidInputs(QuantumAlloy.getFluid(L * 40))
                .fluidInputs(CelestialTungsten.getFluid(L * 20))
                .fluidInputs(Spacetime.getFluid(L * 4))
                .chancedOutput(HYPERSTABLE_SELF_HEALING_ADHESIVE.getStackForm(), 2000, 0)
                .EUt(VA[MAX])
                .duration(20)
                .tier(1)
                .buildAndRegister();

        //  Supersolid Spacetime Continuum
        NICOLL_DYSON_BEAMER_OSCILLATING_MODULE.recipeBuilder()
                .notConsumable(EIGENFOLDED_SPACETIME_MANIFOLD)
                .notConsumable(ROTATING_TRANSPARENT_SURFACE)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE)
                .input(singularity, Naquadria)
                .input(QUANTUM_ANOMALY)
                .input(swarm, Galaxium, 2)
                .fluidInputs(Hikarium.getFluid(L * 40))
                .fluidInputs(CosmicNeutronium.getFluid(L * 40))
                .fluidInputs(Spacetime.getFluid(L * 4))
                .fluidInputs(Eternity.getFluid(L))
                .chancedOutput(SUPERSOLID_SPACETIME_CONTINUUM, 2000, 0)
                .EUt(VA[MAX])
                .duration(20)
                .tier(2)
                .buildAndRegister();

        //  Magmatter Liquid
        //  This is basic material to create other Magmatter components.
        NICOLL_DYSON_BEAMER_OSCILLATING_MODULE.recipeBuilder()
                .notConsumable(RYDBERG_SPINORIAL_ASSEMBLY)
                .notConsumable(GTLiteMetaBlocks.DYSON_SWARM_CASING.getItemVariant(BlockDysonSwarmCasing.DysonSwarmCasingType.DEPLOYMENT_MAGNET))
                .input(BOSE_EINSTEIN_CONDENSATE, 64)
                .input(singularity, Taranium)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE, 4)
                .input(wireFine, QuantumchromodynamicallyConfinedMatter, 32)
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(64000))
                .fluidInputs(MercuryCadmiumTelluride.getFluid(64000))
                .fluidInputs(MBBA.getFluid(48000))
                .fluidInputs(ChargedCaesiumCeriumCobaltIndiumAlloy.getFluid(32000))
                .fluidInputs(Spacetime.getFluid(4000))
                .fluidInputs(Eternity.getFluid(L * 4))
                .output(BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT, 64)
                .fluidOutputs(Magmatter.getFluid(16000))
                .EUt(VA[MAX])
                .duration(20)
                .tier(2)
                .buildAndRegister();

    }

}
