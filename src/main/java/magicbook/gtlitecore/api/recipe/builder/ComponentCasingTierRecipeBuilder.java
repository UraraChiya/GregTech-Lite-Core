package magicbook.gtlitecore.api.recipe.builder;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import magicbook.gtlitecore.api.recipe.properties.ComponentCasingTierProperty;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

/**
 * Component Assembly Line Casing Recipe builder
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class creates a recipe builder for Component Assembly Line Casing Tier system (please see: {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityComponentAssemblyLine}.
 *     You should use {@link gregtech.api.capability.impl.MultiblockRecipeLogic#checkRecipe(Recipe)} to implement correspondent function about this recipe.
 *     About related recipe property, please see: {@link ComponentCasingTierProperty}.
 * </p>
 */
public class ComponentCasingTierRecipeBuilder extends RecipeBuilder<ComponentCasingTierRecipeBuilder> {

    public ComponentCasingTierRecipeBuilder() {}

    public ComponentCasingTierRecipeBuilder(Recipe recipe,
                                            RecipeMap<ComponentCasingTierRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public ComponentCasingTierRecipeBuilder(RecipeBuilder<ComponentCasingTierRecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public ComponentCasingTierRecipeBuilder copy() {
        return new ComponentCasingTierRecipeBuilder(this);
    }

    public int getComponentTier() {
        return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage.getRecipePropertyValue(ComponentCasingTierProperty.getInstance(), 0);
    }

    @Override
    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(ComponentCasingTierProperty.KEY)) {
            this.CasingTier(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public ComponentCasingTierRecipeBuilder CasingTier(int Tier) {
        if (Tier <= 0) {
            GTLiteLog.logger.error("Casing Tier cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }

        this.applyProperty(ComponentCasingTierProperty.getInstance(), Tier);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(ComponentCasingTierProperty.getInstance().getKey(), getComponentTier())
                .toString();
    }
}