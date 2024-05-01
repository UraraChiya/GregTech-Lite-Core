package magicbook.gtlitecore.common.items;

import gregtech.api.GTValues;
import gregtech.api.items.metaitem.ElectricStats;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.items.metaitem.stats.IItemComponent;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.items.behaviors.ProspectorScannerBehavior;
import gregtech.common.items.behaviors.TooltipBehavior;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import magicbook.gtlitecore.common.items.behaviors.GrindBallBehavior;
import magicbook.gtlitecore.common.items.behaviors.StructureWriterBehavior;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;

import static gregtech.api.GTValues.M;
import static magicbook.gtlitecore.api.utils.AnimatedTooltipHandler.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class GTLiteMetaItems1 extends StandardMetaItem {
    public GTLiteMetaItems1() {
        this.setRegistryName("gtlite_meta_item_1");
        setCreativeTab(GTLiteAPI.TAB_GTLITE);
    }

    public void registerSubItems() {

        //  Boards
        GOOWARE_BOARD = this.addItem(0, "board.gooware")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        OPTICAL_BOARD = this.addItem(1, "board.optical")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        SPINTRONIC_BOARD = this.addItem(2, "board.spintronic")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        if (GTLiteConfigHolder.recipes.enableMagnetoResonaticCircuit) {
            MAGNETO_RESONATIC_BOARD = this.addItem(3, "board.magneto_resonatic")
                    .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        }

        //  Circuit Boards
        GOOWARE_CIRCUIT_BOARD = this.addItem(4, "circuit_board.gooware")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        OPTICAL_CIRCUIT_BOARD = this.addItem(5, "circuit_board.optical")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        SPINTRONIC_CIRCUIT_BOARD = this.addItem(6, "circuit_board.spintronic")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        if (GTLiteConfigHolder.recipes.enableMagnetoResonaticCircuit) {
            MAGNETO_RESONATIC_CIRCUIT_BOARD = this.addItem(7, "circuit_board.magneto_resonatic")
                    .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        }

        //  Circuits
        GOOWARE_PROCESSOR = this.addItem(8, "circuit.gooware_processor")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GOOWARE_ASSEMBLY = this.addItem(9, "circuit.gooware_assembly")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GOOWARE_COMPUTER = this.addItem(10, "circuit.gooware_computer")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GOOWARE_MAINFRAME = this.addItem(11, "circuit.gooware_mainframe")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        OPTICAL_PROCESSOR = this.addItem(12, "circuit.optical_processor")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        OPTICAL_ASSEMBLY = this.addItem(13, "circuit.optical_assembly")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        OPTICAL_COMPUTER = this.addItem(14, "circuit.optical_computer")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        OPTICAL_MAINFRAME = this.addItem(15, "circuit.optical_mainframe")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        SPINTRONIC_PROCESSOR = this.addItem(16, "circuit.spintronic_processor")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        SPINTRONIC_ASSEMBLY = this.addItem(17, "circuit.spintronic_assembly")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        SPINTRONIC_COMPUTER = this.addItem(18, "circuit.spintronic_computer")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        SPINTRONIC_MAINFRAME = this.addItem(19, "circuit.spintronic_mainframe")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        COSMIC_PROCESSOR = this.addItem(20, "circuit.cosmic_processor")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT)
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.circuit.cosmic_processor.tooltip.1"));
                    lines.add(translatedAnimatedText("metaitem.circuit.cosmic_processor.tooltip.2", 1, 100, DARK_PURPLE, DARK_RED).get());
                }));

        COSMIC_ASSEMBLY = this.addItem(21, "circuit.cosmic_assembly")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT)
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.circuit.cosmic_assembly.tooltip.1"));
                    lines.add(translatedAnimatedText("metaitem.circuit.cosmic_assembly.tooltip.2", 1, 100, DARK_PURPLE, DARK_RED).get());
                }));

        COSMIC_COMPUTER = this.addItem(22, "circuit.cosmic_computer")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT)
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.circuit.cosmic_computer.tooltip.1"));
                    lines.add(translatedAnimatedText("metaitem.circuit.cosmic_computer.tooltip.2", 1, 100, DARK_PURPLE, DARK_RED).get());
                }));

        COSMIC_MAINFRAME = this.addItem(23, "circuit.cosmic_mainframe")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT)
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.circuit.cosmic_mainframe.tooltip.1"));
                    lines.add(translatedAnimatedText("metaitem.circuit.cosmic_mainframe.tooltip.2", 1, 100, DARK_PURPLE, DARK_RED).get());
                }));

        SUPRACAUSAL_PROCESSOR = this.addItem(24, "circuit.supracausal_processor")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT)
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.circuit.supracausal_processor.tooltip.1"));
                    lines.add(translatedAnimatedText("metaitem.circuit.supracausal_processor.tooltip.2", 1, 100, RED, GOLD, YELLOW, GREEN, AQUA, BLUE, LIGHT_PURPLE).get());
                }));

        SUPRACAUSAL_ASSEMBLY = this.addItem(25, "circuit.supracausal_assembly")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT)
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.circuit.supracausal_assembly.tooltip.1"));
                    lines.add(translatedAnimatedText("metaitem.circuit.supracausal_assembly.tooltip.2", 1, 100, RED, GOLD, YELLOW, GREEN, AQUA, BLUE, LIGHT_PURPLE).get());
                }));

        SUPRACAUSAL_COMPUTER = this.addItem(26, "circuit.supracausal_computer")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT)
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.circuit.supracausal_computer.tooltip.1"));
                    lines.add(translatedAnimatedText("metaitem.circuit.supracausal_computer.tooltip.2", 1, 100, RED, GOLD, YELLOW, GREEN, AQUA, BLUE, LIGHT_PURPLE).get());
                }));

        SUPRACAUSAL_MAINFRAME = this.addItem(27, "circuit.supracausal_mainframe")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT)
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.circuit.supracausal_mainframe.tooltip.1"));
                    lines.add(translatedAnimatedText("metaitem.circuit.supracausal_mainframe.tooltip.2", 1, 100, RED + BOLD, GOLD + BOLD, YELLOW + BOLD, GREEN + BOLD, AQUA + BOLD, BLUE + BOLD, LIGHT_PURPLE + BOLD).get());
                }));

        SUPRACHRONAL_CIRCUIT_ULV = this.addItem(28, "circuit.suprachronal.ulv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ULV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        SUPRACHRONAL_CIRCUIT_LV = this.addItem(29, "circuit.suprachronal.lv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        SUPRACHRONAL_CIRCUIT_MV = this.addItem(30, "circuit.suprachronal.mv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        SUPRACHRONAL_CIRCUIT_HV = this.addItem(31, "circuit.suprachronal.hv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.HV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        SUPRACHRONAL_CIRCUIT_EV = this.addItem(32, "circuit.suprachronal.ev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.EV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        SUPRACHRONAL_CIRCUIT_IV = this.addItem(33, "circuit.suprachronal.iv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.IV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        SUPRACHRONAL_CIRCUIT_LuV = this.addItem(34, "circuit.suprachronal.luv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LuV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        SUPRACHRONAL_CIRCUIT_ZPM = this.addItem(35, "circuit.suprachronal.zpm").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        SUPRACHRONAL_CIRCUIT_UV = this.addItem(36, "circuit.suprachronal.uv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        SUPRACHRONAL_CIRCUIT_UHV = this.addItem(37, "circuit.suprachronal.uhv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        SUPRACHRONAL_CIRCUIT_UEV = this.addItem(38, "circuit.suprachronal.uev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        SUPRACHRONAL_CIRCUIT_UIV = this.addItem(39, "circuit.suprachronal.uiv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        SUPRACHRONAL_CIRCUIT_UXV = this.addItem(40, "circuit.suprachronal.uxv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        SUPRACHRONAL_CIRCUIT_OpV = this.addItem(41, "circuit.suprachronal.opv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        SUPRACHRONAL_CIRCUIT_MAX = this.addItem(42, "circuit.suprachronal.max").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        if (GTLiteConfigHolder.recipes.enableMagnetoResonaticCircuit) {
            MAGNETO_RESONATIC_CIRCUIT_ULV = this.addItem(43, "circuit.magneto_resonatic.ulv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ULV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
            MAGNETO_RESONATIC_CIRCUIT_LV = this.addItem(44, "circuit.magneto_resonatic.lv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
            MAGNETO_RESONATIC_CIRCUIT_MV = this.addItem(45, "circuit.magneto_resonatic.mv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
            MAGNETO_RESONATIC_CIRCUIT_HV = this.addItem(46, "circuit.magneto_resonatic.hv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.HV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
            MAGNETO_RESONATIC_CIRCUIT_EV = this.addItem(47, "circuit.magneto_resonatic.ev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.EV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
            MAGNETO_RESONATIC_CIRCUIT_IV = this.addItem(48, "circuit.magneto_resonatic.iv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.IV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
            MAGNETO_RESONATIC_CIRCUIT_LuV = this.addItem(49, "circuit.magneto_resonatic.luv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LuV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
            MAGNETO_RESONATIC_CIRCUIT_ZPM = this.addItem(50, "circuit.magneto_resonatic.zpm").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
            MAGNETO_RESONATIC_CIRCUIT_UV = this.addItem(51, "circuit.magneto_resonatic.uv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
            MAGNETO_RESONATIC_CIRCUIT_UHV = this.addItem(52, "circuit.magneto_resonatic.uhv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
            MAGNETO_RESONATIC_CIRCUIT_UEV = this.addItem(53, "circuit.magneto_resonatic.uev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
            MAGNETO_RESONATIC_CIRCUIT_UIV = this.addItem(54, "circuit.magneto_resonatic.uiv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
            MAGNETO_RESONATIC_CIRCUIT_UXV = this.addItem(55, "circuit.magneto_resonatic.uxv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
            MAGNETO_RESONATIC_CIRCUIT_OpV = this.addItem(56, "circuit.magneto_resonatic.opv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
            MAGNETO_RESONATIC_CIRCUIT_MAX = this.addItem(57, "circuit.magneto_resonatic.max").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX).setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);
        }

        //  SMDs
        OPTICAL_TRANSISTOR = this.addItem(58, "component.optical_smd.transistor");
        OPTICAL_RESISTOR = this.addItem(59, "component.optical_smd.resistor");
        OPTICAL_CAPACITOR = this.addItem(60, "component.optical_smd.capacitor");
        OPTICAL_DIODE = this.addItem(61, "component.optical_smd.diode");
        OPTICAL_INDUCTOR = this.addItem(62, "component.optical_smd.inductor");
        SPINTRONIC_TRANSISTOR = this.addItem(63, "component.spintronic_smd.transistor");
        SPINTRONIC_RESISTOR = this.addItem(64, "component.spintronic_smd.resistor");
        SPINTRONIC_CAPACITOR = this.addItem(65, "component.spintronic_smd.capacitor");
        SPINTRONIC_DIODE = this.addItem(66, "component.spintronic_smd.diode");
        SPINTRONIC_INDUCTOR = this.addItem(67, "component.spintronic_smd.inductor");
        COSMIC_TRANSISTOR = this.addItem(68, "component.cosmic_smd.transistor");
        COSMIC_RESISTOR = this.addItem(69, "component.cosmic_smd.resistor");
        COSMIC_CAPACITOR = this.addItem(70, "component.cosmic_smd.capacitor");
        COSMIC_DIODE = this.addItem(71, "component.cosmic_smd.diode");
        COSMIC_INDUCTOR = this.addItem(72, "component.cosmic_smd.inductor");
        SUPRACAUSAL_TRANSISTOR = this.addItem(73, "component.supracausal_smd.transistor");
        SUPRACAUSAL_RESISTOR = this.addItem(74, "component.supracausal_smd.resistor");
        SUPRACAUSAL_CAPACITOR = this.addItem(75, "component.supracausal_smd.capacitor");
        SUPRACAUSAL_DIODE = this.addItem(76, "component.supracausal_smd.diode");
        SUPRACAUSAL_INDUCTOR = this.addItem(77, "component.supracausal_smd.inductor");

        //  Circuit Components
        BZ_REACTION_CHAMBER = this.addItem(78, "component.gooware.reaction_chamber");
        NONLINEAR_CHEMICAL_OSCILLATOR = this.addItem(79, "component.gooware.nonlinear_chemical_oscillator");
        OPTICAL_LASER_CONTROL_UNIT = this.addItem(80, "component.optical.optical_laser_control_unit");
        ESR_COMPUTATION_UNIT = this.addItem(81, "component.spintronic.esr_computation_unit");
        COSMIC_INFORMATION_MODULE = this.addItem(82, "component.cosmic.information_module");
        HOLOGRAPHIC_INFORMATION_IMC = this.addItem(83, "component.cosmic.holographic_imc");
        SPACETIME_CONDENSER = this.addItem(84, "component.supracausal.spacetime_condenser");
        LIGHT_CONE_MODULE = this.addItem(85, "component.supracausal.light_cone_module");
        OPTICAL_FIBER = this.addItem(86, "component.optical.optical_fiber");
        DIELECTRIC_MIRROR = this.addItem(87, "component.optical.dielectric_mirror");
        EMPTY_LASER_ASSEMBLY = this.addItem(88, "component.optical.emitter.empty");
        HELIUM_NEON_LASER = this.addItem(89, "component.optical.emitter.helium_neon");
        ND_YAG_LASER = this.addItem(90, "component.optical.emitter.nd_yag");
        TOPOLOGICAL_INSULATOR_TUBE = this.addItem(91, "component.spintronic.topological_insulator");
        BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT = this.addItem(92, "component.spintronic.bose_einstein_condensate_containment_unit");
        BOSE_EINSTEIN_CONDENSATE = this.addItem(93, "component.spintronic.bose_einstein_condensate");
        CLADDED_OPTICAL_FIBER_CORE = this.addItem(94, "component.cosmic.cladded_optical_fiber_core");
        CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT = this.addItem(95, "component.cosmic.closed_timelike_curve_computational_unit");
        CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT = this.addItem(96, "component.cosmic.closed_timelike_curve_guidance_unit");
        NUCLEAR_CLOCK = this.addItem(97, "component.cosmic.nuclear_clock");
        MANIFOLD_OSCILLATORY_POWER_CELL = this.addItem(98, "component.cosmic.manifold_oscillatory_power_cell");
        SCINTILLATOR = this.addItem(99, "component.cosmic.scintillator");
        SCINTILLATOR_CRYSTAL = this.addItem(100, "component.cosmic.scintillator_crystal");
        TOPOLOGICAL_MANIPULATOR_UNIT = this.addItem(101, "component.supracausal.topological_manipulator_unit");
        GRAVITON_TRANSDUCER = this.addItem(102, "component.supracausal.graviton_transducer");
        RELATIVISTIC_SPINORIAL_MEMORY_SYSTEM = this.addItem(103, "component.supracausal.relativistic_spinorial_memory_system");
        MACROWORMHOLE_GENERATOR = this.addItem(104, "component.supracausal.macrowormhole_generator");
        MICROWORMHOLE_GENERATOR = this.addItem(105, "component.supracausal.microwormhole_generator");
        STABILIZED_WORMHOLE_GENERATOR = this.addItem(106, "component.supracausal.stabilized_wormhole_generator");
        EIGENFOLDED_SPACETIME_MANIFOLD = this.addItem(107, "component.supracausal.eigenfolded_space_time_manifold");
        RECURSIVELY_FOLDED_NEGATIVE_SPACE = this.addItem(108, "component.supracausal.recursively_folded_negative_space");

        BIO_CELL = this.addItem(120, "component.gooware.bio_cell");
        BIO_DISH = this.addItem(121, "component.gooware.bio_dish");
        RYDBERG_SPINORIAL_ASSEMBLY = this.addItem(122, "component.spintronic.rydberg_spinorial_assembly");
        CRYOGENIC_INTERFACE = this.addItem(123, "component.spintronic.cryogenic_interface");
        EXCITATION_MAINTAINER = this.addItem(124, "component.spintronic.excitation_maintainer");
        X_RAY_WAVEGUIDE = this.addItem(125, "component.spintronic.x_ray_waveguide");
        ELECTRON_SOURCE = this.addItem(126, "component.spintronic.electron_source");
        X_RAY_LASER = this.addItem(127, "component.spintronic.x_ray_laser");
        X_RAY_MIRROR = this.addItem(128, "component.spintronic.x_ray_mirror");
        MICROFOCUS_X_RAY_TUBE = this.addItem(129, "component.spintronic.microfocus_x_ray_tube");
        EXOTIC_SOC = this.addItem(130, "component.spintronic.exotic_soc");
        LEPTON_TRAP_CRYSTAL = this.addItem(131, "component.cosmic.lepton_trap_crystal");
        CHARGED_LEPTON_TRAP_CRYSTAL = this.addItem(132, "component.cosmic.charged_lepton_trap_crystal");
        COLORED_LEDS = this.addItem(133, "component.cosmic.colored_leds");
        ROTATING_TRANSPARENT_SURFACE = this.addItem(134, "component.cosmic.rotating_transparent_surface");
        UNIVERSAL_SOC = this.addItem(135, "component.cosmic.universal_soc");

        VACUUM_TUBE_COMPONENT = this.addItem(149, "component.primitive.vacuum_tube_component");
        DIAMOND_CHIP = this.addItem(150, "component.crystal.diamond_chip");
        RUBY_CHIP = this.addItem(151, "component.crystal.ruby_chip");
        SAPPHIRE_CHIP = this.addItem(152, "component.crystal.sapphire_chip");
        DIAMOND_MODULATOR = this.addItem(153, "component.crystal.diamond_modulator");
        RUBY_MODULATOR = this.addItem(154, "component.crystal.ruby_modulator");
        SAPPHIRE_MODULATOR = this.addItem(155, "component.crystal.sapphire_modulator");
        CRYSTAL_SOC_SOCKET = this.addItem(156, "component.crystal.system_on_chip_socket");

        //  Boules and Wafers
        NANO_PIC_WAFER = this.addItem(200, "wafer.nano_pic");
        NANO_PIC_CHIP = this.addItem(201, "wafer.chip.nano_pic");
        PICO_PIC_WAFER = this.addItem(202, "wafer.pico_pic");
        PICO_PIC_CHIP = this.addItem(203, "wafer.chip.pico_pic");
        FEMTO_PIC_WAFER = this.addItem(204, "wafer.femto_pic");
        FEMTO_PIC_CHIP = this.addItem(205, "wafer.chip.femto_pic");
        DUBNIUM_BOULE = this.addItem(206, "boule.dubnium");
        DUBNIUM_WAFER = this.addItem(207, "wafer.dubnium");
        PHASE_CHANGE_MEMORY = this.addItem(208, "wafer.chip.phase_change_memory");
        OPTICAL_NOR_MEMORY_CHIP = this.addItem(209, "wafer.chip.optical_nor_memory_chip");
        SPIN_TRANSFER_TORQUE_MEMORY = this.addItem(210, "wafer.chip.spin_transfer_torque_memory");
        SPINTRONIC_NAND_MEMORY_CHIP = this.addItem(211, "wafer.chip.spintronic_nand_memory_chip");
        UNTREATED_COSMIC_CPU = this.addItem(212, "wafer.untreated_cosmic_cpu");
        COSMIC_CPU = this.addItem(213, "wafer.cosmic_cpu");
        COSMIC_CPU_CHIP = this.addItem(214, "wafer.chip.cosmic_cpu");
        COSMIC_MEMORY_CHIP = this.addItem(215, "wafer.chip.cosmic_memory");

        SUPRACAUSAL_MEMORY_CHIP = this.addItem(217, "wafer.chip.supracausal_memory");
        UHASOC_WAFER = this.addItem(218, "wafer.uhasoc");
        UHASOC_CHIP = this.addItem(219, "wafer.chip.uhasoc");
        CUBIC_ZIRCONIA_EUROPIUM_BOULE = this.addItem(220, "boule.cubic_zirconia.europium");
        CUBIC_ZIRCONIA_EUROPIUM_WAFER = this.addItem(221, "wafer.cubic_zirconia.europium");
        CRYSTAL_INTERFACE_WAFER = this.addItem(222, "wafer.crystal_interface");
        CRYSTAL_INTERFACE_CHIP = this.addItem(223, "wafer.chip.crystal_interface");
        INTRAVITAL_SOC = this.addItem(224, "component.gooware.intravital_soc");
        STRONTIUM_CARBONATE_BOHRIUM_BOULE = this.addItem(225, "boule.strontium_carbonate.bohrium");
        STRONTIUM_CARBONATE_BOHRIUM_WAFER = this.addItem(226, "wafer.strontium_carbonate.bohrium");
        STRONTIUM_CARBONATE_OPTICAL_WAFER = this.addItem(227, "component.optical.strontium_carbonate_wafer");
        STRONTIUM_CARBONATE_OPTICAL_CHIP = this.addItem(228, "component.optical.strontium_carbonate_chip");
        OPTICAL_IMC_BOARD = this.addItem(229, "component.optical.optical_imc_board");
        PHOTOELECTRON_SOC = this.addItem(230, "component.optical.photoelectron_soc");

        //  Voltage Coils
        VOLTAGE_COIL_UHV = this.addItem(250, "voltage_coil.uhv");
        VOLTAGE_COIL_UEV = this.addItem(251, "voltage_coil.uev");
        VOLTAGE_COIL_UIV = this.addItem(252, "voltage_coil.uiv");
        VOLTAGE_COIL_UXV = this.addItem(253, "voltage_coil.uxv");
        VOLTAGE_COIL_OpV = this.addItem(254, "voltage_coil.opv");

        //  Covers
        ELECTRIC_MOTOR_ULV = this.addItem(255, "cover.electric_motor.ulv");
        ELECTRIC_PISTON_ULV = this.addItem(256, "cover.electric_piston.ulv");

        ELECTRIC_PUMP_ULV = this.addItem(257, "cover.electric_pump.ulv")
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.electric.pump.tooltip"));
                    lines.add(I18n.format("gregtech.universal.tooltip.fluid_transfer_rate", 32));
                }));

        CONVEYOR_MODULE_ULV = this.addItem(258, "cover.conveyor_module.ulv")
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.conveyor.module.tooltip"));
                    lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 4));
                }));

        ROBOT_ARM_ULV = this.addItem(259, "cover.robot_arm.ulv")
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.robot.arm.tooltip"));
                    lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 4));
                }));

        EMITTER_ULV = this.addItem(260, "cover.emitter.ulv");
        SENSOR_ULV = this.addItem(261, "cover.sensor.ulv");
        FIELD_GENERATOR_ULV = this.addItem(262, "cover.field_generator.ulv");
        ELECTRIC_MOTOR_MAX = this.addItem(263, "cover.electric_motor.max");
        ELECTRIC_PISTON_MAX = this.addItem(264, "cover.electric_piston.max");

        ELECTRIC_PUMP_MAX = this.addItem(265, "cover.electric_pump.max")
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.electric.pump.tooltip"));
                    lines.add(I18n.format("gregtech.universal.tooltip.fluid_transfer_rate", 1048576));
                }));

        CONVEYOR_MODULE_MAX = this.addItem(266, "cover.conveyor_module.max")
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.conveyor.module.tooltip"));
                    lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate_stacks", 16));
                }));

        ROBOT_ARM_MAX = this.addItem(267, "cover.robot_arm.max")
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.robot.arm.tooltip"));
                    lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate_stacks", 16));
                }));

        EMITTER_MAX = this.addItem(268, "cover.emitter.max");
        SENSOR_MAX = this.addItem(269, "cover.sensor.max");
        FIELD_GENERATOR_MAX = this.addItem(270, "cover.field_generator.max");

        if (GTLiteConfigHolder.tools.enableHighTierSolarPanel) {
            //  Free Id: 270-275 for UHV-OpV Solar Panels
            COVER_SOLAR_PANEL_MAX = this.addItem(276, "cover.solar_panel.max")
                    .addComponents(new TooltipBehavior((lines) -> {
                        lines.add(I18n.format("metaitem.cover.solar.panel.tooltip.1"));
                        lines.add(I18n.format("metaitem.cover.solar.panel.tooltip.2"));
                        lines.add(I18n.format("gregtech.universal.tooltip.voltage_out", GTValues.V[GTValues.MAX], GTValues.VNF[GTValues.MAX]));
            }));
        }

        //  Tools
        if (GTLiteConfigHolder.tools.enableEVProspector) {
            PROSPECTOR_EV = this.addItem(280, "tool.prospector.ev")
                    .addComponents(new IItemComponent[]{ElectricStats.createElectricItem(500000000L, 4), new ProspectorScannerBehavior(5, 4)})
                    .setMaxStackSize(1)
                    .setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);
        }

        if (GTLiteConfigHolder.tools.enableZPMProspector) {
            PROSPECTOR_ZPM = this.addItem(281, "tool.prospector.zpm")
                    .addComponents(new IItemComponent[]{ElectricStats.createElectricItem(4000000000L, 7), new ProspectorScannerBehavior(7, 7)})
                    .setMaxStackSize(1)
                    .setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);
        }

        if (GTLiteConfigHolder.tools.enableHighTierBattery) {
            BATTERY_HULL_SMALL_LITHIUM_SULFIDE = this.addItem(284, "battery.hull.uhv");
            BATTERY_HULL_MEDIUM_LITHIUM_SULFIDE = this.addItem(285, "battery.hull.uev");
            BATTERY_HULL_LARGE_LITHIUM_SULFIDE = this.addItem(286, "battery.hull.uiv");
            BATTERY_HULL_SMALL_LANTHANUM_NICKEL_OXIDE = this.addItem(287, "battery.hull.uxv");
            BATTERY_HULL_MEDIUM_LANTHANUM_NICKEL_OXIDE = this.addItem(288, "battery.hull.opv");
            BATTERY_HULL_LARGE_LANTHANUM_NICKEL_OXIDE = this.addItem(289, "battery.hull.max");

            BATTERY_UHV_LITHIUM_SULFIDE = this.addItem(290, "battery.uhv.lithium_sulfide")
                    .addComponents(ElectricStats.createRechargeableBattery(10485760000L, GTValues.UHV))
                    .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UHV)
                    .setModelAmount(8)
                    .setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);

            BATTERY_UEV_LITHIUM_SULFIDE = this.addItem(291, "battery.uev.lithium_sulfide")
                    .addComponents(ElectricStats.createRechargeableBattery(41943040000L, GTValues.UEV))
                    .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UEV)
                    .setModelAmount(8)
                    .setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);

            BATTERY_UIV_LITHIUM_SULFIDE = this.addItem(292, "battery.uiv.lithium_sulfide")
                    .addComponents(ElectricStats.createRechargeableBattery(167772160000L, GTValues.UIV))
                    .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UIV)
                    .setModelAmount(8)
                    .setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);

            BATTERY_UXV_LANTHANUM_NICKEL_OXIDE = this.addItem(293, "battery.uxv.lanthanum_nickel_oxide")
                    .addComponents(ElectricStats.createRechargeableBattery(671088640000L, GTValues.UXV))
                    .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UXV)
                    .setModelAmount(8)
                    .setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);

            BATTERY_OpV_LANTHANUM_NICKEL_OXIDE = this.addItem(294, "battery.opv.lanthanum_nickel_oxide")
                    .addComponents(ElectricStats.createRechargeableBattery(2684354560000L, GTValues.OpV))
                    .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.OpV)
                    .setModelAmount(8).setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);

            BATTERY_MAX_LANTHANUM_NICKEL_OXIDE = this.addItem(295, "battery.max.lanthanum_nickel_oxide")
                    .addComponents(ElectricStats.createRechargeableBattery(10737418240000L, GTValues.MAX))
                    .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MAX)
                    .setModelAmount(8)
                    .setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);

            if (GTLiteConfigHolder.tools.enableHighTierUltimateBattery) {
                ULTIMATE_BATTERY_MK2 = this.addItem(296, "battery.uev.ultimate")
                        .addComponents(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.UEV))
                        .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UEV)
                        .setModelAmount(8)
                        .setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);

                ULTIMATE_BATTERY_MK3 = this.addItem(297, "battery.uiv.ultimate")
                        .addComponents(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.UIV))
                        .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UIV)
                        .setModelAmount(8)
                        .setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);

                ULTIMATE_BATTERY_MK4 = this.addItem(298, "battery.uxv.ultimate")
                        .addComponents(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.UXV))
                        .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UXV)
                        .setModelAmount(8)
                        .setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);

                ULTIMATE_BATTERY_MK5 = this.addItem(299, "battery.opv.ultimate")
                        .addComponents(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.OpV))
                        .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.OpV)
                        .setModelAmount(8)
                        .setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);
            }
        }
        //  Others
        GRINDBALL_SOAPSTONE = this.addItem(300, "grindball.soapstone")
                .setMaxStackSize(1)
                .addComponents(new GrindBallBehavior())
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);

        GRINDBALL_ALUMINIUM = this.addItem(301, "grindball.aluminium")
                .setMaxStackSize(1)
                .addComponents(new GrindBallBehavior())
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);

        COMPONENT_GRINDER_BORON_NITRIDE = this.addItem(302, "component.grinder.boron_nitride");
        COMPONENT_GRINDER_BLACK_PLUTONIUM = this.addItem(303, "component.grinder.black_plutonium");
        QCD_PROTECTIVE_PLATING = this.addItem(304, "qcd_protective_plating");
        CARBON_ALLOTROPE_MIXTURE = this.addItem(305, "mixture.carbon_allotrope");
        GRAPHENE_ALIGNED_CNT = this.addItem(306, "cnt.graphene_aligned");
        UNSTABLE_STAR = this.addItem(307, "unstable_star");
        ZENITH_STAR = this.addItem(308, "zenith_star");
        QUANTUM_ANOMALY = this.addItem(309, "quantum_anomaly");
        MAGNETRON = this.addItem(310, "magnetron");
        SEPARATION_ELECTROMAGNET = this.addItem(311, "separation_electromagnet");
        COSMIC_FABRIC = this.addItem(312, "cosmic_fabric");
        MEMORY_FOAM_PLATE = this.addItem(313, "memory_foam_plate");
        FULLERENE_FIBER = this.addItem(314, "highly_insulating_fullerene_foil");
        HYPERDIMENSIONAL_DRONE = this.addItem(315, "hyperdimensional_drone");
        HYPERDIMENSIONAL_OSCILLATING_MATTER = this.addItem(316, "hyperdimensional_oscillating_matter");

        CHROMATIC_LENS = this.addItem(317, "chromatic_lens")
                .addOreDict("craftingLensChromatic");

        NEUTRONIUM_SPHERE = this.addItem(318, "neutronium_sphere");
        TRIPLET_NEUTRONIUM_SPHERE = this.addItem(319, "triplet_neutronium_sphere");
        MINING_DRONE_LV = this.addItem(320, "mining_drone.lv");
        MINING_DRONE_MV = this.addItem(321, "mining_drone.mv");
        MINING_DRONE_HV = this.addItem(322, "mining_drone.hv");
        MINING_DRONE_EV = this.addItem(323, "mining_drone.ev");
        MINING_DRONE_IV = this.addItem(324, "mining_drone.iv");
        MINING_DRONE_LuV = this.addItem(325, "mining_drone.luv");
        MINING_DRONE_ZPM = this.addItem(326, "mining_drone.zpm");
        MINING_DRONE_UV = this.addItem(327, "mining_drone.uv");
        MINING_DRONE_UHV = this.addItem(328, "mining_drone.uhv");
        MINING_DRONE_UEV = this.addItem(329, "mining_drone.uev");
        MINING_DRONE_UIV = this.addItem(330, "mining_drone.uiv");
        MINING_DRONE_UXV = this.addItem(331, "mining_drone.uxv");
        MINING_DRONE_OpV = this.addItem(332, "mining_drone.opv");
        MINING_DRONE_MAX = this.addItem(333, "mining_drone.max");
        CRUDE_HYPERCUBE = this.addItem(334, "crude_hypercube");
        CHARGED_HYPERCUBE = this.addItem(335, "charged_hypercube");
        COSMIC_MEMORY_CARD = this.addItem(336, "cosmic_memory_card");
        COSMIC_MEMORY_CARD_OVERWORLD = this.addItem(337, "cosmic_memory_card.overworld");
        COSMIC_MEMORY_CARD_NETHER = this.addItem(338, "cosmic_memory_card.nether");
        COSMIC_MEMORY_CARD_END = this.addItem(339, "cosmic_memory_card.end");
        DIMENSION_GAP = this.addItem(340, "dimension_gap");
        ULTRASONIC_HOMOGENIZER = this.addItem(341, "ultrasonic_homogenizer");
        PIEZOELECTRIC_CRYSTAL = this.addItem(342, "piezoelectric_crystal");
        DYSON_SWARM_MODULE = this.addItem(343, "dyson_swarm_module");
        HYPERSTABLE_SELF_HEALING_ADHESIVE = this.addItem(344, "hyperstable_self_healing_adhesive");
        SUPERSOLID_SPACETIME_CONTINUUM = this.addItem(345, "supersolid_spacetime_continuum");

        //  High Energy Physics Items
        PLASMA_CONTAINMENT_CELL = this.addItem(350, "plasma_containment_cell");
        RHENIUM_PLASMA_CONTAINMENT_CELL = this.addItem(351, "rhenium_plasma_containment_cell");
        NEUTRON_PLASMA_CONTAINMENT_CELL = this.addItem(352, "neutron_plasma_containment_cell");
        EXTREMELY_DURABLE_PLASMA_CONTAINMENT_CELL = this.addItem(353, "extremely_durable_plasma_containment_cell");
        DENSE_NEUTRON_PLASMA_CONTAINMENT_CELL = this.addItem(354, "dense_neutron_plasma_containment_cell");
        COSMIC_NEUTRON_PLASMA_CONTAINMENT_CELL = this.addItem(355, "cosmic_neutron_plasma_containment_cell");
        TIME_DILATION_CONTAINMENT_UNIT = this.addItem(356, "time_dilation_containment_unit");
        CONTAINED_RN_SINGULARITY = this.addItem(357, "contained_reissner_nordstrom_singularity");
        CONTAINED_KN_SINGULARITY = this.addItem(358, "contained_kerr_newmann_singularity");
        CONTAINED_KERR_SINGULARITY = this.addItem(359, "contained_kerr_singularity");
        CONTAINED_HIGH_DENSITY_PROTONIC_MATTER = this.addItem(360, "contained_high_density_protonic_matter");
        CONTAINED_EXOTIC_MATTER = this.addItem(361, "contained_exotic_matter");
        CHARGED_TRIPLET_NEUTRONIUM_SPHERE = this.addItem(362, "charged_triplet_neutronium_sphere");

        COSMIC_FABRIC_PLASMA_CONTAINMENT_CELL = this.addItem(363, "cosmic_fabric_plasma_containment_cell")
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.cosmic_fabric_plasma_containment_cell.tooltip.1"));
                    lines.add(I18n.format("metaitem.cosmic_fabric_plasma_containment_cell.tooltip.2"));
                    lines.add(I18n.format("metaitem.cosmic_fabric_plasma_containment_cell.tooltip.3"));
                    lines.add(I18n.format("metaitem.cosmic_fabric_plasma_containment_cell.tooltip.4"));
                }));

        //  Algae
        BARNARDA_C_BASE = this.addItem(370, "alga.barnarda_c.base");

        BARNARDA_C_CHLORELLA = this.addItem(371, "alga.barnarda_c.chlorella")
                .addOreDict("dyePurple");

        BARNARDA_C_BRYOPSIS_HYPNOIDES = this.addItem(372, "alga.barnarda_c.bryopsis_hypnoides")
                .addOreDict("dyeGreen");

        BARNARDA_C_ZOOXANTHELLAE = this.addItem(373, "alga.barnarda_c.zooxanthellae")
                .addOreDict("dyeOrange");

        TAU_CETI_F_BASE = this.addItem(374, "alga.tau_ceti_f.base");

        TAU_CETI_F_SCENEDESMUS_OBLIQUUS = this.addItem(375, "alga.tau_ceti_f.scenedesmus_obliquus")
                .addOreDict("dyeLime");

        TAU_CETI_F_PHAEOPHYTA = this.addItem(376, "alga.tau_ceti_f.phaeophyta")
                .addOreDict("dyeBrown");

        TAU_CETI_F_SPIRULINA = this.addItem(377, "alga.tau_ceti_f.spirulina")
                .addOreDict("dyeBlue");

        PROXIMA_B_BASE = this.addItem(378, "alga.proxima_b.base");

        PROXIMA_B_CONCHOSPORE = this.addItem(379, "alga.proxima_b.conchospore")
                .addOreDict("dyeRed");

        PROXIMA_B_POLYSIPHONIA_SENTICULOSA = this.addItem(380, "alga.proxima_b.polysiphonia_senticulosa")
                .addOreDict("dyeYellow");

        PROXIMA_B_SPIROGYRA = this.addItem(381, "alga.proxima_b.spirogyra")
                .addOreDict("dyeGray");

        //  Memory Cards
        MEMORY_CARD_BASE = this.addItem(385, "memory_card.base");
        MEMORY_CARD_ZOMBIE = this.addItem(386, "memory_card.zombie");
        MEMORY_CARD_SKELETON = this.addItem(387, "memory_card.skeleton");
        MEMORY_CARD_CREEPER = this.addItem(388, "memory_card.creeper");
        MEMORY_CARD_SPIDER = this.addItem(389, "memory_card.spider");
        MEMORY_CARD_SLIME = this.addItem(390, "memory_card.slime");
        MEMORY_CARD_WITCH = this.addItem(391, "memory_card.witch");
        MEMORY_CARD_GUARDIAN = this.addItem(392, "memory_card.guardian");
        MEMORY_CARD_ENDERMAN = this.addItem(393, "memory_card.enderman");
        MEMORY_CARD_WITHER_SKELETON = this.addItem(394, "memory_card.wither_skeleton");
        MEMORY_CARD_BLAZE = this.addItem(395, "memory_card.blaze");
        MEMORY_CARD_GHAST = this.addItem(396, "memory_card.ghast");
        MEMORY_CARD_SHULKER = this.addItem(397, "memory_card.shulker");
        MEMORY_CARD_WITHER = this.addItem(398, "memory_card.wither");
        MEMORY_CARD_ENDER_DRAGON = this.addItem(399, "memory_card.ender_dragon");

        //  Particles
        ALPHA_PARTICLE = this.addItem(400, "particle.alpha")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        GRAVITON = this.addItem(401, "particle.graviton")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        UP_QUARK = this.addItem(402, "particle.up_quark")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        DOWN_QUARK = this.addItem(403, "particle.down_quark")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        CHARM_QUARK = this.addItem(404, "particle.charm_quark")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        STRANGE_QUARK = this.addItem(405, "particle.strange_quark")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        TOP_QUARK = this.addItem(406, "particle.top_quark")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        BOTTOM_QUARK = this.addItem(407, "particle.bottom_quark")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        ELECTRON = this.addItem(408, "particle.electron")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        ELECTRON_NEUTRINO = this.addItem(409, "particle.electron_neutrino")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        MUON = this.addItem(410, "particle.muon")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        MUON_NEUTRINO = this.addItem(411, "particle.muon_neutrino")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        TAU = this.addItem(412, "particle.tau")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        TAU_NEUTRINO = this.addItem(413, "particle.tau_neutrino")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        GLUON = this.addItem(414, "particle.gluon")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        PHOTON = this.addItem(415, "particle.photon")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        Z_BOSON = this.addItem(416, "particle.z_boson")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        W_BOSON = this.addItem(417, "particle.w_boson")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        HIGGS_BOSON = this.addItem(418, "particle.higgs_boson")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        PROTON = this.addItem(419, "particle.proton")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        NEUTRON = this.addItem(420, "particle.neutron")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        LAMBDA_BARYON = this.addItem(421, "particle.lambda_baryon")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        OMEGA_BARYON = this.addItem(422, "particle.omega_baryon")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        MESON = this.addItem(423, "particle.meson")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        ETA_MESON = this.addItem(424, "particle.eta_meson")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_PARTICLE);

        //  Extruders
        EXOTIC_SHAPE_EXTRUDERS[0] = EXOTIC_SHAPE_EXTRUDER_PLATE = this.addItem(450, "shape.exotic_extruder.plate")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[1] = EXOTIC_SHAPE_EXTRUDER_ROD = this.addItem(451, "shape.exotic_extruder.rod")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[2] = EXOTIC_SHAPE_EXTRUDER_BOLT = this.addItem(452, "shape.exotic_extruder.bolt")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[3] = EXOTIC_SHAPE_EXTRUDER_RING = this.addItem(453, "shape.exotic_extruder.ring")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[4] = EXOTIC_SHAPE_EXTRUDER_CELL = this.addItem(454, "shape.exotic_extruder.cell")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[5] = EXOTIC_SHAPE_EXTRUDER_INGOT = this.addItem(455, "shape.exotic_extruder.ingot")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[6] = EXOTIC_SHAPE_EXTRUDER_WIRE = this.addItem(456, "shape.exotic_extruder.wire")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[7] = EXOTIC_SHAPE_EXTRUDER_PIPE_TINY = this.addItem(457, "shape.exotic_extruder.pipe.tiny")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[8] = EXOTIC_SHAPE_EXTRUDER_PIPE_SMALL = this.addItem(458, "shape.exotic_extruder.pipe.small")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[9] = EXOTIC_SHAPE_EXTRUDER_PIPE_NORMAL = this.addItem(459, "shape.exotic_extruder.pipe.normal")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[10] = EXOTIC_SHAPE_EXTRUDER_PIPE_LARGE = this.addItem(460, "shape.exotic_extruder.pipe.large")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[11] = EXOTIC_SHAPE_EXTRUDER_PIPE_HUGE = this.addItem(461, "shape.exotic_extruder.pipe.huge")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[12] = EXOTIC_SHAPE_EXTRUDER_BLOCK = this.addItem(462, "shape.exotic_extruder.block")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        //  Exotic Extruder Shapes index 13-20 (inclusive), id 463-470 (inclusive) are unused

        EXOTIC_SHAPE_EXTRUDERS[21] = EXOTIC_SHAPE_EXTRUDER_GEAR = addItem(471, "shape.exotic_extruder.gear")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[22] = EXOTIC_SHAPE_EXTRUDER_BOTTLE = addItem(472, "shape.exotic_extruder.bottle")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[23] = EXOTIC_SHAPE_EXTRUDER_FOIL = addItem(473, "shape.exotic_extruder.foil")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[24] = EXOTIC_SHAPE_EXTRUDER_GEAR_SMALL = addItem(474, "shape.exotic_extruder.gear_small")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[25] = EXOTIC_SHAPE_EXTRUDER_ROD_LONG = addItem(475, "shape.exotic_extruder.rod_long")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        EXOTIC_SHAPE_EXTRUDERS[26] = EXOTIC_SHAPE_EXTRUDER_ROTOR = addItem(476, "shape.exotic_extruder.rotor")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GTLiteMaterials.WhiteDwarfMatter, M * 4)));

        //  Wrap Items
        WRAP_CIRCUIT_ULV = this.addItem(500, "wrap.circuit.ulv")
                .addOreDict("wrapCircuitUlv")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_CIRCUIT_LV = this.addItem(501, "wrap.circuit.lv")
                .addOreDict("wrapCircuitLv")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_CIRCUIT_MV = this.addItem(502, "wrap.circuit.mv")
                .addOreDict("wrapCircuitMv")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_CIRCUIT_HV = this.addItem(503, "wrap.circuit.hv")
                .addOreDict("wrapCircuitHv")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_CIRCUIT_EV = this.addItem(504, "wrap.circuit.ev")
                .addOreDict("wrapCircuitEv")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_CIRCUIT_IV = this.addItem(505, "wrap.circuit.iv")
                .addOreDict("wrapCircuitIv")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_CIRCUIT_LuV = this.addItem(506, "wrap.circuit.luv")
                .addOreDict("wrapCircuitLuv")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_CIRCUIT_ZPM = this.addItem(507, "wrap.circuit.zpm")
                .addOreDict("wrapCircuitZpm")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_CIRCUIT_UV = this.addItem(508, "wrap.circuit.uv")
                .addOreDict("wrapCircuitUv")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_CIRCUIT_UHV = this.addItem(509, "wrap.circuit.uhv")
                .addOreDict("wrapCircuitUhv")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_CIRCUIT_UEV = this.addItem(510, "wrap.circuit.uev")
                .addOreDict("wrapCircuitUev")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_CIRCUIT_UIV = this.addItem(511, "wrap.circuit.uiv")
                .addOreDict("wrapCircuitUiv")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_CIRCUIT_UXV = this.addItem(512, "wrap.circuit.uxv")
                .addOreDict("wrapCircuitUxv")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_CIRCUIT_OpV = this.addItem(513, "wrap.circuit.opv")
                .addOreDict("wrapCircuitOpv")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_CIRCUIT_MAX = this.addItem(514, "wrap.circuit.max")
                .addOreDict("wrapCircuitMax")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_BASIC_CIRCUIT_BOARD = this.addItem(515, "wrap.circuit_board.basic")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_GOOD_CIRCUIT_BOARD = this.addItem(516, "wrap.circuit_board.good")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_PLASTIC_CIRCUIT_BOARD = this.addItem(517, "wrap.circuit_board.plastic")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_ADVANCED_CIRCUIT_BOARD = this.addItem(518, "wrap.circuit_board.advanced")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_EXTREME_CIRCUIT_BOARD = this.addItem(519, "wrap.circuit_board.extreme")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_ELITE_CIRCUIT_BOARD = this.addItem(520, "wrap.circuit_board.elite")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_WETWARE_CIRCUIT_BOARD = this.addItem(521, "wrap.circuit_board.wetware")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_GOOWARE_CIRCUIT_BOARD = this.addItem(522, "wrap.circuit_board.gooware")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_OPTICAL_CIRCUIT_BOARD = this.addItem(523, "wrap.circuit_board.optical")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SPINTRONIC_CIRCUIT_BOARD = this.addItem(524, "wrap.circuit_board.spintronic")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SMD_TRANSISTOR = this.addItem(525, "wrap.smd.transistor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SMD_RESISTOR = this.addItem(526, "wrap.smd.resistor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SMD_CAPACITOR = this.addItem(527, "wrap.smd.capacitor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SMD_DIODE = this.addItem(528, "wrap.smd.diode")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SMD_INDUCTOR = this.addItem(529, "wrap.smd.inductor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_ADVANCED_SMD_TRANSISTOR = this.addItem(530, "wrap.advanced_smd.transistor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_ADVANCED_SMD_RESISTOR = this.addItem(531, "wrap.advanced_smd.resistor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_ADVANCED_SMD_CAPACITOR = this.addItem(532, "wrap.advanced_smd.capacitor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_ADVANCED_SMD_DIODE = this.addItem(533, "wrap.advanced_smd.diode")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_ADVANCED_SMD_INDUCTOR = this.addItem(534, "wrap.advanced_smd.inductor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_OPTICAL_SMD_TRANSISTOR = this.addItem(535, "wrap.optical_smd.transistor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_OPTICAL_SMD_RESISTOR = this.addItem(536, "wrap.optical_smd.resistor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_OPTICAL_SMD_CAPACITOR = this.addItem(537, "wrap.optical_smd.capacitor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_OPTICAL_SMD_DIODE = this.addItem(538, "wrap.optical_smd.diode")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_OPTICAL_SMD_INDUCTOR = this.addItem(539, "wrap.optical_smd.inductor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SPINTRONIC_SMD_TRANSISTOR = this.addItem(540, "wrap.spintronic_smd.transistor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SPINTRONIC_SMD_RESISTOR = this.addItem(541, "wrap.spintronic_smd.resistor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SPINTRONIC_SMD_CAPACITOR = this.addItem(542, "wrap.spintronic_smd.capacitor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SPINTRONIC_SMD_DIODE = this.addItem(543, "wrap.spintronic_smd.diode")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SPINTRONIC_SMD_INDUCTOR = this.addItem(544, "wrap.spintronic_smd.inductor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_COSMIC_SMD_TRANSISTOR = this.addItem(545, "wrap.cosmic_smd.transistor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_COSMIC_SMD_RESISTOR = this.addItem(546, "wrap.cosmic_smd.resistor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_COSMIC_SMD_CAPACITOR = this.addItem(547, "wrap.cosmic_smd.capacitor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_COSMIC_SMD_DIODE = this.addItem(548, "wrap.cosmic_smd.diode")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_COSMIC_SMD_INDUCTOR = this.addItem(549, "wrap.cosmic_smd.inductor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SUPRACAUSAL_SMD_TRANSISTOR = this.addItem(550, "wrap.supracausal_smd.transistor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SUPRACAUSAL_SMD_RESISTOR = this.addItem(551, "wrap.supracausal_smd.resistor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SUPRACAUSAL_SMD_CAPACITOR = this.addItem(552, "wrap.supracausal_smd.capacitor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SUPRACAUSAL_SMD_DIODE = this.addItem(553, "wrap.supracausal_smd.diode")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        WRAP_SUPRACAUSAL_SMD_INDUCTOR = this.addItem(554, "wrap.supracausal_smd.inductor")
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_WRAP);

        //  Singularities
        MAGIC_SINGULARITY = this.addItem(800, "singularity.magic")
                .addOreDict("singularityMagic");

        METRIC_SINGULARITY = this.addItem(801, "singularity.metric")
                .addOreDict("singularityMetric");

        EXOTIC_SINGULARITY = this.addItem(802, "singularity.exotic")
                .addOreDict("singularityExotic");

        ANCIENT_SINGULARITY = this.addItem(803, "singularity.ancient")
                .addOreDict("singularityAncient");

        VOID_SINGULARITY = this.addItem(804, "singularity.void")
                .addOreDict("singularityVoid");

        EIGEN_SINGULARITY = this.addItem(805, "singularity.eigen")
                .addOreDict("singularityEigen");

        WEIRD_SINGULARITY = this.addItem(806, "singularity.weird")
                .addOreDict("singularityWeird");

        //  Fluid Cores
        FLUID_CORE_T1 = this.addItem(900, "fluid_core.t1");
        FLUID_CORE_T2 = this.addItem(901, "fluid_core.t2");
        FLUID_CORE_T3 = this.addItem(902, "fluid_core.t3");
        FLUID_CORE_T4 = this.addItem(903, "fluid_core.t4");
        FLUID_CORE_T5 = this.addItem(904, "fluid_core.t5");
        FLUID_CORE_T6 = this.addItem(905, "fluid_core.t6");
        FLUID_CORE_T7 = this.addItem(906, "fluid_core.t7");
        FLUID_CORE_T8 = this.addItem(907, "fluid_core.t8");
        FLUID_CORE_T9 = this.addItem(908, "fluid_core.t9");
        FLUID_CORE_T10 = this.addItem(909, "fluid_core.t10");

        //  General Circuits
        GENERAL_CIRCUIT_ULV = this.addItem(910, "general_circuit.ulv")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ULV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GENERAL_CIRCUIT_LV = this.addItem(911, "general_circuit.lv")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GENERAL_CIRCUIT_MV = this.addItem(912, "general_circuit.mv")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GENERAL_CIRCUIT_HV = this.addItem(913, "general_circuit.hv")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.HV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GENERAL_CIRCUIT_EV = this.addItem(914, "general_circuit.ev")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.EV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GENERAL_CIRCUIT_IV = this.addItem(915, "general_circuit.iv")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.IV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GENERAL_CIRCUIT_LuV = this.addItem(916, "general_circuit.luv")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LuV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GENERAL_CIRCUIT_ZPM = this.addItem(917, "general_circuit.zpm")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GENERAL_CIRCUIT_UV = this.addItem(918, "general_circuit.uv")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GENERAL_CIRCUIT_UHV = this.addItem(919, "general_circuit.uhv")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GENERAL_CIRCUIT_UEV = this.addItem(920, "general_circuit.uev")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GENERAL_CIRCUIT_UIV = this.addItem(921, "general_circuit.uiv")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GENERAL_CIRCUIT_UXV = this.addItem(922, "general_circuit.uxv")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GENERAL_CIRCUIT_OpV = this.addItem(923, "general_circuit.opv")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);

        GENERAL_CIRCUIT_MAX = this.addItem(924, "general_circuit.max")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX)
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_CIRCUIT);


        //  Debug Items
        STRUCTURE_WRITER = this.addItem(10000, "debug.structure_writer")
                .addComponents(StructureWriterBehavior.INSTANCE)
                .addComponents(new TooltipBehavior((lines) -> {
                    lines.add(I18n.format("metaitem.debug.structure_writer.tooltip.1"));
                    lines.add(TooltipHelper.BLINKING_CYAN + I18n.format("metaitem.debug.structure_writer.tooltip.2"));
                    if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                        lines.add(I18n.format("metaitem.debug.structure_writer.tooltip.3"));
                        lines.add(I18n.format("metaitem.debug.structure_writer.tooltip.4"));
                        lines.add(I18n.format("metaitem.debug.structure_writer.tooltip.5"));
                        lines.add(I18n.format("metaitem.debug.structure_writer.tooltip.6"));
                        lines.add(I18n.format("metaitem.debug.structure_writer.tooltip.7"));
                        lines.add(I18n.format("metaitem.debug.structure_writer.tooltip.8"));
                        lines.add(I18n.format("metaitem.debug.structure_writer.tooltip.9"));
                        lines.add(I18n.format("metaitem.debug.structure_writer.tooltip.10"));
                    } else {
                        lines.add(I18n.format("gregtech.tooltip.hold_shift"));
                    }
                }))
                .setCreativeTabs(GTLiteAPI.TAB_GTLITE_TOOL);
    }
}
