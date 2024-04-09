package magicbook.gtlitecore.common.metatileentities;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockTurbineCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.metatileentity.single.SimpleSteamMetaTileEntity;
import magicbook.gtlitecore.api.metatileentity.single.SteamProgressIndicator;
import magicbook.gtlitecore.api.metatileentity.single.SteamProgressIndicators;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.api.utils.GTLiteUtils;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockFusionCasing;
import magicbook.gtlitecore.common.blocks.BlockMetalCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.metatileentities.electric.MetaTileEntityLightningRod;
import magicbook.gtlitecore.common.metatileentities.multi.electric.*;
import magicbook.gtlitecore.common.metatileentities.multi.electric.adv.*;
import magicbook.gtlitecore.common.metatileentities.multi.electric.generator.*;
import magicbook.gtlitecore.common.metatileentities.multi.part.*;
import magicbook.gtlitecore.common.metatileentities.multi.steam.MetaTileEntityLargePrimitiveBlastFurnace;
import magicbook.gtlitecore.common.metatileentities.multi.steam.MetaTileEntityLargeSteamCompressor;
import magicbook.gtlitecore.common.metatileentities.multi.storage.MetaTileEntityYottaFluidTank;

import static gregtech.api.GTValues.*;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.gtliteId;

/**
 * Meta Tile Entities
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is the basic class about machines in gtlitecore,
 *     all single/multi machines init in this class, so this class's function is same as
 *      {@link gregtech.common.metatileentities.MetaTileEntities}).
 *     ID range of gtlitecore meta tile entities:
 *
 *     <pre>
 *         14000-14999: Multiblock Parts,<br>
 *         15000-16000: Single Machines,<br>
 *         16001-20000: Multiblock Machines.
 *     </pre>
 *
 *     Some ID is free in this range (but maybe add new machines in this free IDs).
 * </p>
 *
 * @since 2.8.7-beta
 */
public class GTLiteMetaTileEntities {

    ////////////////////////
    //  Multiblock Parts  //
    ////////////////////////

    //  ID Range: 14000-14999
    public static MetaTileEntityGrindBallHatch MULTIPART_GRIND_BALL_HATCH;
    public static final MetaTileEntityReinforcedRotorHolder[] MULTIPART_REINFORCED_ROTOR_HOLDER = new MetaTileEntityReinforcedRotorHolder[8];
    public static final MetaTileEntityEnergyHatch[] INPUT_ENERGY_HATCH_4A = new MetaTileEntityEnergyHatch[4];
    public static final MetaTileEntityEnergyHatch[] INPUT_ENERGY_HATCH_16A = new MetaTileEntityEnergyHatch[4];
    public static final MetaTileEntityEnergyHatch[] OUTPUT_ENERGY_HATCH_4A = new MetaTileEntityEnergyHatch[7];
    public static final MetaTileEntityEnergyHatch[] OUTPUT_ENERGY_HATCH_16A = new MetaTileEntityEnergyHatch[8];
    public static final MetaTileEntitySubstationEnergyHatch[] SUBSTATION_INPUT_ENERGY_HATCH = new MetaTileEntitySubstationEnergyHatch[4];
    public static final MetaTileEntitySubstationEnergyHatch[] SUBSTATION_OUTPUT_ENERGY_HATCH = new MetaTileEntitySubstationEnergyHatch[4];
    public static final MetaTileEntityFluidHatch[] IMPORT_FLUID_HATCH = new MetaTileEntityFluidHatch[4];
    public static final MetaTileEntityFluidHatch[] EXPORT_FLUID_HATCH = new MetaTileEntityFluidHatch[4];
    public static final MetaTileEntityItemBus[] IMPORT_ITEM_HATCH = new MetaTileEntityItemBus[4];
    public static final MetaTileEntityItemBus[] EXPORT_ITEM_HATCH = new MetaTileEntityItemBus[4];
    public static final MetaTileEntityMultiFluidHatch[] QUADRUPLE_IMPORT_FLUID_HATCH = new MetaTileEntityMultiFluidHatch[4];
    public static final MetaTileEntityMultiFluidHatch[] QUADRUPLE_EXPORT_FLUID_HATCH = new MetaTileEntityMultiFluidHatch[4];
    public static final MetaTileEntityMultiFluidHatch[] NONUPLE_IMPORT_FLUID_HATCH = new MetaTileEntityMultiFluidHatch[4];
    public static final MetaTileEntityMultiFluidHatch[] NONUPLE_EXPORT_FLUID_HATCH = new MetaTileEntityMultiFluidHatch[4];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_4A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_4A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_16A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_16A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_64A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_64A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_256A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_256A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_1024A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_1024A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_4096A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_4096A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_16384A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_16384A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_65536A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_65536A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_262144A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_262144A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_1048576A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_1048576A = new MetaTileEntityWirelessEnergyHatch[15];

    public static MetaTileEntityQCComponentEmpty QC_EMPTY_COMPONENT;
    public static final MetaTileEntityQCComponentComputation[] QC_COMPUTATION_COMPONENT = new MetaTileEntityQCComponentComputation[2];
    public static final MetaTileEntityQCComponentCooler[] QC_COOLER_COMPONENT = new MetaTileEntityQCComponentCooler[2];
    public static MetaTileEntityQCComponentBridge QC_BRIDGE_COMPONENT;

    ///////////////////////
    //  Single Machines  //
    ///////////////////////

    //  ID Range: 15000-16000
    public static SimpleMachineMetaTileEntity[] CHEMICAL_DRYER = new SimpleMachineMetaTileEntity[V.length - 1];
    public static SimpleSteamMetaTileEntity[] STEAM_VACUUM_CHAMBER = new SimpleSteamMetaTileEntity[2];
    public static SimpleMachineMetaTileEntity[] VACUUM_CHAMBER = new SimpleMachineMetaTileEntity[V.length - 1];
    public static final SimpleGeneratorMetaTileEntity[] NAQUADAH_REACTOR = new SimpleGeneratorMetaTileEntity[4];
    public static final SimpleGeneratorMetaTileEntity[] ROCKET_ENGINE = new SimpleGeneratorMetaTileEntity[3];
    public static SimpleMachineMetaTileEntity[] COMPONENT_ASSEMBLER = new SimpleMachineMetaTileEntity[IV + 1];
    public static SimpleMachineMetaTileEntity[] BIO_REACTOR = new SimpleMachineMetaTileEntity[V.length - 1];
    public static SimpleMachineMetaTileEntity[] CONDENSER = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] SIMULATOR = new SimpleMachineMetaTileEntity[IV + 1];
    public static final SimpleGeneratorMetaTileEntity[] BIOMASS_GENERATOR = new SimpleGeneratorMetaTileEntity[3];
    public static final MetaTileEntityLightningRod[] LIGHTNING_ROD = new MetaTileEntityLightningRod[3];

    ///////////////////////////
    //  Multiblock Machines  //
    ///////////////////////////

    //  ID Range: 16001-20000
    public static MetaTileEntityIndustrialDrillingRig INDUSTRIAL_DRILLING_RIG;
    public static MetaTileEntityCatalyticReformer CATALYTIC_REFORMER;
    public static MetaTileEntitySonicator SONICATOR;
    public static MetaTileEntityHydraulicFracker HYDRAULIC_FRACKER;
    public static MetaTileEntityNanoscaleFabricator NANOSCALE_FABRICATOR;
    public static MetaTileEntityIndustrialRoaster INDUSTRIAL_ROASTER;
    public static MetaTileEntityCrystallizationCrucible CRYSTALLIZATION_CRUCIBLE;
    public static MetaTileEntityCVDUnit CVD_UNIT;
    public static MetaTileEntityPlasmaCVDUnit PLASMA_CVD_UNIT;
    public static MetaTileEntityLaserCVDUnit LASER_CVD_UNIT;
    public static MetaTileEntityBurnerReactor BURNER_REACTOR;
    public static MetaTileEntityCryogenicReactor CRYOGENIC_REACTOR;
    public static MetaTileEntityLargeNaquadahReactor LARGE_NAQUADAH_REACTOR;
    public static MetaTileEntityHyperReactorMkI HYPER_REACTOR_MK1;
    public static MetaTileEntityHyperReactorMkII HYPER_REACTOR_MK2;
    public static MetaTileEntityHyperReactorMkIII HYPER_REACTOR_MK3;
    public static MetaTileEntityIsaMill ISA_MILL;
    public static MetaTileEntityFlotationCellRegulator FLOTATION_CELL_REGULATOR;
    public static MetaTileEntityVacuumDryingFurnace VACUUM_DRYING_FURNACE;
    public static MetaTileEntityVolcanus VOLCANUS;
    public static MetaTileEntityCryogenicFreezer CRYOGENIC_FREEZER;
    public static MetaTileEntityFuelRefineFactory FUEL_REFINE_FACTORY;
    public static MetaTileEntityIonImplantator ION_IMPLANTATOR;
    public static MetaTileEntityUnmannedDroneAirport UNMANNED_DRONE_AIRPORT;
    public static MetaTileEntitySpaceElevator SPACE_ELEVATOR;
    public static MetaTileEntityVirtualCosmosSimulator VIRTUAL_COSMOS_SIMULATOR;
    public static MetaTileEntityCollider COLLIDER;
    public static MetaTileEntityDimensionalOscillator DIMENSIONAL_OSCILLATOR;
    public static MetaTileEntityDecayGenerator DECAY_GENERATOR;

    public static final MetaTileEntityAdvancedFusionReactor[] ADVANCED_FUSION_REACTOR = new MetaTileEntityAdvancedFusionReactor[2];
    public static MetaTileEntityPreciseAssembler PRECISE_ASSEMBLER;
    public static MetaTileEntityComponentAssemblyLine COMPONENT_ASSEMBLY_LINE;
    public static MetaTileEntityAdvancedAssemblyLine ADVANCED_ASSEMBLY_LINE;
    public static final MetaTileEntityCompressedFusionReactor[] COMPRESSED_FUSION_REACTOR = new MetaTileEntityCompressedFusionReactor[5];

    public static MetaTileEntityMegaChemicalReactor MEGA_CHEMICAL_REACTOR;
    public static MetaTileEntityMegaAlloyBlastSmelter MEGA_ALLOY_BLAST_SMELTER;
    public static MetaTileEntityMegaOilCrackingUnit MEGA_OIL_CRACKING_UNIT;
    public static MetaTileEntityStellarFurnace STELLAR_FURNACE;
    public static MetaTileEntityPlasmaCondenser PLASMA_CONDENSER;
    public static MetaTileEntityCosmicRayDetector COSMIC_RAY_DETECTOR;
    public static MetaTileEntitySuprachronalAssemblyLine SUPRACHRONAL_ASSEMBLY_LINE;
    public static MetaTileEntityMolecularTransformer MOLECULAR_TRANSFORMER;
    public static MetaTileEntityQuantumForceTransformer QUANTUM_FORCE_TRANSFORMER;
    public static MetaTileEntityExtremeIndustrialGreenhouse EXTREME_INDUSTRIAL_GREENHOUSE;
    public static MetaTileEntityLargeSteamCompressor LARGE_STEAM_COMPRESSOR;
    public static MetaTileEntityLargePrimitiveBlastFurnace LARGE_PRIMITIVE_BLAST_FURNACE;
    public static MetaTileEntityHeatExchanger HEAT_EXCHANGER;
    public static MetaTileEntityExtremeHeatExchanger EXTREME_HEAT_EXCHANGER;
    public static MetaTileEntityMegaHeatExchanger MEGA_HEAT_EXCHANGER;
    public static MetaTileEntityTreeGrowthFactory TREE_GROWTH_FACTORY;
    public static MetaTileEntityLargeProcessingFactory LARGE_PROCESSING_FACTORY;
    public static MetaTileEntityAdvancedProcessingArray EXTREME_PROCESSING_ARRAY;
    public static MetaTileEntityAdvancedProcessingArray ULTIMATE_PROCESSING_ARRAY;
    public static MetaTileEntityLargeAlloySmelter LARGE_ALLOY_SMELTER;
    public static MetaTileEntityMegaTurbine MEGA_STEAM_TURBINE;
    public static MetaTileEntityMegaTurbine MEGA_GAS_TURBINE;
    public static MetaTileEntityMegaTurbine MEGA_PLASMA_TURBINE;
    public static MetaTileEntityLargeTurbine HIGH_PRESSURE_STEAM_TURBINE;
    public static MetaTileEntityLargeTurbine SUPERCRITICAL_STEAM_TURBINE;
    public static MetaTileEntityMegaTurbine MEGA_HIGH_PRESSURE_STEAM_TURBINE;
    public static MetaTileEntityMegaTurbine MEGA_SUPERCRITICAL_STEAM_TURBINE;
    public static MetaTileEntityLargeRocketEngine LARGE_ROCKET_ENGINE;
    public static MetaTileEntityLargeBiomassGenerator LARGE_BIOMASS_GENERATOR;
    public static MetaTileEntityNeutralNetworkNexus NEUTRAL_NETWORK_NEXUS;
    public static MetaTileEntityPCBFactory PCB_FACTORY;
    public static MetaTileEntityDangoteDistillery DANGOTE_DISTILLERY;
    public static MetaTileEntityAmazonWarehousingDepot AMAZON_WAREHOUSING_DEPOT;
    public static MetaTileEntityArcFurnaceArray ARC_FURNACE_ARRAY;
    public static MetaTileEntityElectrolyticTank ELECTROLYTIC_TANK;
    public static MetaTileEntityTurbineMixer TURBINE_MIXER;
    public static MetaTileEntityIndustrialCentrifuge INDUSTRIAL_CENTRIFUGE;
    public static MetaTileEntityZhuHaiFishingPond ZHUHAI_FISHING_POND;
    public static MetaTileEntityCokingTower COKING_TOWER;
    public static MetaTileEntityAdvancedLargeMiner EXTREME_LARGE_MINER;
    public static MetaTileEntityAdvancedLargeMiner ULTIMATE_LARGE_MINER;
    public static MetaTileEntityAdvancedLargeMiner INFINITY_LARGE_MINER;
    public static MetaTileEntityAdvancedFluidDrill ADVANCED_FLUID_DRILL_RIG;
    public static MetaTileEntityAdvancedFluidDrill EXTREME_FLUID_DRILL_RIG;
    public static MetaTileEntityAdvancedFluidDrill ULTIMATE_FLUID_DRILL_RIG;
    public static MetaTileEntityAdvancedFluidDrill INFINITY_FLUID_DRILL_RIG;
    public static MetaTileEntityLargeCircuitAssemblyLine LARGE_CIRCUIT_ASSEMBLY_LINE;
    public static MetaTileEntityElectromagneticSeparationPlant ELECTROMAGNETIC_SEPARATION_PLANT;
    public static MetaTileEntityLargeVacuumChamber LARGE_VACUUM_CHAMBER;
    public static MetaTileEntityLargeBioReactor LARGE_BIO_REACTOR;
    public static MetaTileEntityLargeEUVMaskAligner LARGE_EUV_MASK_ALIGNER;
    public static MetaTileEntityIonLithographyFactory ION_LITHOGRAPHY_FACTORY;
    public static MetaTileEntityLargeHighPressureFormingUnit LARGE_HIGH_PRESSURE_FORMING_UNIT;
    public static MetaTileEntityLargeTurrentLathingFactory LARGE_TURRENT_LATHING_FACTORY;
    public static MetaTileEntityDysonSwarm DYSON_SWARM;
    public static MetaTileEntityIntegratedOreProcessor INTEGRATED_ORE_PROCESSOR;
    public static MetaTileEntityLargeFluidPhaseTransformer LARGE_FLUID_PHASE_TRANSFORMER;
    public static MetaTileEntityPlanetaryGasSiphon PLANETARY_GAS_SIPHON;
    public static MetaTileEntityBiowareSimulator BIOWARE_SIMULATOR;
    public static MetaTileEntityAlgaeCultureTank ALGAE_CULTURE_TANK;
    public static MetaTileEntityLargeGasCollector LARGE_GAS_COLLECTOR;
    public static MetaTileEntityUltimateCombustionEngine ULTIMATE_COMBUSTION_ENGINE;
    public static MetaTileEntityIndustrialInductionFurnace INDUSTRIAL_INDUCTION_FURNACE;
    public static MetaTileEntityHorizontalShaftImpactMacerator HORIZONTAL_SHAFT_IMPACT_MACERATOR;
    public static MetaTileEntityTroughTypeOreWasher TROUGH_TYPE_ORE_WASHER;
    public static MetaTileEntityFixedSiftingPlant FIXED_SIFTING_PLANT;
    public static MetaTileEntityLargeWiremillArray LARGE_WIREMILL_ARRAY;
    public static MetaTileEntityCirculativeCoolingTower CIRCULATIVE_COOLING_TOWER;
    public static MetaTileEntityLargeRockBreaker LARGE_ROCK_BREAKER;
    public static MetaTileEntityIndustrialRockBreaker INDUSTRIAL_ROCK_BREAKER;
    public static MetaTileEntityDimensionalMixer DIMENSIONAL_MIXER;
    public static MetaTileEntityYottaFluidTank YOTTA_FLUID_TANK;
    public static MetaTileEntityDimensionallyTranscendentPlasmaForge DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE;
    public static MetaTileEntityQuantumComputer QUANTUM_COMPUTER;
    public static MetaTileEntityNicollDysonBeamer NICOLL_DYSON_BEAMER;

    /**
     * Steam Machine init method.
     *
     * <p>
     *     Please see {@link SimpleSteamMetaTileEntity}, this method is packaged of this class,
     *     and used for init some basic steam machines (e.g. Steam Vacuum Chamber).
     * </p>
     *
     * @param machines           Machine, you should pre-init it.
     * @param startId            Start id, because this method generate 2 machine in 1 work (steam + high pressure steam), so it take up 2 id.
     * @param name               Unlocalized name, use bronze and steel as a suffix to distinguish steam and high pressure steam.
     * @param recipeMap          Recipe map, plase use recipe map in {@link RecipeMaps} or same class in other addition mods.
     * @param progressIndicator  Progress Bar Indicator, this parameter is not same as progress bar in {@link Textures}, please see {@link SteamProgressIndicator}.
     * @param texture            Overlay textures, please use textures in {@link Textures} or same class in other addition mods.
     * @param isBricked          Extra texture of machine, if is bricked, then add a brick texture on side and front.
     */
    private static void registerSimpleSteamMetaTileEntity(SimpleSteamMetaTileEntity[] machines,
                                                          int startId,
                                                          String name,
                                                          RecipeMap<?> recipeMap,
                                                          SteamProgressIndicator progressIndicator,
                                                          ICubeRenderer texture,
                                                          boolean isBricked) {
        machines[0] = registerMetaTileEntity(startId, new SimpleSteamMetaTileEntity(gtliteId(String.format("%s.bronze", name)), recipeMap, progressIndicator, texture, isBricked, false));
        machines[1] = registerMetaTileEntity(startId + 1, new SimpleSteamMetaTileEntity(gtliteId(String.format("%s.steel", name)), recipeMap, progressIndicator, texture, isBricked, true));
    }

    /**
     * Multiblock part init method.
     *
     * <p>
     *     Multiblock Part range: 14000-14999.
     *     Used to init multiblock part (e.g. {@link gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiblockPart}).
     * </p>
     */
    private static <F extends MetaTileEntity> F registerPartMetaTileEntity(int id, F mte) {
        if (id > 1000)
            return null;
        return registerMetaTileEntity(id + 13999, mte);
    }

    /**
     * Multiblock machine init method.
     *
     * <p>
     *     Multiblock Machine range: 16001-20000.
     *     Used to init multiblock machine (e.g. {@link gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController}).
     * </p>
     */
    private static <T extends MultiblockControllerBase> T registerMultiMetaTileEntity(int id, T mte) {
        return registerMetaTileEntity(id + 16000, mte);
    }

    public static void init() {

        //  Multiblock Parts
        //  Range: 14000-14999
        MULTIPART_GRIND_BALL_HATCH                = registerPartMetaTileEntity(1,   new MetaTileEntityGrindBallHatch(        gtliteId("grind_ball_hatch")));
        MULTIPART_REINFORCED_ROTOR_HOLDER[0]      = registerPartMetaTileEntity(2,   new MetaTileEntityReinforcedRotorHolder( gtliteId("reinforced_rotor_holder.luv"),               LuV));
        MULTIPART_REINFORCED_ROTOR_HOLDER[1]      = registerPartMetaTileEntity(3,   new MetaTileEntityReinforcedRotorHolder( gtliteId("reinforced_rotor_holder.zpm"),               ZPM));
        MULTIPART_REINFORCED_ROTOR_HOLDER[2]      = registerPartMetaTileEntity(4,   new MetaTileEntityReinforcedRotorHolder( gtliteId("reinforced_rotor_holder.uv"),                UV));
        MULTIPART_REINFORCED_ROTOR_HOLDER[3]      = registerPartMetaTileEntity(5,   new MetaTileEntityReinforcedRotorHolder( gtliteId("reinforced_rotor_holder.uhv"),               UHV));
        MULTIPART_REINFORCED_ROTOR_HOLDER[4]      = registerPartMetaTileEntity(6,   new MetaTileEntityReinforcedRotorHolder( gtliteId("reinforced_rotor_holder.uev"),               UEV));
        MULTIPART_REINFORCED_ROTOR_HOLDER[5]      = registerPartMetaTileEntity(7,   new MetaTileEntityReinforcedRotorHolder( gtliteId("reinforced_rotor_holder.uiv"),               UIV));
        MULTIPART_REINFORCED_ROTOR_HOLDER[6]      = registerPartMetaTileEntity(8,   new MetaTileEntityReinforcedRotorHolder( gtliteId("reinforced_rotor_holder.uxv"),               UXV));
        MULTIPART_REINFORCED_ROTOR_HOLDER[7]      = registerPartMetaTileEntity(9,   new MetaTileEntityReinforcedRotorHolder( gtliteId("reinforced_rotor_holder.opv"),               OpV));
        INPUT_ENERGY_HATCH_4A[0]                  = registerPartMetaTileEntity(10,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.input_4a.uev"),                 UEV, 4,       false));
        INPUT_ENERGY_HATCH_4A[1]                  = registerPartMetaTileEntity(11,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.input_4a.uiv"),                 UIV, 4,       false));
        INPUT_ENERGY_HATCH_4A[2]                  = registerPartMetaTileEntity(12,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.input_4a.uxv"),                 UXV, 4,       false));
        INPUT_ENERGY_HATCH_4A[3]                  = registerPartMetaTileEntity(13,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.input_4a.opv"),                 OpV, 4,       false));
        INPUT_ENERGY_HATCH_16A[0]                 = registerPartMetaTileEntity(14,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.input_16a.uev"),                UEV, 16,      false));
        INPUT_ENERGY_HATCH_16A[1]                 = registerPartMetaTileEntity(15,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.input_16a.uiv"),                UIV, 16,      false));
        INPUT_ENERGY_HATCH_16A[2]                 = registerPartMetaTileEntity(16,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.input_16a.uxv"),                UXV, 16,      false));
        INPUT_ENERGY_HATCH_16A[3]                 = registerPartMetaTileEntity(17,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.input_16a.opv"),                OpV, 16,      false));
        OUTPUT_ENERGY_HATCH_4A[0]                 = registerPartMetaTileEntity(18,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_4a.lv"),                 LV,  4,       true));
        OUTPUT_ENERGY_HATCH_4A[1]                 = registerPartMetaTileEntity(19,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_4a.mv"),                 MV,  4,       true));
        OUTPUT_ENERGY_HATCH_4A[2]                 = registerPartMetaTileEntity(20,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_4a.hv"),                 HV,  4,       true));
        OUTPUT_ENERGY_HATCH_4A[3]                 = registerPartMetaTileEntity(21,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_4a.uev"),                UEV, 4,       true));
        OUTPUT_ENERGY_HATCH_4A[4]                 = registerPartMetaTileEntity(22,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_4a.uiv"),                UIV, 4,       true));
        OUTPUT_ENERGY_HATCH_4A[5]                 = registerPartMetaTileEntity(23,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_4a.uxv"),                UXV, 4,       true));
        OUTPUT_ENERGY_HATCH_4A[6]                 = registerPartMetaTileEntity(24,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_4a.opv"),                OpV, 4,       true));
        OUTPUT_ENERGY_HATCH_16A[0]                = registerPartMetaTileEntity(25,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_16a.lv"),                LV,  16,      true));
        OUTPUT_ENERGY_HATCH_16A[1]                = registerPartMetaTileEntity(26,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_16a.mv"),                MV,  16,      true));
        OUTPUT_ENERGY_HATCH_16A[2]                = registerPartMetaTileEntity(27,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_16a.hv"),                HV,  16,      true));
        OUTPUT_ENERGY_HATCH_16A[3]                = registerPartMetaTileEntity(28,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_16a.ev"),                EV,  16,      true));
        OUTPUT_ENERGY_HATCH_16A[4]                = registerPartMetaTileEntity(29,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_16a.uev"),               UEV, 16,      true));
        OUTPUT_ENERGY_HATCH_16A[5]                = registerPartMetaTileEntity(30,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_16a.uiv"),               UIV, 16,      true));
        OUTPUT_ENERGY_HATCH_16A[6]                = registerPartMetaTileEntity(31,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_16a.uxv"),               UXV, 16,      true));
        OUTPUT_ENERGY_HATCH_16A[7]                = registerPartMetaTileEntity(32,  new MetaTileEntityEnergyHatch(           gtliteId("energy_hatch.output_16a.opv"),               OpV, 16,      true));
        SUBSTATION_INPUT_ENERGY_HATCH[0]          = registerPartMetaTileEntity(33,  new MetaTileEntitySubstationEnergyHatch( gtliteId("substation_hatch.input_64a.uev"),            UEV, 64,      false));
        SUBSTATION_INPUT_ENERGY_HATCH[1]          = registerPartMetaTileEntity(34,  new MetaTileEntitySubstationEnergyHatch( gtliteId("substation_hatch.input_64a.uiv"),            UIV, 64,      false));
        SUBSTATION_INPUT_ENERGY_HATCH[2]          = registerPartMetaTileEntity(35,  new MetaTileEntitySubstationEnergyHatch( gtliteId("substation_hatch.input_64a.uxv"),            UXV, 64,      false));
        SUBSTATION_INPUT_ENERGY_HATCH[3]          = registerPartMetaTileEntity(36,  new MetaTileEntitySubstationEnergyHatch( gtliteId("substation_hatch.input_64a.opv"),            OpV, 64,      false));
        SUBSTATION_OUTPUT_ENERGY_HATCH[0]         = registerPartMetaTileEntity(37,  new MetaTileEntitySubstationEnergyHatch( gtliteId("substation_hatch.output_64a.uev"),           UEV, 64,      true));
        SUBSTATION_OUTPUT_ENERGY_HATCH[1]         = registerPartMetaTileEntity(38,  new MetaTileEntitySubstationEnergyHatch( gtliteId("substation_hatch.output_64a.uiv"),           UIV, 64,      true));
        SUBSTATION_OUTPUT_ENERGY_HATCH[2]         = registerPartMetaTileEntity(39,  new MetaTileEntitySubstationEnergyHatch( gtliteId("substation_hatch.output_64a.uxv"),           UXV, 64,      true));
        SUBSTATION_OUTPUT_ENERGY_HATCH[3]         = registerPartMetaTileEntity(40,  new MetaTileEntitySubstationEnergyHatch( gtliteId("substation_hatch.output_64a.opv"),           OpV, 64,      true));
        IMPORT_FLUID_HATCH[0]                     = registerPartMetaTileEntity(41,  new MetaTileEntityFluidHatch(            gtliteId("fluid_hatch.import.uev"),                    UEV,                    false));
        IMPORT_FLUID_HATCH[1]                     = registerPartMetaTileEntity(42,  new MetaTileEntityFluidHatch(            gtliteId("fluid_hatch.import.uiv"),                    UIV,                    false));
        IMPORT_FLUID_HATCH[2]                     = registerPartMetaTileEntity(43,  new MetaTileEntityFluidHatch(            gtliteId("fluid_hatch.import.uxv"),                    UXV,                    false));
        IMPORT_FLUID_HATCH[3]                     = registerPartMetaTileEntity(44,  new MetaTileEntityFluidHatch(            gtliteId("fluid_hatch.import.opv"),                    OpV,                    false));
        EXPORT_FLUID_HATCH[0]                     = registerPartMetaTileEntity(45,  new MetaTileEntityFluidHatch(            gtliteId("fluid_hatch.export.uev"),                    UEV,                    true));
        EXPORT_FLUID_HATCH[1]                     = registerPartMetaTileEntity(46,  new MetaTileEntityFluidHatch(            gtliteId("fluid_hatch.export.uiv"),                    UIV,                    true));
        EXPORT_FLUID_HATCH[2]                     = registerPartMetaTileEntity(47,  new MetaTileEntityFluidHatch(            gtliteId("fluid_hatch.export.uxv"),                    UXV,                    true));
        EXPORT_FLUID_HATCH[3]                     = registerPartMetaTileEntity(48,  new MetaTileEntityFluidHatch(            gtliteId("fluid_hatch.export.opv"),                    OpV,                    true));
        IMPORT_ITEM_HATCH[0]                      = registerPartMetaTileEntity(49,  new MetaTileEntityItemBus(               gtliteId("item_hatch.import.uev"),                     UEV,                    false));
        IMPORT_ITEM_HATCH[1]                      = registerPartMetaTileEntity(50,  new MetaTileEntityItemBus(               gtliteId("item_hatch.import.uiv"),                     UIV,                    false));
        IMPORT_ITEM_HATCH[2]                      = registerPartMetaTileEntity(51,  new MetaTileEntityItemBus(               gtliteId("item_hatch.import.uxv"),                     UXV,                    false));
        IMPORT_ITEM_HATCH[3]                      = registerPartMetaTileEntity(52,  new MetaTileEntityItemBus(               gtliteId("item_hatch.import.opv"),                     OpV,                    false));
        EXPORT_ITEM_HATCH[0]                      = registerPartMetaTileEntity(53,  new MetaTileEntityItemBus(               gtliteId("item_hatch.export.uev"),                     UEV,                    true));
        EXPORT_ITEM_HATCH[1]                      = registerPartMetaTileEntity(54,  new MetaTileEntityItemBus(               gtliteId("item_hatch.export.uiv"),                     UIV,                    true));
        EXPORT_ITEM_HATCH[2]                      = registerPartMetaTileEntity(55,  new MetaTileEntityItemBus(               gtliteId("item_hatch.export.uxv"),                     UXV,                    true));
        EXPORT_ITEM_HATCH[3]                      = registerPartMetaTileEntity(56,  new MetaTileEntityItemBus(               gtliteId("item_hatch.export.opv"),                     OpV,                    true));
        QUADRUPLE_IMPORT_FLUID_HATCH[0]           = registerPartMetaTileEntity(57,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.import_4x.uev"),                 UEV, 4,       false));
        QUADRUPLE_IMPORT_FLUID_HATCH[1]           = registerPartMetaTileEntity(58,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.import_4x.uiv"),                 UIV, 4,       false));
        QUADRUPLE_IMPORT_FLUID_HATCH[2]           = registerPartMetaTileEntity(59,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.import_4x.uxv"),                 UXV, 4,       false));
        QUADRUPLE_IMPORT_FLUID_HATCH[3]           = registerPartMetaTileEntity(60,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.import_4x.opv"),                 OpV, 4,       false));
        QUADRUPLE_EXPORT_FLUID_HATCH[0]           = registerPartMetaTileEntity(61,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.export_4x.uev"),                 UEV, 4,       true));
        QUADRUPLE_EXPORT_FLUID_HATCH[1]           = registerPartMetaTileEntity(62,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.export_4x.uiv"),                 UIV, 4,       true));
        QUADRUPLE_EXPORT_FLUID_HATCH[2]           = registerPartMetaTileEntity(63,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.export_4x.uxv"),                 UXV, 4,       true));
        QUADRUPLE_EXPORT_FLUID_HATCH[3]           = registerPartMetaTileEntity(64,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.export_4x.opv"),                 OpV, 4,       true));
        NONUPLE_IMPORT_FLUID_HATCH[0]             = registerPartMetaTileEntity(65,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.import_9x.uev"),                 UEV, 9,       false));
        NONUPLE_IMPORT_FLUID_HATCH[1]             = registerPartMetaTileEntity(66,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.import_9x.uiv"),                 UIV, 9,       false));
        NONUPLE_IMPORT_FLUID_HATCH[2]             = registerPartMetaTileEntity(67,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.import_9x.uxv"),                 UXV, 9,       false));
        NONUPLE_IMPORT_FLUID_HATCH[3]             = registerPartMetaTileEntity(68,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.import_9x.opv"),                 OpV, 9,       false));
        NONUPLE_EXPORT_FLUID_HATCH[0]             = registerPartMetaTileEntity(69,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.export_9x.uev"),                 UEV, 9,       true));
        NONUPLE_EXPORT_FLUID_HATCH[1]             = registerPartMetaTileEntity(70,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.export_9x.uiv"),                 UIV, 9,       true));
        NONUPLE_EXPORT_FLUID_HATCH[2]             = registerPartMetaTileEntity(71,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.export_9x.uxv"),                 UXV, 9,       true));
        NONUPLE_EXPORT_FLUID_HATCH[3]             = registerPartMetaTileEntity(72,  new MetaTileEntityMultiFluidHatch(       gtliteId("fluid_hatch.export_9x.opv"),                 OpV, 9,       true));
        WIRELESS_INPUT_ENERGY_HATCH[0]            = registerPartMetaTileEntity(73,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.ulv"),           ULV, 2,       false));
        WIRELESS_INPUT_ENERGY_HATCH[1]            = registerPartMetaTileEntity(74,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.lv"),            LV,  2,       false));
        WIRELESS_INPUT_ENERGY_HATCH[2]            = registerPartMetaTileEntity(75,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.mv"),            MV,  2,       false));
        WIRELESS_INPUT_ENERGY_HATCH[3]            = registerPartMetaTileEntity(76,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.hv"),            HV,  2,       false));
        WIRELESS_INPUT_ENERGY_HATCH[4]            = registerPartMetaTileEntity(77,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.ev"),            EV,  2,       false));
        WIRELESS_INPUT_ENERGY_HATCH[5]            = registerPartMetaTileEntity(78,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.iv"),            IV,  2,       false));
        WIRELESS_INPUT_ENERGY_HATCH[6]            = registerPartMetaTileEntity(79,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.luv"),           LuV, 2,       false));
        WIRELESS_INPUT_ENERGY_HATCH[7]            = registerPartMetaTileEntity(80,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.zpm"),           ZPM, 2,       false));
        WIRELESS_INPUT_ENERGY_HATCH[8]            = registerPartMetaTileEntity(81,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.uv"),            UV,  2,       false));
        WIRELESS_INPUT_ENERGY_HATCH[9]            = registerPartMetaTileEntity(82,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.uhv"),           UHV, 2,       false));
        WIRELESS_INPUT_ENERGY_HATCH[10]           = registerPartMetaTileEntity(83,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.uev"),           UEV, 2,       false));
        WIRELESS_INPUT_ENERGY_HATCH[11]           = registerPartMetaTileEntity(84,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.uiv"),           UIV, 2,       false));
        WIRELESS_INPUT_ENERGY_HATCH[12]           = registerPartMetaTileEntity(85,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.uxv"),           UXV, 2,       false));
        WIRELESS_INPUT_ENERGY_HATCH[13]           = registerPartMetaTileEntity(86,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.opv"),           OpV, 2,       false));
        WIRELESS_INPUT_ENERGY_HATCH[14]           = registerPartMetaTileEntity(87,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input.max"),           MAX, 2,       false));
        WIRELESS_OUTPUT_ENERGY_HATCH[0]           = registerPartMetaTileEntity(88,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.ulv"),          ULV, 2,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH[1]           = registerPartMetaTileEntity(89,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.lv"),           LV,  2,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH[2]           = registerPartMetaTileEntity(90,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.mv"),           MV,  2,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH[3]           = registerPartMetaTileEntity(91,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.hv"),           HV,  2,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH[4]           = registerPartMetaTileEntity(92,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.ev"),           EV,  2,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH[5]           = registerPartMetaTileEntity(93,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.iv"),           IV,  2,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH[6]           = registerPartMetaTileEntity(94,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.luv"),          LuV, 2,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH[7]           = registerPartMetaTileEntity(95,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.zpm"),          ZPM, 2,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH[8]           = registerPartMetaTileEntity(96,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.uv"),           UV,  2,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH[9]           = registerPartMetaTileEntity(97,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.uhv"),          UHV, 2,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH[10]          = registerPartMetaTileEntity(98,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.uev"),          UEV, 2,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH[11]          = registerPartMetaTileEntity(99,  new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.uiv"),          UIV, 2,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH[12]          = registerPartMetaTileEntity(100, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.uxv"),          UXV, 2,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH[13]          = registerPartMetaTileEntity(101, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.opv"),          OpV, 2,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH[14]          = registerPartMetaTileEntity(102, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output.max"),          MAX, 2,       true));
        WIRELESS_INPUT_ENERGY_HATCH_4A[0]         = registerPartMetaTileEntity(103, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.ulv"),        ULV, 4,       false));
        WIRELESS_INPUT_ENERGY_HATCH_4A[1]         = registerPartMetaTileEntity(104, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.lv"),         LV,  4,       false));
        WIRELESS_INPUT_ENERGY_HATCH_4A[2]         = registerPartMetaTileEntity(105, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.mv"),         MV,  4,       false));
        WIRELESS_INPUT_ENERGY_HATCH_4A[3]         = registerPartMetaTileEntity(106, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.hv"),         HV,  4,       false));
        WIRELESS_INPUT_ENERGY_HATCH_4A[4]         = registerPartMetaTileEntity(107, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.ev"),         EV,  4,       false));
        WIRELESS_INPUT_ENERGY_HATCH_4A[5]         = registerPartMetaTileEntity(108, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.iv"),         IV,  4,       false));
        WIRELESS_INPUT_ENERGY_HATCH_4A[6]         = registerPartMetaTileEntity(109, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.luv"),        LuV, 4,       false));
        WIRELESS_INPUT_ENERGY_HATCH_4A[7]         = registerPartMetaTileEntity(110, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.zpm"),        ZPM, 4,       false));
        WIRELESS_INPUT_ENERGY_HATCH_4A[8]         = registerPartMetaTileEntity(111, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.uv"),         UV,  4,       false));
        WIRELESS_INPUT_ENERGY_HATCH_4A[9]         = registerPartMetaTileEntity(112, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.uhv"),        UHV, 4,       false));
        WIRELESS_INPUT_ENERGY_HATCH_4A[10]        = registerPartMetaTileEntity(113, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.uev"),        UEV, 4,       false));
        WIRELESS_INPUT_ENERGY_HATCH_4A[11]        = registerPartMetaTileEntity(114, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.uiv"),        UIV, 4,       false));
        WIRELESS_INPUT_ENERGY_HATCH_4A[12]        = registerPartMetaTileEntity(115, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.uxv"),        UXV, 4,       false));
        WIRELESS_INPUT_ENERGY_HATCH_4A[13]        = registerPartMetaTileEntity(116, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.opv"),        OpV, 4,       false));
        WIRELESS_INPUT_ENERGY_HATCH_4A[14]        = registerPartMetaTileEntity(117, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4a.max"),        MAX, 4,       false));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[0]        = registerPartMetaTileEntity(118, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.ulv"),       ULV, 4,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[1]        = registerPartMetaTileEntity(119, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.lv"),        LV,  4,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[2]        = registerPartMetaTileEntity(120, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.mv"),        MV,  4,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[3]        = registerPartMetaTileEntity(121, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.hv"),        HV,  4,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[4]        = registerPartMetaTileEntity(122, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.ev"),        EV,  4,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[5]        = registerPartMetaTileEntity(123, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.iv"),        IV,  4,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[6]        = registerPartMetaTileEntity(124, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.luv"),       LuV, 4,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[7]        = registerPartMetaTileEntity(125, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.zpm"),       ZPM, 4,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[8]        = registerPartMetaTileEntity(126, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.uv"),        UV,  4,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[9]        = registerPartMetaTileEntity(127, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.uhv"),       UHV, 4,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[10]       = registerPartMetaTileEntity(128, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.uev"),       UEV, 4,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[11]       = registerPartMetaTileEntity(129, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.uiv"),       UIV, 4,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[12]       = registerPartMetaTileEntity(130, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.uxv"),       UXV, 4,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[13]       = registerPartMetaTileEntity(131, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.opv"),       OpV, 4,       true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4A[14]       = registerPartMetaTileEntity(132, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4a.max"),       MAX, 4,       true));
        WIRELESS_INPUT_ENERGY_HATCH_16A[0]        = registerPartMetaTileEntity(133, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.ulv"),       ULV, 16,      false));
        WIRELESS_INPUT_ENERGY_HATCH_16A[1]        = registerPartMetaTileEntity(134, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.lv"),        LV,  16,      false));
        WIRELESS_INPUT_ENERGY_HATCH_16A[2]        = registerPartMetaTileEntity(135, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.mv"),        MV,  16,      false));
        WIRELESS_INPUT_ENERGY_HATCH_16A[3]        = registerPartMetaTileEntity(136, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.hv"),        HV,  16,      false));
        WIRELESS_INPUT_ENERGY_HATCH_16A[4]        = registerPartMetaTileEntity(137, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.ev"),        EV,  16,      false));
        WIRELESS_INPUT_ENERGY_HATCH_16A[5]        = registerPartMetaTileEntity(138, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.iv"),        IV,  16,      false));
        WIRELESS_INPUT_ENERGY_HATCH_16A[6]        = registerPartMetaTileEntity(139, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.luv"),       LuV, 16,      false));
        WIRELESS_INPUT_ENERGY_HATCH_16A[7]        = registerPartMetaTileEntity(140, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.zpm"),       ZPM, 16,      false));
        WIRELESS_INPUT_ENERGY_HATCH_16A[8]        = registerPartMetaTileEntity(141, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.uv"),        UV,  16,      false));
        WIRELESS_INPUT_ENERGY_HATCH_16A[9]        = registerPartMetaTileEntity(142, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.uhv"),       UHV, 16,      false));
        WIRELESS_INPUT_ENERGY_HATCH_16A[10]       = registerPartMetaTileEntity(143, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.uev"),       UEV, 16,      false));
        WIRELESS_INPUT_ENERGY_HATCH_16A[11]       = registerPartMetaTileEntity(144, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.uiv"),       UIV, 16,      false));
        WIRELESS_INPUT_ENERGY_HATCH_16A[12]       = registerPartMetaTileEntity(145, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.uxv"),       UXV, 16,      false));
        WIRELESS_INPUT_ENERGY_HATCH_16A[13]       = registerPartMetaTileEntity(146, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.opv"),       OpV, 16,      false));
        WIRELESS_INPUT_ENERGY_HATCH_16A[14]       = registerPartMetaTileEntity(147, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16a.max"),       MAX, 16,      false));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[0]       = registerPartMetaTileEntity(148, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.ulv"),      ULV, 16,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[1]       = registerPartMetaTileEntity(149, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.lv"),       LV,  16,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[2]       = registerPartMetaTileEntity(150, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.mv"),       MV,  16,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[3]       = registerPartMetaTileEntity(151, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.hv"),       HV,  16,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[4]       = registerPartMetaTileEntity(152, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.ev"),       EV,  16,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[5]       = registerPartMetaTileEntity(153, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.iv"),       IV,  16,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[6]       = registerPartMetaTileEntity(154, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.luv"),      LuV, 16,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[7]       = registerPartMetaTileEntity(155, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.zpm"),      ZPM, 16,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[8]       = registerPartMetaTileEntity(156, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.uv"),       UV,  16,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[9]       = registerPartMetaTileEntity(157, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.uhv"),      UHV, 16,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[10]      = registerPartMetaTileEntity(158, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.uev"),      UEV, 16,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[11]      = registerPartMetaTileEntity(159, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.uiv"),      UIV, 16,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[12]      = registerPartMetaTileEntity(160, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.uxv"),      UXV, 16,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[13]      = registerPartMetaTileEntity(161, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.opv"),      OpV, 16,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16A[14]      = registerPartMetaTileEntity(162, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16a.max"),      MAX, 16,      true));
        WIRELESS_INPUT_ENERGY_HATCH_64A[0]        = registerPartMetaTileEntity(163, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.ulv"),       ULV, 64,      false));
        WIRELESS_INPUT_ENERGY_HATCH_64A[1]        = registerPartMetaTileEntity(164, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.lv"),        LV,  64,      false));
        WIRELESS_INPUT_ENERGY_HATCH_64A[2]        = registerPartMetaTileEntity(165, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.mv"),        MV,  64,      false));
        WIRELESS_INPUT_ENERGY_HATCH_64A[3]        = registerPartMetaTileEntity(166, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.hv"),        HV,  64,      false));
        WIRELESS_INPUT_ENERGY_HATCH_64A[4]        = registerPartMetaTileEntity(167, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.ev"),        EV,  64,      false));
        WIRELESS_INPUT_ENERGY_HATCH_64A[5]        = registerPartMetaTileEntity(168, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.iv"),        IV,  64,      false));
        WIRELESS_INPUT_ENERGY_HATCH_64A[6]        = registerPartMetaTileEntity(169, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.luv"),       LuV, 64,      false));
        WIRELESS_INPUT_ENERGY_HATCH_64A[7]        = registerPartMetaTileEntity(170, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.zpm"),       ZPM, 64,      false));
        WIRELESS_INPUT_ENERGY_HATCH_64A[8]        = registerPartMetaTileEntity(171, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.uv"),        UV,  64,      false));
        WIRELESS_INPUT_ENERGY_HATCH_64A[9]        = registerPartMetaTileEntity(172, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.uhv"),       UHV, 64,      false));
        WIRELESS_INPUT_ENERGY_HATCH_64A[10]       = registerPartMetaTileEntity(173, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.uev"),       UEV, 64,      false));
        WIRELESS_INPUT_ENERGY_HATCH_64A[11]       = registerPartMetaTileEntity(174, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.uiv"),       UIV, 64,      false));
        WIRELESS_INPUT_ENERGY_HATCH_64A[12]       = registerPartMetaTileEntity(175, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.uxv"),       UXV, 64,      false));
        WIRELESS_INPUT_ENERGY_HATCH_64A[13]       = registerPartMetaTileEntity(176, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.opv"),       OpV, 64,      false));
        WIRELESS_INPUT_ENERGY_HATCH_64A[14]       = registerPartMetaTileEntity(177, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_64a.max"),       MAX, 64,      false));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[0]       = registerPartMetaTileEntity(178, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.ulv"),      ULV, 64,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[1]       = registerPartMetaTileEntity(179, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.lv"),       LV,  64,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[2]       = registerPartMetaTileEntity(180, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.mv"),       MV,  64,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[3]       = registerPartMetaTileEntity(181, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.hv"),       HV,  64,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[4]       = registerPartMetaTileEntity(182, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.ev"),       EV,  64,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[5]       = registerPartMetaTileEntity(183, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.iv"),       IV,  64,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[6]       = registerPartMetaTileEntity(184, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.luv"),      LuV, 64,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[7]       = registerPartMetaTileEntity(185, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.zpm"),      ZPM, 64,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[8]       = registerPartMetaTileEntity(186, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.uv"),       UV,  64,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[9]       = registerPartMetaTileEntity(187, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.uhv"),      UHV, 64,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[10]      = registerPartMetaTileEntity(188, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.uev"),      UEV, 64,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[11]      = registerPartMetaTileEntity(189, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.uiv"),      UIV, 64,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[12]      = registerPartMetaTileEntity(190, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.uxv"),      UXV, 64,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[13]      = registerPartMetaTileEntity(191, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.opv"),      OpV, 64,      true));
        WIRELESS_OUTPUT_ENERGY_HATCH_64A[14]      = registerPartMetaTileEntity(192, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_64a.max"),      MAX, 64,      true));
        WIRELESS_INPUT_ENERGY_HATCH_256A[0]       = registerPartMetaTileEntity(193, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.ulv"),      ULV, 256,     false));
        WIRELESS_INPUT_ENERGY_HATCH_256A[1]       = registerPartMetaTileEntity(194, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.lv"),       LV,  256,     false));
        WIRELESS_INPUT_ENERGY_HATCH_256A[2]       = registerPartMetaTileEntity(195, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.mv"),       MV,  256,     false));
        WIRELESS_INPUT_ENERGY_HATCH_256A[3]       = registerPartMetaTileEntity(196, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.hv"),       HV,  256,     false));
        WIRELESS_INPUT_ENERGY_HATCH_256A[4]       = registerPartMetaTileEntity(197, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.ev"),       EV,  256,     false));
        WIRELESS_INPUT_ENERGY_HATCH_256A[5]       = registerPartMetaTileEntity(198, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.iv"),       IV,  256,     false));
        WIRELESS_INPUT_ENERGY_HATCH_256A[6]       = registerPartMetaTileEntity(199, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.luv"),      LuV, 256,     false));
        WIRELESS_INPUT_ENERGY_HATCH_256A[7]       = registerPartMetaTileEntity(200, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.zpm"),      ZPM, 256,     false));
        WIRELESS_INPUT_ENERGY_HATCH_256A[8]       = registerPartMetaTileEntity(201, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.uv"),       UV,  256,     false));
        WIRELESS_INPUT_ENERGY_HATCH_256A[9]       = registerPartMetaTileEntity(202, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.uhv"),      UHV, 256,     false));
        WIRELESS_INPUT_ENERGY_HATCH_256A[10]      = registerPartMetaTileEntity(203, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.uev"),      UEV, 256,     false));
        WIRELESS_INPUT_ENERGY_HATCH_256A[11]      = registerPartMetaTileEntity(204, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.uiv"),      UIV, 256,     false));
        WIRELESS_INPUT_ENERGY_HATCH_256A[12]      = registerPartMetaTileEntity(205, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.uxv"),      UXV, 256,     false));
        WIRELESS_INPUT_ENERGY_HATCH_256A[13]      = registerPartMetaTileEntity(206, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.opv"),      OpV, 256,     false));
        WIRELESS_INPUT_ENERGY_HATCH_256A[14]      = registerPartMetaTileEntity(207, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_256a.max"),      MAX, 256,     false));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[0]      = registerPartMetaTileEntity(208, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.ulv"),     ULV, 256,     true));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[1]      = registerPartMetaTileEntity(209, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.lv"),      LV,  256,     true));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[2]      = registerPartMetaTileEntity(210, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.mv"),      MV,  256,     true));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[3]      = registerPartMetaTileEntity(211, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.hv"),      HV,  256,     true));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[4]      = registerPartMetaTileEntity(212, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.ev"),      EV,  256,     true));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[5]      = registerPartMetaTileEntity(213, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.iv"),      IV,  256,     true));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[6]      = registerPartMetaTileEntity(214, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.luv"),     LuV, 256,     true));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[7]      = registerPartMetaTileEntity(215, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.zpm"),     ZPM, 256,     true));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[8]      = registerPartMetaTileEntity(216, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.uv"),      UV,  256,     true));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[9]      = registerPartMetaTileEntity(217, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.uhv"),     UHV, 256,     true));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[10]     = registerPartMetaTileEntity(218, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.uev"),     UEV, 256,     true));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[11]     = registerPartMetaTileEntity(219, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.uiv"),     UIV, 256,     true));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[12]     = registerPartMetaTileEntity(220, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.uxv"),     UXV, 256,     true));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[13]     = registerPartMetaTileEntity(221, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.opv"),     OpV, 256,     true));
        WIRELESS_OUTPUT_ENERGY_HATCH_256A[14]     = registerPartMetaTileEntity(222, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_256a.max"),     MAX, 256,     true));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[0]      = registerPartMetaTileEntity(223, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.ulv"),     ULV, 1024,    false));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[1]      = registerPartMetaTileEntity(224, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.lv"),      LV,  1024,    false));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[2]      = registerPartMetaTileEntity(225, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.mv"),      MV,  1024,    false));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[3]      = registerPartMetaTileEntity(226, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.hv"),      HV,  1024,    false));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[4]      = registerPartMetaTileEntity(227, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.ev"),      EV,  1024,    false));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[5]      = registerPartMetaTileEntity(228, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.iv"),      IV,  1024,    false));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[6]      = registerPartMetaTileEntity(229, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.luv"),     LuV, 1024,    false));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[7]      = registerPartMetaTileEntity(230, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.zpm"),     ZPM, 1024,    false));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[8]      = registerPartMetaTileEntity(231, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.uv"),      UV,  1024,    false));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[9]      = registerPartMetaTileEntity(232, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.uhv"),     UHV, 1024,    false));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[10]     = registerPartMetaTileEntity(233, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.uev"),     UEV, 1024,    false));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[11]     = registerPartMetaTileEntity(234, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.uiv"),     UIV, 1024,    false));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[12]     = registerPartMetaTileEntity(235, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.uxv"),     UXV, 1024,    false));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[13]     = registerPartMetaTileEntity(236, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.opv"),     OpV, 1024,    false));
        WIRELESS_INPUT_ENERGY_HATCH_1024A[14]     = registerPartMetaTileEntity(237, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1024a.max"),     MAX, 1024,    false));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[0]     = registerPartMetaTileEntity(238, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.ulv"),    ULV, 1024,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[1]     = registerPartMetaTileEntity(239, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.lv"),     LV,  1024,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[2]     = registerPartMetaTileEntity(240, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.mv"),     MV,  1024,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[3]     = registerPartMetaTileEntity(241, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.hv"),     HV,  1024,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[4]     = registerPartMetaTileEntity(242, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.ev"),     EV,  1024,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[5]     = registerPartMetaTileEntity(243, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.iv"),     IV,  1024,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[6]     = registerPartMetaTileEntity(244, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.luv"),    LuV, 1024,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[7]     = registerPartMetaTileEntity(245, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.zpm"),    ZPM, 1024,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[8]     = registerPartMetaTileEntity(246, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.uv"),     UV,  1024,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[9]     = registerPartMetaTileEntity(247, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.uhv"),    UHV, 1024,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[10]    = registerPartMetaTileEntity(248, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.uev"),    UEV, 1024,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[11]    = registerPartMetaTileEntity(249, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.uiv"),    UIV, 1024,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[12]    = registerPartMetaTileEntity(250, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.uxv"),    UXV, 1024,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[13]    = registerPartMetaTileEntity(251, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.opv"),    OpV, 1024,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1024A[14]    = registerPartMetaTileEntity(252, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1024a.max"),    MAX, 1024,    true));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[0]      = registerPartMetaTileEntity(253, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.ulv"),     ULV, 4096,    false));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[1]      = registerPartMetaTileEntity(254, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.lv"),      LV,  4096,    false));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[2]      = registerPartMetaTileEntity(255, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.mv"),      MV,  4096,    false));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[3]      = registerPartMetaTileEntity(256, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.hv"),      HV,  4096,    false));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[4]      = registerPartMetaTileEntity(257, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.ev"),      EV,  4096,    false));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[5]      = registerPartMetaTileEntity(258, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.iv"),      IV,  4096,    false));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[6]      = registerPartMetaTileEntity(259, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.luv"),     LuV, 4096,    false));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[7]      = registerPartMetaTileEntity(260, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.zpm"),     ZPM, 4096,    false));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[8]      = registerPartMetaTileEntity(261, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.uv"),      UV,  4096,    false));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[9]      = registerPartMetaTileEntity(262, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.uhv"),     UHV, 4096,    false));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[10]     = registerPartMetaTileEntity(263, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.uev"),     UEV, 4096,    false));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[11]     = registerPartMetaTileEntity(264, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.uiv"),     UIV, 4096,    false));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[12]     = registerPartMetaTileEntity(265, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.uxv"),     UXV, 4096,    false));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[13]     = registerPartMetaTileEntity(266, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.opv"),     OpV, 4096,    false));
        WIRELESS_INPUT_ENERGY_HATCH_4096A[14]     = registerPartMetaTileEntity(267, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_4096a.max"),     MAX, 4096,    false));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[0]     = registerPartMetaTileEntity(268, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.ulv"),    ULV, 4096,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[1]     = registerPartMetaTileEntity(269, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.lv"),     LV,  4096,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[2]     = registerPartMetaTileEntity(270, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.mv"),     MV,  4096,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[3]     = registerPartMetaTileEntity(271, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.hv"),     HV,  4096,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[4]     = registerPartMetaTileEntity(272, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.ev"),     EV,  4096,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[5]     = registerPartMetaTileEntity(273, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.iv"),     IV,  4096,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[6]     = registerPartMetaTileEntity(274, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.luv"),    LuV, 4096,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[7]     = registerPartMetaTileEntity(275, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.zpm"),    ZPM, 4096,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[8]     = registerPartMetaTileEntity(276, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.uv"),     UV,  4096,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[9]     = registerPartMetaTileEntity(277, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.uhv"),    UHV, 4096,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[10]    = registerPartMetaTileEntity(278, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.uev"),    UEV, 4096,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[11]    = registerPartMetaTileEntity(279, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.uiv"),    UIV, 4096,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[12]    = registerPartMetaTileEntity(280, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.uxv"),    UXV, 4096,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[13]    = registerPartMetaTileEntity(281, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.opv"),    OpV, 4096,    true));
        WIRELESS_OUTPUT_ENERGY_HATCH_4096A[14]    = registerPartMetaTileEntity(282, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_4096a.max"),    MAX, 4096,    true));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[0]     = registerPartMetaTileEntity(283, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.ulv"),    ULV, 16384,   false));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[1]     = registerPartMetaTileEntity(284, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.lv"),     LV,  16384,   false));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[2]     = registerPartMetaTileEntity(285, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.mv"),     MV,  16384,   false));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[3]     = registerPartMetaTileEntity(286, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.hv"),     HV,  16384,   false));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[4]     = registerPartMetaTileEntity(287, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.ev"),     EV,  16384,   false));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[5]     = registerPartMetaTileEntity(288, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.iv"),     IV,  16384,   false));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[6]     = registerPartMetaTileEntity(289, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.luv"),    LuV, 16384,   false));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[7]     = registerPartMetaTileEntity(290, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.zpm"),    ZPM, 16384,   false));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[8]     = registerPartMetaTileEntity(291, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.uv"),     UV,  16384,   false));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[9]     = registerPartMetaTileEntity(292, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.uhv"),    UHV, 16384,   false));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[10]    = registerPartMetaTileEntity(293, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.uev"),    UEV, 16384,   false));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[11]    = registerPartMetaTileEntity(294, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.uiv"),    UIV, 16384,   false));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[12]    = registerPartMetaTileEntity(295, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.uxv"),    UXV, 16384,   false));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[13]    = registerPartMetaTileEntity(296, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.opv"),    OpV, 16384,   false));
        WIRELESS_INPUT_ENERGY_HATCH_16384A[14]    = registerPartMetaTileEntity(297, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_16384a.max"),    MAX, 16384,   false));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[0]    = registerPartMetaTileEntity(298, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.ulv"),   ULV, 16384,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[1]    = registerPartMetaTileEntity(299, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.lv"),    LV,  16384,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[2]    = registerPartMetaTileEntity(300, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.mv"),    MV,  16384,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[3]    = registerPartMetaTileEntity(301, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.hv"),    HV,  16384,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[4]    = registerPartMetaTileEntity(302, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.ev"),    EV,  16384,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[5]    = registerPartMetaTileEntity(303, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.iv"),    IV,  16384,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[6]    = registerPartMetaTileEntity(304, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.luv"),   LuV, 16384,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[7]    = registerPartMetaTileEntity(305, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.zpm"),   ZPM, 16384,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[8]    = registerPartMetaTileEntity(306, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.uv"),    UV,  16384,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[9]    = registerPartMetaTileEntity(307, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.uhv"),   UHV, 16384,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[10]   = registerPartMetaTileEntity(308, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.uev"),   UEV, 16384,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[11]   = registerPartMetaTileEntity(309, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.uiv"),   UIV, 16384,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[12]   = registerPartMetaTileEntity(310, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.uxv"),   UXV, 16384,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[13]   = registerPartMetaTileEntity(311, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.opv"),   OpV, 16384,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_16384A[14]   = registerPartMetaTileEntity(312, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_16384a.max"),   MAX, 16384,   true));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[0]     = registerPartMetaTileEntity(313, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.ulv"),    ULV, 65536,   false));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[1]     = registerPartMetaTileEntity(314, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.lv"),     LV,  65536,   false));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[2]     = registerPartMetaTileEntity(315, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.mv"),     MV,  65536,   false));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[3]     = registerPartMetaTileEntity(316, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.hv"),     HV,  65536,   false));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[4]     = registerPartMetaTileEntity(317, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.ev"),     EV,  65536,   false));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[5]     = registerPartMetaTileEntity(318, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.iv"),     IV,  65536,   false));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[6]     = registerPartMetaTileEntity(319, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.luv"),    LuV, 65536,   false));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[7]     = registerPartMetaTileEntity(320, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.zpm"),    ZPM, 65536,   false));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[8]     = registerPartMetaTileEntity(321, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.uv"),     UV,  65536,   false));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[9]     = registerPartMetaTileEntity(322, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.uhv"),    UHV, 65536,   false));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[10]    = registerPartMetaTileEntity(323, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.uev"),    UEV, 65536,   false));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[11]    = registerPartMetaTileEntity(324, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.uiv"),    UIV, 65536,   false));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[12]    = registerPartMetaTileEntity(325, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.uxv"),    UXV, 65536,   false));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[13]    = registerPartMetaTileEntity(326, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.opv"),    OpV, 65536,   false));
        WIRELESS_INPUT_ENERGY_HATCH_65536A[14]    = registerPartMetaTileEntity(327, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_65536a.max"),    MAX, 65536,   false));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[0]    = registerPartMetaTileEntity(328, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.ulv"),   ULV, 65536,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[1]    = registerPartMetaTileEntity(329, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.lv"),    LV,  65536,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[2]    = registerPartMetaTileEntity(330, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.mv"),    MV,  65536,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[3]    = registerPartMetaTileEntity(331, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.hv"),    HV,  65536,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[4]    = registerPartMetaTileEntity(332, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.ev"),    EV,  65536,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[5]    = registerPartMetaTileEntity(333, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.iv"),    IV,  65536,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[6]    = registerPartMetaTileEntity(334, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.luv"),   LuV, 65536,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[7]    = registerPartMetaTileEntity(335, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.zpm"),   ZPM, 65536,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[8]    = registerPartMetaTileEntity(336, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.uv"),    UV,  65536,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[9]    = registerPartMetaTileEntity(337, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.uhv"),   UHV, 65536,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[10]   = registerPartMetaTileEntity(338, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.uev"),   UEV, 65536,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[11]   = registerPartMetaTileEntity(339, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.uiv"),   UIV, 65536,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[12]   = registerPartMetaTileEntity(340, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.uxv"),   UXV, 65536,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[13]   = registerPartMetaTileEntity(341, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.opv"),   OpV, 65536,   true));
        WIRELESS_OUTPUT_ENERGY_HATCH_65536A[14]   = registerPartMetaTileEntity(342, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_65536a.max"),   MAX, 65536,   true));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[0]    = registerPartMetaTileEntity(343, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.ulv"),   ULV, 262144,  false));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[1]    = registerPartMetaTileEntity(344, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.lv"),    LV,  262144,  false));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[2]    = registerPartMetaTileEntity(345, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.mv"),    MV,  262144,  false));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[3]    = registerPartMetaTileEntity(346, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.hv"),    HV,  262144,  false));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[4]    = registerPartMetaTileEntity(347, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.ev"),    EV,  262144,  false));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[5]    = registerPartMetaTileEntity(348, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.iv"),    IV,  262144,  false));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[6]    = registerPartMetaTileEntity(349, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.luv"),   LuV, 262144,  false));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[7]    = registerPartMetaTileEntity(350, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.zpm"),   ZPM, 262144,  false));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[8]    = registerPartMetaTileEntity(351, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.uv"),    UV,  262144,  false));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[9]    = registerPartMetaTileEntity(352, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.uhv"),   UHV, 262144,  false));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[10]   = registerPartMetaTileEntity(353, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.uev"),   UEV, 262144,  false));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[11]   = registerPartMetaTileEntity(354, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.uiv"),   UIV, 262144,  false));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[12]   = registerPartMetaTileEntity(355, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.uxv"),   UXV, 262144,  false));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[13]   = registerPartMetaTileEntity(356, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.opv"),   OpV, 262144,  false));
        WIRELESS_INPUT_ENERGY_HATCH_262144A[14]   = registerPartMetaTileEntity(357, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_262144a.max"),   MAX, 262144,  false));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[0]   = registerPartMetaTileEntity(358, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.ulv"),  ULV, 262144,  true));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[1]   = registerPartMetaTileEntity(359, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.lv"),   LV,  262144,  true));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[2]   = registerPartMetaTileEntity(360, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.mv"),   MV,  262144,  true));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[3]   = registerPartMetaTileEntity(361, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.hv"),   HV,  262144,  true));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[4]   = registerPartMetaTileEntity(362, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.ev"),   EV,  262144,  true));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[5]   = registerPartMetaTileEntity(363, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.iv"),   IV,  262144,  true));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[6]   = registerPartMetaTileEntity(364, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.luv"),  LuV, 262144,  true));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[7]   = registerPartMetaTileEntity(365, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.zpm"),  ZPM, 262144,  true));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[8]   = registerPartMetaTileEntity(366, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.uv"),   UV,  262144,  true));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[9]   = registerPartMetaTileEntity(367, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.uhv"),  UHV, 262144,  true));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[10]  = registerPartMetaTileEntity(368, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.uev"),  UEV, 262144,  true));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[11]  = registerPartMetaTileEntity(369, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.uiv"),  UIV, 262144,  true));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[12]  = registerPartMetaTileEntity(370, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.uxv"),  UXV, 262144,  true));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[13]  = registerPartMetaTileEntity(371, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.opv"),  OpV, 262144,  true));
        WIRELESS_OUTPUT_ENERGY_HATCH_262144A[14]  = registerPartMetaTileEntity(372, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_262144a.max"),  MAX, 262144,  true));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[0]   = registerPartMetaTileEntity(373, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.ulv"),  ULV, 1048576, false));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[1]   = registerPartMetaTileEntity(374, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.lv"),   LV,  1048576, false));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[2]   = registerPartMetaTileEntity(375, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.mv"),   MV,  1048576, false));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[3]   = registerPartMetaTileEntity(376, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.hv"),   HV,  1048576, false));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[4]   = registerPartMetaTileEntity(377, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.ev"),   EV,  1048576, false));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[5]   = registerPartMetaTileEntity(378, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.iv"),   IV,  1048576, false));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[6]   = registerPartMetaTileEntity(379, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.luv"),  LuV, 1048576, false));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[7]   = registerPartMetaTileEntity(380, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.zpm"),  ZPM, 1048576, false));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[8]   = registerPartMetaTileEntity(381, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.uv"),   UV,  1048576, false));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[9]   = registerPartMetaTileEntity(382, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.uhv"),  UHV, 1048576, false));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[10]  = registerPartMetaTileEntity(383, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.uev"),  UEV, 1048576, false));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[11]  = registerPartMetaTileEntity(384, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.uiv"),  UIV, 1048576, false));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[12]  = registerPartMetaTileEntity(385, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.uxv"),  UXV, 1048576, false));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[13]  = registerPartMetaTileEntity(386, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.opv"),  OpV, 1048576, false));
        WIRELESS_INPUT_ENERGY_HATCH_1048576A[14]  = registerPartMetaTileEntity(387, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.input_1048576a.max"),  MAX, 1048576, false));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[0]  = registerPartMetaTileEntity(388, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.ulv"), ULV, 1048576, true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[1]  = registerPartMetaTileEntity(389, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.lv"),  LV,  1048576, true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[2]  = registerPartMetaTileEntity(390, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.mv"),  MV,  1048576, true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[3]  = registerPartMetaTileEntity(391, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.hv"),  HV,  1048576, true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[4]  = registerPartMetaTileEntity(392, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.ev"),  EV,  1048576, true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[5]  = registerPartMetaTileEntity(393, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.iv"),  IV,  1048576, true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[6]  = registerPartMetaTileEntity(394, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.luv"), LuV, 1048576, true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[7]  = registerPartMetaTileEntity(395, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.zpm"), ZPM, 1048576, true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[8]  = registerPartMetaTileEntity(396, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.uv"),  UV,  1048576, true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[9]  = registerPartMetaTileEntity(397, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.uhv"), UHV, 1048576, true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[10] = registerPartMetaTileEntity(398, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.uev"), UEV, 1048576, true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[11] = registerPartMetaTileEntity(399, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.uiv"), UIV, 1048576, true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[12] = registerPartMetaTileEntity(400, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.uxv"), UXV, 1048576, true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[13] = registerPartMetaTileEntity(401, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.opv"), OpV, 1048576, true));
        WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[14] = registerPartMetaTileEntity(402, new MetaTileEntityWirelessEnergyHatch(   gtliteId("wireless_energy_hatch.output_1048576a.max"), MAX, 1048576, true));
        //  Free ID: 403-499
        QC_EMPTY_COMPONENT                        = registerPartMetaTileEntity(500, new MetaTileEntityQCComponentEmpty(      gtliteId("qc_empty_component")));
        QC_COMPUTATION_COMPONENT[0]               = registerPartMetaTileEntity(501, new MetaTileEntityQCComponentComputation(gtliteId("qc_computation_component"),                                          false));
        QC_COMPUTATION_COMPONENT[1]               = registerPartMetaTileEntity(502, new MetaTileEntityQCComponentComputation(gtliteId("qc_advanced_computation_component"),                                 true));
        QC_COOLER_COMPONENT[0]                    = registerPartMetaTileEntity(503, new MetaTileEntityQCComponentCooler(     gtliteId("qc_heat_sink_component"),                                            false));
        QC_COOLER_COMPONENT[1]                    = registerPartMetaTileEntity(504, new MetaTileEntityQCComponentCooler(     gtliteId("qc_active_cooler_component"),                                        true));
        QC_BRIDGE_COMPONENT                       = registerPartMetaTileEntity(505, new MetaTileEntityQCComponentBridge(     gtliteId("qc_bridge_component")));

        //  Single Machines
        //  Range: 15000-16000
        registerSimpleMetaTileEntity(CHEMICAL_DRYER, 15000, "chemical_dryer", GTLiteRecipeMaps.CHEMICAL_DRYER_RECIPES, GTLiteTextures.CHEMICAL_DRYER_OVERLAY, true, GTLiteUtils::gtliteId, GTUtility.hvCappedTankSizeFunction);
        registerSimpleSteamMetaTileEntity(STEAM_VACUUM_CHAMBER, 15013, "vacuum_chamber", GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES, SteamProgressIndicators.COMPRESS, Textures.GAS_COLLECTOR_OVERLAY, false);
        registerSimpleMetaTileEntity(VACUUM_CHAMBER, 15015, "vacuum_chamber", GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES, Textures.GAS_COLLECTOR_OVERLAY, true, GTLiteUtils::gtliteId, GTUtility.hvCappedTankSizeFunction);
        NAQUADAH_REACTOR[0] = registerMetaTileEntity(15028, new SimpleGeneratorMetaTileEntity(gtliteId("naquadah_reactor.iv"), GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES, GTLiteTextures.NAQUADAH_REACTOR_OVERLAY, 5, GTUtility.genericGeneratorTankSizeFunction));
        NAQUADAH_REACTOR[1] = registerMetaTileEntity(15029, new SimpleGeneratorMetaTileEntity(gtliteId("naquadah_reactor.luv"), GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES, GTLiteTextures.NAQUADAH_REACTOR_OVERLAY, 6, GTUtility.genericGeneratorTankSizeFunction));
        NAQUADAH_REACTOR[2] = registerMetaTileEntity(15030, new SimpleGeneratorMetaTileEntity(gtliteId("naquadah_reactor.zpm"), GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES, GTLiteTextures.NAQUADAH_REACTOR_OVERLAY, 7, GTUtility.genericGeneratorTankSizeFunction));
        NAQUADAH_REACTOR[3] = registerMetaTileEntity(15031, new SimpleGeneratorMetaTileEntity(gtliteId("naquadah_reactor.uv"), GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES, GTLiteTextures.NAQUADAH_REACTOR_OVERLAY, 8, GTUtility.genericGeneratorTankSizeFunction));
        ROCKET_ENGINE[0] = registerMetaTileEntity(15032, new SimpleGeneratorMetaTileEntity(gtliteId("rocket_engine.hv"), GTLiteRecipeMaps.ROCKET_ENGINE_RECIPES, GTLiteTextures.ROCKET_ENGINE_OVERLAY, 3, GTUtility.genericGeneratorTankSizeFunction));
        ROCKET_ENGINE[1] = registerMetaTileEntity(15033, new SimpleGeneratorMetaTileEntity(gtliteId("rocket_engine.ev"), GTLiteRecipeMaps.ROCKET_ENGINE_RECIPES, GTLiteTextures.ROCKET_ENGINE_OVERLAY, 4, GTUtility.genericGeneratorTankSizeFunction));
        ROCKET_ENGINE[2] = registerMetaTileEntity(15034, new SimpleGeneratorMetaTileEntity(gtliteId("rocket_engine.iv"), GTLiteRecipeMaps.ROCKET_ENGINE_RECIPES, GTLiteTextures.ROCKET_ENGINE_OVERLAY, 5, GTUtility.genericGeneratorTankSizeFunction));
        registerSimpleMetaTileEntity(COMPONENT_ASSEMBLER, 15035, "component_assembler", GTLiteRecipeMaps.COMPONENT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, true, GTLiteUtils::gtliteId, GTUtility.hvCappedTankSizeFunction);
        registerSimpleMetaTileEntity(BIO_REACTOR, 15040, "bio_reactor", GTLiteRecipeMaps.BIO_REACTOR_RECIPES, GTLiteTextures.BIO_REACTOR_OVERLAY, true, GTLiteUtils::gtliteId, GTUtility.hvCappedTankSizeFunction);
        CONDENSER[0] = registerMetaTileEntity(15053, new SimpleMachineMetaTileEntity(gtliteId("condenser.uv"), GTLiteRecipeMaps.CONDENSER_RECIPES, GTLiteTextures.CONDENSER_OVERLAY, 8, true, GTUtility.genericGeneratorTankSizeFunction));
        CONDENSER[1] = registerMetaTileEntity(15054, new SimpleMachineMetaTileEntity(gtliteId("condenser.uhv"), GTLiteRecipeMaps.CONDENSER_RECIPES, GTLiteTextures.CONDENSER_OVERLAY, 9, true, GTUtility.genericGeneratorTankSizeFunction));
        CONDENSER[2] = registerMetaTileEntity(15055, new SimpleMachineMetaTileEntity(gtliteId("condenser.uev"), GTLiteRecipeMaps.CONDENSER_RECIPES, GTLiteTextures.CONDENSER_OVERLAY, 10, true, GTUtility.genericGeneratorTankSizeFunction));
        CONDENSER[3] = registerMetaTileEntity(15056, new SimpleMachineMetaTileEntity(gtliteId("condenser.uiv"), GTLiteRecipeMaps.CONDENSER_RECIPES, GTLiteTextures.CONDENSER_OVERLAY, 11, true, GTUtility.genericGeneratorTankSizeFunction));
        CONDENSER[4] = registerMetaTileEntity(15057, new SimpleMachineMetaTileEntity(gtliteId("condenser.uxv"), GTLiteRecipeMaps.CONDENSER_RECIPES, GTLiteTextures.CONDENSER_OVERLAY, 12, true, GTUtility.genericGeneratorTankSizeFunction));
        CONDENSER[5] = registerMetaTileEntity(15058, new SimpleMachineMetaTileEntity(gtliteId("condenser.opv"), GTLiteRecipeMaps.CONDENSER_RECIPES, GTLiteTextures.CONDENSER_OVERLAY, 13, true, GTUtility.genericGeneratorTankSizeFunction));
        registerSimpleMetaTileEntity(SIMULATOR, 15059, "simulator", GTLiteRecipeMaps.SIMULATOR_RECIPES, GTLiteTextures.SIMULATOR_OVERLAY, true, GTLiteUtils::gtliteId, GTUtility.hvCappedTankSizeFunction);
        BIOMASS_GENERATOR[0] = registerMetaTileEntity(15064, new SimpleGeneratorMetaTileEntity(gtliteId("biomass_generator.ev"), GTLiteRecipeMaps.BIOMASS_GENERATOR_RECIPES, GTLiteTextures.BIOMASS_GENERATOR_OVERLAY, 4, GTUtility.genericGeneratorTankSizeFunction));
        BIOMASS_GENERATOR[1] = registerMetaTileEntity(15065, new SimpleGeneratorMetaTileEntity(gtliteId("biomass_generator.iv"), GTLiteRecipeMaps.BIOMASS_GENERATOR_RECIPES, GTLiteTextures.BIOMASS_GENERATOR_OVERLAY, 5, GTUtility.genericGeneratorTankSizeFunction));
        BIOMASS_GENERATOR[2] = registerMetaTileEntity(15066, new SimpleGeneratorMetaTileEntity(gtliteId("biomass_generator.luv"), GTLiteRecipeMaps.BIOMASS_GENERATOR_RECIPES, GTLiteTextures.BIOMASS_GENERATOR_OVERLAY, 6, GTUtility.genericGeneratorTankSizeFunction));
        LIGHTNING_ROD[0] = registerMetaTileEntity(15067, new MetaTileEntityLightningRod(gtliteId("lightning_rod.hv"), HV));
        LIGHTNING_ROD[1] = registerMetaTileEntity(15068, new MetaTileEntityLightningRod(gtliteId("lightning_rod.ev"), EV));
        LIGHTNING_ROD[2] = registerMetaTileEntity(15069, new MetaTileEntityLightningRod(gtliteId("lightning_rod.iv"), IV));

        //  Multiblock Machines
        //  Range: 16001-20000
        INDUSTRIAL_DRILLING_RIG = registerMultiMetaTileEntity(1, new MetaTileEntityIndustrialDrillingRig(gtliteId("industrial_drilling_rig")));
        CATALYTIC_REFORMER = registerMultiMetaTileEntity(2, new MetaTileEntityCatalyticReformer(gtliteId("catalytic_reformer")));
        SONICATOR = registerMultiMetaTileEntity(3, new MetaTileEntitySonicator(gtliteId("sonicator")));
        HYDRAULIC_FRACKER = registerMultiMetaTileEntity(4, new MetaTileEntityHydraulicFracker(gtliteId("hydraulic_fracker"), ZPM));
        NANOSCALE_FABRICATOR = registerMultiMetaTileEntity(5, new MetaTileEntityNanoscaleFabricator(gtliteId("nanoscale_fabricator")));
        INDUSTRIAL_ROASTER = registerMultiMetaTileEntity(6, new MetaTileEntityIndustrialRoaster(gtliteId("industrial_roaster")));
        CRYSTALLIZATION_CRUCIBLE = registerMultiMetaTileEntity(7, new MetaTileEntityCrystallizationCrucible(gtliteId("crystallization_crucible")));
        CVD_UNIT = registerMultiMetaTileEntity(8, new MetaTileEntityCVDUnit(gtliteId("cvd_unit")));
        PLASMA_CVD_UNIT = registerMultiMetaTileEntity(9, new MetaTileEntityPlasmaCVDUnit(gtliteId("plasma_cvd_unit")));
        LASER_CVD_UNIT = registerMultiMetaTileEntity(10, new MetaTileEntityLaserCVDUnit(gtliteId("laser_cvd_unit")));
        BURNER_REACTOR = registerMultiMetaTileEntity(11, new MetaTileEntityBurnerReactor(gtliteId("burner_reactor")));
        CRYOGENIC_REACTOR = registerMultiMetaTileEntity(12, new MetaTileEntityCryogenicReactor(gtliteId("cryogenic_reactor")));
        LARGE_NAQUADAH_REACTOR = registerMultiMetaTileEntity(13, new MetaTileEntityLargeNaquadahReactor(gtliteId("large_naquadah_reactor")));
        HYPER_REACTOR_MK1 = registerMultiMetaTileEntity(14, new MetaTileEntityHyperReactorMkI(gtliteId("hyper_reactor_mk1")));
        HYPER_REACTOR_MK2 = registerMultiMetaTileEntity(15, new MetaTileEntityHyperReactorMkII(gtliteId("hyper_reactor_mk2")));
        HYPER_REACTOR_MK3 = registerMultiMetaTileEntity(16, new MetaTileEntityHyperReactorMkIII(gtliteId("hyper_reactor_mk3")));
        ISA_MILL = registerMultiMetaTileEntity(17, new MetaTileEntityIsaMill(gtliteId("isa_mill")));
        FLOTATION_CELL_REGULATOR = registerMultiMetaTileEntity(18, new MetaTileEntityFlotationCellRegulator(gtliteId("flotation_cell_regulator")));
        VACUUM_DRYING_FURNACE = registerMultiMetaTileEntity(19, new MetaTileEntityVacuumDryingFurnace(gtliteId("vacuum_drying_furnace")));
        VOLCANUS = registerMultiMetaTileEntity(20, new MetaTileEntityVolcanus(gtliteId("volcanus")));
        CRYOGENIC_FREEZER = registerMultiMetaTileEntity(21, new MetaTileEntityCryogenicFreezer(gtliteId("cryogenic_freezer")));
        FUEL_REFINE_FACTORY = registerMultiMetaTileEntity(22, new MetaTileEntityFuelRefineFactory(gtliteId("fuel_refine_factory")));
        ION_IMPLANTATOR = registerMultiMetaTileEntity(23, new MetaTileEntityIonImplantator(gtliteId("ion_implantator")));
        UNMANNED_DRONE_AIRPORT = registerMultiMetaTileEntity(24, new MetaTileEntityUnmannedDroneAirport(gtliteId("unmanned_drone_airport")));
        SPACE_ELEVATOR = registerMultiMetaTileEntity(25, new MetaTileEntitySpaceElevator(gtliteId("space_elevator")));
        VIRTUAL_COSMOS_SIMULATOR = registerMultiMetaTileEntity(26, new MetaTileEntityVirtualCosmosSimulator(gtliteId("virtual_cosmos_simulator")));
        COLLIDER = registerMultiMetaTileEntity(27, new MetaTileEntityCollider(gtliteId("collider")));
        DIMENSIONAL_OSCILLATOR = registerMultiMetaTileEntity(28, new MetaTileEntityDimensionalOscillator(gtliteId("dimensional_oscillator")));
        DECAY_GENERATOR = registerMultiMetaTileEntity(29, new MetaTileEntityDecayGenerator(gtliteId("decay_generator")));
        ADVANCED_FUSION_REACTOR[0] = registerMultiMetaTileEntity(30, new MetaTileEntityAdvancedFusionReactor(gtliteId("fusion_reactor_mk4"), UHV, GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_CASING_MK4), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.CRYOSTAT), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.DIVERTOR), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.VACUUM)));
        ADVANCED_FUSION_REACTOR[1] = registerMultiMetaTileEntity(31, new MetaTileEntityAdvancedFusionReactor(gtliteId("fusion_reactor_mk5"), UEV, GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_CASING_MK5), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.ADVANCED_CRYOSTAT), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.ADVANCED_DIVERTOR), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.ADVANCED_VACUUM)));
        PRECISE_ASSEMBLER = registerMultiMetaTileEntity(32, new MetaTileEntityPreciseAssembler(gtliteId("precise_assembler")));
        COMPONENT_ASSEMBLY_LINE = registerMultiMetaTileEntity(33, new MetaTileEntityComponentAssemblyLine(gtliteId("component_assembly_line")));
        ADVANCED_ASSEMBLY_LINE = registerMultiMetaTileEntity(34, new MetaTileEntityAdvancedAssemblyLine(gtliteId("advanced_assembly_line")));
        COMPRESSED_FUSION_REACTOR[0] = registerMultiMetaTileEntity(35, new MetaTileEntityCompressedFusionReactor(gtliteId("compressed_fusion_reactor.luv"), LuV, MetaBlocks.FUSION_CASING.getState(gregtech.common.blocks.BlockFusionCasing.CasingType.FUSION_CASING), MetaBlocks.FUSION_CASING.getState(gregtech.common.blocks.BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL), MetaBlocks.FRAMES.get(Materials.Naquadah).getBlock(Materials.Naquadah)));
        COMPRESSED_FUSION_REACTOR[1] = registerMultiMetaTileEntity(36, new MetaTileEntityCompressedFusionReactor(gtliteId("compressed_fusion_reactor.zpm"), ZPM, MetaBlocks.FUSION_CASING.getState(gregtech.common.blocks.BlockFusionCasing.CasingType.FUSION_CASING_MK2), MetaBlocks.FUSION_CASING.getState(gregtech.common.blocks.BlockFusionCasing.CasingType.FUSION_COIL), MetaBlocks.FRAMES.get(Materials.NaquadahEnriched).getBlock(Materials.NaquadahEnriched)));
        COMPRESSED_FUSION_REACTOR[2] = registerMultiMetaTileEntity(37, new MetaTileEntityCompressedFusionReactor(gtliteId("compressed_fusion_reactor.uv"), UV, MetaBlocks.FUSION_CASING.getState(gregtech.common.blocks.BlockFusionCasing.CasingType.FUSION_CASING_MK3), MetaBlocks.FUSION_CASING.getState(gregtech.common.blocks.BlockFusionCasing.CasingType.FUSION_COIL), MetaBlocks.FRAMES.get(Materials.Naquadria).getBlock(Materials.Naquadria)));
        COMPRESSED_FUSION_REACTOR[3] = registerMultiMetaTileEntity(38, new MetaTileEntityCompressedFusionReactor(gtliteId("compressed_fusion_reactor.uhv"), UHV, GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_CASING_MK4), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2), MetaBlocks.FRAMES.get(Materials.Tritanium).getBlock(Materials.Tritanium)));
        COMPRESSED_FUSION_REACTOR[4] = registerMultiMetaTileEntity(39, new MetaTileEntityCompressedFusionReactor(gtliteId("compressed_fusion_reactor.uev"), UEV, GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_CASING_MK5), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3), MetaBlocks.FRAMES.get(GTLiteMaterials.Orichalcum).getBlock(GTLiteMaterials.Orichalcum)));
        MEGA_ALLOY_BLAST_SMELTER = registerMultiMetaTileEntity(40, new MetaTileEntityMegaAlloyBlastSmelter(gtliteId("mega_alloy_blast_smelter")));
        MEGA_CHEMICAL_REACTOR = registerMultiMetaTileEntity(41, new MetaTileEntityMegaChemicalReactor(gtliteId("mega_chemical_reactor")));
        MEGA_OIL_CRACKING_UNIT = registerMultiMetaTileEntity(42, new MetaTileEntityMegaOilCrackingUnit(gtliteId("mega_oil_cracking_unit")));
        STELLAR_FURNACE = registerMultiMetaTileEntity(43, new MetaTileEntityStellarFurnace(gtliteId("stellar_furnace")));
        PLASMA_CONDENSER = registerMultiMetaTileEntity(44, new MetaTileEntityPlasmaCondenser(gtliteId("plasma_condenser")));
        COSMIC_RAY_DETECTOR = registerMultiMetaTileEntity(45, new MetaTileEntityCosmicRayDetector(gtliteId("cosmic_ray_detector")));
        SUPRACHRONAL_ASSEMBLY_LINE = registerMultiMetaTileEntity(46, new MetaTileEntitySuprachronalAssemblyLine(gtliteId("suprachronal_assembly_line")));
        MOLECULAR_TRANSFORMER = registerMultiMetaTileEntity(47, new MetaTileEntityMolecularTransformer(gtliteId("molecular_transformer")));
        QUANTUM_FORCE_TRANSFORMER = registerMultiMetaTileEntity(48, new MetaTileEntityQuantumForceTransformer(gtliteId("quantum_force_transformer")));
        EXTREME_INDUSTRIAL_GREENHOUSE = registerMultiMetaTileEntity(49, new MetaTileEntityExtremeIndustrialGreenhouse(gtliteId("extreme_industrial_greenhouse")));
        LARGE_STEAM_COMPRESSOR = registerMultiMetaTileEntity(50, new MetaTileEntityLargeSteamCompressor(gtliteId("large_steam_compressor")));
        LARGE_PRIMITIVE_BLAST_FURNACE = registerMultiMetaTileEntity(51, new MetaTileEntityLargePrimitiveBlastFurnace(gtliteId("large_primitive_blast_furnace")));
        HEAT_EXCHANGER = registerMultiMetaTileEntity(52, new MetaTileEntityHeatExchanger(gtliteId("heat_exchanger")));
        EXTREME_HEAT_EXCHANGER = registerMultiMetaTileEntity(53, new MetaTileEntityExtremeHeatExchanger(gtliteId("extreme_heat_exchanger")));
        MEGA_HEAT_EXCHANGER = registerMultiMetaTileEntity(54, new MetaTileEntityMegaHeatExchanger(gtliteId("mega_heat_exchanger")));
        TREE_GROWTH_FACTORY = registerMultiMetaTileEntity(55, new MetaTileEntityTreeGrowthFactory(gtliteId("tree_growth_factory")));
        LARGE_PROCESSING_FACTORY = registerMultiMetaTileEntity(56, new MetaTileEntityLargeProcessingFactory(gtliteId("large_processing_factory")));
        EXTREME_PROCESSING_ARRAY = registerMultiMetaTileEntity(57, new MetaTileEntityAdvancedProcessingArray(gtliteId("extreme_processing_array"), 0));
        ULTIMATE_PROCESSING_ARRAY = registerMultiMetaTileEntity(58, new MetaTileEntityAdvancedProcessingArray(gtliteId("ultimate_processing_array"), 1));
        LARGE_ALLOY_SMELTER = registerMultiMetaTileEntity(59, new MetaTileEntityLargeAlloySmelter(gtliteId("large_alloy_smelter")));
        MEGA_STEAM_TURBINE = registerMultiMetaTileEntity(60, new MetaTileEntityMegaTurbine(gtliteId("mega_turbine.steam"), RecipeMaps.STEAM_TURBINE_FUELS, HV, MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STEEL_TURBINE_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STEEL_GEARBOX), Textures.SOLID_STEEL_CASING, false, GTLiteTextures.MEGA_TURBINE_OVERLAY));
        MEGA_GAS_TURBINE = registerMultiMetaTileEntity(61, new MetaTileEntityMegaTurbine(gtliteId("mega_turbine.gas"), RecipeMaps.GAS_TURBINE_FUELS, EV, MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STAINLESS_TURBINE_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STAINLESS_STEEL_GEARBOX), Textures.CLEAN_STAINLESS_STEEL_CASING, true, GTLiteTextures.MEGA_TURBINE_OVERLAY));
        MEGA_PLASMA_TURBINE = registerMultiMetaTileEntity(62, new MetaTileEntityMegaTurbine(gtliteId("mega_turbine.plasma"), RecipeMaps.PLASMA_GENERATOR_FUELS, IV, MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_TURBINE_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_GEARBOX), Textures.ROBUST_TUNGSTENSTEEL_CASING, false, GTLiteTextures.MEGA_TURBINE_OVERLAY));
        HIGH_PRESSURE_STEAM_TURBINE = registerMultiMetaTileEntity(63, new MetaTileEntityLargeTurbine(gtliteId("high_pressure_steam_turbine"), GTLiteRecipeMaps.HIGH_PRESSURE_STEAM_TURBINE_RECIPES, EV, MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TITANIUM_TURBINE_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TITANIUM_GEARBOX), Textures.STABLE_TITANIUM_CASING, false, Textures.LARGE_STEAM_TURBINE_OVERLAY));
        SUPERCRITICAL_STEAM_TURBINE = registerMultiMetaTileEntity(64, new MetaTileEntityLargeTurbine(gtliteId("supercritical_steam_turbine"), GTLiteRecipeMaps.SUPERCRITICAL_STEAM_TURBINE_RECIPES, LuV, GTLiteMetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.MAR_M200_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_GEARBOX), GTLiteTextures.MAR_M200_STEEL_CASING, false, Textures.LARGE_STEAM_TURBINE_OVERLAY));
        MEGA_HIGH_PRESSURE_STEAM_TURBINE = registerMultiMetaTileEntity(65, new MetaTileEntityMegaTurbine(gtliteId("mega_high_pressure_steam_turbine"), GTLiteRecipeMaps.HIGH_PRESSURE_STEAM_TURBINE_RECIPES, EV, MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TITANIUM_TURBINE_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TITANIUM_GEARBOX), Textures.STABLE_TITANIUM_CASING, false, GTLiteTextures.MEGA_TURBINE_OVERLAY));
        MEGA_SUPERCRITICAL_STEAM_TURBINE = registerMultiMetaTileEntity(66, new MetaTileEntityMegaTurbine(gtliteId("mega_supercritical_steam_turbine"), GTLiteRecipeMaps.SUPERCRITICAL_STEAM_TURBINE_RECIPES, LuV, GTLiteMetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.MAR_M200_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_GEARBOX), GTLiteTextures.MAR_M200_STEEL_CASING, false, GTLiteTextures.MEGA_TURBINE_OVERLAY));
        LARGE_ROCKET_ENGINE = registerMultiMetaTileEntity(67, new MetaTileEntityLargeRocketEngine(gtliteId("large_rocket_engine")));
        LARGE_BIOMASS_GENERATOR = registerMultiMetaTileEntity(68, new MetaTileEntityLargeBiomassGenerator(gtliteId("large_biomass_generator")));
        NEUTRAL_NETWORK_NEXUS = registerMultiMetaTileEntity(69, new MetaTileEntityNeutralNetworkNexus(gtliteId("neutral_network_nexus")));
        PCB_FACTORY = registerMultiMetaTileEntity(70, new MetaTileEntityPCBFactory(gtliteId("pcb_factory")));
        DANGOTE_DISTILLERY = registerMultiMetaTileEntity(71, new MetaTileEntityDangoteDistillery(gtliteId("dangote_distillery")));
        AMAZON_WAREHOUSING_DEPOT = registerMultiMetaTileEntity(72, new MetaTileEntityAmazonWarehousingDepot(gtliteId("amazon_warehousing_depot")));
        ARC_FURNACE_ARRAY = registerMultiMetaTileEntity(73, new MetaTileEntityArcFurnaceArray(gtliteId("arc_furnace_array")));
        ELECTROLYTIC_TANK = registerMultiMetaTileEntity(74, new MetaTileEntityElectrolyticTank(gtliteId("electrolytic_tank")));
        TURBINE_MIXER = registerMultiMetaTileEntity(75, new MetaTileEntityTurbineMixer(gtliteId("turbine_mixer")));
        INDUSTRIAL_CENTRIFUGE = registerMultiMetaTileEntity(76, new MetaTileEntityIndustrialCentrifuge(gtliteId("industrial_centrifuge")));
        ZHUHAI_FISHING_POND = registerMultiMetaTileEntity(77, new MetaTileEntityZhuHaiFishingPond(gtliteId("zhuhai_fishing_pond")));
        COKING_TOWER = registerMultiMetaTileEntity(78, new MetaTileEntityCokingTower(gtliteId("coking_tower")));
        EXTREME_LARGE_MINER = registerMultiMetaTileEntity(79, new MetaTileEntityAdvancedLargeMiner(gtliteId("large_miner.zpm"), 7, 1, 9, 7, Materials.Protactinium, 64));
        ULTIMATE_LARGE_MINER = registerMultiMetaTileEntity(80, new MetaTileEntityAdvancedLargeMiner(gtliteId("large_miner.uv"), 8, 1, 18, 8, Materials.Einsteinium, 128));
        INFINITY_LARGE_MINER = registerMultiMetaTileEntity(81, new MetaTileEntityAdvancedLargeMiner(gtliteId("large_miner.uhv"), 9, 1, 36, 9, Materials.Mendelevium, 256));
        ADVANCED_FLUID_DRILL_RIG = registerMultiMetaTileEntity(82, new MetaTileEntityAdvancedFluidDrill(gtliteId("fluid_drill_rig.iv"), 5));
        EXTREME_FLUID_DRILL_RIG = registerMultiMetaTileEntity(83, new MetaTileEntityAdvancedFluidDrill(gtliteId("fluid_drill_rig.luv"), 6));
        ULTIMATE_FLUID_DRILL_RIG = registerMultiMetaTileEntity(84, new MetaTileEntityAdvancedFluidDrill(gtliteId("fluid_drill_rig.zpm"), 7));
        INFINITY_FLUID_DRILL_RIG = registerMultiMetaTileEntity(85, new MetaTileEntityAdvancedFluidDrill(gtliteId("fluid_drill_rig.uv"), 8));
        LARGE_CIRCUIT_ASSEMBLY_LINE = registerMultiMetaTileEntity(86, new MetaTileEntityLargeCircuitAssemblyLine(gtliteId("large_circuit_assembly_line")));
        ELECTROMAGNETIC_SEPARATION_PLANT = registerMultiMetaTileEntity(87, new MetaTileEntityElectromagneticSeparationPlant(gtliteId("electromagnetic_separation_plant")));
        LARGE_VACUUM_CHAMBER = registerMultiMetaTileEntity(88, new MetaTileEntityLargeVacuumChamber(gtliteId("large_vacuum_chamber")));
        LARGE_BIO_REACTOR = registerMultiMetaTileEntity(89, new MetaTileEntityLargeBioReactor(gtliteId("large_bio_reactor")));
        LARGE_EUV_MASK_ALIGNER = registerMultiMetaTileEntity(90, new MetaTileEntityLargeEUVMaskAligner(gtliteId("large_euv_mask_aligner")));
        ION_LITHOGRAPHY_FACTORY = registerMultiMetaTileEntity(91, new MetaTileEntityIonLithographyFactory(gtliteId("ion_lithography_factory")));
        LARGE_HIGH_PRESSURE_FORMING_UNIT = registerMultiMetaTileEntity(92, new MetaTileEntityLargeHighPressureFormingUnit(gtliteId("large_high_pressure_forming_unit")));
        LARGE_TURRENT_LATHING_FACTORY = registerMultiMetaTileEntity(93, new MetaTileEntityLargeTurrentLathingFactory(gtliteId("large_turrent_lathing_factory")));
        DYSON_SWARM = registerMultiMetaTileEntity(94, new MetaTileEntityDysonSwarm(gtliteId("dyson_swarm")));
        INTEGRATED_ORE_PROCESSOR = registerMultiMetaTileEntity(95, new MetaTileEntityIntegratedOreProcessor(gtliteId("integrated_ore_processor")));
        LARGE_FLUID_PHASE_TRANSFORMER = registerMultiMetaTileEntity(96, new MetaTileEntityLargeFluidPhaseTransformer(gtliteId("large_fluid_phase_transformer")));
        //  97 GRAVITY_FIELD_CONSTRAINT_ROLLING_PLANT
        //  98 SUPERSTRUCTURE_ASSEMBLY_PLANT
        PLANETARY_GAS_SIPHON = registerMultiMetaTileEntity(99, new MetaTileEntityPlanetaryGasSiphon(gtliteId("planetary_gas_siphon")));
        BIOWARE_SIMULATOR = registerMultiMetaTileEntity(100, new MetaTileEntityBiowareSimulator(gtliteId("bioware_simulator")));
        ALGAE_CULTURE_TANK = registerMultiMetaTileEntity(101, new MetaTileEntityAlgaeCultureTank(gtliteId("algae_culture_tank")));
        LARGE_GAS_COLLECTOR = registerMultiMetaTileEntity(102, new MetaTileEntityLargeGasCollector(gtliteId("large_gas_collector")));
        ULTIMATE_COMBUSTION_ENGINE = registerMultiMetaTileEntity(103, new MetaTileEntityUltimateCombustionEngine(gtliteId("ultimate_combustion_engine"), LuV));
        INDUSTRIAL_INDUCTION_FURNACE = registerMultiMetaTileEntity(104, new MetaTileEntityIndustrialInductionFurnace(gtliteId("industrial_induction_furnace")));
        HORIZONTAL_SHAFT_IMPACT_MACERATOR = registerMultiMetaTileEntity(105, new MetaTileEntityHorizontalShaftImpactMacerator(gtliteId("horizontal_shaft_impact_macerator")));
        TROUGH_TYPE_ORE_WASHER = registerMultiMetaTileEntity(106, new MetaTileEntityTroughTypeOreWasher(gtliteId("trough_type_ore_washer")));
        FIXED_SIFTING_PLANT = registerMultiMetaTileEntity(107, new MetaTileEntityFixedSiftingPlant(gtliteId("fixed_sifting_plant")));
        LARGE_WIREMILL_ARRAY = registerMultiMetaTileEntity(108, new MetaTileEntityLargeWiremillArray(gtliteId("large_wiremill_array")));
        CIRCULATIVE_COOLING_TOWER = registerMultiMetaTileEntity(109, new MetaTileEntityCirculativeCoolingTower(gtliteId("circulative_cooling_tower")));
        //  110 MATERIAL_TRANSMUTATION_ARRAY
        //  111
        //  112
        //  113
        //  114
        LARGE_ROCK_BREAKER = registerMultiMetaTileEntity(115, new MetaTileEntityLargeRockBreaker(gtliteId("large_rock_breaker")));
        INDUSTRIAL_ROCK_BREAKER = registerMultiMetaTileEntity(116, new MetaTileEntityIndustrialRockBreaker(gtliteId("industrial_rock_breaker")));
        //  117
        //  118
        //  119
        DIMENSIONAL_MIXER = registerMultiMetaTileEntity(120, new MetaTileEntityDimensionalMixer(gtliteId("dimensional_mixer")));
        //  Free ID: 121-149
        YOTTA_FLUID_TANK = registerMultiMetaTileEntity(150, new MetaTileEntityYottaFluidTank(gtliteId("yotta_fluid_tank")));
        //  151 TWENTY_FIVE_FLUID_TANK
        //  Free ID: 152-199
        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE = registerMultiMetaTileEntity(200, new MetaTileEntityDimensionallyTranscendentPlasmaForge(gtliteId("dimensionally_transcendent_plasma_forge")));
        QUANTUM_COMPUTER = registerMultiMetaTileEntity(201, new MetaTileEntityQuantumComputer(gtliteId("quantum_computer")));
        NICOLL_DYSON_BEAMER = registerMultiMetaTileEntity(202, new MetaTileEntityNicollDysonBeamer(gtliteId("nicoll_dyson_beamer")));
    }
}
