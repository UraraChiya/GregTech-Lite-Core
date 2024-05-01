package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
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

public class MetaTileEntityPlanetaryGasSiphon extends RecipeMapMultiblockController {

    public MetaTileEntityPlanetaryGasSiphon(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.PLANETARY_GAS_SIPHON_RECIPES);
        this.recipeMapWorkable = new MultiblockRecipeLogic(this, true);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityPlanetaryGasSiphon(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("F   F", "F   F", "CCCCC", "     ", "     ", "     ", "     ", "     ", "     ", "     ")
                .aisle("     ", "     ", "CCCCC", " CCC ", "  F  ", "  F  ", "  F  ", "     ", "     ", "     ")
                .aisle("     ", "     ", "CCCCC", " CCC ", " FCF ", " FCF ", " FCF ", "  F  ", "  F  ", "  F  ")
                .aisle("     ", "     ", "CCCCC", " CSC ", "  F  ", "  F  ", "  F  ", "     ", "     ", "     ")
                .aisle("F   F", "F   F", "CCCCC", "     ", "     ", "     ", "     ", "     ", "     ", "     ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(24)
                        .or(autoAbilities()))
                .where('F', states(getFrameState()))
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.BERKELIUM_CASING);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.Berkelium).getBlock(Materials.Berkelium);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.BERKELIUM_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.PLANETARY_GAS_SIPHON_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
        tooltip.add(I18n.format("gtlitecore.machine.planetary_gas_siphon.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.planetary_gas_siphon.tooltip.2"));
    }
}
