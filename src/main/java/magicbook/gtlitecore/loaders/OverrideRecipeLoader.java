package magicbook.gtlitecore.loaders;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.*;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;
import gregtechfoodoption.block.GTFOGlassCasing;
import gregtechfoodoption.block.GTFOMetaBlocks;
import gregtechfoodoption.recipe.GTFOMachineRecipes;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import magicbook.gtlitecore.common.blocks.BlockHermeticCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.MarkerMaterials.Color.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.blocks.BlockHermeticCasing.HermeticCasingsType.HERMETIC_UHV;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static gregtechfoodoption.machines.GTFOTileEntities.SLICER;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.BIO_REACTOR_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.*;

public class OverrideRecipeLoader {

    public static void init() {
        MachineCasingOverrides();
        SiliconWaferOverrides();
        RubberOverrides();
        SteamStageOverrides();
        HighTierOverrides();
        GCYMOverrides();
        GTFOOverrides();
    }

    /**
     * Override of Machine Casings.
     *
     * <p>
     *     This class is an override about machine casings like tiered hull,
     *     also override quantum chest/tank recipes, because in GregTech vanilla environment,
     *     UHV main material ({@link CraftingComponent#HULL}) is {@link Materials#Neutronium},
     *     but in gtlitecore, UHV main material is {@link magicbook.gtlitecore.api.unification.GTLiteMaterials#Orichalcum}.
     * </p>
     */
    private static void MachineCasingOverrides() {
        //  UHV Machine Casing
        ModHandler.removeRecipeByName("gregtech:casing_uhv");
        ModHandler.addShapedRecipe(true, "casing_uhv", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, Orichalcum));

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, IntCircuitIngredient.getIntegratedCircuit(8), OreDictUnifier.get(plate, Neutronium, 8));
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Orichalcum, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  UHV Machine Hull assembler recipe
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{OreDictUnifier.get(cableGtSingle, Europium, 2), MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV)},
                new FluidStack[]{Polybenzimidazole.getFluid(288)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV))
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .output(MetaTileEntities.HULL[9])
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        //  UHV Hermetic Casing
        ModHandler.removeRecipeByName("gregtech:hermetic_casing_max");
        ModHandler.addShapedRecipe(true, "hermetic_casing_uhv", MetaBlocks.HERMETIC_CASING.getItemVariant(HERMETIC_UHV),
                "PPP", "PFP", "PPP",
                'P', new UnificationEntry(plate, Orichalcum),
                'F', new UnificationEntry(pipeLargeFluid, Duranium));

        //  UHV Quantum Chest
        ModHandler.removeRecipeByName("gregtech:quantum_chest_uhv");
        ModHandler.addShapedRecipe(true, "quantum_chest_uhv", MetaTileEntities.QUANTUM_CHEST[9].getStackForm(),
                "CPC", "PHP", "CFC",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'P', new UnificationEntry(plate, Orichalcum),
                'F', MetaItems.FIELD_GENERATOR_UV.getStackForm(),
                'H', MetaTileEntities.HULL[UHV].getStackForm());

        //  UHV Quantum Tank
        ModHandler.removeRecipeByName("gregtech:quantum_tank_uhv");
        ModHandler.addShapedRecipe(true, "quantum_tank_uhv", MetaTileEntities.QUANTUM_TANK[9].getStackForm(),
                "CGC", "PHP", "CUC",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'P', new UnificationEntry(plate, Orichalcum),
                'U', MetaItems.ELECTRIC_PUMP_UV.getStackForm(),
                'G', MetaItems.FIELD_GENERATOR_UV.getStackForm(),
                'H', MetaBlocks.HERMETIC_CASING.getItemVariant(HERMETIC_UHV));

        //  UEV Casing
        ModHandler.addShapedRecipe(true, "casing_uev", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UEV),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, Adamantium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Adamantium, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UEV))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        //  UEV Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UEV))
                .input(cableGtSingle, PedotTMA, 2)
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .output(MetaTileEntities.HULL[UEV])
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        //  UIV Casing
        ModHandler.addShapedRecipe(true, "casing_uiv", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UIV),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, Infinity));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Infinity, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UIV))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        //  UIV Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UIV))
                .input(cableGtSingle, Solarium, 2)
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .output(MetaTileEntities.HULL[UIV])
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        //  UXV Casing
        ModHandler.addShapedRecipe(true, "casing_uxv", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UXV),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, CosmicNeutronium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, CosmicNeutronium, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UXV))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        //  UXV Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UXV))
                .input(cableGtSingle, Hypogen, 2)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(MetaTileEntities.HULL[UXV])
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        //  OpV Casing
        ModHandler.addShapedRecipe(true, "casing_opv", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.OpV),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, Spacetime));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Spacetime, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.OpV))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        //  OpV Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.OpV))
                .input(cableGtSingle, Galaxium, 2)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(MetaTileEntities.HULL[OpV])
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        //  MAX Casing
        ModHandler.addShapedRecipe(true, "casing_max", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, Eternity));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Eternity, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        //  MAX Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX))
                .input(cableGtSingle, Universium, 2)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(MetaTileEntities.HULL[MAX])
                .EUt(16)
                .duration(50)
                .buildAndRegister();
    }

    /**
     * Override of Silicon Wafers
     *
     * <p>
     *     This is a necessary tweak about {@link Materials#Neutronium}, because in gtlitecore,
     *     you needs to build Fusion Reactor Mark V to get Neutronium,
     *     so in the same tier, you can not get Neutronium Wafer same as vanilla GregTech environment.
     * </p>
     */
    private static void SiliconWaferOverrides() {

        //  Delete Neutronium Boule recipe
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES,
                new ItemStack[]{OreDictUnifier.get(block, Silicon, 32),
                        OreDictUnifier.get(ingot, Neutronium, 4),
                        OreDictUnifier.get(dust, GalliumArsenide, 2)},
                new FluidStack[]{Xenon.getFluid(8000)});

        //  Delete Neutronium Boule -> Wafer recipes
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{Water.getFluid(1000)});

        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{DistilledWater.getFluid(750)});

        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{Lubricant.getFluid(250)});

        //  Dubnium Boule
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

        //  Neutronium Boule
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

        //  Dubnium Boule -> Dubnium Wafer
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

        //  Neutronium Boule -> Neutronium Wafer
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

        //  Add Laser Engraver recipe to Dubnium Wafer and Neutronium Wafer.

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

    /**
     * Override of Rubbers
     *
     * <p>
     *     In gtlitecore, we add two new rubbers (please see:
     *      {@link magicbook.gtlitecore.api.unification.GTLiteMaterials#NitrileButadieneRubber},
     *      {@link magicbook.gtlitecore.api.unification.GTLiteMaterials#PolyPhosphonitrileFluoroRubber}),
     *     so we should add some recipes about old rubbers in GregTech.
     * </p>
     */
    private static void RubberOverrides() {

        //  Conveyor Module Recipes

        //  LV Conveyor Module
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

        //  MV Conveyor Module
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

        //  HV Conveyor Module
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

        //  EV Conveyor Module
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

        //  IV Conveyor Module
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

        //  todo maybe we can add recipes of LuV-UV conveyor modules, but they are assembly line recipes.

        //  Electric Pump Recipes

        //  LV Electric Pump
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

        //  MV Electric Pump
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

        //  HV Electric Pump
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

        //  EV Electric Pump
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

        //  IV Electric Pump
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

        //  todo maybe we can add recipes of LuV-UV electric pumps, but they are assembly line recipes.
    }

    /**
     * Override of Steam Stage Machines
     *
     * <p>
     *     In modpack environment, player needs craft ULV components to make steam stage machines.
     *     This override has a big todo: some steam machine override recipes is added by modpack scripts (CraftTweaker), we needs to redo it in this class.
     * </p>
     */
    private static void SteamStageOverrides() {
        if (GTLiteConfigHolder.machines.enableHarderSteamStageMachine) {
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

    /**
     * Overrides of some High Tier misc contents
     *
     * <p>
     *     Some overrides of High Tier Hermetic casings, capacitors and End game items.
     * </p>
     */
    private static void HighTierOverrides() {

        //  Hermetic Casings
        ModHandler.addShapedRecipe(true, "hermetic_casing_uev", GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_UEV),
                "ppp", "pPp", "ppp",
                'p', new UnificationEntry(plate, Adamantium),
                'P', new UnificationEntry(pipeLargeFluid, Lafium));

        ModHandler.addShapedRecipe(true, "hermetic_casing_uiv", GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_UIV),
                "ppp", "pPp", "ppp",
                'p', new UnificationEntry(plate, Infinity),
                'P', new UnificationEntry(pipeLargeFluid, CrystalMatrix));

        ModHandler.addShapedRecipe(true, "hermetic_casing_uxv", GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_UXV),
                "ppp", "pPp", "ppp",
                'p', new UnificationEntry(plate, CosmicNeutronium),
                'P', new UnificationEntry(pipeLargeFluid, QuantumchromodynamicallyConfinedMatter));

        ModHandler.addShapedRecipe(true, "hermetic_casing_opv", GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_OpV),
                "ppp", "pPp", "ppp",
                'p', new UnificationEntry(plate, Spacetime),
                'P', new UnificationEntry(pipeLargeFluid, Fatalium));

        //  Empty Capacitor (for Power Substation)
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                OreDictUnifier.get(frameGt, Neutronium),
                OreDictUnifier.get(plate, Neutronium, 6),
                OreDictUnifier.get(screw, Neutronium, 24));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(plate, Orichalcum, 6)
                .input(screw, Orichalcum, 24)
                .outputs(MetaBlocks.BATTERY_BLOCK.getItemVariant(BlockBatteryPart.BatteryPartType.EMPTY_TIER_III))
                .EUt(VA[ZPM])
                .duration(400)
                .buildAndRegister();

        //  End Game things
        //  a.k.a. creative things!
        if (GTLiteConfigHolder.misc.enableCreativeRecipe) {
            ModHandler.addShapedRecipe(true, "quantum_tank_creative", CREATIVE_TANK.getStackForm(),
                    "XFX", "PHP", "XpX",
                    'X', new UnificationEntry(circuit, MarkerMaterials.Tier.MAX),
                    'F', FIELD_GENERATOR_MAX,
                    'P', new UnificationEntry(plate, Eternity),
                    'p', ELECTRIC_PUMP_MAX,
                    'H', GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_MAX));

            ModHandler.addShapedRecipe(true, "quantum_chest_creative", CREATIVE_CHEST.getStackForm(),
                    "XPX", "PHP", "XFX",
                    'H', HULL[MAX].getStackForm(),
                    'P', new UnificationEntry(plate, Eternity),
                    'X', new UnificationEntry(circuit, MarkerMaterials.Tier.MAX),
                    'F', FIELD_GENERATOR_MAX);

            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(ITEM_IMPORT_BUS[UHV])
                    .input(TOOL_DATA_MODULE, 4)
                    .input(circuit, MarkerMaterials.Tier.MAX, 4)
                    .fluidInputs(SolderingAlloy.getFluid(5760))
                    .fluidInputs(Eternity.getFluid(2880))
                    .fluidInputs(Spacetime.getFluid(1440))
                    .fluidInputs(Infinity.getFluid(576))
                    .output(CREATIVE_DATA_HATCH)
                    .stationResearch(b -> b
                            .researchStack(ADVANCED_DATA_ACCESS_HATCH.getStackForm())
                            .CWUt(1024)
                            .EUt(VA[MAX]))
                    .EUt(VA[MAX])
                    .duration(200)
                    .buildAndRegister();

            ModHandler.addShapedRecipe(true, "creative_energy_unit", CREATIVE_ENERGY.getStackForm(),
                    "IXI", "EHS", "IPI",
                    'H', HULL[MAX].getStackForm(),
                    'I', FEMTO_PIC_CHIP,
                    'X', new UnificationEntry(circuit, MarkerMaterials.Tier.MAX),
                    'E', EMITTER_MAX,
                    'S', SENSOR_MAX,
                    'P', new UnificationEntry(plate, Eternity));
        }

        SolarPanels();
        ItemBuses();
        FluidHatches();
        MultiFluidHatches();
        EnergyHathces();
    }

    private static void SolarPanels() {

        //  Basic Solar Panel
        ModHandler.removeRecipeByName("gregtech:solar_panel_basic");
        ModHandler.addShapedRecipe(true, "solar_panel.basic", COVER_SOLAR_PANEL.getStackForm(),
                "SAS", "XPX",
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV),
                'P', CARBON_FIBER_PLATE,
                'S', SILICON_WAFER,
                'A', new UnificationEntry(plate, Glass));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.ULV, 2)
                .input(CARBON_FIBER_PLATE)
                .input(SILICON_WAFER, 2)
                .circuitMeta(18)
                .fluidInputs(Glass.getFluid(L))
                .output(COVER_SOLAR_PANEL, 2)
                .EUt(VA[LV])
                .duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.ULV, 2)
                .input(CARBON_FIBER_PLATE)
                .input(SILICON_WAFER, 2)
                .circuitMeta(18)
                .fluidInputs(BorosilicateGlass.getFluid(L / 2))
                .output(COVER_SOLAR_PANEL, 2)
                .EUt(VA[LV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.ULV, 2)
                .input(CARBON_FIBER_PLATE)
                .input(SILICON_WAFER, 2)
                .circuitMeta(18)
                .fluidInputs(GSTGlass.getFluid(L / 4))
                .output(COVER_SOLAR_PANEL, 2)
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.ULV, 2)
                .input(CARBON_FIBER_PLATE)
                .input(SILICON_WAFER, 2)
                .circuitMeta(18)
                .fluidInputs(ZBLANGlass.getFluid(L / 4))
                .output(COVER_SOLAR_PANEL, 2)
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        //  ULV Solar Panel
        ModHandler.removeRecipeByName("gregtech:solar_panel_ulv");
        ModHandler.addShapedRecipe(true, "solar_panel.ulv", COVER_SOLAR_PANEL_ULV.getStackForm(),
                "AGA", "XCX", "P P",
                'C', COVER_SOLAR_PANEL,
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.LV),
                'P', new UnificationEntry(plate, GalliumArsenide),
                'A', CARBON_FIBER_PLATE,
                'G', new UnificationEntry(plate, Glass));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(COVER_SOLAR_PANEL)
                .input(circuit, MarkerMaterials.Tier.LV, 2)
                .input(CARBON_FIBER_PLATE, 2)
                .input(plate, GalliumArsenide, 2)
                .circuitMeta(18)
                .fluidInputs(Glass.getFluid(L))
                .output(COVER_SOLAR_PANEL_ULV, 2)
                .EUt(VA[MV])
                .duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(COVER_SOLAR_PANEL)
                .input(circuit, MarkerMaterials.Tier.LV, 2)
                .input(CARBON_FIBER_PLATE, 2)
                .input(plate, GalliumArsenide, 2)
                .circuitMeta(18)
                .fluidInputs(BorosilicateGlass.getFluid(L / 2))
                .output(COVER_SOLAR_PANEL_ULV, 2)
                .EUt(VA[MV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(COVER_SOLAR_PANEL)
                .input(circuit, MarkerMaterials.Tier.LV, 2)
                .input(CARBON_FIBER_PLATE, 2)
                .input(plate, GalliumArsenide, 2)
                .circuitMeta(18)
                .fluidInputs(GSTGlass.getFluid(L / 4))
                .output(COVER_SOLAR_PANEL_ULV, 2)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(COVER_SOLAR_PANEL)
                .input(circuit, MarkerMaterials.Tier.LV, 2)
                .input(CARBON_FIBER_PLATE, 2)
                .input(plate, GalliumArsenide, 2)
                .circuitMeta(18)
                .fluidInputs(ZBLANGlass.getFluid(L / 4))
                .output(COVER_SOLAR_PANEL_ULV, 2)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        //  LV Solar Panel
        ModHandler.removeRecipeByName("gregtech:solar_panel_lv");
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, CobaltBrass)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 4)
                .input(CARBON_FIBER_PLATE, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(wireFine, Cupronickel, 4)
                .circuitMeta(18)
                .fluidInputs(Glass.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_LV, 2)
                .EUt(VA[HV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, CobaltBrass)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 4)
                .input(CARBON_FIBER_PLATE, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(wireFine, Cupronickel, 4)
                .circuitMeta(18)
                .fluidInputs(BorosilicateGlass.getFluid(L * 2))
                .output(COVER_SOLAR_PANEL_LV, 2)
                .EUt(VA[HV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, CobaltBrass)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 4)
                .input(CARBON_FIBER_PLATE, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(wireFine, Cupronickel, 4)
                .circuitMeta(18)
                .fluidInputs(GSTGlass.getFluid(L))
                .output(COVER_SOLAR_PANEL_LV, 2)
                .EUt(VA[HV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, CobaltBrass)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 4)
                .input(CARBON_FIBER_PLATE, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(wireFine, Cupronickel, 4)
                .circuitMeta(18)
                .fluidInputs(ZBLANGlass.getFluid(L))
                .output(COVER_SOLAR_PANEL_LV, 2)
                .EUt(VA[HV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  MV Solar Panel
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, VanadiumSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(wireFine, Kanthal, 4)
                .circuitMeta(18)
                .fluidInputs(Glass.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_MV, 2)
                .EUt(VA[EV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, VanadiumSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(wireFine, Kanthal, 4)
                .circuitMeta(18)
                .fluidInputs(BorosilicateGlass.getFluid(L * 2))
                .output(COVER_SOLAR_PANEL_MV, 2)
                .EUt(VA[EV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, VanadiumSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(wireFine, Kanthal, 4)
                .circuitMeta(18)
                .fluidInputs(GSTGlass.getFluid(L))
                .output(COVER_SOLAR_PANEL_MV, 2)
                .EUt(VA[EV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, VanadiumSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(wireFine, Kanthal, 4)
                .circuitMeta(18)
                .fluidInputs(ZBLANGlass.getFluid(L))
                .output(COVER_SOLAR_PANEL_MV, 2)
                .EUt(VA[EV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  HV Solar Panel
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, BlueSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 16)
                .input(CARBON_FIBER_PLATE, 32)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(wireFine, Nichrome, 4)
                .circuitMeta(18)
                .fluidInputs(Glass.getFluid(L * 8))
                .output(COVER_SOLAR_PANEL_HV, 2)
                .EUt(VA[IV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, BlueSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 16)
                .input(CARBON_FIBER_PLATE, 32)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(wireFine, Nichrome, 4)
                .circuitMeta(18)
                .fluidInputs(BorosilicateGlass.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_HV, 2)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, BlueSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 16)
                .input(CARBON_FIBER_PLATE, 32)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(wireFine, Nichrome, 4)
                .circuitMeta(18)
                .fluidInputs(GSTGlass.getFluid(L * 2))
                .output(COVER_SOLAR_PANEL_HV, 2)
                .EUt(VA[IV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, BlueSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 16)
                .input(CARBON_FIBER_PLATE, 32)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(wireFine, Nichrome, 4)
                .circuitMeta(18)
                .fluidInputs(ZBLANGlass.getFluid(L * 2))
                .output(COVER_SOLAR_PANEL_HV, 2)
                .EUt(VA[IV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  EV Solar Panel
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenCarbide)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 32)
                .input(CARBON_FIBER_PLATE, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(wireFine, RTMAlloy, 4)
                .circuitMeta(18)
                .fluidInputs(Glass.getFluid(L * 8))
                .output(COVER_SOLAR_PANEL_EV, 2)
                .EUt(VA[LuV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenCarbide)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 32)
                .input(CARBON_FIBER_PLATE, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(wireFine, RTMAlloy, 4)
                .circuitMeta(18)
                .fluidInputs(BorosilicateGlass.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_EV, 2)
                .EUt(VA[LuV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenCarbide)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 32)
                .input(CARBON_FIBER_PLATE, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(wireFine, RTMAlloy, 4)
                .circuitMeta(18)
                .fluidInputs(GSTGlass.getFluid(L * 2))
                .output(COVER_SOLAR_PANEL_EV, 2)
                .EUt(VA[LuV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenCarbide)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 32)
                .input(CARBON_FIBER_PLATE, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(wireFine, RTMAlloy, 4)
                .circuitMeta(18)
                .fluidInputs(ZBLANGlass.getFluid(L * 2))
                .output(COVER_SOLAR_PANEL_EV, 2)
                .EUt(VA[LuV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  IV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSE)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 4)
                .input(VOLTAGE_COIL_IV, 2)
                .input(foil, NiobiumTitanium, 8)
                .input(wireFine, HSSG, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .fluidInputs(BorosilicateGlass.getFluid(3000))
                .output(COVER_SOLAR_PANEL_IV, 2)
                .scannerResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_EV.getStackForm())
                        .EUt(VA[ZPM])
                        .duration(600))
                .EUt(VA[ZPM])
                .duration(200)
                .buildAndRegister();

        //  LuV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 8)
                .input(VOLTAGE_COIL_LuV, 2)
                .input(foil, VanadiumGallium, 8)
                .input(wireFine, Naquadah, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .fluidInputs(BorosilicateGlass.getFluid(3000))
                .output(COVER_SOLAR_PANEL_LUV, 2)
                .scannerResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_IV.getStackForm())
                        .EUt(VA[UV])
                        .duration(600))
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        //  ZPM Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Duranium)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 16)
                .input(VOLTAGE_COIL_ZPM, 2)
                .input(foil, YttriumBariumCuprate, 8)
                .input(wireFine, Trinium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .fluidInputs(BorosilicateGlass.getFluid(6000))
                .fluidInputs(Polyetheretherketone.getFluid(L))
                .output(COVER_SOLAR_PANEL_ZPM, 2)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_LUV.getStackForm())
                        .EUt(VA[UHV])
                        .CWUt(32))
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        //  UV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 32)
                .input(VOLTAGE_COIL_UV, 2)
                .input(foil, Europium, 8)
                .input(wireFine, Tritanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .fluidInputs(BorosilicateGlass.getFluid(6000))
                .fluidInputs(Polyetheretherketone.getFluid(L))
                .output(COVER_SOLAR_PANEL_UV, 2)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_ZPM.getStackForm())
                        .EUt(VA[UEV])
                        .CWUt(64))
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        //  MAX Solar Panel (todo update this recipe when gtlitecore have UHV-OpV Solar Panels)
    }

    private static void ItemBuses() {

        //  Delete vanilla UHV item bus recipe
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(), QUANTUM_CHEST[1].getStackForm(), IntCircuitIngredient.getIntegratedCircuit(1)},
                new FluidStack[]{Polybenzimidazole.getFluid(720)});

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(), QUANTUM_CHEST[1].getStackForm(), IntCircuitIngredient.getIntegratedCircuit(2)},
                new FluidStack[]{Polybenzimidazole.getFluid(720)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(QUANTUM_CHEST[1])
                .circuitMeta(1)
                .fluidInputs(Polyetheretherketone.getFluid(720))
                .output(ITEM_IMPORT_BUS[UHV])
                .EUt(VA[UHV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(QUANTUM_CHEST[1])
                .circuitMeta(2)
                .fluidInputs(Polyetheretherketone.getFluid(720))
                .output(ITEM_EXPORT_BUS[UHV])
                .EUt(VA[UHV])
                .duration(300)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTierItemHatch) {
            //  UEV item bus
            ModHandler.addShapedRecipe(true, "item_bus_input_to_output_10", IMPORT_ITEM_HATCH[0].getStackForm(),
                    " d ", " H ", "   ",
                    'H', EXPORT_ITEM_HATCH[0].getStackForm());

            ModHandler.addShapedRecipe(true, "item_bus_output_to_input_10", EXPORT_ITEM_HATCH[0].getStackForm(),
                    " d ", " H ", "   ",
                    'H', IMPORT_ITEM_HATCH[0].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(QUANTUM_CHEST[2])
                    .circuitMeta(1)
                    .fluidInputs(Polyetheretherketone.getFluid(864))
                    .output(IMPORT_ITEM_HATCH[0])
                    .EUt(VA[UEV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(QUANTUM_CHEST[2])
                    .circuitMeta(2)
                    .fluidInputs(Polyetheretherketone.getFluid(864))
                    .output(EXPORT_ITEM_HATCH[0])
                    .EUt(VA[UEV])
                    .duration(300)
                    .buildAndRegister();

            //  UIV item bus
            ModHandler.addShapedRecipe(true, "item_bus_input_to_output_11", IMPORT_ITEM_HATCH[1].getStackForm(),
                    " d ", " H ", "   ",
                    'H', EXPORT_ITEM_HATCH[1].getStackForm());

            ModHandler.addShapedRecipe(true, "item_bus_output_to_input_11", EXPORT_ITEM_HATCH[1].getStackForm(),
                    " d ", " H ", "   ",
                    'H', IMPORT_ITEM_HATCH[1].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(QUANTUM_CHEST[3])
                    .circuitMeta(1)
                    .fluidInputs(Kevlar.getFluid(1008))
                    .output(IMPORT_ITEM_HATCH[1])
                    .EUt(VA[UIV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(QUANTUM_CHEST[3])
                    .circuitMeta(2)
                    .fluidInputs(Kevlar.getFluid(1008))
                    .output(EXPORT_ITEM_HATCH[1])
                    .EUt(VA[UIV])
                    .duration(300)
                    .buildAndRegister();

            //  UXV item bus
            ModHandler.addShapedRecipe(true, "item_bus_input_to_output_12", IMPORT_ITEM_HATCH[2].getStackForm(),
                    " d ", " H ", "   ",
                    'H', EXPORT_ITEM_HATCH[2].getStackForm());

            ModHandler.addShapedRecipe(true, "item_bus_output_to_input_12", EXPORT_ITEM_HATCH[2].getStackForm(),
                    " d ", " H ", "   ",
                    'H', IMPORT_ITEM_HATCH[2].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(QUANTUM_CHEST[4])
                    .circuitMeta(1)
                    .fluidInputs(Kevlar.getFluid(1152))
                    .output(IMPORT_ITEM_HATCH[2])
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(QUANTUM_CHEST[4])
                    .circuitMeta(2)
                    .fluidInputs(Kevlar.getFluid(1152))
                    .output(EXPORT_ITEM_HATCH[2])
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();

            //  OpV item bus
            ModHandler.addShapedRecipe(true, "item_bus_input_to_output_13", IMPORT_ITEM_HATCH[3].getStackForm(),
                    " d ", " H ", "   ",
                    'H', EXPORT_ITEM_HATCH[3].getStackForm());

            ModHandler.addShapedRecipe(true, "item_bus_output_to_input_13", EXPORT_ITEM_HATCH[3].getStackForm(),
                    " d ", " H ", "   ",
                    'H', IMPORT_ITEM_HATCH[3].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(QUANTUM_CHEST[5])
                    .circuitMeta(1)
                    .fluidInputs(CosmicFabric.getFluid(1296))
                    .output(IMPORT_ITEM_HATCH[3])
                    .EUt(VA[OpV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(QUANTUM_CHEST[5])
                    .circuitMeta(2)
                    .fluidInputs(CosmicFabric.getFluid(1296))
                    .output(EXPORT_ITEM_HATCH[3])
                    .EUt(VA[OpV])
                    .duration(300)
                    .buildAndRegister();
        }

    }

    private static void FluidHatches() {

        //  Delete vanilla UHV fluid bus recipe
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(), QUANTUM_TANK[1].getStackForm(), IntCircuitIngredient.getIntegratedCircuit(1)},
                new FluidStack[]{Polybenzimidazole.getFluid(720)});

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(), QUANTUM_TANK[1].getStackForm(), IntCircuitIngredient.getIntegratedCircuit(2)},
                new FluidStack[]{Polybenzimidazole.getFluid(720)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(QUANTUM_TANK[1])
                .circuitMeta(1)
                .fluidInputs(Polyetheretherketone.getFluid(720))
                .output(FLUID_IMPORT_HATCH[UHV])
                .EUt(VA[UHV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(QUANTUM_TANK[1])
                .circuitMeta(2)
                .fluidInputs(Polyetheretherketone.getFluid(720))
                .output(FLUID_EXPORT_HATCH[UHV])
                .EUt(VA[UHV])
                .duration(300)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTierFluidHatch) {
            //  UEV fluid hatch
            ModHandler.addShapedRecipe(true, "fluid_hatch_input_to_output_10", IMPORT_FLUID_HATCH[0].getStackForm(),
                    " d ", " H ", "   ",
                    'H', EXPORT_FLUID_HATCH[0].getStackForm());

            ModHandler.addShapedRecipe(true, "fluid_hatch_output_to_input_10", EXPORT_FLUID_HATCH[0].getStackForm(),
                    " d ", " H ", "   ",
                    'H', IMPORT_FLUID_HATCH[0].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(QUANTUM_TANK[2])
                    .circuitMeta(1)
                    .fluidInputs(Polyetheretherketone.getFluid(864))
                    .output(IMPORT_FLUID_HATCH[0])
                    .EUt(VA[UEV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(QUANTUM_CHEST[2])
                    .circuitMeta(2)
                    .fluidInputs(Polyetheretherketone.getFluid(864))
                    .output(EXPORT_FLUID_HATCH[0])
                    .EUt(VA[UEV])
                    .duration(300)
                    .buildAndRegister();

            //  UIV
            ModHandler.addShapedRecipe(true, "fluid_hatch_input_to_output_11", IMPORT_FLUID_HATCH[1].getStackForm(),
                    " d ", " H ", "   ",
                    'H', EXPORT_FLUID_HATCH[1].getStackForm());

            ModHandler.addShapedRecipe(true, "fluid_hatch_output_to_input_11", EXPORT_FLUID_HATCH[1].getStackForm(),
                    " d ", " H ", "   ",
                    'H', IMPORT_FLUID_HATCH[1].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(QUANTUM_TANK[3])
                    .circuitMeta(1)
                    .fluidInputs(Kevlar.getFluid(1008))
                    .output(IMPORT_FLUID_HATCH[1])
                    .EUt(VA[UIV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(QUANTUM_TANK[3])
                    .circuitMeta(2)
                    .fluidInputs(Kevlar.getFluid(1008))
                    .output(EXPORT_FLUID_HATCH[1])
                    .EUt(VA[UIV])
                    .duration(300)
                    .buildAndRegister();

            //  UXV
            ModHandler.addShapedRecipe(true, "fluid_hatch_input_to_output_12", IMPORT_FLUID_HATCH[2].getStackForm(),
                    " d ", " H ", "   ",
                    'H', EXPORT_FLUID_HATCH[2].getStackForm());

            ModHandler.addShapedRecipe(true, "fluid_hatch_output_to_input_12", EXPORT_FLUID_HATCH[2].getStackForm(),
                    " d ", " H ", "   ",
                    'H', IMPORT_FLUID_HATCH[2].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(QUANTUM_TANK[4])
                    .circuitMeta(1)
                    .fluidInputs(Kevlar.getFluid(1152))
                    .output(IMPORT_FLUID_HATCH[2])
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(QUANTUM_TANK[4])
                    .circuitMeta(2)
                    .fluidInputs(Kevlar.getFluid(1152))
                    .output(EXPORT_FLUID_HATCH[2])
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();

            //  OpV
            ModHandler.addShapedRecipe(true, "fluid_hatch_input_to_output_13", IMPORT_FLUID_HATCH[3].getStackForm(),
                    " d ", " H ", "   ",
                    'H', EXPORT_FLUID_HATCH[3].getStackForm());

            ModHandler.addShapedRecipe(true, "fluid_hatch_output_to_input_13", EXPORT_FLUID_HATCH[3].getStackForm(),
                    " d ", " H ", "   ",
                    'H', IMPORT_FLUID_HATCH[3].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(QUANTUM_TANK[5])
                    .circuitMeta(1)
                    .fluidInputs(CosmicFabric.getFluid(1296))
                    .output(IMPORT_FLUID_HATCH[3])
                    .EUt(VA[OpV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(QUANTUM_TANK[5])
                    .circuitMeta(2)
                    .fluidInputs(CosmicFabric.getFluid(1296))
                    .output(EXPORT_FLUID_HATCH[3])
                    .EUt(VA[OpV])
                    .duration(300)
                    .buildAndRegister();
        }

    }

    private static void MultiFluidHatches() {

        //  UHV 4x
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(4), FLUID_IMPORT_HATCH[UHV].getStackForm(), OreDictUnifier.get(pipeQuadrupleFluid, Neutronium)},
                new FluidStack[]{Polybenzimidazole.getFluid(576)});

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(4), FLUID_EXPORT_HATCH[UHV].getStackForm(), OreDictUnifier.get(pipeQuadrupleFluid, Neutronium)},
                new FluidStack[]{Polybenzimidazole.getFluid(576)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FLUID_IMPORT_HATCH[UHV])
                .input(pipeQuadrupleFluid, Duranium)
                .circuitMeta(4)
                .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                .output(QUADRUPLE_IMPORT_HATCH[5]) // UHV
                .EUt(VA[UV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FLUID_EXPORT_HATCH[UHV])
                .input(pipeQuadrupleFluid, Duranium)
                .circuitMeta(4)
                .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                .output(QUADRUPLE_EXPORT_HATCH[5]) // UHV
                .EUt(VA[UV])
                .duration(300)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTierMultiFluidHatch) {
            //  UEV 4x
            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_input_to_output_10", QUADRUPLE_IMPORT_FLUID_HATCH[0].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_EXPORT_FLUID_HATCH[0].getStackForm());

            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_output_to_input_10", QUADRUPLE_EXPORT_FLUID_HATCH[0].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_IMPORT_FLUID_HATCH[0].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[0]) // UEV
                    .input(pipeQuadrupleFluid, Lafium)
                    .circuitMeta(4)
                    .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                    .output(QUADRUPLE_IMPORT_FLUID_HATCH[0]) // UEV
                    .EUt(VA[UHV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[0]) // UEV
                    .input(pipeQuadrupleFluid, Lafium)
                    .circuitMeta(4)
                    .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                    .output(QUADRUPLE_EXPORT_FLUID_HATCH[0]) // UEV
                    .EUt(VA[UHV])
                    .duration(300)
                    .buildAndRegister();

            //  UIV 4x
            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_input_to_output_11", QUADRUPLE_IMPORT_FLUID_HATCH[1].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_EXPORT_FLUID_HATCH[1].getStackForm());

            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_output_to_input_11", QUADRUPLE_EXPORT_FLUID_HATCH[1].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_IMPORT_FLUID_HATCH[1].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[1]) // UIV
                    .input(pipeQuadrupleFluid, CrystalMatrix)
                    .circuitMeta(4)
                    .fluidInputs(Kevlar.getFluid(L * 4))
                    .output(QUADRUPLE_IMPORT_FLUID_HATCH[1]) // UIV
                    .EUt(VA[UEV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[1]) // UIV
                    .input(pipeQuadrupleFluid, CrystalMatrix)
                    .circuitMeta(4)
                    .fluidInputs(Kevlar.getFluid(L * 4))
                    .output(QUADRUPLE_EXPORT_FLUID_HATCH[1]) // UIV
                    .EUt(VA[UEV])
                    .duration(300)
                    .buildAndRegister();

            //  UXV 4x
            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_input_to_output_12", QUADRUPLE_IMPORT_FLUID_HATCH[2].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_EXPORT_FLUID_HATCH[2].getStackForm());

            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_output_to_input_12", QUADRUPLE_EXPORT_FLUID_HATCH[2].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_IMPORT_FLUID_HATCH[2].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[2]) // UXV
                    .input(pipeQuadrupleFluid, QuantumchromodynamicallyConfinedMatter)
                    .circuitMeta(4)
                    .fluidInputs(Kevlar.getFluid(L * 4))
                    .output(QUADRUPLE_IMPORT_FLUID_HATCH[2]) // UXV
                    .EUt(VA[UIV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[2]) // UXV
                    .input(pipeQuadrupleFluid, QuantumchromodynamicallyConfinedMatter)
                    .circuitMeta(4)
                    .fluidInputs(Kevlar.getFluid(L * 4))
                    .output(QUADRUPLE_EXPORT_FLUID_HATCH[2]) // UXV
                    .EUt(VA[UIV])
                    .duration(300)
                    .buildAndRegister();

            //  OpV 4x
            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_input_to_output_13", QUADRUPLE_IMPORT_FLUID_HATCH[3].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_EXPORT_FLUID_HATCH[3].getStackForm());

            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_output_to_input_13", QUADRUPLE_EXPORT_FLUID_HATCH[3].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_IMPORT_FLUID_HATCH[3].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[3]) // OpV
                    .input(pipeQuadrupleFluid, Fatalium)
                    .circuitMeta(4)
                    .fluidInputs(CosmicFabric.getFluid(L * 4))
                    .output(QUADRUPLE_IMPORT_FLUID_HATCH[3]) // OpV
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[3]) // OpV
                    .input(pipeQuadrupleFluid, Fatalium)
                    .circuitMeta(4)
                    .fluidInputs(CosmicFabric.getFluid(L * 4))
                    .output(QUADRUPLE_EXPORT_FLUID_HATCH[3]) // OpV
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();
        }

        //  UHV 9x
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(9), FLUID_IMPORT_HATCH[UHV].getStackForm(), OreDictUnifier.get(pipeNonupleFluid, Neutronium)},
                new FluidStack[]{Polybenzimidazole.getFluid(1296)});

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(9), FLUID_EXPORT_HATCH[UHV].getStackForm(), OreDictUnifier.get(pipeNonupleFluid, Neutronium)},
                new FluidStack[]{Polybenzimidazole.getFluid(1296)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FLUID_IMPORT_HATCH[UHV])
                .input(pipeNonupleFluid, Duranium)
                .circuitMeta(9)
                .fluidInputs(Polyetheretherketone.getFluid(L * 9))
                .output(NONUPLE_IMPORT_HATCH[5]) // UHV
                .EUt(VA[UV])
                .duration(600)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FLUID_EXPORT_HATCH[UHV])
                .input(pipeNonupleFluid, Duranium)
                .circuitMeta(9)
                .fluidInputs(Polyetheretherketone.getFluid(L * 9))
                .output(NONUPLE_EXPORT_HATCH[5]) // UHV
                .EUt(VA[UV])
                .duration(600)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTierMultiFluidHatch) {
            //  UEV 9x
            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_input_to_output_10", NONUPLE_IMPORT_FLUID_HATCH[0].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_EXPORT_FLUID_HATCH[0].getStackForm());

            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_output_to_input_10", NONUPLE_EXPORT_FLUID_HATCH[0].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_IMPORT_FLUID_HATCH[0].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[0]) // UEV
                    .input(pipeNonupleFluid, Lafium)
                    .circuitMeta(9)
                    .fluidInputs(Polyetheretherketone.getFluid(L * 9))
                    .output(NONUPLE_IMPORT_FLUID_HATCH[0]) // UEV
                    .EUt(VA[UHV])
                    .duration(600)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[0]) // UEV
                    .input(pipeNonupleFluid, Lafium)
                    .circuitMeta(9)
                    .fluidInputs(Polyetheretherketone.getFluid(L * 9))
                    .output(NONUPLE_EXPORT_FLUID_HATCH[0]) // UEV
                    .EUt(VA[UHV])
                    .duration(600)
                    .buildAndRegister();

            //  UIV 9x
            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_input_to_output_11", NONUPLE_IMPORT_FLUID_HATCH[1].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_EXPORT_FLUID_HATCH[1].getStackForm());

            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_output_to_input_11", NONUPLE_EXPORT_FLUID_HATCH[1].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_IMPORT_FLUID_HATCH[1].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[1]) // UIV
                    .input(pipeNonupleFluid, CrystalMatrix)
                    .circuitMeta(9)
                    .fluidInputs(Kevlar.getFluid(L * 9))
                    .output(NONUPLE_IMPORT_FLUID_HATCH[1]) // UIV
                    .EUt(VA[UEV])
                    .duration(600)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[1]) // UIV
                    .input(pipeNonupleFluid, CrystalMatrix)
                    .circuitMeta(9)
                    .fluidInputs(Kevlar.getFluid(L * 9))
                    .output(NONUPLE_EXPORT_FLUID_HATCH[1]) // UIV
                    .EUt(VA[UEV])
                    .duration(600)
                    .buildAndRegister();

            //  UXV 9x
            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_input_to_output_12", NONUPLE_IMPORT_FLUID_HATCH[2].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_EXPORT_FLUID_HATCH[2].getStackForm());

            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_output_to_input_12", NONUPLE_EXPORT_FLUID_HATCH[2].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_IMPORT_FLUID_HATCH[2].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[2]) // UXV
                    .input(pipeNonupleFluid, QuantumchromodynamicallyConfinedMatter)
                    .circuitMeta(9)
                    .fluidInputs(Kevlar.getFluid(L * 9))
                    .output(NONUPLE_IMPORT_FLUID_HATCH[2]) // UXV
                    .EUt(VA[UIV])
                    .duration(600)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[2]) // UXV
                    .input(pipeNonupleFluid, QuantumchromodynamicallyConfinedMatter)
                    .circuitMeta(9)
                    .fluidInputs(Kevlar.getFluid(L * 9))
                    .output(NONUPLE_EXPORT_FLUID_HATCH[2]) // UXV
                    .EUt(VA[UIV])
                    .duration(600)
                    .buildAndRegister();

            //  OpV 9x
            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_input_to_output_13", NONUPLE_IMPORT_FLUID_HATCH[3].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_EXPORT_FLUID_HATCH[3].getStackForm());

            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_output_to_input_13", NONUPLE_EXPORT_FLUID_HATCH[3].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_IMPORT_FLUID_HATCH[3].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[3]) // OpV
                    .input(pipeNonupleFluid, Fatalium)
                    .circuitMeta(9)
                    .fluidInputs(CosmicFabric.getFluid(L * 9))
                    .output(NONUPLE_IMPORT_FLUID_HATCH[3]) // OpV
                    .EUt(VA[UXV])
                    .duration(600)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[3]) // OpV
                    .input(pipeNonupleFluid, Fatalium)
                    .circuitMeta(9)
                    .fluidInputs(CosmicFabric.getFluid(L * 9))
                    .output(NONUPLE_EXPORT_FLUID_HATCH[3]) // OpV
                    .EUt(VA[UXV])
                    .duration(600)
                    .buildAndRegister();
        }
    }

    private static void EnergyHathces() {

        EnergyHatches1A();
        EnergyHatches4A();
        EnergyHatches16A();
        EnergyHatches64A();
        Transformers();
        PowerTransformers();
        HiAmpTransformers();
        LaserHatches256A();
        LaserHatches1024A();
        LaserHatches4096A();
    }

    private static void EnergyHatches1A() {

        //  Delete UHV vanilla recipes
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLY_LINE_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(),
                        OreDictUnifier.get(cableGtSingle, Europium, 4),
                        ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                        OreDictUnifier.get(circuit, MarkerMaterials.Tier.UHV),
                        OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 2)},
                new FluidStack[]{SodiumPotassium.getFluid(12000),
                        SolderingAlloy.getFluid(5760)});

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLY_LINE_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(),
                        OreDictUnifier.get(spring, Europium, 4),
                        ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                        OreDictUnifier.get(circuit, MarkerMaterials.Tier.UHV),
                        OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 2)},
                new FluidStack[]{SodiumPotassium.getFluid(12000),
                        SolderingAlloy.getFluid(5760)});

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(cableGtSingle, Europium, 4)
                .input(NANO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(VOLTAGE_COIL_UHV, 2)
                .fluidInputs(SodiumPotassium.getFluid(12000))
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .output(ENERGY_INPUT_HATCH[UHV])
                .EUt(VA[UHV])
                .duration(1000)
                .stationResearch(b -> b
                        .researchStack(ENERGY_INPUT_HATCH[UV].getStackForm())
                        .CWUt(128)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(spring, Europium, 4)
                .input(NANO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(VOLTAGE_COIL_UHV, 2)
                .fluidInputs(SodiumPotassium.getFluid(12000))
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .output(ENERGY_OUTPUT_HATCH[UHV])
                .EUt(VA[UHV])
                .duration(1000)
                .stationResearch(b -> b
                        .researchStack(ENERGY_OUTPUT_HATCH[UV].getStackForm())
                        .CWUt(128)
                        .EUt(VA[UV]))
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTier1AEnergyHatch) {
            //  UEV
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(cableGtSingle, PedotTMA, 4)
                    .input(NANO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.UEV)
                    .input(VOLTAGE_COIL_UEV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(14000))
                    .fluidInputs(SolderingAlloy.getFluid(11520))
                    .output(ENERGY_INPUT_HATCH[UEV])
                    .EUt(VA[UEV])
                    .duration(1200)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_INPUT_HATCH[UHV].getStackForm())
                            .CWUt(256)
                            .EUt(VA[UHV]))
                    .buildAndRegister();

            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(spring, PedotTMA, 4)
                    .input(NANO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.UEV)
                    .input(VOLTAGE_COIL_UEV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(14000))
                    .fluidInputs(SolderingAlloy.getFluid(11520))
                    .output(ENERGY_OUTPUT_HATCH[UEV])
                    .EUt(VA[UEV])
                    .duration(1200)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_OUTPUT_HATCH[UHV].getStackForm())
                            .CWUt(256)
                            .EUt(VA[UHV]))
                    .buildAndRegister();

            //  UIV
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(cableGtSingle, Solarium, 4)
                    .input(PICO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.UIV)
                    .input(VOLTAGE_COIL_UIV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(16000))
                    .fluidInputs(SolderingAlloy.getFluid(23040))
                    .output(ENERGY_INPUT_HATCH[UIV])
                    .EUt(VA[UIV])
                    .duration(1400)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_INPUT_HATCH[UEV].getStackForm())
                            .CWUt(512)
                            .EUt(VA[UEV]))
                    .buildAndRegister();

            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(spring, Solarium, 4)
                    .input(PICO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.UIV)
                    .input(VOLTAGE_COIL_UIV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(16000))
                    .fluidInputs(SolderingAlloy.getFluid(23040))
                    .output(ENERGY_OUTPUT_HATCH[UIV])
                    .EUt(VA[UIV])
                    .duration(1400)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_OUTPUT_HATCH[UEV].getStackForm())
                            .CWUt(512)
                            .EUt(VA[UEV]))
                    .buildAndRegister();

            //  UXV
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(cableGtSingle, Hypogen, 4)
                    .input(PICO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.UXV)
                    .input(VOLTAGE_COIL_UXV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(18000))
                    .fluidInputs(SolderingAlloy.getFluid(46080))
                    .output(ENERGY_INPUT_HATCH[UXV])
                    .EUt(VA[UXV])
                    .duration(1600)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_INPUT_HATCH[UIV].getStackForm())
                            .CWUt(1024)
                            .EUt(VA[UIV]))
                    .buildAndRegister();

            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(spring, Hypogen, 4)
                    .input(PICO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.UXV)
                    .input(VOLTAGE_COIL_UXV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(18000))
                    .fluidInputs(SolderingAlloy.getFluid(46080))
                    .output(ENERGY_OUTPUT_HATCH[UXV])
                    .EUt(VA[UXV])
                    .duration(1600)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_OUTPUT_HATCH[UIV].getStackForm())
                            .CWUt(1024)
                            .EUt(VA[UIV]))
                    .buildAndRegister();

            //  OpV
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(cableGtSingle, Galaxium, 4)
                    .input(FEMTO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.OpV)
                    .input(VOLTAGE_COIL_OpV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(20000))
                    .fluidInputs(SolderingAlloy.getFluid(92160))
                    .output(ENERGY_INPUT_HATCH[OpV])
                    .EUt(VA[OpV])
                    .duration(1800)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_INPUT_HATCH[UXV].getStackForm())
                            .CWUt(2048)
                            .EUt(VA[UXV]))
                    .buildAndRegister();

            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(spring, Galaxium, 4)
                    .input(FEMTO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.OpV)
                    .input(VOLTAGE_COIL_OpV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(20000))
                    .fluidInputs(SolderingAlloy.getFluid(92160))
                    .output(ENERGY_OUTPUT_HATCH[OpV])
                    .EUt(VA[OpV])
                    .duration(1800)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_OUTPUT_HATCH[UXV].getStackForm())
                            .CWUt(2048)
                            .EUt(VA[UXV]))
                    .buildAndRegister();
        }
    }

    private static void EnergyHatches4A() {

        //  Delete vanilla UHV recipes
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, ENERGY_INPUT_HATCH[UHV].getStackForm(), OreDictUnifier.get(wireGtQuadruple, Europium, 2), OreDictUnifier.get(plate, Neutronium, 2));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, ENERGY_OUTPUT_HATCH[UHV].getStackForm(), OreDictUnifier.get(wireGtQuadruple, Europium, 2), OreDictUnifier.get(plate, Neutronium, 2));

        //  fixme it seems ceu dev missing these... so if this recipe be deleted in future versions, this change should delete.
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, TRANSFORMER[ZPM].getStackForm(), ENERGY_OUTPUT_HATCH[ZPM].getStackForm(), OreDictUnifier.get(wireGtQuadruple, VanadiumGallium, 2), OreDictUnifier.get(plate, NaquadahAlloy, 2));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_OUTPUT_HATCH[ZPM])
                .input(wireGtQuadruple, VanadiumGallium, 2)
                .input(plate, NaquadahAlloy, 2)
                .output(ENERGY_OUTPUT_HATCH_4A[3]) // from EV to ZPM
                .EUt(VA[LuV])
                .duration(100)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableLVtoHV4AEnergyHatch) {
            //  4A output addons for LV, MV, HV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[LV])
                    .input(wireGtQuadruple, Tin, 2)
                    .input(plate, Steel, 2)
                    .output(OUTPUT_ENERGY_HATCH_4A[0])
                    .EUt(VA[ULV])
                    .duration(100)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[MV])
                    .input(wireGtQuadruple, Copper, 2)
                    .input(plate, Aluminium, 2)
                    .output(OUTPUT_ENERGY_HATCH_4A[1])
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[HV])
                    .input(wireGtQuadruple, Gold, 2)
                    .input(plate, StainlessSteel, 2)
                    .output(OUTPUT_ENERGY_HATCH_4A[2])
                    .EUt(VA[MV])
                    .duration(100)
                    .buildAndRegister();
        }

        //  UHV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_INPUT_HATCH[UHV])
                .input(wireGtQuadruple, Europium, 2)
                .input(plate, Orichalcum, 2)
                .output(ENERGY_INPUT_HATCH_4A[5]) // from IV to UHV
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_OUTPUT_HATCH[UHV])
                .input(wireGtQuadruple, Europium, 2)
                .input(plate, Orichalcum, 2)
                .output(ENERGY_OUTPUT_HATCH_4A[5]) // from EV to UHV
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTier4AEnergyHatch) {
            //  UEV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_INPUT_HATCH[UEV])
                    .input(wireGtQuadruple, PedotTMA, 2)
                    .input(plate, Adamantium, 2)
                    .output(INPUT_ENERGY_HATCH_4A[0]) // from gtlitecore
                    .EUt(VA[UHV])
                    .duration(100)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[UEV])
                    .input(wireGtQuadruple, PedotTMA, 2)
                    .input(plate, Adamantium, 2)
                    .output(OUTPUT_ENERGY_HATCH_4A[3]) // from gtlitecore
                    .EUt(VA[UHV])
                    .duration(100)
                    .buildAndRegister();

            //  UIV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_INPUT_HATCH[UIV])
                    .input(wireGtQuadruple, Solarium, 2)
                    .input(plate, Infinity, 2)
                    .output(INPUT_ENERGY_HATCH_4A[1]) // from gtlitecore
                    .EUt(VA[UEV])
                    .duration(100)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[UIV])
                    .input(wireGtQuadruple, Solarium, 2)
                    .input(plate, Infinity, 2)
                    .output(OUTPUT_ENERGY_HATCH_4A[4]) // from gtlitecore
                    .EUt(VA[UEV])
                    .duration(100)
                    .buildAndRegister();

            //  UXV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_INPUT_HATCH[UXV])
                    .input(wireGtQuadruple, Hypogen, 2)
                    .input(plate, CosmicNeutronium, 2)
                    .output(INPUT_ENERGY_HATCH_4A[2]) // from gtlitecore
                    .EUt(VA[UIV])
                    .duration(100)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[UXV])
                    .input(wireGtQuadruple, Hypogen, 2)
                    .input(plate, CosmicNeutronium, 2)
                    .output(OUTPUT_ENERGY_HATCH_4A[5]) // from gtlitecore
                    .EUt(VA[UIV])
                    .duration(100)
                    .buildAndRegister();

            //  OpV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_INPUT_HATCH[OpV])
                    .input(wireGtQuadruple, Galaxium, 2)
                    .input(plate, Spacetime, 2)
                    .output(INPUT_ENERGY_HATCH_4A[3]) // from gtlitecore
                    .EUt(VA[UXV])
                    .duration(100)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[OpV])
                    .input(wireGtQuadruple, Galaxium, 2)
                    .input(plate, Spacetime, 2)
                    .output(OUTPUT_ENERGY_HATCH_4A[6]) // from gtlitecore
                    .EUt(VA[UXV])
                    .duration(100)
                    .buildAndRegister();
        }
    }

    private static void EnergyHatches16A() {

        //  Delete vanilla UHV recipes
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, HI_AMP_TRANSFORMER[UV].getStackForm(), ENERGY_INPUT_HATCH_4A[5].getStackForm(2), OreDictUnifier.get(wireGtOctal, Europium, 2), OreDictUnifier.get(plate, Neutronium, 4));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, HI_AMP_TRANSFORMER[UV].getStackForm(), ENERGY_OUTPUT_HATCH_4A[5].getStackForm(), OreDictUnifier.get(wireGtOctal, Europium, 2), OreDictUnifier.get(plate, Neutronium, 4));

        if (GTLiteConfigHolder.machines.enableLVtoEV16AEnergyHatch) {
            //  16A output addons for LV, MV, HV, EV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[LV])
                    .input(OUTPUT_ENERGY_HATCH_4A[0])
                    .input(wireGtOctal, Tin, 2)
                    .input(plate, Steel, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[0])
                    .EUt(VA[ULV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[MV])
                    .input(OUTPUT_ENERGY_HATCH_4A[1])
                    .input(wireGtOctal, Copper, 2)
                    .input(plate, Aluminium, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[1])
                    .EUt(VA[LV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[HV])
                    .input(OUTPUT_ENERGY_HATCH_4A[2])
                    .input(wireGtOctal, Gold, 2)
                    .input(plate, StainlessSteel, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[2])
                    .EUt(VA[MV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[EV])
                    .input(ENERGY_OUTPUT_HATCH_4A[0])
                    .input(wireGtOctal, Aluminium, 2)
                    .input(plate, Titanium, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[3])
                    .EUt(VA[HV])
                    .duration(200)
                    .buildAndRegister();
        }

        //  UHV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UHV])
                .input(ENERGY_INPUT_HATCH_4A[5], 2)
                .input(wireGtOctal, Europium, 2)
                .input(plate, Orichalcum, 4)
                .output(ENERGY_INPUT_HATCH_16A[4])
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UHV])
                .input(ENERGY_OUTPUT_HATCH_4A[5])
                .input(wireGtOctal, Europium, 2)
                .input(plate, Orichalcum, 4)
                .output(ENERGY_OUTPUT_HATCH_16A[4])
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTier16AEnergyHatch) {
            //  UEV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UEV])
                    .input(INPUT_ENERGY_HATCH_4A[0], 2) // from gtlitecore
                    .input(wireGtOctal, PedotTMA, 2)
                    .input(plate, Adamantium, 4)
                    .output(INPUT_ENERGY_HATCH_16A[0]) // from gtlitecore
                    .EUt(VA[UHV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UEV])
                    .input(OUTPUT_ENERGY_HATCH_4A[3]) // from gtlitecore
                    .input(wireGtOctal, PedotTMA, 2)
                    .input(plate, Adamantium, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[4]) // from gtlitecore
                    .EUt(VA[UHV])
                    .duration(200)
                    .buildAndRegister();

            //  UIV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UIV])
                    .input(INPUT_ENERGY_HATCH_4A[1], 2) // from gtlitecore
                    .input(wireGtOctal, Solarium, 2)
                    .input(plate, Infinity, 4)
                    .output(INPUT_ENERGY_HATCH_16A[1]) // from gtlitecore
                    .EUt(VA[UEV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UIV])
                    .input(OUTPUT_ENERGY_HATCH_4A[4]) // from gtlitecore
                    .input(wireGtOctal, Solarium, 2)
                    .input(plate, Infinity, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[5]) // from gtlitecore
                    .EUt(VA[UEV])
                    .duration(200)
                    .buildAndRegister();

            //  UXV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UXV])
                    .input(INPUT_ENERGY_HATCH_4A[2], 2) // from gtlitecore
                    .input(wireGtOctal, Hypogen, 2)
                    .input(plate, CosmicNeutronium, 4)
                    .output(INPUT_ENERGY_HATCH_16A[2]) // from gtlitecore
                    .EUt(VA[UIV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UXV])
                    .input(OUTPUT_ENERGY_HATCH_4A[5]) // from gtlitecore
                    .input(wireGtOctal, Hypogen, 2)
                    .input(plate, CosmicNeutronium, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[6]) // from gtlitecore
                    .EUt(VA[UIV])
                    .duration(200)
                    .buildAndRegister();

            //  OpV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[OpV])
                    .input(INPUT_ENERGY_HATCH_4A[3], 2) // from gtlitecore
                    .input(wireGtOctal, Galaxium, 2)
                    .input(plate, Spacetime, 4)
                    .output(INPUT_ENERGY_HATCH_16A[3]) // from gtlitecore
                    .EUt(VA[UXV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[OpV])
                    .input(OUTPUT_ENERGY_HATCH_4A[6]) // from gtlitecore
                    .input(wireGtOctal, Galaxium, 2)
                    .input(plate, Spacetime, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[7]) // from gtlitecore
                    .EUt(VA[UXV])
                    .duration(200)
                    .buildAndRegister();
        }
    }

    private static void EnergyHatches64A() {

        //  Delete vanilla UHV recipes
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, POWER_TRANSFORMER[UV].getStackForm(), ENERGY_INPUT_HATCH_16A[4].getStackForm(), OreDictUnifier.get(wireGtHex, Europium, 2), OreDictUnifier.get(plate, Neutronium, 6));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, POWER_TRANSFORMER[UV].getStackForm(), ENERGY_OUTPUT_HATCH_16A[4].getStackForm(), OreDictUnifier.get(wireGtHex, Europium, 2), OreDictUnifier.get(plate, Neutronium, 6));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[UHV])
                .input(ENERGY_INPUT_HATCH_16A[4])
                .input(wireGtHex, Europium, 2)
                .input(plate, Orichalcum, 6)
                .output(SUBSTATION_ENERGY_INPUT_HATCH[4])
                .EUt(VA[UV])
                .duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[UHV])
                .input(ENERGY_OUTPUT_HATCH_16A[4])
                .input(wireGtHex, Europium, 2)
                .input(plate, Orichalcum, 6)
                .output(SUBSTATION_ENERGY_OUTPUT_HATCH[4])
                .EUt(VA[UV])
                .duration(400)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTier64ASubstationEnergyHatch) {
            //  UEV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[UEV])
                    .input(INPUT_ENERGY_HATCH_16A[0])
                    .input(wireGtHex, PedotTMA, 2)
                    .input(plate, Adamantium, 6)
                    .output(SUBSTATION_INPUT_ENERGY_HATCH[0])
                    .EUt(VA[UHV])
                    .duration(400)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[UEV])
                    .input(OUTPUT_ENERGY_HATCH_16A[4])
                    .input(wireGtHex, PedotTMA, 2)
                    .input(plate, Adamantium, 6)
                    .output(SUBSTATION_OUTPUT_ENERGY_HATCH[0])
                    .EUt(VA[UHV])
                    .duration(400)
                    .buildAndRegister();

            //  UIV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[UIV])
                    .input(INPUT_ENERGY_HATCH_16A[1])
                    .input(wireGtHex, Solarium, 2)
                    .input(plate, Infinity, 6)
                    .output(SUBSTATION_INPUT_ENERGY_HATCH[1])
                    .EUt(VA[UEV])
                    .duration(400)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[UIV])
                    .input(OUTPUT_ENERGY_HATCH_16A[5])
                    .input(wireGtHex, Solarium, 2)
                    .input(plate, Infinity, 6)
                    .output(SUBSTATION_OUTPUT_ENERGY_HATCH[1])
                    .EUt(VA[UEV])
                    .duration(400)
                    .buildAndRegister();

            //  UXV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[UXV])
                    .input(INPUT_ENERGY_HATCH_16A[2])
                    .input(wireGtHex, Hypogen, 2)
                    .input(plate, CosmicNeutronium, 6)
                    .output(SUBSTATION_INPUT_ENERGY_HATCH[2])
                    .EUt(VA[UIV])
                    .duration(400)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[UXV])
                    .input(OUTPUT_ENERGY_HATCH_16A[6])
                    .input(wireGtHex, Hypogen, 2)
                    .input(plate, CosmicNeutronium, 6)
                    .output(SUBSTATION_OUTPUT_ENERGY_HATCH[2])
                    .EUt(VA[UIV])
                    .duration(400)
                    .buildAndRegister();

            //  OpV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[OpV])
                    .input(INPUT_ENERGY_HATCH_16A[3])
                    .input(wireGtHex, Galaxium, 2)
                    .input(plate, Spacetime, 6)
                    .output(SUBSTATION_INPUT_ENERGY_HATCH[3])
                    .EUt(VA[UXV])
                    .duration(400)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[OpV])
                    .input(OUTPUT_ENERGY_HATCH_16A[7])
                    .input(wireGtHex, Galaxium, 2)
                    .input(plate, Spacetime, 6)
                    .output(SUBSTATION_OUTPUT_ENERGY_HATCH[3])
                    .EUt(VA[UXV])
                    .duration(400)
                    .buildAndRegister();
        }
    }

    private static void Transformers() {

        //  UHV
        ModHandler.addShapedRecipe(true, "machine.transformer.uhv", TRANSFORMER[UHV].getStackForm(),
                "PWW", "WH ", "PWW",
                'W', new UnificationEntry(cableGtSingle, Europium),
                'P', NANO_PIC_CHIP,
                'H', HULL[UHV].getStackForm());

        if (GTLiteConfigHolder.machines.enableHighTierTransformer) {
            //  UEV
            ModHandler.addShapedRecipe(true, "machine.transformer.uev", TRANSFORMER[UEV].getStackForm(),
                    "PWW", "WH ", "PWW",
                    'W', new UnificationEntry(cableGtSingle, PedotTMA),
                    'P', NANO_PIC_CHIP,
                    'H', HULL[UEV].getStackForm());

            //  UIV
            ModHandler.addShapedRecipe(true, "machine.transformer.uiv", TRANSFORMER[UIV].getStackForm(),
                    "PWW", "WH ", "PWW",
                    'W', new UnificationEntry(cableGtSingle, Solarium),
                    'P', PICO_PIC_CHIP,
                    'H', HULL[UIV].getStackForm());

            //  UXV
            ModHandler.addShapedRecipe(true, "machine.transformer.uxv", TRANSFORMER[UXV].getStackForm(),
                    "PWW", "WH ", "PWW",
                    'W', new UnificationEntry(cableGtSingle, Hypogen),
                    'P', PICO_PIC_CHIP,
                    'H', HULL[UXV].getStackForm());

            //  OpV
            ModHandler.addShapedRecipe(true, "machine.transformer.opv", TRANSFORMER[OpV].getStackForm(),
                    "PWW", "WH ", "PWW",
                    'W', new UnificationEntry(cableGtSingle, Galaxium),
                    'P', FEMTO_PIC_CHIP,
                    'H', HULL[OpV].getStackForm());
        }

    }

    private static void PowerTransformers() {

        //  UHV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UHV])
                .input(ELECTRIC_PUMP_IV)
                .input(cableGtOctal, PedotTMA)
                .input(cableGtHex, Europium, 2)
                .input(springSmall, Europium)
                .input(spring, PedotTMA)
                .fluidInputs(Lubricant.getFluid(2000))
                .output(POWER_TRANSFORMER[UHV])
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTierPowerTransformer) {
            //  UEV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UEV])
                    .input(ELECTRIC_PUMP_LuV)
                    .input(cableGtOctal, Solarium)
                    .input(cableGtHex, PedotTMA, 2)
                    .input(springSmall, PedotTMA)
                    .input(spring, Solarium)
                    .fluidInputs(Lubricant.getFluid(2000))
                    .output(POWER_TRANSFORMER[UEV])
                    .EUt(VA[UEV])
                    .duration(200)
                    .buildAndRegister();

            //  UIV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UIV])
                    .input(ELECTRIC_PUMP_LuV)
                    .input(cableGtOctal, Hypogen)
                    .input(cableGtHex, Solarium, 2)
                    .input(springSmall, Solarium)
                    .input(spring, Hypogen)
                    .fluidInputs(Lubricant.getFluid(2000))
                    .output(POWER_TRANSFORMER[UIV])
                    .EUt(VA[UIV])
                    .duration(200)
                    .buildAndRegister();

            //  UXV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UXV])
                    .input(ELECTRIC_PUMP_ZPM)
                    .input(cableGtOctal, Galaxium)
                    .input(cableGtHex, Hypogen, 2)
                    .input(springSmall, Hypogen)
                    .input(spring, Galaxium)
                    .fluidInputs(Lubricant.getFluid(2000))
                    .output(POWER_TRANSFORMER[UXV])
                    .EUt(VA[UXV])
                    .duration(200)
                    .buildAndRegister();

            //  OpV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[OpV])
                    .input(ELECTRIC_PUMP_ZPM)
                    .input(cableGtOctal, Universium)
                    .input(cableGtHex, Hypogen, 2)
                    .input(springSmall, Hypogen)
                    .input(spring, Universium)
                    .fluidInputs(Lubricant.getFluid(2000))
                    .output(POWER_TRANSFORMER[OpV])
                    .EUt(VA[OpV])
                    .duration(200)
                    .buildAndRegister();
        }
    }

    private static void HiAmpTransformers() {

        //  UHV
        ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.uhv", HI_AMP_TRANSFORMER[UHV].getStackForm(),
                "VQQ", "PH ", "VQQ",
                'V', VOLTAGE_COIL_UHV,
                'H', HULL[UHV].getStackForm(),
                'P', new UnificationEntry(cableGtQuadruple, PedotTMA),
                'Q', new UnificationEntry(cableGtQuadruple, Europium));

        if (GTLiteConfigHolder.machines.enableHighTierHiAmpTransformer) {
            //  UEV
            ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.uev", HI_AMP_TRANSFORMER[UEV].getStackForm(),
                    "VQQ", "PH ", "VQQ",
                    'V', VOLTAGE_COIL_UEV,
                    'H', HULL[UEV].getStackForm(),
                    'P', new UnificationEntry(cableGtQuadruple, Solarium),
                    'Q', new UnificationEntry(cableGtQuadruple, PedotTMA));

            //  UIV
            ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.uiv", HI_AMP_TRANSFORMER[UIV].getStackForm(),
                    "VQQ", "PH ", "VQQ",
                    'V', VOLTAGE_COIL_UIV,
                    'H', HULL[UIV].getStackForm(),
                    'P', new UnificationEntry(cableGtQuadruple, Hypogen),
                    'Q', new UnificationEntry(cableGtQuadruple, Solarium));

            //  UXV
            ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.uxv", HI_AMP_TRANSFORMER[UXV].getStackForm(),
                    "VQQ", "PH ", "VQQ",
                    'V', VOLTAGE_COIL_UXV,
                    'H', HULL[UXV].getStackForm(),
                    'P', new UnificationEntry(cableGtQuadruple, Galaxium),
                    'Q', new UnificationEntry(cableGtQuadruple, Hypogen));

            //  OpV
            ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.opv", HI_AMP_TRANSFORMER[OpV].getStackForm(),
                    "VQQ", "PH ", "VQQ",
                    'V', VOLTAGE_COIL_OpV,
                    'H', HULL[OpV].getStackForm(),
                    'P', new UnificationEntry(cableGtQuadruple, Universium),
                    'Q', new UnificationEntry(cableGtQuadruple, Galaxium));
        }
    }

    private static void LaserHatches256A() {

        if (GTLiteConfigHolder.machines.enableHighTier256ALaserHatch) {
            //  UHV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UHV])
                    .input(lens, Diamond)
                    .input(EMITTER_UHV)
                    .input(ELECTRIC_PUMP_UHV)
                    .input(cableGtSingle, Europium, 4)
                    .circuitMeta(1)
                    .output(LASER_INPUT_HATCH_256[4])
                    .EUt(VA[UHV])
                    .duration(300)
                    .buildAndRegister();

            //  UHV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UHV])
                    .input(lens, Diamond)
                    .input(SENSOR_UHV)
                    .input(ELECTRIC_PUMP_UHV)
                    .input(cableGtSingle, Europium, 4)
                    .circuitMeta(1)
                    .output(LASER_OUTPUT_HATCH_256[4])
                    .EUt(VA[UHV])
                    .duration(300)
                    .buildAndRegister();

            //  UEV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(lens, Diamond)
                    .input(EMITTER_UEV)
                    .input(ELECTRIC_PUMP_UEV)
                    .input(cableGtSingle, PedotTMA, 4)
                    .circuitMeta(1)
                    .output(LASER_INPUT_HATCH_256[5])
                    .EUt(VA[UEV])
                    .duration(300)
                    .buildAndRegister();

            //  UEV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(lens, Diamond)
                    .input(SENSOR_UEV)
                    .input(ELECTRIC_PUMP_UEV)
                    .input(cableGtSingle, PedotTMA, 4)
                    .circuitMeta(1)
                    .output(LASER_OUTPUT_HATCH_256[5])
                    .EUt(VA[UEV])
                    .duration(300)
                    .buildAndRegister();

            //  UIV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(lens, Diamond)
                    .input(EMITTER_UIV)
                    .input(ELECTRIC_PUMP_UIV)
                    .input(cableGtSingle, Solarium, 4)
                    .circuitMeta(1)
                    .output(LASER_INPUT_HATCH_256[6])
                    .EUt(VA[UIV])
                    .duration(300)
                    .buildAndRegister();

            //  UIV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(lens, Diamond)
                    .input(SENSOR_UIV)
                    .input(ELECTRIC_PUMP_UIV)
                    .input(cableGtSingle, Solarium, 4)
                    .circuitMeta(1)
                    .output(LASER_OUTPUT_HATCH_256[6])
                    .EUt(VA[UIV])
                    .duration(300)
                    .buildAndRegister();

            //  UXV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(lens, Diamond)
                    .input(EMITTER_UXV)
                    .input(ELECTRIC_PUMP_UXV)
                    .input(cableGtSingle, Hypogen, 4)
                    .circuitMeta(1)
                    .output(LASER_INPUT_HATCH_256[7])
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();

            //  UXV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(lens, Diamond)
                    .input(SENSOR_UXV)
                    .input(ELECTRIC_PUMP_UXV)
                    .input(cableGtSingle, Hypogen, 4)
                    .circuitMeta(1)
                    .output(LASER_OUTPUT_HATCH_256[7])
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();

            //  OpV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(lens, Diamond)
                    .input(EMITTER_OpV)
                    .input(ELECTRIC_PUMP_OpV)
                    .input(cableGtSingle, Galaxium, 4)
                    .circuitMeta(1)
                    .output(LASER_INPUT_HATCH_256[8])
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();

            //  OpV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(lens, Diamond)
                    .input(SENSOR_OpV)
                    .input(ELECTRIC_PUMP_OpV)
                    .input(cableGtSingle, Galaxium, 4)
                    .circuitMeta(1)
                    .output(LASER_OUTPUT_HATCH_256[8])
                    .EUt(VA[OpV])
                    .duration(300)
                    .buildAndRegister();
        }

    }

    private static void LaserHatches1024A() {

        if (GTLiteConfigHolder.machines.enableHighTier1024ALaserHatch) {
            //  UHV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UHV])
                    .input(lens, Diamond, 2)
                    .input(EMITTER_UHV, 2)
                    .input(ELECTRIC_PUMP_UHV, 2)
                    .input(cableGtDouble, Europium, 4)
                    .circuitMeta(2)
                    .output(LASER_INPUT_HATCH_1024[4])
                    .EUt(VA[UHV])
                    .duration(600)
                    .buildAndRegister();

            //  UHV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UHV])
                    .input(lens, Diamond, 2)
                    .input(SENSOR_UHV, 2)
                    .input(ELECTRIC_PUMP_UHV, 2)
                    .input(cableGtDouble, Europium, 4)
                    .circuitMeta(2)
                    .output(LASER_OUTPUT_HATCH_1024[4])
                    .EUt(VA[UHV])
                    .duration(600)
                    .buildAndRegister();

            //  UEV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(lens, Diamond, 2)
                    .input(EMITTER_UEV, 2)
                    .input(ELECTRIC_PUMP_UEV, 2)
                    .input(cableGtDouble, PedotTMA, 4)
                    .circuitMeta(2)
                    .output(LASER_INPUT_HATCH_1024[5])
                    .EUt(VA[UEV])
                    .duration(600)
                    .buildAndRegister();

            //  UEV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(lens, Diamond, 2)
                    .input(SENSOR_UEV, 2)
                    .input(ELECTRIC_PUMP_UEV, 2)
                    .input(cableGtDouble, PedotTMA, 4)
                    .circuitMeta(2)
                    .output(LASER_OUTPUT_HATCH_1024[5])
                    .EUt(VA[UEV])
                    .duration(600)
                    .buildAndRegister();

            //  UIV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(lens, Diamond, 2)
                    .input(EMITTER_UIV, 2)
                    .input(ELECTRIC_PUMP_UIV, 2)
                    .input(cableGtDouble, Solarium, 4)
                    .circuitMeta(2)
                    .output(LASER_INPUT_HATCH_1024[6])
                    .EUt(VA[UIV])
                    .duration(600)
                    .buildAndRegister();

            //  UIV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(lens, Diamond, 2)
                    .input(SENSOR_UIV, 2)
                    .input(ELECTRIC_PUMP_UIV, 2)
                    .input(cableGtDouble, Solarium, 4)
                    .circuitMeta(2)
                    .output(LASER_OUTPUT_HATCH_1024[6])
                    .EUt(VA[UIV])
                    .duration(600)
                    .buildAndRegister();

            //  UXV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(lens, Diamond, 2)
                    .input(EMITTER_UXV, 2)
                    .input(ELECTRIC_PUMP_UXV, 2)
                    .input(cableGtDouble, Hypogen, 4)
                    .circuitMeta(2)
                    .output(LASER_INPUT_HATCH_1024[7])
                    .EUt(VA[UXV])
                    .duration(600)
                    .buildAndRegister();

            //  UXV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(lens, Diamond, 2)
                    .input(SENSOR_UXV, 2)
                    .input(ELECTRIC_PUMP_UXV, 2)
                    .input(cableGtDouble, Hypogen, 4)
                    .circuitMeta(2)
                    .output(LASER_OUTPUT_HATCH_1024[7])
                    .EUt(VA[UXV])
                    .duration(600)
                    .buildAndRegister();

            //  OpV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(lens, Diamond, 2)
                    .input(EMITTER_OpV, 2)
                    .input(ELECTRIC_PUMP_OpV, 2)
                    .input(cableGtDouble, Galaxium, 4)
                    .circuitMeta(2)
                    .output(LASER_INPUT_HATCH_1024[8])
                    .EUt(VA[OpV])
                    .duration(600)
                    .buildAndRegister();

            //  OpV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(lens, Diamond, 2)
                    .input(SENSOR_OpV, 2)
                    .input(ELECTRIC_PUMP_OpV, 2)
                    .input(cableGtDouble, Galaxium, 4)
                    .circuitMeta(2)
                    .output(LASER_OUTPUT_HATCH_1024[8])
                    .EUt(VA[OpV])
                    .duration(600)
                    .buildAndRegister();
        }
    }

    private static void LaserHatches4096A() {

        if (GTLiteConfigHolder.machines.enableHighTier4096ALaserHatch) {
            //  UHV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UHV])
                    .input(lens, Diamond, 4)
                    .input(EMITTER_UHV, 4)
                    .input(ELECTRIC_PUMP_UHV, 4)
                    .input(cableGtQuadruple, Europium, 4)
                    .circuitMeta(3)
                    .output(LASER_INPUT_HATCH_4096[4])
                    .EUt(VA[UHV])
                    .duration(1200)
                    .buildAndRegister();

            //  UHV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UHV])
                    .input(lens, Diamond, 4)
                    .input(SENSOR_UHV, 4)
                    .input(ELECTRIC_PUMP_UHV, 4)
                    .input(cableGtQuadruple, Europium, 4)
                    .circuitMeta(3)
                    .output(LASER_OUTPUT_HATCH_4096[4])
                    .EUt(VA[UHV])
                    .duration(1200)
                    .buildAndRegister();

            //  UEV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(lens, Diamond, 4)
                    .input(EMITTER_UEV, 4)
                    .input(ELECTRIC_PUMP_UEV, 4)
                    .input(cableGtQuadruple, PedotTMA, 4)
                    .circuitMeta(3)
                    .output(LASER_INPUT_HATCH_4096[5])
                    .EUt(VA[UEV])
                    .duration(1200)
                    .buildAndRegister();

            //  UEV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(lens, Diamond, 4)
                    .input(SENSOR_UEV, 4)
                    .input(ELECTRIC_PUMP_UEV, 4)
                    .input(cableGtQuadruple, PedotTMA, 4)
                    .circuitMeta(3)
                    .output(LASER_OUTPUT_HATCH_4096[5])
                    .EUt(VA[UEV])
                    .duration(1200)
                    .buildAndRegister();

            //  UIV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(lens, Diamond, 4)
                    .input(EMITTER_UIV, 4)
                    .input(ELECTRIC_PUMP_UIV, 4)
                    .input(cableGtQuadruple, Solarium, 4)
                    .circuitMeta(3)
                    .output(LASER_INPUT_HATCH_4096[6])
                    .EUt(VA[UIV])
                    .duration(1200)
                    .buildAndRegister();

            //  UIV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(lens, Diamond, 4)
                    .input(SENSOR_UIV, 4)
                    .input(ELECTRIC_PUMP_UIV, 4)
                    .input(cableGtQuadruple, Solarium, 4)
                    .circuitMeta(3)
                    .output(LASER_OUTPUT_HATCH_4096[6])
                    .EUt(VA[UIV])
                    .duration(1200)
                    .buildAndRegister();

            //  UXV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(lens, Diamond, 4)
                    .input(EMITTER_UXV, 4)
                    .input(ELECTRIC_PUMP_UXV, 4)
                    .input(cableGtQuadruple, Hypogen, 4)
                    .circuitMeta(3)
                    .output(LASER_INPUT_HATCH_4096[7])
                    .EUt(VA[UXV])
                    .duration(1200)
                    .buildAndRegister();

            //  UXV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(lens, Diamond, 4)
                    .input(SENSOR_UXV, 4)
                    .input(ELECTRIC_PUMP_UXV, 4)
                    .input(cableGtQuadruple, Hypogen, 4)
                    .circuitMeta(3)
                    .output(LASER_OUTPUT_HATCH_4096[7])
                    .EUt(VA[UXV])
                    .duration(1200)
                    .buildAndRegister();

            //  OpV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(lens, Diamond, 4)
                    .input(EMITTER_OpV, 4)
                    .input(ELECTRIC_PUMP_OpV, 4)
                    .input(cableGtQuadruple, Galaxium, 4)
                    .circuitMeta(3)
                    .output(LASER_INPUT_HATCH_4096[8])
                    .EUt(VA[OpV])
                    .duration(1200)
                    .buildAndRegister();

            //  OpV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(lens, Diamond, 4)
                    .input(SENSOR_OpV, 4)
                    .input(ELECTRIC_PUMP_OpV, 4)
                    .input(cableGtQuadruple, Galaxium, 4)
                    .circuitMeta(3)
                    .output(LASER_OUTPUT_HATCH_4096[8])
                    .EUt(VA[OpV])
                    .duration(1200)
                    .buildAndRegister();
        }
    }

    /**
     * Overrides of Gregicality Multiblocks
     *
     * <p>
     *     Some machines in gtlitecore environment is too hard to make it, so we rewrite some recipes.
     *     Machines like Mega Blast furnace and Large Circuit Assembler is too unuseful.
     *     You can control this overrides by {@link GTLiteConfigHolder}.
     * </p>
     */
    private static void GCYMOverrides() {

        //  A little tweaks about Mega Blast Furnace and Mega Vacuum Freezer.
        //  Because in gtlitecore, we add Volcanus and Cryogenic Freezer, and gcym's mega machine is too unuseful.
        //  So we buff it to UV stage, and add new, more powerful mega machine for UHV stage.
        if (GTLiteConfigHolder.compats.enableEasierMegaMachines) {
            ModHandler.removeRecipeByName("gcym:mega_blast_furnace");
            ModHandler.addShapedRecipe(true, "mega_blast_furnace", MEGA_BLAST_FURNACE.getStackForm(),
                    "SXS", "FHF", "PWP",
                    'H', VOLCANUS.getStackForm(),
                    'F', FIELD_GENERATOR_UV,
                    'S', new UnificationEntry(spring, YttriumBariumCuprate),
                    'X', new UnificationEntry(circuit, MarkerMaterials.Tier.UV),
                    'P', new UnificationEntry(plate, Orichalcum),
                    'W', new UnificationEntry(wireGtQuadruple, Tritanium));

            ModHandler.removeRecipeByName("gcym:mega_vacuum_freezer");
            ModHandler.addShapedRecipe(true, "mega_vacuum_freezer", MEGA_VACUUM_FREEZER.getStackForm(),
                    "SXS", "FHF", "PWP",
                    'H', CRYOGENIC_FREEZER.getStackForm(),
                    'F', FIELD_GENERATOR_UV,
                    'S', new UnificationEntry(pipeNormalFluid, Duranium),
                    'X', new UnificationEntry(circuit, MarkerMaterials.Tier.UV),
                    'P', new UnificationEntry(plate, Orichalcum),
                    'W', new UnificationEntry(wireGtQuadruple, Tritanium));
        }

        //  This machine is too unuseful in gtlitecore environment, because we have Large Circuit Assembly Line.
        //  In vanilla CEu environment, this machine needs UV-tier circuit, is ridiculous in 15 voltages pack.
        if (GTLiteConfigHolder.compats.enableEasierLargeCircuitAssembler) {
            ModHandler.removeRecipeByName("gcym:large_circuit_assembler");
            ModHandler.addShapedRecipe(true, "large_circuit_assembler", LARGE_CIRCUIT_ASSEMBLER.getStackForm(),
                    "RER", "CXC", "WMW",
                    'X', CIRCUIT_ASSEMBLER[IV].getStackForm(),
                    'C', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                    'R', ROBOT_ARM_IV,
                    'E', EMITTER_IV,
                    'M', CONVEYOR_MODULE_IV,
                    'W', new UnificationEntry(cableGtSingle, Platinum));
        }

        if (GTLiteConfigHolder.compats.enableHighTierTieredHatch) {
            ModHandler.addShapedRecipe("tiered_hatch.uhv", TIERED_HATCH[UHV].getStackForm(),
                    "PPP", "PCP", "PPP",
                    'P', new UnificationEntry(plate, Orichalcum),
                    'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UEV));

            ModHandler.addShapedRecipe("tiered_hatch.uev", TIERED_HATCH[UEV].getStackForm(),
                    "PPP", "PCP", "PPP",
                    'P', new UnificationEntry(plate, Adamantium),
                    'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UIV));

            ModHandler.addShapedRecipe("tiered_hatch.uiv", TIERED_HATCH[UIV].getStackForm(),
                    "PPP", "PCP", "PPP",
                    'P', new UnificationEntry(plate, Infinity),
                    'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UXV));

            ModHandler.addShapedRecipe("tiered_hatch.uxv", TIERED_HATCH[UXV].getStackForm(),
                    "PPP", "PCP", "PPP",
                    'P', new UnificationEntry(plate, CosmicNeutronium),
                    'C', new UnificationEntry(circuit, MarkerMaterials.Tier.OpV));

            ModHandler.addShapedRecipe("tiered_hatch.opv", TIERED_HATCH[OpV].getStackForm(),
                    "PPP", "PCP", "PPP",
                    'P', new UnificationEntry(plate, Spacetime),
                    'C', new UnificationEntry(circuit, MarkerMaterials.Tier.MAX));

            ModHandler.addShapedRecipe("tiered_hatch.max", TIERED_HATCH[MAX].getStackForm(),
                    "PPP", "PCP", "PPP",
                    'P', new UnificationEntry(plate, Eternity),
                    'C', new UnificationEntry(circuit, MarkerMaterials.Tier.MAX));
        }
    }

    /**
     * Overrides of GregTech Food Option Machines.
     *
     * <p>
     *     Because some machines in gregtechfoodoption do not support UHV+ stage recipes, so we rewrite it.
     *     We reinit a component map about dense plate, the original map is in {@link GTFOMachineRecipes#init()}.
     *     This override can not control by {@link GTLiteConfigHolder}, because it just a compatibility between two mods.
     * </p>
     */
    private static void GTFOOverrides() {

        //  Remove original recipes, use gtlitecore register machine recipes.
        String[] voltageList = {"lv", "mv", "hv", "ev", "iv", "luv", "zpm", "uv", "uhv"};
        for (int i = 0; i < 9; i++) {
            ModHandler.removeRecipeByName("gregtechfoodoption:gregtechfoodoption.machine.slicer." + voltageList[i]);
        }

        //  A new map of dense plate component, is not same as gregtechfoodoption's.
        CraftingComponent.Component PLATE_DENSE = new CraftingComponent.Component(Stream.of(
                new Object[]{0, new UnificationEntry(plateDense, WroughtIron)},
                new Object[]{1, new UnificationEntry(plateDense, Steel)},
                new Object[]{2, new UnificationEntry(plateDense, Aluminium)},
                new Object[]{3, new UnificationEntry(plateDense, StainlessSteel)},
                new Object[]{4, new UnificationEntry(plateDense, Titanium)},
                new Object[]{5, new UnificationEntry(plateDense, TungstenSteel)},
                new Object[]{6, new UnificationEntry(plateDense, RhodiumPlatedPalladium)},
                new Object[]{7, new UnificationEntry(plateDense, NaquadahAlloy)},
                new Object[]{8, new UnificationEntry(plateDense, Darmstadtium)},
                new Object[]{9, new UnificationEntry(plateDense, Orichalcum)},
                new Object[]{10, new UnificationEntry(plateDense, Adamantium)},
                new Object[]{11, new UnificationEntry(plateDense, Infinity)},
                new Object[]{12, new UnificationEntry(plateDense, CosmicNeutronium)},
                new Object[]{13, new UnificationEntry(plateDense, Spacetime)},
                new Object[]{14, new UnificationEntry(plateDense, Eternity)})
                .collect(Collectors.toMap((data) -> (Integer)data[0], (data) -> data[1])));

        //  new recipes of Slicer
        MetaTileEntityLoader.registerMachineRecipe(SLICER,
                "PXW", "SHX", "DCW",
                'P', CraftingComponent.PISTON,
                'X', CraftingComponent.CIRCUIT,
                'W', CraftingComponent.CABLE,
                'S', CraftingComponent.SAWBLADE,
                'H', CraftingComponent.HULL,
                'D', PLATE_DENSE,
                'C', CraftingComponent.CONVEYOR);

        if (GTLiteConfigHolder.compats.enableGTFOTweaks) {

            //  Greenhouse Glass
            //  Why this recipe use assembler not alloy smelter?
            GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, CupricHydrogenArsenite.getItemStack(), MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.TEMPERED_GLASS));

            ALLOY_SMELTER_RECIPES.recipeBuilder()
                    .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.TEMPERED_GLASS))
                    .inputs(CupricHydrogenArsenite.getItemStack())
                    .outputs(GTFOMetaBlocks.GTFO_GLASS_CASING.getItemVariant(GTFOGlassCasing.CasingType.GREENHOUSE_GLASS))
                    .EUt(24)
                    .duration(60)
                    .buildAndRegister();

            //  Unfired Porcelain Tile
            //  Why this recipe consume my shape mold!? :(
            GTRecipeHandler.removeRecipesByInputs(FORMING_PRESS_RECIPES, BoneChinaClay.getItemStack(2), SHAPE_MOLD_PLATE.getStackForm());

            FORMING_PRESS_RECIPES.recipeBuilder()
                    .inputs(BoneChinaClay.getItemStack(2))
                    .notConsumable(SHAPE_MOLD_PLATE)
                    .outputs(UnfiredPorcelainTile.getItemStack())
                    .EUt(28)
                    .duration(160)
                    .buildAndRegister();

            //  Nitrophenols
            //  Why this recipe use chemical reactor not centrifuge?
            GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES, Nitrophenols.getFluid(1000));
            GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES, Nitrophenols.getFluid(1000));


            CENTRIFUGE_RECIPES.recipeBuilder()
                    .fluidInputs(Nitrophenols.getFluid(1000))
                    .outputs(IVNitrophenol.getItemStack(15))
                    .outputs(IINitrophenol.getItemStack(15))
                    .EUt(VA[HV])
                    .duration(10)
                    .buildAndRegister();

            //  todo Use of 2-Nitrophenol

            //  Fungal Rennet Solution
            //  Please use Bio Reactor recipe!
            GTRecipeHandler.removeRecipesByInputs(MIXER_RECIPES,
                    new ItemStack[]{PenicilliumRoqueforti.getItemStack()},
                    new FluidStack[]{LacticAcidBacteria.getFluid(1), CrudeRennetSolution.getFluid(250)});

            BIO_REACTOR_RECIPES.recipeBuilder()
                    .inputs(PenicilliumRoqueforti.getItemStack())
                    .fluidInputs(LacticAcidBacteria.getFluid(1))
                    .fluidInputs(CrudeRennetSolution.getFluid(250))
                    .fluidOutputs(FungalRennetSolution.getFluid(250))
                    .EUt(110)
                    .duration(120)
                    .buildAndRegister();

        }

    }

}