package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.*;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.LV;

public class MetaTileEntityUnmannedDroneAirport extends RecipeMapMultiblockController {

    public MetaTileEntityUnmannedDroneAirport(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.DRONE_AIRPORT_RECIPES);
        this.recipeMapWorkable = new MultiblockRecipeLogic(this, true);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityUnmannedDroneAirport(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("    F     F", "    F     F", "     FCCCF ", "     F   F ", "           ", "           ")
                .aisle("F          ", "F          ", "FFFFFCXXXCF", " AAAF     F", " AAA       ", "           ")
                .aisle("           ", "           ", "FAAACXXXXXC", "P###P      ", "P###P      ", " AAA       ")
                .aisle("           ", "           ", "FAAACXXXXXC", "A#G#A      ", "A#G#A      ", " AMA       ")
                .aisle("           ", "           ", "FAAACXXXXXC", "P###P      ", "P###P      ", " AAA       ")
                .aisle("F          ", "F          ", "FFFFFCXXXCF", " AAAF     F", " ASA       ", "           ")
                .aisle("    F     F", "    F     F", "     FCCCF ", "     F   F ", "           ", "           ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .or(states(getAnotherCasingState())))
                .where('X', states(getSecondCasingState()))
                .where('A', states(getThirdCasingState())
                        .setMinGlobalLimited(25)
                        .or(autoAbilities(true, true, true, true, true, false, false)))
                .where('G', states(getFourthCasingState()))
                .where('P', states(getBoilerCasingState()))
                .where('F', states(getFrameState()))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where(' ', any())
                .where('#', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.WARNING_SIGN.getState(BlockWarningSign.SignType.YELLOW_STRIPES);
    }

    private static IBlockState getAnotherCasingState() {
        return MetaBlocks.WARNING_SIGN.getState(BlockWarningSign.SignType.SMALL_YELLOW_STRIPES);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.CLEANROOM_CASING.getState(BlockCleanroomCasing.CasingType.PLASCRETE);
    }

    private static IBlockState getThirdCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID);
    }

    private static IBlockState getFourthCasingState() {
        return MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STEEL_GEARBOX);
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
        return Textures.SOLID_STEEL_CASING;
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
        tooltip.add(I18n.format("gtlitecore.machine.unmanned_drone_airport.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.unmanned_drone_airport.tooltip.2"));
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
        MultiblockShapeInfo.Builder baseBuilder = null;
        if (Blocks.AIR != null) {
            baseBuilder = MultiblockShapeInfo.builder()
                    .aisle("    F     F", "    F     F", "     FCCCF ", "     F   F ", "           ", "           ")
                    .aisle("F          ", "F          ", "FFFFFCXXXCF", " WEEF     F", " AAA       ", "           ")
                    .aisle("           ", "           ", "FAAACXXXXXC", "P###P      ", "P###P      ", " AAA       ")
                    .aisle("           ", "           ", "FAAACXXXXXC", "A#G#A      ", "A#G#A      ", " AMA       ")
                    .aisle("           ", "           ", "FAAACXXXXXC", "P###P      ", "P###P      ", " AAA       ")
                    .aisle("F          ", "F          ", "FFFFFCXXXCF", " OYZF     F", " ASA       ", "           ")
                    .aisle("    F     F", "    F     F", "     FCCCF ", "     F   F ", "           ", "           ")
                    .where('S', GTLiteMetaTileEntities.UNMANNED_DRONE_AIRPORT, EnumFacing.SOUTH)
                    .where('C', getAnotherCasingState())
                    .where('X', getSecondCasingState())
                    .where('A', getThirdCasingState())
                    .where('G', getFourthCasingState())
                    .where('P', getBoilerCasingState())
                    .where('F', getFrameState())
                    .where('M', MetaTileEntities.MUFFLER_HATCH[LV], EnumFacing.UP)
                    .where('W', MetaTileEntities.MAINTENANCE_HATCH, EnumFacing.NORTH)
                    .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[HV], EnumFacing.NORTH)
                    .where('O', MetaTileEntities.ITEM_IMPORT_BUS[LV], EnumFacing.SOUTH)
                    .where('Y', MetaTileEntities.ITEM_EXPORT_BUS[LV], EnumFacing.SOUTH)
                    .where('Z', MetaTileEntities.FLUID_IMPORT_HATCH[LV], EnumFacing.SOUTH)
                    .where('#', Blocks.AIR.getDefaultState());
        }
        if (baseBuilder != null) {
            shapeInfos.add(baseBuilder.shallowCopy().where('C', getCasingState()).build());
            shapeInfos.add(baseBuilder.build());
        }
        return shapeInfos;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }
}
