package magicbook.gtlitecore.api.capability;

import gregtech.api.gui.resources.TextureArea;

public interface IQCComponentHatch {

    int getUpkeepEUt();

    default int getMaxEUt() {
        return this.getUpkeepEUt();
    }

    boolean canBeDamaged();

    default boolean isDamaged() {
        return false;
    }

    default void setDamaged(boolean damaged) {}

    boolean isBridge();

    TextureArea getComponentIcon();
}
