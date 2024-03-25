package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.SupercriticalSteam;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.SuperheatedSteam;

public class HeatExchanger {

    public static void init() {
        BasicHeatExchange();
        //  TODO SolarPanelTowerHeatExchange();
        Fuels();
    }

    private static void BasicHeatExchange() {
        //  Lava
        HEAT_EXCHANGE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(5))
                .fluidInputs(Lava.getFluid(1))
                .fluidOutputs(Steam.getFluid(160 * 5))
                .fluidOutputs(SuperheatedSteam.getFluid(80 * 5))
                .fluidOutputs(SupercriticalSteam.getFluid(1))
                .maxRate(1600)
                .flowRate(500)
                .duration(20)
                .buildAndRegister();

        Mark1Fusion();
        Mark2Fusion();
        Mark3Fusion();
    }

    private static void Mark1Fusion() {
        //  Helium Plasma
        HEAT_EXCHANGE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(5))
                .fluidInputs(Helium.getPlasma(1))
                .fluidOutputs(SuperheatedSteam.getFluid(160 * 5))
                .fluidOutputs(SupercriticalSteam.getFluid(80 * 5))
                .fluidOutputs(Helium.getFluid(1))
                .maxRate(1600)
                .flowRate(500)
                .duration(20)
                .buildAndRegister();
    }

    private static void Mark2Fusion() {
        //  Nitrogen Plasma
        HEAT_EXCHANGE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(5))
                .fluidInputs(Nitrogen.getPlasma(1))
                .fluidOutputs(SuperheatedSteam.getFluid(320 * 5))
                .fluidOutputs(SupercriticalSteam.getFluid(160 * 5))
                .fluidOutputs(Nitrogen.getFluid(1))
                .maxRate(3200)
                .flowRate(500)
                .duration(20)
                .buildAndRegister();

        //  Oxygen Plasma
        HEAT_EXCHANGE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(5))
                .fluidInputs(Oxygen.getPlasma(1))
                .fluidOutputs(SuperheatedSteam.getFluid(320 * 5))
                .fluidOutputs(SupercriticalSteam.getFluid(160 * 5))
                .fluidOutputs(Oxygen.getFluid(1))
                .maxRate(3200)
                .flowRate(500)
                .duration(20)
                .buildAndRegister();

        //  Argon Plasma
        HEAT_EXCHANGE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(5))
                .fluidInputs(Argon.getPlasma(1))
                .fluidOutputs(SuperheatedSteam.getFluid(320 * 5))
                .fluidOutputs(SupercriticalSteam.getFluid(160 * 5))
                .fluidOutputs(Argon.getFluid(1))
                .maxRate(3200)
                .flowRate(500)
                .duration(20)
                .buildAndRegister();

        //  Iron Plasma
        HEAT_EXCHANGE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(5))
                .fluidInputs(Iron.getPlasma(1))
                .fluidOutputs(SuperheatedSteam.getFluid(320 * 5))
                .fluidOutputs(SupercriticalSteam.getFluid(160 * 5))
                .fluidOutputs(Iron.getFluid(1))
                .maxRate(3200)
                .flowRate(500)
                .duration(20)
                .buildAndRegister();

        //  Tin Plasma
        HEAT_EXCHANGE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(5))
                .fluidInputs(Tin.getPlasma(1))
                .fluidOutputs(SuperheatedSteam.getFluid(320 * 5))
                .fluidOutputs(SupercriticalSteam.getFluid(160 * 5))
                .fluidOutputs(Tin.getFluid(1))
                .maxRate(3200)
                .flowRate(500)
                .duration(20)
                .buildAndRegister();
    }

    private static void Mark3Fusion() {
        //  Nickel Plasma
        HEAT_EXCHANGE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(5))
                .fluidInputs(Nickel.getPlasma(1))
                .fluidOutputs(SuperheatedSteam.getFluid(640 * 5))
                .fluidOutputs(SupercriticalSteam.getFluid(320 * 5))
                .fluidOutputs(Nickel.getFluid(1))
                .maxRate(6400)
                .flowRate(500)
                .duration(20)
                .buildAndRegister();

        //  Americium Plasma
        HEAT_EXCHANGE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(5))
                .fluidInputs(Americium.getPlasma(1))
                .fluidOutputs(SuperheatedSteam.getFluid(640 * 5))
                .fluidOutputs(SupercriticalSteam.getFluid(320 * 5))
                .fluidOutputs(Americium.getFluid(1))
                .maxRate(6400)
                .flowRate(500)
                .duration(20)
                .buildAndRegister();
    }

    private static void Fuels() {
        //  Superheated Steam
        HIGH_PRESSURE_STEAM_TURBINE_RECIPES.recipeBuilder()
                .fluidInputs(SuperheatedSteam.getFluid(320))
                .fluidOutputs(DistilledWater.getFluid(64))
                .EUt((int) V[MV])
                .duration(10)
                .buildAndRegister();

        //  Supercritical Steam
        SUPERCRITICAL_STEAM_TURBINE_RECIPES.recipeBuilder()
                .fluidInputs(SupercriticalSteam.getFluid(640))
                .fluidOutputs(DistilledWater.getFluid(128))
                .EUt((int) V[EV])
                .duration(10)
                .buildAndRegister();
    }
}
