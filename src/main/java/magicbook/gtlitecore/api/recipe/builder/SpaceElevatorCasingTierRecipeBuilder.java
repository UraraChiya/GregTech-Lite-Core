package magicbook.gtlitecore.api.recipe.builder;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import magicbook.gtlitecore.api.recipe.properties.SpaceElevatorCasingTierProperty;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

/**
 * Space Elevator Casing Recipe Builder
 *
 * @author Magic_Sweepy
 */
public class SpaceElevatorCasingTierRecipeBuilder extends RecipeBuilder<SpaceElevatorCasingTierRecipeBuilder> {

    public SpaceElevatorCasingTierRecipeBuilder() {}

    public SpaceElevatorCasingTierRecipeBuilder(Recipe recipe,
                                                RecipeMap<SpaceElevatorCasingTierRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public SpaceElevatorCasingTierRecipeBuilder(RecipeBuilder<SpaceElevatorCasingTierRecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public SpaceElevatorCasingTierRecipeBuilder copy() {
        return new SpaceElevatorCasingTierRecipeBuilder(this);
    }

    public int getSpaceElevatorTier() {
        return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage.getRecipePropertyValue(SpaceElevatorCasingTierProperty.getInstance(), 0);
    }

    @Override
    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(SpaceElevatorCasingTierProperty.KEY)) {
            this.CasingTier(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public SpaceElevatorCasingTierRecipeBuilder CasingTier(int Tier) {
        if (Tier <= 0) {
            GTLiteLog.logger.error("Casing Tier cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(SpaceElevatorCasingTierProperty.getInstance(), Tier);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(SpaceElevatorCasingTierProperty.getInstance().getKey(), getSpaceElevatorTier())
                .toString();
    }
}