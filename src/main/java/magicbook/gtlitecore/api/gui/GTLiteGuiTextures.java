package magicbook.gtlitecore.api.gui;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.resources.SteamTexture;
import gregtech.api.gui.resources.TextureArea;

/**
 * Gui Textures of gtlitecore
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     Used to load Gui Textures like overlay, progress bar,
 *     button, logo and icon, same as {@link GuiTextures}.
 * </p>
 *
 * @since 2.8.7-beta
 */
public class GTLiteGuiTextures {

    //  Steam Overlay
    public static final SteamTexture FLUID_SLOT_STEAM = SteamTexture.fullImage("textures/gui/base/fluid_slot_%s.png");
    public static final SteamTexture INT_CIRCUIT_OVERLAY_STEAM = SteamTexture.fullImage("textures/gui/overlay/int_circuit_overlay_%s.png");

    //  Progress Bar
    public static final TextureArea PROGRESS_BAR_NANOSCALE = TextureArea.fullImage("textures/gui/progress_bar/progress_bar_nanoscale.png");
    public static final TextureArea PROGRESS_BAR_COMPONENT_ASSEMBLY_LINE_1 = TextureArea.fullImage("textures/gui/progress_bar/progress_bar_component_assembly_line_1.png");
    public static final TextureArea PROGRESS_BAR_COMPONENT_ASSEMBLY_LINE_2 = TextureArea.fullImage("textures/gui/progress_bar/progress_bar_component_assembly_line_2.png");
    public static final TextureArea PROGRESS_BAR_HEAT_EXCHANGE = TextureArea.fullImage("textures/gui/progress_bar/progress_bar_heat_exchange.png");
    public static final TextureArea PROGRESS_BAR_SPACE_ELEVATOR_MINING_MODULE = TextureArea.fullImage("textures/gui/progress_bar/progress_bar_mining_module.png");
    public static final TextureArea PROGRESS_BAR_SPACE_ELEVATOR_DRILLING_MODULE = TextureArea.fullImage("textures/gui/progress_bar/progress_bar_drilling_module.png");
    public static final TextureArea PROGRESS_BAR_FORGING_MODULE = TextureArea.fullImage("textures/gui/progress_bar/progress_bar_forging_module.png");
    public static final TextureArea PROGRESS_BAR_ETERNITY_GARDEN = TextureArea.fullImage("textures/gui/progress_bar/progress_bar_eternity_garden.png");

    //  Overlay
    public static final TextureArea FOIL_OVERLAY = TextureArea.fullImage("textures/gui/overlay/foil_overlay.png");
    public static final TextureArea NANOSCALE_OVERLAY_1 = TextureArea.fullImage("textures/gui/overlay/nanoscale_overlay_1.png");
    public static final TextureArea NANOSCALE_OVERLAY_2 = TextureArea.fullImage("textures/gui/overlay/nanoscale_overlay_2.png");
    public static final TextureArea DISH_OVERLAY = TextureArea.fullImage("textures/gui/overlay/dish_overlay.png");
    public static final TextureArea GREEN_OVERLAY = TextureArea.fullImage("textures/gui/overlay/green_overlay.png");
    public static final TextureArea RED_OVERLAY = TextureArea.fullImage("textures/gui/overlay/red_overlay.png");
    public static final TextureArea PINK_OVERLAY = TextureArea.fullImage("textures/gui/overlay/pink_overlay.png");
    public static final TextureArea BLUE_OVERLAY = TextureArea.fullImage("textures/gui/overlay/blue_overlay.png");

    //  Button
    public static final TextureArea BUTTON_STRUCTURE_SWITCHING = TextureArea.fullImage("textures/gui/widget/button_structure_switching.png");
    public static final TextureArea BUTTON_YOTTA_MODE = TextureArea.fullImage("textures/gui/widget/button_yotta_mode.png");
    public static final TextureArea FUSION_REACTOR_MK4_TITLE = TextureArea.fullImage("textures/gui/widget/fusion_reactor_mk4_title.png");
    public static final TextureArea FUSION_REACTOR_MK5_TITLE = TextureArea.fullImage("textures/gui/widget/fusion_reactor_mk5_title.png");

    //  Logo
    public static final TextureArea SPACE_ELEVATOR_LOGO = TextureArea.fullImage("textures/gui/icon/space_elevator_logo.png");
    public static final TextureArea SPACE_ELEVATOR_LOGO_DARK = TextureArea.fullImage("textures/gui/icon/space_elevator_logo_dark.png");
    public static final TextureArea ETERNITY_GARDEN_LOGO = TextureArea.fullImage("textures/gui/icon/eternity_garden_logo.png");

    //  Icon
    public static final TextureArea QC_COMPONENT_OUTLINE = TextureArea.fullImage("textures/gui/widget/quantum_computer/component_outline.png");
    public static final TextureArea QC_ICON_EMPTY_COMPONENT = TextureArea.fullImage("textures/gui/widget/quantum_computer/empty_component.png");
    public static final TextureArea QC_ICON_COMPUTATION_COMPONENT = TextureArea.fullImage("textures/gui/widget/quantum_computer/computation_component.png");
    public static final TextureArea QC_ICON_ADVANCED_COMPUTATION_COMPONENT = TextureArea.fullImage("textures/gui/widget/quantum_computer/advanced_computation_component.png");
    public static final TextureArea QC_ICON_DAMAGED_COMPUTATION_COMPONENT = TextureArea.fullImage("textures/gui/widget/quantum_computer/damaged_computation_component.png");
    public static final TextureArea QC_ICON_DAMAGED_ADVANCED_COMPUTATION_COMPONENT = TextureArea.fullImage("textures/gui/widget/quantum_computer/damaged_advanced_computation_component.png");
    public static final TextureArea QC_ICON_HEAT_SINK_COMPONENT = TextureArea.fullImage("textures/gui/widget/quantum_computer/heat_sink_component.png");
    public static final TextureArea QC_ICON_ACTIVE_COOLER_COMPONENT = TextureArea.fullImage("textures/gui/widget/quantum_computer/active_cooler_component.png");
    public static final TextureArea QC_ICON_BRIDGE_COMPONENT = TextureArea.fullImage("textures/gui/widget/quantum_computer/bridge_component.png");

    public GTLiteGuiTextures() {}
}