package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtechfoodoption.GTFOMaterialHandler.Aminophenol;
import static gregtechfoodoption.GTFOMaterialHandler.Aniline;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class KaptonChain {

    public static void init() {
        PyromelliticDianhydrideChain();
        OxydianilineChain();
        BPDAChain();
        ParaPhenylenediamineChain();
        KaptonProcess();
    }

    private static void PyromelliticDianhydrideChain() {

        //  C6H4(CH3)2 + 2CH3Cl -> C6H2(CH3)4 + 2HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ParaXylene.getFluid(1000))
                .fluidInputs(Chloromethane.getFluid(2000))
                .output(dust, Durene, 24)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .EUt(VA[MV])
                .duration(6 * SECOND)
                .buildAndRegister();

        //  C6H2(CH3)4 + 12O -> C6H2(C2O3)2 + 6H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Durene, 4)
                .fluidInputs(Oxygen.getFluid(2000))
                .output(dust, PyromelliticDianhydride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[HV])
                .duration(SECOND + 10)
                .buildAndRegister();
    }

    private static void OxydianilineChain() {

        //  C6H5NO2 + 4H -> HOC6H4NH2 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Nitrobenzene.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(4000))
                .circuitMeta(1)
                .outputs(Aminophenol.getItemStack(15))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[LV])
                .duration(15 * SECOND)
                .buildAndRegister();

        //  2C6H5NH2 + C2H5OH -> C12H12N2O + 2CH4
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Tin)
                .fluidInputs(Aniline.getFluid(2000))
                .fluidInputs(Phenol.getFluid(1000))
                .notConsumable(HydrochloricAcid.getFluid())
                .output(dust, Oxydianiline, 27)
                .fluidOutputs(Methane.getFluid(2000))
                .EUt(VA[ZPM])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  HOC6H4NH2 + ClC6H4NO2 + H2O -> C12H12N2O + 3O + HCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Saltpeter)
                .inputs(Aminophenol.getItemStack(15))
                .fluidInputs(Nitrochlorobenzene.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .notConsumable(Dimethylformamide.getFluid())
                .output(dust, Oxydianiline, 27)
                .fluidOutputs(Oxygen.getFluid(3000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .EUt(VA[LV])
                .duration(10 * SECOND)
                .buildAndRegister();
    }

    private static void BPDAChain() {

        // C8H4O3 -> C16H6O6 + 2H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PhthalicAnhydride, 13)
                .notConsumable(dust, Palladium)
                .output(dust, BiphenylTetracarboxylicAcidDianhydride, 28)
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[HV])
                .duration(10 * SECOND)
                .buildAndRegister();
    }

    private static void ParaPhenylenediamineChain() {

        //  ClC6H4NO2 + 2NH3 -> H2NC6H4NO2 + NH4Cl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Nitrochlorobenzene.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidOutputs(Nitroaniline.getFluid(1000))
                .output(dust, AmmoniumChloride, 2)
                .EUt(VA[HV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  H2NC6H4NO2 + 6H -> H2NC6H4NH2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Nitroaniline.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(6000))
                .output(dust, ParaPhenylenediamine, 16)
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[IV])
                .duration(10 * SECOND)
                .buildAndRegister();
    }

    private static void KaptonProcess() {

        //  2C6H2(C2O3)2 + C12H12N2O -> C22H10N2O5 + 10C + 6H + 2O (loss)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PyromelliticDianhydride, 2)
                .input(dust, Oxydianiline, 3)
                .fluidOutputs(KaptonK.getFluid(L))
                .EUt(VA[IV])
                .duration(SECOND + 10)
                .buildAndRegister();

        //  2C6H2(C2O3)2 + C12H12N2O + C16H6O6 + H2NC6H4NH2 -> C24H18N2O5 + 30C + 12H + 14O + 2N (loss)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, BiphenylTetracarboxylicAcidDianhydride, 2)
                .input(dust, ParaPhenylenediamine)
                .fluidInputs(KaptonK.getFluid(L))
                .fluidOutputs(KaptonE.getFluid(L))
                .EUt(VA[ZPM])
                .duration(SECOND + 10)
                .buildAndRegister();
    }
}