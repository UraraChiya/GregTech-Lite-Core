package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.core.sound.GTSoundEvents;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import static gregtech.api.GTValues.*;

public class MetaTileEntityMegaChemicalReactor extends RecipeMapMultiblockController {

    public MetaTileEntityMegaChemicalReactor(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.LARGE_CHEMICAL_RECIPES);
        this.recipeMapWorkable = new MegaChemicalReactorWorkableHandler(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityMegaChemicalReactor(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("X   X", "XXXXX", "X   X", "XXXXX", "X   X")
                .aisle("XXXXX", "XCCCX", "XPPPX", "XCCCX", "XXXXX")
                .aisle("X   X", "XPPPX", "XMMMX", "XPPPX", "X   X")
                .aisle("XXXXX", "XCCCX", "XPPPX", "XCCCX", "XXXXX")
                .aisle("X   X", "SXXXX", "X   X", "XXXXX", "X   X")
                .where('S', this.selfPredicate())
                .where('P', states(getBoilerCasingState()))
                .where('C', heatingCoils())
                .where('M', states(getUniqueCasingState()))
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(50)
                        .or(autoAbilities()))
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.PTFE_INERT_CASING);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE);
    }

    private static IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.INERT_PTFE_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.CHEMICAL_REACTOR_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
        tooltip.add(I18n.format("gtlitecore.machine.mega_chemical_reactor.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.mega_chemical_reactor.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.mega_chemical_reactor.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.mega_chemical_reactor.tooltip.4"));
    }

    @Override
    public SoundEvent getBreakdownSound() {
        return GTSoundEvents.BREAKDOWN_ELECTRICAL;
    }

    private class MegaChemicalReactorWorkableHandler extends MultiblockRecipeLogic {
        public MegaChemicalReactorWorkableHandler(RecipeMapMultiblockController tileEntity) {
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