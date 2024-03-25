package magicbook.gtlitecore.common.metatileentities.multi.electric;

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
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockBoilerCasing;
import magicbook.gtlitecore.common.blocks.BlockMultiblockCasing;
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

import static gregtech.api.unification.material.Materials.NaquadahAlloy;

public class MetaTileEntityFuelRefineFactory extends RecipeMapMultiblockController {

    public MetaTileEntityFuelRefineFactory(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.FUEL_REFINE_FACTORY_RECIPES);
        this.recipeMapWorkable = new MultiblockRecipeLogic(this, true);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityFuelRefineFactory(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("               ", "      XXX      ", "               ", "               ", "               ", "               ", "               ", "      XXX      ", "               ", "               ", "               ", "               ", "               ", "      XXX      ", "               ")
                .aisle("      XXX      ", "    XX   XX    ", "      XXX      ", "               ", "               ", "               ", "      XXX      ", "    XX   XX    ", "      XXX      ", "               ", "               ", "               ", "      XXX      ", "    XX   XX    ", "      XXX      ")
                .aisle("    XX   XX    ", "   X  XXX  X   ", "    XX   XX    ", "               ", "               ", "               ", "    XX   XX    ", "   X  XXX  X   ", "    XX   XX    ", "               ", "               ", "               ", "    XX   XX    ", "   X  XXX  X   ", "    XX   XX    ")
                .aisle("   X       X   ", "  XPXXFPFXXPX  ", "   X  F F  X   ", "      F F      ", "      F F      ", "      F F      ", "   X  F F  X   ", "  XPXXFPFXXPX  ", "   X  F F  X   ", "      F F      ", "      F F      ", "      F F      ", "   X  F F  X   ", "  XPXXFPFXXPX  ", "   X       X   ")
                .aisle("  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ")
                .aisle("  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ")
                .aisle(" X    XXX    X ", "X XF  FPF  FX X", " X F  F F  F X ", "   F  F F  F   ", "   F  F F  F   ", "   F  F F  F   ", " X F  F F  F X ", "X XF  FPF  FX X", " X F  F F  F X ", "   F  F F  F   ", "   F  F F  F   ", "   F  F F  F   ", " X F  F F  F X ", "X XF  FPF  FX X", " X    XXX    X ")
                .aisle(" X    XXX    X ", "X XPUUP PUUPX X", " X           X ", "               ", "               ", "               ", " X           X ", "X XPUUP PUUPX X", " X           X ", "               ", "               ", "               ", " X           X ", "X XPUUP PUUPX X", " X    XMX    X ")
                .aisle(" X    XXX    X ", "X XF  FPF  FX X", " X F  F F  F X ", "   F  F F  F   ", "   F  F F  F   ", "   F  F F  F   ", " X F  F F  F X ", "X XF  FPF  FX X", " X F  F F  F X ", "   F  F F  F   ", "   F  F F  F   ", "   F  F F  F   ", " X F  F F  F X ", "X XF  FPF  FX X", " X    XXX    X ")
                .aisle("  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ")
                .aisle("  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ")
                .aisle("   X       X   ", "  XPXXFPFXXPX  ", "   X  F F  X   ", "      F F      ", "      F F      ", "      F F      ", "   X  F F  X   ", "  XPXXFPFXXPX  ", "   X  F F  X   ", "      F F      ", "      F F      ", "      F F      ", "   X  F F  X   ", "  XPXXFPFXXPX  ", "   X       X   ")
                .aisle("    XX   XX    ", "   X  XXX  X   ", "    XX   XX    ", "               ", "               ", "               ", "    XX   XX    ", "   X  XXX  X   ", "    XX   XX    ", "               ", "               ", "               ", "    XX   XX    ", "   X  XXX  X   ", "    XX   XX    ")
                .aisle("      XXX      ", "    XX   XX    ", "      XXX      ", "               ", "               ", "               ", "      XXX      ", "    XX   XX    ", "      XXX      ", "               ", "               ", "               ", "      XXX      ", "    XX   XX    ", "      XXX      ")
                .aisle("               ", "      XSX      ", "               ", "               ", "               ", "               ", "               ", "      XXX      ", "               ", "               ", "               ", "               ", "               ", "      XXX      ", "               ")
                .where('S', this.selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(387)
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('P', states(getBoilerCasingState()))
                .where('U', states(getUniqueCasingState()))
                .where('F', states(getFrameState()))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.TALONITE_CASING);
    }

    private static IBlockState getBoilerCasingState() {
        return GTLiteMetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYBENZIMIDAZOLE);
    }

    private static IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(NaquadahAlloy).getBlock(NaquadahAlloy);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.TALONITE_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.BURNER_REACTOR_OVERLAY;
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }
}
