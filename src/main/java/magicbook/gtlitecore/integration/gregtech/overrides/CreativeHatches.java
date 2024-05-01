package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import magicbook.gtlitecore.common.blocks.BlockHermeticCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.Materials.SolderingAlloy;
import static gregtech.api.unification.ore.OrePrefix.circuit;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregtech.common.items.MetaItems.TOOL_DATA_MODULE;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class CreativeHatches {

    public static void init() {
        if (GTLiteConfigHolder.misc.enableCreativeRecipe) {
            //  Creative Quantum Tank
            ModHandler.addShapedRecipe(true, "quantum_tank_creative", CREATIVE_TANK.getStackForm(),
                    "XFX", "PHP", "XpX",
                    'X', new UnificationEntry(circuit, MarkerMaterials.Tier.MAX),
                    'F', FIELD_GENERATOR_MAX,
                    'P', new UnificationEntry(plate, Eternity),
                    'p', ELECTRIC_PUMP_MAX,
                    'H', GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_MAX));

            //  Creative Quantum Chest
            ModHandler.addShapedRecipe(true, "quantum_chest_creative", CREATIVE_CHEST.getStackForm(),
                    "XPX", "PHP", "XFX",
                    'H', HULL[MAX].getStackForm(),
                    'P', new UnificationEntry(plate, Eternity),
                    'X', new UnificationEntry(circuit, MarkerMaterials.Tier.MAX),
                    'F', FIELD_GENERATOR_MAX);

            //  Creative Data Hatch
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(ITEM_IMPORT_BUS[UHV])
                    .input(TOOL_DATA_MODULE, 4)
                    .input(circuit, MarkerMaterials.Tier.MAX, 4)
                    .fluidInputs(SolderingAlloy.getFluid(5760))
                    .fluidInputs(Eternity.getFluid(2880))
                    .fluidInputs(Spacetime.getFluid(1440))
                    .fluidInputs(Infinity.getFluid(576))
                    .output(CREATIVE_DATA_HATCH)
                    .stationResearch(b -> b
                            .researchStack(ADVANCED_DATA_ACCESS_HATCH.getStackForm())
                            .CWUt(16384)
                            .EUt(VA[MAX]))
                    .EUt(VA[MAX])
                    .duration(200)
                    .buildAndRegister();

            //  Creative Energy Unit
            ModHandler.addShapedRecipe(true, "creative_energy_unit", CREATIVE_ENERGY.getStackForm(),
                    "IXI", "EHS", "IPI",
                    'H', HULL[MAX].getStackForm(),
                    'I', FEMTO_PIC_CHIP,
                    'X', new UnificationEntry(circuit, MarkerMaterials.Tier.MAX),
                    'E', EMITTER_MAX,
                    'S', SENSOR_MAX,
                    'P', new UnificationEntry(plate, Eternity));
        }
    }
}
