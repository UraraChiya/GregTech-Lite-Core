package magicbook.gtlitecore.loaders;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockSteamCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.MarkerMaterials.Color.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class OverrideRecipeLoader {

    public static void init() {
        SiliconWaferOverrides();
        RubberOverrides();
        SteamStageOverrides();
    }

    private static void SiliconWaferOverrides() {
        //  Neutronium Boule
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES,
                new ItemStack[]{OreDictUnifier.get(block, Silicon, 32),
                        OreDictUnifier.get(ingot, Neutronium, 4),
                        OreDictUnifier.get(dust, GalliumArsenide, 2)},
                new FluidStack[]{Xenon.getFluid(8000)});

        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{Water.getFluid(1000)});

        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{DistilledWater.getFluid(750)});

        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{Lubricant.getFluid(250)});

        BLAST_RECIPES.recipeBuilder()
                .input(block, Silicon, 32)
                .input(ingot, Dubnium, 4)
                .input(dust, GalliumArsenide, 2)
                .fluidInputs(Xenon.getFluid(8000))
                .output(DUBNIUM_BOULE)
                .blastFurnaceTemp(6484)
                .EUt(VA[IV])
                .duration(18000)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(block, Silicon, 64)
                .input(ingot, Neutronium, 8)
                .input(dust, GalliumArsenide, 4)
                .fluidInputs(Radon.getFluid(8000))
                .output(NEUTRONIUM_BOULE)
                .blastFurnaceTemp(8864)
                .EUt(VA[LuV])
                .duration(21000)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(DUBNIUM_BOULE)
                .fluidInputs(Water.getFluid(1000))
                .output(DUBNIUM_WAFER, 64)
                .output(DUBNIUM_WAFER, 32)
                .EUt(VA[IV])
                .duration(4800)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(DUBNIUM_BOULE)
                .fluidInputs(DistilledWater.getFluid(750))
                .output(DUBNIUM_WAFER, 64)
                .output(DUBNIUM_WAFER, 32)
                .EUt(VA[IV])
                .duration(3600)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(DUBNIUM_BOULE)
                .fluidInputs(Lubricant.getFluid(250))
                .output(DUBNIUM_WAFER, 64)
                .output(DUBNIUM_WAFER, 32)
                .EUt(VA[IV])
                .duration(2400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_BOULE)
                .fluidInputs(Water.getFluid(1000))
                .output(NEUTRONIUM_WAFER, 64)
                .output(NEUTRONIUM_WAFER, 64)
                .EUt(VA[LuV])
                .duration(6400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_BOULE)
                .fluidInputs(DistilledWater.getFluid(750))
                .output(NEUTRONIUM_WAFER, 64)
                .output(NEUTRONIUM_WAFER, 64)
                .EUt(VA[LuV])
                .duration(4800)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_BOULE)
                .fluidInputs(Lubricant.getFluid(250))
                .output(NEUTRONIUM_WAFER, 64)
                .output(NEUTRONIUM_WAFER, 64)
                .EUt(VA[LuV])
                .duration(3200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Red: Integrated Logic Circuit Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Red));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Red)
                .output(INTEGRATED_LOGIC_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Red)
                .output(INTEGRATED_LOGIC_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Green: RAM Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Green));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Green)
                .output(RANDOM_ACCESS_MEMORY_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Green)
                .output(RANDOM_ACCESS_MEMORY_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Light Blue: CPU Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, LightBlue));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, LightBlue)
                .output(CENTRAL_PROCESSING_UNIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, LightBlue)
                .output(CENTRAL_PROCESSING_UNIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Blue: ULPIC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Blue));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Blue)
                .output(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Blue)
                .output(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Orange: LPIC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Orange));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Orange)
                .output(LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Orange)
                .output(LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cyan: Simple SoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Cyan));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Cyan)
                .output(SIMPLE_SYSTEM_ON_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Cyan)
                .output(SIMPLE_SYSTEM_ON_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Gray: NAND Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Gray));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Gray)
                .output(NAND_MEMORY_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Gray)
                .output(NAND_MEMORY_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Pink: NOR Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Pink));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Pink)
                .output(NOR_MEMORY_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Pink)
                .output(NOR_MEMORY_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Brown: PIC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Brown));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Brown)
                .output(POWER_INTEGRATED_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Brown)
                .output(POWER_INTEGRATED_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Yellow: SoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Yellow));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Yellow)
                .output(SYSTEM_ON_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Yellow)
                .output(SYSTEM_ON_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Purple: ASoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Purple));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Purple)
                .output(ADVANCED_SYSTEM_ON_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Purple)
                .output(ADVANCED_SYSTEM_ON_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Black: HASoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Black));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Black)
                .output(HIGHLY_ADVANCED_SOC_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Black)
                .output(HIGHLY_ADVANCED_SOC_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void RubberOverrides() {
        //  Conveyor Module Recipes
        ModHandler.addShapedRecipe(true, "conveyor_module_lv_nitrile_butadiene_rubber", CONVEYOR_MODULE_LV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_LV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tin));

        ModHandler.addShapedRecipe(true, "conveyor_module_lv_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_LV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_LV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tin));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Tin)
                    .input(ELECTRIC_MOTOR_LV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_LV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        ModHandler.addShapedRecipe(true, "conveyor_module_mv_nitrile_butadiene_rubber", CONVEYOR_MODULE_MV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_MV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Copper));

        ModHandler.addShapedRecipe(true, "conveyor_module_mv_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_MV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_MV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Copper));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Copper)
                    .input(ELECTRIC_MOTOR_MV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_MV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        ModHandler.addShapedRecipe(true, "conveyor_module_hv_nitrile_butadiene_rubber", CONVEYOR_MODULE_HV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_HV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Gold));

        ModHandler.addShapedRecipe(true, "conveyor_module_hv_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_HV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_HV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Gold));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Gold)
                    .input(ELECTRIC_MOTOR_HV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_HV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        ModHandler.addShapedRecipe(true, "conveyor_module_ev_nitrile_butadiene_rubber", CONVEYOR_MODULE_EV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_EV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Aluminium));

        ModHandler.addShapedRecipe(true, "conveyor_module_ev_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_EV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_EV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Aluminium));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Aluminium)
                    .input(ELECTRIC_MOTOR_EV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_EV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        ModHandler.addShapedRecipe(true, "conveyor_module_iv_nitrile_butadiene_rubber", CONVEYOR_MODULE_IV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_IV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tungsten));

        ModHandler.addShapedRecipe(true, "conveyor_module_iv_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_IV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_IV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tungsten));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Tungsten)
                    .input(ELECTRIC_MOTOR_IV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_IV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        //  TODO LuV-UV

        //  Electric Pump Recipes
        ModHandler.addShapedRecipe(true, "electric_pump_lv_nitrile_butadiene_rubber", ELECTRIC_PUMP_LV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Tin),
                'R', new UnificationEntry(rotor, Tin),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, Bronze),
                'M', ELECTRIC_MOTOR_LV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tin));

        ModHandler.addShapedRecipe(true, "electric_pump_lv_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_LV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Tin),
                'R', new UnificationEntry(rotor, Tin),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, Bronze),
                'M', ELECTRIC_MOTOR_LV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tin));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tin)
                .input(pipeNormalFluid, Bronze)
                .input(screw, Tin)
                .input(rotor, Tin)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_LV)
                .output(ELECTRIC_PUMP_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tin)
                .input(pipeNormalFluid, Bronze)
                .input(screw, Tin)
                .input(rotor, Tin)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_LV)
                .output(ELECTRIC_PUMP_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "electric_pump_mv_nitrile_butadiene_rubber", ELECTRIC_PUMP_MV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Bronze),
                'R', new UnificationEntry(rotor, Bronze),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, Steel),
                'M', ELECTRIC_MOTOR_MV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Copper));

        ModHandler.addShapedRecipe(true, "electric_pump_mv_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_MV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Bronze),
                'R', new UnificationEntry(rotor, Bronze),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, Steel),
                'M', ELECTRIC_MOTOR_MV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Copper));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Copper)
                .input(pipeNormalFluid, Steel)
                .input(screw, Bronze)
                .input(rotor, Bronze)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_MV)
                .output(ELECTRIC_PUMP_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Copper)
                .input(pipeNormalFluid, Steel)
                .input(screw, Bronze)
                .input(rotor, Bronze)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_MV)
                .output(ELECTRIC_PUMP_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "electric_pump_hv_nitrile_butadiene_rubber", ELECTRIC_PUMP_HV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Steel),
                'R', new UnificationEntry(rotor, Steel),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, StainlessSteel),
                'M', ELECTRIC_MOTOR_HV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Gold));

        ModHandler.addShapedRecipe(true, "electric_pump_hv_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_HV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Steel),
                'R', new UnificationEntry(rotor, Steel),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, StainlessSteel),
                'M', ELECTRIC_MOTOR_HV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Gold));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Gold)
                .input(pipeNormalFluid, StainlessSteel)
                .input(screw, Steel)
                .input(rotor, Steel)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_HV)
                .output(ELECTRIC_PUMP_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Gold)
                .input(pipeNormalFluid, StainlessSteel)
                .input(screw, Steel)
                .input(rotor, Steel)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_HV)
                .output(ELECTRIC_PUMP_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "electric_pump_ev_nitrile_butadiene_rubber", ELECTRIC_PUMP_EV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, StainlessSteel),
                'R', new UnificationEntry(rotor, StainlessSteel),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, Titanium),
                'M', ELECTRIC_MOTOR_EV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Aluminium));

        ModHandler.addShapedRecipe(true, "electric_pump_ev_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_EV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, StainlessSteel),
                'R', new UnificationEntry(rotor, StainlessSteel),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, Titanium),
                'M', ELECTRIC_MOTOR_EV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Aluminium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Aluminium)
                .input(pipeNormalFluid, Titanium)
                .input(screw, StainlessSteel)
                .input(rotor, StainlessSteel)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_EV)
                .output(ELECTRIC_PUMP_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Aluminium)
                .input(pipeNormalFluid, Titanium)
                .input(screw, StainlessSteel)
                .input(rotor, StainlessSteel)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_EV)
                .output(ELECTRIC_PUMP_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "electric_pump_iv_nitrile_butadiene_rubber", ELECTRIC_PUMP_IV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, TungstenSteel),
                'R', new UnificationEntry(rotor, TungstenSteel),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, TungstenSteel),
                'M', ELECTRIC_MOTOR_IV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tungsten));

        ModHandler.addShapedRecipe(true, "electric_pump_iv_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_IV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, TungstenSteel),
                'R', new UnificationEntry(rotor, TungstenSteel),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, TungstenSteel),
                'M', ELECTRIC_MOTOR_IV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tungsten));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tungsten)
                .input(pipeNormalFluid, TungstenSteel)
                .input(screw, TungstenSteel)
                .input(rotor, TungstenSteel)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_IV)
                .output(ELECTRIC_PUMP_IV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tungsten)
                .input(pipeNormalFluid, TungstenSteel)
                .input(screw, TungstenSteel)
                .input(rotor, TungstenSteel)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_IV)
                .output(ELECTRIC_PUMP_IV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  TODO LuV-UV
    }

    private static void SteamStageOverrides() {

        if (GTLiteConfigHolder.steamOverrides.enableHarderSteamMachineRecipe) {

            ModHandler.removeRecipeByName("gregtech:steam_boiler_coal_bronze");
            ModHandler.addShapedRecipe(true, "steam_boiler_coal_bronze", MetaTileEntities.STEAM_BOILER_COAL_BRONZE.getStackForm(),
                    "PPP", "CHC", "BFB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_BRICKS_HULL),
                    'C', CONVEYOR_MODULE_ULV,
                    'P', new UnificationEntry(plate, Bronze),
                    'B', new UnificationEntry(block, Brick),
                    'F', "craftingFurnace");

            ModHandler.removeRecipeByName("gregtech:steam_boiler_coal_steel");
            ModHandler.addShapedRecipe(true, "steam_boiler_coal_steel", MetaTileEntities.STEAM_BOILER_COAL_STEEL.getStackForm(),
                    "PPP", "RHC", "BFB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_BRICKS_HULL),
                    'C', CONVEYOR_MODULE_ULV,
                    'R', ROBOT_ARM_ULV,
                    'P', new UnificationEntry(plate, Steel),
                    'B', new UnificationEntry(block, Brick),
                    'F', "craftingFurnace");

            ModHandler.removeRecipeByName("gregtech:steam_boiler_solar_bronze");
            ModHandler.addShapedRecipe(true, "steam_boiler_solar_bronze", MetaTileEntities.STEAM_BOILER_SOLAR_BRONZE.getStackForm(),
                    "PPP", "CHU", "BAB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_BRICKS_HULL),
                    'C', CONVEYOR_MODULE_ULV,
                    'U', ELECTRIC_PUMP_ULV,
                    'P', new UnificationEntry(plate, Bronze),
                    'B', new UnificationEntry(block, Brick),
                    'A', new UnificationEntry(pipeSmallFluid, Bronze));

            ModHandler.removeRecipeByName("gregtech:steam_boiler_solar_steel");
            ModHandler.addShapedRecipe(true, "steam_boiler_solar_steel", MetaTileEntities.STEAM_BOILER_SOLAR_STEEL.getStackForm(),
                    "PGP", "CHU", "BRB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_BRICKS_HULL),
                    'C', CONVEYOR_MODULE_ULV,
                    'U', ELECTRIC_PUMP_ULV,
                    'R', ROBOT_ARM_ULV,
                    'B', new UnificationEntry(pipeSmallFluid, TinAlloy),
                    'P', new UnificationEntry(plate, Steel),
                    'G', new UnificationEntry(plate, Glass));

            ModHandler.removeRecipeByName("gregtech:steam_boiler_lava_bronze");
            ModHandler.addShapedRecipe(true, "steam_boiler_lava_bronze", MetaTileEntities.STEAM_BOILER_LAVA_BRONZE.getStackForm(),
                    "PPP", "UHU", "BAB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_BRICKS_HULL),
                    'U', ELECTRIC_PUMP_ULV,
                    'P', new UnificationEntry(plate, Bronze),
                    'B', new UnificationEntry(block, Brick),
                    'A', new UnificationEntry(pipeSmallFluid, Bronze));

            ModHandler.removeRecipeByName("gregtech:steam_boiler_lava_steel");
            ModHandler.addShapedRecipe(true, "steam_boiler_lava_steel", MetaTileEntities.STEAM_BOILER_LAVA_STEEL.getStackForm(),
                    "PPP", "UHR", "BAB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_BRICKS_HULL),
                    'U', ELECTRIC_PUMP_ULV,
                    'R', ROBOT_ARM_ULV,
                    'P', new UnificationEntry(plate, Steel),
                    'B', new UnificationEntry(block, Brick),
                    'A', new UnificationEntry(pipeSmallFluid, TinAlloy));
        }
    }
}
