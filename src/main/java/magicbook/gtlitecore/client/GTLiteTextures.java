package magicbook.gtlitecore.client;

import codechicken.lib.texture.TextureUtils;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SidedCubeRenderer;
import gregtech.client.renderer.texture.cube.SimpleOrientedCubeRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import magicbook.gtlitecore.client.renderer.GTLiteOverlayRenderer;
import magicbook.gtlitecore.client.renderer.texture.IndustrialCentrifugeRenderer;
import magicbook.gtlitecore.client.renderer.texture.IsaMillRenderer;
import magicbook.gtlitecore.client.renderer.texture.TurbineMixerRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;

import static magicbook.gtlitecore.api.utils.GTLiteUtils.gtliteId;

public class GTLiteTextures {

    //  Oriented Overlay Renderer
    public static final OrientedOverlayRenderer CHEMICAL_DRYER_OVERLAY = new OrientedOverlayRenderer("machines/chemical_dryer");
    public static final OrientedOverlayRenderer NAQUADAH_REACTOR_OVERLAY = new OrientedOverlayRenderer("machines/naquadah_reactor");
    public static final OrientedOverlayRenderer ROCKET_ENGINE_OVERLAY = new OrientedOverlayRenderer("machines/rocket_engine");
    public static final OrientedOverlayRenderer BIO_REACTOR_OVERLAY = new OrientedOverlayRenderer("machines/bio_reactor");
    public static final OrientedOverlayRenderer CONDENSER_OVERLAY = new OrientedOverlayRenderer("machines/condenser");
    public static final OrientedOverlayRenderer SIMULATOR_OVERLAY = new OrientedOverlayRenderer("machines/simulator");
    public static final OrientedOverlayRenderer BIOMASS_GENERATOR_OVERLAY = new OrientedOverlayRenderer("machines/biomass_generator");

    public static final OrientedOverlayRenderer INDUSTRIAL_DRILL_OVERLAY = new OrientedOverlayRenderer("multiblocks/industrial_drilling_reg");
    public static final OrientedOverlayRenderer CATALYTIC_REFORMER_OVERLAY = new OrientedOverlayRenderer("multiblocks/catalytic_reformer");
    public static final OrientedOverlayRenderer SONICATOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/sonicator");
    public static final OrientedOverlayRenderer HYDRAULIC_FRACKER_OVERLAY = new OrientedOverlayRenderer("multiblocks/hydraulic_fracker");
    public static final OrientedOverlayRenderer NANOSCALE_FABRICATOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/nanoscale_fabricator");
    public static final OrientedOverlayRenderer INDUSTRIAL_ROASTER_OVERLAY = new OrientedOverlayRenderer("multiblocks/industrial_roaster");
    public static final OrientedOverlayRenderer CRYSTALLIZATION_CRUCIBLE_OVERLAY = new OrientedOverlayRenderer("multiblocks/crystallization_crucible");
    public static final OrientedOverlayRenderer CVD_UNIT_OVERLAY = new OrientedOverlayRenderer("multiblocks/cvd_unit");
    public static final OrientedOverlayRenderer BURNER_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/burner_reactor");
    public static final OrientedOverlayRenderer CRYOGENIC_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/cryogenic_reactor");
    public static final OrientedOverlayRenderer ISA_MILL_OVERLAY = new OrientedOverlayRenderer("multiblocks/isa_mill");
    public static final OrientedOverlayRenderer FARM_OVERLAY = new OrientedOverlayRenderer("multiblocks/tree_growth_factory");
    public static final OrientedOverlayRenderer VIRTUAL_COSMOS_SIMULATOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/virtual_cosmos_simulator");
    public static final OrientedOverlayRenderer COLLIDER_OVERLAY = new OrientedOverlayRenderer("multiblocks/collider");
    public static final OrientedOverlayRenderer DIMENSIONAL_OSCILLATOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/dimensional_oscillator");
    public static final OrientedOverlayRenderer STELLAR_FURNACE_OVERLAY = new OrientedOverlayRenderer("multiblocks/stellar_furnace");
    public static final OrientedOverlayRenderer DECAY_GENERATOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/decay_generator");
    public static final OrientedOverlayRenderer SUPRACHRONAL_ASSEMBLY_LINE_OVERLAY = new OrientedOverlayRenderer("multiblocks/suprachronal_assembly_line");
    public static final OrientedOverlayRenderer SPACE_ELEVATOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/space_elevator");
    public static final OrientedOverlayRenderer LARGE_PROCESSING_FACTORY_OVERLAY = new OrientedOverlayRenderer("multiblocks/large_processing_factory");
    public static final OrientedOverlayRenderer MEGA_TURBINE_OVERLAY = new OrientedOverlayRenderer("multiblocks/mega_turbine");
    public static final OrientedOverlayRenderer NEUTRAL_NETWORK_NEXUS_OVERLAY = new OrientedOverlayRenderer("multiblocks/neutral_network_nexus");
    public static final OrientedOverlayRenderer QUANTUM_FORCE_TRANSFORMER_OVERLAY = new OrientedOverlayRenderer("multiblocks/quantum_force_transformer");
    public static final OrientedOverlayRenderer TURBINE_MIXER_OVERLAY = new OrientedOverlayRenderer("multiblocks/turbine_mixer");
    public static final OrientedOverlayRenderer INDUSTRIAL_CENTRIFUGE_OVERLAY = new OrientedOverlayRenderer("multiblocks/industrial_centrifuge");
    public static final OrientedOverlayRenderer COKING_TOWER_OVERLAY = new OrientedOverlayRenderer("multiblocks/coking_tower");
    public static final OrientedOverlayRenderer BIOWARE_SIMULATOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/bioware_simulator");
    public static final OrientedOverlayRenderer LARGE_ROCKET_ENGINE_OVERLAY = new OrientedOverlayRenderer("multiblocks/large_rocket_engine");
    public static final OrientedOverlayRenderer ALGAE_CULTURE_TANK_OVERLAY = new OrientedOverlayRenderer("multiblocks/algae_culture_tank");
    public static final OrientedOverlayRenderer LARGE_BIO_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/large_bio_reactor");
    public static final OrientedOverlayRenderer ELECTROMAGNETIC_SEPARATION_PLANT_OVERLAY = new OrientedOverlayRenderer("multiblocks/electromagnetic_separation_plant");
    public static final OrientedOverlayRenderer DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_OVERLAY = new OrientedOverlayRenderer("multiblocks/dimensionally_transcendent_plasma_forge");
    public static final OrientedOverlayRenderer LIGHTNING_ROD_OVERLAY = new OrientedOverlayRenderer("generators/lightning_rod");
    public static final OrientedOverlayRenderer DYSON_SWARM_OVERLAY = new OrientedOverlayRenderer("multiblocks/dyson_swarm");
    public static final OrientedOverlayRenderer LARGE_FLUID_PHASE_TRANSFORMER_OVERLAY = new OrientedOverlayRenderer("multiblocks/large_fluid_phase_transformer");
    public static final OrientedOverlayRenderer PRECISE_ASSEMBLER_OVERLAY = new OrientedOverlayRenderer("multiblocks/precise_assembler");
    public static final OrientedOverlayRenderer QUANTUM_COMPUTER_OVERLAY = new OrientedOverlayRenderer("multiblocks/quantum_computer");
    public static final OrientedOverlayRenderer PLANETARY_GAS_SIPHON_OVERLAY = new OrientedOverlayRenderer("multiblocks/planetary_gas_siphon");

    //  GTLite Overlay Renderer
    public static final GTLiteOverlayRenderer INCONEL_625_CASING = new GTLiteOverlayRenderer("casings/inconel_625_casing");
    public static final GTLiteOverlayRenderer HASTELLOY_N_CASING = new GTLiteOverlayRenderer("casings/hastelloy_n_casing");
    public static final GTLiteOverlayRenderer RED_STEEL_CASING = new GTLiteOverlayRenderer("casings/red_steel_casing_top");
    public static final GTLiteOverlayRenderer ADVANCED_INVAR_CASING = new GTLiteOverlayRenderer("casings/advanced_invar_casing");
    public static final GTLiteOverlayRenderer ADVANCED_ALUMINIUM_CASING = new GTLiteOverlayRenderer("casings/advanced_aluminium_casing");
    public static final GTLiteOverlayRenderer TALONITE_CASING = new GTLiteOverlayRenderer("casings/talonite_casing");
    public static final GTLiteOverlayRenderer NAQUADRIA_CASING = new GTLiteOverlayRenderer("casings/naquadria_casing");
    public static final GTLiteOverlayRenderer HASTELLOY_X78_CASING = new GTLiteOverlayRenderer("casings/hastelloy_x78_casing");
    public static final GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK1 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk1");
    public static final GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK2 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk2");
    public static final GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK3 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk3");
    public static final GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK4 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk4");
    public static final GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK5 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk5");
    public static final GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK6 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk6");
    public static final GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK7 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk7");
    public static final GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK8 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk8");
    public static final GTLiteOverlayRenderer IRIDIUM_CASING = new GTLiteOverlayRenderer("casings/iridium_casing");
    public static final GTLiteOverlayRenderer FARM_CASING = new GTLiteOverlayRenderer("casings/aseptic_farm_casing");
    public static final GTLiteOverlayRenderer HYPER_CASING = new GTLiteOverlayRenderer("casings/hyper_casing");
    public static final GTLiteOverlayRenderer ADVANCED_HYPER_CASING = new GTLiteOverlayRenderer("casings/advanced_hyper_casing");
    public static final GTLiteOverlayRenderer HIGH_ENERGY_CASING = new GTLiteOverlayRenderer("casings/high_energy_casing");
    public static final GTLiteOverlayRenderer ADVANCED_HIGH_ENERGY_CASING = new GTLiteOverlayRenderer("casings/advanced_high_energy_casing");
    public static final GTLiteOverlayRenderer ULTIMATE_HIGH_ENERGY_CASING = new GTLiteOverlayRenderer("casings/ultimate_high_energy_casing");
    public static final GTLiteOverlayRenderer TRITANIUM_CASING = new GTLiteOverlayRenderer("casings/tritanium_casing");
    public static final GTLiteOverlayRenderer ZIRCONIUM_CARBIDE_CASING = new GTLiteOverlayRenderer("casings/zirconium_carbide_casing");
    public static final GTLiteOverlayRenderer SPACE_ELEVATOR_CASING = new GTLiteOverlayRenderer("casings/spaces/basic_casing");
    public static final GTLiteOverlayRenderer STABALLOY_CASING = new GTLiteOverlayRenderer("casings/staballoy_casing");
    public static final GTLiteOverlayRenderer QUANTUM_CASING = new GTLiteOverlayRenderer("casings/quantum_casing");
    public static final GTLiteOverlayRenderer BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING = new GTLiteOverlayRenderer("casings/basic_photolithographic_framework_casing");
    public static final GTLiteOverlayRenderer HG_1223_CASING = new GTLiteOverlayRenderer("casings/hg_1223_casing");
    public static final GTLiteOverlayRenderer EGLIN_STEEL_CASING = new GTLiteOverlayRenderer("casings/eglin_steel_casing");
    public static final GTLiteOverlayRenderer INCONEL_792_CASING = new GTLiteOverlayRenderer("casings/inconel_792_casing");
    public static final GTLiteOverlayRenderer AUSTENITIC_STAINLESS_STEEL_CASING = new GTLiteOverlayRenderer("casings/austenitic_stainless_steel_casing");
    public static final GTLiteOverlayRenderer MAR_M200_STEEL_CASING = new GTLiteOverlayRenderer("casings/mar_m200_steel_casing");
    public static final GTLiteOverlayRenderer BIOWARE_COMPUTER_CASING = new GTLiteOverlayRenderer("casings/bioware_computer_casing_top");
    public static final GTLiteOverlayRenderer ADVANCED_BIOWARE_COMPUTER_CASING = new GTLiteOverlayRenderer("casings/bioware_computer_casing");
    public static final GTLiteOverlayRenderer HSS_S_CASING = new GTLiteOverlayRenderer("casings/hss_s_casing");
    public static final GTLiteOverlayRenderer EINSTEINIUM_CASING = new GTLiteOverlayRenderer("casings/einsteinium_casing");
    public static final GTLiteOverlayRenderer NITINOL_60_CASING = new GTLiteOverlayRenderer("casings/nitinol_60_casing");
    public static final GTLiteOverlayRenderer FERMIUM_CASING = new GTLiteOverlayRenderer("casings/fermium_casing");
    public static final GTLiteOverlayRenderer PROTACTINIUM_CASING = new GTLiteOverlayRenderer("casings/protactinium_casing");
    public static final GTLiteOverlayRenderer MENDELEVIUM_CASING = new GTLiteOverlayRenderer("casings/mendelevium_casing");
    public static final GTLiteOverlayRenderer HSS_G_CASING = new GTLiteOverlayRenderer("casings/hss_g_casing");
    public static final GTLiteOverlayRenderer INCOLOY_MA_813_CASING = new GTLiteOverlayRenderer("casings/incoloy_ma_813_casing");
    public static final GTLiteOverlayRenderer URANIUM_CASING = new GTLiteOverlayRenderer("casings/uranium_casing");
    public static final GTLiteOverlayRenderer POTIN_CASING = new GTLiteOverlayRenderer("casings/potin_casing");
    public static final GTLiteOverlayRenderer PLUTONIUM_CASING = new GTLiteOverlayRenderer("casings/plutonium_casing");
    public static final GTLiteOverlayRenderer BLACK_STEEL_CASING = new GTLiteOverlayRenderer("casings/black_steel_casing");
    public static final GTLiteOverlayRenderer TUMBAGA_CASING = new GTLiteOverlayRenderer("casings/tumbaga_casing");
    public static final GTLiteOverlayRenderer RHODIUM_PLATED_PALLADIUM_CASING = new GTLiteOverlayRenderer("casings/rhodium_plated_palladium_casing");
    public static final GTLiteOverlayRenderer NIOBIUM_TITANIUM_CASING = new GTLiteOverlayRenderer("casings/niobium_titanium_casing");
    public static final GTLiteOverlayRenderer BOTMIUM_CASING = new GTLiteOverlayRenderer("casings/botmium_casing");
    public static final GTLiteOverlayRenderer LAURENIUM_CASING = new GTLiteOverlayRenderer("casings/laurenium_casing");
    public static final GTLiteOverlayRenderer INCOLOY_DS_CASING = new GTLiteOverlayRenderer("casings/incoloy_ds_casing");
    public static final GTLiteOverlayRenderer MARAGING_STEEL_250_CASING = new GTLiteOverlayRenderer("casings/maraging_steel_250_casing");
    public static final GTLiteOverlayRenderer RURIDIT_CASING = new GTLiteOverlayRenderer("casings/ruridit_casing");
    public static final GTLiteOverlayRenderer OSMIRIDIUM_CASING = new GTLiteOverlayRenderer("casings/osmiridium_casing");
    public static final GTLiteOverlayRenderer FLUXED_ELECTRUM_CASING = new GTLiteOverlayRenderer("casings/fluxed_electrum_casing");
    public static final GTLiteOverlayRenderer RHODIUM_CASING = new GTLiteOverlayRenderer("casings/rhodium_casing");
    public static final GTLiteOverlayRenderer DIMENSIONAL_BRIDGE_CASING = new GTLiteOverlayRenderer("casings/dimensional_bridge_casing");
    public static final GTLiteOverlayRenderer NAQUADAH_ALLOY_CASING = new GTLiteOverlayRenderer("casings/naquadah_alloy_casing");
    public static final GTLiteOverlayRenderer INCOLOY_020_CASING = new GTLiteOverlayRenderer("casings/incoloy_020_casing");
    public static final GTLiteOverlayRenderer TANTALUM_CARBIDE_CASING = new GTLiteOverlayRenderer("casings/tantalum_carbide_casing");
    public static final GTLiteOverlayRenderer NAQUADAH_CASING = new GTLiteOverlayRenderer("casings/naquadah_casing");
    public static final GTLiteOverlayRenderer HATTRIUM_CASING = new GTLiteOverlayRenderer("casings/hattrium_casing");
    public static final GTLiteOverlayRenderer BERKELIUM_CASING = new GTLiteOverlayRenderer("casings/berkelium_casing");
    public static final GTLiteOverlayRenderer MULTIPART_GRIND_BALL_HATCH = new GTLiteOverlayRenderer("multiparts/overlay_grind_ball_hatch");

    //  Simple Overlay Renderer
    public static final SimpleOverlayRenderer QC_EMPTY_COMPONENT_OVERLAY = new SimpleOverlayRenderer("overlay/machine/quantum_computer/empty");
    public static final SimpleOverlayRenderer QC_COMPUTATION_COMPONENT_OVERLAY = new SimpleOverlayRenderer("overlay/machine/quantum_computer/computation");
    public static final SimpleOverlayRenderer QC_ADVANCED_COMPUTATION_COMPONENT_OVERLAY = new SimpleOverlayRenderer("overlay/machine/quantum_computer/computation_advanced");
    public static final SimpleOverlayRenderer QC_COMPUTATION_COMPONENT_ACTIVE_OVERLAY = new SimpleOverlayRenderer("overlay/machine/quantum_computer/computation_active");
    public static final SimpleOverlayRenderer QC_ADVANCED_COMPUTATION_COMPONENT_ACTIVE_OVERLAY = new SimpleOverlayRenderer("overlay/machine/quantum_computer/computation_advanced_active");
    public static final SimpleOverlayRenderer QC_HEAT_SINK_OVERLAY = new SimpleOverlayRenderer("overlay/machine/quantum_computer/heat_sink");
    public static final SimpleOverlayRenderer QC_ACTIVE_COOLER_OVERLAY = new SimpleOverlayRenderer("overlay/machine/quantum_computer/active_cooler");
    public static final SimpleOverlayRenderer QC_ACTIVE_COOLER_ACTIVE_OVERLAY = new SimpleOverlayRenderer("overlay/machine/quantum_computer/active_cooler_active");
    public static final SimpleOverlayRenderer QC_DAMAGED_OVERLAY = new SimpleOverlayRenderer("overlay/machine/quantum_computer/damaged");
    public static final SimpleOverlayRenderer QC_DAMAGED_ACTIVE_OVERLAY = new SimpleOverlayRenderer("overlay/machine/quantum_computer/damaged_active");
    public static final SimpleOverlayRenderer QC_ADVANCED_DAMAGED_OVERLAY = new SimpleOverlayRenderer("overlay/machine/quantum_computer/damaged_advanced");
    public static final SimpleOverlayRenderer QC_ADVANCED_DAMAGED_ACTIVE_OVERLAY = new SimpleOverlayRenderer("overlay/machine/quantum_computer/damaged_advanced_active");
    public static final SimpleOverlayRenderer QC_BRIDGE_OVERLAY = new SimpleOverlayRenderer("overlay/machine/quantum_computer/bridge");
    public static final SimpleOverlayRenderer QC_BRIDGE_ACTIVE_OVERLAY = new SimpleOverlayRenderer("overlay/machine/quantum_computer/bridge_active");

    //  Simple Oriented Cube Renderer
    public static final SimpleOrientedCubeRenderer ADVANCED_FILTER_IRIDIUM_FRONT = new SimpleOrientedCubeRenderer("casings/advanced_filter_iridium_front");
    public static final SimpleOrientedCubeRenderer ADVANCED_GRATE_OSMIRIDIUM_FRONT = new SimpleOrientedCubeRenderer("casings/advanced_grate_osmiridium_front");
    public static final SimpleOrientedCubeRenderer FORCE_FIELD_CONSTRAINED_CASING = new SimpleOrientedCubeRenderer("casings/force_field_constrained_casing");
    public static final SimpleOrientedCubeRenderer RECEIVER_CASING = new SimpleOrientedCubeRenderer("casings/receiver_casing");

    //  Sided Cube Renderer
    public static final ICubeRenderer COMPUTER_CASING = new SidedCubeRenderer("casings/quantum_computer_casing");
    public static final ICubeRenderer ADVANCED_COMPUTER_CASING = new SidedCubeRenderer("casings/advanced_quantum_computer_casing");

    //  Custom Renderer
    public static IsaMillRenderer ISA_MILL = new IsaMillRenderer();
    public static TurbineMixerRenderer TURBINE_MIXER = new TurbineMixerRenderer();
    public static IndustrialCentrifugeRenderer INDUSTRIAL_CENTRIFUGE = new IndustrialCentrifugeRenderer();

    //  Multi Renderer
    public static TextureAtlasSprite HALO;
    public static TextureAtlasSprite HALO_NOISE;
    public static TextureAtlasSprite[] COSMIC;
    public static TextureAtlasSprite COSMIC_0;
    public static TextureAtlasSprite COSMIC_1;
    public static TextureAtlasSprite COSMIC_2;
    public static TextureAtlasSprite COSMIC_3;
    public static TextureAtlasSprite COSMIC_4;
    public static TextureAtlasSprite COSMIC_5;
    public static TextureAtlasSprite COSMIC_6;
    public static TextureAtlasSprite COSMIC_7;
    public static TextureAtlasSprite COSMIC_8;
    public static TextureAtlasSprite COSMIC_9;
    public static TextureAtlasSprite FORCE_FIELD;

    public GTLiteTextures() {}

    public static void register(TextureMap textureMap) {
        HALO = textureMap.registerSprite(gtliteId("items/halo"));
        HALO_NOISE = textureMap.registerSprite(gtliteId("items/halo_noise"));
        COSMIC_0 = textureMap.registerSprite(gtliteId("shader/cosmic_0"));
        COSMIC_1 = textureMap.registerSprite(gtliteId("shader/cosmic_1"));
        COSMIC_2 = textureMap.registerSprite(gtliteId("shader/cosmic_2"));
        COSMIC_3 = textureMap.registerSprite(gtliteId("shader/cosmic_3"));
        COSMIC_4 = textureMap.registerSprite(gtliteId("shader/cosmic_4"));
        COSMIC_5 = textureMap.registerSprite(gtliteId("shader/cosmic_5"));
        COSMIC_6 = textureMap.registerSprite(gtliteId("shader/cosmic_6"));
        COSMIC_7 = textureMap.registerSprite(gtliteId("shader/cosmic_7"));
        COSMIC_8 = textureMap.registerSprite(gtliteId("shader/cosmic_8"));
        COSMIC_9 = textureMap.registerSprite(gtliteId("shader/cosmic_9"));
        COSMIC = new TextureAtlasSprite[] {
                COSMIC_0,
                COSMIC_1,
                COSMIC_2,
                COSMIC_3,
                COSMIC_4,
                COSMIC_5,
                COSMIC_6,
                COSMIC_7,
                COSMIC_8,
                COSMIC_9
        };
        FORCE_FIELD = textureMap.registerSprite(gtliteId("blocks/multiblocks/quantum_force_transformer/force_field"));
    }

    public static void preInit() {
        TextureUtils.addIconRegister(GTLiteTextures::register);
    }
}
