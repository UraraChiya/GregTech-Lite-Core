package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockSteamCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class Machines {

    public static void init() {
        SteamStageMachines();
    }

    /**
     * Override of Steam Stage Machines
     *
     * <p>
     *     In modpack environment, player needs craft ULV components to make steam stage machines.
     * </p>
     */
    private static void SteamStageMachines() {
        if (GTLiteConfigHolder.machines.enableHarderSteamStageMachine) {

            //  Steam Coal Boiler
            ModHandler.removeRecipeByName("gregtech:steam_boiler_coal_bronze");
            ModHandler.addShapedRecipe(true, "steam_boiler_coal_bronze", MetaTileEntities.STEAM_BOILER_COAL_BRONZE.getStackForm(),
                    "PPP", "CHC", "BFB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_BRICKS_HULL),
                    'C', CONVEYOR_MODULE_ULV,
                    'P', new UnificationEntry(plate, Bronze),
                    'B', new UnificationEntry(block, Brick),
                    'F', "craftingFurnace");

            //  High Pressure Steam Coal Boiler
            ModHandler.removeRecipeByName("gregtech:steam_boiler_coal_steel");
            ModHandler.addShapedRecipe(true, "steam_boiler_coal_steel", MetaTileEntities.STEAM_BOILER_COAL_STEEL.getStackForm(),
                    "PPP", "RHC", "BFB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_BRICKS_HULL),
                    'C', CONVEYOR_MODULE_ULV,
                    'R', ROBOT_ARM_ULV,
                    'P', new UnificationEntry(plate, Steel),
                    'B', new UnificationEntry(block, Brick),
                    'F', "craftingFurnace");

            //  Steam Solar Boiler
            ModHandler.removeRecipeByName("gregtech:steam_boiler_solar_bronze");
            ModHandler.addShapedRecipe(true, "steam_boiler_solar_bronze", MetaTileEntities.STEAM_BOILER_SOLAR_BRONZE.getStackForm(),
                    "PPP", "CHU", "BAB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_BRICKS_HULL),
                    'C', CONVEYOR_MODULE_ULV,
                    'U', ELECTRIC_PUMP_ULV,
                    'P', new UnificationEntry(plate, Bronze),
                    'B', new UnificationEntry(block, Brick),
                    'A', new UnificationEntry(pipeSmallFluid, Bronze));

            //  High Pressure Steam Solar Boiler
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

            //  Steam Lava Boiler
            ModHandler.removeRecipeByName("gregtech:steam_boiler_lava_bronze");
            ModHandler.addShapedRecipe(true, "steam_boiler_lava_bronze", MetaTileEntities.STEAM_BOILER_LAVA_BRONZE.getStackForm(),
                    "PPP", "UHU", "BAB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_BRICKS_HULL),
                    'U', ELECTRIC_PUMP_ULV,
                    'P', new UnificationEntry(plate, Bronze),
                    'B', new UnificationEntry(block, Brick),
                    'A', new UnificationEntry(pipeSmallFluid, Bronze));

            //  High Pressure Steam Lava Boiler
            ModHandler.removeRecipeByName("gregtech:steam_boiler_lava_steel");
            ModHandler.addShapedRecipe(true, "steam_boiler_lava_steel", MetaTileEntities.STEAM_BOILER_LAVA_STEEL.getStackForm(),
                    "PPP", "UHR", "BAB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_BRICKS_HULL),
                    'U', ELECTRIC_PUMP_ULV,
                    'R', ROBOT_ARM_ULV,
                    'P', new UnificationEntry(plate, Steel),
                    'B', new UnificationEntry(block, Brick),
                    'A', new UnificationEntry(pipeSmallFluid, TinAlloy));

            //  Steam Macerator
            ModHandler.removeRecipeByName("gregtech:steam_macerator_bronze");
            ModHandler.addShapedRecipe(true, "steam_macerator_bronze", MetaTileEntities.STEAM_MACERATOR_BRONZE.getStackForm(),
                    "IMG", "PPC", "RRP",
                    'C', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_HULL),
                    'P', new UnificationEntry(pipeTinyFluid, Bronze),
                    'G', new UnificationEntry(gem, Diamond),
                    'I', ELECTRIC_PISTON_ULV,
                    'M', ELECTRIC_MOTOR_ULV,
                    'R', new UnificationEntry(plate, Bronze));

            //  High Pressure Steam Macerator
            ModHandler.removeRecipeByName("gregtech:steam_macerator_steel");
            ModHandler.addShapedRecipe(true, "steam_macerator_steel", MetaTileEntities.STEAM_MACERATOR_STEEL.getStackForm(),
                    "IMG", "PPC", "RRP",
                    'C', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_HULL),
                    'P', new UnificationEntry(pipeTinyFluid, TinAlloy),
                    'G', new UnificationEntry(gem, Diamond),
                    'I', ELECTRIC_PISTON_ULV,
                    'M', ELECTRIC_MOTOR_ULV,
                    'R', new UnificationEntry(plate, Steel));

            //  Steam Compressor
            ModHandler.removeRecipeByName("gregtech:steam_compressor_bronze");
            ModHandler.addShapedRecipe(true, "steam_compressor_bronze", MetaTileEntities.STEAM_COMPRESSOR_BRONZE.getStackForm(),
                    " R ", "PCP", "TRT",
                    'R', new UnificationEntry(plate, Bronze),
                    'C', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_HULL),
                    'P', ELECTRIC_PISTON_ULV,
                    'T', new UnificationEntry(pipeTinyFluid, Bronze));

            //  High Pressure Steam Compressor
            ModHandler.removeRecipeByName("gregtech:steam_compressor_steel");
            ModHandler.addShapedRecipe(true, "steam_compressor_steel", MetaTileEntities.STEAM_COMPRESSOR_STEEL.getStackForm(),
                    " R ", "PCP", "TRT",
                    'R', new UnificationEntry(plate, Steel),
                    'C', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_HULL),
                    'P', ELECTRIC_PISTON_ULV,
                    'T', new UnificationEntry(pipeTinyFluid, TinAlloy));

            //  Steam Alloy Smelter
            ModHandler.removeRecipeByName("gregtech:steam_alloy_smelter_bronze");
            ModHandler.addShapedRecipe(true, "steam_alloy_smelter_bronze", MetaTileEntities.STEAM_ALLOY_SMELTER_BRONZE.getStackForm(),
                    "RWR", "WCW", "TWT",
                    'C', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_BRICKS_HULL),
                    'W', new UnificationEntry(wireGtQuadruple, Lead),
                    'T', new UnificationEntry(pipeTinyFluid, Bronze),
                    'R', new UnificationEntry(plate, Bronze));

            //  High Pressure Steam Alloy Smelter
            ModHandler.removeRecipeByName("gregtech:steam_alloy_smelter_steel");
            ModHandler.addShapedRecipe(true, "steam_alloy_smelter_steel", MetaTileEntities.STEAM_ALLOY_SMELTER_STEEL.getStackForm(),
                    "RWR", "WCW", "TWT",
                    'C', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_BRICKS_HULL),
                    'W', new UnificationEntry(wireGtQuadruple, Lead),
                    'T', new UnificationEntry(pipeTinyFluid, TinAlloy),
                    'R', new UnificationEntry(plate, Steel));

            //  Steam Furnace
            ModHandler.removeRecipeByName("gregtech:steam_furnace_bronze");
            ModHandler.addShapedRecipe(true, "steam_furnace_bronze", MetaTileEntities.STEAM_FURNACE_BRONZE.getStackForm(),
                    "RWR", "WCW", "TWT",
                    'C', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_BRICKS_HULL),
                    'W', new UnificationEntry(wireGtDouble, Lead),
                    'T', new UnificationEntry(pipeTinyFluid, Bronze),
                    'R', new UnificationEntry(plate, Bronze));

            //  High Pressure Steam Furnace
            ModHandler.removeRecipeByName("gregtech:steam_furnace_steel");
            ModHandler.addShapedRecipe(true, "steam_furnace_steel", MetaTileEntities.STEAM_FURNACE_STEEL.getStackForm(),
                    "RWR", "WCW", "TWT",
                    'C', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_BRICKS_HULL),
                    'W', new UnificationEntry(wireGtDouble, Lead),
                    'T', new UnificationEntry(pipeTinyFluid, TinAlloy),
                    'R', new UnificationEntry(plate, Steel));

            //  Steam Hammer
            ModHandler.removeRecipeByName("gregtech:steam_hammer_bronze");
            ModHandler.addShapedRecipe(true, "steam_hammer_bronze", MetaTileEntities.STEAM_HAMMER_BRONZE.getStackForm(),
                    "TPT", "RCR", "TXT",
                    'C', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_HULL),
                    'P', ELECTRIC_PISTON_ULV,
                    'X', "craftingAnvil",
                    'T', new UnificationEntry(pipeTinyFluid, Bronze),
                    'R', new UnificationEntry(plate, Bronze));

            //  High Pressure Steam Hammer
            ModHandler.removeRecipeByName("gregtech:steam_hammer_steel");
            ModHandler.addShapedRecipe(true, "steam_hammer_steel", MetaTileEntities.STEAM_HAMMER_STEEL.getStackForm(),
                    "TPT", "RCR", "TXT",
                    'C', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_HULL),
                    'P', ELECTRIC_PISTON_ULV,
                    'X', "craftingAnvil",
                    'T', new UnificationEntry(pipeTinyFluid, TinAlloy),
                    'R', new UnificationEntry(plate, Steel));

            //  Steam Rock Breaker
            ModHandler.removeRecipeByName("gregtech:steam_rock_breaker_bronze");
            ModHandler.addShapedRecipe(true, "steam_rock_breaker_bronze", MetaTileEntities.STEAM_ROCK_BREAKER_BRONZE.getStackForm(),
                    "IMD", "TCT", "GGG",
                    'C', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_HULL),
                    'T', new UnificationEntry(pipeTinyFluid, Bronze),
                    'I', ELECTRIC_PISTON_ULV,
                    'M', ELECTRIC_MOTOR_ULV,
                    'D', new UnificationEntry(gem, Diamond),
                    'G', new ItemStack(Blocks.GLASS));

            //  High Pressure Steam Rock Breaker
            ModHandler.removeRecipeByName("gregtech:steam_rock_breaker_steel");
            ModHandler.addShapedRecipe(true, "steam_rock_breaker_steel", MetaTileEntities.STEAM_ROCK_BREAKER_STEEL.getStackForm(),
                    "IMD", "TCT", "GGG",
                    'C', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_HULL),
                    'T', new UnificationEntry(pipeTinyFluid, TinAlloy),
                    'I', ELECTRIC_PISTON_ULV,
                    'M', ELECTRIC_MOTOR_ULV,
                    'D', new UnificationEntry(gem, Diamond),
                    'G', new ItemStack(Blocks.GLASS));

            //  Steam Extractor
            ModHandler.removeRecipeByName("gregtech:steam_extractor_bronze");
            ModHandler.addShapedRecipe(true, "steam_extractor_bronze", MetaTileEntities.STEAM_EXTRACTOR_BRONZE.getStackForm(),
                    "GRG", "SHP", "TRT",
                    'G', new ItemStack(Blocks.GLASS),
                    'R', new UnificationEntry(plate, Bronze),
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_HULL),
                    'S', ELECTRIC_PISTON_ULV,
                    'P', ELECTRIC_PUMP_ULV,
                    'T', new UnificationEntry(pipeTinyFluid, Bronze));

            //  High Pressure Extractor
            ModHandler.removeRecipeByName("gregtech:steam_extractor_steel");
            ModHandler.addShapedRecipe(true, "steam_extractor_steel", MetaTileEntities.STEAM_EXTRACTOR_STEEL.getStackForm(),
                    "GRG", "SHP", "TRT",
                    'G', new ItemStack(Blocks.GLASS),
                    'R', new UnificationEntry(plate, Steel),
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_HULL),
                    'S', ELECTRIC_PISTON_ULV,
                    'P', ELECTRIC_PUMP_ULV,
                    'T', new UnificationEntry(pipeTinyFluid, TinAlloy));

            //  Steam Miner
            ModHandler.removeRecipeByName("gregtech:steam_miner");
            ModHandler.addShapedRecipe(true, "steam_miner", MetaTileEntities.STEAM_MINER.getStackForm(),
                    "MMM", "PHP", "XSX",
                    'M', ELECTRIC_MOTOR_ULV,
                    'P', new UnificationEntry(pipeTinyFluid, Bronze),
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_HULL),
                    'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV),
                    'S', SENSOR_ULV);

        }
    }
}
