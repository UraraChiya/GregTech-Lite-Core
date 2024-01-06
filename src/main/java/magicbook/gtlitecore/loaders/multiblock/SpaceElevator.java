package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.fluids.store.FluidStorageKeys;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class SpaceElevator {

    public static void init() {
        DrillingModule();
        MiningModule();
        AssemblingModule();
    }

    private static void DrillingModule() {

        //  LV
        for (FluidStack stack : new FluidStack[]{
                RocketFuel.getFluid(2000),
                RP1RocketFuel.getFluid(2000),
                DenseHydrazineMixtureFuel.getFluid(500),
                MethylhydrazineNitrateRocketFuel.getFluid(500)}) {

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LV.getStackForm(16))
                    .circuitMeta(0)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Oil.getFluid(3000000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LV.getStackForm(16))
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(RawOil.getFluid(1400000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LV.getStackForm(16))
                    .circuitMeta(2)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(OilLight.getFluid(1950000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LV.getStackForm(16))
                    .circuitMeta(3)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(OilHeavy.getFluid(1792000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LV.getStackForm(16))
                    .circuitMeta(4)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Oxygen.getFluid(3800000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LV.getStackForm(16))
                    .circuitMeta(5)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Nitrogen.getFluid(8500000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LV.getStackForm(16))
                    .circuitMeta(6)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Hydrogen.getFluid(2800000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LV.getStackForm(16))
                    .circuitMeta(7)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Iron.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LV.getStackForm(16))
                    .circuitMeta(8)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Bronze.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();
        }

        //  MV
        for (FluidStack stack : new FluidStack[]{
                RocketFuel.getFluid(2000),
                RP1RocketFuel.getFluid(2000),
                DenseHydrazineMixtureFuel.getFluid(500),
                MethylhydrazineNitrateRocketFuel.getFluid(500)}) {

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_MV.getStackForm(16))
                    .circuitMeta(0)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(HeliumNeon.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_MV.getStackForm(16))
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Ammonia.getFluid(1280000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_MV.getStackForm(16))
                    .circuitMeta(2)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Ethylene.getFluid(1792000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_MV.getStackForm(16))
                    .circuitMeta(3)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(SaltWater.getFluid(13000000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_MV.getStackForm(16))
                    .circuitMeta(4)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(SulfuricAcid.getFluid(1784000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_MV.getStackForm(16))
                    .circuitMeta(5)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Chlorobenzene.getFluid(1896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_MV.getStackForm(16))
                    .circuitMeta(6)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(CarbonMonoxide.getFluid(9480000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_MV.getStackForm(16))
                    .circuitMeta(7)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Methane.getFluid(2792000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_MV.getStackForm(16))
                    .circuitMeta(8)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Air.getFluid(FluidStorageKeys.GAS, 1000000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();
        }

        //  HV
        for (FluidStack stack : new FluidStack[]{
                RocketFuel.getFluid(2000),
                RP1RocketFuel.getFluid(2000),
                DenseHydrazineMixtureFuel.getFluid(500),
                MethylhydrazineNitrateRocketFuel.getFluid(500)}) {

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_HV.getStackForm(16))
                    .circuitMeta(0)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(NetherAir.getFluid(FluidStorageKeys.GAS, 1000000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_HV.getStackForm(16))
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Nickel.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_HV.getStackForm(16))
                    .circuitMeta(2)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Lead.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_HV.getStackForm(16))
                    .circuitMeta(3)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(HydrofluoricAcid.getFluid(1784000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_HV.getStackForm(16))
                    .circuitMeta(4)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Argon.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_HV.getStackForm(16))
                    .circuitMeta(5)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Krypton.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_HV.getStackForm(16))
                    .circuitMeta(6)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Xenon.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_HV.getStackForm(16))
                    .circuitMeta(7)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(VinylChloride.getFluid(1792000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_HV.getStackForm(16))
                    .circuitMeta(8)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Deuterium.getFluid(2800000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();
        }

        //  EV
        for (FluidStack stack : new FluidStack[]{
                RocketFuel.getFluid(2000),
                RP1RocketFuel.getFluid(2000),
                DenseHydrazineMixtureFuel.getFluid(500),
                MethylhydrazineNitrateRocketFuel.getFluid(500)}) {

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_EV.getStackForm(16))
                    .circuitMeta(0)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(EnderAir.getFluid(FluidStorageKeys.GAS, 1000000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_EV.getStackForm(16))
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Tritium.getFluid(2800000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_EV.getStackForm(16))
                    .circuitMeta(2)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Aluminium.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_EV.getStackForm(16))
                    .circuitMeta(3)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Bromine.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_EV.getStackForm(16))
                    .circuitMeta(4)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Iodine.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_EV.getStackForm(16))
                    .circuitMeta(5)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(SodiumBisulfate.getFluid(450000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_EV.getStackForm(16))
                    .circuitMeta(6)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Propene.getFluid(1896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_EV.getStackForm(16))
                    .circuitMeta(7)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Butadiene.getFluid(1896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_EV.getStackForm(16))
                    .circuitMeta(8)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Isoprene.getFluid(1896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();
        }

        //  IV
        for (FluidStack stack : new FluidStack[]{
                RocketFuel.getFluid(2000),
                RP1RocketFuel.getFluid(2000),
                DenseHydrazineMixtureFuel.getFluid(500),
                MethylhydrazineNitrateRocketFuel.getFluid(500)}) {

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_IV.getStackForm(16))
                    .circuitMeta(0)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Radon.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_IV.getStackForm(16))
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Naquadah.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_IV.getStackForm(16))
                    .circuitMeta(2)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Magnalium.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_IV.getStackForm(16))
                    .circuitMeta(3)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Iron3Chloride.getFluid(900000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_IV.getStackForm(16))
                    .circuitMeta(4)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Blaze.getFluid(1896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_IV.getStackForm(16))
                    .circuitMeta(5)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Tetrafluoroethylene.getFluid(1792000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_IV.getStackForm(16))
                    .circuitMeta(6)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(TitaniumTetrachloride.getFluid(896000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_IV.getStackForm(16))
                    .circuitMeta(7)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(DistilledWater.getFluid(80000000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_IV.getStackForm(16))
                    .circuitMeta(8)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(SodiumPotassium.getFluid(450000))
                    .CasingTier(1)
                    .EUt(VA[UV])
                    .duration(20)
                    .buildAndRegister();
        }

        //  LuV
        for (FluidStack stack : new FluidStack[]{
                RocketFuel.getFluid(4000),
                RP1RocketFuel.getFluid(4000),
                DenseHydrazineMixtureFuel.getFluid(1000),
                MethylhydrazineNitrateRocketFuel.getFluid(1000)}) {

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LuV.getStackForm(16))
                    .circuitMeta(0)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Beryllium.getFluid(896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LuV.getStackForm(16))
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Thorium.getFluid(896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LuV.getStackForm(16))
                    .circuitMeta(2)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Plutonium239.getFluid(896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LuV.getStackForm(16))
                    .circuitMeta(3)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Plutonium241.getFluid(896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LuV.getStackForm(16))
                    .circuitMeta(4)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Tungsten.getFluid(896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LuV.getStackForm(16))
                    .circuitMeta(5)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Neodymium.getFluid(896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LuV.getStackForm(16))
                    .circuitMeta(6)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(FluoroantimonicAcid.getFluid(450000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LuV.getStackForm(16))
                    .circuitMeta(7)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(NetherStar.getFluid(450000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_LuV.getStackForm(16))
                    .circuitMeta(8)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(DragonBreath.getFluid(450000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();
        }

        //  ZPM
        for (FluidStack stack : new FluidStack[]{
                RocketFuel.getFluid(4000),
                RP1RocketFuel.getFluid(4000),
                DenseHydrazineMixtureFuel.getFluid(1000),
                MethylhydrazineNitrateRocketFuel.getFluid(1000)}) {

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_ZPM.getStackForm(16))
                    .circuitMeta(0)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(NaquadahEnriched.getFluid(896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_ZPM.getStackForm(16))
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Electrum.getFluid(896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_ZPM.getStackForm(16))
                    .circuitMeta(2)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Butyraldehyde.getFluid(1792000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_ZPM.getStackForm(16))
                    .circuitMeta(3)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(IndiumConcentrate.getFluid(450000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_ZPM.getStackForm(16))
                    .circuitMeta(4)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(AquaRegia.getFluid(1896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_ZPM.getStackForm(16))
                    .circuitMeta(5)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(BoronTrifluoride.getFluid(1896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_ZPM.getStackForm(16))
                    .circuitMeta(6)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Lubricant.getFluid(1896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_ZPM.getStackForm(16))
                    .circuitMeta(7)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(PhosphoricAcid.getFluid(1784000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_ZPM.getStackForm(16))
                    .circuitMeta(8)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Epoxy.getFluid(1792000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();
        }

        //  UV
        for (FluidStack stack : new FluidStack[]{
                RocketFuel.getFluid(4000),
                RP1RocketFuel.getFluid(4000),
                DenseHydrazineMixtureFuel.getFluid(1000),
                MethylhydrazineNitrateRocketFuel.getFluid(1000)}) {

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_UV.getStackForm(16))
                    .circuitMeta(0)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(GalliumArsenide.getFluid(900000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_UV.getStackForm(16))
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Palladium.getFluid(896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_UV.getStackForm(16))
                    .circuitMeta(2)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Platinum.getFluid(896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_UV.getStackForm(16))
                    .circuitMeta(3)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Caesium.getFluid(896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_UV.getStackForm(16))
                    .circuitMeta(4)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Mercury.getFluid(896000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_UV.getStackForm(16))
                    .circuitMeta(5)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Dichloroethane.getFluid(900000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_UV.getStackForm(16))
                    .circuitMeta(6)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(LeadZincSolution.getFluid(900000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_UV.getStackForm(16))
                    .circuitMeta(7)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(SulfurDichloride.getFluid(900000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_UV.getStackForm(16))
                    .circuitMeta(8)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(BedrockSmoke.getFluid(1792000))
                    .CasingTier(2)
                    .EUt(VA[UHV])
                    .duration(20)
                    .buildAndRegister();
        }

        //  UHV 3 6000 2000

        //  UEV 3

        //  UIV 4 8000 4000
        for (FluidStack stack : new FluidStack[]{
                RocketFuel.getFluid(8000),
                RP1RocketFuel.getFluid(8000),
                DenseHydrazineMixtureFuel.getFluid(4000),
                MethylhydrazineNitrateRocketFuel.getFluid(4000)}) {

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_UIV.getStackForm(16))
                    .circuitMeta(0)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(RawStarMatter.getFluid(100000))
                    .CasingTier(4)
                    .EUt(VA[UIV])
                    .duration(20)
                    .buildAndRegister();

            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .notConsumable(MINING_DRONE_UIV.getStackForm(16))
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(StarCoreMatter.getPlasma(100000))
                    .CasingTier(4)
                    .EUt(VA[UIV])
                    .duration(20)
                    .buildAndRegister();
        }

        //  UXV 4

        //  OpV 5

        //  MAX 5
    }

    private static void MiningModule() {

        //  LV
        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(1)
                .fluidInputs(RocketFuel.getFluid(2000))
                .chancedOutput(ore, Iron, 1024, 8000, 500)
                .chancedOutput(ore, Copper, 1024, 8000, 500)
                .chancedOutput(ore, Gold, 1024, 6000, 500)
                .chancedOutput(ore, Magnetite, 1024, 9000, 500)
                .chancedOutput(ore, VanadiumMagnetite, 1024, 8000, 500)
                .chancedOutput(ore, Pyrite, 1024, 8000, 500)
                .chancedOutput(ore, Chalcopyrite, 1024, 9000, 500)
                .chancedOutput(ore, Sphalerite, 1024, 6000, 500)
                .chancedOutput(ore, Aluminium, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(1)
                .fluidInputs(RP1RocketFuel.getFluid(2000))
                .chancedOutput(ore, Iron, 1024, 8000, 500)
                .chancedOutput(ore, Copper, 1024, 8000, 500)
                .chancedOutput(ore, Gold, 1024, 6000, 500)
                .chancedOutput(ore, Magnetite, 1024, 9000, 500)
                .chancedOutput(ore, VanadiumMagnetite, 1024, 8000, 500)
                .chancedOutput(ore, Pyrite, 1024, 8000, 500)
                .chancedOutput(ore, Chalcopyrite, 1024, 9000, 500)
                .chancedOutput(ore, Sphalerite, 1024, 6000, 500)
                .chancedOutput(ore, Aluminium, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(11)
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(2000))
                .chancedOutput(ore, Iron, 1024, 8000, 500)
                .chancedOutput(ore, Copper, 1024, 8000, 500)
                .chancedOutput(ore, Gold, 1024, 6000, 500)
                .chancedOutput(ore, Magnetite, 1024, 9000, 500)
                .chancedOutput(ore, VanadiumMagnetite, 1024, 8000, 500)
                .chancedOutput(ore, Pyrite, 1024, 8000, 500)
                .chancedOutput(ore, Chalcopyrite, 1024, 9000, 500)
                .chancedOutput(ore, Sphalerite, 1024, 6000, 500)
                .chancedOutput(ore, Aluminium, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(11)
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(2000))
                .chancedOutput(ore, Iron, 1024, 8000, 500)
                .chancedOutput(ore, Copper, 1024, 8000, 500)
                .chancedOutput(ore, Gold, 1024, 6000, 500)
                .chancedOutput(ore, Magnetite, 1024, 9000, 500)
                .chancedOutput(ore, VanadiumMagnetite, 1024, 8000, 500)
                .chancedOutput(ore, Pyrite, 1024, 8000, 500)
                .chancedOutput(ore, Chalcopyrite, 1024, 9000, 500)
                .chancedOutput(ore, Sphalerite, 1024, 6000, 500)
                .chancedOutput(ore, Aluminium, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Nickel-Cobalt-Sulfur
        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(2)
                .fluidInputs(RocketFuel.getFluid(2000))
                .chancedOutput(ore, Nickel, 1024, 8000, 500)
                .chancedOutput(ore, Cobalt, 1024, 7000, 500)
                .chancedOutput(ore, Sulfur, 1024, 9000, 500)
                .chancedOutput(ore, Garnierite, 1024, 7000, 500)
                .chancedOutput(ore, Pentlandite, 1024, 6000, 500)
                .chancedOutput(ore, YellowLimonite, 1024, 9000, 500)
                .chancedOutput(ore, BrownLimonite, 1024, 9000, 500)
                .chancedOutput(ore, BandedIron, 1024, 8000, 500)
                .chancedOutput(ore, Cobaltite, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(2)
                .fluidInputs(RP1RocketFuel.getFluid(2000))
                .chancedOutput(ore, Nickel, 1024, 8000, 500)
                .chancedOutput(ore, Cobalt, 1024, 7000, 500)
                .chancedOutput(ore, Sulfur, 1024, 9000, 500)
                .chancedOutput(ore, Garnierite, 1024, 7000, 500)
                .chancedOutput(ore, Pentlandite, 1024, 6000, 500)
                .chancedOutput(ore, YellowLimonite, 1024, 9000, 500)
                .chancedOutput(ore, BrownLimonite, 1024, 9000, 500)
                .chancedOutput(ore, BandedIron, 1024, 8000, 500)
                .chancedOutput(ore, Cobaltite, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(12)
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(2000))
                .chancedOutput(ore, Nickel, 1024, 8000, 500)
                .chancedOutput(ore, Cobalt, 1024, 7000, 500)
                .chancedOutput(ore, Sulfur, 1024, 9000, 500)
                .chancedOutput(ore, Garnierite, 1024, 7000, 500)
                .chancedOutput(ore, Pentlandite, 1024, 6000, 500)
                .chancedOutput(ore, YellowLimonite, 1024, 9000, 500)
                .chancedOutput(ore, BrownLimonite, 1024, 9000, 500)
                .chancedOutput(ore, BandedIron, 1024, 8000, 500)
                .chancedOutput(ore, Cobaltite, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(12)
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(2000))
                .chancedOutput(ore, Nickel, 1024, 8000, 500)
                .chancedOutput(ore, Cobalt, 1024, 7000, 500)
                .chancedOutput(ore, Sulfur, 1024, 9000, 500)
                .chancedOutput(ore, Garnierite, 1024, 7000, 500)
                .chancedOutput(ore, Pentlandite, 1024, 6000, 500)
                .chancedOutput(ore, YellowLimonite, 1024, 9000, 500)
                .chancedOutput(ore, BrownLimonite, 1024, 9000, 500)
                .chancedOutput(ore, BandedIron, 1024, 8000, 500)
                .chancedOutput(ore, Cobaltite, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Salt-Rock Salt
        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(3)
                .fluidInputs(RocketFuel.getFluid(2000))
                .chancedOutput(ore, Salt, 1024, 9000, 500)
                .chancedOutput(ore, RockSalt, 1024, 9000, 500)
                .chancedOutput(ore, Realgar, 1024, 7000, 500)
                .chancedOutput(ore, Zeolite, 1024, 8000, 500)
                .chancedOutput(ore, Asbestos, 1024, 9000, 500)
                .chancedOutput(ore, Lepidolite, 1024, 7000, 500)
                .chancedOutput(ore, Spodumene, 1024, 7000, 500)
                .chancedOutput(ore, Grossular, 1024, 6000, 500)
                .chancedOutput(ore, Gypsum, 1024, 7000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(3)
                .fluidInputs(RP1RocketFuel.getFluid(2000))
                .chancedOutput(ore, Salt, 1024, 9000, 500)
                .chancedOutput(ore, RockSalt, 1024, 9000, 500)
                .chancedOutput(ore, Realgar, 1024, 7000, 500)
                .chancedOutput(ore, Zeolite, 1024, 8000, 500)
                .chancedOutput(ore, Asbestos, 1024, 9000, 500)
                .chancedOutput(ore, Lepidolite, 1024, 7000, 500)
                .chancedOutput(ore, Spodumene, 1024, 7000, 500)
                .chancedOutput(ore, Grossular, 1024, 6000, 500)
                .chancedOutput(ore, Gypsum, 1024, 7000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(13)
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(2000))
                .chancedOutput(ore, Salt, 1024, 9000, 500)
                .chancedOutput(ore, RockSalt, 1024, 9000, 500)
                .chancedOutput(ore, Realgar, 1024, 7000, 500)
                .chancedOutput(ore, Zeolite, 1024, 8000, 500)
                .chancedOutput(ore, Asbestos, 1024, 9000, 500)
                .chancedOutput(ore, Lepidolite, 1024, 7000, 500)
                .chancedOutput(ore, Spodumene, 1024, 7000, 500)
                .chancedOutput(ore, Grossular, 1024, 6000, 500)
                .chancedOutput(ore, Gypsum, 1024, 7000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(13)
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(100))
                .chancedOutput(ore, Salt, 1024, 9000, 2000)
                .chancedOutput(ore, RockSalt, 1024, 9000, 500)
                .chancedOutput(ore, Realgar, 1024, 7000, 500)
                .chancedOutput(ore, Zeolite, 1024, 8000, 500)
                .chancedOutput(ore, Asbestos, 1024, 9000, 500)
                .chancedOutput(ore, Lepidolite, 1024, 7000, 500)
                .chancedOutput(ore, Spodumene, 1024, 7000, 500)
                .chancedOutput(ore, Grossular, 1024, 6000, 500)
                .chancedOutput(ore, Gypsum, 1024, 7000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Quartzites
        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(4)
                .fluidInputs(RocketFuel.getFluid(2000))
                .chancedOutput(ore, Quartzite, 1024, 9000, 500)
                .chancedOutput(ore, NetherQuartz, 1024, 8000, 500)
                .chancedOutput(ore, CertusQuartz, 1024, 8000, 500)
                .chancedOutput(ore, Barite, 1024, 7000, 500)
                .chancedOutput(ore, BasalticMineralSand, 1024, 7000, 500)
                .chancedOutput(ore, GraniticMineralSand, 1024, 7000, 500)
                .chancedOutput(ore, FullersEarth, 1024, 8000, 500)
                .chancedOutput(ore, Topaz, 1024, 6000, 500)
                .chancedOutput(ore, BlueTopaz, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(4)
                .fluidInputs(RP1RocketFuel.getFluid(2000))
                .chancedOutput(ore, Quartzite, 1024, 9000, 500)
                .chancedOutput(ore, NetherQuartz, 1024, 8000, 500)
                .chancedOutput(ore, CertusQuartz, 1024, 8000, 500)
                .chancedOutput(ore, Barite, 1024, 7000, 500)
                .chancedOutput(ore, BasalticMineralSand, 1024, 7000, 500)
                .chancedOutput(ore, GraniticMineralSand, 1024, 7000, 500)
                .chancedOutput(ore, FullersEarth, 1024, 8000, 500)
                .chancedOutput(ore, Topaz, 1024, 6000, 500)
                .chancedOutput(ore, BlueTopaz, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(14)
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(2000))
                .chancedOutput(ore, Quartzite, 1024, 9000, 500)
                .chancedOutput(ore, NetherQuartz, 1024, 8000, 500)
                .chancedOutput(ore, CertusQuartz, 1024, 8000, 500)
                .chancedOutput(ore, Barite, 1024, 7000, 500)
                .chancedOutput(ore, BasalticMineralSand, 1024, 7000, 500)
                .chancedOutput(ore, GraniticMineralSand, 1024, 7000, 500)
                .chancedOutput(ore, FullersEarth, 1024, 8000, 500)
                .chancedOutput(ore, Topaz, 1024, 6000, 500)
                .chancedOutput(ore, BlueTopaz, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_LV.getStackForm(16))
                .circuitMeta(14)
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(2000))
                .chancedOutput(ore, Quartzite, 1024, 9000, 500)
                .chancedOutput(ore, NetherQuartz, 1024, 8000, 500)
                .chancedOutput(ore, CertusQuartz, 1024, 8000, 500)
                .chancedOutput(ore, Barite, 1024, 7000, 500)
                .chancedOutput(ore, BasalticMineralSand, 1024, 7000, 500)
                .chancedOutput(ore, GraniticMineralSand, 1024, 7000, 500)
                .chancedOutput(ore, FullersEarth, 1024, 8000, 500)
                .chancedOutput(ore, Topaz, 1024, 6000, 500)
                .chancedOutput(ore, BlueTopaz, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Lead-Silver-Copper
        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(5)
                .fluidInputs(RocketFuel.getFluid(2000))
                .chancedOutput(ore, Lead, 1024, 8000, 500)
                .chancedOutput(ore, Silver, 1024, 6000, 500)
                .chancedOutput(ore, Tin, 1024, 9000, 500)
                .chancedOutput(ore, Galena, 1024, 8000, 500)
                .chancedOutput(ore, Cassiterite, 1024, 7000, 500)
                .chancedOutput(ore, CassiteriteSand, 1024, 6000, 500)
                .chancedOutput(ore, Tetrahedrite, 1024, 8000, 500)
                .chancedOutput(ore, Stibnite, 1024, 6000, 500)
                .chancedOutput(ore, Bauxite, 1024, 7000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(5)
                .fluidInputs(RP1RocketFuel.getFluid(2000))
                .chancedOutput(ore, Lead, 1024, 8000, 500)
                .chancedOutput(ore, Silver, 1024, 6000, 500)
                .chancedOutput(ore, Tin, 1024, 9000, 500)
                .chancedOutput(ore, Galena, 1024, 8000, 500)
                .chancedOutput(ore, Cassiterite, 1024, 7000, 500)
                .chancedOutput(ore, CassiteriteSand, 1024, 6000, 500)
                .chancedOutput(ore, Tetrahedrite, 1024, 8000, 500)
                .chancedOutput(ore, Stibnite, 1024, 6000, 500)
                .chancedOutput(ore, Bauxite, 1024, 7000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(15)
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(2000))
                .chancedOutput(ore, Lead, 1024, 8000, 500)
                .chancedOutput(ore, Silver, 1024, 6000, 500)
                .chancedOutput(ore, Tin, 1024, 9000, 500)
                .chancedOutput(ore, Galena, 1024, 8000, 500)
                .chancedOutput(ore, Cassiterite, 1024, 7000, 500)
                .chancedOutput(ore, CassiteriteSand, 1024, 6000, 500)
                .chancedOutput(ore, Tetrahedrite, 1024, 8000, 500)
                .chancedOutput(ore, Stibnite, 1024, 6000, 500)
                .chancedOutput(ore, Bauxite, 1024, 7000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(15)
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(2000))
                .chancedOutput(ore, Lead, 1024, 8000, 500)
                .chancedOutput(ore, Silver, 1024, 6000, 500)
                .chancedOutput(ore, Tin, 1024, 9000, 500)
                .chancedOutput(ore, Galena, 1024, 8000, 500)
                .chancedOutput(ore, Cassiterite, 1024, 7000, 500)
                .chancedOutput(ore, CassiteriteSand, 1024, 6000, 500)
                .chancedOutput(ore, Tetrahedrite, 1024, 8000, 500)
                .chancedOutput(ore, Stibnite, 1024, 6000, 500)
                .chancedOutput(ore, Bauxite, 1024, 7000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Redstone-Diamond-Thorium
        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(6)
                .fluidInputs(RocketFuel.getFluid(2000))
                .chancedOutput(ore, Redstone, 1024, 8000, 500)
                .chancedOutput(ore, Diamond, 1024, 7000, 500)
                .chancedOutput(ore, Emerald, 1024, 6000, 500)
                .chancedOutput(ore, Ruby, 1024, 6000, 500)
                .chancedOutput(ore, Cinnabar, 1024, 7000, 500)
                .chancedOutput(ore, Coal, 1024, 9000, 500)
                .chancedOutput(ore, Graphite, 1024, 6000, 500)
                .chancedOutput(ore, Beryllium, 1024, 8000, 500)
                .chancedOutput(ore, Thorium, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(6)
                .fluidInputs(RP1RocketFuel.getFluid(2000))
                .chancedOutput(ore, Redstone, 1024, 8000, 500)
                .chancedOutput(ore, Diamond, 1024, 7000, 500)
                .chancedOutput(ore, Emerald, 1024, 6000, 500)
                .chancedOutput(ore, Ruby, 1024, 6000, 500)
                .chancedOutput(ore, Cinnabar, 1024, 7000, 500)
                .chancedOutput(ore, Coal, 1024, 9000, 500)
                .chancedOutput(ore, Graphite, 1024, 6000, 500)
                .chancedOutput(ore, Beryllium, 1024, 8000, 500)
                .chancedOutput(ore, Thorium, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(16)
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(2000))
                .chancedOutput(ore, Redstone, 1024, 8000, 500)
                .chancedOutput(ore, Diamond, 1024, 7000, 500)
                .chancedOutput(ore, Emerald, 1024, 6000, 500)
                .chancedOutput(ore, Ruby, 1024, 6000, 500)
                .chancedOutput(ore, Cinnabar, 1024, 7000, 500)
                .chancedOutput(ore, Coal, 1024, 9000, 500)
                .chancedOutput(ore, Graphite, 1024, 6000, 500)
                .chancedOutput(ore, Beryllium, 1024, 8000, 500)
                .chancedOutput(ore, Thorium, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(16)
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(2000))
                .chancedOutput(ore, Redstone, 1024, 8000, 500)
                .chancedOutput(ore, Diamond, 1024, 7000, 500)
                .chancedOutput(ore, Emerald, 1024, 6000, 500)
                .chancedOutput(ore, Ruby, 1024, 6000, 500)
                .chancedOutput(ore, Cinnabar, 1024, 7000, 500)
                .chancedOutput(ore, Coal, 1024, 9000, 500)
                .chancedOutput(ore, Graphite, 1024, 6000, 500)
                .chancedOutput(ore, Beryllium, 1024, 8000, 500)
                .chancedOutput(ore, Thorium, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Lapis-Electrotine
        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(7)
                .fluidInputs(RocketFuel.getFluid(2000))
                .chancedOutput(ore, Lapis, 1024, 8000, 500)
                .chancedOutput(ore, Lapis, 1024, 8000, 500)
                .chancedOutput(ore, Sodalite, 1024, 9000, 500)
                .chancedOutput(ore, Lazurite, 1024, 8000, 500)
                .chancedOutput(ore, Calcite, 1024, 9000, 500)
                .chancedOutput(ore, Electrotine, 1024, 7000, 500)
                .chancedOutput(ore, Saltpeter, 1024, 8000, 500)
                .chancedOutput(ore, Diatomite, 1024, 6000, 500)
                .chancedOutput(ore, Alunite, 1024, 7000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(7)
                .fluidInputs(RP1RocketFuel.getFluid(2000))
                .chancedOutput(ore, Lapis, 1024, 8000, 500)
                .chancedOutput(ore, Lapis, 1024, 8000, 500)
                .chancedOutput(ore, Sodalite, 1024, 9000, 500)
                .chancedOutput(ore, Lazurite, 1024, 8000, 500)
                .chancedOutput(ore, Calcite, 1024, 9000, 500)
                .chancedOutput(ore, Electrotine, 1024, 7000, 500)
                .chancedOutput(ore, Saltpeter, 1024, 8000, 500)
                .chancedOutput(ore, Diatomite, 1024, 6000, 500)
                .chancedOutput(ore, Alunite, 1024, 7000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(17)
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(2000))
                .chancedOutput(ore, Lapis, 1024, 8000, 500)
                .chancedOutput(ore, Lapis, 1024, 8000, 500)
                .chancedOutput(ore, Sodalite, 1024, 9000, 500)
                .chancedOutput(ore, Lazurite, 1024, 8000, 500)
                .chancedOutput(ore, Calcite, 1024, 9000, 500)
                .chancedOutput(ore, Electrotine, 1024, 7000, 500)
                .chancedOutput(ore, Saltpeter, 1024, 8000, 500)
                .chancedOutput(ore, Diatomite, 1024, 6000, 500)
                .chancedOutput(ore, Alunite, 1024, 7000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(17)
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(2000))
                .chancedOutput(ore, Lapis, 1024, 8000, 500)
                .chancedOutput(ore, Lapis, 1024, 8000, 500)
                .chancedOutput(ore, Sodalite, 1024, 9000, 500)
                .chancedOutput(ore, Lazurite, 1024, 8000, 500)
                .chancedOutput(ore, Calcite, 1024, 9000, 500)
                .chancedOutput(ore, Electrotine, 1024, 7000, 500)
                .chancedOutput(ore, Saltpeter, 1024, 8000, 500)
                .chancedOutput(ore, Diatomite, 1024, 6000, 500)
                .chancedOutput(ore, Alunite, 1024, 7000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Oilsand-Magnesite
        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(8)
                .fluidInputs(RocketFuel.getFluid(2000))
                .chancedOutput(ore, Oilsands, 1024, 9000, 500)
                .chancedOutput(ore, Soapstone, 1024, 8000, 500)
                .chancedOutput(ore, Talc, 1024, 8000, 500)
                .chancedOutput(ore, GlauconiteSand, 1024, 7000, 500)
                .chancedOutput(ore, Trona, 1024, 6000, 500)
                .chancedOutput(ore, Magnesite, 1024, 7000, 500)
                .chancedOutput(ore, Olivine, 1024, 7000, 500)
                .chancedOutput(ore, Bentonite, 1024, 7000, 500)
                .chancedOutput(ore, Pollucite, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(8)
                .fluidInputs(RP1RocketFuel.getFluid(2000))
                .chancedOutput(ore, Oilsands, 1024, 9000, 500)
                .chancedOutput(ore, Soapstone, 1024, 8000, 500)
                .chancedOutput(ore, Talc, 1024, 8000, 500)
                .chancedOutput(ore, GlauconiteSand, 1024, 7000, 500)
                .chancedOutput(ore, Trona, 1024, 6000, 500)
                .chancedOutput(ore, Magnesite, 1024, 7000, 500)
                .chancedOutput(ore, Olivine, 1024, 7000, 500)
                .chancedOutput(ore, Bentonite, 1024, 7000, 500)
                .chancedOutput(ore, Pollucite, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(18)
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(2000))
                .chancedOutput(ore, Oilsands, 1024, 9000, 500)
                .chancedOutput(ore, Soapstone, 1024, 8000, 500)
                .chancedOutput(ore, Talc, 1024, 8000, 500)
                .chancedOutput(ore, GlauconiteSand, 1024, 7000, 500)
                .chancedOutput(ore, Trona, 1024, 6000, 500)
                .chancedOutput(ore, Magnesite, 1024, 7000, 500)
                .chancedOutput(ore, Olivine, 1024, 7000, 500)
                .chancedOutput(ore, Bentonite, 1024, 7000, 500)
                .chancedOutput(ore, Pollucite, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_MV.getStackForm(16))
                .circuitMeta(18)
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(2000))
                .chancedOutput(ore, Oilsands, 1024, 9000, 500)
                .chancedOutput(ore, Soapstone, 1024, 8000, 500)
                .chancedOutput(ore, Talc, 1024, 8000, 500)
                .chancedOutput(ore, GlauconiteSand, 1024, 7000, 500)
                .chancedOutput(ore, Trona, 1024, 6000, 500)
                .chancedOutput(ore, Magnesite, 1024, 7000, 500)
                .chancedOutput(ore, Olivine, 1024, 7000, 500)
                .chancedOutput(ore, Bentonite, 1024, 7000, 500)
                .chancedOutput(ore, Pollucite, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Lithium-Tungsten-Molybdenum
        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(9)
                .fluidInputs(RocketFuel.getFluid(2000))
                .chancedOutput(ore, Lithium, 1024, 9000, 500)
                .chancedOutput(ore, Molybdenum, 1024, 7000, 500)
                .chancedOutput(ore, Scheelite, 1024, 6000, 500)
                .chancedOutput(ore, Tungstate, 1024, 6000, 500)
                .chancedOutput(ore, Wulfenite, 1024, 8000, 500)
                .chancedOutput(ore, Molybdenite, 1024, 8000, 500)
                .chancedOutput(ore, Powellite, 1024, 7000, 500)
                .chancedOutput(ore, Chromite, 1024, 7000, 500)
                .chancedOutput(ore, Ilmenite, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(9)
                .fluidInputs(RP1RocketFuel.getFluid(2000))
                .chancedOutput(ore, Lithium, 1024, 9000, 500)
                .chancedOutput(ore, Molybdenum, 1024, 7000, 500)
                .chancedOutput(ore, Scheelite, 1024, 6000, 500)
                .chancedOutput(ore, Tungstate, 1024, 6000, 500)
                .chancedOutput(ore, Wulfenite, 1024, 8000, 500)
                .chancedOutput(ore, Molybdenite, 1024, 8000, 500)
                .chancedOutput(ore, Powellite, 1024, 7000, 500)
                .chancedOutput(ore, Chromite, 1024, 7000, 500)
                .chancedOutput(ore, Ilmenite, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(19)
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(2000))
                .chancedOutput(ore, Lithium, 1024, 9000, 500)
                .chancedOutput(ore, Molybdenum, 1024, 7000, 500)
                .chancedOutput(ore, Scheelite, 1024, 6000, 500)
                .chancedOutput(ore, Tungstate, 1024, 6000, 500)
                .chancedOutput(ore, Wulfenite, 1024, 8000, 500)
                .chancedOutput(ore, Molybdenite, 1024, 8000, 500)
                .chancedOutput(ore, Powellite, 1024, 7000, 500)
                .chancedOutput(ore, Chromite, 1024, 7000, 500)
                .chancedOutput(ore, Ilmenite, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(19)
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(2000))
                .chancedOutput(ore, Lithium, 1024, 9000, 500)
                .chancedOutput(ore, Molybdenum, 1024, 7000, 500)
                .chancedOutput(ore, Scheelite, 1024, 6000, 500)
                .chancedOutput(ore, Tungstate, 1024, 6000, 500)
                .chancedOutput(ore, Wulfenite, 1024, 8000, 500)
                .chancedOutput(ore, Molybdenite, 1024, 8000, 500)
                .chancedOutput(ore, Powellite, 1024, 7000, 500)
                .chancedOutput(ore, Chromite, 1024, 7000, 500)
                .chancedOutput(ore, Ilmenite, 1024, 6000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Neodymium-Platinum-Palladium
        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(10)
                .fluidInputs(RocketFuel.getFluid(2000))
                .chancedOutput(ore, Neodymium, 1024, 6000, 500)
                .chancedOutput(ore, Platinum, 1024, 7000, 500)
                .chancedOutput(ore, Palladium, 1024, 7000, 500)
                .chancedOutput(ore, Bastnasite, 1024, 8000, 500)
                .chancedOutput(ore, Monazite, 1024, 7000, 500)
                .chancedOutput(ore, Cooperite, 1024, 8000, 500)
                .chancedOutput(ore, Bornite, 1024, 9000, 500)
                .chancedOutput(ore, Tantalite, 1024, 8000, 500)
                .chancedOutput(ore, Pyrolusite, 1024, 8000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(10)
                .fluidInputs(RP1RocketFuel.getFluid(2000))
                .chancedOutput(ore, Neodymium, 1024, 6000, 500)
                .chancedOutput(ore, Platinum, 1024, 7000, 500)
                .chancedOutput(ore, Palladium, 1024, 7000, 500)
                .chancedOutput(ore, Bastnasite, 1024, 8000, 500)
                .chancedOutput(ore, Monazite, 1024, 7000, 500)
                .chancedOutput(ore, Cooperite, 1024, 8000, 500)
                .chancedOutput(ore, Bornite, 1024, 9000, 500)
                .chancedOutput(ore, Tantalite, 1024, 8000, 500)
                .chancedOutput(ore, Pyrolusite, 1024, 8000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(20)
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(2000))
                .chancedOutput(ore, Neodymium, 1024, 6000, 500)
                .chancedOutput(ore, Platinum, 1024, 7000, 500)
                .chancedOutput(ore, Palladium, 1024, 7000, 500)
                .chancedOutput(ore, Bastnasite, 1024, 8000, 500)
                .chancedOutput(ore, Monazite, 1024, 7000, 500)
                .chancedOutput(ore, Cooperite, 1024, 8000, 500)
                .chancedOutput(ore, Bornite, 1024, 9000, 500)
                .chancedOutput(ore, Tantalite, 1024, 8000, 500)
                .chancedOutput(ore, Pyrolusite, 1024, 8000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(20)
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(2000))
                .chancedOutput(ore, Neodymium, 1024, 6000, 500)
                .chancedOutput(ore, Platinum, 1024, 7000, 500)
                .chancedOutput(ore, Palladium, 1024, 7000, 500)
                .chancedOutput(ore, Bastnasite, 1024, 8000, 500)
                .chancedOutput(ore, Monazite, 1024, 7000, 500)
                .chancedOutput(ore, Cooperite, 1024, 8000, 500)
                .chancedOutput(ore, Bornite, 1024, 9000, 500)
                .chancedOutput(ore, Tantalite, 1024, 8000, 500)
                .chancedOutput(ore, Pyrolusite, 1024, 8000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Sapphire-Amethyst
        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(11)
                .fluidInputs(RocketFuel.getFluid(2000))
                .chancedOutput(ore, Sapphire, 1024, 7000, 500)
                .chancedOutput(ore, Almandine, 1024, 7000, 500)
                .chancedOutput(ore, Pyrope, 1024, 8000, 500)
                .chancedOutput(ore, GreenSapphire, 1024, 8000, 500)
                .chancedOutput(ore, Amethyst, 1024, 9000, 500)
                .chancedOutput(ore, GarnetRed, 1024, 8000, 500)
                .chancedOutput(ore, GarnetYellow, 1024, 8000, 500)
                .chancedOutput(ore, GarnetSand, 1024, 8000, 500)
                .chancedOutput(ore, Opal, 1024, 8000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(11)
                .fluidInputs(RP1RocketFuel.getFluid(2000))
                .chancedOutput(ore, Sapphire, 1024, 7000, 500)
                .chancedOutput(ore, Almandine, 1024, 7000, 500)
                .chancedOutput(ore, Pyrope, 1024, 8000, 500)
                .chancedOutput(ore, GreenSapphire, 1024, 8000, 500)
                .chancedOutput(ore, Amethyst, 1024, 9000, 500)
                .chancedOutput(ore, GarnetRed, 1024, 8000, 500)
                .chancedOutput(ore, GarnetYellow, 1024, 8000, 500)
                .chancedOutput(ore, GarnetSand, 1024, 8000, 500)
                .chancedOutput(ore, Opal, 1024, 8000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(21)
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(2000))
                .chancedOutput(ore, Sapphire, 1024, 7000, 500)
                .chancedOutput(ore, Almandine, 1024, 7000, 500)
                .chancedOutput(ore, Pyrope, 1024, 8000, 500)
                .chancedOutput(ore, GreenSapphire, 1024, 8000, 500)
                .chancedOutput(ore, Amethyst, 1024, 9000, 500)
                .chancedOutput(ore, GarnetRed, 1024, 8000, 500)
                .chancedOutput(ore, GarnetYellow, 1024, 8000, 500)
                .chancedOutput(ore, GarnetSand, 1024, 8000, 500)
                .chancedOutput(ore, Opal, 1024, 8000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(21)
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(2000))
                .chancedOutput(ore, Sapphire, 1024, 7000, 500)
                .chancedOutput(ore, Almandine, 1024, 7000, 500)
                .chancedOutput(ore, Pyrope, 1024, 8000, 500)
                .chancedOutput(ore, GreenSapphire, 1024, 8000, 500)
                .chancedOutput(ore, Amethyst, 1024, 9000, 500)
                .chancedOutput(ore, GarnetRed, 1024, 8000, 500)
                .chancedOutput(ore, GarnetYellow, 1024, 8000, 500)
                .chancedOutput(ore, GarnetSand, 1024, 8000, 500)
                .chancedOutput(ore, Opal, 1024, 8000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Copper-Tantalum
        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(12)
                .fluidInputs(RocketFuel.getFluid(2000))
                .chancedOutput(ore, Malachite, 1024, 9000, 500)
                .chancedOutput(ore, Apatite, 1024, 8000, 500)
                .chancedOutput(ore, TricalciumPhosphate, 1024, 8000, 500)
                .chancedOutput(ore, Realgar, 1024, 9000, 500)
                .chancedOutput(ore, Grossular, 1024, 8000, 500)
                .chancedOutput(ore, Pyrolusite, 1024, 7000, 500)
                .chancedOutput(ore, Spessartine, 1024, 7000, 500)
                .chancedOutput(ore, Tantalite, 1024, 6000, 500)
                .chancedOutput(ore, Pyrochlore, 1024, 8000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(12)
                .fluidInputs(RP1RocketFuel.getFluid(2000))
                .chancedOutput(ore, Malachite, 1024, 9000, 500)
                .chancedOutput(ore, Apatite, 1024, 8000, 500)
                .chancedOutput(ore, TricalciumPhosphate, 1024, 8000, 500)
                .chancedOutput(ore, Realgar, 1024, 9000, 500)
                .chancedOutput(ore, Grossular, 1024, 8000, 500)
                .chancedOutput(ore, Pyrolusite, 1024, 7000, 500)
                .chancedOutput(ore, Spessartine, 1024, 7000, 500)
                .chancedOutput(ore, Tantalite, 1024, 6000, 500)
                .chancedOutput(ore, Pyrochlore, 1024, 8000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(22)
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(2000))
                .chancedOutput(ore, Malachite, 1024, 9000, 500)
                .chancedOutput(ore, Apatite, 1024, 8000, 500)
                .chancedOutput(ore, TricalciumPhosphate, 1024, 8000, 500)
                .chancedOutput(ore, Realgar, 1024, 9000, 500)
                .chancedOutput(ore, Grossular, 1024, 8000, 500)
                .chancedOutput(ore, Pyrolusite, 1024, 7000, 500)
                .chancedOutput(ore, Spessartine, 1024, 7000, 500)
                .chancedOutput(ore, Tantalite, 1024, 6000, 500)
                .chancedOutput(ore, Pyrochlore, 1024, 8000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_HV.getStackForm(16))
                .circuitMeta(22)
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(2000))
                .chancedOutput(ore, Malachite, 1024, 9000, 500)
                .chancedOutput(ore, Apatite, 1024, 8000, 500)
                .chancedOutput(ore, TricalciumPhosphate, 1024, 8000, 500)
                .chancedOutput(ore, Realgar, 1024, 9000, 500)
                .chancedOutput(ore, Grossular, 1024, 8000, 500)
                .chancedOutput(ore, Pyrolusite, 1024, 7000, 500)
                .chancedOutput(ore, Spessartine, 1024, 7000, 500)
                .chancedOutput(ore, Tantalite, 1024, 6000, 500)
                .chancedOutput(ore, Pyrochlore, 1024, 8000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Naquadah-Plutonium-Uranium
        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_EV.getStackForm(16))
                .circuitMeta(13)
                .fluidInputs(RocketFuel.getFluid(2000))
                .chancedOutput(ore, Naquadah, 1024, 6000, 500)
                .chancedOutput(ore, Naquadah, 1024, 6000, 500)
                .chancedOutput(ore, Naquadah, 1024, 6000, 500)
                .chancedOutput(ore, Plutonium239, 1024, 7000, 500)
                .chancedOutput(ore, Uraninite, 1024, 8000, 500)
                .chancedOutput(ore, Uraninite, 1024, 8000, 500)
                .chancedOutput(ore, Pitchblende, 1024, 8000, 500)
                .chancedOutput(ore, Pitchblende, 1024, 8000, 500)
                .chancedOutput(ore, Pyrochlore,  1024, 9000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_EV.getStackForm(16))
                .circuitMeta(13)
                .fluidInputs(RP1RocketFuel.getFluid(2000))
                .chancedOutput(ore, Naquadah, 1024, 6000, 500)
                .chancedOutput(ore, Naquadah, 1024, 6000, 500)
                .chancedOutput(ore, Naquadah, 1024, 6000, 500)
                .chancedOutput(ore, Plutonium239, 1024, 7000, 500)
                .chancedOutput(ore, Uraninite, 1024, 8000, 500)
                .chancedOutput(ore, Uraninite, 1024, 8000, 500)
                .chancedOutput(ore, Pitchblende, 1024, 8000, 500)
                .chancedOutput(ore, Pitchblende, 1024, 8000, 500)
                .chancedOutput(ore, Pyrochlore,  1024, 9000, 500)
                .EUt(VA[UV])
                .duration(400)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_EV.getStackForm(16))
                .circuitMeta(23)
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(2000))
                .chancedOutput(ore, Naquadah, 1024, 6000, 500)
                .chancedOutput(ore, Naquadah, 1024, 6000, 500)
                .chancedOutput(ore, Naquadah, 1024, 6000, 500)
                .chancedOutput(ore, Plutonium239, 1024, 7000, 500)
                .chancedOutput(ore, Uraninite, 1024, 8000, 500)
                .chancedOutput(ore, Uraninite, 1024, 8000, 500)
                .chancedOutput(ore, Pitchblende, 1024, 8000, 500)
                .chancedOutput(ore, Pitchblende, 1024, 8000, 500)
                .chancedOutput(ore, Pyrochlore,  1024, 9000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                .notConsumable(MINING_DRONE_EV.getStackForm(16))
                .circuitMeta(23)
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(2000))
                .chancedOutput(ore, Naquadah, 1024, 6000, 500)
                .chancedOutput(ore, Naquadah, 1024, 6000, 500)
                .chancedOutput(ore, Naquadah, 1024, 6000, 500)
                .chancedOutput(ore, Plutonium239, 1024, 7000, 500)
                .chancedOutput(ore, Uraninite, 1024, 8000, 500)
                .chancedOutput(ore, Uraninite, 1024, 8000, 500)
                .chancedOutput(ore, Pitchblende, 1024, 8000, 500)
                .chancedOutput(ore, Pitchblende, 1024, 8000, 500)
                .chancedOutput(ore, Pyrochlore,  1024, 9000, 500)
                .EUt(VA[UV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();
    }

    private static void AssemblingModule() {

        //  Engraved Crystal Chip
        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(plate, Emerald)
                .fluidInputs(SolderingAlloy.getFluid(16))
                .fluidInputs(Biomass.getFluid(16))
                .output(ENGRAVED_CRYSTAL_CHIP, 4)
                .EUt(900)
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(plate, Olivine)
                .fluidInputs(SolderingAlloy.getFluid(16))
                .fluidInputs(Biomass.getFluid(16))
                .output(ENGRAVED_CRYSTAL_CHIP, 4)
                .EUt(900)
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Crystal SoC
        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(plate, Europium)
                .input(CRYSTAL_INTERFACE_CHIP, 2)
                .input(wireFine, Titanium, 4)
                .output(CRYSTAL_SOC_SOCKET, 4)
                .EUt(VA[LuV])
                .duration(20)
                .CasingTier(1)
                .buildAndRegister();

        //  Wetware CPU
        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(plate, KaptonE)
                .input(STEM_CELLS, 4)
                .input(pipeTinyFluid, Polybenzimidazole, 4)
                .input(plate, Cupronickel, 4)
                .input(foil, PolyvinylChloride, 4)
                .input(bolt, HSSG, 4)
                .fluidInputs(SterileGrowthMedium.getFluid(16))
                .output(NEURO_PROCESSOR, 4)
                .EUt(100000)
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();
    }
}
