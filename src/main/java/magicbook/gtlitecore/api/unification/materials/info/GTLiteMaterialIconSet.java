package magicbook.gtlitecore.api.unification.materials.info;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.material.info.MaterialIconSet;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.items.behaviors.renderer.HaloRenderItemBehavior;

/**
 * Material Icon Set
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     Material Icon set class for gtlitecore, like {@link MaterialIconSet}.
 *     But some icon set use extended shader, please see: {@link MaterialIconSetWithRenderer}.
 *     This extended icon set required mixin of gregtech's meta item classes,
 *     such as {@link MetaItem.MetaValueItem}.
 * </p>
 *
 * @since 2.8.7-beta
 */
public class GTLiteMaterialIconSet {

    /**
     * Enriched Icon Set
     *
     * <p>
     *     The source icon set is from <a href="https://github.com/GTNewHorizons/GTplusplus">GT++</a>.
     *     Some materials like {@link GTLiteMaterials#Hypogen}use this icon set now.
     * </p>
     *
     * @since 2.7.4-beta
     */
    public static final MaterialIconSet ENRICHED = new MaterialIconSet("enriched", null, true);

    /**
     * Nuclear Icon Set
     *
     * <p>
     *     The source icon set is from <a href="https://github.com/GTNewHorizons/GTplusplus">GT++</a>.
     *     Some materials like {@link GTLiteMaterials#Rhugnor}use this icon set now.
     * </p>
     *
     * @since 2.8.7-beta
     */
    public static final MaterialIconSet NUCLEAR = new MaterialIconSet("nuclear", null, true);

    /**
     * Reagent Icon Set
     *
     * <p>
     *     This icon set is same like some <a href="https://github.com/GTNewHorizons/GTplusplus">GT++</a> textures,
     *     add some reagent style dust, only some chemical material used this icon set,
     *     like {@link GTLiteMaterials#SodiumEthylxanthate} for Isa Mill ore processing.
     * </p>
     *
     * @since 2.8.7-beta
     */
    public static final MaterialIconSet REAGENT = new MaterialIconSet("reagent", null, true);

    /**
     * Custom Icon Set: Infinity
     *
     * <p>
     *     The source icon set is from <a href="https://github.com/GTNewHorizons/GT5-Unofficial">GT5u</a>.
     *     This icon set is for {@link GTLiteMaterials#Infinity}.
     *     Hint: This icon set has a extended {@code renderer} by {@link HaloRenderItemBehavior}.
     * </p>
     *
     * @since 2.7.4-beta
     */
    public static final MaterialIconSetWithRenderer CUSTOM_INFINITY = new MaterialIconSetWithRenderer("infinity", null, true, new HaloRenderItemBehavior(10, 0xFF000000, () -> GTLiteTextures.HALO, true));

    /**
     * Custom Icon Set: Space Time
     *
     * <p>
     *     The source icon set is from <a href="https://github.com/GTNewHorizons/GT5-Unofficial">GT5u</a>.
     *     This icon set is for {@link GTLiteMaterials#Spacetime}.
     * </p>
     *
     * @since 2.7.4-beta
     */
    public static final MaterialIconSet CUSTOM_SPACETIME = new MaterialIconSet("spacetime", null, true);

    /**
     * Custom Icon Set: Degenerate Rhenium
     *
     * <p>
     *     The source icon set is from <a href="https://github.com/GregTechCEu/gregicality-legacy">GCY</a>.
     *     This icon set is for {@link GTLiteMaterials#DegenerateRhenium}.
     * </p>
     *
     * @since 2.7.4-beta
     */
    public static final MaterialIconSet CUSTOM_DEGENERATE_RHENIUM = new MaterialIconSet("degenerate_rhenium", null, true);

    /**
     * Custom Icon Set: MHCSM (Magneto Hydrodynamically Constrained Star Matter)
     *
     * <p>
     *     The source icon set is from <a href="https://github.com/GTNewHorizons/GT5-Unofficial">GT5u</a>.
     *     This icon set is for {@link GTLiteMaterials#MagnetoHydrodynamicallyConstrainedStarMatter}.
     * </p>
     *
     * @since 2.7.4-beta
     */
    public static final MaterialIconSet CUSTOM_MHCSM = new MaterialIconSet("mhcsm", null, true);

    /**
     * Custom Icon Set: Eternity
     *
     * <p>
     *     The source icon set is from <a href="https://github.com/GTNewHorizons/GT5-Unofficial">GT5u</a>.
     *     This icon set is for {@link GTLiteMaterials#Eternity}.
     *     Hint: This icon set has a extended {@code renderer} by {@link HaloRenderItemBehavior}.
     * </p>
     *
     * @since 2.8.7-beta
     */
    public static final MaterialIconSetWithRenderer CUSTOM_ETERNITY = new MaterialIconSetWithRenderer("eternity", null, true, new HaloRenderItemBehavior(10, 0xFF000000, () -> GTLiteTextures.HALO, true));

    //  TODO Redo
    public static final MaterialIconSetWithRenderer CUSTOM_COSMIC_NEUTRONIUM = new MaterialIconSetWithRenderer("cosmic_neutronium", null, true, new HaloRenderItemBehavior(10, 0x33FFFFFF, () -> GTLiteTextures.HALO_NOISE, true));

    /**
     * Custom Icon Set: Magneto Resonatic
     *
     * <p>
     *     This icon set is used to mix {@link MaterialIconSet#DIAMOND} and {@link MaterialIconSet#MAGNETIC},
     *     in {@code bartworks} and {@code gregicality}, this gem is commonly use this textures.
     * </p>
     *
     * @since 2.8.7-beta
     */
    public static final MaterialIconSet CUSTOM_MAGNETO_RESONATIC = new MaterialIconSet("magneto_resonatic", null, true);

    //  TODO Finish
    public static final MaterialIconSet CUSTOM_OMNIUM = new MaterialIconSetWithRenderer("omnium", null, true, new HaloRenderItemBehavior(10, 0xFFFFFFFF, () -> GTLiteTextures.HALO, true));

    /**
     * Custom Icon Set: Magmatter
     *
     * <p>
     *     The source icon set is from <a href="https://github.com/GTNewHorizons/GT5-Unofficial">GT5u</a>.
     *     This icon set is for {@link GTLiteMaterials#Magmatter}.
     *     Hint: This icon set has a extended {@code renderer} by {@link HaloRenderItemBehavior}.
     * </p>
     */
    public static final MaterialIconSetWithRenderer CUSTOM_MAGMATTER = new MaterialIconSetWithRenderer("magmatter", null, true, new HaloRenderItemBehavior(10, 0x33FFFFFF, () -> GTLiteTextures.HALO_NOISE, true));
}