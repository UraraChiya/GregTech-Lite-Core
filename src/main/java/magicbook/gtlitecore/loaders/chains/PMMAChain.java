package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class PMMAChain {

    public static void init() {

        //  (CH3)2CO + HCN -> C4H7NO
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Acetone.getFluid(1000))
                .fluidInputs(HydrogenCyanide.getFluid(1000))
                .fluidOutputs(AcetoneCyanohydrin.getFluid(2000))
                .duration(150)
                .EUt(240)
                .buildAndRegister();

        //  C4H7NO + CH3OH -> C5H8O2 + NH3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(AcetoneCyanohydrin.getFluid(2000))
                .fluidInputs(Methanol.getFluid(1000))
                .fluidOutputs(PMMA.getFluid(L * 4))
                .fluidOutputs(Ammonia.getFluid(1000))
                .duration(200)
                .EUt(240)
                .buildAndRegister();
    }
}
