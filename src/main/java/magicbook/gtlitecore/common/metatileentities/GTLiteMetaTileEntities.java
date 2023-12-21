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
import magicbook.gtlitecore.common.metatileentities.multi.electric.*;
import magicbook.gtlitecore.common.metatileentities.multi.electric.adv.*;
import magicbook.gtlitecore.common.metatileentities.multi.electric.generator.*;
import magicbook.gtlitecore.common.metatileentities.multi.part.*;
import magicbook.gtlitecore.common.metatileentities.multi.steam.MetaTileEntityLargePrimitiveBlastFurnace;
import magicbook.gtlitecore.common.metatileentities.multi.steam.MetaTileEntityLargeSteamCompressor;

import static gregtech.api.GTValues.*;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.gtliteId;

public class GTLiteMetaTileEntities {

    //  Multiblock Part range: 14000-14999
    public static MetaTileEntityGrindBallHatch MULTIPART_GRIND_BALL_HATCH;
    public static final MetaTileEntityReinforcedRotorHolder[] MULTIPART_REINFORCED_ROTOR_HOLDER = new MetaTileEntityReinforcedRotorHolder[8];
    public static MetaTileEntityEnergyHatch[] INPUT_ENERGY_HATCH_4A = new MetaTileEntityEnergyHatch[4];
    public static MetaTileEntityEnergyHatch[] INPUT_ENERGY_HATCH_16A = new MetaTileEntityEnergyHatch[4];
    public static MetaTileEntityEnergyHatch[] OUTPUT_ENERGY_HATCH_4A = new MetaTileEntityEnergyHatch[7];
    public static MetaTileEntityEnergyHatch[] OUTPUT_ENERGY_HATCH_16A = new MetaTileEntityEnergyHatch[8];
    public static MetaTileEntitySubstationEnergyHatch[] SUBSTATION_INPUT_ENERGY_HATCH = new MetaTileEntitySubstationEnergyHatch[4];
    public static MetaTileEntitySubstationEnergyHatch[] SUBSTATION_OUTPUT_ENERGY_HATCH = new MetaTileEntitySubstationEnergyHatch[4];
    public static MetaTileEntityFluidHatch[] IMPORT_FLUID_HATCH = new MetaTileEntityFluidHatch[4];
    public static MetaTileEntityFluidHatch[] EXPORT_FLUID_HATCH = new MetaTileEntityFluidHatch[4];
    public static MetaTileEntityItemBus[] IMPORT_ITEM_HATCH = new MetaTileEntityItemBus[4];
    public static MetaTileEntityItemBus[] EXPORT_ITEM_HATCH = new MetaTileEntityItemBus[4];

    //  Single Machine range: 15000-16000
    public static SimpleMachineMetaTileEntity[] CHEMICAL_DRYER = new SimpleMachineMetaTileEntity[V.length - 1];
    public static SimpleSteamMetaTileEntity[] STEAM_VACUUM_CHAMBER = new SimpleSteamMetaTileEntity[2];
    public static SimpleMachineMetaTileEntity[] VACUUM_CHAMBER = new SimpleMachineMetaTileEntity[V.length - 1];
    public static final SimpleGeneratorMetaTileEntity[] NAQUADAH_REACTOR = new SimpleGeneratorMetaTileEntity[4];
    public static final SimpleGeneratorMetaTileEntity[] ROCKET_ENGINE = new SimpleGeneratorMetaTileEntity[3];
    public static SimpleMachineMetaTileEntity[] COMPONENT_ASSEMBLER = new SimpleMachineMetaTileEntity[IV + 1];
    public static SimpleMachineMetaTileEntity[] BIO_REACTOR = new SimpleMachineMetaTileEntity[V.length - 1];

    //  Multiblock Machine range: 16001-20000
    public static MetaTileEntityIndustrialDrillingReg INDUSTRIAL_DRILLING_REG;
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

    public static MetaTileEntityLargeSteamCompressor LARGE_STEAM_COMPRESSOR;
    public static MetaTileEntityLargePrimitiveBlastFurnace LARGE_PRIMITIVE_BLAST_FURNACE;
    public static MetaTileEntityHeatExchanger HEAT_EXCHANGER;
    public static MetaTileEntityExtremeHeatExchanger EXTREME_HEAT_EXCHANGER;
    public static MetaTileEntityMegaHeatExchanger MEGA_HEAT_EXCHANGER;
    public static MetaTileEntityTreeGrowthFactory TREE_GROWTH_FACTORY;
    public static MetaTileEntityLargeProcessingFactory LARGE_PROCESSING_FACTORY;
    public static MetaTileEntityMegaTurbine MEGA_STEAM_TURBINE;
    public static MetaTileEntityMegaTurbine MEGA_GAS_TURBINE;
    public static MetaTileEntityMegaTurbine MEGA_PLASMA_TURBINE;
    public static MetaTileEntityLargeTurbine HIGH_PRESSURE_STEAM_TURBINE;
    public static MetaTileEntityLargeTurbine SUPERCRITICAL_STEAM_TURBINE;
    public static MetaTileEntityNeutralNetworkNexus NEUTRAL_NETWORK_NEXUS;
    public static MetaTileEntityPCBFactory PCB_FACTORY;
    public static MetaTileEntityDangoteDistillery DANGOTE_DISTILLERY;
    public static MetaTileEntityElectrolyticTank ELECTROLYTIC_TANK;
    public static MetaTileEntityTurbineMixer TURBINE_MIXER;
    public static MetaTileEntityZhuHaiFishingPond ZHUHAI_FISHING_POND;
    public static MetaTileEntityCokingTower COKING_TOWER;
    public static MetaTileEntityEnergyStorageTower ENERGY_STORAGE_TOWER;

    /**
     * @param machines Pre-init Machine name, e.g. public static SimpleSteamMetaTileEntity[] STEAM_VACUUM_CHAMBER = new SimpleSteamMetaTileEntity[2];
     * @param startId Machine id range;
     * @param name Machine name;
     * @param recipeMap Machine recipemap;
     * @param progressIndicator Progress bar;
     * @param texture Textures;
     * @param isBricked Is Bricked textures or not.
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

    //  Multiblock Part range: 14000-14999
    private static <F extends MetaTileEntity> F registerPartMetaTileEntity(int id, F mte) {
        if (id > 1000) return null;
        return registerMetaTileEntity(id + 13999, mte);
    }

    //  Multiblock Machine range: 16001-20000
    private static <T extends MultiblockControllerBase> T registerMultiMetaTileEntity(int id, T mte) {
        return registerMetaTileEntity(id + 16000, mte);
    }

    public static void init() {

        //  Multiblock Part range: 14000-14999
        MULTIPART_GRIND_BALL_HATCH = registerPartMetaTileEntity(1, new MetaTileEntityGrindBallHatch(gtliteId("grind_ball_hatch")));
        MULTIPART_REINFORCED_ROTOR_HOLDER[0] = registerPartMetaTileEntity(2, new MetaTileEntityReinforcedRotorHolder(gtliteId("reinforced_rotor_holder.luv"), LuV));
        MULTIPART_REINFORCED_ROTOR_HOLDER[1] = registerPartMetaTileEntity(3, new MetaTileEntityReinforcedRotorHolder(gtliteId("reinforced_rotor_holder.zpm"), ZPM));
        MULTIPART_REINFORCED_ROTOR_HOLDER[2] = registerPartMetaTileEntity(4, new MetaTileEntityReinforcedRotorHolder(gtliteId("reinforced_rotor_holder.uv"), UV));
        MULTIPART_REINFORCED_ROTOR_HOLDER[3] = registerPartMetaTileEntity(5, new MetaTileEntityReinforcedRotorHolder(gtliteId("reinforced_rotor_holder.uhv"), UHV));
        MULTIPART_REINFORCED_ROTOR_HOLDER[4] = registerPartMetaTileEntity(6, new MetaTileEntityReinforcedRotorHolder(gtliteId("reinforced_rotor_holder.uev"), UEV));
        MULTIPART_REINFORCED_ROTOR_HOLDER[5] = registerPartMetaTileEntity(7, new MetaTileEntityReinforcedRotorHolder(gtliteId("reinforced_rotor_holder.uiv"), UIV));
        MULTIPART_REINFORCED_ROTOR_HOLDER[6] = registerPartMetaTileEntity(8, new MetaTileEntityReinforcedRotorHolder(gtliteId("reinforced_rotor_holder.uxv"), UXV));
        MULTIPART_REINFORCED_ROTOR_HOLDER[7] = registerPartMetaTileEntity(9, new MetaTileEntityReinforcedRotorHolder(gtliteId("reinforced_rotor_holder.opv"), OpV));
        INPUT_ENERGY_HATCH_4A[0] = registerPartMetaTileEntity(10, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.input_4a.uev"), 10, 4, false));
        INPUT_ENERGY_HATCH_4A[1] = registerPartMetaTileEntity(11, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.input_4a.uiv"), 11, 4, false));
        INPUT_ENERGY_HATCH_4A[2] = registerPartMetaTileEntity(12, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.input_4a.uxv"), 12, 4, false));
        INPUT_ENERGY_HATCH_4A[3] = registerPartMetaTileEntity(13, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.input_4a.opv"), 13, 4, false));
        INPUT_ENERGY_HATCH_16A[0] = registerPartMetaTileEntity(14, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.input_16a.uev"), 10, 16, false));
        INPUT_ENERGY_HATCH_16A[1] = registerPartMetaTileEntity(15, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.input_16a.uiv"), 11, 16, false));
        INPUT_ENERGY_HATCH_16A[2] = registerPartMetaTileEntity(16, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.input_16a.uxv"), 12, 16, false));
        INPUT_ENERGY_HATCH_16A[3] = registerPartMetaTileEntity(17, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.input_16a.opv"), 13, 16, false));
        OUTPUT_ENERGY_HATCH_4A[0] = registerPartMetaTileEntity(18, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_4a.lv"), 1, 4, true));
        OUTPUT_ENERGY_HATCH_4A[1] = registerPartMetaTileEntity(19, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_4a.mv"), 2, 4, true));
        OUTPUT_ENERGY_HATCH_4A[2] = registerPartMetaTileEntity(20, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_4a.hv"), 3, 4, true));
        OUTPUT_ENERGY_HATCH_4A[3] = registerPartMetaTileEntity(21, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_4a.uev"), 10, 4, true));
        OUTPUT_ENERGY_HATCH_4A[4] = registerPartMetaTileEntity(22, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_4a.uiv"), 11, 4, true));
        OUTPUT_ENERGY_HATCH_4A[5] = registerPartMetaTileEntity(23, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_4a.uxv"), 12, 4, true));
        OUTPUT_ENERGY_HATCH_4A[6] = registerPartMetaTileEntity(24, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_4a.opv"), 13, 4, true));
        OUTPUT_ENERGY_HATCH_16A[0] = registerPartMetaTileEntity(25, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_16a.lv"), 1, 16, true));
        OUTPUT_ENERGY_HATCH_16A[1] = registerPartMetaTileEntity(26, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_16a.mv"), 2, 16, true));
        OUTPUT_ENERGY_HATCH_16A[2] = registerPartMetaTileEntity(27, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_16a.hv"), 3, 16, true));
        OUTPUT_ENERGY_HATCH_16A[3] = registerPartMetaTileEntity(28, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_16a.ev"), 4, 16, true));
        OUTPUT_ENERGY_HATCH_16A[4] = registerPartMetaTileEntity(29, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_16a.uev"), 10, 16, true));
        OUTPUT_ENERGY_HATCH_16A[5] = registerPartMetaTileEntity(30, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_16a.uiv"), 11, 16, true));
        OUTPUT_ENERGY_HATCH_16A[6] = registerPartMetaTileEntity(31, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_16a.uxv"), 12, 16, true));
        OUTPUT_ENERGY_HATCH_16A[7] = registerPartMetaTileEntity(32, new MetaTileEntityEnergyHatch(gtliteId("energy_hatch.output_16a.opv"), 13, 16, true));
        SUBSTATION_INPUT_ENERGY_HATCH[0] = registerPartMetaTileEntity(33, new MetaTileEntitySubstationEnergyHatch(gtliteId("substation_hatch.input_64a.uev"), 10, 64, false));
        SUBSTATION_INPUT_ENERGY_HATCH[1] = registerPartMetaTileEntity(34, new MetaTileEntitySubstationEnergyHatch(gtliteId("substation_hatch.input_64a.uiv"), 11, 64, false));
        SUBSTATION_INPUT_ENERGY_HATCH[2] = registerPartMetaTileEntity(35, new MetaTileEntitySubstationEnergyHatch(gtliteId("substation_hatch.input_64a.uxv"), 12, 64, false));
        SUBSTATION_INPUT_ENERGY_HATCH[3] = registerPartMetaTileEntity(36, new MetaTileEntitySubstationEnergyHatch(gtliteId("substation_hatch.input_64a.opv"), 13, 64, false));
        SUBSTATION_OUTPUT_ENERGY_HATCH[0] = registerPartMetaTileEntity(37, new MetaTileEntitySubstationEnergyHatch(gtliteId("substation_hatch.output_64a.uev"), 10, 64, false));
        SUBSTATION_OUTPUT_ENERGY_HATCH[1] = registerPartMetaTileEntity(38, new MetaTileEntitySubstationEnergyHatch(gtliteId("substation_hatch.output_64a.uiv"), 11, 64, false));
        SUBSTATION_OUTPUT_ENERGY_HATCH[2] = registerPartMetaTileEntity(39, new MetaTileEntitySubstationEnergyHatch(gtliteId("substation_hatch.output_64a.uxv"), 12, 64, false));
        SUBSTATION_OUTPUT_ENERGY_HATCH[3] = registerPartMetaTileEntity(40, new MetaTileEntitySubstationEnergyHatch(gtliteId("substation_hatch.output_64a.opv"), 13, 64, false));
        IMPORT_FLUID_HATCH[0] = registerPartMetaTileEntity(41, new MetaTileEntityFluidHatch(gtliteId("fluid_hatch.import.uev"), 10, false));
        IMPORT_FLUID_HATCH[1] = registerPartMetaTileEntity(42, new MetaTileEntityFluidHatch(gtliteId("fluid_hatch.import.uiv"), 11, false));
        IMPORT_FLUID_HATCH[2] = registerPartMetaTileEntity(43, new MetaTileEntityFluidHatch(gtliteId("fluid_hatch.import.uxv"), 12, false));
        IMPORT_FLUID_HATCH[3] = registerPartMetaTileEntity(44, new MetaTileEntityFluidHatch(gtliteId("fluid_hatch.import.opv"), 13, false));
        EXPORT_FLUID_HATCH[0] = registerPartMetaTileEntity(45, new MetaTileEntityFluidHatch(gtliteId("fluid_hatch.export.uev"), 10, true));
        EXPORT_FLUID_HATCH[1] = registerPartMetaTileEntity(46, new MetaTileEntityFluidHatch(gtliteId("fluid_hatch.export.uiv"), 11, true));
        EXPORT_FLUID_HATCH[2] = registerPartMetaTileEntity(47, new MetaTileEntityFluidHatch(gtliteId("fluid_hatch.export.uxv"), 12, true));
        EXPORT_FLUID_HATCH[3] = registerPartMetaTileEntity(48, new MetaTileEntityFluidHatch(gtliteId("fluid_hatch.export.opv"), 13, true));
        IMPORT_ITEM_HATCH[0] = registerPartMetaTileEntity(49, new MetaTileEntityItemBus(gtliteId("item_hatch.import.uev"), 10, false));
        IMPORT_ITEM_HATCH[1] = registerPartMetaTileEntity(50, new MetaTileEntityItemBus(gtliteId("item_hatch.import.uiv"), 11, false));
        IMPORT_ITEM_HATCH[2] = registerPartMetaTileEntity(51, new MetaTileEntityItemBus(gtliteId("item_hatch.import.uxv"), 12, false));
        IMPORT_ITEM_HATCH[3] = registerPartMetaTileEntity(52, new MetaTileEntityItemBus(gtliteId("item_hatch.import.opv"), 13, false));
        EXPORT_ITEM_HATCH[0] = registerPartMetaTileEntity(53, new MetaTileEntityItemBus(gtliteId("item_hatch.export.uev"), 10, false));
        EXPORT_ITEM_HATCH[1] = registerPartMetaTileEntity(54, new MetaTileEntityItemBus(gtliteId("item_hatch.export.uiv"), 11, false));
        EXPORT_ITEM_HATCH[2] = registerPartMetaTileEntity(55, new MetaTileEntityItemBus(gtliteId("item_hatch.export.uxv"), 12, false));
        EXPORT_ITEM_HATCH[3] = registerPartMetaTileEntity(56, new MetaTileEntityItemBus(gtliteId("item_hatch.export.opv"), 13, false));

        //  Single Machine range: 15000-16000
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

        //  Multiblock Machine range: 16001-20000
        INDUSTRIAL_DRILLING_REG = registerMultiMetaTileEntity(1, new MetaTileEntityIndustrialDrillingReg(gtliteId("industrial_drilling_reg")));
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
        //  26 VIRTUAL_COSMOS_SIMULATOR
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
        //  49
        LARGE_STEAM_COMPRESSOR = registerMultiMetaTileEntity(50, new MetaTileEntityLargeSteamCompressor(gtliteId("large_steam_compressor")));
        LARGE_PRIMITIVE_BLAST_FURNACE = registerMultiMetaTileEntity(51, new MetaTileEntityLargePrimitiveBlastFurnace(gtliteId("large_primitive_blast_furnace")));
        HEAT_EXCHANGER = registerMultiMetaTileEntity(52, new MetaTileEntityHeatExchanger(gtliteId("heat_exchanger")));
        EXTREME_HEAT_EXCHANGER = registerMultiMetaTileEntity(53, new MetaTileEntityExtremeHeatExchanger(gtliteId("extreme_heat_exchanger")));
        MEGA_HEAT_EXCHANGER = registerMultiMetaTileEntity(54, new MetaTileEntityMegaHeatExchanger(gtliteId("mega_heat_exchanger")));
        TREE_GROWTH_FACTORY = registerMultiMetaTileEntity(55, new MetaTileEntityTreeGrowthFactory(gtliteId("tree_growth_factory")));
        LARGE_PROCESSING_FACTORY = registerMultiMetaTileEntity(56, new MetaTileEntityLargeProcessingFactory(gtliteId("large_processing_factory")));
        //  57
        //  58
        //  59
        MEGA_STEAM_TURBINE = registerMultiMetaTileEntity(60, new MetaTileEntityMegaTurbine(gtliteId("mega_turbine.steam"), RecipeMaps.STEAM_TURBINE_FUELS, HV, MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STEEL_TURBINE_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STEEL_GEARBOX), Textures.SOLID_STEEL_CASING, false, GTLiteTextures.MEGA_TURBINE_OVERLAY));
        MEGA_GAS_TURBINE = registerMultiMetaTileEntity(61, new MetaTileEntityMegaTurbine(gtliteId("mega_turbine.gas"), RecipeMaps.GAS_TURBINE_FUELS, EV, MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STAINLESS_TURBINE_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STAINLESS_STEEL_GEARBOX), Textures.CLEAN_STAINLESS_STEEL_CASING, true, GTLiteTextures.MEGA_TURBINE_OVERLAY));
        MEGA_PLASMA_TURBINE = registerMultiMetaTileEntity(62, new MetaTileEntityMegaTurbine(gtliteId("mega_turbine.plasma"), RecipeMaps.PLASMA_GENERATOR_FUELS, IV, MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_TURBINE_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_GEARBOX), Textures.ROBUST_TUNGSTENSTEEL_CASING, false, GTLiteTextures.MEGA_TURBINE_OVERLAY));
        HIGH_PRESSURE_STEAM_TURBINE = registerMultiMetaTileEntity(63, new MetaTileEntityLargeTurbine(gtliteId("high_pressure_steam_turbine"), GTLiteRecipeMaps.HIGH_PRESSURE_STEAM_TURBINE_RECIPES, 4, MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TITANIUM_TURBINE_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TITANIUM_GEARBOX), Textures.STABLE_TITANIUM_CASING, false, Textures.LARGE_STEAM_TURBINE_OVERLAY));
        SUPERCRITICAL_STEAM_TURBINE = registerMultiMetaTileEntity(64, new MetaTileEntityLargeTurbine(gtliteId("supercritical_steam_turbine"), GTLiteRecipeMaps.SUPERCRITICAL_STEAM_TURBINE_RECIPES, 6, GTLiteMetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.MAR_M200_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_GEARBOX), GTLiteTextures.MAR_M200_STEEL_CASING, false, Textures.LARGE_STEAM_TURBINE_OVERLAY));
        //  65 MEGA_HIGH_PRESSURE_STEAM_TURBINE
        //  66 MEGA_SUPERCRITICAL_STEAM_TURBINE
        //  67
        //  68
        NEUTRAL_NETWORK_NEXUS = registerMultiMetaTileEntity(69, new MetaTileEntityNeutralNetworkNexus(gtliteId("neutral_network_nexus")));
        PCB_FACTORY = registerMultiMetaTileEntity(70, new MetaTileEntityPCBFactory(gtliteId("pcb_factory")));
        DANGOTE_DISTILLERY = registerMultiMetaTileEntity(71, new MetaTileEntityDangoteDistillery(gtliteId("dangote_distillery")));
        //  72 AMAZON WAREHOUSING DEPOT
        //  73 ARC_FURNACE_ARRAY
        ELECTROLYTIC_TANK = registerMultiMetaTileEntity(74, new MetaTileEntityElectrolyticTank(gtliteId("electrolytic_tank")));
        TURBINE_MIXER = registerMultiMetaTileEntity(75, new MetaTileEntityTurbineMixer(gtliteId("turbine_mixer")));
        //  76 INDUSTRIAL_CENTRIFUGE
        ZHUHAI_FISHING_POND = registerMultiMetaTileEntity(77, new MetaTileEntityZhuHaiFishingPond(gtliteId("zhuhai_fishing_pond")));
        COKING_TOWER = registerMultiMetaTileEntity(78, new MetaTileEntityCokingTower(gtliteId("coking_tower")));
        //  79
        //  80
        //  81
        //  82
        //  83
        //  84
        //  85
        //  86
        //  87
        //  88
        //  89
        //  90
        //  91
        //  92
        //  93
        //  94
        //  95
        //  96
        //  97
        //  98
        //  99
        ENERGY_STORAGE_TOWER = registerMultiMetaTileEntity(100, new MetaTileEntityEnergyStorageTower(gtliteId("energy_storage_tower")));
    }
}
