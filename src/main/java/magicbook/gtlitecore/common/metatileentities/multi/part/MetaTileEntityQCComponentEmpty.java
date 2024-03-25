package magicbook.gtlitecore.common.metatileentities.multi.part;

import gregtech.api.gui.resources.TextureArea;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import magicbook.gtlitecore.client.GTLiteTextures;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityQCComponentEmpty extends MetaTileEntityQCComponent {

    public MetaTileEntityQCComponentEmpty(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityQCComponentEmpty(metaTileEntityId);
    }

    @Override
    public boolean isAdvanced() {
        return false;
    }

    @Override
    public SimpleOverlayRenderer getFrontOverlay() {
        return GTLiteTextures.QC_EMPTY_COMPONENT_OVERLAY;
    }

    @Override
    public TextureArea getComponentIcon() {
        return GTLiteGuiTextures.QC_ICON_EMPTY_COMPONENT;
    }

    @Override
    public int getUpkeepEUt() {
        return 0;
    }

    @Override
    public boolean canBeDamaged() {
        return false;
    }
}
