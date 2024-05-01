package magicbook.gtlitecore.integration.gregtechfoodoption;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtechfoodoption.block.GTFOGlassCasing;
import gregtechfoodoption.block.GTFOMetaBlocks;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_PLATE;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.BIO_REACTOR_RECIPES;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.CHEMICAL_DRYER_RECIPES;

/**
 * Overrides of GregTechFoodOptions
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     You can control this overrides by {@link GTLiteConfigHolder}.
 * </p>
 *
 * @since 1.11.1
 */
public class GTFOOverrideRecipeLoader {

    public static void init() {
        if (GTLiteConfigHolder.compats.enableGTFOTweaks) {

            //  Greenhouse Glass
            //  Why this recipe use assembler not alloy smelter?
            GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, CupricHydrogenArsenite.getItemStack(), MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.TEMPERED_GLASS));

            ALLOY_SMELTER_RECIPES.recipeBuilder()
                    .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.TEMPERED_GLASS))
                    .inputs(CupricHydrogenArsenite.getItemStack())
                    .outputs(GTFOMetaBlocks.GTFO_GLASS_CASING.getItemVariant(GTFOGlassCasing.CasingType.GREENHOUSE_GLASS))
                    .EUt(24)
                    .duration(60)
                    .buildAndRegister();

            //  Unfired Porcelain Tile
            //  Why this recipe consume my shape mold!? :(
            GTRecipeHandler.removeRecipesByInputs(FORMING_PRESS_RECIPES, BoneChinaClay.getItemStack(2), SHAPE_MOLD_PLATE.getStackForm());

            FORMING_PRESS_RECIPES.recipeBuilder()
                    .inputs(BoneChinaClay.getItemStack(2))
                    .notConsumable(SHAPE_MOLD_PLATE)
                    .outputs(UnfiredPorcelainTile.getItemStack())
                    .EUt(28)
                    .duration(160)
                    .buildAndRegister();

            //  Nitrophenols
            //  Why this recipe use chemical reactor not centrifuge?
            GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES, Nitrophenols.getFluid(1000));
            GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES, Nitrophenols.getFluid(1000));


            CENTRIFUGE_RECIPES.recipeBuilder()
                    .fluidInputs(Nitrophenols.getFluid(1000))
                    .outputs(IVNitrophenol.getItemStack(15))
                    .outputs(IINitrophenol.getItemStack(15))
                    .EUt(VA[HV])
                    .duration(10)
                    .buildAndRegister();

            //  todo Use of 2-Nitrophenol

            //  Fungal Rennet Solution
            //  Please use Bio Reactor recipe!
            GTRecipeHandler.removeRecipesByInputs(MIXER_RECIPES,
                    new ItemStack[]{PenicilliumRoqueforti.getItemStack()},
                    new FluidStack[]{LacticAcidBacteria.getFluid(1), CrudeRennetSolution.getFluid(250)});

            BIO_REACTOR_RECIPES.recipeBuilder()
                    .inputs(PenicilliumRoqueforti.getItemStack())
                    .fluidInputs(LacticAcidBacteria.getFluid(1))
                    .fluidInputs(CrudeRennetSolution.getFluid(250))
                    .fluidOutputs(FungalRennetSolution.getFluid(250))
                    .EUt(110)
                    .duration(120)
                    .buildAndRegister();

            //  Mozzarella Curd
            //  Use Chemical Dryer, do not use Thermal Centrifuge!
            GTRecipeHandler.removeRecipesByInputs(THERMAL_CENTRIFUGE_RECIPES, SmallMozzarellaCurd.getItemStack());

            CHEMICAL_DRYER_RECIPES.recipeBuilder()
                    .inputs(SmallMozzarellaCurd.getItemStack())
                    .outputs(DriedMozzarellaCurd.getItemStack())
                    .EUt(VA[LV])
                    .duration(50 * SECOND)
                    .buildAndRegister();

        }
    }

}
