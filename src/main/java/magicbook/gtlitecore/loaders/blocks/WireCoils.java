package magicbook.gtlitecore.loaders.blocks;

import magicbook.gtlitecore.common.blocks.BlockWireCoil;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.Seaborgium;
import static gregtech.api.unification.material.Materials.Tritanium;
import static gregtech.api.unification.ore.OrePrefix.foil;
import static gregtech.api.unification.ore.OrePrefix.wireGtDouble;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class WireCoils {

    /**
     * @param tier Based on the original duration formula of CEu, with a rounding of 5
     * @return New coil recipe duration
     */
    private static int resultDuration(int tier) {
        return (45 + tier * 5) * 20;
    }

    /**
     * @param tier Based on the original EUt formula of CEu
     * @return New coil EUt (based on UV tier)
     */
    private static int resultEUt(int tier) {
        return VA[UV + tier];
    }

    public static void init() {

        //  Adamantium
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, Adamantium, 8)
                .input(foil, SiliconCarbide, 8)
                .fluidInputs(Tritanium.getFluid(L))
                .outputs(GTLiteMetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.ADAMANTIUM))
                .EUt(resultEUt(1))
                .duration(resultDuration(1))
                .buildAndRegister();

        //  Ichorium
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, Ichorium, 8)
                .input(foil, Seaborgium, 8)
                .fluidInputs(Adamantium.getFluid(L))
                .outputs(GTLiteMetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.ICHORIUM))
                .EUt(resultEUt(2))
                .duration(resultDuration(2))
                .buildAndRegister();

        //  Astralium
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, Astralium, 8)
                .input(foil, Abyssalloy, 8)
                .fluidInputs(Ichorium.getFluid(L))
                .outputs(GTLiteMetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.ASTRALIUM))
                .EUt(resultEUt(3))
                .duration(resultDuration(3))
                .buildAndRegister();
    }
}
