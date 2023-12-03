package magicbook.gtlitecore.common.metatileentities;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import magicbook.gtlitecore.api.metatileentity.single.SimpleSteamMetaTileEntity;
import magicbook.gtlitecore.api.metatileentity.single.SteamProgressIndicator;
import magicbook.gtlitecore.api.metatileentity.single.SteamProgressIndicators;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.api.utils.GTLiteUtils;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockFusionCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.metatileentities.multi.electric.*;
import magicbook.gtlitecore.common.metatileentities.multi.electric.adv.MetaTileEntityCryogenicFreezer;
import magicbook.gtlitecore.common.metatileentities.multi.electric.adv.MetaTileEntityMegaChemicalReactor;
import magicbook.gtlitecore.common.metatileentities.multi.electric.adv.MetaTileEntityVolcanus;
import magicbook.gtlitecore.common.metatileentities.multi.electric.generator.MetaTileEntityLargeNaquadahReactor;
import magicbook.gtlitecore.common.metatileentities.multi.part.MetaTileEntityGrindBallHatch;

import static gregtech.api.GTValues.*;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.gtliteId;

public class GTLiteMetaTileEntities {

    //  Multiblock Part range: 14000-14999
    public static MetaTileEntityGrindBallHatch MULTIPART_GRIND_BALL_HATCH;

    //  Single Machine range: 15000-16000
    public static SimpleMachineMetaTileEntity[] CHEMICAL_DRYER = new SimpleMachineMetaTileEntity[V.length - 1];
    public static SimpleSteamMetaTileEntity[] STEAM_VACUUM_CHAMBER = new SimpleSteamMetaTileEntity[2];
    public static SimpleMachineMetaTileEntity[] VACUUM_CHAMBER = new SimpleMachineMetaTileEntity[V.length - 1];
    public static final SimpleGeneratorMetaTileEntity[] NAQUADAH_REACTOR = new SimpleGeneratorMetaTileEntity[4];
    public static final SimpleGeneratorMetaTileEntity[] ROCKET_ENGINE = new SimpleGeneratorMetaTileEntity[3];

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

    public static MetaTileEntityIsaMill ISA_MILL;
    public static MetaTileEntityFlotationCellRegulator FLOTATION_CELL_REGULATOR;
    public static MetaTileEntityVacuumDryingFurnace VACUUM_DRYING_FURNACE;
    public static MetaTileEntityVolcanus VOLCANUS;
    public static MetaTileEntityCryogenicFreezer CRYOGENIC_FREEZER;
    public static MetaTileEntityFuelRefineFactory FUEL_REFINE_FACTORY;
    public static MetaTileEntityIonImplantator ION_IMPLANTATOR;
    public static MetaTileEntityUnmannedDroneAirport UNMANNED_DRONE_AIRPORT;

    public static final MetaTileEntityAdvancedFusionReactor[] ADVANCED_FUSION_REACTOR = new MetaTileEntityAdvancedFusionReactor[2];

    public static MetaTileEntityMegaChemicalReactor MEGA_CHEMICAL_REACTOR;

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
        //  HYPER REACTOR Mk1 14
        //  HYPER REACTOR Mk2 15
        //  HYPER REACTOR Mk3 16
        ISA_MILL = registerMultiMetaTileEntity(17, new MetaTileEntityIsaMill(gtliteId("isa_mill")));
        FLOTATION_CELL_REGULATOR = registerMultiMetaTileEntity(18, new MetaTileEntityFlotationCellRegulator(gtliteId("flotation_cell_regulator")));
        VACUUM_DRYING_FURNACE = registerMultiMetaTileEntity(19, new MetaTileEntityVacuumDryingFurnace(gtliteId("vacuum_drying_furnace")));
        VOLCANUS = registerMultiMetaTileEntity(20, new MetaTileEntityVolcanus(gtliteId("volcanus")));
        CRYOGENIC_FREEZER = registerMultiMetaTileEntity(21, new MetaTileEntityCryogenicFreezer(gtliteId("cryogenic_freezer")));
        FUEL_REFINE_FACTORY = registerMultiMetaTileEntity(22, new MetaTileEntityFuelRefineFactory(gtliteId("fuel_refine_factory")));
        ION_IMPLANTATOR = registerMultiMetaTileEntity(23, new MetaTileEntityIonImplantator(gtliteId("ion_implantator")));
        UNMANNED_DRONE_AIRPORT = registerMultiMetaTileEntity(24, new MetaTileEntityUnmannedDroneAirport(gtliteId("unmanned_drone_airport")));
        //  25 SPACE_ELEVATOR
        //  26 VIRTUAL_COSMOS_SIMULATOR
        ADVANCED_FUSION_REACTOR[0] = registerMultiMetaTileEntity(30, new MetaTileEntityAdvancedFusionReactor(gtliteId("fusion_reactor_mk4"), UHV, GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_CASING_MK4), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.CRYOSTAT), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.DIVERTOR), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.VACUUM)));
        ADVANCED_FUSION_REACTOR[1] = registerMultiMetaTileEntity(31, new MetaTileEntityAdvancedFusionReactor(gtliteId("fusion_reactor_mk5"), UEV, GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_CASING_MK5), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.ADVANCED_CRYOSTAT), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.ADVANCED_DIVERTOR), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.ADVANCED_VACUUM)));

        //  MEGA_ALLOY_SMELTER 40
        MEGA_CHEMICAL_REACTOR = registerMultiMetaTileEntity(41, new MetaTileEntityMegaChemicalReactor(gtliteId("mega_chemical_reactor")));
        //  MEGA_OIL_CRACKING_UNIT 42
    }
}
