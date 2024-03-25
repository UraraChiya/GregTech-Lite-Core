package magicbook.gtlitecore.loaders.handlers;

import gregtech.api.recipes.builders.BlastRecipeBuilder;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.GemProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import java.util.List;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.AUTOCLAVE_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CUTTER_RECIPES;
import static gregtech.api.unification.material.Materials.DistilledWater;
import static gregtech.api.unification.ore.OrePrefix.gemExquisite;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.CRYSTALLIZATION_RECIPES;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialFlags.DISABLE_CRYSTALLIZATION;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.boule;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.seedCrystal;

public class BouleRecipeHandler {

    public static void register() {
        OrePrefix.gem.addProcessingHandler(PropertyKey.GEM, BouleRecipeHandler::processCrystallizer);
    }

    public static void processCrystallizer(OrePrefix gem, @Nonnull Material material, GemProperty property) {

        //  If material has flag DISABLE_CRYSTALLIZATION, then do not generate crystallization of material.
        if (!material.hasFlag(MaterialFlags.CRYSTALLIZABLE) || material.hasFlag(DISABLE_CRYSTALLIZATION))
            return;

        //  If material has too may components, then do not generate recipe.
        if (material.getMaterialComponents().size() > CRYSTALLIZATION_RECIPES.getMaxInputs() - 1 + CRYSTALLIZATION_RECIPES.getMaxFluidInputs()) {
            return;
        }

        int componentAmount = 0;
        int temperature = 0;

        List<ItemStack> inputs = new ObjectArrayList<>();
        List<FluidStack> fluidInputs = new ObjectArrayList<>();

        for (MaterialStack materialStack : material.getMaterialComponents()) {
            Material componentMaterial = materialStack.material;
            int amount = (int) materialStack.amount;

            //  Check if material has dust property.
            if (componentMaterial.isSolid() || componentMaterial.hasProperty(PropertyKey.DUST)) {
                componentAmount += amount;
                temperature += componentMaterial.getBlastTemperature() * amount;

                //  If material has too may components, then do not generate recipe.
                if (inputs.size() > CRYSTALLIZATION_RECIPES.getMaxInputs() - 1) {
                    return;
                }

                //  If okay, load its components into recipe.
                inputs.add(OreDictUnifier.get(OrePrefix.dust, componentMaterial, amount));
            } else if (componentMaterial.hasProperty(PropertyKey.FLUID)) {
                //  Check fluid components, e.g. Chlorine.
                componentAmount += amount;

                //  If material has too many fluid components, then do not generate recipe.
                if (fluidInputs.size() > CRYSTALLIZATION_RECIPES.getMaxFluidInputs()) {
                    return;
                }

                //  If okay, load its fluid components into recipe.
                fluidInputs.add(componentMaterial.getFluid(amount * 1000));
            }

            //  If materials with no blast temperature property, then set it blast temperature to 1200K.
            if (!componentMaterial.hasProperty(PropertyKey.BLAST)) {
                temperature += 1200 * amount;
            }
        }

        //  Prohibit division by zero
        //  FIXME May be can be delete
        if (componentAmount == 0) return;

        //  Get average temperature for recipes.
        temperature /= componentAmount;

        //  Use Blast Recipe Builder to define crystallizer recipes, check temperature of recipe and choose a match voltage.
        BlastRecipeBuilder builder = CRYSTALLIZATION_RECIPES.recipeBuilder()
                .blastFurnaceTemp(temperature)
                .EUt(VA[temperature <= 2800 ? HV : EV]);

        //  If material has two component, then set stack amount to 2.
        if (componentAmount == 2) {
            for (ItemStack stack : inputs) {
                stack.setCount(stack.getCount() * 2);
            }
            for (FluidStack stack : fluidInputs) {
                stack.amount *= 2;
            }

            componentAmount = 1;

            //  Get duration of recipe.
            builder.duration((int) (material.getMass() * 4 * 2));
        } else if (componentAmount % 4 != 0) {
            for (ItemStack stack : inputs) {
                stack.setCount(stack.getCount() * 4);
            }
            for (FluidStack stack : fluidInputs) {
                stack.amount *= 4;
            }

            builder.duration((int) (material.getMass() * 4 * 4));
        } else {
            componentAmount /= 4;

            builder.duration((int) (material.getMass() * 4));
        }

        //  Seed Crystal -> Boule
        builder.input(seedCrystal, material, componentAmount).output(boule, material, componentAmount);

        //  Pay attention, some recipes should add other origin (i.e. here is the automatically generated recipe).
        if (!inputs.isEmpty()) builder.inputStacks(inputs);
        if (!fluidInputs.isEmpty()) builder.fluidInputs(fluidInputs.toArray(new FluidStack[0]));
        builder.buildAndRegister();

        //  Boule -> Exquisite Gem + Seed Crystal
        CUTTER_RECIPES.recipeBuilder()
                .input(boule, material)
                .output(gemExquisite, material)
                .output(seedCrystal, material)
                .duration((int) (material.getMass() * 4))
                .EUt(16)
                .buildAndRegister();

        //  Exquisite Gem + Distilled Water -> Seed Crystal
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(gemExquisite, material)
                .fluidInputs(DistilledWater.getFluid(8000))
                .output(seedCrystal, material)
                .duration((int) (material.getMass() * 9))
                .EUt(VA[HV])
                .buildAndRegister();
    }
}