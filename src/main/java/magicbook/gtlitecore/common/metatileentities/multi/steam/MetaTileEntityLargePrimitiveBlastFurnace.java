package magicbook.gtlitecore.common.metatileentities.multi.steam;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.*;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockFireboxCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.capability.impl.NoEnergyMultiblockRecipeLogic;
import magicbook.gtlitecore.api.metatileentity.multi.NoEnergyMultiblockController;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static gregtech.api.GTValues.ULV;
import static magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate.optionalStates;

/**
 * Large Primitive Blast Furnace
 *
 * @author Gate Guardian
 *
 * <p>
 *     This is a basic example of
 *      {@link magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate#optionalStates(String, IBlockState...)},
 *     this method create a upgrade system of multiblock.
 *     Thanks my friend Gate Guardian's work about it, I just do something unimportant.
 * </p>
 */
public class MetaTileEntityLargePrimitiveBlastFurnace extends NoEnergyMultiblockController {

    private byte auxiliaryFurnaceNumber = 0;
    private static final TraceabilityPredicate SNOW_LAYER = new TraceabilityPredicate(blockWorldState -> GTUtility.isBlockSnow(blockWorldState.getBlockState()));

    public MetaTileEntityLargePrimitiveBlastFurnace(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.PRIMITIVE_BLAST_FURNACE_RECIPES);
        this.recipeMapWorkable = new LargePrimitiveBlastFurnaceRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargePrimitiveBlastFurnace(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);

        if (context.get("AuxiliaryFurnace1") != null) {
            auxiliaryFurnaceNumber += 1;
        }

        if (context.get("AuxiliaryFurnace2") != null) {
            auxiliaryFurnaceNumber += 1;
        }
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        auxiliaryFurnaceNumber = 0;
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("     DDD     ", "             ", "             ", "             ", "             ", "             ", "             ", "             ", "             ")
                .aisle("    CDDDC    ", "    CDDDC    ", "    CDDDC    ", "     DDD     ", "             ", "             ", "             ", "             ", "             ")
                .aisle("AAAGDDDDDJFFF", "GGG D###D JJJ", " G  D###D  J ", " G  D###D  J ", " G   DDD   J ", " G    D    J ", "      D      ", "      D      ", "      D      ")
                .aisle("AAAGDDDDDJFFF", "GoGHD#o#DIJoJ", "G#G D###D J#J", "G#G D###D J#J", "G#G D###D J#J", "G#G  D#D  J#J", "     D#D     ", "     D#D     ", "     D#D     ")
                .aisle("AAAGDDDDDJFFF", "GGG D###D JJJ", " G  D###D  J ", " G  D###D  J ", " G   DDD   J ", " G    D    J ", "      D      ", "      D      ", "      D      ")
                .aisle("    CDDDC    ", "    CDSDC    ", "    CDDDC    ", "     DDD     ", "             ", "             ", "             ", "             ", "             ")
                .aisle("     DDD     ", "             ", "             ", "             ", "             ", "             ", "             ", "             ", "             ")
                .where('S', this.selfPredicate())
                .where('C', states(getFrameState()))
                .where('D', states(getCasingState())
                        .setMinGlobalLimited(69)
                        .or(autoAbilities(false, true, true, false, false, false)))
                .where('A', optionalStates("AuxiliaryFurnace1", getSecondCasingState()))
                .where('F', optionalStates("AuxiliaryFurnace2", getSecondCasingState()))
                .where('G', optionalStates("AuxiliaryFurnace1", getCasingState()))
                .where('H', optionalStates("AuxiliaryFurnace1", getBoilerCasingState()))
                .where('I', optionalStates("AuxiliaryFurnace2", getBoilerCasingState()))
                .where('J', optionalStates("AuxiliaryFurnace2", getCasingState()))
                .where('#', air())
                .where('o', air()
                        .or(SNOW_LAYER))
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.BOILER_FIREBOX_CASING.getState(BlockFireboxCasing.FireboxCasingType.STEEL_FIREBOX);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.Steel).getBlock(Materials.Steel);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.PRIMITIVE_BRICKS;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.PRIMITIVE_BLAST_FURNACE_OVERLAY;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        if (isStructureFormed()) {
            textList.add(new TextComponentTranslation("gtlitecore.machine.large_primitive_blast_furnace.auxiliary_furnace_number", auxiliaryFurnaceNumber));
        }
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.large_primitive_blast_furnace.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.large_primitive_blast_furnace.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.large_primitive_blast_furnace.tooltip.3"));
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle("     DDD     ", "             ", "             ", "             ", "             ", "             ", "             ", "             ", "             ")
                    .aisle("    CDDDC    ", "    CDDDC    ", "    CDDDC    ", "     DDD     ", "             ", "             ", "             ", "             ", "             ")
                    .aisle("AAAGDDDDDJFFF", "GGG D   D JJJ", " G  D   D  J ", " G  D   D  J ", " G   DDD   J ", " G    D    J ", "      D      ", "      D      ", "      D      ")
                    .aisle("AAAGDDDDDJFFF", "G GHD   DIJ J", "G G D   D J J", "G*G D   D J!J", "G G D   D J J", "G G  D D  J J", "     D D     ", "     D D     ", "     D D     ")
                    .aisle("AAAGDDDDDJFFF", "GGG D   D JJJ", " G  D   D  J ", " G  D   D  J ", " G   DDD   J ", " G    D    J ", "      D      ", "      D      ", "      D      ")
                    .aisle("    CDDDC    ", "    CXSYC    ", "    CDDDC    ", "     DDD     ", "             ", "             ", "             ", "             ", "             ")
                    .aisle("     DDD     ", "             ", "             ", "             ", "             ", "             ", "             ", "             ", "             ")
                    .where('S', GTLiteMetaTileEntities.LARGE_PRIMITIVE_BLAST_FURNACE, EnumFacing.SOUTH)
                    .where('C', getFrameState())
                    .where('D', getCasingState())
                    .where('X', MetaTileEntities.ITEM_IMPORT_BUS[ULV], EnumFacing.SOUTH)
                    .where('Y', MetaTileEntities.ITEM_EXPORT_BUS[ULV], EnumFacing.SOUTH)
                    .where(' ', Blocks.AIR.getDefaultState());
            shapeInfo.add(builder.build());
            shapeInfo.add(builder
                    .where('A', getSecondCasingState())
                    .where('G', getCasingState())
                    .where('H', getBoilerCasingState())
                    .build());
            shapeInfo.add(builder
                    .where('F', getSecondCasingState())
                    .where('I', getBoilerCasingState())
                    .where('J', getCasingState())
                    .build());
        }
        return shapeInfo;
    }

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }

    private class LargePrimitiveBlastFurnaceRecipeLogic extends NoEnergyMultiblockRecipeLogic {

        public LargePrimitiveBlastFurnaceRecipeLogic(NoEnergyMultiblockController tileEntity) {
            super(tileEntity, RecipeMaps.PRIMITIVE_BLAST_FURNACE_RECIPES);
        }

        /**
         * @param maxProgress Get reduction by auxiliaryFurnaceNumber, if auxiliary = 1, 2, then get 1/8, 1/16 progress time.
         */
        @Override
        public void setMaxProgress(int maxProgress) {
            if (isStructureFormed()) {
                if (auxiliaryFurnaceNumber == 1) {
                    this.maxProgressTime = maxProgress / 8;
                } else if (auxiliaryFurnaceNumber == 2) {
                    this.maxProgressTime = maxProgress / 16;
                } else {
                    this.maxProgressTime = maxProgress;
                }
            }
        }
    }
}