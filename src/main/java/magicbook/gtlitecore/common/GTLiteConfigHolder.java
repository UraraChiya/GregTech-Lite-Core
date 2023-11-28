package magicbook.gtlitecore.common;

import magicbook.gtlitecore.GTLiteCore;
import net.minecraftforge.common.config.Config;

@Config(modid = GTLiteCore.MODID)
public class GTLiteConfigHolder {

    @Config.Comment("Config options for modification of GTLite Core contents")
    @Config.Name("GTLite Core Options")
    public static GTLiteCoreOverrides gtlitecoreOverrides = new GTLiteCoreOverrides();

    @Config.Comment("Config options for modification of GregTech Processing Chains")
    @Config.Name("Processing Chain Override Options")
    public static ChainOverrides chainOverrides = new ChainOverrides();

    @Config.Comment("Config options for modification of GregTech Steam stage contents")
    @Config.Name("Steam Stage Contents Override Options")
    public static SteamOverrides steamOverrides = new SteamOverrides();

    public static class GTLiteCoreOverrides {
        @Config.Comment({"Enable harder Crucible recipes, requires Vacuum Chamber.", "Default: true"})
        public boolean enableHarderCrucibleRecipe = true;
    }

    public static class ChainOverrides {
        @Config.Comment({"Enable Rare Earth process.", "Default: true"})
        public boolean enableRareEarthProcessing = true;
        @Config.Comment({"Enable Platinum Group process.", "Default: true"})
        public static boolean enablePlatinumGroupProcessing = true;
        @Config.Comment({"Enable Tungsten process.", "Default: true"})
        public boolean enableTungstenProcessing = true;
        @Config.Comment({"Enable Graphene process.", "Default: true"})
        public boolean enableGrapheneProcessing = true;
    }

    public static class SteamOverrides {
        @Config.Comment({"Enable harder Steam machine recipes, requires ULV components.", "Default: true"})
        public boolean enableHarderSteamMachineRecipe = true;
        @Config.Comment({"Enable harder Vacuum tube recipes, requires Vacuum Chamber.", "Default: true"})
        public boolean enableHarderVacuumTubeRecipe = true;
    }
}
