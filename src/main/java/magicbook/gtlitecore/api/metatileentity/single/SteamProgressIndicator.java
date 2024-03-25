package magicbook.gtlitecore.api.metatileentity.single;

import gregtech.api.gui.resources.SteamTexture;
import gregtech.api.gui.widgets.ProgressWidget;

public class SteamProgressIndicator {

    public SteamTexture progressBarTexture;
    public ProgressWidget.MoveType progressMoveType;
    public int width, height;

    /**
     * @param progressBarTexture  Progress Bar textures of machine, you can use renderer in {@link magicbook.gtlitecore.api.gui.GTLiteGuiTextures} or {@link gregtech.api.gui.GuiTextures}.
     * @param progressMoveType    Move type of progress bar
     * @param width               Width of progress bar
     * @param height              Height of progress bar
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