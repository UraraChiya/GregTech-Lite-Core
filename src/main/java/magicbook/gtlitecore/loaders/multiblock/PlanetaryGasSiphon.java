package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.material.Material;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.PLANETARY_GAS_SIPHON_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class PlanetaryGasSiphon {

    public static void init() {
        int[] Energy = { VHA[LV], VHA[MV], VHA[HV], VHA[EV], VHA[IV], VHA[LuV], VHA[ZPM] };
        MetaItem<?>.MetaValueItem[] Drone = { MINING_DRONE_LV, MINING_DRONE_MV, MINING_DRONE_HV, MINING_DRONE_EV, MINING_DRONE_IV,
                MINING_DRONE_LuV, MINING_DRONE_ZPM };
        Material[] Pipe = { Steel, Aluminium, StainlessSteel, Titanium, TungstenSteel, NiobiumTitanium, Iridium };
        Material[] Drill = { Steel, Aluminium, StainlessSteel, Titanium, TungstenSteel, HSSE, NaquadahAlloy };

        //  LV Mining Drone
        createPlanetaryGasSiphonRecipe(1, Drone[0], Pipe[0], Drill[0], Nitrogen,        30000, Energy[0]);
        createPlanetaryGasSiphonRecipe(2, Drone[0], Pipe[0], Drill[0], Oxygen,          8000,  Energy[0]);
        createPlanetaryGasSiphonRecipe(3, Drone[0], Pipe[0], Drill[0], CarbonMonoxide,  12000, Energy[0]);
        createPlanetaryGasSiphonRecipe(4, Drone[0], Pipe[0], Drill[0], NitrogenDioxide, 10000, Energy[0]);

        //  MV Mining Drone
        createPlanetaryGasSiphonRecipe(1, Drone[1], Pipe[1], Drill[1], Hydrogen,            30000, Energy[1]);
        createPlanetaryGasSiphonRecipe(2, Drone[1], Pipe[1], Drill[1], Helium,              4000,  Energy[1]);
        createPlanetaryGasSiphonRecipe(3, Drone[1], Pipe[1], Drill[1], SulfurDioxide,       10000, Energy[1]);
        createPlanetaryGasSiphonRecipe(4, Drone[1], Pipe[1], Drill[1], DinitrogenTetroxide, 8000,  Energy[1]);

        //  HV Mining Drone
        createPlanetaryGasSiphonRecipe(1, Drone[2], Pipe[2], Drill[2], Helium3,        30000, Energy[2]);
        createPlanetaryGasSiphonRecipe(2, Drone[2], Pipe[2], Drill[2], CarbonDioxide,  10000, Energy[2]);
        createPlanetaryGasSiphonRecipe(3, Drone[2], Pipe[2], Drill[2], Neon,           4000,  Energy[2]);
        createPlanetaryGasSiphonRecipe(4, Drone[2], Pipe[2], Drill[2], SulfurTrioxide, 8000,  Energy[2]);

        //  EV Mining Drone
        createPlanetaryGasSiphonLiquidRecipe(1, Drone[3], Pipe[3], Drill[3], Oxygen,     8000,  Energy[3]);
        createPlanetaryGasSiphonRecipe(      2, Drone[3], Pipe[3], Drill[3], Argon,      4000,  Energy[3]);
        createPlanetaryGasSiphonRecipe(      3, Drone[3], Pipe[3], Drill[3], Methane,    10000, Energy[3]);
        createPlanetaryGasSiphonRecipe(      4, Drone[3], Pipe[3], Drill[3], NaturalGas, 12000, Energy[3]);

        //  IV Mining Drone
        createPlanetaryGasSiphonLiquidRecipe(1, Drone[4], Pipe[4], Drill[4], Helium,  8000,  Energy[4]);
        createPlanetaryGasSiphonRecipe(      2, Drone[4], Pipe[4], Drill[4], Ammonia, 12000, Energy[4]);
        createPlanetaryGasSiphonRecipe(      3, Drone[4], Pipe[4], Drill[4], CoalGas, 30000, Energy[4]);
        createPlanetaryGasSiphonRecipe(      4, Drone[4], Pipe[4], Drill[4], Krypton, 4000,  Energy[4]);

        //  LuV Mining Drone
        createPlanetaryGasSiphonRecipe(1, Drone[5], Pipe[5], Drill[5], HydrogenSulfide, 30000, Energy[5]);
        createPlanetaryGasSiphonRecipe(2, Drone[5], Pipe[5], Drill[5], Deuterium,       12000, Energy[5]);
        createPlanetaryGasSiphonRecipe(3, Drone[5], Pipe[5], Drill[5], Xenon,           4000,  Energy[5]);
        createPlanetaryGasSiphonRecipe(4, Drone[5], Pipe[5], Drill[5], Chlorine,        10000, Energy[5]);

        //  ZPM Mining Drone
        createPlanetaryGasSiphonRecipe(1, Drone[6], Pipe[6], Drill[6], Tritium,    10000, Energy[6]);
        createPlanetaryGasSiphonRecipe(2, Drone[6], Pipe[6], Drill[6], Radon,      4000,  Energy[6]);
        createPlanetaryGasSiphonRecipe(3, Drone[6], Pipe[6], Drill[6], HeliumNeon, 8000,  Energy[6]);
        createPlanetaryGasSiphonRecipe(4, Drone[6], Pipe[6], Drill[6], Fluorine,   12000, Energy[6]);
    }

    private static void createPlanetaryGasSiphonRecipe(int circuitMeta,
                                                       MetaItem<?>.MetaValueItem drone,
                                                       Material pipeFluid,
                                                       Material drillHead,
                                                       Material fluidOutput,
                                                       int amount,
                                                       int voltage) {

        //  x1
        for (FluidStack stack : new FluidStack[] {
                RocketFuel.getFluid(4000),
                RP1RocketFuel.getFluid(4000),
                DenseHydrazineMixtureFuel.getFluid(2000),
                MethylhydrazineNitrateRocketFuel.getFluid(2000)
        }) {
            PLANETARY_GAS_SIPHON_RECIPES.recipeBuilder()
                    .circuitMeta(circuitMeta)
                    .notConsumable(drone.getStackForm(4))
                    .input(pipeNormalFluid, pipeFluid, 4)
                    .input(toolHeadDrill, drillHead, 2)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(fluidOutput.getFluid(amount))
                    .EUt(voltage)
                    .duration(20)
                    .buildAndRegister();
        }

        //  x2
        for (FluidStack stack : new FluidStack[] {
                RocketFuel.getFluid(8000),
                RP1RocketFuel.getFluid(8000),
                DenseHydrazineMixtureFuel.getFluid(4000),
                MethylhydrazineNitrateRocketFuel.getFluid(4000)
        }) {
            PLANETARY_GAS_SIPHON_RECIPES.recipeBuilder()
                    .circuitMeta(circuitMeta + 5)
                    .notConsumable(drone.getStackForm(16))
                    .input(pipeNormalFluid, pipeFluid, 8)
                    .input(toolHeadDrill, drillHead, 4)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(fluidOutput.getFluid(amount * 2))
                    .EUt(voltage)
                    .duration(20)
                    .buildAndRegister();
        }

        //  x4
        for (FluidStack stack : new FluidStack[] {
                RocketFuel.getFluid(16000),
                RP1RocketFuel.getFluid(16000),
                DenseHydrazineMixtureFuel.getFluid(8000),
                MethylhydrazineNitrateRocketFuel.getFluid(8000)
        }) {
            PLANETARY_GAS_SIPHON_RECIPES.recipeBuilder()
                    .circuitMeta(circuitMeta + 10)
                    .notConsumable(drone.getStackForm(64))
                    .input(pipeNormalFluid, pipeFluid, 16)
                    .input(toolHeadDrill, drillHead, 8)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(fluidOutput.getFluid(amount * 4))
                    .EUt(voltage)
                    .duration(20)
                    .buildAndRegister();
        }
    }

    private static void createPlanetaryGasSiphonLiquidRecipe(int circuitMeta,
                                                             MetaItem<?>.MetaValueItem drone,
                                                             Material pipeFluid,
                                                             Material drillHead,
                                                             Material fluidOutput,
                                                             int amount,
                                                             int voltage) {
        //  x1
        for (FluidStack stack : new FluidStack[] {
                RocketFuel.getFluid(4000),
                RP1RocketFuel.getFluid(4000),
                DenseHydrazineMixtureFuel.getFluid(2000),
                MethylhydrazineNitrateRocketFuel.getFluid(2000)
        }) {
            PLANETARY_GAS_SIPHON_RECIPES.recipeBuilder()
                    .circuitMeta(circuitMeta)
                    .notConsumable(drone.getStackForm(4))
                    .input(pipeNormalFluid, pipeFluid, 4)
                    .input(toolHeadDrill, drillHead, 2)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(fluidOutput.getFluid(FluidStorageKeys.LIQUID, amount))
                    .EUt(voltage)
                    .duration(20)
                    .buildAndRegister();
        }

        //  x2
        for (FluidStack stack : new FluidStack[] {
                RocketFuel.getFluid(8000),
                RP1RocketFuel.getFluid(8000),
                DenseHydrazineMixtureFuel.getFluid(4000),
                MethylhydrazineNitrateRocketFuel.getFluid(4000)
        }) {
            PLANETARY_GAS_SIPHON_RECIPES.recipeBuilder()
                    .circuitMeta(circuitMeta + 5)
                    .notConsumable(drone.getStackForm(16))
                    .input(pipeNormalFluid, pipeFluid, 8)
                    .input(toolHeadDrill, drillHead, 4)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(fluidOutput.getFluid(FluidStorageKeys.LIQUID, amount * 2))
                    .EUt(voltage)
                    .duration(20)
                    .buildAndRegister();
        }

        //  x4
        for (FluidStack stack : new FluidStack[] {
                RocketFuel.getFluid(16000),
                RP1RocketFuel.getFluid(16000),
                DenseHydrazineMixtureFuel.getFluid(8000),
                MethylhydrazineNitrateRocketFuel.getFluid(8000)
        }) {
            PLANETARY_GAS_SIPHON_RECIPES.recipeBuilder()
                    .circuitMeta(circuitMeta + 10)
                    .notConsumable(drone.getStackForm(64))
                    .input(pipeNormalFluid, pipeFluid, 16)
                    .input(toolHeadDrill, drillHead, 8)
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(fluidOutput.getFluid(FluidStorageKeys.LIQUID, amount * 4))
                    .EUt(voltage)
                    .duration(20)
                    .buildAndRegister();
        }
    }

}
