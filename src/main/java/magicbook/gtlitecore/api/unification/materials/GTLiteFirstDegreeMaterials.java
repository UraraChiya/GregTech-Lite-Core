package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.properties.ToolProperty;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialFlags.DISABLE_CRYSTALLIZATION;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialIconSet.REAGENT;

/**
 * First Degree Materials
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is a part of {@code Material} class.
 * </p>
 *
 * @since 2.8.7-beta
 */
public class GTLiteFirstDegreeMaterials {

    //  Range: 11001-12000
    private static int startId = 11001;
    private static final int endId = startId + 999;

    public static void register() {

        //  11001 Platinum Group Residue
        PlatinumGroupResidue = new Material.Builder(getId(), gregtechId("platinum_group_residue"))
                .dust()
                .color(0x64632E)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iridium, 1, Osmium, 1, Rhodium, 1, Ruthenium, 1, RareEarth, 1)
                .build()
                .setFormula("RuRhIr2Os(HNO3)3", true);

        //  11002 Platinum Group Concentrate
        PlatinumGroupConcentrate = new Material.Builder(getId(), gregtechId("platinum_group_concentrate"))
                .liquid()
                .color(0xFFFFA6)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gold, 1, Platinum, 1, Palladium, 1, HydrochloricAcid, 6)
                .build()
                .setFormula("AuPtPd(HCl)6", true);

        //  11003 Purified Platinum Group Concentrate
        PurifiedPlatinumGroupConcentrate = new Material.Builder(getId(), gregtechId("purified_platinum_group_concentrate"))
                .liquid()
                .color(0xFFFFC8)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Platinum, 1, Palladium, 1, Chlorine, 6)
                .build()
                .setFormula("H2PtPdCl6", true);

        //  11004 Ammonium Hexachloroplatinate
        AmmoniumHexachloroplatinate = new Material.Builder(getId(), gregtechId("ammonium_hexachloroplatinate"))
                .liquid()
                .color(0xFEF0C2)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 8, Platinum, 1, Chlorine, 6)
                .build()
                .setFormula("(NH4)2PtCl6", true);

        //  11005 Ammonium Hexachloropalladate
        AmmoniumHexachloropalladate = new Material.Builder(getId(), gregtechId("ammonium_hexachloropalladate"))
                .liquid()
                .color(0x808080)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 8, Palladium, 1, Chlorine, 6)
                .build()
                .setFormula("(NH4)2PdCl6", true);

        //  11006 Sodium Nitrate
        SodiumNitrate = new Material.Builder(getId(), gregtechId("sodium_nitrate"))
                .dust()
                .color(0x846684)
                .iconSet(ROUGH)
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 3)
                .build();

        //  11007 Hexachloroplatinic Acid
        HexachloroplatinicAcid = new Material.Builder(getId(), gregtechId("hexachloroplatinic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xFEF4D1)
                .components(Hydrogen, 2, Platinum, 1, Chlorine, 6)
                .build();

        //  11008 Carbon Tetrachloride
        CarbonTetrachloride = new Material.Builder(getId(), gregtechId("carbon_tetrachloride"))
                .liquid()
                .color(0x75201A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 1, Chlorine, 4)
                .build();

        //  11009 Ruthenium Chloride
        RutheniumChloride = new Material.Builder(getId(), gregtechId("ruthenium_chloride"))
                .dust()
                .color(0x605C6C)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Ruthenium, 1, Chlorine, 3)
                .build();

        //  11010 Sodium Peroxide
        SodiumPeroxide = new Material.Builder(getId(), gregtechId("sodium_peroxide"))
                .dust()
                .color(0xECFF80)
                .iconSet(ROUGH)
                .components(Sodium, 2, Oxygen, 2)
                .build();

        //  11011 Rhodium Oxide
        RhodiumOxide = new Material.Builder(getId(), gregtechId("rhodium_oxide"))
                .dust()
                .color(0xD93D16)
                .iconSet(METALLIC)
                .components(Rhodium, 2, Oxygen, 3)
                .build();

        //  11012 Sulfur Dichloride
        SulfurDichloride = new Material.Builder(getId(), gregtechId("sulfur_dichloride"))
                .liquid()
                .color(0x761410)
                .components(Sulfur, 1, Chlorine, 2)
                .build();

        //  11013 Thionyl Chloride
        ThionylChloride = new Material.Builder(getId(), gregtechId("thionyl_chloride"))
                .liquid()
                .color(0xEBE863)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sulfur, 1, Oxygen, 1, Chlorine, 2)
                .build();

        //  11014 Osmium Tetrachloride
        OsmiumTetrachloride = new Material.Builder(getId(), gregtechId("osmium_tetrachloride"))
                .dust()
                .color(0x29080A)
                .iconSet(METALLIC)
                .components(Osmium, 1, Chlorine, 4)
                .build();

        //  11015 Lanthanum Oxide
        LanthanumOxide = new Material.Builder(getId(), gregtechId("lanthanum_oxide"))
                .dust()
                .color(0x5F7777)
                .iconSet(SHINY)
                .components(Lanthanum, 2, Oxygen, 3)
                .build();

        //  11016 Cerium Oxide
        CeriumOxide = new Material.Builder(getId(), gregtechId("cerium_oxide"))
                .dust()
                .color(0x10937F)
                .iconSet(METALLIC)
                .components(Cerium, 1, Oxygen, 2)
                .build();

        //  11017 Praseodymium Oxide
        PraseodymiumOxide = new Material.Builder(getId(), gregtechId("praseodymium_oxide"))
                .dust()
                .color(0xD0D0D0)
                .iconSet(METALLIC)
                .components(Praseodymium, 2, Oxygen, 3)
                .build();

        //  11018 Neodymium Oxide
        NeodymiumOxide = new Material.Builder(getId(), gregtechId("neodymium_oxide"))
                .dust()
                .color(0x868686)
                .components(Neodymium, 2, Oxygen, 3)
                .build();
        //  11019 Samarium Oxide
        SamariumOxide = new Material.Builder(getId(), gregtechId("samarium_oxide"))
                .dust()
                .color(0xFFFFDD)
                .components(Samarium, 2, Oxygen, 3)
                .build();
        //  11020 Europium Oxide
        EuropiumOxide = new Material.Builder(getId(), gregtechId("europium_oxide"))
                .dust()
                .color(0x20AAAA)
                .iconSet(SHINY)
                .components(Europium, 2, Oxygen, 3)
                .build();
        //  11021 Gadolinium Oxide
        GadoliniumOxide = new Material.Builder(getId(), gregtechId("gadolinium_oxide"))
                .dust()
                .color(0xEEEEFF)
                .iconSet(METALLIC)
                .components(Gadolinium, 2, Oxygen, 3)
                .build();
        //  11022 Terbium Oxide
        TerbiumOxide = new Material.Builder(getId(), gregtechId("terbium_oxide"))
                .dust()
                .color(0xA264A2)
                .iconSet(METALLIC)
                .components(Terbium, 2, Oxygen, 3)
                .build();

        //  11023 Dysprosium Oxide
        DysprosiumOxide = new Material.Builder(getId(), gregtechId("dysprosium_oxide"))
                .dust()
                .color(0xD273D2)
                .iconSet(METALLIC)
                .components(Dysprosium, 2, Oxygen, 3)
                .build();

        //  11024 Holmium Oxide
        HolmiumOxide = new Material.Builder(getId(), gregtechId("holmium_oxide"))
                .dust()
                .color(0xAF7F2A)
                .iconSet(SHINY)
                .components(Holmium, 2, Oxygen, 3)
                .build();

        //  11025 Erbium Oxide
        ErbiumOxide = new Material.Builder(getId(), gregtechId("erbium_oxide"))
                .dust()
                .color(0xE07A32)
                .iconSet(METALLIC)
                .components(Erbium, 2, Oxygen, 3)
                .build();

        //  11026 Thulium Oxide
        ThuliumOxide = new Material.Builder(getId(), gregtechId("thulium_oxide"))
                .dust()
                .color(0x3B9E8B)
                .components(Thulium, 2, Oxygen, 3)
                .build();

        //  11027 Ytterbium Oxide
        YtterbiumOxide = new Material.Builder(getId(), gregtechId("ytterbium_oxide"))
                .dust()
                .color(0xA9A9A9)
                .components(Ytterbium, 2, Oxygen, 3)
                .build();

        //  11028 Lutetium Oxide
        LutetiumOxide = new Material.Builder(getId(), gregtechId("lutetium_oxide"))
                .dust()
                .color(0x11BBFF)
                .iconSet(METALLIC)
                .components(Lutetium, 2, Oxygen, 3)
                .build();

        //  11029 Scandium Oxide
        ScandiumOxide = new Material.Builder(getId(), gregtechId("scandium_oxide"))
                .dust()
                .color(0x43964F)
                .iconSet(METALLIC)
                .components(Scandium, 2, Oxygen, 3)
                .build();

        //  11030 Yttrium Oxide
        YttriumOxide = new Material.Builder(getId(), gregtechId("yttrium_oxide"))
                .dust()
                .color(0x78544E)
                .iconSet(SHINY)
                .components(Yttrium, 2, Oxygen, 3)
                .build();

        //  11031 Ammonium Nitrate
        AmmoniumNitrate = new Material.Builder(getId(), gregtechId("ammonium_nitrate"))
                .dust()
                .liquid()
                .color(0xA59ED7)
                .iconSet(METALLIC)
                .components(Ammonia, 1, NitricAcid, 1)
                .build()
                .setFormula("NH4NO3", true);

        //  11032 Heavy Taranium Fuel
        HeavyTaraniumFuel = new Material.Builder(getId(), gregtechId("heavy_taranium_fuel"))
                .liquid()
                .color(0x141414)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        //  11033 Medium Taranium Fuel
        MediumTaraniumFuel = new Material.Builder(getId(), gregtechId("medium_taranium_fuel"))
                .liquid()
                .color(0x181818)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        //  11034 Light Taranium Fuel
        LightTaraniumFuel = new Material.Builder(getId(), gregtechId("light_taranium_fuel"))
                .liquid()
                .color(0x1C1C1C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        //  11035 Heavy Enriched Taranium Fuel
        HeavyEnrichedTaraniumFuel = new Material.Builder(getId(), gregtechId("heavy_enriched_taranium_fuel"))
                .liquid()
                .color(0x0F1414)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        //  11036 Medium Enriched Taranium Fuel
        MediumEnrichedTaraniumFuel = new Material.Builder(getId(), gregtechId("medium_enriched_taranium_fuel"))
                .liquid()
                .color(0x0F1818)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        //  11037 Light Enriched Taranium Fuel
        LightEnrichedTaraniumFuel = new Material.Builder(getId(), gregtechId("light_enriched_taranium_fuel"))
                .liquid()
                .color(0x0F1C1C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        //  11038 Orichalcum Energized
        OrichalcumEnergized = new Material.Builder(getId(), gregtechId("orichalcum_energized"))
                .dust()
                .color(0xF4FC0C)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Orichalcum, 1)
                .build();

        //  11039 Adamantite
        Adamantite = new Material.Builder(getId(), gregtechId("adamantite"))
                .dust()
                .color(0xC83C3C)
                .iconSet(ROUGH)
                .components(Adamantium, 3, Oxygen, 4)
                .build();

        //  11040 Adamantium Unstable
        AdamantiumUnstable = new Material.Builder(getId(), gregtechId("adamantium_unstable"))
                .liquid()
                .color(0xFF763C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Adamantium, 1)
                .build();

        //  11041 Adamantium Enriched
        AdamantiumEnriched = new Material.Builder(getId(), gregtechId("adamantium_enriched"))
                .dust()
                .color(0x64B4FF)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vibranium, 1, RareEarth, 1)
                .build();

        //  11042 Vibranium Unstable
        VibraniumUnstable = new Material.Builder(getId(), gregtechId("vibranium_unstable"))
                .liquid()
                .color(0xFF7832)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vibranium, 1)
                .build();

        //  11043 Deep Iron
        DeepIron = new Material.Builder(getId(), gregtechId("deep_iron"))
                .dust()
                .color(0x968C8C)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iron, 2, Trinium, 1, Indium, 1)
                .build();

        //  11044 Sodium Ethylate
        SodiumEthylate = new Material.Builder(getId(), gregtechId("sodium_ethylate"))
                .dust()
                .color(0xD0FC8F)
                .iconSet(DULL)
                .components(Carbon, 2, Hydrogen, 5, Oxygen, 1, Sodium, 1)
                .build();

        //  11045 Potassium Ethylate
        PotassiumEthylate = new Material.Builder(getId(), gregtechId("potassium_ethylate"))
                .dust()
                .liquid()
                .color(0xFBC47D)
                .iconSet(DULL)
                .components(Carbon, 2, Hydrogen, 5, Oxygen, 1, Potassium, 1)
                .build();

        //  11046 Calcium Carbonate
        CalciumCarbonate = new Material.Builder(getId(), gregtechId("calcium_carbonate"))
                .dust()
                .color(0xE8E8CB)
                .iconSet(ROUGH)
                .components(Calcium, 1, Carbon, 1, Oxygen, 3)
                .build();

        //  11047 Carbon Disulfide
        CarbonDisulfide = new Material.Builder(getId(), gregtechId("carbon_disulfide"))
                .fluid()
                .color(0x1F80C8)
                .components(Carbon, 1, Sulfur, 2)
                .build();

        //  11048 Sodium Ethylxanthate
        SodiumEthylxanthate = new Material.Builder(getId(), gregtechId("sodium_ethylxanthate"))
                .dust()
                .color(0xF3F311)
                .iconSet(REAGENT)
                .components(Carbon, 3, Hydrogen, 5, Sodium, 1, Oxygen, 1, Sulfur, 2)
                .build();

        //  11049 Potassium Ethylxanthate
        PotassiumEthylxanthate = new Material.Builder(getId(), gregtechId("potassium_ethylxanthate"))
                .dust()
                .color(0xB9AD83)
                .iconSet(REAGENT)
                .components(Carbon, 3, Hydrogen, 5, Potassium, 1, Oxygen, 1, Sulfur, 2)
                .build();

        //  11050 Calcium Carbide
        CalciumCarbide = new Material.Builder(getId(), gregtechId("calcium_carbide"))
                .dust()
                .color(0x807B70)
                .iconSet(DULL)
                .components(Calcium, 1, Carbon, 2)
                .build();

        //  11051 Calcium Hydroxide
        CalciumHydroxide = new Material.Builder(getId(), gregtechId("calcium_hydroxide"))
                .dust()
                .color(0x5F8764)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Calcium, 1, Hydrogen, 2, Oxygen, 2)
                .build()
                .setFormula("Ca(OH)2", true);

        //  11052 Boric Acid
        BoricAcid = new Material.Builder(getId(), gregtechId("boric_acid"))
                .dust()
                .liquid()
                .color(0xFAFAFA)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 3, Boron, 1, Oxygen, 3)
                .build();

        //  11053 Boron Trioxide
        BoronTrioxide = new Material.Builder(getId(), gregtechId("boron_trioxide"))
                .dust()
                .color(0xE9FAC0)
                .iconSet(METALLIC)
                .components(Boron, 2, Oxygen, 3)
                .build();

        //  11054 Boron Trifluoride
        BoronTrifluoride = new Material.Builder(getId(), gregtechId("boron_trifluoride"))
                .gas()
                .color(0xFAF191)
                .components(Boron, 1, Fluorine, 3)
                .build();

        //  11055 Lithium Hydride
        LithiumHydride = new Material.Builder(getId(), gregtechId("lithium_hydride"))
                .ingot()
                .color(0x9BAFDB)
                .iconSet(METALLIC)
                .components(Lithium, 1, Hydrogen, 1)
                .build();

        //  11056 Lithium Tetrafluoroborate
        LithiumTetrafluoroborate = new Material.Builder(getId(), gregtechId("lithium_tetrafluoroborate"))
                .dust()
                .color(0x90FAF6)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Lithium, 1, Boron, 1, Fluorine, 4)
                .build();

        //  11057 Diborane
        Diborane = new Material.Builder(getId(), gregtechId("diborane"))
                .gas()
                .color(0x3F3131)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 2, Hydrogen, 6)
                .build();

        //  11058 Borazine
        Borazine = new Material.Builder(getId(), gregtechId("borazine"))
                .liquid()
                .color(0x542828)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 3, Hydrogen, 6, Nitrogen, 3)
                .build();

        //  11059 Boron Trichloride
        BoronTrichloride = new Material.Builder(getId(), gregtechId("boron_trichloride"))
                .gas()
                .color(0x033F1B)
                .components(Boron, 1, Chlorine, 3)
                .build();

        //  11060 Trichloroborazine
        Trichloroborazine = new Material.Builder(getId(), gregtechId("trichloroborazine"))
                .liquid()
                .color(0xD62929)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 3, Chlorine, 3, Hydrogen, 3, Nitrogen, 3)
                .build();

        //  11061 Hexagonal Boron Nitride
        HexagonalBoronNitride = new Material.Builder(getId(), gregtechId("hexagonal_boron_nitride"))
                .gem()
                .color(0x6A6A72)
                .iconSet(GEM_VERTICAL)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Nitrogen, 1)
                .build()
                .setFormula("h-BN", true);

        //  11062 Cubic Boron Nitride
        CubicBoronNitride = new Material.Builder(getId(), gregtechId("cubic_boron_nitride"))
                .gem()
                .color(0x545572)
                .iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, DISABLE_DECOMPOSITION, DISABLE_CRYSTALLIZATION, FLAMMABLE, EXPLOSIVE)
                .components(Boron, 1, Nitrogen, 1)
                .toolStats(new ToolProperty(14.0F, 9.0F, 12400, 15))
                .build()
                .setFormula("c-BN", true);

        //  11063 Amorphous Boron Nitride
        AmorphousBoronNitride = new Material.Builder(getId(), gregtechId("amorphous_boron_nitride"))
                .ingot()
                .color(0x9193C5)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING)
                .components(Boron, 1, Nitrogen, 1)
                .build()
                .setFormula("a-BN", true);

        //  11064 Heterodiamond
        Heterodiamond = new Material.Builder(getId(), gregtechId("heterodiamond"))
                .gem()
                .color(0x512A72)
                .iconSet(GEM_HORIZONTAL)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Carbon, 1, Nitrogen, 1)
                .build();

        //  11065 Cubic Heterodiamond
        CubicHeterodiamond = new Material.Builder(getId(), gregtechId("cubic_heterodiamond"))
                .gem()
                .color(0x753DA6)
                .iconSet(DIAMOND)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Carbon, 2, Nitrogen, 1)
                .build()
                .setFormula("c-BC2N", true);

        //  11066 Hydrobromic Acid
        HydrobromicAcid = new Material.Builder(getId(), gregtechId("hydrobromic_acid"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0x8D1212)
                .components(Hydrogen, 1, Bromine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11067 Potassium Hydroxide
        PotassiumHydroxide = new Material.Builder(getId(), gregtechId("potassium_hydroxide"))
                .dust()
                .liquid(new FluidBuilder().temperature(633))
                .color(0xFA9849)
                .flags(DISABLE_DECOMPOSITION)
                .components(Potassium, 1, Oxygen, 1, Hydrogen, 1)
                .build();

        //  11068 Potassium Bromate
        PotassiumBromate = new Material.Builder(getId(), gregtechId("potassium_bromate"))
                .dust()
                .color(0x782828)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(ROUGH)
                .components(Potassium, 1, Bromine, 1, Oxygen, 3)
                .build();

        //  11069 Potassium Formate
        PotassiumFormate = new Material.Builder(getId(), gregtechId("potassium_formate"))
                .dust()
                .color(0x74B5A9)
                .iconSet(DULL)
                .components(Carbon, 1, Hydrogen, 3, Oxygen, 1, Potassium, 1)
                .build();

        //  11070 Copper Chloride
        CopperChloride = new Material.Builder(getId(), gregtechId("copper_chloride"))
                .dust()
                .color(0x3FB3B8)
                .iconSet(ROUGH)
                .components(Copper, 1, Chlorine, 2)
                .build();

        //  11071 Palladium Nitrate
        PalladiumNitrate = new Material.Builder(getId(), gregtechId("palladium_nitrate"))
                .dust()
                .color(0x82312A)
                .iconSet(METALLIC)
                .components(Palladium, 1, Nitrogen, 2, Oxygen, 6)
                .build()
                .setFormula("Pd(NO3)2", true);

        //  11072 Fullerene
        Fullerene = new Material.Builder(getId(), gregtechId("fullerene"))
                .ingot()
                .color(0x72556A)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL, GENERATE_ROD, GENERATE_RING, GENERATE_FRAME, GENERATE_FINE_WIRE)
                .components(Carbon, 60)
                .build();

        //  11073 Trimethylaluminium
        Trimethylaluminium = new Material.Builder(getId(), gregtechId("trimethylaluminium"))
                .liquid()
                .color(0x6ECCFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 2, Carbon, 6, Hydrogen, 18)
                .build()
                .setFormula("Al2(CH3)6", true);

        //  11074 Gallium Trichloride
        GalliumTrichloride = new Material.Builder(getId(), gregtechId("gallium_trichloride"))
                .dust()
                .color(0x6EB4FF)
                .iconSet(ROUGH)
                .components(Gallium, 1, Chlorine, 3)
                .build();

        //  11075 Aluminium Trichloride
        AluminiumTrichloride = new Material.Builder(getId(), gregtechId("aluminium_trichloride"))
                .dust()
                .color(0x78C3EB)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 1, Chlorine, 3)
                .build();

        //  11076 Trimethylgallium
        Trimethylgallium = new Material.Builder(getId(), gregtechId("trimethylgallium"))
                .liquid()
                .color(0x4F92FF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, Carbon, 3, Hydrogen, 9)
                .build()
                .setFormula("Ga(CH3)3", true);

        //  11077 Aluminium Hydroxide
        AluminiumHydroxide = new Material.Builder(getId(), gregtechId("aluminium_hydroxide"))
                .dust()
                .color(0xBEBEC8)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 1, Oxygen, 3, Hydrogen, 3)
                .build()
                .setFormula("Al(OH)3", true);

        //  11078 Alumina
        Alumina = new Material.Builder(getId(), gregtechId("alumina"))
                .dust()
                .color(0x78c3eb)
                .iconSet(METALLIC)
                .components(Aluminium, 2, Oxygen, 3)
                .build();

        //  11079 Gallium Trioxide
        GalliumTrioxide = new Material.Builder(getId(), gregtechId("gallium_trioxide"))
                .dust()
                .liquid(new FluidBuilder().temperature(2170))
                .color(0xE4CDFF)
                .iconSet(METALLIC)
                .components(Gallium, 1, Oxygen, 3)
                .build();

        //  11080 Gallium Nitride
        GalliumNitride = new Material.Builder(getId(), gregtechId("gallium_nitride"))
                .ingot()
                .color(0xFFF458)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE)
                .components(Gallium, 1, Nitrogen, 1)
                .build();

        //  11081 Beryllium Oxide
        BerylliumOxide = new Material.Builder(getId(), gregtechId("beryllium_oxide"))
                .ingot()
                .color(0x54C757)
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Beryllium, 1, Oxygen, 1)
                .build();

        //  11082 Graphene Oxide
        GrapheneOxide = new Material.Builder(getId(), gregtechId("graphene_oxide"))
                .dust()
                .color(0x777777)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Graphene, 1, Oxygen, 1)
                .build();

        //  11083 Carbon Nanotube
        CarbonNanotube = new Material.Builder(getId(), gregtechId("carbon_nanotube"))
                .ingot()
                .liquid()
                .color(0x05090C)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_FINE_WIRE, GENERATE_SPRING)
                .cableProperties(V[UEV], 8, 6, false)
                .components(Carbon, 48)
                .build()
                .setFormula("CNT", false);

        //  11084 Silver Chloride
        SilverChloride = new Material.Builder(getId(), gregtechId("silver_chloride"))
                .dust()
                .color(0x8D8D8D)
                .iconSet(METALLIC)
                .components(Silver, 1, Chlorine, 1)
                .build();

        //  11085 Silver Oxide
        SilverOxide = new Material.Builder(getId(), gregtechId("silver_oxide"))
                .dust()
                .color(0xA4A4A4)
                .components(Silver, 2, Oxygen, 1)
                .build();

        //  11086 Silver Tetrafluoroborate
        SilverTetrafluoroborate = new Material.Builder(getId(), gregtechId("silver_tetrafluoroborate"))
                .liquid()
                .color(0x818024)
                .flags(DISABLE_DECOMPOSITION)
                .components(Silver, 1, Boron, 1, Fluorine, 4)
                .build()
                .setFormula("AgBF4", true);

        //  11087 Tin Chloride
        TinChloride = new Material.Builder(getId(), gregtechId("tin_chloride"))
                .dust()
                .liquid()
                .color(0xDBDBDB)
                .iconSet(METALLIC)
                .components(Tin, 1, Chlorine, 2)
                .build();

        //  11088 Trimethyltin Chloride
        TrimethyltinChloride = new Material.Builder(getId(), gregtechId("trimethyltin_chloride"))
                .liquid()
                .color(0x7F776F)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 6, Tin, 1, Chlorine, 1)
                .build()
                .setFormula("(CH3)3SnCl", true);

        //  11089 Potassium Tetrachloroplatinate
        PotassiumTetrachloroplatinate = new Material.Builder(getId(), gregtechId("potassium_tetrachloroplatinate"))
                .dust()
                .color(0xF1B04F)
                .iconSet(SHINY)
                .components(Potassium, 2, Platinum, 1, Chlorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("K2PtCl4", true);

        //  11090 Ammonium Sulfate
        AmmoniumSulfate = new Material.Builder(getId(), gregtechId("ammonium_sulfate"))
                .liquid()
                .color(0x5858F4)
                .components(Nitrogen, 4, Hydrogen, 8, Sulfur, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(NH2)4SO4", true);

        //  11091 Ammonium Persulfate
        AmmoniumPersulfate = new Material.Builder(getId(), gregtechId("ammonium_persulfate"))
                .liquid()
                .color(0x4242B7)
                .components(Nitrogen, 2, Hydrogen, 8, Sulfur, 2, Oxygen, 8)
                .build()
                .setFormula("(NH4)2S2O8", true);

        //  11092 White Phosphorus
        WhitePhosphorus = new Material.Builder(getId(), gregtechId("white_phosphorus"))
                .gem()
                .color(0xECEADD)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        //  11093 Red Phosphorus
        RedPhosphorus = new Material.Builder(getId(), gregtechId("red_phosphorus"))
                .gem()
                .color(0x77040E)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        //  11094 Violet Phosphorus
        VioletPhosphorus = new Material.Builder(getId(), gregtechId("violet_phosphorus"))
                .gem()
                .color(0x8000FF)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        //  11095 Black Phosphorus
        BlackPhosphorus = new Material.Builder(getId(), gregtechId("black_phosphorus"))
                .gem()
                .color(0x36454F)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        //  11096 Blue Phosphorus
        BluePhosphorus = new Material.Builder(getId(), gregtechId("blue_phosphorus"))
                .gem()
                .color(0x9BE3E4)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        //  11097 Wollastonite
        Wollastonite = new Material.Builder(getId(), gregtechId("wollastonite"))
                .dust()
                .color(0xF0F0F0)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(Quicklime, 2, SiliconDioxide, 3)
                .build()
                .setFormula("CaSiO3", true);

        //  11098 Phosphorene
        Phosphorene = new Material.Builder(getId(), gregtechId("phosphorene"))
                .ingot()
                .color(0x273239)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FOIL)
                .components(Phosphorus, 4)
                .build();

        //  11099 Phosphorus Trichloride
        PhosphorusTrichloride = new Material.Builder(getId(), gregtechId("phosphorus_trichloride"))
                .liquid()
                .color(0xD8D85B)
                .components(Phosphorus, 1, Chlorine, 3)
                .build();

        //  11100 Phosphoryl Chloride
        PhosphorylChloride = new Material.Builder(getId(), gregtechId("phosphoryl_chloride"))
                .liquid()
                .color(0xE8BB5B)
                .components(Phosphorus, 1, Oxygen, 1, Chlorine, 3)
                .build();

        //  11101 Phosphine
        Phosphine = new Material.Builder(getId(), gregtechId("phosphine"))
                .gas()
                .color(0xACB330)
                .flags(DECOMPOSITION_BY_ELECTROLYZING, FLAMMABLE)
                .components(Phosphorus, 1, Hydrogen, 3)
                .build();

        //  11102 Cubic Zirconia
        CubicZirconia = new Material.Builder(getId(), gregtechId("cubic_zirconia"))
                .gem()
                .color(0xFFDFE2)
                .iconSet(DIAMOND)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zirconium, 1, Oxygen, 2)
                .build()
                .setFormula("c-ZrO2", true);

        //  11103 Sodium Fluoride
        SodiumFluoride = new Material.Builder(getId(), gregtechId("sodium_fluoride"))
                .dust()
                .color(0x460012)
                .iconSet(DULL)
                .components(Sodium, 1, Fluorine, 1)
                .build();

        //  11104 Sodium Trifluoroethanolate
        SodiumTrifluoroethanolate = new Material.Builder(getId(), gregtechId("sodium_trifluoroethanolate"))
                .dust()
                .color(0x50083E)
                .iconSet(ROUGH)
                .components(Sodium, 1, Carbon, 2, Hydrogen, 4, Oxygen, 1, Fluorine, 3)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11105 Chromium Germanium Telluride
        ChromiumGermaniumTelluride = new Material.Builder(getId(), gregtechId("chromium_germanium_telluride"))
                .ingot()
                .fluid()
                .color(0x8F103E)
                .iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Chrome, 1, Germanium, 1, Tellurium, 3)
                .blast(b -> b
                        .temp(2900, BlastProperty.GasTier.HIGHER))
                .build();

        //  11106 Magnetic Chromium Germanium Telluride
        ChromiumGermaniumTellurideMagnetic = new Material.Builder(getId(), gregtechId("magnetic_chromium_germanium_telluride"))
                .ingot()
                .color(0x8F103E)
                .iconSet(MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, IS_MAGNETIC)
                .components(ChromiumGermaniumTelluride, 1)
                .ingotSmeltInto(ChromiumGermaniumTelluride)
                .arcSmeltInto(ChromiumGermaniumTelluride)
                .macerateInto(ChromiumGermaniumTelluride)
                .build();

        ChromiumGermaniumTelluride.getProperty(PropertyKey.INGOT).setMagneticMaterial(ChromiumGermaniumTellurideMagnetic);

        //  11107 Sodium Tellurite
        SodiumTellurite = new Material.Builder(getId(), gregtechId("sodium_tellurite"))
                .dust()
                .color(0xC6C9BE)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 2, Tellurium, 1, Oxygen, 3)
                .build();

        //  11108 Selenium Dioxide
        SeleniumDioxide = new Material.Builder(getId(), gregtechId("selenium_dioxide"))
                .dust()
                .color(0xE0DDD8)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Selenium, 1, Oxygen, 2)
                .build();

        //  11109 Tellurium Dioxide
        TelluriumDioxide = new Material.Builder(getId(), gregtechId("tellurium_dioxide"))
                .dust()
                .color(0xE3DDB8)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Tellurium, 1, Oxygen, 2)
                .build();

        //  11110 Selenous Acid
        SelenousAcid = new Material.Builder(getId(), gregtechId("selenous_acid"))
                .dust()
                .color(0xE0E083)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Selenium, 1, Oxygen, 3)
                .build();

        //  11111 Germanium Dioxide
        GermaniumDioxide = new Material.Builder(getId(), gregtechId("germanium_dioxide"))
                .dust()
                .color(0x666666)
                .flags(DISABLE_DECOMPOSITION)
                .components(Germanium, 1, Oxygen, 2)
                .build();

        //  11112 Roasted Sphalerite
        RoastedSphalerite = new Material.Builder(getId(), gregtechId("roasted_sphalerite"))
                .dust()
                .color(0xAC8B5C)
                .iconSet(FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, GermaniumDioxide, 1)
                .build();

        //  11113 Zinc Rich Sphalerite
        ZincRichSphalerite = new Material.Builder(getId(), gregtechId("zinc_rich_sphalerite"))
                .dust()
                .color(0xC3AC8F)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zinc, 2, RoastedSphalerite, 3)
                .build()
                .setFormula("Zn2(GaGeO2)", true);

        //  11114 Zinc Oxide
        ZincOxide = new Material.Builder(getId(), gregtechId("zinc_oxide"))
                .dust()
                .color(0xB85C34)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .components(Zinc, 1, Oxygen, 1)
                .build();

        //  11115 Waelz Oxide
        WaelzOxide = new Material.Builder(getId(), gregtechId("waelz_oxide"))
                .dust()
                .color(0xB8B8B8)
                .iconSet(FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zinc, 1, GermaniumDioxide, 1)
                .build();

        //  11116 Waelz Slag
        WaelzSlag = new Material.Builder(getId(), gregtechId("waelz_slag"))
                .dust()
                .color(0xAC8B5C)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, Zinc, 1, Sulfur, 1, Oxygen, 4)
                .build();

        //  11117 Impure Germanium Dioxide
        ImpureGermaniumDioxide = new Material.Builder(getId(), gregtechId("impure_germanium_dioxide"))
                .dust()
                .color(0x666666)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(GermaniumDioxide, 1)
                .build()
                .setFormula("GeO2?", true);

        //  11118 Germanium Tetrachloride
        GermaniumTetrachloride = new Material.Builder(getId(), gregtechId("germanium_tetrachloride"))
                .liquid()
                .color(0x787878)
                .flags(DISABLE_DECOMPOSITION)
                .components(Germanium, 1, Chlorine, 4)
                .build();

        //  11119 Molybdenum Trioxide
        MolybdenumTrioxide = new Material.Builder(getId(), gregtechId("molybdenum_trioxide"))
                .dust()
                .color(0xCBCFDA)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Molybdenum, 1, Oxygen, 3)
                .build();

        //  11120 Lead Chloride
        LeadChloride = new Material.Builder(getId(), gregtechId("lead_chloride"))
                .dust()
                .color(0xF3F3F3)
                .iconSet(ROUGH)
                .components(Lead, 1, Chlorine, 2)
                .build();

        //  11121 Perrhenic Acid
        PerrhenicAcid = new Material.Builder(getId(), gregtechId("perrhenic_acid"))
                .dust()
                .color(0xE6DC70)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 1, Rhenium, 1, Oxygen, 4)
                .build();

        //  11122 Ammonium Perrhenate
        AmmoniumPerrhenate = new Material.Builder(getId(), gregtechId("ammonium_perrhenate"))
                .dust()
                .liquid()
                .color(0xA69970)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Hydrogen, 4, Rhenium, 1, Oxygen, 4)
                .build();

        //  11123 Niobium Pentoxide
        NiobiumPentoxide = new Material.Builder(getId(), gregtechId("niobium_pentoxide"))
                .dust()
                .color(0xBAB0C3)
                .iconSet(ROUGH)
                .components(Niobium, 2, Oxygen, 5)
                .build();

        //  11124 Tantalum Pentoxide
        TantalumPentoxide = new Material.Builder(getId(), gregtechId("tantalum_pentoxide"))
                .dust()
                .color(0x72728A)
                .iconSet(ROUGH)
                .components(Tantalum, 2, Oxygen, 5)
                .build();

        //  11125 Calcium Difluoride
        CalciumDifluoride = new Material.Builder(getId(), gregtechId("calcium_difluoride"))
                .dust()
                .color(0xFFFC9E)
                .iconSet(ROUGH)
                .components(Calcium, 1, Fluorine, 2)
                .build();

        //  11126 Manganese Difluoride
        ManganeseDifluoride = new Material.Builder(getId(), gregtechId("manganese_difluoride"))
                .dust()
                .color(0xEF4B3D)
                .iconSet(ROUGH)
                .components(Manganese, 1, Fluorine, 2)
                .build();

        //  11127 Heavy Alkali Chloride Solution
        HeavyAlkaliChlorideSolution = new Material.Builder(getId(), gregtechId("heavy_alkali_chloride_solution"))
                .liquid()
                .color(0x8F5353)
                .flags(DISABLE_DECOMPOSITION)
                .components(Rubidium, 1, Caesium, 2, Chlorine, 6, Water, 2)
                .build()
                .setFormula("RbCl(CsCl)2Cl3(H2O)2", true);

        //  11128 Stannic Chloride
        StannicChloride = new Material.Builder(getId(), gregtechId("stannic_chloride"))
                .liquid()
                .color(0x33BBF5)
                .components(Tin, 1, Chlorine, 4)
                .build();

        //  11129 Rubidium Chlorostannate
        RubidiumChlorostannate = new Material.Builder(getId(), gregtechId("rubidium_chlorostannate"))
                .dust()
                .color(0xBD888A)
                .iconSet(METALLIC)
                .components(Rubidium, 2, Tin, 1, Chlorine, 6)
                .build();

        //  11130 Caesium Chlorostannate
        CaesiumChlorostannate = new Material.Builder(getId(), gregtechId("caesium_chlorostannate"))
                .dust()
                .color(0xBDAD88)
                .iconSet(SHINY)
                .components(Caesium, 2, Tin, 1, Chlorine, 6)
                .build();

        //  11131 Thallium Sulfate
        ThalliumSulfate = new Material.Builder(getId(), gregtechId("thallium_sulfate"))
                .dust()
                .color(0x9C222C)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Thallium, 2, Sulfur, 1, Oxygen, 4)
                .build();

        //  11132 Tungsten Trioxide
        TungstenTrioxide = new Material.Builder(getId(), gregtechId("tungsten_trioxide"))
                .dust()
                .color(0xC7D300)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Tungsten, 1, Oxygen, 3)
                .build();

        //  11133 GST Glass
        GSTGlass = new Material.Builder(getId(), gregtechId("gst_glass"))
                .ingot()
                .fluid()
                .color(0xCFFFFF)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, NO_SMASHING, NO_WORKING, DECOMPOSITION_BY_CENTRIFUGING)
                .components(Germanium, 2, Antimony, 2, Tellurium, 5)
                .blast(b -> b
                        .temp(873, BlastProperty.GasTier.MID))
                .build();

        //  11134 ZBLAN Glass
        ZBLANGlass = new Material.Builder(getId(), gregtechId("zblan_glass"))
                .ingot()
                .fluid()
                .color(0xACB4BC)
                .iconSet(SHINY)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_FINE_WIRE)
                .components(Zirconium, 5, Barium, 2, Lanthanum, 1, Aluminium, 1, Sodium, 2, Fluorine, 6)
                .build()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2", true);

        //  11135 Erbium-doped ZBLAN Glass
        ErbiumDopedZBLANGlass = new Material.Builder(getId(), gregtechId("erbium_doped_zblan_glass"))
                .ingot()
                .color(0x505444)
                .iconSet(BRIGHT)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(ZBLANGlass, 1, Erbium, 1)
                .build()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Er", true);

        //  11136 PraseodymiumDopedZBLANGlass
        PraseodymiumDopedZBLANGlass = new Material.Builder(getId(), gregtechId("praseodymium_doped_zblan_glass"))
                .ingot()
                .color(0xC5C88D)
                .iconSet(BRIGHT)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(ZBLANGlass, 1, Praseodymium, 1)
                .build()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Pr", true);

        //  11137 Silicon Tetrachloride
        SiliconTetrachloride = new Material.Builder(getId(), gregtechId("silicon_tetrachloride"))
                .liquid()
                .color(0x5B5B7A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Silicon, 1, Chlorine, 4)
                .build();

        //  11138 Helium-Neon Gas
        HeliumNeon = new Material.Builder(getId(), gregtechId("helium_neon"))
                .gas()
                .color(0xFF0080)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(Helium, 1, Neon, 1)
                .build();

        //  11139 Nd:YAG
        NdYAG = new Material.Builder(getId(), gregtechId("nd_yag"))
                .gem()
                .color(0xD99DE4)
                .iconSet(GEM_VERTICAL)
                .flags(CRYSTALLIZABLE, DECOMPOSITION_BY_CENTRIFUGING, GENERATE_LENS)
                .components(YttriumOxide, 2, NeodymiumOxide, 1, Alumina, 5)
                .build()
                .setFormula("Nd:YAG", true);

        //  11140 HRA Magnesium
        HRAMagnesium = new Material.Builder(getId(), gregtechId("hra_magnesium"))
                .dust()
                .color(Magnesium.getMaterialRGB())
                .iconSet(SHINY)
                .components(Magnesium, 1)
                .build();

        //  11141 Cadmium Bromide
        CadmiumBromide = new Material.Builder(getId(), gregtechId("cadmium_bromide"))
                .dust()
                .color(0xFF1774)
                .iconSet(SHINY)
                .components(Cadmium, 1, Bromine, 2)
                .build();

        //  11142 Magnesium Bromide
        MagnesiumBromide = new Material.Builder(getId(), gregtechId("magnesium_bromide"))
                .dust()
                .color(0x5F4C32)
                .iconSet(METALLIC)
                .components(Magnesium, 1, Bromine, 2)
                .build();

        //  11143 Dimethylcadmium
        Dimethylcadmium = new Material.Builder(getId(), gregtechId("dimethylcadmium"))
                .liquid()
                .color(0x5C037F)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 6, Cadmium, 1)
                .build()
                .setFormula("(CH3)2Cd", true);

        //  11144 Cadmium Sulfide
        CadmiumSulfide = new Material.Builder(getId(), gregtechId("cadmium_sulfide"))
                .dust()
                .color(0xC8C43C)
                .flags(DECOMPOSITION_BY_ELECTROLYZING, GENERATE_PLATE)
                .iconSet(METALLIC)
                .components(Cadmium, 1, Sulfur, 1)
                .build();

        //  11145 Aluminium Selenide
        AluminiumSelenide = new Material.Builder(getId(), gregtechId("aluminium_selenide"))
                .dust()
                .color(0x969651)
                .components(Aluminium, 2, Selenium, 3)
                .build();

        //  11146 Hydrogen Selenide
        HydrogenSelenide = new Material.Builder(getId(), gregtechId("hydrogen_selenide"))
                .gas()
                .color(0x42f554)
                .components(Hydrogen, 2, Selenium, 1)
                .build();

        //  11147 Cadmium Selenide
        CadmiumSelenide = new Material.Builder(getId(), gregtechId("cadmium_selenide"))
                .dust()
                .color(0x983034)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .iconSet(METALLIC)
                .components(Cadmium, 1, Selenium, 1)
                .build();

        //  11148 Potassium Manganate
        PotassiumManganate = new Material.Builder(getId(), gregtechId("potassium_manganate"))
                .dust()
                .color(0x873883)
                .iconSet(METALLIC)
                .components(Potassium, 2, Manganese, 1, Oxygen, 4)
                .build();

        //  11149 Potassium Manganate
        PotassiumPermanganate = new Material.Builder(getId(), gregtechId("potassium_permanganate"))
                .dust()
                .color(0x871D82)
                .iconSet(DULL)
                .components(Potassium, 1, Manganese, 1, Oxygen, 4)
                .build();

        //  11150 Manganese Sulfate
        ManganeseSulfate = new Material.Builder(getId(), gregtechId("manganese_sulfate"))
                .dust()
                .color(0xF0F895)
                .iconSet(ROUGH)
                .components(Manganese, 1, Sulfur, 1, Oxygen, 4)
                .build();

        //  11151 Potassium Sulfate
        PotassiumSulfate = new Material.Builder(getId(), gregtechId("potassium_sulfate"))
                .dust()
                .color(0xF4FBB0)
                .iconSet(DULL)
                .components(Potassium, 2, Sulfur, 1, Oxygen, 4)
                .build();

        //  11152 Neodymium-Doped Yttrium Oxide
        NeodymiumDopedYttriumOxide = new Material.Builder(getId(), gregtechId("neodymium_doped_yttrium_oxide"))
                .dust()
                .color(0x5AD55F)
                .iconSet(DULL)
                .build()
                .setFormula("Nd:Y?", false);

        //  11153 Aluminium Nitrate
        AluminiumNitrate = new Material.Builder(getId(), gregtechId("aluminium_nitrate"))
                .dust()
                .color(0x3AB3AA)
                .iconSet(SHINY)
                .components(Aluminium, 1, Nitrogen, 3, Oxygen, 9)
                .build()
                .setFormula("Al(NO3)3", true);

        //  11154 Alumina Solution
        AluminaSolution = new Material.Builder(getId(), gregtechId("alumina_solution"))
                .liquid()
                .color(0x6C4DC1)
                .components(Alumina, 1, Carbon, 25, Hydrogen, 56, Chlorine, 2, Nitrogen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(Al2O3)(CH2Cl2)(C12H27N)2", true);

        //  11155 Unprocessed Nd:YAG Solution
        UnprocessedNdYAGSolution = new Material.Builder(getId(), gregtechId("unprocessed_nd_yag_solution"))
                .liquid()
                .color(0x6f20af)
                .iconSet(DULL)
                .build()
                .setFormula("Nd:YAG?", false);

        //  11156 Niobium Pentachloride
        NiobiumPentachloride = new Material.Builder(getId(), gregtechId("niobium_pentachloride"))
                .dust()
                .color(Niobium.getMaterialRGB() + Chlorine.getMaterialRGB())
                .iconSet(SHINY)
                .components(Niobium, 1, Chlorine, 5)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11157 Lithium Niobate
        LithiumNiobate = new Material.Builder(getId(), gregtechId("lithium_niobate"))
                .ingot()
                .color(0xD27700)
                .iconSet(SHINY)
                .components(Lithium, 1, Niobium, 1, Oxygen, 4)
                .blast(6700)
                .flags(DISABLE_DECOMPOSITION)
                .flags(GENERATE_PLATE, GENERATE_LENS)
                .build();

        //  11158 Roasted Vanadium Magnetite
        RoastedVanadiumMagnetite = new Material.Builder(getId(), gregtechId("roasted_vanadium_magnetite"))
                .dust()
                .color(0xCC9933)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vanadium, 1, Oxygen, 1)
                .build();

        //  11159 Sodium Vanadate
        SodiumVanadate = new Material.Builder(getId(), gregtechId("sodium_vanadate"))
                .dust()
                .color(0xCC9933)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 3, Vanadium, 1, Oxygen, 4)
                .build();

        //  11160 Ammonium Vanadate
        AmmoniumVanadate = new Material.Builder(getId(), gregtechId("ammonium_vanadate"))
                .dust()
                .color(0xCC9933)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Hydrogen, 4, Vanadium, 1, Oxygen, 3)
                .build();

        //  11161 Bismuth Nitrate Solution
        BismuthNitrateSolution = new Material.Builder(getId(), gregtechId("bismuth_nitrate_solution"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0x3ABF50)
                .components(Bismuth, 1, Nitrogen, 3, Oxygen, 10, Hydrogen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Bi(NO3)3(H2O)");

        //  11162 Bismuth Vanadate Solution
        BismuthVanadateSolution = new Material.Builder(getId(), gregtechId("bismuth_vanadate_solution"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0xFFAF33)
                .flags(DISABLE_DECOMPOSITION)
                .components(Bismuth, 1, Vanadium, 1, Hydrogen, 2, Oxygen, 5)
                .build()
                .setFormula("BiVO4(H2O)", true);

        //  11163 Bismuth Vanadate
        BismuthVanadate = new Material.Builder(getId(), gregtechId("bismuth_vanadate"))
                .dust()
                .color(0xFFAF33)
                .iconSet(SHINY)
                .components(Bismuth, 1, Vanadium, 1, Oxygen, 4)
                .build();

        //  11164 Lu-Tm-Y Chlorides Solution
        LuTmYChloridesSolution = new Material.Builder(getId(), gregtechId("lu_tm_y_chlorides_solution"))
                .liquid()
                .color(Lutetium.getMaterialRGB() + Thulium.getMaterialRGB() + Yttrium.getMaterialRGB())
                .components(Lutetium, 2, Thulium, 2, Yttrium, 6, Chlorine, 30, Hydrogen, 30, Oxygen, 15)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(LuCl3)2(TmCl3)2(YCl3)6(H2O)15", true);

        //  11165 Lu-Tm-doped Yttrium Vanadate Deposition
        LuTmDopedYttriumVanadateDeposition = new Material.Builder(getId(), gregtechId("lu_tm_doped_yttrium_vanadate_deposition"))
                .dust()
                .color(Yttrium.getMaterialRGB() + Vanadium.getMaterialRGB() + Lutetium.getMaterialRGB())
                .iconSet(FINE)
                .build()
                .setFormula("Lu/Tm:YVO?", false);

        //  11166 Ammonium Carbonate
        AmmoniumCarbonate = new Material.Builder(getId(), gregtechId("ammonium_carbonate"))
                .dust()
                .color(0x7C89D9)
                .iconSet(SHINY)
                .components(Carbon, 1, Hydrogen, 8, Oxygen, 3, Nitrogen, 2)
                .build()
                .setFormula("(NH4)2CO3", true);

        //  11167 Lu/Tm:YVO
        LuTmYVO = new Material.Builder(getId(), gregtechId("lu_tm_yvo"))
                .gem()
                .color(0x8C1B23)
                .iconSet(GEM_HORIZONTAL)
                .flags(DISABLE_DECOMPOSITION, GENERATE_LENS, CRYSTALLIZABLE)
                .components(Yttrium, 1, Vanadium, 1, Oxygen, 1, Lutetium, 1, Thulium, 1)
                .build()
                .setFormula("Lu/Tm:YVO", false);

        //  11168 Pr-Ho-Y Nitrates Solution
        PrHoYNitratesSolution = new Material.Builder(getId(), gregtechId("pr_ho_y_nitrates_solution"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(Praseodymium.getMaterialRGB() + Holmium.getMaterialRGB() + Yttrium.getMaterialRGB())
                .components(Praseodymium, 2, Holmium, 2, Yttrium, 6, Nitrogen, 30, Oxygen, 105, Hydrogen, 30)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(Pr(NO3)3)2(Ho(NO3)3)2(Y(NO3)3)6(H2O)15", true);

        //  11169 Lithium Fluoride
        LithiumFluoride = new Material.Builder(getId(), gregtechId("lithium_fluoride"))
                .dust()
                .color(Lithium.getMaterialRGB() + Fluorine.getMaterialRGB())
                .iconSet(SHINY)
                .components(Lithium, 1, Fluorine, 1)
                .build();

        //  11170 Hexafluorosilicic Acid
        HexafluorosilicicAcid = new Material.Builder(getId(), gregtechId("hexafluorosilicic_acid"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(Silicon.getMaterialRGB() + Fluorine.getMaterialRGB())
                .components(Hydrogen, 2, Silicon, 1, Fluorine, 6)
                .build();

        //  11171 Ammonium Fluoride
        AmmoniumFluoride = new Material.Builder(getId(), gregtechId("ammonium_fluoride"))
                .liquid()
                .color(Ammonia.getMaterialRGB() + Fluorine.getMaterialRGB())
                .components(Nitrogen, 1, Hydrogen, 4, Fluorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11172 Ammonium Difluoride
        AmmoniumDifluoride = new Material.Builder(getId(), gregtechId("ammonium_difluoride"))
                .dust()
                .color(AmmoniumFluoride.getMaterialRGB())
                .iconSet(FINE)
                .components(Nitrogen, 1, Hydrogen, 5, Fluorine, 2)
                .build()
                .setFormula("NH4HF2", true);

        //  11173 Beryllium Difluoride
        BerylliumDifluoride = new Material.Builder(getId(), gregtechId("beryllium_difluoride"))
                .dust()
                .color(Beryllium.getMaterialRGB() + Fluorine.getMaterialRGB())
                .iconSet(SHINY)
                .components(Beryllium, 1, Fluorine, 2)
                .build();

        //  11174 Pr:Ho/YLF
        PrHoYLF = new Material.Builder(getId(), gregtechId("pr_ho_ylf"))
                .gem()
                .color(Praseodymium.getMaterialRGB() + Holmium.getMaterialRGB() + Yttrium.getMaterialRGB() + Lithium.getMaterialRGB())
                .iconSet(RUBY)
                .components(Praseodymium, 1, Holmium, 1, Lithium, 1, Yttrium, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION, GENERATE_LENS, CRYSTALLIZABLE)
                .build()
                .setFormula("Pr/Ho:YLF", false);

        //  11175 Sodium Acetate
        SodiumAcetate = new Material.Builder(getId(), gregtechId("sodium_acetate"))
                .liquid()
                .color(0xC5D624)
                .components(SodiumHydroxide, 1, Ethenone, 1)
                .build()
                .setFormula("C2H3NaO2", true);

        //  11176 Sodium Oxide
        SodiumOxide = new Material.Builder(getId(), gregtechId("sodium_oxide"))
                .dust()
                .color(0x2C96FC)
                .iconSet(BRIGHT)
                .components(Sodium, 2, Oxygen, 1)
                .build();

        //  11177 Titanium Nitrate
        TitaniumNitrate = new Material.Builder(getId(), gregtechId("titanium_nitrate"))
                .dust()
                .color(Titanium.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .iconSet(DULL)
                .components(Titanium, 1, Nitrogen, 4, Oxygen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Ti(NO3)4", true);

        //  11178 Plutonium Trihydride
        PlutoniumTrihydride = new Material.Builder(getId(), gregtechId("plutonium_trihydride"))
                .dust()
                .color(0x140002)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Plutonium239, 1, Hydrogen, 3)
                .build()
                .setFormula("PuH3", true);

        //  11179 Plutonium Phosphide
        PlutoniumPhosphide = new Material.Builder(getId(), gregtechId("plutonium_phosphide"))
                .ingot()
                .color(0x1F0104)
                .iconSet(MAGNETIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Plutonium239, 1, Phosphorus, 1)
                .build()
                .setFormula("PuP", true);

        //  11180 Neptunium Aluminide
        NeptuniumAluminide = new Material.Builder(getId(), gregtechId("neptunium_aluminide"))
                .ingot()
                .fluid()
                .color(0x5E228F)
                .iconSet(MAGNETIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Neptunium, 1, Aluminium, 3)
                .blast(b -> b
                        .temp(1568, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[ZPM]))
                .build()
                .setFormula("NpAl3", true);

        //  11181 Bismuth Trioxide
        BismuthTrioxide = new Material.Builder(getId(), gregtechId("bismuth_trioxide"))
                .dust()
                .color(0xF5EF42)
                .iconSet(FINE)
                .components(Bismuth, 2, Oxygen, 3)
                .build();

        //  11182 Ferric Oxide
        FerricOxide = new Material.Builder(getId(), gregtechId("ferric_oxide"))
                .dust()
                .color(0x915A5A)
                .iconSet(ROUGH)
                .components(Iron, 2, Oxygen, 3)
                .build();

        //  11183 Bismuth Ferrite
        BismuthFerrite = new Material.Builder(getId(), gregtechId("bismuth_ferrite"))
                .gem()
                .color(0x43634B)
                .iconSet(MAGNETIC)
                .flags(CRYSTALLIZABLE, GENERATE_PLATE)
                .components(BismuthTrioxide, 2, FerricOxide, 2)
                .build()
                .setFormula("BiFeO3", true);

        //  11184 Thallium Copper Chloride
        ThalliumCopperChloride = new Material.Builder(getId(), gregtechId("thallium_copper_chloride"))
                .ingot()
                .fluid()
                .color(0x3C5CB5)
                .iconSet(MAGNETIC)
                .flags(GENERATE_FINE_WIRE)
                .components(Thallium, 1, Copper, 1, Chlorine, 3)
                .build();

        //  11185 Bismuth Chalcogenide
        BismuthChalcogenide = new Material.Builder(getId(), gregtechId("bismuth_chalcogenide"))
                .ingot()
                .color(0x91994D)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_FOIL, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Bismuth, 1, Antimony, 1, Tellurium, 2, Sulfur, 1)
                .build();

        //  11186 Mercury Cadmium Telluride
        MercuryCadmiumTelluride = new Material.Builder(getId(), gregtechId("mercury_cadmium_telluride"))
                .ingot()
                .fluid()
                .color(0x823C80)
                .iconSet(BRIGHT)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .components(Mercury, 2, Cadmium, 1, Tellurium, 2)
                .blast(b -> b
                        .temp(2170, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[UHV]))
                .build();

        //  11187 Lanthanum Fullerene Mixture
        LanthanumFullereneMixture = new Material.Builder(getId(), gregtechId("lanthanum_fullerene_mixture"))
                .dust()
                .color(0xD26D8E)
                .iconSet(BRIGHT)
                .build()
                .setFormula("(C60H30)La2", true);

        //  11188 Lanthanum Embedded Fullerene
        LanthanumEmbeddedFullerene = new Material.Builder(getId(), gregtechId("lanthanum_embedded_fullerene"))
                .dust()
                .color(0x84FFAC)
                .iconSet(BRIGHT)
                .build()
                .setFormula("(C60H30)La2", true);

        //  11189 Strontium Dichloride
        StrontiumDichloride = new Material.Builder(getId(), gregtechId("strontium_dichloride"))
                .dust()
                .color(Strontium.getMaterialRGB() + Chlorine.getMaterialRGB())
                .iconSet(SHINY)
                .components(Strontium, 1, Chlorine, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11190 Celestite
        Celestite = new Material.Builder(getId(), gregtechId("celestite"))
                .gem()
                .color(0x4AE3E6)
                .iconSet(OPAL)
                .components(Strontium, 1, Sulfur, 1, Oxygen, 4)
                .flags(CRYSTALLIZABLE, DISABLE_DECOMPOSITION, GENERATE_LENS)
                .build();

        //  11191 Strontium Carbonate
        StrontiumCarbonate = new Material.Builder(getId(), gregtechId("strontium_carbonate"))
                .dust()
                .color(0x1DAFD3)
                .iconSet(SAND)
                .components(Strontium, 1, Carbon, 1, Oxygen, 3)
                .build();

        //  11192 Silica Gel
        SilicaGel = new Material.Builder(getId(), gregtechId("silica_gel"))
                .dust()
                .color(0x9695FD)
                .iconSet(SHINY)
                .components(Silicon, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11193 Silica Gel Base
        SilicaGelBase = new Material.Builder(getId(), gregtechId("silica_gel_base"))
                .liquid()
                .color(0x9695FD)
                .iconSet(ROUGH)
                .components(SiliconDioxide, 1, HydrochloricAcid, 1, SodiumHydroxide, 1, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11194 Nitronium Tetrafluoroborate
        NitroniumTetrafluoroborate = new Material.Builder(getId(), gregtechId("nitronium_tetrafluoroborate"))
                .dust()
                .color(0x787449)
                .iconSet(DULL)
                .components(Nitrogen, 1, Oxygen, 2, Boron, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11195 Nitrosonium Tetrafluoroborate
        NitrosoniumTetrafluoroborate = new Material.Builder(getId(), gregtechId("nitrosonium_tetrafluoroborate"))
                .dust()
                .color(0xA32A8C)
                .iconSet(ROUGH)
                .components(Nitrogen, 1, Oxygen, 1, Boron, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11196 Tetrafluoroboric Acid
        TetrafluoroboricAcid = new Material.Builder(getId(), gregtechId("tetrafluoroboric_acid"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0x83A731)
                .components(Hydrogen, 1, Boron, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11197 Potassium Bisulfite
        PotassiumBisulfite = new Material.Builder(getId(), gregtechId("potassium_bisulfite"))
                .dust()
                .color(344314)
                .iconSet(DULL)
                .components(Potassium, 1, Hydrogen, 1, Sulfur, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11198 Potassium Nitrite
        PotassiumNitrite = new Material.Builder(getId(), gregtechId("potassium_nitrite"))
                .dust()
                .color(0xB9B9B9)
                .components(Potassium, 1, Nitrogen, 1, Oxygen, 2)
                .build();

        //  11199 Potassium Carbonate
        PotassiumCarbonate = new Material.Builder(getId(), gregtechId("potassium_carbonate"))
                .dust()
                .color(0x7C89D9)
                .iconSet(ROUGH)
                .components(Potassium, 2, Carbon, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11200 Phosphorus-Doped Europium Iron Arsenide
        PhosphorusDopedEuropiumIronArsenide = new Material.Builder(getId(), gregtechId("phosphorus_doped_europium_iron_arsenide"))
                .ingot()
                .fluid()
                .color(0x2C85F1)
                .iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Phosphorus, 1, Europium, 1, Iron, 2, Arsenic, 2)
                .blast(b -> b
                        .temp(5500, BlastProperty.GasTier.HIGHEST))
                .build()
                .setFormula("P:EuFe2Ae2", true);

        //  11201 Magnetic Phosphorus-Doped Europium Iron Arsenide
        PhosphorusDopedEuropiumIronArsenideMagnetic = new Material.Builder(getId(), gregtechId("magnetic_phosphorus_doped_europium_iron_arsenide"))
                .ingot()
                .color(0x2C85F1)
                .iconSet(MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, IS_MAGNETIC)
                .components(PhosphorusDopedEuropiumIronArsenide, 1)
                .ingotSmeltInto(PhosphorusDopedEuropiumIronArsenide)
                .arcSmeltInto(PhosphorusDopedEuropiumIronArsenide)
                .macerateInto(PhosphorusDopedEuropiumIronArsenide)
                .build()
                .setFormula("P:EuFe2Ae2", true);

        PhosphorusDopedEuropiumIronArsenide.getProperty(PropertyKey.INGOT).setMagneticMaterial(PhosphorusDopedEuropiumIronArsenideMagnetic);

        //  11202 Caesium Iodide
        CaesiumIodide = new Material.Builder(getId(), gregtechId("caesium_iodide"))
                .dust()
                .color(Caesium.getMaterialRGB() + Iodine.getMaterialRGB())
                .iconSet(SHINY)
                .components(Caesium, 1, Iodine, 1)
                .build();

        //  11203 Tl-Tm-Doped Caesium Iodide
        TlTmDopedCaesiumIodide = new Material.Builder(getId(), gregtechId("tl_tm_doped_caesium_iodide"))
                .dust()
                .color(Thallium.getMaterialRGB() + Thulium.getMaterialRGB() + CaesiumIodide.getMaterialRGB())
                .iconSet(BRIGHT)
                .components(Thallium, 1, Thulium, 1, CaesiumIodide, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Tl/Tm:CsI");

        //  11204 Cadmium Tungstate
        CadmiumTungstate = new Material.Builder(getId(), gregtechId("cadmium_tungstate"))
                .dust()
                .color(Cadmium.getMaterialRGB() + Tungsten.getMaterialRGB())
                .iconSet(BRIGHT)
                .components(Cadmium, 1, Tungsten, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11205 Bismuth Germanate
        BismuthGermanate = new Material.Builder(getId(), gregtechId("bismuth_germanate"))
                .dust()
                .color(Bismuth.getMaterialRGB() + Germanium.getMaterialRGB())
                .iconSet(ROUGH)
                .components(Bismuth, 4, Germanium, 3, Oxygen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11206 Strontium Sulfide
        StrontiumSulfide = new Material.Builder(getId(), gregtechId("strontium_sulfide"))
                .dust()
                .color(Strontium.getMaterialRGB() + Sulfur.getMaterialRGB())
                .iconSet(SHINY)
                .components(Strontium, 1, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11207 Sodium Cinnamate
        SodiumCinnamate = new Material.Builder(getId(), gregtechId("sodium_cinnamate"))
                .dust()
                .color(0xB84975)
                .iconSet(ROUGH)
                .components(Carbon, 9, Hydrogen, 7, Sodium, 1, Oxygen, 2)
                .build();

        //  11208 Lithiumthiinediselenide
        Lithiumthiinediselenide = new Material.Builder(getId(), gregtechId("lithiumthiinediselenide"))
                .dust()
                .color(0x689E64)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 4, Sulfur, 2, Lithium, 2, Selenium, 2)
                .build();

        //  11209 Sodium Thiosulfate
        SodiumThiosulfate = new Material.Builder(getId(), gregtechId("sodium_thiosulfate"))
                .dust()
                .color(0x1436A7)
                .iconSet(ROUGH)
                .components(Sodium, 2, Sulfur, 2, Oxygen, 3)
                .build();

        //  11210 Sodium Formate
        SodiumFormate = new Material.Builder(getId(), gregtechId("sodium_formate"))
                .liquid()
                .color(0x416CC0)
                .iconSet(ROUGH)
                .components(Carbon, 1, Hydrogen, 1, Oxygen, 2, Sodium, 1)
                .build()
                .setFormula("HCOONa", false);

        //  11211 Francium Carbide
        FranciumCarbide = new Material.Builder(getId(), gregtechId("francium_carbide"))
                .dust()
                .color(0xDBDBDB)
                .iconSet(SHINY)
                .components(Francium, 2, Carbon, 2)
                .build();

        //  11212 Boron Carbide
        BoronCarbide = new Material.Builder(getId(), gregtechId("boron_carbide"))
                .dust()
                .color(0x3A5170)
                .iconSet(DULL)
                .components(Boron, 4, Carbon, 3)
                .build();

        //  11213 Boron Francium Carbide
        BoronFranciumCarbide = new Material.Builder(getId(), gregtechId("boron_francium_carbide"))
                .dust()
                .color(FranciumCarbide.getMaterialRGB() + BoronCarbide.getMaterialRGB())
                .iconSet(SHINY)
                .components(BoronCarbide, 1, FranciumCarbide, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Fr4B4C7", true);

        //  11214 Hydroiodic Acid
        HydroiodicAcid = new Material.Builder(getId(), gregtechId("hydroiodic_acid"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(Hydrogen.getMaterialRGB() + Iodine.getMaterialRGB())
                .components(Hydrogen, 1, Iodine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11215 Lithium Aluminium Hydride
        LithiumAluminiumHydride = new Material.Builder(getId(), gregtechId("lithium_aluminium_hydride"))
                .dust()
                .color(Lithium.getMaterialRGB() + Aluminium.getMaterialRGB() + Hydrogen.getMaterialRGB())
                .iconSet(SAND)
                .components(Lithium, 1, Aluminium, 1, Hydrogen, 4)
                .build();

        //  11216 Aluminium Hydride
        AluminiumHydride = new Material.Builder(getId(), gregtechId("aluminium_hydride"))
                .dust()
                .color(Aluminium.getMaterialRGB() + Hydrogen.getMaterialRGB())
                .iconSet(SHINY)
                .components(Aluminium, 1, Hydrogen, 3)
                .build();

        //  11217 Lithium Iodide
        LithiumIodide = new Material.Builder(getId(), gregtechId("lithium_iodide"))
                .dust()
                .color(Lithium.getMaterialRGB() + Iodine.getMaterialRGB())
                .iconSet(DULL)
                .components(Lithium, 1, Iodine, 1)
                .build();

        //  11218 Sodium Ethoxide
        SodiumEthoxide = new Material.Builder(getId(), gregtechId("sodium_ethoxide"))
                .dust()
                .color(Sodium.getMaterialRGB() + Ethanol.getMaterialRGB())
                .iconSet(DULL)
                .components(Carbon, 2, Hydrogen, 5, Oxygen, 1, Sodium, 1)
                .build();

        //  11219 Neutronium Nanotube
        NeutroniumNanotube = new Material.Builder(getId(), gregtechId("neutronium_nanotube"))
                .ingot()
                .color(0xDDBDCC)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(Carbon, 48, Neutronium, 1)
                .build()
                .setFormula("Nt:CNT");

        //  11220 Naquadria Caesium Xenonnonfluoride
        NaquadriaCaesiumXenonnonfluoride = new Material.Builder(getId(), gregtechId("naquadria_caesium_xenonnonfluoride"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0x54C248)
                .components(Naquadria, 1, Caesium, 1, Xenon, 1, Fluorine, 9)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11221 Naquadria Caesiumfluoride
        NaquadriaCaesiumfluoride = new Material.Builder(getId(), gregtechId("naquadria_caesiumfluoride"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0xAAEB69)
                .components(Naquadria, 1, Fluorine, 3, Caesium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("*Nq*F2CsF", true);

        //  11222 Radon Naquadria Octafluoride
        RadonNaquadriaOctafluoride = new Material.Builder(getId(), gregtechId("radon_naquadria_octafluoride"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0x85F378)
                .components(Radon, 1, Naquadria, 1, Fluorine, 8)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11223 Caesium Xenontrioxide Fluoride
        CaesiumXenontrioxideFluoride = new Material.Builder(getId(), gregtechId("caesium_xenontrioxide_fluoride"))
                .liquid()
                .color(0x5067D7)
                .flags(DISABLE_DECOMPOSITION)
                .components(Caesium, 1, Xenon, 1, Oxygen, 3, Fluorine, 1)
                .build();

        //  11224 Radon Trioxide
        RadonTrioxide = new Material.Builder(getId(), gregtechId("radon_trioxide"))
                .gas()
                .color(0x9A6DD7)
                .components(Radon, 1, Oxygen, 3)
                .build();

        //  11225 Caesium Fluoride
        CaesiumFluoride = new Material.Builder(getId(), gregtechId("caesium_fluoride"))
                .liquid()
                .color(0xFF7A5F)
                .components(Caesium, 1, Fluorine, 1)
                .build();

        //  11226 Xenon Trioxide
        XenonTrioxide = new Material.Builder(getId(), gregtechId("xenon_trioxide"))
                .gas()
                .color(0x359FC3)
                .components(Xenon, 1, Oxygen, 3)
                .build();

        //  11227 Radon Difluoride
        RadonDifluoride = new Material.Builder(getId(), gregtechId("radon_difluoride"))
                .gas()
                .color(0x8B7EFF)
                .components(Radon, 1, Fluorine, 2)
                .build();

        //  11228 Polonium Nitrate
        PoloniumNitrate = new Material.Builder(getId(), gregtechId("polonium_nitrate"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(Polonium.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .components(Polonium, 1, Nitrogen, 4, Oxygen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Po(NO3)4", true);

        //  11229 Polonium Dichloride
        PoloniumDichloride = new Material.Builder(getId(), gregtechId("polonium_dichloride"))
                .dust()
                .color(Polonium.getMaterialRGB() + Chlorine.getMaterialRGB())
                .components(Polonium, 1, Chlorine, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11230 Lithium Sulfide
        LithiumSulfide = new Material.Builder(getId(), gregtechId("lithium_sulfide"))
                .ingot()
                .color(0xFDFB9A)
                .iconSet(BRIGHT)
                .components(Lithium, 2, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .blast(b -> b
                        .temp(8372, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[UV], 353))
                .build();

        //  11231 Lanthanum Nickel Oxide
        LanthanumNickelOxide = new Material.Builder(getId(), gregtechId("lanthanum_nickel_oxide"))
                .ingot()
                .color(0x99C0FF)
                .iconSet(BRIGHT)
                .components(Lanthanum, 2, Nickel, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .blast(b -> b
                        .temp(10720, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 446))
                .build();

        //  11232 Sodium Azide
        SodiumAzide = new Material.Builder(getId(), gregtechId("sodium_azide"))
                .dust()
                .color(Sodium.getMaterialRGB() + Nitrogen.getMaterialRGB())
                .iconSet(DULL)
                .components(Sodium, 1, Nitrogen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11233 Sodium Azanide
        SodiumAzanide = new Material.Builder(getId(), gregtechId("sodium_azanide"))
                .dust()
                .color(Sodium.getMaterialRGB() + Ammonia.getMaterialRGB())
                .iconSet(ROUGH)
                .components(Sodium, 1, Nitrogen, 1, Hydrogen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11234 Bismuth Lawrencium Strontium Cuprate
        BismuthLawrenciumStrontiumCuprate = new Material.Builder(getId(), gregtechId("bismuth_lawrencium_strontium_cuprate"))
                .ingot()
                .fluid()
                .color(0xF2C5D5)
                .iconSet(METALLIC)
                .components(Bismuth, 2, Lawrencium, 2, Strontium, 2, Copper, 3, Oxygen, 10)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD)
                .blast(b -> b
                        .temp(9800, BlastProperty.GasTier.HIGHEST))
                .build();

        //  11235 Magnetic Bismuth Lawrencium Strontium Cuprate
        BismuthLawrenciumStrontiumCuprateMagnetic = new Material.Builder(getId(), gregtechId("magnetic_bismuth_lawrencium_strontium_cuprate"))
                .ingot()
                .color(0xF2C5D5)
                .iconSet(MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, IS_MAGNETIC)
                .components(BismuthLawrenciumStrontiumCuprate, 1)
                .ingotSmeltInto(BismuthLawrenciumStrontiumCuprate)
                .arcSmeltInto(BismuthLawrenciumStrontiumCuprate)
                .macerateInto(BismuthLawrenciumStrontiumCuprate)
                .build();

        BismuthLawrenciumStrontiumCuprate.getProperty(PropertyKey.INGOT).setMagneticMaterial(BismuthLawrenciumStrontiumCuprateMagnetic);

        //  11236 Californium Trichloride
        CaliforniumTrichloride = new Material.Builder(getId(), gregtechId("californium_trichloride"))
                .dust()
                .color(0x8B67D1)
                .iconSet(METALLIC)
                .components(Californium, 1, Chlorine, 3)
                .build();

        //  11237 Rhenium Pentachloride
        RheniumPentachloride = new Material.Builder(getId(), gregtechId("rhenium_pentachloride"))
                .dust()
                .color(0x5B1780)
                .iconSet(SHINY)
                .components(Rhenium, 1, Chlorine, 5)
                .build();

        //  11238 Hassium Tetrachloride
        HassiumTetrachloride = new Material.Builder(getId(), gregtechId("hassium_tetrachloride"))
                .dust()
                .color(0x032551)
                .iconSet(SHINY)
                .components(MetastableHassium, 1, Chlorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11239 Thallium Chloride
        ThalliumChloride = new Material.Builder(getId(), gregtechId("thallium_chloride"))
                .dust()
                .color(0xFF7409)
                .iconSet(METALLIC)
                .components(Thallium, 1, Chlorine, 1)
                .build();

        //  11240 Hexafluorophosphoric Acid
        HexafluorophosphoricAcid = new Material.Builder(getId(), gregtechId("hexafluorophosphoric_acid"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0xFCC782)
                .components(Hydrogen, 1, Phosphorus, 1, Fluorine, 6)
                .build();

        //  11241 Rhenium Hassium Thallium Isophtaloylbisdiethylthiourea Hexafluorophosphate
        RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexafluorophosphate = new Material.Builder(getId(), gregtechId("rhenium_hassium_thallium_isophtaloylbisdiethylthiourea_hexafluorophosphate"))
                .dust()
                .color(0x5F5F82)
                .iconSet(BRIGHT)
                .components(Carbon, 60, Hydrogen, 84, Oxygen, 12, Nitrogen, 12, Sulfur, 6, Fluorine, 6, Phosphorus, 1, Rhenium, 1, Hassium, 1, Thallium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11242 Sodium Thiocyanate
        SodiumThiocyanate = new Material.Builder(getId(), gregtechId("sodium_thiocyanate"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0x818052)
                .components(Sodium, 1, Sulfur, 1, Carbon, 1, Nitrogen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11243 Radium Sulfate
        RadiumSulfate = new Material.Builder(getId(), gregtechId("radium_sulfate"))
                .dust()
                .color(0xEAFFA1)
                .iconSet(SHINY)
                .components(Radium, 1, Sulfur, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11244 Radium Dichloride
        RadiumDichloride = new Material.Builder(getId(), gregtechId("radium_dichloride"))
                .dust()
                .color(0xCCFF33)
                .iconSet(SHINY)
                .components(Radium, 1, Chlorine, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11245 Radium Hydroxide
        RadiumHydroxide = new Material.Builder(getId(), gregtechId("radium_hydroxide"))
                .dust()
                .color(0xD8E6A7)
                .iconSet(SHINY)
                .components(Radium, 1, Oxygen, 2, Hydrogen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Ra(OH)2", true);

        //  11246 Radium Oxide
        RadiumOxide = new Material.Builder(getId(), gregtechId("radium_oxide"))
                .dust()
                .color(0xE0ECB7)
                .iconSet(SHINY)
                .components(Radium, 1, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11247 Ce:LAG
        CeLAG = new Material.Builder(getId(), gregtechId("ce_lag"))
                .gem()
                .color(0x00A816)
                .iconSet(GEM_VERTICAL)
                .flags(CRYSTALLIZABLE, DECOMPOSITION_BY_CENTRIFUGING, GENERATE_LENS)
                .components(CeriumOxide, 1, LutetiumOxide, 1, Alumina, 5)
                .build()
                .setFormula("Ce:LAG", true);

        //  11248 Lead Zirconate Titanate
        LeadZirconateTitanate = new Material.Builder(getId(), gregtechId("lead_zirconate_titanate"))
                .gem(3)
                .color(0x359ADE)
                .iconSet(OPAL)
                .flags(CRYSTALLIZABLE, DECOMPOSITION_BY_CENTRIFUGING, GENERATE_LENS)
                .components(Lead, 1, Titanium, 1, CubicZirconia, 1, Oxygen, 1)
                .build()
                .setFormula("PbZrTiO3", true);

        //  11249 Sodium Iodide
        SodiumIodide = new Material.Builder(getId(), gregtechId("sodium_iodide"))
                .dust()
                .color(Sodium.getMaterialRGB() + Iodine.getMaterialRGB())
                .iconSet(METALLIC)
                .components(Sodium, 1, Iodine, 1)
                .build();

        //  11250 Sodium Nitrite
        SodiumNitrite = new Material.Builder(getId(), gregtechId("sodium_nitrite"))
                .dust()
                .color(Sodium.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .iconSet(DULL)
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11251 Potassium Iodide
        PotassiumIodide = new Material.Builder(getId(), gregtechId("potassium_iodide"))
                .dust()
                .color(Potassium.getMaterialRGB() + Iodine.getMaterialRGB())
                .iconSet(ROUGH)
                .components(Potassium, 1, Iodine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11252 Sodium Pertechnetate
        SodiumPertechnetate = new Material.Builder(getId(), gregtechId("sodium_pertechnetate"))
                .dust()
                .color(Sodium.getMaterialRGB() + Technetium.getMaterialRGB())
                .iconSet(SHINY)
                .components(Sodium, 1, Technetium, 1, Oxygen, 4)
                .build();

        //  11253 Potassium Pertechnetate
        PotassiumPertechnetate = new Material.Builder(getId(), gregtechId("potassium_pertechnetate"))
                .dust()
                .color(Potassium.getMaterialRGB() + Technetium.getMaterialRGB())
                .iconSet(METALLIC)
                .components(Potassium, 1, Technetium, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11254 Potassium Nonahydridorhenate
        PotassiumNonahydridorhenate = new Material.Builder(getId(), gregtechId("potassium_nonahydridorhenate"))
                .dust()
                .color(0xD89926)
                .iconSet(SHINY)
                .components(Hydrogen, 9, Potassium, 2, Rhenium, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11255 Potassium Nonahydridotechnetate
        PotassiumNonahydridotechnetate = new Material.Builder(getId(), gregtechId("potassium_nonahydridotechnetate"))
                .dust()
                .color(0xD6BB09)
                .iconSet(SHINY)
                .components(Hydrogen, 9, Potassium, 2, Technetium, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11256 Potassium Perrhenate
        PotassiumPerrhenate = new Material.Builder(getId(), gregtechId("potassium_perrhenate"))
                .dust()
                .color(Potassium.getMaterialRGB() + Rhenium.getMaterialRGB())
                .iconSet(ROUGH)
                .components(Potassium, 1, Rhenium, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
