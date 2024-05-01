package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregtech.api.GTValues;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.AbstractRecipeLogic;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.IMachineHatchMultiblock;
import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.*;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTUtility;
import gregtech.api.util.TextComponentUtil;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.ConfigHolder;
import gregtech.core.sound.GTSoundEvents;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockMetalCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 *  Plan of difficult TODO and FIXME
 *  @deprecated Maybe it does not have much impact because there are more powerful machines present...
 *
 *    <p>Redo machine hatch property, require 4 slots and 256 machine limit.</p>
 *
 *    <p>Maybe use Modular UI to create UI and redo internal private class</p>
 *
 *    ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 130 + 80).label(10, 5, this.getMetaFullName());
 *         builder.widget((new BlockableSlotWidget(this.machineHandler, 0, 81, 18, true, true))
 *                .setIsBlocked(this::isSlotBlocked)
 *                .setBackgroundTexture(new IGuiTexture[]{GuiTextures.SLOT}));
 *         builder.widget((new BlockableSlotWidget(this.machineHandler, 1, 81, 18 + 18, true, true))
 *                .setIsBlocked(this::isSlotBlocked)
 *                .setBackgroundTexture(new IGuiTexture[]{GuiTextures.SLOT}));
 *         builder.widget((new BlockableSlotWidget(this.machineHandler, 2, 81 + 18, 18, true, true))
 *                .setIsBlocked(this::isSlotBlocked)
 *                .setBackgroundTexture(new IGuiTexture[]{GuiTextures.SLOT}));
 *         builder.widget((new BlockableSlotWidget(this.machineHandler, 2, 81 + 18, 18 + 18, true, true))
 *                .setIsBlocked(this::isSlotBlocked)
 *                .setBackgroundTexture(new IGuiTexture[]{GuiTextures.SLOT}));
 *         return builder.bindPlayerInventory(entityPlayer.inventory, GuiTextures.SLOT, 7, 48)
 *         .build(this.getHolder(), entityPlayer);
 *
 *    <p>Then redo renderMetaTileEntity, use 4x Pipe overlay in @see{gregtech.client.renderer.texture}.</p>
 *
 *    <p>Another difficult problem in machine hatch is:</p>
 *    <p>No matter how you refactor, or even create a new machine limit,</p>
 *    <p>it seems impossible to read machines in slots with other indices!</p>
 *
 *    qwq
 */

@Deprecated
public class MetaTileEntityAdvancedProcessingArray extends RecipeMapMultiblockController implements IMachineHatchMultiblock {

    private final int tier;
    private boolean machineChanged;

    public MetaTileEntityAdvancedProcessingArray(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, null);
        this.tier = tier;
        this.recipeMapWorkable = new ProcessingArrayWorkable(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityAdvancedProcessingArray(metaTileEntityId, tier);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        ((MetaTileEntityAdvancedProcessingArray.ProcessingArrayWorkable)this.recipeMapWorkable).findMachineStack();
    }

    @Override
    public int getMachineLimit() {
        return this.tier == 0 ? 128 : 256;
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXX", "XXX", "XXX")
                .aisle("XXX", "X#X", "XXX")
                .aisle("XXX", "XSX", "XXX")
                .where('S', this.selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(4)
                        .or(autoAbilities(false, true, true, true, true, true, true))
                        .or(abilities(MultiblockAbility.INPUT_ENERGY)
                                .setMinGlobalLimited(1)
                                .setMaxGlobalLimited(4))
                        .or(abilities(MultiblockAbility.MACHINE_HATCH)
                                .setExactLimit(1)))
                .where('#', air())
                .build();
    }

    public IBlockState getCasingState() {
        return this.tier == 0 ? GTLiteMetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.HSS_S_CASING) : GTLiteMetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.EINSTEINIUM_CASING);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return this.tier == 0 ? GTLiteTextures.HSS_S_CASING : GTLiteTextures.EINSTEINIUM_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return Textures.ADVANCED_PROCESSING_ARRAY_OVERLAY;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        ProcessingArrayWorkable logic = (ProcessingArrayWorkable) this.recipeMapWorkable;
        MultiblockDisplayText.builder(textList, this.isStructureFormed())
                .setWorkingStatus(this.recipeMapWorkable.isWorkingEnabled(), this.recipeMapWorkable.isActive())
                .addEnergyUsageLine(this.recipeMapWorkable.getEnergyContainer())
                .addEnergyTierLine(logic.currentMachineStack == ItemStack.EMPTY ? -1 : logic.machineTier)
                .addCustom((tl) -> {
                    if (this.isStructureFormed()) {
                        ITextComponent maxMachinesTextx = TextComponentUtil.stringWithColor(TextFormatting.DARK_PURPLE, Integer.toString(this.getMachineLimit()));
                        ITextComponent maxMachinesText = TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.machine.machine_hatch.machines_max", maxMachinesTextx);
                        TextComponentTranslation bodyText;
                        TextComponentTranslation hoverText1;
                        if (logic.activeRecipeMap == null) {
                            ITextComponent noneText = TextComponentUtil.translationWithColor(TextFormatting.YELLOW, "gregtech.machine.machine_hatch.machines_none");
                            bodyText = TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.machine.machine_hatch.machines", noneText);
                            hoverText1 = TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.machine.machine_hatch.machines_none_hover");
                            tl.add(TextComponentUtil.setHover(bodyText, hoverText1, maxMachinesText));
                        } else {
                            String key = logic.getMachineStack().getTranslationKey();
                            bodyText = TextComponentUtil.translationWithColor(TextFormatting.DARK_PURPLE, key + ".name");
                            bodyText = TextComponentUtil.translationWithColor(TextFormatting.DARK_PURPLE, "%sx %s", logic.getParallelLimit(), bodyText);
                            hoverText1 = TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.machine.machine_hatch.machines", bodyText);
                            ITextComponent voltageName = new TextComponentString(GTValues.VNF[logic.machineTier]);
                            int amps = logic.getMachineStack().getCount();
                            String energyFormatted = TextFormattingUtil.formatNumbers(GTValues.V[logic.machineTier] * (long)amps);
                            ITextComponent hoverText = TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.machine.machine_hatch.machines_max_eut", new Object[]{energyFormatted, amps, voltageName});
                            tl.add(TextComponentUtil.setHover(hoverText1, hoverText, maxMachinesText));
                        }

                        if (this.isActive()) {
                            tl.add(TextComponentUtil.translationWithColor(TextFormatting.DARK_RED, "gregtech.machine.machine_hatch.locked", new Object[0]));
                        }
                    }})
                .addWorkingStatusLine()
                .addProgressLine(this.recipeMapWorkable.getProgressPercent());
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    public void notifyMachineChanged() {
        this.machineChanged = true;
    }

    @Override
    public String[] getBlacklist() {
        return ConfigHolder.machines.processingArrayBlacklist;
    }

    @Override
    public SoundEvent getBreakdownSound() {
        return GTSoundEvents.BREAKDOWN_MECHANICAL;
    }

    @Override
    public SoundEvent getSound() {
        return GTSoundEvents.ARC;
    }

    @Override
    public TraceabilityPredicate autoAbilities(boolean checkEnergyIn,
                                               boolean checkMaintenance,
                                               boolean checkItemIn,
                                               boolean checkItemOut,
                                               boolean checkFluidIn,
                                               boolean checkFluidOut,
                                               boolean checkMuffler) {
        TraceabilityPredicate predicate = super.autoAbilities(checkMaintenance, checkMuffler)
                .or(checkEnergyIn ? abilities(MultiblockAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(4).setPreviewCount(1) : new TraceabilityPredicate());
        predicate = predicate.or(abilities(MultiblockAbility.IMPORT_ITEMS).setPreviewCount(1));
        predicate = predicate.or(abilities(MultiblockAbility.EXPORT_ITEMS).setPreviewCount(1));
        predicate = predicate.or(abilities(MultiblockAbility.IMPORT_FLUIDS).setPreviewCount(1));
        predicate = predicate.or(abilities(MultiblockAbility.EXPORT_FLUIDS).setPreviewCount(1));
        return predicate;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.universal.tooltip.parallel", this.getMachineLimit()));
        tooltip.add(I18n.format("gtlitecore.machine.advanced_processing_array.tooltip"));

        if (tier == 0) {
            tooltip.add(I18n.format("gtlitecore.machine.extreme_processing_array.tooltip.1"));
        }

        if (tier == 1) {
            tooltip.add(I18n.format("gtlitecore.machine.ultimate_processing_array.tooltip.1"));
        }
    }

    @Override
    public int getItemOutputLimit() {
        ItemStack machineStack = ((ProcessingArrayWorkable) this.recipeMapWorkable).getMachineStack();
        MetaTileEntity mte = GTUtility.getMetaTileEntity(machineStack);
        return mte == null ? 0 : mte.getItemOutputLimit();
    }

    protected class ProcessingArrayWorkable extends MultiblockRecipeLogic {

        private static final ICleanroomProvider DUMMY_CLEANROOM = DummyCleanroom.createForAllTypes();
        ItemStack currentMachineStack;
        MetaTileEntity mte;
        private int machineTier;
        private long machineVoltage;
        private RecipeMap<?> activeRecipeMap;

        public ProcessingArrayWorkable(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
            this.currentMachineStack = ItemStack.EMPTY;
            this.mte = null;
        }

        @Override
        public void invalidate() {
            super.invalidate();
            if (this.mte != null && this.mte instanceof ICleanroomReceiver) {
                ((ICleanroomReceiver)this.mte).setCleanroom(null);
            }

            this.currentMachineStack = ItemStack.EMPTY;
            this.mte = null;
            MetaTileEntityAdvancedProcessingArray.this.machineChanged = true;
            this.machineTier = 0;
            this.machineVoltage = 0L;
            this.activeRecipeMap = null;
        }

        @Override
        public boolean isRecipeMapValid(RecipeMap<?> recipeMap) {
            return ArrayUtils.contains(((IMachineHatchMultiblock) this.metaTileEntity).getBlacklist(), recipeMap.getUnlocalizedName()) ? false : GTUtility.isMachineValidForMachineHatch(this.currentMachineStack, ((IMachineHatchMultiblock)this.metaTileEntity).getBlacklist());
        }

        @Override
        protected boolean shouldSearchForRecipes() {
            return this.canWorkWithMachines() && super.shouldSearchForRecipes();
        }

        public boolean canWorkWithMachines() {
            if (MetaTileEntityAdvancedProcessingArray.this.machineChanged) {
                this.findMachineStack();
                MetaTileEntityAdvancedProcessingArray.this.machineChanged = false;
                this.previousRecipe = null;
                if (MetaTileEntityAdvancedProcessingArray.this.isDistinct()) {
                    this.invalidatedInputList.clear();
                } else {
                    this.invalidInputsForRecipes = false;
                }
            }

            return !this.currentMachineStack.isEmpty() && this.activeRecipeMap != null;
        }

        public @Nullable RecipeMap<?> getRecipeMap() {
            return this.activeRecipeMap;
        }

        public void findMachineStack() {
            RecipeMapMultiblockController controller = (RecipeMapMultiblockController) this.metaTileEntity;
            ItemStack machine = (controller.getAbilities(MultiblockAbility.MACHINE_HATCH).get(0)).getStackInSlot(0);
            this.mte = GTUtility.getMetaTileEntity(machine);
            if (this.mte == null) {
                this.activeRecipeMap = null;
            } else {
                this.activeRecipeMap = this.mte.getRecipeMap();
                MetaTileEntityHolder holder = new MetaTileEntityHolder();
                this.mte = holder.setMetaTileEntity(this.mte);
                holder.setWorld(this.metaTileEntity.getWorld());
                MetaTileEntity var5 = this.mte;
                if (var5 instanceof ICleanroomReceiver receiver) {
                    if (ConfigHolder.machines.cleanMultiblocks) {
                        receiver.setCleanroom(DUMMY_CLEANROOM);
                    } else {
                        ICleanroomProvider provider = controller.getCleanroom();
                        if (provider != null) {
                            receiver.setCleanroom(provider);
                        }
                    }
                }
            }

            this.machineTier = this.mte instanceof ITieredMetaTileEntity ? ((ITieredMetaTileEntity)this.mte).getTier() : 0;
            this.machineVoltage = GTValues.V[this.machineTier];
            this.currentMachineStack = machine;
        }

        @Override
        public boolean checkRecipe(@Nonnull Recipe recipe) {
            if (this.mte == null) {
                return false;
            } else {
                AbstractRecipeLogic arl = this.mte.getRecipeLogic();
                if (arl == null) {
                    return false;
                } else {
                    return arl.checkRecipe(recipe) && super.checkRecipe(recipe);
                }
            }
        }

        @Override
        protected int getOverclockForTier(long voltage) {
            return super.getOverclockForTier(Math.min(this.machineVoltage, this.getMaximumOverclockVoltage()));
        }

        @Override
        public int getParallelLimit() {
            return this.currentMachineStack != null && !this.currentMachineStack.isEmpty() ? Math.min(this.currentMachineStack.getCount(), MetaTileEntityAdvancedProcessingArray.this.getMachineLimit()) : MetaTileEntityAdvancedProcessingArray.this.getMachineLimit();
        }

        @Override
        protected Recipe findRecipe(long maxVoltage,
                                    IItemHandlerModifiable inputs,
                                    IMultipleTankHandler fluidInputs) {
            return super.findRecipe(Math.min(super.getMaxVoltage(), this.machineVoltage), inputs, fluidInputs);
        }

        @Override
        public long getMaxVoltage() {
            return super.getMaximumOverclockVoltage();
        }

        @Override
        protected int getNumberOfOCs(int recipeEUt) {
            if (!this.isAllowOverclocking()) {
                return 0;
            } else {
                int recipeTier = Math.max(0, GTUtility.getTierByVoltage(recipeEUt / Math.max(1, this.parallelRecipesPerformed)));
                int maximumTier = Math.min(this.machineTier, GTUtility.getTierByVoltage(this.getMaxVoltage()));
                int numberOfOCs = maximumTier - recipeTier;
                if (recipeTier == 0) {
                    --numberOfOCs;
                }

                return numberOfOCs;
            }
        }

        private ItemStack getMachineStack() {
            return this.currentMachineStack;
        }

        /**
         * @deprecated This is just a compensation of advanced processing array, may be removed in the future.
         * @param maxProgress get max progress from tier.
         */
        @Deprecated
        public void setMaxProgress(int maxProgress) {
            if (tier == 0) {
                this.maxProgressTime = (int) (0.8 * maxProgress);
            }

            if (tier == 1) {
                this.maxProgressTime = (int) (0.5 * maxProgress);
            }
        }
    }
}