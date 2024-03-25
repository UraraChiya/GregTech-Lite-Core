package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiMapMultiblockController;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.*;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.*;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockBoilerCasing;
import magicbook.gtlitecore.common.blocks.BlockPCBFactoryCasing;
import magicbook.gtlitecore.common.blocks.BlockUniqueCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
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

import static gregtech.api.GTValues.EV;
import static gregtech.api.GTValues.LuV;
import static magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate.optionalStates;

//  TODO redo workable handler and recipe maps, maybe split nano assembling mode to a new nano swarm-related machine.
//  TODO add recipe tier, and compare with auxiliaryUpgradeNumber though checkRecipe().
public class MetaTileEntityPCBFactory extends MultiMapMultiblockController {

    private byte auxiliaryUpgradeNumber = 0;
    private static final TraceabilityPredicate SNOW_LAYER = new TraceabilityPredicate(blockWorldState -> GTUtility.isBlockSnow(blockWorldState.getBlockState()));

    public MetaTileEntityPCBFactory(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                GTLiteRecipeMaps.PCB_FACTORY_ETCH_RECIPES,
                GTLiteRecipeMaps.PCB_FACTORY_BIO_RECIPES,
                GTLiteRecipeMaps.PCB_FACTORY_NANO_RECIPES
        });
        this.recipeMapWorkable = new PCBFactoryRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityPCBFactory(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);

        //  T2
        if (context.get("AuxiliaryUpgradeTier2") != null) {
            auxiliaryUpgradeNumber += 1;
        }

        //  Water Cooling Tower
        if (context.get("AuxiliaryUpgradeWaterCoolingTower") != null) {
            auxiliaryUpgradeNumber += 1;
        }

        //  Bio Chamber
        if (context.get("AuxiliaryUpgradeBioChamber") != null) {
            auxiliaryUpgradeNumber += 1;
        }

        //  T3
        if (context.get("AuxiliaryUpgradeTier3") != null) {
            auxiliaryUpgradeNumber += 1;
        }

        //  Infinity Cooling Tower
        if (context.get("AuxiliaryUpgradeInfinityCoolingTower") != null) {
            auxiliaryUpgradeNumber += 1;
        }
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        auxiliaryUpgradeNumber = 0;
    }

    /**
     * <h2>PCB Factory Structures</h2>
     *
     * <p>Basic structure for GregTech 5 Unofficial, and I made some tweaks...</p>
     *
     * <p>If you want to reference some structure, please see below:</p>
     *
     * <h3>Basic T1 Structure</h3>
     * .aisle("FCCCCCF", "FCCCCCF", "FCCCCCF", "FCCCCCF", "F     F", "       ")
     * .aisle("CcccccC", "C#####C", "C#####C", "C#####C", "CCCCCCC", "F     F")
     * .aisle("CcccccC", "D#XXX#D", "D#####D", "C#####C", "CCCCCCC", "F     F")
     * .aisle("CcccccC", "D#XXX#D", "D#####D", "C#####C", "CCCCCCC", "FFFFFFF")
     * .aisle("CcccccC", "D#XXX#D", "D#####D", "C#####C", "CGGGGGC", "F     F")
     * .aisle("CcccccC", "C#####C", "C#####C", "C#####C", "CGGGGGC", "F     F")
     * .aisle("FCCSCCF", "FGGGGGF", "FGGGGGF", "FGGGGGF", "FFFFFFF", "       ")
     * <h3>Basic T2 Structure</h3>
     * .aisle("fddf       ", "fddf       ", "fddf       ", "           ", "           ", "           ", "           ")
     * .aisle("dddd       ", "d##d       ", "d##d       ", "fddf       ", "fddf       ", "           ", "           ")
     * .aisle("ddddFCCCCCF", "d##dFCCCCCF", "d##dFCCCCCF", "d##dFCCCCCF", "d##dF     F", "fddf       ", "           ")
     * .aisle("ddddCcccccC", "d##dC#####C", "d##dC#####C", "d##dC#####C", "d##dCCCCCCC", "ddddF     F", "fddf       ")
     * .aisle("ddddCcccccC", "d##dD#XXX#D", "d##dD#####D", "d##dC#####C", "d##dCCCCCCC", "ddddF     F", "fddf       ")
     * .aisle("ddddCcccccC", "d##dD#XXX#D", "d##dD#####D", "d##dC#####C", "d##dCCCCCCC", "ddddFFFFFFF", "fddf       ")
     * .aisle("ddddCcccccC", "d##dD#XXX#D", "d##dD#####D", "d##dC#####C", "d##dCGGGGGC", "ddddF     F", "fddf       ")
     * .aisle("ddddCcccccC", "d##dC#####C", "d##dC#####C", "d##dC#####C", "d##dCGGGGGC", "ddddF     F", "fddf       ")
     * .aisle("ddddFCCSCCF", "d##dFGGGGGF", "d##dFGGGGGF", "d##dFGGGGGF", "d##dFFFFFFF", "fddf       ", "           ")
     * .aisle("dddd       ", "d##d       ", "d##d       ", "fddf       ", "fddf       ", "           ", "           ")
     * .aisle("fddf       ", "fddf       ", "fddf       ", "           ", "           ", "           ", "           ")
     *  <h3>Water Cooling Tower</h3>
     *  .aisle("     HeeeH ", "     HpppH ", "     H   H ", "     H   H ", "     HgggH ", "     H   H ", "     H   H ", "     H   H ", "     H   H ", "     HxxxH ")
     *  .aisle("     eeeee ", "     pxxxp ", "      xxx  ", "      xxx  ", "     gxxxg ", "      xxx  ", "      xxx  ", "      ppp  ", "      xxx  ", "     x###x ")
     *  .aisle("    Peeeee ", "     px#xp ", "      xox  ", "      x#x  ", "     gx#xg ", "      x#x  ", "      x#x  ", "      p#p  ", "      x#x  ", "     x###x ")
     *  .aisle("    Peeeee ", "     pxxxp ", "      xxx  ", "      xxx  ", "     gxxxg ", "      xxx  ", "      xxx  ", "      ppp  ", "      xxx  ", "     x###x ")
     *  .aisle("    PHeeeH ", "     HpppH ", "     H   H ", "     H   H ", "     HgggH ", "     H   H ", "     H   H ", "     H   H ", "     H   H ", "     HxxxH ")
     *  .aisle("    P      ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ")
     *  .aisle("    P      ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ")
     *  .aisle("fddfP      ", "fddf       ", "fddf       ", "           ", "           ", "           ", "           ", "           ", "           ", "           ")
     *  .aisle("ddddP      ", "d##d       ", "d##d       ", "fddf       ", "fddf       ", "           ", "           ", "           ", "           ", "           ")
     *  .aisle("ddddFCCCCCF", "d##dFCCCCCF", "d##dFCCCCCF", "d##dFCCCCCF", "d##dF     F", "fddf       ", "           ", "           ", "           ", "           ")
     *  .aisle("ddddCcccccC", "d##dC#####C", "d##dC#####C", "d##dC#####C", "d##dCCCCCCC", "ddddF     F", "fddf       ", "           ", "           ", "           ")
     *  .aisle("ddddCcccccC", "d##dD#XXX#D", "d##dD#####D", "d##dC#####C", "d##dCCCCCCC", "ddddF     F", "fddf       ", "           ", "           ", "           ")
     *  .aisle("ddddCcccccC", "d##dD#XXX#D", "d##dD#####D", "d##dC#####C", "d##dCCCCCCC", "ddddFFFFFFF", "fddf       ", "           ", "           ", "           ")
     *  .aisle("ddddCcccccC", "d##dD#XXX#D", "d##dD#####D", "d##dC#####C", "d##dCGGGGGC", "ddddF     F", "fddf       ", "           ", "           ", "           ")
     *  .aisle("ddddCcccccC", "d##dC#####C", "d##dC#####C", "d##dC#####C", "d##dCGGGGGC", "ddddF     F", "fddf       ", "           ", "           ", "           ")
     *  .aisle("ddddFCCSCCF", "d##dFGGGGGF", "d##dFGGGGGF", "d##dFGGGGGF", "d##dFFFFFFF", "fddf       ", "           ", "           ", "           ", "           ")
     *  .aisle("dddd       ", "d##d       ", "d##d       ", "fddf       ", "fddf       ", "           ", "           ", "           ", "           ", "           ")
     *  .aisle("fddf       ", "fddf       ", "fddf       ", "           ", "           ", "           ", "           ", "           ", "           ", "           ")
     * <h3>Bio Chamber</h3>
     * .aisle("     HeeeH              ", "     HpppH              ", "     H   H              ", "     H   H              ", "     HgggH              ", "     H   H              ", "     H   H              ", "     H   H              ", "     H   H              ", "     HxxxH              ")
     * .aisle("     eeeee              ", "     pxxxp              ", "      xxx               ", "      xxx               ", "     gxxxg              ", "      xxx               ", "      xxx               ", "      ppp               ", "      xxx               ", "     x###x              ")
     * .aisle("    Peeeee              ", "     px#xp              ", "      xox               ", "      x#x               ", "     gx#xg              ", "      x#x               ", "      x#x               ", "      p#p               ", "      x#x               ", "     x###x              ")
     * .aisle("    Peeeee              ", "     pxxxp              ", "      xxx               ", "      xxx               ", "     gxxxg              ", "      xxx               ", "      xxx               ", "      ppp               ", "      xxx               ", "     x###x              ")
     * .aisle("    PHeeeH              ", "     HpppH              ", "     H   H              ", "     H   H              ", "     HgggH              ", "     H   H              ", "     H   H              ", "     H   H              ", "     H   H              ", "     HxxxH              ")
     * .aisle("    P                   ", "                        ", "                        ", "                        ", "                        ", "                        ", "                        ", "                        ", "                        ", "                        ")
     * .aisle("    P                   ", "                        ", "                        ", "                        ", "                        ", "                        ", "                        ", "                        ", "                        ", "                        ")
     * .aisle("fddfP                   ", "fddf                    ", "fddf                    ", "                        ", "                        ", "                        ", "                        ", "                        ", "                        ", "                        ")
     * .aisle("ddddP                   ", "d##d                    ", "d##d                    ", "fddf                    ", "fddf                    ", "                        ", "                        ", "                        ", "                        ", "                        ")
     * .aisle("ddddFCCCCCF             ", "d##dFCCCCCF             ", "d##dFCCCCCF             ", "d##dFCCCCCF             ", "d##dF     F             ", "fddf                    ", "                        ", "                        ", "                        ", "                        ")
     * .aisle("ddddCcccccC hYYYh  hYYYh", "d##dC#####C hIIIh  hIIIh", "d##dC#####C hIIIh  hIIIh", "d##dC#####C hIIIh  hIIIh", "d##dCCCCCCC h   h  h   h", "ddddF     F             ", "fddf                    ", "                        ", "                        ", "                        ")
     * .aisle("ddddCcccccC YYYYY  YYYYY", "d##dD#XXX#D I###I  I###I", "d##dD#####D I###I  I###I", "d##dC#####C I###I  I###I", "d##dCCCCCCC  YYY    YYY ", "ddddF     F             ", "fddf                    ", "                        ", "                        ", "                        ")
     * .aisle("ddddCcccccCQYYYYY  YYYYY", "d##dD#XXX#D I###I  I###I", "d##dD#####D I###I  I###I", "d##dC#####C I###I  I###I", "d##dCCCCCCC  YYY    YYY ", "ddddFFFFFFF   Y      Y  ", "fddf           YYYYYY   ", "                        ", "                        ", "                        ")
     * .aisle("ddddCcccccC YYYYY  YYYYY", "d##dD#XXX#D I###I  I###I", "d##dD#####D I###I  I###I", "d##dC#####C I###I  I###I", "d##dCGGGGGC  YYY    YYY ", "ddddF     F             ", "fddf                    ", "                        ", "                        ", "                        ")
     * .aisle("ddddCcccccC hYYYh  hYYYh", "d##dC#####C hIIIh  hIIIh", "d##dC#####C hIIIh  hIIIh", "d##dC#####C hIIIh  hIIIh", "d##dCGGGGGC h   h  h   h", "ddddF     F             ", "fddf                    ", "                        ", "                        ", "                        ")
     * .aisle("ddddFCCSCCF             ", "d##dFGGGGGF             ", "d##dFGGGGGF             ", "d##dFGGGGGF             ", "d##dFFFFFFF             ", "fddf                    ", "                        ", "                        ", "                        ", "                        ")
     * .aisle("dddd                    ", "d##d                    ", "d##d                    ", "fddf                    ", "fddf                    ", "                        ", "                        ", "                        ", "                        ", "                        ")
     * .aisle("fddf                    ", "fddf                    ", "fddf                    ", "                        ", "                        ", "                        ", "                        ", "                        ", "                        ", "                        ")
     * <h3>Basic T3 Structure</h3>
     * .aisle("           HeeeH              ", "          HpppH              ", "          H   H              ", "          H   H              ", "          HgggH              ", "          H   H              ", "          H   H              ", "          H   H              ", "          H   H              ", "          HxxxH              ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("           eeeee              ", "          pxxxp              ", "           xxx               ", "           xxx               ", "          gxxxg              ", "           xxx               ", "           xxx               ", "           ppp               ", "           xxx               ", "          x###x              ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("          Peeeee              ", "          px#xp              ", "           xox               ", "           x#x               ", "          gx#xg              ", "           x#x               ", "           x#x               ", "           p#p               ", "           x#x               ", "          x###x              ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("          Peeeee              ", "          pxxxp              ", "           xxx               ", "           xxx               ", "          gxxxg              ", "           xxx               ", "           xxx               ", "           ppp               ", "           xxx               ", "          x###x              ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("          PHeeeH              ", "          HpppH              ", "          H   H              ", "          H   H              ", "          HgggH              ", "          H   H              ", "          H   H              ", "          H   H              ", "          H   H              ", "          HxxxH              ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("          P                   ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("          P                   ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("      fddfP                   ", "     fddf                    ", "     fddf                    ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("      ddddP                   ", "     d##d                    ", "     d##d                    ", "     fddf                    ", "     fddf                    ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("      ddddFCCCCCF             ", "     d##dFCCCCCF             ", "     d##dFCCCCCF             ", "     d##dFCCCCCF             ", "     d##dF     F             ", "     fddf                    ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("      ddddCcccccC hYYYh  hYYYh", "     d##dC#####C hIIIh  hIIIh", "     d##dC#####C hIIIh  hIIIh", "     d##dC#####C hIIIh  hIIIh", "     d##dCCCCCCC h   h  h   h", "     ddddF     F             ", "     fddf                    ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("      ddddCcccccC YYYYY  YYYYY", "     d##dD#XXX#D I###I  I###I", "     d##dD#####D I###I  I###I", "     d##dC#####C I###I  I###I", "     d##dCCCCCCC  YYY    YYY ", "     ddddF     F             ", "     fddf                    ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("     ZddddCcccccCQYYYYY  YYYYY", "     d##dD#XXX#D I###I  I###I", "     d##dD#####D I###I  I###I", "     d##dC#####C I###I  I###I", "     d##dCCCCCCC  YYY    YYY ", "     ddddFFFFFFF   Y      Y  ", "     fddf           YYYYYY   ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("     ZddddCcccccC YYYYY  YYYYY", "     d##dD#XXX#D I###I  I###I", "     d##dD#####D I###I  I###I", "     d##dC#####C I###I  I###I", "     d##dCGGGGGC  YYY    YYY ", "     ddddF     F             ", "     fddf                    ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("     ZddddCcccccC hYYYh  hYYYh", "     d##dC#####C hIIIh  hIIIh", "     d##dC#####C hIIIh  hIIIh", "     d##dC#####C hIIIh  hIIIh", "     d##dCGGGGGC h   h  h   h", "     ddddF     F             ", "     fddf                    ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("     ZddddFCCSCCF             ", "     d##dFGGGGGF             ", "     d##dFGGGGGF             ", "     d##dFGGGGGF             ", "     d##dFFFFFFF             ", "     fddf                    ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("     Zdddd                    ", "     d##d                    ", "     d##d                    ", "     fddf                    ", "     fddf                    ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("     Zfddf                    ", "     fddf                    ", "     fddf                    ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("     Z                        ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle(" yyyyyyyy                     ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("yyyyyyyyyy                    ", "  yyyyyy                     ", "  yyyyyy                     ", "  yyyyyy                     ", "  yyyyyy                     ", "  yyyyyy                     ", "     yyy                     ", "     yyy                     ", "     yyy                     ", "  yyyyyy                     ", "  y    y                     ", "  yyyyyy                     ", "  yyy                        ", "  yyy                        ", "  yyy                        ", "  yyy                        ", "  yyy                        ", "  yyy                        ", "                             ", "                             ", "                             ", "                             ")
     * .aisle("yyyyyyyyyy                    ", " y######y                    ", " y######y                    ", " y######y                    ", " y######y                    ", " y######y                    ", "  qqq###y                    ", "  qqq###y                    ", "  qqq###y                    ", " y######y                    ", " y#qqqq#y                    ", " y######y                    ", " y###qqq                     ", " y###qqq                     ", " y###qq                      ", " y###qq                      ", " y###q                       ", " y###q                       ", "  qqqq                       ", "  qqqq                       ", "                             ", "                             ")
     * .aisle("yyyyyyyyyy                    ", " y######y                    ", " y######y                    ", " y######y                    ", " y######y                    ", " y######y                    ", "  q#####y                    ", "  q#####y                    ", "  q#####y                    ", " y######y                    ", " y######y                    ", " y######y                    ", "  q####q                     ", "  q####q                     ", "  q###y                      ", " y####y                      ", " y####y                      ", " y####y                      ", "  q###y                      ", "  qy##y                      ", "   yyyy                      ", "    yy                       ")
     * .aisle("yyyyyyyyyy                    ", " y######y                    ", " y######y                    ", " y######y                    ", " y######y                    ", " y######y                    ", "  qqq###y                    ", "  qqq###y                    ", "  qqq###y                    ", " y######y                    ", " y#qqqq#y                    ", " y######y                    ", " y###qqq                     ", " y###qqq                     ", " y###qq                      ", " y###qq                      ", " y###q                       ", " y###q                       ", "  qqqq                       ", "  qqqq                       ", "                             ", "                             ")
     * .aisle("yyyyyyyyyy                    ", "  yyyyyy                     ", "  yyyyyy                     ", "  yyyyyy                     ", "  yyyyyy                     ", "  yyyyyy                     ", "     yyy                     ", "     yyy                     ", "     yyy                     ", "  yyyyyy                     ", "  y    y                     ", "  yyyyyy                     ", "  yyy                        ", "  yyy                        ", "  yyy                        ", "  yyy                        ", "  yyy                        ", "  yyy                        ", "                             ", "                             ", "                             ", "                             ")
     * .aisle(" yyyyyyyy                     ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
     *
     * <p>This multiblock is a typically upgrade structure, but something can be improved in the future (so it has many plans).</p>
     *
     * <p>Because it has many todo, we need to choice some important to solve it, e.g. in fact it just has five hatches, but in upgrade, we need to add more hatches for it.</p>
     *
     * @return Total Structure of PCB Factory, it means this structure consist of all upgrades.
     */
    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("           HeeeH  UWWWU       ", "           HpppH  UvvvU       ", "           H   H  U   U       ", "           H   H  U   U       ", "           HgggH  U   U       ", "           H   H  U   U       ", "           H   H  U   U       ", "           H   H  U   U       ", "           H   H  U   U       ", "           HxxxH  UWWWU       ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("           eeeee  WWWWW       ", "           pxxxp  vWWWv       ", "            xxx    VVV        ", "            xxx    VVV        ", "           gxxxg   VVV        ", "            xxx    VVV        ", "            xxx    VVV        ", "            ppp    vvv        ", "            xxx    WWW        ", "           x###x  W###W       ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("          PeeeeezzWWWWW       ", "           px#xp  vWwWv       ", "            xox    VwV        ", "            x#x    VwV        ", "           gx#xg   VwV        ", "            x#x    VwV        ", "            x#x    VwV        ", "            p#p    vwv        ", "            x#x    WwW        ", "           x###x  W###W       ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("          Peeeee  WWWWW       ", "           pxxxp  vWWWv       ", "            xxx    VVV        ", "            xxx    VVV        ", "           gxxxg   VVV        ", "            xxx    VVV        ", "            xxx    VVV        ", "            ppp    vvv        ", "            xxx    WWW        ", "           x###x  W###W       ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("          PHeeeH  UWWWU       ", "           HpppH  UvvvU       ", "           H   H  U   U       ", "           H   H  U   U       ", "           HgggH  U   U       ", "           H   H  U   U       ", "           H   H  U   U       ", "           H   H  U   U       ", "           H   H  U   U       ", "           HxxxH  UWWWU       ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("          P                   ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("          P                   ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("      fddfP                   ", "      fddf                    ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("      ddddP                   ", "      d##d                    ", "      d##d                    ", "      fddf                    ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("      ddddFCCCCCF             ", "      d##dFTTTTTF             ", "      d##dFCCCCCF             ", "      d##dFCCCCCF             ", "      d##dF     F             ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("      ddddCcccccC hYYYh  hYYYh", "      d##dC#####C hIIIh  hIIIh", "      d##dC#####C hIIIh  hIIIh", "      d##dC#####C hIIIh  hIIIh", "      d##dCCCCCCC h   h  h   h", "      ddddF     F             ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("      ddddCcccccC YYYYY  YYYYY", "      d##dD#XXX#D I###I  I###I", "      d##dD#####D I###I  I###I", "      d##dC#####C I###I  I###I", "      d##dCCCCCCC  YYY    YYY ", "      ddddF     F             ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("     ZddddCcccccCQYYYYY  YYYYY", "      d##dD#XXX#D I###I  I###I", "      d##dD#####D I###I  I###I", "      d##dC#####C I###I  I###I", "      d##dCCCCCCC  YYY    YYY ", "      ddddFFFFFFF   Y      Y  ", "      fddf           YYYYYY   ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("     ZddddCcccccC YYYYY  YYYYY", "      d##dD#XXX#D I###I  I###I", "      d##dD#####D I###I  I###I", "      d##dC#####C I###I  I###I", "      d##dCGGGGGC  YYY    YYY ", "      ddddF     F             ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("     ZddddCcccccC hYYYh  hYYYh", "      d##dC#####C hIIIh  hIIIh", "      d##dC#####C hIIIh  hIIIh", "      d##dC#####C hIIIh  hIIIh", "      d##dCGGGGGC h   h  h   h", "      ddddF     F             ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("     ZddddFCCSCCF             ", "      d##dFGGGGGF             ", "      d##dFGGGGGF             ", "      d##dFGGGGGF             ", "      d##dFFFFFFF             ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("     Zdddd                    ", "      d##d                    ", "      d##d                    ", "      fddf                    ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("     Zfddf                    ", "      fddf                    ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("     Z                        ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle(" yyyyyyyy                     ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .aisle("yyyyyyyyyy                    ", "  yyyyyy                      ", "  yyyyyy                      ", "  yyyyyy                      ", "  yyyyyy                      ", "  yyyyyy                      ", "     yyy                      ", "     yyy                      ", "     yyy                      ", "  yyyyyy                      ", "  y    y                      ", "  yyyyyy                      ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "                              ", "                              ", "                              ", "                              ")
                .aisle("yyyyyyyyyy                    ", " y######y                     ", " y######y                     ", " y######y                     ", " y######y                     ", " y######y                     ", "  qqq###y                     ", "  qqq###y                     ", "  qqq###y                     ", " y######y                     ", " y#qqqq#y                     ", " y######y                     ", " y###qqq                      ", " y###qqq                      ", " y###qq                       ", " y###qq                       ", " y###q                        ", " y###q                        ", "  qqqq                        ", "  qqqq                        ", "                              ", "                              ")
                .aisle("yyyyyyyyyy                    ", " y######y                     ", " y######u                     ", " y######y                     ", " y######y                     ", " y######y                     ", "  q#####y                     ", "  q#####y                     ", "  q#####y                     ", " y######y                     ", " y######y                     ", " y######y                     ", "  q####q                      ", "  q####q                      ", "  q###y                       ", " y####y                       ", " y####y                       ", " y####y                       ", "  q###y                       ", "  qy##y                       ", "   yyyy                       ", "    yy                        ")
                .aisle("yyyyyyyyyy                    ", " y######y                     ", " y######y                     ", " y######y                     ", " y######y                     ", " y######y                     ", "  qqq###y                     ", "  qqq###y                     ", "  qqq###y                     ", " y######y                     ", " y#qqqq#y                     ", " y######y                     ", " y###qqq                      ", " y###qqq                      ", " y###qq                       ", " y###qq                       ", " y###q                        ", " y###q                        ", "  qqqq                        ", "  qqqq                        ", "                              ", "                              ")
                .aisle("yyyyyyyyyy                    ", "  yyyyyy                      ", "  yyyyyy                      ", "  yyyyyy                      ", "  yyyyyy                      ", "  yyyyyy                      ", "     yyy                      ", "     yyy                      ", "     yyy                      ", "  yyyyyy                      ", "  y    y                      ", "  yyyyyy                      ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "                              ", "                              ", "                              ", "                              ")
                .aisle(" yyyyyyyy                     ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                .where('S', this.selfPredicate())
                //  Basic T1 Structure
                .where('C', states(getCasingState())) // T1 casing
                .where('T', states(getCasingState())
                        .or(autoAbilities()))
                .where('c', states(getSecondCasingState())) // floor
                .where('D', states(getThirdCasingState())) // grate
                .where('F', states(getFrameState())) // HSLA frame
                .where('G', states(getGlassState())) // Laminated glass
                .where('X', states(getFourthCasingState())) // substrate casing
                //  Basic T2 Structure
                .where('f', optionalStates("AuxiliaryUpgradeTier2", getSecondFrameState())) // tungsten steel frame
                .where('d', optionalStates("AuxiliaryUpgradeTier2", getFifthCasingState())) // T2 casing
                //  Water Cooling Tower Structure
                .where('P', optionalStates("AuxiliaryUpgradeWaterCoolingTower", getBoilerCasingState())) // PBI pipe casing
                .where('H', optionalStates("AuxiliaryUpgradeWaterCoolingTower", getThirdFrameState())) // Naquadah Alloy frame
                .where('e', optionalStates("AuxiliaryUpgradeWaterCoolingTower", getFifthCasingState())) // T2 casing
                .where('p', optionalStates("AuxiliaryUpgradeWaterCoolingTower", getSecondBoilerCasingState())) // Tungsten Steel pipe casing
                .where('x', optionalStates("AuxiliaryUpgradeWaterCoolingTower", getSixthCasingState())) // Water cooling casing
                .where('g', optionalStates("AuxiliaryUpgradeWaterCoolingTower", getSeventhCasingState())) //  Tungsten Steel intake casing
                //  Bio Chamber Structure
                .where('Q', optionalStates("AuxiliaryUpgradeBioChamber", getBoilerCasingState())) // PBI pipe casing
                .where('Y', optionalStates("AuxiliaryUpgradeBioChamber", getEighthCasingState())) // Bio machine casing
                .where('h', optionalStates("AuxiliaryUpgradeBioChamber", getFourthFrameState())) // Vanadium Steel frame
                .where('I', optionalStates("AuxiliaryUpgradeBioChamber", getGlassState())) // Laminated glass
                //  Basic T3 Structure
                .where('y', optionalStates("AuxiliaryUpgradeTier3", getNinthCasingState())) // T3 casing
                .where('Z', optionalStates("AuxiliaryUpgradeTier3", getBoilerCasingState())) // PBI pipe casing
                .where('q', optionalStates("AuxiliaryUpgradeTier3", getEleventhCasingState())) // PTFE casing
                .where('u', optionalStates("AuxiliaryUpgradeTier3", getUniqueCasingState())) // computing casing
                //  Infinity Cooling Tower structure
                .where('z', optionalStates("AuxiliaryUpgradeInfinityCoolingTower", getBoilerCasingState())) // PBI pipe casing
                .where('U', optionalStates("AuxiliaryUpgradeInfinityCoolingTower", getFifthFrameState())) // Europium frame
                .where('V', optionalStates("AuxiliaryUpgradeInfinityCoolingTower", getTenthCasingState())) // Infinity cooling casing
                .where('v', optionalStates("AuxiliaryUpgradeInfinityCoolingTower", getSecondBoilerCasingState())) // Tungsten Steel pipe casing
                .where('W', optionalStates("AuxiliaryUpgradeInfinityCoolingTower", getNinthCasingState())) // T3 casing
                .where('w', optionalStates("AuxiliaryUpgradeInfinityCoolingTower", getCoilState())) // Superconduct coil
                .where('#', any())
                .where('o', any()
                        .or(SNOW_LAYER))
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.PCB_FACTORY_CASING.getState(BlockPCBFactoryCasing.PCBFactoryCasingType.BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.CLEANROOM_CASING.getState(BlockCleanroomCasing.CasingType.PLASCRETE);
    }

    private static IBlockState getThirdCasingState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING);
    }

    private static IBlockState getFourthCasingState() {
        return GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(magicbook.gtlitecore.common.blocks.BlockMultiblockCasing.MultiblockCasingType.ADVANCED_SUBSTRATE_CASING);
    }

    private static IBlockState getFifthCasingState() {
        return GTLiteMetaBlocks.PCB_FACTORY_CASING.getState(BlockPCBFactoryCasing.PCBFactoryCasingType.MOLD_PRINTING_ASSEMBLY_FRAMEWORK_CASING);
    }

    private static IBlockState getSixthCasingState() {
        return GTLiteMetaBlocks.PCB_FACTORY_CASING.getState(BlockPCBFactoryCasing.PCBFactoryCasingType.WATER_COOLED_MACHINE_CASING);
    }

    private static IBlockState getSeventhCasingState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.EXTREME_ENGINE_INTAKE_CASING);
    }

    private static IBlockState getEighthCasingState() {
        return GTLiteMetaBlocks.PCB_FACTORY_CASING.getState(BlockPCBFactoryCasing.PCBFactoryCasingType.BIOLOGICAL_STERILE_MACHINE_CASING);
    }

    private static IBlockState getNinthCasingState() {
        return GTLiteMetaBlocks.PCB_FACTORY_CASING.getState(BlockPCBFactoryCasing.PCBFactoryCasingType.RADIATION_PROOF_SCAN_FRAMEWORK_CASING);
    }

    private static IBlockState getTenthCasingState() {
        return GTLiteMetaBlocks.PCB_FACTORY_CASING.getState(BlockPCBFactoryCasing.PCBFactoryCasingType.INFINITY_COOLED_MACHINE_CASING);
    }

    private static IBlockState getEleventhCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.PTFE_INERT_CASING);
    }

    private static IBlockState getUniqueCasingState() {
        return GTLiteMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.COMPMUTING_CASING);
    }

    private static IBlockState getBoilerCasingState() {
        return GTLiteMetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYBENZIMIDAZOLE);
    }

    private static IBlockState getSecondBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(gregtech.common.blocks.BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE);
    }

    private static IBlockState getCoilState() {
        return MetaBlocks.FUSION_CASING.getState(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.LAMINATED_GLASS);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(GCYMMaterials.HSLASteel).getBlock(GCYMMaterials.HSLASteel);
    }

    private static IBlockState getSecondFrameState() {
        return MetaBlocks.FRAMES.get(Materials.TungstenSteel).getBlock(Materials.TungstenSteel);
    }

    private static IBlockState getThirdFrameState() {
        return MetaBlocks.FRAMES.get(Materials.NaquadahAlloy).getBlock(Materials.NaquadahAlloy);
    }

    private static IBlockState getFourthFrameState() {
        return MetaBlocks.FRAMES.get(Materials.VanadiumSteel).getBlock(Materials.VanadiumSteel);
    }

    private static IBlockState getFifthFrameState() {
        return MetaBlocks.FRAMES.get(Materials.Europium).getBlock(Materials.Europium);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle("           HeeeH  UWWWU       ", "           HpppH  UvvvU       ", "           H   H  U   U       ", "           H   H  U   U       ", "           HgggH  U   U       ", "           H   H  U   U       ", "           H   H  U   U       ", "           H   H  U   U       ", "           H   H  U   U       ", "           HxxxH  UWWWU       ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("           eeeee  WWWWW       ", "           pxxxp  vWWWv       ", "            xxx    VVV        ", "            xxx    VVV        ", "           gxxxg   VVV        ", "            xxx    VVV        ", "            xxx    VVV        ", "            ppp    vvv        ", "            xxx    WWW        ", "           x###x  W###W       ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("          PeeeeezzWWWWW       ", "           px#xp  vWwWv       ", "            xox    VwV        ", "            x#x    VwV        ", "           gx#xg   VwV        ", "            x#x    VwV        ", "            x#x    VwV        ", "            p#p    vwv        ", "            x#x    WwW        ", "           x###x  W###W       ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("          Peeeee  WWWWW       ", "           pxxxp  vWWWv       ", "            xxx    VVV        ", "            xxx    VVV        ", "           gxxxg   VVV        ", "            xxx    VVV        ", "            xxx    VVV        ", "            ppp    vvv        ", "            xxx    WWW        ", "           x###x  W###W       ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("          PHeeeH  UWWWU       ", "           HpppH  UvvvU       ", "           H   H  U   U       ", "           H   H  U   U       ", "           HgggH  U   U       ", "           H   H  U   U       ", "           H   H  U   U       ", "           H   H  U   U       ", "           H   H  U   U       ", "           HxxxH  UWWWU       ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("          P                   ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("          P                   ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("      fddfP                   ", "      fddf                    ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("      ddddP                   ", "      d##d                    ", "      d##d                    ", "      fddf                    ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("      ddddFCCCCCF             ", "      d##dFJKLMNF             ", "      d##dFCCCCCF             ", "      d##dFCCCCCF             ", "      d##dF     F             ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("      ddddCcccccC hYYYh  hYYYh", "      d##dC#####C hIIIh  hIIIh", "      d##dC#####C hIIIh  hIIIh", "      d##dC#####C hIIIh  hIIIh", "      d##dCCCCCCC h   h  h   h", "      ddddF     F             ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("      ddddCcccccC YYYYY  YYYYY", "      d##dD#XXX#D I###I  I###I", "      d##dD#####D I###I  I###I", "      d##dC#####C I###I  I###I", "      d##dCCCCCCC  YYY    YYY ", "      ddddF     F             ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("     ZddddCcccccCQYYYYY  YYYYY", "      d##dD#XXX#D I###I  I###I", "      d##dD#####D I###I  I###I", "      d##dC#####C I###I  I###I", "      d##dCCCCCCC  YYY    YYY ", "      ddddFFFFFFF   Y      Y  ", "      fddf           YYYYYY   ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("     ZddddCcccccC YYYYY  YYYYY", "      d##dD#XXX#D I###I  I###I", "      d##dD#####D I###I  I###I", "      d##dC#####C I###I  I###I", "      d##dCGGGGGC  YYY    YYY ", "      ddddF     F             ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("     ZddddCcccccC hYYYh  hYYYh", "      d##dC#####C hIIIh  hIIIh", "      d##dC#####C hIIIh  hIIIh", "      d##dC#####C hIIIh  hIIIh", "      d##dCGGGGGC h   h  h   h", "      ddddF     F             ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("     ZddddFCCSCCF             ", "      d##dFGGGGGF             ", "      d##dFGGGGGF             ", "      d##dFGGGGGF             ", "      d##dFFFFFFF             ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("     Zdddd                    ", "      d##d                    ", "      d##d                    ", "      fddf                    ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("     Zfddf                    ", "      fddf                    ", "      fddf                    ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("     Z                        ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle(" yyyyyyyy                     ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("yyyyyyyyyy                    ", "  yyyyyy                      ", "  yyyyyy                      ", "  yyyyyy                      ", "  yyyyyy                      ", "  yyyyyy                      ", "     yyy                      ", "     yyy                      ", "     yyy                      ", "  yyyyyy                      ", "  y    y                      ", "  yyyyyy                      ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "                              ", "                              ", "                              ", "                              ")
                    .aisle("yyyyyyyyyy                    ", " y######y                     ", " y######y                     ", " y######y                     ", " y######y                     ", " y######y                     ", "  qqq###y                     ", "  qqq###y                     ", "  qqq###y                     ", " y######y                     ", " y#qqqq#y                     ", " y######y                     ", " y###qqq                      ", " y###qqq                      ", " y###qq                       ", " y###qq                       ", " y###q                        ", " y###q                        ", "  qqqq                        ", "  qqqq                        ", "                              ", "                              ")
                    .aisle("yyyyyyyyyy                    ", " y######y                     ", " y######u                     ", " y######y                     ", " y######y                     ", " y######y                     ", "  q#####y                     ", "  q#####y                     ", "  q#####y                     ", " y######y                     ", " y######y                     ", " y######y                     ", "  q####q                      ", "  q####q                      ", "  q###y                       ", " y####y                       ", " y####y                       ", " y####y                       ", "  q###y                       ", "  qy##y                       ", "   yyyy                       ", "    yy                        ")
                    .aisle("yyyyyyyyyy                    ", " y######y                     ", " y######y                     ", " y######y                     ", " y######y                     ", " y######y                     ", "  qqq###y                     ", "  qqq###y                     ", "  qqq###y                     ", " y######y                     ", " y#qqqq#y                     ", " y######y                     ", " y###qqq                      ", " y###qqq                      ", " y###qq                       ", " y###qq                       ", " y###q                        ", " y###q                        ", "  qqqq                        ", "  qqqq                        ", "                              ", "                              ")
                    .aisle("yyyyyyyyyy                    ", "  yyyyyy                      ", "  yyyyyy                      ", "  yyyyyy                      ", "  yyyyyy                      ", "  yyyyyy                      ", "     yyy                      ", "     yyy                      ", "     yyy                      ", "  yyyyyy                      ", "  y    y                      ", "  yyyyyy                      ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "  yyy                         ", "                              ", "                              ", "                              ", "                              ")
                    .aisle(" yyyyyyyy                     ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ", "                              ")
                    .where('S', GTLiteMetaTileEntities.PCB_FACTORY, EnumFacing.SOUTH)
                    .where('C', getCasingState())
                    .where('J', MetaTileEntities.MAINTENANCE_HATCH, EnumFacing.NORTH)
                    .where('K', MetaTileEntities.ENERGY_INPUT_HATCH[LuV], EnumFacing.NORTH)
                    .where('L', MetaTileEntities.ITEM_IMPORT_BUS[LuV], EnumFacing.NORTH)
                    .where('M', MetaTileEntities.ITEM_EXPORT_BUS[LuV], EnumFacing.NORTH)
                    .where('N', MetaTileEntities.FLUID_IMPORT_HATCH[LuV], EnumFacing.NORTH)
                    .where('c', getSecondCasingState())
                    .where('D', getThirdCasingState())
                    .where('F', getFrameState())
                    .where('G', getGlassState())
                    .where('X', getFourthCasingState())
                    .where(' ', Blocks.AIR.getDefaultState())
                    .where('#', Blocks.AIR.getDefaultState())
                    .where('o', Blocks.AIR.getDefaultState());
            shapeInfo.add(builder.build());
            shapeInfo.add(builder
                    .where('f', getSecondFrameState())
                    .where('d', getFifthCasingState())
                    .build());
            shapeInfo.add(builder
                    .where('P', getBoilerCasingState())
                    .where('H', getThirdFrameState())
                    .where('e', getFifthCasingState())
                    .where('p', getSecondBoilerCasingState())
                    .where('x', getSixthCasingState())
                    .where('g', getSeventhCasingState())
                    .build());
            shapeInfo.add(builder
                    .where('Q', getBoilerCasingState())
                    .where('Y', getEighthCasingState())
                    .where('h', getFourthFrameState())
                    .where('I', getGlassState())
                    .build());
            shapeInfo.add(builder
                    .where('y', getNinthCasingState())
                    .where('Z', getBoilerCasingState())
                    .where('q', getEleventhCasingState())
                    .where('u', getUniqueCasingState())
                    .build());
            shapeInfo.add(builder
                    .where('z', getBoilerCasingState())
                    .where('U', getFifthFrameState())
                    .where('V', getTenthCasingState())
                    .where('v', getSecondBoilerCasingState())
                    .where('W', getNinthCasingState())
                    .where('w', getCoilState())
                    .build());
        }
        return shapeInfo;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.4"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.5"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.6"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.7"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.8"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.9"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.10"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.11"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.12"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.13"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.14"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.15"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.16"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.17"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.18"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.19"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.20"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.21"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.22"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.23"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.24"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.25"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.26"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.27"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.28"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.29"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.30"));
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    private class PCBFactoryRecipeLogic extends MultiblockRecipeLogic {

        public PCBFactoryRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        private int maxParallel() {
            return Math.min(4 * (GTUtility.getTierByVoltage(getMaxVoltage()) - EV), 64);
        }

        /**
         * @return Check if machine in Etching mode.
         */
        private boolean isEtchMode() {
            return getRecipeMap() == GTLiteRecipeMaps.PCB_FACTORY_ETCH_RECIPES;
        }

        /**
         * @return Check if machine in Bio mode.
         */
        private boolean isBioMode() {
            return getRecipeMap() == GTLiteRecipeMaps.PCB_FACTORY_BIO_RECIPES;
        }

        /**
         * @return Check if machine in Nano mode.
         */
        private boolean isNanoMode() {
            return getRecipeMap() == GTLiteRecipeMaps.PCB_FACTORY_NANO_RECIPES;
        }

        /**
         * @return Get parallel by auxiliaryUpgradeNumber, when auxiliary = 1, 3, 4, then return correspond parallel to recipe.
         */
        @Override
        public int getParallelLimit() {
            if (isEtchMode()) {
                if (auxiliaryUpgradeNumber == 1) { // T2
                    return maxParallel();
                } else {
                    return 1;
                }
            } else if (isBioMode()) {
                if (auxiliaryUpgradeNumber == 3) { // Bio Chamber
                    return maxParallel();
                } else {
                    return 1;
                }
            } else if (isNanoMode()) {
                if (auxiliaryUpgradeNumber == 4) { // T3
                    return  maxParallel();
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }

        /**
         * @param maxProgress Get redution by auxiliaryUpgradeNumber, when auxiliary = 2, 5, then get 1/4, 1/8 progress time.
         */
        @Override
        public void setMaxProgress(int maxProgress) {
            if (auxiliaryUpgradeNumber == 2) { // Water Cooling Tower
                this.maxProgressTime = maxProgress / 4;
            }
            if (auxiliaryUpgradeNumber == 5) { // Infinity Cooling Tower
                this.maxProgressTime = maxProgress / 8;
            }
        }
    }
}