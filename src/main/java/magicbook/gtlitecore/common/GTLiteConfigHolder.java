package magicbook.gtlitecore.common;

import magicbook.gtlitecore.GTLiteCore;
import net.minecraftforge.common.config.Config;

import static net.minecraftforge.common.config.Config.*;

@Config(modid = GTLiteCore.MODID)
public class GTLiteConfigHolder {

    @Comment({"Config options for Mod Compatibility"})
    @Name("Compatibility Options")
    @RequiresMcRestart
    public static CompatibilityOptions compats = new CompatibilityOptions();

    @Comment({"Config options for GregTech Lite Machines"})
    @Name("Machine Options")
    @RequiresMcRestart
    public static MachineOptions machines = new MachineOptions();

    @Comment({"Config options for Miscellaneous Features"})
    @Name("Misc Options")
    @RequiresMcRestart
    public static MiscOptions misc = new MiscOptions();

    @Comment({"Config Options for GregTech Lite, GregTech and Vanilla Recipes"})
    @Name("Recipe Options")
    @RequiresMcRestart
    public static RecipeOptions recipes = new RecipeOptions();

    @Comment({"Config Options for Tools and Armor"})
    @Name("Tool and Armor Options")
    @RequiresMcRestart
    public static ToolOptions tools = new ToolOptions();

    public GTLiteConfigHolder() {}

    public static class CompatibilityOptions {

        @Comment({"Enable easier Large Circuit Assembler (GCYM) recipe, requires IV-tier materials and LuV-tier circuit.", "Default: true"})
        public boolean enableEasierLargeCircuitAssembler = true;

        @Comment({"Enable easier Mega Blast Furnace/Vacuum Freezer (GCYM) recipes, requires UV-tier materials.", "Default: true"})
        public boolean enableEasierMegaMachines = true;

        @Comment({"Enable high tier Tiered Hatch (UHV-MAX) recipes.", "Default: true"})
        public boolean enableHighTierTieredHatch = true;

        @Comment({"Enable some recipe tweaks of GTFO (such as Greenhouse Glass).", "Default: true"})
        public boolean enableGTFOTweaks = true;

        public CompatibilityOptions() {}
    }

    public static class MachineOptions {

        @Comment({"Enable harder Steam stage Machine recipes, requires ULV components.", "Default: true"})
        public boolean enableHarderSteamStageMachine = true;

        @Comment({"Enable high tier item hatch (UEV-OpV) recipes, these hatches may have issues.", "Default: true"})
        public boolean enableHighTierItemHatch = true;

        @Comment({"Enable high tier fluid hatch (UEV-OpV) recipes, these hatches may have issues.", "Default: true"})
        public boolean enableHighTierFluidHatch = true;

        @Comment({"Enable high tier multi fluid hatch (UEV-OpV) recipes, these hatches may have issues.", "Default: true"})
        public boolean enableHighTierMultiFluidHatch = true;

        @Comment({"Enable high tier 1A energy hatch (UEV-OpV) recipes.", "Default: true"})
        public boolean enableHighTier1AEnergyHatch = true;

        @Comment({"Enable LV-HV 4A energy hatch recipes.", "Default: true"})
        public boolean enableLVtoHV4AEnergyHatch = true;

        @Comment({"Enable high tier 4A energy hatch (UEV-OpV) recipes.", "Default: true"})
        public boolean enableHighTier4AEnergyHatch = true;

        @Comment({"Enable LV-EV 16A energy hatch recipes.", "Default: true"})
        public boolean enableLVtoEV16AEnergyHatch = true;

        @Comment({"Enable high tier 16A energy hatch (UEV-OpV) recipes.", "Default: true"})
        public boolean enableHighTier16AEnergyHatch = true;

        @Comment({"Enable high tier 64A substation energy hatch (UEV-OpV) recipes.", "Default: true"})
        public boolean enableHighTier64ASubstationEnergyHatch = true;

        @Comment({"Enable high tier transformer (UEV-OpV) recipes.", "Default: true"})
        public boolean enableHighTierTransformer = true;

        @Comment({"Enable high tier power transformer (UEV-OpV) recipes.", "Default: true"})
        public boolean enableHighTierPowerTransformer = true;

        @Comment({"Enable high tier hi-amp transformer (UEV-OpV) recipes.", "Default: true"})
        public boolean enableHighTierHiAmpTransformer = true;

        @Comment({"Enable high tier 256A laser hatch (UHV-OpV) recipes.", "Default: true"})
        public boolean enableHighTier256ALaserHatch = true;

        @Comment({"Enable high tier 1024A laser hatch (UHV-OpV) recipes.", "Default: true"})
        public boolean enableHighTier1024ALaserHatch = true;

        @Comment({"Enable high tier 4096A laser hatch (UHV-OpV) recipes.", "Default: true"})
        public boolean enableHighTier4096ALaserHatch = true;

        @Comment({"Enable Simulator (LV-IV), and its recipes.", "Default: true"})
        public boolean enableSimulator = true;

        @Comment({"Set chance of Simulator recipes.", "Default: 1000"})
        @RangeInt(min = 1, max = 10000)
        public int chanceSimulator = 1000;

        @Comment({"Set tier chance boost of Simulator recipes.", "Default: 100"})
        @RangeInt(min = 1, max = 10000)
        public int tierChanceBoostSimulator = 100;

        public MachineOptions() {}
    }

    public static class MiscOptions {

        @Comment({"Allow combustion generator use Rocket Fuel.", "Default: false"})
        public boolean enableRocketFuelEngineRecipe = false;

        @Comment({"Rocket Fuel EU/t product in Rocket Engine.", "Default: 512"})
        @RangeInt(min = 1, max = 8192)
        public int heatValueRocketFuel = 512;

        @Comment({"RP-1 Rocket Fuel EU/t product in Rocket Engine.", "Default: 512"})
        @RangeInt(min = 1, max = 8192)
        public int heatValueRP1RocketFuel = 512;

        @Comment({"Dense Hydrazine Mixture Rocket Fuel EU/t product in Rocket Engine.", "Default: 2048"})
        @RangeInt(min = 1, max = 8192)
        public int heatValueDenseHydrazineMixtureRocketFuel = 2048;

        @Comment({"Methylhydrazine Nitrate Rocket Fuel EU/t product in Rocket Engine.", "Default: 2048"})
        @RangeInt(min = 1, max = 8192)
        public int heatValueMethylhydrazineNitrateRocketFuel = 2048;

        @Comment({"Naquadah Fuels EU/t product in Naquadah Reactor.", "Default: 2048"})
        @RangeInt(min = 1, max = 2097152)
        public int heatValueNaquadahFuel = 2048;

        @Comment({"Taranium Fuels EU/t product in Naquadah Reactor.", "Default: 4096"})
        @RangeInt(min = 1, max = 2097152)
        public int heatValueTaraniumFuel = 4096;

        @Comment({"Enriched Taranium Fuels EU/t product in Naquadah Reactor.", "Default: 8192"})
        @RangeInt(min = 1, max = 2097152)
        public int heatValueEnrichedTaraniumFuel = 8192;

        @Comment({"Allow Gas Turbine use Naquadah Gas to product EU/t.", "Default: true"})
        public boolean enableNaquadahGasTurbineRecipe = true;

        @Comment({"Naquadah Gas EU/t product in Gas Turbine.", "Default: 32"})
        @RangeInt(min = 1, max = 2048)
        public int heatValueNaquadahGas = 32;

        @Comment({"Allow Gas Turbine use Exotic Gases to product EU/t.", "Default: true"})
        public boolean enableExoticGasTurbineRecipe = true;

        @Comment({"Exotic Gases EU/t product in Gas Turbine.", "Default: 1024"})
        @RangeInt(min = 1, max = 2048)
        public int heatValueExoticGas = 1024;

        @Comment({"Hyper Fuels EU/t product in Hyper Reactor Mark 1.", "Default: 32768"})
        @RangeInt(min = 1, max = 8388608)
        public int heatValueHyperFuelsMark1 = 32768;

        @Comment({"Hyper Fuels EU/t product in Hyper Reactor Mark 2.", "Default: 131072"})
        @RangeInt(min = 1, max = 33554432)
        public int heatValueHyperFuelsMark2 = 131072;

        @Comment({"Hyper Fuels EU/t product in Hyper Reactor Mark 3.", "Default: 524288"})
        @RangeInt(min = 1, max = 134217728)
        public int heatValueHyperFuelsMark3 = 524288;

        @Comment({"Hyper Fuel Mark 2 EU/t product in Hyper Reactor Mark 1.", "Default: 131072"})
        @RangeInt(min = 1, max = 8388608)
        public int heatValueHyperFuelMark2 = 131072;

        @Comment({"Hyper Fuel Mark 3 EU/t product in Hyper Reactor Mark 2.", "Default: 524288"})
        @RangeInt(min = 1, max = 33554432)
        public int heatValueHyperFuelMark3 = 524288;

        @Comment({"Hyper Fuel Mark 4 EU/t product in Hyper Reactor Mark 3.", "Default: 2097152"})
        @RangeInt(min = 1, max = 134217728)
        public int heatValueHyperFuelMark4 = 2097152;

        @Comment({"Biomass EU/t product in Biomass Generator.", "Default: 120"})
        @RangeInt(min = 1, max = 32768)
        public int heatValueBiomass = 120;

        @Comment({"Fermented Biomass EU/t product in Biomass Generator.", "Default: 120"})
        @RangeInt(min = 1, max = 32768)
        public int heatValueFermentedBiomass = 120;

        @Comment({"Bacterial Sludge EU/t product in Biomass Generator.", "Default: 480"})
        @RangeInt(min = 1, max = 32768)
        public int heatValueBacterialSludge = 480;

        @Comment({"Sterile Growth Medium EU/t product in Biomass Generator.", "Default: 1920"})
        @RangeInt(min = 1, max = 32768)
        public int heatValueSterileGrowthMedium = 1920;

        @Comment({"Mutagen EU/t product in Biomass Generator.", "Default: 480"})
        @RangeInt(min = 1, max = 32768)
        public int heatValueMutagen = 480;

        @Comment({"Exotic Mutagen EU/t product in Biomass Generator.", "Default: 1920"})
        @RangeInt(min = 1, max = 32768)
        public int heatValueExoticMutagen = 1920;

        @Comment({"Allow Bio Reactor use some GregTech vanilla recipes in Chemical Reactor.", "Default: true"})
        public boolean enableBioReactorVanillaRecipe = true;

        @Comment({"Allow Creative items (e.g. Creative Quantum Tank) be makable in Survival mode.", "Default: true"})
        public boolean enableCreativeRecipe = true;

        public MiscOptions() {}
    }

    public static class RecipeOptions {

        @Comment({"Enable magneto resonatic circuit and its recipes.", "Default: true"})
        public boolean enableMagnetoResonaticCircuit = true;

        @Comment({"Enable easier Processor Assembly recipes, now it products two per run.", "Default: true"})
        public boolean enableEasierProcessorAssembly = true;

        @Comment({"Enable harder Vacuum Tube recipes, requires Vacuum Chamber and more materials.", "Default: true"})
        public boolean enableHarderVacuumTube = true;

        @Comment({"Enable harder Crystal SoC recipes, requires Cubic Zirconium and more materials.", "Default: true"})
        public boolean enableHarderCrystalSoC = true;

        @Comment({"Enable harder Wetware Board recipes, requires Kapton-K.", "Default: true"})
        public boolean enableHarderWetwareBoard = true;

        @Comment({"Enable harder Platinum Group process.", "Default: true"})
        public boolean enableHarderPlatinumGroupProcess = true;

        @Comment({"Enable harder Rare Earth process.", "Default: true"})
        public boolean enableHarderRareEarthProcess = true;

        @Comment({"Enable harder Tungsten process.", "Default: true"})
        public boolean enableHarderTungstenProcess = true;

        @Comment({"Enable harder Molybdenum Rhenium process.", "Default: true"})
        public boolean enableHarderMolybdenumRheniumProcess = true;

        @Comment({"Enable harder Niobium Tantalum process.", "Default: true"})
        public boolean enableHarderNiobiumTantalumProcess = true;

        @Comment({"Enable harder Graphene process.", "Default: true"})
        public boolean enableHarderGrapheneProcess = true;

        @Comment({"Enable harder Ammonia process.", "Default: true"})
        public boolean enableHarderAmmoniaProcess = true;

        @Comment({"Enable easier Hydrogen Cyanide process.", "Default: true"})
        public boolean enableEasierHydrogenCyanideProcess = true;

        @Comment({"Enable harder Crucible recipes, requires Vacuum Chamber and some materials.", "Default: true"})
        public boolean enableHarderCrucible = true;

        public RecipeOptions() {}
    }

    public static class ToolOptions {

        @Comment({"Enable EV-tier Prospector.", "Default: true"})
        public boolean enableEVProspector = true;

        @Comment({"Enable ZPM-tier Prospector.", "Default: true"})
        public boolean enableZPMProspector = true;

        @Comment({"Enable high tier batteries (UHV-MAX).", "Default: true"})
        public boolean enableHighTierBattery = true;

        @Comment({"Enable more ultimate batteries (UEV-OpV).", "Default: true"})
        public boolean enableHighTierUltimateBattery = true;

        @Comment({"Enable high tier solar panels (UHV-MAX).", "Default: true"})
        public boolean enableHighTierSolarPanel = true;

        public ToolOptions() {}
    }
}
