package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class WetwareCircuits {

    public static void init() {
        CircuitBoard();
        AssemblyBuffer();
    }

    private static void CircuitBoard() {
        //  Delete original recipe
        GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                new ItemStack[]{MULTILAYER_FIBER_BOARD.getStackForm(16),
                                PETRI_DISH.getStackForm(),
                                ELECTRIC_PUMP_LuV.getStackForm(),
                                SENSOR_IV.getStackForm(),
                                OreDictUnifier.get(circuit, MarkerMaterials.Tier.IV),
                                OreDictUnifier.get(foil, NiobiumTitanium, 16)},
                new FluidStack[]{SterileGrowthMedium.getFluid(4000)});

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, KaptonK, 16)
                .input(PETRI_DISH)
                .input(ELECTRIC_PUMP_LuV)
                .input(SENSOR_IV)
                .input(circuit, MarkerMaterials.Tier.IV)
                .input(foil, NiobiumTitanium, 16)
                .fluidInputs(SterileGrowthMedium.getFluid(4000))
                .output(WETWARE_BOARD, 16)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .duration(1200)
                .EUt(VA[LuV])
                .buildAndRegister();
    }

    private static void AssemblyBuffer() {
        //  Delete original recipe
        GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                new ItemStack[]{WETWARE_CIRCUIT_BOARD.getStackForm(),
                                WETWARE_PROCESSOR_LUV.getStackForm(2),
                                ADVANCED_SMD_INDUCTOR.getStackForm(6),
                                ADVANCED_SMD_CAPACITOR.getStackForm(12),
                                RANDOM_ACCESS_MEMORY.getStackForm(24),
                                OreDictUnifier.get(wireFine, YttriumBariumCuprate, 16)},
                new FluidStack[]{Tin.getFluid(288)});

        GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                new ItemStack[]{WETWARE_CIRCUIT_BOARD.getStackForm(),
                        WETWARE_PROCESSOR_LUV.getStackForm(2),
                        ADVANCED_SMD_INDUCTOR.getStackForm(6),
                        ADVANCED_SMD_CAPACITOR.getStackForm(12),
                        RANDOM_ACCESS_MEMORY.getStackForm(24),
                        OreDictUnifier.get(wireFine, YttriumBariumCuprate, 16)},
                new FluidStack[]{SolderingAlloy.getFluid(144)});

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(WETWARE_CIRCUIT_BOARD)
                .input(WETWARE_PROCESSOR_LUV, 2)
                .input(ADVANCED_SMD_INDUCTOR, 6)
                .input(ADVANCED_SMD_CAPACITOR, 12)
                .input(RANDOM_ACCESS_MEMORY, 24)
                .input(wireFine, YttriumBariumCuprate, 16)
                .output(WETWARE_PROCESSOR_ASSEMBLY_ZPM, 2)
                .solderMultiplier(2)
                .EUt(38400)
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}