package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.FluidState;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import net.minecraft.util.text.TextFormatting;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.Deuterium;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.BRIGHT;
import static gregtech.api.util.GTUtility.gregtechId;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class GTLiteHighDegreeMaterials {

    //  Range: 15001-16000
    private static int startId = 15001;
    private static final int endId = startId + 999;

    public static void register() {

        //  15001 Quark Gluon Plasma
        QuarkGluonPlasma = new Material.Builder(getId(), gregtechId("quark_gluon_plasma"))
                .liquid(new FluidBuilder().state(FluidState.PLASMA).temperature((int) (V[ZPM] + V[UHV])/2))
                .color(0x8DA7DC)
                .build()
                .setFormula(TextFormatting.OBFUSCATED  + "a" + TextFormatting.RESET + "§e(u2)d(c2)s(t2)bg" + TextFormatting.OBFUSCATED + "a", false);

        //  15002 Heavy Quarks
        HeavyQuarks = new Material.Builder(getId(), gregtechId("heavy_quarks"))
                .liquid(new FluidBuilder().state(FluidState.PLASMA).temperature((int) V[ZPM]))
                .color(0xA6C8D4)
                .build()
                .setFormula(TextFormatting.OBFUSCATED  + "a"  + TextFormatting.RESET + "§e(u2)ds" + TextFormatting.OBFUSCATED  + "a" , true);

        //  15003 Light Quarks
        LightQuarks = new Material.Builder(getId(), gregtechId("light_quarks"))
                .liquid(new FluidBuilder().state(FluidState.PLASMA).temperature((int) (V[ZPM] + V[UHV])/2))
                .color(0x7E95DF)
                .build()
                .setFormula(TextFormatting.OBFUSCATED  + "a" + TextFormatting.RESET + "§e(c2)(t2)b" + TextFormatting.OBFUSCATED + "a", false);

        //  15004 Gluons
        Gluons = new Material.Builder(getId(), gregtechId("gluons"))
                .liquid(new FluidBuilder().state(FluidState.PLASMA).temperature((int) V[UHV]))
                .color(0x564983)
                .build()
                .setFormula(TextFormatting.OBFUSCATED  + "a" + TextFormatting.RESET + "§eg" + TextFormatting.OBFUSCATED  + "a", false);

        //  15005 Instantons
        Instantons = new Material.Builder(getId(), gregtechId("instantons"))
                .liquid(new FluidBuilder().state(FluidState.PLASMA).temperature((int) V[UEV]))
                .color(0x80CFEC)
                .build()
                .setFormula(TextFormatting.OBFUSCATED  + "a" + TextFormatting.RESET + "§ei" + TextFormatting.OBFUSCATED  + "a", false);

        //  15006 Higgs Bosons
        HiggsBosons = new Material.Builder(getId(), gregtechId("higgs_bosons"))
                .liquid(new FluidBuilder().state(FluidState.PLASMA).temperature((int) V[UXV]).customStill())
                .build()
                .setFormula(TextFormatting.OBFUSCATED  + "a" + TextFormatting.RESET + "§eh" + TextFormatting.OBFUSCATED + "a", false);

        //  15007 Heavy Lepton Mixture
        HeavyLepton = new Material.Builder(getId(), gregtechId("heavy_lepton"))
                .liquid(new FluidBuilder().state(FluidState.PLASMA).temperature((int)(V[UIV] - V[UV])))
                .color(0xD3A9F8)
                .build()
                .setFormula(TextFormatting.OBFUSCATED  + "a" + TextFormatting.RESET + "§e(t2)u" + TextFormatting.OBFUSCATED  + "a", true);

        //  15008 Temporal Fluid
        TemporalFluid = new Material.Builder(getId(), gregtechId("temporal_fluid"))
                .liquid(new FluidBuilder().state(FluidState.PLASMA).temperature((int)(V[OpV] - V[IV])).customStill())
                .build()
                .setFormula(TextFormatting.OBFUSCATED  + "a"  + TextFormatting.RESET + "§et" + TextFormatting.OBFUSCATED  + "a", false);

        //  15009 Cosmic Computing Mixture
        CosmicComputingMixture = new Material.Builder(getId(), gregtechId("cosmic_computing_mixture"))
                .liquid(new FluidBuilder().state(FluidState.PLASMA).temperature((int)(V[OpV])).customStill())
                .build()
                .setFormula(TextFormatting.OBFUSCATED + "aaaaaa", false);

        //  15010 Heavy Quark Enriched Mixture
        HeavyQuarkEnrichedMixture = new Material.Builder(getId(), gregtechId("heavy_quark_enriched_mixture"))
                .liquid(new FluidBuilder().state(FluidState.PLASMA).temperature((int) ((V[ZPM] * 4 + V[UHV])/2)))
                .color(HeavyQuarks.getMaterialRGB() + LightQuarks.getMaterialRGB())
                .components(LightQuarks, 1, HeavyQuarks, 3)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .build()
                .setFormula(TextFormatting.OBFUSCATED  + "a"  + TextFormatting.RESET + "§e(u2)d(c2)s(t2)b" + TextFormatting.OBFUSCATED  + "a" , true);

        //  15011 Deuterium-Superheavy Mixture
        DeuteriumSuperheavyMixture = new Material.Builder(getId(), gregtechId("deuterium_superheavy_mixture"))
                .liquid(new FluidBuilder().state(FluidState.PLASMA).temperature((int) (V[ZPM] * V[MV])/2))
                .color(0x7B9F8E)
                .components(Deuterium, 2, MetastableHassium, 1, MetastableFlerovium, 1, MetastableOganesson, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  15012 Heavy Quark Degenerate Matter
        HeavyQuarkDegenerateMatter = new Material.Builder(getId(), gregtechId("heavy_quark_degenerate_matter"))
                .ingot()
                .liquid(new FluidBuilder().temperature((int) (V[UV] + V[HV] * V[HV])))
                .plasma(new FluidBuilder().temperature((int) (V[UV] * V[HV])))
                .color(0x5DBD3A)
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(14960, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UIV]))
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
