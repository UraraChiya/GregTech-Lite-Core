package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.recipes.GTRecipeHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.ingotHot;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.DECAY_GENERATOR_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.ALPHA_PARTICLE;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.NEUTRON;

public class DecayGenerator {

    public static void init() {
        Elements();
        HighEnergyPhysics();
    }

    private static void Elements() {
        MetastableFleroviumChain();

        //  Yb -> Hf
        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Ytterbium.getFluid(L))
                .fluidOutputs(Hafnium.getFluid(L))
                .EUt(VA[LuV])
                .duration(120)
                .tier(1)
                .buildAndRegister();

        //  Ac -> Fr
        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Actinium.getFluid(L))
                .fluidOutputs(Francium.getFluid(L))
                .EUt(VA[ZPM])
                .duration(100)
                .tier(2)
                .buildAndRegister();

        //  Mo -> Tc
        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Molybdenum.getFluid(L))
                .fluidOutputs(Technetium.getFluid(L))
                .EUt(VA[IV])
                .duration(100)
                .tier(1)
                .buildAndRegister();

        //  Th -> Pa
        //  Needs Neutron Irradiation, so you need use Nitrogen plasma in Collider to get Neutron.
        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .notConsumable(NEUTRON)
                .fluidInputs(Thorium.getFluid(L))
                .fluidOutputs(Protactinium.getFluid(L))
                .EUt(VA[LuV])
                .duration(80)
                .tier(1)
                .buildAndRegister();

        //  Ra -> Rn + alpha
        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Radium.getFluid(1000))
                .output(ALPHA_PARTICLE)
                .fluidOutputs(Radon.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(120)
                .tier(1) // ZPM
                .buildAndRegister();
    }

    private static void MetastableFleroviumChain() {

        //  Flerovium-Ytterbium Plasma
        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(QuasifissioningPlasma.getPlasma(1000))
                .fluidOutputs(FleroviumYtterbiumPlasma.getPlasma(1000))
                .EUt(VA[ZPM])
                .duration(160)
                .tier(1)
                .buildAndRegister();

        //  Flerovium-Ytterbium Plasma -> Metastable Flerovium
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(FleroviumYtterbiumPlasma.getPlasma(1000))
                .fluidOutputs(MetastableFlerovium.getFluid(L * 2))
                .fluidOutputs(Ytterbium.getFluid(L * 2))
                .EUt(VA[EV])
                .duration(290)
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_INGOT.getStackForm()},
                new FluidStack[]{MetastableFlerovium.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_BLOCK.getStackForm()},
                new FluidStack[]{MetastableFlerovium.getFluid(1296)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_NUGGET.getStackForm()},
                new FluidStack[]{MetastableFlerovium.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_PLATE.getStackForm()},
                new FluidStack[]{MetastableFlerovium.getFluid(144)});

        //  Metastable Flerovium liquid -> Metastable Flerovium hot ingot
        VACUUM_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(MetastableFlerovium.getFluid(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 500))
                .output(ingotHot, MetastableFlerovium)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 500))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();
    }

    private static void HighEnergyPhysics() {

        //  Helium liquid -> Alpha Particle
        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 3200))
                .chancedOutput(ALPHA_PARTICLE, 1000, 500)
                .EUt(VH[IV])
                .duration(200)
                .tier(1) // ZPM
                .buildAndRegister();

        //  Helium-3 -> Alpha Particle
        //  In centrifuge, 80 Helium -> 5 Helium-3 (16:1).
        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Helium3.getFluid(200))
                .chancedOutput(ALPHA_PARTICLE, 1000, 500)
                .EUt(VH[LuV])
                .duration(100)
                .tier(1) // ZPM
                .buildAndRegister();

        //  Helium Plasma -> Alpha Particle
        //  In Fusion Reactor (Mk I), 125 D + 125 T -> 125 He.
        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Helium.getPlasma(125))
                .chancedOutput(ALPHA_PARTICLE, 1000, 500)
                .EUt(VH[ZPM])
                .duration(50)
                .tier(1) // ZPM
                .buildAndRegister();
    }
}
