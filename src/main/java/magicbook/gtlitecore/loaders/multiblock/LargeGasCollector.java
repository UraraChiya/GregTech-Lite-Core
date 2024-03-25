package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.LARGE_GAS_COLLECTOR_RECIPES;

public class LargeGasCollector {

    public static void init() {

        //  Air
        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .notConsumable(ELECTRIC_PUMP_LV)
                .fluidOutputs(Air.getFluid(40000))
                .EUt(VA[HV])
                .duration(200)
                .buildAndRegister();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(11)
                .notConsumable(ELECTRIC_PUMP_HV)
                .fluidOutputs(Air.getFluid(160000))
                .EUt(VA[EV])
                .duration(200)
                .buildAndRegister();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(21)
                .notConsumable(ELECTRIC_PUMP_IV)
                .fluidOutputs(Air.getFluid(640000))
                .EUt(VA[IV])
                .duration(200)
                .buildAndRegister();

        //  Nether Air
        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(ELECTRIC_PUMP_LV)
                .fluidOutputs(NetherAir.getFluid(40000))
                .EUt(VA[LV])
                .duration(200)
                .buildAndRegister();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(12)
                .notConsumable(ELECTRIC_PUMP_HV)
                .fluidOutputs(NetherAir.getFluid(160000))
                .EUt(VA[HV])
                .duration(200)
                .buildAndRegister();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(22)
                .notConsumable(ELECTRIC_PUMP_IV)
                .fluidOutputs(NetherAir.getFluid(640000))
                .EUt(VA[IV])
                .duration(200)
                .buildAndRegister();

        //  Ender Air
        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(ELECTRIC_PUMP_LV)
                .fluidOutputs(EnderAir.getFluid(40000))
                .EUt(VA[LV])
                .duration(200)
                .buildAndRegister();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(13)
                .notConsumable(ELECTRIC_PUMP_HV)
                .fluidOutputs(EnderAir.getFluid(160000))
                .EUt(VA[HV])
                .duration(200)
                .buildAndRegister();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(23)
                .notConsumable(ELECTRIC_PUMP_IV)
                .fluidOutputs(EnderAir.getFluid(640000))
                .EUt(VA[IV])
                .duration(200)
                .buildAndRegister();

        //  Liquid Air
        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .notConsumable(ELECTRIC_PUMP_MV)
                .fluidOutputs(LiquidAir.getFluid(40000))
                .EUt(VA[MV])
                .duration(400)
                .buildAndRegister();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(14)
                .notConsumable(ELECTRIC_PUMP_EV)
                .fluidOutputs(LiquidAir.getFluid(160000))
                .EUt(VA[EV])
                .duration(400)
                .buildAndRegister();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(24)
                .notConsumable(ELECTRIC_PUMP_LuV)
                .fluidOutputs(LiquidAir.getFluid(640000))
                .EUt(VA[LuV])
                .duration(400)
                .buildAndRegister();

        //  Liquid Nether Air
        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .notConsumable(ELECTRIC_PUMP_MV)
                .fluidOutputs(LiquidNetherAir.getFluid(40000))
                .EUt(VA[MV])
                .duration(400)
                .buildAndRegister();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(15)
                .notConsumable(ELECTRIC_PUMP_EV)
                .fluidOutputs(LiquidNetherAir.getFluid(160000))
                .EUt(VA[EV])
                .duration(400)
                .buildAndRegister();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(25)
                .notConsumable(ELECTRIC_PUMP_LuV)
                .fluidOutputs(LiquidNetherAir.getFluid(640000))
                .EUt(VA[LuV])
                .duration(400)
                .buildAndRegister();

        //  Liquid Ender Air
        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .notConsumable(ELECTRIC_PUMP_MV)
                .fluidOutputs(LiquidEnderAir.getFluid(40000))
                .EUt(VA[MV])
                .duration(400)
                .buildAndRegister();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .notConsumable(ELECTRIC_PUMP_EV)
                .fluidOutputs(LiquidEnderAir.getFluid(160000))
                .EUt(VA[EV])
                .duration(400)
                .buildAndRegister();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(26)
                .notConsumable(ELECTRIC_PUMP_LuV)
                .fluidOutputs(LiquidEnderAir.getFluid(640000))
                .EUt(VA[LuV])
                .duration(400)
                .buildAndRegister();

    }
}
