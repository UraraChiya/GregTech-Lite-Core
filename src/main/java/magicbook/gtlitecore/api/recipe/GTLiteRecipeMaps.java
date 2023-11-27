package magicbook.gtlitecore.api.recipe;

import gregtech.api.gui.GuiTextures;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;

public class GTLiteRecipeMaps {

    //  Single Machine RecipeMaps
    public static final RecipeMap<SimpleRecipeBuilder> CHEMICAL_DRYER_RECIPES;

    public GTLiteRecipeMaps() {}

    static {
        //  Chemical Dryer RecipeMap
        CHEMICAL_DRYER_RECIPES = new RecipeMap<>("chemical_dryer_recipes", 1, true, 2, true, 1, true, 1, true, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
                .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, false, false, GuiTextures.DUST_OVERLAY)
                .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
                .setSound(GTSoundEvents.FURNACE);
    }
}
