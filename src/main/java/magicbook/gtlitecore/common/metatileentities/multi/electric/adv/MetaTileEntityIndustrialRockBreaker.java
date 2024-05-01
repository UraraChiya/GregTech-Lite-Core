package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockStructureCasing;
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

public class MetaTileEntityIndustrialRockBreaker extends RecipeMapMultiblockController {

    public MetaTileEntityIndustrialRockBreaker(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.ROCK_BREAKER_RECIPES);
        this.recipeMapWorkable = new IndustrialRockBreakerRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityIndustrialRockBreaker(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(" F   F ", "FFCCCFF", " FCMCF ", "FFCCCFF", " F   F ")
                .aisle(" CCCCC ", "FC###CF", " C#P#C ", "FC###CF", " CCCCC ")
                .aisle(" CDDDC ", "FC###CF", " C#P#C ", "FC###CF", " CDDDC ")
                .aisle(" CDDDC ", "FC###CF", " C#P#C ", "FC###CF", " CDDDC ")
                .aisle(" CDDDC ", "FC###CF", " C#P#C ", "FC###CF", " CDDDC ")
                .aisle(" CCCCC ", "FC###CF", " C#P#C ", "FC###CF", " CCCCC ")
                .aisle(" F   F ", "FFCCCFF", " FCSCF ", "FFCCCFF", " F   F ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState()))
                .where('D', states(getCasingState())
                        .or(autoAbilities()))
                .where('P', states(getBoilerCasingState()))
                .where('F', states(getFrameState()))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('#', air())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.STRUCTURE_CASING.getState(BlockStructureCasing.StructureCasingType.RHODIUM_CASING);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(GCYMMaterials.HSLASteel).getBlock(GCYMMaterials.HSLASteel);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.RHODIUM_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.ROCK_BREAKER_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.get_parallel_by_voltage"));
        tooltip.add(I18n.format("gtlitecore.machine.industrial_rock_breaker.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.industrial_rock_breaker.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.max_parallel", 640));
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class IndustrialRockBreakerRecipeLogic extends MultiblockRecipeLogic {

        public IndustrialRockBreakerRecipeLogic(RecipeMapMultiblockController tileEntity) {
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
