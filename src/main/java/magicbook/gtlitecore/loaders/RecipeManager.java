package magicbook.gtlitecore.loaders;

import magicbook.gtlitecore.loaders.blocks.Crucibles;
import magicbook.gtlitecore.loaders.blocks.WireCoils;
import magicbook.gtlitecore.loaders.chains.*;
import magicbook.gtlitecore.loaders.circuits.*;
import magicbook.gtlitecore.loaders.components.MachineComponents;
import magicbook.gtlitecore.loaders.multiblock.*;
import magicbook.gtlitecore.loaders.oreprocessing.*;

public class RecipeManager {

    private RecipeManager() {}

    public static void init() {
        initBlocks();
        MachineComponents.init();
        MaterialInfoLoader.init();
        MachineRecipeLoader.init();
        MiscRecipes.init();
        RecipeConflicts.init();
      
        initChains();
        initOreProcessings();
        initCircuits();
        initMultiRecipes();

        FusionLoader.init();
        OverrideRecipeLoader.init();
    }

    private static void initBlocks() {
        WireCoils.init();
        Crucibles.init();
    }

    private static void initChains() {
        AcetyleneChain.init();
        AmmoniaChain.init();
        BoronNitrideChain.init();
        BrineChain.init();
        BPAPolycarbonateChain.init();
        BZMediumChain.init();
        CBDOPolycarbonateChain.init();
        ChlorineChain.init();
        CyanogenChain.init();
        DimethylformamideChain.init();
        DragonChain.init();
        EDTAChain.init();
        EtchingMaterialsChain.init();
        EthyleneGlycolChain.init();
        FEPChain.init();
        FullereneChain.init();
        GalliumNitrideChain.init();
        GrapheneChain.init();
        HydrogenPeroxideChain.init();
        //  TODO IsotopesChain.init();
        KaptonChain.init();
        KevlarChain.init();
        MagneticsChain.init();
        MagnetoResonaticChain.init();
        MethylamineChain.init();
        NanotubesChain.init();
        NdYAGChain.init();
        OilChain.init();
        PEDOTChain.init();
        PEEKChain.init();
        PhosphorusChain.init();
        PhotoresistivesChain.init();
        PMMAChain.init();
        PowerIntCircuitChain.init();
        RocketFuelChain.init();
        RubberChain.init();
        SeleniumTelluriumChain.init();
        TurpentineChain.init();
        ZirconiumChain.init();
        ZylonChain.init();
    }

    private static void initOreProcessings() {
        GermaniumProcessing.init();
        IsaMillOreProcessing.init();
        MolybdenumProcessing.init();
        NiobiumTantalumProcessing.init();
        PlatinumGroupProcessing.init();
        RareEarthProcessing.init();
        RubidiumProcessing.init();
        TaraniumProcessing.init();
        ThalliumProcessing.init();
        TungstenProcessing.init();
        VanadiumProcessing.init();
    }
  
    private static void initCircuits() {
        ProcessorCircuits.init();
        NanoCircuits.init();
        QuantumCircuits.init();
        CrystalCircuits.init();
        WetwareCircuits.init();
        GoowareCircuits.init();
        OpticalCircuits.init();
    }

    private static void initMultiRecipes() {
        ComponentAssembler.init();
        ComponentAssemblyLine.init();
        DroneAirport.init();
        TreeGrowthFactory.init();
        Collider.init();
        DecayGenerator.init();
        PlasmaCondenser.init();
        SuprachronalAssemblyLine.init();
        SpaceElevator.init();
        MolecularTransformer.init();
    }
}