package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.unification.material.Material;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.DRONE_AIRPORT_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

@SuppressWarnings("rawtypes")
public class DroneAirport {

    public static void init() {
        DroneRecipes();
        LVstage();
        MVstage();
        HVstage();
        EVstage();
        IVstage();
    }

    private static void DroneRecipes() {

        //  LV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Steel)
                .input(ROBOT_ARM_LV, 2)
                .input(SENSOR_LV, 2)
                .input(cableGtSingle, Tin, 2)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(MINING_DRONE_LV)
                .EUt(VA[LV])
                .duration(200)
                .buildAndRegister();

        //  MV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Aluminium)
                .input(ROBOT_ARM_MV, 2)
                .input(SENSOR_MV, 2)
                .input(cableGtSingle, Copper, 2)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(MINING_DRONE_MV)
                .EUt(VA[MV])
                .duration(200)
                .buildAndRegister();

        //  HV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, StainlessSteel)
                .input(ROBOT_ARM_HV, 2)
                .input(SENSOR_HV, 2)
                .input(cableGtSingle, Gold, 2)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(MINING_DRONE_HV)
                .EUt(VA[HV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  EV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Titanium)
                .input(ROBOT_ARM_EV, 2)
                .input(SENSOR_EV, 2)
                .input(cableGtSingle, Aluminium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(MINING_DRONE_EV)
                .EUt(VA[EV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  IV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenSteel)
                .input(ROBOT_ARM_IV, 2)
                .input(SENSOR_IV, 2)
                .input(cableGtSingle, Platinum, 2)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(MINING_DRONE_IV)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  LuV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, RhodiumPlatedPalladium)
                .input(ROBOT_ARM_LuV, 2)
                .input(SENSOR_LuV, 2)
                .input(cableGtSingle, NiobiumTitanium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Cupronickel.getFluid(L))
                .output(MINING_DRONE_LuV)
                .EUt(VA[LuV])
                .duration(200)
                .scannerResearch(b -> b
                        .researchStack(MINING_DRONE_IV.getStackForm())
                        .EUt(VA[IV])
                        .duration(400))
                .buildAndRegister();

        //  ZPM
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .input(ROBOT_ARM_ZPM, 2)
                .input(SENSOR_ZPM, 2)
                .input(cableGtSingle, VanadiumGallium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Kanthal.getFluid(L))
                .output(MINING_DRONE_ZPM)
                .EUt(VA[ZPM])
                .duration(200)
                .scannerResearch(b -> b
                        .researchStack(MINING_DRONE_LuV.getStackForm())
                        .EUt(VA[LuV])
                        .duration(400))
                .buildAndRegister();

        //  UV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Darmstadtium)
                .input(ROBOT_ARM_UV, 2)
                .input(SENSOR_UV, 2)
                .input(cableGtSingle, YttriumBariumCuprate, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Nichrome.getFluid(L))
                .output(MINING_DRONE_UV)
                .EUt(VA[UV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(MINING_DRONE_ZPM.getStackForm())
                        .EUt(VA[ZPM])
                        .CWUt(32))
                .buildAndRegister();

        //  UHV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(ROBOT_ARM_UHV, 2)
                .input(SENSOR_UHV, 2)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(RTMAlloy.getFluid(L))
                .output(MINING_DRONE_UHV)
                .EUt(VA[UHV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(MINING_DRONE_UV.getStackForm())
                        .EUt(VA[UV])
                        .CWUt(64))
                .buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(ROBOT_ARM_UEV, 2)
                .input(SENSOR_UEV, 2)
                .input(cableGtSingle, PedotTMA, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(HSSG.getFluid(L))
                .output(MINING_DRONE_UEV)
                .EUt(VA[UEV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(MINING_DRONE_UHV.getStackForm())
                        .EUt(VA[UHV])
                        .CWUt(128))
                .buildAndRegister();

        //  UIV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Infinity)
                .input(ROBOT_ARM_UIV, 2)
                .input(SENSOR_UIV, 2)
                .input(cableGtSingle, Solarium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Naquadah.getFluid(L))
                .output(MINING_DRONE_UIV)
                .EUt(VA[UIV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(MINING_DRONE_UEV.getStackForm())
                        .EUt(VA[UEV])
                        .CWUt(256))
                .buildAndRegister();

        //  UXV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, CosmicNeutronium)
                .input(ROBOT_ARM_UXV, 2)
                .input(SENSOR_UXV, 2)
                .input(cableGtSingle, Hypogen, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Trinium.getFluid(L))
                .output(MINING_DRONE_UXV)
                .EUt(VA[UXV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(MINING_DRONE_UIV.getStackForm())
                        .EUt(VA[UIV])
                        .CWUt(512))
                .buildAndRegister();

        //  OpV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Spacetime)
                .input(ROBOT_ARM_OpV, 2)
                .input(SENSOR_OpV, 2)
                .input(cableGtSingle, Galaxium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Tritanium.getFluid(L))
                .output(MINING_DRONE_OpV)
                .EUt(VA[OpV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(MINING_DRONE_UXV.getStackForm())
                        .EUt(VA[UXV])
                        .CWUt(1024))
                .buildAndRegister();

        //  MAX
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Eternity)
                .input(ROBOT_ARM_MAX, 2)
                .input(SENSOR_MAX, 2)
                .input(cableGtSingle, Universium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Adamantium.getFluid(L))
                .output(MINING_DRONE_MAX)
                .EUt(VA[MAX])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(MINING_DRONE_OpV.getStackForm())
                        .EUt(VA[OpV])
                        .CWUt(2048))
                .buildAndRegister();
    }

    private static void LVstage() {
        //  Iron-Copper-Gold vein
        createDroneAirportRecipe(1, MINING_DRONE_LV,
                Iron,              8000,
                Copper,            8000,
                Gold,              6000,
                Magnetite,         9000,
                VanadiumMagnetite, 7000,
                Pyrite,            8000,
                Chalcopyrite,      9000,
                Sphalerite,        6000,
                Aluminium,         6000,
                VH[LV]);

        //  Nickel-Cobalt-Sulfur vein
        createDroneAirportRecipe(2, MINING_DRONE_LV,
                Nickel,         8000,
                Cobalt,         7000,
                Sulfur,         9000,
                Garnierite,     7000,
                Pentlandite,    6000,
                YellowLimonite, 9000,
                BrownLimonite,  9000,
                BandedIron,     8000,
                Cobaltite,      6000,
                VH[LV]);

        //  Salt-Rock Salt vein
        createDroneAirportRecipe(3, MINING_DRONE_LV,
                Salt,       9000,
                RockSalt,   9000,
                Realgar,    7000,
                Zeolite,    8000,
                Asbestos,   9000,
                Lepidolite, 7000,
                Spodumene,  7000,
                Grossular,  6000,
                Gypsum,     7000,
                VH[LV]);

        //  Quartzites-Topaz vein
        createDroneAirportRecipe(4, MINING_DRONE_LV,
                Quartzite,           9000,
                NetherQuartz,        8000,
                CertusQuartz,        8000,
                Barite,              7000,
                BasalticMineralSand, 7000,
                GraniticMineralSand, 7000,
                FullersEarth,        8000,
                Topaz,               6000,
                BlueTopaz,           6000,
                VH[LV]);
    }

    private static void MVstage() {
        //  Lead-Silver-Copper vein
        createDroneAirportRecipe(1, MINING_DRONE_MV,
                Lead,            8000,
                Silver,          6000,
                Tin,             9000,
                Galena,          8000,
                Cassiterite,     7000,
                CassiteriteSand, 5000,
                Tetrahedrite,    8000,
                Stibnite,        6000,
                Bauxite,         7000,
                VH[MV]);

        //  Redstone-Diamond-Thorium vein
        createDroneAirportRecipe(2, MINING_DRONE_MV,
                Redstone,  8000,
                Diamond,   7000,
                Emerald,   6000,
                Ruby,      6000,
                Cinnabar,  7000,
                Coal,      9000,
                Graphite,  6000,
                Beryllium, 8000,
                Thorium,   6000,
                VH[MV]);

        //  Lapis-Electrotine vein
        createDroneAirportRecipe(3, MINING_DRONE_MV,
                Lapis,       8000,
                Sodalite,    7000,
                Kyanite,     9000,
                Lazurite,    8000,
                Calcite,     9000,
                Electrotine, 6000,
                Saltpeter,   7000,
                Diatomite,   8000,
                Alunite,     6000,
                VH[MV]);

        //  Oilsand-Magnesite vein
        createDroneAirportRecipe(4, MINING_DRONE_MV,
                Oilsands,       9000,
                Soapstone,      8000,
                Talc,           8000,
                GlauconiteSand, 7000,
                Trona,          6000,
                Magnesite,      7000,
                Olivine,        7000,
                Bentonite,      7000,
                Pollucite,      6000,
                VH[MV]);
    }

    private static void HVstage() {

        //  Lithium-Tungsten-Molybdenum vein
        createDroneAirportRecipe(1, MINING_DRONE_HV,
                Lithium,     9000,
                Molybdenum,  7000,
                Scheelite,   6000,
                Tungstate,   6000,
                Wulfenite,   8000,
                Molybdenite, 8000,
                Powellite,   7000,
                Chromite,    7000,
                Ilmenite,    6000,
                VH[HV]);

        //  Neodymium-Platinum-Palladium vein
        createDroneAirportRecipe(2, MINING_DRONE_HV,
                Neodymium,  6000,
                Platinum,   7000,
                Palladium,  7000,
                Bastnasite, 8000,
                Monazite,   7000,
                Cooperite,  8000,
                Bornite,    9000,
                Tantalite,  8000,
                Pyrolusite, 8000,
                VH[HV]);

        //  Sapphire-Amethyst vein
        createDroneAirportRecipe(3, MINING_DRONE_HV,
                Sapphire,      7000,
                Almandine,     7000,
                Pyrope,        8000,
                GreenSapphire, 7000,
                Amethyst,      9000,
                GarnetRed,     8000,
                GarnetYellow,  8000,
                GarnetYellow,  8000,
                Opal,          8000,
                VH[HV]);

        //  Copper-Tantalum vein
        createDroneAirportRecipe(4, MINING_DRONE_HV,
                Malachite,           9000,
                Apatite,             8000,
                TricalciumPhosphate, 8000,
                Realgar,             9000,
                Grossular,           8000,
                Pyrolusite,          7000,
                Spessartine,         7000,
                Tantalite,           6000,
                Pyrochlore,          8000,
                VH[HV]);
    }

    private static void EVstage() {

        //  Naquadah-Plutonium-Uranium vein
        createDroneAirportRecipe(1, MINING_DRONE_EV,
                Neodymium,  9000,
                Platinum,   8000,
                Cooperite,  7000,
                Tungstate,  8000,
                Scheelite,  7000,
                Bauxite,    8000,
                Palladium,  7000,
                Pyrochlore, 8000,
                Grossular,  8000,
                VH[EV]);

        //  Monazite-Molybdenum vein
        createDroneAirportRecipe(2, MINING_DRONE_EV,
                Monazite,    9000,
                Bastnasite,  8000,
                Molybdenum,  7000,
                Molybdenite, 8000,
                Bornite,     7000,
                Tantalite,   8000,
                Almandine,   8000,
                Apatite,     7000,
                Ilmenite,    7000,
                VH[EV]);

        //  Oilsand vein
        createDroneAirportRecipe(3, MINING_DRONE_EV,
                Oilsands,            8000,
                Oilsands,            8000,
                Oilsands,            8000,
                Oilsands,            8000,
                GraniticMineralSand, 7000,
                GarnetSand,          7000,
                BasalticMineralSand, 6000,
                GlauconiteSand,      9000,
                Quartzite,           7000,
                VH[EV]);

        //  Silver-Gold-Platinum vein
        createDroneAirportRecipe(4, MINING_DRONE_EV,
                Silver,    7000,
                Silver,    7000,
                Gold,      6000,
                Gold,      6000,
                Platinum,  8000,
                Platinum,  8000,
                Lead,      9000,
                Tin,       9000,
                Cooperite, 7000,
                VH[EV]);
    }

    private static void IVstage() {

        //  Naquadah-Plutonium-Uranium vein
        createDroneAirportRecipe(1, MINING_DRONE_IV,
                Naquadah,     6000,
                Naquadah,     6000,
                Naquadah,     6000,
                Plutonium239, 7000,
                Uraninite,    8000,
                Uraninite,    8000,
                Pitchblende,  8000,
                Pitchblende,  8000,
                Pyrochlore,   9000,
                VH[IV]);

        //  Thorium-Plutonium-Pitchblende vein
        createDroneAirportRecipe(2, MINING_DRONE_IV,
                Thorium,     8000,
                Thorium,     8000,
                Uraninite,   7000,
                Uraninite,   7000,
                Pitchblende, 9000,
                Pitchblende, 9000,
                Beryllium,   8000,
                Emerald,     8000,
                Olivine,     9000,
                VH[IV]);

        //  Sylvanite-Gold-Silver vein
        createDroneAirportRecipe(3, MINING_DRONE_IV,
                Gold,      8000,
                Gold,      8000,
                Gold,      8000,
                Gold,      8000,
                Silver,    9000,
                Silver,    9000,
                Silver,    9000,
                Sylvanite, 4000,
                Sylvanite, 4000,
                VH[IV]);

        //  Rhenite-Molybdenum vein
        createDroneAirportRecipe(4, MINING_DRONE_IV,
                Molybdenite, 9000,
                Molybdenite, 9000,
                Molybdenite, 9000,
                Wulfenite,   8000,
                Wulfenite,   8000,
                Wulfenite,   8000,
                Rheniite,    7000,
                Rheniite,    7000,
                Rheniite,    7000,
                VH[IV]);
    }

    private static void createDroneAirportRecipe(int circuitMeta,
                                                 MetaItem.MetaValueItem drone,
                                                 Material ore1,
                                                 int chanceOre1,
                                                 Material ore2,
                                                 int chanceOre2,
                                                 Material ore3,
                                                 int chanceOre3,
                                                 Material ore4,
                                                 int chanceOre4,
                                                 Material ore5,
                                                 int chanceOre5,
                                                 Material ore6,
                                                 int chanceOre6,
                                                 Material ore7,
                                                 int chanceOre7,
                                                 Material ore8,
                                                 int chanceOre8,
                                                 Material ore9,
                                                 int chanceOre9,
                                                 int voltage) {
        //  x1
        for (FluidStack stack : new FluidStack[] {
                RocketFuel.getFluid(4000),
                RP1RocketFuel.getFluid(4000),
                DenseHydrazineMixtureFuel.getFluid(2000),
                MethylhydrazineNitrateRocketFuel.getFluid(2000)
        }) {
            DRONE_AIRPORT_RECIPES.recipeBuilder()
                    .circuitMeta(circuitMeta)
                    .notConsumable(drone.getStackForm(4))
                    .fluidInputs(new FluidStack[]{stack})
                    .chancedOutput(ore, ore1, 4, chanceOre1, 500)
                    .chancedOutput(ore, ore2, 4, chanceOre2, 500)
                    .chancedOutput(ore, ore3, 4, chanceOre3, 500)
                    .chancedOutput(ore, ore4, 4, chanceOre4, 500)
                    .chancedOutput(ore, ore5, 4, chanceOre5, 500)
                    .chancedOutput(ore, ore6, 4, chanceOre6, 500)
                    .chancedOutput(ore, ore7, 4, chanceOre7, 500)
                    .chancedOutput(ore, ore8, 4, chanceOre8, 500)
                    .chancedOutput(ore, ore9, 4, chanceOre9, 500)
                    .EUt(voltage)
                    .duration(400)
                    .buildAndRegister();
        }

        //  x2
        for (FluidStack stack : new FluidStack[] {
                RocketFuel.getFluid(8000),
                RP1RocketFuel.getFluid(8000),
                DenseHydrazineMixtureFuel.getFluid(4000),
                MethylhydrazineNitrateRocketFuel.getFluid(4000)
        }) {
            DRONE_AIRPORT_RECIPES.recipeBuilder()
                    .circuitMeta(circuitMeta + 5)
                    .notConsumable(drone.getStackForm(16))
                    .fluidInputs(new FluidStack[]{stack})
                    .chancedOutput(ore, ore1, 16, chanceOre1, 500)
                    .chancedOutput(ore, ore2, 16, chanceOre2, 500)
                    .chancedOutput(ore, ore3, 16, chanceOre3, 500)
                    .chancedOutput(ore, ore4, 16, chanceOre4, 500)
                    .chancedOutput(ore, ore5, 16, chanceOre5, 500)
                    .chancedOutput(ore, ore6, 16, chanceOre6, 500)
                    .chancedOutput(ore, ore7, 16, chanceOre7, 500)
                    .chancedOutput(ore, ore8, 16, chanceOre8, 500)
                    .chancedOutput(ore, ore9, 16, chanceOre9, 500)
                    .EUt(voltage)
                    .duration(400)
                    .buildAndRegister();
        }

        //  x4
        for (FluidStack stack : new FluidStack[] {
                RocketFuel.getFluid(16000),
                RP1RocketFuel.getFluid(16000),
                DenseHydrazineMixtureFuel.getFluid(8000),
                MethylhydrazineNitrateRocketFuel.getFluid(8000)
        }) {
            DRONE_AIRPORT_RECIPES.recipeBuilder()
                    .circuitMeta(circuitMeta + 10)
                    .notConsumable(drone.getStackForm(64))
                    .fluidInputs(new FluidStack[]{stack})
                    .chancedOutput(ore, ore1, 64, chanceOre1, 500)
                    .chancedOutput(ore, ore2, 64, chanceOre2, 500)
                    .chancedOutput(ore, ore3, 64, chanceOre3, 500)
                    .chancedOutput(ore, ore4, 64, chanceOre4, 500)
                    .chancedOutput(ore, ore5, 64, chanceOre5, 500)
                    .chancedOutput(ore, ore6, 64, chanceOre6, 500)
                    .chancedOutput(ore, ore7, 64, chanceOre7, 500)
                    .chancedOutput(ore, ore8, 64, chanceOre8, 500)
                    .chancedOutput(ore, ore9, 64, chanceOre9, 500)
                    .EUt(voltage)
                    .duration(400)
                    .buildAndRegister();
        }
    }

}