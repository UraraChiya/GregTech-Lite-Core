package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import magicbook.gtlitecore.common.GTLiteConfigHolder;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.BismuthTellurite;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.MagnetoResonatic;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class MagnetoResonaticCircuits {

    public static void init() {
        if (GTLiteConfigHolder.recipes.enableMagnetoResonaticCircuit) {
            CircuitBoard();
            Circuits();
        }
    }

    private static void CircuitBoard() {
        //  Magneto Resonatic Board
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(dust, IndiumGalliumPhosphide)
                .input(dust, BismuthTellurite, 2)
                .input(dust, Boron, 2)
                .input(dust, MagnetoResonatic)
                .output(MAGNETO_RESONATIC_BOARD)
                .EUt(VA[HV])
                .duration(300)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Magneto Resonatic Circuit Board
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_BOARD)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .output(MAGNETO_RESONATIC_CIRCUIT_BOARD)
                .EUt(VA[EV])
                .duration(600)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void Circuits() {

        //  ULV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD)
                .input(gem, MagnetoResonatic)
                .input(CAPACITOR, 4)
                .input(TRANSISTOR, 4)
                .input(DIODE, 4)
                .input(VACUUM_TUBE, 1)
                .fluidInputs(SolderingAlloy.getFluid(36))
                .output(MAGNETO_RESONATIC_CIRCUIT_ULV, 4)
                .EUt(VA[LV])
                .duration(75)
                .buildAndRegister();

        //  LV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD)
                .input(gem, MagnetoResonatic)
                .input(MAGNETO_RESONATIC_CIRCUIT_ULV)
                .input(CAPACITOR, 4)
                .input(TRANSISTOR, 4)
                .input(DIODE, 4)
                .fluidInputs(SolderingAlloy.getFluid(72))
                .output(MAGNETO_RESONATIC_CIRCUIT_LV, 4)
                .EUt(VA[MV])
                .duration(150)
                .buildAndRegister();

        //  MV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD)
                .input(gem, MagnetoResonatic)
                .input(MAGNETO_RESONATIC_CIRCUIT_LV)
                .input(CAPACITOR, 8)
                .input(TRANSISTOR, 8)
                .input(DIODE, 8)
                .fluidInputs(SolderingAlloy.getFluid(108))
                .output(MAGNETO_RESONATIC_CIRCUIT_MV, 4)
                .EUt(VA[HV])
                .duration(225)
                .buildAndRegister();

        //  HV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD)
                .input(gem, MagnetoResonatic)
                .input(MAGNETO_RESONATIC_CIRCUIT_MV)
                .input(CAPACITOR, 8)
                .input(TRANSISTOR, 8)
                .input(DIODE, 8)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(MAGNETO_RESONATIC_CIRCUIT_HV, 4)
                .EUt(VA[EV])
                .duration(300)
                .buildAndRegister();

        //  EV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD)
                .input(gem, MagnetoResonatic)
                .input(MAGNETO_RESONATIC_CIRCUIT_HV)
                .input(SMD_CAPACITOR, 16)
                .input(SMD_TRANSISTOR, 16)
                .input(SMD_DIODE, 16)
                .fluidInputs(SolderingAlloy.getFluid(180))
                .output(MAGNETO_RESONATIC_CIRCUIT_EV, 4)
                .EUt(VA[IV])
                .duration(375)
                .buildAndRegister();

        //  IV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD, 6)
                .input(gem, MagnetoResonatic, 6)
                .input(MAGNETO_RESONATIC_CIRCUIT_EV)
                .input(SMD_CAPACITOR, 16)
                .input(SMD_TRANSISTOR, 16)
                .input(SMD_DIODE, 16)
                .fluidInputs(SolderingAlloy.getFluid(864))
                .output(MAGNETO_RESONATIC_CIRCUIT_IV, 4)
                .EUt(VA[LuV])
                .duration(450)
                .buildAndRegister();

        //  LuV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD, 6)
                .input(gem, MagnetoResonatic, 6)
                .input(MAGNETO_RESONATIC_CIRCUIT_IV)
                .input(ADVANCED_SMD_CAPACITOR, 24)
                .input(ADVANCED_SMD_TRANSISTOR, 24)
                .input(ADVANCED_SMD_DIODE, 24)
                .fluidInputs(SolderingAlloy.getFluid(1008))
                .output(MAGNETO_RESONATIC_CIRCUIT_LuV, 4)
                .EUt(VA[ZPM])
                .duration(525)
                .buildAndRegister();

        //  ZPM
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD, 6)
                .input(gemExquisite, MagnetoResonatic)
                .input(MAGNETO_RESONATIC_CIRCUIT_LuV)
                .input(ADVANCED_SMD_CAPACITOR, 24)
                .input(ADVANCED_SMD_TRANSISTOR, 24)
                .input(ADVANCED_SMD_DIODE, 24)
                .fluidInputs(SolderingAlloy.getFluid(4608))
                .output(MAGNETO_RESONATIC_CIRCUIT_ZPM, 4)
                .EUt(VA[UV])
                .duration(600)
                .buildAndRegister();

        //  UV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD, 6)
                .input(gemExquisite, MagnetoResonatic, 6)
                .input(MAGNETO_RESONATIC_CIRCUIT_ZPM)
                .input(ADVANCED_SMD_CAPACITOR, 32)
                .input(ADVANCED_SMD_TRANSISTOR, 32)
                .input(ADVANCED_SMD_DIODE, 32)
                .fluidInputs(SolderingAlloy.getFluid(5184))
                .output(MAGNETO_RESONATIC_CIRCUIT_UV, 4)
                .EUt(VA[UHV])
                .duration(675)
                .buildAndRegister();

        //  UHV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD, 12)
                .input(gemExquisite, MagnetoResonatic, 12)
                .input(MAGNETO_RESONATIC_CIRCUIT_UV)
                .input(OPTICAL_CAPACITOR, 32)
                .input(OPTICAL_TRANSISTOR, 32)
                .input(OPTICAL_DIODE, 32)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .output(MAGNETO_RESONATIC_CIRCUIT_UHV, 4)
                .EUt(VA[UEV])
                .duration(750)
                .buildAndRegister();

        //  UEV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD, 18)
                .input(gemExquisite, MagnetoResonatic, 18)
                .input(MAGNETO_RESONATIC_CIRCUIT_UHV)
                .input(SPINTRONIC_CAPACITOR, 32)
                .input(SPINTRONIC_TRANSISTOR, 32)
                .input(SPINTRONIC_DIODE, 32)
                .fluidInputs(SolderingAlloy.getFluid(6336))
                .output(MAGNETO_RESONATIC_CIRCUIT_UEV, 4)
                .EUt(VA[UIV])
                .duration(825)
                .buildAndRegister();

        //  UIV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD, 24)
                .input(gemExquisite, MagnetoResonatic, 24)
                .input(MAGNETO_RESONATIC_CIRCUIT_UEV)
                .input(COSMIC_CAPACITOR, 32)
                .input(COSMIC_TRANSISTOR, 32)
                .input(COSMIC_DIODE, 32)
                .fluidInputs(SolderingAlloy.getFluid(6912))
                .output(MAGNETO_RESONATIC_CIRCUIT_UIV, 4)
                .EUt(VA[UXV])
                .duration(900)
                .buildAndRegister();

        //  UXV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD, 30)
                .input(gemExquisite, MagnetoResonatic, 30)
                .input(MAGNETO_RESONATIC_CIRCUIT_UIV)
                .input(SUPRACAUSAL_CAPACITOR, 32)
                .input(SUPRACAUSAL_TRANSISTOR, 32)
                .input(SUPRACAUSAL_DIODE, 32)
                .fluidInputs(SolderingAlloy.getFluid(7488))
                .output(MAGNETO_RESONATIC_CIRCUIT_UXV, 4)
                .EUt(VA[OpV])
                .duration(975)
                .buildAndRegister();

        //  OpV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD, 36)
                .input(gemExquisite, MagnetoResonatic, 36)
                .input(MAGNETO_RESONATIC_CIRCUIT_UXV)
                .input(SUPRACAUSAL_CAPACITOR, 48)
                .input(SUPRACAUSAL_TRANSISTOR, 48)
                .input(SUPRACAUSAL_DIODE, 48)
                .fluidInputs(SolderingAlloy.getFluid(8064))
                .output(MAGNETO_RESONATIC_CIRCUIT_OpV, 4)
                .EUt(VA[MAX])
                .duration(1050)
                .buildAndRegister();
        //  MAX
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETO_RESONATIC_CIRCUIT_BOARD, 42)
                .input(gemExquisite, MagnetoResonatic, 42)
                .input(MAGNETO_RESONATIC_CIRCUIT_OpV)
                .input(SUPRACAUSAL_CAPACITOR, 64)
                .input(SUPRACAUSAL_TRANSISTOR, 64)
                .input(SUPRACAUSAL_DIODE, 64)
                .fluidInputs(SolderingAlloy.getFluid(8640))
                .output(MAGNETO_RESONATIC_CIRCUIT_MAX, 4)
                .EUt((int) V[MAX])
                .duration(1124)
                .buildAndRegister();
    }
}