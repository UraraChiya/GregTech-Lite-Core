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
import gregtech.api.recipes.ingredients.GTRecipeInput;
import gregtech.core.sound.GTSoundEvents;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import magicbook.gtlitecore.api.recipe.builder.*;
import magicbook.gtlitecore.api.recipe.machines.*;
import net.minecraft.init.SoundEvents;
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

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.SIMULATOR_RECIPES.recipeBuilder()
     *          .notConsumable(GTLiteMetaItems.MEMORY_CARD_ZOMBIE)
     *          .circuitMeta(1)
     *          .chancedOutput(new ItemStack(Items.ROTTEN_FLESH, 64), 8000, 500)
     *          .EUt(VA[LV])
     *          .duration(1200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Recipe map for {@link magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities#SIMULATOR},
     *     maybe seems like Simulator in <a href="https://github.com/xt9/DeepMobLearning">Deep Mob Learning</a> Mod.
     *     If you add new recipe, then you can add it in your config, please see:
     *      {@link magicbook.gtlitecore.common.GTLiteConfigHolder#machines}
     *     of cause, this is just some QoL settings.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> SIMULATOR_RECIPES = new RecipeMap<>("simulator_recipes", 2, 2, 0, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.SCIENCE);

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
     *     Same as {@link #BURNER_REACTOR_RECIPES}, just a low temperature version,
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
     *     GTLiteRecipeMaps.FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
     *          .input(OrePrefix.dust, GTLiteMaterials.Tiberium)
     *          .input(OrePrefix.dust, GTLiteMaterials.OrichalcumEnergized)
     *          .circuitMeta(11)
     *          .fluidInputs(Materials.NaquadahEnriched.getFluid(2000))
     *          .fluidInputs(GTLiteMaterials.Vibranium.getPlasma(1000))
     *          .fluidInputs(GTLiteMaterials.HeavyHyperFuel.getFluid(400))
     *          .fluidInputs(GTLiteMaterials.SuperheavyExoticGas.getFluid(200))
     *          .fluidOutputs(GTLiteMaterials.HyperFuelMkII.getFluid(3000))
     *          .EUt(VA[UEV])
     *          .duration(100)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Just a simple recipe map, used to product fuels (and some advanced recipes about low stage fuels,
     *     like {@link gregtech.api.unification.material.Materials#CetaneBoostedDiesel}).
     *     And some materials like {@link magicbook.gtlitecore.api.unification.GTLiteMaterials#Vibranium},
     *     can and only can product by this machine (some trivia: in
     *      <a href="https://github.com/GregTechCEu/gregicality-science">Gregicality Science</a>,
     *     this material product by a special recipe map 'Superheavy Reaction'.).
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
     *     GTLiteRecipeMaps.HYPER_REACTOR_MK1_RECIPES.recipeBuilder()
     *          .fluidInputs(GTLiteMaterials.HyperFuelMkII.getFluid(1))
     *          .duration(300)
     *          .EUt(524288)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Like {@link #NAQUADAH_REACTOR_RECIPES}, you should add it in your config,
     *     same like fuel's heat value tweak config in
     *      {@link magicbook.gtlitecore.common.GTLiteConfigHolder#misc}
     *     of cause, this is just some QoL settings.
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
     *     GTLiteRecipeMaps.HYPER_REACTOR_MK2_RECIPES.recipeBuilder()
     *          .fluidInputs(GTLiteMaterials.HyperFuelMkIII.getFluid(1))
     *          .duration(600)
     *          .EUt(2097152)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Advanced Hyper Reactor recipe map, in this recipe map,
     *     some materials product more energy (like {@link magicbook.gtlitecore.api.unification.GTLiteMaterials#LightHyperFuel}).
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
     *     GTLiteRecipeMaps.HYPER_REACTOR_MK3_RECIPES.recipeBuilder()
     *          .fluidInputs(HyperFuelMkIV.getFluid(1))
     *          .duration(1200)
     *          .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelMark4)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Same like {@link #HYPER_REACTOR_MK1_RECIPES} and {@link #HYPER_REACTOR_MK2_RECIPES}.
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
     *     GTLiteRecipeMaps.FLOTATION_RECIPES.recipeBuilder()
     *          .input(OrePrefix.dust, GTLiteMaterials.PotassiumEthylxanthate, 32)
     *          .input(GTLiteOrePrefix.milled, Materials.Chalcopyrite, 64)
     *          .input(GTLiteOrePrefix.milled, Materials.Chalcopyrite, 64)
     *          .input(GTLiteOrePrefix.milled, Materials.Chalcopyrite, 64)
     *          .input(GTLiteOrePrefix.milled, Materials.Chalcopyrite, 64)
     *          .fluidInputs(GTLiteMaterials.Turpentine.getFluid(12000))
     *          .fluidOutputs(GTLiteMaterials.ChalcopyriteFront.getFluid(1000))
     *          .EUt(VA[IV])
     *          .duration(9600)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Next processing step before after {@link #ISA_MILL_RECIPES},
     *     please see {@link magicbook.gtlitecore.loaders.oreprocessing.IsaMillOreProcessing}.
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
     *     GTLiteRecipeMaps.VACUUM_DRYING_RECIPES.recipeBuilder()
     *          .fluidInputs(GTLiteMaterials.MonaziteFront.getFluid(4000))
     *          .output(OrePrefix.dust, Materials.Erbium, 64)
     *          .output(OrePrefix.dust, Materials.Zirconium, 64)
     *          .output(OrePrefix.dust, Materials.Lanthanum, 32)
     *          .output(OrePrefix.dust, Materials.Lutetium, 16)
     *          .output(OrePrefix.dust, Materials.Europium, 8)
     *          .EUt(VA[ZPM])
     *          .duration(2400)
     *          .blastFurnaceTemp(5500)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Final step of Isa Mill Ore Processing chain (after {@link #FLOTATION_RECIPES}),
     *     same as EBF's temperature system (but just have some special ranges).
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
     *     GTLiteRecipeMaps.DRONE_AIRPORT_RECIPES.recipeBuilder()
     *          .notConsumable(GTLiteMetaItems.MINING_DRONE_EV.getStackForm(16))
     *          .circuitMeta(1)
     *          .fluidInputs(GTLiteMaterials.MethylhydrazineNitrateRocketFuel.getFluid(4000))
     *          .chancedOutput(OrePrefix.ore, Materials.Naquadah, 64, 5000, 500)
     *          .EUt(VA[EV)
     *          .duration(8)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Simple recipe map, please see {@link magicbook.gtlitecore.loaders.multiblock.DroneAirport}.
     *     Usually used special method, please use this method.
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
     *     GTLiteRecipeMaps.ION_IMPLANTATOR_RECIPES.recipeBuilder()
     *          .input(OrePrefix.ring, GTLiteMaterials.Fullerene)
     *          .input(OrePrefix.wireFine, GTLiteMaterials.ThalliumCopperChloride, 4)
     *          .fluidInputs(GTLiteMaterials.Kevlar.getFluid(L))
     *          .output(GTLiteMetaItems.SPINTRONIC_INDUCTOR, 16)
     *          .duration(160)
     *          .EUt(VA[UHV])
     *          .cleanroom(CleanroomType.CLEANROOM)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Used to product advanced smd inductor, such as {@link magicbook.gtlitecore.loaders.circuits.CosmicCircuits}.
     *     Now this recipe map just have this function (may be add more recipes for other function).
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
     *     GTLiteRecipeMaps.PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
     *          .input(GTLiteMetaItems.FLUID_CORE_T7)
     *          .input(MetaItems.FIELD_GENERATOR_UV)
     *          .input(MetaTileEntities.QUANTUM_TANK[5])
     *          .input(OrePrefix.foil, GTLiteMaterials.PolyPhosphonitrileFluoroRubber, 64)
     *          .fluidInputs(GTLiteMaterials.Polyetheretherketone.getFluid(L * 128))
     *          .fluidInputs(Materials.TinAlloy.getFluid(L * 128))
     *          .fluidInputs(Materials.Lubricant.getFluid(7000))
     *          .fluidInputs(GTLiteMaterials.CelestialTungsten.getFluid(L * 4))
     *          .output(GTLiteMetaItems.FLUID_CORE_T8)
     *          .EUt(VA[UIV])
     *          .duration(400)
     *          .CasingTier(6)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Port from Prim's mod <a href="https://github.com/GTNewHorizons/GoodGenerator">Good Generator</a>,
     *     and this recipe map has special property (different predicate of casings and internal casings),
     *     casings is {@link magicbook.gtlitecore.common.blocks.BlockPreciseAssemblerCasing},
     *     internal casings is {@link gregtech.common.blocks.BlockMachineCasing} (above LuV).
     *     Usually used for some high tier components and System on Chip of advanced circuits (above wetware circuit),
     *     and also have some advanced recipes for original circuits (like wetware processing unit).
     *     Please use .CasingTier() method to define total tier of recipe,
     *     you can see {@link magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate#PA_CASING} and
     *      {@link magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate#PA_INTERNAL_CASING},
     *     these predicates control this machine recipes.
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
     *     GTLiteRecipeMaps.COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
     *          .input(OrePrefix.cableGtDouble, Materials.Tungsten, 2)
     *          .input(OrePrefix.stick, Materials.TungstenSteel, 2)
     *          .input(OrePrefix.stick, Materials.NeodymiumMagnetic)
     *          .input(wireGtDouble, Materials.Graphene, 4)
     *          .output(MetaItems.ELECTRIC_MOTOR_IV)
     *          .EUt(VA[LV])
     *          .duration(20)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Easy version of {@link #COMPONENT_ASSEMBLY_LINE_RECIPES}, so just a simple recipe map.
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
     *     GTLiteRecipeMaps.COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
     *          .input(OrePrefix.stickLong, GTLiteMaterials.PhosphorusDopedEuropiumIronArsenideMagnetic, 64)
     *          .input(OrePrefix.stickLong, GTLiteMaterials.Legendarium, 64)
     *          .input(OrePrefix.stickLong, GTLiteMaterials.Legendarium, 64)
     *          .input(OrePrefix.stickLong, GTLiteMaterials.Legendarium, 64)
     *          .input(OrePrefix.stickLong, GTLiteMaterials.Legendarium, 64)
     *          .input(OrePrefix.stickLong, GTLiteMaterials.Legendarium, 64)
     *          .input(OrePrefix.stickLong, GTLiteMaterials.Legendarium, 64)
     *          .input(OrePrefix.cableGtHex, GTLiteMaterials.Solarium, 8)
     *          .fluidInputs(Materials.SolderingAlloy.getFluid(L * 32 * 64))
     *          .fluidInputs(Materials.Lubricant.getFluid(448000))
     *          .fluidInputs(GTLiteMaterials.Zylon.getFluid(L * 4 * 64))
     *          .fluidInputs(GTLiteMaterials.Astralium.getFluid(L * 2 * 64))
     *          .fluidInputs(GTLiteMaterials.Abyssalloy.getFluid(L * 16 * 64))
     *          .output(MetaItems.ELECTRIC_MOTOR_UIV, 64)
     *          .EUt(VA[UIV])
     *          .duration(1800)
     *          .CasingTier(UIV)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Port from Prim's mod <a href="https://github.com/GTNewHorizons/GoodGenerator">Good Generator</a>,
     *     and this recipe map has special property (predicate blocks in {@link magicbook.gtlitecore.common.blocks.BlockComponentAssemblyLineCasing}),
     *     please see: {@link magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate#CA_CASING}.
     *     Used special JEI page textures, please see {@link RecipeMapComponentAssemblyLine}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<ComponentCasingTierRecipeBuilder> COMPONENT_ASSEMBLY_LINE_RECIPES = new RecipeMapComponentAssemblyLine<>("component_assembly_line_recipes", 12, 1, 12, 0, new ComponentCasingTierRecipeBuilder(), false)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.TREE_GROWTH_RECIPES.recipeBuilder()
     *          .notConsumable(new ItemStack(Blocks.SAPLING, 1, 4))
     *          .circuitMeta(1)
     *          .fluidInputs(Materials.Water.getFluid(200))
     *          .outputs(new ItemStack(Blocks.LOG2, 8, 0))
     *          .outputs(new ItemStack(Blocks.LEAVES2, 4, 0))
     *          .chancedOutput(new ItemStack(Blocks.SAPLING, 1, 4), 4000, 500)
     *          .chancedOutput(new ItemStack(Items.APPLE), 2000, 500)
     *          .EUt(VA[LV])
     *          .duration(100)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Simple recipes for {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityTreeGrowthFactory}.
     *     TODO maybe rebalanced this recipe map and {@link gregtechfoodoption.recipe.chain.GreenhouseChain}.
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
     *     GTLiteRecipeMaps.COLLIDER_RECIPES.recipeBuilder()
     *          .fluidInputs(Materials.Copper.getFluid(L))
     *          .fluidInputs(Materials.Caesium.getFluid(L))
     *          .fluidOutputs(Materials.Actinium.getFluid(L))
     *          .fluidOutputs(GTLiteMaterials.FreeElectronGas.getFluid(L))
     *          .EUt(VA[IV])
     *          .duration(200)
     *          .CasingTier(1)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Used {@link magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate#FIELD_CASING} predicate,
     *     just another voltage property (so you can use voltage name, but should above ZPM),
     *     predicate blocks in {@link magicbook.gtlitecore.common.blocks.BlockFieldCasing}.
     *     If you add recipes of particles, then should output some Free Electric Gas.
     *     For high energy physics recipes, you should add circuit to distinguish recipes (pay attention conflicts!).
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
     *     GTLiteRecipeMaps.NICOLL_DYSON_BEAMER_OSCILLATING_MODULE.recipeBuilder()
     *          .notConsumable(OrePrefix.spring, GTLiteMaterials.Edenium)
     *          .input(GTLiteMetaItems.BOSE_EINSTEIN_CONDENSATE, 64)
     *          .input(GTLiteMetaItems.HYPERSTABLE_SELF_HEALING_ADHESIVE, 4)
     *          .fluidInputs(GTLiteMaterial.RawStarMatter.getFluid(16000))
     *          .fluidInputs(GTLiteMaterial.StarCoreMatter.getPlasma(16000))
     *          .fluidInputs(GTLiteMaterial.QuantumchromodynamicallyConfinedMatter.getFluid(16000))
     *          .output(GTLiteMetaItems.BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT, 64)
     *          .fluidOutputs(GTLiteMaterials.Magmatter.getFluid(16000))
     *          .EUt(VA[MAX])
     *          .duration(20)
     *          .CasingTier(2)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     This recipe map is advanced version of {@link #DIMENSIONAL_OSCILLATOR_RECIPES},
     *     used special recipe property {@link GravitonCasingTierRecipeBuilder},
     *     and predicate tier by blocks in {@link magicbook.gtlitecore.common.blocks.BlockGravitonCasing}.
     *     All Dimensional Oscillator recipe will generate a same recipe in this recipe map,
     *     these recipes all have 1 tier property (mean low).
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<GravitonCasingTierRecipeBuilder> NICOLL_DYSON_BEAMER_OSCILLATING_MODULE = new RecipeMap<>("nicoll_dyson_beamer_oscillating_module", 6, 6, 6, 6, new GravitonCasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(true, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, true, false, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : SoundEvents.ENTITY_GENERIC_EXPLODE);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
     *          .notConsumable(OrePrefix.plate, GTLiteMaterials.Galaxium)
     *          .fluidInputs(GTLiteMaterials.Fatalium.getPlasma(L))
     *          .fluidInputs(GTLiteMaterials.Hypogen.getFluid(L * 4))
     *          .fluidInputs(GTLiteMaterials.DimensionallyTranscendentResidue.getFluid(16000))
     *          .fluidOutputs(GTLiteMaterials.Fatalium.getFluid(L))
     *          .EUt(VA[OpV])
     *          .duration(20)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Maybe just a advanced version of {@link RecipeMaps#IMPLOSION_RECIPES},
     *     but you do not needs to use tnt! Used to some advanced materials for UIV+.
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
            .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : SoundEvents.ENTITY_GENERIC_EXPLODE)
            .onRecipeBuild((recipeBuilder) -> NICOLL_DYSON_BEAMER_OSCILLATING_MODULE.recipeBuilder()
                    .inputs(recipeBuilder.getInputs().toArray(new GTRecipeInput[0]))
                    .fluidInputs(recipeBuilder.getFluidInputs())
                    .outputs(recipeBuilder.getOutputs())
                    .chancedOutputs(recipeBuilder.getChancedOutputs())
                    .fluidOutputs(recipeBuilder.getFluidOutputs())
                    .chancedFluidOutputs(recipeBuilder.getChancedFluidOutputs())
                    .duration(recipeBuilder.getDuration())
                    .EUt(recipeBuilder.getEUt())
                    .CasingTier(1)
                    .hidden() // Hidden same recipes in NDB Oscillating Module recipe.
                    .buildAndRegister());

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
     *          .input(OrePrefix.wireFine, GTLiteMaterials.Magmatter, 4)
     *          .input(GTLiteMetaItems.HYPERSTABLE_SELF_HEALING_ADHESIVE)
     *          .input(GTLiteMetaItems.MANIFOLD_OSCILLATORY_POWER_CELL, 16)
     *          .fluidInputs(GTLiteMaterials.Magmatter.getFluid(L))
     *          .fluidInputs(GTLiteMaterials.Spacetime.getFluid(L * 4))
     *          .fluidInputs(GTLiteMaterials.CosmicNeutronium.getFluid(1000))
     *          .output(OrePrefix.wireGtSingle, GTLiteMaterials.Magmatter)
     *          .EUt(VA[MAX])
     *          .duration(20)
     *          .temperature(BigInteger.valueOf(Integer.MAX_VALUE))
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     This recipe map is advanced version of {@link #STELLAR_FURNACE_RECIPES},
     *     all Stellar Furnace recipe will generate a same recipe in this recipe map.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<GravitonCasingTierRecipeBuilder> NICOLL_DYSON_BEAMER_BURNING_MODULE = new RecipeMapNDBBurningModule<>("nicoll_dyson_beamer_burning_module", 9, 9, 9, 9, new GravitonCasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, false, false, GuiTextures.FILTER_SLOT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.FILTER_SLOT_OVERLAY)
            .setSlotOverlay(true, false, false, GuiTextures.FILTER_SLOT_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.FILTER_SLOT_OVERLAY)
            .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSound(GTSoundEvents.FURNACE);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.STELLAR_FURNACE_RECIPES.recipeBuilder()
     *          .input(OrePrefix.ingot, Materials.Rhenium)
     *          .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.NAQUADRIA_CHARGE))
     *          .fluidOutputs(GTLiteMaterials.DegenerateRhenium.getPlasma(1000))
     *          .EUt(VA[UIV])
     *          .duration(20)
     *          .temperature(BigInteger.valueOf(3932160))
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Basic processing recipe in UEV+, use a special recipe builder.
     *     The different between {@link NoCoilTemperatureRecipeBuilder} and {@link NoCoilHigherTemperatureRecipeBuilder} is data type,
     *     this recipe builder use {@link java.math.BigInteger}, so you can write some big numbers in this recipe maps.
     *     Pay attention, if you use too big numbers, then may be cause some problem about {@link RecipeMap}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<NoCoilHigherTemperatureRecipeBuilder> STELLAR_FURNACE_RECIPES = new RecipeMap<>("stellar_furnace_recipes", 6, 6, 6, 6, new NoCoilHigherTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MASS_FAB, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSound(GTValues.FOOLS.get() ? SoundEvents.ENTITY_GENERIC_EXPLODE : GTSoundEvents.FURNACE)
            .onRecipeBuild((recipeBuilder) -> NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                    .inputs(recipeBuilder.getInputs().toArray(new GTRecipeInput[0]))
                    .fluidInputs(recipeBuilder.getFluidInputs())
                    .outputs(recipeBuilder.getOutputs())
                    .chancedOutputs(recipeBuilder.getChancedOutputs())
                    .fluidOutputs(recipeBuilder.getFluidOutputs())
                    .chancedFluidOutputs(recipeBuilder.getChancedFluidOutputs())
                    .duration(recipeBuilder.getDuration())
                    .EUt(recipeBuilder.getEUt())
                    .CasingTier(1)
                    .hidden() // Hidden same recipes in NDB Burning Module recipes.
                    .buildAndRegister());

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.PLASMA_CONDENSER_RECIPES.recipeBuilder()
     *          .input(GTLiteMetaItems.RHENIUM_PLASMA_CONTAINMENT_CELL)
     *          .fluidInputs(Materials.Helium.getFluid(FluidStorageKeys.LIQUID, 16000))
     *          .circuitMeta(1)
     *          .output(GTLiteMetaItems.PLASMA_CONTAINMENT_CELL)
     *          .fluidOutputs(GTLiteMaterials.DegenerateRhenium.getFluid(1000))
     *          .fluidOutputs(Materials.Helium.getFluid(FluidStorageKeys.GAS, 16000))
     *          .EUt(VA[UEV])
     *          .duration(100)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Simple recipe. please see {@link magicbook.gtlitecore.loaders.multiblock.PlasmaCondenser},
     *     used to add materials and containment cells cooling recipes.
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
     *     GTLiteRecipeMaps.DECAY_GENERATOR_RECIPES.recipeBuilder()
     *          .fluidInputs(GTLiteMaterials.QuasifissioningPlasma.getPlasma(1000))
     *          .fluidOutputs(GTLiteMaterials.FleroviumYtterbiumPlasma.getPlasma(1000))
     *          .EUt(VA[ZPM])
     *          .duration(160)
     *          .CasingTier(1)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Used {@link magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate#FIELD_CASING} predicate,
     *     just another voltage property (so you can use voltage name, but should above ZPM),
     *     predicate blocks in {@link magicbook.gtlitecore.common.blocks.BlockFieldCasing}.
     *     Same as {@link #COLLIDER_RECIPES}, used {@link FieldCasingTierRecipeBuilder}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FieldCasingTierRecipeBuilder> DECAY_GENERATOR_RECIPES = new RecipeMap<>("decay_generator_recipes", 1, 1, 1, 1, new FieldCasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_HAMMER, ProgressWidget.MoveType.VERTICAL_DOWNWARDS)
            .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
     *          .input(GTLiteOrePrefix.singularity, Materials.Water)
     *          .input(GTLiteOrePrefix.singularity, Materials.Lava)
     *          .input(GTLiteOrePrefix.singularity, Materials.Wood)
     *          .input(GTLiteOrePrefix.singularity, Materials.Stone)
     *          .input(GTLiteOrePrefix.singularity, Materials.Netherrack)
     *          .input(GTLiteOrePrefix.singularity, Materials.Endstone)
     *          .input(GTLiteOrePrefix.singularity, Materials.Emerald)
     *          .input(GTLiteOrePrefix.singularity, Materials.Obsidian)
     *          .input(GTLiteOrePrefix.singularity, Materials.TreatedWood)
     *          .input(GTLiteOrePrefix.singularity, Materials.Gunpowder)
     *          .input(GTLiteOrePrefix.singularity, Materials.Diamond)
     *          .input(GTLiteOrePrefix.singularity, Materials.NetherQuartz)
     *          .input(GTLiteOrePrefix.singularity, Materials.Brick)
     *          .input(GTLiteOrePrefix.singularity, Materials.Coal)
     *          .input(GTLiteOrePrefix.singularity, Materials.Steam)
     *          .input(GTLiteOrePrefix.singularity, Materials.Clay)
     *          .output(GTLiteMetaItems.ANCIENT_SINGULARITY)
     *          .EUt(VA[MAX])
     *          .duration(20)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     End machine in OpV stage, please see {@link magicbook.gtlitecore.loaders.multiblock.SuprachronalAssemblyLine}.
     *     Used {@link RecipeMapSuprachronalAssemblyLine} for JEI page, just like {@link gregtech.api.recipes.machines.RecipeMapAssemblyLine},
     *     but not has research property (but this recipe map is also simple recipe builder).
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
     *     GTLiteRecipeMaps.SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
     *          .circuitMeta(1)
     *          .notConsumable(GTLiteMetaItems.MINING_DRONE_ZPM.getStackForm(16))
     *          .fluidInputs(Materials.RocketFuel.getFluid(16000))
     *          .fluidOutputs(Materials.Naquadah.getFluid(80000))
     *          .EUt(VH[ZPM])
     *          .duration(20)
     *          .CasingTier(2)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     One of three module of space elevator modules, please see {@link magicbook.gtlitecore.loaders.multiblock.SpaceElevator}.
     *     Predicate casing tier by motor casings in {@link magicbook.gtlitecore.common.blocks.BlockActiveMultiblockCasing}.
     *     TODO maybe deprecate or tweak, if redo space elevator in future.
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
     *     GTLiteRecipeMaps.SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
     *          .circuitMeta(30)
     *          .notConsumable(GTLiteMetaItems.MINING_DRONE_OpV.getStackForm(16))
     *          .chancedOutput(OrePrefix.ore, Materials.Naquadah, 4096)
     *          .EUt(VA[UV)
     *          .duration(Materials.Naquadah.getMass() * Materials.NaquadahEnriched.getMass())
     *          .CasingTier(3)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     One of three module of space elevator modules, please see {@link magicbook.gtlitecore.loaders.multiblock.SpaceElevator}.
     *     Predicate casing tier by motor casings in {@link magicbook.gtlitecore.common.blocks.BlockActiveMultiblockCasing}.
     *     TODO maybe deprecate or tweak, if redo space elevator in future.
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
     *     GTLiteRecipeMaps.SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
     *          .input(OrePrefix.frameGt, GTLiteMaterials.BlackPlutonium)
     *          .input(GTLiteMetaItems.COSMIC_INFORMATION_MODULE)
     *          .input(GTLiteMetaItems.CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT)
     *          .input(GTLiteMetaItems.CLADDED_OPTICAL_FIBER_CORE, 8)
     *          .input(GTLiteMetaItems.BOSE_EINSTEIN_CONDENSATE, 4)
     *          .input(OrePrefix.wireGtSingle, GTLiteMaterials.AstralTitanium, 2)
     *          .fluidInputs(GTLiteMaterials.CosmicComputingMixture.getFluid(1000))
     *          .fluidInputs(GTLiteMaterials.PlatinumGroupAlloy.getFluid(L))
     *          .output(GTLiteMetaItems.HOLOGRAPHIC_INFORMATION_IMC, 2)
     *          .EUt(VA[UIV])
     *          .duration(20)
     *          .CasingTier(5)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     One of three module of space elevator modules, please see {@link magicbook.gtlitecore.loaders.multiblock.SpaceElevator}.
     *     Predicate casing tier by motor casings in {@link magicbook.gtlitecore.common.blocks.BlockActiveMultiblockCasing}.
     *     TODO maybe deprecate or tweak, if redo space elevator in future.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SpaceElevatorCasingTierRecipeBuilder> SPACE_ELEVATOR_ASSEMBLING_MODULE = new RecipeMapSuprachronalAssemblyLine<>("space_elevator_assembling_module", 16, 1, 4, 0, new SpaceElevatorCasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ASSEMBLY_LINE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * <p>
     *     Fake recipe map groups for {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityLargeProcessingFactory}.
     *     This processing mode consist of three common recipes: {@link RecipeMaps#COMPRESSOR_RECIPES}, {@link RecipeMaps#LATHE_RECIPES},
     *     and {@link RecipeMaps#POLARIZER_RECIPES}, and use different circuit to check it, please see {@link RecipeMapPseudoGroup}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMapPseudoGroup<SimpleRecipeBuilder> PROCESSING_MODE_A = new RecipeMapPseudoGroup<>("processing_mode_a", 1, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.COMPRESSOR_RECIPES, RecipeMaps.LATHE_RECIPES, RecipeMaps.POLARIZER_RECIPES, true);

    /**
     * <p>
     *     Fake recipe map groups for {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityLargeProcessingFactory}.
     *     This processing mode consist of three common recipes: {@link RecipeMaps#FERMENTING_RECIPES}, {@link RecipeMaps#EXTRACTOR_RECIPES},
     *     and {@link RecipeMaps#CANNER_RECIPES}, and use different circuit to check it, please see {@link RecipeMapPseudoGroup}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMapPseudoGroup<SimpleRecipeBuilder> PROCESSING_MODE_B = new RecipeMapPseudoGroup<>("processing_mode_b", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.FERMENTING_RECIPES, RecipeMaps.EXTRACTOR_RECIPES, RecipeMaps.CANNER_RECIPES, true);

    /**
     * <p>
     *     Fake recipe map groups for {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityLargeProcessingFactory}.
     *     This processing mode consist of three common recipes: {@link RecipeMaps#LASER_ENGRAVER_RECIPES}, {@link RecipeMaps#AUTOCLAVE_RECIPES},
     *     and {@link RecipeMaps#FLUID_SOLIDFICATION_RECIPES}, and use different circuit to check it, please see {@link RecipeMapPseudoGroup}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMapPseudoGroup<SimpleRecipeBuilder> PROCESSING_MODE_C  = new RecipeMapPseudoGroup<>("processing_mode_c", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.LASER_ENGRAVER_RECIPES, RecipeMaps.AUTOCLAVE_RECIPES, RecipeMaps.FLUID_SOLIDFICATION_RECIPES, true);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder()
     *          .input(OrePrefix.ingot, Materials.Tin)
     *          .output(OrePrefix.ingot, Materials.Silver)
     *          .EUt(VA[EV])
     *          .duration(600)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Used to build some fantastic transform, such as iron -> iridium,
     *     please see: {@link magicbook.gtlitecore.loaders.multiblock.MolecularTransformer}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> MOLECULAR_TRANSFORMER_RECIPES = new RecipeMap<>("molecular_transformer_recipes", 1, 1, 0, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(true, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
     *          .circuitMeta(1)
     *          .fluidOutputs(HeavyLepton.getFluid(40))
     *          .EUt((int) V[UHV])
     *          .duration(1)
     *          .Altitude(80)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     A special check recipe map, please see: {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityCosmicRayDetector}.
     *     This recipe map will check altitude of special block in multiblock structure.
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
     *     GTLiteRecipeMaps.PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
     *          .circuitMeta(3)
     *          .notConsumable(GTLiteOrePrefix.swarm, Gold)
     *          .input(OrePrefix.plate, GTLiteMaterials.KaptonK)
     *          .input(OrePrefix.foil, Materials.AnnealedCopper, 42)
     *          .input(OrePrefix.foil, Materials.Copper, 42)
     *          .fluidInputs(Materials.SulfuricAcid.getFluid(1322))
     *          .fluidInputs(Materials.Iron3Chloride.getFluid(661))
     *          .output(MetaItems.PLASTIC_CIRCUIT_BOARD, 91)
     *          .EUt(368640)
     *          .duration(132)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Mode for PCB Factory, please see: {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityPCBFactory}.
     *     Used nano swarm as catalyst in common situation (tier 2: silver, tier 3: gold).
     *     TODO maybe deprecate or tweak, if redo pcb factory in future.
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
     *     GTLiteRecipeMaps.PCB_FACTORY_BIO_RECIPES.recipeBuilder()
     *          .input(OrePrefix.plate, GTLiteMaterials.KaptonK)
     *          .input(OrePrefix.foil, Materials.Glass, 64)
     *          .output(MetaItems.WETWARE_CIRCUIT_BOARD, 125)
     *          .EUt(491520)
     *          .duration(392)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Mode for PCB Factory, please see: {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityPCBFactory}.
     *     Unused now.
     *     TODO maybe deprecate or tweak, if redo pcb factory in future.
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
     *     GTLiteRecipeMaps.NEUTRAL_NETWORK_NEXUS_ASSEMBLING_MODE.recipeBuilder()
     *          .input(lens, Glass)
     *          .input(CARBON_FIBERS, 8)
     *          .fluidInputs(Materials.Helium.getFluid(L * 8)})
     *          .fluidInputs(Materials.Iron3Chloride.getFluid(4000))
     *          .fluidInputs(Materials.Lubricant.getFluid(250))
     *          .output(nanosensor, Carbon)
     *          .EUt(VA[IV])
     *          .duration(200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     One of three modes of Neutral Network Nexus, used to create Nanosensor and Nanotube,
     *     please see {@link magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> NEUTRAL_NETWORK_NEXUS_ASSEMBLING_MODE = new RecipeMap<>("neutral_network_nexus_assembling_module", 6, 1, 3, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.IN_SLOT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.IN_SLOT_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.OUT_SLOT_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
     *          .circuitMeta(1)
     *          .input(GTLiteOrePrefix.nanotube, Materials.Carbon)
     *          .input(GTLiteOrePrefix.nanosensor, Materials.Carbon)
     *          .input(MetaItems.SIMPLE_SYSTEM_ON_CHIP, 8)
     *          .input(OrePrefix.dust, Materials.Carbon, 4)
     *          .fluidInputs(PCBCoolant.getFluid(L))
     *          .output(GTLiteOrePrefix.swarm, Materials.Carbon)
     *          .EUt(VA[LV])
     *          .duration(200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     One of three modes of Neutral Network Nexus, used to breeding nano swarm.
     *     Please see: {@link magicbook.gtlitecore.loaders.multiblock.NeutralNetworkNexus}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SwarmTierRecipeBuilder> NEUTRAL_NETWORK_NEXUS_BREEDING_MODE = new RecipeMap<>("neutral_network_nexus_breeding_mode", 6, 1, 3, 0, new SwarmTierRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, true, GuiTextures.EXTRACTOR_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.NEUTRAL_NETWORK_NEXUS_HYBRIDIZING_MODE.recipeBuilder()
     *          .circuitMeta(1)
     *          .input(GTLiteOrePrefix.swarm, Materials.Copper)
     *          .input(GTLiteOrePrefix.swarm, Materials.Redstone)
     *          .chancedOutput(GTLiteOrePrefix.swarm, Materials.Copper, 8000, 0)
     *          .chancedOutput(GTLiteOrePrefix.swarm, Materials.Redstone, 8000, 0)
     *          .chancedOutput(GTLiteOrePrefix.swarm, Materials.RedAlloy, 2000, 500)
     *          .EUt(VA[IV])
     *          .duration(200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     One of two modes of Neutral Network Nexus, used to hybridizing nano swarm.
     *     Please see: {@link magicbook.gtlitecore.loaders.multiblock.NeutralNetworkNexus}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SwarmTierRecipeBuilder> NEUTRAL_NETWORK_NEXUS_HYBRIDIZING_MODE = new RecipeMap<>("neutral_network_nexus_hybridizing_mode", 6, 6, 3, 3, new SwarmTierRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.CIRCUIT_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
     *          .circuitMeta(11)
     *          .notConsumable(GTLiteOrePrefix.swarm, GTLiteMaterials.Fullerene)
     *          .input(OrePrefix.dust, Materials.Carbon, 64)
     *          .fluidInputs(Materials.Chlorine.getFluid(16000))
     *          .fluidInputs(Materials.Hydrogen.getFluid(16000))
     *          .fluidInputs(Materials.Oxygen.getFluid(16000))
     *          .fluidOutputs(GTLiteMaterials.NitrileButadieneRubber.getFluid(9216))
     *          .fluidOutputs(GTLiteMaterials.PolyPhosphonitrileFluoroRubber.getFluid(9216))
     *          .fluidOutputs(GTLiteMaterials.Polyetheretherketone.getFluid(18432))
     *          .fluidOutputs(Materials.Rubber.getFluid(36864))
     *          .EUt(VA[UV])
     *          .duration(400)
     *          .CasingTier(2)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Please see: {@link magicbook.gtlitecore.loaders.multiblock.QuantumForceTransformer},
     *     This recipe map's predicate like {@link #COLLIDER_RECIPES}.
     *     If you want to add new recipes, please use swarm ({@link magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix#swarm})
     *     as catalyst, and add a advanced version of your recipe (use different swarm as catalyst),
     *     and add a special circuit to resolve conflicts.
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
     *     GTLiteRecipeMaps.TURBINE_MIXER_RECIPES.recipeBuilder()
     *          .circuitMeta(8)
     *          .input(OrePrefix.dust, Materials.Gadolinium)
     *          .input(OrePrefix.dust, Materials.Terbium)
     *          .input(OrePrefix.dust, Materials.Dysprosium)
     *          .input(OrePrefix.dust, Materials.Holmium)
     *          .input(OrePrefix.dust, Materials.Erbium)
     *          .input(OrePrefix.dust, Materials.Thulium)
     *          .input(OrePrefix.dust, Materials.Ytterbium)
     *          .input(OrePrefix.dust, Materials.Lutetium)
     *          .output(OrePrefix.dust, GTLiteMaterials.LanthanumGroupHAlloy, 8)
     *          .EUt(VA[UEV])
     *          .duration(180)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Extended version of {@link RecipeMaps#MIXER_RECIPES}, has 9 input slots and 6 fluid input slots,
     *     usually add special component material recipe in this recipe map (such as {@link magicbook.gtlitecore.api.unification.GTLiteMaterials#Periodicium}).
     *     TODO use {@link RecipeMap#onRecipeBuild(Consumer)} to tweak this recipe map be advanced version of mixer recipes,
     *          or create recipes of {@link gregicality.multiblocks.api.recipes.GCYMRecipeMaps#ALLOY_BLAST_RECIPES} via recipe handler.
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
     *     GTLiteRecipeMaps.HEAT_EXCHANGE_RECIPES.recipeBuilder()
     *          .fluidInputs(Materials.DistilledWater.getFluid(5))
     *          .fluidInputs(Materials.Helium.getPlasma(1))
     *          .fluidOutputs(GTLiteMaterials.SuperheatedSteam.getFluid(160 * 5))
     *          .fluidOutputs(GTLiteMaterials.SupercriticalSteam.getFluid(80 * 5))
     *          .fluidOutputs(Materials.Helium.getFluid(1))
     *          .maxRate(1600)
     *          .flowRate(500)
     *          .duration(20)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Please see: {@link FlowRateRecipeBuilder}, this recipe map has two special property.
     *     Pay attention, the correspond machine also has some special check,
     *     please see: {@link magicbook.gtlitecore.api.capability.impl.HeatExchangerRecipeLogic}.
     *     If you still understand, then you can see {@link magicbook.gtlitecore.loaders.multiblock.HeatExchanger}.
     *     Textures of JEI page from Prim's mod <a href="https://github.com/GTNewHorizons/GoodGenerator">Good Generator</a>.
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
     *     GTLiteRecipeMaps.HIGH_PRESSURE_STEAM_TURBINE_RECIPES.recipeBuilder()
     *          .fluidInputs(GTLiteMaterials.SuperheatedSteam.getFluid(320))
     *          .fluidOutputs(Materials.DistilledWater.getFluid(64))
     *          .EUt((int) V[MV])
     *          .duration(10)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Fuel Recipe map like {@link RecipeMaps#GAS_TURBINE_FUELS},
     *     used for {@link magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities#HIGH_PRESSURE_STEAM_TURBINE},
     *     and its mega version {@link magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities#MEGA_HIGH_PRESSURE_STEAM_TURBINE}.
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
     *     GTLiteRecipeMaps.SUPERCRITICAL_STEAM_TURBINE_RECIPES.recipeBuilder()
     *          .fluidInputs(GTLiteMaterials.SupercriticalSteam.getFluid(640))
     *          .fluidOutputs(Materials.DistilledWater.getFluid(128))
     *          .EUt((int) V[EV])
     *          .duration(10)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Fuel Recipe map like {@link RecipeMaps#GAS_TURBINE_FUELS},
     *     used for {@link magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities#SUPERCRITICAL_STEAM_TURBINE},
     *     and its mega version {@link magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities#MEGA_SUPERCRITICAL_STEAM_TURBINE}.
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
     *     GTLiteRecipeMaps.BIOWARE_SIMULATOR.recipeBuilder()
     *          .notConsumable(GTLiteMetaItems.MINING_DRONE_EV.getStackForm(35))
     *          .fluidInputs(Materials.Biomass.getFluid(80000))
     *          .output(OrePrefix.dust, Materials.Naquadah, 64)
     *          .EUt(VHA[UV])
     *          .duration(2000)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Unused now, maybe just a advanced version of {@link #SIMULATOR_RECIPES}.
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
     *     GTLiteRecipeMaps.NANO_SCALE_MASK_ALIGNER_RECIPES.recipeBuilder()
     *          .notConsumable(OrePrefix.lens, GTLiteMaterials.MagnetoResonatic)
     *          .notConsumable(OrePrefix.lens, GTLiteMaterials.NdYAG)
     *          .notConsumable(OrePrefix.lens, Materials.NetherStar)
     *          .input(MetaItems.NEUTRONIUM_WAFER)
     *          .output(GTLiteMetaItems.UHASOC_WAFER, 32)
     *          .EUt(VA[LuV])
     *          .duration(50)
     *          .cleanroom(CleanroomType.CLEANROOM)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Advanced version of {@link RecipeMaps#LASER_ENGRAVER_RECIPES}.
     *     TODO use {@link RecipeMap#onRecipeBuild(Consumer)} to tweak this recipe map be advanced version of laser engraver recipes.
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
     *     GTLiteRecipeMaps.ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
     *          .input(GTLiteMetaItems.BARNARDA_C_ZOOXANTHELLAE, 2)
     *          .circuitMeta(1)
     *          .fluidInputs(Materials.Mutagen.getFluid(2))
     *          .output(GTLiteMetaItems.BARNARDA_C_ZOOXANTHELLAE, 16)
     *          .EUt(VA[UV])
     *          .duration(200)
     *          .temperature(109)
     *          .cleanroom(CleanroomType.STERILE_CLEANROOM)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Just a easy recipe for {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityAlgaeCultureTank}.
     *     TODO maybe add more common algae recipes in this recipe map.
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
     *     GTLiteRecipeMaps.BIOMASS_GENERATOR_RECIPES.recipeBuilder()
     *          .fluidInputs(Materials.FermentedBiomass.getFluid(200))
     *          .EUt((int) V[EV])
     *          .duration(20)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Simple fuel recipe map for {@link magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities#BIOMASS_GENERATOR}.
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
     *     GTLiteRecipeMaps.LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
     *          .circuitMeta(1)
     *          .notConsumable(MetaItems.ELECTRIC_PUMP_LV)
     *          .fluidOutputs(Materials.Air.getFluid(40000))
     *          .EUt(VA[HV])
     *          .duration(200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Advanced version of {@link RecipeMaps#GAS_COLLECTOR_RECIPES},
     *     please see: {@link magicbook.gtlitecore.loaders.multiblock.LargeGasCollector}.
     *     Use different circuits and electric pumps to resolve conflicts.
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
     *     GTLiteRecipeMaps.VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
     *          .notConsumable(COSMIC_MEMORY_CARD_OVERWORLD)
     *          .output(dust, Stone, 240891153)
     *          .EUt(VA[UXV])
     *          .duration(1200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Special JEI page {@link RecipeMapVirtualCosmosSimulator},
     *     like Eye of Harmony in <a href="https://github.com/GTNewHorizons/TecTech">TecTech</a>.
     *     This recipe map has 81 output slots and 18 fluid output slots.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> VIRTUAL_COSMOS_SIMULATOR_RECIPES = new RecipeMapVirtualCosmosSimulator<>("virtual_cosmos_simulator_recipes", 1, 81, 0, 18, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
     *          .notConsumable(MetaItems.QUANTUM_PROCESSOR_EV)
     *          .input(GTLiteMetaItems.WRAP_EXTREME_CIRCUIT_BOARD, 2)
     *          .input(MetaItems.QUBIT_CENTRAL_PROCESSING_UNIT_WAFER, 8)
     *          .input(MetaItems.NANO_CENTRAL_PROCESSING_UNIT_WAFER, 4)
     *          .input(GTLiteMetaItems.WRAP_ADVANCED_SMD_CAPACITOR, 6)
     *          .input(GTLiteMetaItems.WRAP_ADVANCED_SMD_TRANSISTOR, 6)
     *          .input(OrePrefix.wireGtHex, Materials.Platinum, 12)
     *          .fluidInputs(Materials.SolderingAlloy.getFluid(72 * 64))
     *          .output(MetaItems.QUANTUM_PROCESSOR_EV, 64)
     *          .EUt(VA[EV])
     *          .duration(800)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Recipe Map for {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityLargeCircuitAssemblyLine}.
     *     In this recipe map, please put not consumable item on the last slot in item input slots.
     *     Because Large Circuit Assembly Line use special ui ({@link RecipeMapLargeCircuitAssemblyLine}),
     *     you should make it on special slot on left hand.
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
     *     GTLiteRecipeMaps.DYSON_SWARM_RECIPES.recipeBuilder()
     *          .circuitMeta(2)
     *          .input(GTLiteMetaItems.DYSON_SWARM_MODULE, 4)
     *          .chancedOutput(GTLiteMetaItems.DYSON_SWARM_MODULE, 5000, 0)
     *          .chancedOutput(GTLiteMetaItems.DYSON_SWARM_MODULE, 5000, 0)
     *          .chancedOutput(GTLiteMetaItems.DYSON_SWARM_MODULE, 5000, 0)
     *          .chancedOutput(GTLiteMetaItems.DYSON_SWARM_MODULE, 5000, 0)
     *          .EUt(40000000)
     *          .duration(200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Fake fuel recipe map of {@link magicbook.gtlitecore.common.metatileentities.multi.electric.generator.MetaTileEntityDysonSwarm},
     *     TODO maybe deprecate or tweak, if redo dyson swarm in future.
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
     *     GTLiteRecipeMaps.PLANETARY_GAS_SIPHON_RECIPES.recipeBuilder()
     *          .circuitMeta(1)
     *          .notConsumable(GTLiteMetaItems.MINING_DRONE_OpV.getStackForm(64))
     *          .input(OrePrefix.pipeNormalFluid, GTLiteMaterials.CrystalMatrix, 16)
     *          .input(OrePrefix.toolHeadDrill, GTLiteMaterials.Hypogen, 8)
     *          .fluidInputs(Materials.RocketFuel.getFluid(16000))
     *          .fluidOutputs(GTLiteMaterials.Spacetime.getFluid(160000))
     *          .EUt((int) V[MAX])
     *          .duration(2000)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Please see: {@link magicbook.gtlitecore.loaders.multiblock.PlanetaryGasSiphon},
     *     may be just a easy version of {@link #SPACE_ELEVATOR_DRILLING_MODULE}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PLANETARY_GAS_SIPHON_RECIPES = new RecipeMap<>("planetary_gas_siphon_recipes", 4, 0, 1, 1, new SimpleRecipeBuilder(), false)
            .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_SPACE_ELEVATOR_DRILLING_MODULE, ProgressWidget.MoveType.VERTICAL)
            .setSound(GTSoundEvents.MINER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
     *          .input(OrePrefix.dust, GTLiteMaterials.MagnetoHydrodynamicallyConstrainedStarMatter)
     *          .input(GTLiteOrePrefix.swarm, GTLiteMaterials.Eternity, 2)
     *          .input(GTLiteMetaItems.MANIFOLD_OSCILLATORY_POWER_CELL, 4)
     *          .fluidInputs(GTLiteMaterials.Magmatter.getFluid(L))
     *          .output(OrePrefix.dust, GTLiteMaterials.Magmatter)
     *          .EUt(VA[MAX])
     *          .duration(20)
     *          .CasingTier(3)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     This recipe map used special recipe property {@link GravitonCasingTierRecipeBuilder},
     *     and predicate tier by blocks in {@link magicbook.gtlitecore.common.blocks.BlockGravitonCasing}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<GravitonCasingTierRecipeBuilder> NICOLL_DYSON_BEAMER_FORGING_MODULE = new RecipeMap<>("nicoll_dyson_beamer_forging_module", 3, 2, 1, 0, new GravitonCasingTierRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_1)
            .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, false, true, GuiTextures.IMPLOSION_OVERLAY_1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(SoundEvents.ENTITY_GENERIC_EXPLODE);

    public GTLiteRecipeMaps() {}
}