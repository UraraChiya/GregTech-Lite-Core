package magicbook.gtlitecore.loaders.components;

import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class MaterialComponents {
    public static void init() {
        WIRE_ELECTRIC.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.wireGtSingle, Trinium)},
                {10, new UnificationEntry(OrePrefix.wireGtSingle, Tritanium)},
                {11, new UnificationEntry(OrePrefix.wireGtSingle, Adamantium)},
//                {12, new UnificationEntry(OrePrefix.wireGtSingle, Trinium)},
//                {13, new UnificationEntry(OrePrefix.wireGtSingle, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        WIRE_QUAD.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.wireGtQuadruple, Europium)},
//                {10, new UnificationEntry(OrePrefix.wireGtQuadruple, Trinium)},
//                {11, new UnificationEntry(OrePrefix.wireGtQuadruple, Trinium)},
//                {12, new UnificationEntry(OrePrefix.wireGtQuadruple, Trinium)},
//                {13, new UnificationEntry(OrePrefix.wireGtQuadruple, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        WIRE_OCT.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.wireGtOctal, Europium)},
//                {10, new UnificationEntry(OrePrefix.wireGtOctal, Trinium)},
//                {11, new UnificationEntry(OrePrefix.wireGtOctal, Trinium)},
//                {12, new UnificationEntry(OrePrefix.wireGtOctal, Trinium)},
//                {13, new UnificationEntry(OrePrefix.wireGtOctal, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        WIRE_HEX.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.wireGtHex, Europium)},
//                {10, new UnificationEntry(OrePrefix.wireGtHex, Trinium)},
//                {11, new UnificationEntry(OrePrefix.wireGtHex, Trinium)},
//                {12, new UnificationEntry(OrePrefix.wireGtHex, Trinium)},
//                {13, new UnificationEntry(OrePrefix.wireGtHex, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE.appendIngredients(Stream.of(new Object[][]{
//                {10, new UnificationEntry(OrePrefix.cableGtSingle, Trinium)},
//                {11, new UnificationEntry(OrePrefix.cableGtSingle, Trinium)},
//                {12, new UnificationEntry(OrePrefix.cableGtSingle, Trinium)},
//                {13, new UnificationEntry(OrePrefix.cableGtSingle, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_QUAD.appendIngredients(Stream.of(new Object[][]{
//                {10, new UnificationEntry(OrePrefix.cableGtQuadruple, Trinium)},
//                {11, new UnificationEntry(OrePrefix.cableGtQuadruple, Trinium)},
//                {12, new UnificationEntry(OrePrefix.cableGtQuadruple, Trinium)},
//                {13, new UnificationEntry(OrePrefix.cableGtQuadruple, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_OCT.appendIngredients(Stream.of(new Object[][]{
//                {10, new UnificationEntry(OrePrefix.cableGtOctal, Trinium)},
//                {11, new UnificationEntry(OrePrefix.cableGtOctal, Trinium)},
//                {12, new UnificationEntry(OrePrefix.cableGtOctal, Trinium)},
//                {13, new UnificationEntry(OrePrefix.cableGtOctal, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_HEX.appendIngredients(Stream.of(new Object[][]{
//                {10, new UnificationEntry(OrePrefix.cableGtHex, Trinium)},
//                {11, new UnificationEntry(OrePrefix.cableGtHex, Trinium)},
//                {12, new UnificationEntry(OrePrefix.cableGtHex, Trinium)},
//                {13, new UnificationEntry(OrePrefix.cableGtHex, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_TIER_UP.appendIngredients(Stream.of(new Object[][]{
//                {9, new UnificationEntry(OrePrefix.cableGtSingle, Trinium)},
//                {10, new UnificationEntry(OrePrefix.cableGtSingle, Trinium)},
//                {11, new UnificationEntry(OrePrefix.cableGtSingle, Trinium)},
//                {12, new UnificationEntry(OrePrefix.cableGtSingle, Trinium)},
//                {13, new UnificationEntry(OrePrefix.cableGtSingle, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        PIPE_NORMAL.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.pipeNormalFluid, Duranium)},
//                {10, new UnificationEntry(OrePrefix.pipeNormalFluid, Trinium)},
//                {11, new UnificationEntry(OrePrefix.pipeNormalFluid, Trinium)},
//                {12, new UnificationEntry(OrePrefix.pipeNormalFluid, Trinium)},
//                {13, new UnificationEntry(OrePrefix.pipeNormalFluid, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        PIPE_LARGE.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.pipeLargeFluid, Duranium)},
//                {10, new UnificationEntry(OrePrefix.pipeNormalFluid, Trinium)},
//                {11, new UnificationEntry(OrePrefix.pipeNormalFluid, Trinium)},
//                {12, new UnificationEntry(OrePrefix.pipeNormalFluid, Trinium)},
//                {13, new UnificationEntry(OrePrefix.pipeNormalFluid, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        GLASS.appendIngredients(Stream.of(new Object[][]{
//                {7, EPMetablocks.EP_TRANSPARENT_CASING.getItemVariant(EPBlockTransparentCasing.TransparentCasingType.BPA_POLYCARBONATE_GLASS)},
//                {8, EPMetablocks.EP_TRANSPARENT_CASING.getItemVariant(EPBlockTransparentCasing.TransparentCasingType.BPA_POLYCARBONATE_GLASS)},
//                {9, EPMetablocks.EP_PMMA_CASING.getItemVariant(EPBlockPMMACasing.CasingType.PMMA_GLASS)},
//                {10, EPMetablocks.EP_PMMA_CASING.getItemVariant(EPBlockPMMACasing.CasingType.PMMA_GLASS)},
//                {11, EPMetablocks.EP_TRANSPARENT_CASING.getItemVariant(EPBlockTransparentCasing.TransparentCasingType.CBDO_POLYCARBONATE_GLASS)},
//                {12, EPMetablocks.EP_TRANSPARENT_CASING.getItemVariant(EPBlockTransparentCasing.TransparentCasingType.CBDO_POLYCARBONATE_GLASS)},
//                {13, EPMetablocks.EP_GLASS_CASING_B.getItemVariant(EPBlockGlassCasingB.GlassType.INFINITY_GLASS)},
//                {14, EPMetablocks.EP_GLASS_CASING_B.getItemVariant(EPBlockGlassCasingB.GlassType.INFINITY_GLASS)}
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        PLATE.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.plate, Orichalcum)},
                {10, new UnificationEntry(OrePrefix.plate, Adamantium)},
//                {11, new UnificationEntry(OrePrefix.plate, Trinium)},
//                {12, new UnificationEntry(OrePrefix.plate, Trinium)},
//                {13, new UnificationEntry(OrePrefix.plate, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        HULL_PLATE.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.plate, Polyetheretherketone)},
                {10, new UnificationEntry(OrePrefix.plate, Polyetheretherketone)},
                {11, new UnificationEntry(OrePrefix.plate, Kevlar)},
                {12, new UnificationEntry(OrePrefix.plate, Kevlar)},
                {13, new UnificationEntry(OrePrefix.plate, CosmicFabric)},
                {14, new UnificationEntry(OrePrefix.plate, CosmicFabric)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        DOUBLE_PLATE.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.plateDouble, Orichalcum)},
                {10, new UnificationEntry(OrePrefix.plateDouble, Adamantium)},
//                {11, new UnificationEntry(OrePrefix.plateDouble, Trinium)},
//                {12, new UnificationEntry(OrePrefix.plateDouble, Trinium)},
//                {13, new UnificationEntry(OrePrefix.plateDouble, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        ROTOR.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.rotor, Orichalcum)},
                {10, new UnificationEntry(OrePrefix.rotor, Adamantium)},
//                {11, new UnificationEntry(OrePrefix.rotor, Trinium)},
//                {12, new UnificationEntry(OrePrefix.rotor, Trinium)},
//                {13, new UnificationEntry(OrePrefix.rotor, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        GRINDER.appendIngredients(Stream.of(new Object[][]{
                {6, MetaItems.COMPONENT_GRINDER_TUNGSTEN.getStackForm()},
                {7, MetaItems.COMPONENT_GRINDER_TUNGSTEN.getStackForm()},
                {8, MetaItems.COMPONENT_GRINDER_TUNGSTEN.getStackForm()},
//                {9, GTLiteMetaItems.BORON_NITRIDE_GRINDER.getStackForm()},
//                {10, GTLiteMetaItems.BORON_NITRIDE_GRINDER.getStackForm()},
//                {11, GTLiteMetaItems.BORON_NITRIDE_GRINDER.getStackForm()},
//                {12, },
//                {13, },
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        SAWBLADE.appendIngredients(Stream.of(new Object[][]{
//                {9, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, CubicBoronNitride)},
//                {10, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, BlackTitanium)},
//                {11, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Hypogen)},
//                {12, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Trinium)},
//                {13, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        COIL_HEATING.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.wireGtDouble, Trinium)},
                {10, new UnificationEntry(OrePrefix.wireGtDouble, Tritanium)},
                {11, new UnificationEntry(OrePrefix.wireGtDouble, Adamantium)},
//                {12, new UnificationEntry(OrePrefix.wireGtDouble, Trinium)},
//                {13, new UnificationEntry(OrePrefix.wireGtDouble, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        COIL_HEATING_DOUBLE.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.wireGtQuadruple, Trinium)},
                {10, new UnificationEntry(OrePrefix.wireGtQuadruple, Tritanium)},
                {11, new UnificationEntry(OrePrefix.wireGtDouble, Adamantium)},
//                {12, new UnificationEntry(OrePrefix.wireGtDouble, Trinium)},
//                {13, new UnificationEntry(OrePrefix.wireGtDouble, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        COIL_ELECTRIC.appendIngredients(Stream.of(new Object[][]{
//                {9, new UnificationEntry(OrePrefix.wireGtOctal, AwakenedDraconium)},
//                {10, new UnificationEntry(OrePrefix.wireGtOctal, Seaborgium)},
//                {11, new UnificationEntry(OrePrefix.wireGtOctal, BlackDwarfMatter)},
//                  {12, new UnificationEntry(OrePrefix.wireGtOctal, Trinium)},
//                  {13, new UnificationEntry(OrePrefix.wireGtOctal, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        STICK_MAGNETIC.appendIngredients(Stream.of(new Object[][]{
//                {9, new UnificationEntry(OrePrefix.stickLong, ChromiumGermaniumTellurideMagnetic)},
//                {10, new UnificationEntry(OrePrefix.stickLong, ChromiumGermaniumTellurideMagnetic)},
//                {11, new UnificationEntry(OrePrefix.stickLong, WhiteDwarfMatter)},
//                {12, new UnificationEntry(OrePrefix.stickLong, WhiteDwarfMatter)},
//                  {13, new UnificationEntry(OrePrefix.stickLong, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        STICK_DISTILLATION.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.spring, Trinium)},
                {10, new UnificationEntry(OrePrefix.spring, Tritanium)},
                {11, new UnificationEntry(OrePrefix.spring, Adamantium)},
//                {12, new UnificationEntry(OrePrefix.spring, Trinium)},
//                {13, new UnificationEntry(OrePrefix.spring, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        STICK_ELECTROMAGNETIC.appendIngredients(Stream.of(new Object[][]{
                {5, new UnificationEntry(OrePrefix.stick, VanadiumGallium)},
                {6, new UnificationEntry(OrePrefix.stick, VanadiumGallium)},
                {7, new UnificationEntry(OrePrefix.stick, VanadiumGallium)},
                {8, new UnificationEntry(OrePrefix.stickLong, VanadiumGallium)},
                {9, new UnificationEntry(OrePrefix.stickLong, VanadiumGallium)},
//                {10, new UnificationEntry(OrePrefix.stick, CarbonNanotube)},
//                {11, new UnificationEntry(OrePrefix.stick, CarbonNanotube)},
//                {12, new UnificationEntry(OrePrefix.stickLong, CarbonNanotube)},
//                {13, new UnificationEntry(OrePrefix.stickLong, CarbonNanotube)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        STICK_RADIOACTIVE.appendIngredients(Stream.of(new Object[][]{
//                {9, new UnificationEntry(OrePrefix.stick, Dubnium)},
//                {10, new UnificationEntry(OrePrefix.stick, Livermorium)},
//                {11, new UnificationEntry(OrePrefix.stick, MetastableFlerovium)},
//                {12, new UnificationEntry(OrePrefix.stick, MetastableHassium)},
//                {13, new UnificationEntry(OrePrefix.stick, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        //  TODO PEEK, Kevlar, Zylon Fluid pipes
        PIPE_REACTOR.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.pipeNormalFluid, Polybenzimidazole)},
                {10, new UnificationEntry(OrePrefix.pipeLargeFluid, Polybenzimidazole)},
                {11, new UnificationEntry(OrePrefix.pipeHugeFluid, Polybenzimidazole)},
//                {12, new UnificationEntry(OrePrefix.pipeLargeFluid, Trinium)},
//                {13, new UnificationEntry(OrePrefix.pipeHugeFluid, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        POWER_COMPONENT.appendIngredients(Stream.of(new Object[][]{
//                {8, EPMetaItems.NANO_PIC_CHIP},
//                {9, EPMetaItems.NANO_PIC_CHIP},
//                {10, EPMetaItems.PICO_PIC_CHIP},
//                {11, EPMetaItems.PICO_PIC_CHIP},
//                {12, EPMetaItems.FEMTO_PIC_CHIP},
//                {13, EPMetaItems.ATTO_PIC_CHIP},
//                {14, EPMetaItems.ZEPTO_PIC_CHIP},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        VOLTAGE_COIL.appendIngredients(Stream.of(new Object[][]{
//                {9, EPMetaItems.VOLTAGE_COIL_UHV},
//                {10, EPMetaItems.VOLTAGE_COIL_UEV},
//                {11, EPMetaItems.VOLTAGE_COIL_UIV},
//                {12, EPMetaItems.VOLTAGE_COIL_UXV},
//                {13, EPMetaItems.VOLTAGE_COIL_OPV},
//                {14, EPMetaItems.VOLTAGE_COIL_MAX},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        SPRING.appendIngredients(Stream.of(new Object[][]{
//                {10, new UnificationEntry(OrePrefix.spring, PedotTMA)},
//                {11, new UnificationEntry(OrePrefix.spring, RutheniumTriniumAmericiumNeutronate)},
//                {12, new UnificationEntry(OrePrefix.spring, Trinium)},
//                {13, new UnificationEntry(OrePrefix.spring, Trinium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
    }
}
