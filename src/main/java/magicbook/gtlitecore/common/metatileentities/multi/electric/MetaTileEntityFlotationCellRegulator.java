package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
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
import magicbook.gtlitecore.common.blocks.BlockBoilerCasing;
import magicbook.gtlitecore.common.blocks.BlockMultiblockCasing;
import magicbook.gtlitecore.common.blocks.BlockUniqueCasing;
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

public class MetaTileEntityFlotationCellRegulator extends RecipeMapMultiblockController {

    public MetaTileEntityFlotationCellRegulator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.FLOTATION_RECIPES);
        this.recipeMapWorkable = new MultiblockRecipeLogic(this, true);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityFlotationCellRegulator(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("  CCC  ", " CCCCC ", "CCCCCCC", "CCCCCCC", "CCCCCCC", " CCCCC ", "  CCC  ")
                .aisle("  CCC  ", " CCGCC ", "CCGGGCC", "CGGGGGC", "CCGGGCC", " CCGCC ", "  CCC  ")
                .aisle("       ", "   T   ", "  T T  ", " T P T ", "  T T  ", "   T   ", "       ")
                .aisle("       ", "   T   ", "  T T  ", " T P T ", "  T T  ", "   T   ", "       ")
                .aisle("       ", "   T   ", "  T T  ", " T P T ", "  T T  ", "   T   ", "       ")
                .aisle("       ", "   T   ", "  T T  ", " T P T ", "  T T  ", "   T   ", "       ")
                .aisle("       ", "   T   ", "  T T  ", " T P T ", "  T T  ", "   T   ", "       ")
                .aisle("       ", "   T   ", "  T T  ", " T P T ", "  T T  ", "   T   ", "       ")
                .aisle("       ", "       ", "   E   ", "  ESE  ", "   E   ", "       ", "       ")
                .where('S', this.selfPredicate())
                .where('E', states(getCasingState()))
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(55)
                        .or(autoAbilities()))
                .where('T', states(getUniqueCasingState()))
                .where('P', states(getBoilerCasingState()))
                .where('G', states(getSecondCasingState()))
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.HASTELLOY_N_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.HASTELLOY_N_GEARBOX_CASING);
    }

    private static IBlockState getBoilerCasingState() {
        return GTLiteMetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.HASTELLOY_N);
    }

    private static IBlockState getUniqueCasingState() {
        return GTLiteMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.FLOTATION_CELL);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.HASTELLOY_N_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.BURNER_REACTOR_OVERLAY;
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }
}
