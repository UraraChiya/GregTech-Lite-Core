package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.ConfigHolder;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.api.recipe.properties.FieldCasingTierProperty;
import magicbook.gtlitecore.api.utils.GTLiteUtils;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockScienceCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static gregtech.api.GTValues.ZPM;

public class MetaTileEntityDecayGenerator extends RecipeMapMultiblockController {

    private int casingTier;

    public MetaTileEntityDecayGenerator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.DECAY_GENERATOR_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityDecayGenerator(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("FieldCasingTieredStats");
        this.casingTier = GTLiteUtils.getOrDefault(() -> type instanceof WrappedIntTier,
                () -> ((WrappedIntTier) type).getIntTier(), 0);
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.casingTier = 0;
    }

    @Override
    public boolean checkRecipe(@Nonnull Recipe recipe,
                               boolean consumeIfSuccess) {
        return super.checkRecipe(recipe, consumeIfSuccess) && recipe.getProperty(FieldCasingTierProperty.getInstance(), 0) <= casingTier;
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("A   A", " FFF ", " FFF ", " FFF ", "A   A")
                .aisle("AAAAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA")
                .aisle("A   A", " EEE ", " EAE ", " EEE ", "A   A")
                .aisle("ABBBA", "BDDDB", "BDDDB", "BDDDB", "ABBBA")
                .aisle("ABCBA", "BDDDB", "CDDDC", "BDDDB", "ABCBA")
                .aisle("ABBBA", "BDDDB", "BDDDB", "BDDDB", "ABBBA")
                .aisle("A   A", " EEE ", " EAE ", " EEE ", "A   A")
                .aisle("AAAAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA")
                .aisle("A   A", " FFF ", " F~F ", " FFF ", "A   A")
                .where('~', this.selfPredicate())
                .where('A', states(getCasingState()))
                .where('B', states(getSecondCasingState()))
                .where('C', GTLiteTraceabilityPredicate.FIELD_CASING.get())
                .where('D', states(getThirdCasingState()))
                .where('F', states(getCasingState())
                        .or(autoAbilities()))
                .where('E', states(getCasingState()))
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.ADVANCED_HIGH_ENERGY_CASING);
    }

    private static IBlockState getThirdCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.HOLLOW_CASING);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.HIGH_ENERGY_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.DECAY_GENERATOR_OVERLAY;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("A   A", " FVF ", " FUF ", " FVF ", "A   A")
                .aisle("AAAAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA")
                .aisle("A   A", " EEE ", " EAE ", " EEE ", "A   A")
                .aisle("ABBBA", "BDDDB", "BDDDB", "BDDDB", "ABBBA")
                .aisle("ABCBA", "BDDDB", "CDDDC", "BDDDB", "ABCBA")
                .aisle("ABBBA", "BDDDB", "BDDDB", "BDDDB", "ABBBA")
                .aisle("A   A", " EEE ", " EAE ", " EEE ", "A   A")
                .aisle("AAAAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA")
                .aisle("A   A", " YZY ", " X~X ", " YWY ", "A   A")
                .where('~', GTLiteMetaTileEntities.DECAY_GENERATOR, EnumFacing.SOUTH)
                .where('A', getCasingState())
                .where('B', getSecondCasingState())
                .where('D', getThirdCasingState())
                .where('F', getCasingState())
                .where('X', MetaTileEntities.FLUID_EXPORT_HATCH[ZPM], EnumFacing.SOUTH)
                .where('Y', MetaTileEntities.FLUID_IMPORT_HATCH[ZPM], EnumFacing.SOUTH)
                .where('Z', MetaTileEntities.ITEM_IMPORT_BUS[ZPM], EnumFacing.SOUTH)
                .where('W', MetaTileEntities.ITEM_EXPORT_BUS[ZPM], EnumFacing.SOUTH)
                .where('V', MetaTileEntities.ENERGY_INPUT_HATCH[ZPM], EnumFacing.NORTH)
                .where('U', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : getCasingState(), EnumFacing.NORTH)
                .where('E', getCasingState());
        GTLiteAPI.MAP_FIELD_CASING.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
                .forEach(entry -> shapeInfo.add(builder.where('C', entry.getKey()).build()));
        return shapeInfo;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.decay_generator.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.decay_generator.tooltip.2"));
    }
}