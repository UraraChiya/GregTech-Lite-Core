package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

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
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockCleanroomCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtechfoodoption.block.GTFOGlassCasing;
import gregtechfoodoption.block.GTFOMetaBlocks;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
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

public class MetaTileEntityIndustrialBioReactor extends MultiMapMultiblockController {

    public MetaTileEntityIndustrialBioReactor(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                RecipeMaps.FERMENTING_RECIPES,
                RecipeMaps.BREWING_RECIPES,
                GTLiteRecipeMaps.BIO_REACTOR_RECIPES
        });
        this.recipeMapWorkable = new IndustrialBioReactorRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityIndustrialBioReactor(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCCCC", "CCCCCCC", "CCCCCCC", "CCCCCCC", "       ")
                .aisle("CEEEEEC", "D#####D", "D#####D", "C#####C", "CCCCCCC")
                .aisle("CEEEEEC", "D#####D", "D#####D", "C#####C", "CCCCCCC")
                .aisle("CEEEEEC", "D#####D", "D#####D", "C#####C", "CCCCCCC")
                .aisle("CCCSCCC", "CGGGGGC", "CGGGGGC", "CCCCCCC", "       ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(50)
                        .or(autoAbilities()))
                .where('D', states(getSecondCasingState()))
                .where('E', states(getThirdCasingState()))
                .where('G', states(getGlassState()))
                .where('#', air())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.STRUCTURE_CASING.getState(BlockStructureCasing.StructureCasingType.DURALUMINIUM_ALLOY_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING);
    }

    private static IBlockState getThirdCasingState() {
        return MetaBlocks.CLEANROOM_CASING.getState(BlockCleanroomCasing.CasingType.PLASCRETE);
    }

    private static IBlockState getGlassState() {
        return GTFOMetaBlocks.GTFO_GLASS_CASING.getState(GTFOGlassCasing.CasingType.GREENHOUSE_GLASS);
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.DURALUMINIUM_ALLOY_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.LARGE_BIO_REACTOR_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.get_parallel_by_voltage"));
        tooltip.add(I18n.format("gtlitecore.machine.industrial_bio_reactor.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.industrial_bio_reactor.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.max_parallel", 640));
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class IndustrialBioReactorRecipeLogic extends MultiblockRecipeLogic {

        public IndustrialBioReactorRecipeLogic(MetaTileEntityIndustrialBioReactor tileEntity) {
            super(tileEntity, true);
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
