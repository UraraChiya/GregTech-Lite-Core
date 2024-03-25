package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregicality.multiblocks.api.render.GCYMTextures;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.BlockTurbineCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtechfoodoption.recipe.GTFORecipeMaps;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockActiveUniqueCasing;
import magicbook.gtlitecore.common.blocks.BlockBoilerCasing;
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

public class MetaTileEntityLargeTurrentLathingFactory extends MultiMapMultiblockController {

    public MetaTileEntityLargeTurrentLathingFactory(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                RecipeMaps.LATHE_RECIPES,
                RecipeMaps.CUTTER_RECIPES,
                GTFORecipeMaps.SLICER_RECIPES});
        this.recipeMapWorkable = new TurrentLathingFactoryRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargeTurrentLathingFactory(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXXXX", " P P ", " P P ", " P P ", "XXXXX")
                .aisle("XXXXX", "PCGCP", "PCGCP", "PCGCP", "XXXXX")
                .aisle("XXXXX", " pUp ", " psp ", " pUp ", "XGGGX")
                .aisle("XXXXX", " pcp ", " F F ", " pcp ", "XGGGX")
                .aisle("XXXXX", " pcp ", " F F ", " pcp ", "XGGGX")
                .aisle("XXXXX", " pUp ", " psp ", " pUp ", "XGGGX")
                .aisle("XXXXX", "PCGCP", "PCGCP", "PCGCP", "XXXXX")
                .aisle("XXSXX", " P P ", " P P ", " P P ", "XXXXX")
                .where('S', this.selfPredicate())
                .where('X', states(getCasingState())
                        .or(autoAbilities()))
                .where('C', states(getCasingState()))
                .where('P', states(getBoilerCasingState()))
                .where('p', states(getSecondBoilerCasingState()))
                .where('F', states(getGlassState()))
                .where('G', states(getSecondCasingState()))
                .where('c', states(getUniqueCasingState()))
                .where('U', states(getThirdCasingState()))
                .where('s', states(getThirdBoilerCasingState()))
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.STRUCTURE_CASING.getState(BlockStructureCasing.StructureCasingType.TANTALUM_CARBIDE_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING);
    }

    private static IBlockState getThirdCasingState() {
        return MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_GEARBOX);
    }

    private static IBlockState getBoilerCasingState() {
        return GTLiteMetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYBENZIMIDAZOLE);
    }

    private static IBlockState getSecondBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(gregtech.common.blocks.BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE);
    }

    private static IBlockState getThirdBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(gregtech.common.blocks.BlockBoilerCasing.BoilerCasingType.STEEL_PIPE);
    }

    private static IBlockState getUniqueCasingState() {
        return GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getState(BlockActiveUniqueCasing.ActiveCasingType.ADVANCED_SLICING_BLADE);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS);
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.TANTALUM_CARBIDE_CASING;
    }
    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GCYMTextures.LARGE_CUTTER_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.large_turrent_lathing_factory.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.get_parallel_by_voltage"));
        tooltip.add(I18n.format("gtlitecore.machine.large_turrent_lathing_factory.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.large_turrent_lathing_factory.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.max_parallel", 640));
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class TurrentLathingFactoryRecipeLogic extends MultiblockRecipeLogic {

        public TurrentLathingFactoryRecipeLogic(MetaTileEntityLargeTurrentLathingFactory tileEntity) {
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

        /**
         * @param maxProgress Get 1/2 progress time.
         */
        @Override
        public void setMaxProgress(int maxProgress) {
            this.maxProgressTime = maxProgress / 2;
        }
    }
}
