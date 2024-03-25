package magicbook.gtlitecore.common.blocks;

import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.GTLiteAPI;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GTLiteMetaBlocks {

    public static BlockMultiblockCasing MULTIBLOCK_CASING;
    public static BlockMetalCasing METAL_CASING;
    public static BlockMachineCasing MACHINE_CASING;
    public static BlockStructureCasing STRUCTURE_CASING;
    public static BlockBoilerCasing BOILER_CASING;
    public static BlockUniqueCasing UNIQUE_CASING;
    public static BlockFusionCasing FUSION_CASING;
    public static BlockCleanroomCasing CLEANROOM_CASING;
    public static BlockPreciseAssemblerCasing PRECISE_ASSEMBLER_CASING;
    public static BlockComponentAssemblyLineCasing COMPONENT_ASSEMBLY_LINE_CASING;
    public static BlockSpaceElevatorCasing SPACE_ELEVATOR_CASING;
    public static BlockPCBFactoryCasing PCB_FACTORY_CASING;
    public static BlockComputerCasing COMPUTER_CASING;
    public static BlockActiveMultiblockCasing ACTIVE_MULTIBLOCK_CASING;
    public static BlockActiveUniqueCasing ACTIVE_UNIQUE_CASING;
    public static BlockScienceCasing SCIENCE_CASING;
    public static BlockFieldCasing FIELD_CASING;
    public static BlockWireCoil WIRE_COIL;
    public static BlockTransparentCasing TRANSPARENT_CASING;
    public static BlockExplosive EXPLOSIVE_BLOCK;
    public static BlockCrucible CRUCIBLE;
    public static BlockYottaTankCell YOTTA_TANK_CELL;
    public static BlockHermeticCasing HERMETIC_CASING;
    public static BlockDecorativeTransparentCasing DECORATIVE_TRANSPARENT_CASING;
    public static BlockCoolingCore COOLING_CORE;
    public static BlockDysonSwarmCasing DYSON_SWARM_CASING;
    public static BlockQuantumComputerCasing QUANTUM_COMPUTER_CASING;

    private GTLiteMetaBlocks() {}

    public static void init() {
        MULTIBLOCK_CASING = new BlockMultiblockCasing();
        MULTIBLOCK_CASING.setRegistryName("multiblock_casing");
        MULTIBLOCK_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        METAL_CASING = new BlockMetalCasing();
        METAL_CASING.setRegistryName("metal_casing");
        METAL_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        MACHINE_CASING = new BlockMachineCasing();
        MACHINE_CASING.setRegistryName("machine_casing");
        MACHINE_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        STRUCTURE_CASING = new BlockStructureCasing();
        STRUCTURE_CASING.setRegistryName("structure_casing");
        STRUCTURE_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        BOILER_CASING = new BlockBoilerCasing();
        BOILER_CASING.setRegistryName("boiler_casing");
        BOILER_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        UNIQUE_CASING = new BlockUniqueCasing();
        UNIQUE_CASING.setRegistryName("unique_casing");
        UNIQUE_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        FUSION_CASING = new BlockFusionCasing();
        FUSION_CASING.setRegistryName("fusion_casing");
        FUSION_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        CLEANROOM_CASING = new BlockCleanroomCasing();
        CLEANROOM_CASING.setRegistryName("cleanroom_casing");
        CLEANROOM_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        PRECISE_ASSEMBLER_CASING = new BlockPreciseAssemblerCasing();
        PRECISE_ASSEMBLER_CASING.setRegistryName("precise_assembler_casing");
        PRECISE_ASSEMBLER_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        COMPONENT_ASSEMBLY_LINE_CASING = new BlockComponentAssemblyLineCasing();
        COMPONENT_ASSEMBLY_LINE_CASING.setRegistryName("component_assembly_line_casing");
        COMPONENT_ASSEMBLY_LINE_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        SPACE_ELEVATOR_CASING = new BlockSpaceElevatorCasing();
        SPACE_ELEVATOR_CASING.setRegistryName("space_elevator_casing");
        SPACE_ELEVATOR_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        PCB_FACTORY_CASING = new BlockPCBFactoryCasing();
        PCB_FACTORY_CASING.setRegistryName("pcb_factory_casing");
        PCB_FACTORY_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        COMPUTER_CASING = new BlockComputerCasing();
        COMPUTER_CASING.setRegistryName("computer_casing");
        COMPUTER_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        ACTIVE_MULTIBLOCK_CASING = new BlockActiveMultiblockCasing();
        ACTIVE_MULTIBLOCK_CASING.setRegistryName("active_multiblock_casing");
        ACTIVE_MULTIBLOCK_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        ACTIVE_UNIQUE_CASING = new BlockActiveUniqueCasing();
        ACTIVE_UNIQUE_CASING.setRegistryName("active_unique_casing");
        ACTIVE_UNIQUE_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        SCIENCE_CASING = new BlockScienceCasing();
        SCIENCE_CASING.setRegistryName("science_casing");
        SCIENCE_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        FIELD_CASING = new BlockFieldCasing();
        FIELD_CASING.setRegistryName("field_casing");
        FIELD_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        WIRE_COIL = new BlockWireCoil();
        WIRE_COIL.setRegistryName("wire_coil");
        WIRE_COIL.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        TRANSPARENT_CASING = new BlockTransparentCasing();
        TRANSPARENT_CASING.setRegistryName("transparent_casing");
        TRANSPARENT_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        EXPLOSIVE_BLOCK = new BlockExplosive();
        EXPLOSIVE_BLOCK.setRegistryName("explosive_block");
        EXPLOSIVE_BLOCK.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        CRUCIBLE = new BlockCrucible();
        CRUCIBLE.setRegistryName("crucible");
        CRUCIBLE.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        YOTTA_TANK_CELL = new BlockYottaTankCell();
        YOTTA_TANK_CELL.setRegistryName("yotta_tank_cell");
        YOTTA_TANK_CELL.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        HERMETIC_CASING = new BlockHermeticCasing();
        HERMETIC_CASING.setRegistryName("hermetic_casing");
        HERMETIC_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK_DECORATIVE);

        DECORATIVE_TRANSPARENT_CASING = new BlockDecorativeTransparentCasing();
        DECORATIVE_TRANSPARENT_CASING.setRegistryName("decorative_transparent_casing");
        DECORATIVE_TRANSPARENT_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK_DECORATIVE);

        COOLING_CORE = new BlockCoolingCore();
        COOLING_CORE.setRegistryName("cooling_core");
        COOLING_CORE.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        DYSON_SWARM_CASING = new BlockDysonSwarmCasing();
        DYSON_SWARM_CASING.setRegistryName("dyson_swarm_casing");
        DYSON_SWARM_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);

        QUANTUM_COMPUTER_CASING = new BlockQuantumComputerCasing();
        QUANTUM_COMPUTER_CASING.setRegistryName("quantum_computer_casing");
        QUANTUM_COMPUTER_CASING.setCreativeTab(GTLiteAPI.TAB_GTLITE_BLOCK);
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(MULTIBLOCK_CASING);
        registerItemModel(METAL_CASING);
        registerItemModel(MACHINE_CASING);
        registerItemModel(STRUCTURE_CASING);
        registerItemModel(BOILER_CASING);
        registerItemModel(UNIQUE_CASING);
        registerItemModel(FUSION_CASING);
        registerItemModel(CLEANROOM_CASING);
        registerItemModel(PRECISE_ASSEMBLER_CASING);
        registerItemModel(COMPONENT_ASSEMBLY_LINE_CASING);
        registerItemModel(SPACE_ELEVATOR_CASING);
        registerItemModel(PCB_FACTORY_CASING);
        registerItemModel(COMPUTER_CASING);
        registerItemModel(SCIENCE_CASING);
        registerItemModel(FIELD_CASING);
        registerItemModel(EXPLOSIVE_BLOCK);
        registerItemModel(CRUCIBLE);
        registerItemModel(YOTTA_TANK_CELL);
        registerItemModel(HERMETIC_CASING);
        registerItemModel(DECORATIVE_TRANSPARENT_CASING);
        registerItemModel(COOLING_CORE);
        registerItemModel(DYSON_SWARM_CASING);
        registerItemModel(QUANTUM_COMPUTER_CASING);

        WIRE_COIL.onModelRegister();
        TRANSPARENT_CASING.onModelRegister();
        ACTIVE_MULTIBLOCK_CASING.onModelRegister();
        ACTIVE_UNIQUE_CASING.onModelRegister();
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            MetaBlocks.statePropertiesToString(state.getProperties())));
        }
    }
}
