package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.Neutronium;
import static gregtech.api.unification.material.Materials.SolderingAlloy;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.GTLiteValues.MINUTE;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class SupracausalCircuits {

    public static void init() {
        CircuitBoard();
        CircuitComponent();
        SMDs();
        Circuits();
    }

    private static void CircuitBoard() {

        //  Supracausal Board
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(COSMIC_INFORMATION_MODULE)
                .input(plate, BlackDwarfMatter, 2)
                .input(plate, Hypogen, 2)
                .input(STABILIZED_WORMHOLE_GENERATOR)
                .input(swarm, CarbonNanotube)
                .input(wireFine, Hikarium, 8)
                .fluidInputs(Galaxium.getFluid(L))
                .output(SPACETIME_CONDENSER)
                .EUt(VA[UXV])
                .duration(SECOND)
                .stationResearch(b -> b
                        .researchStack(COSMIC_INFORMATION_MODULE.getStackForm())
                        .EUt(VA[UXV])
                        .CWUt(256))
                .buildAndRegister();

        //  Supracausal Processing Unit
        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(frameGt, TantalumHafniumSeaborgiumCarbide)
                .input(SPACETIME_CONDENSER)
                .input(plate, CosmicFabric, 4)
                .input(NUCLEAR_CLOCK)
                .input(TOPOLOGICAL_MANIPULATOR_UNIT)
                .input(GRAVITON_TRANSDUCER)
                .input(EIGENFOLDED_SPACETIME_MANIFOLD)
                .input(RELATIVISTIC_SPINORIAL_MEMORY_SYSTEM)
                .input(BOSE_EINSTEIN_CONDENSATE, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .input(wireGtSingle, HeavyQuarkDegenerateMatter, 2)
                .fluidInputs(CosmicComputingMixture.getFluid(4000))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(2000))
                .fluidInputs(Spacetime.getFluid(1000))
                .fluidInputs(CosmicNeutronium.getFluid(1000))
                .output(LIGHT_CONE_MODULE, 2)
                .EUt(VA[UXV])
                .duration(SECOND)
                .tier(5)
                .buildAndRegister();

    }

    private static void CircuitComponent() {

        //  Contained RN Singularity -> Contained KN Singularity
        //  back to Stellar Furnace recipes

        //  Contained KN Singularity -> Contained Kerr Singularity
        CANNER_RECIPES.recipeBuilder()
                .input(CONTAINED_KN_SINGULARITY)
                .fluidInputs(FreeElectronGas.getFluid(1000))
                .output(CONTAINED_KERR_SINGULARITY)
                .EUt(VA[UEV])
                .duration(2 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Macrowormhole Generator -> Recursively Folded Negative Space -> Eigenfolded Spacetime Manifold
        //  back to Stellar Furnace recipes

        //  Graviton Transducer
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(QCD_PROTECTIVE_PLATING, 2)
                .input(CONTAINED_RN_SINGULARITY)
                .input(MICROWORMHOLE_GENERATOR)
                .input(SENSOR_UXV)
                .fluidInputs(HiggsBosons.getFluid(L * 4))
                .output(GRAVITON_TRANSDUCER)
                .EUt(VA[UXV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Relativistic Spinorial Memory
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Neutronium)
                .input(FIELD_GENERATOR_UXV)
                .input(BATTERY_UXV_LANTHANUM_NICKEL_OXIDE)
                .input(wireFine, HeavyQuarkDegenerateMatter, 4)
                .fluidInputs(Instantons.getFluid(L * 4))
                .output(RELATIVISTIC_SPINORIAL_MEMORY_SYSTEM)
                .EUt(VA[UXV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Topological Manipulator Unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(QCD_PROTECTIVE_PLATING)
                .input(plate, Spacetime)
                .input(CONTAINED_KN_SINGULARITY)
                .input(EMITTER_UXV)
                .fluidInputs(TemporalFluid.getFluid(L * 4))
                .output(TOPOLOGICAL_MANIPULATOR_UNIT)
                .EUt(VA[UXV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Microwormhole Generator
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Orichalcum)
                .input(FIELD_GENERATOR_UHV)
                .input(CONTAINED_KERR_SINGULARITY)
                .input(wireFine, Vibranium, 4)
                .fluidInputs(Taranium.getFluid(L * 4))
                .output(MICROWORMHOLE_GENERATOR)
                .EUt(VA[UXV])
                .duration(SECOND)
                .tier(7) // UXV
                .buildAndRegister();

        //  Macrowormhole Generator
        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(plate, AstralTitanium)
                .input(FIELD_GENERATOR_UEV)
                .input(CONTAINED_HIGH_DENSITY_PROTONIC_MATTER)
                .input(MICROWORMHOLE_GENERATOR)
                .input(CONTAINED_KERR_SINGULARITY)
                .input(BATTERY_UEV_LITHIUM_SULFIDE)
                .fluidInputs(CelestialTungsten.getFluid(L * 4))
                .output(MACROWORMHOLE_GENERATOR)
                .EUt(VA[UXV])
                .duration(SECOND)
                .tier(5)
                .buildAndRegister();

        //  Stabilized Wormhole Generator
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(plate, Periodicium)
                .input(FIELD_GENERATOR_UXV)
                .input(CONTAINED_EXOTIC_MATTER)
                .input(MACROWORMHOLE_GENERATOR)
                .input(BATTERY_UXV_LANTHANUM_NICKEL_OXIDE)
                .fluidInputs(QuantumchromodynamicallyConfinedMatter.getFluid(L * 4))
                .output(STABILIZED_WORMHOLE_GENERATOR)
                .EUt(VA[UXV])
                .duration(SECOND)
                .stationResearch(b -> b
                        .researchStack(MACROWORMHOLE_GENERATOR.getStackForm())
                        .EUt(VA[UXV])
                        .CWUt(256))
                .buildAndRegister();

        //  Contained High Density Protonic Matter -> Contained Exotic Matter
        //  back to Stellar Furnace recipes

        //  Supracausal RAM
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(RANDOM_ACCESS_MEMORY)
                .input(plate, TransitionLAlloy, 2)
                .input(plate, BlackDwarfMatter, 2)
                .input(springSmall, WhiteDwarfMatter)
                .input(wireFine, HeavyQuarkDegenerateMatter, 4)
                .input(bolt, Taranium, 2)
                .output(SUPRACAUSAL_MEMORY_CHIP, 4)
                .EUt(VA[UXV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

    }

    private static void SMDs() {

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, WhiteDwarfMatter, 8)
                .input(plate, NeutroniumNanotube)
                .input(plate, Periodicium)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_TRANSISTOR, 32)
                .EUt(VA[UIV])
                .duration(8 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CVD_UNIT_RECIPES.recipeBuilder()
                .input(dust, ChargedCaesiumCeriumCobaltIndiumAlloy)
                .input(wireFine, QuantumchromodynamicallyConfinedMatter, 4)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_RESISTOR, 32)
                .EUt(VA[UIV])
                .duration(8 * SECOND)
                .temperature(6675)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_CVD_UNIT_RECIPES.recipeBuilder()
                .input(wireFine, BlackDwarfMatter, 8)
                .input(plate, Hypogen)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_CAPACITOR, 32)
                .EUt(VA[UIV])
                .duration(8 * SECOND)
                .temperature(7432)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, Spacetime)
                .input(dust, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(wireFine, HeavyQuarkDegenerateMatter, 8)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_DIODE, 32)
                .EUt(VA[UIV])
                .duration(8 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ION_IMPLANTATOR_RECIPES.recipeBuilder()
                .input(ring, TantalumHafniumSeaborgiumCarbide, 2)
                .input(wireFine, CosmicNeutronium, 4)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_INDUCTOR, 32)
                .EUt(VA[UIV])
                .duration(8 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void Circuits() {

        //  Supracausal Processor
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(LIGHT_CONE_MODULE)
                .input(INTRAVITAL_SOC)
                .input(SUPRACAUSAL_RESISTOR, 8)
                .input(SUPRACAUSAL_CAPACITOR, 8)
                .input(SUPRACAUSAL_TRANSISTOR, 8)
                .input(wireFine, Hypogen, 8)
                .solderMultiplier(1)
                .output(SUPRACAUSAL_PROCESSOR, 2)
                .EUt(VA[UXV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Supracausal Assembly
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SPACETIME_CONDENSER)
                .input(SUPRACAUSAL_PROCESSOR, 2)
                .input(SUPRACAUSAL_INDUCTOR, 6)
                .input(SUPRACAUSAL_CAPACITOR, 12)
                .input(SUPRACAUSAL_MEMORY_CHIP, 24)
                .input(wireFine, Hypogen, 16)
                .solderMultiplier(2)
                .output(SUPRACAUSAL_ASSEMBLY, 2)
                .EUt(VA[UXV])
                .duration(20 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Supracausal Supercomputer
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(SPACETIME_CONDENSER)
                .input(SUPRACAUSAL_ASSEMBLY, 2)
                .input(SUPRACAUSAL_DIODE, 8)
                .input(COSMIC_CPU_CHIP, 16) // TODO new chip or not
                .input(SUPRACAUSAL_MEMORY_CHIP, 32)
                .input(wireFine, HeavyQuarkDegenerateMatter, 24)
                .input(foil, Hikarium, 32)
                .input(plate, BlackDwarfMatter, 4)
                .fluidInputs(SolderingAlloy.getFluid(34560))
                .fluidInputs(Kevlar.getFluid(18432))
                .fluidInputs(Zylon.getFluid(9216))
                .fluidInputs(Hypogen.getFluid(4608))
                .output(SUPRACAUSAL_COMPUTER)
                .EUt(VA[UXV])
                .duration(20 * SECOND)
                .stationResearch(b -> b
                        .researchStack(SUPRACAUSAL_ASSEMBLY.getStackForm())
                        .EUt(VA[UXV])
                        .CWUt(512))
                .buildAndRegister();

        //  Supracausal Mainframe
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, CosmicNeutronium, 2)
                .input(SUPRACAUSAL_COMPUTER, 2)
                .input(SUPRACAUSAL_DIODE, 16)
                .input(SUPRACAUSAL_CAPACITOR, 16)
                .input(SUPRACAUSAL_TRANSISTOR, 16)
                .input(SUPRACAUSAL_RESISTOR, 16)
                .input(SUPRACAUSAL_INDUCTOR, 16)
                .input(foil, Hikarium, 16)
                .input(SUPRACAUSAL_MEMORY_CHIP, 32)
                .input(wireGtDouble, NeutroniumSuperconductor, 16)
                .input(plate, Hypogen, 8)
                .fluidInputs(SolderingAlloy.getFluid(43776))
                .fluidInputs(CosmicFabric.getFluid(34560))
                .fluidInputs(FullerenePolymerMatrix.getFluid(17280))
                .fluidInputs(Zylon.getFluid(8640))
                .output(SUPRACAUSAL_MAINFRAME)
                .EUt(VA[OpV])
                .duration(2 * MINUTE)
                .stationResearch(b -> b
                        .researchStack(SUPRACAUSAL_COMPUTER.getStackForm())
                        .EUt(VA[OpV])
                        .CWUt(1024))
                .buildAndRegister();
    }
}
