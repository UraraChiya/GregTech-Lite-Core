package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiMapMultiblockController;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.utils.TooltipHelper;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockActiveUniqueCasing;
import magicbook.gtlitecore.common.blocks.BlockComputerCasing;
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

public class MetaTileEntityBiowareSimulator extends MultiMapMultiblockController {

    public MetaTileEntityBiowareSimulator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                GTLiteRecipeMaps.SIMULATOR_RECIPES,
                GTLiteRecipeMaps.BIOWARE_SIMULATOR_RECIPES});
        this.recipeMapWorkable = new BiowareSimulatorRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityBiowareSimulator(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CC", "DD", "DD", "DD", "CC")
                .aisle("VC", "XV", "XV", "XV", "VC")
                .aisle("VC", "XV", "XV", "XV", "VC")
                .aisle("VC", "XV", "XV", "XV", "VC")
                .aisle("SC", "DD", "DD", "DD", "CC")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState()))
                .where('D', states(getSecondCasingState())
                        .setMinGlobalLimited(4)
                        .or(autoAbilities()))
                .where('V', states(getThirdCasingState()))
                .where('X', states(getUniqueCasingState()))
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.COMPUTER_CASING.getState(BlockComputerCasing.ComputerCasingType.ADVANCED_BIOWARE_COMPUTER_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GTLiteMetaBlocks.COMPUTER_CASING.getState(BlockComputerCasing.ComputerCasingType.BIOWARE_COMPUTER_CASING);
    }

    private static IBlockState getThirdCasingState() {
        return GTLiteMetaBlocks.COMPUTER_CASING.getState(BlockComputerCasing.ComputerCasingType.BIOWARE_COMPUTER_HEAT_VENT);
    }

    private static IBlockState getUniqueCasingState() {
        return GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getState(BlockActiveUniqueCasing.ActiveCasingType.BIOWARE_COMPUTING_CASING);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return iMultiblockPart == null ? GTLiteTextures.ADVANCED_BIOWARE_COMPUTER_CASING : GTLiteTextures.BIOWARE_COMPUTER_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.BIOWARE_SIMULATOR_OVERLAY;
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.get_parallel_by_voltage"));
        tooltip.add(I18n.format("gtlitecore.machine.bioware_simulator.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.bioware_simulator.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.bioware_simulator.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.bioware_simulator.tooltip.4"));
        tooltip.add(I18n.format("gtlitecore.machine.bioware_simulator.tooltip.5"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.max_parallel", 640));
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    protected static class BiowareSimulatorRecipeLogic extends MultiblockRecipeLogic {

        public BiowareSimulatorRecipeLogic(RecipeMapMultiblockController tileEntity) {
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


        /**
         * @param maxProgress Get 1/2 progress time.
         */
        @Override
        public void setMaxProgress(int maxProgress) {
            this.maxProgressTime = maxProgress / 2;
        }

    }
}