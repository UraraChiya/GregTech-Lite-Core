package magicbook.gtlitecore.common.covers;

import gregtech.api.GTValues;
import gregtech.api.cover.CoverDefinition;
import gregtech.api.items.behavior.CoverItemBehavior;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.common.covers.*;

import static magicbook.gtlitecore.api.utils.GTLiteUtils.gtliteId;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class GTLiteCoverBehavior {

    public static void init() {
        registerBehavior("pump.ulv",       ELECTRIC_PUMP_ULV,      (def, tile, side) -> new CoverPump(def, tile, side, GTValues.ULV, 320));
        registerBehavior("conveyor.ulv",   CONVEYOR_MODULE_ULV,    (def, tile, side) -> new CoverConveyor(def, tile, side, GTValues.ULV, 4));
        registerBehavior("robot_arm.ulv",  ROBOT_ARM_ULV,          (def, tile, side) -> new CoverRoboticArm(def, tile, side, GTValues.ULV, 4));
        registerBehavior("pump.max",       ELECTRIC_PUMP_MAX,      (def, tile, side) -> new CoverPump(def, tile, side, GTValues.MAX, 1048576));
        registerBehavior("conveyor.max",   CONVEYOR_MODULE_MAX,    (def, tile, side) -> new CoverConveyor(def, tile, side, GTValues.MAX, 1024));
        registerBehavior("robot_arm.max",  ROBOT_ARM_MAX,          (def, tile, side) -> new CoverRoboticArm(def, tile, side, GTValues.MAX, 1024));
        registerBehavior("solar_panel.max", COVER_SOLAR_PANEL_MAX, (def, tile, side) -> new CoverSolarPanel(def, tile, side, GTValues.V[GTValues.MAX]));
    }

    /**
     * Used to register Cover Behavior to Meta Item.
     *
     * <p>
     *     Register {@link CoverBehaviors} to Meta Item.
     *     This method used internal {@code ResourceLocation} to package original method,
     *     when use this method to register, {@code ResouceLocation} of behavior is always in {@code gtlitecore}.
     * </p>
     *
     * @param name             Behavior name.
     * @param placerItem       Meta Item which this Cover correspondenced.
     * @param behaviorCreator  Cover Creater which you want this behavior actioned.
     */
    public static void registerBehavior(String name,
                                        MetaItem<?>.MetaValueItem placerItem,
                                        CoverDefinition.CoverCreator behaviorCreator) {
        CoverDefinition coverDefinition = CoverBehaviors.registerCover(gtliteId(name), placerItem.getStackForm(), behaviorCreator);
        placerItem.addComponents(new CoverItemBehavior(coverDefinition));
    }
}
