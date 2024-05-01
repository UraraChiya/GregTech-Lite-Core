package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.foil;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.PCB_FACTORY_ETCH_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.KaptonE;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.KaptonK;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;

public class PCBFactory {

    public static void init() {
        BasicCircuitBoard();
        GoodCircuitBoard();
        PlasticCircuitBoard();
        AdvancedCircuitBoard();
        ExtremeCircuitBoard();
        EliteCircuitBoard();
        WetwareCircuitBoard();
        KaptonCircuitBoard();
        OpticalCircuitBoard();
        SpintronicCircuitBoard();
    }

    private static void BasicCircuitBoard() {}
    private static void GoodCircuitBoard() {}

    private static void PlasticCircuitBoard() {

        //  PE
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Polyethylene)
                .input(foil, AnnealedCopper, 16)
                .input(foil, Copper, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(250))
                .output(PLASTIC_CIRCUIT_BOARD, 8)
                .EUt(22)
                .duration(665)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Polyethylene)
                .input(foil, AnnealedCopper, 16)
                .input(foil, Copper, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(250))
                .output(PLASTIC_CIRCUIT_BOARD, 10)
                .EUt(90)
                .duration(554)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Polyethylene)
                .input(foil, AnnealedCopper, 16)
                .input(foil, Copper, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(250))
                .output(PLASTIC_CIRCUIT_BOARD, 12)
                .EUt(90)
                .duration(543)
                .buildAndRegister();

        //  PVC
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, PolyvinylChloride)
                .input(foil, AnnealedCopper, 22)
                .input(foil, Copper, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(353))
                .output(PLASTIC_CIRCUIT_BOARD, 12)
                .EUt(90)
                .duration(543)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, PolyvinylChloride)
                .input(foil, AnnealedCopper, 22)
                .input(foil, Copper, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(353))
                .output(PLASTIC_CIRCUIT_BOARD, 14)
                .EUt(360)
                .duration(452)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, PolyvinylChloride)
                .input(foil, AnnealedCopper, 22)
                .input(foil, Copper, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(353))
                .output(PLASTIC_CIRCUIT_BOARD, 16)
                .EUt(360)
                .duration(362)
                .buildAndRegister();

        //  PTFE
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, AnnealedCopper, 27)
                .input(foil, Copper, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(433))
                .output(PLASTIC_CIRCUIT_BOARD, 16)
                .EUt(360)
                .duration(443)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, AnnealedCopper, 27)
                .input(foil, Copper, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(433))
                .output(PLASTIC_CIRCUIT_BOARD, 20)
                .EUt(1440)
                .duration(369)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, AnnealedCopper, 27)
                .input(foil, Copper, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(433))
                .output(PLASTIC_CIRCUIT_BOARD, 23)
                .EUt(1440)
                .duration(296)
                .buildAndRegister();

        //  Epoxy
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Epoxy)
                .input(foil, AnnealedCopper, 32)
                .input(foil, Copper, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(500))
                .output(PLASTIC_CIRCUIT_BOARD, 23)
                .EUt(1440)
                .duration(362)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Epoxy)
                .input(foil, AnnealedCopper, 32)
                .input(foil, Copper, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(500))
                .output(PLASTIC_CIRCUIT_BOARD, 27)
                .EUt(5760)
                .duration(302)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Epoxy)
                .input(foil, AnnealedCopper, 32)
                .input(foil, Copper, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(500))
                .output(PLASTIC_CIRCUIT_BOARD, 32)
                .EUt(5760)
                .duration(241)
                .buildAndRegister();

        //  Fibered epoxy
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, AnnealedCopper, 35)
                .input(foil, Copper, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(559))
                .output(PLASTIC_CIRCUIT_BOARD, 32)
                .EUt(5760)
                .duration(296)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, AnnealedCopper, 35)
                .input(foil, Copper, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(559))
                .output(PLASTIC_CIRCUIT_BOARD, 39)
                .EUt(23040)
                .duration(246)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, AnnealedCopper, 35)
                .input(foil, Copper, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(559))
                .output(PLASTIC_CIRCUIT_BOARD, 46)
                .EUt(23040)
                .duration(197)
                .buildAndRegister();

        //  PBI
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Polybenzimidazole)
                .input(foil, AnnealedCopper, 39)
                .input(foil, Copper, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(612))
                .output(PLASTIC_CIRCUIT_BOARD, 46)
                .EUt(23040)
                .duration(241)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Polybenzimidazole)
                .input(foil, AnnealedCopper, 39)
                .input(foil, Copper, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(612))
                .output(PLASTIC_CIRCUIT_BOARD, 54)
                .EUt(92160)
                .duration(201)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Polybenzimidazole)
                .input(foil, AnnealedCopper, 39)
                .input(foil, Copper, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(612))
                .output(PLASTIC_CIRCUIT_BOARD, 64)
                .EUt(92160)
                .duration(161)
                .buildAndRegister();

        //  Kapton-K
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, KaptonK)
                .input(foil, AnnealedCopper, 42)
                .input(foil, Copper, 42)
                .fluidInputs(SulfuricAcid.getFluid(1322))
                .fluidInputs(Iron3Chloride.getFluid(661))
                .output(PLASTIC_CIRCUIT_BOARD, 64)
                .EUt(92160)
                .duration(197)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, KaptonK)
                .input(foil, AnnealedCopper, 42)
                .input(foil, Copper, 42)
                .fluidInputs(SulfuricAcid.getFluid(1322))
                .fluidInputs(Iron3Chloride.getFluid(661))
                .output(PLASTIC_CIRCUIT_BOARD, 77)
                .EUt(368640)
                .duration(164)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, KaptonK)
                .input(foil, AnnealedCopper, 42)
                .input(foil, Copper, 42)
                .fluidInputs(SulfuricAcid.getFluid(1322))
                .fluidInputs(Iron3Chloride.getFluid(661))
                .output(PLASTIC_CIRCUIT_BOARD, 91)
                .EUt(368640)
                .duration(132)
                .buildAndRegister();

        //  Kapton-E
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, KaptonE)
                .input(foil, AnnealedCopper, 45)
                .input(foil, Copper, 45)
                .fluidInputs(SulfuricAcid.getFluid(1414))
                .fluidInputs(Iron3Chloride.getFluid(707))
                .output(PLASTIC_CIRCUIT_BOARD, 91)
                .EUt(368640)
                .duration(161)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, KaptonE)
                .input(foil, AnnealedCopper, 45)
                .input(foil, Copper, 45)
                .fluidInputs(SulfuricAcid.getFluid(1414))
                .fluidInputs(Iron3Chloride.getFluid(707))
                .output(PLASTIC_CIRCUIT_BOARD, 108)
                .EUt(1474560)
                .duration(134)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, KaptonE)
                .input(foil, AnnealedCopper, 45)
                .input(foil, Copper, 45)
                .fluidInputs(SulfuricAcid.getFluid(1414))
                .fluidInputs(Iron3Chloride.getFluid(707))
                .output(PLASTIC_CIRCUIT_BOARD, 128)
                .EUt(1474560)
                .duration(108)
                .buildAndRegister();
    }

    private static void AdvancedCircuitBoard() {

        //  PVC
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, PolyvinylChloride)
                .input(foil, Gold, 16)
                .input(foil, Electrum, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(500))
                .output(ADVANCED_CIRCUIT_BOARD, 8)
                .EUt(90)
                .duration(665)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, PolyvinylChloride)
                .input(foil, Gold, 16)
                .input(foil, Electrum, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(500))
                .output(ADVANCED_CIRCUIT_BOARD, 10)
                .EUt(360)
                .duration(554)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, PolyvinylChloride)
                .input(foil, Gold, 16)
                .input(foil, Electrum, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(500))
                .output(ADVANCED_CIRCUIT_BOARD, 12)
                .EUt(360)
                .duration(443)
                .buildAndRegister();

        //  PTFE
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, Gold, 22)
                .input(foil, Electrum, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(707))
                .output(ADVANCED_CIRCUIT_BOARD, 12)
                .EUt(360)
                .duration(543)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, Gold, 22)
                .input(foil, Electrum, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(707))
                .output(ADVANCED_CIRCUIT_BOARD, 14)
                .EUt(1440)
                .duration(452)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, Gold, 22)
                .input(foil, Electrum, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(707))
                .output(ADVANCED_CIRCUIT_BOARD, 16)
                .EUt(1440)
                .duration(362)
                .buildAndRegister();

        //  Epoxy
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Epoxy)
                .input(foil, Gold, 27)
                .input(foil, Electrum, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(866))
                .output(ADVANCED_CIRCUIT_BOARD, 16)
                .EUt(1440)
                .duration(443)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Epoxy)
                .input(foil, Gold, 27)
                .input(foil, Electrum, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(866))
                .output(ADVANCED_CIRCUIT_BOARD, 20)
                .EUt(5760)
                .duration(369)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Epoxy)
                .input(foil, Gold, 27)
                .input(foil, Electrum, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(866))
                .output(ADVANCED_CIRCUIT_BOARD, 23)
                .EUt(5760)
                .duration(296)
                .buildAndRegister();

        //  Fibered epoxy
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, Gold, 32)
                .input(foil, Electrum, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(1000))
                .output(ADVANCED_CIRCUIT_BOARD, 23)
                .EUt(5760)
                .duration(362)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, Gold, 32)
                .input(foil, Electrum, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(1000))
                .output(ADVANCED_CIRCUIT_BOARD, 27)
                .EUt(23040)
                .duration(302)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, Gold, 32)
                .input(foil, Electrum, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(1000))
                .output(ADVANCED_CIRCUIT_BOARD, 32)
                .EUt(23040)
                .duration(241)
                .buildAndRegister();

        //  PBI
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Polybenzimidazole)
                .input(foil, Gold, 35)
                .input(foil, Electrum, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(1118))
                .output(ADVANCED_CIRCUIT_BOARD, 32)
                .EUt(23040)
                .duration(296)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Polybenzimidazole)
                .input(foil, Gold, 35)
                .input(foil, Electrum, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(1118))
                .output(ADVANCED_CIRCUIT_BOARD, 39)
                .EUt(92160)
                .duration(246)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Polybenzimidazole)
                .input(foil, Gold, 35)
                .input(foil, Electrum, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(1118))
                .output(ADVANCED_CIRCUIT_BOARD, 46)
                .EUt(92160)
                .duration(197)
                .buildAndRegister();

        //  Kapton-K
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, KaptonK)
                .input(foil, Gold, 39)
                .input(foil, Electrum, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(1224))
                .output(ADVANCED_CIRCUIT_BOARD, 46)
                .EUt(92160)
                .duration(241)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, KaptonK)
                .input(foil, Gold, 39)
                .input(foil, Electrum, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(1224))
                .output(ADVANCED_CIRCUIT_BOARD, 54)
                .EUt(368640)
                .duration(201)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, KaptonK)
                .input(foil, Gold, 39)
                .input(foil, Electrum, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(1224))
                .output(ADVANCED_CIRCUIT_BOARD, 64)
                .EUt(368640)
                .duration(161)
                .buildAndRegister();

        //  Kapton-E
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, KaptonE)
                .input(foil, Gold, 42)
                .input(foil, Electrum, 42)
                .fluidInputs(SulfuricAcid.getFluid(1322))
                .fluidInputs(Iron3Chloride.getFluid(1322))
                .output(ADVANCED_CIRCUIT_BOARD, 64)
                .EUt(368640)
                .duration(197)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, KaptonE)
                .input(foil, Gold, 42)
                .input(foil, Electrum, 42)
                .fluidInputs(SulfuricAcid.getFluid(1322))
                .fluidInputs(Iron3Chloride.getFluid(1322))
                .output(ADVANCED_CIRCUIT_BOARD, 77)
                .EUt(1474560)
                .duration(164)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, KaptonE)
                .input(foil, Gold, 42)
                .input(foil, Electrum, 42)
                .fluidInputs(SulfuricAcid.getFluid(1322))
                .fluidInputs(Iron3Chloride.getFluid(1322))
                .output(ADVANCED_CIRCUIT_BOARD, 91)
                .EUt(1474560)
                .duration(132)
                .buildAndRegister();
    }
    private static void ExtremeCircuitBoard() {

        //  PTFE
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, AnnealedCopper, 16)
                .input(foil, AnnealedCopper, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(1000))
                .output(EXTREME_CIRCUIT_BOARD, 8)
                .EUt(360)
                .duration(665)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, AnnealedCopper, 16)
                .input(foil, AnnealedCopper, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(1000))
                .output(EXTREME_CIRCUIT_BOARD, 10)
                .EUt(1440)
                .duration(554)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, AnnealedCopper, 16)
                .input(foil, AnnealedCopper, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(1000))
                .output(EXTREME_CIRCUIT_BOARD, 12)
                .EUt(1440)
                .duration(443)
                .buildAndRegister();

        //  Epoxy
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Epoxy)
                .input(foil, AnnealedCopper, 22)
                .input(foil, AnnealedCopper, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(1414))
                .output(EXTREME_CIRCUIT_BOARD, 12)
                .EUt(1440)
                .duration(543)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Epoxy)
                .input(foil, AnnealedCopper, 22)
                .input(foil, AnnealedCopper, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(1414))
                .output(EXTREME_CIRCUIT_BOARD, 14)
                .EUt(5760)
                .duration(452)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Epoxy)
                .input(foil, AnnealedCopper, 22)
                .input(foil, AnnealedCopper, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(1414))
                .output(EXTREME_CIRCUIT_BOARD, 16)
                .EUt(5760)
                .duration(362)
                .buildAndRegister();

        //  Fibered epoxy
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, AnnealedCopper, 27)
                .input(foil, AnnealedCopper, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(1732))
                .output(EXTREME_CIRCUIT_BOARD, 16)
                .EUt(5760)
                .duration(443)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, AnnealedCopper, 27)
                .input(foil, AnnealedCopper, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(1732))
                .output(EXTREME_CIRCUIT_BOARD, 20)
                .EUt(23040)
                .duration(369)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, AnnealedCopper, 27)
                .input(foil, AnnealedCopper, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(1732))
                .output(EXTREME_CIRCUIT_BOARD, 23)
                .EUt(23040)
                .duration(296)
                .buildAndRegister();

        //  PBI
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Polybenzimidazole)
                .input(foil, AnnealedCopper, 32)
                .input(foil, AnnealedCopper, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(2000))
                .output(EXTREME_CIRCUIT_BOARD, 23)
                .EUt(23040)
                .duration(362)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Polybenzimidazole)
                .input(foil, AnnealedCopper, 32)
                .input(foil, AnnealedCopper, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(2000))
                .output(EXTREME_CIRCUIT_BOARD, 27)
                .EUt(92160)
                .duration(302)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Polybenzimidazole)
                .input(foil, AnnealedCopper, 32)
                .input(foil, AnnealedCopper, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(2000))
                .output(EXTREME_CIRCUIT_BOARD, 32)
                .EUt(92160)
                .duration(241)
                .buildAndRegister();

        //  Kapton-K
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, KaptonK)
                .input(foil, AnnealedCopper, 35)
                .input(foil, AnnealedCopper, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(2236))
                .output(EXTREME_CIRCUIT_BOARD, 32)
                .EUt(92160)
                .duration(296)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, KaptonK)
                .input(foil, AnnealedCopper, 35)
                .input(foil, AnnealedCopper, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(2236))
                .output(EXTREME_CIRCUIT_BOARD, 39)
                .EUt(368640)
                .duration(246)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, KaptonK)
                .input(foil, AnnealedCopper, 35)
                .input(foil, AnnealedCopper, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(2236))
                .output(EXTREME_CIRCUIT_BOARD, 46)
                .EUt(368640)
                .duration(197)
                .buildAndRegister();

        //  Kapton-E
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, KaptonE)
                .input(foil, AnnealedCopper, 39)
                .input(foil, AnnealedCopper, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(2449))
                .output(EXTREME_CIRCUIT_BOARD, 46)
                .EUt(368640)
                .duration(241)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, KaptonE)
                .input(foil, AnnealedCopper, 39)
                .input(foil, AnnealedCopper, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(2449))
                .output(EXTREME_CIRCUIT_BOARD, 54)
                .EUt(1474560)
                .duration(201)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, KaptonE)
                .input(foil, AnnealedCopper, 39)
                .input(foil, AnnealedCopper, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(2449))
                .output(EXTREME_CIRCUIT_BOARD, 64)
                .EUt(1474560)
                .duration(161)
                .buildAndRegister();
    }
    private static void EliteCircuitBoard() {

        //  Epoxy
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Epoxy)
                .input(foil, Palladium, 16)
                .input(foil, Platinum, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(2000))
                .output(ELITE_CIRCUIT_BOARD, 8)
                .EUt(1440)
                .duration(665)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Epoxy)
                .input(foil, Palladium, 16)
                .input(foil, Platinum, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(2000))
                .output(ELITE_CIRCUIT_BOARD, 10)
                .EUt(5760)
                .duration(554)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Epoxy)
                .input(foil, Palladium, 16)
                .input(foil, Platinum, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(2000))
                .output(ELITE_CIRCUIT_BOARD, 12)
                .EUt(5760)
                .duration(443)
                .buildAndRegister();

        //  Fibered epoxy
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, Palladium, 22)
                .input(foil, Platinum, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(2828))
                .output(ELITE_CIRCUIT_BOARD, 12)
                .EUt(5760)
                .duration(543)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, Palladium, 22)
                .input(foil, Platinum, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(2828))
                .output(ELITE_CIRCUIT_BOARD, 14)
                .EUt(23040)
                .duration(452)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, Palladium, 22)
                .input(foil, Platinum, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(2828))
                .output(ELITE_CIRCUIT_BOARD, 16)
                .EUt(23040)
                .duration(362)
                .buildAndRegister();

        //  PBI
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Polybenzimidazole)
                .input(foil, Palladium, 27)
                .input(foil, Platinum, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(3464))
                .output(ELITE_CIRCUIT_BOARD, 16)
                .EUt(23040)
                .duration(443)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Polybenzimidazole)
                .input(foil, Palladium, 27)
                .input(foil, Platinum, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(3464))
                .output(ELITE_CIRCUIT_BOARD, 20)
                .EUt(92160)
                .duration(369)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Polybenzimidazole)
                .input(foil, Palladium, 27)
                .input(foil, Platinum, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(3464))
                .output(ELITE_CIRCUIT_BOARD, 23)
                .EUt(92160)
                .duration(296)
                .buildAndRegister();

        //  Kapton-K
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, KaptonK)
                .input(foil, Palladium, 32)
                .input(foil, Platinum, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(4000))
                .output(ELITE_CIRCUIT_BOARD, 23)
                .EUt(92160)
                .duration(362)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, KaptonK)
                .input(foil, Palladium, 32)
                .input(foil, Platinum, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(4000))
                .output(ELITE_CIRCUIT_BOARD, 27)
                .EUt(368640)
                .duration(302)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, KaptonK)
                .input(foil, Palladium, 32)
                .input(foil, Platinum, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(4000))
                .output(ELITE_CIRCUIT_BOARD, 32)
                .EUt(368640)
                .duration(241)
                .buildAndRegister();

        //  Kapton-E
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, KaptonE)
                .input(foil, Palladium, 35)
                .input(foil, Platinum, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(4472))
                .output(ELITE_CIRCUIT_BOARD, 32)
                .EUt(368640)
                .duration(296)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, KaptonE)
                .input(foil, Palladium, 35)
                .input(foil, Platinum, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(4472))
                .output(ELITE_CIRCUIT_BOARD, 39)
                .EUt(1474560)
                .duration(246)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, KaptonE)
                .input(foil, Palladium, 35)
                .input(foil, Platinum, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(4472))
                .output(ELITE_CIRCUIT_BOARD, 46)
                .EUt(1474560)
                .duration(197)
                .buildAndRegister();
    }

    private static void WetwareCircuitBoard() {}

    private static void KaptonCircuitBoard() {}

    private static void OpticalCircuitBoard() {}

    private static void SpintronicCircuitBoard() {}
}
