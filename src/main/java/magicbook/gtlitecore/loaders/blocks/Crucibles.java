package magicbook.gtlitecore.loaders.blocks;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import magicbook.gtlitecore.common.blocks.BlockCrucible;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.HexagonalBoronNitride;

public class Crucibles {
    public static void init() {

        if (GTLiteConfigHolder.recipes.enableHarderCrucible) {
            //  Bronze Crucible (1696 K, Steam stage)
            VACUUM_CHAMBER_RECIPES.recipeBuilder()
                    .input(plate, Bronze, 5)
                    .circuitMeta(5)
                    .fluidInputs(Tin.getFluid(L * 4))
                    .outputs(GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.BRONZE_CRUCIBLE))
                    .EUt(VA[ULV])
                    .duration(1200)
                    .buildAndRegister();

            //  Invar Crucible (2395 K, LV stage)
            VACUUM_CHAMBER_RECIPES.recipeBuilder()
                    .input(plate, Invar, 5)
                    .circuitMeta(5)
                    .fluidInputs(TinAlloy.getFluid(L * 4))
                    .outputs(GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.INVAR_CRUCIBLE))
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            //  Quartzite Crucible (2482 K, MV stage)
            VACUUM_CHAMBER_RECIPES.recipeBuilder()
                    .input(plate, Quartzite, 5)
                    .circuitMeta(5)
                    .fluidInputs(SolderingAlloy.getFluid(L * 4))
                    .outputs(GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.QUARTZ_CRUCIBLE))
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            //  Chrome Crucible (2725 K, HV stage)
            VACUUM_CHAMBER_RECIPES.recipeBuilder()
                    .input(plate, Chrome, 5)
                    .circuitMeta(5)
                    .fluidInputs(Steel.getFluid(L * 4))
                    .outputs(GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.CHROME_CRUCIBLE))
                    .EUt(VA[HV])
                    .duration(1200)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();

            //  Vanadium Crucible (2728 K, EV Stage)
            VACUUM_CHAMBER_RECIPES.recipeBuilder()
                    .input(plate, Vanadium, 5)
                    .circuitMeta(5)
                    .fluidInputs(Aluminium.getFluid(L * 4))
                    .outputs(GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.VANADIUM_CRUCIBLE))
                    .EUt(VA[EV])
                    .duration(1200)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();

            //  Niobium Titanium Crucible (2931 K, EV Stage)
            VACUUM_CHAMBER_RECIPES.recipeBuilder()
                    .input(plate, NiobiumTitanium, 5)
                    .circuitMeta(5)
                    .fluidInputs(Aluminium.getFluid(L * 4))
                    .outputs(GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.NIOBIUM_TITANIUM_CRUCIBLE))
                    .EUt(VA[EV])
                    .duration(1200)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();

            //  Iridium Crucible (3398 K, IV Stage)
            VACUUM_CHAMBER_RECIPES.recipeBuilder()
                    .input(plate, Iridium, 5)
                    .circuitMeta(5)
                    .fluidInputs(StainlessSteel.getFluid(L * 4))
                    .outputs(GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.IRIDIUM_CRUCIBLE))
                    .EUt(VA[IV])
                    .duration(1200)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();

            //  Molybdenum Crucible (3620 K, IV Stage)
            VACUUM_CHAMBER_RECIPES.recipeBuilder()
                    .input(plate, Molybdenum, 5)
                    .circuitMeta(5)
                    .fluidInputs(StainlessSteel.getFluid(L * 4))
                    .outputs(GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.MOLYBDENUM_CRUCIBLE))
                    .EUt(VA[IV])
                    .duration(1200)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();

            //  Tungsten Crucible (3695 K, LuV Stage)
            VACUUM_CHAMBER_RECIPES.recipeBuilder()
                    .input(plate, Tungsten, 5)
                    .circuitMeta(5)
                    .fluidInputs(Titanium.getFluid(L * 4))
                    .outputs(GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.TUNGSTEN_CRUCIBLE))
                    .EUt(VA[LuV])
                    .duration(1200)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();

            //  Osmium Crucible (4132 K, LuV Stage)
            VACUUM_CHAMBER_RECIPES.recipeBuilder()
                    .input(plate, Osmium, 5)
                    .circuitMeta(5)
                    .fluidInputs(Titanium.getFluid(L * 4))
                    .outputs(GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.OSMIUM_CRUCIBLE))
                    .EUt(VA[LuV])
                    .duration(1200)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();

            //  Graphene Crucible (4750 K, ZPM Stage)
            VACUUM_CHAMBER_RECIPES.recipeBuilder()
                    .input(plate, Graphene, 5)
                    .circuitMeta(5)
                    .fluidInputs(TungstenSteel.getFluid(L * 4))
                    .outputs(GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.GRAPHITE_CRUCIBLE))
                    .EUt(VA[ZPM])
                    .duration(1200)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();

            //  Boron Nitride Crucibles (5328 K, UV Stage)
            VACUUM_CHAMBER_RECIPES.recipeBuilder()
                    .input(plate, HexagonalBoronNitride, 5)
                    .fluidInputs(RhodiumPlatedPalladium.getFluid(L * 2))
                    .circuitMeta(5)
                    .outputs(GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.BORON_NITRIDE_CRUCIBLE))
                    .EUt(VA[UV])
                    .duration(1200)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
        } else {

            //  Bronze Crucible (1696 K)
            ModHandler.addShapedRecipe(true, "bronze_crucible", GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.BRONZE_CRUCIBLE),
                    "P P", "PhP", "PPP",
                    'P', new UnificationEntry(plate, Bronze));

            //  Invar Crucible (2395 K)
            ModHandler.addShapedRecipe(true, "invar_crucible", GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.INVAR_CRUCIBLE),
                    "P P", "PhP", "PPP",
                    'P', new UnificationEntry(plate, Invar));

            //  Quartzite Crucible (2482 K)
            ModHandler.addShapedRecipe(true, "quartzite_crucible", GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.QUARTZ_CRUCIBLE),
                    "P P", "PhP", "PPP",
                    'P', new UnificationEntry(plate, Quartzite));

            //  Chrome Crucible (2725 K)
            ModHandler.addShapedRecipe(true, "chrome_crucible", GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.CHROME_CRUCIBLE),
                    "P P", "PhP", "PPP",
                    'P', new UnificationEntry(plate, Chrome));

            //  Vanadium Crucible (2728 K)
            ModHandler.addShapedRecipe(true, "vanadium_crucible", GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.VANADIUM_CRUCIBLE),
                    "P P", "PhP", "PPP",
                    'P', new UnificationEntry(plate, Vanadium));

            //  Niobium Titanium Crucible (2931 K)
            ModHandler.addShapedRecipe(true, "niobium_titanium_crucible", GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.NIOBIUM_TITANIUM_CRUCIBLE),
                    "P P", "PhP", "PPP",
                    'P', new UnificationEntry(plate, NiobiumTitanium));

            //  Iridium Crucible (3398 K)
            ModHandler.addShapedRecipe(true, "iridium_crucible", GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.IRIDIUM_CRUCIBLE),
                    "P P", "PhP", "PPP",
                    'P', new UnificationEntry(plate, Iridium));

            //  Molybdenum Crucible (3620 K)
            ModHandler.addShapedRecipe(true, "molybdenum_crucible", GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.MOLYBDENUM_CRUCIBLE),
                    "P P", "PhP", "PPP",
                    'P', new UnificationEntry(plate, Molybdenum));

            //  Tungsten Crucible (3695 K)
            ModHandler.addShapedRecipe(true, "tungsten_crucible", GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.TUNGSTEN_CRUCIBLE),
                    "P P", "PhP", "PPP",
                    'P', new UnificationEntry(plate, Tungsten));

            //  Osmium Crucible (4132 K)
            ModHandler.addShapedRecipe(true, "osmium_crucible", GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.OSMIUM_CRUCIBLE),
                    "P P", "PhP", "PPP",
                    'P', new UnificationEntry(plate, Osmium));

            //  Graphene Crucible (4750 K)
            ModHandler.addShapedRecipe(true, "graphene_crucible", GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.GRAPHITE_CRUCIBLE),
                    "P P", "PhP", "PPP",
                    'P', new UnificationEntry(plate, Graphene));

            //  Boron Nitride Crucibles (5328 K)
            ModHandler.addShapedRecipe(true, "boron_nitride_crucibles", GTLiteMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.BORON_NITRIDE_CRUCIBLE),
                    "P P", "PhP", "PPP",
                    'P', new UnificationEntry(plate, HexagonalBoronNitride));
        }
    }
}