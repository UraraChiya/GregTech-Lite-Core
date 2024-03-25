package magicbook.gtlitecore.loaders.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_BLOCK;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class CosmicFabricChain {

    public static void init() {

        //  Cosmic Fabric
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(foil, ZBLANGlass)
                .input(plate, Spacetime)
                .input(MEMORY_FOAM_PLATE, 2)
                .input(FULLERENE_FIBER, 4)
                .fluidInputs(FluorinatedEthylenePropylene.getFluid(L * 4))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .output(COSMIC_FABRIC)
                .EUt(VA[UEV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  back to stellar furnace and plasma condenser recipes

        MemoryFoamPlateChain();
        FullereneFiberChain();
    }

    private static void MemoryFoamPlateChain() {

        //  C + 2C7H8 + 2CO2 + 2N -> C17H16N2O4
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Carbon)
                .notConsumable(dust, CopperChloride)
                .fluidInputs(Toluene.getFluid(2000))
                .fluidInputs(CarbonDioxide.getFluid(2000))
                .fluidInputs(Nitrogen.getFluid(2000))
                .fluidOutputs(TolueneDiisocyanate.getFluid(1000))
                .EUt(VA[HV])
                .duration(40)
                .buildAndRegister();

        //  2C9H6N2O2 + 8C2H6O2 + 2O -> 2C17H16N2O4 + 14H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(TolueneDiisocyanate.getFluid(2000))
                .fluidInputs(EthyleneGlycol.getFluid(8000))
                .fluidInputs(Oxygen.getFluid(2000))
                .fluidOutputs(Polyurethane.getFluid(2000))
                .fluidOutputs(Water.getFluid(14000))
                .EUt(VA[HV])
                .duration(110)
                .buildAndRegister();

        //  CaCO3 + C17H16N2O4 + C2H6O2 -> C20H22N2O9Ca?
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Calcite, 5)
                .fluidInputs(Polyurethane.getFluid(1000))
                .fluidInputs(EthyleneGlycol.getFluid(1000))
                .fluidInputs(Air.getFluid(1000))
                .fluidOutputs(ViscoelasticPolyurethane.getFluid(2000))
                .EUt(VA[EV])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_BLOCK)
                .fluidInputs(ViscoelasticPolyurethane.getFluid(1000))
                .output(MEMORY_FOAM_PLATE)
                .EUt(VA[EV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    public static void FullereneFiberChain() {

        //  Na + NH3 -> NaNH2 + H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Sodium)
                .circuitMeta(0)
                .fluidInputs(Ammonia.getFluid(1000))
                .output(dust, SodiumAzanide, 4)
                .fluidOutputs(Hydrogen.getFluid(1000))
                .EUt(VA[HV])
                .duration(40)
                .buildAndRegister();

        //  NaNH2 + N2O4 -> NaN3 + H2O + 3O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumAzanide, 4)
                .fluidInputs(DinitrogenTetroxide.getFluid(1000))
                .output(dust, SodiumAzide, 4)
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(Oxygen.getFluid(3000))
                .EUt(VA[EV])
                .duration(80)
                .buildAndRegister();

        //  C3H6O + CH4 -> C4H10O
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Zeolite)
                .fluidInputs(Acetone.getFluid(1000))
                .fluidInputs(Methane.getFluid(1000))
                .fluidOutputs(Tertbutanol.getFluid(1000))
                .EUt(VA[MV])
                .duration(126)
                .buildAndRegister();

        //  2C4H10O + 2CO2 -> C10H18O5 + H2O
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Tertbutanol.getFluid(2000))
                .fluidInputs(CarbonDioxide.getFluid(2000))
                .output(dust, DitertbutylDicarbonate, 33)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[EV])
                .duration(260)
                .buildAndRegister();

        //  C10H18O5 + 2NaN3 + 2K -> 2Na + 3K2O + 2C5H9N3O2
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, DitertbutylDicarbonate, 33)
                .input(dust, SodiumAzide, 8)
                .input(dust, Potassium, 2)
                .output(dust, Sodium, 2)
                .output(dust, Potash, 6)
                .fluidOutputs(Tertbutylcarbonylazide.getFluid(2000))
                .EUt(VA[HV])
                .duration(210)
                .buildAndRegister();

        //  C60 + 4C5H9N3O2 + 8H2O + 4CO -> C60N12H12 + 8CO2 + 4C4H10O (cycle)
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Fullerene)
                .fluidInputs(Tertbutylcarbonylazide.getFluid(4000))
                .fluidInputs(Water.getFluid(8000))
                .fluidInputs(CarbonMonoxide.getFluid(4000))
                .fluidOutputs(AminatedFullerene.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(8000))
                .fluidOutputs(Tertbutanol.getFluid(4000))
                .EUt(VA[LuV])
                .duration(120)
                .buildAndRegister();

        //  Aminated Fullerene -> Azafullerene
        FLUID_HEATER_RECIPES.recipeBuilder()
                .notConsumable(wireFine, Rhenium)
                .fluidInputs(AminatedFullerene.getFluid(1000))
                .fluidOutputs(Azafullerene.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(120)
                .buildAndRegister();

        //  PbFeC153H36NO2 + C60H12N12 -> Fullerene Fiber
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(foil, FullerenePolymerMatrix)
                .fluidInputs(Azafullerene.getFluid(10))
                .output(FULLERENE_FIBER)
                .EUt(VA[UV])
                .duration(350)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}
