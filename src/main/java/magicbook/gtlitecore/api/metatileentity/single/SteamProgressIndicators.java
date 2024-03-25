package magicbook.gtlitecore.api.metatileentity.single;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;

/**
 * Steam Progress Indicators.
 *
 * <p>
 *     This class has same efficiency as {@link GuiTextures}, but has compatibility with Steam machines.
 *     Please see {@link SteamProgressIndicator}, those class init basic function of Indicator.
 * </p>
 */
public class SteamProgressIndicators {
    public static final SteamProgressIndicator COMPRESS = new SteamProgressIndicator(GuiTextures.PROGRESS_BAR_COMPRESS_STEAM, ProgressWidget.MoveType.HORIZONTAL, 20, 15);
}