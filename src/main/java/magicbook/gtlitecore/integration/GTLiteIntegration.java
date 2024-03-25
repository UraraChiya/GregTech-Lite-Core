package magicbook.gtlitecore.integration;

import magicbook.gtlitecore.api.GTLiteValues;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import magicbook.gtlitecore.integration.theoneprobe.provider.RecipeFluidOutputInfoProvider;
import magicbook.gtlitecore.integration.theoneprobe.provider.RecipeItemOutputInfoProvider;
import mcjty.theoneprobe.TheOneProbe;
import mcjty.theoneprobe.api.ITheOneProbe;
import net.minecraftforge.fml.common.Loader;

public class GTLiteIntegration {

    public static void init() {
        //  The One Probe Integration
        if (Loader.isModLoaded(GTLiteValues.MODID_TOP)) {
            GTLiteLog.logger.info("Registering The One Probe Integration...");
            ITheOneProbe oneProbe = TheOneProbe.theOneProbeImp;
            oneProbe.registerProvider(new RecipeItemOutputInfoProvider());
            oneProbe.registerProvider(new RecipeFluidOutputInfoProvider());
        }
    }


    public GTLiteIntegration() {}
}
