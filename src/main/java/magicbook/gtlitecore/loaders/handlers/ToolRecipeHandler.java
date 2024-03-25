package magicbook.gtlitecore.loaders.handlers;

import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IElectricItem;
import gregtech.api.items.toolitem.IGTTool;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.properties.ToolProperty;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.common.items.GTLiteTools;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import javax.annotation.Nonnull;

import static gregtech.api.unification.material.properties.PropertyKey.GEM;
import static gregtech.common.items.MetaItems.*;

public class ToolRecipeHandler {

    public static void register() {
        OrePrefix.plate.addProcessingHandler(PropertyKey.TOOL, ToolRecipeHandler::processTool);
    }

    private static void processTool(OrePrefix prefix, Material material, ToolProperty property) {

        UnificationEntry rod = new UnificationEntry(OrePrefix.stick, material);
        UnificationEntry plate = new UnificationEntry(OrePrefix.plate, material);
        UnificationEntry ingot = new UnificationEntry(material.hasProperty(GEM) ? OrePrefix.gem : OrePrefix.ingot, material);
        UnificationEntry spring = new UnificationEntry(OrePrefix.spring, material);
        UnificationEntry screw = new UnificationEntry(OrePrefix.screw, material);

        if (material.hasFlag(MaterialFlags.GENERATE_PLATE) && !material.hasFlag(MaterialFlags.NO_SMASHING)) {

            //  Combination Wrench
            addToolRecipe(material, GTLiteTools.COMBINATION_WRENCH, true,
                    "PhP", "IPI", "fP ",
                    'I', ingot,
                    'P', plate);

            if (material.hasFlag(MaterialFlags.GENERATE_ROD)) {

                //  Universal Spade
                addToolRecipe(material, GTLiteTools.UNIVERSAL_SPADE, true,
                        "hPP", "DRP", "RDf",
                        'P', plate,
                        'D', new UnificationEntry(OrePrefix.dye, MarkerMaterials.Color.Blue),
                        'R', rod);

                //  Electric Jackhammer (LV)
                if (property.getToolDurability() > 0) {
                    ItemStack[] powerUnits = {
                            POWER_UNIT_LV.getMaxChargeOverrideStack(100000L)
                    };

                    for (int i = 0; i < powerUnits.length; i++) {
                        IElectricItem powerUnit = powerUnits[i].getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
                        ItemStack toolItem = null;
                        if (powerUnit != null) {
                            toolItem = GTLiteTools.ELECTRIC_JACKHAMMER_LV.get(material, 0, powerUnit.getMaxCharge());
                        }
                        if (toolItem != null) {
                            ModHandler.addShapedEnergyTransferRecipe(String.format("%s_%s", "electric_jackhammer.lv", material, i),
                                    toolItem,
                                    Ingredient.fromStacks(powerUnits[i]), true, true,
                                    "YRf", "PSP", "XPH",
                                    'R', rod,
                                    'P', plate,
                                    'S', spring,
                                    'Y', screw,
                                    'H', powerUnits[i],
                                    'X', ELECTRIC_PISTON_LV);
                        }
                    }
                }

                //  Electric Jackhammer (HV)
                if (property.getToolDurability() > 0) {
                    ItemStack[] powerUnits = {
                            POWER_UNIT_HV.getMaxChargeOverrideStack(1600000L)
                    };

                    for (int i = 0; i < powerUnits.length; i++) {
                        IElectricItem powerUnit = powerUnits[i].getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
                        ItemStack toolItem = null;
                        if (powerUnit != null) {
                            toolItem = GTLiteTools.ELECTRIC_JACKHAMMER_HV.get(material, 0, powerUnit.getMaxCharge());
                        }

                        if (toolItem != null) {
                            ModHandler.addShapedEnergyTransferRecipe(String.format("%s_%s", "electric_jackhammer.hv", material, i),
                                    toolItem,
                                    Ingredient.fromStacks(powerUnits[i]), true, true,
                                    "YRf", "PSP", "XPH",
                                    'R', rod,
                                    'P', plate,
                                    'S', spring,
                                    'Y', screw,
                                    'H', powerUnits[i],
                                    'X', ELECTRIC_PISTON_HV);
                        }
                    }
                }

                //  Electric Jackhammer (IV)
                if (property.getToolDurability() > 0) {
                    ItemStack[] powerUnits = {
                            POWER_UNIT_IV.getMaxChargeOverrideStack(25600000L)
                    };

                    for (int i = 0; i < powerUnits.length; i++) {
                        IElectricItem powerUnit = powerUnits[i].getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
                        ItemStack toolItem = null;
                        if (powerUnit != null) {
                            toolItem = GTLiteTools.ELECTRIC_JACKHAMMER_IV.get(material, 0, powerUnit.getMaxCharge());
                        }

                        if (toolItem != null) {
                            ModHandler.addShapedEnergyTransferRecipe(String.format("%s_%s", "electric_jackhammer.iv", material, i),
                                    toolItem,
                                    Ingredient.fromStacks(powerUnits[i]), true, true,
                                    "YRf", "PSP", "XPH",
                                    'R', rod,
                                    'P', plate,
                                    'S', spring,
                                    'Y', screw,
                                    'H', powerUnits[i],
                                    'X', ELECTRIC_PISTON_IV);
                        }
                    }
                }
            }

            //  Vajra
            if (property.getToolDurability() > 0) {
                ItemStack[] powerUnits = {
                        POWER_UNIT_EV.getMaxChargeOverrideStack(6400000L)
                };

                for (int i = 0; i < powerUnits.length; i++) {
                    IElectricItem powerUnit = powerUnits[i].getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
                    ItemStack toolItem = null;
                    if (powerUnit != null) {
                        toolItem = GTLiteTools.VAJRA.get(material, 0, powerUnit.getMaxCharge());
                    }

                    if (toolItem != null) {
                        ModHandler.addShapedEnergyTransferRecipe(String.format("%s_%s", "vajra", material, i),
                                toolItem,
                                Ingredient.fromStacks(powerUnits[i]), true, true,
                                "GEh",
                                           "EFP",
                                           "wPH",
                                'H', powerUnits[i],
                                'F', FIELD_GENERATOR_EV,
                                'G', COMPONENT_GRINDER_TUNGSTEN,
                                'E', ENERGIUM_CRYSTAL,
                                'P', plate
                        );
                    }
                }
            }

        }
    }

    public static void addToolRecipe(@Nonnull Material material,
                                     @Nonnull IGTTool tool,
                                     boolean mirrored, Object... recipe) {
        if (mirrored) {
            ModHandler.addMirroredShapedRecipe(String.format("%s_%s", tool.getToolId(), material),
                    tool.get(material), recipe);
        } else {
            ModHandler.addShapedRecipe(String.format("%s_%s", tool.getToolId(), material),
                    tool.get(material), recipe);
        }
    }
}
