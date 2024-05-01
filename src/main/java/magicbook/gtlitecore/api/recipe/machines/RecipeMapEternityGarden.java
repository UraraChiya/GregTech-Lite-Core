package magicbook.gtlitecore.api.recipe.machines;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;

public class RecipeMapEternityGarden<R extends RecipeBuilder<R>> extends RecipeMap<R> {

    public RecipeMapEternityGarden(@Nonnull String unlocalizedName,
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
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 180, 260)
                .widget(new ProgressWidget(200, 9 + 4, 65, 140, 14, GTLiteGuiTextures.PROGRESS_BAR_ETERNITY_GARDEN, ProgressWidget.MoveType.HORIZONTAL))
                .image(70, 40, 23, 23, GTLiteGuiTextures.ETERNITY_GARDEN_LOGO);
        this.addInventorySlotGroup(builder, importItems, importFluids, false, yOffset);
        this.addInventorySlotGroup(builder, exportItems, exportFluids, true, yOffset);
        return builder;
    }

    @Override
    protected void addInventorySlotGroup(ModularUI.Builder builder, IItemHandlerModifiable itemHandler, FluidTankList fluidHandler, boolean isOutputs, int yOffset) {
        int startInputX = 18 + 4;
        int startInputY = 9;
        if (!isOutputs) {
            addSlot(builder, startInputX, startInputY, 0, itemHandler, fluidHandler, false, false);
            addSlot(builder, startInputX + 18, startInputY, 1, itemHandler, fluidHandler, false, false);
            addSlot(builder, startInputX - 9, startInputY + 18, 2, itemHandler, fluidHandler, false, false);
            addSlot(builder, startInputX + 9, startInputY + 18, 3, itemHandler, fluidHandler, false, false);
            addSlot(builder, startInputX + 9 + 18, startInputY + 18, 4, itemHandler, fluidHandler, false, false);
            addSlot(builder, startInputX, startInputY + 18 * 2, 5, itemHandler, fluidHandler, false, false);
            addSlot(builder, startInputX + 18, startInputY + 18 * 2, 6, itemHandler, fluidHandler, false, false);

            int StartInputY = startInputY + 72;
            addSlot(builder, startInputX, StartInputY, 0, itemHandler, fluidHandler, true, false);
            addSlot(builder, startInputX + 18, StartInputY, 1, itemHandler, fluidHandler, true, false);
            addSlot(builder, startInputX - 9, StartInputY + 18, 2, itemHandler, fluidHandler, true, false);
            addSlot(builder, startInputX + 9, StartInputY + 18, 3, itemHandler, fluidHandler, true, false);
            addSlot(builder, startInputX + 9 + 18, StartInputY + 18, 4, itemHandler, fluidHandler, true, false);
            addSlot(builder, startInputX, StartInputY + 18 * 2, 5, itemHandler, fluidHandler, true, false);
            addSlot(builder, startInputX + 18, StartInputY + 18 * 2, 6, itemHandler, fluidHandler, true, false);
        } else {
            int StartInputX = startInputX + 85;
            addSlot(builder, StartInputX, startInputY, 0, itemHandler, fluidHandler, false, true);
            addSlot(builder, StartInputX + 18, startInputY, 1, itemHandler, fluidHandler, false, true);
            addSlot(builder, StartInputX - 9, startInputY + 18, 2, itemHandler, fluidHandler, false, true);
            addSlot(builder, StartInputX + 9, startInputY + 18, 3, itemHandler, fluidHandler, false, true);
            addSlot(builder, StartInputX + 9 + 18, startInputY + 18, 4, itemHandler, fluidHandler, false, true);
            addSlot(builder, StartInputX, startInputY + 18 * 2, 5, itemHandler, fluidHandler, false, true);
            addSlot(builder, StartInputX + 18, startInputY + 18 * 2, 6, itemHandler, fluidHandler, false, true);

            int StartInputY = startInputY + 72;
            addSlot(builder, StartInputX, StartInputY, 0, itemHandler, fluidHandler, true, true);
            addSlot(builder, StartInputX + 18, StartInputY, 1, itemHandler, fluidHandler, true, true);
            addSlot(builder, StartInputX - 9, StartInputY + 18, 2, itemHandler, fluidHandler, true, true);
            addSlot(builder, StartInputX + 9, StartInputY + 18, 3, itemHandler, fluidHandler, true, true);
            addSlot(builder, StartInputX + 9 + 18, StartInputY + 18, 4, itemHandler, fluidHandler, true, true);
            addSlot(builder, StartInputX, StartInputY + 18 * 2, 5, itemHandler, fluidHandler, true, true);
            addSlot(builder, StartInputX + 18, StartInputY + 18 * 2, 6, itemHandler, fluidHandler, true, true);
        }
    }
}
