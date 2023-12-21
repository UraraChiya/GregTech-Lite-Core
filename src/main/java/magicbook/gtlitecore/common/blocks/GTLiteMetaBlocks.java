package magicbook.gtlitecore.common.blocks;

import gregtech.common.blocks.MetaBlocks;
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
    public static BlockBoilerCasing BOILER_CASING;
    public static BlockUniqueCasing UNIQUE_CASING;
    public static BlockFusionCasing FUSION_CASING;
    public static BlockCleanroomCasing CLEANROOM_CASING;
    public static BlockPreciseAssemblerCasing PRECISE_ASSEMBLER_CASING;
    public static BlockComponentAssemblyLineCasing COMPONENT_ASSEMBLY_LINE_CASING;
    public static BlockSpaceElevatorCasing SPACE_ELEVATOR_CASING;
    public static BlockPCBFactoryCasing PCB_FACTORY_CASING;
    public static BlockActiveMultiblockCasing ACTIVE_MULTIBLOCK_CASING;
    public static BlockActiveUniqueCasing ACTIVE_UNIQUE_CASING;
    public static BlockScienceCasing SCIENCE_CASING;
    public static BlockFieldCasing FIELD_CASING;
    public static BlockBatteryCell BATTERY_CELL;
    public static BlockWireCoil WIRE_COIL;
    public static BlockTransparentCasing TRANSPARENT_CASING;
    public static BlockExplosive EXPLOSIVE_BLOCK;
    public static BlockCrucible CRUCIBLE;
    public static BlockHermeticCasing HERMETIC_CASING;

    private GTLiteMetaBlocks() {}

    public static void init() {
        MULTIBLOCK_CASING = new BlockMultiblockCasing();
        MULTIBLOCK_CASING.setRegistryName("multiblock_casing");
        METAL_CASING = new BlockMetalCasing();
        METAL_CASING.setRegistryName("metal_casing");
        BOILER_CASING = new BlockBoilerCasing();
        BOILER_CASING.setRegistryName("boiler_casing");
        UNIQUE_CASING = new BlockUniqueCasing();
        UNIQUE_CASING.setRegistryName("unique_casing");
        FUSION_CASING = new BlockFusionCasing();
        FUSION_CASING.setRegistryName("fusion_casing");
        CLEANROOM_CASING = new BlockCleanroomCasing();
        CLEANROOM_CASING.setRegistryName("cleanroom_casing");
        PRECISE_ASSEMBLER_CASING = new BlockPreciseAssemblerCasing();
        PRECISE_ASSEMBLER_CASING.setRegistryName("precise_assembler_casing");
        COMPONENT_ASSEMBLY_LINE_CASING = new BlockComponentAssemblyLineCasing();
        COMPONENT_ASSEMBLY_LINE_CASING.setRegistryName("component_assembly_line_casing");
        SPACE_ELEVATOR_CASING = new BlockSpaceElevatorCasing();
        SPACE_ELEVATOR_CASING.setRegistryName("space_elevator_casing");
        PCB_FACTORY_CASING = new BlockPCBFactoryCasing();
        PCB_FACTORY_CASING.setRegistryName("pcb_factory_casing");
        ACTIVE_MULTIBLOCK_CASING = new BlockActiveMultiblockCasing();
        ACTIVE_MULTIBLOCK_CASING.setRegistryName("active_multiblock_casing");
        ACTIVE_UNIQUE_CASING = new BlockActiveUniqueCasing();
        ACTIVE_UNIQUE_CASING.setRegistryName("active_unique_casing");
        SCIENCE_CASING = new BlockScienceCasing();
        SCIENCE_CASING.setRegistryName("science_casing");
        FIELD_CASING = new BlockFieldCasing();
        FIELD_CASING.setRegistryName("field_casing");
        BATTERY_CELL = new BlockBatteryCell();
        BATTERY_CELL.setRegistryName("battery_cell");
        WIRE_COIL = new BlockWireCoil();
        WIRE_COIL.setRegistryName("wire_coil");
        TRANSPARENT_CASING = new BlockTransparentCasing();
        TRANSPARENT_CASING.setRegistryName("transparent_casing");
        EXPLOSIVE_BLOCK = new BlockExplosive();
        EXPLOSIVE_BLOCK.setRegistryName("explosive_block");
        CRUCIBLE = new BlockCrucible();
        CRUCIBLE.setRegistryName("crucible");
        HERMETIC_CASING = new BlockHermeticCasing();
        HERMETIC_CASING.setRegistryName("hermetic_casing");
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(MULTIBLOCK_CASING);
        registerItemModel(METAL_CASING);
        registerItemModel(BOILER_CASING);
        registerItemModel(UNIQUE_CASING);
        registerItemModel(FUSION_CASING);
        registerItemModel(CLEANROOM_CASING);
        registerItemModel(PRECISE_ASSEMBLER_CASING);
        registerItemModel(COMPONENT_ASSEMBLY_LINE_CASING);
        registerItemModel(SPACE_ELEVATOR_CASING);
        registerItemModel(PCB_FACTORY_CASING);
        registerItemModel(SCIENCE_CASING);
        registerItemModel(FIELD_CASING);
        registerItemModel(BATTERY_CELL);
        registerItemModel(EXPLOSIVE_BLOCK);
        registerItemModel(CRUCIBLE);
        registerItemModel(HERMETIC_CASING);

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
