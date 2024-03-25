package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.PYROLYSE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.stickLong;
import static gregtechfoodoption.GTFOMaterialHandler.AceticAnhydride;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class CBDOPolycarbonateChain {

    public static void init() {

        //  C3H6 + CO + H2O -> C4H8O2
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Propene.getFluid(1000))
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(IsobutyricAcid.getFluid(1000))
                .EUt(VA[HV])
                .duration(180)
                .buildAndRegister();

        //  2C4H8O2 + C4H6O3 -> C8H14O3 + 2C2H4O2
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(IsobutyricAcid.getFluid(2000))
                .fluidInputs(AceticAnhydride.getFluid(1000))
                .fluidOutputs(IsobutyricAnhydride.getFluid(1000))
                .fluidOutputs(AceticAcid.getFluid(2000))
                .EUt(VA[EV])
                .duration(60)
                .buildAndRegister();

        //  C8H14O3 -> 2C4H6O2 + 2H2O (lost)
        PYROLYSE_RECIPES.recipeBuilder()
                .notConsumable(stickLong, YttriumBariumCuprate)
                .fluidInputs(IsobutyricAnhydride.getFluid(1000))
                .fluidOutputs(Dimethylketene.getFluid(2000))
                .EUt(VA[LuV])
                .duration(240)
                .buildAndRegister();

        //  2C4H6O2 + 4H -> C8H16O2
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Rhenium)
                .fluidInputs(Dimethylketene.getFluid(2000))
                .fluidInputs(Hydrogen.getFluid(4000))
                .fluidOutputs(Tetramethylcyclobutanediol.getFluid(1000))
                .EUt(VA[UV])
                .duration(120)
                .buildAndRegister();

        //  C8H16O2 + C13H10O3 -> C9H14O3 + 2C6H6O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Tetramethylcyclobutanediol.getFluid(1000))
                .fluidInputs(DiphenylCarbonate.getFluid(1000))
                .fluidOutputs(CBDOPolycarbonate.getFluid(144))
                .fluidOutputs(Phenol.getFluid(2000))
                .EUt(VA[MV])
                .duration(160)
                .buildAndRegister();
    }
}
