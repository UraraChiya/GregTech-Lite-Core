package magicbook.gtlitecore.loaders;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;

import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.*;

public class MachineRecipeLoader {
    public static void init() {
        SingleMachineRecipes();
        MultiblockControllerRecipes();
    }

    private static void SingleMachineRecipes() {

        //  Chemical Dryer
        MetaTileEntityLoader.registerMachineRecipe(true, CHEMICAL_DRYER,
                "WCW", "SHS", "WCW",
                'W', CraftingComponent.CABLE,
                'C', CraftingComponent.CIRCUIT,
                'S', CraftingComponent.SPRING,
                'H', CraftingComponent.HULL);

        //  TODO Steam Vacuum Chamber

        //  Vacuum Chamber
        MetaTileEntityLoader.registerMachineRecipe(true, VACUUM_CHAMBER,
                "GCG", "PHP", "GWG",
                'W', CraftingComponent.CABLE,
                'C', CraftingComponent.CIRCUIT,
                'P', CraftingComponent.PUMP,
                'G', CraftingComponent.GLASS,
                'H', CraftingComponent.HULL);

    }

    private static void MultiblockControllerRecipes() {

        //  Industrial Drilling Reg
        ModHandler.addShapedRecipe(true, "industrial_drilling_reg", INDUSTRIAL_DRILLING_REG.getStackForm(),
                "PKP", "CHC", "MMM",
                'P', ELECTRIC_PISTON_UV.getStackForm(),
                'K', new UnificationEntry(cableGtQuadruple, YttriumBariumCuprate),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'H', HULL[UV].getStackForm(),
                'M', ELECTRIC_MOTOR_UV.getStackForm());

        //  Catalytic Reformer
        ModHandler.addShapedRecipe(true, "catalytic_reformer", CATALYTIC_REFORMER.getStackForm(),
                "MCM", "PHP", "MKM",
                'M', new UnificationEntry(pipeNormalFluid, StainlessSteel),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'P', ELECTRIC_PUMP_EV.getStackForm(),
                'H', HULL[EV].getStackForm(),
                'K', new UnificationEntry(cableGtDouble, Aluminium));

        //  Sonicator
        ModHandler.addShapedRecipe(true, "sonicator", SONICATOR.getStackForm(),
                "LFL", "PHP", "CPC",
                'L', new UnificationEntry(pipeLargeFluid, Naquadah),
                'F', FIELD_GENERATOR_UV.getStackForm(),
                'P', ELECTRIC_PUMP_UV.getStackForm(),
                'H', HULL[UV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UV));

        //  Hydraulic Fracker
        ModHandler.addShapedRecipe(true, "fracker", HYDRAULIC_FRACKER.getStackForm(),
                "CLC", "GHG", "PPP",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UV),
                'L', new UnificationEntry(pipeLargeFluid, Naquadah),
                'G', new UnificationEntry(gear, NaquadahAlloy),
                'H', HULL[ZPM].getStackForm(),
                'P', ELECTRIC_PUMP_ZPM.getStackForm());

        //  Nanoscale Fabricator
        ModHandler.addShapedRecipe(true, "nanoscale_fabricator", NANOSCALE_FABRICATOR.getStackForm(),
                "KSK", "EHE", "CFC",
                'K', new UnificationEntry(cableGtSingle, Europium),
                'S', SENSOR_UHV.getStackForm(),
                'E', EMITTER_UHV.getStackForm(),
                'H', HULL[UHV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UEV),
                'F', FIELD_GENERATOR_UHV.getStackForm());

        //  Roaster
        ModHandler.addShapedRecipe(true, "roaster", INDUSTRIAL_ROASTER.getStackForm(),
                "KSK", "CHC", "PPP",
                'K', new UnificationEntry(cableGtQuadruple, Platinum),
                'S', new UnificationEntry(spring, Tungsten),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'H', HULL[EV].getStackForm(),
                'P', new UnificationEntry(plate, TitaniumCarbide));

        //  Crystallization Crucible
        ModHandler.addShapedRecipe(true, "crystallization_crucible", CRYSTALLIZATION_CRUCIBLE.getStackForm(),
                "CMC", "LHL", "PCP",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'M', new UnificationEntry(plateDouble, MolybdenumDisilicide),
                'L', new UnificationEntry(pipeNormalFluid, Titanium),
                'H', HULL[EV].getStackForm(),
                'P', new UnificationEntry(plate, Titanium));

        //  CVD Unit
        ModHandler.addShapedRecipe(true, "cvd_unit", CVD_UNIT.getStackForm(),
                "PKP", "CHC", "ESE",
                'P', new UnificationEntry(plate, BlueSteel),
                'K', new UnificationEntry(cableGtSingle, Aluminium),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'H', HULL[EV].getStackForm(),
                'S', SENSOR_EV.getStackForm(),
                'E', EMITTER_EV.getStackForm());

        //  Plasma CVD Unit
        //ModHandler.addShapedRecipe(true, "plasma_cvd_unit", PLASMA_CVD_UNIT.getStackForm(),
        //        "PKP", "CHC", "ESE",
        //        'P', new UnificationEntry(plate, Vibranium),
        //        'K', new UnificationEntry(cableGtSingle, SiliconCarbide),
        //        'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UEV),
        //        'H', HULL[UHV].getStackForm(),
        //        'S', SENSOR_UHV.getStackForm(),
        //        'E', EMITTER_UHV.getStackForm());

        //  Laser CVD Unit
        //ModHandler.addShapedRecipe(true, "laser_cvd_unit", LASER_CVD_UNIT.getStackForm(),
        //        "EOE", "CHC", "PPP",
        //        'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UEV),
        //        'H', HULL[UHV].getStackForm(),
        //        'P', new UnificationEntry(plate, Orichalcum),
        //        'E', EMITTER_UHV.getStackForm(),
        //        'O', OPTICAL_FIBER.getStackForm()
        //);

        //  Burner Reactor
        ModHandler.addShapedRecipe(true, "burner_reactor", BURNER_REACTOR.getStackForm(),
                "KRK", "IHI", "CMC",
                'K', new UnificationEntry(cableGtSingle, Platinum),
                'R', new UnificationEntry(rotor, TungstenSteel),
                'I', new UnificationEntry(pipeSmallFluid, Tungsten),
                'H', HULL[IV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'M', ELECTRIC_MOTOR_IV.getStackForm());

        //  Cryogenic Reactor
        ModHandler.addShapedRecipe(true, "cryogenic_reactor", CRYOGENIC_REACTOR.getStackForm(),
                "KRK", "IHI", "CWC",
                'K', new UnificationEntry(cableGtSingle, Platinum),
                'R', new UnificationEntry(rotor, Titanium),
                'I', new UnificationEntry(pipeSmallFluid, StainlessSteel),
                'H', HULL[IV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'W', ELECTRIC_PUMP_IV.getStackForm());
    }
}
