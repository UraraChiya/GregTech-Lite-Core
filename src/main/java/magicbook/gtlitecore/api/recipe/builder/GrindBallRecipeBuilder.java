package magicbook.gtlitecore.api.recipe.builder;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import magicbook.gtlitecore.api.recipe.properties.GrindBallProperty;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

/**
 * Grindball Recipe Builder
 *
 * @author Gate Guardian
 */
public class GrindBallRecipeBuilder extends RecipeBuilder<GrindBallRecipeBuilder> {

    public GrindBallRecipeBuilder() {}

    public GrindBallRecipeBuilder(Recipe recipe,
                                  RecipeMap<GrindBallRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public GrindBallRecipeBuilder(RecipeBuilder<GrindBallRecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public GrindBallRecipeBuilder copy() {
        return new GrindBallRecipeBuilder(this);
    }

    public int getLevel() {
        return this.recipePropertyStorage == null ? 0 :
                this.recipePropertyStorage.getRecipePropertyValue(GrindBallProperty.getInstance(), 0);
    }

    @Override
    public boolean applyProperty(@Nonnull String key,
                                 Object value) {
        if (key.equals(GrindBallProperty.KEY)) {
            this.grindBallTier(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public GrindBallRecipeBuilder grindBallTier(int level) {
        if (level <= 0) {
            GTLiteLog.logger.error("Grind Ball Tier cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(GrindBallProperty.getInstance(), level);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(GrindBallProperty.getInstance().getKey(), getLevel())
                .toString();
    }
}
