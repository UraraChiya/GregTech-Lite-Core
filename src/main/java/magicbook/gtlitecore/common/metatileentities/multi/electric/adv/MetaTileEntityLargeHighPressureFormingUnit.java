package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiMapMultiblockController;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
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

public class MetaTileEntityLargeHighPressureFormingUnit extends MultiMapMultiblockController {

    public MetaTileEntityLargeHighPressureFormingUnit(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                RecipeMaps.BENDER_RECIPES,
                RecipeMaps.COMPRESSOR_RECIPES,
                RecipeMaps.FORMING_PRESS_RECIPES,
                RecipeMaps.EXTRUDER_RECIPES,
                RecipeMaps.AUTOCLAVE_RECIPES});
        this.recipeMapWorkable = new HighPressureFormingUnitRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargeHighPressureFormingUnit(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("     XXEXX     ", "     XXEXX     ", "       X       ")
                .aisle("   XXXXXXXXX   ", "   XXCCCCCXX   ", "     XPXPX     ")
                .aisle("  XXXXXEXXXXX  ", "  XCCCXEXCCCX  ", "   XXF s FXX   ")
                .aisle(" XXXXX   XXXXX ", " XCCXX   XXCCX ", "  XF       FX  ")
                .aisle(" XXX       XXX ", " XCX       XCX ", "  X         X  ")
                .aisle("XXXX       XXXX", "XCCX       XCCX", " XF         FX ")
                .aisle("XXX         XXX", "XCX         XCX", " P           P ")
                .aisle("EXE         EXE", "ECE         ECE", "XXs         sXX")
                .aisle("XXX         XXX", "XCX         XCX", " P           P ")
                .aisle("XXXX       XXXX", "XCCX       XCCX", " XF         FX ")
                .aisle(" XXX       XXX ", " XCX       XCX ", "  X         X  ")
                .aisle(" XXXXX   XXXXX ", " XCCXX   XXCCX ", "  XF       FX  ")
                .aisle("  XXXXXEXXXXX  ", "  XCCCXEXCCCX  ", "   XXF s FXX   ")
                .aisle("   XXXXXXXXX   ", "   XXCCCCCXX   ", "     XPXPX     ")
                .aisle("     XXEXX     ", "     XXSXX     ", "       X       ")
                .where('S', this.selfPredicate())
                .where('X', states(getCasingState()))
                .where('E', states(getUniqueCasingState()))
                .where('C', states(getBoilerCasingState()))
                .where('F', states(getCasingState())
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS)
                                .setMaxGlobalLimited(12)
                                .setPreviewCount(6))
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS)
                                .setMaxGlobalLimited(12)
                                .setPreviewCount(6)))
                .where('P', states(getCasingState())
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS)
                                .setMaxGlobalLimited(8)
                                .setPreviewCount(4))
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS)
                                .setMaxGlobalLimited(8)
                                .setPreviewCount(4)))
                .where('s', states(getCasingState())
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH)
                                .setExactLimit(1)
                                .setPreviewCount(1))
                        .or(abilities(MultiblockAbility.INPUT_ENERGY)
                                .setMinGlobalLimited(1)
                                .setMaxGlobalLimited(3)
                                .setPreviewCount(3)))
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.STRUCTURE_CASING.getState(BlockStructureCasing.StructureCasingType.INCOLOY_020_CASING);
    }

    private static IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE);
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.INCOLOY_020_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GCYMTextures.LARGE_BENDER_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.large_high_pressure_forming_unit.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.get_parallel_by_voltage"));
        tooltip.add(I18n.format("gtlitecore.machine.large_high_pressure_forming_unit.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.large_high_pressure_forming_unit.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.max_parallel", 640));
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class HighPressureFormingUnitRecipeLogic extends MultiblockRecipeLogic {

        public HighPressureFormingUnitRecipeLogic(MetaTileEntityLargeHighPressureFormingUnit tileEntity) {
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
