package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import magicbook.gtlitecore.common.GTLiteConfigHolder;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.common.items.MetaItems.STEM_CELLS;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.BIO_REACTOR_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.ExoticMutagen;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.BIO_CELL;

public class BioReactor {

    public static void init() {

        if (GTLiteConfigHolder.misc.enableBioReactorVanillaRecipe) {

            //  Some vanilla biological recipes
            BIO_REACTOR_RECIPES.recipeBuilder()
                    .fluidInputs(Bacteria.getFluid(1000))
                    .fluidInputs(Biomass.getFluid(1000))
                    .fluidOutputs(BacterialSludge.getFluid(1000))
                    .EUt(VA[EV])
                    .duration(600)
                    .cleanroom(CleanroomType.STERILE_CLEANROOM)
                    .buildAndRegister();

            BIO_REACTOR_RECIPES.recipeBuilder()
                    .input(dust, Osmiridium)
                    .circuitMeta(1)
                    .fluidInputs(Bacteria.getFluid(500))
                    .fluidInputs(SterileGrowthMedium.getFluid(500))
                    .output(STEM_CELLS, 32)
                    .fluidOutputs(BacterialSludge.getFluid(500))
                    .EUt(VA[LuV])
                    .duration(300)
                    .cleanroom(CleanroomType.STERILE_CLEANROOM)
                    .buildAndRegister();

            //  Bio Cell for Gooware SoC processing
            BIO_REACTOR_RECIPES.recipeBuilder()
                    .input(dust, NaquadahEnriched)
                    .circuitMeta(1)
                    .fluidInputs(SterileGrowthMedium.getFluid(1000))
                    .fluidInputs(Bacteria.getFluid(1000))
                    .fluidInputs(ExoticMutagen.getFluid(500))
                    .output(BIO_CELL, 64)
                    .EUt(VA[ZPM])
                    .duration(600)
                    .cleanroom(CleanroomType.STERILE_CLEANROOM)
                    .buildAndRegister();
        }

        //  Another stem cell recipe
        BIO_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Osmiridium)
                .circuitMeta(11)
                .fluidInputs(Bacteria.getFluid(500))
                .fluidInputs(SterileGrowthMedium.getFluid(500))
                .fluidInputs(ExoticMutagen.getFluid(250))
                .output(STEM_CELLS, 64)
                .fluidOutputs(BacterialSludge.getFluid(500))
                .EUt(VA[UV])
                .duration(150)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();
    }
}
