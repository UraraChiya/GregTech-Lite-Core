package magicbook.gtlitecore.loaders.blocks;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import magicbook.gtlitecore.common.blocks.BlockExplosive;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.GELLED_TOLUENE;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class Explosives {

    public static void init() {

        //  Naquadria Charge
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Uranium238)
                .input(dust, Naquadria)
                .input(GELLED_TOLUENE, 4)
                .input(plate, Osmium)
                .input(dust, Hexanitrohexaaxaisowurtzitane)
                .input(bolt, Titanium, 4)
                .fluidInputs(GlycerylTrinitrate.getFluid(1000))
                .outputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.NAQUADRIA_CHARGE))
                .EUt(VA[UHV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Taranium Charge
        //  Require degenerate rhenium, i.e. naquadria charge
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Plutonium241)
                .input(dust, Taranium)
                .input(GELLED_TOLUENE, 4)
                .input(plate, DegenerateRhenium)
                .input(dust, Hexanitrohexaaxaisowurtzitane)
                .input(bolt, TungstenSteel, 4)
                .fluidInputs(GlycerylTrinitrate.getFluid(3000))
                .outputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.TARANIUM_CHARGE))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        //  Leptonic Charge
        //  Require heavy lepton mixture, i.e. cosmic ray detector
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.TARANIUM_CHARGE))
                .input(plate, MetastableOganesson)
                .input(plate, Vibranium)
                .input(bolt, Dubnium, 4)
                .fluidInputs(HeavyLepton.getFluid(1000))
                .outputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.LEPTONIC_CHARGE))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        //  QCD Charge
        //  Require heavy quark degenerate matter, i.e. leptonic charge
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.LEPTONIC_CHARGE))
                .input(plate, HeavyQuarkDegenerateMatter)
                .input(plate, MetastableHassium)
                .input(bolt, Livermorium, 4)
                .fluidInputs(Gluons.getFluid(1000))
                .outputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .EUt(VA[UXV])
                .duration(100)
                .buildAndRegister();
    }
}
