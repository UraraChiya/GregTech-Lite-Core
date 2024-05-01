package magicbook.gtlitecore.loaders;

import magicbook.gtlitecore.loaders.handlers.*;

public class RecipeHandler {

    public static void init() {
        BouleRecipeHandler.register();
        MaterialRecipeHandler.register();
        PartRecipeHandler.register();
        PipeRecipeHandler.register();
        WireRecipeHandler.register();
        ToolRecipeHandler.register();
    }
}