package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.unification.material.Material;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.NEUTRAL_NETWORK_NEXUS_BREEDING_MODE;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.NEUTRAL_NETWORK_NEXUS_HYBRIDIZING_MODE;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.*;

public class NeutralNetworkNexus {

    public static void init() {
        BreedingMode();
        HybridizingMode();
    }

    private static void BreedingMode() {

        //  Basic Breeding
        createBasicBreeding(Carbon, VA[LV], 6400);
        createBasicBreeding(Tin, VA[LV], 3800);
        //createBasicBreeding(Cobalt, VA[MV], 5300);

        //  Advanced Breeding
        createAdvancedBreeding(Silver, VA[HV], 3200);
        createAdvancedBreeding(Gold, VA[HV], 3600);
        createAdvancedBreeding(Platinum, VA[HV], 3400);
        createAdvancedBreeding(Titanium, VA[EV], 2200);
        createAdvancedBreeding(Tungsten, VA[IV], 2800);
        createAdvancedBreeding(Naquadah, VA[IV], 1800);
        createAdvancedBreeding(Neodymium, VA[EV], 2400);

        //  Elite Breeding
        createEliteBreeding(Graphene, VA[EV], 1800);
        createEliteBreeding(Europium, VA[LuV], 800);
        createEliteBreeding(Americium, VA[ZPM], 600);
        createEliteBreeding(Dubnium, VA[UV], 400);
        createEliteBreeding(NaquadahEnriched, VA[LuV], 1400);

        //  Ultimate Breeding
        createUltimateBreeding(Fullerene, VA[UV], 500);
        createUltimateBreeding(CarbonNanotube, VA[UHV], 300);
        createUltimateBreeding(Naquadria, VA[ZPM], 1000);
        createUltimateBreeding(Tritanium, VA[UV], 380);
        createUltimateBreeding(Orichalcum, VA[UV], 240);
    }

    private static void HybridizingMode() {

        //  Testing Recipe
        NEUTRAL_NETWORK_NEXUS_HYBRIDIZING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(swarm, Copper)
                .input(swarm, Redstone)
                .chancedOutput(swarm, Copper, 8000, 0)
                .chancedOutput(swarm, Redstone, 8000, 0)
                .chancedOutput(swarm, RedAlloy, 2000, 500)
                .EUt(VA[IV])
                .duration(200)
                .buildAndRegister();
    }

    private static void createBasicBreeding(Material material,
                                            int consumeEnergy,
                                            int duration) {
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, material)
                .input(nanosensor, material)
                .input(SIMPLE_SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 4)
                .fluidInputs(PCBCoolant.getFluid(L))
                .output(swarm, material)
                .EUt(consumeEnergy)
                .duration(duration)
                .buildAndRegister();
    }

    private static void createAdvancedBreeding(Material material,
                                               int consumeEnergy,
                                               int duration) {
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, material)
                .input(nanosensor, material)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 8)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, material)
                .EUt(consumeEnergy)
                .duration(duration)
                .buildAndRegister();
    }

    private static void createEliteBreeding(Material material,
                                            int consumeEnergy,
                                            int duration) {
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, material)
                .input(nanosensor, material)
                .input(ADVANCED_SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 16))
                .output(swarm, material)
                .EUt(consumeEnergy)
                .duration(duration)
                .buildAndRegister();
    }

    private static void createUltimateBreeding(Material material,
                                               int consumeEnergy,
                                               int duration) {
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, material)
                .input(nanosensor, material)
                .input(HIGHLY_ADVANCED_SOC, 8)
                .input(dust, Carbon, 32)
                .fluidInputs(PCBCoolant.getFluid(L * 64))
                .output(swarm, material)
                .EUt(consumeEnergy)
                .duration(duration)
                .buildAndRegister();
    }
}
