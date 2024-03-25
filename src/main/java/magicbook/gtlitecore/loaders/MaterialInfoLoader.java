package magicbook.gtlitecore.loaders;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.common.blocks.*;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.common.metatileentities.MetaTileEntities.HULL;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class MaterialInfoLoader {

    public static void init() {
        MachineCasings();
        Glasses();
        VoltageCoils();
        CoilBlocks();
    }

    private static void MachineCasings() {

        //  UHV Machine Casing
        OreDictUnifier.registerOre(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV),
                new ItemMaterialInfo(new MaterialStack(Orichalcum, M * 8)));

        //  UHV Machine Hull
        OreDictUnifier.registerOre(HULL[UHV].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(Orichalcum, M * 8),
                new MaterialStack(Europium, M),
                new MaterialStack(Polyetheretherketone, M * 2)));

        //  UEV Machine Casing
        OreDictUnifier.registerOre(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UEV),
                new ItemMaterialInfo(new MaterialStack(Adamantium, M * 8)));

        //  UEV Machine Hull
        OreDictUnifier.registerOre(HULL[UEV].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(Adamantium, M * 8),
                new MaterialStack(PedotTMA, M),
                new MaterialStack(Polyetheretherketone, M * 2)));

        //  UIV Machine Casing
        OreDictUnifier.registerOre(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UIV),
                new ItemMaterialInfo(new MaterialStack(Infinity, M * 8)));

        //  UIV Machine Hull
        OreDictUnifier.registerOre(HULL[UIV].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(Infinity, M * 8),
                new MaterialStack(Solarium, M),
                new MaterialStack(Polyetheretherketone, M * 2)));

        //  UXV Machine Casing
        OreDictUnifier.registerOre(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UXV),
                new ItemMaterialInfo(new MaterialStack(CosmicNeutronium, M * 8)));

        //  UXV Machine Hull
        OreDictUnifier.registerOre(HULL[UXV].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(CosmicNeutronium, M * 8),
                new MaterialStack(Hypogen, M),
                new MaterialStack(Zylon, M * 2)));

        //  OpV Machine Casing
        OreDictUnifier.registerOre(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.OpV),
                new ItemMaterialInfo(new MaterialStack(Spacetime, M * 8)));

        //  OpV Machine Hull
        OreDictUnifier.registerOre(HULL[OpV].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(Spacetime, M * 8),
                new MaterialStack(Galaxium, M),
                new MaterialStack(Zylon, M * 2)));

        //  MAX Machine Casing
        OreDictUnifier.registerOre(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX),
                new ItemMaterialInfo(new MaterialStack(Eternity, M * 8)));

        //  MAX Machine Hull
        OreDictUnifier.registerOre(HULL[MAX].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(Eternity, M * 8),
                new MaterialStack(Universium, M),
                new MaterialStack(Zylon, M * 2)));

    }

    private static void Glasses() {
        //  Common Glasses

        //  BPA Polycarbonate Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.BPA_POLYCARBONATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BPAPolycarbonate, M * 4)));

        //  PMMA Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.PMMA_GLASS),
                new ItemMaterialInfo(new MaterialStack(PMMA, M * 4)));

        //  CBDO Polycarbonate Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.CBDO_POLYCARBONATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(CBDOPolycarbonate, M * 4)));

        //  Infinity Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.INFINITY_GLASS),
                new ItemMaterialInfo(new MaterialStack(Infinity, M * 4)));

        //  Decorative Glasses

        //  Borosilicate Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.BOROSILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4)));

        //  Titanium reinforced Borosilicate Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.TITANIUM_REINFORCED_BOROSILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                        new MaterialStack(Titanium, M * 4)));

        //  Tungsten reinforced Borosilicate Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.TUNGSTEN_REINFORCED_BOROSILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                        new MaterialStack(Tungsten, M * 4)));

        //  Osmium reinforced Borosilicate Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.OSMIUM_REINFORCED_BOROSILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                        new MaterialStack(Osmium, M * 4)));

        //  Naquadah reinforced Borosilicate Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.NAQUADAH_REINFORCED_BOROSILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                        new MaterialStack(Naquadah, M * 4)));

        //  Trinium reinforced Borosilicate Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.TRINIUM_REINFORCED_BOROSILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                        new MaterialStack(Trinium, M * 4)));

        //  Mithril reinforced Borosilicate Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.MITHRIL_REINFORCED_BOROSILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                        new MaterialStack(Mithril, M * 4)));

        //  Neutronium reinforced Borosilicate Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.NEUTRONIUM_REINFORCED_BOROSILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                        new MaterialStack(Neutronium, M * 4)));

        //  Abyssalloy reinforced Borosilicate Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.ABYSSALLOY_REINFORCED_BOROSILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                        new MaterialStack(Abyssalloy, M * 4)));

        //  Heavy Quark Degenerate Matter reinforced Borosilicate Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.HEAVY_QUARK_DEGENERATE_MATTER_REINFORCED_BOROSILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                        new MaterialStack(HeavyQuarkDegenerateMatter, M * 4)));

        //  Transcendent Metal reinforced Borosilicate Glass
        OreDictUnifier.registerOre(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.TRANSCENDENT_METAL_REINFORCED_BOROSILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                        new MaterialStack(TranscendentMetal, M * 4)));
    }

    private static void VoltageCoils() {

        //  UHV Voltage Coil
        OreDictUnifier.registerOre(VOLTAGE_COIL_UHV.getStackForm(), new ItemMaterialInfo (
                new MaterialStack(ChromiumGermaniumTellurideMagnetic, M / 2),
                new MaterialStack(Vibranium, M * 2)));

        //  UEV Voltage Coil
        OreDictUnifier.registerOre(VOLTAGE_COIL_UEV.getStackForm(), new ItemMaterialInfo (
                new MaterialStack(ChromiumGermaniumTellurideMagnetic, M / 2),
                new MaterialStack(Mithril, M * 2)));

        //  UIV Voltage Coil
        OreDictUnifier.registerOre(VOLTAGE_COIL_UIV.getStackForm(), new ItemMaterialInfo (
                new MaterialStack(PhosphorusDopedEuropiumIronArsenideMagnetic, M / 2),
                new MaterialStack(Astralium, M * 2)));

        //  UXV Voltage Coil
        OreDictUnifier.registerOre(VOLTAGE_COIL_UXV.getStackForm(), new ItemMaterialInfo(
                new MaterialStack(PhosphorusDopedEuropiumIronArsenideMagnetic, M / 2),
                new MaterialStack(Hikarium, M * 2)));

        //  OpV Voltage Coil
        OreDictUnifier.registerOre(VOLTAGE_COIL_OpV.getStackForm(), new ItemMaterialInfo(
                new MaterialStack(BismuthLawrenciumStrontiumCuprateMagnetic, M / 2),
                new MaterialStack(Arcanium, M * 2)));
    }

    private static void CoilBlocks() {
        //  Adamantium Coil Block
        OreDictUnifier.registerOre(GTLiteMetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.ADAMANTIUM), new ItemMaterialInfo(
                new MaterialStack(Adamantium, M * 8),
                new MaterialStack(SiliconCarbide, M * 2),
                new MaterialStack(Tritanium, M)));

        //  Ichorium Coil Block
        OreDictUnifier.registerOre(GTLiteMetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.ICHORIUM), new ItemMaterialInfo(
                new MaterialStack(Ichorium, M * 8),
                new MaterialStack(Seaborgium, M * 2),
                new MaterialStack(Adamantium, M)));

        //  Astralium Coil Block
        OreDictUnifier.registerOre(GTLiteMetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.ASTRALIUM), new ItemMaterialInfo(
                new MaterialStack(Astralium, M * 8),
                new MaterialStack(Abyssalloy, M * 2),
                new MaterialStack(Ichorium, M)));

        //  Other Unique Coil Blocks

        //  Quantum Coil
        OreDictUnifier.registerOre(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.QUANTUM_COIL), new ItemMaterialInfo(
                new MaterialStack(Europium, M * 8),
                new MaterialStack(Pikyonium64B, M * 2),
                new MaterialStack(QuantumAlloy, M)));

        //  Hypogen Coil
        OreDictUnifier.registerOre(GTLiteMetaBlocks.DYSON_SWARM_CASING.getItemVariant(BlockDysonSwarmCasing.DysonSwarmCasingType.HYPOGEN_COIL_BLOCK), new ItemMaterialInfo(
                new MaterialStack(Hypogen, M * 8),
                new MaterialStack(ArceusAlloy2B, M * 2),
                new MaterialStack(FullereneSuperconductor, M)));
    }
}
