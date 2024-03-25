package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.recipes.RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.wireFine;
import static gregtech.common.items.MetaItems.*;

public class QuantumCircuits {

    public static void init() {
        AssemblyBuffer();
    }

    private static void AssemblyBuffer() {

        if (GTLiteConfigHolder.recipes.enableEasierProcessorAssembly) {
            //  Delete original recipe
            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{EXTREME_CIRCUIT_BOARD.getStackForm(),
                            QUANTUM_PROCESSOR_EV.getStackForm(2),
                            SMD_INDUCTOR.getStackForm(8),
                            SMD_CAPACITOR.getStackForm(16),
                            RANDOM_ACCESS_MEMORY.getStackForm(4),
                            OreDictUnifier.get(wireFine, Platinum, 16)},
                    new FluidStack[]{Tin.getFluid(288)});

            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{EXTREME_CIRCUIT_BOARD.getStackForm(),
                            QUANTUM_PROCESSOR_EV.getStackForm(2),
                            SMD_INDUCTOR.getStackForm(8),
                            SMD_CAPACITOR.getStackForm(16),
                            RANDOM_ACCESS_MEMORY.getStackForm(4),
                            OreDictUnifier.get(wireFine, Platinum, 16)},
                    new FluidStack[]{SolderingAlloy.getFluid(144)});

            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{EXTREME_CIRCUIT_BOARD.getStackForm(),
                            QUANTUM_PROCESSOR_EV.getStackForm(2),
                            ADVANCED_SMD_INDUCTOR.getStackForm(2),
                            ADVANCED_SMD_CAPACITOR.getStackForm(4),
                            RANDOM_ACCESS_MEMORY.getStackForm(4),
                            OreDictUnifier.get(wireFine, Platinum, 16)},
                    new FluidStack[]{Tin.getFluid(288)});

            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{EXTREME_CIRCUIT_BOARD.getStackForm(),
                            QUANTUM_PROCESSOR_EV.getStackForm(2),
                            ADVANCED_SMD_INDUCTOR.getStackForm(2),
                            ADVANCED_SMD_CAPACITOR.getStackForm(4),
                            RANDOM_ACCESS_MEMORY.getStackForm(4),
                            OreDictUnifier.get(wireFine, Platinum, 16)},
                    new FluidStack[]{SolderingAlloy.getFluid(144)});

            CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXTREME_CIRCUIT_BOARD)
                    .input(QUANTUM_PROCESSOR_EV, 2)
                    .input(SMD_INDUCTOR, 8)
                    .input(SMD_CAPACITOR, 16)
                    .input(RANDOM_ACCESS_MEMORY, 16)
                    .input(wireFine, Platinum, 16)
                    .solderMultiplier(2)
                    .output(QUANTUM_ASSEMBLY_IV, 2)
                    .EUt(2400)
                    .duration(400)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();

            CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXTREME_CIRCUIT_BOARD)
                    .input(QUANTUM_PROCESSOR_EV, 2)
                    .input(ADVANCED_SMD_INDUCTOR, 2)
                    .input(ADVANCED_SMD_CAPACITOR, 4)
                    .input(RANDOM_ACCESS_MEMORY, 16)
                    .input(wireFine, Platinum, 16)
                    .solderMultiplier(2)
                    .output(QUANTUM_ASSEMBLY_IV, 2)
                    .EUt(2400)
                    .duration(200)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
        }
    }
}