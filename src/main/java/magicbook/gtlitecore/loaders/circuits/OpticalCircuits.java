package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.multiblocks.api.recipes.GCYMRecipeMaps.ALLOY_BLAST_RECIPES;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class OpticalCircuits {

    public static void init() {
        CircuitBoard();
        CircuitComponent();
        SMDs();
        SoC();
        Circuits();
    }

    private static void CircuitBoard() {

        //  Optical Board
        CVD_UNIT_RECIPES.recipeBuilder()
                .input(plate, GalliumNitride)
                .input(foil, Americium, 4)
                .fluidInputs(FluorinatedEthylenePropylene.getFluid(L * 2))//  TODO Find better material
                .output(OPTICAL_BOARD)
                .duration(40)
                .EUt(VA[UHV])
                .temperature(980)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Optical Circuit Board
        for (FluidStack stack : new FluidStack[]{
                TetramethylammoniumHydroxide.getFluid(4000),
                EDP.getFluid(1000)}) {
            CHEMICAL_RECIPES.recipeBuilder()
                    .input(OPTICAL_BOARD)
                    .input(foil, Americium, 64)
                    .fluidInputs(stack)
                    .output(OPTICAL_CIRCUIT_BOARD)
                    .duration(210)
                    .EUt(VA[IV])
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
        }
    }

    private static void CircuitComponent() {

        //  ZBLAN Glass
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Zirconium, 5)
                .input(dust, Barium, 2)
                .input(dust, Lanthanum)
                .input(dust, Aluminium)
                .input(dust, Sodium, 2)
                .circuitMeta(5)
                .fluidInputs(Fluorine.getFluid(6200))
                .output(dust, ZBLANGlass, 11)
                .EUt(VA[HV])
                .duration(500)
                .buildAndRegister();

        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Zirconium, 5)
                .input(dust, Barium, 2)
                .input(dust, Lanthanum)
                .input(dust, Aluminium)
                .input(dust, Sodium, 2)
                .fluidInputs(Fluorine.getFluid(6200))
                .circuitMeta(5)
                .fluidOutputs(ZBLANGlass.getFluid(L * 11))
                .blastFurnaceTemp(1073)
                .duration(1800)
                .EUt(VA[HV])
                .buildAndRegister();

        //  GST Glass
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Germanium, 2)
                .input(dust, Antimony, 2)
                .input(dust, Tellurium, 5)
                .circuitMeta(3)
                .output(dust, GSTGlass, 9)
                .EUt(VA[HV])
                .duration(250)
                .buildAndRegister();

        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Germanium, 2)
                .input(dust, Antimony, 2)
                .input(dust, Tellurium, 5)
                .circuitMeta(3)
                .fluidOutputs(GSTGlass.getFluid(L * 9))
                .blastFurnaceTemp(873)
                .duration(1600)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Er-doped ZBLAN Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, ZBLANGlass)
                .input(dust, Erbium)
                .output(ingot, ErbiumDopedZBLANGlass, 2)
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Pr-doped ZBLAN Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, ZBLANGlass)
                .input(dust, Praseodymium)
                .output(ingot, PraseodymiumDopedZBLANGlass, 2)
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  PRAM
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(RANDOM_ACCESS_MEMORY)
                .input(plate, GSTGlass, 2)
                .input(foil, Americium, 8)
                .output(PHASE_CHANGE_MEMORY, 4)
                .duration(200)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  ACNOR
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(NOR_MEMORY_CHIP)
                .input(OPTICAL_FIBER, 2)
                .input(foil, Trinium, 8)
                .output(OPTICAL_NOR_MEMORY_CHIP, 4)
                .duration(200)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Si + 4Cl -> SiCl4
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Silicon)
                .fluidInputs(Chlorine.getFluid(4000))
                .circuitMeta(1)
                .fluidOutputs(SiliconTetrachloride.getFluid(1000))
                .duration(300)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Another GeCl4 recipe
        //  You can get GeCl4 by Germanium process, but when you make optical circuit,
        //  through Isa mill chain, you can directly get Germanium, so maybe this recipe is useful.
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Germanium)
                .circuitMeta(4)
                .fluidInputs(Chlorine.getFluid(4000))
                .fluidOutputs(GermaniumTetrachloride.getFluid(1000))
                .EUt(VA[MV])
                .duration(350)
                .buildAndRegister();

        //  Optical Fiber
        LASER_CVD_UNIT_RECIPES.recipeBuilder()
                .fluidInputs(GermaniumTetrachloride.getFluid(250))
                .fluidInputs(PhosphorylChloride.getFluid(250))
                .fluidInputs(SiliconTetrachloride.getFluid(1000))
                .notConsumable(SHAPE_EXTRUDER_WIRE)
                .output(OPTICAL_FIBER, 8)
                .duration(400)
                .EUt(VA[LuV])
                .temperature(1800)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Dielectric Mirror
        MOLECULAR_BEAM_RECIPES.recipeBuilder()
                .input(foil, Polybenzimidazole)
                .input(dust, ErbiumDopedZBLANGlass, 2)
                .input(dust, PraseodymiumDopedZBLANGlass, 2)
                .input(dust, TantalumPentoxide, 7)
                .output(DIELECTRIC_MIRROR)
                .duration(600)
                .EUt(VA[LuV])
                .temperature(2820)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Empty Laser
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(DIELECTRIC_MIRROR)
                .input(plate, SterlingSilver, 2)
                .input(ring, TungstenSteel, 2)
                .input(cableGtSingle, Platinum, 2)
                .fluidInputs(BorosilicateGlass.getFluid(L * 2))
                .output(EMPTY_LASER_ASSEMBLY)
                .duration(100)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Helium-Neon Laser
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Helium.getFluid(1000))
                .fluidInputs(Neon.getFluid(1000))
                .fluidOutputs(HeliumNeon.getFluid(1000))
                .EUt(VA[MV])
                .duration(120)
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(EMPTY_LASER_ASSEMBLY)
                .fluidInputs(HeliumNeon.getFluid(1000))
                .output(HELIUM_NEON_LASER)
                .EUt(VA[HV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Nd:YAG Laser
        CANNER_RECIPES.recipeBuilder()
                .input(EMPTY_LASER_ASSEMBLY)
                .input(gem, NdYAG)
                .output(ND_YAG_LASER)
                .EUt(VA[HV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Optical Laser Control Unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_CIRCUIT_BOARD)
                .input(HELIUM_NEON_LASER)
                .input(ND_YAG_LASER)
                .input(lens, Diamond, 2)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(OPTICAL_LASER_CONTROL_UNIT)
                .duration(600)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void SMDs() {

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, Naquadah, 4)
                .input(dust, CadmiumSulfide)
                .fluidInputs(KaptonE.getFluid(L * 2))
                .output(OPTICAL_RESISTOR, 16)
                .duration(160)
                .EUt(VA[UV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, Iridium, 8)
                .input(foil, Germanium)
                .fluidInputs(KaptonE.getFluid(L))
                .output(OPTICAL_TRANSISTOR, 16)
                .duration(160)
                .EUt(VA[UV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_CVD_UNIT_RECIPES.recipeBuilder()
                .input(OPTICAL_FIBER, 2)
                .input(plate, ErbiumDopedZBLANGlass)
                .fluidInputs(KaptonE.getFluid(L / 4))
                .output(OPTICAL_CAPACITOR, 16)
                .duration(160)
                .EUt(VA[UV])
                .temperature(487)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, Terbium)
                .input(wireFine, BorosilicateGlass, 4)
                .fluidInputs(KaptonE.getFluid(L / 2))
                .output(OPTICAL_DIODE, 16)
                .duration(160)
                .EUt(VA[UV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ION_IMPLANTATOR_RECIPES.recipeBuilder()
                .input(dust, Silver, 4)
                .input(plate, PMMA)
                .fluidInputs(KaptonE.getFluid(L))
                .output(OPTICAL_INDUCTOR, 16)
                .duration(160)
                .EUt(VA[UV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void SoC() {

        //  MnF2 + ZnS + Ta2O5 + TiO2 + C2H6O -> Electrolyte Reflector Mixture
        MIXER_RECIPES.recipeBuilder()
                .input(dust, ManganeseDifluoride, 3)
                .input(dust, ZincSulfide, 2)
                .input(dust, TantalumPentoxide, 7)
                .input(dust, Rutile, 3)
                .fluidInputs(Ethanol.getFluid(1000))
                .fluidOutputs(ElectrolyteReflectorMixture.getFluid(1000))
                .EUt(VA[UHV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Centrifuge recipe of Electrolyte Reflector Mixture
        //  This recipe should in Cleanroom environment.
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(ElectrolyteReflectorMixture.getFluid(1000))
                .output(dust, ManganeseDifluoride, 3)
                .output(dust, ZincSulfide, 2)
                .output(dust, TantalumPentoxide, 7)
                .output(dust, Rutile, 3)
                .fluidOutputs(Ethanol.getFluid(1000))
                .EUt(VA[LuV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  SrSO4 + Bh -> Bh-doped SrSO4 Boule
        CRYSTALLIZATION_RECIPES.recipeBuilder()
                .input(dust, StrontiumCarbonate, 64)
                .input(dust, Bohrium, 8)
                .output(STRONTIUM_CARBONATE_BOHRIUM_BOULE)
                .EUt(VA[ZPM])
                .duration(120)
                .blastFurnaceTemp(6000)
                .buildAndRegister();

        //  Bh-doped SrSO4 Boule -> Bh-doped SrSO4 Wafer
        CUTTER_RECIPES.recipeBuilder()
                .input(STRONTIUM_CARBONATE_BOHRIUM_BOULE)
                .fluidInputs(Lubricant.getFluid(300))
                .outputs(STRONTIUM_CARBONATE_BOHRIUM_WAFER.getStackForm(6))
                .EUt(VA[EV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Bh-doped SrSO4 Wafer -> Optical Wafer
        //  This is a special wafer for Optical SoC process.
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(STRONTIUM_CARBONATE_BOHRIUM_WAFER)
                .fluidInputs(ElectrolyteReflectorMixture.getFluid(16))
                .output(STRONTIUM_CARBONATE_OPTICAL_WAFER)
                .EUt(VA[UV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Optical Wafer -> Optical Chip
        CUTTER_RECIPES.recipeBuilder()
                .input(STRONTIUM_CARBONATE_OPTICAL_WAFER)
                .fluidInputs(Lubricant.getFluid(200))
                .output(STRONTIUM_CARBONATE_OPTICAL_CHIP, 8)
                .duration(100)
                .EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Optical IMC Board
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, PedotTMA)
                .input(STRONTIUM_CARBONATE_OPTICAL_CHIP, 2)
                .input(lens, LithiumNiobate)
                .input(dust, ZBLANGlass, 2)
                .fluidInputs(TinAlloy.getFluid(L * 2))
                .output(OPTICAL_IMC_BOARD, 2)
                .EUt(VA[UEV])
                .duration(400)
                .CasingTier(3) // UV
                .buildAndRegister();

        //  UHASoC
        NANO_SCALE_MASK_ALIGNER_RECIPES.recipeBuilder()
                .notConsumable(lens, MagnetoResonatic)
                .notConsumable(lens, NdYAG)
                .notConsumable(lens, NetherStar)
                .input(NEUTRONIUM_WAFER)
                .output(UHASOC_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(UHASOC_WAFER)
                .fluidInputs(Water.getFluid(1000))
                .output(UHASOC_CHIP, 6)
                .EUt(VA[LuV])
                .duration(1800)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(UHASOC_WAFER)
                .fluidInputs(DistilledWater.getFluid(750))
                .output(UHASOC_CHIP, 6)
                .EUt(VA[LuV])
                .duration(1350)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(UHASOC_WAFER)
                .fluidInputs(Lubricant.getFluid(250))
                .output(UHASOC_CHIP, 6)
                .EUt(VA[LuV])
                .duration(900)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Optical SoC
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_IMC_BOARD)
                .input(UHASOC_CHIP, 2)
                .input(OPTICAL_FIBER, 4)
                .input(wireFine, Solarium, 4)
                .fluidInputs(SiliconCarbide.getFluid(L * 2))
                .fluidInputs(Glowstone.getFluid(4000))
                .output(PHOTOELECTRON_SOC, 4)
                .EUt(VA[UEV])
                .duration(200)
                .CasingTier(5) // UEV
                .buildAndRegister();
    }

    private static void Circuits() {

        //  Processor
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_LASER_CONTROL_UNIT)
                .input(CRYSTAL_CENTRAL_PROCESSING_UNIT)
                .input(OPTICAL_RESISTOR, 8)
                .input(OPTICAL_CAPACITOR, 8)
                .input(OPTICAL_TRANSISTOR, 8)
                .input(OPTICAL_FIBER, 8)
                .output(OPTICAL_PROCESSOR, 2)
                .solderMultiplier(1)
                .duration(200)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_CIRCUIT_BOARD)
                .input(PHOTOELECTRON_SOC)
                .input(wireFine, PedotPSS, 8)
                .input(bolt, Adamantium, 8)
                .output(OPTICAL_PROCESSOR, 4)
                .solderMultiplier(1)
                .duration(100)
                .EUt(VA[UEV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Assembly
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_CIRCUIT_BOARD)
                .input(OPTICAL_PROCESSOR, 2)
                .input(OPTICAL_INDUCTOR, 6)
                .input(OPTICAL_CAPACITOR, 12)
                .input(PHASE_CHANGE_MEMORY, 24)
                .input(OPTICAL_FIBER, 16)
                .output(OPTICAL_ASSEMBLY, 2)
                .solderMultiplier(2)
                .duration(400)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Computer
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(OPTICAL_CIRCUIT_BOARD)
                .input(OPTICAL_ASSEMBLY, 2)
                .input(OPTICAL_DIODE, 8)
                .input(OPTICAL_NOR_MEMORY_CHIP, 16)
                .input(PHASE_CHANGE_MEMORY, 32)
                .input(OPTICAL_FIBER, 24)
                .input(foil, KaptonE, 32)
                .input(plate, Tritanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(4320))
                .fluidInputs(Polyetheretherketone.getFluid(2304))
                .fluidInputs(Vibranium.getFluid(1152))
                .output(OPTICAL_COMPUTER)
                .duration(400)
                .EUt(VA[UHV])
                .stationResearch(b -> b
                        .researchStack(OPTICAL_ASSEMBLY.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  Mainframe
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum, 2)
                .input(OPTICAL_COMPUTER, 2)
                .input(OPTICAL_DIODE, 16)
                .input(OPTICAL_CAPACITOR, 16)
                .input(OPTICAL_TRANSISTOR, 16)
                .input(OPTICAL_RESISTOR, 16)
                .input(OPTICAL_INDUCTOR, 16)
                .input(foil, KaptonE, 64)
                .input(PHASE_CHANGE_MEMORY, 32)
                .input(wireGtDouble, QuantumAlloy, 16)
                .input(plate, Tritanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(5472))
                .fluidInputs(Polyetheretherketone.getFluid(4320))
                .fluidInputs(Vibranium.getFluid(2304))
                .fluidInputs(KaptonK.getFluid(1152))
                .output(OPTICAL_MAINFRAME)
                .duration(1200)
                .EUt(VA[UEV])
                .stationResearch(b -> b
                        .researchStack(OPTICAL_COMPUTER.getStackForm())
                        .CWUt(384)
                        .EUt(VA[UEV]))
                .buildAndRegister();
    }
}
