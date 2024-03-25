package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.*;
import gregtech.api.recipes.Recipe;
import gregtech.api.util.BlockInfo;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityItemBus;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.api.recipe.properties.NoCoilTemperatureProperty;
import magicbook.gtlitecore.api.utils.GTLiteUtils;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockCrucible;
import magicbook.gtlitecore.common.blocks.BlockMultiblockCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static gregtech.api.GTValues.*;

public class MetaTileEntityNanoscaleFabricator extends RecipeMapMultiblockController {

    private int temperature;

    public MetaTileEntityNanoscaleFabricator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.MOLECULAR_BEAM_RECIPES);
        this.recipeMapWorkable = new NanoscaleFabricatorWorkableHandler(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityNanoscaleFabricator(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("   TTT   ", "   TIT   ", "   TCT   ", "         ")
                .aisle("  XXXXX  ", "  XX#XX  ", "  XXXXX  ", "  XXXXX  ")
                .aisle(" XXXXXXX ", " X#####X ", " X#####X ", " XXGGGXX ")
                .aisle("TXXTTTXXT", "TX#####XT", "TX#####XT", " XGGGGGX ")
                .aisle("TXXTITXXT", "I###A###I", "CX#####XC", " XGGGGGX ")
                .aisle("TXXTTTXXT", "TX#####XT", "TX#####XT", " XGGGGGX ")
                .aisle(" XXXXXXX ", " X#####X ", " X#####X ", " XXGGGXX ")
                .aisle("  XXXXX  ", "  XX#XX  ", "  XXXXX  ", "  XXSXX  ")
                .aisle("   TTT   ", "   TIT   ", "   TCT   ", "         ")
                .where('S', this.selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(84)
                        .or(autoAbilities(true, true, false, true, true, false, false)))
                .where('T', states(getSecondCasingState())
                        .setMinGlobalLimited(36))
                .where('G', states(getGlassState()))
                .where('I', metaTileEntities(MetaTileEntities.ITEM_IMPORT_BUS[ULV])
                        .or(states(getSecondCasingState())))
                .where('C', states(getSecondCasingState())
                        .or(cruciblePredicate()))
                .where('A', states(getThirdCasingState()))
                .where('#', air())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.ENGRAVER_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.NONCONDUCTING_CASING);
    }

    private static IBlockState getThirdCasingState() {
        return GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.ADVANCED_SUBSTRATE_CASING);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.LAMINATED_GLASS);
    }

    @Nonnull
    private TraceabilityPredicate cruciblePredicate() {
        return new TraceabilityPredicate(blockWorldState -> {
            IBlockState state = blockWorldState.getBlockState();
            Block block = state.getBlock();
            if (block instanceof BlockCrucible) {
                int storedTemperature = blockWorldState.getMatchContext().getOrPut("Temperature", 0);
                blockWorldState.getMatchContext().set("Temperature", ((BlockCrucible) block).getState(state).getTemperature() + storedTemperature);

                int storedCrucibleAmount = blockWorldState.getMatchContext().getOrPut("CrucibleAmount", 0);
                blockWorldState.getMatchContext().set("CrucibleAmount", 1 + storedCrucibleAmount);
                return true;
            }
            return false;
        }, () -> Arrays.stream(BlockCrucible.CrucibleType.values())
                .sorted(Comparator.comparingInt(BlockCrucible.CrucibleType::getTemperature))
                .map(type -> new BlockInfo(GTLiteMetaBlocks.CRUCIBLE.getState(type), null))
                .toArray(BlockInfo[]::new));
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        int crucibleAmount = context.getInt("CrucibleAmount");
        if (crucibleAmount != 0) this.temperature = context.getInt("Temperature") / crucibleAmount;
        else this.temperature = 0;
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.temperature = 0;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        if (iMultiblockPart instanceof MetaTileEntityItemBus && ((MetaTileEntityItemBus) iMultiblockPart).getExportItems().getSlots() == 0) {
            return GCYMTextures.NONCONDUCTING_CASING;
        }

        return GCYMTextures.ENGRAVER_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.NANOSCALE_FABRICATOR_OVERLAY;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if (isStructureFormed()) {
            textList.add(new TextComponentTranslation("gregtech.multiblock.blast_furnace.max_temperature",
                    TextFormatting.RED + GTLiteUtils.formatNumbers(temperature) + "K"));
        }
        super.addDisplayText(textList);
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle("   TTT   ", "   TPT   ", "   TCT   ", "         ")
                    .aisle("  XXXXX  ", "  XX#XX  ", "  XXXXX  ", "  XXXXX  ")
                    .aisle(" XXXXXXX ", " X     X ", " X     X ", " XXGGGXX ")
                    .aisle("TXXTTTXXT", "TX     XT", "TX     XT", " XGGGGGX ")
                    .aisle("TXXTATXXT", "N   J   U", "CX     XC", " XGGGGGX ")
                    .aisle("TXXTTTXXT", "TX     XT", "TX     XT", " XGGGGGX ")
                    .aisle(" XXXXXXX ", " X     X ", " X     X ", " XXGGGXX ")
                    .aisle("  XXXXX  ", "  FX XO  ", "  XXXXX  ", "  XMSEX  ")
                    .aisle("   TTT   ", "   TIT   ", "   TCT   ", "         ")
                    .where('S', GTLiteMetaTileEntities.NANOSCALE_FABRICATOR, EnumFacing.SOUTH)
                    .where('X', getCasingState())
                    .where('T', getSecondCasingState())
                    .where('G', getGlassState())
                    .where('J', getThirdCasingState())
                    .where('I', MetaTileEntities.ITEM_IMPORT_BUS[ULV], EnumFacing.SOUTH)
                    .where('N', MetaTileEntities.ITEM_IMPORT_BUS[ULV], EnumFacing.WEST)
                    .where('P', MetaTileEntities.ITEM_IMPORT_BUS[ULV], EnumFacing.NORTH)
                    .where('U', MetaTileEntities.ITEM_IMPORT_BUS[ULV], EnumFacing.EAST)
                    .where('A', MetaTileEntities.ITEM_IMPORT_BUS[ULV], EnumFacing.DOWN)
                    .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[UV], EnumFacing.SOUTH)
                    .where('F', MetaTileEntities.FLUID_IMPORT_HATCH[HV], EnumFacing.SOUTH)
                    .where('O', MetaTileEntities.ITEM_EXPORT_BUS[HV], EnumFacing.SOUTH)
                    .where(' ', Blocks.AIR.getDefaultState())
                    .where('M', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : getCasingState(), EnumFacing.SOUTH);
        }

        for (BlockCrucible.CrucibleType crucibleType : BlockCrucible.CrucibleType.values()) {
            shapeInfos.add(builder.where('C', GTLiteMetaBlocks.CRUCIBLE.getState(crucibleType)).build());
        }

        return shapeInfos;
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class NanoscaleFabricatorWorkableHandler extends MultiblockRecipeLogic {

        public NanoscaleFabricatorWorkableHandler(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        @Override
        public boolean checkRecipe(@Nonnull Recipe recipe) {
            int delta = temperature - recipe.getProperty(NoCoilTemperatureProperty.getInstance(), 0);
            return (delta > 0 && delta < 250);
        }
    }
}