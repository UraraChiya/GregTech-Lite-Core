package magicbook.gtlitecore.common.metatileentities.multi.part;

import gregtech.api.GTValues;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityQCComponentBridge extends MetaTileEntityQCComponent {

    public MetaTileEntityQCComponentBridge(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityQCComponentBridge(metaTileEntityId);
    }

    @Override
    public boolean isAdvanced() {
        return true;
    }

    @Override
    public boolean doesAllowBridging() {
        return true;
    }

    @Override
    public SimpleOverlayRenderer getFrontOverlay() {
        return GTLiteTextures.QC_BRIDGE_OVERLAY;
    }

    @Override
    public TextureArea getComponentIcon() {
        return GTLiteGuiTextures.QC_ICON_BRIDGE_COMPONENT;
    }

    @Override
    public SimpleOverlayRenderer getFrontActiveOverlay() {
        return GTLiteTextures.QC_BRIDGE_ACTIVE_OVERLAY;
    }

    @Override
    public int getUpkeepEUt() {
        return GTValues.VA[GTValues.LuV];
    }

    @Override
    public boolean canBeDamaged() {
        return false;
    }
}
