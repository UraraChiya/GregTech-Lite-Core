package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockMultiblockCasing;
import magicbook.gtlitecore.common.blocks.BlockTransparentCasing;
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

import static gregtech.api.GTValues.EV;

public class MetaTileEntityIndustrialVacuumChamber extends RecipeMapMultiblockController {

    public MetaTileEntityIndustrialVacuumChamber(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES);
        this.recipeMapWorkable = new IndustrialVacuumChamberRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityIndustrialVacuumChamber(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(" CCC ", " CGC ", " CGC ", " CCC ")
                .aisle("CCCCC", "C###C", "C###C", "CDDDC")
                .aisle("CCCCC", "G#P#G", "G#P#G", "CDDDC")
                .aisle("CCCCC", "C###C", "C###C", "CDDDC")
                .aisle(" CSC ", " CGC ", " CGC ", " CCC ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(21)
                        .or(autoAbilities()))
                .where('D', states(getSecondCasingState()))
                .where('P', states(getBoilerCasingState()))
                .where('G', states(getGlassState()))
                .where('#', air())
                .where(' ', any())
                .build();
    }


    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.TALONITE_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE);
    }

    private static IBlockState getGlassState() {
        return GTLiteMetaBlocks.TRANSPARENT_CASING.getState(BlockTransparentCasing.TransparentCasingType.CBDO_POLYCARBONATE_GLASS);
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.TALONITE_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.LARGE_ROCKET_ENGINE_OVERLAY;
    }

    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.get_parallel_by_voltage"));
        tooltip.add(I18n.format("gtlitecore.machine.industrial_vacuum_chamber.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.industrial_vacuum_chamber.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.max_parallel", 640));
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class IndustrialVacuumChamberRecipeLogic extends MultiblockRecipeLogic {

        public IndustrialVacuumChamberRecipeLogic(MetaTileEntityIndustrialVacuumChamber tileEntity) {
            super(tileEntity);
        }

        private int ParallelTier(int tier) {
            if (tier - EV <= 0) {
                return 64;
            } else {
                return 64 * (tier - EV);
            }
        }

        /**
         * @return If machine's voltage less than or equal EV, then return 64 parallel.
         *         If machine's voltage greater than EV, then return (64 * (tier - 4)) parallel.
         *         Max Parallel: 640 (Max voltage).
         */
        @Override
        public int getParallelLimit() {
            int tier = GTUtility.getTierByVoltage(getMaxVoltage());
            return Math.min(ParallelTier(tier), 640);
        }
    }
}
