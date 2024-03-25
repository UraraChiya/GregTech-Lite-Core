package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.unification.material.MarkerMaterials;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.CARBON_MESH;
import static gregtech.common.items.MetaItems.POWER_THRUSTER_ADVANCED;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.DYSON_SWARM_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.DYSON_SWARM_MODULE;

public class DysonSwarm {

    public static void init() {

        //  Dyson Swarm Module
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, HY1301, 2)
                .input(circuit, MarkerMaterials.Tier.ZPM)
                .input(CARBON_MESH, 8)
                .input(ring, ActiniumGroupHAlloy, 16)
                .input(POWER_THRUSTER_ADVANCED, 2)
                .input(wireFine, CarbonNanotube, 4)
                .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                .output(DYSON_SWARM_MODULE, 64)
                .EUt(VA[UHV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  x1
        DYSON_SWARM_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(DYSON_SWARM_MODULE)
                .chancedOutput(DYSON_SWARM_MODULE, 5000, 0)
                .EUt(10000000)
                .duration(200)
                .buildAndRegister();

        //  x4
        DYSON_SWARM_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(DYSON_SWARM_MODULE, 4)
                .chancedOutput(DYSON_SWARM_MODULE, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 5000, 0)
                .EUt(40000000)
                .duration(200)
                .buildAndRegister();

        //  x16
        DYSON_SWARM_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(DYSON_SWARM_MODULE, 16)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .EUt(160000000)
                .duration(200)
                .buildAndRegister();

        //  x32
        DYSON_SWARM_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(DYSON_SWARM_MODULE, 32)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .EUt(320000000)
                .duration(200)
                .buildAndRegister();

        //  x64
        DYSON_SWARM_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(DYSON_SWARM_MODULE, 64)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .EUt(640000000)
                .duration(200)
                .buildAndRegister();
    }
}
