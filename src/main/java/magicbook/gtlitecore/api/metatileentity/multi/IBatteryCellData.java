package magicbook.gtlitecore.api.metatileentity.multi;

import javax.annotation.Nonnull;

public interface IBatteryCellData {

    int getTier();
    long getCapacity();
    @Nonnull String getBatteryName();
}
