package magicbook.gtlitecore.common.covers;

import gregtech.api.GTValues;
import gregtech.api.cover.CoverDefinition;
import gregtech.api.items.behavior.CoverItemBehavior;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.common.covers.CoverConveyor;
import gregtech.common.covers.CoverPump;
import gregtech.common.covers.CoverRoboticArm;
import gregtech.common.covers.CoverSolarPanel;
import magicbook.gtlitecore.api.GTLiteValues;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import net.minecraft.util.ResourceLocation;

public class GTLiteCoverBehavior {

    public static void init() {

        registerBehavior(new ResourceLocation(GTLiteValues.MODID, "pump.ulv"), GTLiteMetaItems.ELECTRIC_PUMP_ULV,
                (def, tile, side) -> new CoverPump(def, tile, side, GTValues.ULV, 320));
        registerBehavior(new ResourceLocation(GTLiteValues.MODID, "conveyor.ulv"), GTLiteMetaItems.CONVEYOR_MODULE_ULV,
                (def, tile, side) -> new CoverConveyor(def, tile, side, GTValues.ULV, 4));
        registerBehavior(new ResourceLocation(GTLiteValues.MODID, "robot_arm.ulv"), GTLiteMetaItems.ROBOT_ARM_ULV,
                (def, tile, side) -> new CoverRoboticArm(def, tile, side, GTValues.ULV, 4));
        registerBehavior(new ResourceLocation(GTLiteValues.MODID, "pump.max"), GTLiteMetaItems.ELECTRIC_PUMP_MAX,
                (def, tile, side) -> new CoverPump(def, tile, side, GTValues.MAX, 1048576));
        registerBehavior(new ResourceLocation(GTLiteValues.MODID, "conveyor.max"), GTLiteMetaItems.CONVEYOR_MODULE_MAX,
                (def, tile, side) -> new CoverConveyor(def, tile, side, GTValues.MAX, 1024));
        registerBehavior(new ResourceLocation(GTLiteValues.MODID, "robot_arm.max"), GTLiteMetaItems.ROBOT_ARM_MAX,
                (def, tile, side) -> new CoverRoboticArm(def, tile, side, GTValues.MAX, 1024));
        registerBehavior(new ResourceLocation(GTLiteValues.MODID,  "solar_panel.max"), GTLiteMetaItems.COVER_SOLAR_PANEL_MAX,
                (def, tile, side) -> new CoverSolarPanel(def, tile, side, GTValues.V[GTValues.MAX]));
    }

    /**
     * Used to register cover behavior.
     *
     * <p>
     *     Please pre init item in {@link GTLiteMetaItems},
     *     and use {@link gregtech.api.items.metaitem.MetaItem.MetaValueItem#addComponents} to add tooltips.
     * </p>
     *
     * @param coverId          Resource Location of cover, please use modid of gtlitecore (please see: {@link GTLiteValues#MODID}, do not use value in mod main class).
     * @param placerItem       Set which item has this cover behavior.
     * @param behaviorCreator  Definition of cover, use lambda to define a cover (you can see some example at gregtech/common/covers).
     */
    @SuppressWarnings("rawtypes")
    public static void registerBehavior(ResourceLocation coverId,
                                        MetaItem.MetaValueItem placerItem,
                                        CoverDefinition.CoverCreator behaviorCreator) {
        CoverDefinition coverDefinition = gregtech.common.covers.CoverBehaviors.registerCover(coverId, placerItem.getStackForm(), behaviorCreator);
        placerItem.addComponents(new CoverItemBehavior(coverDefinition));
    }
}
