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

public class NanoCircuits {

    public static void init() {
        AssemblyBuffer();
    }

    private static void AssemblyBuffer() {
        if (GTLiteConfigHolder.recipes.enableEasierProcessorAssembly) {
            //  Delete original recipe
            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(),
                            NANO_PROCESSOR_HV.getStackForm(2),
                            SMD_INDUCTOR.getStackForm(4),
                            SMD_CAPACITOR.getStackForm(8),
                            RANDOM_ACCESS_MEMORY.getStackForm(8),
                            OreDictUnifier.get(wireFine, Electrum, 16)},
                    new FluidStack[]{Tin.getFluid(288)});

            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(),
                            NANO_PROCESSOR_HV.getStackForm(2),
                            SMD_INDUCTOR.getStackForm(4),
                            SMD_CAPACITOR.getStackForm(8),
                            RANDOM_ACCESS_MEMORY.getStackForm(8),
                            OreDictUnifier.get(wireFine, Electrum, 16)},
                    new FluidStack[]{SolderingAlloy.getFluid(144)});

            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(),
                            NANO_PROCESSOR_HV.getStackForm(2),
                            ADVANCED_SMD_INDUCTOR.getStackForm(),
                            ADVANCED_SMD_CAPACITOR.getStackForm(2),
                            RANDOM_ACCESS_MEMORY.getStackForm(8),
                            OreDictUnifier.get(wireFine, Electrum, 16)},
                    new FluidStack[]{Tin.getFluid(288)});

            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(),
                            NANO_PROCESSOR_HV.getStackForm(2),
                            ADVANCED_SMD_INDUCTOR.getStackForm(),
                            ADVANCED_SMD_CAPACITOR.getStackForm(2),
                            RANDOM_ACCESS_MEMORY.getStackForm(8),
                            OreDictUnifier.get(wireFine, Electrum, 16)},
                    new FluidStack[]{SolderingAlloy.getFluid(144)});

            CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ADVANCED_CIRCUIT_BOARD)
                    .input(NANO_PROCESSOR_HV, 2)
                    .input(SMD_INDUCTOR, 4)
                    .input(SMD_CAPACITOR, 8)
                    .input(RANDOM_ACCESS_MEMORY, 8)
                    .input(wireFine, Electrum, 16)
                    .solderMultiplier(2)
                    .output(NANO_PROCESSOR_ASSEMBLY_EV, 2)
                    .EUt(600)
                    .duration(400)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();

            CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ADVANCED_CIRCUIT_BOARD)
                    .input(NANO_PROCESSOR_HV, 2)
                    .input(ADVANCED_SMD_INDUCTOR)
                    .input(ADVANCED_SMD_CAPACITOR, 2)
                    .input(RANDOM_ACCESS_MEMORY, 8)
                    .input(wireFine, Electrum, 16)
                    .solderMultiplier(2)
                    .output(NANO_PROCESSOR_ASSEMBLY_EV, 2)
                    .EUt(600)
                    .duration(200)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
        }
    }
}
