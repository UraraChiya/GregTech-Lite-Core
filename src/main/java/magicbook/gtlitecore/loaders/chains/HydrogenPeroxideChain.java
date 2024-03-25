package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.dustTiny;
import static gregtech.common.items.MetaItems.BLACKLIGHT;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class HydrogenPeroxideChain {

    public static void init() {

        //  C6H4(CO2H)2 -> C6H4(CO)2O + H2O
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(PhthalicAcid.getFluid(1000))
                .output(dust, PhthalicAnhydride, 13)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Anthraquinone Process

        //  C6H4(CO)2O + C6H5Et -> C6H4(CO)2C6H3Et + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PhthalicAnhydride, 13)
                .fluidInputs(Ethylbenzene.getFluid(1000))
                .fluidOutputs(Ethylanthraquinone.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(1000)
                .EUt(VA[EV])
                .buildAndRegister();

        //  C6H4(CO)2C6H3Et + 6H -> C6H4(CH2OH)2C6H3Et
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dustTiny, Palladium)
                .fluidInputs(Ethylanthraquinone.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(6000))
                .fluidOutputs(Ethylanthrahydroquinone.getFluid(1000))
                .duration(400)
                .EUt(VA[IV])
                .buildAndRegister();

        //  C6H4(CH2OH)2C6H3Et + 6O -> C6H4(CO)2C6H3Et + 3H2O2
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylanthrahydroquinone.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(6000))
                .fluidOutputs(Ethylanthraquinone.getFluid(1000))
                .fluidOutputs(HydrogenPeroxide.getFluid(3000))
                .duration(40)
                .EUt(VA[EV])
                .buildAndRegister();

        //  2H + 2O -> H2O2
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Platinum)
                .fluidInputs(Hydrogen.getFluid(2000))
                .fluidInputs(Oxygen.getFluid(2000))
                .fluidOutputs(HydrogenPeroxide.getFluid(1000))
                .EUt(VA[LuV])
                .duration(200)
                .buildAndRegister();

        //  12H2O -> 6H2O2 + 6H
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(BLACKLIGHT)
                .notConsumable(dust, YttriumBariumCuprate)
                .fluidInputs(Water.getFluid(12000))
                .circuitMeta(24)
                .fluidOutputs(HydrogenPeroxide.getFluid(6000))
                .fluidOutputs(Hydrogen.getFluid(6000))
                .EUt(VA[UV])
                .duration(240)
                .buildAndRegister();
    }
}
