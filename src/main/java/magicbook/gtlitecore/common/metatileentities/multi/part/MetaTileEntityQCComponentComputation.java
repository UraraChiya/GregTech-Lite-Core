package magicbook.gtlitecore.common.metatileentities.multi.part;

import gregtech.api.GTValues;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import magicbook.gtlitecore.api.capability.IQCComputationProvider;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import magicbook.gtlitecore.client.GTLiteTextures;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityQCComponentComputation extends MetaTileEntityQCComponent implements IQCComputationProvider {

    private final boolean advanced;

    public MetaTileEntityQCComponentComputation(ResourceLocation metaTileEntityId, boolean advanced) {
        super(metaTileEntityId);
        this.advanced = advanced;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityQCComponentComputation(metaTileEntityId, advanced);
    }

    @Override
    public boolean isAdvanced() {
        return this.advanced;
    }

    @Override
    public SimpleOverlayRenderer getFrontOverlay() {
        if (this.isDamaged()) {
            return this.advanced ? GTLiteTextures.QC_ADVANCED_DAMAGED_OVERLAY : GTLiteTextures.QC_DAMAGED_OVERLAY;
        } else {
            return this.advanced ? GTLiteTextures.QC_ADVANCED_COMPUTATION_COMPONENT_OVERLAY : GTLiteTextures.QC_COMPUTATION_COMPONENT_OVERLAY;
        }
    }

    @Override
    public TextureArea getComponentIcon() {
        if (this.isDamaged()) {
            return this.advanced ? GTLiteGuiTextures.QC_ICON_DAMAGED_ADVANCED_COMPUTATION_COMPONENT : GTLiteGuiTextures.QC_ICON_DAMAGED_COMPUTATION_COMPONENT;
        } else {
            return this.advanced ? GTLiteGuiTextures.QC_ICON_ADVANCED_COMPUTATION_COMPONENT : GTLiteGuiTextures.QC_ICON_COMPUTATION_COMPONENT;
        }
    }

    @Override
    public SimpleOverlayRenderer getFrontActiveOverlay() {
        if (this.isDamaged()) {
            return this.advanced ? GTLiteTextures.QC_ADVANCED_DAMAGED_ACTIVE_OVERLAY : GTLiteTextures.QC_DAMAGED_ACTIVE_OVERLAY;
        } else {
            return this.advanced ? GTLiteTextures.QC_ADVANCED_COMPUTATION_COMPONENT_ACTIVE_OVERLAY : GTLiteTextures.QC_COMPUTATION_COMPONENT_ACTIVE_OVERLAY;
        }
    }

    @Override
    public int getUpkeepEUt() {
        return GTValues.VA[this.advanced ? GTValues.LuV : GTValues.IV];
    }

    @Override
    public int getMaxEUt() {
        return GTValues.VA[this.advanced ? GTValues.UV : GTValues.ZPM];
    }

    @Override
    public boolean canBeDamaged() {
        return true;
    }

    @Override
    public int getCWUPerTick() {
        if (this.isDamaged()) {
            return 0;
        } else {
            return this.advanced ? 64 : 16;
        }
    }

    @Override
    public int getCoolingPerTick() {
        return this.advanced ? 8 : 4;
    }
}
