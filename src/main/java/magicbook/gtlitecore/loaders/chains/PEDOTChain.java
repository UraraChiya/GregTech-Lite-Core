package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class PEDOTChain {

    public static void init() {
        EDOTChain();
        PSSChain();
        TMAChain();
    }

    private static void EDOTChain() {

        //  C4H10O2 -> C4H6O2 + 4H
        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(Butanediol.getFluid(1000))
                .fluidOutputs(Diacetyl.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(4000))
                .duration(80)
                .EUt(VA[MV])
                .buildAndRegister();

        //  C4H6O2 + C2H6O2 + SCl2 -> C6H6O2S + 2HCl + 2H2O (lost)
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Diacetyl.getFluid(1000))
                .fluidInputs(EthyleneGlycol.getFluid(1000))
                .fluidInputs(SulfurDichloride.getFluid(1000))
                .fluidOutputs(Edot.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .duration(100)
                .EUt(VA[HV])
                .buildAndRegister();
    }

    private static void PSSChain() {

        //  Styrene -> Polystyrene
        CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Styrene.getFluid(L))
                .fluidInputs(Air.getFluid(1000))
                .fluidOutputs(Polystyrene.getFluid(L))
                .duration(160)
                .EUt(VA[LV])
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Styrene.getFluid(L))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidOutputs(Polystyrene.getFluid(216))
                .duration(160)
                .EUt(VA[LV])
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(24)
                .fluidInputs(Styrene.getFluid(2160))
                .fluidInputs(Air.getFluid(7500))
                .fluidInputs(TitaniumTetrachloride.getFluid(100))
                .fluidOutputs(Polystyrene.getFluid(3240))
                .duration(800)
                .EUt(VA[LV])
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(24)
                .fluidInputs(Styrene.getFluid(2160))
                .fluidInputs(Oxygen.getFluid(7500))
                .fluidInputs(TitaniumTetrachloride.getFluid(100))
                .fluidOutputs(Polystyrene.getFluid(4320))
                .duration(800)
                .EUt(VA[LV])
                .buildAndRegister();

        //  C8H8 + SO3 -> C8H8SO3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Polystyrene.getFluid(L))
                .fluidInputs(SulfurTrioxide.getFluid(1000))
                .fluidOutputs(PolystyreneSulfonate.getFluid(L))
                .duration(160)
                .EUt(VA[HV])
                .buildAndRegister();

        //  PEDOT:PSS
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Edot.getFluid(1000))
                .fluidInputs(PolystyreneSulfonate.getFluid(L))
                .fluidOutputs(PedotPSS.getFluid(L * 9))
                .duration(400)
                .EUt(VA[UV])
                .buildAndRegister();
    }

    private static void TMAChain() {

        //  PEDOT-TMA
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Edot.getFluid(1000))
                .fluidInputs(PMMA.getFluid(L))
                .fluidOutputs(PedotTMA.getFluid(L * 9))
                .duration(400)
                .EUt(VA[UHV])
                .buildAndRegister();
    }
}
