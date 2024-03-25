package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class PEEKChain {

    public static void init() {

        //  (FC6H4)2CO + Na2CO3 + C6H4(OH)2 -> C20H12O3 + 2NaF + CO2 + H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Difluorobenzophenone, 24)
                .input(dust, SodaAsh, 6)
                .fluidInputs(Hydroquinone.getFluid(1000))
                .output(dust, SodiumFluoride, 4)
                .fluidOutputs(Polyetheretherketone.getFluid(2592))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(240)
                .buildAndRegister();

        //  Na2CO3 + C6H4(OH)2 + 2C6H5F -> C20H12O3 + 2NaF + 2H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodaAsh, 6)
                .fluidInputs(Hydroquinone.getFluid(1000))
                .fluidInputs(Fluorobenzene.getFluid(2000))
                .output(dust, SodiumFluoride, 4)
                .fluidOutputs(Polyetheretherketone.getFluid(2592))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[UHV])
                .duration(480)
                .buildAndRegister();

        //  C6H5F + C7H7F + 6Cl + H2O -> (FC6H4)2CO + 6HF
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Zinc)
                .fluidInputs(Fluorobenzene.getFluid(1000))
                .fluidInputs(Fluorotoluene.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(6000))
                .fluidInputs(Water.getFluid(1000))
                .output(dust, Difluorobenzophenone, 24)
                .fluidOutputs(HydrofluoricAcid.getFluid(6000))
                .EUt(VA[EV])
                .duration(200)
                .buildAndRegister();

        //  C3H6 + C6H6 + 3O -> C6H4(OH)2 + C6H6O2 + C3H6O
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Propene.getFluid(1000))
                .fluidInputs(Benzene.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(3000))
                .circuitMeta(5)
                .fluidOutputs(Hydroquinone.getFluid(1000))
                .fluidOutputs(Resorcinol.getFluid(1000))
                .fluidOutputs(Acetone.getFluid(1000))
                .EUt(VA[EV])
                .duration(200)
                .buildAndRegister();

        //  C6H5F + H2SbF7 + CH4 -> SbF3 + C7H7F + 4HF
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Fluorobenzene.getFluid(1000))
                .fluidInputs(FluoroantimonicAcid.getFluid(1000))
                .fluidInputs(Methane.getFluid(1000))
                .output(dust, AntimonyTrifluoride, 4)
                .fluidOutputs(Fluorotoluene.getFluid(1000))
                .fluidOutputs(HydrofluoricAcid.getFluid(4000))
                .EUt(VA[HV])
                .duration(140)
                .buildAndRegister();

    }
}