package magicbook.gtlitecore.api.recipe.builder;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import magicbook.gtlitecore.api.recipe.properties.FieldCasingTierProperty;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityCollider;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

/**
 * Field Casing Recipe Builder
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class creates a recipe builder for field casing tier system,
 *     used for many multiblocks, e.g. {@link MetaTileEntityCollider}.
 *     You should use {@link MultiblockRecipeLogic#checkRecipe(Recipe)} to implement correspondent function about this recipe.
 *     About related recipe property, please see: {@link FieldCasingTierProperty}.
 * </p>
 */
public class FieldCasingTierRecipeBuilder extends RecipeBuilder<FieldCasingTierRecipeBuilder> {

    public FieldCasingTierRecipeBuilder() {}

    public FieldCasingTierRecipeBuilder(Recipe recipe,
                                        RecipeMap<FieldCasingTierRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public FieldCasingTierRecipeBuilder(RecipeBuilder<FieldCasingTierRecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public FieldCasingTierRecipeBuilder copy() {
        return new FieldCasingTierRecipeBuilder(this);
    }

    public int getFieldCasingTier() {
        return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage.getRecipePropertyValue(FieldCasingTierProperty.getInstance(), 0);
    }

    @Override
    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(FieldCasingTierProperty.KEY)) {
            this.tier(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public FieldCasingTierRecipeBuilder tier(int casingTier) {
        if (casingTier <= 0) {
            GTLiteLog.logger.error("Casing Tier cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(FieldCasingTierProperty.getInstance(), casingTier);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(FieldCasingTierProperty.getInstance().getKey(), getFieldCasingTier())
                .toString();
    }
}
