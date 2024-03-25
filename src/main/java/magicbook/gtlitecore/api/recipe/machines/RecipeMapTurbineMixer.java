package magicbook.gtlitecore.api.recipe.machines;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.RecipeProgressWidget;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;

/**
 * Turbine Mixer Recipe Map
 *
 * @author Magic_Sweepy
 */
public class RecipeMapTurbineMixer<R extends RecipeBuilder<R>> extends RecipeMap<R> {

    public RecipeMapTurbineMixer(@Nonnull String unlocalizedName,
                                     int maxInputs,
                                     int maxOutputs,
                                     int maxFluidInputs,
                                     int maxFluidOutputs,
                                     @Nonnull R defaultRecipeBuilder,
                                     boolean isHidden) {
        super(unlocalizedName, maxInputs, maxOutputs, maxFluidInputs, maxFluidOutputs, defaultRecipeBuilder, isHidden);
    }

    @Override
    public ModularUI.Builder createJeiUITemplate(IItemHandlerModifiable importItems, IItemHandlerModifiable exportItems, FluidTankList importFluids, FluidTankList exportFluids, int yOffset) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 176 + 18 * 2 - 9)
                .widget(new RecipeProgressWidget(200, 176 / 2 - 18 + 4, 18 * 2 + 9, 22, 22, progressBarTexture, moveType, this));
        this.addInventorySlotGroup(builder, importItems, importFluids, false, yOffset);
        this.addInventorySlotGroup(builder, exportItems, exportFluids, true, yOffset);
        return builder;
    }

    @Override
    protected void addInventorySlotGroup(ModularUI.Builder builder, IItemHandlerModifiable itemHandler, FluidTankList fluidHandler, boolean isOutputs, int yOffset) {

        int startInputsX = 14;
        int startInputsY = 9;

        if (!isOutputs) {
            //  item inputs slots
            for (int i = 0; i < 3; i++) { // height
                for (int j = 0; j < 3; j++) { // width
                    int slotIndex = i * 3 + j;
                    addSlot(builder, startInputsX + 18 * j, startInputsY + 18 * i, slotIndex, itemHandler, fluidHandler, false, false);
                }
            }
            //  fluid inputs slots
            int StartInputsY = startInputsY + 18 * 3;
            for (int i = 0; i < 2; i++) { // height
                for (int j = 0; j < 3; j++) { // width
                    int slotIndex = i * 3 + j;
                    addSlot(builder, startInputsX + 18 * j, StartInputsY + 18 * i, slotIndex, itemHandler, fluidHandler, true, false);
                }
            }
        } else {
            int StartInputsX = startInputsX + 18 * 3 + 34;
            int StartInputsY = startInputsY + 18 * 2;
            addSlot(builder, StartInputsX, StartInputsY, 0, itemHandler, fluidHandler, false, true);
            addSlot(builder, StartInputsX + 18, StartInputsY, 0, itemHandler, fluidHandler, true, true);
        }

    }
}
