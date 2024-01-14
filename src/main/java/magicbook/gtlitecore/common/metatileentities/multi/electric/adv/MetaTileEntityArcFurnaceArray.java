package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
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
import magicbook.gtlitecore.client.GTLiteTextures;
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

//  TODO Plasma Arc Furnace mode...
public class MetaTileEntityArcFurnaceArray extends RecipeMapMultiblockController {

    public MetaTileEntityArcFurnaceArray(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.ARC_FURNACE_RECIPES);
        this.recipeMapWorkable = new ArcFurnaceArrayRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityArcFurnaceArray(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(" CCC ", " CMC ", " CCC ")
                .aisle("CCCCC", "CX#XC", " CVC ")
                .aisle("CCCCC", "CX#XC", " CVC ")
                .aisle("CCCCC", "CX#XC", " CVC ")
                .aisle(" CCC ", " CSC ", " CCC ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(16)
                        .or(autoAbilities()))
                .where('X', states(getCoilState()))
                .where('V', states(getUniqueCasingState()))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where(' ', any())
                .where('#', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.BOTMIUM_CASING);
    }

    private static IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    private static IBlockState getCoilState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.MOLYBDENUM_DISILICIDE_COIL);
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.BOTMIUM_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.ARC_FURNACE_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.arc_furnace_array.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.arc_furnace_array.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.arc_furnace_array.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.arc_furnace_array.tooltip.4"));
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class ArcFurnaceArrayRecipeLogic extends MultiblockRecipeLogic {

        public ArcFurnaceArrayRecipeLogic(MetaTileEntityArcFurnaceArray tileEntity) {
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
         * @return Parallel = 64 * (tier - EV), i.e. IV 64, LuV 128, ZPM, 256, UV, 512, UHV, 1024,...
         * Max Parallel: 4096
         */
        @Override
        public int getParallelLimit() {
            int tier = GTUtility.getTierByVoltage(getMaxVoltage());
            return Math.min(ParallelTier(tier), 4096);
        }
    }
}
