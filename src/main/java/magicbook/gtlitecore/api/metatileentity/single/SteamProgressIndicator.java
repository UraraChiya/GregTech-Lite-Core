package magicbook.gtlitecore.api.metatileentity.single;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.resources.SteamTexture;
import gregtech.api.gui.widgets.ProgressWidget;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;

/**
 * Steam Progress Bar Indicator
 *
 * @since 2.7.4-beta
 */
public class SteamProgressIndicator {

    public SteamTexture progressBarTexture;
    public ProgressWidget.MoveType progressMoveType;
    public int width, height;

    /**
     * @param progressBarTexture  Progress Bar textures of machine, you can use renderer in {@link GTLiteGuiTextures} or {@link GuiTextures},
     *                            or another {@code Texture} class in other addition mods.
     * @param progressMoveType    Move type of progress bar.
     * @param width               Width of progress bar.
     * @param height              Height of progress bar.
     */
    public SteamProgressIndicator(SteamTexture progressBarTexture,
                                  ProgressWidget.MoveType progressMoveType,
                                  int width,
                                  int height) {
        this.progressBarTexture = progressBarTexture;
        this.progressMoveType = progressMoveType;
        this.width = width;
        this.height = height;
    }
}