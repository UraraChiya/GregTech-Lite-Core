package magicbook.gtlitecore.loaders.components;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class MachineComponents {
    public static void init() {
        ElectricMotor();
        ConveyorModule();
        ElectricPiston();
        RobotArm();
        ElectricPump();
        Emitter();
        Sensor();
        FieldGenerator();
    }

    private static void ElectricMotor() {

        //  ULV
        ModHandler.addShapedRecipe(true, "electric_motor.ulv", ELECTRIC_MOTOR_ULV.getStackForm(),
                "CWR", "WMW", "RWC",
                'C', new UnificationEntry(pipeTinyFluid, Bronze),
                'W', new UnificationEntry(wireGtSingle, Lead),
                'M', new UnificationEntry(stick, IronMagnetic),
                'R', new UnificationEntry(stick, WroughtIron));

        //  UHV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTellurideMagnetic)
                .input(stickLong, Adamantium, 4)
                .input(ring, Adamantium, 4)
                .input(round, Adamantium, 8)
                .input(wireFine, SiliconCarbide, 64)
                .input(wireFine, SiliconCarbide, 64)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ELECTRIC_MOTOR_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_MOTOR_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTellurideMagnetic)
                .input(stickLong, Hdcs, 4)
                .input(ring, Hdcs, 4)
                .input(round, Hdcs, 8)
                .input(wireFine, Seaborgium, 64)
                .input(wireFine, Seaborgium, 64)
                .input(cableGtSingle, PedotTMA, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Lubricant.getFluid(5000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(Ichorium.getFluid(L))
                .output(ELECTRIC_MOTOR_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_MOTOR_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  UIV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, PhosphorusDopedEuropiumIronArsenideMagnetic)
                .input(stickLong, Legendarium, 4)
                .input(ring, Legendarium, 4)
                .input(round, Legendarium, 8)
                .input(wireFine, Abyssalloy, 64)
                .input(wireFine, Abyssalloy, 64)
                .input(cableGtSingle, Solarium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Lubricant.getFluid(7000))
                .fluidInputs(Zylon.getFluid(L * 4))
                .fluidInputs(Astralium.getFluid(L * 2))
                .output(ELECTRIC_MOTOR_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_MOTOR_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  UXV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, PhosphorusDopedEuropiumIronArsenideMagnetic)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 4)
                .input(ring, MagnetoHydrodynamicallyConstrainedStarMatter, 4)
                .input(round, MagnetoHydrodynamicallyConstrainedStarMatter, 8)
                .input(wireFine, BlackDwarfMatter, 64)
                .input(wireFine, BlackDwarfMatter, 64)
                .input(cableGtSingle, Hypogen, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(Lubricant.getFluid(9000))
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 8))
                .fluidInputs(Hikarium.getFluid(L * 4))
                .output(ELECTRIC_MOTOR_UXV)
                .duration(3000)
                .EUt(30000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_MOTOR_UIV.getStackForm())
                        .CWUt(512)
                        .EUt(VA[UIV]))
                .buildAndRegister();

        //  OpV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
               .input(stickLong, BismuthLawrenciumStrontiumCuprateMagnetic)
               .input(stickLong, TranscendentMetal, 4)
               .input(ring, TranscendentMetal, 4)
               .input(round, TranscendentMetal, 8)
               .input(wireFine, Shirabon, 64)
               .input(wireFine, Shirabon, 64)
               .input(cableGtSingle, Galaxium, 2)
               .fluidInputs(SolderingAlloy.getFluid(L * 128))
               .fluidInputs(Lubricant.getFluid(11000))
               .fluidInputs(CosmicFabric.getFluid(L * 16))
               .fluidInputs(Arcanium.getFluid(L * 8))
               .output(ELECTRIC_MOTOR_OpV)
               .duration(3600)
               .EUt(100000000)
               .stationResearch(b -> b
                       .researchStack(ELECTRIC_MOTOR_UXV.getStackForm())
                       .CWUt(1024)
                       .EUt(VA[UXV]))
               .buildAndRegister();

    }

    private static void ConveyorModule() {

        //  ULV
        ModHandler.addShapedRecipe(true, "conveyor_module.ulv", CONVEYOR_MODULE_ULV.getStackForm(),
                "RRR", "MCM", "RRR",
                'R', "wool",
                'M', ELECTRIC_MOTOR_ULV.getStackForm(),
                'C', new UnificationEntry(pipeTinyFluid, Bronze));

        //  UHV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV, 2)
                .input(plate, Adamantium, 2)
                .input(ring, Adamantium, 4)
                .input(round, Adamantium, 16)
                .input(screw, Adamantium, 4)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 32))
                .fluidInputs(Vibranium.getFluid(L))
                .output(CONVEYOR_MODULE_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(CONVEYOR_MODULE_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV, 2)
                .input(plate, Hdcs, 2)
                .input(ring, Hdcs, 4)
                .input(round, Hdcs, 16)
                .input(screw, Hdcs, 4)
                .input(cableGtSingle, PedotTMA, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Lubricant.getFluid(5000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 40))
                .fluidInputs(Ichorium.getFluid(L * 2))
                .output(CONVEYOR_MODULE_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(CONVEYOR_MODULE_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  UIV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UIV, 2)
                .input(plate, Legendarium, 2)
                .input(ring, Legendarium, 4)
                .input(round, Legendarium, 16)
                .input(screw, Legendarium, 4)
                .input(cableGtSingle, Solarium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Lubricant.getFluid(7000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 48))
                .fluidInputs(Astralium.getFluid(L * 4))
                .output(CONVEYOR_MODULE_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(CONVEYOR_MODULE_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  UXV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UXV, 2)
                .input(plate, MagnetoHydrodynamicallyConstrainedStarMatter, 2)
                .input(ring, MagnetoHydrodynamicallyConstrainedStarMatter, 4)
                .input(round, MagnetoHydrodynamicallyConstrainedStarMatter, 16)
                .input(screw, MagnetoHydrodynamicallyConstrainedStarMatter, 4)
                .input(cableGtSingle, Hypogen, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(Lubricant.getFluid(9000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 56))
                .fluidInputs(Hikarium.getFluid(L * 8))
                .output(CONVEYOR_MODULE_UXV)
                .duration(3000)
                .EUt(30000000)
                .stationResearch(b -> b
                        .researchStack(CONVEYOR_MODULE_UIV.getStackForm())
                        .CWUt(512)
                        .EUt(VA[UIV]))
                .buildAndRegister();

        //  OpV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_OpV, 2)
                .input(plate, TranscendentMetal, 2)
                .input(ring, TranscendentMetal, 4)
                .input(round, TranscendentMetal, 16)
                .input(screw, TranscendentMetal, 4)
                .input(cableGtSingle, Galaxium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 128))
                .fluidInputs(Lubricant.getFluid(11000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 64))
                .fluidInputs(Arcanium.getFluid(L * 16))
                .output(CONVEYOR_MODULE_OpV)
                .duration(3600)
                .EUt(100000000)
                .stationResearch(b -> b
                        .researchStack(CONVEYOR_MODULE_UXV.getStackForm())
                        .CWUt(1024)
                        .EUt(VA[UXV]))
                .buildAndRegister();
    }

    private static void ElectricPiston() {

        //  ULV
        ModHandler.addShapedRecipe(true, "electric_piston.ulv", ELECTRIC_PISTON_ULV.getStackForm(),
                "PPP", "CRR", "CMG",
                'P', new UnificationEntry(plate, WroughtIron),
                'C', new UnificationEntry(pipeTinyFluid, Bronze),
                'R', new UnificationEntry(stick, WroughtIron),
                'M', ELECTRIC_MOTOR_ULV.getStackForm(),
                'G', new UnificationEntry(gearSmall, WroughtIron));

        //  UHV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV)
                .input(plate, Adamantium, 4)
                .input(ring, Adamantium, 4)
                .input(round, Adamantium, 16)
                .input(stick, Adamantium, 4)
                .input(gear, Orichalcum)
                .input(gearSmall, Orichalcum, 2)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ELECTRIC_PISTON_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PISTON_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV)
                .input(plate, Hdcs, 4)
                .input(ring, Hdcs, 4)
                .input(round, Hdcs, 16)
                .input(stick, Hdcs, 4)
                .input(gear, Adamantium)
                .input(gearSmall, Adamantium, 2)
                .input(cableGtSingle, PedotTMA, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Lubricant.getFluid(5000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(Ichorium.getFluid(L))
                .output(ELECTRIC_PISTON_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PISTON_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  UIV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UIV)
                .input(plate, Legendarium, 4)
                .input(ring, Legendarium, 4)
                .input(round, Legendarium, 16)
                .input(stick, Legendarium, 4)
                .input(gear, Infinity)
                .input(gearSmall, Infinity, 2)
                .input(cableGtSingle, Solarium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Lubricant.getFluid(7000))
                .fluidInputs(Zylon.getFluid(L * 4))
                .fluidInputs(Astralium.getFluid(L * 2))
                .output(ELECTRIC_PISTON_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PISTON_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  UXV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UXV)
                .input(plate, MagnetoHydrodynamicallyConstrainedStarMatter, 4)
                .input(ring, MagnetoHydrodynamicallyConstrainedStarMatter, 4)
                .input(round, MagnetoHydrodynamicallyConstrainedStarMatter, 16)
                .input(stick, MagnetoHydrodynamicallyConstrainedStarMatter, 4)
                .input(gear, CosmicNeutronium)
                .input(gearSmall, CosmicNeutronium, 2)
                .input(cableGtSingle, Hypogen, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(Lubricant.getFluid(9000))
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 8))
                .fluidInputs(Hikarium.getFluid(L * 4))
                .output(ELECTRIC_PISTON_UXV)
                .duration(3000)
                .EUt(30000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PISTON_UIV.getStackForm())
                        .CWUt(512)
                        .EUt(VA[UIV]))
                .buildAndRegister();

        //  OpV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_OpV)
                .input(plate, TranscendentMetal, 4)
                .input(ring, TranscendentMetal, 4)
                .input(round, TranscendentMetal, 16)
                .input(stick, TranscendentMetal, 4)
                .input(gear, Spacetime)
                .input(gearSmall, Spacetime, 2)
                .input(cableGtSingle, Galaxium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 128))
                .fluidInputs(Lubricant.getFluid(11000))
                .fluidInputs(CosmicFabric.getFluid(L * 16))
                .fluidInputs(Arcanium.getFluid(L * 8))
                .output(ELECTRIC_PISTON_OpV)
                .duration(3600)
                .EUt(100000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PISTON_UXV.getStackForm())
                        .CWUt(1024)
                        .EUt(VA[UXV]))
                .buildAndRegister();
    }

    private static void RobotArm() {

        //  ULV
        ModHandler.addShapedRecipe(true, "robot_arm.ulv", ROBOT_ARM_ULV.getStackForm(),
                "CCC", "MRM", "PXR",
                'C', new UnificationEntry(pipeTinyFluid, Bronze),
                'M', ELECTRIC_MOTOR_ULV.getStackForm(),
                'R', new UnificationEntry(stick, WroughtIron),
                'P', ELECTRIC_PISTON_ULV.getStackForm(),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV));

        //  UHV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Adamantium, 4)
                .input(gear, Adamantium)
                .input(gearSmall, Adamantium, 3)
                .input(ELECTRIC_MOTOR_UHV, 2)
                .input(ELECTRIC_PISTON_UHV)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(circuit, MarkerMaterials.Tier.UV, 2)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ROBOT_ARM_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(ROBOT_ARM_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Hdcs, 4)
                .input(gear, Hdcs)
                .input(gearSmall, Hdcs, 3)
                .input(ELECTRIC_MOTOR_UEV, 2)
                .input(ELECTRIC_PISTON_UEV)
                .input(circuit, MarkerMaterials.Tier.UEV)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(cableGtSingle, PedotTMA, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .fluidInputs(Lubricant.getFluid(5000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(Ichorium.getFluid(L))
                .output(ROBOT_ARM_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(ROBOT_ARM_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  UIV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Legendarium, 4)
                .input(gear, Legendarium)
                .input(gearSmall, Legendarium, 3)
                .input(ELECTRIC_MOTOR_UIV, 2)
                .input(ELECTRIC_PISTON_UIV)
                .input(circuit, MarkerMaterials.Tier.UIV)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(cableGtSingle, Solarium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 24))
                .fluidInputs(Lubricant.getFluid(7000))
                .fluidInputs(Zylon.getFluid(L * 4))
                .fluidInputs(Astralium.getFluid(L * 2))
                .output(ROBOT_ARM_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(ROBOT_ARM_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  UXV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 4)
                .input(gear, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(gearSmall, MagnetoHydrodynamicallyConstrainedStarMatter, 3)
                .input(ELECTRIC_MOTOR_UXV, 2)
                .input(ELECTRIC_PISTON_UXV)
                .input(circuit, MarkerMaterials.Tier.UXV)
                .input(circuit, MarkerMaterials.Tier.UIV, 2)
                .input(circuit, MarkerMaterials.Tier.UEV, 4)
                .input(cableGtSingle, Hypogen, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 28))
                .fluidInputs(Lubricant.getFluid(9000))
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 8))
                .fluidInputs(Hikarium.getFluid(L * 4))
                .output(ROBOT_ARM_UXV)
                .duration(3000)
                .EUt(30000000)
                .stationResearch(b -> b
                        .researchStack(ROBOT_ARM_UIV.getStackForm())
                        .CWUt(512)
                        .EUt(VA[UIV]))
                .buildAndRegister();

        //  OpV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, TranscendentMetal, 4)
                .input(gear, TranscendentMetal)
                .input(gearSmall, TranscendentMetal, 3)
                .input(ELECTRIC_MOTOR_OpV, 2)
                .input(ELECTRIC_PISTON_OpV)
                .input(circuit, MarkerMaterials.Tier.OpV)
                .input(circuit, MarkerMaterials.Tier.UXV, 2)
                .input(circuit, MarkerMaterials.Tier.UIV, 4)
                .input(cableGtSingle, Galaxium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Lubricant.getFluid(11000))
                .fluidInputs(CosmicFabric.getFluid(L * 16))
                .fluidInputs(Arcanium.getFluid(L * 8))
                .output(ROBOT_ARM_OpV)
                .duration(3600)
                .EUt(100000000)
                .stationResearch(b -> b
                        .researchStack(ROBOT_ARM_UXV.getStackForm())
                        .CWUt(1024)
                        .EUt(VA[UXV]))
                .buildAndRegister();
    }

    private static void ElectricPump() {

        ModHandler.addShapedRecipe(true, "electric_pump.ulv", ELECTRIC_PUMP_ULV.getStackForm(),
                "SXR", "dPw", "RMC",
                'S', new UnificationEntry(screw, WroughtIron),
                'X', new UnificationEntry(rotor, WroughtIron),
                'P', new UnificationEntry(pipeNormalFluid, Copper),
                'R', "wool",
                'C', new UnificationEntry(pipeTinyFluid, Bronze),
                'M', ELECTRIC_MOTOR_ULV.getStackForm());

        //  UHV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV)
                .input(pipeLargeFluid, Duranium)
                .input(plate, Adamantium, 2)
                .input(screw, Adamantium, 8)
                .input(ring, NitrileButadieneRubber, 32)
                .input(rotor, Orichalcum)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ELECTRIC_PUMP_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PUMP_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV)
                .input(pipeLargeFluid, Lafium)
                .input(plate, Hdcs, 2)
                .input(screw, Hdcs, 8)
                .input(ring, NitrileButadieneRubber, 64)
                .input(rotor, Adamantium)
                .input(cableGtSingle, PedotTMA, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Lubricant.getFluid(5000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(Ichorium.getFluid(L))
                .output(ELECTRIC_PUMP_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PUMP_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  UIV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UIV)
                .input(pipeLargeFluid, CrystalMatrix)
                .input(plate, Legendarium, 2)
                .input(screw, Legendarium, 8)
                .input(ring, NitrileButadieneRubber, 64)
                .input(rotor, Infinity)
                .input(cableGtSingle, Solarium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Lubricant.getFluid(7000))
                .fluidInputs(Zylon.getFluid(L * 4))
                .fluidInputs(Astralium.getFluid(L * 2))
                .output(ELECTRIC_PUMP_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PUMP_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  UXV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UXV)
                .input(pipeLargeFluid, QuantumchromodynamicallyConfinedMatter)
                .input(plate, MagnetoHydrodynamicallyConstrainedStarMatter, 2)
                .input(screw, MagnetoHydrodynamicallyConstrainedStarMatter, 8)
                .input(ring, NitrileButadieneRubber, 64)
                .input(rotor, CosmicNeutronium)
                .input(cableGtSingle, Hypogen, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(Lubricant.getFluid(9000))
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 8))
                .fluidInputs(Hikarium.getFluid(L * 4))
                .output(ELECTRIC_PUMP_UXV)
                .duration(3000)
                .EUt(30000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PUMP_UIV.getStackForm())
                        .CWUt(512)
                        .EUt(VA[UIV]))
                .buildAndRegister();

        //  OpV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_OpV)
                .input(pipeLargeFluid, Fatalium)
                .input(plate, TranscendentMetal, 2)
                .input(screw, TranscendentMetal, 8)
                .input(ring, NitrileButadieneRubber, 64)
                .input(rotor, Spacetime)
                .input(cableGtSingle, Galaxium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 128))
                .fluidInputs(Lubricant.getFluid(11000))
                .fluidInputs(CosmicFabric.getFluid(L * 16))
                .fluidInputs(Arcanium.getFluid(L * 8))
                .output(ELECTRIC_PUMP_OpV)
                .duration(3600)
                .EUt(100000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PUMP_UXV.getStackForm())
                        .CWUt(1024)
                        .EUt(VA[UXV]))
                .buildAndRegister();
    }

    private static void Emitter() {

        //  ULV
        ModHandler.addShapedRecipe(true, "emitter.ulv", EMITTER_ULV.getStackForm(),
                "CRX", "RGR", "XRC",
                'R', new UnificationEntry(stick, TinAlloy),
                'C', new UnificationEntry(pipeTinyFluid, Bronze),
                'G', new UnificationEntry(gem, Sapphire),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV));

        //  UHV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(ELECTRIC_MOTOR_UHV)
                .input(stickLong, Adamantium, 4)
                .input(GRAVI_STAR, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(foil, Vibranium, 64)
                .input(foil, Vibranium, 32)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Vibranium.getFluid(L))
                .output(EMITTER_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(EMITTER_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs)
                .input(ELECTRIC_MOTOR_UEV)
                .input(stickLong, Hdcs, 4)
                .input(GRAVI_STAR, 4)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(foil, Ichorium, 64)
                .input(foil, Ichorium, 32)
                .input(cableGtSingle, PedotTMA, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(Ichorium.getFluid(L))
                .output(EMITTER_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(EMITTER_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  UIV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Legendarium)
                .input(ELECTRIC_MOTOR_UIV)
                .input(stickLong, Legendarium, 4)
                .input(UNSTABLE_STAR)
                .input(circuit, MarkerMaterials.Tier.UIV, 2)
                .input(foil, Astralium, 64)
                .input(foil, Astralium, 64)
                .input(cableGtSingle, Solarium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(Zylon.getFluid(L * 4))
                .fluidInputs(Astralium.getFluid(L * 2))
                .output(EMITTER_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(EMITTER_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  UXV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(ELECTRIC_MOTOR_UXV)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 4)
                .input(UNSTABLE_STAR, 2)
                .input(circuit, MarkerMaterials.Tier.UXV, 2)
                .input(foil, Hikarium, 64)
                .input(foil, Hikarium, 64)
                .input(cableGtSingle, Hypogen, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 128))
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 8))
                .fluidInputs(Hikarium.getFluid(L * 4))
                .output(EMITTER_UXV)
                .duration(3000)
                .EUt(30000000)
                .stationResearch(b -> b
                        .researchStack(EMITTER_UIV.getStackForm())
                        .CWUt(512)
                        .EUt(VA[UIV]))
                .buildAndRegister();

        //  OpV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, TranscendentMetal)
                .input(ELECTRIC_MOTOR_OpV)
                .input(stickLong, TranscendentMetal, 4)
                .input(UNSTABLE_STAR, 4)
                .input(circuit, MarkerMaterials.Tier.OpV, 2)
                .input(foil, Arcanium, 64)
                .input(foil, Arcanium, 64)
                .input(cableGtSingle, Galaxium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 256))
                .fluidInputs(CosmicFabric.getFluid(L * 16))
                .fluidInputs(Arcanium.getFluid(L * 8))
                .output(EMITTER_OpV)
                .duration(3600)
                .EUt(100000000)
                .stationResearch(b -> b
                        .researchStack(EMITTER_UXV.getStackForm())
                        .CWUt(1024)
                        .EUt(VA[UXV]))
                .buildAndRegister();
    }

    private static void Sensor() {

        //  ULV
        ModHandler.addShapedRecipe(true, "sensor.ulv", SENSOR_ULV.getStackForm(),
                "P G", "PR ", "XPP",
                'P', new UnificationEntry(plate, WroughtIron),
                'R', new UnificationEntry(stick, TinAlloy),
                'G', new UnificationEntry(gem, Sapphire),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV));

        //  UHV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(ELECTRIC_MOTOR_UHV)
                .input(plate, Adamantium, 4)
                .input(GRAVI_STAR, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(foil, Orichalcum, 64)
                .input(foil, Orichalcum, 32)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Vibranium.getFluid(L))
                .output(SENSOR_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(SENSOR_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs)
                .input(ELECTRIC_MOTOR_UEV)
                .input(plate, Hdcs, 4)
                .input(GRAVI_STAR, 4)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(foil, Seaborgium, 64)
                .input(foil, Seaborgium, 32)
                .input(cableGtSingle, PedotTMA, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(Ichorium.getFluid(L))
                .output(SENSOR_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(SENSOR_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  UIV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Legendarium)
                .input(ELECTRIC_MOTOR_UIV)
                .input(plate, Legendarium, 4)
                .input(UNSTABLE_STAR)
                .input(circuit, MarkerMaterials.Tier.UIV, 2)
                .input(foil, CelestialTungsten, 64)
                .input(foil, CelestialTungsten, 32)
                .input(cableGtSingle, Solarium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(Zylon.getFluid(L * 4))
                .fluidInputs(Astralium.getFluid(L * 2))
                .output(SENSOR_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(SENSOR_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  UXV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(plate, MagnetoHydrodynamicallyConstrainedStarMatter, 4)
                .input(UNSTABLE_STAR, 2)
                .input(circuit, MarkerMaterials.Tier.UXV, 2)
                .input(foil, WhiteDwarfMatter, 64)
                .input(foil, WhiteDwarfMatter, 32)
                .input(cableGtSingle, Hypogen, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 128))
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 8))
                .fluidInputs(Hikarium.getFluid(L * 4))
                .output(SENSOR_UXV)
                .duration(3000)
                .EUt(30000000)
                .stationResearch(b -> b
                        .researchStack(SENSOR_UIV.getStackForm())
                        .CWUt(512)
                        .EUt(VA[UIV]))
                .buildAndRegister();

        //  OpV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, TranscendentMetal)
                .input(plate, TranscendentMetal, 4)
                .input(UNSTABLE_STAR, 4)
                .input(circuit, MarkerMaterials.Tier.OpV, 2)
                .input(foil, Edenium, 64)
                .input(foil, Edenium, 32)
                .input(cableGtSingle, Galaxium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 256))
                .fluidInputs(CosmicFabric.getFluid(L * 16))
                .fluidInputs(Arcanium.getFluid(L * 8))
                .output(SENSOR_OpV)
                .duration(3600)
                .EUt(100000000)
                .stationResearch(b -> b
                        .researchStack(SENSOR_UXV.getStackForm())
                        .CWUt(1024)
                        .EUt(VA[UXV]))
                .buildAndRegister();
    }

    private static void FieldGenerator() {

        //  ULV
        ModHandler.addShapedRecipe(true, "field_generator.ulv", FIELD_GENERATOR_ULV.getStackForm(),
                "WPW", "XGX", "WPW",
                'W', new UnificationEntry(pipeLargeFluid, Lead),
                'P', new UnificationEntry(plate, WroughtIron),
                'G', new UnificationEntry(gem, Ruby),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV));

        //  UHV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(plate, Adamantium, 6)
                .input(GRAVI_STAR, 2)
                .input(EMITTER_UHV, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(wireFine, PedotPSS, 64)
                .input(wireFine, PedotPSS, 64)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Vibranium.getFluid(L))
                .output(FIELD_GENERATOR_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(FIELD_GENERATOR_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs)
                .input(plate, Hdcs, 6)
                .input(GRAVI_STAR, 4)
                .input(EMITTER_UEV, 2)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(wireFine, QuantumAlloy, 64)
                .input(wireFine, QuantumAlloy, 64)
                .input(cableGtSingle, PedotTMA, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(Ichorium.getFluid(L))
                .output(FIELD_GENERATOR_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(FIELD_GENERATOR_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  UIV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Legendarium)
                .input(plate, Legendarium, 6)
                .input(UNSTABLE_STAR)
                .input(EMITTER_UIV, 2)
                .input(circuit, MarkerMaterials.Tier.UIV, 2)
                .input(wireFine, FullereneSuperconductor, 64)
                .input(wireFine, FullereneSuperconductor, 64)
                .input(cableGtSingle, Solarium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 24))
                .fluidInputs(Zylon.getFluid(L * 4))
                .fluidInputs(Astralium.getFluid(L * 2))
                .output(FIELD_GENERATOR_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(FIELD_GENERATOR_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  UXV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(plate, MagnetoHydrodynamicallyConstrainedStarMatter, 6)
                .input(UNSTABLE_STAR, 2)
                .input(EMITTER_UXV, 2)
                .input(circuit, MarkerMaterials.Tier.UXV, 2)
                .input(wireFine, BoronFranciumCarbideSuperconductor, 64)
                .input(wireFine, BoronFranciumCarbideSuperconductor, 64)
                .input(cableGtSingle, Hypogen, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 28))
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 8))
                .fluidInputs(Hikarium.getFluid(L * 4))
                .output(FIELD_GENERATOR_UXV)
                .duration(3000)
                .EUt(30000000)
                .stationResearch(b -> b
                        .researchStack(FIELD_GENERATOR_UIV.getStackForm())
                        .CWUt(512)
                        .EUt(VA[UIV]))
                .buildAndRegister();

        //  OpV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, TranscendentMetal)
                .input(plate, TranscendentMetal, 6)
                .input(UNSTABLE_STAR, 4)
                .input(EMITTER_OpV, 2)
                .input(circuit, MarkerMaterials.Tier.OpV, 2)
                .input(wireFine, NeutroniumSuperconductor, 64)
                .input(wireFine, NeutroniumSuperconductor, 64)
                .input(cableGtSingle, Galaxium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(CosmicFabric.getFluid(L * 16))
                .fluidInputs(Arcanium.getFluid(L * 8))
                .output(FIELD_GENERATOR_OpV)
                .duration(3600)
                .EUt(100000000)
                .stationResearch(b -> b
                        .researchStack(FIELD_GENERATOR_UXV.getStackForm())
                        .CWUt(1024)
                        .EUt(VA[UXV]))
                .buildAndRegister();
    }
}