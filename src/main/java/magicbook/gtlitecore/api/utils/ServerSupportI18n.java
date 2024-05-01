package magicbook.gtlitecore.api.utils;

import magicbook.gtlitecore.common.CommonProxy;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Server side Support I18n
 *
 * @author vfyjxf
 *
 * <p>
 *     Thanks vfyjxf create this class and help me to learn it.
 * </p>
 */
public class ServerSupportI18n {

    /**
     * Format with Client and Server two names.
     *
     * <p>
     *     Please use it for {@code RecipeProperty} init (because it needs on server side),
     *     this step is in {@link CommonProxy#registerRecipes(RegistryEvent.Register)}.
     *     otherwise init maybe cause server-side crash because server side can not cast {@link I18n} class.
     * </p>.
     *
     * @param clientName  Client side localized name.
     * @param serverName  Server name (use english).
     * @return            Same as same name method in {@link I18n}, but this method is server supported.
     */
    public static String format(String clientName, String serverName) {
        return FMLLaunchHandler.side() == Side.CLIENT ? clientHelper(clientName) : serverName;
    }

    /**
     * Client name helper.
     *
     * @param clientName  Client side localized name, i.e. {@code I18n.format(clientName)}.
     * @return            Return a client name by {@code format()} in {@link I18n}.
     */
    public static String clientHelper(String clientName) {
        return I18n.format(clientName);
    }
}
