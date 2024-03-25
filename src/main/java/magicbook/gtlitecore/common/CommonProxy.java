package magicbook.gtlitecore.common;

import gregtech.api.GregTechAPI;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.cover.CoverDefinition;
import gregtech.api.recipes.recipeproperties.FusionEUToStartProperty;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.loaders.recipe.CraftingComponent;
import magicbook.gtlitecore.GTLiteCore;
import magicbook.gtlitecore.api.recipe.properties.AssemblyCasingTierProperty;
import magicbook.gtlitecore.api.recipe.properties.ComponentCasingTierProperty;
import magicbook.gtlitecore.api.recipe.properties.FieldCasingTierProperty;
import magicbook.gtlitecore.api.recipe.properties.SpaceElevatorCasingTierProperty;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import magicbook.gtlitecore.api.utils.ServerSupportI18n;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.covers.GTLiteCoverBehavior;
import magicbook.gtlitecore.loaders.MaterialInfoLoader;
import magicbook.gtlitecore.loaders.RecipeHandler;
import magicbook.gtlitecore.loaders.RecipeManager;
import magicbook.gtlitecore.loaders.components.MaterialComponents;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.function.Function;

import static gregtech.api.GregTechAPI.HEATING_COILS;
import static magicbook.gtlitecore.api.utils.ChatCalculatorHelper.eval;

@Mod.EventBusSubscriber(modid = GTLiteCore.MODID)
public class CommonProxy {

    public void preLoad() {}

    @SubscribeEvent
    public static void syncConfigValues(@Nonnull ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(GTLiteCore.MODID)) {
            ConfigManager.sync(GTLiteCore.MODID, Config.Type.INSTANCE);
        }
    }

    @SubscribeEvent
    public static void registerBlocks(@Nonnull RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        GTLiteLog.logger.info("Registering Blocks...");
        registry.register(GTLiteMetaBlocks.MULTIBLOCK_CASING);
        registry.register(GTLiteMetaBlocks.METAL_CASING);
        registry.register(GTLiteMetaBlocks.MACHINE_CASING);
        registry.register(GTLiteMetaBlocks.STRUCTURE_CASING);
        registry.register(GTLiteMetaBlocks.BOILER_CASING);
        registry.register(GTLiteMetaBlocks.UNIQUE_CASING);
        registry.register(GTLiteMetaBlocks.FUSION_CASING);
        registry.register(GTLiteMetaBlocks.CLEANROOM_CASING);
        registry.register(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING);
        registry.register(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING);
        registry.register(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING);
        registry.register(GTLiteMetaBlocks.PCB_FACTORY_CASING);
        registry.register(GTLiteMetaBlocks.COMPUTER_CASING);
        registry.register(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING);
        registry.register(GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING);
        registry.register(GTLiteMetaBlocks.SCIENCE_CASING);
        registry.register(GTLiteMetaBlocks.FIELD_CASING);
        registry.register(GTLiteMetaBlocks.WIRE_COIL);
        registry.register(GTLiteMetaBlocks.TRANSPARENT_CASING);
        registry.register(GTLiteMetaBlocks.EXPLOSIVE_BLOCK);
        registry.register(GTLiteMetaBlocks.CRUCIBLE);
        registry.register(GTLiteMetaBlocks.YOTTA_TANK_CELL);
        registry.register(GTLiteMetaBlocks.HERMETIC_CASING);
        registry.register(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING);
        registry.register(GTLiteMetaBlocks.COOLING_CORE);
        registry.register(GTLiteMetaBlocks.DYSON_SWARM_CASING);
        registry.register(GTLiteMetaBlocks.QUANTUM_COMPUTER_CASING);
    }

    @SubscribeEvent
    public static void registerItems(@Nonnull RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        GTLiteLog.logger.info("Registering Items...");
        registry.register(createItemBlock(GTLiteMetaBlocks.MULTIBLOCK_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.METAL_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.MACHINE_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.STRUCTURE_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.BOILER_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.UNIQUE_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.FUSION_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.CLEANROOM_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.PCB_FACTORY_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.COMPUTER_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.SCIENCE_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.FIELD_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.WIRE_COIL, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.TRANSPARENT_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.EXPLOSIVE_BLOCK, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.CRUCIBLE, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.YOTTA_TANK_CELL, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.HERMETIC_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.COOLING_CORE, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.DYSON_SWARM_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTLiteMetaBlocks.QUANTUM_COMPUTER_CASING, VariantItemBlock::new));
    }

    @Nonnull
    private static <T extends Block>ItemBlock createItemBlock(@Nonnull T block, @Nonnull Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }

    @SubscribeEvent
    public static void registerCoverBehavior(GregTechAPI.RegisterEvent<CoverDefinition> event) {
        GTLiteLog.logger.info("Registering Cover Behaviors...");
        GTLiteCoverBehavior.init();
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        GTLiteLog.logger.info("Registering recipes...");
        //  Fusion Tier extends
        FusionEUToStartProperty.registerFusionTier(9, "(MK4)");
        FusionEUToStartProperty.registerFusionTier(10, "(MK5)");
        //  Precise Assembly Tiers
        AssemblyCasingTierProperty.registerAssemblyCasingTier(1, ServerSupportI18n.format("gtlitecore.machine.precise_assembler.tier.1", "(MK1)"));
        AssemblyCasingTierProperty.registerAssemblyCasingTier(2, ServerSupportI18n.format("gtlitecore.machine.precise_assembler.tier.2", "(MK2)"));
        AssemblyCasingTierProperty.registerAssemblyCasingTier(3, ServerSupportI18n.format("gtlitecore.machine.precise_assembler.tier.3", "(MK3)"));
        AssemblyCasingTierProperty.registerAssemblyCasingTier(4, ServerSupportI18n.format("gtlitecore.machine.precise_assembler.tier.4", "(MK4)"));
        AssemblyCasingTierProperty.registerAssemblyCasingTier(5, ServerSupportI18n.format("gtlitecore.machine.precise_assembler.tier.5", "(MK5)"));
        AssemblyCasingTierProperty.registerAssemblyCasingTier(6, ServerSupportI18n.format("gtlitecore.machine.precise_assembler.tier.6", "(MK6)"));
        AssemblyCasingTierProperty.registerAssemblyCasingTier(7, ServerSupportI18n.format("gtlitecore.machine.precise_assembler.tier.7", "(MK7)"));
        AssemblyCasingTierProperty.registerAssemblyCasingTier(8, ServerSupportI18n.format("gtlitecore.machine.precise_assembler.tier.8", "(MK8)"));
        //  Component Assembly Line Tiers
        ComponentCasingTierProperty.registerComponentCasingTier(1, ServerSupportI18n.format("gtlitecore.machine.component_assembly_line.tier.1", "(LV)"));
        ComponentCasingTierProperty.registerComponentCasingTier(2, ServerSupportI18n.format("gtlitecore.machine.component_assembly_line.tier.2", "(MV)"));
        ComponentCasingTierProperty.registerComponentCasingTier(3, ServerSupportI18n.format("gtlitecore.machine.component_assembly_line.tier.3", "(HV)"));
        ComponentCasingTierProperty.registerComponentCasingTier(4, ServerSupportI18n.format("gtlitecore.machine.component_assembly_line.tier.4", "(EV)"));
        ComponentCasingTierProperty.registerComponentCasingTier(5, ServerSupportI18n.format("gtlitecore.machine.component_assembly_line.tier.5", "(IV)"));
        ComponentCasingTierProperty.registerComponentCasingTier(6, ServerSupportI18n.format("gtlitecore.machine.component_assembly_line.tier.6", "(LuV)"));
        ComponentCasingTierProperty.registerComponentCasingTier(7, ServerSupportI18n.format("gtlitecore.machine.component_assembly_line.tier.7", "(ZPM)"));
        ComponentCasingTierProperty.registerComponentCasingTier(8, ServerSupportI18n.format("gtlitecore.machine.component_assembly_line.tier.8", "(UV)"));
        ComponentCasingTierProperty.registerComponentCasingTier(9, ServerSupportI18n.format("gtlitecore.machine.component_assembly_line.tier.9", "(UHV)"));
        ComponentCasingTierProperty.registerComponentCasingTier(10, ServerSupportI18n.format("gtlitecore.machine.component_assembly_line.tier.10", "(UEV)"));
        ComponentCasingTierProperty.registerComponentCasingTier(11, ServerSupportI18n.format("gtlitecore.machine.component_assembly_line.tier.11", "(UIV)"));
        ComponentCasingTierProperty.registerComponentCasingTier(12, ServerSupportI18n.format("gtlitecore.machine.component_assembly_line.tier.12", "(UXV)"));
        ComponentCasingTierProperty.registerComponentCasingTier(13, ServerSupportI18n.format("gtlitecore.machine.component_assembly_line.tier.13", "(OpV)"));
        ComponentCasingTierProperty.registerComponentCasingTier(14, ServerSupportI18n.format("gtlitecore.machine.component_assembly_line.tier.14", "(MAX)"));
        //  Field Casing Tiers
        FieldCasingTierProperty.registerFieldCasingTier(1, "1 (ZPM)");
        FieldCasingTierProperty.registerFieldCasingTier(2, "2 (UV)");
        FieldCasingTierProperty.registerFieldCasingTier(3, "3 (UHV)");
        FieldCasingTierProperty.registerFieldCasingTier(4, "4 (UEV)");
        FieldCasingTierProperty.registerFieldCasingTier(5, "5 (UIV)");
        FieldCasingTierProperty.registerFieldCasingTier(6, "6 (UXV)");
        FieldCasingTierProperty.registerFieldCasingTier(7, "7 (OpV)");
        FieldCasingTierProperty.registerFieldCasingTier(8, "8 (MAX)");
        //  Space Elevator Tiers
        SpaceElevatorCasingTierProperty.registerSpaceElevatorCasingTier(1, "(MK1)");
        SpaceElevatorCasingTierProperty.registerSpaceElevatorCasingTier(2, "(MK2)");
        SpaceElevatorCasingTierProperty.registerSpaceElevatorCasingTier(3, "(MK3)");
        SpaceElevatorCasingTierProperty.registerSpaceElevatorCasingTier(4, "(MK4)");
        SpaceElevatorCasingTierProperty.registerSpaceElevatorCasingTier(5, "(MK5)");

        RecipeManager.init();
    }

    @SubscribeEvent
    public static void registerRecipeHandlers(RegistryEvent.Register<IRecipe> event) {
        GTLiteLog.logger.info("Registering recipe handlers...");
        RecipeHandler.init();
    }

    @SubscribeEvent
    public static void registerMaterialInfo(GregTechAPI.RegisterEvent<ItemMaterialInfo> event) {
        GTLiteLog.logger.info("Registering material infos...");
        MaterialInfoLoader.init();
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void registerMaterialComponents(GregTechAPI.RegisterEvent<CraftingComponent> event) {
        GTLiteLog.logger.info("Registering material components...");
        MaterialComponents.init();
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerWireCoil(GregTechAPI.RegisterEvent<BlockWireCoil> event) {
        GTLiteLog.logger.info("Registering wire coils...");
        for (magicbook.gtlitecore.common.blocks.BlockWireCoil.CoilType type : magicbook.gtlitecore.common.blocks.BlockWireCoil.CoilType.values()) {
            HEATING_COILS.put(GTLiteMetaBlocks.WIRE_COIL.getState(type), type);
        }
    }

    @SubscribeEvent
    public static void registerServerChatEvents(@Nonnull ServerChatEvent event) {
        String message = event.getMessage();

        if (!message.startsWith("="))
            return;

        if (event.getPlayer() == null)
            return;

        event.setCanceled(true);

        if (message.startsWith("=help")) { //  If player send =help, then return guide of this function.
            for (int i = 1; i <= 12; i++) {
                event.getPlayer().sendMessage(new TextComponentTranslation(String.format("gtlitecore.chat_calculator.help.%s", i), i == 3 ? new TextComponentString("%").setStyle(new Style().setColor(TextFormatting.AQUA)) : new TextComponentString[]{}));
            }
        } else {
            double result; // calculate result
            String stripped = message.substring(1); // strip the = sign
            String[] split = stripped.split(","); // split into expression and args

            event.getPlayer().sendMessage(new TextComponentString(stripped).setStyle(new Style().setColor(TextFormatting.AQUA))); // send the input to only the player
            try {
                result = eval(split[0].toLowerCase(), event.getPlayer());
            } catch (Exception e) {
                // send the error to the player
                event.getPlayer().sendMessage(new TextComponentString(e.getMessage()).setStyle(new Style().setColor(TextFormatting.RED)));
                return;
            }

            // parse arguments
            int decimalPlaces = 3;
            for (int i = 1; i < split.length; i++) {
                String arg = split[i];
                String value = arg.split("=")[1];
                if (arg.startsWith("places")) decimalPlaces = Integer.parseInt(value.replaceAll("\\s", ""));
            }

            // format output
            DecimalFormat formatter = new DecimalFormat("#.###");
            formatter.setMaximumFractionDigits(decimalPlaces);
            String formatted = formatter.format(result);

            // return output
            event.getPlayer().sendMessage(new TextComponentString(formatted).setStyle(new Style().setColor(TextFormatting.GRAY)));
        }
    }

}