package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.recipes.RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.MarkerMaterials.Component.Capacitor;
import static gregtech.api.unification.material.MarkerMaterials.Component.Inductor;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.component;
import static gregtech.api.unification.ore.OrePrefix.wireFine;
import static gregtech.common.items.MetaItems.*;

public class ProcessorCircuits {

    public static void init() {
        AssemblyBuffer();
    }

    private static void AssemblyBuffer() {
        if (GTLiteConfigHolder.recipes.enableEasierProcessorAssembly) {
            //  Delete original recipe
            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{PLASTIC_CIRCUIT_BOARD.getStackForm(),
                            PROCESSOR_MV.getStackForm(2),
                            OreDictUnifier.get(component, Inductor, 4),
                            OreDictUnifier.get(component, Capacitor, 8),
                            RANDOM_ACCESS_MEMORY.getStackForm(4),
                            OreDictUnifier.get(wireFine, RedAlloy, 8)},
                    new FluidStack[]{Tin.getFluid(288)});

            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{PLASTIC_CIRCUIT_BOARD.getStackForm(),
                            PROCESSOR_MV.getStackForm(2),
                            OreDictUnifier.get(component, Inductor, 4),
                            OreDictUnifier.get(component, Capacitor, 8),
                            RANDOM_ACCESS_MEMORY.getStackForm(4),
                            OreDictUnifier.get(wireFine, RedAlloy, 8)},
                    new FluidStack[]{SolderingAlloy.getFluid(144)});

            CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(PLASTIC_CIRCUIT_BOARD)
                    .input(PROCESSOR_MV, 2)
                    .input(component, Inductor, 4)
                    .input(component, Capacitor, 8)
                    .input(RANDOM_ACCESS_MEMORY, 4)
                    .input(wireFine, RedAlloy, 8)
                    .solderMultiplier(2)
                    .output(PROCESSOR_ASSEMBLY_HV, 2)
                    .EUt(90)
                    .duration(400)
                    .buildAndRegister();
        }
    }
}
