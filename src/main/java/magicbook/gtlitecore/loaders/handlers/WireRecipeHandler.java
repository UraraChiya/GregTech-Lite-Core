package magicbook.gtlitecore.loaders.handlers;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.properties.WireProperties;
import gregtech.api.unification.ore.OrePrefix;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;

import static gregtech.api.recipes.RecipeMaps.EXTRUDER_RECIPES;
import static gregtech.api.unification.ore.OrePrefix.wireGtSingle;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getVoltageMultiplier;

public class WireRecipeHandler {

    public static void register() {
        wireGtSingle.addProcessingHandler(PropertyKey.WIRE, WireRecipeHandler::processWireSingle);
    }

    /**
     * Processing single wire by Exotic wire extruder.
     *
     * <p>
     *     <ul>
     *         <li>Energy Consumed: {@code getVoltageMultiplier(material) * 6} -> {@code getVoltageMultiplier(material) * 3}.</li>
     *         <li>Duration: {@code material.getMass() * 2} -> {@code 10 tick}</li>
     *     </ul>
     * </p>
     */
    public static void processWireSingle(OrePrefix wirePrefix, Material material, WireProperties property) {
        OrePrefix prefix = material.hasProperty(PropertyKey.INGOT) ? OrePrefix.ingot : material.hasProperty(PropertyKey.GEM) ? OrePrefix.gem : OrePrefix.dust;
        EXTRUDER_RECIPES.recipeBuilder()
                .input(prefix, material)
                .notConsumable(GTLiteMetaItems.EXOTIC_SHAPE_EXTRUDER_WIRE)
                .output(wireGtSingle, material, 2)
                .EUt(getVoltageMultiplier(material) * 3)
                .duration(10)
                .buildAndRegister();
    }

}
