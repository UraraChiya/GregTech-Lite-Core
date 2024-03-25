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
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockActiveUniqueCasing;
import magicbook.gtlitecore.common.blocks.BlockMachineCasing;
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

public class MetaTileEntityHorizontalShaftImpactMacerator extends MultiMapMultiblockController {

    public MetaTileEntityHorizontalShaftImpactMacerator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                RecipeMaps.MACERATOR_RECIPES,
                RecipeMaps.FORGE_HAMMER_RECIPES});
        this.recipeMapWorkable = new HorizontalShaftImpactMaceratorRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityHorizontalShaftImpactMacerator(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(" CCCCCCC ", " CCCCCCC ", "FCCCCCCCF", "         ", "         ", "F       F")
                .aisle("FCCCCCCCF", "FCUUUUUCF", "FC     CF", "F       F", "F       F", "FFFFFFFFF")
                .aisle(" CCCCCCC ", " CUUUUUC ", "FC     CF", "         ", "         ", "F       F")
                .aisle(" CCCCCCC ", " CUUUUUC ", "FC     CF", "         ", "         ", "F       F")
                .aisle(" CCCCCCC ", " CUUUUUC ", "FC     CF", "         ", "         ", "F       F")
                .aisle("FCCCCCCCF", "FCUUUUUCF", "FC     CF", "F       F", "F       F", "FFFFFFFFF")
                .aisle(" CCCCCCC ", " CCCSCCC ", "FCCCCCCCF", "         ", "         ", "F       F")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(49)
                        .or(autoAbilities()))
                .where('U', states(getUniqueCasingState()))
                .where('F', states(getFrameState()))
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.LAURENIUM_CASING);
    }

    private static IBlockState getUniqueCasingState() {
        return GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getState(BlockActiveUniqueCasing.ActiveCasingType.ADVANCED_CRUSHING_WHEEL);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.Titanium).getBlock(Materials.Titanium);
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.LAURENIUM_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GCYMTextures.LARGE_MACERATOR_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.horizontal_shaft_impact_macerator.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.horizontal_shaft_impact_macerator.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.get_parallel_by_voltage"));
        tooltip.add(I18n.format("gtlitecore.machine.horizontal_shaft_impact_macerator.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.horizontal_shaft_impact_macerator.tooltip.4"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.max_parallel", 640));
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class HorizontalShaftImpactMaceratorRecipeLogic extends MultiblockRecipeLogic {

        public HorizontalShaftImpactMaceratorRecipeLogic(MetaTileEntityHorizontalShaftImpactMacerator tileEntity) {
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