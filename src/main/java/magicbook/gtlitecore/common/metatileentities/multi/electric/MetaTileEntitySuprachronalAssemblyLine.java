package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockScienceCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class MetaTileEntitySuprachronalAssemblyLine extends RecipeMapMultiblockController {

    public MetaTileEntitySuprachronalAssemblyLine(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.SUPRACHRONAL_ASSEMBLY_LINE_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntitySuprachronalAssemblyLine(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("  XXXXDDDXXXX  ", "      DDD      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "      DDD      ", "  XXXXDDDXXXX  ")
                .aisle(" XXXXXXXXXXXXX ", "       X       ", "       Y       ", "       Z       ", "       Y       ", "       Z       ", "       Y       ", "       Z       ", "       Y       ", "       Z       ", "       Y       ", "       Z       ", "       Y       ", "       X       ", " XXXXXXXXXXXXX ")
                .aisle("XXXXXXXXXXXXXXX", "       X       ", "       Y       ", "       X       ", "       X       ", "      WXW      ", "     XXXXX     ", "     WXXXW     ", "     XXXXX     ", "      WXW      ", "       X       ", "       X       ", "       Y       ", "       X       ", "XXXXXXXXXXXXXXX")
                .aisle("XXXXXXXXXXXXXXX", "       X       ", "       X       ", "       X       ", "     XXXXX     ", "    YWAAAWY    ", "    XAAAAAX    ", "    YAAAAAY    ", "    XAAAAAX    ", "    YWAAAWY    ", "     XXXXX     ", "       X       ", "       X       ", "       X       ", "XXXXXXXXXXXXXXX")
                .aisle("XXXXXXXXXXXXXXX", "       X       ", "       X       ", "     XXXXX     ", "    XAAAAAX    ", "   YAAAAAAAY   ", "   XAAAAAAAX   ", "   YAAAAAAAY   ", "   XAAAAAAAX   ", "   YAAAAAAAY   ", "    XAAAAAX    ", "     XXXXX     ", "       X       ", "       X       ", "XXXXXXXXXXXXXXX")
                .aisle("XXXXXXXXXXXXXXX", "       X       ", "      XXX      ", "    XXAAAXX    ", "   XAAAAAAAX   ", "   WAAAAAAAW   ", "  XAAAAAAAAAX  ", "  WAAAAAAAAAW  ", "  XAAAAAAAAAX  ", "   WAAAAAAAW   ", "   XAAAAAAAX   ", "    XXAAAXX    ", "      XXX      ", "       X       ", "XXXXXXXXXXXXXXX")
                .aisle("DXXXXXXXXXXXXXD", "D     YXY     D", "     XXWXX     ", "    XAAAAAX    ", "   XAAAAAAAX   ", "  WAAAAAAAAAW  ", "  XAAAAAAAAAX  ", "  WAAAAAAAAAW  ", "  XAAAAAAAAAX  ", "  WAAAAAAAAAW  ", "   XAAAAAAAX   ", "    XAAAAAX    ", "     XXWXX     ", "D     YXY     D", "DXXXXXXXXXXXXXD")
                .aisle("DXXXXXXoXXXXXXD", "DXXXXXXoXXXXXXD", " YYXXXWoWXXXYY ", " ZXXXAAoAAXXXZ ", " YXXAAAoAAAXXY ", " ZXAAAAoAAAAXZ ", " YXAAAAoAAAAXY ", " ZXAAAAoAAAAXZ ", " YXAAAAoAAAAXY ", " ZXAAAAoAAAAXZ ", " YXXAAAoAAAXXY ", " ZXXXAAoAAXXXZ ", " YYXXXWoWXXXYY ", "DXXXXXXWXXXXXXD", "DXXXXXXOXXXXXXD")
                .aisle("DXXXXXXXXXXXXXD", "D     YXY     D", "     XXWXX     ", "    XAAAAAX    ", "   XAAAAAAAX   ", "  WAAAAAAAAAW  ", "  XAAAAAAAAAX  ", "  WAAAAAAAAAW  ", "  XAAAAAAAAAX  ", "  WAAAAAAAAAW  ", "   XAAAAAAAX   ", "    XAAAAAX    ", "     XXWXX     ", "D     YXY     D", "DXXXXXXXXXXXXXD")
                .aisle("XXXXXXXXXXXXXXX", "       X       ", "      XXX      ", "    XXAAAXX    ", "   XAAAAAAAX   ", "   WAAAAAAAW   ", "  XAAAAAAAAAX  ", "  WAAAAAAAAAW  ", "  XAAAAAAAAAX  ", "   WAAAAAAAW   ", "   XAAAAAAAX   ", "    XXAAAXX    ", "      XXX      ", "       X       ", "XXXXXXXXXXXXXXX")
                .aisle("XXXXXXXXXXXXXXX", "       X       ", "       X       ", "     XXXXX     ", "    XAAAAAX    ", "   YAAAAAAAY   ", "   XAAAAAAAX   ", "   YAAAAAAAY   ", "   XAAAAAAAX   ", "   YAAAAAAAY   ", "    XAAAAAX    ", "     XXXXX     ", "       X       ", "       X       ", "XXXXXXXXXXXXXXX")
                .aisle("XXXXXXXXXXXXXXX", "       X       ", "       X       ", "       X       ", "     XXXXX     ", "    YWAAAWY    ", "    XAAAAAX    ", "    YAAAAAY    ", "    XAAAAAX    ", "    YWAAAWY    ", "     XXXXX     ", "       X       ", "       X       ", "       X       ", "XXXXXXXXXXXXXXX")
                .aisle("XXXXXXXXXXXXXXX", "       X       ", "       Y       ", "       X       ", "       X       ", "      WXW      ", "     XXXXX     ", "     WXXXW     ", "     XXXXX     ", "      WXW      ", "       X       ", "       X       ", "       Y       ", "       X       ", "XXXXXXXXXXXXXXX")
                .aisle(" XXXXXXXXXXXXX ", "       X       ", "       Y       ", "       Z       ", "       Y       ", "       Z       ", "       Y       ", "       Z       ", "       Y       ", "       Z       ", "       Y       ", "       Z       ", "       Y       ", "       X       ", " XXXXXXXXXXXXX ")
                .aisle("  XXXXDDDXXXX  ", "      DSD      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "      DDD      ", "  XXXXDDDXXXX  ")
                .where('S', selfPredicate())
                .where('X', states(getCasingState()))
                .where('Y', states(getSecondCasingState()))
                .where('Z', states(getThirdCasingState()))
                .where('W', states(getCoilState()))
                .where('o', states(getFourthCasingState()))
                .where('D', states(getCasingState())
                        .or(autoAbilities(true, true, true, true, true, false, false)))
                .where('O', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('A', air())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.ULTIMATE_HIGH_ENERGY_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.DIMENSIONAL_BRIDGE_CASING);
    }

    private static IBlockState getThirdCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.SPACETIME_CASING);
    }

    private static IBlockState getFourthCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.HOLLOW_CASING);
    }

    private static IBlockState getCoilState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.MOLECULAR_COIL);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.ULTIMATE_HIGH_ENERGY_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.SUPRACHRONAL_ASSEMBLY_LINE_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.suprachronal_assembly_line.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.suprachronal_assembly_line.tooltip.2"));
    }
}
