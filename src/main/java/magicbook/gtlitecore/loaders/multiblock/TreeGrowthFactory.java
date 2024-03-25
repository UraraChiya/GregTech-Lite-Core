package magicbook.gtlitecore.loaders.multiblock;

import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.Biomass;
import static gregtech.api.unification.material.Materials.Water;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.TREE_GROWTH_RECIPES;

public class TreeGrowthFactory {

    public static void init() {

        //  Oak
        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 1, 0))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 8, 0))
                .outputs(new ItemStack(Blocks.LEAVES, 4, 0))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 1, 0), 4000, 500)
                .chancedOutput(new ItemStack(Items.APPLE), 2000, 500)
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 4, 0))
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 16, 0))
                .outputs(new ItemStack(Blocks.LEAVES, 8, 0))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 4, 0), 6000, 1000)
                .chancedOutput(new ItemStack(Items.APPLE, 2), 4000, 500)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 16, 0))
                .circuitMeta(3)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 32, 0))
                .outputs(new ItemStack(Blocks.LEAVES, 16, 0))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 8, 0), 8000, 1000)
                .chancedOutput(new ItemStack(Items.APPLE, 4), 6000, 500)
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        //  Spruce
        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 1, 1))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 8, 1))
                .outputs(new ItemStack(Blocks.LEAVES, 4, 1))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 1, 1), 4000, 500)
                .chancedOutput(new ItemStack(Items.APPLE), 2000, 500)
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 4, 1))
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 16, 1))
                .outputs(new ItemStack(Blocks.LEAVES, 8, 1))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 4, 1), 6000, 1000)
                .chancedOutput(new ItemStack(Items.APPLE, 2), 4000, 500)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 16, 1))
                .circuitMeta(3)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 32, 1))
                .outputs(new ItemStack(Blocks.LEAVES, 16, 1))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 8, 1), 8000, 1000)
                .chancedOutput(new ItemStack(Items.APPLE, 4), 6000, 500)
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        //  Birch
        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 1, 2))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 8, 2))
                .outputs(new ItemStack(Blocks.LEAVES, 4, 2))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 1, 2), 4000, 500)
                .chancedOutput(new ItemStack(Items.APPLE), 2000, 500)
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 4, 2))
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 16, 2))
                .outputs(new ItemStack(Blocks.LEAVES, 8, 2))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 4, 2), 6000, 1000)
                .chancedOutput(new ItemStack(Items.APPLE, 2), 4000, 500)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 16, 2))
                .circuitMeta(3)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 32, 2))
                .outputs(new ItemStack(Blocks.LEAVES, 16, 2))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 8, 2), 8000, 1000)
                .chancedOutput(new ItemStack(Items.APPLE, 4), 6000, 500)
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        //  Jungle
        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 1, 3))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 8, 3))
                .outputs(new ItemStack(Blocks.LEAVES, 4, 3))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 1, 3), 4000, 500)
                .chancedOutput(new ItemStack(Items.DYE, 2, 3), 2000, 500)
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 4, 3))
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 16, 3))
                .outputs(new ItemStack(Blocks.LEAVES, 8, 3))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 4, 3), 6000, 1000)
                .chancedOutput(new ItemStack(Items.DYE, 4, 3), 4000, 500)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 16, 3))
                .circuitMeta(3)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 32, 3))
                .outputs(new ItemStack(Blocks.LEAVES, 16, 3))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 8, 3), 8000, 1000)
                .chancedOutput(new ItemStack(Items.DYE, 8, 3), 6000, 500)
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        //  Acacia
        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 1, 4))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG2, 8, 0))
                .outputs(new ItemStack(Blocks.LEAVES2, 4, 0))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 1, 4), 4000, 500)
                .chancedOutput(new ItemStack(Items.APPLE), 2000, 500)
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 4, 4))
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG2, 16, 0))
                .outputs(new ItemStack(Blocks.LEAVES2, 8, 0))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 2, 4), 6000, 1000)
                .chancedOutput(new ItemStack(Items.APPLE, 2), 4000, 500)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 16, 4))
                .circuitMeta(3)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG2, 32, 0))
                .outputs(new ItemStack(Blocks.LEAVES2, 16, 0))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 4, 4), 8000, 1000)
                .chancedOutput(new ItemStack(Items.APPLE, 4), 6000, 500)
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        //  Dark Oak
        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 1, 5))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG2, 8, 1))
                .outputs(new ItemStack(Blocks.LEAVES2, 4, 1))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 1, 5), 4000, 500)
                .chancedOutput(new ItemStack(Items.APPLE), 2000, 500)
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 4, 5))
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG2, 16, 1))
                .outputs(new ItemStack(Blocks.LEAVES2, 8, 1))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 2, 5), 6000, 1000)
                .chancedOutput(new ItemStack(Items.APPLE, 2), 4000, 500)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 16, 5))
                .circuitMeta(3)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG2, 32, 1))
                .outputs(new ItemStack(Blocks.LEAVES2, 16, 1))
                .chancedOutput(new ItemStack(Blocks.SAPLING, 4, 5), 8000, 1000)
                .chancedOutput(new ItemStack(Items.APPLE, 4), 6000, 500)
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        //  Rubber
        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(MetaBlocks.RUBBER_SAPLING))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(200))
                .outputs(new ItemStack(MetaBlocks.RUBBER_LOG, 8))
                .outputs(new ItemStack(MetaBlocks.RUBBER_LEAVES, 4, 1))
                .chancedOutput(new ItemStack(MetaBlocks.RUBBER_SAPLING, 1), 4000, 500)
                .chancedOutput(MetaItems.STICKY_RESIN, 4, 2000, 500)
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(MetaBlocks.RUBBER_SAPLING, 4))
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(MetaBlocks.RUBBER_LOG, 16))
                .outputs(new ItemStack(MetaBlocks.RUBBER_LEAVES, 8, 1))
                .chancedOutput(new ItemStack(MetaBlocks.RUBBER_SAPLING, 2), 6000, 1000)
                .chancedOutput(MetaItems.STICKY_RESIN, 8, 4000, 500)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(MetaBlocks.RUBBER_SAPLING, 16))
                .circuitMeta(3)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(MetaBlocks.RUBBER_LOG, 32))
                .outputs(new ItemStack(MetaBlocks.RUBBER_LEAVES, 16, 1))
                .chancedOutput(new ItemStack(MetaBlocks.RUBBER_SAPLING, 4), 8000, 1000)
                .chancedOutput(MetaItems.STICKY_RESIN, 16, 6000, 500)
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();
    }
}