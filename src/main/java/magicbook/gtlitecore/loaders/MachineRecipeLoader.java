package magicbook.gtlitecore.loaders;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.*;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import magicbook.gtlitecore.common.blocks.BlockBoilerCasing;
import magicbook.gtlitecore.common.blocks.BlockCleanroomCasing;
import magicbook.gtlitecore.common.blocks.BlockComputerCasing;
import magicbook.gtlitecore.common.blocks.BlockFusionCasing;
import magicbook.gtlitecore.common.blocks.BlockMultiblockCasing;
import magicbook.gtlitecore.common.blocks.*;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.init.Items;

import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static gregtechfoodoption.machines.GTFOTileEntities.GREENHOUSE;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.*;

public class MachineRecipeLoader {
    public static void init() {
        SingleMachineRecipes();
        MultiblockControllerRecipes();
        MachineCasingRecipes();
    }

    private static void SingleMachineRecipes() {

        //  Chemical Dryer
        MetaTileEntityLoader.registerMachineRecipe(true, CHEMICAL_DRYER,
                "WCW", "SHS", "WCW",
                'W', CraftingComponent.CABLE,
                'C', CraftingComponent.CIRCUIT,
                'S', CraftingComponent.SPRING,
                'H', CraftingComponent.HULL);

        //  Steam Vacuum Chamber
        ModHandler.addShapedRecipe(true, "steam_vacuum_chamber.bronze", STEAM_VACUUM_CHAMBER[0].getStackForm(),
                "GCG", "PHP", "GWG",
                'W', new UnificationEntry(pipeTinyFluid, Bronze),
                'C', new UnificationEntry(gem, Diamond),
                'P', ELECTRIC_PUMP_ULV,
                'G', "blockGlass",
                'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_HULL));

        ModHandler.addShapedRecipe(true, "steam_vacuum_chamber.steel", STEAM_VACUUM_CHAMBER[1].getStackForm(),
                "GCG", "PHP", "GWG",
                'W', new UnificationEntry(pipeTinyFluid, TinAlloy),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV),
                'P', ELECTRIC_PUMP_ULV,
                'G', "blockGlass",
                'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_HULL));

        //  Vacuum Chamber
        MetaTileEntityLoader.registerMachineRecipe(true, VACUUM_CHAMBER,
                "GCG", "PHP", "GWG",
                'W', CraftingComponent.CABLE,
                'C', CraftingComponent.CIRCUIT,
                'P', CraftingComponent.PUMP,
                'G', CraftingComponent.GLASS,
                'H', CraftingComponent.HULL);

        //  Naquadah Reactor
        MetaTileEntityLoader.registerMachineRecipe(true, NAQUADAH_REACTOR,
                "RCR", "FHF", "WCW",
                'R', CraftingComponent.STICK_RADIOACTIVE,
                'C', CraftingComponent.CIRCUIT,
                'F', CraftingComponent.FIELD_GENERATOR,
                'W', CraftingComponent.CABLE,
                'H', CraftingComponent.HULL);

        //  Rocket Engine
        MetaTileEntityLoader.registerMachineRecipe(true, ROCKET_ENGINE,
                "PXP", "MHM", "DWD",
                'P', CraftingComponent.PISTON,
                'X', CraftingComponent.CIRCUIT,
                'M', CraftingComponent.MOTOR,
                'H', CraftingComponent.HULL,
                'D', CraftingComponent.DOUBLE_PLATE,
                'W', CraftingComponent.CABLE);

        //  Component Assembler
        MetaTileEntityLoader.registerMachineRecipe(true, COMPONENT_ASSEMBLER,
                "PPP", "CHR", "WXW",
                'P', CraftingComponent.PLATE,
                'H', CraftingComponent.HULL,
                'C', CraftingComponent.CONVEYOR,
                'R', CraftingComponent.ROBOT_ARM,
                'W', CraftingComponent.CABLE,
                'X', CraftingComponent.CIRCUIT);

        //  Bio Reactor
        MetaTileEntityLoader.registerMachineRecipe(true, BIO_REACTOR,
                "PXX", "pHp", "PMW",
                'H', CraftingComponent.HULL,
                'P', CraftingComponent.PUMP,
                'p', CraftingComponent.PIPE_NORMAL,
                'X', CraftingComponent.CIRCUIT,
                'W', CraftingComponent.CABLE,
                'M', CraftingComponent.MOTOR);

        //  Condenser
        MetaTileEntityLoader.registerMachineRecipe(true, CONDENSER,
                "RFR", "PHP", "WXW",
                'H', CraftingComponent.HULL,
                'P', CraftingComponent.PISTON,
                'F', CraftingComponent.FIELD_GENERATOR,
                'W', CraftingComponent.CABLE,
                'X', CraftingComponent.BETTER_CIRCUIT,
                'R', CraftingComponent.STICK_RADIOACTIVE);

        if (GTLiteConfigHolder.machines.enableSimulator) {
            //  Simulator
            MetaTileEntityLoader.registerMachineRecipe(true, SIMULATOR,
                    "WAW", "OHO", "WAW",
                    'A', CraftingComponent.SENSOR,
                    'W', CraftingComponent.CABLE,
                    'H', CraftingComponent.HULL,
                    'O', CraftingComponent.BETTER_CIRCUIT);
        }

        //  Biomass Generator
        MetaTileEntityLoader.registerMachineRecipe(true, BIOMASS_GENERATOR,
                "SOS", "IHP", "WTW",
                'H', CraftingComponent.HULL,
                'I', CraftingComponent.PISTON,
                'P', CraftingComponent.PUMP,
                'S', CraftingComponent.SPRING,
                'T', CraftingComponent.SAWBLADE,
                'W', CraftingComponent.CABLE,
                'O', CraftingComponent.DOUBLE_PLATE);

        //  Lightning Rod
        ModHandler.addShapedRecipe(true, "lightning_rod.iv", GTLiteMetaTileEntities.LIGHTNING_ROD[0].getStackForm(),
                "LML", "MCM", "LML",
                'L', ENERGY_LAPOTRONIC_ORB,
                'C', HULL[IV].getStackForm(),
                'M', MetaTileEntities.TRANSFORMER[5].getStackForm());

        ModHandler.addShapedRecipe(true, "lightning_rod.luv", GTLiteMetaTileEntities.LIGHTNING_ROD[1].getStackForm(),
                "LML", "MCM", "LML",
                'L', ENERGY_LAPOTRONIC_ORB_CLUSTER,
                'C', HULL[LuV].getStackForm(),
                'M', MetaTileEntities.TRANSFORMER[6].getStackForm());

        ModHandler.addShapedRecipe(true, "lightning_rod.zpm", GTLiteMetaTileEntities.LIGHTNING_ROD[2].getStackForm(),
                "LML", "MCM", "LML",
                'L', ENERGY_MODULE,
                'C', HULL[ZPM].getStackForm(),
                'M', MetaTileEntities.TRANSFORMER[7].getStackForm());
    }

    private static void MultiblockControllerRecipes() {

        //  Industrial Drilling Rig
        ModHandler.addShapedRecipe(true, "industrial_drilling_rig", INDUSTRIAL_DRILLING_RIG.getStackForm(),
                "PKP", "CHC", "MMM",
                'P', ELECTRIC_PISTON_UV.getStackForm(),
                'K', new UnificationEntry(cableGtQuadruple, YttriumBariumCuprate),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'H', HULL[UV].getStackForm(),
                'M', ELECTRIC_MOTOR_UV.getStackForm());

        //  Catalytic Reformer
        ModHandler.addShapedRecipe(true, "catalytic_reformer", CATALYTIC_REFORMER.getStackForm(),
                "MCM", "PHP", "MKM",
                'M', new UnificationEntry(pipeNormalFluid, StainlessSteel),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'P', ELECTRIC_PUMP_EV.getStackForm(),
                'H', HULL[EV].getStackForm(),
                'K', new UnificationEntry(cableGtDouble, Aluminium));

        //  Sonicator
        ModHandler.addShapedRecipe(true, "sonicator", SONICATOR.getStackForm(),
                "LFL", "PHP", "CPC",
                'L', new UnificationEntry(pipeLargeFluid, Naquadah),
                'F', FIELD_GENERATOR_UV.getStackForm(),
                'P', ELECTRIC_PUMP_UV.getStackForm(),
                'H', HULL[UV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UV));

        //  Hydraulic Fracker
        ModHandler.addShapedRecipe(true, "fracker", HYDRAULIC_FRACKER.getStackForm(),
                "CLC", "GHG", "PPP",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UV),
                'L', new UnificationEntry(pipeLargeFluid, Naquadah),
                'G', new UnificationEntry(gear, NaquadahAlloy),
                'H', HULL[ZPM].getStackForm(),
                'P', ELECTRIC_PUMP_ZPM.getStackForm());

        //  Nanoscale Fabricator
        ModHandler.addShapedRecipe(true, "nanoscale_fabricator", NANOSCALE_FABRICATOR.getStackForm(),
                "KSK", "EHE", "CFC",
                'K', new UnificationEntry(cableGtSingle, Europium),
                'S', SENSOR_UHV.getStackForm(),
                'E', EMITTER_UHV.getStackForm(),
                'H', HULL[UHV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UEV),
                'F', FIELD_GENERATOR_UHV.getStackForm());

        //  Industrial Roaster
        ModHandler.addShapedRecipe(true, "roaster", INDUSTRIAL_ROASTER.getStackForm(),
                "KSK", "CHC", "PPP",
                'K', new UnificationEntry(cableGtQuadruple, Platinum),
                'S', new UnificationEntry(spring, Tungsten),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'H', HULL[EV].getStackForm(),
                'P', new UnificationEntry(plate, TitaniumCarbide));

        //  Crystallization Crucible
        ModHandler.addShapedRecipe(true, "crystallization_crucible", CRYSTALLIZATION_CRUCIBLE.getStackForm(),
                "CMC", "LHL", "PCP",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'M', new UnificationEntry(plateDouble, MolybdenumDisilicide),
                'L', new UnificationEntry(pipeNormalFluid, Titanium),
                'H', HULL[EV].getStackForm(),
                'P', new UnificationEntry(plate, Titanium));

        //  CVD Unit
        ModHandler.addShapedRecipe(true, "cvd_unit", CVD_UNIT.getStackForm(),
                "PKP", "CHC", "ESE",
                'P', new UnificationEntry(plate, BlueSteel),
                'K', new UnificationEntry(cableGtSingle, Aluminium),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'H', HULL[EV].getStackForm(),
                'S', SENSOR_EV.getStackForm(),
                'E', EMITTER_EV.getStackForm());

        //  Plasma CVD Unit
        ModHandler.addShapedRecipe(true, "plasma_cvd_unit", PLASMA_CVD_UNIT.getStackForm(),
                "PKP", "CHC", "ESE",
                'P', new UnificationEntry(plate, Vibranium),
                'K', new UnificationEntry(cableGtSingle, SiliconCarbide),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UEV),
                'H', HULL[UHV].getStackForm(),
                'S', SENSOR_UHV.getStackForm(),
                'E', EMITTER_UHV.getStackForm());

        //  Laser CVD Unit
        ModHandler.addShapedRecipe(true, "laser_cvd_unit", LASER_CVD_UNIT.getStackForm(),
                "EOE", "CHC", "PPP",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UEV),
                'H', HULL[UHV].getStackForm(),
                'P', new UnificationEntry(plate, Orichalcum),
                'E', EMITTER_UHV.getStackForm(),
                'O', new UnificationEntry(plate, GSTGlass)
        );

        //  Burner Reactor
        ModHandler.addShapedRecipe(true, "burner_reactor", BURNER_REACTOR.getStackForm(),
                "KRK", "IHI", "CMC",
                'K', new UnificationEntry(cableGtSingle, Platinum),
                'R', new UnificationEntry(rotor, TungstenSteel),
                'I', new UnificationEntry(pipeSmallFluid, Tungsten),
                'H', HULL[IV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'M', ELECTRIC_MOTOR_IV.getStackForm());

        //  Cryogenic Reactor
        ModHandler.addShapedRecipe(true, "cryogenic_reactor", CRYOGENIC_REACTOR.getStackForm(),
                "KRK", "IHI", "CWC",
                'K', new UnificationEntry(cableGtSingle, Platinum),
                'R', new UnificationEntry(rotor, Titanium),
                'I', new UnificationEntry(pipeSmallFluid, StainlessSteel),
                'H', HULL[IV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'W', ELECTRIC_PUMP_IV.getStackForm());

        //  Large Naquadah Reactor
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Naquadria)
                .input(NAQUADAH_REACTOR[3])
                .input(ELECTRIC_PUMP_UV, 2)
                .input(FIELD_GENERATOR_UV, 2)
                .input(plate, Moscovium, 4)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(cableGtQuadruple, YttriumBariumCuprate, 4)
                .fluidInputs(Nihonium.getFluid(L * 4))
                .output(LARGE_NAQUADAH_REACTOR)
                .EUt(VA[UV])
                .duration(600)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Isa Mill
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[LuV])
                .inputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.INCONEL625_GEARBOX_CASING, 2))
                .input(plate, Inconel625, 4)
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(CONVEYOR_MODULE_LuV, 2)
                .input(gear, Inconel625, 2)
                .input(gearSmall, Inconel792, 4)
                .input(screw, Tantalloy61, 16)
                .input(foil, Titanium, 8)
                .input(cableGtQuadruple, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(Zeron100.getFluid(L * 4))
                .output(ISA_MILL)
                .scannerResearch(b -> b
                        .researchStack(MACERATOR[IV].getStackForm())
                        .EUt(VA[IV])
                        .duration(600))
                .EUt(VA[LuV])
                .duration(1200)
                .buildAndRegister();

        //  Flotation Cell Regulator
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[ZPM])
                .inputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.FLOTATION_CELL, 2))
                .input(plate, HastelloyN, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .input(gear, Stellite, 2)
                .input(gearSmall, Talonite, 4)
                .input(screw, IncoloyMA813, 16)
                .input(foil, TungstenSteel, 8)
                .input(cableGtQuadruple, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(WatertightSteel.getFluid(L * 4))
                .output(FLOTATION_CELL_REGULATOR)
                .scannerResearch(b -> b
                        .researchStack(ORE_WASHER[IV].getStackForm())
                        .EUt(VA[LuV])
                        .duration(600))
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Vacuum Drying Furnace
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[IV])
                .input(frameGt, RedSteel, 4)
                .input(plate, TitaniumTungstenCarbide, 4)
                .input(circuit, MarkerMaterials.Tier.IV, 4)
                .input(ELECTRIC_PISTON_IV, 2)
                .input(gear, TanmolyiumBetaC, 2)
                .input(gearSmall, EglinSteel, 4)
                .input(screw, AusteniticStainlessSteel904L, 16)
                .input(foil, StainlessSteel, 8)
                .input(cableGtQuadruple, Platinum, 4)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(CobaltBrass.getFluid(L * 4))
                .output(VACUUM_DRYING_FURNACE)
                .scannerResearch(b -> b
                        .researchStack(CHEMICAL_DRYER[IV].getStackForm())
                        .EUt(VA[EV])
                        .duration(600))
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Volcanus
        ModHandler.addShapedRecipe(true, "volcanus", VOLCANUS.getStackForm(),
                "GXG", "RHR", "PWP",
                'G', new UnificationEntry(gear, HSSG),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                'H', ELECTRIC_BLAST_FURNACE.getStackForm(),
                'R', ROBOT_ARM_IV.getStackForm(),
                'P', new UnificationEntry(plate, AusteniticStainlessSteel904L),
                'W', VOLTAGE_COIL_IV.getStackForm());

        //  Cryogenic Freezer
        ModHandler.addShapedRecipe(true, "cryogenic_freezer", CRYOGENIC_FREEZER.getStackForm(),
                "SXS", "EHE", "PWP",
                'S', new UnificationEntry(spring, HSSG),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                'H', VACUUM_FREEZER.getStackForm(),
                'E', ELECTRIC_PUMP_IV.getStackForm(),
                'P', new UnificationEntry(plate, TanmolyiumBetaC),
                'W', new UnificationEntry(cableGtSingle, Platinum));

        //  Fuel Refine Factory
        ModHandler.addShapedRecipe(true, "fuel_refine_factory", FUEL_REFINE_FACTORY.getStackForm(),
                "RFR", "CHC", "PWP",
                'H', MetaTileEntities.HULL[UV].getStackForm(),
                'P', ELECTRIC_PUMP_UV,
                'F', new UnificationEntry(pipeHugeFluid, Duranium),
                'R', new UnificationEntry(rotor, Orichalcum),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'W', new UnificationEntry(cableGtQuadruple, SiliconCarbide));

        //  Ion Implantator
        ModHandler.addShapedRecipe(true, "ion_implantator", ION_IMPLANTATOR.getStackForm(),
                "WCW", "EHP", "WKW",
                'E', EMITTER_UHV.getStackForm(),
                'P', ELECTRIC_PUMP_UHV.getStackForm(),
                'H', HULL[UHV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'K', new UnificationEntry(cableGtSingle, Europium),
                'W', new UnificationEntry(plate, Adamantium));

        //  Unmanned Drone Airport
        ModHandler.addShapedRecipe(true, "unmanned_drone_airport", UNMANNED_DRONE_AIRPORT.getStackForm(),
                "PDP", "CHC", "WWW",
                'H', HULL[HV].getStackForm(),
                'D', MINING_DRONE_HV.getStackForm(),
                'C', CONVEYOR_MODULE_HV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Gold),
                'P', new UnificationEntry(plate, StainlessSteel));

        //  Space Elevator
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UV])
                .input(frameGt, Pikyonium64B, 4)
                .input(MINING_DRONE_UV, 8)
                .input(plateDouble, Vibranium, 32)
                .input(UNMANNED_DRONE_AIRPORT, 16)
                .input(PLANETARY_GAS_SIPHON, 16)
                .input(GRAVITATION_ENGINE, 8)
                .input(CONVEYOR_MODULE_UV, 16)
                .input(ROBOT_ARM_UV, 16)
                .input(gear, Cinobite, 3)
                .input(gearSmall, TitanSteel, 6)
                .input(POWER_THRUSTER_ADVANCED, 32)
                .input(WIRELESS, 64)
                .input(wireGtSingle, EnrichedNaquadahTriniumEuropiumDuranide, 16)
                .fluidInputs(SolderingAlloy.getFluid(128000))
                .fluidInputs(Lubricant.getFluid(300000))
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(16000))
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(16000))
                .output(SPACE_ELEVATOR)
                .stationResearch(b -> b
                        .researchStack(UNMANNED_DRONE_AIRPORT.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UV]))
                .EUt(VA[UV])
                .duration(1200)
                .buildAndRegister();

        //  Fusion Reactor Mk IV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                .input(circuit, MarkerMaterials.Tier.UEV, 4)
                .input(GRAVI_STAR)
                .input(plateDouble, Dubnium)
                .input(FIELD_GENERATOR_UV, 2)
                .input(NANO_PIC_CHIP, 64)
                .input(NANO_PIC_CHIP, 64)
                .input(wireGtSingle, PedotPSS, 32)
                .fluidInputs(SolderingAlloy.getFluid(2304))
                .fluidInputs(Europium.getFluid(2304))
                .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                .output(ADVANCED_FUSION_REACTOR[0])
                .EUt(VA[UV])
                .duration(1000)
                .stationResearch(b -> b
                        .researchStack(FUSION_REACTOR[2].getStackForm())
                        .CWUt(192)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  Fusion Reactor Mk V
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3))
                .input(circuit, MarkerMaterials.Tier.UIV, 4)
                .input(UNSTABLE_STAR)
                .input(plateDouble, Livermorium)
                .input(FIELD_GENERATOR_UHV, 2)
                .input(PICO_PIC_CHIP, 64)
                .input(PICO_PIC_CHIP, 64)
                .input(wireGtSingle, QuantumAlloy, 32)
                .fluidInputs(SolderingAlloy.getFluid(4608))
                .fluidInputs(Americium.getFluid(4608))
                .fluidInputs(Kevlar.getFluid(L * 4))
                .output(ADVANCED_FUSION_REACTOR[1])
                .EUt(VA[UHV])
                .duration(1000)
                .stationResearch(b -> b
                        .researchStack(ADVANCED_FUSION_REACTOR[0].getStackForm())
                        .CWUt(384)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  Precise Assembler
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(LARGE_ASSEMBLER.getStackForm())
                .input(frameGt, MARM200Steel, 4)
                .input(ROBOT_ARM_IV, 2)
                .input(CONVEYOR_MODULE_IV, 2)
                .input(plate, Stellite100, 4)
                .input(gear, TanmolyiumBetaC, 4)
                .input(cableGtQuadruple, Naquadah, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 6))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(HastelloyN.getFluid(L * 2))
                .outputs(PRECISE_ASSEMBLER.getStackForm())
                .scannerResearch(b -> b
                        .researchStack(LARGE_ASSEMBLER.getStackForm())
                        .EUt(VA[IV])
                        .duration(1200))
                .EUt(VA[LuV])
                .duration(1200)
                .buildAndRegister();

        //  Component Assembly Line
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ASSEMBLY_LINE)
                .input(frameGt, Cinobite, 4)
                .input(PRECISE_ASSEMBLER, 4)
                .input(COMPONENT_ASSEMBLER[IV], 16)
                .input(ROBOT_ARM_UV, 4)
                .input(CONVEYOR_MODULE_UV, 4)
                .input(plateDouble, IncoloyMA813, 8)
                .input(plateDouble, Pikyonium64B, 8)
                .input(gear, TitanSteel)
                .input(gearSmall, TitanSteel, 3)
                .input(wireGtQuadruple, EnrichedNaquadahTriniumEuropiumDuranide, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Lubricant.getFluid(16000))
                .output(COMPONENT_ASSEMBLY_LINE)
                .EUt(VA[UV])
                .duration(1200)
                .stationResearch(b -> b
                        .researchStack(COMPONENT_ASSEMBLER[IV].getStackForm())
                        .CWUt(32)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  Advanced Assembly Line
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UV])
                .input(frameGt, Pikyonium64B, 4)
                .inputs(PRECISE_ASSEMBLER.getStackForm(4))
                .input(ASSEMBLER[IV], 8)
                .input(CIRCUIT_ASSEMBLER[IV], 8)
                .input(ROBOT_ARM_UV, 4)
                .input(EMITTER_UV, 2)
                .input(CONVEYOR_MODULE_UV, 2)
                .input(plateDouble, HY1301, 8)
                .input(plateDouble, ToxicAlloy, 8)
                .input(gear, Cinobite)
                .input(gearSmall, Botmium, 3)
                .input(wireGtQuadruple, UraniumRhodiumDinaquadide, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Lubricant.getFluid(16000))
                .output(ADVANCED_ASSEMBLY_LINE)
                .EUt(VA[UV])
                .duration(1200)
                .stationResearch(b -> b
                        .researchStack(ASSEMBLY_LINE.getStackForm())
                        .CWUt(32)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  Compressed Fusion Reactor Mk I
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[LuV])
                .input(FUSION_REACTOR[0], 16)
                .input(plate, Europium, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PUMP_LuV, 2)
                .input(FIELD_GENERATOR_LuV, 2)
                .input(cableGtQuadruple, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(Ruridit.getFluid(L * 10))
                .fluidInputs(Polybenzimidazole.getFluid(L * 4))
                .output(COMPRESSED_FUSION_REACTOR[0])
                .scannerResearch(b -> b
                        .researchStack(FUSION_REACTOR[0].getStackForm())
                        .EUt(VA[LuV])
                        .duration(1200))
                .EUt(VA[LuV])
                .duration(1200)
                .buildAndRegister();

        //  Compressed Fusion Reactor Mk II
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[ZPM])
                .input(FUSION_REACTOR[1], 16)
                .input(plate, Americium, 4)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .input(FIELD_GENERATOR_ZPM, 2)
                .input(cableGtQuadruple, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(Osmiridium.getFluid(L * 10))
                .fluidInputs(Polybenzimidazole.getFluid(L * 4))
                .output(COMPRESSED_FUSION_REACTOR[1])
                .scannerResearch(b -> b
                        .researchStack(FUSION_REACTOR[1].getStackForm())
                        .EUt(VA[ZPM])
                        .duration(1200))
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Compressed Fusion Reactor Mk III
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UV])
                .input(FUSION_REACTOR[2], 16)
                .input(plate, Dubnium, 4)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(ELECTRIC_PUMP_UV, 2)
                .input(FIELD_GENERATOR_UV, 2)
                .input(cableGtQuadruple, YttriumBariumCuprate, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(Tritanium.getFluid(L * 10))
                .fluidInputs(Polybenzimidazole.getFluid(L * 4))
                .output(COMPRESSED_FUSION_REACTOR[2])
                .stationResearch(b -> b
                        .researchStack(FUSION_REACTOR[2].getStackForm())
                        .EUt(VA[UV])
                        .CWUt(64))
                .EUt(VA[UV])
                .duration(1200)
                .buildAndRegister();

        //  Compressed Fusion Reactor Mk IV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(ADVANCED_FUSION_REACTOR[0], 16)
                .input(plate, Livermorium, 4)
                .input(circuit, MarkerMaterials.Tier.UEV, 4)
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.CRYOSTAT, 4))
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.DIVERTOR, 4))
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.VACUUM, 4))
                .input(ELECTRIC_PUMP_UHV, 2)
                .input(FIELD_GENERATOR_UHV, 2)
                .input(cableGtQuadruple, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(Adamantium.getFluid(L * 10))
                .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                .output(COMPRESSED_FUSION_REACTOR[3])
                .stationResearch(b -> b
                        .researchStack(ADVANCED_FUSION_REACTOR[0].getStackForm())
                        .EUt(VA[UHV])
                        .CWUt(128))
                .EUt(VA[UHV])
                .duration(1200)
                .buildAndRegister();

        //  Compressed Fusion Reactor Mk V
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UEV])
                .input(ADVANCED_FUSION_REACTOR[1], 16)
                .input(plate, MetastableFlerovium, 4)
                .input(circuit, MarkerMaterials.Tier.UIV, 4)
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.ADVANCED_CRYOSTAT, 4))
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.ADVANCED_DIVERTOR, 4))
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.ADVANCED_VACUUM, 4))
                .input(ELECTRIC_PUMP_UEV, 2)
                .input(FIELD_GENERATOR_UEV, 2)
                .input(cableGtQuadruple, PedotTMA, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(Mithril.getFluid(L * 10))
                .fluidInputs(Zylon.getFluid(L * 4))
                .output(COMPRESSED_FUSION_REACTOR[4])
                .stationResearch(b -> b
                        .researchStack(ADVANCED_FUSION_REACTOR[1].getStackForm())
                        .EUt(VA[UEV])
                        .CWUt(256))
                .EUt(VA[UEV])
                .duration(1200)
                .buildAndRegister();

        //  Tree Growth Factory
        ModHandler.addShapedRecipe(true, "tree_growth_factory", TREE_GROWTH_FACTORY.getStackForm(),
                "RSR", "PHP", "WCW",
                'S', COVER_SCREEN,
                'R', new UnificationEntry(spring, Steel),
                'H', HULL[MV].getStackForm(),
                'P', ELECTRIC_PUMP_MV,
                'C', new UnificationEntry(toolHeadBuzzSaw, Aluminium),
                'W', new UnificationEntry(cableGtSingle, Copper));

        //  Large Processing Factory
        ModHandler.addShapedRecipe(true, "large_processing_factory", LARGE_PROCESSING_FACTORY.getStackForm(),
                "RDR", "AHA", "WBW",
                'H', HULL[IV].getStackForm(),
                'R', ROBOT_ARM_IV,
                'A', new UnificationEntry(plate, Staballoy),
                'D', TOOL_DATA_STICK,
                'W', new UnificationEntry(cableGtSingle, NiobiumTitanium),
                'B', WORKBENCH.getStackForm());

        //  Extreme Processing Array
        ModHandler.addShapedRecipe(true, "extreme_processing_array", EXTREME_PROCESSING_ARRAY.getStackForm(),
                "RXR", "SHE", "PFP",
                'R', ROBOT_ARM_ZPM,
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.UV),
                'S', SENSOR_ZPM,
                'H', ADVANCED_PROCESSING_ARRAY.getStackForm(),
                'E', EMITTER_ZPM,
                'P', new UnificationEntry(plate, HSSS),
                'F', new UnificationEntry(pipeLargeFluid, Europium));

        //  Ultimate Processing Array
        ModHandler.addShapedRecipe(true, "ultimate_processing_array", ULTIMATE_PROCESSING_ARRAY.getStackForm(),
                "RXR", "SHE", "PFP",
                'R', ROBOT_ARM_UV,
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'S', SENSOR_UV,
                'H', EXTREME_PROCESSING_ARRAY.getStackForm(),
                'E', EMITTER_UV,
                'P', new UnificationEntry(plate, Einsteinium),
                'F', new UnificationEntry(pipeLargeFluid, Duranium));

        //  Large Alloy Smelter
        ModHandler.addShapedRecipe(true, "large_alloy_smelter", LARGE_ALLOY_SMELTER.getStackForm(),
                "PGP", "CHC", "PWP",
                'H', ALLOY_SMELTER[EV].getStackForm(),
                'P', new UnificationEntry(plate, TungstenCarbide),
                'G', new UnificationEntry(gear, TungstenCarbide),
                'W', new UnificationEntry(cableGtSingle, Aluminium),
                'C', CONVEYOR_MODULE_EV);

        //  Stellar Furnace
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs, 4)
                .inputs(VOLTAGE_COIL_UV.getStackForm(2))
                .input(circuit, MarkerMaterials.Tier.UEV, 4)
                .input(plate, IncoloyMA813, 4)
                .input(plateDouble, IncoloyMA956, 4)
                .input(gear, Tritanium, 2)
                .input(gearSmall, Tritanium, 4)
                .input(screw, Adamantium, 16)
                .input(wireFine, Seaborgium, 64)
                .input(wireFine, Seaborgium, 64)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(Lubricant.getFluid(5760))
                .fluidInputs(Ichorium.getFluid(L * 2))
                .outputs(STELLAR_FURNACE.getStackForm())
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.STELLAR_CONTAINMENT_CASING))
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .EUt(VA[UEV])
                .duration(1200)
                .buildAndRegister();

        //  Plasma Condenser
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSS)
                .input(plate, RhodiumPlatedPalladium, 4)
                .input(circuit, MarkerMaterials.Tier.UV, 2)
                .input(ELECTRIC_MOTOR_UV, 2)
                .input(ELECTRIC_PUMP_UV, 2)
                .input(SENSOR_UV, 2)
                .input(gear, TungstenCarbide, 4)
                .input(screw, Inconel792, 16)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(BlueSteel.getFluid(2880))
                .fluidInputs(CobaltBrass.getFluid(2880))
                .outputs(PLASMA_CONDENSER.getStackForm())
                .EUt(VA[UV])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(VACUUM_FREEZER.getStackForm())
                        .CWUt(30)
                        .EUt(VA[ZPM]))
                .buildAndRegister();

        //  Collider
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, MARM200Steel)
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(plate, Pikyonium64B, 4)
                .input(FIELD_GENERATOR_ZPM, 4)
                .inputs(NEUTRON_REFLECTOR.getStackForm(2))
                .input(cableGtQuadruple, VanadiumGallium, 2)
                .fluidInputs(HY1301.getFluid(L * 4))
                .outputs(COLLIDER.getStackForm())
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Decay Generator
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(plate, IncoloyMA813, 4)
                .input(FIELD_GENERATOR_ZPM, 4)
                .inputs(NEUTRON_REFLECTOR.getStackForm(2))
                .input(cableGtQuadruple, VanadiumGallium, 2)
                .fluidInputs(Tantalloy61.getFluid(L * 4))
                .outputs(DECAY_GENERATOR.getStackForm())
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Mega Oil Cracking Unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, HMS1J22Alloy, 4)
                .inputs(CRACKER.getStackForm(16))
                .input(circuit, MarkerMaterials.Tier.IV, 16)
                .input(plateDouble, HG1223, 4)
                .input(plateDouble, Staballoy, 4)
                .input(gear, MaragingSteel250, 4)
                .input(gearSmall, Stellite, 16)
                .input(cableGtQuadruple, Aluminium, 4)
                .fluidInputs(HSSS.getFluid(L * 4))
                .outputs(MEGA_OIL_CRACKING_UNIT.getStackForm())
                .EUt(VA[EV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Mega Chemical Reactor
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, MARM200Steel, 4)
                .inputs(LARGE_CHEMICAL_REACTOR.getStackForm(16))
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(plateDouble, HMS1J79Alloy, 4)
                .input(plateDouble, IncoloyDS, 4)
                .input(gear, Inconel625, 4)
                .input(gearSmall, Tantalloy61, 16)
                .input(cableGtQuadruple, VanadiumGallium, 4)
                .fluidInputs(Osmiridium.getFluid(L * 4))
                .outputs(MEGA_CHEMICAL_REACTOR.getStackForm())
                .EUt(VA[IV])
                .duration(800)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Mega Alloy Blast Smelter
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, AusteniticStainlessSteel904L, 4)
                .inputs(ALLOY_BLAST_SMELTER.getStackForm(16))
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(plateDouble, HSLASteel, 4)
                .input(plateDouble, HastelloyC59, 4)
                .input(gear, HY1301, 4)
                .input(gearSmall, TanmolyiumBetaC, 16)
                .input(wireGtQuadruple, NiobiumTitanium, 4)
                .fluidInputs(Inconel792.getFluid(L * 4))
                .outputs(MEGA_ALLOY_BLAST_SMELTER.getStackForm())
                .EUt(VA[LuV])
                .duration(1200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Molecular Transformer
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Pikyonium64B)
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING))
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(plate, Cinobite, 4)
                .input(FIELD_GENERATOR_ZPM, 4)
                .input(TOOL_DATA_ORB, 2)
                .input(wireGtQuadruple, YttriumBariumCuprate, 2)
                .fluidInputs(HastelloyC59.getFluid(L * 4))
                .output(MOLECULAR_TRANSFORMER)
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Large Steam Compressor
        ModHandler.addShapedRecipe(true, "large_steam_compressor", LARGE_STEAM_COMPRESSOR.getStackForm(),
                "CPC", "GFG", "CPC",
                'C', MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.BRONZE_BRICKS),
                'F', STEAM_COMPRESSOR_BRONZE.getStackForm(),
                'G', new UnificationEntry(gear, Potin),
                'P', ELECTRIC_PISTON_ULV);

        //  Large Primitive Blast Furnace
        ModHandler.addShapedRecipe(true, "large_primitive_blast_furnace", LARGE_PRIMITIVE_BLAST_FURNACE.getStackForm(),
                "PMP", "MFM", "PMP",
                'P', new UnificationEntry(plate, Bronze),
                'F', new UnificationEntry(frameGt, Steel),
                'M', PRIMITIVE_BLAST_FURNACE.getStackForm());

        //  Mega Steam Turbine
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(LARGE_STEAM_TURBINE)
                .input(plate, WatertightSteel, 8)
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PUMP_IV, 2)
                .input(FLUID_REGULATOR_IV, 2)
                .input(gear, TanmolyiumBetaC, 4)
                .input(screw, MARM200Steel, 16)
                .fluidInputs(BlueSteel.getFluid(L * 4))
                .output(MEGA_STEAM_TURBINE)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Mega Gas Turbine
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(LARGE_GAS_TURBINE)
                .input(plate, TantalumCarbide, 8)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PUMP_LuV, 2)
                .input(FLUID_REGULATOR_LUV, 2)
                .input(rotor, Staballoy, 4)
                .input(screw, IncoloyMA813, 16)
                .fluidInputs(Naquadah.getFluid(L * 4))
                .output(MEGA_GAS_TURBINE)
                .EUt(VA[LuV])
                .duration(1200)
                .buildAndRegister();

        //  Mega Plasma Turbine
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(LARGE_PLASMA_TURBINE)
                .input(plate, HMS1J79Alloy, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .input(FLUID_REGULATOR_ZPM, 2)
                .input(spring, Pikyonium64B, 4)
                .input(screw, Trinium, 16)
                .fluidInputs(NaquadahAlloy.getFluid(L * 4))
                .output(MEGA_PLASMA_TURBINE)
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Mega High Pressure Steam Turbine
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HIGH_PRESSURE_STEAM_TURBINE)
                .input(plate, HY1301, 8)
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PUMP_IV, 2)
                .input(FLUID_REGULATOR_IV, 2)
                .input(ring, Inconel625, 8)
                .input(screw, TungstenSteel, 16)
                .fluidInputs(RTMAlloy.getFluid(L * 4))
                .output(MEGA_HIGH_PRESSURE_STEAM_TURBINE)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Mega Supercritical Steam Turbine
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(SUPERCRITICAL_STEAM_TURBINE)
                .input(plate, IncoloyMA813, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .input(FLUID_REGULATOR_ZPM, 2)
                .input(rotor, HastelloyC59, 4)
                .input(screw, YttriumBariumCuprate, 16)
                .fluidInputs(Americium.getFluid(L * 4))
                .output(MEGA_SUPERCRITICAL_STEAM_TURBINE)
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Large Rocket Engine
        ModHandler.addShapedRecipe(true, "large_rocket_engine", LARGE_ROCKET_ENGINE.getStackForm(),
                "PAP", "HFH", "WDW",
                'H', ROCKET_ENGINE[2].getStackForm(),
                'F', new UnificationEntry(frameGt, TungstenCarbide),
                'D', POWER_THRUSTER_ADVANCED,
                'W', new UnificationEntry(cableGtQuadruple, Platinum),
                'P', ELECTRIC_PISTON_IV,
                'A', new UnificationEntry(plate, Inconel792));

        //  Large Biomass Generator
        ModHandler.addShapedRecipe(true, "large_biomass_generator", LARGE_BIOMASS_GENERATOR.getStackForm(),
                "SAS", "PBP", "WFW",
                'B', BIOMASS_GENERATOR[2].getStackForm(),
                'P', new UnificationEntry(plateDouble, Plutonium239),
                'W', new UnificationEntry(cableGtDouble, NiobiumTitanium),
                'F', FIELD_GENERATOR_LuV,
                'S', new UnificationEntry(spring, RTMAlloy),
                'A', FLUID_CELL_LARGE_TUNGSTEN_STEEL);

        //  Cosmic Ray Detector
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UIV])
                .input(plate, Hdcs, 4)
                .input(EMITTER_UIV, 2)
                .input(SENSOR_UIV, 2)
                .input(TOOL_DATA_MODULE, 4)
                .input(gear, Cinobite, 2)
                .input(wireGtSingle, QuantumAlloy, 16)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(HY1301.getFluid(2880))
                .fluidInputs(MetastableHassium.getFluid(L * 2))
                .output(COSMIC_RAY_DETECTOR)
                .stationResearch(b -> b
                        .researchStack(SCANNER[UIV].getStackForm())
                        .CWUt(128)
                        .EUt(VA[UEV]))
                .EUt(VA[UEV])
                .duration(1200)
                .buildAndRegister();

        //  Neutral Network Nexus
        ModHandler.addShapedRecipe(true, "neutral_network_nexus", NEUTRAL_NETWORK_NEXUS.getStackForm(),
                "RSR", "FHF", "WMW",
                'H', HULL[ZPM].getStackForm(),
                'S', new UnificationEntry(spring, Trinium),
                'W', new UnificationEntry(cableGtSingle, VanadiumGallium),
                'M', ELECTRIC_MOTOR_ZPM,
                'F', FIELD_GENERATOR_ZPM,
                'R', new UnificationEntry(plate, Americium));

        //  PCB Factory
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, RhodiumPlatedPalladium, 4)
                .input(CIRCUIT_ASSEMBLER[IV], 4)
                .input(plate, Osmiridium, 4)
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(gear, Ruridit, 2)
                .input(ROBOT_ARM_LuV, 4)
                .input(cableGtSingle, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(Lubricant.getFluid(12000))
                .fluidInputs(PCBCoolant.getFluid(1000))
                .output(PCB_FACTORY)
                .scannerResearch(b -> b
                        .researchStack(CIRCUIT_ASSEMBLER[IV].getStackForm())
                        .EUt(VA[IV])
                        .duration(600))
                .EUt(VA[LuV])
                .duration(1200)
                .buildAndRegister();

        //  Quantum Force Transformer
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MOLECULAR_TRANSFORMER)
                .input(frameGt, Pikyonium64B, 4)
                .input(FIELD_GENERATOR_UEV, 2)
                .input(QUANTUM_ANOMALY)
                .input(plate, AstralTitanium, 4)
                .input(plate, CelestialTungsten, 4)
                .input(circuit, MarkerMaterials.Tier.UIV, 8)
                .input(gear, Neutronium, 3)
                .input(gearSmall, TitanSteel, 6)
                .input(spring, CarbonNanotube, 2)
                .input(cableGtQuadruple, PedotTMA, 4)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(TransitionHAlloy.getFluid(2880))
                .fluidInputs(TransitionLAlloy.getFluid(2880))
                .fluidInputs(Orichalcum.getFluid(L * 4))
                .output(QUANTUM_FORCE_TRANSFORMER)
                .stationResearch(b -> b
                        .researchStack(MOLECULAR_TRANSFORMER.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UHV]))
                .EUt(VA[UEV])
                .duration(1200)
                .buildAndRegister();

        //  Dimensional Oscillator
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UIV])
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.SPACETIME_CASING, 4))
                .input(ELECTRIC_PISTON_UIV, 2)
                .input(FIELD_GENERATOR_UIV, 2)
                .input(plate, SuperheavyHAlloy, 4)
                .input(plate, SuperheavyLAlloy, 4)
                .input(circuit, MarkerMaterials.Tier.UIV, 16)
                .input(stickLong, PlutoniumPhosphide, 4)
                .input(ring, Hdcs, 32)
                .input(foil, Abyssalloy, 16)
                .input(cableGtQuadruple, Solarium, 4)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(AlkalisGroupAlloy.getFluid(2880))
                .fluidInputs(AlkalineEarthGroupAlloy.getFluid(2880))
                .fluidInputs(Adamantium.getFluid(L * 4))
                .output(DIMENSIONAL_OSCILLATOR)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.SPACETIME_CASING))
                        .EUt(VA[UEV])
                        .CWUt(576))
                .EUt(VA[UIV])
                .duration(1200)
                .buildAndRegister();

        //  Dangote Distillery
        ModHandler.addShapedRecipe(true, "dangote_distillery", DANGOTE_DISTILLERY.getStackForm(),
                "SWS", "PHP", "pGp",
                'H', LARGE_DISTILLERY.getStackForm(),
                'P', ELECTRIC_PUMP_LuV,
                'p', new UnificationEntry(plate, HG1223),
                'G', new UnificationEntry(gear, Osmiridium),
                'S', new UnificationEntry(spring, MolybdenumDisilicide),
                'W', new UnificationEntry(cableGtSingle, NiobiumTitanium));

        //  Turbine Mixer
        ModHandler.addShapedRecipe(true, "turbine_mixer", TURBINE_MIXER.getStackForm(),
                "PGP", "MHM", "WWW",
                'H', LARGE_MIXER.getStackForm(),
                'M', ELECTRIC_MOTOR_LuV,
                'W', new UnificationEntry(cableGtSingle, NiobiumTitanium),
                'P', new UnificationEntry(plate, EglinSteel),
                'G', new UnificationEntry(gear, EglinSteel));

        //  Industrial Centrirfuge
        ModHandler.addShapedRecipe(true, "industrial_centrifuge", INDUSTRIAL_CENTRIFUGE.getStackForm(),
                "PGP", "MHM", "WWW",
                'H', LARGE_CENTRIFUGE.getStackForm(),
                'M', ELECTRIC_MOTOR_LuV,
                'W', new UnificationEntry(cableGtSingle, NiobiumNitride),
                'P', new UnificationEntry(plate, Tumbaga),
                'G', new UnificationEntry(gear, Tumbaga));

        //  ZhuHai Fishing Pond
        ModHandler.addShapedRecipe(true, "zhuhai_fishing_pond", ZHUHAI_FISHING_POND.getStackForm(),
                "FRF", "PHP", "WXW",
                'H', FISHER[3].getStackForm(),
                'R', Items.FISHING_ROD,
                'P', ELECTRIC_PUMP_EV,
                'F', FLUID_FILTER,
                'W', new UnificationEntry(cableGtSingle, Aluminium),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.EV));

        //  Coking Tower
        ModHandler.addShapedRecipe(true, "coking_tower", COKING_TOWER.getStackForm(),
                "ICX", "VHV", "IPX",
                'H', PYROLYSE_OVEN.getStackForm(),
                'P', ELECTRIC_PUMP_EV,
                'I', ELECTRIC_PISTON_EV,
                'X', new UnificationEntry(wireGtQuadruple, Platinum),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'V', new UnificationEntry(pipeNormalFluid, VanadiumSteel));

        //  Heat Exchanger
        ModHandler.addShapedRecipe(true, "heat_exchanger", HEAT_EXCHANGER.getStackForm(),
                "XRX", "PHP", "pSp",
                'H', HULL[EV].getStackForm(),
                'R', new UnificationEntry(rotor, Staballoy),
                'P', ELECTRIC_PUMP_EV,
                'X', new UnificationEntry(cableGtQuadruple, Aluminium),
                'p', new UnificationEntry(plate, TungstenSteel),
                'S', new UnificationEntry(spring, HSLASteel));

        //  Extreme Heat Exchanger
        ModHandler.addShapedRecipe(true, "extreme_heat_exchanger", EXTREME_HEAT_EXCHANGER.getStackForm(),
                "XRX", "PHP", "pSp",
                'H', HULL[IV].getStackForm(),
                'R', new UnificationEntry(rotor, Inconel792),
                'P', ELECTRIC_PUMP_IV,
                'X', new UnificationEntry(cableGtQuadruple, Platinum),
                'p', new UnificationEntry(plate, HSSE),
                'S', new UnificationEntry(spring, HSSG));

        //  Mega Heat Exchanger
        ModHandler.addShapedRecipe(true, "mega_heat_exchanger", MEGA_HEAT_EXCHANGER.getStackForm(),
                "XRX", "PHP", "pSp",
                'H', HULL[LuV].getStackForm(),
                'R', new UnificationEntry(rotor, Inconel625),
                'P', ELECTRIC_PUMP_LuV,
                'X', new UnificationEntry(cableGtQuadruple, NiobiumTitanium),
                'p', new UnificationEntry(plate, HSSS),
                'S', new UnificationEntry(spring, VanadiumGallium));

        //  High Pressure Steam Turbine
        ModHandler.addShapedRecipe(true, "high_pressure_steam_turbine", HIGH_PRESSURE_STEAM_TURBINE.getStackForm(),
                "XRX", "FHF", "WDW",
                'H', HULL[EV].getStackForm(),
                'F', new UnificationEntry(pipeNormalFluid, Titanium),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'R', new UnificationEntry(rotor, Staballoy),
                'W', new UnificationEntry(cableGtSingle, Aluminium),
                'D', ELECTRIC_PUMP_EV);

        //  Supercritical Steam Turbine
        ModHandler.addShapedRecipe(true, "supercritical_steam_turbine", SUPERCRITICAL_STEAM_TURBINE.getStackForm(),
                "XPX", "GHG", "FWF",
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                'P', new UnificationEntry(plate, MARM200CeSteel),
                'G', new UnificationEntry(gear, TungstenCarbide),
                'H', HULL[LuV].getStackForm(),
                'F', new UnificationEntry(pipeLargeFluid, Inconel792),
                'W', new UnificationEntry(cableGtSingle, NiobiumTitanium));

        //  Electrolytic Tank
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, HY1301, 4)
                .input(LARGE_ELECTROLYZER, 16)
                .input(circuit, MarkerMaterials.Tier.IV, 16)
                .input(plateDouble, HastelloyC59, 4)
                .input(plateDouble, MARM200CeSteel, 4)
                .input(gear, Tantalloy61, 4)
                .input(gearSmall, MaragingSteel250, 16)
                .input(cableGtQuadruple, Platinum, 4)
                .fluidInputs(MolybdenumDisilicide.getFluid(L * 4))
                .output(ELECTROLYTIC_TANK)
                .EUt(VA[IV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Hyper Reactor Mk I
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HastelloyC276)
                .input(LARGE_NAQUADAH_REACTOR)
                .input(plate, Meitnerium, 4)
                .input(plate, Vibranium, 4)
                .input(circuit, MarkerMaterials.Tier.UEV, 4)
                .input(ELECTRIC_PUMP_UHV, 2)
                .input(FIELD_GENERATOR_UHV, 2)
                .input(NANO_PIC_CHIP, 16)
                .input(gear, Roentgenium, 4)
                .input(screw, Dubnium, 16)
                .input(cableGtQuadruple, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(Trinaquadalloy.getFluid(L * 20))
                .output(HYPER_REACTOR_MK1)
                .stationResearch(b -> b
                        .researchStack(LARGE_NAQUADAH_REACTOR.getStackForm())
                        .EUt(VA[UHV])
                        .CWUt(32))
                .EUt(VA[UHV])
                .duration(600)
                .buildAndRegister();

        //  Hyper Reactor Mk II
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HastelloyX78)
                .input(HYPER_REACTOR_MK1)
                .input(plate, Nobelium, 4)
                .input(plate, Rhugnor, 4)
                .input(circuit, MarkerMaterials.Tier.UIV, 4)
                .input(ELECTRIC_PUMP_UEV, 2)
                .input(FIELD_GENERATOR_UEV, 2)
                .input(PICO_PIC_CHIP, 16)
                .input(gear, Lawrencium, 4)
                .input(screw, Livermorium, 16)
                .input(cableGtQuadruple, PedotTMA, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(Tairitsium.getFluid(L * 20))
                .fluidInputs(Polyetheretherketone.getFluid(L * 10))
                .output(HYPER_REACTOR_MK2)
                .stationResearch(b -> b
                        .researchStack(HYPER_REACTOR_MK1.getStackForm())
                        .EUt(VA[UEV])
                        .CWUt(64))
                .EUt(VA[UEV])
                .duration(600)
                .buildAndRegister();

        //  Hyper Reactor Mk III
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HastelloyK243)
                .input(HYPER_REACTOR_MK2)
                .input(plate, MetastableHassium, 4)
                .input(plate, Hypogen, 4)
                .input(circuit, MarkerMaterials.Tier.UXV, 4)
                .input(ELECTRIC_PUMP_UIV, 2)
                .input(FIELD_GENERATOR_UIV, 2)
                .input(FEMTO_PIC_CHIP, 16)
                .input(gear, MetastableOganesson, 4)
                .input(screw, MetastableFlerovium, 16)
                .input(cableGtQuadruple, Solarium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(BlackTitanium.getFluid(L * 20))
                .fluidInputs(ArceusAlloy2B.getFluid(L * 10))
                .fluidInputs(Zylon.getFluid(L * 5))
                .output(HYPER_REACTOR_MK3)
                .stationResearch(b -> b
                        .researchStack(HYPER_REACTOR_MK2.getStackForm())
                        .EUt(VA[UIV])
                        .CWUt(128))
                .EUt(VA[UIV])
                .duration(600)
                .buildAndRegister();

        //  Bioware Simulator
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[LuV])
                .input(SIMULATOR[IV], 4)
                .input(plate, Osmiridium, 4)
                .input(FIELD_GENERATOR_LuV, 2)
                .input(swarm, Carbon)
                .input(circuit, MarkerMaterials.Tier.LuV, 2)
                .input(wireFine, Kanthal, 16)
                .fluidInputs(KPR.getFluid(L * 4))
                .output(BIOWARE_SIMULATOR)
                .EUt(VA[LuV])
                .duration(300)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Amazon Warehousing Depot
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, AusteniticStainlessSteel904L, 4)
                .input(LARGE_PACKAGER, 16)
                .input(circuit, MarkerMaterials.Tier.EV, 16)
                .input(plateDouble, TitaniumCarbide, 4)
                .input(plateDouble, RedSteel, 4)
                .input(gear, Rhodium, 4)
                .input(gearSmall, HSSS, 16)
                .input(cableGtQuadruple, Electrum, 4)
                .fluidInputs(HastelloyC276.getFluid(L * 4))
                .output(AMAZON_WAREHOUSING_DEPOT)
                .EUt(VA[EV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Algae Culture Tank
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[ZPM])
                .input(plate, Actinium, 4)
                .input(plate, Naquadria, 4)
                .input(circuit, MarkerMaterials.Tier.UV, 2)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .input(FIELD_GENERATOR_ZPM, 2)
                .input(pipeLargeFluid, LithiumTitanate)
                .input(rotor, Berkelium, 2)
                .input(wireFine, Cobalt, 16)
                .fluidInputs(Mutagen.getFluid(L * 4))
                .output(ALGAE_CULTURE_TANK)
                .EUt(VA[ZPM])
                .duration(1200)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //  Extreme Large Miner
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[ZPM])
                .input(frameGt, Osmiridium, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(ELECTRIC_PUMP_ZPM, 4)
                .input(CONVEYOR_MODULE_ZPM, 4)
                .input(gear, Pikyonium64B, 4)
                .circuitMeta(2)
                .output(EXTREME_LARGE_MINER)
                .EUt(VA[ZPM])
                .duration(400)
                .buildAndRegister();

        //  Ultimate Large Miner
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UV])
                .input(frameGt, Tritanium, 4)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(ELECTRIC_MOTOR_UV, 4)
                .input(ELECTRIC_PUMP_UV, 4)
                .input(CONVEYOR_MODULE_UV, 4)
                .input(gear, Cinobite, 4)
                .circuitMeta(2)
                .output(ULTIMATE_LARGE_MINER)
                .EUt(VA[UV])
                .duration(400)
                .buildAndRegister();

        //  Infinity Large Miner
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(frameGt, Adamantium, 4)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(ELECTRIC_MOTOR_UHV, 4)
                .input(ELECTRIC_PUMP_UHV, 4)
                .input(CONVEYOR_MODULE_UHV, 4)
                .input(gear, TitanSteel, 4)
                .circuitMeta(2)
                .output(INFINITY_LARGE_MINER)
                .EUt(VA[UHV])
                .duration(400)
                .buildAndRegister();

        //  Advanced Fluid Drill Rig
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[ZPM])
                .input(frameGt, HSSG, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(ELECTRIC_PUMP_ZPM, 4)
                .input(gear, HY1301, 4)
                .circuitMeta(2)
                .output(ADVANCED_FLUID_DRILL_RIG)
                .EUt(VA[ZPM])
                .duration(400)
                .buildAndRegister();

        //  Extreme Fluid Drill Rig
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UV])
                .input(frameGt, Naquadah, 4)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(ELECTRIC_MOTOR_UV, 4)
                .input(ELECTRIC_PUMP_UV, 4)
                .input(gear, IncoloyMA813, 4)
                .circuitMeta(2)
                .output(EXTREME_FLUID_DRILL_RIG)
                .EUt(VA[UV])
                .duration(400)
                .buildAndRegister();

        //  Ultimate Fluid Drill Rig
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(frameGt, Trinium, 4)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(ELECTRIC_MOTOR_UHV, 4)
                .input(ELECTRIC_PUMP_UHV, 4)
                .input(gear, SiliconCarbide, 4)
                .circuitMeta(2)
                .output(ULTIMATE_FLUID_DRILL_RIG)
                .EUt(VA[UHV])
                .duration(400)
                .buildAndRegister();

        //  Infinity Fluid Drill Rig
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UEV])
                .input(frameGt, Tritanium, 4)
                .input(circuit, MarkerMaterials.Tier.UEV, 4)
                .input(ELECTRIC_MOTOR_UEV, 4)
                .input(ELECTRIC_PUMP_UEV, 4)
                .input(gear, Lafium, 4)
                .circuitMeta(2)
                .output(INFINITY_FLUID_DRILL_RIG)
                .EUt(VA[UEV])
                .duration(400)
                .buildAndRegister();

        //  Large Vacuum Chamber
        ModHandler.addShapedRecipe(true, "large_vacuum_chamber", LARGE_VACUUM_CHAMBER.getStackForm(),
                "GpG", "PIP", "WRW",
                'I', VACUUM_CHAMBER[IV].getStackForm(),
                'P', ELECTRIC_PUMP_IV,
                'p', new UnificationEntry(plate, MaragingSteel300),
                'W', new UnificationEntry(cableGtSingle, Tungsten),
                'R', new UnificationEntry(rotor, Staballoy),
                'G', MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS));

        //  Large Bio Reactor
        ModHandler.addShapedRecipe(true, "large_bio_reactor", LARGE_BIO_REACTOR.getStackForm(),
                "PMP", "BFB", "PWP",
                'F', new UnificationEntry(frameGt, Plutonium241),
                'B', BIO_REACTOR[IV].getStackForm(),
                'P', new UnificationEntry(plate, TungstenCarbide),
                'W', new UnificationEntry(cableGtSingle, Platinum),
                'M', ELECTRIC_PUMP_IV);

        //  Large Gas Collector
        ModHandler.addShapedRecipe(true, "large_gas_collector", LARGE_GAS_COLLECTOR.getStackForm(),
                "ARA", "PHP", "WFW",
                'H', GAS_COLLECTOR[IV].getStackForm(),
                'P', new UnificationEntry(pipeNormalFluid, TungstenSteel),
                'W', new UnificationEntry(cableGtQuadruple, Platinum),
                'R', new UnificationEntry(rotor, Staballoy),
                'A', new UnificationEntry(plate, BlackSteel),
                'F', FIELD_GENERATOR_IV);

        //  Extreme Industrial Greenhouse
        ModHandler.addShapedRecipe(true, "extreme_industrial_greenhouse", EXTREME_INDUSTRIAL_GREENHOUSE.getStackForm(),
                "GIG", "SHF", "WXW",
                'H', GREENHOUSE.getStackForm(),
                'S', SENSOR_HV,
                'F', FIELD_GENERATOR_HV,
                'W', new UnificationEntry(cableGtSingle, Gold),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'I', FLUID_FILTER,
                'G', new UnificationEntry(plate, Glass));

        //  Industrial Induction Furnace
        ModHandler.addShapedRecipe(true, "industrial_induction_furnace", INDUSTRIAL_INDUCTION_FURNACE.getStackForm(),
                "FFF", "XCX", "WXW",
                'F', ELECTRIC_FURNACE[IV].getStackForm(),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'C', GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.NIOBIUM_TITANIUM_CASING),
                'W', new UnificationEntry(cableGtSingle, Platinum));

        //  Arc Furnace Array
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Botmium, 4)
                .input(LARGE_ARC_FURNACE, 16)
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(plateDouble, TitaniumTungstenCarbide, 4)
                .input(plateDouble, MARM200CeSteel, 4)
                .input(gear, RhodiumPlatedPalladium, 4)
                .input(gearSmall, Talonite, 16)
                .input(cableGtQuadruple, NiobiumNitride, 4)
                .fluidInputs(Inconel792.getFluid(L * 4))
                .output(ARC_FURNACE_ARRAY)
                .EUt(VA[LuV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Suprachronal Assembly Line
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, CosmicNeutronium, 4)
                .input(ADVANCED_ASSEMBLY_LINE, 16)
                .input(COMPONENT_ASSEMBLY_LINE, 16)
                .input(circuit, MarkerMaterials.Tier.MAX, 8)
                .input(ROBOT_ARM_OpV, 4)
                .input(EMITTER_OpV, 4)
                .input(FIELD_GENERATOR_OpV, 4)
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.DIMENSIONAL_BRIDGE_CASING, 4))
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.SPACETIME_CASING, 4))
                .inputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.OpV, 4))
                .input(plateDouble, Legendarium, 32)
                .input(plateDouble, Spacetime, 32)
                .input(plateDouble, TranscendentMetal, 32)
                .input(plateDouble, Infinity, 32)
                .input(gear, MagnetoHydrodynamicallyConstrainedStarMatter, 16)
                .input(cableGtQuadruple, Galaxium, 4)
                .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(128000))
                .fluidInputs(Arcanium.getFluid(57600))
                .fluidInputs(Universium.getFluid(28800))
                .fluidInputs(DegenerateRhenium.getFluid(14400))
                .output(SUPRACHRONAL_ASSEMBLY_LINE)
                .EUt(VA[OpV])
                .duration(1200)
                .stationResearch(b -> b
                        .researchStack(DIMENSIONAL_OSCILLATOR.getStackForm())
                        .EUt(VA[OpV])
                        .CWUt(576))
                .buildAndRegister();

        //  Virtual Cosmos Simulator
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, TranscendentMetal, 4)
                .input(DIMENSIONAL_OSCILLATOR, 2)
                .input(SPACE_ELEVATOR, 4)
                .input(BIOWARE_SIMULATOR, 16)
                .input(circuit, MarkerMaterials.Tier.MAX, 8)
                .input(FIELD_GENERATOR_UXV, 4)
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.DIMENSIONAL_BRIDGE_CASING, 16))
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.DIMENSIONAL_PRESERVE_CASING, 16))
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.SPACETIME_CASING, 16))
                .inputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.UXV, 16))
                .input(plateDense, Spacetime, 4)
                .input(plateDense, CosmicNeutronium, 4)
                .input(gear, MagnetoHydrodynamicallyConstrainedStarMatter, 16)
                .input(gear, Infinity, 16)
                .input(stickLong, Hypogen, 32)
                .input(wireGtOctal, BoronFranciumCarbideSuperconductor, 4)
                .fluidInputs(CosmicComputingMixture.getFluid(65536))
                .fluidInputs(Arcanium.getFluid(57600))
                .fluidInputs(BlackDwarfMatter.getFluid(28800))
                .fluidInputs(WhiteDwarfMatter.getFluid(28800))
                .output(VIRTUAL_COSMOS_SIMULATOR)
                .EUt(VA[UXV])
                .duration(1200)
                .stationResearch(b -> b
                        .researchStack(SPACE_ELEVATOR.getStackForm())
                        .EUt(VA[UXV])
                        .CWUt(576))
                .buildAndRegister();

        //  Horizontal Shaft Impact Macerator
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Laurenium, 4)
                .input(LARGE_MACERATOR, 16)
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(plateDouble, Zeron100, 4)
                .input(plateDouble, HMS1J22Alloy, 4)
                .input(gear, Ruridit, 4)
                .input(gearSmall, Stellite, 16)
                .input(cableGtQuadruple, Graphene, 4)
                .fluidInputs(TitaniumTungstenCarbide.getFluid(L * 4))
                .output(HORIZONTAL_SHAFT_IMPACT_MACERATOR)
                .EUt(VA[LuV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Trough Type Ore Washer
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, IncoloyMA956, 4)
                .input(LARGE_CHEMICAL_BATH, 16)
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(plateDouble, WatertightSteel, 4)
                .input(plateDouble, HG1223, 4)
                .input(gear, HastelloyN, 4)
                .input(gearSmall, HSSE, 16)
                .input(cableGtQuadruple, Osmium, 4)
                .fluidInputs(TanmolyiumBetaC.getFluid(L * 4))
                .output(TROUGH_TYPE_ORE_WASHER)
                .EUt(VA[LuV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fixed Sifting Plant
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, MaragingSteel250, 4)
                .input(LARGE_SIFTER, 16)
                .input(circuit, MarkerMaterials.Tier.IV, 16)
                .input(plateDouble, MaragingSteel300, 4)
                .input(plateDouble, BlueSteel, 4)
                .input(gear, VanadiumSteel, 4)
                .input(gearSmall, TungstenSteel, 16)
                .input(cableGtQuadruple, Aluminium, 4)
                .fluidInputs(Stellite.getFluid(L * 4))
                .output(FIXED_SIFTING_PLANT)
                .EUt(VA[IV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Large Wiremill Array
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenSteel, 4)
                .input(LARGE_WIREMILL, 16)
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(plateDouble, MaragingSteel250, 4)
                .input(plateDouble, Ruridit, 4)
                .input(gear, Stellite, 4)
                .input(gearSmall, HSSG, 16)
                .input(cableGtQuadruple, Osmium, 4)
                .fluidInputs(EglinSteel.getFluid(L * 4))
                .output(LARGE_WIREMILL_ARRAY)
                .EUt(VA[LuV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Large Circuit Assembly Line
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ASSEMBLY_LINE)
                .input(frameGt, HastelloyC59, 4)
                .input(LARGE_CIRCUIT_ASSEMBLER, 4)
                .input(CIRCUIT_ASSEMBLER[LuV], 16)
                .input(ROBOT_ARM_LuV, 4)
                .input(CONVEYOR_MODULE_LuV, 4)
                .input(plateDouble, Tantalloy61, 8)
                .input(plateDouble, MARM200CeSteel, 8)
                .input(gear, HSSE)
                .input(gearSmall, Osmiridium, 3)
                .input(wireGtQuadruple, IndiumTinBariumTitaniumCuprate, 4)
                .fluidInputs(SolderingAlloy.getFluid(4608))
                .fluidInputs(Lubricant.getFluid(16000))
                .output(LARGE_CIRCUIT_ASSEMBLY_LINE)
                .EUt(VA[LuV])
                .duration(1200)
                .scannerResearch(b -> b
                        .researchStack(LARGE_CIRCUIT_ASSEMBLER.getStackForm())
                        .EUt(VA[IV])
                        .duration(600))
                .buildAndRegister();

        //  Electromagnetic Separation Factory
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, HMS1J79Alloy, 4)
                .input(LARGE_POLARIZER, 16)
                .input(circuit, MarkerMaterials.Tier.IV, 16)
                .input(plateDouble, Laurenium, 4)
                .input(plateDouble, TantalumCarbide, 4)
                .input(gear, SterlingSilver, 4)
                .input(gearSmall, RhodiumPlatedPalladium, 16)
                .input(cableGtQuadruple, TungstenSteel, 4)
                .fluidInputs(MaragingSteel300.getFluid(L * 4))
                .output(ELECTROMAGNETIC_SEPARATION_PLANT)
                .EUt(VA[IV])
                .duration(600)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Large EUV Mask Aligner
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, FluxedElectrum, 4)
                .input(LARGE_ENGRAVER, 16)
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(plateDouble, HY1301, 4)
                .input(plateDouble, Tantalloy61, 4)
                .input(gear, Inconel792, 4)
                .input(gearSmall, EglinSteel, 16)
                .input(cableGtQuadruple, HSSG, 4)
                .fluidInputs(TantalumCarbide.getFluid(L * 4))
                .output(LARGE_EUV_MASK_ALIGNER)
                .EUt(VA[LuV])
                .duration(1200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Ion Lithography Factory
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Cinobite, 16)
                .input(LARGE_EUV_MASK_ALIGNER, 64)
                .input(ION_IMPLANTATOR, 64)
                .input(ELECTROLYTIC_TANK, 64)
                .input(ELECTROMAGNETIC_SEPARATION_PLANT, 64)
                .input(PHOTON, 64)
                .input(plateDense, Orichalcum, 6)
                .input(plateDense, Adamantium, 6)
                .input(circuit, MarkerMaterials.Tier.UEV, 64)
                .input(circuit, MarkerMaterials.Tier.UEV, 64)
                .input(ELECTRIC_PUMP_UHV, 32)
                .input(CONVEYOR_MODULE_UHV, 32)
                .input(ROBOT_ARM_UHV, 32)
                .input(FIELD_GENERATOR_UHV, 32)
                .input(gear, MetastableOganesson, 16)
                .input(wireGtHex, PedotPSS, 64)
                .fluidInputs(Trinaquadalloy.getFluid(65536))
                .fluidInputs(TitanSteel.getFluid(65536))
                .fluidInputs(EnrichedNaquadahTriniumEuropiumDuranide.getFluid(57600))
                .fluidInputs(MetastableFlerovium.getFluid(28800))
                .output(ION_LITHOGRAPHY_FACTORY)
                .EUt(VA[UHV])
                .duration(6400)
                .stationResearch(b -> b
                        .researchStack(ION_IMPLANTATOR.getStackForm())
                        .EUt(VA[UHV])
                        .CWUt(576))
                .buildAndRegister();

        //  Large Rock Breaker
        ModHandler.addShapedRecipe(true, "large_rock_breaker", LARGE_ROCK_BREAKER.getStackForm(),
                "ICI", "PXP", "WCW",
                'X', ROCK_BREAKER[IV].getStackForm(),
                'C', COMPONENT_GRINDER_TUNGSTEN,
                'W', new UnificationEntry(cableGtSingle, Platinum),
                'P', ELECTRIC_PISTON_IV,
                'I', new UnificationEntry(pipeLargeItem, SterlingSilver));

        //  Industrial Rock Breaker
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Tungsten, 4)
                .input(LARGE_ROCK_BREAKER, 16)
                .input(circuit, MarkerMaterials.Tier.EV, 16)
                .input(plateDouble, Ultimet, 4)
                .input(plateDouble, Cobalt, 4)
                .input(gear, BlackSteel, 4)
                .input(gearSmall, WroughtIron, 16)
                .input(cableGtQuadruple, Electrum, 4)
                .fluidInputs(Stellite100.getFluid(L * 4))
                .output(INDUSTRIAL_ROCK_BREAKER)
                .EUt(VA[EV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  DTPF
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Neutronium, 16)
                .input(INDUSTRIAL_INDUCTION_FURNACE, 64)
                .input(ARC_FURNACE_ARRAY, 64)
                .input(MEGA_BLAST_FURNACE, 64)
                .input(INDUSTRIAL_ROASTER, 64)
                .input(BURNER_REACTOR, 64)
                .input(MEGA_ALLOY_BLAST_SMELTER, 64)
                .input(STELLAR_FURNACE, 64)
                .input(HIGGS_BOSON, 64)
                .input(plateDense, Vibranium, 6)
                .input(plateDense, Infinity, 6)
                .input(circuit, MarkerMaterials.Tier.UEV, 64)
                .input(ELECTRIC_PUMP_UEV, 32)
                .input(FIELD_GENERATOR_UEV, 32)
                .input(gear, MetastableHassium, 16)
                .input(wireGtHex, QuantumAlloy, 64)
                .fluidInputs(BlackTitanium.getFluid(65536))
                .fluidInputs(HastelloyK243.getFluid(57600))
                .fluidInputs(SuperheavyLAlloy.getFluid(57600))
                .fluidInputs(DegenerateRhenium.getFluid(28800))
                .output(DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE)
                .EUt(VA[UEV])
                .duration(12800)
                .stationResearch(b -> b
                        .researchStack(STELLAR_FURNACE.getStackForm())
                        .EUt(VA[UEV])
                        .CWUt(576))
                .buildAndRegister();

        //  Dimensional Mixer
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HastelloyX78, 16)
                .input(TURBINE_MIXER, 64)
                .input(INDUSTRIAL_CENTRIFUGE, 64)
                .input(FIXED_SIFTING_PLANT, 64)
                .input(SONICATOR, 64)
                .input(PROTON, 64)
                .input(plateDense, Tritanium, 6)
                .input(plateDense, Darmstadtium, 6)
                .input(circuit, MarkerMaterials.Tier.UEV, 64)
                .input(circuit, MarkerMaterials.Tier.UEV, 64)
                .input(ELECTRIC_MOTOR_UHV, 32)
                .input(ROBOT_ARM_UHV, 32)
                .input(SENSOR_UHV, 32)
                .input(FIELD_GENERATOR_UHV, 32)
                .input(gear, ArceusAlloy2B, 16)
                .input(wireGtHex, PedotPSS, 64)
                .fluidInputs(Tairitsium.getFluid(65536))
                .fluidInputs(Lafium.getFluid(57600))
                .fluidInputs(TransitionHAlloy.getFluid(57600))
                .fluidInputs(Mithril.getFluid(28800))
                .output(DIMENSIONAL_MIXER)
                .EUt(VA[UHV])
                .duration(3200)
                .stationResearch(b -> b
                        .researchStack(SONICATOR.getStackForm())
                        .EUt(VA[UHV])
                        .CWUt(576))
                .buildAndRegister();

        //  Yotta Fluid Tank
        ModHandler.addShapedRecipe(true, "yotta_fluid_tank", YOTTA_FLUID_TANK.getStackForm(),
                "SXS", "OCO", "SPS",
                'S', new UnificationEntry(screw, BlueSteel),
                'X', COVER_SCREEN,
                'O', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'C', GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.FORCE_FIELD_CONSTRAINED_CASING),
                'P', new UnificationEntry(pipeNormalFluid, StainlessSteel));

        //  Large High Pressure Forming Unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, ZirconiumCarbide, 4)
                .input(LARGE_BENDER, 16)
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(plateDouble, Incoloy020, 4)
                .input(plateDouble, Stellite100, 4)
                .input(gear, HSSS, 4)
                .input(gearSmall, TungstenCarbide, 16)
                .input(cableGtQuadruple, Tungsten, 4)
                .fluidInputs(IncoloyMA956.getFluid(L * 4))
                .output(LARGE_HIGH_PRESSURE_FORMING_UNIT)
                .EUt(VA[LuV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Large Turrent Lathing Factory
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Incoloy020, 4)
                .input(LARGE_CUTTER, 16)
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(plateDouble, HSSS, 4)
                .input(plateDouble, HSLASteel, 4)
                .input(gear, CobaltBrass, 4)
                .input(gearSmall, Osmiridium, 16)
                .input(cableGtQuadruple, RTMAlloy, 4)
                .fluidInputs(TitaniumCarbide.getFluid(L * 4))
                .output(LARGE_TURRENT_LATHING_FACTORY)
                .EUt(VA[LuV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Ultimate Combustion Engine
        ModHandler.addShapedRecipe(true, "ultimate_combustion_engine", ULTIMATE_COMBUSTION_ENGINE.getStackForm(),
                "PXP", "MCM", "GWG",
                'P', ELECTRIC_PISTON_LUV,
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ZPM),
                'M', ELECTRIC_MOTOR_LuV,
                'C', HULL[LuV].getStackForm(),
                'G', new UnificationEntry(gear, Naquadah),
                'W', new UnificationEntry(cableGtSingle, VanadiumGallium));

        //  Circulative Cooling Tower
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, ToxicAlloy, 16)
                .input(VACUUM_DRYING_FURNACE, 64)
                .input(MEGA_VACUUM_FREEZER, 64)
                .input(CRYOGENIC_REACTOR, 64)
                .input(LARGE_GAS_COLLECTOR, 64)
                .input(PLASMA_CONDENSER, 64)
                .input(MESON, 64)
                .input(plateDense, Pikyonium64B, 6)
                .input(plateDense, Osmiridium, 6)
                .input(circuit, MarkerMaterials.Tier.UHV, 64)
                .input(CONVEYOR_MODULE_UHV, 64)
                .input(ELECTRIC_PISTON_UHV, 64)
                .input(ELECTRIC_PUMP_UHV, 64)
                .input(FIELD_GENERATOR_UHV, 64)
                .input(gear, Botmium, 16)
                .input(wireGtHex, PedotPSS, 64)
                .fluidInputs(ArceusAlloy2B.getFluid(65536))
                .fluidInputs(HastelloyX78.getFluid(57600))
                .fluidInputs(Lafium.getFluid(57600))
                .fluidInputs(Vibranium.getFluid(28800))
                .output(CIRCULATIVE_COOLING_TOWER)
                .stationResearch(b -> b
                        .researchStack(MEGA_VACUUM_FREEZER.getStackForm())
                        .CWUt(576)
                        .EUt(VA[UHV]))
                .EUt(VA[UHV])
                .duration(2800)
                .buildAndRegister();

        //  Dyson Swarm
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UIV])
                .input(SENSOR_UIV, 2)
                .input(plate, VoidMetal, 16)
                .input(circuit, MarkerMaterials.Tier.UIV, 8)
                .input(COVER_SOLAR_PANEL_UV, 4)
                .input(VOLTAGE_COIL_UIV, 2)
                .input(wireGtOctal, FullereneSuperconductor, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Lubricant.getFluid(16000))
                .fluidInputs(SuperheavyHAlloy.getFluid(L * 4))
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(DYSON_SWARM)
                .EUt(VA[UIV])
                .duration(1200)
                .stationResearch(b -> b
                        .researchStack(DYSON_SWARM_MODULE.getStackForm())
                        .EUt(VA[UIV])
                        .CWUt(576))
                .buildAndRegister();

        //  Integrated Ore Processor
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[ZPM])
                .input(ELECTRIC_MOTOR_ZPM, 32)
                .input(ELECTRIC_PISTON_ZPM, 8)
                .input(ELECTRIC_PUMP_ZPM, 16)
                .input(CONVEYOR_MODULE_ZPM, 8)
                .input(ROBOT_ARM_ZPM, 8)
                .input(plateDouble, StainlessSteel, 32)
                .input(rotor, Chrome, 16)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(pipeNormalFluid, Polybenzimidazole, 32)
                .input(COMPONENT_GRINDER_TUNGSTEN, 64)
                .input(wireGtDouble, UraniumRhodiumDinaquadide, 16)
                .fluidInputs(SolderingAlloy.getFluid(2880))
                .fluidInputs(Naquadria.getFluid(1440))
                .output(INTEGRATED_ORE_PROCESSOR)
                .EUt(VA[ZPM])
                .duration(1600)
                .scannerResearch(b -> b
                        .researchStack(COMPONENT_GRINDER_TUNGSTEN.getStackForm())
                        .EUt(VA[ZPM])
                        .duration(800))
                .buildAndRegister();

        //  Large Fluid Phase Transformer
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, HG1223, 4)
                .input(LARGE_EXTRACTOR, 16)
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(plateDouble, HastelloyC276, 4)
                .input(plateDouble, Ruthenium, 4)
                .input(gear, Diamond, 4)
                .input(gearSmall, Iridium, 16)
                .input(cableGtQuadruple, Osmium, 4)
                .fluidInputs(WatertightSteel.getFluid(L * 4))
                .output(LARGE_FLUID_PHASE_TRANSFORMER)
                .EUt(VA[LuV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Quantum Computer
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HIGH_PERFORMANCE_COMPUTING_ARRAY)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(SENSOR_UV, 8)
                .input(FIELD_GENERATOR_UV, 8)
                .input(TOOL_DATA_MODULE)
                .input(COVER_SCREEN, 2)
                .input(NANO_PIC_CHIP, 16)
                .input(ring, Orichalcum, 32)
                .input(wireGtDouble, EnrichedNaquadahTriniumEuropiumDuranide, 16)
                .input(screw, Rutherfordium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(YttriumBariumCuprate.getFluid(L * 8))
                .fluidInputs(Naquadria.getFluid(L))
                .output(QUANTUM_COMPUTER)
                .stationResearch(b -> b
                        .researchStack(HIGH_PERFORMANCE_COMPUTING_ARRAY.getStackForm())
                        .EUt(VA[UV])
                        .CWUt(64))
                .EUt(VA[UV])
                .duration(800)
                .buildAndRegister();

        //  Quantum Computer Components
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.QUANTUM_COMPUTER_CASING.getItemVariant(BlockQuantumComputerCasing.QCCasingType.COMPUTER_CASING))
                .input(circuit, MarkerMaterials.Tier.LuV)
                .input(TOOL_DATA_ORB)
                .fluidInputs(PCBCoolant.getFluid(2000))
                .output(QC_EMPTY_COMPONENT)
                .EUt(VA[LuV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(QC_EMPTY_COMPONENT)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(FIELD_GENERATOR_ZPM)
                .fluidInputs(PCBCoolant.getFluid(2000))
                .output(QC_COMPUTATION_COMPONENT[0])
                .EUt(VA[ZPM])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(QC_COMPUTATION_COMPONENT[0])
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(FIELD_GENERATOR_UV)
                .fluidInputs(PCBCoolant.getFluid(2000))
                .output(QC_COMPUTATION_COMPONENT[1])
                .EUt(VA[UV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(QC_EMPTY_COMPONENT)
                .input(plate, StainlessSteel, 32)
                .input(screw, Titanium, 8)
                .fluidInputs(PCBCoolant.getFluid(2000))
                .output(QC_COOLER_COMPONENT[0])
                .EUt(VA[LuV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.QUANTUM_COMPUTER_CASING.getItemVariant(BlockQuantumComputerCasing.QCCasingType.ADVANCED_COMPUTER_CASING))
                .input(plate, StainlessSteel, 16)
                .input(pipeTinyFluid, Titanium, 16)
                .input(screw, Titanium, 8)
                .fluidInputs(PCBCoolant.getFluid(2000))
                .output(QC_COOLER_COMPONENT[1])
                .EUt(VA[LuV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.QUANTUM_COMPUTER_CASING.getItemVariant(BlockQuantumComputerCasing.QCCasingType.ADVANCED_COMPUTER_CASING))
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(EMITTER_UV)
                .input(MetaBlocks.OPTICAL_PIPES[0], 2)
                .fluidInputs(PCBCoolant.getFluid(2000))
                .output(QC_BRIDGE_COMPONENT)
                .EUt(VA[ZPM])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Planetary Gas Siphon
        ModHandler.addShapedRecipe(true, "planetary_gas_siphon", PLANETARY_GAS_SIPHON.getStackForm(),
                "MAM", "XHX", "SPS",
                'H', HULL[ZPM].getStackForm(),
                'P', new UnificationEntry(pipeNormalFluid, TungstenCarbide),
                'S', new UnificationEntry(screw, LithiumTitanate),
                'A', ELECTRIC_PUMP_ZPM,
                'M', ELECTRIC_MOTOR_ZPM,
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ZPM));
    }

    private static void MachineCasingRecipes() {

        //  Substrate Casing
        ModHandler.addShapedRecipe(true, "substrate_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.SUBSTRATE_CASING),
                "PPP", "RFR", "R R",
                'P', new UnificationEntry(plate, Palladium),
                'R', new UnificationEntry(stick, RedSteel),
                'F', new UnificationEntry(frameGt, BlueSteel));

        //  Advanced Substrate Casing
        ModHandler.addShapedRecipe(true, "advanced_substrate_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.ADVANCED_SUBSTRATE_CASING),
                "PPP", "RFR", "R R",
                'P', new UnificationEntry(plate, Ruridit),
                'R', new UnificationEntry(stick, Duranium),
                'F', new UnificationEntry(frameGt, NaquadahAlloy));

        //  Drill Head
        ModHandler.addShapedRecipe(true, "drill_head", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.DRILL_HEAD),
                "PGP", "MHM", "SSS",
                'P', ELECTRIC_PISTON_UV.getStackForm(),
                'G', new UnificationEntry(gear, Orichalcum),
                'M', ELECTRIC_MOTOR_UV.getStackForm(),
                'H', HULL[UV].getStackForm(),
                'S', COMPONENT_GRINDER_TUNGSTEN.getStackForm());

        //  Inconel-625 Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[EV], 2)
                .input(plate, Inconel625, 4)
                .input(plate, HSSE, 8)
                .input(ring, Inconel625, 8)
                .input(bolt, Inconel625, 16)
                .fluidInputs(Titanium.getFluid(L * 8))
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.INCONEL625_CASING, 2))
                .EUt(VA[EV])
                .duration(240)
                .buildAndRegister();

        //  Inconel-625 Gearbox Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, HSSS)
                .input(gear, Inconel625, 3)
                .input(gearSmall, HSSG, 6)
                .input(bolt, HSSE, 16)
                .input(COMPONENT_GRINDER_TUNGSTEN, 2)
                .fluidInputs(Zeron100.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.INCONEL625_GEARBOX_CASING, 2))
                .EUt(VA[LuV])
                .duration(300)
                .buildAndRegister();

        //  Inconel-625 Pipe Casing
        ModHandler.addShapedRecipe(true, "inconel_625_pipe", GTLiteMetaBlocks.BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.INCONEL625, 2),
                "APA", "PFP", "APA",
                'F', new UnificationEntry(frameGt, MaragingSteel300),
                'P', new UnificationEntry(pipeNormalFluid, Inconel625),
                'A', new UnificationEntry(plate, NiobiumTitanium));

        //  Grindball Hatch
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(dust, Soapstone, 4)
                .notConsumable(SHAPE_MOLD_BALL)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(GRINDBALL_SOAPSTONE)
                .EUt(VA[MV])
                .duration(300)
                .buildAndRegister();

        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(dust, Aluminium, 4)
                .notConsumable(SHAPE_MOLD_BALL)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(GRINDBALL_ALUMINIUM)
                .EUt(VA[HV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[EV])
                .input(frameGt, TungstenSteel)
                .input(gear, Titanium, 4)
                .input(COMPONENT_GRINDER_TUNGSTEN)
                .input(wireFine, Tungsten, 16)
                .fluidInputs(RTMAlloy.getFluid(L * 4))
                .output(MULTIPART_GRIND_BALL_HATCH)
                .EUt(VA[IV])
                .duration(600)
                .buildAndRegister();

        //  Hatelloy-N Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[EV], 2)
                .input(plate, Nichrome, 4)
                .input(plate, WatertightSteel, 4)
                .input(stickLong, HSSG, 2)
                .input(bolt, HastelloyN, 16)
                .fluidInputs(StainlessSteel.getFluid(L * 8))
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.HASTELLOY_N_CASING, 2))
                .EUt(VA[IV])
                .duration(280)
                .buildAndRegister();

        //  Hastelloy-N Gearbox Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, HSSG)
                .input(plate, HSSG, 4)
                .input(gear, HastelloyN, 3)
                .input(gearSmall, HSSG, 6)
                .input(bolt, TungstenCarbide, 16)
                .fluidInputs(HastelloyX.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.HASTELLOY_N_GEARBOX_CASING, 2))
                .EUt(VA[LuV])
                .duration(140)
                .buildAndRegister();

        //  Hastelloy-N Pipe Casing
        ModHandler.addShapedRecipe(true, "hastelloy_n_pipe", GTLiteMetaBlocks.BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.HASTELLOY_N, 2),
                "APA", "PFP", "APA",
                'F', new UnificationEntry(frameGt, WatertightSteel),
                'P', new UnificationEntry(pipeNormalFluid, HastelloyN),
                'A', new UnificationEntry(plate, VanadiumGallium));

        //  Flotation Cell
        ModHandler.addShapedRecipe(true, "flotation_cell", GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.FLOTATION_CELL, 2),
                "AAA", "AGA", "APA",
                'P', ELECTRIC_PUMP_IV,
                'A', new UnificationEntry(plate, HastelloyN),
                'G', MetaBlocks.MULTIBLOCK_CASING.getItemVariant(gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, HastelloyN, 7)
                .inputs(MetaBlocks.MULTIBLOCK_CASING.getItemVariant(gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING))
                .input(ELECTRIC_PUMP_IV)
                .outputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.FLOTATION_CELL, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Red Steel Casing
        ModHandler.addShapedRecipe(true, "red_steel_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.RED_STEEL_CASING, 2),
                "PhP", "TFT","PwP",
                'P', new UnificationEntry(plateDouble, RedSteel),
                'T', new UnificationEntry(plate, TitaniumCarbide),
                'F', new UnificationEntry(frameGt, CobaltBrass));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plateDouble, RedSteel, 4)
                .input(plate, TitaniumCarbide, 2)
                .input(frameGt, CobaltBrass)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.RED_STEEL_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Advanced Invar Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.INVAR_HEATPROOF))
                .circuitMeta(6)
                .fluidInputs(AusteniticStainlessSteel904L.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.ADVANCED_INVAR_CASING))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Advanced Aluminium Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF))
                .circuitMeta(6)
                .fluidInputs(TanmolyiumBetaC.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.ADVANCED_ALUMINIUM_CASING))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Polybenzimidazole Pipe Casing
        ModHandler.addShapedRecipe(true, "polybenzimidazole_pipe", GTLiteMetaBlocks.BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.POLYBENZIMIDAZOLE, 2),
                "APA", "PFP", "APA",
                'F', new UnificationEntry(frameGt, Polybenzimidazole),
                'P', new UnificationEntry(pipeNormalFluid, Polybenzimidazole),
                'A', new UnificationEntry(plate, Polybenzimidazole));

        //  Talonite Casing
        ModHandler.addShapedRecipe(true, "talonite_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.TALONITE_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Talonite),
                'F', new UnificationEntry(frameGt, Talonite));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Talonite, 6)
                .input(frameGt, Talonite)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.TALONITE_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Naquadria Casing
        ModHandler.addShapedRecipe(true, "naquadria_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.NAQUADRIA_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Naquadria),
                'F', new UnificationEntry(frameGt, NaquadahAlloy));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Naquadria, 6)
                .input(frameGt, NaquadahAlloy)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.NAQUADRIA_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Hastelloy-X78 Casing
        ModHandler.addShapedRecipe(true, "hastelloy_x78_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.HASTELLOY_X78_CASING, 2),
                "PhP", "TFT","PwP",
                'P', new UnificationEntry(plateDouble, HastelloyX),
                'T', new UnificationEntry(plate, HastelloyX78),
                'F', new UnificationEntry(frameGt, HastelloyX));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plateDouble, HastelloyX, 4)
                .input(plate, HastelloyX78, 2)
                .input(frameGt, HastelloyX)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.HASTELLOY_X78_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Fusion Casing Mk IV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                .input(VOLTAGE_COIL_UHV, 2)
                .input(FIELD_GENERATOR_UV)
                .input(plate, Dubnium, 6)
                .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_CASING_MK4, 2))
                .EUt(VA[UHV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fusion Casing Mk V
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UEV])
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3))
                .input(VOLTAGE_COIL_UEV, 2)
                .input(FIELD_GENERATOR_UHV)
                .input(plate, Livermorium, 6)
                .fluidInputs(Zylon.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_CASING_MK5, 2))
                .EUt(VA[UEV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fusion Coil Mk 2
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.FUSION_CASING.getItemVariant(gregtech.common.blocks.BlockFusionCasing.CasingType.FUSION_COIL))
                .input(FIELD_GENERATOR_LuV, 2)
                .input(ELECTRIC_PUMP_LuV)
                .input(NEUTRON_REFLECTOR, 2)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(pipeSmallFluid, Europium, 4)
                .input(plate, Americium, 4)
                .fluidInputs(YttriumBariumCuprate.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                .EUt(VA[UV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fusion Coil Mk 3
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                .input(FIELD_GENERATOR_ZPM, 2)
                .input(ELECTRIC_PUMP_ZPM)
                .input(NEUTRON_REFLECTOR, 2)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(pipeSmallFluid, Duranium, 4)
                .input(plate, Dubnium, 4)
                .fluidInputs(Europium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3))
                .EUt(VA[UHV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fusion Coil Mk 4
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3))
                .input(FIELD_GENERATOR_UV, 2)
                .input(ELECTRIC_PUMP_UV)
                .input(NEUTRON_REFLECTOR, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(pipeSmallFluid, Lafium, 4)
                .input(plate, Livermorium, 4)
                .fluidInputs(Americium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK4))
                .EUt(VA[UEV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cryostat
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, StainlessSteel)
                .input(plate, Titanium, 4)
                .input(ELECTRIC_PUMP_UHV)
                .input(SENSOR_UHV)
                .input(pipeTinyFluid, Copper, 2)
                .input(screw, LithiumTitanate, 8)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.CRYOSTAT, 4))
                .EUt(VA[UV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Advanced Cryostat
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Titanium)
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.CRYOSTAT))
                .input(plate, TungstenSteel, 4)
                .input(ELECTRIC_PUMP_UEV)
                .input(SENSOR_UEV)
                .input(pipeTinyFluid, Bronze, 2)
                .input(screw, LithiumTitanate, 8)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.ADVANCED_CRYOSTAT, 4))
                .EUt(VA[UHV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Divertor
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, StainlessSteel)
                .input(plate, Titanium, 4)
                .input(CONVEYOR_MODULE_UHV)
                .input(EMITTER_UHV)
                .input(rotor, Staballoy, 2)
                .input(screw, LithiumTitanate, 8)
                .fluidInputs(Lubricant.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.DIVERTOR, 4))
                .EUt(VA[UV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Advanced Divertor
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Titanium)
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.DIVERTOR))
                .input(plate, TungstenSteel, 4)
                .input(CONVEYOR_MODULE_UEV)
                .input(EMITTER_UEV)
                .input(rotor, Inconel792, 2)
                .input(screw, LithiumTitanate, 8)
                .fluidInputs(Lubricant.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.ADVANCED_DIVERTOR, 4))
                .EUt(VA[UHV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Vacuum
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, StainlessSteel)
                .input(plate, Titanium, 4)
                .input(ELECTRIC_PISTON_UHV)
                .input(FIELD_GENERATOR_UHV)
                .input(pipeTinyFluid, Copper, 2)
                .input(screw, LithiumTitanate, 8)
                .fluidInputs(Polycaprolactam.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.VACUUM, 4))
                .EUt(VA[UV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Advanced Vacuum
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Titanium)
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.VACUUM))
                .input(plate, TungstenSteel, 4)
                .input(ELECTRIC_PISTON_UEV)
                .input(FIELD_GENERATOR_UEV)
                .input(pipeTinyFluid, Bronze, 2)
                .input(screw, LithiumTitanate, 8)
                .fluidInputs(Polycaprolactam.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.ADVANCED_VACUUM, 4))
                .EUt(VA[UHV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Precise Assembler Casing Mk I
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(ROBOT_ARM_EV, 2)
                .input(plateDouble, MARM200CeSteel, 2)
                .input(circuit, MarkerMaterials.Tier.LuV)
                .input(gearSmall, Stellite, 4)
                .input(cableGtQuadruple, Naquadah, 2)
                .input(screw, HSSG, 32)
                .fluidInputs(BlackSteel.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK1, 4))
                .EUt(VA[IV])
                .duration(400)
                .buildAndRegister();

        //  Precise Assembler Casing Mk II
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .inputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK1))
                .input(ROBOT_ARM_IV, 2)
                .input(plateDouble, HastelloyC59, 2)
                .input(circuit, MarkerMaterials.Tier.ZPM)
                .input(gearSmall, TanmolyiumBetaC, 8)
                .input(cableGtQuadruple, Tritanium, 2)
                .input(screw, HSSE, 32)
                .fluidInputs(Zeron100.getFluid(576))
                .outputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK2, 4))
                .EUt(VA[LuV])
                .duration(400)
                .buildAndRegister();

        //  Precise Assembler Casing Mk III
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UV))
                .inputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK2))
                .input(ROBOT_ARM_LuV, 2)
                .input(plateDouble, HMS1J79Alloy, 2)
                .input(circuit, MarkerMaterials.Tier.UV)
                .input(gearSmall, HY1301, 8)
                .input(cableGtQuadruple, SiliconCarbide, 2)
                .input(screw, HSSS, 32)
                .fluidInputs(IncoloyMA813.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK3, 4))
                .EUt(VA[ZPM])
                .duration(400)
                .buildAndRegister();

        //  Precise Assembler Casing Mk IV
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV))
                .inputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK3))
                .input(ROBOT_ARM_ZPM, 2)
                .input(plateDouble, PlatinumGroupAlloy, 2)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(gearSmall, Cinobite, 8)
                .input(screw, Orichalcum, 32)
                .fluidInputs(TransitionLAlloy.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK4, 4))
                .EUt(VA[UV])
                .duration(400)
                .buildAndRegister();

        //  Precise Assembler Casing Mk V
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UEV))
                .inputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK4))
                .input(ROBOT_ARM_UV, 2)
                .input(plateDouble, BlackTitanium, 2)
                .input(circuit, MarkerMaterials.Tier.UEV)
                .input(gearSmall, TitanSteel, 8)
                .input(screw, SuperheavyLAlloy, 32)
                .fluidInputs(RefractoryAlloy.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK5, 4))
                .EUt(VA[UHV])
                .duration(400)
                .buildAndRegister();

        //  Precise Assembler Casing Mk VI
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UIV))
                .inputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK5))
                .input(ROBOT_ARM_UHV, 2)
                .input(plateDouble, BlackPlutonium, 2)
                .input(circuit, MarkerMaterials.Tier.UIV)
                .input(gearSmall, LanthanumGroupLAlloy, 8)
                .input(screw, LanthanumFullereneNanotube, 32)
                .fluidInputs(Neutronium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK6, 4))
                .EUt(VA[UEV])
                .duration(400)
                .buildAndRegister();

        //  Precise Assembler Casing Mk VII
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UXV))
                .inputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK6))
                .input(ROBOT_ARM_UEV, 2)
                .input(plateDouble, Octiron, 2)
                .input(circuit, MarkerMaterials.Tier.UXV)
                .input(gearSmall, ActiniumGroupLAlloy, 8)
                .input(screw, ChargedCaesiumCeriumCobaltIndiumAlloy, 32)
                .fluidInputs(SuperheavyHAlloy.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK7, 4))
                .EUt(VA[UIV])
                .duration(400)
                .buildAndRegister();

        //  Precise Assembler Casing Mk VIII
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.OpV))
                .inputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK7))
                .input(ROBOT_ARM_UIV, 2)
                .input(plateDouble, Arcanium, 2)
                .input(circuit, MarkerMaterials.Tier.OpV)
                .input(gearSmall, CosmicNeutronium, 8)
                .input(screw, TantalumHafniumSeaborgiumCarbide, 32)
                .fluidInputs(Fatalium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK8, 4))
                .EUt(VA[UXV])
                .duration(400)
                .buildAndRegister();

        //  Iridium Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.STEEL_SOLID))
                .fluidInputs(Iridium.getFluid(L * 2))
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.IRIDIUM_CASING))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Advanced Filter Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Iridium)
                .inputs(MetaBlocks.CLEANROOM_CASING.getItemVariant(gregtech.common.blocks.BlockCleanroomCasing.CasingType.FILTER_CASING))
                .input(ELECTRIC_MOTOR_UV)
                .input(rotor, Iridium)
                .input(ITEM_FILTER)
                .input(FLUID_FILTER)
                .input(stickLong, Iridium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.CLEANROOM_CASING.getItemVariant(BlockCleanroomCasing.CleanroomCasingType.ADVANCED_FILTER_CASING))
                .EUt(VA[LuV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Component Assembly Line Casings
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Steel, 1)
                .input(plateDense, Steel, 4)
                .input(ROBOT_ARM_LV, 4)
                .input(ELECTRIC_PISTON_LV, 8)
                .input(ELECTRIC_MOTOR_LV, 10)
                .input(gear, Steel, 4)
                .input(wireGtQuadruple, Tin, 6)
                .input(circuit, MarkerMaterials.Tier.LV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.LV, 4))
                .EUt(VA[LV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Aluminium, 1)
                .input(plateDense, Aluminium, 4)
                .input(ROBOT_ARM_MV, 4)
                .input(ELECTRIC_PISTON_MV, 8)
                .input(ELECTRIC_MOTOR_MV, 10)
                .input(gear, Aluminium, 4)
                .input(wireGtQuadruple, Copper, 6)
                .input(circuit, MarkerMaterials.Tier.MV, 8)
                .input(circuit, MarkerMaterials.Tier.LV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.MV, 4))
                .EUt(VA[MV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, StainlessSteel, 1)
                .input(plateDense, StainlessSteel, 4)
                .input(ROBOT_ARM_HV, 4)
                .input(ELECTRIC_PISTON_HV, 8)
                .input(ELECTRIC_MOTOR_HV, 10)
                .input(gear, StainlessSteel, 4)
                .input(wireGtQuadruple, Gold, 6)
                .input(circuit, MarkerMaterials.Tier.HV, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.HV, 4))
                .EUt(VA[HV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Titanium, 1)
                .input(plateDense, Titanium, 4)
                .input(ROBOT_ARM_EV, 4)
                .input(ELECTRIC_PISTON_EV, 8)
                .input(ELECTRIC_MOTOR_EV, 10)
                .input(gear, Titanium, 4)
                .input(wireGtQuadruple, Aluminium, 6)
                .input(circuit, MarkerMaterials.Tier.EV, 8)
                .input(circuit, MarkerMaterials.Tier.HV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.EV, 4))
                .EUt(VA[EV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenSteel, 1)
                .input(plateDense, TungstenSteel, 4)
                .input(ROBOT_ARM_IV, 4)
                .input(ELECTRIC_PISTON_IV, 8)
                .input(ELECTRIC_MOTOR_IV, 10)
                .input(gear, TungstenSteel, 4)
                .input(wireGtQuadruple, Tungsten, 6)
                .input(circuit, MarkerMaterials.Tier.IV, 8)
                .input(circuit, MarkerMaterials.Tier.EV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.IV, 4))
                .EUt(VA[IV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, RhodiumPlatedPalladium)
                .input(plateDense, RhodiumPlatedPalladium, 6)
                .input(ROBOT_ARM_LuV, 8)
                .input(ELECTRIC_PISTON_LUV, 10)
                .input(ELECTRIC_MOTOR_LuV, 16)
                .input(gear, RhodiumPlatedPalladium, 4)
                .input(gearSmall, RhodiumPlatedPalladium, 16)
                .input(cableGtQuadruple, NiobiumTitanium, 8)
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .input(circuit, MarkerMaterials.Tier.IV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(Zeron100.getFluid(1728))
                .fluidInputs(TanmolyiumBetaC.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.LuV, 4))
                .EUt(VA[LuV])
                .duration(600)
                .scannerResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.IV))
                        .EUt(VA[IV])
                        .duration(1200))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .input(plateDense, NaquadahAlloy, 6)
                .input(ROBOT_ARM_ZPM, 8)
                .input(ELECTRIC_PISTON_ZPM, 10)
                .input(ELECTRIC_MOTOR_ZPM, 16)
                .input(gear, NaquadahAlloy, 4)
                .input(gearSmall, NaquadahAlloy, 16)
                .input(cableGtQuadruple, VanadiumGallium, 8)
                .input(circuit, MarkerMaterials.Tier.ZPM, 8)
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(MARM200CeSteel.getFluid(1728))
                .fluidInputs(HastelloyC59.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.ZPM, 4))
                .EUt(VA[ZPM])
                .duration(600)
                .scannerResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.LuV))
                        .EUt(VA[LuV])
                        .duration(1200))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Darmstadtium)
                .input(plateDense, Darmstadtium, 6)
                .input(ROBOT_ARM_UV, 8)
                .input(ELECTRIC_PISTON_UV, 10)
                .input(ELECTRIC_MOTOR_UV, 16)
                .input(gear, Darmstadtium, 4)
                .input(gearSmall, Darmstadtium, 16)
                .input(cableGtQuadruple, YttriumBariumCuprate, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 8)
                .input(circuit, MarkerMaterials.Tier.ZPM, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(HMS1J79Alloy.getFluid(1728))
                .fluidInputs(Pikyonium64B.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UV, 4))
                .EUt(VA[UV])
                .duration(600)
                .scannerResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.ZPM))
                        .EUt(VA[ZPM])
                        .duration(1200))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(plateDense, Orichalcum, 6)
                .input(ROBOT_ARM_UHV, 8)
                .input(ELECTRIC_PISTON_UHV, 10)
                .input(ELECTRIC_MOTOR_UHV, 16)
                .input(gear, Orichalcum, 4)
                .input(gearSmall, Orichalcum, 16)
                .input(cableGtQuadruple, Europium, 8)
                .input(circuit, MarkerMaterials.Tier.UHV, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(TitanSteel.getFluid(1728))
                .fluidInputs(Cinobite.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UHV, 4))
                .EUt(VA[UHV])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UV))
                        .EUt(VA[UV])
                        .CWUt(64))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(plateDense, Adamantium, 6)
                .input(ROBOT_ARM_UEV, 8)
                .input(ELECTRIC_PISTON_UEV, 10)
                .input(ELECTRIC_MOTOR_UEV, 16)
                .input(gear, Adamantium, 4)
                .input(gearSmall, Adamantium, 16)
                .input(cableGtQuadruple, PedotTMA, 8)
                .input(circuit, MarkerMaterials.Tier.UEV, 8)
                .input(circuit, MarkerMaterials.Tier.UHV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(BlackTitanium.getFluid(1728))
                .fluidInputs(Abyssalloy.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UEV, 4))
                .EUt(VA[UEV])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UHV))
                        .EUt(VA[UHV])
                        .CWUt(128))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Infinity)
                .input(plateDense, Infinity, 6)
                .input(ROBOT_ARM_UIV, 8)
                .input(ELECTRIC_PISTON_UIV, 10)
                .input(ELECTRIC_MOTOR_UIV, 16)
                .input(gear, Infinity, 4)
                .input(gearSmall, Infinity, 16)
                .input(cableGtQuadruple, Solarium, 8)
                .input(circuit, MarkerMaterials.Tier.UIV, 8)
                .input(circuit, MarkerMaterials.Tier.UEV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(BlackPlutonium.getFluid(1728))
                .fluidInputs(SuperheavyHAlloy.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UIV, 4))
                .EUt(VA[UIV])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UEV))
                        .EUt(VA[UEV])
                        .CWUt(256))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, CosmicNeutronium)
                .input(plateDense, CosmicNeutronium, 6)
                .input(ROBOT_ARM_UXV, 8)
                .input(ELECTRIC_PISTON_UXV, 10)
                .input(ELECTRIC_MOTOR_UXV, 16)
                .input(gear, CosmicNeutronium, 4)
                .input(gearSmall, CosmicNeutronium, 16)
                .input(cableGtQuadruple, Hypogen, 8)
                .input(circuit, MarkerMaterials.Tier.UXV, 8)
                .input(circuit, MarkerMaterials.Tier.UIV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(QuantumchromodynamicallyConfinedMatter.getFluid(1728))
                .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UXV, 4))
                .EUt(VA[UXV])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UIV))
                        .EUt(VA[UIV])
                        .CWUt(512))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Spacetime)
                .input(plateDense, Spacetime, 6)
                .input(ROBOT_ARM_OpV, 8)
                .input(ELECTRIC_PISTON_OpV, 10)
                .input(ELECTRIC_MOTOR_OpV, 16)
                .input(gear, Spacetime, 4)
                .input(gearSmall, Spacetime, 16)
                .input(cableGtQuadruple, Galaxium, 8)
                .input(circuit, MarkerMaterials.Tier.OpV, 8)
                .input(circuit, MarkerMaterials.Tier.UXV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(WhiteDwarfMatter.getFluid(1728))
                .fluidInputs(BlackDwarfMatter.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.OpV, 4))
                .EUt(VA[OpV])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UXV))
                        .EUt(VA[UXV])
                        .CWUt(1024))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Eternity)
                .input(plateDense, Eternity, 6)
                .input(ROBOT_ARM_MAX, 8)
                .input(ELECTRIC_PISTON_MAX, 10)
                .input(ELECTRIC_MOTOR_MAX, 16)
                .input(gear, Eternity, 4)
                .input(gearSmall, Eternity, 16)
                .input(cableGtQuadruple, Universium, 8)
                .input(circuit, MarkerMaterials.Tier.MAX, 8)
                .input(circuit, MarkerMaterials.Tier.OpV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(Arcanium.getFluid(1728))
                .fluidInputs(Shirabon.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.MAX, 4))
                .EUt(VA[MAX])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.OpV))
                        .EUt(VA[OpV])
                        .CWUt(2048))
                .buildAndRegister();

        //  Farm Casing
        ModHandler.addShapedRecipe(true, "farm_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.ASEPTIC_FARM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, TreatedWood),
                'F', new UnificationEntry(frameGt, Aluminium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, TreatedWood, 6)
                .input(frameGt, Aluminium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.ASEPTIC_FARM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Zirconium Carbide Casing
        ModHandler.addShapedRecipe(true, "zirconium_carbide_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.ZIRCONIUM_CARBIDE_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, ZirconiumCarbide),
                'F', new UnificationEntry(frameGt, ZirconiumCarbide));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, ZirconiumCarbide, 6)
                .input(frameGt, ZirconiumCarbide)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.ZIRCONIUM_CARBIDE_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Stellar Containment Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, MaragingSteel250)
                .input(plate, Hdcs, 4)
                .inputs(VOLTAGE_COIL_ZPM.getStackForm(2))
                .input(screw, IncoloyMA813, 8)
                .fluidInputs(Inconel792.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.STELLAR_CONTAINMENT_CASING))
                .EUt(VA[UHV])
                .duration(50)
                .buildAndRegister();

        //  High Energy Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Osmiridium)
                .input(plate, Osmiridium, 6)
                .input(circuit, MarkerMaterials.Tier.LuV)
                .input(wireFine, Iridium, 16)
                .input(wireFine, Cupronickel, 16)
                .input(wireGtSingle, VanadiumGallium, 2)
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING, 2))
                .EUt(VA[ZPM])
                .duration(100)
                .buildAndRegister();

        //  Advanced High Energy Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Europium)
                .input(plate, Europium, 6)
                .input(circuit, MarkerMaterials.Tier.ZPM)
                .input(wireFine, Ruridit, 16)
                .input(wireFine, Kanthal, 16)
                .input(wireGtSingle, YttriumBariumCuprate, 2)
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.ADVANCED_HIGH_ENERGY_CASING, 2))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  Ultimate High Energy Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Americium)
                .input(plate, Americium, 6)
                .input(circuit, MarkerMaterials.Tier.UV)
                .input(wireFine, Hdcs, 16)
                .input(wireFine, Nichrome, 16)
                .input(wireGtSingle, Europium, 2)
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.ULTIMATE_HIGH_ENERGY_CASING, 2))
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        //  Molecular Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenSteel)
                .input(plate, BlueSteel, 4)
                .input(wireFine, Tantalum, 16)
                .input(wireFine, Palladium, 16)
                .input(foil, Rhodium, 8)
                .input(wireGtDouble, Naquadah, 4)
                .fluidInputs(RTMAlloy.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.MOLECULAR_COIL, 2))
                .EUt(VA[ZPM])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Hollow Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, RhodiumPlatedPalladium)
                .input(pipeNormalFluid, Naquadah, 2)
                .input(ELECTRIC_PUMP_IV, 2)
                .input(ring, StainlessSteel, 32)
                .input(wireGtSingle, Platinum, 2)
                .fluidInputs(BlackSteel.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HOLLOW_CASING, 2))
                .EUt(VA[IV])
                .duration(200)
                .buildAndRegister();

        //  Spacetime Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Neutronium)
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HOLLOW_CASING))
                .input(plate, Infinity, 6)
                .input(FIELD_GENERATOR_UEV, 2)
                .input(wireFine, Vibranium, 16)
                .fluidInputs(Rhugnor.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.SPACETIME_CASING, 2))
                .EUt(VA[UEV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Dimensional Bridge Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.ADVANCED_HIGH_ENERGY_CASING))
                .input(plate, Vibranium, 6)
                .input(FIELD_GENERATOR_UHV, 2)
                .input(wireFine, YttriumBariumCuprate, 16)
                .fluidInputs(Tritanium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.DIMENSIONAL_BRIDGE_CASING, 2))
                .EUt(VA[UHV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Dimensional Preserve Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Neutronium)
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.ULTIMATE_HIGH_ENERGY_CASING))
                .input(plate, Infinity, 6)
                .input(FIELD_GENERATOR_UEV, 2)
                .input(wireFine, Europium, 16)
                .fluidInputs(Adamantium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.DIMENSIONAL_PRESERVE_CASING, 2))
                .EUt(VA[UEV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Field Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .input(plate, Kanthal, 4)
                .input(FIELD_GENERATOR_ZPM, 2)
                .input(wireGtSingle, VanadiumGallium, 2)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.ZPM, 2))
                .EUt(VA[ZPM])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Darmstadtium)
                .input(plate, Nichrome, 4)
                .input(FIELD_GENERATOR_UV, 2)
                .input(wireGtSingle, YttriumBariumCuprate, 2)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.UV, 2))
                .EUt(VA[UV])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(plate, RTMAlloy, 4)
                .input(FIELD_GENERATOR_UHV, 2)
                .input(wireGtSingle, Europium, 2)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.UHV, 2))
                .EUt(VA[UHV])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(plate, HSSG, 4)
                .input(FIELD_GENERATOR_UEV, 2)
                .input(wireGtSingle, PedotTMA, 2)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.UEV, 2))
                .EUt(VA[UEV])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Infinity)
                .input(plate, Naquadah, 4)
                .input(FIELD_GENERATOR_UIV, 2)
                .input(wireGtSingle, Solarium, 2)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.UIV, 2))
                .EUt(VA[UIV])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, CosmicNeutronium)
                .input(plate, Trinium, 4)
                .input(FIELD_GENERATOR_UXV, 2)
                .input(wireGtSingle, Hypogen, 2)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.UXV, 2))
                .EUt(VA[UXV])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Spacetime)
                .input(plate, Tritanium, 4)
                .input(FIELD_GENERATOR_OpV, 2)
                .input(wireGtSingle, Galaxium, 2)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.OpV, 2))
                .EUt(VA[OpV])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Eternity)
                .input(plate, Adamantium, 4)
                .input(FIELD_GENERATOR_MAX, 2)
                .input(wireGtSingle, Universium, 2)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.MAX, 2))
                .EUt(VA[MAX])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Space Elevator Casings
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenCarbide)
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.TUNGSTENSTEEL_ROBUST))
                .input(plate, Pikyonium64B, 6)
                .input(wireFine, Zinc, 16)
                .fluidInputs(Kanthal.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING.getItemVariant(BlockSpaceElevatorCasing.ElevatorCasingType.BASIC_CASING, 2))
                .EUt(VA[UV])
                .duration(50)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Osmiridium)
                .input(plate, IncoloyMA813, 6)
                .input(ELECTRIC_PUMP_IV, 2)
                .input(CONVEYOR_MODULE_IV, 2)
                .input(ROBOT_ARM_IV, 2)
                .input(wireFine, Tantalum, 16)
                .fluidInputs(RTMAlloy.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING.getItemVariant(BlockSpaceElevatorCasing.ElevatorCasingType.INTERNAL_STRUCTURE, 2))
                .EUt(VA[UV])
                .duration(50)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Naquadah)
                .input(plate, TungstenSteel, 6)
                .input(NEUTRON_REFLECTOR, 2)
                .input(stick, Inconel625, 2)
                .input(stick, MARM200Steel, 2)
                .input(wireFine, Lead, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING.getItemVariant(BlockSpaceElevatorCasing.ElevatorCasingType.SUPPORT_STRUCTURE, 2))
                .EUt(VA[UV])
                .duration(50)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.CLEANROOM_CASING.getItemVariant(gregtech.common.blocks.BlockCleanroomCasing.CasingType.PLASCRETE))
                .fluidInputs(FluorinatedEthylenePropylene.getFluid(L * 2)) // todo use more powerful plastic, this is too soft!
                .outputs(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING.getItemVariant(BlockSpaceElevatorCasing.ElevatorCasingType.FLOOR))
                .circuitMeta(6)
                .EUt(VA[HV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UV])
                .input(ELECTRIC_MOTOR_UV, 2)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(plate, HSSS, 4)
                .input(gear, Duranium, 3)
                .input(gearSmall, HY1301, 6)
                .input(wireFine, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(Lubricant.getFluid(16000))
                .fluidInputs(Tantalloy61.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING.getItemVariant(BlockSpaceElevatorCasing.ElevatorCasingType.CABLE_CASING))
                .EUt(VA[UV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING.getItemVariant(BlockSpaceElevatorCasing.ElevatorCasingType.BASIC_CASING))
                        .CWUt(128)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[IV])
                .input(frameGt, HSSG)
                .input(ELECTRIC_MOTOR_IV, 4)
                .input(wireFine, Platinum, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1600))
                .fluidInputs(Americium.getFluid(L))
                .outputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK1, 4))
                .EUt(VA[ZPM])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING.getItemVariant(BlockSpaceElevatorCasing.ElevatorCasingType.INTERNAL_STRUCTURE))
                        .CWUt(64)
                        .EUt(VA[ZPM]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSE)
                .inputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK1))
                .input(ELECTRIC_MOTOR_LuV, 4)
                .input(wireFine, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1600))
                .fluidInputs(Orichalcum.getFluid(L))
                .outputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK2, 4))
                .EUt(VA[UV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK1))
                        .CWUt(128)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSS)
                .inputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK2))
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(wireFine, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Lubricant.getFluid(3200))
                .fluidInputs(Adamantium.getFluid(L))
                .outputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK3, 4))
                .EUt(VA[UHV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK2))
                        .CWUt(256)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs)
                .inputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK3))
                .input(ELECTRIC_MOTOR_UV, 4)
                .input(wireFine, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Lubricant.getFluid(3200))
                .fluidInputs(Mithril.getFluid(L))
                .outputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK4, 4))
                .EUt(VA[UEV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK3))
                        .CWUt(512)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Infinity)
                .inputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK4))
                .input(ELECTRIC_MOTOR_UHV, 4)
                .input(wireFine, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Lubricant.getFluid(6400))
                .fluidInputs(Rhugnor.getFluid(L))
                .outputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK5, 4))
                .EUt(VA[UIV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK4))
                        .CWUt(1024)
                        .EUt(VA[UIV]))
                .buildAndRegister();

        //  Advanced Assembly Control Casing
        ModHandler.addShapedRecipe(true, "casing_assembly_control.advanced", GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getItemVariant(BlockActiveUniqueCasing.ActiveCasingType.ADVANCED_ASSEMBLY_CONTROL_CASING, 2),
                "OPO", "SFE", "OMO",
                'O', new UnificationEntry(circuit, MarkerMaterials.Tier.UV),
                'P', ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT,
                'F', new UnificationEntry(frameGt, NaquadahAlloy),
                'S', SENSOR_ZPM,
                'E', EMITTER_ZPM,
                'M', ELECTRIC_MOTOR_ZPM);

        //  Advanced Assembly Casing
        ModHandler.addShapedRecipe(true, "casing_assembly_line.advanced", GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getItemVariant(BlockActiveUniqueCasing.ActiveCasingType.ADVANCED_ASSEMBLY_LINE_CASING, 2),
                "PGP", "RFR", "PGP",
                'P', new UnificationEntry(plate, Iridium),
                'G', new UnificationEntry(gear, Osmiridium),
                'R', ROBOT_ARM_ZPM,
                'F', new UnificationEntry(frameGt, NaquadahAlloy));

        //  Circuit Assembly Casing
        ModHandler.addShapedRecipe(true, "circuit_assembly_casing", GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getItemVariant(BlockActiveUniqueCasing.ActiveCasingType.CIRCUIT_ASSEMBLY_LINE_CASING, 2),
                "PGP", "RFR", "PGP",
                'P', new UnificationEntry(plate, Osmium),
                'G', new UnificationEntry(gear, Rhodium),
                'R', ROBOT_ARM_LuV,
                'F', new UnificationEntry(frameGt, HSSE));

        //  Advanced Grate Casing
        ModHandler.addShapedRecipe(true, "advanced_grate_casing", GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.ADVANCED_GRATE_CASING, 2),
                "PRP", "PXP", "PMP",
                'X', MetaBlocks.MULTIBLOCK_CASING.getItemVariant(gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING),
                'R', new UnificationEntry(rotor, StainlessSteel),
                'M', ELECTRIC_MOTOR_LuV,
                'P', new UnificationEntry(plate, Osmiridium));

        //  Staballoy Casing
        ModHandler.addShapedRecipe(true, "staballoy_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.STABALLOY_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Staballoy),
                'F', new UnificationEntry(frameGt, MaragingSteel250));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Staballoy, 6)
                .input(frameGt, MaragingSteel250)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.STABALLOY_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Reinforced Rotor Holder

        //  LuV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, RhodiumPlatedPalladium)
                .input(ROTOR_HOLDER[3])
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(rotor, Staballoy, 4)
                .input(stickLong, Titanium, 2)
                .input(wireFine, Platinum, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .output(MULTIPART_REINFORCED_ROTOR_HOLDER[0])
                .EUt(VA[LuV])
                .duration(1200)
                .buildAndRegister();

        //  ZPM
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .input(ROTOR_HOLDER[4])
                .input(ELECTRIC_MOTOR_ZPM, 2)
                .input(rotor, Inconel792, 4)
                .input(stickLong, TungstenSteel, 2)
                .input(wireFine, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .output(MULTIPART_REINFORCED_ROTOR_HOLDER[1])
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  UV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Darmstadtium)
                .input(ROTOR_HOLDER[5])
                .input(ELECTRIC_MOTOR_UV, 2)
                .input(rotor, Inconel625, 4)
                .input(stickLong, RhodiumPlatedPalladium, 2)
                .input(wireFine, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .output(MULTIPART_REINFORCED_ROTOR_HOLDER[2])
                .EUt(VA[UV])
                .duration(1200)
                .buildAndRegister();

        //  UHV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(MULTIPART_REINFORCED_ROTOR_HOLDER[2])
                .input(ELECTRIC_MOTOR_UHV, 2)
                .input(CONVEYOR_MODULE_UHV, 2)
                .input(rotor, Adamantium, 4)
                .input(stickLong, HSSS, 2)
                .input(wireFine, YttriumBariumCuprate, 32)
                .fluidInputs(SolderingAlloy.getFluid(L * 10))
                .output(MULTIPART_REINFORCED_ROTOR_HOLDER[3])
                .EUt(VA[UHV])
                .duration(1200)
                .scannerResearch(b -> b
                        .researchStack(MULTIPART_REINFORCED_ROTOR_HOLDER[2].getStackForm())
                        .EUt(VA[UV])
                        .duration(600))
                .buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(MULTIPART_REINFORCED_ROTOR_HOLDER[3])
                .input(ELECTRIC_MOTOR_UEV, 2)
                .input(CONVEYOR_MODULE_UEV, 2)
                .input(rotor, Taranium, 4)
                .input(stickLong, Osmiridium, 2)
                .input(wireFine, ThalliumCopperChloride, 32)
                .fluidInputs(SolderingAlloy.getFluid(L * 10))
                .output(MULTIPART_REINFORCED_ROTOR_HOLDER[4])
                .EUt(VA[UEV])
                .duration(1200)
                .scannerResearch(b -> b
                        .researchStack(MULTIPART_REINFORCED_ROTOR_HOLDER[3].getStackForm())
                        .EUt(VA[UHV])
                        .duration(1200))
                .buildAndRegister();

        //  UIV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Infinity)
                .input(MULTIPART_REINFORCED_ROTOR_HOLDER[4])
                .input(ELECTRIC_MOTOR_UIV, 2)
                .input(CONVEYOR_MODULE_UIV, 2)
                .input(rotor, BlackPlutonium, 4)
                .input(stickLong, Tritanium, 2)
                .input(wireFine, SuperheavyLAlloy, 32)
                .fluidInputs(SolderingAlloy.getFluid(L * 10))
                .output(MULTIPART_REINFORCED_ROTOR_HOLDER[5])
                .EUt(VA[UIV])
                .duration(1200)
                .stationResearch(b -> b
                        .researchStack(MULTIPART_REINFORCED_ROTOR_HOLDER[4].getStackForm())
                        .EUt(VA[UEV])
                        .CWUt(64))
                .buildAndRegister();

        //  UXV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, CosmicNeutronium)
                .input(MULTIPART_REINFORCED_ROTOR_HOLDER[5])
                .input(ELECTRIC_MOTOR_UXV, 2)
                .input(CONVEYOR_MODULE_UXV, 2)
                .input(rotor, Octiron, 4)
                .input(stickLong, Adamantium, 2)
                .input(wireFine, SuperheavyHAlloy, 32)
                .fluidInputs(SolderingAlloy.getFluid(L * 10))
                .output(MULTIPART_REINFORCED_ROTOR_HOLDER[6])
                .EUt(VA[UXV])
                .duration(1200)
                .stationResearch(b -> b
                        .researchStack(MULTIPART_REINFORCED_ROTOR_HOLDER[5].getStackForm())
                        .EUt(VA[UIV])
                        .CWUt(128))
                .buildAndRegister();

        //  OpV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Spacetime)
                .input(MULTIPART_REINFORCED_ROTOR_HOLDER[6])
                .input(ELECTRIC_MOTOR_OpV, 2)
                .input(CONVEYOR_MODULE_OpV, 2)
                .input(rotor, TranscendentMetal, 4)
                .input(stickLong, Hdcs, 2)
                .input(wireFine, Arcanium, 32)
                .fluidInputs(SolderingAlloy.getFluid(L * 10))
                .output(MULTIPART_REINFORCED_ROTOR_HOLDER[7])
                .EUt(VA[OpV])
                .duration(1200)
                .stationResearch(b -> b
                        .researchStack(MULTIPART_REINFORCED_ROTOR_HOLDER[6].getStackForm())
                        .EUt(VA[UXV])
                        .CWUt(256))
                .buildAndRegister();

        //  Quantum Casing
        ModHandler.addShapedRecipe(true, "quantum_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.QUANTUM_CASING, 2),
                "PhP", "TFT","PwP",
                'P', new UnificationEntry(plateDouble, Naquadria),
                'T', new UnificationEntry(plate, QuantumAlloy),
                'F', new UnificationEntry(frameGt, Orichalcum));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plateDouble, Naquadria, 4)
                .input(plate, QuantumAlloy, 2)
                .input(frameGt, Orichalcum)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.QUANTUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Reflective Casing
        ModHandler.addShapedRecipe(true, "reflective_casing", GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.REFLECTIVE_CASING, 2),
                "NNN", "FHF", "WWW",
                'H', HULL[IV].getStackForm(),
                'N', NEUTRON_REFLECTOR,
                'F', FIELD_GENERATOR_IV,
                'W', new UnificationEntry(cableGtSingle, Platinum));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[IV])
                .input(NEUTRON_REFLECTOR, 3)
                .input(FIELD_GENERATOR_IV, 2)
                .input(cableGtSingle, Platinum, 3)
                .outputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.REFLECTIVE_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  PCB T1 casing
        ModHandler.addShapedRecipe(true, "photolithographic_framework_casing", GTLiteMetaBlocks.PCB_FACTORY_CASING.getItemVariant(BlockPCBFactoryCasing.PCBFactoryCasingType.BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Iridium),
                'F', new UnificationEntry(frameGt, Naquadah));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Iridium, 6)
                .input(frameGt, Naquadah)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.PCB_FACTORY_CASING.getItemVariant(BlockPCBFactoryCasing.PCBFactoryCasingType.BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  PCB T2 casing
        ModHandler.addShapedRecipe(true, "mold_printing_assembly_framework_casing", GTLiteMetaBlocks.PCB_FACTORY_CASING.getItemVariant(BlockPCBFactoryCasing.PCBFactoryCasingType.MOLD_PRINTING_ASSEMBLY_FRAMEWORK_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Pikyonium64B),
                'F', new UnificationEntry(frameGt, NaquadahEnriched));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Pikyonium64B, 6)
                .input(frameGt, NaquadahEnriched)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.PCB_FACTORY_CASING.getItemVariant(BlockPCBFactoryCasing.PCBFactoryCasingType.MOLD_PRINTING_ASSEMBLY_FRAMEWORK_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Water cooling casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, StainlessSteel)
                .input(plate, HY1301, 4)
                .input(pipeNormalFluid, Polybenzimidazole)
                .input(ELECTRIC_PUMP_EV)
                .input(wireFine, NiobiumTitanium, 4)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.PCB_FACTORY_CASING.getItemVariant(BlockPCBFactoryCasing.PCBFactoryCasingType.WATER_COOLED_MACHINE_CASING, 2))
                .EUt(VA[ZPM])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Bio chamber casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, VanadiumSteel)
                .input(plate, BlackSteel, 4)
                .input(FIELD_GENERATOR_EV)
                .input(STEM_CELLS, 2)
                .input(wireFine, VanadiumGallium, 4)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.PCB_FACTORY_CASING.getItemVariant(BlockPCBFactoryCasing.PCBFactoryCasingType.BIOLOGICAL_STERILE_MACHINE_CASING, 2))
                .EUt(VA[ZPM])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  PCB T3 casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Tritanium)
                .input(plate, Cinobite, 4)
                .input(TOOL_DATA_STICK)
                .input(wireFine, Tin, 4)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.PCB_FACTORY_CASING.getItemVariant(BlockPCBFactoryCasing.PCBFactoryCasingType.RADIATION_PROOF_SCAN_FRAMEWORK_CASING, 2))
                .EUt(VA[UV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Infinity cooling casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(plate, Infinity, 4)
                .input(pipeNormalFluid, Lafium)
                .input(ELECTRIC_PUMP_LuV)
                .input(wireFine, Europium, 4)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.PCB_FACTORY_CASING.getItemVariant(BlockPCBFactoryCasing.PCBFactoryCasingType.INFINITY_COOLED_MACHINE_CASING, 2))
                .EUt(VA[UHV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Computing casing
        ModHandler.addShapedRecipe(true, "computing_casing", GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.COMPMUTING_CASING, 2),
                "pPp", "wCw", "pSp",
                'C', GTLiteMetaBlocks.PCB_FACTORY_CASING.getItemVariant(BlockPCBFactoryCasing.PCBFactoryCasingType.RADIATION_PROOF_SCAN_FRAMEWORK_CASING),
                'P', COVER_SCREEN,
                'p', new UnificationEntry(plate, RhodiumPlatedPalladium),
                'S', SENSOR_IV,
                'w', new UnificationEntry(wireGtSingle, Cobalt));

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.PCB_FACTORY_CASING.getItemVariant(BlockPCBFactoryCasing.PCBFactoryCasingType.RADIATION_PROOF_SCAN_FRAMEWORK_CASING))
                .input(COVER_SCREEN)
                .input(plate, RhodiumPlatedPalladium, 4)
                .input(SENSOR_IV)
                .input(wireGtSingle, Cobalt, 2)
                .outputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.COMPMUTING_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Quantum coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, Europium, 8)
                .input(foil, Pikyonium64B, 8)
                .fluidInputs(QuantumAlloy.getFluid(L))
                .outputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.QUANTUM_COIL))
                .EUt(VA[UEV])
                .duration(1100)
                .buildAndRegister();

        //  Quantum Glass
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(plate, ZBLANGlass, 4)
                .notConsumable(SHAPE_MOLD_BLOCK)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .fluidInputs(Cinobite.getFluid(L / 2))
                .outputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.QUANTUM_GLASS))
                .EUt(VA[UHV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Hyper casings
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.NAQUADRIA_CASING))
                .circuitMeta(6)
                .fluidInputs(BlackPlutonium.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.HYPER_CASING))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.HYPER_CASING))
                .circuitMeta(6)
                .fluidInputs(BlackDwarfMatter.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.ADVANCED_HYPER_CASING))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(plate, CarbonNanotube, 4)
                .input(FIELD_GENERATOR_UV, 2)
                .input(wireFine, Seaborgium, 4)
                .fluidInputs(Hdcs.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.HYPER_CORE_MK1))
                .EUt(VA[UEV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(plate, CelestialTungsten, 4)
                .input(FIELD_GENERATOR_UHV, 2)
                .input(wireFine, AstralTitanium, 4)
                .fluidInputs(Legendarium.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.HYPER_CORE_MK2))
                .EUt(VA[UIV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Taranium)
                .input(plate, MetastableHassium, 4)
                .input(FIELD_GENERATOR_UEV, 2)
                .input(wireFine, SuperheavyHAlloy, 4)
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.HYPER_CORE_MK3))
                .EUt(VA[UXV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  HG-1223 casing
        ModHandler.addShapedRecipe(true, "hg_1223_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.HG1223_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, HG1223),
                'F', new UnificationEntry(frameGt, WatertightSteel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, HG1223, 6)
                .input(frameGt, WatertightSteel)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.HG1223_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Eglin Steel casing
        ModHandler.addShapedRecipe(true, "eglin_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.EGLIN_STEEL_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, EglinSteel),
                'F', new UnificationEntry(frameGt, EglinSteel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, EglinSteel, 6)
                .input(frameGt, EglinSteel)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.EGLIN_STEEL_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Tritanium casing
        ModHandler.addShapedRecipe(true, "tritanium_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.TRITANIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Tritanium),
                'F', new UnificationEntry(frameGt, HSSS));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Tritanium, 6)
                .input(frameGt, HSSS)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.TRITANIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Inconel-792 casing
        ModHandler.addShapedRecipe(true, "inconel_792_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.INCONEL_792_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Inconel792),
                'F', new UnificationEntry(frameGt, WatertightSteel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Inconel792, 6)
                .input(frameGt, WatertightSteel)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.INCONEL_792_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  MAR-M200 Steel casing
        ModHandler.addShapedRecipe(true, "mar_m200_steel_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.MAR_M200_CASING, 2),
                "TPT", "RFR", "TPT",
                'T', new UnificationEntry(plate, IncoloyMA956),
                'P', new UnificationEntry(plate, WatertightSteel),
                'R', new UnificationEntry(rotor, MARM200Steel),
                'F', new UnificationEntry(frameGt, MARM200Steel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, IncoloyMA956, 4)
                .input(plate, WatertightSteel, 2)
                .input(rotor, MARM200Steel, 2)
                .input(frameGt, MARM200Steel)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.MAR_M200_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Bioware Computer Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Ruridit)
                .input(plate, Ruridit, 6)
                .input(ELECTRIC_PUMP_IV, 2)
                .input(wireFine, BorosilicateGlass, 32)
                .input(wireFine, Rhodium, 32)
                .input(cableGtSingle, NiobiumTitanium, 2)
                .fluidInputs(Biomass.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.ComputerCasingType.BIOWARE_COMPUTER_CASING, 2))
                .EUt(VA[LuV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Advanced Bioware Computer Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.ComputerCasingType.BIOWARE_COMPUTER_CASING))
                .input(circuit, MarkerMaterials.Tier.LuV)
                .input(wireFine, Aluminium, 64)
                .input(wireFine, Cupronickel, 64)
                .input(wireGtSingle, SamariumIronArsenicOxide, 4)
                .outputs(GTLiteMetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.ComputerCasingType.ADVANCED_BIOWARE_COMPUTER_CASING, 2))
                .EUt(VA[LuV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Bioware Heat Vent
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Iridium)
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(rotor, Iridium, 2)
                .input(pipeTinyFluid, VanadiumSteel, 16)
                .input(plate, TinAlloy, 16)
                .input(wireFine, UraniumTriplatinum, 4)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.ComputerCasingType.BIOWARE_COMPUTER_HEAT_VENT, 2))
                .EUt(VA[IV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Bioware Computing Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Osmiridium)
                .input(PETRI_DISH)
                .input(plate, VanadiumGallium, 4)
                .input(dust, Sarcosine, 3)
                .input(FIELD_GENERATOR_LuV, 2)
                .input(cableGtSingle, NiobiumNitride)
                .outputs(GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getItemVariant(BlockActiveUniqueCasing.ActiveCasingType.BIOWARE_COMPUTING_CASING))
                .EUt(VA[LuV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  HSS-S Casing
        ModHandler.addShapedRecipe(true, "hss_s_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.HSS_S_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, HSSS),
                'F', new UnificationEntry(frameGt, Americium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, HSSS, 6)
                .input(frameGt, Americium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.HSS_S_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Einsteinium Casing
        ModHandler.addShapedRecipe(true, "einsteinium_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.EINSTEINIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Einsteinium),
                'F', new UnificationEntry(frameGt, Einsteinium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Einsteinium, 6)
                .input(frameGt, Einsteinium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.EINSTEINIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Nitinol-60 Casing
        ModHandler.addShapedRecipe(true, "nitinol_60_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.NITINOL_60_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Nitinol60),
                'F', new UnificationEntry(frameGt, Nitinol60));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Nitinol60, 6)
                .input(frameGt, Nitinol60)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.NITINOL_60_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Fermium Casing
        ModHandler.addShapedRecipe(true, "fermium_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.FERMIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Fermium),
                'F', new UnificationEntry(frameGt, Fermium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Fermium, 6)
                .input(frameGt, Fermium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.FERMIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Mendelevium Casing
        ModHandler.addShapedRecipe(true, "mendelevium_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.MENDELEVIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Mendelevium),
                'F', new UnificationEntry(frameGt, Mendelevium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Mendelevium, 6)
                .input(frameGt, Mendelevium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.MENDELEVIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Protactinium Casing
        ModHandler.addShapedRecipe(true, "protactinium_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.PROTACTINIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Protactinium),
                'F', new UnificationEntry(frameGt, Protactinium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Protactinium, 6)
                .input(frameGt, Protactinium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.PROTACTINIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  HSS-G Casing
        ModHandler.addShapedRecipe(true, "hss_g_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.HSS_G_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, HSSG),
                'F', new UnificationEntry(frameGt, HSSG));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, HSSG, 6)
                .input(frameGt, HSSG)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.HSS_G_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Incoloy-MA813 Casing
        ModHandler.addShapedRecipe(true, "incoloy_ma_813_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.INCOLOY_MA_813_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, IncoloyMA813),
                'F', new UnificationEntry(frameGt, IncoloyMA956));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, IncoloyMA813, 6)
                .input(frameGt, IncoloyMA956)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.INCOLOY_MA_813_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Curium Casing
        ModHandler.addShapedRecipe(true, "curium_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.CURIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Curium),
                'F', new UnificationEntry(frameGt, Curium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Curium, 6)
                .input(frameGt, Curium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.CURIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Uranium Casing
        ModHandler.addShapedRecipe(true, "uranium_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.URANIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Uranium235),
                'F', new UnificationEntry(frameGt, Uranium238));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Uranium235, 6)
                .input(frameGt, Uranium238)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.URANIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Potin Casing
        ModHandler.addShapedRecipe(true, "potin_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.POTIN_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Potin),
                'F', new UnificationEntry(frameGt, StainlessSteel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Potin, 6)
                .input(frameGt, StainlessSteel)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.POTIN_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Plutonium Casing
        ModHandler.addShapedRecipe(true, "plutonium_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.PLUTONIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Plutonium239),
                'F', new UnificationEntry(frameGt, Plutonium241));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Plutonium239, 6)
                .input(frameGt, Plutonium241)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.PLUTONIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Black Steel Casing
        ModHandler.addShapedRecipe(true, "black_steel_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.BLACK_STEEL_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, BlackSteel),
                'F', new UnificationEntry(frameGt, BlackSteel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, BlackSteel, 6)
                .input(frameGt, BlackSteel)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.BLACK_STEEL_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Tumbaga Casing
        ModHandler.addShapedRecipe(true, "tumbaga_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.TUMBAGA_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Tumbaga),
                'F', new UnificationEntry(frameGt, Tumbaga));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Tumbaga, 6)
                .input(frameGt, Tumbaga)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.TUMBAGA_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Rhodium Plated Palladium Casing
        ModHandler.addShapedRecipe(true, "rhodium_plated_palladium_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.RHODIUM_PLATED_PALLADIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, RhodiumPlatedPalladium),
                'F', new UnificationEntry(frameGt, RhodiumPlatedPalladium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, RhodiumPlatedPalladium, 6)
                .input(frameGt, RhodiumPlatedPalladium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.RHODIUM_PLATED_PALLADIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Berkelium Casing
        ModHandler.addShapedRecipe(true, "berkelium_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.BERKELIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Berkelium),
                'F', new UnificationEntry(frameGt, Berkelium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Berkelium, 6)
                .input(frameGt, Berkelium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.BERKELIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Californium Casing
        ModHandler.addShapedRecipe(true, "californium_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.CALIFORNIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Californium),
                'F', new UnificationEntry(frameGt, Californium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Californium, 6)
                .input(frameGt, Californium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.CALIFORNIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Neptunium Casing
        ModHandler.addShapedRecipe(true, "neptunium_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.NEPTUNIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Neptunium),
                'F', new UnificationEntry(frameGt, Neptunium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Neptunium, 6)
                .input(frameGt, Neptunium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.NEPTUNIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Nobelium Casing
        ModHandler.addShapedRecipe(true, "nobelium_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.NOBELIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Nobelium),
                'F', new UnificationEntry(frameGt, Nobelium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Nobelium, 6)
                .input(frameGt, Nobelium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.NOBELIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Lawrencium Casing
        ModHandler.addShapedRecipe(true, "lawrencium_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.LAWRENCIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Lawrencium),
                'F', new UnificationEntry(frameGt, Lawrencium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Lawrencium, 6)
                .input(frameGt, Lawrencium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.LAWRENCIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Niobium Titanium Casing
        ModHandler.addShapedRecipe(true, "niobium_titanium_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.NIOBIUM_TITANIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, NiobiumTitanium),
                'F', new UnificationEntry(frameGt, NiobiumNitride));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, NiobiumTitanium, 6)
                .input(frameGt, NiobiumNitride)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.NIOBIUM_TITANIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Botmium Casing
        ModHandler.addShapedRecipe(true, "botmium_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.BOTMIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Botmium),
                'F', new UnificationEntry(frameGt, Botmium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Botmium, 6)
                .input(frameGt, Botmium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.BOTMIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Ultimate Engine Intake Casing
        ModHandler.addShapedRecipe(true, "ultimate_engine_intake_casing", GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getItemVariant(BlockActiveUniqueCasing.ActiveCasingType.ULTIMATE_ENGINE_INTAKE_CASING, 2),
                "PhP", "RCR", "PwP",
                'C', GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.NAQUADAH_CASING),
                'R', new UnificationEntry(rotor, Naquadah),
                'P', new UnificationEntry(pipeNormalFluid, Naquadah));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(rotor, Naquadah, 2)
                .input(pipeNormalFluid, Naquadah, 4)
                .inputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.NAQUADAH_CASING))
                .outputs(GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getItemVariant(BlockActiveUniqueCasing.ActiveCasingType.ULTIMATE_ENGINE_INTAKE_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Austenitic Stainless Steel Casing
        ModHandler.addShapedRecipe(true, "austenitic_stainless_steel_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.AUSTENITIC_STAINLESS_STEEL_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, AusteniticStainlessSteel904L),
                'F', new UnificationEntry(frameGt, AusteniticStainlessSteel904L));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, AusteniticStainlessSteel904L, 6)
                .input(frameGt, AusteniticStainlessSteel904L)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.AUSTENITIC_STAINLESS_STEEL_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Laurenium Casing
        ModHandler.addShapedRecipe(true, "laurenium_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.LAURENIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Laurenium),
                'F', new UnificationEntry(frameGt, Laurenium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Laurenium, 6)
                .input(frameGt, Laurenium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.LAURENIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Advanced Crushing Wheel
        ModHandler.addShapedRecipe(true, "advanced_crushing_wheels", GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getItemVariant(BlockActiveUniqueCasing.ActiveCasingType.ADVANCED_CRUSHING_WHEEL, 2),
                "GGG", "ECE", "EXE",
                'C', GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.LAURENIUM_CASING),
                'G', new UnificationEntry(gearSmall, HSSE),
                'E', new UnificationEntry(gear, TungstenCarbide),
                'X', ELECTRIC_MOTOR_LuV);

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(gearSmall, HSSE, 3)
                .input(gear, TungstenCarbide, 4)
                .input(ELECTRIC_MOTOR_LuV)
                .inputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.LAURENIUM_CASING))
                .outputs(GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getItemVariant(BlockActiveUniqueCasing.ActiveCasingType.ADVANCED_CRUSHING_WHEEL, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Incoloy-DS Casing
        ModHandler.addShapedRecipe(true, "incoloy_ds_casing", GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.INCOLOY_DS_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, IncoloyDS),
                'F', new UnificationEntry(frameGt, RhodiumPlatedPalladium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, IncoloyDS, 6)
                .input(frameGt, RhodiumPlatedPalladium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.INCOLOY_DS_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Maraging Steel 250 Casing
        ModHandler.addShapedRecipe(true, "maraging_steel_250_casing", GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.MARAGING_STEEL_250_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, MaragingSteel250),
                'F', new UnificationEntry(frameGt, MaragingSteel250));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, MaragingSteel250, 6)
                .input(frameGt, MaragingSteel250)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.MARAGING_STEEL_250_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Ruridit Casing
        ModHandler.addShapedRecipe(true, "ruridit_casing", GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.RURIDIT_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Ruridit),
                'F', new UnificationEntry(frameGt, Ruridit));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Ruridit, 6)
                .input(frameGt, Ruridit)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.RURIDIT_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Osmiridium Casing
        ModHandler.addShapedRecipe(true, "osmiridium_casing", GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.OSMIRIDIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Osmiridium),
                'F', new UnificationEntry(frameGt, Osmiridium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Osmiridium, 6)
                .input(frameGt, Osmiridium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.OSMIRIDIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Fluxed Electrum Casing
        ModHandler.addShapedRecipe(true, "fluxed_electrum_casing", GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.FLUXED_ELECTRUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, FluxedElectrum),
                'F', new UnificationEntry(frameGt, TitaniumTungstenCarbide));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, FluxedElectrum, 6)
                .input(frameGt, TitaniumTungstenCarbide)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.FLUXED_ELECTRUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Rhodium Casing
        ModHandler.addShapedRecipe(true, "rhodium_casing", GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.RHODIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Rhodium),
                'F', new UnificationEntry(frameGt, Ruthenium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Rhodium, 6)
                .input(frameGt, Ruthenium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.RHODIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Naquadah Alloy Casing
        ModHandler.addShapedRecipe(true, "naquadah_alloy_casing", GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.NAQUADAH_ALLOY_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, NaquadahAlloy),
                'F', new UnificationEntry(frameGt, Trinium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, NaquadahAlloy, 6)
                .input(frameGt, Trinium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.NAQUADAH_ALLOY_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Yotta Fluid Tank Casings
        ModHandler.addShapedRecipe(true, "force_field_constrained_casing", GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.FORCE_FIELD_CONSTRAINED_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, MARM200Steel),
                'F', new UnificationEntry(frameGt, Rhodium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, MARM200Steel, 6)
                .input(frameGt, Rhodium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.FORCE_FIELD_CONSTRAINED_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, BlackSteel)
                .input(FLUID_CORE_T1)
                .input(plate, Steel,4)
                .input(ELECTRIC_PUMP_HV, 8)
                .input(pipeNormalFluid, StainlessSteel, 4)
                .circuitMeta(5)
                .fluidInputs(Cupronickel.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.YOTTA_TANK_CELL.getItemVariant(BlockYottaTankCell.YottaTankCellTier.T1))
                .EUt(VA[HV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenSteel)
                .input(FLUID_CORE_T2)
                .input(plate, RhodiumPlatedPalladium, 4)
                .input(ELECTRIC_PUMP_EV, 8)
                .input(pipeNormalFluid, Titanium, 4)
                .circuitMeta(5)
                .fluidInputs(Kanthal.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.YOTTA_TANK_CELL.getItemVariant(BlockYottaTankCell.YottaTankCellTier.T2))
                .EUt(VA[IV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Naquadah)
                .input(FLUID_CORE_T3)
                .input(plate, NaquadahEnriched, 4)
                .input(ELECTRIC_PUMP_IV, 8)
                .input(pipeNormalFluid, NiobiumTitanium, 4)
                .circuitMeta(5)
                .fluidInputs(Nichrome.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.YOTTA_TANK_CELL.getItemVariant(BlockYottaTankCell.YottaTankCellTier.T3))
                .EUt(VA[LuV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Trinium)
                .input(FLUID_CORE_T4)
                .input(plate, Naquadria, 4)
                .input(ELECTRIC_PUMP_LuV, 8)
                .input(pipeNormalFluid, Iridium, 4)
                .circuitMeta(5)
                .fluidInputs(RTMAlloy.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.YOTTA_TANK_CELL.getItemVariant(BlockYottaTankCell.YottaTankCellTier.T4))
                .EUt(VA[ZPM])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Americium)
                .input(FLUID_CORE_T5)
                .input(plate, Tritanium, 4)
                .input(ELECTRIC_PUMP_ZPM, 8)
                .input(pipeNormalFluid, Europium, 4)
                .circuitMeta(5)
                .fluidInputs(HSSG.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.YOTTA_TANK_CELL.getItemVariant(BlockYottaTankCell.YottaTankCellTier.T5))
                .EUt(VA[UV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(FLUID_CORE_T6)
                .input(plate, Adamantium, 4)
                .input(ELECTRIC_PUMP_UV, 8)
                .input(pipeNormalFluid, Duranium, 4)
                .circuitMeta(5)
                .fluidInputs(Naquadah.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.YOTTA_TANK_CELL.getItemVariant(BlockYottaTankCell.YottaTankCellTier.T6))
                .EUt(VA[UHV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, CelestialTungsten)
                .input(FLUID_CORE_T7)
                .input(plate, AstralTitanium, 4)
                .input(ELECTRIC_PUMP_UHV, 8)
                .input(pipeNormalFluid, Lafium, 4)
                .circuitMeta(5)
                .fluidInputs(Trinium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.YOTTA_TANK_CELL.getItemVariant(BlockYottaTankCell.YottaTankCellTier.T7))
                .EUt(VA[UEV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Infinity)
                .input(FLUID_CORE_T8)
                .input(plate, DegenerateRhenium, 4)
                .input(ELECTRIC_PUMP_UEV, 8)
                .input(pipeNormalFluid, CrystalMatrix, 4)
                .circuitMeta(5)
                .fluidInputs(Tritanium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.YOTTA_TANK_CELL.getItemVariant(BlockYottaTankCell.YottaTankCellTier.T8))
                .EUt(VA[UIV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, HeavyQuarkDegenerateMatter)
                .input(FLUID_CORE_T9)
                .input(plate, BlackDwarfMatter, 4)
                .input(ELECTRIC_PUMP_UIV, 8)
                .input(pipeNormalFluid, QuantumchromodynamicallyConfinedMatter, 4)
                .circuitMeta(5)
                .fluidInputs(Ichorium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.YOTTA_TANK_CELL.getItemVariant(BlockYottaTankCell.YottaTankCellTier.T9))
                .EUt(VA[UXV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TranscendentMetal)
                .input(FLUID_CORE_T10)
                .input(plate, Shirabon, 4)
                .input(ELECTRIC_PUMP_UXV, 8)
                .input(pipeNormalFluid, Fatalium, 4)
                .circuitMeta(5)
                .fluidInputs(Astralium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.YOTTA_TANK_CELL.getItemVariant(BlockYottaTankCell.YottaTankCellTier.T10))
                .EUt(VA[OpV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Incoloy-020 Casing
        ModHandler.addShapedRecipe(true, "incoloy_020_casing", GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.INCOLOY_020_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Incoloy020),
                'F', new UnificationEntry(frameGt, Incoloy020));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Incoloy020, 6)
                .input(frameGt, Incoloy020)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.INCOLOY_020_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Tantalum Carbide Casing
        ModHandler.addShapedRecipe(true, "tantalum_carbide_casing", GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.TANTALUM_CARBIDE_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, TantalumCarbide),
                'F', new UnificationEntry(frameGt, TantalumCarbide));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, TantalumCarbide, 6)
                .input(frameGt, TantalumCarbide)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.TANTALUM_CARBIDE_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Advanced Slicing Blade
        ModHandler.addShapedRecipe(true, "advanced_slicing_blades", GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getItemVariant(BlockActiveUniqueCasing.ActiveCasingType.ADVANCED_SLICING_BLADE, 2),
                "PPP", "GCG", "GMG",
                'C', GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.TANTALUM_CARBIDE_CASING),
                'M', ELECTRIC_MOTOR_LuV,
                'G', new UnificationEntry(gear, TungstenCarbide),
                'P', new UnificationEntry(plate, HSSE));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, HSSE, 3)
                .input(gear, TungstenCarbide, 4)
                .input(ELECTRIC_MOTOR_LuV)
                .inputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.TANTALUM_CARBIDE_CASING))
                .outputs(GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getItemVariant(BlockActiveUniqueCasing.ActiveCasingType.ADVANCED_SLICING_BLADE, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Naquadah Casing
        ModHandler.addShapedRecipe(true, "naquadah_casing", GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.NAQUADAH_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Naquadah),
                'F', new UnificationEntry(frameGt, Naquadah));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Naquadah, 6)
                .input(frameGt, Naquadah)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.NAQUADAH_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Naquadah Gearbox Casing
        ModHandler.addShapedRecipe(true, "naquadah_gearbox_casing", GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.NAQUADAH_GEARBOX_CASING, 2),
                "PhP", "GFG", "PwP",
                'P', new UnificationEntry(plate, Naquadah),
                'G', new UnificationEntry(gear, Naquadah),
                'F', new UnificationEntry(frameGt, Naquadah));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Naquadah, 4)
                .input(gear, Naquadah, 2)
                .input(frameGt, Naquadah)
                .circuitMeta(4)
                .outputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.NAQUADAH_GEARBOX_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Hattrium Casing
        ModHandler.addShapedRecipe(true, "hattrium_casing", GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.HATTRIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Hattrium),
                'F', new UnificationEntry(frameGt, Hattrium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Hattrium, 6)
                .input(frameGt, Hattrium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.HATTRIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Circulative Cooling Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.HATTRIUM_CASING))
                .input(ELECTRIC_PUMP_IV, 2)
                .input(gear, SiliconeRubber)
                .input(pipeNormalFluid, Aluminium, 4)
                .input(ring, Zinc, 16)
                .input(wireFine, NaquadahEnriched, 4)
                .fluidInputs(GelidCryotheum.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.STRUCTURE_CASING.getItemVariant(BlockStructureCasing.StructureCasingType.CIRCULATIVE_COOLING_CASING, 2))
                .EUt(VA[IV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Circulative Cooling Core
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(plate, AlkalisGroupAlloy, 2)
                .input(SENSOR_IV, 2)
                .input(rotor, Meitnerium)
                .input(FLUID_CELL_LARGE_STEEL)
                .input(wireFine, PlatinumGroupAlloy, 4)
                .fluidInputs(EnrichedNaquadahTriniumEuropiumDuranide.getFluid(L / 4))
                .outputs(GTLiteMetaBlocks.COOLING_CORE.getItemVariant(BlockCoolingCore.CoolingCoreTier.MK1, 4))
                .EUt(VA[UHV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.COOLING_CORE.getItemVariant(BlockCoolingCore.CoolingCoreTier.MK1))
                .input(plate, RefractoryAlloy, 2)
                .input(SENSOR_LuV, 2)
                .input(rotor, Nobelium)
                .input(FLUID_CELL_LARGE_ALUMINIUM)
                .input(wireFine, Tairitsium, 4)
                .fluidInputs(PedotPSS.getFluid(L / 4))
                .outputs(GTLiteMetaBlocks.COOLING_CORE.getItemVariant(BlockCoolingCore.CoolingCoreTier.MK2, 4))
                .EUt(VA[UEV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.COOLING_CORE.getItemVariant(BlockCoolingCore.CoolingCoreTier.MK2))
                .input(plate, BlackTitanium, 2)
                .input(SENSOR_ZPM, 2)
                .input(rotor, MetastableOganesson)
                .input(FLUID_CELL_LARGE_STAINLESS_STEEL)
                .input(wireFine, SuperheavyLAlloy, 4)
                .fluidInputs(QuantumAlloy.getFluid(L / 4))
                .outputs(GTLiteMetaBlocks.COOLING_CORE.getItemVariant(BlockCoolingCore.CoolingCoreTier.MK3, 4))
                .EUt(VA[UIV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.COOLING_CORE.getItemVariant(BlockCoolingCore.CoolingCoreTier.MK3))
                .input(plate, BlackPlutonium, 2)
                .input(SENSOR_UV, 2)
                .input(rotor, MetastableHassium)
                .input(FLUID_CELL_LARGE_TITANIUM)
                .input(wireFine, SuperheavyHAlloy, 4)
                .fluidInputs(FullereneSuperconductor.getFluid(L / 4))
                .outputs(GTLiteMetaBlocks.COOLING_CORE.getItemVariant(BlockCoolingCore.CoolingCoreTier.MK4, 4))
                .EUt(VA[UXV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Hypogen Coil Block
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, Hypogen, 8)
                .input(foil, ArceusAlloy2B, 8)
                .fluidInputs(FullereneSuperconductor.getFluid(L))
                .outputs(GTLiteMetaBlocks.DYSON_SWARM_CASING.getItemVariant(BlockDysonSwarmCasing.DysonSwarmCasingType.HYPOGEN_COIL_BLOCK, 2))
                .EUt(VA[UIV])
                .duration(1200)
                .buildAndRegister();

        //  Dyson Swarm Control Casing
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, CelestialTungsten)
                .input(plate, Pikyonium64B, 6)
                .input(EMITTER_UHV, 2)
                .input(SENSOR_UHV, 2)
                .input(FEMTO_PIC_CHIP, 4)
                .input(COVER_ENERGY_DETECTOR_ADVANCED, 8)
                .input(cableGtDouble, AstralTitanium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Osmiridium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.DYSON_SWARM_CASING.getItemVariant(BlockDysonSwarmCasing.DysonSwarmCasingType.CONTROL_CASING, 8))
                .stationResearch(b -> b
                        .researchStack(TIERED_HATCH[UIV].getStackForm())
                        .EUt(VA[UIV])
                        .CWUt(288))
                .EUt(8000000)
                .duration(400)
                .buildAndRegister();

        //  Control Primary
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, IncoloyMA813)
                .input(ring, Naquadah, 32)
                .input(foil, RutheniumTriniumAmericiumNeutronate, 16)
                .input(wireFine, UraniumTriplatinum, 4)
                .fluidInputs(TinAlloy.getFluid(L * 4))
                .fluidInputs(HSSE.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.DYSON_SWARM_CASING.getItemVariant(BlockDysonSwarmCasing.DysonSwarmCasingType.CONTROL_PRIMARY, 4))
                .EUt(8000000)
                .duration(200)
                .CasingTier(5) // UEV
                .buildAndRegister();

        //  Control Secondary
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.MOLECULAR_COIL))
                .input(gear, Duranium)
                .input(gearSmall, Orichalcum)
                .input(ring, RTMAlloy, 32)
                .input(wireFine, Trinium, 4)
                .fluidInputs(Hikarium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.DYSON_SWARM_CASING.getItemVariant(BlockDysonSwarmCasing.DysonSwarmCasingType.CONTROL_SECONDARY, 4))
                .EUt(8000000)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Control Toroid
        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(frameGt, MetastableOganesson)
                .input(foil, WhiteDwarfMatter, 8)
                .input(screw, Neutronium, 4)
                .fluidInputs(BlackTitanium.getFluid(L))
                .outputs(GTLiteMetaBlocks.DYSON_SWARM_CASING.getItemVariant(BlockDysonSwarmCasing.DysonSwarmCasingType.CONTROL_TOROID))
                .EUt(8000000)
                .duration(20)
                .CasingTier(5)
                .buildAndRegister();

        //  Depolyment Casing
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TantalumHafniumSeaborgiumCarbide)
                .input(QUANTUM_CHEST[8])
                .input(CONVEYOR_MODULE_UIV, 2)
                .input(screw, MetastableHassium, 4)
                .fluidInputs(MetastableFlerovium.getFluid(L))
                .fluidInputs(PedotTMA.getFluid(L / 2))
                .outputs(GTLiteMetaBlocks.DYSON_SWARM_CASING.getItemVariant(BlockDysonSwarmCasing.DysonSwarmCasingType.DEPLOYMENT_CASING, 8))
                .EUt(8000000)
                .duration(400)
                .CasingTier(5) // UEV
                .buildAndRegister();

        //  Depolyment Magnet
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HY1301)
                .input(plate, NaquadahEnriched, 4)
                .input(plate, PedotPSS, 4)
                .input(ELECTRON)
                .input(gear, MagnetoHydrodynamicallyConstrainedStarMatter, 2)
                .input(ring, HMS1J79Alloy, 32)
                .input(foil, QuantumAlloy, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(UraniumRhodiumDinaquadide.getFluid(L * 4))
                .fluidInputs(Germanium.getFluid(L))
                .outputs(GTLiteMetaBlocks.DYSON_SWARM_CASING.getItemVariant(BlockDysonSwarmCasing.DysonSwarmCasingType.DEPLOYMENT_MAGNET, 4))
                .stationResearch(b -> b
                        .researchStack(EXCITATION_MAINTAINER.getStackForm())
                        .EUt(VA[UIV])
                        .CWUt(288))
                .EUt(8000000)
                .duration(400)
                .buildAndRegister();

        //  Receiver Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, LanthanumGroupHAlloy)
                .input(CONVEYOR_MODULE_UEV)
                .input(ELECTRIC_PUMP_UEV)
                .input(plateDouble, TitanSteel, 2)
                .input(foil, SuperheavyLAlloy, 16)
                .input(wireFine, LunaSilver, 4)
                .fluidInputs(FluxedElectrum.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.DYSON_SWARM_CASING.getItemVariant(BlockDysonSwarmCasing.DysonSwarmCasingType.RECEIVER_CASING, 8))
                .EUt(8000000)
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Receiver Core
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Darmstadtium)
                .input(plate, HastelloyK243, 4)
                .input(plate, ArceusAlloy2B, 4)
                .input(FIELD_GENERATOR_UEV, 2)
                .input(foil, Tairitsium, 16)
                .input(cableGtDouble, Solarium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(ChargedCaesiumCeriumCobaltIndiumAlloy.getFluid(L * 2))
                .fluidInputs(Mendelevium.getFluid(L))
                .outputs(GTLiteMetaBlocks.DYSON_SWARM_CASING.getItemVariant(BlockDysonSwarmCasing.DysonSwarmCasingType.DEPLOYMENT_CORE))
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK5))
                        .EUt(VA[UIV])
                        .CWUt(288))
                .EUt(8000000)
                .duration(100)
                .buildAndRegister();

        //  Quantum Computer Casings
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Duranium)
                .input(plate, Duranium, 6)
                .input(circuit, MarkerMaterials.Tier.ZPM)
                .input(wireFine, Osmiridium, 32)
                .input(wireFine, Rhenium, 32)
                .input(wireGtSingle, YttriumBariumCuprate, 2)
                .outputs(GTLiteMetaBlocks.QUANTUM_COMPUTER_CASING.getItemVariant(BlockQuantumComputerCasing.QCCasingType.COMPUTER_CASING, 2))
                .EUt(VA[ZPM])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.QUANTUM_COMPUTER_CASING.getItemVariant(BlockQuantumComputerCasing.QCCasingType.COMPUTER_CASING))
                .input(circuit, MarkerMaterials.Tier.UV)
                .input(wireFine, Titanium, 64)
                .input(wireFine, RedAlloy, 64)
                .input(wireGtSingle, UraniumRhodiumDinaquadide, 4)
                .outputs(GTLiteMetaBlocks.QUANTUM_COMPUTER_CASING.getItemVariant(BlockQuantumComputerCasing.QCCasingType.ADVANCED_COMPUTER_CASING))
                .EUt(VA[ZPM])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Titanium)
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(rotor, Titanium, 2)
                .input(pipeTinyFluid, Titanium, 16)
                .input(plate, BlackBronze, 16)
                .input(wireGtSingle, IndiumTinBariumTitaniumCuprate)
                .outputs(GTLiteMetaBlocks.QUANTUM_COMPUTER_CASING.getItemVariant(BlockQuantumComputerCasing.QCCasingType.HEAT_VENT, 2))
                .EUt(VA[LuV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}