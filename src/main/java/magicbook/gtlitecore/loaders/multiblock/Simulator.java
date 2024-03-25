package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.unification.material.MarkerMaterials;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CANNER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.SIMULATOR_RECIPES;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class Simulator {

    public static void init() {
        MemoryCards();
        Simulation();
        BiowareSimulation();
    }

    private static void MemoryCards() {

        //  Base
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Polyethylene)
                .input(circuit, MarkerMaterials.Tier.LV)
                .input(wireFine, Silver, 4)
                .fluidInputs(TinAlloy.getFluid(L / 2))
                .output(MEMORY_CARD_BASE)
                .EUt(VA[LV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, PolyvinylChloride)
                .input(circuit, MarkerMaterials.Tier.LV)
                .input(wireFine, Silver, 4)
                .fluidInputs(TinAlloy.getFluid(L / 2))
                .output(MEMORY_CARD_BASE)
                .EUt(VA[LV])
                .duration(200)
                .buildAndRegister();

        //  Zombie
        CANNER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .input(Items.ROTTEN_FLESH)
                .output(MEMORY_CARD_ZOMBIE)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  Skeleton
        CANNER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .input(Items.BONE)
                .output(MEMORY_CARD_SKELETON)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  Creeper
        CANNER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .input(Items.GUNPOWDER)
                .output(MEMORY_CARD_CREEPER)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  Slime
        CANNER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .input(Items.SLIME_BALL)
                .output(MEMORY_CARD_SLIME)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  Spider
        CANNER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .input(Items.SPIDER_EYE)
                .output(MEMORY_CARD_SPIDER)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  Blaze
        CANNER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .input(Items.BLAZE_POWDER)
                .output(MEMORY_CARD_BLAZE)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  Ghast
        CANNER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .input(Items.GHAST_TEAR)
                .output(MEMORY_CARD_GHAST)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  Guardian
        CANNER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .input(Items.PRISMARINE_SHARD)
                .output(MEMORY_CARD_GUARDIAN)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  Wither Skeleton
        CANNER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .input(Items.SKULL, 1, 1)
                .output(MEMORY_CARD_WITHER_SKELETON)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  Witch
        CANNER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .input(Items.GLASS_BOTTLE)
                .output(MEMORY_CARD_WITCH)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  Enderman
        CANNER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .input(Items.ENDER_EYE)
                .output(MEMORY_CARD_ENDERMAN)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  Shulker
        CANNER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .input(Items.SHULKER_SHELL)
                .output(MEMORY_CARD_SHULKER)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  Wither
        CANNER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .input(Items.NETHER_STAR)
                .output(MEMORY_CARD_WITHER)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  Ender Dragon
        CANNER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .inputs(new ItemStack(Blocks.DRAGON_EGG))
                .output(MEMORY_CARD_ENDER_DRAGON)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();
    }

    private static void Simulation() {

        if (GTLiteConfigHolder.machines.enableSimulator) {
            //  LV: Zombie, Skeleton, Creeper, Slime, Spider
            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_ZOMBIE)
                    .circuitMeta(1)
                    .chancedOutput(new ItemStack(Items.ROTTEN_FLESH, 64), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_ZOMBIE)
                    .circuitMeta(2)
                    .chancedOutput(ingot, Iron, 16, GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_ZOMBIE)
                    .circuitMeta(3)
                    .chancedOutput(new ItemStack(Items.CARROT, 32), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_ZOMBIE)
                    .circuitMeta(4)
                    .chancedOutput(new ItemStack(Items.POTATO, 32), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_ZOMBIE)
                    .circuitMeta(5)
                    .chancedOutput(new ItemStack(Items.SKULL, 16, 2), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_SKELETON)
                    .circuitMeta(1)
                    .chancedOutput(new ItemStack(Items.BONE, 32), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_SKELETON)
                    .circuitMeta(2)
                    .chancedOutput(new ItemStack(Items.ARROW, 64), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_SKELETON)
                    .circuitMeta(3)
                    .chancedOutput(new ItemStack(Items.SKULL, 16, 0), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_SKELETON)
                    .circuitMeta(4)
                    .chancedOutput(ingot, Tin, 16, GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_CREEPER)
                    .circuitMeta(1)
                    .chancedOutput(new ItemStack(Items.GUNPOWDER, 32), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_CREEPER)
                    .circuitMeta(2)
                    .chancedOutput(new ItemStack(Items.COAL, 32), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_CREEPER)
                    .circuitMeta(3)
                    .chancedOutput(new ItemStack(Items.SKULL, 16, 4), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_SLIME)
                    .circuitMeta(1)
                    .chancedOutput(new ItemStack(Items.SLIME_BALL, 32), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_SLIME)
                    .circuitMeta(2)
                    .chancedOutput(ingot, Nickel, 16, GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_SPIDER)
                    .circuitMeta(1)
                    .chancedOutput(new ItemStack(Items.SPIDER_EYE, 64), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_SPIDER)
                    .circuitMeta(2)
                    .chancedOutput(new ItemStack(Items.STRING, 32), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_SPIDER)
                    .circuitMeta(3)
                    .chancedOutput(ingot, Copper, 16, GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[LV])
                    .duration(1200)
                    .buildAndRegister();

            //  MV: Blaze, Ghast, Guardian, Wither Skeleton, Witch
            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_BLAZE)
                    .circuitMeta(1)
                    .chancedOutput(new ItemStack(Items.BLAZE_ROD, 16), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_BLAZE)
                    .circuitMeta(2)
                    .chancedOutput(dust, Sulfur, 32, GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_BLAZE)
                    .circuitMeta(3)
                    .chancedOutput(new ItemStack(Items.MAGMA_CREAM, 64), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_GHAST)
                    .circuitMeta(1)
                    .chancedOutput(new ItemStack(Items.GHAST_TEAR, 32), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_GHAST)
                    .circuitMeta(2)
                    .chancedOutput(ingot, Silver, 16, GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_GUARDIAN)
                    .circuitMeta(1)
                    .chancedOutput(new ItemStack(Items.PRISMARINE_SHARD, 64), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_GUARDIAN)
                    .circuitMeta(2)
                    .chancedOutput(new ItemStack(Items.PRISMARINE_CRYSTALS, 64), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_GUARDIAN)
                    .circuitMeta(3)
                    .chancedOutput(new ItemStack(Items.FISH, 64), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_GUARDIAN)
                    .circuitMeta(4)
                    .chancedOutput(ingot, Gold, 16, GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_GUARDIAN)
                    .circuitMeta(5)
                    .chancedOutput(dust, Aluminium, 16, GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_WITHER_SKELETON)
                    .circuitMeta(1)
                    .chancedOutput(new ItemStack(Items.SKULL, 16, 1), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_WITHER_SKELETON)
                    .circuitMeta(2)
                    .chancedOutput(ingot, Lead, 16, GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_WITHER_SKELETON)
                    .circuitMeta(3)
                    .chancedOutput(new ItemStack(Blocks.SOUL_SAND, 64), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_WITCH)
                    .circuitMeta(1)
                    .chancedOutput(dust, Redstone, 32, GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_WITCH)
                    .circuitMeta(2)
                    .chancedOutput(dust, Glowstone, 32, GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_WITCH)
                    .circuitMeta(3)
                    .chancedOutput(new ItemStack(Items.SUGAR, 64), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[MV])
                    .duration(1200)
                    .buildAndRegister();

            //  HV: Enderman, Shulker
            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_ENDERMAN)
                    .circuitMeta(1)
                    .chancedOutput(new ItemStack(Items.ENDER_PEARL, 16), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[HV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_ENDERMAN)
                    .circuitMeta(2)
                    .chancedOutput(new ItemStack(Items.EMERALD, 16), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[HV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_ENDERMAN)
                    .circuitMeta(3)
                    .chancedOutput(new ItemStack(Blocks.END_STONE, 32), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[HV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_SHULKER)
                    .circuitMeta(1)
                    .chancedOutput(new ItemStack(Items.SHULKER_SHELL, 16), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[HV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_SHULKER)
                    .circuitMeta(2)
                    .chancedOutput(new ItemStack(Items.DIAMOND, 16), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[HV])
                    .duration(1200)
                    .buildAndRegister();

            //  EV: Wither
            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_WITHER)
                    .circuitMeta(1)
                    .chancedOutput(new ItemStack(Items.NETHER_STAR), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[EV])
                    .duration(1200)
                    .buildAndRegister();

            //  IV: Ender Dragon
            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_ENDER_DRAGON)
                    .circuitMeta(1)
                    .chancedOutput(new ItemStack(Items.DRAGON_BREATH, 32), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[IV])
                    .duration(1200)
                    .buildAndRegister();

            SIMULATOR_RECIPES.recipeBuilder()
                    .notConsumable(MEMORY_CARD_ENDER_DRAGON)
                    .circuitMeta(2)
                    .chancedOutput(new ItemStack(Blocks.DRAGON_EGG), GTLiteConfigHolder.machines.chanceSimulator, GTLiteConfigHolder.machines.tierChanceBoostSimulator)
                    .EUt(VA[IV])
                    .duration(1200)
                    .buildAndRegister();
        }
    }

    private static void BiowareSimulation() {

    }
}
