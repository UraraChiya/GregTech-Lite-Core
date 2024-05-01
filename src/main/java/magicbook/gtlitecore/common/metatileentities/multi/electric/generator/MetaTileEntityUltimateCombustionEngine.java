package magicbook.gtlitecore.common.metatileentities.multi.electric.generator;

import gregtech.api.GTValues;
import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.MultiblockFuelRecipeLogic;
import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.*;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.RelativeDirection;
import gregtech.api.util.TextComponentUtil;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockActiveUniqueCasing;
import magicbook.gtlitecore.common.blocks.BlockStructureCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class MetaTileEntityUltimateCombustionEngine extends FuelMultiblockController implements IProgressBarMultiblock {

    private final int tier;
    private boolean boostAllowed;

    public MetaTileEntityUltimateCombustionEngine(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, RecipeMaps.COMBUSTION_GENERATOR_FUELS, tier);
        this.recipeMapWorkable = new LargeCombustionEngineWorkableHandler(this);
        this.recipeMapWorkable.setMaximumOverclockVoltage(GTValues.V[tier]);
        this.tier = tier;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityUltimateCombustionEngine(metaTileEntityId, tier);
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        LargeCombustionEngineWorkableHandler recipeLogic = (LargeCombustionEngineWorkableHandler) this.recipeMapWorkable;
        MultiblockDisplayText.Builder builder = MultiblockDisplayText.builder(textList, this.isStructureFormed())
                .setWorkingStatus(recipeLogic.isWorkingEnabled(), recipeLogic.isActive())
                .addEnergyProductionLine(GTValues.V[tier + 1], recipeLogic.getRecipeEUt())
                .addFuelNeededLine(recipeLogic.getRecipeFluidInputInfo(), recipeLogic.getPreviousRecipeDuration())
                .addCustom((tl) -> {
                    if (this.isStructureFormed() && recipeLogic.isOxygenBoosted) {
                        tl.add(TextComponentUtil.translationWithColor(TextFormatting.AQUA, "gregtech.multiblock.large_combustion_engine.liquid_oxygen_boosted"));
                    }
                })
                .addWorkingStatusLine();
    }

    @Override
    protected void addErrorText(List<ITextComponent> textList) {
        super.addErrorText(textList);
        if (this.isStructureFormed()) {
            if (this.checkIntakesObstructed()) {
                textList.add(TextComponentUtil.translationWithColor(TextFormatting.RED, "gregtech.multiblock.large_combustion_engine.obstructed"));
                textList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.multiblock.large_combustion_engine.obstructed.desc"));
            }

            FluidStack lubricantStack = this.getInputFluidInventory().drain(Materials.Lubricant.getFluid(Integer.MAX_VALUE), false);
            if (lubricantStack == null || lubricantStack.amount == 0) {
                textList.add(TextComponentUtil.translationWithColor(TextFormatting.RED, "gregtech.multiblock.large_combustion_engine.no_lubricant"));
            }
        }

    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.universal.tooltip.base_production_eut", GTValues.V[this.tier]));
        tooltip.add(I18n.format("gregtech.universal.tooltip.uses_per_hour_lubricant", 1000));
        tooltip.add(I18n.format("gtlitecore.machine.ultimate_combustion_engine.tooltip.boost_ultimate", GTValues.V[this.tier] * 4L));
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXX", "XDX", "XXX")
                .aisle("XCX", "CGC", "XCX")
                .aisle("XCX", "CGC", "XCX")
                .aisle("AAA", "AYA", "AAA")
                .where('Y', this.selfPredicate())
                .where('X', states(getCasingState()))
                .where('G', states(getGearboxCasingState()))
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(3)
                        .or(autoAbilities(false, true, true, true, true, true, true)))
                .where('D', metaTileEntities(MultiblockAbility.REGISTRY.get(MultiblockAbility.OUTPUT_ENERGY).stream()
                        .filter(mte -> {
                            IEnergyContainer container = mte.getCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, null);
                            return container != null && container.getOutputVoltage() * container.getOutputAmperage() >= GTValues.V[tier];
                        })
                        .toArray(MetaTileEntity[]::new))
                        .addTooltip("gregtech.multiblock.pattern.error.limited.1", GTValues.VN[tier]))
                .where('A', states(getIntakeState())
                        .addTooltips("gregtech.multiblock.pattern.clear_amount_1"))
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.STRUCTURE_CASING.getState(BlockStructureCasing.StructureCasingType.NAQUADAH_CASING);
    }

    private static IBlockState getGearboxCasingState() {
        return GTLiteMetaBlocks.STRUCTURE_CASING.getState(BlockStructureCasing.StructureCasingType.NAQUADAH_GEARBOX_CASING);
    }

    private IBlockState getIntakeState() {
        return GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getState(BlockActiveUniqueCasing.ActiveCasingType.ULTIMATE_ENGINE_INTAKE_CASING);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.NAQUADAH_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.EXTREME_COMBUSTION_ENGINE_OVERLAY;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

    @Override
    public boolean isStructureObstructed() {
        return super.isStructureObstructed() || this.checkIntakesObstructed();
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        IEnergyContainer energyContainer = this.getEnergyContainer();
        this.boostAllowed = energyContainer != null && energyContainer.getOutputVoltage() >= GTValues.V[this.tier + 1];
    }

    private boolean checkIntakesObstructed() {
        for(int left = -1; left <= 1; ++left) {
            for(int up = -1; up <= 1; ++up) {
                if (left != 0 || up != 0) {
                    BlockPos checkPos = RelativeDirection.offsetPos(this.getPos(), this.getFrontFacing(), this.getUpwardsFacing(), this.isFlipped(), up, left, 1);
                    IBlockState state = this.getWorld().getBlockState(checkPos);
                    if (!state.getBlock().isAir(state, this.getWorld(), checkPos)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }

    public boolean isBoostAllowed() {
        return this.boostAllowed;
    }

    @Override
    public int getNumProgressBars() {
        return 3;
    }

    @Override
    public double getFillPercentage(int index) {
        int[] oxygenAmount;
        if (index == 0) {
            oxygenAmount = new int[2];
            if (this.getInputFluidInventory() != null) {
                MultiblockFuelRecipeLogic recipeLogic = (MultiblockFuelRecipeLogic) this.recipeMapWorkable;
                if (recipeLogic.getInputFluidStack() != null) {
                    FluidStack testStack = recipeLogic.getInputFluidStack().copy();
                    testStack.amount = Integer.MAX_VALUE;
                    oxygenAmount = this.getTotalFluidAmount(testStack, this.getInputFluidInventory());
                }
            }

            return oxygenAmount[1] != 0 ? 1.0 * (double) oxygenAmount[0] / (double) oxygenAmount[1] : 0.0;
        } else if (index == 1) {
            oxygenAmount = new int[2];
            if (this.getInputFluidInventory() != null) {
                oxygenAmount = this.getTotalFluidAmount(Materials.Lubricant.getFluid(Integer.MAX_VALUE), this.getInputFluidInventory());
            }

            return oxygenAmount[1] != 0 ? 1.0 * (double) oxygenAmount[0] / (double)oxygenAmount[1] : 0.0;
        } else {
            oxygenAmount = new int[2];
            if (this.getInputFluidInventory() != null && this.isBoostAllowed()) {
                FluidStack oxygenStack = Materials.Oxygen.getFluid(FluidStorageKeys.LIQUID, Integer.MAX_VALUE);
                oxygenAmount = this.getTotalFluidAmount(oxygenStack, this.getInputFluidInventory());
            }

            return oxygenAmount[1] != 0 ? 1.0 * (double) oxygenAmount[0] / (double) oxygenAmount[1] : 0.0;
        }
    }

    @Override
    public TextureArea getProgressBarTexture(int index) {
        if (index == 0) {
            return GuiTextures.PROGRESS_BAR_LCE_FUEL;
        } else {
            return index == 1 ? GuiTextures.PROGRESS_BAR_LCE_LUBRICANT : GuiTextures.PROGRESS_BAR_LCE_OXYGEN;
        }
    }

    @Override
    public void addBarHoverText(List<ITextComponent> hoverList, int index) {
        if (index == 0) {
            this.addFuelText(hoverList);
        } else {
            int oxygenStored;
            int oxygenCapacity;
            TextComponentString oxygenInfo;
            if (index == 1) {
                oxygenStored = 0;
                oxygenCapacity = 0;
                if (this.isStructureFormed() && this.getInputFluidInventory() != null) {
                    int[] lubricantAmount = this.getTotalFluidAmount(Materials.Lubricant.getFluid(Integer.MAX_VALUE), this.getInputFluidInventory());
                    oxygenStored = lubricantAmount[0];
                    oxygenCapacity = lubricantAmount[1];
                }

                oxygenInfo = TextComponentUtil.stringWithColor(TextFormatting.GOLD, TextFormattingUtil.formatNumbers(oxygenStored) + " / " + TextFormattingUtil.formatNumbers(oxygenCapacity) + " L");
                hoverList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.multiblock.large_combustion_engine.lubricant_amount", oxygenInfo));
            } else if (this.isBoostAllowed()) {
                oxygenStored = 0;
                oxygenCapacity = 0;
                if (this.isStructureFormed() && this.getInputFluidInventory() != null) {
                    FluidStack oxygenStack = Materials.Oxygen.getFluid(FluidStorageKeys.LIQUID, Integer.MAX_VALUE);
                    int[] oxygenAmount = this.getTotalFluidAmount(oxygenStack, this.getInputFluidInventory());
                    oxygenStored = oxygenAmount[0];
                    oxygenCapacity = oxygenAmount[1];
                }

                oxygenInfo = TextComponentUtil.stringWithColor(TextFormatting.AQUA, TextFormattingUtil.formatNumbers(oxygenStored) + " / " + TextFormattingUtil.formatNumbers(oxygenCapacity) + " L");
                hoverList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.multiblock.large_combustion_engine.liquid_oxygen_amount", oxygenInfo));
            } else {
                hoverList.add(TextComponentUtil.translationWithColor(TextFormatting.YELLOW, "gregtech.multiblock.large_combustion_engine.liquid_oxygen_boost_disallowed"));
            }
        }

    }

    private static class LargeCombustionEngineWorkableHandler extends MultiblockFuelRecipeLogic {

        private boolean isOxygenBoosted = false;
        private final MetaTileEntityUltimateCombustionEngine combustionEngine;
        private final int tier;
        private static final FluidStack LIQUID_OXYGEN_STACK = Materials.Oxygen.getFluid(FluidStorageKeys.LIQUID, 140);
        private static final FluidStack LUBRICANT_STACK = Materials.Lubricant.getFluid(1);

        public LargeCombustionEngineWorkableHandler(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
            this.combustionEngine = (MetaTileEntityUltimateCombustionEngine) tileEntity;
            this.tier = 6;
        }

        @Override
        protected void updateRecipeProgress() {
            if (this.canRecipeProgress && this.drawEnergy(this.recipeEUt, true)) {
                this.drainLubricant();
                this.drainOxygen();
                this.drawEnergy(this.recipeEUt, false);
                if (++this.progressTime > this.maxProgressTime) {
                    this.completeRecipe();
                }
            }
        }

        protected void checkOxygen() {
            if (this.combustionEngine.isBoostAllowed()) {
                IMultipleTankHandler inputTank = this.combustionEngine.getInputFluidInventory();
                FluidStack boosterStack = LIQUID_OXYGEN_STACK;
                this.isOxygenBoosted = boosterStack.isFluidStackIdentical(inputTank.drain(boosterStack, false));
            }
        }

        protected void drainOxygen() {
            if (this.isOxygenBoosted && this.totalContinuousRunningTime % 20L == 0L) {
                FluidStack boosterStack = LIQUID_OXYGEN_STACK;
                this.combustionEngine.getInputFluidInventory().drain(boosterStack, true);
            }
        }

        protected boolean checkLubricant() {
            IMultipleTankHandler inputTank = this.combustionEngine.getInputFluidInventory();
            if (LUBRICANT_STACK.isFluidStackIdentical(inputTank.drain(LUBRICANT_STACK, false))) {
                return true;
            } else {
                this.invalidate();
                return false;
            }
        }

        protected void drainLubricant() {
            if (this.totalContinuousRunningTime == 1L || this.totalContinuousRunningTime % 72L == 0L) {
                IMultipleTankHandler inputTank = this.combustionEngine.getInputFluidInventory();
                inputTank.drain(LUBRICANT_STACK, true);
            }

        }

        @Override
        protected boolean shouldSearchForRecipes() {
            this.checkOxygen();
            return super.shouldSearchForRecipes() && this.checkLubricant();
        }

        @Override
        protected boolean canProgressRecipe() {
            return super.canProgressRecipe() && this.checkLubricant();
        }

        @Override
        public long getMaxVoltage() {
            return this.isOxygenBoosted ? GTValues.V[this.tier] * 2L : GTValues.V[this.tier];
        }

        @Override
        protected long boostProduction(long production) {
            if (this.isOxygenBoosted) {
                return production * 2L;
            } else {
                return production;
            }
        }

        @Override
        public void invalidate() {
            this.isOxygenBoosted = false;
            super.invalidate();
        }
    }
}
