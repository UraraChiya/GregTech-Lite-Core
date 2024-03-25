package magicbook.gtlitecore.loaders.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtechfoodoption.GTFOMaterialHandler.AceticAnhydride;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class ZylonChain {

    public static void init() {

        //  2Na + O -> Na2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Sodium, 2)
                .fluidInputs(Oxygen.getFluid(1000))
                .circuitMeta(1)
                .output(dust, SodiumOxide, 3)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        //  C6H4(CH3)2 + 2Br + 2O -> C7H6Br2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ParaXylene.getFluid(1000))
                .fluidInputs(Bromine.getFluid(2000))
                .fluidInputs(Oxygen.getFluid(2000))
                .fluidOutputs(Dibromomethylbenzene.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[IV])
                .duration(430)
                .buildAndRegister();

        //  C7H8 + 2Br -> C7H6Br2
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Toluene.getFluid(1000))
                .fluidInputs(Bromine.getFluid(2000))
                .circuitMeta(24)
                .fluidOutputs(Dibromomethylbenzene.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(215)
                .buildAndRegister();

        //  C7H6Br2 + H2SO4 -> C8H6O2 + 2Br + HS + H2O2
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Dibromomethylbenzene.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, Terephthalaldehyde, 16)
                .fluidOutputs(Bromine.getFluid(2000))
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .fluidOutputs(HydrogenPeroxide.getFluid(1000))
                .EUt(VA[LuV])
                .duration(120)
                .buildAndRegister();

        //  C3H6 + HCl -> CH3CHClCH3
        //  Another Propene + Hydrochloric Acid recipe is GTFO's Isopropyl Chloride, see RecipeConflicts.
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Propene.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .circuitMeta(2)
                .fluidOutputs(Isochloropropane.getFluid(1000))
                .EUt(VA[HV])
                .duration(480)
                .buildAndRegister();

        //  Na2O + C6H6O2 + CH3CHClCH3 + C4H6O3 + 2HNO3 + C3H6 -> C12H16O2(NO2)2 + NaCl + 2H2O + C2H4O2 + C2H3NaO2
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumOxide, 3)
                .fluidInputs(Resorcinol.getFluid(1000))
                .fluidInputs(Isochloropropane.getFluid(1000))
                .fluidInputs(AceticAnhydride.getFluid(1000))
                .fluidInputs(NitricAcid.getFluid(2000))
                .fluidInputs(Propene.getFluid(1000))
                .output(dust, Salt, 2)
                .fluidOutputs(Dinitrodipropanyloxybenzene.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .fluidOutputs(AceticAcid.getFluid(1000))
                .fluidOutputs(SodiumAcetate.getFluid(1000))
                .EUt(VA[UV])
                .duration(500)
                .buildAndRegister();

        //  C8H6O2 + C12H16O2(NO2)2 -> C20H22N2O2 + 6O
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Palladium)
                .input(dust, Terephthalaldehyde, 16)
                .fluidInputs(Dinitrodipropanyloxybenzene.getFluid(1000))
                .output(dust, PreZylon)
                .fluidOutputs(Oxygen.getFluid(6000))
                .EUt(VA[UHV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  C20H22N2O2 -> C14H6N2O2 + 2C3H6
        BLAST_RECIPES.recipeBuilder()
                .input(dust, PreZylon)
                .output(dust, Zylon)
                .fluidOutputs(Propane.getFluid(2000))
                .EUt(VA[HV])
                .duration(16000)
                .blastFurnaceTemp(10000)
                .buildAndRegister();
    }
}