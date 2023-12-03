package magicbook.gtlitecore.api.unification.materials.info;

import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.client.resources.I18n;

import java.util.Collections;

import static gregtech.api.GTValues.M;
import static gregtech.api.unification.ore.OrePrefix.Conditions.hasGemProperty;
import static gregtech.api.unification.ore.OrePrefix.Flags.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialFlags.*;

public class GTLiteOrePrefix {

    public static final OrePrefix milled = new OrePrefix("milled", -1, null, GTLiteMaterialIconType.milled, ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty.and(mat -> mat.hasFlag(GENERATE_MILLED)), mat -> Collections.singletonList(I18n.format("metaitem.milled.tooltip.flotation")));

    public static final OrePrefix seedCrystal = new OrePrefix("seedCrystal", M / 9, null, GTLiteMaterialIconType.seedCrystal, ENABLE_UNIFICATION,
            hasGemProperty.and(mat -> mat.hasFlag(GENERATE_BOULE) || (mat.hasFlag(MaterialFlags.CRYSTALLIZABLE) && !mat.hasFlag(GTLiteMaterialFlags.DISABLE_CRYSTALLIZATION))));
    public static final OrePrefix boule = new OrePrefix("boule", M * 4, null, GTLiteMaterialIconType.boule, ENABLE_UNIFICATION,
            hasGemProperty.and(mat -> mat.hasFlag(GENERATE_BOULE) || (mat.hasFlag(MaterialFlags.CRYSTALLIZABLE) && !mat.hasFlag(GTLiteMaterialFlags.DISABLE_CRYSTALLIZATION))));
}