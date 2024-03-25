package magicbook.gtlitecore.common.metatileentities.multi.part;

import gregtech.api.GTValues;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import magicbook.gtlitecore.api.capability.IQCCoolantProvider;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import magicbook.gtlitecore.client.GTLiteTextures;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityQCComponentCooler extends MetaTileEntityQCComponent implements IQCCoolantProvider {

    private final boolean advanced;

    public MetaTileEntityQCComponentCooler(ResourceLocation metaTileEntityId, boolean advanced) {
        super(metaTileEntityId);
        this.advanced = advanced;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityQCComponentCooler(metaTileEntityId, advanced);
    }

    @Override
    public boolean isAdvanced() {
        return this.advanced;
    }

    @Override
    public SimpleOverlayRenderer getFrontOverlay() {
        return this.advanced ? GTLiteTextures.QC_ACTIVE_COOLER_OVERLAY : GTLiteTextures.QC_HEAT_SINK_OVERLAY;
    }

    @Override
    public TextureArea getComponentIcon() {
        return this.advanced ? GTLiteGuiTextures.QC_ICON_ACTIVE_COOLER_COMPONENT : GTLiteGuiTextures.QC_ICON_HEAT_SINK_COMPONENT;
    }

    @Override
    public SimpleOverlayRenderer getFrontActiveOverlay() {
        return this.advanced ? GTLiteTextures.QC_ACTIVE_COOLER_ACTIVE_OVERLAY : this.getFrontOverlay();
    }

    @Override
    public int getUpkeepEUt() {
        return this.advanced ? GTValues.VA[GTValues.LuV] : 0;
    }

    @Override
    public boolean canBeDamaged() {
        return false;
    }

    @Override
    public int getCoolingAmount() {
        return this.advanced ? 32 : 16;
    }

    @Override
    public boolean isActiveCooler() {
        return this.advanced;
    }

    @Override
    public int getMaxCoolantPerTick() {
        return this.advanced ? 4 : 0;
    }
}
