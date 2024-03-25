package magicbook.gtlitecore.api;

import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;

@SuppressWarnings("unused")
public class GTLiteValues {

    /**
     * This modid is same as MODID in {@link magicbook.gtlitecore.GTLiteCore},
     * but please use it in internal interaction situation (e.g. {@link magicbook.gtlitecore.common.covers.GTLiteCoverBehavior}).
     */
    public static final String MODID = "gtlitecore";

    public static final String MODID_GT = "gregtech";

    public static final String MODID_GCYM = "gcym";

    public static final String MODID_GTFO = "gregtechfoodoption";

    public static final String MODID_AE2 = "appliedenergistics2";

    public static final String MODID_XU2 = "extrautils2";

    public static final String MODID_EIO = "enderio";

    public static final String MODID_TOP = "theoneprobe";

    public static final Material[] tierList = {
            MarkerMaterials.Tier.ULV,
            MarkerMaterials.Tier.LV,
            MarkerMaterials.Tier.MV,
            MarkerMaterials.Tier.HV,
            MarkerMaterials.Tier.EV,
            MarkerMaterials.Tier.IV,
            MarkerMaterials.Tier.LuV,
            MarkerMaterials.Tier.ZPM,
            MarkerMaterials.Tier.UV,
            MarkerMaterials.Tier.UHV,
            MarkerMaterials.Tier.UEV,
            MarkerMaterials.Tier.UIV,
            MarkerMaterials.Tier.UXV,
            MarkerMaterials.Tier.OpV,
            MarkerMaterials.Tier.MAX
    };

    public static final Material[] colorList = {
            MarkerMaterials.Color.White,
            MarkerMaterials.Color.Orange,
            MarkerMaterials.Color.Magenta,
            MarkerMaterials.Color.LightBlue,
            MarkerMaterials.Color.Yellow,
            MarkerMaterials.Color.Lime,
            MarkerMaterials.Color.Pink,
            MarkerMaterials.Color.Gray,
            MarkerMaterials.Color.LightGray,
            MarkerMaterials.Color.Cyan,
            MarkerMaterials.Color.Purple,
            MarkerMaterials.Color.Blue,
            MarkerMaterials.Color.Brown,
            MarkerMaterials.Color.Green,
            MarkerMaterials.Color.Red,
            MarkerMaterials.Color.Black
    };
}
