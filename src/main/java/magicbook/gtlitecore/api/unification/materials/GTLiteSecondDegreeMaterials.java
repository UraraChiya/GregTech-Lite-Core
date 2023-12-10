package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.ToolProperty;

import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class GTLiteSecondDegreeMaterials {

    //  Range: 12001-13000
    private static int startId = 12001;
    private static final int endId = startId + 999;

    public static void register() {
        //  12001 Inconel-625
        Inconel625 = new Material.Builder(getId(), gregtechId("inconel_625"))
                .ingot()
                .fluid()
                .color(0x3fcc60)
                .iconSet(METALLIC)
                .blast(b -> b
                        .temp(4850, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[IV], 1000)
                        .vacuumStats(VA[HV], 200))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_ROTOR)
                .components(Nickel, 8, Chrome, 6, Molybdenum, 4, Niobium, 4, Titanium, 3, Iron, 2, Aluminium, 2)
                .fluidPipeProperties(4500, 340, true, true, true, false)
                .build();
      
        //  12002 Hastelloy-N
        HastelloyN = new Material.Builder(getId(), gregtechId("hastelloy_n"))
                .ingot()
                .fluid()
                .color(0x939554)
                .iconSet(DULL)
                .blast(b -> b
                        .temp(4550, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[EV], 800)
                        .vacuumStats(VA[HV], 180))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_BOLT_SCREW, GENERATE_ROTOR, GENERATE_FRAME)
                .components(Nickel, 15, Molybdenum, 4, Chrome, 2, Titanium, 2, Yttrium, 2)
                .fluidPipeProperties(4380, 300, true, true, true,false)
                .build();

        //  12003 Austenitic Stainless Steel-904L
        AusteniticStainlessSteel904L = new Material.Builder(getId(), gregtechId("super_austenitic_stainless_steel_904_l"))
                .ingot()
                .fluid()
                .color(0x881357)
                .iconSet(METALLIC)
                .blast(b -> b
                        .temp(4960, BlastProperty.GasTier.MID)
                        .blastStats(VA[EV], 944)
                        .vacuumStats(VA[HV], 320))
                .components(StainlessSteel, 8, NickelZincFerrite, 4, Kanthal, 4, Molybdenum, 4)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_BOLT_SCREW)
                .build();

        //  12004 Tanmolyium Beta-C
        TanmolyiumBetaC = new Material.Builder(getId(), gregtechId("tanmolyium_beta_c"))
                .ingot()
                .fluid()
                .color(0xc72fcc)
                .iconSet(METALLIC)
                .blast(b -> b
                        .temp(5300, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[IV], 800)
                        .vacuumStats(VA[HV], 400))
                .components(Titanium, 5, Molybdenum, 5, Vanadium, 2, Chrome, 3, Aluminium, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build();

        //  12005 Talonite
        Talonite = new Material.Builder(getId(), gregtechId("talonite"))
                .ingot()
                .fluid()
                .color(0x9991A5)
                .iconSet(SHINY)
                .blast(b -> b
                        .blastStats(VA[EV], 454)
                        .vacuumStats(VA[MV], 280))
                .components(Cobalt, 4, Chrome, 3, Phosphorus, 2, Molybdenum, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12006 Hastelloy-X78
        HastelloyX78 = new Material.Builder(getId(), gregtechId("hastelloy_x_78"))
                .ingot()
                .fluid()
                .color(0x6BA3E3)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(12800, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 1997)
                        .vacuumStats(VA[LuV], 340))
                .components(NaquadahAlloy, 10, Rhenium, 5, Naquadria, 4, Gadolinium, 3, Strontium, 2, Polonium, 3, Rutherfordium, 2)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12007 Silicon Carbide
        SiliconCarbide = new Material.Builder(getId(), gregtechId("silicon_carbide"))
                .dust()
                .fluid()
                .color(0x4D4D4D)
                .iconSet(METALLIC)
                .flags(GENERATE_FINE_WIRE)
                .components(Silicon, 1, Carbon, 1)
                .blast(b -> b
                        .temp(2500, BlastProperty.GasTier.HIGH)
                        .blastStats(VA[UV])
                        .vacuumStats(VA[EV], 280))
                .cableProperties(V[UHV], 6, 8, false)
                .build();

        //  12008 MAR-M200 Steel
        MARM200Steel = new Material.Builder(getId(), gregtechId("mar_m_200_steel"))
                .ingot()
                .fluid()
                .color(0x515151)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(5000, BlastProperty.GasTier.HIGH)
                        .blastStats(VA[IV], 200)
                        .vacuumStats(VA[HV], 120))
                .components(Niobium, 2, Chrome, 9, Aluminium, 5, Titanium, 2, Cobalt, 10, Tungsten, 13, Nickel, 18)
                .flags(GENERATE_PLATE, GENERATE_ROTOR, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12009 MAR-M200-Ce Steel
        MARM200CeSteel = new Material.Builder(getId(), gregtechId("mar_m_200_ce_steel"))
                .ingot()
                .fluid()
                .color(0x383030)
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(7500, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[LuV], 432)
                        .vacuumStats(VA[EV], 180))
                .components(MARM200Steel, 18, Cerium, 1)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE)
                .build();

        //  12010 Stellite
        Stellite = new Material.Builder(getId(), gregtechId("stellite"))
                .ingot()
                .fluid()
                .color(0x9991A5)
                .iconSet(METALLIC)
                .blast(b -> b
                        .temp(4310, BlastProperty.GasTier.HIGH)
                        .blastStats(VA[EV], 220)
                        .vacuumStats(VA[MV], 90))
                .components(Chrome, 9, Cobalt, 9, Manganese, 5, Titanium, 2)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build();

        //  12011 Hastelloy-C59
        HastelloyC59 = new Material.Builder(getId(), gregtechId("hastelloy_c_59"))
                .ingot()
                .fluid()
                .color(0xD6D0F0)
                .iconSet(DULL)
                .blast(b -> b
                        .temp(7600, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[LuV], 559)
                        .vacuumStats(VA[EV], 300))
                .components(Nickel, 18, Chrome, 16, TinAlloy, 8, Cobalt, 6, Niobium, 4, Aluminium, 4)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12012 HMS-1J79Alloy
        HMS1J79Alloy = new Material.Builder(getId(), gregtechId("hms_1_j_79_alloy"))
                .ingot()
                .fluid()
                .color(0xD1CB0B)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(8100, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[LuV], 886)
                        .vacuumStats(VA[EV], 400))
                .components(Nickel, 14, Iron, 12, Molybdenum, 11, CobaltBrass, 8, Chrome, 6, Silicon, 4)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE)
                .build();

        //  12013 High Strength Structural Steel-HY130-1
        HY1301 = new Material.Builder(getId(), gregtechId("hy_1301"))
                .ingot()
                .fluid()
                .color(0x6F3E57)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(7850, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[LuV], 766)
                        .vacuumStats(VA[EV], 357))
                .components(Nickel, 9, NickelZincFerrite, 6, Chrome, 4, Nichrome, 4, Iron, 4, Molybdenum, 4, Rhenium, 2)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build();

        //  12014 Incoloy-MA813
        IncoloyMA813 = new Material.Builder(getId(), gregtechId("incoloy_ma_813"))
                .ingot()
                .fluid()
                .color(0x6CF076)
                .iconSet(SHINY)
                .components(VanadiumSteel, 4, Osmiridium, 2, HSSS, 3, Germanium, 4, Duranium, 5)
                .blast(b -> b
                        .temp(8400, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[ZPM], 1277)
                        .vacuumStats(VA[IV], 400))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_FRAME)
                .build();

        //  12015 Lafium
        Lafium = new Material.Builder(getId(), gregtechId("lafium"))
                .ingot()
                .fluid()
                .color(0x0D0D60)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(9865, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 860)
                        .vacuumStats(VA[ZPM], 260))
                .components(HastelloyN, 8, Naquadria, 4, Samarium, 2, Tungsten, 4, Aluminium, 6, Nickel, 8, Titanium, 4, Carbon, 2, Argon, 2)
                .fluidPipeProperties(23000, 8000, true, true, true, true)
                .build();

        //  12016 Inconel-792
        Inconel792 = new Material.Builder(getId(), gregtechId("inconel_792"))
                .ingot()
                .fluid()
                .color(0x6CF076)
                .iconSet(SHINY)
                .components(Nickel, 2, Niobium, 1, Aluminium, 2, Nichrome, 1)
                .blast(b -> b
                        .temp(6200, BlastProperty.GasTier.HIGH)
                        .blastStats(VA[IV], 466)
                        .vacuumStats(VA[HV], 130))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_ROTOR)
                .fluidPipeProperties(4900, 220, true, true, true, false)
                .build();

        //  12017 Eglin Steel Base
        EglinSteelBase = new Material.Builder(getId(), gregtechId("eglin_steel_base"))
                .dust()
                .color(0x8B4513)
                .iconSet(SAND)
                .components(Iron, 4, Kanthal, 1, Invar, 5)
                .build();

        //  12018 Eglin Steel
        EglinSteel = new Material.Builder(getId(), gregtechId("eglin_steel"))
                .ingot()
                .fluid()
                .color(0x8B4513)
                .iconSet(METALLIC)
                .components(EglinSteelBase, 10, Sulfur, 1, Silicon, 1, Carbon, 1)
                .blast(b -> b
                        .temp(1048, BlastProperty.GasTier.LOW)
                        .blastStats(VA[MV], 24))
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_FRAME)
                .build();

        //  12019 Pikyonium-64B
        Pikyonium64B = new Material.Builder(getId(), gregtechId("pikyonium_64_b"))
                .ingot()
                .fluid()
                .color(0x3467BA)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(10400, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[ZPM], 487)
                        .vacuumStats(VA[IV], 170))
                .components(Inconel792, 8, EglinSteel, 5, NaquadahAlloy, 4, TungstenSteel, 4, Cerium, 3, Antimony, 2, Platinum, 2, Ytterbium, 1)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FRAME)
                .build();

        //  12020 Cinobite
        Cinobite = new Material.Builder(getId(), gregtechId("cinobite"))
                .ingot()
                .fluid()
                .color(0x010101)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(10460, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[UV], 800)
                        .vacuumStats(VA[LuV], 140))
                .components(Zeron100, 8, Stellite100, 6, Titanium, 6, Naquadria, 4, Osmiridium, 3, Aluminium, 2, Tin, 1, Mercury, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build();

        //  12021 Titan Steel
        TitanSteel = new Material.Builder(getId(), gregtechId("titan_steel"))
                .ingot()
                .fluid()
                .color(0xAA0D0D)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(10600, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 1200)
                        .vacuumStats(VA[ZPM], 180))
                .components(TitaniumTungstenCarbide, 6, AusteniticStainlessSteel904L, 3, Ruby, 3)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build();

        //  12022 Quantum Alloy
        QuantumAlloy = new Material.Builder(getId(), gregtechId("quantum_alloy"))
                .ingot()
                .fluid()
                .color(0x954FE0)
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(13501, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 1400)
                        .vacuumStats(VA[LuV], 240))
                .components(Stellite, 15, CadmiumSelenide, 8, Emerald, 5, Gallium, 5, Americium, 5, Palladium, 5, Bismuth, 5, Germanium, 5)
                .cableProperties(V[UEV], 32, 0, true)
                .flags(GENERATE_PLATE)
                .build();

        //  12023 Prasiolite
        Prasiolite = new Material.Builder(getId(), gregtechId("prasiolite"))
                .gem()
                .color(0x9EB749)
                .iconSet(QUARTZ)
                .flags(CRYSTALLIZABLE, GENERATE_LENS)
                .components(SiliconDioxide, 5, Iron, 1)
                .build();

        //  12024 Bismuth Tellurite
        BismuthTellurite = new Material.Builder(getId(), gregtechId("bismuth_tellurite"))
                .dust()
                .color(0x0E8933)
                .iconSet(DULL)
                .components(Bismuth, 2, Tellurium, 3)
                .build();

        //  12025 Magneto Resonatic
        MagnetoResonatic = new Material.Builder(getId(), gregtechId("magneto_resonatic"))
                .gem()
                .color(0xFF97FF)
                .iconSet(MAGNETIC)
                .components(Prasiolite, 3, BismuthTellurite, 6, CubicZirconia, 1, SteelMagnetic, 1)
                .flags(NO_SMELTING, GENERATE_LENS)
                .build();

        //  12026 HDCS (High Durability Compound Steel)
        Hdcs = new Material.Builder(getId(), gregtechId("hdcs"))
                .ingot()
                .fluid()
                .color(0x334433)
                .iconSet(SHINY)
                .toolStats(ToolProperty.Builder.of(20.0F, 10.0F, 18000, 18)
                                       .magnetic()
                                       .build())
                .blast(b -> b
                        .temp(11900, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 1800)
                        .vacuumStats(VA[LuV]))
                .components(TungstenSteel, 12, HSSS, 9, HSSG, 6, Ruridit, 3, MagnetoResonatic, 2, Plutonium241, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_ROUND, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_DOUBLE_PLATE, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE)
                .build();

        //  12027 Zirconium Carbide
        ZirconiumCarbide = new Material.Builder(getId(), gregtechId("zirconium_carbide"))
                .ingot()
                .fluid()
                .color(0xFFDACD)
                .iconSet(SHINY)
                .components(Zirconium, 1, Carbon, 1)
                .blast(b -> b
                        .temp(1200, BlastProperty.GasTier.MID)
                        .blastStats(VA[HV], 344))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12028 Maraging Steel 250
        MaragingSteel250 = new Material.Builder(getId(), gregtechId("maraging_steel_250"))
                .ingot()
                .fluid()
                .color(0xA5ADB2)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(2413, BlastProperty.GasTier.MID)
                        .blastStats(VA[EV], 680))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_GEAR)
                .components(Steel, 16, Molybdenum, 1, Titanium, 1, Nickel, 4, Cobalt, 2)
                .build();

        //  12029 HMS-1J22 Alloy
        HMS1J22Alloy = new Material.Builder(getId(), gregtechId("hms_1_j_22_alloy"))
                .ingot()
                .fluid()
                .color(0x9E927D)
                .iconSet(DULL)
                .components(Nickel, 12, TinAlloy, 8, Chrome, 4, Phosphorus, 2, Silicon, 2)
                .blast(b -> b
                        .temp(4330, BlastProperty.GasTier.MID)
                        .blastStats(VA[EV], 290))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12030 HG-1223
        HG1223 = new Material.Builder(getId(), gregtechId("hg_1223"))
                .ingot()
                .fluid()
                .color(0x235497)
                .iconSet(SHINY)
                .components(Mercury, 1, Barium, 2, Calcium, 2, Copper, 3, Oxygen, 8)
                .blast(b -> b
                        .temp(5325, BlastProperty.GasTier.HIGH)
                        .blastStats(VA[EV], 301))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE)
                .build();

        //  12031 Staballoy
        Staballoy = new Material.Builder(getId(), gregtechId("staballoy"))
                .ingot()
                .fluid()
                .color(0x444B42)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(3450, BlastProperty.GasTier.HIGH)
                        .blastStats(VA[EV], 462))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_ROTOR, GENERATE_DOUBLE_PLATE)
                .components(Uranium238, 9, Titanium, 1)
                .build();

        //  12032 Incoloy-DS
        IncoloyDS = new Material.Builder(getId(), gregtechId("incoloy_ds"))
                .ingot()
                .fluid()
                .color(0x6746B7)
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(5680, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[IV], 680))
                .components(Iron, 23, Cobalt, 9, Chrome, 9, Nickel, 9)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE)
                .build();

        //  12033 Tantalloy-61
        Tantalloy61 = new Material.Builder(getId(), gregtechId("tantalloy_61"))
                .ingot()
                .fluid()
                .color(0x717171)
                .iconSet(METALLIC)
                .components(Tantalum, 13, Tungsten, 12, Titanium, 6, Yttrium, 4)
                .blast(b -> b
                        .temp(6900, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[LuV], 901))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build();

        //  12034 Lithium Titanate
        LithiumTitanate = new Material.Builder(getId(), gregtechId("lithium_titanate"))
                .ingot()
                .color(0xFE71A9)
                .iconSet(SHINY)
                .blast(3100)
                .components(Lithium, 2, Titanium, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION, GENERATE_ROD, GENERATE_BOLT_SCREW)
                .fluidPipeProperties(2830, 200, true, true, false, false)
                .build();

        //  12035 Lanthanum Fullerene Nanotube
        LanthanumFullereneNanotube = new Material.Builder(getId(), gregtechId("lanthanum_fullerene_nanotube"))
                .ingot()
                .color(0xD24473)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(C60H30)C48La2", true);

        //  12036 Fullerene Superconductor
        FullereneSuperconductor = new Material.Builder(getId(), gregtechId("fullerene_superconductor"))
                .ingot()
                .fluid()
                .color(0x8BF743)
                .iconSet(BRIGHT)
                .components(TitaniumTungstenCarbide, 16, LanthanumFullereneNanotube, 4, MetastableOganesson, 4, Cinobite, 3, Radium, 2, Astatine, 2)
                .blast(b -> b
                        .temp(14960, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UIV], 560))
                .cableProperties(V[UIV], 256, 0, true)
                .build();

        //  12037 Black Titanium
        BlackTitanium = new Material.Builder(getId(), gregtechId("black_titanium"))
                .ingot()
                .fluid()
                .color(0x6C003B)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(11500, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UEV], 580))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Titanium, 26, Lanthanum, 6, TungstenSteel, 4, Cobalt, 3, Manganese, 2, Phosphorus, 2, Palladium, 2, Niobium, 1, Argon, 5)
                .toolStats(new ToolProperty(9.0F, 30.0F, 32000, 20))
                .build();

        //  12038 Black Plutonium
        BlackPlutonium = new Material.Builder(getId(), gregtechId("black_plutonium"))
                .ingot()
                .fluid()
                .color(0x060606)
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(12960, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UIV], 600))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Plutonium241, 18, Cerium, 9, Gadolinium, 3, Dysprosium, 3, Thulium, 2, TungstenCarbide, 6, RedSteel, 6, Duranium, 2, Radon, 2)
                .toolStats(new ToolProperty(18.0F, 40.0F, 75000, 30))
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
