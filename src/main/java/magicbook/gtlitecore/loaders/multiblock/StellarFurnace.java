package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import magicbook.gtlitecore.common.blocks.BlockExplosive;
import magicbook.gtlitecore.common.blocks.BlockTransparentCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;

import java.math.BigInteger;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class StellarFurnace {

    public static void init() {
        BasicComponent();
        Recipes();
    }

    private static void BasicComponent() {

        //  Plasma Containment Cell
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(FIELD_GENERATOR_UV)
                .input(stickLong, NaquadahAlloy)
                .input(plate, Osmiridium, 4)
                .inputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.PMMA_GLASS, 2))
                .fluidInputs(TinAlloy.getFluid(L * 2))
                .output(PLASMA_CONTAINMENT_CELL)
                .EUt(VA[ZPM])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Extremely Durable Plasma Containment Cell
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(FIELD_GENERATOR_UEV)
                .input(stickLong, Tritanium)
                .input(QCD_PROTECTIVE_PLATING, 4)
                .inputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.INFINITY_GLASS, 2))
                .fluidInputs(TinAlloy.getFluid(L * 2))
                .output(EXTREMELY_DURABLE_PLASMA_CONTAINMENT_CELL)
                .EUt(VA[UV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Separation Electromagnet
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETRON)
                .input(plate, NiobiumNitride, 4)
                .input(stickLong, VanadiumGallium)
                .input(foil, Polybenzimidazole, 8)
                .input(wireFine, YttriumBariumCuprate, 16)
                .fluidInputs(BlackSteel.getFluid(L * 2))
                .output(SEPARATION_ELECTROMAGNET)
                .EUt(VA[ZPM])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

    }

    private static void Recipes() {
        DegenerateRhenium();
        CosmicComputingMixture();
        HeavyQuarkDegenerateMatter();
        CosmicNeutronium();
        QuantumchromodynamicallyConfinedMatter();
    }

    private static void DegenerateRhenium() {

        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(ingot, Rhenium)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.NAQUADRIA_CHARGE))
                .fluidOutputs(DegenerateRhenium.getPlasma(1000))
                .EUt(VA[UIV])
                .duration(20)
                .temperature(BigInteger.valueOf((10 * V[UV]) - (10 * V[ZPM])))
                .buildAndRegister();

        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(plateDense, Rhenium)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.NAQUADRIA_CHARGE))
                .fluidOutputs(DegenerateRhenium.getPlasma(10000))
                .EUt(VA[UXV])
                .duration(20)
                .temperature(BigInteger.valueOf((10 * V[UV]) - (10 * V[ZPM])))
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(PLASMA_CONTAINMENT_CELL)
                .fluidInputs(DegenerateRhenium.getPlasma(1000))
                .output(RHENIUM_PLASMA_CONTAINMENT_CELL)
                .EUt(VA[LuV])
                .duration(20)
                .buildAndRegister();
    }

    private static void CosmicComputingMixture() {

        //  Quark Gluon Plasma
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(plate, DegenerateRhenium)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.LEPTONIC_CHARGE))
                .fluidOutputs(QuarkGluonPlasma.getPlasma(1000))
                .EUt(VA[UIV])
                .duration(60)
                .temperature(BigInteger.valueOf((10 * V[UHV]) - (10 * V[ZPM])))
                .buildAndRegister();

        //  Quark Gluon Plasma -> Heavy Quarks + Light Quarks + Gluons
        CENTRIFUGE_RECIPES.recipeBuilder()
                .notConsumable(SEPARATION_ELECTROMAGNET)
                .fluidInputs(QuarkGluonPlasma.getPlasma(1000))
                .fluidOutputs(HeavyQuarks.getFluid(200))
                .fluidOutputs(LightQuarks.getFluid(600))
                .fluidOutputs(Gluons.getFluid(200))
                .EUt(VA[UEV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cosmic Computing Mixture
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .fluidInputs(HeavyLepton.getFluid(32000))
                .fluidInputs(HeavyQuarks.getFluid(8000))
                .fluidInputs(Gluons.getFluid(8000))
                .fluidInputs(Instantons.getFluid(4000))
                .fluidInputs(TemporalFluid.getFluid(4000))
                .fluidInputs(HiggsBosons.getFluid(4000))
                .fluidOutputs(CosmicComputingMixture.getFluid(60000))
                .EUt(VA[UIV])
                .duration(1200)
                .temperature(BigInteger.valueOf(Long.MAX_VALUE))
                .buildAndRegister();
    }

    private static void HeavyQuarkDegenerateMatter() {

        //  Heavy Quark Enriched Mixture
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(LightQuarks.getFluid(1000))
                .fluidInputs(HeavyQuarks.getFluid(3000))
                .fluidOutputs(HeavyQuarkEnrichedMixture.getFluid(1000))
                .EUt(VA[UIV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Deuterium-Superheavy Mixture
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.LEPTONIC_CHARGE))
                .fluidInputs(Deuterium.getFluid(2000))
                .fluidInputs(MetastableHassium.getFluid(L))
                .fluidInputs(MetastableFlerovium.getFluid(L))
                .fluidInputs(MetastableOganesson.getFluid(L))
                .fluidOutputs(DeuteriumSuperheavyMixture.getFluid(2592))
                .EUt(VA[UIV])
                .duration(100)
                .temperature(BigInteger.valueOf((10 * V[UEV]) - (10 * V[ZPM])))
                .buildAndRegister();

        //  Heavy Quark Degenerate Matter
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.LEPTONIC_CHARGE))
                .fluidInputs(DeuteriumSuperheavyMixture.getFluid(1000))
                .fluidInputs(HeavyQuarkEnrichedMixture.getFluid(1000))
                .fluidOutputs(HeavyQuarkDegenerateMatter.getPlasma(1000))
                .EUt(VA[UIV])
                .duration(20)
                .temperature(BigInteger.valueOf((10 * V[UIV]) - (10 * V[EV])))
                .buildAndRegister();
    }

    private static void CosmicNeutronium() {

        //  Step 1: Dense Neutron Plasma
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(ingot, Neutronium)
                .input(ingot, HeavyQuarkDegenerateMatter)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .fluidInputs(HeavyLepton.getFluid(6000))
                .fluidInputs(Gluons.getFluid(6000))
                .fluidInputs(Periodicium.getFluid(2736))
                .fluidOutputs(DenseNeutronPlasma.getPlasma(6000))
                .EUt(VA[UIV])
                .duration(20)
                .temperature(BigInteger.valueOf((long) Double.MAX_VALUE))
                .buildAndRegister();

        //  Step2: Cosmic Neutron Plasma
        SCANNER_RECIPES.recipeBuilder()
                .input(EXTREMELY_DURABLE_PLASMA_CONTAINMENT_CELL)
                .fluidInputs(DenseNeutronPlasma.getPlasma(1000))
                .output(DENSE_NEUTRON_PLASMA_CONTAINMENT_CELL)
                .EUt(VA[UEV])
                .duration(90)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(DENSE_NEUTRON_PLASMA_CONTAINMENT_CELL, 2)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .fluidInputs(AstralTitanium.getPlasma(6000))
                .fluidInputs(CelestialTungsten.getPlasma(6000))
                .output(COSMIC_NEUTRON_PLASMA_CONTAINMENT_CELL)
                .EUt(VA[UIV])
                .duration(10)
                .temperature(BigInteger.valueOf(Long.MAX_VALUE))
                .buildAndRegister();

        //  back to plasma condenser recipe
    }

    private static void QuantumchromodynamicallyConfinedMatter() {

        //  Heavy Quark Degenerate Matter -> High Energy Quark Gluon Plasma
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(ingot, HeavyQuarkDegenerateMatter)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .fluidOutputs(HighEnergyQuarkGluonPlasma.getPlasma(L))
                .EUt(VA[UIV])
                .duration(200)
                .temperature(BigInteger.valueOf(Long.MAX_VALUE))
                .buildAndRegister();

        //  back to plasma condenser recipe

        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(plate, QuantumchromodynamicallyConfinedMatter)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .output(QCD_PROTECTIVE_PLATING)
                .EUt(VA[UIV])
                .duration(10)
                .temperature(BigInteger.valueOf(Long.MAX_VALUE))
                .buildAndRegister();
    }
}