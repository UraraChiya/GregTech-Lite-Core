package magicbook.gtlitecore.common;

import gregtech.api.unification.material.event.MaterialEvent;
import magicbook.gtlitecore.api.GTLiteValues;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.api.unification.OrePrefixAddition;
import magicbook.gtlitecore.api.unification.materials.GTLiteMaterialPropertyAddition;
import magicbook.gtlitecore.common.items.GTLiteTools;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = GTLiteValues.MODID)
public class GTLiteEventHandler {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterials(MaterialEvent event) {
        GTLiteMaterials.init();
        OrePrefixAddition.init();
        GTLiteMaterialPropertyAddition.init();
        GTLiteTools.init();
    }
}
