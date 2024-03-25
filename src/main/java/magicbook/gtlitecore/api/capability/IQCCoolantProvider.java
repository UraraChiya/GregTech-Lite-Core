package magicbook.gtlitecore.api.capability;

public interface IQCCoolantProvider extends IQCComponentHatch {

    int getCoolingAmount();

    boolean isActiveCooler();

    default int getMaxCoolantPerTick() {
        return 0;
    }
}
