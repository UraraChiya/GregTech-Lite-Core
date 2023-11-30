package magicbook.gtlitecore.loaders;

import magicbook.gtlitecore.loaders.blocks.Crucibles;
import magicbook.gtlitecore.loaders.components.MachineComponents;
import magicbook.gtlitecore.loaders.oreprocessing.PlatinumGroupProcessing;
import magicbook.gtlitecore.loaders.oreprocessing.RareEarthProcessing;
import magicbook.gtlitecore.loaders.oreprocessing.TaraniumProcessing;

public class RecipeManager {

    private RecipeManager() {}

    public static void init() {
        initBlocks();
        MachineComponents.init();
        MaterialInfoLoader.init();
        MachineRecipeLoader.init();
        initOreProcessings();
    }

    private static void initBlocks() {
        Crucibles.init();
    }

    private static void initOreProcessings() {
       PlatinumGroupProcessing.init();
       RareEarthProcessing.init();
       TaraniumProcessing.init();
    }
}