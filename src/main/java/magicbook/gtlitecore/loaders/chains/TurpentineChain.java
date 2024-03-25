package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.Naphtha;
import static gregtech.api.unification.material.Materials.Steam;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class TurpentineChain {

    public static void init() {

        CHEMICAL_RECIPES.recipeBuilder()
                .input("logWood")
                .fluidInputs(Naphtha.getFluid(1000))
                .fluidOutputs(LeachedTurpentine.getFluid(1000))
                .duration(80)
                .EUt(VA[HV])
                .buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .fluidInputs(Steam.getFluid(1000))
                .fluidInputs(LeachedTurpentine.getFluid(1000))
                .circuitMeta(1)
                .fluidOutputs(SteamCrackedTurpentine.getFluid(1000))
                .duration(80)
                .EUt(240)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(SteamCrackedTurpentine.getFluid(1000))
                .fluidOutputs(Turpentine.getFluid(1000))
                .fluidOutputs(Naphtha.getFluid(1000))
                .duration(120)
                .EUt(VA[MV])
                .buildAndRegister();
    }
}
