package magicbook.gtlitecore.api;

import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import magicbook.gtlitecore.GTLiteCore;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import net.minecraft.util.text.TextFormatting;

@SuppressWarnings("unused")
public class GTLiteValues {

    /**
     * Special Voltage for some recipes needs integer based energy consumed.
     */
    public static final int[] VZ = new int[] { 1, 30, 100, 500, 2000, 8000, 30000, 100000, 500000, 2000000, 8000000, 30000000, 100000000, 500000000, 2000000000 };

    /**
     * Tier list for {@link OrePrefix#circuit}, used in some recipes.
     */
    public static final Material[] tierList = { MarkerMaterials.Tier.ULV, MarkerMaterials.Tier.LV, MarkerMaterials.Tier.MV, MarkerMaterials.Tier.HV, MarkerMaterials.Tier.EV, MarkerMaterials.Tier.IV, MarkerMaterials.Tier.LuV, MarkerMaterials.Tier.ZPM, MarkerMaterials.Tier.UV, MarkerMaterials.Tier.UHV, MarkerMaterials.Tier.UEV, MarkerMaterials.Tier.UIV, MarkerMaterials.Tier.UXV, MarkerMaterials.Tier.OpV, MarkerMaterials.Tier.MAX };

    /**
     * Color list for recipes (used in some special situation like {@link OrePrefix#lens}).
     */
    public static final Material[] colorList = { MarkerMaterials.Color.White, MarkerMaterials.Color.Orange, MarkerMaterials.Color.Magenta, MarkerMaterials.Color.LightBlue, MarkerMaterials.Color.Yellow, MarkerMaterials.Color.Lime, MarkerMaterials.Color.Pink, MarkerMaterials.Color.Gray, MarkerMaterials.Color.LightGray, MarkerMaterials.Color.Cyan, MarkerMaterials.Color.Purple, MarkerMaterials.Color.Blue, MarkerMaterials.Color.Brown, MarkerMaterials.Color.Green, MarkerMaterials.Color.Red, MarkerMaterials.Color.Black };

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * because 1 second = 20 tick (in game), so we can use this to add 1 second.
     */
    public static final int SECOND = 20;

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * because 1 minute = 60 second = 1200 tick (in game), so we can use this to add 1 minute.
     */
    public static final int MINUTE = 60 * SECOND;

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * because 1 hour = 60 minute = 3600 second, so we can use this to add 1 hour.
     */
    public static final int HOUR = 60 * MINUTE;

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * just 1/2 {@link #HOUR} (means 30 minute and 1800 second).
     */
    public static final int HALF_HOUR = HOUR / 2;

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * just 1/4 {@link #HOUR} and 1/2 {@link #HALF_HOUR} (means 15 minute and 900 second).
     */
    public static final int QUAT_HOUR = HOUR / 4;

    /**
     * Special String for some {@code formula}, please see: {@link GTLiteMaterials}.
     * Commonly, we use below method {@link #formulaWithObfuscatedA(String)} for {@code formula}.
     */
    public static final String ObfuscatedA = TextFormatting.OBFUSCATED  + "a" + TextFormatting.RESET;

    /**
     * Used to add {@code formula} with two {@link #ObfuscatedA} at head and tail.
     *
     * <p>
     *     This format of {@code formula} is from {@code gregicality} originally,
     *     in that mod, formula of some high-energy material used two obfuscated symbol,
     *     of cause also at head and tail (so this method is a salute for {@code gregicality}).
     * </p>
     *
     * @param formula  Middle {@code formula}.
     * @return         Formula of {@code material}.
     */
    public static String formulaWithObfuscatedA(String formula) {
        return ObfuscatedA + formula + ObfuscatedA;
    }

    /**
     * Used to add obfuscated {@code formula}.
     *
     * @return Obfuscated {@code formula} (five a symbol, also is a salute of {@code gregicality}).
     */
    public static String addObfuscatedFormula() {
        return TextFormatting.OBFUSCATED + "aaaaaa";
    }

    /**
     * This modid is same as {@link GTLiteCore#MODID}.
     * Hint: this parameter is internal, we use it on class in {@code gtlitecore}.
     * Do not use this parameter in external situation (please use the first).
     */
    public static final String MODID = "gtlitecore";

    /**
     * This mod name is same as {@link GTLiteCore#NAME}.
     * Hint: this parameter is internal, we use it on class in {@code gtlitecore}.
     * Do not use this parameter in external situation (please use the first).
     */
    public static final String NAME = "Gregicality Science";

    /**
     * This mod version is same as {@link GTLiteCore#VERSION}.
     * Hint: this parameter is internal, we use it on class in {@code gtlitecore}.
     * Do not use this parameter in external situation (please use the first).
     */
    public static final String VERSION = "0.0.1-alpha";

    /**
     * Integration {@code modid}, please see: {@code integration/gregtech}.
     */
    public static final String MODID_GT = "gregtech";

    /**
     * Integration {@code modid}, please see: {@code integration/gcym}.
     */
    public static final String MODID_GCYM = "gcym";

    /**
     * Integration {@code modid}, please see: {@code integration/gregtechfoodoption}.
     */
    public static final String MODID_GTFO = "gregtechfoodoption";

    /**
     * @deprecated Integration {@code modid}.
     */
    @Deprecated
    public static final String MODID_AE2 = "appliedenergistics2";

    /**
     * @deprecated Integration {@code modid}.
     */
    @Deprecated
    public static final String MODID_XU2 = "extrautils2";

    /**
     * @deprecated Integration {@code modid}.
     */
    @Deprecated
    public static final String MODID_EIO = "enderio";

    /**
     * Integration {@code modid}, please see: {@code integration/theoneprobe}.
     */
    public static final String MODID_TOP = "theoneprobe";

    private GTLiteValues() {}
}
