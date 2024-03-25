package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.unification.material.Material;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.block;
import static gregtech.common.blocks.MetaBlocks.ITNT;
import static gregtechfoodoption.GTFOMaterialHandler.RainbowSap;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.CONDENSER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.singularity;

public class Condenser {

    public static void init() {
        MagicSingularities();
        MetricSingularities();
        ExoticSingularities();
        AncientSingularities();
        VoidSingularities();
        EigenSingularities();
        WeirdSingularities();
    }

    private static void MagicSingularities() {
        createSingularityRecipe(Naquadah, true);
        createSingularityRecipe(NaquadahEnriched, true);
        createSingularityRecipe(Naquadria, true);
        createSingularityRecipe(Orichalcum, true);
        createSingularityRecipe(Adamantium, true);
        createSingularityRecipe(Vibranium, true);
        createSingularityRecipe(Taranium, true);
        createSingularityRecipe(Mithril, true);
        createSingularityRecipe(Solarium, true);
        createSingularityRecipe(LunaSilver, true);
        createSingularityRecipe(Neutronium, true);
        createSingularityRecipe(NetherStar, true);
        createSingularityRecipe(Glowstone, true);
        createSingularityRecipe(Ichorium, true);
        createSingularityRecipe(CrystalMatrix, true);
        createSingularityRecipe(Infinity, true);
    }

    private static void MetricSingularities() {
        createSingularityRecipe(Iron, true);
        createSingularityRecipe(Copper, true);
        createSingularityRecipe(Tin, true);
        createSingularityRecipe(Gold, true);
        createSingularityRecipe(Silver, true);
        createSingularityRecipe(Lead, true);
        createSingularityRecipe(Zinc, true);
        createSingularityRecipe(Titanium, true);
        createSingularityRecipe(Tungsten, true);
        createSingularityRecipe(Vanadium, true);
        createSingularityRecipe(Platinum, true);
        createSingularityRecipe(Palladium, true);
        createSingularityRecipe(Ruthenium, true);
        createSingularityRecipe(Rhodium, true);
        createSingularityRecipe(Iridium, true);
        createSingularityRecipe(Osmium, true);
    }

    private static void ExoticSingularities() {
        createSingularityRecipe(Duranium, true);
        createSingularityRecipe(Tritanium, true);
        createSingularityRecipe(AstralTitanium, true);
        createSingularityRecipe(CelestialTungsten, true);
        createSingularityRecipe(Bedrock, false);
        createSingularityRecipe(Astralium, true);
        createSingularityRecipe(Hikarium, true);
        createSingularityRecipe(Rhugnor, true);
        createSingularityRecipe(DragonBreath, false);
        createSingularityRecipe(ConcentrateDragonBreath, false);
        createSingularityRecipe(DragonBlood, false);
        createSingularityRecipe(Hypogen, true);
        createSingularityRecipe(CosmicNeutronium, true);
        createSingularityRecipe(MagnetoHydrodynamicallyConstrainedStarMatter, true);
        createSingularityRecipe(Spacetime, true);
        createSingularityRecipe(TranscendentMetal, true);
    }

    private static void AncientSingularities() {
        createSingularityRecipe(Water, false);
        createSingularityRecipe(Lava, false);

        CONDENSER_RECIPES.recipeBuilder()
                .input("plankWood", 64)
                .output(singularity, Wood)
                .EUt(VA[IV])
                .duration((int) Wood.getMass() * 8)
                .buildAndRegister();

        CONDENSER_RECIPES.recipeBuilder()
                .input("stone", 64)
                .output(singularity, Stone)
                .EUt(VA[IV])
                .duration((int) Wood.getMass() * 8)
                .buildAndRegister();

        CONDENSER_RECIPES.recipeBuilder()
                .input("stoneNetherrack", 64)
                .output(singularity, Netherrack)
                .EUt(VA[IV])
                .duration((int) Netherrack.getMass() * 8)
                .buildAndRegister();

        CONDENSER_RECIPES.recipeBuilder()
                .input("stoneEndstone", 64)
                .output(singularity, Endstone)
                .EUt(VA[IV])
                .duration((int) Endstone.getMass() * 8)
                .buildAndRegister();

        createSingularityRecipe(Emerald, true);
        createSingularityRecipe(Obsidian, true);

        CONDENSER_RECIPES.recipeBuilder()
                .input("plankTreatedWood", 64)
                .output(singularity, TreatedWood)
                .EUt(VA[IV])
                .duration((int) TreatedWood.getMass() * 8)
                .buildAndRegister();

        CONDENSER_RECIPES.recipeBuilder()
                .input(ITNT, 64)
                .output(singularity, Gunpowder)
                .EUt(VA[IV])
                .duration((int) Gunpowder.getMass() * 8)
                .buildAndRegister();

        createSingularityRecipe(Diamond, true);
        createSingularityRecipe(NetherQuartz, true);
        createSingularityRecipe(Brick, true);
        createSingularityRecipe(Coal, true);
        createSingularityRecipe(Steam, false);
        createSingularityRecipe(Clay, true);
    }

    private static void VoidSingularities() {
        createSingularityRecipe(Air, false);
        createSingularityRecipe(NetherAir, false);
        createSingularityRecipe(EnderAir, false);
        createSingularityRecipe(Carbon, false);
        createSingularityRecipe(Hydrogen, false);
        createSingularityRecipe(Oxygen, false);
        createSingularityRecipe(Chlorine, false);
        createSingularityRecipe(Fluorine, false);
        createSingularityRecipe(Helium, false);
        createSingularityRecipe(Neon, false);
        createSingularityRecipe(Argon, false);
        createSingularityRecipe(Krypton, false);
        createSingularityRecipe(Xenon, false);
        createSingularityRecipe(Radon, false);
        createSingularityRecipe(MetastableOganesson, true);
        createSingularityRecipe(RainbowSap, false);
    }

    private static void EigenSingularities() {
        createSingularityRecipe(Bronze, true);
        createSingularityRecipe(Steel, true);
        createSingularityRecipe(Aluminium, true);
        createSingularityRecipe(StainlessSteel, true);
        createSingularityRecipe(CobaltBrass, true);
        createSingularityRecipe(VanadiumSteel, true);
        createSingularityRecipe(BlackSteel, true);
        createSingularityRecipe(BlueSteel, true);
        createSingularityRecipe(RedSteel, true);
        createSingularityRecipe(TungstenSteel, true);
        createSingularityRecipe(HSSG, true);
        createSingularityRecipe(HSSE, true);
        createSingularityRecipe(HSSS, true);
        createSingularityRecipe(Ruridit, true);
        createSingularityRecipe(Osmiridium, true);
        createSingularityRecipe(NaquadahAlloy, true);
    }

    private static void WeirdSingularities() {
        createSingularityRecipe(BlazingPyrotheum, false);
        createSingularityRecipe(GelidCryotheum, false);
        createSingularityRecipe(Tiberium, false);

        CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(QuarkGluonPlasma.getPlasma(L * 9 * 64))
                .output(singularity, QuarkGluonPlasma)
                .EUt(VA[IV])
                .duration((int) QuarkGluonPlasma.getMass() * 8)
                .buildAndRegister();

        createSingularityRecipe(LightQuarks, false);
        createSingularityRecipe(HeavyQuarks, false);
        createSingularityRecipe(Gluons, false);
        createSingularityRecipe(Instantons, false);
        createSingularityRecipe(HiggsBosons, false);
        createSingularityRecipe(HeavyLepton, false);
        createSingularityRecipe(TemporalFluid, false);
        createSingularityRecipe(HeavyQuarkDegenerateMatter, true);
        createSingularityRecipe(QuantumchromodynamicallyConfinedMatter, true);
        createSingularityRecipe(BlackDwarfMatter, true);
        createSingularityRecipe(WhiteDwarfMatter, true);
        createSingularityRecipe(DimensionallyTranscendentResidue, false);
    }

    private static void createSingularityRecipe(Material material,
                                                boolean isSolid) {
        if (isSolid) {
            CONDENSER_RECIPES.recipeBuilder()
                    .input(block, material, 64)
                    .output(singularity, material)
                    .EUt(VA[IV])
                    .duration((int) material.getMass() * 8)
                    .buildAndRegister();
        } else {
            CONDENSER_RECIPES.recipeBuilder()
                    .fluidInputs(material.getFluid(L * 9 * 64))
                    .output(singularity, material)
                    .EUt(VA[IV])
                    .duration((int) material.getMass() * 8)
                    .buildAndRegister();
        }
    }
}
