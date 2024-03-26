package magicbook.gtlitecore.api.recipe;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.builders.BlastRecipeBuilder;
import gregtech.api.recipes.builders.FuelRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import magicbook.gtlitecore.api.recipe.builder.*;
import magicbook.gtlitecore.api.recipe.machines.*;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenProperty;

import java.util.function.Consumer;

/**
 * Recipe Maps
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is the basic class of gtlitecore recipe maps.
 *     Has same zen class name as {@link RecipeMaps}, but some function maybe error.
 * </p>
 *
 * <p>
 *     Another hint is examples and notes in this class is not for ZenScript (CraftTweaker),
 *     these descriptions are for java, so if you want create a addition mod of gtlitecore,
 *     then you can read and learn it (maybe needs some basic tutorials).
 * </p>
 *
 * @since 2.8.7-beta
 */
@ZenExpansion("mods.gregtech.recipe.RecipeMaps")
@ZenRegister
public class GTLiteRecipeMaps {

    //////////////////////////////////
    //  Single Machine Recipe Maps  //
    /////////////////////////////////

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.CHEMICAL_DRYER_RECIPES.recipeBuilder()
     *          .input(OrePrefix.dust, Materials.Naquadria)
     *          .fluidInputs(GTLiteMaterials.Orichalcum.getFluid(1000))
     *          .output(OrePrefix.dust, Materials.Naquadah, 2)
     *          .fluidOutputs(GTLiteMaterials.Bedrock.getFluid(1000))
     *          .EUt(VA[EV])
     *          .duration(1200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     This is a basic example about how to create a chemical dryer recipes.
     *     Pay attention, this machine's recipe map is not like the same name machine's recipe map in
     *      <a href="https://github.com/GregTechCEu/gregicality-legacy">Gregicality</a>,
     *     so do not use so many inputs or outputs.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> CHEMICAL_DRYER_RECIPES = new RecipeMap<>("chemical_dryer_recipes", 1, 2, 1, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSoundEvents.FURNACE);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES.recipeBuilder()
     *          .notConsumable(GTLiteMetaItems.MINING_DRONE_LV.getStackForm(2))
     *          .input(OrePrefix.String, Materials.Bronze)
     *          .fluidInputs(Materials.Helium.getFluid(FluidStorageKeys.LIQUID, 1000))
     *          .output(MetaItems.COIN_CHOCOLATE, 2)
     *          .EUt((int) (V[OpV]))
     *          .duration(Materials.Bronze.getMass() * 16)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Vacuum Chamber is a special machine in gtlitecore, this machine has steam and high pressure steam version,
     *     so you can create steam stage recipes by custom numbers below LV in .EUt() method.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> VACUUM_CHAMBER_RECIPES = new RecipeMap<>("vacuum_chamber_recipes", 4, 1, 2, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES.recipeBuilder()
     *          .fluidInputs(Materials.NaquadahEnriched)
     *          .EUt(3356)
     *          .duration(124)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Naquadah Reactor recipe map, if you add some fuel recipes, you should add it in your config,
     *     same like fuel's heat value tweak config in
     *      {@link magicbook.gtlitecore.common.GTLiteConfigHolder#misc}
     *     of cause, this is just some QoL settings.
     *     Because this is the first generator recipe map, so maybe something should be warning:
     *     do not use negative energy consume (if not, then your generator fuel cannot emitted energy).
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> NAQUADAH_REACTOR_RECIPES = new RecipeMap<>("naquadah_reactor_recipes", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COMBUSTION)
            .allowEmptyOutput();

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.ROCKET_ENGINE_RECIPES.recipeBuilder()
     *          .fluidInputs(Materials.Helium.getFluid(FluidStorageKeys.LIQUID, L / 4))
     *          .EUt(VHA[IV])
     *          .duration(15)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Another liquid-only generator, rocket engine, you should add it in your config,
     *     same like fuel's heat value tweak config in
     *      {@link magicbook.gtlitecore.common.GTLiteConfigHolder#misc}
     *     of cause, this is just some QoL settings.
     *     In example, this symbol 'L' is {@link GTValues#L}, it means 144.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> ROCKET_ENGINE_RECIPES = new RecipeMap<>("rocket_engine_recipes", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
            .setSound(GTSoundEvents.COMBUSTION)
            .allowEmptyOutput();

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.BIO_REACTOR_RECIPES.recipeBuilder()
     *          .circuitMeta(1)
     *          .fluidInputs(Materials.Biomass.getFluid(L * 4))
     *          .fluidInputs(Materials.Lava.getFluid(L * 2))
     *          .output(OrePrefix.dust, Materials.Obsidian, 4)
     *          .fluidOutputs(Materials.Water.getFluid(L * 2))
     *          .EUt(VH[ZPM])
     *          .duration(1200)
     *          .cleanroom(CleanroomType.CLEANROOM)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Port from the same name machine in
     *      <a href="https://github.com/GTNewHorizons/bartworks">Bartworks</a>,
     *     but recipe style like Bio Reactor in
     *      <a href="https://github.com/GregTechCEu/gregicality-legacy">Gregicality</a>.
     *     This machine use a special GUI texture, please see {@link GTLiteGuiTextures#DISH_OVERLAY},
     *     this texture is just a petri dish icon.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> BIO_REACTOR_RECIPES = new RecipeMap<>("bio_reactor_recipes", 6, 1, 3, 2, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(false, false, true, GTLiteGuiTextures.DISH_OVERLAY)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.CONDENSER_RECIPES.recipeBuilder()
     *          .input(OrePrefix.block, Materials.Gold)
     *          .output(GTLiteOrePrefix.singularity, Materials.Gold)
     *          .EUt(VA[IV])
     *          .duration(800)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     For singularity processing, this recipe map is just a simple recipe map.
     *     But we use a new method to init its recipes, please see {@link magicbook.gtlitecore.loaders.multiblock.Condenser}.
     *     Please use {@link magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix#singularity} for outputs.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> CONDENSER_RECIPES = new RecipeMap<>("condenser_recipes", 1, 1, 1, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.BOX_OVERLAY)
            .setSound(GTSoundEvents.COMPRESSOR);

    //////////////////////////////////////
    //  Multiblock Machine Recipe Maps  //
    //////////////////////////////////////

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.DRILLING_RECIPES.recipeBuilder()
     *          .input(new ItemStack(Blocks.BEDROCK))
     *          .chancedOutput(OrePrefix.dust, GTLiteMaterials.Bedrock, 5000, 500)
     *          .fluidOutputs(GTLiteMaterials.BedrockSmoke.getFluid(16000))
     *          .duration(200)
     *          .EUt(VA[UEV])
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     This recipe map is for {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityIndustrialDrillingRig}.
     *     Pay attention, this multiblock machine has a special check, so please use block in input,
     *     this machine will break the block which below the drill head block in structures.
     *     If you use not consumable input, then drill head in this multiblock will not break the below block,
     *     for the example, please see: {@link magicbook.gtlitecore.loaders.oreprocessing.TaraniumProcessing}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DRILLING_RECIPES = new RecipeMap<>("drill_recipes", 1, 1, 0, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSoundEvents.MACERATOR);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.CATALYTIC_REFORMER_RECIPES.recipeBuilder()
     *          .notConsumable(OrePrefix.plate, Materials.Neutronium)
     *          .fluidInputs(GTLiteMaterials.Spacetime.getFluid(48000))
     *          .fluidOutputs(GTLiteMaterials.Infinity.getFluid(8000))
     *          .fluidOutputs(GTLiteMaterials.Hypogen.getFluid(12000))
     *          .fluidOutputs(GTLiteMaterials.Rhugnor.getFluid(14000))
     *          .fluidOutputs(GTLiteMaterials.CrystalMatrix.getFluid(14000))
     *          .duration(200)
     *          .EUt(VA[UEV])
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Just simple recipe map, catalyst form is plate in not consumable input in same situation.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> CATALYTIC_REFORMER_RECIPES = new RecipeMap<>("catalytic_reformer_recipes", 1, 0, 1, 4, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRACKING, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.SONICATION_RECIPES.recipeBuilder()
     *          .fluidInputs(GTLiteMaterials.Blood.getFluid(64000))
     *          .fluidOutputs(GTLiteMaterials.BloodCells.getFluid(16000))
     *          .fluidOutputs(GTLiteMaterials.BloodPlasma.getFluid(16000))
     *          .EUt(VA[ZPM])
     *          .duration(200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Just simple recipe map, used for some biological processing common,
     *     such as Blood processing in {@link magicbook.gtlitecore.loaders.circuits.GoowareCircuits}.
     *     This recipe map has a special overlay {@link GTLiteGuiTextures#FOIL_OVERLAY},
     *     because is used for cycle Phosphorene foil in {@link magicbook.gtlitecore.loaders.chains.KevlarChain}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> SONICATION_RECIPES = new RecipeMap<>("sonication_recipes", 0, 1, 2, 2, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, true, false, GuiTextures.BREWER_OVERLAY)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSlotOverlay(true, false, true, GTLiteGuiTextures.FOIL_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.CENTRIFUGE);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.MOLECULAR_BEAM_RECIPES.recipeBuilder()
     *          .input(OrePrefix.foil, Materials.Nickel, 8)
     *          .input(OrePrefix.dust, Materials.Boron)
     *          .fluidInputs(Materials.Nitrogen.getFluid(1000))
     *          .output(OrePrefix.gem, GTLiteMaterials.HexagonalBoronNitride, 2)
     *          .EUt(VA[UEV])
     *          .duration(80)
     *          .temperature(2900)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Please see {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityNanoscaleFabricator},
     *     this machine has a special check, though we use {@link NoCoilTemperatureRecipeBuilder}, this machine still check temperature when run recipes,
     *     the current temperature dependencies to temperature info in {@link magicbook.gtlitecore.common.blocks.BlockCrucible}.
     *     And this recipe map has a special overlay {@link GTLiteGuiTextures#NANOSCALE_OVERLAY_1} and {@link GTLiteGuiTextures#NANOSCALE_OVERLAY_2},
     *     these pictures are same, but one used for item, one used for fluid.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> MOLECULAR_BEAM_RECIPES = new RecipeMap<>("molecular_beam_recipes", 6, 1, 2,  0, new NoCoilTemperatureRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GTLiteGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(false, false, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(false, true, false, GTLiteGuiTextures.NANOSCALE_OVERLAY_2)
            .setSlotOverlay(false, true, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_2)
            .setSlotOverlay(true, false, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(true, true, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_2)
            .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_NANOSCALE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ELECTROLYZER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
     *          .input(OrePrefix.dust, Materials.Quicklime, 2)
     *          .input(OrePrefix.dust, Materials.Carbon, 3)
     *          .output(OrePrefix.dust, Materials.CalciumCarbide, 3)
     *          .fluidOutputs(Materials.CarbonMonoxide.getFluid(1000))
     *          .EUt(VA[MV])
     *          .duration(500)
     *          .temperature(2473)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Used for {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityIndustrialRoaster},
     *     this machine get temperature by {@link gregtech.common.blocks.BlockFireboxCasing} via a special traceability predicate,
     *     please see {@link magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate#FIRE_BOX}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> INDUSTRIAL_ROASTER_RECIPES = new RecipeMap<>("industrial_roaster_recipes", 3, 3, 3,  3, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.CRYSTALLIZATION_RECIPES.recipeBuilder()
     *          .input(OrePrefix.dust, CubicZirconia, 64)
     *          .input(OrePrefix.dust, Europium, 8)
     *          .output(GTLiteMetaItems.CUBIC_ZIRCONIA_EUROPIUM_BOULE)
     *          .EUt(VA[MV])
     *          .duration(120)
     *          .blastFurnaceTemp(3000)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     This recipe map is actually unused in the same situation,
     *     just create some special boule (like {@link magicbook.gtlitecore.common.items.GTLiteMetaItems#STRONTIUM_CARBONATE_BOHRIUM_BOULE}) recipes,
     *     because recipe handler {@link magicbook.gtlitecore.loaders.handlers.BouleRecipeHandler} generates all recipes (if gem has components).
     *     If you want to add crystal seed/boule recipes, then you can add a special flags for your material,
     *     please see {@link magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialFlags#GENERATE_BOULE},
     *     if you do not wan to add, then use {@link magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialFlags#DISABLE_CRYSTALLIZATION}.
     *     This recipe can auto-calculate temperature by components' temperature and amount (if not, then get common temperature like cupronickel coil),
     *     this machine support new coil block in gtlitecore, so you should pay attention for the component temperature (sometime cause some problem).
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<BlastRecipeBuilder> CRYSTALLIZATION_RECIPES = new RecipeMap<>("crystallization_recipes", 6, 1, 3, 0, new BlastRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.CVD_UNIT_RECIPES.recipeBuilder()
     *          .inputs(GTFOMaterialHandler.LithiumCarbonate.getItemStack(6))
     *          .fluidInputs(GTLiteMaterials.CalciumTrifluoromethansulphonate.getFluid(1000))
     *          .output(dust, GTLiteMaterials.LithiumTrifluoromethansulphonate, 18)
     *          .output(dust, GTLiteMaterials.CalciumCarbonate, 5)
     *          .EUt(VA[EV])
     *          .duration(340)
     *          .temperature(1600)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Recipe map for CVD Unit, temperature is just a little tweak about recipe map GUI in JEI,
     *     this parameter not affected recipe check.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> CVD_UNIT_RECIPES = new RecipeMap<>("cvd_unit_recipes", 2, 2, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.PLASMA_CVD_UNIT_RECIPES.recipeBuilder()
     *          .notConsumable(OrePrefix.plate, Materials.Rhenium)
     *          .fluidInputs(GTLiteMaterials.Acetylene.getFluid(3000))
     *          .fluidInputs(GTLiteMaterials.Cycloparaphenylene.getFluid(7000))
     *          .fluidInputs(Materials.Nitrogen.getPlasma(10000))
     *          .output(OrePrefix.ingot, GTLiteMaterials.CarbonNanotube)
     *          .fluidOutputs(Materials.Ammonia.getFluid(10000))
     *          .EUt(VA[UV])
     *          .duration(100)
     *          .temperature(993)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Plasma CVD Unit recipe is for some nanotube recipes now,
     *     please see {@link magicbook.gtlitecore.loaders.chains.NanotubesChain}.
     *     You should use different catalyst (usually use plate or double plate) to create recipes,
     *     if not, then will cause conflicts (not warning in log, but cannot run in game).
     *     This machine's recipes have advanced version all, if use plate catalyst,
     *     then use double plate catalyst in advanced recipe,
     *     and x4 recipe consumes and products (of cause energy use, or you not want this).
     *     TODO use {@link RecipeMap#onRecipeBuild(Consumer)} to tweak this recipe map be advanced version of cvd unit recipes.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> PLASMA_CVD_UNIT_RECIPES = new RecipeMap<>("plasma_cvd_unit_recipes", 2, 2, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.LASER_CVD_UNIT_RECIPES.recipeBuilder()
     *          .input(OrePrefix.wireFine, GTLiteMaterials.SuperheavyHAlloy, 8)
     *          .input(OrePrefix.plate, GTLiteMaterials.Rhugnor)
     *          .fluidInputs(GTLiteMaterials.Zylon.getFluid(L * 2))
     *          .output(GTLiteMetaItems.COSMIC_CAPACITOR, 32)
     *          .EUt(VA[UEV])
     *          .duration(160)
     *          .temperature(5630)
     *          .cleanroom(CleanroomType.CLEANROOM)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Used for some advanced smd capacitor recipes (above gooware circuit),
     *     such as {@link magicbook.gtlitecore.loaders.circuits.OpticalCircuits},
     *     and some special materials (like optical fiber, please see {@link magicbook.gtlitecore.common.items.GTLiteMetaItems#OPTICAL_FIBER}).
     *     Sometimes recipes need use cleanroom and temperature both, in this situation, please put cleanroom at the last (for consistency of JEI pages).
     *     TODO use {@link RecipeMap#onRecipeBuild(Consumer)} to tweak this recipe map be advanced version of cvd unit recipes.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> LASER_CVD_UNIT_RECIPES = new RecipeMap<>("laser_cvd_unit_recipes", 2, 2, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.BURNER_REACTOR_RECIPES.recipeBuilder()
     *          .notConsumable(OrePrefix.dust, Materials.Silver)
     *          .fluidInputs(Materials.Ethylene.getFluid(7000))
     *          .fluidOutputs(GTLiteMaterials.EthyleneOxide.getFluid(6000))
     *          .fluidOutputs(Materials.CarbonDioxide.getFluid(2000))
     *          .fluidOutputs(Materials.Water.getFluid(2000))
     *          .EUt(VA[HV])
     *          .duration(150)
     *          .temperature(450)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Different to {@link GTLiteRecipeMaps#INDUSTRIAL_ROASTER_RECIPES}, this recipe map do not check temperature.
     *     This parameter is just a tweak of JEI info, so you can add anythings (do not exceed max value of Integer).
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> BURNER_REACTOR_RECIPES = new RecipeMap<>("burner_reactor_recipes", 3, 3, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.CRYOGENIC_REACTOR_RECIPES.recipeBuilder()
     *          .notConsumable(OrePrefix.dust, Materials.Iron)
     *          .fluidInputs(Materials.Butadiene.getFluid(1000))
     *          .fluidInputs(GTLiteMaterials.Acrylonitrile.getFluid(1000))
     *          .notConsumable(GTLiteMaterials.HydrogenPeroxide.getFluid(1))
     *          .fluidOutputs(GTLiteMaterials.NitrileButadieneRubber.getFluid(1000))
     *          .EUt(VA[LuV])
     *          .duration(200)
     *          .temperature(286)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Same as {@link GTLiteRecipeMaps#BURNER_REACTOR_RECIPES}, just a low temperature version,
     *     but please do not use high temperature in this recipes (if not, so why do not you use Burner Reactor recipe map).
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> CRYOGENIC_REACTOR_RECIPES = new RecipeMap<>("cryogenic_reactor_recipes", 3, 2, 3, 2, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> FUEL_REFINE_FACTORY_RECIPES = new RecipeMap<>("fuel_refine_factory_recipes", 3, 4, 4, 2, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
            .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.CHEMICAL_REACTOR);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK1_RECIPES = new RecipeMap<>("hyper_reactor_mk1_recipes", 0, 0, 1,0 , new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC)
            .allowEmptyOutput();

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK2_RECIPES = new RecipeMap<>("hyper_reactor_mk2_recipes", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC)
            .allowEmptyOutput();

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK3_RECIPES = new RecipeMap<>("hyper_reactor_mk3_recipes", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC)
            .allowEmptyOutput();

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.ISA_MILL_RECIPES.recipeBuilder()
     *          .input(OrePrefix.ore, Materials.Almandine, 16)
     *          .circuitMeta(10)
     *          .output(GTLiteOrePrefix.milled, Materials.Almandine, 64)
     *          .output(GTLiteOrePrefix.milled, Materials.Almandine, 32)
     *          .EUt(VA[EV])
     *          .duration(2400)
     *          .grindBallTier(2)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Related to the special ore prefix {@link magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix#milled},
     *     this recipe map has a special property: grindball (please see {@link magicbook.gtlitecore.common.items.GTLiteMetaItems#GRINDBALL_ALUMINIUM}
     *     and {@link magicbook.gtlitecore.common.items.GTLiteMetaItems#GRINDBALL_SOAPSTONE}).
     *     Please use 1 or 2 to tweak grindball material (one correspond soapstone and another correspond to aluminium).
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<GrindBallRecipeBuilder> ISA_MILL_RECIPES = new RecipeMap<>("isa_mill_recipes", 3, 3, 0, 0, new GrindBallRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.MACERATOR);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> FLOTATION_RECIPES = new RecipeMap<>("flotation_recipes", 6, 0, 1, 1, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.BATH);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<BlastRecipeBuilder> VACUUM_DRYING_RECIPES = new RecipeMap<>("vacuum_drying_recipes", 1, 9, 2, 0, new BlastRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, false, false, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSound(GTSoundEvents.FURNACE);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DRONE_AIRPORT_RECIPES = new RecipeMap<>("drone_airport_recipes", 2, 9, 1, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSound(GTSoundEvents.COMPUTATION);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> ION_IMPLANTATOR_RECIPES = new RecipeMap<>("ion_implantator_recipes", 3, 1, 1, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ELECTROLYZER);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<AssemblyCasingTierRecipeBuilder> PRECISE_ASSEMBLER_RECIPES = new RecipeMapPreciseAssembler<>("precise_assembler_recipes", 4, 1, 4, 0, new AssemblyCasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> COMPONENT_ASSEMBLER_RECIPES = new RecipeMap<>("component_assembler_recipes", 6, 1, 1, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<ComponentCasingTierRecipeBuilder> COMPONENT_ASSEMBLY_LINE_RECIPES = new RecipeMapComponentAssemblyLine<>("component_assembly_line_recipes", 12, 1, 12, 0, new ComponentCasingTierRecipeBuilder(), false)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> TREE_GROWTH_RECIPES = new RecipeMap<>("tree_growth_recipes", 2, 4, 2, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSound(GTSoundEvents.CHAINSAW_TOOL);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FieldCasingTierRecipeBuilder> COLLIDER_RECIPES = new RecipeMap<>("collider_recipes", 6, 6, 6, 6, new FieldCasingTierRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, false, false, GuiTextures.IMPLOSION_OVERLAY_1)
            .setSlotOverlay(true, false, true, GuiTextures.IMPLOSION_OVERLAY_1)
            .setSound(GTSoundEvents.ELECTROLYZER);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DIMENSIONAL_OSCILLATOR_RECIPES = new RecipeMap<>("dimensional_oscillator_recipes", 3, 3, 3, 3, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(true, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, true, false, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSound(GTSoundEvents.SCIENCE);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<NoCoilHigherTemperatureRecipeBuilder> STELLAR_FURNACE_RECIPES = new RecipeMap<>("stellar_furnace_recipes", 6, 6, 6, 6, new NoCoilHigherTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MASS_FAB, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSound(GTSoundEvents.FURNACE);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PLASMA_CONDENSER_RECIPES = new RecipeMap<>("plasma_condenser_recipes", 3, 3, 3, 3, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_REPLICATOR, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FieldCasingTierRecipeBuilder> DECAY_GENERATOR_RECIPES = new RecipeMap<>("decay_generator_recipes", 1, 1, 1, 1, new FieldCasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_HAMMER, ProgressWidget.MoveType.VERTICAL_DOWNWARDS)
            .setSound(GTSoundEvents.SCIENCE);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> SUPRACHRONAL_ASSEMBLY_LINE_RECIPES = new RecipeMapSuprachronalAssemblyLine<>("suprachronal_assembly_line_recipes", 16, 1, 4, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, GuiTextures.BOX_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ASSEMBLY_LINE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.REPLICATOR);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SpaceElevatorCasingTierRecipeBuilder> SPACE_ELEVATOR_DRILLING_MODULE = new RecipeMap<>("space_elevator_drilling_module", 2, 0, 1, 1, new SpaceElevatorCasingTierRecipeBuilder(), false)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_SPACE_ELEVATOR_DRILLING_MODULE, ProgressWidget.MoveType.VERTICAL)
            .setSound(GTSoundEvents.DRILL_TOOL);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SpaceElevatorCasingTierRecipeBuilder> SPACE_ELEVATOR_MINING_MODULE = new RecipeMap<>("space_elevator_mining_module", 4, 9, 2, 0, new SpaceElevatorCasingTierRecipeBuilder(), false)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_SPACE_ELEVATOR_MINING_MODULE, ProgressWidget.MoveType.VERTICAL)
            .setSound(GTSoundEvents.MINER);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SpaceElevatorCasingTierRecipeBuilder> SPACE_ELEVATOR_ASSEMBLING_MODULE = new RecipeMapSuprachronalAssemblyLine<>("space_elevator_assembling_module", 16, 1, 4, 0, new SpaceElevatorCasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ASSEMBLY_LINE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMapPseudoGroup<SimpleRecipeBuilder> PROCESSING_MODE_A = new RecipeMapPseudoGroup<>("processing_mode_a", 1, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.COMPRESSOR_RECIPES, RecipeMaps.LATHE_RECIPES, RecipeMaps.POLARIZER_RECIPES, true);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMapPseudoGroup<SimpleRecipeBuilder> PROCESSING_MODE_B = new RecipeMapPseudoGroup<>("processing_mode_b", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.FERMENTING_RECIPES, RecipeMaps.EXTRACTOR_RECIPES, RecipeMaps.CANNER_RECIPES, true);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMapPseudoGroup<SimpleRecipeBuilder> PROCESSING_MODE_C  = new RecipeMapPseudoGroup<>("processing_mode_c", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.LASER_ENGRAVER_RECIPES, RecipeMaps.AUTOCLAVE_RECIPES, RecipeMaps.FLUID_SOLIDFICATION_RECIPES, true);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> MOLECULAR_TRANSFORMER_RECIPES = new RecipeMap<>("molecular_transformer_recipes", 1, 1, 0, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(true, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.SCIENCE);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<AltitudeRecipeBuilder> COSMIC_RAY_DETECTOR_RECIPES = new RecipeMap<>("cosmic_ray_detector_recipes", 4, 4, 2, 2, new AltitudeRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MASS_FAB, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PCB_FACTORY_ETCH_RECIPES = new RecipeMap<>("pcb_factory_etch_recipes", 6, 1, 3, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PCB_FACTORY_BIO_RECIPES = new RecipeMap<>("pcb_factory_bio_recipes", 6, 1, 3, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PCB_FACTORY_NANO_RECIPES = new RecipeMap<>("pcb_factory_nano_recipes", 6, 1, 3, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(true, false, true, GuiTextures.SCANNER_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> NEUTRAL_NETWORK_NEXUS_BREEDING_MODE = new RecipeMap<>("neutral_network_nexus_breeding_mode", 6, 6, 3, 3, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> NEUTRAL_NETWORK_NEXUS_HYBRIDIZING_MODE = new RecipeMap<>("neutral_network_nexus_hybridizing_mode", 6, 6, 3, 3, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FieldCasingTierRecipeBuilder> QUANTUM_FORCE_TRANSFORMER_RECIPES = new RecipeMap<>("quantum_force_transformer_recipes", 6, 6, 6, 6, new FieldCasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> TURBINE_MIXER_RECIPES = new RecipeMapTurbineMixer<>("turbine_mixer_recipes", 9, 1, 6, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.DUST_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressWidget.MoveType.CIRCULAR)
            .setSound(GTSoundEvents.MIXER);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FlowRateRecipeBuilder> HEAT_EXCHANGE_RECIPES = new RecipeMapHeatExchanger<>("heat_exchanger_recipes", 0, 0, 2, 3, new FlowRateRecipeBuilder(), false)
            .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_HEAT_EXCHANGE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.BATH);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HIGH_PRESSURE_STEAM_TURBINE_RECIPES = new RecipeMap<>("high_pressure_steam_turbine_recipes", 0, 0, 1, 1, new FuelRecipeBuilder(), false)
            .setSlotOverlay(false, true, true, GuiTextures.DARK_CANISTER_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, ProgressWidget.MoveType.HORIZONTAL)
            .allowEmptyOutput()
            .setSound(GTSoundEvents.TURBINE);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> SUPERCRITICAL_STEAM_TURBINE_RECIPES = new RecipeMap<>("supercritical_steam_turbine_recipes", 0, 0, 1, 1, new FuelRecipeBuilder(), false)
            .setSlotOverlay(false, true, true, GuiTextures.DARK_CANISTER_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, ProgressWidget.MoveType.HORIZONTAL)
            .allowEmptyOutput()
            .setSound(GTSoundEvents.TURBINE);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> BIOWARE_SIMULATOR_RECIPES = new RecipeMap<>("bioware_simulator_recipes", 2, 2, 2, 2, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.DATA_ORB_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.FILTER_SLOT_OVERLAY)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.SCIENCE);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> SIMULATOR_RECIPES = new RecipeMap<>("simulator_recipes", 2, 2, 0, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.SCIENCE);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> NANO_SCALE_MASK_ALIGNER_RECIPES = new RecipeMap<>("nano_scale_mask_aligner_recipes", 4, 2, 2, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.LENS_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.LENS_OVERLAY)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSound(GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> ALGAE_CULTURE_TANK_RECIPES = new RecipeMap<>("algae_culture_tank_recipes", 2, 1, 2, 0, new NoCoilTemperatureRecipeBuilder(), false)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.BATH);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> BIOMASS_GENERATOR_RECIPES = new RecipeMap<>("biomass_generator_recipes", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.BATH)
            .allowEmptyOutput();

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> LARGE_GAS_COLLECTOR_RECIPES = new RecipeMap<>("large_gas_collector_recipes", 2, 0, 0, 1, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COMPRESSOR);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> VIRTUAL_COSMOS_SIMULATOR_RECIPES = new RecipeMapVirtualCosmosSimulator<>("virtual_cosmos_simulator_recipes", 1, 81, 0, 18, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES = new RecipeMapLargeCircuitAssemblyLine<>("large_circuit_assembly_line_recipes", 7, 1, 1, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.DATA_ORB_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> DYSON_SWARM_RECIPES = new RecipeMap<>("dyson_swarm_recipes", 2, 8, 0, 0, new FuelRecipeBuilder(), true)
            .allowEmptyOutput()
            .setSound(GTSoundEvents.COOLING);

    /**
     * Example:
     *
     * <pre>
     *
     * </pre>
     *
     * <p>
     *
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PLANETARY_GAS_SIPHON_RECIPES = new RecipeMap<>("planetary_gas_siphon_recipes", 4, 0, 1, 1, new SimpleRecipeBuilder(), false)
            .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_SPACE_ELEVATOR_DRILLING_MODULE, ProgressWidget.MoveType.VERTICAL)
            .setSound(GTSoundEvents.MINER);

    public GTLiteRecipeMaps() {}
}