package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.unification.material.MarkerMaterials;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.recipes.RecipeMaps.AUTOCLAVE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtechfoodoption.GTFOMaterialHandler.RainbowSap;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.SUPRACHRONAL_ASSEMBLY_LINE_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.singularity;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class SuprachronalAssemblyLine {

    private static final ItemStack[] suprachronals = {
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_ULV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_LV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_MV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_HV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_EV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_IV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_LuV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_ZPM.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UHV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UEV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UIV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UXV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_OpV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_MAX.getStackForm(),
    };

    public static void init() {

        //  Magic Singularity
        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(singularity, Naquadah)         // 1  Naquadah
                .input(singularity, NaquadahEnriched) // 2  Enriched Naquadah
                .input(singularity, Naquadria)        // 3  Naquadria
                .input(singularity, Orichalcum)       // 4  Orichalcum
                .input(singularity, Adamantium)       // 5  Adamantium
                .input(singularity, Vibranium)        // 6  Vibranium
                .input(singularity, Taranium)         // 7  Taranium
                .input(singularity, Mithril)          // 8  Mithril
                .input(singularity, Solarium)         // 9  Solarium
                .input(singularity, LunaSilver)       // 10 Luna Silver
                .input(singularity, Neutronium)       // 11 Neutronium
                .input(singularity, NetherStar)       // 12 Nether Star
                .input(singularity, Glowstone)        // 13 Glowstone
                .input(singularity, Ichorium)         // 14 Ichorium
                .input(singularity, CrystalMatrix)    // 15 Crystal Matrix
                .input(singularity, Infinity)         // 16 Infinity
                .output(MAGIC_SINGULARITY)
                .EUt(VA[MAX])
                .duration(20)
                .buildAndRegister();

        //  Metric Singularity
        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(singularity, Iron)      // 1  Iron
                .input(singularity, Copper)    // 2  Copper
                .input(singularity, Tin)       // 3  Tin
                .input(singularity, Gold)      // 4  Gold
                .input(singularity, Silver)    // 5  Silver
                .input(singularity, Lead)      // 6  Lead
                .input(singularity, Zinc)      // 7  Zinc
                .input(singularity, Titanium)  // 8  Titanium
                .input(singularity, Tungsten)  // 9  Tungsten
                .input(singularity, Vanadium)  // 10 Vanadium
                .input(singularity, Platinum)  // 11 Platinum
                .input(singularity, Palladium) // 12 Palladium
                .input(singularity, Ruthenium) // 13 Ruthenium
                .input(singularity, Rhodium)   // 14 Rhodium
                .input(singularity, Iridium)   // 15 Iridium
                .input(singularity, Osmium)    // 16 Osmium
                .output(METRIC_SINGULARITY)
                .EUt(VA[MAX])
                .duration(20)
                .buildAndRegister();

        //  Exotic Singularity
        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(singularity, Duranium) // 1 Duranium
                .input(singularity, Tritanium) // 2 Tritanium
                .input(singularity, AstralTitanium) // 3 Astral Titanium
                .input(singularity, CelestialTungsten) // 4 Celestial Tungsten
                .input(singularity, Bedrock) // 5 Bedrock
                .input(singularity, Astralium) // 6 Astralium
                .input(singularity, Hikarium) // 7 Hikarium
                .input(singularity, Rhugnor) // 8 Rhugnor
                .input(singularity, DragonBreath) // 9 Dragon Breath
                .input(singularity, ConcentrateDragonBreath) // 10 Concentrate Dragon Breath
                .input(singularity, DragonBlood) // 11 Dragon Blood
                .input(singularity, Hypogen) // 12 Hypogen
                .input(singularity, CosmicNeutronium) // 13 Cosmic Neutronium
                .input(singularity, MagnetoHydrodynamicallyConstrainedStarMatter) // 14 MHDCS
                .input(singularity, Spacetime) // 15 Spacetime
                .input(singularity, TranscendentMetal) // 16 Transcendent Metal
                .output(EXOTIC_SINGULARITY)
                .EUt(VA[MAX])
                .duration(20)
                .buildAndRegister();

        //  Ancient Singularity
        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(singularity, Water) // 1 Water
                .input(singularity, Lava) // 2 Lava
                .input(singularity, Wood) // 3 Wood
                .input(singularity, Stone) // 4 Stone
                .input(singularity, Netherrack) // 5 Nether
                .input(singularity, Endstone) // 6 Endstone
                .input(singularity, Emerald) // 7 Emerald
                .input(singularity, Obsidian) // 8 Obsidian
                .input(singularity, TreatedWood) // 9 Treated Wood
                .input(singularity, Gunpowder) // 10 Gunpowder
                .input(singularity, Diamond) // 11 Diamond
                .input(singularity, NetherQuartz) // 12 Nether Quartz
                .input(singularity, Brick) // 13 Brick
                .input(singularity, Coal) // 14 Coal
                .input(singularity, Steam) // 15 Steam
                .input(singularity, Clay) // 16 Clay
                .output(ANCIENT_SINGULARITY)
                .EUt(VA[MAX])
                .duration(20)
                .buildAndRegister();

        //  Void Singularity
        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(singularity, Air) // 1 Air
                .input(singularity, NetherAir) // 2 Nether Air
                .input(singularity, EnderAir) // 3 Ender Air
                .input(singularity, Carbon) // 4 Carbon
                .input(singularity, Hydrogen) // 5 Hydrogen
                .input(singularity, Oxygen) // 6 Oxygen
                .input(singularity, Chlorine) // 7 Chlorine
                .input(singularity, Fluorine) // 8 Fluorine
                .input(singularity, Helium) // 9 Helium
                .input(singularity, Neon) // 10 Neon
                .input(singularity, Argon) // 11 Argon
                .input(singularity, Krypton) // 12 Krypton
                .input(singularity, Xenon) // 13 Xenon
                .input(singularity, Radon) // 14 Radon
                .input(singularity, MetastableOganesson) // 15 Metastable Oganesson
                .input(singularity, RainbowSap) // 16 Rainbow Sap
                .output(VOID_SINGULARITY)
                .EUt(VA[MAX])
                .duration(20)
                .buildAndRegister();

        //  Eigen Singularity
        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(singularity, Bronze) // 1 Bronze
                .input(singularity, Steel) // 2 Steel
                .input(singularity, Aluminium) // 3 Aluminium
                .input(singularity, StainlessSteel) // 4 Stainless Steel
                .input(singularity, CobaltBrass) // 5 Cobalt Brass
                .input(singularity, VanadiumSteel) // 6 Vanadium Steel
                .input(singularity, BlackSteel) // 7 Black Steel
                .input(singularity, BlueSteel) // 8 Blue Steel
                .input(singularity, RedSteel) // 9 Red Steel
                .input(singularity, TungstenSteel) // 10 Tungsten Steel
                .input(singularity, HSSG) // 11 HSS-G
                .input(singularity, HSSE) // 12 HSS-E
                .input(singularity, HSSS) // 13 HSS-S
                .input(singularity, Ruridit) // 14 Ruridit
                .input(singularity, Osmiridium) // 15 Osmiridium
                .input(singularity, NaquadahAlloy) // 16 Naquadah Alloy
                .output(EIGEN_SINGULARITY)
                .EUt(VA[MAX])
                .duration(20)
                .buildAndRegister();

        //  Weird Singularity
        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(singularity, BlazingPyrotheum) // 1 Blazing Pyrotheum
                .input(singularity, GelidCryotheum) // 2 Gelid Cryotheum
                .input(singularity, Tiberium) // 3 Tiberium
                .input(singularity, QuarkGluonPlasma) // 4 Quark Gluon Plasma
                .input(singularity, LightQuarks) // 5 Light Quarks
                .input(singularity, HeavyQuarks) // 6 Heavy Quarks
                .input(singularity, Gluons) // 7 Gluons
                .input(singularity, Instantons) // 8 Instantons
                .input(singularity, HiggsBosons) // 9 Higgs Bosons
                .input(singularity, HeavyLepton) // 10 Heavy Lepton
                .input(singularity, TemporalFluid) // 11 Temporal Fluid
                .input(singularity, HeavyQuarkDegenerateMatter) // 12 Heavy Quark Degenerate Matter
                .input(singularity, QuantumchromodynamicallyConfinedMatter) // 13 Quantumchromodynamically Confined Matter
                .input(singularity, BlackDwarfMatter) // 14 Black Dwarf Matter
                .input(singularity, WhiteDwarfMatter) // 15 White Dwarf Matter
                .input(singularity, DimensionallyTranscendentResidue) // 16 Dimensionally Transcendent Residue
                .output(WEIRD_SINGULARITY)
                .EUt(VA[MAX])
                .duration(20)
                .buildAndRegister();

        //  All special singularities -> Eternity Singularity
        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MAGIC_SINGULARITY)
                .input(METRIC_SINGULARITY)
                .input(EXOTIC_SINGULARITY)
                .input(ANCIENT_SINGULARITY)
                .input(VOID_SINGULARITY)
                .input(EIGEN_SINGULARITY)
                .input(WEIRD_SINGULARITY)
                .fluidInputs(CosmicComputingMixture.getFluid(L * 10))
                .fluidInputs(Infinity.getFluid(8000))
                .fluidInputs(Spacetime.getFluid(L * 4))
                .fluidInputs(Eternity.getFluid(L))
                .output(singularity, Eternity)
                .EUt((int) V[MAX])
                .duration(20)
                .buildAndRegister();

        //  Eternity Singularity -> Eternity swarm
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(singularity, Eternity)
                .output(swarm, Eternity, 64)
                .EUt(VA[OpV])
                .duration(600)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Hyperdimensional Drone
        if (GTLiteConfigHolder.tools.enableHighTierUltimateBattery) {
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(frameGt, Eternity)
                    .input(DYSON_SWARM_MODULE, 16)
                    .input(swarm, Eternity, 4)
                    .input(plate, CosmicFabric, 16)
                    .input(circuit, MarkerMaterials.Tier.MAX, 4)
                    .input(ULTIMATE_BATTERY_MK5, 2)
                    .input(ELECTRIC_PUMP_OpV, 8)
                    .input(ROBOT_ARM_OpV, 8)
                    .input(pipeNormalFluid, Neutronium, 16)
                    .input(wireGtQuadruple, NeutroniumSuperconductor, 32)
                    .fluidInputs(SolderingAlloy.getFluid(16000))
                    .fluidInputs(Lubricant.getFluid(30000))
                    .fluidInputs(Spacetime.getFluid(2000))
                    .fluidInputs(Edenium.getFluid(L * 4))
                    .output(HYPERDIMENSIONAL_DRONE)
                    .EUt(VA[OpV])
                    .duration(200)
                    .stationResearch(b -> b
                            .researchStack(MINING_DRONE_OpV.getStackForm())
                            .EUt(VA[OpV])
                            .CWUt(1024))
                    .buildAndRegister();
        } else {
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(frameGt, Eternity)
                    .input(DYSON_SWARM_MODULE, 16)
                    .input(swarm, Eternity, 4)
                    .input(plate, CosmicFabric, 16)
                    .input(circuit, MarkerMaterials.Tier.MAX, 4)
                    .input(ULTIMATE_BATTERY, 2)
                    .input(ELECTRIC_PUMP_OpV, 8)
                    .input(ROBOT_ARM_OpV, 8)
                    .input(pipeNormalFluid, Neutronium, 16)
                    .input(wireGtQuadruple, NeutroniumSuperconductor, 32)
                    .fluidInputs(SolderingAlloy.getFluid(16000))
                    .fluidInputs(Lubricant.getFluid(30000))
                    .fluidInputs(Spacetime.getFluid(2000))
                    .fluidInputs(Edenium.getFluid(L * 4))
                    .output(HYPERDIMENSIONAL_DRONE)
                    .EUt(VA[OpV])
                    .duration(200)
                    .stationResearch(b -> b
                            .researchStack(MINING_DRONE_OpV.getStackForm())
                            .EUt(VA[OpV])
                            .CWUt(1024))
                    .buildAndRegister();
        }

        //  Hyperdimensional Oscillating Matter -> Suprachronal Circuits (all tiers)
        for (int tier = 0; tier < 15; tier ++) {
            SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HYPERDIMENSIONAL_OSCILLATING_MATTER)
                    .notConsumable(HYPERDIMENSIONAL_DRONE)
                    .circuitMeta(tier)
                    .outputs(suprachronals[tier])
                    .duration(200)
                    .EUt(VA[tier])
                    .buildAndRegister();

            SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HYPERDIMENSIONAL_OSCILLATING_MATTER)
                    .notConsumable(HYPERDIMENSIONAL_DRONE)
                    .circuitMeta(tier + 10)
                    .fluidInputs(Spacetime.getFluid(L))
                    .outputs(suprachronals[tier])
                    .duration(20)
                    .EUt(VA[tier])
                    .buildAndRegister();
        }
    }
}
