package magicbook.gtlitecore.loaders;

import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.recipes.GTRecipeHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.ingotHot;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class FusionLoader {

    public static void init() {
        Elements();
        FantasyMaterials();
    }

    private static void Elements() {

        //  Americium + Neon -> Dubnium
        //  Mk III recipe, for you next wafer and next radioactive rod.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Americium.getFluid(16))
                .fluidInputs(Neon.getFluid(125))
                .fluidOutputs(Dubnium.getFluid(125))
                .EUt(VA[ZPM])
                .duration(160)
                .EUToStart(380000000L)
                .buildAndRegister();

        //  Plutonium-241 + Neon -> Rutherfordium
        //  Mk II recipe
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Plutonium241.getFluid(16))
                .fluidInputs(Neon.getFluid(16))
                .fluidOutputs(Rutherfordium.getFluid(16))
                .EUt(VA[LuV])
                .duration(120)
                .EUToStart(250000000L)
                .buildAndRegister();

        //  Plutonium-241 + Titanium -> Livermorium
        //  Mk IV recipe, next radioactive rod material.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Plutonium241.getFluid(32))
                .fluidInputs(Titanium.getFluid(32))
                .fluidOutputs(Livermorium.getFluid(64))
                .EUt(VA[UHV])
                .duration(200)
                .EUToStart(850000000L)
                .buildAndRegister();

        //  Plutonium-241 + Calcium -> Seaborgium
        //  Mk IV recipe, basic material for UEV stage.
        //  If you want to make Fusion Reactor Mk V, then you need to get this material first.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Plutonium241.getFluid(16))
                .fluidInputs(Calcium.getFluid(32))
                .fluidOutputs(Seaborgium.getFluid(48))
                .EUt(VA[UV])
                .duration(220)
                .EUToStart(650000000L)
                .buildAndRegister();

        //  Metastable Oganesson Chain

        //  Oganesson Breeding Base + Curium -> Hot Oganesson
        //  Mk IV recipe
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(OganessonBreedingBase.getFluid(L))
                .fluidInputs(Curium.getFluid(36))
                .fluidOutputs(MetastableOganesson.getFluid(L))
                .EUt(VA[UHV])
                .duration(100)
                .EUToStart(700000000L)
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_INGOT.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_BLOCK.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(1296)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_NUGGET.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_PLATE.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(144)});

        //  Metastable Oganesson liquid -> Metastable Oganesson hot ingot
        VACUUM_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(MetastableOganesson.getFluid(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 500))
                .output(ingotHot, MetastableOganesson)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 500))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  Quasi-fissioning Plasma
        //  Mk IV recipe, this fusion recipe is the first step of Metastable Flerovium chain.
        //  back to Decay Generator recipe.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Uranium238.getFluid(125))
                .fluidInputs(Uranium238.getFluid(125))
                .fluidOutputs(QuasifissioningPlasma.getPlasma(125))
                .EUt(600000)
                .duration(100)
                .EUToStart(250000000L)
                .buildAndRegister();

        //  Metastable Hassium
        //  Mk V recipe
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(ScandiumTitaniumMixture.getFluid(L * 2))
                .fluidInputs(RadiumRadonMixture.getFluid(1000))
                .fluidOutputs(MetastableHassium.getFluid(L * 4))
                .EUt(VA[UEV])
                .duration(80)
                .EUToStart(900000000L)
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_INGOT.getStackForm()},
                new FluidStack[]{MetastableHassium.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_BLOCK.getStackForm()},
                new FluidStack[]{MetastableHassium.getFluid(1296)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_NUGGET.getStackForm()},
                new FluidStack[]{MetastableHassium.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_PLATE.getStackForm()},
                new FluidStack[]{MetastableHassium.getFluid(144)});

        //  Metastable Hassium liquid -> Metastable Hassium hot ingot
        VACUUM_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(MetastableHassium.getFluid(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 500))
                .output(ingotHot, MetastableHassium)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 500))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  Curium + Sodium -> Bohrium
        //  Mk IV recipe
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Curium.getFluid(L * 2))
                .fluidInputs(Sodium.getFluid(L * 2))
                .fluidOutputs(Bohrium.getFluid(L * 4))
                .EUt(VA[UHV])
                .duration(140)
                .EUToStart(800000000L)
                .buildAndRegister();

        //  Iron + Bismuth -> Meitnerium
        //  Mk IV recipe
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Iron.getPlasma(L))
                .fluidInputs(Bismuth.getFluid(L))
                .fluidOutputs(Meitnerium.getFluid(L * 2))
                .EUt(VA[UHV])
                .duration(140)
                .EUToStart(400000000L)
                .buildAndRegister();

        //  Nickel + Bismuth -> Roentgenium
        //  Mk IV recipe
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Nickel.getPlasma(L))
                .fluidInputs(Bismuth.getFluid(L))
                .fluidOutputs(Roentgenium.getFluid(L * 2))
                .EUt(VA[UHV])
                .duration(180)
                .EUToStart(440000000L)
                .buildAndRegister();

        //  Nickel + Polonium -> Copernicium
        //  Mk III recipe
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Nickel.getPlasma(L * 4))
                .fluidInputs(Polonium.getFluid(L * 4))
                .fluidOutputs(Copernicium.getFluid(L * 4))
                .EUt(VA[UV])
                .duration(100)
                .EUToStart(480000000L)
                .buildAndRegister();

        //  Nickel + Astatine -> Nihonium
        //  Mk III recipe
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Nickel.getPlasma(L * 2))
                .fluidInputs(Astatine.getFluid(L * 2))
                .fluidOutputs(Nihonium.getFluid(L * 4))
                .EUt(358690)
                .duration(180)
                .EUToStart(410000000L)
                .buildAndRegister();

        //  Neptunium + Titanium -> Moscovium
        //  Mk III recipe
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Neptunium.getFluid(L * 2))
                .fluidInputs(Titanium.getFluid(L * 2))
                .fluidOutputs(Moscovium.getFluid(L * 4))
                .EUt(473960)
                .duration(220)
                .EUToStart(380000000L)
                .buildAndRegister();

        //  Americium + Titanium -> Tennessine
        //  Mk III recipe
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Americium.getFluid(L * 2))
                .fluidInputs(Titanium.getFluid(L * 2))
                .fluidOutputs(Tennessine.getFluid(L * 4))
                .EUt(509370)
                .duration(300)
                .EUToStart(420000000L)
                .buildAndRegister();
    }

    private static void FantasyMaterials() {

        //  Nether Star + Bedrock -> Ichor Liquid
        //  Mk IV recipe, you need this to make Ichorium.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(NetherStar.getFluid(L))
                .fluidInputs(Bedrock.getFluid(1000))
                .fluidOutputs(IchorLiquid.getPlasma(L * 4))
                .EUt(VA[UHV])
                .duration(45)
                .EUToStart(650000000L)
                .buildAndRegister();

        //  Nether Star + Glowstone -> Solarium
        //  Mk IV recipe, this material is UIV stage wire.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(NetherStar.getFluid(L))
                .fluidInputs(Glowstone.getFluid(1000))
                .fluidOutputs(Solarium.getFluid(L * 4))
                .EUt(VA[UHV])
                .duration(45)
                .EUToStart(650000000L)
                .buildAndRegister();

        //  Silver + Starlight Liquid -> Luna Silver
        //  Mk IV recipe, this material is used to make Cosmic SoC and some UIV+ things.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Silver.getFluid(L / 2))
                .fluidInputs(StarlightLiquid.getFluid(L / 2))
                .fluidOutputs(LunaSilver.getFluid(L))
                .EUt(VA[UHV])
                .duration(45)
                .EUToStart(650000000L)
                .buildAndRegister();

        //  Ichor Liquid + Radon -> Ichorium
        //  Mk IV recipe, you need this to make Ichorium wire coil block.
        //  When you get ichorium, you can make UEV stage components, and then get Fusion Reactor Mk V.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(IchorLiquid.getPlasma(L))
                .fluidInputs(Radon.getFluid(1000))
                .fluidOutputs(Ichorium.getFluid(500))
                .EUt(VA[UHV])
                .duration(100)
                .EUToStart(1200000000L)
                .buildAndRegister();

        //  Orichalcum + Zirconium -> Mithril
        //  Mk III recipe, you need this to make Infinity.
        //  Of cource, you also need mithril to get Fusion Reactor Mk V.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Orichalcum.getFluid(16))
                .fluidInputs(Zirconium.getFluid(L * 4))
                .fluidOutputs(Mithril.getPlasma(L * 4))
                .EUt(VA[UV])
                .duration(60)
                .EUToStart(450000000L)
                .buildAndRegister();

        //  Vibranium + Duranium -> Crystal Matrix
        //  Mk IV recipe, you need this to make Infinity.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Vibranium.getPlasma(16))
                .fluidInputs(Duranium.getFluid(L * 2))
                .fluidOutputs(CrystalMatrix.getFluid(L * 2))
                .EUt(VA[UHV])
                .duration(120)
                .EUToStart(800000000L)
                .buildAndRegister();

        //  Crystal Matrix + Mithril -> Infinity
        //  Mk V recipe, this material is UIV stage main material.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(CrystalMatrix.getFluid(L * 2))
                .fluidInputs(Mithril.getFluid(L * 2))
                .fluidOutputs(Infinity.getFluid(L * 4))
                .EUt(VA[UEV])
                .duration(240)
                .EUToStart(2550000000L)
                .buildAndRegister();

        //  Void Metal + Bedrock -> Rhugnor
        //  Mk IV recipe, you need this to make hypogen.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(VoidMetal.getFluid(L * 2))
                .fluidInputs(Bedrock.getFluid(1000))
                .fluidOutputs(Rhugnor.getFluid(L * 4))
                .EUt(VA[UHV])
                .duration(160)
                .EUToStart(900000000L)
                .buildAndRegister();

        //  Dragon Blood + Rhugnor -> Hypogen
        //  Mk V recipe, this material is UXV stage wire.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(DragonBlood.getFluid(L * 4))
                .fluidInputs(Rhugnor.getFluid(L * 4))
                .fluidOutputs(Hypogen.getPlasma(L * 8))
                .EUt(VA[UEV])
                .duration(320)
                .EUToStart(2530000000L)
                .buildAndRegister();

        //  Neon + Bedrock -> Taranium plasma
        //  Mk III recipe, a basic material to make higher plasma.
        //  Pay attention, this plasma can not condense to taranium.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Neon.getFluid(L))
                .fluidInputs(Bedrock.getFluid(L))
                .fluidOutputs(Taranium.getPlasma(L * 2))
                .EUt(VA[UV])
                .duration(64)
                .EUToStart(360000000L)
                .buildAndRegister();

        //  Titanium + Taranium plasma -> Astral Titanium
        //  Mk V recipe, this material is UIV stage components.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Titanium.getFluid(L * 2))
                .fluidInputs(Taranium.getPlasma(L * 2))
                .fluidOutputs(AstralTitanium.getPlasma(L * 4))
                .EUt(VA[UEV])
                .duration(32)
                .EUToStart(1800000000L)
                .buildAndRegister();

        //  Tungsten + Taranium plasma -> Celestial Tungsten
        //  Mk V recipe, this material is UIV stage components.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Tungsten.getFluid(L * 2))
                .fluidInputs(Taranium.getPlasma(L * 2))
                .fluidOutputs(CelestialTungsten.getPlasma(L * 4))
                .EUt(VA[UEV])
                .duration(32)
                .EUToStart(1800000000L)
                .buildAndRegister();

        //  Bohrium + Naquadria -> Neutronium
        //  Mk V recipe, a basic material in UIV+ stage.
        //  The original recipe of Neutronium in vanilla CEu environment is Orichalcum recipe now.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Bohrium.getFluid(128))
                .fluidInputs(Naquadria.getFluid(128))
                .fluidOutputs(Neutronium.getFluid(32))
                .EUt(VA[UEV])
                .EUToStart(1300000000L)
                .duration(200)
                .buildAndRegister();

        //  Hikarium + Tairitsium -> Fatalium plasma
        //  Mk V recipe, OpV material pre step.
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Hikarium.getFluid(L * 4))
                .fluidInputs(Tairitsium.getFluid(L * 4))
                .fluidOutputs(Fatalium.getPlasma(L * 2))
                .EUt(VA[UEV])
                .EUToStart(2550000000L)
                .duration(20)
                .buildAndRegister();
    }
}