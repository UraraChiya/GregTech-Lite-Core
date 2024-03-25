package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtechfoodoption.GTFOMaterialHandler.Aminophenol;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class CosmicCircuits {

    public static void init() {
        CircuitBoard();
        CircuitComponent();
        SoC();
        SMDs();
        Circuits();
    }

    private static void CircuitBoard() {

        //  Cosmic Board
        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(plate, DegenerateRhenium, 2)
                .input(plate, HeavyQuarkDegenerateMatter, 2)
                .input(wireFine, Abyssalloy, 6)
                .fluidInputs(Astralium.getFluid(L))
                .output(COSMIC_INFORMATION_MODULE)
                .EUt(VA[UIV])
                .duration(50)
                .CasingTier(4)
                .buildAndRegister();

        //  Cosmic Circuit Board
        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(frameGt, BlackPlutonium)
                .input(COSMIC_INFORMATION_MODULE)
                .input(CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT)
                .input(CLADDED_OPTICAL_FIBER_CORE, 8)
                .input(BOSE_EINSTEIN_CONDENSATE, 4)
                .input(wireGtSingle, AstralTitanium, 2)
                .fluidInputs(CosmicComputingMixture.getFluid(1000))
                .fluidInputs(PlatinumGroupAlloy.getFluid(L))
                .output(HOLOGRAPHIC_INFORMATION_IMC, 2)
                .EUt(VA[UIV])
                .duration(20)
                .CasingTier(5)
                .buildAndRegister();
    }

    private static void CircuitComponent() {

        ScintillatorChain();

        //  Nuclear Clock
        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(SCINTILLATOR)
                .input(plate, Osmiridium, 2)
                .input(SENSOR_UEV)
                .input(ND_YAG_LASER, 2)
                .input(lens, LuTmYVO)
                .input(wireGtSingle, RutheniumTriniumAmericiumNeutronate, 2)
                .fluidInputs(Mithril.getFluid(L * 4))
                .fluidInputs(Thorium.getFluid(5000))
                .output(NUCLEAR_CLOCK)
                .EUt(VA[UEV])
                .duration(35)
                .CasingTier(4)
                .buildAndRegister();

        //  Closed Time-like Curve Guidance Unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(NUCLEAR_CLOCK)
                .input(TOOL_DATA_ORB)
                .input(plate, MetastableFlerovium)
                .input(wireFine, QuantumAlloy, 4)
                .fluidInputs(SuperheavyHAlloy.getFluid(L))
                .output(CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT)
                .EUt(VA[UIV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Closed Time-like Curve Computational Unit
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .input(plate, SuperheavyLAlloy, 2)
                .input(wireFine, Infinity, 4)
                .fluidInputs(Gluons.getFluid(2000))
                .fluidInputs(Neutronium.getFluid(L * 2))
                .output(CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT, 2)
                .EUt(VA[UIV])
                .duration(200)
                .CasingTier(4) // UHV
                .buildAndRegister();

        //  Cladded Optical Fiber Core
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(wireFine, ZBLANGlass)
                .fluidInputs(Zylon.getFluid(16))
                .output(CLADDED_OPTICAL_FIBER_CORE)
                .EUt(VA[LuV])
                .duration(200)
                .buildAndRegister();

        //  Cosmic CPU process

        //  Neutronium Wafer -> Untreated Cosmic CPU Wafer
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .fluidInputs(CosmicComputingMixture.getFluid(L))
                .output(UNTREATED_COSMIC_CPU)
                .EUt(VA[UV])
                .duration(300)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .fluidInputs(CosmicNeutronium.getFluid(16))
                .output(UNTREATED_COSMIC_CPU)
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  Untreated Cosmic CPU Wafer -> Cosmic CPU Wafer
        //  Need to use HSQ or KPR and Fullerene.
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(UNTREATED_COSMIC_CPU)
                .input(dust, Fullerene, 2)
                .fluidInputs(HSQ.getFluid(L * 4))
                .output(COSMIC_CPU)
                .EUt(VA[UEV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(UNTREATED_COSMIC_CPU)
                .input(dust, Fullerene, 2)
                .fluidInputs(KPR.getFluid(L * 4))
                .output(COSMIC_CPU)
                .EUt(VA[UEV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cosmic CPU Wafer -> Cosmic CPU Chip
        CUTTER_RECIPES.recipeBuilder()
                .input(COSMIC_CPU)
                .fluidInputs(Lubricant.getFluid(6000))
                .output(COSMIC_CPU_CHIP, 32)
                .EUt(VA[UV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void SoC() {

        //  NaCl + HI -> NaI + HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Salt, 2)
                .fluidInputs(HydroiodicAcid.getFluid(1000))
                .circuitMeta(1)
                .output(dust, SodiumIodide, 2)
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .EUt(VA[HV])
                .duration(340)
                .buildAndRegister();

        //  Na + HNO2 -> NaNO2 + H
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Sodium)
                .fluidInputs(NitrousAcid.getFluid(1000))
                .output(dust, SodiumNitrite, 4)
                .fluidOutputs(Hydrogen.getFluid(1000))
                .EUt(VA[EV])
                .duration(200)
                .temperature(437)
                .buildAndRegister();

        //  NaF + NaNO2 + C6H4(CO)2O + NaOH + NH3 + HCl + 2Cl + H2O -> C7H5IO2 + N + CO2 + 3(NaCl)(H2O)
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumIodide, 2)
                .input(dust, SodiumNitrite, 4)
                .input(dust, PhthalicAnhydride, 15)
                .fluidInputs(SodiumHydroxide.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(2000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(IodobenzoicAcid.getFluid(1000))
                .fluidOutputs(Nitrogen.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(SaltWater.getFluid(3000))
                .EUt(VA[UEV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  3C7H5IO2 + H2SO4 + 2O -> 3C7H5IO4 + H2S
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, PotassiumBromate)
                .fluidInputs(IodobenzoicAcid.getFluid(3000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(2000))
                .output(dust, IodoxybenzoicAcid, 51)
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .EUt(VA[EV])
                .duration(200)
                .buildAndRegister();

        //  Si(CH3)2Cl2 + CH4 -> (CH3)3SiCl + 2H
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Dimethyldichlorosilane.getFluid(1000))
                .fluidInputs(Methane.getFluid(1000))
                .circuitMeta(2)
                .fluidOutputs(Trimethylchlorosilane.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[IV])
                .duration(150)
                .buildAndRegister();

        //  LiH + (CH3)3SiCl -> (CH3)3SiH + LiCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, LithiumHydride, 2)
                .fluidInputs(Trimethylchlorosilane.getFluid(1000))
                .output(dust, LithiumChloride, 2)
                .fluidOutputs(Trimethylsilane.getFluid(1000))
                .EUt(VA[LuV])
                .duration(340)
                .buildAndRegister();

        //  C7H5IO4 + (CH3)3SiH + C6H5Cl + 2CH2O -> C8H8O2 + (CH3)3SiCl (cycle) + C7H5IO2 (cycle) + 2H
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, CobaltOxide)
                .input(dust, IodoxybenzoicAcid, 17)
                .fluidInputs(Trimethylsilane.getFluid(1000))
                .fluidInputs(Chlorobenzene.getFluid(1000))
                .fluidInputs(Formaldehyde.getFluid(2000))
                .fluidOutputs(Methoxybenzaldehyde.getFluid(1000))
                .fluidOutputs(Trimethylchlorosilane.getFluid(1000))
                .fluidOutputs(IodobenzoicAcid.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[UHV])
                .duration(250)
                .buildAndRegister();

        //  K + I -> KI
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Potassium)
                .input(dust, Iodine)
                .circuitMeta(2)
                .output(dust, PotassiumIodide, 2)
                .EUt(VA[HV])
                .duration(180)
                .buildAndRegister();

        //  KI + CCH7NO + C4H9Li -> LiI + C10H15N + KOH
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PotassiumIodide, 2)
                .inputs(Aminophenol.getItemStack(15))
                .fluidInputs(Butyllithium.getFluid(1000))
                .output(dust, LithiumIodide, 2)
                .fluidOutputs(Butylaniline.getFluid(1000))
                .fluidOutputs(PotassiumHydroxide.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(240)
                .buildAndRegister();

        //  NaOH + Tc + HNO3 -> NaTcO4 + N + 2H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 3)
                .input(dust, Technetium)
                .fluidInputs(NitricAcid.getFluid(1000))
                .output(dust, SodiumPertechnetate, 6)
                .fluidOutputs(Nitrogen.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[IV])
                .duration(350)
                .buildAndRegister();

        //  K + NaTcO4 -> KTcO4 + Na
        BLAST_RECIPES.recipeBuilder()
                .input(dust, Potassium)
                .input(dust, SodiumPertechnetate, 6)
                .output(dust, PotassiumPertechnetate, 6)
                .output(dust, Sodium)
                .EUt(VA[ZPM])
                .duration(280)
                .blastFurnaceTemp(6500)
                .buildAndRegister();

        //  Another KTcO4 recipe
        //  C2H5OK + NaTcO4 -> KTcO4 + C2H5ONa
        BLAST_RECIPES.recipeBuilder()
                .input(dust, SodiumPertechnetate, 6)
                .fluidInputs(PotassiumEthylate.getFluid(1000))
                .output(dust, PotassiumNonahydridotechnetate, 6)
                .output(dust, SodiumEthylate, 9)
                .EUt(VA[ZPM])
                .duration(140)
                .blastFurnaceTemp(6500)
                .buildAndRegister();

        //  KTcO4 + 18K + 13C2H5OH + 4O -> H9K2TcO4 + 4KOH + 13C2H5OK
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PotassiumPertechnetate, 6)
                .input(dust, Potassium, 18)
                .fluidInputs(Ethanol.getFluid(13000))
                .fluidInputs(Oxygen.getFluid(4000))
                .output(dust, PotassiumNonahydridotechnetate, 16)
                .fluidOutputs(PotassiumHydroxide.getFluid(4000))
                .fluidOutputs(PotassiumEthylate.getFluid(13000))
                .EUt(VA[UV])
                .duration(240)
                .buildAndRegister();

        //  KReO4 + 18K + 13C2H5OH + 4O -> H9K2ReO4 + 4KOH + 13C2H5OK
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PotassiumPerrhenate, 6)
                .input(dust, Potassium, 18)
                .fluidInputs(Ethanol.getFluid(13000))
                .fluidInputs(Oxygen.getFluid(4000))
                .output(dust, PotassiumNonahydridorhenate, 16)
                .fluidOutputs(PotassiumHydroxide.getFluid(4000))
                .fluidOutputs(PotassiumEthylate.getFluid(13000))
                .EUt(VA[UV])
                .duration(240)
                .buildAndRegister();

        //  Another C2H5OK liquid recycle recipe
        //  C2H5OK + HCl -> KCl + C2H5OH
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumEthylate.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .output(dust, RockSalt, 2)
                .fluidOutputs(Ethanol.getFluid(1000))
                .EUt(VA[MV])
                .duration(40)
                .buildAndRegister();

        //  NH4ReO4 + KOH -> KReO4 + NH3 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, AmmoniumPerrhenate, 10)
                .fluidInputs(PotassiumHydroxide.getFluid(1000))
                .output(dust, PotassiumPerrhenate, 6)
                .fluidOutputs(Ammonia.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[LuV])
                .duration(40)
                .buildAndRegister();

        //  4C2H4 + NH3 + HBr-> (C2H5)4NBr
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(4000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidInputs(HydrobromicAcid.getFluid(1000))
                .fluidOutputs(TetraethylammoniumBromide.getFluid(1000))
                .EUt(VA[IV])
                .duration(240)
                .buildAndRegister();

        //  H9K2ReO4 + H9K2TcO4 + 2(C2H5)4NBr -> (C2H5)4N(ReH9)(TcH9) + 4K + 2Br
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PotassiumNonahydridorhenate, 16)
                .input(dust, PotassiumNonahydridotechnetate, 16)
                .fluidInputs(TetraethylammoniumBromide.getFluid(2000))
                .output(dust, TetraethylammoniumNonahydriorhenidetechnetide, 49)
                .output(dust, Potassium, 4)
                .fluidOutputs(Bromine.getFluid(2000))
                .EUt(VA[UEV])
                .duration(180)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  C8H8O2 + C10H15N -> C18H21NO + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, TetraethylammoniumNonahydriorhenidetechnetide)
                .fluidInputs(Methoxybenzaldehyde.getFluid(1000))
                .fluidInputs(Butylaniline.getFluid(1000))
                .fluidOutputs(MBBA.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[UIV])
                .duration(90)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Lepton Trap Crystal
        BLAST_RECIPES.recipeBuilder()
                .input(dust, MetastableHassium)
                .input(dust, Molybdenum)
                .input(dust, Rhenium)
                .fluidInputs(NaquadahAlloy.getFluid(L))
                .output(LEPTON_TRAP_CRYSTAL)
                .EUt(3450000)
                .duration(340)
                .blastFurnaceTemp(10900)
                .buildAndRegister();

        //  Lepton Trap Crystal -> Charged Lepton Trap Crystal
        CRYOGENIC_REACTOR_RECIPES.recipeBuilder()
                .input(LEPTON_TRAP_CRYSTAL)
                .input(dustSmall, Vibranium, 2)
                .fluidInputs(HeavyLepton.getFluid(500))
                .fluidInputs(FreeElectronGas.getFluid(500))
                .output(CHARGED_LEPTON_TRAP_CRYSTAL)
                .EUt(VA[UV])
                .duration(240)
                .temperature(133)
                .buildAndRegister();

        //  Colored LEDs
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(dust, CBDOPolycarbonate, 3)
                .input(ADVANCED_SMD_DIODE, 2)
                .input(springSmall, StainlessSteel)
                .input(wireFine, Aluminium, 4)
                .fluidInputs(HSQ.getFluid(L / 2))
                .fluidInputs(Tin.getPlasma(L / 4))
                .output(COLORED_LEDS)
                .EUt(VA[LuV])
                .duration(350)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Colored LEDs -> Rotating Transparent Surface
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UXV)
                .input(COLORED_LEDS)
                .input(gear, CobaltBrass)
                .input(bolt, Tritanium, 2)
                .fluidInputs(CarbonNanotube.getFluid(L))
                .fluidInputs(MBBA.getFluid(500))
                .output(ROTATING_TRANSPARENT_SURFACE)
                .EUt(VA[UHV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Universal SoC
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, BlackPlutonium)
                .input(CHARGED_LEPTON_TRAP_CRYSTAL)
                .input(ROTATING_TRANSPARENT_SURFACE)
                .input(wireFine, LunaSilver, 4)
                .fluidInputs(QuantumchromodynamicallyConfinedMatter.getFluid(L))
                .fluidInputs(Gluons.getFluid(600))
                .fluidInputs(FullereneSuperconductor.getFluid(L / 2))
                .output(UNIVERSAL_SOC, 4)
                .EUt(VA[UXV])
                .duration(200)
                .CasingTier(7) // UXV
                .buildAndRegister();
    }

    private static void SMDs() {

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, RutheniumTriniumAmericiumNeutronate, 8)
                .input(plate, DegenerateRhenium)
                .input(plate, MetastableHassium)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(COSMIC_TRANSISTOR, 32)
                .EUt(VA[UEV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CVD_UNIT_RECIPES.recipeBuilder()
                .input(wireFine, SuperheavyLAlloy, 4)
                .input(dust, LanthanumFullereneNanotube)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(COSMIC_RESISTOR, 32)
                .EUt(VA[UEV])
                .duration(160)
                .temperature(4960)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_CVD_UNIT_RECIPES.recipeBuilder()
                .input(wireFine, SuperheavyHAlloy, 8)
                .input(plate, Rhugnor)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(COSMIC_CAPACITOR, 32)
                .EUt(VA[UEV])
                .duration(160)
                .temperature(5630)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ION_IMPLANTATOR_RECIPES.recipeBuilder()
                .input(ring, AstralTitanium, 2)
                .input(wireFine, PlatinumGroupAlloy, 4)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(COSMIC_INDUCTOR, 32)
                .EUt(VA[UEV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, CelestialTungsten)
                .input(dust, CubicBoronNitride)
                .input(wireFine, AstralTitanium, 8)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(COSMIC_DIODE, 32)
                .EUt(VA[UEV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cosmic RAM
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(RANDOM_ACCESS_MEMORY)
                .input(plate, MetastableHassium, 2)
                .input(plate, MetastableFlerovium, 2)
                .input(foil, AstralTitanium, 8)
                .input(wireFine, SuperheavyLAlloy, 16)
                .output(COSMIC_MEMORY_CHIP, 4)
                .EUt(VA[UIV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void Circuits() {

        //  Cosmic Processor
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(HOLOGRAPHIC_INFORMATION_IMC)
                .input(INTRAVITAL_SOC)
                .input(COSMIC_RESISTOR, 8)
                .input(COSMIC_CAPACITOR, 8)
                .input(COSMIC_TRANSISTOR, 8)
                .input(wireFine, Infinity, 8)
                .solderMultiplier(1)
                .output(COSMIC_PROCESSOR, 2)
                .EUt(VA[UIV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(COSMIC_INFORMATION_MODULE)
                .input(UNIVERSAL_SOC)
                .input(wireFine, HeavyQuarkDegenerateMatter, 8)
                .input(bolt, Spacetime, 8)
                .solderMultiplier(1)
                .output(COSMIC_PROCESSOR, 4)
                .EUt(VA[UXV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cosmic Assembly
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(COSMIC_INFORMATION_MODULE)
                .input(COSMIC_PROCESSOR, 2)
                .input(COSMIC_INDUCTOR, 6)
                .input(COSMIC_CAPACITOR, 12)
                .input(COSMIC_MEMORY_CHIP, 24)
                .input(wireFine, Infinity, 16)
                .solderMultiplier(2)
                .output(COSMIC_ASSEMBLY, 2)
                .EUt(VA[UIV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cosmic Supercomputer
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(COSMIC_INFORMATION_MODULE)
                .input(COSMIC_ASSEMBLY, 2)
                .input(COSMIC_DIODE, 8)
                .input(COSMIC_CPU_CHIP, 16)
                .input(COSMIC_MEMORY_CHIP, 32)
                .input(wireFine, RutheniumTriniumAmericiumNeutronate, 24)
                .input(foil, CelestialTungsten, 32)
                .input(plate, MetastableHassium, 4)
                .fluidInputs(SolderingAlloy.getFluid(17280))
                .fluidInputs(Kevlar.getFluid(9216))
                .fluidInputs(Zylon.getFluid(4608))
                .fluidInputs(Infinity.getFluid(2304))
                .output(COSMIC_COMPUTER)
                .stationResearch(b -> b
                        .researchStack(COSMIC_ASSEMBLY.getStackForm())
                        .EUt(VA[UIV])
                        .CWUt(256))
                .duration(400)
                .EUt(VA[UIV])
                .buildAndRegister();

        //  Cosmic Mainframe
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Infinity, 2)
                .input(COSMIC_COMPUTER, 2)
                .input(COSMIC_DIODE, 16)
                .input(COSMIC_CAPACITOR, 16)
                .input(COSMIC_TRANSISTOR, 16)
                .input(COSMIC_RESISTOR, 16)
                .input(COSMIC_INDUCTOR, 16)
                .input(foil, Astralium, 16)
                .input(COSMIC_MEMORY_CHIP, 32)
                .input(wireGtDouble, BoronFranciumCarbideSuperconductor, 16)
                .input(plate, Rhugnor, 8)
                .fluidInputs(SolderingAlloy.getFluid(21888))
                .fluidInputs(FullerenePolymerMatrix.getFluid(17280))
                .fluidInputs(Zylon.getFluid(8640))
                .fluidInputs(Polyetheretherketone.getFluid(4608))
                .output(COSMIC_MAINFRAME)
                .stationResearch(b -> b
                        .researchStack(COSMIC_COMPUTER.getStackForm())
                        .EUt(VA[UXV])
                        .CWUt(512))
                .duration(1200)
                .EUt(VA[UXV])
                .buildAndRegister();
    }

    private static void ScintillatorChain() {

        //  Cs + I -> CsI
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Caesium)
                .input(dust, Iodine)
                .output(dust, CaesiumIodide, 2)
                .EUt(VA[MV])
                .duration(340)
                .buildAndRegister();

        //  CsI + Tl + Tm -> Tl/Tm:CsI
        MIXER_RECIPES.recipeBuilder()
                .input(dust, CaesiumIodide, 2)
                .input(dust, Thallium)
                .input(dust, Thulium)
                .output(dust, TlTmDopedCaesiumIodide, 4)
                .EUt(VA[EV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  WO3 + CdS + 3O -> CdWO4 + SO2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TungstenTrioxide, 4)
                .input(dust, CadmiumSulfide, 2)
                .fluidInputs(Oxygen.getFluid(3000))
                .output(dust, CadmiumTungstate, 6)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .EUt(VA[IV])
                .duration(120)
                .buildAndRegister();

        //  3GeO2 + 2Bi2O3 -> Bi4Ge3O12
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GermaniumDioxide, 9)
                .input(dust, BismuthTrioxide, 10)
                .output(dust, BismuthGermanate, 19)
                .EUt(VA[LuV])
                .duration(50)
                .buildAndRegister();

        //  Scintillator Crystal
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(plate, PlatinumGroupAlloy)
                .input(dust, CelestialCrystal)
                .input(dust, TlTmDopedCaesiumIodide, 4)
                .input(dust, CadmiumTungstate, 6)
                .input(dust, BismuthGermanate, 19)
                .output(SCINTILLATOR_CRYSTAL)
                .EUt(VA[UHV])
                .duration(280)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Scintillator
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(SCINTILLATOR_CRYSTAL)
                .input(SEPARATION_ELECTROMAGNET)
                .input(plate, Zylon, 2)
                .input(screw, Hdcs, 4)
                .fluidInputs(TinAlloy.getFluid(L * 2))
                .output(SCINTILLATOR)
                .EUt(VA[UHV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}
