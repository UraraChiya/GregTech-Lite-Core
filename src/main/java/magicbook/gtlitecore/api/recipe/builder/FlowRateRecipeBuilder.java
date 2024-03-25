package magicbook.gtlitecore.api.recipe.builder;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.PrimitiveProperty;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.TextFormattingUtil;
import gregtech.api.util.ValidationResult;
import magicbook.gtlitecore.api.recipe.properties.FlowRateProperty;
import magicbook.gtlitecore.api.recipe.properties.MaxRateProperty;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

/**
 * Flow Rate Recipe Builder
 *
 * @author Gate Guardian
 */
public class FlowRateRecipeBuilder extends RecipeBuilder<FlowRateRecipeBuilder> {

    public FlowRateRecipeBuilder() {}

    public FlowRateRecipeBuilder(Recipe recipe,
                                 RecipeMap<FlowRateRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public FlowRateRecipeBuilder(FlowRateRecipeBuilder builder) {
        super(builder);
    }

    public FlowRateRecipeBuilder copy() {
        return new FlowRateRecipeBuilder(this);
    }

    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(MaxRateProperty.KEY)) {
            flowRate(((Number) value).intValue());
            return true;
        }

        if (key.equals(FlowRateProperty.KEY)) {
            flowRate(((Number) value).intValue());
            return true;
        }

        return super.applyProperty(key, value);
    }

    public FlowRateRecipeBuilder maxRate(int heatMaxRate) {
        if (heatMaxRate < 0) {
            GTLiteLog.logger.error("Max Rate cannot be less than 0", new IllegalArgumentException());
            this.recipeStatus = EnumValidationResult.INVALID;
        }

        applyProperty(MaxRateProperty.getInstance(), heatMaxRate);
        return this;
    }

    public FlowRateRecipeBuilder flowRate(int heatFlowRate) {
        if (heatFlowRate < 0) {
            GTLiteLog.logger.error("Flow Rate cannot be less than 0", new IllegalArgumentException());
            this.recipeStatus = EnumValidationResult.INVALID;
        }

        applyProperty(FlowRateProperty.getInstance(), heatFlowRate);
        return this;
    }

    public int getMaxRate() {
        return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage
                .getRecipePropertyValue(MaxRateProperty.getInstance(), 0);
    }

    public int getFlowRate() {
        return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage
                .getRecipePropertyValue(FlowRateProperty.getInstance(), 0);
    }

    public ValidationResult<Recipe> build() {
        this.EUt(1);
        this.applyProperty(PrimitiveProperty.getInstance(), true);
        return super.build();
    }

    public String toString() {
        return (new ToStringBuilder(this))
                .appendSuper(super.toString())
                .append(MaxRateProperty.getInstance().getKey(), TextFormattingUtil.formatNumbers(getMaxRate()))
                .append(FlowRateProperty.getInstance().getKey(), TextFormattingUtil.formatNumbers(getFlowRate()))
                .toString();
    }
}
