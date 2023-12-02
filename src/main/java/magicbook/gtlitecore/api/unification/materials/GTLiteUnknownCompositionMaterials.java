package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.unification.material.Material;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class GTLiteUnknownCompositionMaterials {

    //  Range: 18000-20000
    private static int startId = 18000;
    private static final int endId = startId + 2000;

    public static void register() {
        //  18000 Fracturing Fluid
        FracuringFluid = new Material.Builder(getId(), gregtechId("fracturing_fluid"))
                .liquid()
                .color(0x96D6D5)
                .build();

        //  18001 Rare Earth Hydroxides Solution
        RareEarthHydroxidesSolution = new Material.Builder(getId(), gregtechId("rare_earth_hydroxides_solution"))
                .liquid()
                .color(0x434327)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Oxygen, 1, Hydrogen, 1, Water, 1)
                .build();

        //  18002 Rare Earth Chlorides Solution
        RareEarthChloridesSolution = new Material.Builder(getId(), gregtechId("rare_earth_chlorides_solution"))
                .liquid()
                .color(0x838367)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .build();

        //  18003 La-Pr-Nd-Ce Oxides Solution
        LaPrNdCeOxidesSolution = new Material.Builder(getId(), gregtechId("la_pr_nd_ce_oxides_solution"))
                .fluid()
                .color(0x9CE3DB)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(LanthanumOxide, 1, PraseodymiumOxide, 1, NeodymiumOxide, 1, CeriumOxide, 1)
                .build();

        //  18004 Sc-Eu-Gd-Sm Oxides Solution
        ScEuGdSmOxidesSolution = new Material.Builder(getId(), gregtechId("sc_eu_gd_sm_oxides_solution"))
                .fluid()
                .color(0xFFFF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ScandiumOxide, 1, EuropiumOxide, 1, GadoliniumOxide, 1, SamariumOxide, 1)
                .build();

        //  18005 Y-Tb-Dy-Ho Oxides Solution
        YTbDyHoOxidesSolution = new Material.Builder(getId(), gregtechId("y_tb_dy_ho_oxides_solution"))
                .fluid()
                .color(0x99FF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(YttriumOxide, 1, TerbiumOxide, 1, DysprosiumOxide, 1, HolmiumOxide, 1)
                .build();

        //  18006 Er-Tm-Yb-Lu Oxides Solution
        ErTmYbLuOxidesSolution = new Material.Builder(getId(), gregtechId("er_tm_yb_lu_oxides_solution"))
                .fluid()
                .color(0xFFB3FF)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ErbiumOxide, 1, ThuliumOxide, 1, YtterbiumOxide, 1, LutetiumOxide, 1)
                .build();
      
        //  18007 Bedrock
        Bedrock = new Material.Builder(getId(), gregtechId("bedrock"))
                .dust()
                .liquid()
                .color(0x404040)
                .iconSet(ROUGH)
                .build();

        //  18008 Bedrock Smoke
        BedrockSmoke = new Material.Builder(getId(), gregtechId("bedrock_smoke"))
                .gas()
                .color(0x525252)
                .build();

        //  18009 Bedrock Soot Solution
        BedrockSootSolution = new Material.Builder(getId(), gregtechId("bedrock_soot_solution"))
                .liquid()
                .color(0x1E2430)
                .build();

        //  18010 Clean Bedrock Solution
        CleanBedrockSolution = new Material.Builder(getId(), gregtechId("clean_bedrock_solution"))
                .liquid()
                .color(0xA89F9E)
                .build();

        //  18011 Heavy Bedrock Smoke
        HeavyBedrockSmoke = new Material.Builder(getId(), gregtechId("heavy_bedrock_smoke"))
                .gas()
                .color(0x242222)
                .build();

        //  18012 Medium Bedrock Smoke
        MediumBedrockSmoke = new Material.Builder(getId(), gregtechId("medium_bedrock_smoke"))
                .gas()
                .color(0x2E2C2C)
                .build();

        //  18013 Light Bedrock Smoke
        LightBedrockSmoke = new Material.Builder(getId(), gregtechId("light_bedrock_smoke"))
                .gas()
                .color(0x363333)
                .build();

        //  18014 Ultralight Bedrock Smoke
        UltralightBedrockSmoke = new Material.Builder(getId(), gregtechId("ultralight_bedrock_smoke"))
                .gas()
                .color(0x403D3D)
                .build();

        //  18015 Heavy Taranium Gas
        HeavyTaraniumGas = new Material.Builder(getId(), gregtechId("heavy_taranium_gas"))
                .gas()
                .color(0x262626)
                .build();

        //  18016 Medium Taranium Gas
        MediumTaraniumGas = new Material.Builder(getId(), gregtechId("medium_taranium_gas"))
                .gas()
                .color(0x313131)
                .build();

        //  18017 Light Taranium Gas
        LightTaraniumGas = new Material.Builder(getId(), gregtechId("light_taranium_gas"))
                .gas()
                .color(0x404040)
                .build();

        //  18018 Bedrock Gas
        BedrockGas = new Material.Builder(getId(), gregtechId("bedrock_gas"))
                .gas()
                .color(0x575757)
                .build();

        //  18019 Cracked Heavy Taranium
        CrackedHeavyTaranium = new Material.Builder(getId(), gregtechId("cracked_heavy_taranium"))
                .liquid()
                .color(0x1F2B2E)
                .build();

        //  18020 Cracked Medium Taranium
        CrackedMediumTaranium = new Material.Builder(getId(), gregtechId("cracked_medium_taranium"))
                .liquid()
                .color(0x29393D)
                .build();

        //  18021 Cracked Light Taranium
        CrackedLightTaranium = new Material.Builder(getId(), gregtechId("cracked_light_taranium"))
                .liquid()
                .color(0x374C52)
                .build();

        //  18022 Enriched Bedrock Soot Solution
        EnrichedBedrockSootSolution = new Material.Builder(getId(), gregtechId("enriched_bedrock_soot_solution"))
                .liquid()
                .color(0x280C26)
                .build();

        //  18023 Clean Enriched Bedrock Solution
        CleanEnrichedBedrockSolution = new Material.Builder(getId(), gregtechId("clean_enriched_bedrock_solution"))
                .liquid()
                .color(0x828C8C)
                .build();

        //  18024 Heavy Enriched Bedrock Smoke
        HeavyEnrichedBedrockSmoke = new Material.Builder(getId(), gregtechId("heavy_enriched_bedrock_smoke"))
                .gas()
                .color(0x1A2222)
                .build();

        //  18025 Medium Enriched Bedrock Smoke
        MediumEnrichedBedrockSmoke = new Material.Builder(getId(), gregtechId("medium_enriched_bedrock_smoke"))
                .gas()
                .color(0x1E2C2C)
                .build();

        //  18026 Light Enriched Bedrock Smoke
        LightEnrichedBedrockSmoke = new Material.Builder(getId(), gregtechId("light_enriched_bedrock_smoke"))
                .gas()
                .color(0x163333)
                .build();

        //  18027 Heavy Enriched Taranium Gas
        HeavyEnrichedTaraniumGas = new Material.Builder(getId(), gregtechId("heavy_enriched_taranium_gas"))
                .gas()
                .color(0x1F2626)
                .build();

        //  18028 Medium Enriched Taranium Gas
        MediumEnrichedTaraniumGas = new Material.Builder(getId(), gregtechId("medium_enriched_taranium_gas"))
                .gas()
                .color(0x1F3131)
                .build();

        //  18029 Light Enriched Taranium Gas
        LightEnrichedTaraniumGas = new Material.Builder(getId(), gregtechId("light_enriched_taranium_gas"))
                .gas()
                .color(0x1F4040)
                .build();

        //  18030 Cracked Heavy Enriched Taranium
        CrackedHeavyEnrichedTaranium = new Material.Builder(getId(), gregtechId("cracked_heavy_enriched_taranium"))
                .liquid()
                .color(0x2E1F2E)
                .build();

        //  18031 Cracked Medium Enriched Taranium
        CrackedMediumEnrichedTaranium = new Material.Builder(getId(), gregtechId("cracked_medium_enriched_taranium"))
                .liquid()
                .color(0x29393D)
                .build();

        //  18032 Cracked Light Enriched Taranium
        CrackedLightEnrichedTaranium = new Material.Builder(getId(), gregtechId("cracked_light_enriched_taranium"))
                .liquid()
                .color(0x374C52)
                .build();

        //  18033 Crude Naquadah Fuel
        CrudeNaquadahFuel = new Material.Builder(getId(), gregtechId("crude_naquadah_fuel"))
                .liquid()
                .color(0x077F4E)
                .iconSet(DULL)
                .build();

        //  18034 Heavy Naquadah Fuel
        HeavyNaquadahFuel = new Material.Builder(getId(), gregtechId("heavy_naquadah_fuel"))
                .liquid()
                .color(0x088C56)
                .build();

        //  18035 Medium Naquadah Fuel
        MediumNaquadahFuel = new Material.Builder(getId(), gregtechId("medium_naquadah_fuel"))
                .liquid()
                .color(0x09A566)
                .build();

        //  18036 Light Naquadah Fuel
        LightNaquadahFuel = new Material.Builder(getId(), gregtechId("light_naquadah_fuel"))
                .liquid()
                .color(0x0BBF75)
                .build();

        //  18037 Naquadah Gas
        NaquadahGas = new Material.Builder(getId(), gregtechId("naquadah_gas"))
                .gas()
                .color(0x0CD985)
                .build();

        //  18038 Energetic Naquadria
        EnergeticNaquadria = new Material.Builder(getId(), gregtechId("energetic_naquadria"))
                .liquid()
                .color(0x202020)
                .build()
                .setFormula("Nq?", false);

        //  18039 Heavy Hyper Fuel
        HeavyHyperFuel = new Material.Builder(getId(), gregtechId("heavy_hyper_fuel"))
                .liquid()
                .color(0x1E5064)
                .build();

        //  18040 Medium Hyper Fuel
        MediumHyperFuel = new Material.Builder(getId(), gregtechId("medium_hyper_fuel"))
                .liquid()
                .color(0xDC0A0A)
                .build();

        //  18041 Light Hyper Fuel
        LightHyperFuel = new Material.Builder(getId(), gregtechId("light_hyper_fuel"))
                .liquid()
                .color(0x8C148C)
                .build();

        //  18042 Almandine Front
        AlmandineFront = new Material.Builder(getId(), gregtechId("almandine_front"))
                .liquid()
                .color(Almandine.getMaterialRGB())
                .components(Almandine.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18043 Chalcopyrite Front
        ChalcopyriteFront = new Material.Builder(getId(), gregtechId("chalcopyrite_front"))
                .liquid()
                .color(Chalcopyrite.getMaterialRGB())
                .components(Chalcopyrite.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18044 Monazite Front
        MonaziteFront = new Material.Builder(getId(), gregtechId("monazite_front"))
                .liquid()
                .color(Monazite.getMaterialRGB())
                .components(Monazite.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18045 Grossular Front
        GrossularFront = new Material.Builder(getId(), gregtechId("grossular_front"))
                .liquid()
                .color(Grossular.getMaterialRGB())
                .components(Grossular.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18046 Nickel Front
        NickelFront = new Material.Builder(getId(), gregtechId("nickel_front"))
                .liquid()
                .color(Nickel.getMaterialRGB())
                .components(Nickel, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18047 Platinum Front
        PlatinumFront = new Material.Builder(getId(), gregtechId("platinum_front"))
                .liquid()
                .color(Platinum.getMaterialRGB())
                .components(Platinum, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18048 Pyrope Front
        PyropeFront = new Material.Builder(getId(), gregtechId("pyrope_front"))
                .liquid()
                .color(Pyrope.getMaterialRGB())
                .components(Pyrope.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18049 Redstone Front
        RedstoneFront = new Material.Builder(getId(), gregtechId("redstone_front"))
                .liquid()
                .color(Redstone.getMaterialRGB())
                .components(Redstone.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18050 Spessartine Front
        SpessartineFront = new Material.Builder(getId(), gregtechId("spessartine_front"))
                .liquid()
                .color(Spessartine.getMaterialRGB())
                .components(Spessartine.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18051 Sphalerite Front
        SphaleriteFront = new Material.Builder(getId(), gregtechId("sphalerite_front"))
                .liquid()
                .color(Sphalerite.getMaterialRGB())
                .components(Sphalerite.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18052 Pentlandite Front
        PentlanditeFront = new Material.Builder(getId(), gregtechId("pentlandite_front"))
                .liquid()
                .color(Pentlandite.getMaterialRGB())
                .components(Pentlandite.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18053 Blazing Pyrotheum
        BlazingPyrotheum = new Material.Builder(getId(), gregtechId("blazing_pyrotheum"))
                .liquid(new FluidBuilder().temperature(8000).customStill().customFlow())
                .components(Blaze, 2, Redstone, 1, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18054 Gelid Cryotheum
        GelidCryotheum = new Material.Builder(getId(), gregtechId("gelid_cryotheum"))
                .liquid(new FluidBuilder().temperature(8).customStill().customFlow())
                .color(0x40B8FB)
                .components(Ice, 2, Electrotine, 1, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18055 Rich Nitrogen Mixture
        RichNitrogenMixture = new Material.Builder(getId(), gregtechId("rich_nitrogen_mixture"))
                .gas()
                .color(0x6891D8)
                .build();

        //  18056 Rich Ammonia Mixture
        RichAmmoniaMixture = new Material.Builder(getId(), gregtechId("rich_ammonia_mixture"))
                .liquid()
                .color(0x708ACD)
                .build();

        //  18057 Iodized Brine
        IodizedBrine = new Material.Builder(getId(), gregtechId("iodized_brine"))
                .liquid()
                .color(0x525246)
                .build()
                .setFormula("I?", false);

        //  18058 Iodine Brine Mixture
        IodineBrineMixture = new Material.Builder(getId(), gregtechId("iodine_brine_mixture"))
                .liquid()
                .color(0x525234)
                .build()
                .setFormula("I?Cl", false);

        //  18059 Brominated Brine
        BrominatedBrine = new Material.Builder(getId(), gregtechId("brominated_brine"))
                .liquid()
                .color(0xA9A990)
                .build()
                .setFormula("Br?", false);

        //  24039 Iodine Slurry
        IodineSlurry = new Material.Builder(getId(), gregtechId("iodine_slurry"))
                .liquid()
                .color(0x292923)
                .build()
                .setFormula("I?", false);

        //  24040 Acidic Brominated Brine
        AcidicBrominatedBrine = new Material.Builder(getId(), gregtechId("acidic_brominated_brine"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0xC6A76F)
                .build()
                .setFormula("Br?(H2SO4)Cl", true);

        //  24041 Bromine Sulfate Solution
        BromineSulfateSolution = new Material.Builder(getId(), gregtechId("bromine_sulfate_solution"))
                .liquid()
                .color(0xCC9966)
                .build()
                .setFormula("H2SO4Br(H2O)Cl2", true);

        //  24042 Overheated Bromine Sulfate Gas
        OverheatedBromineSulfateSolution = new Material.Builder(getId(), gregtechId("overheated_bromine_sulfate_gas"))
                .gas()
                .color(0xC69337)
                .iconSet(DULL)
                .build()
                .setFormula("H2SO4Br(H2O)2Cl2", true);

        //  24043 Wet Bromine
        WetBromine = new Material.Builder(getId(), gregtechId("wet_bromine"))
                .gas()
                .color(0xDB5C5C)
                .iconSet(DULL)
                .build()
                .setFormula("Br(H2O)", true);

        //  24044 Debrominated Water
        DebrominatedWater = new Material.Builder(getId(), gregtechId("debrominated_water"))
                .liquid()
                .color(0x24A3A3)
                .components(Hydrogen, 2, Oxygen, 1)
                .build();

        //  24045 BZ Medium
        BZMedium = new Material.Builder(getId(), gregtechId("bz_medium"))
                .liquid()
                .color(10681653)
                .build();

        //  24046 EDP
        EDP = new Material.Builder(getId(), gregtechId("edp"))
                .liquid()
                .color(16514839)
                .build();

        //  24047 Sodio Indene
        SodioIndene = new Material.Builder(getId(), gregtechId("sodio_indene"))
                .liquid()
                .color(0x1D1C24)
                .build();

        //  24048 Steam Cracked Sodio Indene
        SteamCrackedSodioIndene = new Material.Builder(getId(), gregtechId("steam_cracked_sodio_indene"))
                .liquid(new FluidBuilder().temperature(1105))
                .color(0x1C1A29)
                .build();

        //  24049 MethylamineMixture
        MethylamineMixture = new Material.Builder(getId(), gregtechId("methylamine_mixture"))
                .liquid()
                .color(0xAA4400)
                .build();

        //  24050 Phosphorene Solution
        PhosphoreneSolution = new Material.Builder(getId(), gregtechId("phosphorene_solution"))
                .liquid()
                .color(0x465966)
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
