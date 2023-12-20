package magicbook.gtlitecore.api.recipe;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.builders.BlastRecipeBuilder;
import gregtech.api.recipes.builders.FuelRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import magicbook.gtlitecore.api.recipe.builder.*;
import magicbook.gtlitecore.api.recipe.machines.RecipeMapComponentAssemblyLine;
import magicbook.gtlitecore.api.recipe.machines.RecipeMapPreciseAssembler;
import magicbook.gtlitecore.api.recipe.machines.RecipeMapPseudoGroup;
import magicbook.gtlitecore.api.recipe.machines.RecipeMapSuprachronalAssemblyLine;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenExpansion("mods.gregtech.recipe.RecipeMaps")
@ZenRegister
public class GTLiteRecipeMaps {

    //  Single Machine RecipeMaps
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> CHEMICAL_DRYER_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> VACUUM_CHAMBER_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> NAQUADAH_REACTOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> ROCKET_ENGINE_RECIPES;

    //  Multiblock Machine RecipeMaps
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DRILLING_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> CATALYTIC_REFORMER_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> SONICATION_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> MOLECULAR_BEAM_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> INDUSTRIAL_ROASTER_RECIPES;
    @ZenProperty
    public static final RecipeMap<BlastRecipeBuilder> CRYSTALLIZATION_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> CVD_UNIT_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> PLASMA_CVD_UNIT_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> LASER_CVD_UNIT_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> BURNER_REACTOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> CRYOGENIC_REACTOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> FUEL_REFINE_FACTORY_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK1_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK2_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK3_RECIPES;
    @ZenProperty
    public static final RecipeMap<GrindBallRecipeBuilder> ISA_MILL_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> FLOTATION_RECIPES;
    @ZenProperty
    public static final RecipeMap<BlastRecipeBuilder> VACUUM_DRYING_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DRONE_AIRPORT_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> ION_IMPLANTATOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<AssemblyCasingTierRecipeBuilder> PRECISE_ASSEMBLER_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> COMPONENT_ASSEMBLER_RECIPES;
    @ZenProperty
    public static final RecipeMap<ComponentCasingTierRecipeBuilder> COMPONENT_ASSEMBLY_LINE_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> TREE_GROWTH_RECIPES;
    @ZenProperty
    public static final RecipeMap<FieldCasingTierRecipeBuilder> COLLIDER_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DIMENSIONAL_OSCILLATOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilHigherTemperatureRecipeBuilder> STELLAR_FURNACE_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PLASMA_CONDENSER_RECIPES;
    @ZenProperty
    public static final RecipeMap<FieldCasingTierRecipeBuilder> DECAY_GENERATOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> SUPRACHRONAL_ASSEMBLY_LINE_RECIPES;
    @ZenProperty
    public static final RecipeMap<SpaceElevatorCasingTierRecipeBuilder> SPACE_ELEVATOR_DRILLING_MODULE;
    @ZenProperty
    public static final RecipeMap<SpaceElevatorCasingTierRecipeBuilder> SPACE_ELEVATOR_MINING_MODULE;
    @ZenProperty
    public static final RecipeMap<SpaceElevatorCasingTierRecipeBuilder> SPACE_ELEVATOR_ASSEMBLING_MODULE;
    @ZenProperty
    public static final RecipeMapPseudoGroup<SimpleRecipeBuilder> PROCESSING_MODE_A;
    @ZenProperty
    public static final RecipeMapPseudoGroup<SimpleRecipeBuilder> PROCESSING_MODE_B;
    @ZenProperty
    public static final RecipeMapPseudoGroup<SimpleRecipeBuilder> PROCESSING_MODE_C;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> MOLECULAR_TRANSFORMER_RECIPES;
    @ZenProperty
    public static final RecipeMap<AltitudeRecipeBuilder> COSMIC_RAY_DETECTOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PCB_FACTORY_ETCH_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PCB_FACTORY_BIO_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PCB_FACTORY_NANO_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> NEUTRAL_NETWORK_NEXUS_BREEDING_MODE;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> NEUTRAL_NETWORK_NEXUS_HYBRIDIZING_MODE;
    @ZenProperty
    public static final RecipeMap<FieldCasingTierRecipeBuilder> QUANTUM_FORCE_TRANSFORMER_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> TURBINE_MIXER_RECIPES;
    @ZenProperty
    public static final RecipeMap<FlowRateRecipeBuilder> HEAT_EXCHANGE_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> BIO_REACTOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HIGH_PRESSURE_STEAM_TURBINE_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> SUPERCRITICAL_STEAM_TURBINE_RECIPES;

    public GTLiteRecipeMaps() {}

    static {
        //  Chemical Dryer RecipeMap
        CHEMICAL_DRYER_RECIPES = new RecipeMap<>("chemical_dryer_recipes", 1, 2, 1, 1, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
                .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, false, false, GuiTextures.DUST_OVERLAY)
                .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
                .setSound(GTSoundEvents.FURNACE);
        //  Vacuum Chamber RecipeMap
        VACUUM_CHAMBER_RECIPES = new RecipeMap<>("vacuum_chamber_recipes", 4, 1, 2, 1, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, GuiTextures.CIRCUIT_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ASSEMBLER);
        //  Naquadah Reactor RecipeMap
        NAQUADAH_REACTOR_RECIPES = new RecipeMap<>("naquadah_reactor_recipes", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COMBUSTION)
                .allowEmptyOutput();

        //  Rocket Engine RecipeMap
        ROCKET_ENGINE_RECIPES = new RecipeMap<>("rocket_engine_recipes", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
                .setSound(GTSoundEvents.COMBUSTION)
                .allowEmptyOutput();

        //  Industrial Drilling Reg RecipeMap
        DRILLING_RECIPES = new RecipeMap<>("drill_recipes", 1, 1, 0, 1, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
                .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
                .setSound(GTSoundEvents.MACERATOR);
        //  Catalytic Reformer RecipeMap
        CATALYTIC_REFORMER_RECIPES = new RecipeMap<>("catalytic_reformer_recipes", 1, 0, 1, 4, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CRACKING, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.FURNACE);
        //  Sonicator RecipeMap
        SONICATION_RECIPES = new RecipeMap<>("sonication_recipes", 0, 1, 2, 1, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, true, false, GuiTextures.BREWER_OVERLAY)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSlotOverlay(true, false, true, GTLiteGuiTextures.FOIL_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.CENTRIFUGE);
        //  Nanoscale Fabricator RecipeMap
        MOLECULAR_BEAM_RECIPES = new RecipeMap<>("molecular_beam_recipes", 6, 1, 2,  0, new NoCoilTemperatureRecipeBuilder(), false)
                .setSlotOverlay(false, false, false, GTLiteGuiTextures.NANOSCALE_OVERLAY_1)
                .setSlotOverlay(false, false, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_1)
                .setSlotOverlay(false, true, false, GTLiteGuiTextures.NANOSCALE_OVERLAY_2)
                .setSlotOverlay(false, true, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_2)
                .setSlotOverlay(true, false, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_1)
                .setSlotOverlay(true, true, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_2)
                .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_NANOSCALE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ELECTROLYZER);
        //  Industrial Roaster RecipeMap
        INDUSTRIAL_ROASTER_RECIPES = new RecipeMap<>("industrial_roaster_recipes", 3, 3, 3,  3, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.FURNACE);
        //  Crystallization Crucible RecipeMap
        CRYSTALLIZATION_RECIPES = new RecipeMap<>("crystallization_recipes", 6, 1, 3, 0, new BlastRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.FURNACE);
        //  CVD Unit RecipeMap
        CVD_UNIT_RECIPES = new RecipeMap<>("cvd_unit_recipes", 2, 2, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COOLING);
        //  Plasma CVD Unit RecipeMap
        PLASMA_CVD_UNIT_RECIPES = new RecipeMap<>("plasma_cvd_unit_recipes", 2, 2, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COOLING);
        //  Laser CVD Unit RecipeMap
        LASER_CVD_UNIT_RECIPES = new RecipeMap<>("laser_cvd_unit_recipes", 2, 2, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COOLING);
        //  Burner Reactor RecipeMap
        BURNER_REACTOR_RECIPES = new RecipeMap<>("burner_reactor_recipes", 3, 3, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC);
        //  Cryogenic Reactor RecipeMap
        CRYOGENIC_REACTOR_RECIPES = new RecipeMap<>("cryogenic_reactor_recipes", 3, 2, 3, 2, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COOLING);
        //  Fuel Refine Factory RecipeMap
        FUEL_REFINE_FACTORY_RECIPES = new RecipeMap<>("fuel_refine_factory_recipes", 3, 4, 4, 2, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
                .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
                .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.CHEMICAL_REACTOR);
        //  Hyper Reactor Mk I RecipeMap
        HYPER_REACTOR_MK1_RECIPES = new RecipeMap<>("hyper_reactor_mk1_recipes", 0, 0, 1,0 , new FuelRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC)
                .allowEmptyOutput();
        //  Hyper Reactor Mk II RecipeMap
        HYPER_REACTOR_MK2_RECIPES = new RecipeMap<>("hyper_reactor_mk2_recipes", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC)
                .allowEmptyOutput();
        //  Hyper Reactor Mk III RecipeMap
        HYPER_REACTOR_MK3_RECIPES = new RecipeMap<>("hyper_reactor_mk3_recipes", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC)
                .allowEmptyOutput();
        //  Isa Mill RecipeMap
        ISA_MILL_RECIPES = new RecipeMap<>("isa_mill_recipes", 3, 3, 0, 0, new GrindBallRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.MACERATOR);
        //  Flotation Cell Regulator RecipeMap
        FLOTATION_RECIPES = new RecipeMap<>("flotation_recipes", 6, 0, 1, 1, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.BATH);
        //  Vacuum Drying Furnace RecipeMap
        VACUUM_DRYING_RECIPES = new RecipeMap<>("vacuum_drying_recipes", 1, 9, 2, 0, new BlastRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.HORIZONTAL)
                .setSlotOverlay(false, false, false, GuiTextures.FURNACE_OVERLAY_1)
                .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
                .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, true, false, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSound(GTSoundEvents.FURNACE);
        //  Drone Airport RecipeMap
        DRONE_AIRPORT_RECIPES = new RecipeMap<>("drone_airport_recipes", 2, 9, 1, 0, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
                .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSound(GTSoundEvents.COMPUTATION);
        //  Ion Implantator RecipeMap
        ION_IMPLANTATOR_RECIPES = new RecipeMap<>("ion_implantator_recipes", 3, 1, 1, 0, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ELECTROLYZER);
        //  Precise Assembler RecipeMap
        PRECISE_ASSEMBLER_RECIPES = new RecipeMapPreciseAssembler<>("precise_assembler_recipes", 4, 1, 4, 0, new AssemblyCasingTierRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
                .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
                .setSound(GTSoundEvents.ASSEMBLER);
        //  Component Assembler RecipeMap
        COMPONENT_ASSEMBLER_RECIPES = new RecipeMap<>("component_assembler_recipes", 6, 1, 1, 0, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
                .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
                .setSound(GTSoundEvents.ASSEMBLER);

        //  Component Assembly Line RecipeMap
        COMPONENT_ASSEMBLY_LINE_RECIPES = new RecipeMapComponentAssemblyLine<>("component_assembly_line_recipes", 12, 1, 12, 0, new ComponentCasingTierRecipeBuilder(), false)
                .setSound(GTSoundEvents.ASSEMBLER);

        //  Tree Growth Factory RecipeMap
        TREE_GROWTH_RECIPES = new RecipeMap<>("tree_growth_recipes", 2, 4, 2, 0, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSound(GTSoundEvents.CHAINSAW_TOOL);

        //  Collider RecipeMap
        COLLIDER_RECIPES = new RecipeMap<>("collider_recipes", 6, 6, 6, 6, new FieldCasingTierRecipeBuilder(), false)
                .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
                .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
                .setSlotOverlay(true, false, false, GuiTextures.IMPLOSION_OVERLAY_1)
                .setSlotOverlay(true, false, true, GuiTextures.IMPLOSION_OVERLAY_1)
                .setSound(GTSoundEvents.SCIENCE);

        //  Dimensional Oscillator RecipeMap
        DIMENSIONAL_OSCILLATOR_RECIPES = new RecipeMap<>("dimensional_oscillator_recipes", 3, 3, 3, 3, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
                .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
                .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_1)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_1)
                .setSlotOverlay(true, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
                .setSlotOverlay(true, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
                .setSlotOverlay(true, true, false, GuiTextures.MOLECULAR_OVERLAY_2)
                .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_2)
                .setSound(GTSoundEvents.SCIENCE);

        //  Stellar Furnace RecipeMap
        STELLAR_FURNACE_RECIPES = new RecipeMap<>("stellar_furnace_recipes", 6, 6, 6, 6, new NoCoilHigherTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_MASS_FAB, ProgressWidget.MoveType.HORIZONTAL)
                .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, true, false, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSound(GTSoundEvents.ARC);

        //  Plasma Condenser RecipeMap
        PLASMA_CONDENSER_RECIPES = new RecipeMap<>("plasma_condenser_recipes", 3, 3, 3, 3, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_REPLICATOR, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC);

        //  Decay Generator RecipeMap
        DECAY_GENERATOR_RECIPES = new RecipeMap<>("decay_generator_recipes", 1, 1, 1, 1, new FieldCasingTierRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_HAMMER, ProgressWidget.MoveType.VERTICAL_DOWNWARDS)
                .setSound(GTSoundEvents.SCIENCE);

        //  Suprachronal Assembly Line RecipeMap
        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES = new RecipeMapSuprachronalAssemblyLine<>("suprachronal_assembly_line_recipes", 16, 1, 4, 0, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, false, GuiTextures.BOX_OVERLAY)
                .setSlotOverlay(false, false, true, GuiTextures.BOX_OVERLAY)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSlotOverlay(true, false, GuiTextures.BOX_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ASSEMBLY_LINE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.REPLICATOR);

        //  Space Elevator Drilling Module RecipeMap
        SPACE_ELEVATOR_DRILLING_MODULE = new RecipeMap<>("space_elevator_drilling_module", 4, 0, 2, 1, new SpaceElevatorCasingTierRecipeBuilder(), false)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setProgressBar(GuiTextures.PROGRESS_BAR_FLUID_RIG_DEPLETION, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.DRILL_TOOL);

        //  Space Elevator Mining Module
        SPACE_ELEVATOR_MINING_MODULE = new RecipeMap<>("space_elevator_mining_module", 4, 9, 2, 0, new SpaceElevatorCasingTierRecipeBuilder(), false)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.MINER);

        //  Space Elevator Assembling Module
        SPACE_ELEVATOR_ASSEMBLING_MODULE = new RecipeMapSuprachronalAssemblyLine<>("space_elevator_assembling_module", 16, 1, 4, 0, new SpaceElevatorCasingTierRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ASSEMBLY_LINE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ASSEMBLER);

        //  Large Processing Factory
        PROCESSING_MODE_A = new RecipeMapPseudoGroup<>("processing_mode_a", 1, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.COMPRESSOR_RECIPES, RecipeMaps.LATHE_RECIPES, RecipeMaps.POLARIZER_RECIPES, true);
        PROCESSING_MODE_B = new RecipeMapPseudoGroup<>("processing_mode_b", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.FERMENTING_RECIPES, RecipeMaps.EXTRACTOR_RECIPES, RecipeMaps.CANNER_RECIPES, true);
        PROCESSING_MODE_C = new RecipeMapPseudoGroup<>("processing_mode_c", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.LASER_ENGRAVER_RECIPES, RecipeMaps.AUTOCLAVE_RECIPES, RecipeMaps.FLUID_SOLIDFICATION_RECIPES, true);

        //  Molecular Transformer RecipeMap
        MOLECULAR_TRANSFORMER_RECIPES = new RecipeMap<>("molecular_transformer_recipes", 1, 1, 0, 0, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_1)
                .setSlotOverlay(true, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
                .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.SCIENCE);

        //  Cosmic Ray Detector RecipeMap
        COSMIC_RAY_DETECTOR_RECIPES = new RecipeMap<>("cosmic_ray_detector_recipes", 4, 4, 2, 2, new AltitudeRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_MASS_FAB, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.SCIENCE);

        //  PCB Factory Etch RecipeMap
        PCB_FACTORY_ETCH_RECIPES = new RecipeMap<>("pcb_factory_etch_recipes", 6, 1, 3, 0, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
                .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ASSEMBLER);

        //  PCB Factory Bio RecipeMap
        PCB_FACTORY_BIO_RECIPES = new RecipeMap<>("pcb_factory_bio_recipes", 6, 1, 3, 0, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ASSEMBLER);

        //  PCB Factory Nano RecipeMap
        PCB_FACTORY_NANO_RECIPES = new RecipeMap<>("pcb_factory_nano_recipes", 6, 1, 3, 0, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(true, false, true, GuiTextures.SCANNER_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ASSEMBLER);

        //  Neutral Network Nexus RecipeMaps
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE = new RecipeMap<>("neutral_network_nexus_breeding_mode", 6, 6, 3, 3, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSound(GTSoundEvents.ASSEMBLER);

        NEUTRAL_NETWORK_NEXUS_HYBRIDIZING_MODE = new RecipeMap<>("neutral_network_nexus_hybridizing_mode", 6, 6, 3, 3, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSound(GTSoundEvents.ASSEMBLER);

        //  Quantum Force Transformer RecipeMap
        QUANTUM_FORCE_TRANSFORMER_RECIPES = new RecipeMap<>("quantum_force_transformer_recipes", 6, 6, 6, 6, new FieldCasingTierRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.SCIENCE);

        //  Turbine Mixer RecipeMap
        TURBINE_MIXER_RECIPES = new RecipeMap<>("turbine_mixer_recipes", 9, 1, 6, 1, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, GuiTextures.DUST_OVERLAY)
                .setSlotOverlay(true, false, GuiTextures.DUST_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressWidget.MoveType.CIRCULAR)
                .setSound(GTSoundEvents.MIXER);

        //  Heat Exchanger RecipeMap
        HEAT_EXCHANGE_RECIPES = new RecipeMap<>("heat_exchanger_recipes", 0, 0, 2, 3, new FlowRateRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC);

        //  Bio Reactor RecipeMap
        BIO_REACTOR_RECIPES = new RecipeMap<>("bio_reactor_recipes", 6, 1, 2, 1, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, false, GuiTextures.DUST_OVERLAY)
                .setSlotOverlay(false, false, true, GTLiteGuiTextures.DISH_OVERLAY)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
                .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.CHEMICAL_REACTOR);

        //  High Pressure Steam Turbine RecipeMap
        HIGH_PRESSURE_STEAM_TURBINE_RECIPES = new RecipeMap<>("high_pressure_steam_turbine_recipes", 0, 0, 1, 1, new FuelRecipeBuilder(), false);

        //  Supercritical Steam Turbine RecipeMap
        SUPERCRITICAL_STEAM_TURBINE_RECIPES = new RecipeMap<>("supercritical_steam_turbine_recipes", 0, 0, 1, 1, new FuelRecipeBuilder(), false);
    }
}