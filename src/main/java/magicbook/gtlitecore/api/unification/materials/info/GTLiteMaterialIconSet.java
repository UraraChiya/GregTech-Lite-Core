package magicbook.gtlitecore.api.unification.materials.info;

import gregtech.api.unification.material.info.MaterialIconSet;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.items.behaviors.renderer.HaloRenderItemBehavior;

public class GTLiteMaterialIconSet {
    public static final MaterialIconSetWithRenderer CUSTOM_INFINITY = new MaterialIconSetWithRenderer("infinity", null, true, new HaloRenderItemBehavior(10, 0xFF000000, () -> GTLiteTextures.HALO, true));
    public static final MaterialIconSet CUSTOM_SPACETIME = new MaterialIconSet("spacetime", null, true);
    public static final MaterialIconSet CUSTOM_DEGENERATE_RHENIUM = new MaterialIconSet("degenerate_rhenium", null, true);
    public static final MaterialIconSet CUSTOM_LEGENDARIUM = new MaterialIconSet("legendarium", null, true);
    public static final MaterialIconSet CUSTOM_MHCSM = new MaterialIconSet("mhcsm", null, true);
    public static final MaterialIconSetWithRenderer CUSTOM_ETERNITY = new MaterialIconSetWithRenderer("eternity", null, true, new HaloRenderItemBehavior(10, 0xFF000000, () -> GTLiteTextures.HALO, true));
    public static final MaterialIconSet CUSTOM_RHUGNOR = new MaterialIconSet("rhugnor", null, true);
    public static final MaterialIconSet CUSTOM_HYPOGEN = new MaterialIconSet("hypogen", null, true);
    public static final MaterialIconSetWithRenderer CUSTOM_COSMIC_NEUTRONIUM = new MaterialIconSetWithRenderer("cosmic_neutronium", null, true, new HaloRenderItemBehavior(10, 0x33FFFFFF, () -> GTLiteTextures.HALO_NOISE, true));
    public static final MaterialIconSet CUSTOM_MAGNETO_RESONATIC = new MaterialIconSet("magneto_resonatic", null, true);
    public static final MaterialIconSet REAGENT = new MaterialIconSet("reagent", null, true);
    public static final MaterialIconSet CUSTOM_OMNIUM = new MaterialIconSetWithRenderer("omnium", null, true, new HaloRenderItemBehavior(10, 0xFFFFFFFF, () -> GTLiteTextures.HALO, true));
}