package magicbook.gtlitecore.loaders.oreprocessing;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.milled;

public class IsaMillOreProcessing {

    public static void init() {
        milledOreProcess();
        flotationOreProcess();
        dryingOreProcess();
    }

    private static void milledOreProcess() {
        //  Almandine
        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Almandine, 16)
                .circuitMeta(1)
                .output(milled, Almandine, 48)
                .EUt(VA[EV])
                .duration(3000)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Almandine, 16)
                .circuitMeta(10)
                .output(milled, Almandine, 64)
                .output(milled, Almandine, 32)
                .EUt(VA[EV])
                .duration(2400)
                .grindBallTier(2)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Almandine, 16)
                .circuitMeta(2)
                .output(milled, Almandine, 16)
                .EUt(VA[EV])
                .duration(1500)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Almandine, 16)
                .circuitMeta(20)
                .output(milled, Almandine, 32)
                .EUt(VA[EV])
                .duration(1200)
                .grindBallTier(2)
                .buildAndRegister();

        //  Chalcopyrite
        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Chalcopyrite, 16)
                .circuitMeta(1)
                .output(milled, Chalcopyrite, 48)
                .EUt(VA[EV])
                .duration(3000)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Chalcopyrite, 16)
                .circuitMeta(10)
                .output(milled, Chalcopyrite, 64)
                .output(milled, Chalcopyrite, 32)
                .EUt(VA[EV])
                .duration(2400)
                .grindBallTier(2)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Chalcopyrite, 16)
                .circuitMeta(2)
                .output(milled, Chalcopyrite, 16)
                .EUt(VA[EV])
                .duration(1500)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Chalcopyrite, 16)
                .circuitMeta(20)
                .output(milled, Chalcopyrite, 32)
                .EUt(VA[EV])
                .duration(1200)
                .grindBallTier(2)
                .buildAndRegister();

        //  Grossular
        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Grossular, 16)
                .circuitMeta(1)
                .output(milled, Grossular, 48)
                .EUt(VA[EV])
                .duration(3000)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Grossular, 16)
                .circuitMeta(10)
                .output(milled, Grossular, 64)
                .output(milled, Grossular, 32)
                .EUt(VA[EV])
                .duration(2400)
                .grindBallTier(2)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Grossular, 16)
                .circuitMeta(2)
                .output(milled, Grossular, 16)
                .EUt(VA[EV])
                .duration(1500)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Grossular, 16)
                .circuitMeta(20)
                .output(milled, Grossular, 32)
                .EUt(VA[EV])
                .duration(1200)
                .grindBallTier(2)
                .buildAndRegister();

        //  Monazite
        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Monazite, 16)
                .circuitMeta(1)
                .output(milled, Monazite, 48)
                .EUt(VA[EV])
                .duration(3000)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Monazite, 16)
                .circuitMeta(10)
                .output(milled, Monazite, 64)
                .output(milled, Monazite, 32)
                .EUt(VA[EV])
                .duration(2400)
                .grindBallTier(2)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Monazite, 16)
                .circuitMeta(2)
                .output(milled, Monazite, 16)
                .EUt(VA[EV])
                .duration(1500)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Monazite, 16)
                .circuitMeta(20)
                .output(milled, Monazite, 32)
                .EUt(VA[EV])
                .duration(1200)
                .grindBallTier(2)
                .buildAndRegister();

        //  Nickel
        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Nickel, 16)
                .circuitMeta(1)
                .output(milled, Nickel, 48)
                .EUt(VA[EV])
                .duration(3000)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Nickel, 16)
                .circuitMeta(10)
                .output(milled, Nickel, 64)
                .output(milled, Nickel, 32)
                .EUt(VA[EV])
                .duration(2400)
                .grindBallTier(2)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Nickel, 16)
                .circuitMeta(2)
                .output(milled, Nickel, 16)
                .EUt(VA[EV])
                .duration(1500)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Nickel, 16)
                .circuitMeta(20)
                .output(milled, Nickel, 32)
                .EUt(VA[EV])
                .duration(1200)
                .grindBallTier(2)
                .buildAndRegister();

        //  Platinum
        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Platinum, 16)
                .circuitMeta(1)
                .output(milled, Platinum, 48)
                .EUt(VA[EV])
                .duration(3000)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Platinum, 16)
                .circuitMeta(10)
                .output(milled, Platinum, 64)
                .output(milled, Platinum, 32)
                .EUt(VA[EV])
                .duration(2400)
                .grindBallTier(2)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Platinum, 16)
                .circuitMeta(2)
                .output(milled, Platinum, 16)
                .EUt(VA[EV])
                .duration(1500)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Platinum, 16)
                .circuitMeta(20)
                .output(milled, Platinum, 32)
                .EUt(VA[EV])
                .duration(1200)
                .grindBallTier(2)
                .buildAndRegister();

        //  Pyrope
        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Pyrope, 16)
                .circuitMeta(1)
                .output(milled, Pyrope, 48)
                .EUt(VA[EV])
                .duration(3000)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Pyrope, 16)
                .circuitMeta(10)
                .output(milled, Pyrope, 64)
                .output(milled, Pyrope, 32)
                .EUt(VA[EV])
                .duration(2400)
                .grindBallTier(2)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Pyrope, 16)
                .circuitMeta(2)
                .output(milled, Pyrope, 16)
                .EUt(VA[EV])
                .duration(1500)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Pyrope, 16)
                .circuitMeta(20)
                .output(milled, Pyrope, 32)
                .EUt(VA[EV])
                .duration(1200)
                .grindBallTier(2)
                .buildAndRegister();

        //  Redstone
        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Redstone, 16)
                .circuitMeta(1)
                .output(milled, Redstone, 48)
                .EUt(VA[EV])
                .duration(3000)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Redstone, 16)
                .circuitMeta(10)
                .output(milled, Redstone, 64)
                .output(milled, Redstone, 32)
                .EUt(VA[EV])
                .duration(2400)
                .grindBallTier(2)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Redstone, 16)
                .circuitMeta(2)
                .output(milled, Redstone, 16)
                .EUt(VA[EV])
                .duration(1500)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Redstone, 16)
                .circuitMeta(20)
                .output(milled, Redstone, 32)
                .EUt(VA[EV])
                .duration(1200)
                .grindBallTier(2)
                .buildAndRegister();

        //  Spessartine
        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Spessartine, 16)
                .circuitMeta(1)
                .output(milled, Spessartine, 48)
                .EUt(VA[EV])
                .duration(3000)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Spessartine, 16)
                .circuitMeta(10)
                .output(milled, Spessartine, 64)
                .output(milled, Spessartine, 32)
                .EUt(VA[EV])
                .duration(2400)
                .grindBallTier(2)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Spessartine, 16)
                .circuitMeta(2)
                .output(milled, Spessartine, 16)
                .EUt(VA[EV])
                .duration(1500)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Spessartine, 16)
                .circuitMeta(20)
                .output(milled, Spessartine, 32)
                .EUt(VA[EV])
                .duration(1200)
                .grindBallTier(2)
                .buildAndRegister();

        //  Sphalerite
        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Sphalerite, 16)
                .circuitMeta(1)
                .output(milled, Sphalerite, 48)
                .EUt(VA[EV])
                .duration(3000)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Sphalerite, 16)
                .circuitMeta(10)
                .output(milled, Sphalerite, 64)
                .output(milled, Sphalerite, 32)
                .EUt(VA[EV])
                .duration(2400)
                .grindBallTier(2)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Sphalerite, 16)
                .circuitMeta(2)
                .output(milled, Sphalerite, 16)
                .EUt(VA[EV])
                .duration(1500)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Sphalerite, 16)
                .circuitMeta(20)
                .output(milled, Sphalerite, 32)
                .EUt(VA[EV])
                .duration(1200)
                .grindBallTier(2)
                .buildAndRegister();

        //  Pentlandite
        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Pentlandite, 16)
                .circuitMeta(1)
                .output(milled, Pentlandite, 48)
                .EUt(VA[EV])
                .duration(3000)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(ore, Pentlandite, 16)
                .circuitMeta(10)
                .output(milled, Pentlandite, 64)
                .output(milled, Pentlandite, 32)
                .EUt(VA[EV])
                .duration(2400)
                .grindBallTier(2)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Pentlandite, 16)
                .circuitMeta(2)
                .output(milled, Pentlandite, 16)
                .EUt(VA[EV])
                .duration(1500)
                .grindBallTier(1)
                .buildAndRegister();

        ISA_MILL_RECIPES.recipeBuilder()
                .input(crushed, Pentlandite, 16)
                .circuitMeta(20)
                .output(milled, Pentlandite, 32)
                .EUt(VA[EV])
                .duration(1200)
                .grindBallTier(2)
                .buildAndRegister();
    }

    private static void flotationOreProcess() {

        //  C2H5ONa -> C2H5ONa (High Purity)
        //  The first C2H5ONa use Chemical Reactor recipe (for chemical chain), the second for Ore Processing.
        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, SodiumEthoxide, 9)
                .output(dust, SodiumEthylate, 9)
                .EUt(VA[MV])
                .duration(280)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Another K2O recipe
        //  You do not need to centrifuge ash now!
        //  2KOH -> K2O + H2O
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, PotassiumHydroxide, 6)
                .output(dust, Potash, 3)
                .fluidOutputs(Steam.getFluid(1000))
                .EUt(VA[MV])
                .duration(20)
                .temperature(455)
                .buildAndRegister();

        //  Na + C2H6O -> C2H5ONa + H
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Sodium)
                .fluidInputs(Ethanol.getFluid(1000))
                .output(dust, SodiumEthylate, 9)
                .fluidOutputs(Hydrogen.getFluid(1000))
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        //  K2O + 2.5 CaO -> 0.6 C2H5OCa + CaCO3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Potash, 3)
                .input(dust, Quicklime, 5)
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .output(dust, PotassiumEthylate, 6)
                .output(dust, CalciumCarbonate, 5)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        //  C + 2S -> CS2
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, Carbon)
                .input(dust, Sulfur, 2)
                .fluidOutputs(CarbonDisulfide.getFluid(1000))
                .EUt(VA[MV])
                .duration(350)
                .temperature(1200)
                .buildAndRegister();

        //  C2H5ONa + CS2 + C2H6O -> C3H5NaOS2 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumEthylate, 9)
                .fluidInputs(CarbonDisulfide.getFluid(1000))
                .fluidInputs(Ethanol.getFluid(1000))
                .output(dust, SodiumEthylxanthate, 12)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[HV])
                .duration(40)
                .buildAndRegister();

        //  0.3 C2H5OK + CS2 -> C3H5KOS2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PotassiumEthylate, 3)
                .fluidInputs(CarbonDisulfide.getFluid(1000))
                .output(dust, PotassiumEthylxanthate, 12)
                .EUt(VA[HV])
                .duration(40)
                .buildAndRegister();

        //  Almandine
        FLOTATION_RECIPES.recipeBuilder()
                .input(dust, SodiumEthylxanthate, 32)
                .input(milled, Almandine, 64)
                .input(milled, Almandine, 64)
                .input(milled, Almandine, 64)
                .input(milled, Almandine, 64)
                .fluidInputs(Turpentine.getFluid(18000))
                .fluidOutputs(AlmandineFront.getFluid(1000))
                .EUt(VA[IV])
                .duration(9600)
                .buildAndRegister();

        //  Chalcopyrite
        FLOTATION_RECIPES.recipeBuilder()
                .input(dust, PotassiumEthylxanthate, 32)
                .input(milled, Chalcopyrite, 64)
                .input(milled, Chalcopyrite, 64)
                .input(milled, Chalcopyrite, 64)
                .input(milled, Chalcopyrite, 64)
                .fluidInputs(Turpentine.getFluid(12000))
                .fluidOutputs(ChalcopyriteFront.getFluid(1000))
                .EUt(VA[IV])
                .duration(9600)
                .buildAndRegister();

        //  Grossular
        FLOTATION_RECIPES.recipeBuilder()
                .input(dust, PotassiumEthylxanthate, 32)
                .input(milled, Grossular, 64)
                .input(milled, Grossular, 64)
                .input(milled, Grossular, 64)
                .input(milled, Grossular, 64)
                .fluidInputs(Turpentine.getFluid(28000))
                .fluidOutputs(GrossularFront.getFluid(1000))
                .EUt(VA[LuV])
                .duration(9600)
                .buildAndRegister();

        //  Monazite
        FLOTATION_RECIPES.recipeBuilder()
                .input(dust, SodiumEthylxanthate, 32)
                .input(milled, Monazite, 64)
                .input(milled, Monazite, 64)
                .input(milled, Monazite, 64)
                .input(milled, Monazite, 64)
                .fluidInputs(Turpentine.getFluid(30000))
                .fluidOutputs(MonaziteFront.getFluid(1000))
                .EUt(VA[LuV])
                .duration(9600)
                .buildAndRegister();

        //  Nickel
        FLOTATION_RECIPES.recipeBuilder()
                .input(dust, PotassiumEthylxanthate, 32)
                .input(milled, Nickel, 64)
                .input(milled, Nickel, 64)
                .input(milled, Nickel, 64)
                .input(milled, Nickel, 64)
                .fluidInputs(Turpentine.getFluid(25000))
                .fluidOutputs(NickelFront.getFluid(1000))
                .EUt(VA[IV])
                .duration(9600)
                .buildAndRegister();

        //  Platinum
        FLOTATION_RECIPES.recipeBuilder()
                .input(dust, SodiumEthylxanthate, 32)
                .input(milled, Platinum, 64)
                .input(milled, Platinum, 64)
                .input(milled, Platinum, 64)
                .input(milled, Platinum, 64)
                .fluidInputs(Turpentine.getFluid(35000))
                .fluidOutputs(PlatinumFront.getFluid(1000))
                .EUt(VA[LuV])
                .duration(9600)
                .buildAndRegister();

        //  Pyrope
        FLOTATION_RECIPES.recipeBuilder()
                .input(dust, SodiumEthylxanthate, 32)
                .input(milled, Pyrope, 64)
                .input(milled, Pyrope, 64)
                .input(milled, Pyrope, 64)
                .input(milled, Pyrope, 64)
                .fluidInputs(Turpentine.getFluid(8000))
                .fluidOutputs(PyropeFront.getFluid(1000))
                .EUt(VA[IV])
                .duration(9600)
                .buildAndRegister();

        //  Redstone
        FLOTATION_RECIPES.recipeBuilder()
                .input(dust, SodiumEthylxanthate, 32)
                .input(milled, Redstone, 64)
                .input(milled, Redstone, 64)
                .input(milled, Redstone, 64)
                .input(milled, Redstone, 64)
                .fluidInputs(Turpentine.getFluid(13000))
                .fluidOutputs(RedstoneFront.getFluid(1000))
                .EUt(VA[IV])
                .duration(9600)
                .buildAndRegister();

        //  Spessartine
        FLOTATION_RECIPES.recipeBuilder()
                .input(dust, PotassiumEthylxanthate, 32)
                .input(milled, Spessartine, 64)
                .input(milled, Spessartine, 64)
                .input(milled, Spessartine, 64)
                .input(milled, Spessartine, 64)
                .fluidInputs(Turpentine.getFluid(35000))
                .fluidOutputs(SpessartineFront.getFluid(1000))
                .EUt(VA[LuV])
                .duration(9600)
                .buildAndRegister();

        //  Sphalerite
        FLOTATION_RECIPES.recipeBuilder()
                .input(dust, SodiumEthylxanthate, 32)
                .input(milled, Sphalerite, 64)
                .input(milled, Sphalerite, 64)
                .input(milled, Sphalerite, 64)
                .input(milled, Sphalerite, 64)
                .fluidInputs(Turpentine.getFluid(14000))
                .fluidOutputs(SphaleriteFront.getFluid(1000))
                .EUt(VA[LuV])
                .duration(9600)
                .buildAndRegister();

        //  Pentlandite
        FLOTATION_RECIPES.recipeBuilder()
                .input(dust, PotassiumEthylxanthate, 32)
                .input(milled, Pentlandite, 64)
                .input(milled, Pentlandite, 64)
                .input(milled, Pentlandite, 64)
                .input(milled, Pentlandite, 64)
                .fluidInputs(Turpentine.getFluid(14000))
                .fluidOutputs(PentlanditeFront.getFluid(1000))
                .EUt(VA[LuV])
                .duration(9600)
                .buildAndRegister();
    }

    private static void dryingOreProcess() {

        //  Almandine
        VACUUM_DRYING_RECIPES.recipeBuilder()
                .fluidInputs(AlmandineFront.getFluid(4000))
                .output(dust, Aluminium, 64)
                .output(dust, Aluminium, 64)
                .output(dust, Aluminium, 22)
                .output(dust, Manganese, 64)
                .output(dust, Manganese, 26)
                .output(dust, Yttrium, 25)
                .output(dust, Ytterbium, 15)
                .EUt(VA[IV])
                .duration(2400)
                .blastFurnaceTemp(5500)
                .buildAndRegister();

        //  Chalcopyrite
        VACUUM_DRYING_RECIPES.recipeBuilder()
                .fluidInputs(ChalcopyriteFront.getFluid(4000))
                .output(dust, Copper, 64)
                .output(dust, Copper, 64)
                .output(dust, Copper, 52)
                .output(dust, Iron, 64)
                .output(dust, Iron, 44)
                .output(dust, Cadmium, 50)
                .output(dust, Indium, 10)
                .EUt(VA[IV])
                .duration(2400)
                .blastFurnaceTemp(4500)
                .buildAndRegister();

        //  Grossular
        VACUUM_DRYING_RECIPES.recipeBuilder()
                .fluidInputs(GrossularFront.getFluid(4000))
                .output(dust, Calcium, 64)
                .output(dust, Calcium, 64)
                .output(dust, Calcium, 52)
                .output(dust, Aluminium, 64)
                .output(dust, Aluminium, 46)
                .output(dust, Tungsten, 60)
                .output(dust, Thallium, 15)
                .EUt(VA[LuV])
                .duration(2400)
                .blastFurnaceTemp(5500)
                .buildAndRegister();

        //  Monazite
        VACUUM_DRYING_RECIPES.recipeBuilder()
                .fluidInputs(MonaziteFront.getFluid(4000))
                .output(dust, Erbium, 64)
                .output(dust, Zirconium, 64)
                .output(dust, Lanthanum, 32)
                .output(dust, Lutetium, 16)
                .output(dust, Europium, 8)
                .EUt(VA[ZPM])
                .duration(2400)
                .blastFurnaceTemp(5500)
                .buildAndRegister();

        //  Nickel
        VACUUM_DRYING_RECIPES.recipeBuilder()
                .fluidInputs(NickelFront.getFluid(4000))
                .output(dust, Nickel, 64)
                .output(dust, Nickel, 64)
                .output(dust, Nickel, 22)
                .output(dust, Cobalt, 64)
                .output(dust, Cobalt, 56)
                .output(dust, Rhodium, 32)
                .output(dust, Ruthenium, 16)
                .EUt(VA[IV])
                .duration(2400)
                .blastFurnaceTemp(4500)
                .buildAndRegister();

        //  Platinum
        VACUUM_DRYING_RECIPES.recipeBuilder()
                .fluidInputs(PlatinumFront.getFluid(4000))
                .output(dust, Platinum, 64)
                .output(dust, Platinum, 64)
                .output(dust, Iridium, 40)
                .output(dust, Selenium, 40)
                .output(dust, Osmium, 20)
                .output(dust, Tellurium, 10)
                .EUt(VA[LuV])
                .duration(2400)
                .blastFurnaceTemp(5500)
                .buildAndRegister();

        //  Pyrope
        VACUUM_DRYING_RECIPES.recipeBuilder()
                .fluidInputs(PyropeFront.getFluid(4000))
                .output(dust, Magnesium, 64)
                .output(dust, Magnesium, 46)
                .output(dust, Manganese, 64)
                .output(dust, Manganese, 6)
                .output(dust, Boron, 60)
                .output(dust, Rhenium, 20)
                .EUt(VA[EV])
                .duration(2400)
                .blastFurnaceTemp(3500)
                .buildAndRegister();

        //  Redstone
        VACUUM_DRYING_RECIPES.recipeBuilder()
                .fluidInputs(RedstoneFront.getFluid(4000))
                .output(dust, Redstone, 64)
                .output(dust, Redstone, 64)
                .output(dust, Redstone, 64)
                .output(dust, Redstone, 44)
                .output(dust, Chrome, 60)
                .output(dust, Rutile, 48)
                .output(dust, Dysprosium, 16)
                .EUt(VA[IV])
                .duration(2400)
                .blastFurnaceTemp(4500)
                .buildAndRegister();

        //  Spessartine
        VACUUM_DRYING_RECIPES.recipeBuilder()
                .fluidInputs(SpessartineFront.getFluid(4000))
                .output(dust, Manganese, 64)
                .output(dust, Manganese, 64)
                .output(dust, Manganese, 22)
                .output(dust, Aluminium, 64)
                .output(dust, Aluminium, 26)
                .output(dust, Palladium, 30)
                .output(dust, Strontium, 20)
                .EUt(VA[LuV])
                .duration(2400)
                .blastFurnaceTemp(5500)
                .buildAndRegister();

        //  Sphalerite
        VACUUM_DRYING_RECIPES.recipeBuilder()
                .fluidInputs(SphaleriteFront.getFluid(4000))
                .output(dust, Zinc, 64)
                .output(dust, Zinc, 64)
                .output(dust, Zinc, 52)
                .output(dust, Iron, 64)
                .output(dust, Iron, 56)
                .output(dust, Indium, 64)
                .output(dust, Germanium, 15)
                .EUt(VA[LuV])
                .duration(2400)
                .blastFurnaceTemp(5500)
                .buildAndRegister();

        //  Pentlandite
        VACUUM_DRYING_RECIPES.recipeBuilder()
                .fluidInputs(PentlanditeFront.getFluid(4000))
                .output(dust, Iron, 64)
                .output(dust, Iron, 64)
                .output(dust, Iron, 22)
                .output(dust, Nickel, 64)
                .output(dust, Nickel, 36)
                .output(dust, Promethium, 20)
                .output(dust, Hafnium, 10)
                .EUt(VA[LuV])
                .duration(2400)
                .blastFurnaceTemp(5500)
                .buildAndRegister();
    }
}