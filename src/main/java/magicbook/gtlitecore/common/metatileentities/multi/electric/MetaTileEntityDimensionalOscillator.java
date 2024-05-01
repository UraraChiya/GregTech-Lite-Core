package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.utils.TooltipHelper;
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

public class MetaTileEntityDimensionalOscillator extends RecipeMapMultiblockController {

    public MetaTileEntityDimensionalOscillator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.DIMENSIONAL_OSCILLATOR_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityDimensionalOscillator(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("  DDDDD  ", " DDAAADD ", "DDA   ADD", "DA     AD", "DA     AD", "DA     AD", "DDA   ADD", " DDAAADD ", "  DDDDD  ")
                .aisle("  DGGGD  ", " EABBBAE ", "DABFFFBAD", "GBF   FBG", "GBF   FBG", "GBF   FBG", "DABFFFBAD", " EABBBAE ", "  DGGGD  ")
                .aisle("  DGGGD  ", " EABBBAE ", "DABCCCBAD", "GBC   CBG", "GBC   CBG", "GBC   CBG", "DABCCCBAD", " EABBBAE ", "  DGGGD  ")
                .aisle("  DGGGD  ", " EABBBAE ", "DABFFFBAD", "GBF   FBG", "GBF   FBG", "GBF   FBG", "DABFFFBAD", " EABBBAE ", "  DGGGD  ")
                .aisle("  DDDDD  ", " DDAAADD ", "DDA   ADD", "DA     AD", "DA     AD", "DA     AD", "DDA   ADD", " DDAAADD ", "  DDDDD  ")
                .aisle("    D    ", "    D    ", "         ", "         ", "DD     DD", "         ", "         ", "    D    ", "    D    ")
                .aisle("         ", "    D    ", "         ", "         ", " D     D ", "         ", "         ", "    D    ", "         ")
                .aisle("         ", "    D    ", "    D    ", "         ", " DD   DD ", "         ", "    D    ", "    D    ", "         ")
                .aisle("         ", "         ", "    D    ", "   F F   ", "  D   D  ", "   F F   ", "    D    ", "         ", "         ")
                .aisle("         ", "         ", "    D    ", "   DDD   ", "  DDBDD  ", "   DDD   ", "    D    ", "         ", "         ")
                .aisle("         ", "         ", "         ", "   EEE   ", "   E~E   ", "   EEE   ", "         ", "         ", "         ")
                .where('~', this.selfPredicate())
                .where('A', states(getThirdCasingState()))
                .where('B', states(getSecondCasingState()))
                .where('C', states(getCoilState()))
                .where('D', states(getCasingState()))
                .where('F', states(getFourthCasingState()))
                .where('E', states(getCasingState())
                        .setMinGlobalLimited(12)
                        .or(autoAbilities(false, false, false, false, true, true, false)))
                .where('G', states(getCasingState())
                        .setMinGlobalLimited(18)
                        .or(autoAbilities(true, true, true, true, false, false, false)))
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.ADVANCED_HIGH_ENERGY_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.HOLLOW_CASING);
    }

    private static IBlockState getThirdCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.DIMENSIONAL_BRIDGE_CASING);
    }

    private static IBlockState getFourthCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.SPACETIME_CASING);
    }

    private static IBlockState getCoilState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.MOLECULAR_COIL);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.ADVANCED_HIGH_ENERGY_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.DIMENSIONAL_OSCILLATOR_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.BLINKING_RED + I18n.format("gtlitecore.machine.dimensional_oscillator.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.dimensional_oscillator.tooltip.2"));
    }
}