package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.capability.impl.NotifiableItemStackHandler;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.Recipe;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockStructureCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class MetaTileEntityIndustrialDrillingRig extends RecipeMapMultiblockController {

    protected BlockPos targetBlock = null;

    public MetaTileEntityIndustrialDrillingRig(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.DRILLING_RECIPES);
        this.recipeMapWorkable = new IndustrialDrillWorkableHandler(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityIndustrialDrillingRig(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        if (this.targetBlock != null) {
            this.inputInventory.setStackInSlot(0, GTUtility.toItem(getWorld().getBlockState(targetBlock)));
        }
    }

    @Override
    public void invalidateStructure() {
        this.inputInventory.setStackInSlot(0, ItemStack.EMPTY);
        this.targetBlock = null;
        super.invalidateStructure();
    }

    @Override
    protected void initializeAbilities() {
        super.initializeAbilities();
        this.inputInventory = new NotifiableItemStackHandler(this, 1, this, false);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("       ", "XXXXXXX", "X     X", "X     X", "X     X", "X     X", "X     X", "XXXXXXX")
                .aisle("       ", "X     X", "       ", " F   F ", "       ", "       ", "       ", "X  F  X")
                .aisle("       ", "X     X", "   C   ", "  FCF  ", "   C   ", "  CVC  ", "  CVC  ", "X BBB X")
                .aisle("   R   ", "X  D  X", "  CGC  ", "  CGC  ", "  CGC  ", "  VGV  ", "  VGV  ", "XFBBBFX")
                .aisle("       ", "X     X", "   C   ", "  FCF  ", "   C   ", "  CSC  ", "  CVC  ", "X BBB X")
                .aisle("       ", "X     X", "       ", " F   F ", "       ", "       ", "       ", "X  F  X")
                .aisle("       ", "XXXXXXX", "X     X", "X     X", "X     X", "X     X", "X     X", "XXXXXXX")
                .where('S', this.selfPredicate())
                .where('X', states(getCasingState()))
                .where('F', states(getFrameState()))
                .where('C', states(getSecondCasingState()))
                .where('G', states(getTurbineCasingState()))
                .where('V', states(getThirdCasingState()))
                .where('B', states(getSecondCasingState())
                        .setMinGlobalLimited(4)
                        .or(autoAbilities(true, true, false, true, false, true, true)))
                .where('D', states(getFourthCasingState()))
                .where('R', blockPredicate())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.ATOMIC_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID);
    }

    private static IBlockState getThirdCasingState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING);
    }

    private static IBlockState getFourthCasingState() {
        return GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(magicbook.gtlitecore.common.blocks.BlockMultiblockCasing.MultiblockCasingType.DRILL_HEAD);
    }

    private static IBlockState getTurbineCasingState() {
        return GTLiteMetaBlocks.STRUCTURE_CASING.getState(BlockStructureCasing.StructureCasingType.NAQUADAH_GEARBOX_CASING);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(GCYMMaterials.HSLASteel).getBlock(GCYMMaterials.HSLASteel);
    }

    @Nonnull
    protected TraceabilityPredicate blockPredicate() {
        return new TraceabilityPredicate(blockWorldState -> {
            this.targetBlock = blockWorldState.getPos();
            if (this.isStructureFormed()) {
                this.inputInventory.setStackInSlot(0, GTUtility.toItem(getWorld().getBlockState(targetBlock)));
            }
            return true;
        });
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.INDUSTRIAL_DRILL_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.industrial_drilling_rig.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.industrial_drilling_rig.tooltip.2"));
    }

    @Override
    public boolean canBeDistinct() {
        return false;
    }

    protected static class IndustrialDrillWorkableHandler extends MultiblockRecipeLogic {

        public IndustrialDrillWorkableHandler(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        @Nonnull
        @Override
        public MetaTileEntityIndustrialDrillingRig getMetaTileEntity() {
            return (MetaTileEntityIndustrialDrillingRig) super.getMetaTileEntity();
        }

        @Override
        protected boolean setupAndConsumeRecipeInputs(@Nonnull Recipe recipe,
                                                      @Nonnull IItemHandlerModifiable importInventory) {
            boolean result = super.setupAndConsumeRecipeInputs(recipe, importInventory);

            //  Break the block in world if it is consumable
            if (result && !recipe.getInputs().get(0).isNonConsumable()) {
                MetaTileEntityIndustrialDrillingRig drill = getMetaTileEntity();
                if (drill != null) {
                    drill.getWorld().destroyBlock(drill.targetBlock, false);
                }
            }

            return result;
        }
    }
}
