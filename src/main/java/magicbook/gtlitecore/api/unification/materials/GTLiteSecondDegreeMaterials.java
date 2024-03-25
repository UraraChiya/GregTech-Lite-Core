package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.ToolProperty;
import net.minecraft.util.text.TextFormatting;

import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialIconSet.CUSTOM_LEGENDARIUM;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialIconSet.CUSTOM_MAGNETO_RESONATIC;

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
                        .temp(3600, BlastProperty.GasTier.HIGH)
                        .blastStats(VA[EV], 454)
                        .vacuumStats(VA[MV], 280))
                .components(Cobalt, 4, Chrome, 3, Phosphorus, 2, Molybdenum, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR)
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
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_ROD, GENERATE_GEAR)
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
                        .temp(7200, BlastProperty.GasTier.HIGHER)
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
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_ROTOR)
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
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_RING)
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
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FRAME)
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
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_GEAR)
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
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR)
                .build();

        //  12016 Inconel-792
        Inconel792 = new Material.Builder(getId(), gregtechId("inconel_792"))
                .ingot()
                .fluid()
                .color(0x6CF076)
                .iconSet(SHINY)
                .components(Nickel, 2, Niobium, 1, Aluminium, 2, Nichrome, 1)
                .blast(b -> b
                        .temp(5200, BlastProperty.GasTier.HIGH)
                        .blastStats(VA[IV], 466)
                        .vacuumStats(VA[HV], 130))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_ROTOR, GENERATE_GEAR, GENERATE_SMALL_GEAR)
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
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_FRAME, GENERATE_PLATE, GENERATE_GEAR, GENERATE_SMALL_GEAR)
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
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FRAME, GENERATE_FOIL, GENERATE_GEAR)
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
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
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
                .iconSet(CUSTOM_MAGNETO_RESONATIC)
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
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR)
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
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_DOUBLE_PLATE)
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
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME)
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
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR)
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
                .flags(DISABLE_DECOMPOSITION, GENERATE_ROD, GENERATE_BOLT_SCREW)
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
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
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
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_DOUBLE_PLATE)
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
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_ROTOR)
                .components(Plutonium241, 18, Cerium, 9, Gadolinium, 3, Dysprosium, 3, Thulium, 2, TungstenCarbide, 6, RedSteel, 6, Duranium, 2, Radon, 2)
                .toolStats(new ToolProperty(18.0F, 40.0F, 75000, 30))
                .build();

        //  12039 Legendarium
        Legendarium = new Material.Builder(getId(), gregtechId("legendarium"))
                .ingot()
                .fluid()
                .color(0xF58FDA)
                .iconSet(CUSTOM_LEGENDARIUM)
                .components(Naquadria, 1, Trinium, 1, Duranium, 1, Tritanium, 1, Orichalcum, 1, Adamantium, 1, Vibranium, 1, Taranium, 1)
                .blast(b -> b
                        .temp(16500, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UIV], 998))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_ROUND, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_DOUBLE_PLATE, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build();

        //  12040 Abyssalloy
        Abyssalloy = new Material.Builder(getId(), gregtechId("abyssalloy"))
                .ingot()
                .fluid()
                .color(0x9E706A)
                .iconSet(METALLIC)
                .blast(b -> b
                        .temp(9625, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UEV]))
                .components(StainlessSteel, 5, TungstenCarbide, 5, Nichrome, 5, IncoloyMA956, 5, Germanium, 1, Rutherfordium, 1, Radon, 1)
                .cableProperties(V[UIV], 64, 64, false)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .build();

        //  12041 Platinum Group Alloy
        PlatinumGroupAlloy = new Material.Builder(getId(), gregtechId("platinum_group_alloy"))
                .ingot()
                .fluid()
                .color(Gold.getMaterialRGB() + Silver.getMaterialRGB() + Platinum.getMaterialRGB() + Palladium.getMaterialRGB() + Ruthenium.getMaterialRGB() + Rhodium.getMaterialRGB() + Iridium.getMaterialRGB() + Osmium.getMaterialRGB())
                .iconSet(BRIGHT)
                .components(Gold, 1, Silver, 1, Platinum, 1, Palladium, 1, Ruthenium, 1, Rhodium, 1, Iridium, 1, Osmium, 1)
                .blast(b -> b
                        .temp(10000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UV], 1800))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .build();

        //  12042 Superheavy-H Alloy
        SuperheavyHAlloy = new Material.Builder(getId(), gregtechId("superheavy_h_alloy"))
                .ingot()
                .fluid()
                .color(0xE84B36)
                .iconSet(SHINY)
                .components(Copernicium, 1, Nihonium, 1, MetastableFlerovium, 1, Moscovium, 1, Livermorium, 1, Tennessine, 1, MetastableOganesson, 1)
                .blast(b -> b
                        .temp(14960, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UIV], 1236))
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_ROD)
                .build();

        //  12043 Superheavy-L Alloy
        SuperheavyLAlloy = new Material.Builder(getId(), gregtechId("superheavy_l_alloy"))
                .ingot()
                .fluid()
                .color(0x4D8BE9)
                .iconSet(SHINY)
                .components(Rutherfordium, 1, Dubnium, 1, Seaborgium, 1, Bohrium, 1, MetastableHassium, 1, Meitnerium, 1, Darmstadtium, 1, Roentgenium, 1)
                .blast(b -> b
                        .temp(13800, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UEV], 990))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_FINE_WIRE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .build();

        //  12044 Alkalis Group Alloy
        AlkalisGroupAlloy = new Material.Builder(getId(), gregtechId("alkalis_group_alloy"))
                .ingot()
                .fluid()
                .color(Lithium.getMaterialRGB() + Sodium.getMaterialRGB() + Potassium.getMaterialRGB() + Rubidium.getMaterialRGB() + Caesium.getMaterialRGB() + Francium.getMaterialRGB())
                .iconSet(BRIGHT)
                .components(Lithium, 1, Sodium, 1, Potassium, 1, Rubidium, 1, Caesium, 1, Francium, 1)
                .blast(b -> b
                        .temp(9900, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UV], 800))
                .flags(GENERATE_PLATE)
                .build();

        //  12045 Alkaline Earth Group Alloy
        AlkalineEarthGroupAlloy = new Material.Builder(getId(), gregtechId("alkaline_earth_group_alloy"))
                .ingot()
                .fluid()
                .color(Beryllium.getMaterialRGB() + Magnesium.getMaterialRGB() + Calcium.getMaterialRGB() + Strontium.getMaterialRGB() + Barium.getMaterialRGB() + Radium.getMaterialRGB())
                .iconSet(BRIGHT)
                .components(Beryllium, 1, Magnesium, 1, Calcium, 1, Strontium, 1, Barium, 1, Radium, 1)
                .blast(b -> b
                        .temp(10000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UV], 850))
                .build();

        //  12046 Transition-L Alloy
        TransitionLAlloy = new Material.Builder(getId(), gregtechId("transition_l_alloy"))
                .ingot()
                .fluid()
                .color(Titanium.getMaterialRGB() + Vanadium.getMaterialRGB() + Chrome.getMaterialRGB() + Manganese.getMaterialRGB() + Iron.getMaterialRGB() + Cobalt.getMaterialRGB() + Nickel.getMaterialRGB() + Copper.getMaterialRGB())
                .iconSet(SHINY)
                .components(Titanium, 1, Vanadium, 1, Chrome, 1, Manganese, 1, Iron, 1, Cobalt, 1, Nickel, 1, Copper, 1)
                .blast(b -> b
                        .temp(10800, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 1050))
                .flags(GENERATE_PLATE)
                .build();

        //  12047 Transition-H Alloy
        TransitionHAlloy = new Material.Builder(getId(), gregtechId("transition_h_alloy"))
                .ingot()
                .fluid()
                .color(Zirconium.getMaterialRGB() + Niobium.getMaterialRGB() + Molybdenum.getMaterialRGB() + Technetium.getMaterialRGB() + Hafnium.getMaterialRGB() + Tantalum.getMaterialRGB() + Tungsten.getMaterialRGB() + Rhenium.getMaterialRGB())
                .iconSet(SHINY)
                .components(Zirconium, 1, Niobium, 1, Molybdenum, 1, Technetium, 1, Hafnium, 1, Tantalum, 1, Tungsten, 1, Rhenium, 1)
                .blast(b -> b
                        .temp(12000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 1200))
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .build();

        //  12048 Refractory Alloy
        RefractoryAlloy = new Material.Builder(getId(), gregtechId("refractory_alloy"))
                .ingot()
                .fluid()
                .color(Aluminium.getMaterialRGB() + Zinc.getMaterialRGB() + Gallium.getMaterialRGB() + Germanium.getMaterialRGB() + Cadmium.getMaterialRGB() + Indium.getMaterialRGB() + Tin.getMaterialRGB() + Antimony.getMaterialRGB())
                .iconSet(METALLIC)
                .components(Aluminium, 1, Zinc, 1, Gallium, 1, Germanium, 1, Cadmium, 1, Indium, 1, Tin, 1, Antimony, 1)
                .blast(b -> b
                        .temp(11800, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 860))
                .flags(GENERATE_PLATE)
                .build();

        //  12049 Inert Gas Mixture
        InertGasMixture = new Material.Builder(getId(), gregtechId("inert_gas_mixture"))
                .gas()
                .color(Helium.getMaterialRGB() + Neon.getMaterialRGB() + Argon.getMaterialRGB() + Krypton.getMaterialRGB() + Xenon.getMaterialRGB() + Radon.getMaterialRGB())
                .components(Helium, 1, Neon, 1, Argon, 1, Krypton, 1, Xenon, 1, Radon, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  12050 Lanthanum Group-L Alloy
        LanthanumGroupLAlloy = new Material.Builder(getId(), gregtechId("lanthanum_group_l_alloy"))
                .ingot()
                .fluid()
                .color(Lanthanum.getMaterialRGB() + Cerium.getMaterialRGB() + Praseodymium.getMaterialRGB() + Neodymium.getMaterialRGB() + Promethium.getMaterialRGB() + Samarium.getMaterialRGB() + Europium.getMaterialRGB() + Scandium.getMaterialRGB())
                .iconSet(METALLIC)
                .components(Lanthanum, 1, Cerium, 1, Praseodymium, 1, Neodymium, 1, Promethium, 1, Samarium, 1, Europium, 1, Scandium, 1)
                .blast(b -> b
                        .temp(13000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UEV], 400))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build();

        //  12051 Lanthanum Group-H Alloy
        LanthanumGroupHAlloy = new Material.Builder(getId(), gregtechId("lanthanum_group_h_alloy"))
                .ingot()
                .fluid()
                .color(Gadolinium.getMaterialRGB() + Terbium.getMaterialRGB() + Dysprosium.getMaterialRGB() + Holmium.getMaterialRGB() + Erbium.getMaterialRGB() + Thulium.getMaterialRGB() + Ytterbium.getMaterialRGB() + Lutetium.getMaterialRGB())
                .iconSet(METALLIC)
                .components(Gadolinium, 1, Terbium, 1, Dysprosium, 1, Holmium, 1, Erbium, 1, Thulium, 1, Ytterbium, 1, Lutetium, 1)
                .blast(b -> b
                        .temp(13100, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UEV], 420))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12051 Actinium Group-L Alloy
        ActiniumGroupLAlloy = new Material.Builder(getId(), gregtechId("actinium_group_l_alloy"))
                .ingot()
                .fluid()
                .color(Actinium.getMaterialRGB() + Thorium.getMaterialRGB() + Protactinium.getMaterialRGB() + Uranium238.getMaterialRGB() + Neptunium.getMaterialRGB() + Plutonium241.getMaterialRGB() + Americium.getMaterialRGB() + Yttrium.getMaterialRGB())
                .iconSet(SHINY)
                .components(Actinium, 1, Thorium, 1, Protactinium, 1, Uranium238, 1, Neptunium, 1, Plutonium241, 1, Americium, 1, Yttrium, 1)
                .blast(b -> b
                        .temp(14300, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UEV], 290))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build()
                .setFormula("AcThPaUNpPuAmY", false);

        //  12052 Actinium Group-H Alloy
        ActiniumGroupHAlloy = new Material.Builder(getId(), gregtechId("actinium_group_h_alloy"))
                .ingot()
                .fluid()
                .color(Curium.getMaterialRGB() + Berkelium.getMaterialRGB() + Californium.getMaterialRGB() + Einsteinium.getMaterialRGB() + Fermium.getMaterialRGB() + Mendelevium.getMaterialRGB() + Nobelium.getMaterialRGB() + Lawrencium.getMaterialRGB())
                .iconSet(SHINY)
                .components(Curium, 1, Berkelium, 1, Californium, 1, Einsteinium, 1, Fermium, 1, Mendelevium, 1, Nobelium, 1, Lawrencium, 1)
                .blast(b -> b
                        .temp(14500, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UEV], 300))
                .flags(GENERATE_ROD, GENERATE_RING)
                .build();

        //  12053 Halogen Mixture
        HalogenMixture = new Material.Builder(getId(), gregtechId("halogen_mixture"))
                .liquid()
                .color(Fluorine.getMaterialRGB() + Chlorine.getMaterialRGB() + Bromine.getMaterialRGB() + Iodine.getMaterialRGB() + Astatine.getMaterialRGB())
                .components(Fluorine, 1, Chlorine, 1, Bromine, 1, Iodine, 1, Astatine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  12054 Non-metallic Mixture
        NonMetallicMixture = new Material.Builder(getId(), gregtechId("non_metallic_mixture"))
                .liquid()
                .color(Hydrogen.getMaterialRGB() + Boron.getMaterialRGB() + Carbon.getMaterialRGB() + Nitrogen.getMaterialRGB() + Oxygen.getMaterialRGB() + Silicon.getMaterialRGB() + Phosphorus.getMaterialRGB() + Sulfur.getMaterialRGB() + Arsenic.getMaterialRGB() + Selenium.getMaterialRGB() + Tellurium.getMaterialRGB())
                .components(Hydrogen, 1, Boron, 1, Carbon, 1, Nitrogen, 1, Oxygen, 1, Silicon, 1, Phosphorus, 1, Sulfur, 1, Arsenic, 1, Selenium, 1, Tellurium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  12055 Toxic Alloy
        ToxicAlloy = new Material.Builder(getId(), gregtechId("toxic_alloy"))
                .ingot()
                .fluid()
                .color(Mercury.getMaterialRGB() + Thallium.getMaterialRGB() + Lead.getMaterialRGB() + Bismuth.getMaterialRGB() + Polonium.getMaterialRGB())
                .iconSet(METALLIC)
                .components(Mercury, 1, Thallium, 1, Lead, 1, Bismuth, 1, Polonium, 1)
                .blast(b -> b
                        .temp(10800, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UV]))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12056 Rare Earth Alloy
        RareEarthAlloy = new Material.Builder(getId(), gregtechId("rare_earth_alloy"))
                .dust()
                .color(LanthanumGroupLAlloy.getMaterialRGB() + LanthanumGroupHAlloy.getMaterialRGB() + ActiniumGroupLAlloy.getMaterialRGB() + ActiniumGroupHAlloy.getMaterialRGB())
                .components(LanthanumGroupLAlloy, 1, LanthanumGroupHAlloy, 1, ActiniumGroupLAlloy, 1, ActiniumGroupHAlloy, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("LaCePrNdPmSmEuGdTbDyHoErTmYbLuScYAcThPaUNpPuAmCmBkCfEsFmMdNoLr", false);

        //  12057 Periodicium
        Periodicium = new Material.Builder(getId(), gregtechId("periodicium"))
                .ingot()
                .liquid()
                .color(0x3D4BF6)
                .iconSet(BRIGHT)
                .flags(GENERATE_PLATE, GENERATE_ROD)
                .blast(b -> b
                        .temp(15500, BlastProperty.GasTier.HIGHEST))
                .build()
                .setFormula("HHeLiBeBCNOFNeNaMgAlSiPSClArKCaScTiVCrMnFeCoNiCuZnGaGeAsSeBrKrRbSrYZrNbMoTcRuRhPdAgCdInSnSbTeIXeCsBaLaCePrNdPmSmEuGdTbDyHoErTmYbLuHfTaWReOsIrPtAuHgTlPbBiPoAtRnFrRaAcThPaUNpPuAmCmBkCfEsFmMdNoLrRfDbSgBhHsMtDsRgCnNhFlMcLvTsOg");

        //  12058 Charged Caesium-Cerium-Cobalt-Indium Alloy
        ChargedCaesiumCeriumCobaltIndiumAlloy = new Material.Builder(getId(), gregtechId("charged_caesium_cerium_cobalt_indium_alloy"))
                .ingot()
                .fluid()
                .color(0x01E068)
                .iconSet(MAGNETIC)
                .blast(b -> b
                        .temp(15000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 353))
                .components(Caesium, 1, Cerium, 1, Cobalt, 2, Indium, 10)
                .flags(GENERATE_ROD, GENERATE_BOLT_SCREW)
                .build();

        //  12059 BETSPerrhenate
        BETSPerrhenate = new Material.Builder(getId(), gregtechId("bets_perrhenate"))
                .dust()
                .color(0x98E993)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SHINY)
                .components(Rhenium, 1, Carbon, 10, Hydrogen, 8, Sulfur, 4, Selenium, 4, Oxygen, 4)
                .build();

        //  12060 Boron Francium Carbide Superconductor
        BoronFranciumCarbideSuperconductor = new Material.Builder(getId(), gregtechId("boron_francium_carbide_superconductor"))
                .ingot()
                .fluid()
                .color(0x359FFC)
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(18400, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UXV], 190))
                .components(BoronFranciumCarbide, 15, ChargedCaesiumCeriumCobaltIndiumAlloy, 14, CubicBoronNitride, 12, StrontiumCarbonate, 10, MetastableHassium, 5, MetastableOganesson, 2, BETSPerrhenate, 1, MercuryCadmiumTelluride, 1)
                .cableProperties(V[UXV], 128, 0, true)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .build();

        //  12061 Tantalum Hafnium Seaborgium Carbide
        TantalumHafniumSeaborgiumCarbide = new Material.Builder(getId(), gregtechId("tantalum_hafnium_seaborgium_carbide"))
                .ingot()
                .fluid()
                .color(0x2C2C2C)
                .iconSet(SHINY)
                .components(Tantalum, 12, Hafnium, 3, Seaborgium, 1, Carbon, 16)
                .blast(b -> b
                        .temp(13000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 53))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_RING, GENERATE_BOLT_SCREW)
                .build();

        //  12062 Hastelloy-K243
        HastelloyK243 = new Material.Builder(getId(), gregtechId("hastelloy_k_243"))
                .ingot()
                .fluid()
                .color(0x92D959)
                .iconSet(SHINY)
                .components(HastelloyX78, 5, NiobiumNitride, 2, Tritanium, 4, Promethium, 4, Mendelevium, 1)
                .blast(b -> b
                        .temp(14400, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UEV], 304)
                        .vacuumStats(VA[ZPM], 680))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12063 Nitinol-60
        Nitinol60 = new Material.Builder(getId(), gregtechId("nitinol_60"))
                .ingot()
                .fluid()
                .color(0xCCB0EC)
                .iconSet(SHINY)
                .components(Nickel, 2, Titanium, 3)
                .blast(b -> b
                        .temp(1941, BlastProperty.GasTier.HIGH)
                        .blastStats(VA[EV], 650)
                        .vacuumStats(VA[MV], 144))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12064 Tumbaga
        Tumbaga = new Material.Builder(getId(), gregtechId("tumbaga"))
                .ingot()
                .fluid()
                .color(0xF2A80E)
                .iconSet(SHINY)
                .components(Gold, 7, Bronze, 3)
                .blast(b -> b
                        .temp(1200, BlastProperty.GasTier.MID)
                        .blastStats(VA[HV], 980))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_GEAR)
                .build();

        //  12065 Octiron
        Octiron = new Material.Builder(getId(), gregtechId("octiron"))
                .ingot()
                .fluid()
                .color(0x3B4129)
                .iconSet(METALLIC)
                .components(TitanSteel, 8, BlackPlutonium, 8, MetastableFlerovium, 8, MetastableHassium, 8, Tritanium, 8, Thorium, 8, Neptunium, 8, Nobelium, 8)
                .blast(b -> b
                        .temp(16600, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[ULV], 88888)
                        .vacuumStats(VA[ULV], 88888))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_ROTOR)
                .toolStats(new ToolProperty(36.0F, 80.0F, 100000, 30))
                .build();

        //  12066 Botmium
        Botmium = new Material.Builder(getId(), gregtechId("botmium"))
                .ingot()
                .fluid()
                .color(0x51AD6D)
                .iconSet(METALLIC)
                .components(Nitinol60, 1, Osmium, 6, Ruthenium, 6, Thallium, 3)
                .blast(b -> b
                        .temp(8495, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UV], 120)
                        .vacuumStats(VA[UV], 165))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build();

        //  12067 Tairitsium
        Tairitsium = new Material.Builder(getId(), gregtechId("tairitsium"))
                .ingot()
                .fluid()
                .color(0x003F5F)
                .iconSet(METALLIC)
                .components(BlackSteel, 8, Tungsten, 8, Naquadria, 7, Taranium, 4, Carbon, 4, Vanadium, 3)
                .blast(b -> b
                        .temp(7400, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 400)
                        .vacuumStats(VA[EV], 130))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .build();

        //  12068 Transcendent Metal
        TranscendentMetal = new Material.Builder(getId(), gregtechId("transcendent_metal"))
                .ingot()
                .liquid()
                .color(0x1A1A1A)
                .iconSet(METALLIC)
                .blast(b -> b
                        .temp(18000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UXV], 3)
                        .vacuumStats(VA[UXV], 3))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_BOLT_SCREW, GENERATE_RING, GENERATE_FRAME, GENERATE_ROTOR, GENERATE_ROUND)
                .build()
                .setFormula(TextFormatting.OBFUSCATED + "aaaaaa", false);

        //  12070 Arcanium
        Arcanium = new Material.Builder(getId(), gregtechId("arcanium"))
                .ingot()
                .fluid()
                .color(0xD54338)
                .iconSet(BRIGHT)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_DOUBLE_PLATE)
                .blast(b -> b
                        .temp(18300, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UXV], 100)
                        .vacuumStats(VA[UXV], 100))
                .components(Hikarium, 1, Tairitsium, 1, Astralium, 1, LunaSilver, 1, Solarium, 1, RedAlloy, 1)
                .cableProperties(V[OpV], 128, 256, false)
                .build();

        //  12071 Laurenium
        Laurenium = new Material.Builder(getId(), gregtechId("laurenium"))
                .ingot()
                .fluid()
                .color(0xE564E4)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(EglinSteel, 8, Indium, 2, Chrome, 4, Lanthanum, 1, Rhenium, 1)
                .blast(b -> b
                        .temp(7100, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[LuV], 400)
                        .vacuumStats(VA[IV]))
                .build();

        //  12072 NeutroniumSuperconductor
        NeutroniumSuperconductor = new Material.Builder(getId(), gregtechId("neutronium_superconductor"))
                .ingot()
                .fluid()
                .color(0xF8BCD5)
                .iconSet(BRIGHT)
                .components(CosmicNeutronium, 4, Legendarium, 5, Laurenium, 5, Botmium, 5, NeutroniumNanotube, 4, TantalumHafniumSeaborgiumCarbide, 3, IndiumGalliumPhosphide, 3, RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexafluorophosphate, 12)
                .blast(b -> b
                        .temp(18300, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[OpV], 180)
                        .vacuumStats(VA[UIV], 90))
                .cableProperties(V[OpV], 512, 0, true)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .build();

        //  12073 Fluxed Electrum
        FluxedElectrum = new Material.Builder(getId(), gregtechId("fluxed_electrum"))
                .ingot()
                .fluid()
                .color(0xFFE049)
                .iconSet(BRIGHT)
                .components(Electrum, 8, RoseGold, 4, SterlingSilver, 4, NaquadahEnriched, 2)
                .blast(b -> b
                        .temp(8400, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[ZPM], 877)
                        .vacuumStats(VA[IV], 405))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12074 Arceus Alloy 2B
        ArceusAlloy2B = new Material.Builder(getId(), gregtechId("arceus_alloy_2_b"))
                .ingot()
                .fluid()
                .color(0xC4A415)
                .iconSet(SHINY)
                .components(Pikyonium64B, 12, Tritanium, 8, Tumbaga, 6, NaquadahEnriched, 4, RhodiumPlatedPalladium, 4, HSSE, 2, MolybdenumDisilicide, 2, Technetium, 2)
                .blast(b -> b
                        .temp(10650, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 1024)
                        .vacuumStats(VA[ZPM], 338))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_FOIL)
                .build();

        //  12075 Incoloy-020
        Incoloy020 = new Material.Builder(getId(), gregtechId("incoloy_020"))
                .ingot()
                .fluid()
                .color(0x634F46)
                .iconSet(METALLIC)
                .components(Iron, 12, Cupronickel, 4, Bronze, 4, Nichrome, 8, Molybdenum, 6, Silicon, 3, Manganese, 2)
                .blast(b -> b
                        .temp(5475, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[LuV], 884)
                        .vacuumStats(VA[EV], 365))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_DOUBLE_PLATE)
                .build();

        //  12076 Hattrium
        Hattrium = new Material.Builder(getId(), gregtechId("hattrium"))
                .ingot()
                .fluid()
                .color(0xE0F3F3)
                .iconSet(SHINY)
                .components(BlueAlloy, 15, Sapphire, 12, BlueSteel, 8, Magnalium, 6, Beryllium, 4, Diamond, 2, Quartzite, 2, Xenon, 1)
                .blast(b -> b
                        .temp(10800, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UV], 318)
                        .vacuumStats(VA[LuV], 109))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
