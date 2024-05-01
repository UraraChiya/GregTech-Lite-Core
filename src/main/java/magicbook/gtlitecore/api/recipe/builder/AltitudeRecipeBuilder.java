package magicbook.gtlitecore.api.recipe.builder;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import magicbook.gtlitecore.api.recipe.properties.AltitudeProperty;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityCosmicRayDetector;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

/**
 * Altitude Recipe Builder
 *
 * @author Gate Guardian
 *
 * <p>
 *     This class creates a recipe builder for detecting the height in multiblocks,
 *     actually, this function is implement in multiblocks, e.g. {@link MetaTileEntityCosmicRayDetector}).
 *     You should use {@link MultiblockRecipeLogic#checkRecipe(Recipe)} to implement correspondent function about this recipe.
 *     About related recipe property, please see: {@link AltitudeProperty}.
 * </p>
 */
public class AltitudeRecipeBuilder extends RecipeBuilder<AltitudeRecipeBuilder> {

    public AltitudeRecipeBuilder() {}

    public AltitudeRecipeBuilder(Recipe recipe, RecipeMap<AltitudeRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public AltitudeRecipeBuilder(AltitudeRecipeBuilder builder) {
        super(builder);
    }

    public AltitudeRecipeBuilder copy() {
        return new AltitudeRecipeBuilder(this);
    }

    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals("altitude")) {
            altitude(((Number)value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public AltitudeRecipeBuilder altitude(int altitude) {
        if (altitude <= -64 || altitude >= 256) {
            GTLiteLog.logger.error("Altitude cannot be less than -64 or greater than 256", new IllegalArgumentException());
            this.recipeStatus = EnumValidationResult.INVALID;
        }
        applyProperty(AltitudeProperty.getInstance(), altitude);
        return this;
    }

    public int getAltitude() {
        return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage
                .getRecipePropertyValue(AltitudeProperty.getInstance(), 0);
    }

    public String toString() {
        return (new ToStringBuilder(this))
                .appendSuper(super.toString())
                .append(AltitudeProperty.getInstance().getKey(), getAltitude())
                .toString();
    }
}
