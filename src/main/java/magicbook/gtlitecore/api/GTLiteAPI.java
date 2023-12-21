package magicbook.gtlitecore.api;

import gregtech.api.util.BaseCreativeTab;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import magicbook.gtlitecore.api.block.IBlockTier;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.api.metatileentity.multi.IBatteryCellData;
import magicbook.gtlitecore.common.blocks.*;
import net.minecraft.block.state.IBlockState;

import javax.annotation.Nonnull;

import static gregtech.api.GregTechAPI.HEATING_COILS;

public class GTLiteAPI {

    //  Creative Tabs
    public static final BaseCreativeTab TAB_GTLITE = new BaseCreativeTab("gtlite", () -> { return MetaItems.BASIC_TAPE.getStackForm();}, true);

    //  Hash Maps
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_PA_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_PA_INTERNAL_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_CA_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_FIELD_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_SPACE_ELEVATOR_MOTOR = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBatteryCellData> MAP_EST_BATTERIES = new Object2ObjectOpenHashMap<>();

    public static void init() {

        //  Wire Coil Init
        for (BlockWireCoil.CoilType type : BlockWireCoil.CoilType.values()) {
            HEATING_COILS.put(GTLiteMetaBlocks.WIRE_COIL.getState(type), type);
        }

        //  Precise Assembler Casing Tier
        MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK1),
                new WrappedIntTier(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK1, 1));
        MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK2),
                new WrappedIntTier(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK2, 2));
        MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK3),
                new WrappedIntTier(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK3, 3));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.LuV),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.LuV, 1));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.ZPM),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.ZPM, 2));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.UV),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.UV, 3));

        //  Component Assembly Line Casing Tier
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.LV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.LV, 1));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.MV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.MV, 2));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.HV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.HV, 3));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.EV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.EV, 4));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.IV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.IV, 5));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.LuV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.LuV, 6));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.ZPM),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.ZPM, 7));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.UV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.UV, 8));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.UHV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.UHV, 9));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.UEV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.UEV, 10));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.UIV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.UIV, 11));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.UXV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.UXV, 12));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.OpV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.OpV, 13));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.MAX),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.MAX, 14));

        //  Field Casing Tier
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.ZPM),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.ZPM, 1));
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.UV),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.UV, 2));
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.UHV),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.UHV, 3));
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.UEV),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.UEV, 4));
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.UIV),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.UIV, 5));
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.UXV),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.UXV, 6));
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.OpV),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.OpV, 7));
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.MAX),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.MAX, 8));

        //  Space Elevator Motor Tier
        MAP_SPACE_ELEVATOR_MOTOR.put(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getState(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK1),
                new WrappedIntTier(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK1, 1));
        MAP_SPACE_ELEVATOR_MOTOR.put(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getState(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK2),
                new WrappedIntTier(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK2, 2));
        MAP_SPACE_ELEVATOR_MOTOR.put(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getState(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK3),
                new WrappedIntTier(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK3, 3));
        MAP_SPACE_ELEVATOR_MOTOR.put(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getState(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK4),
                new WrappedIntTier(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK4, 4));
        MAP_SPACE_ELEVATOR_MOTOR.put(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getState(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK5),
                new WrappedIntTier(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK5, 5));

        //  Energy Storage Tower Tier
        MAP_EST_BATTERIES.put(GTLiteMetaBlocks.BATTERY_CELL.getState(BlockBatteryCell.BatteryCellType.HV),
                new IBatteryCellData() {
                    @Override
                    public int getTier() {
                        return 3;
                    }

                    @Override
                    public long getCapacity() {
                        return 75000000L;
                    }

                    @Nonnull
                    @Override
                    public String getBatteryName() {
                        return "hv";
                    }
                });

        MAP_EST_BATTERIES.put(GTLiteMetaBlocks.BATTERY_CELL.getState(BlockBatteryCell.BatteryCellType.EV),
                new IBatteryCellData() {
                    @Override
                    public int getTier() {
                        return 4;
                    }

                    @Override
                    public long getCapacity() {
                        return 150000000L;
                    }

                    @Nonnull
                    @Override
                    public String getBatteryName() {
                        return "ev";
                    }
                });

        MAP_EST_BATTERIES.put(GTLiteMetaBlocks.BATTERY_CELL.getState(BlockBatteryCell.BatteryCellType.IV),
                new IBatteryCellData() {
                    @Override
                    public int getTier() {
                        return 5;
                    }

                    @Override
                    public long getCapacity() {
                        return 300000000L;
                    }

                    @Nonnull
                    @Override
                    public String getBatteryName() {
                        return "iv";
                    }
                });

        MAP_EST_BATTERIES.put(GTLiteMetaBlocks.BATTERY_CELL.getState(BlockBatteryCell.BatteryCellType.LuV),
                new IBatteryCellData() {
                    @Override
                    public int getTier() {
                        return 6;
                    }

                    @Override
                    public long getCapacity() {
                        return 600000000L;
                    }

                    @Nonnull
                    @Override
                    public String getBatteryName() {
                        return "luv";
                    }
                });

        MAP_EST_BATTERIES.put(GTLiteMetaBlocks.BATTERY_CELL.getState(BlockBatteryCell.BatteryCellType.ZPM),
                new IBatteryCellData() {
                    @Override
                    public int getTier() {
                        return 7;
                    }

                    @Override
                    public long getCapacity() {
                        return 1200000000L;
                    }

                    @Nonnull
                    @Override
                    public String getBatteryName() {
                        return "zpm";
                    }
                });

        MAP_EST_BATTERIES.put(GTLiteMetaBlocks.BATTERY_CELL.getState(BlockBatteryCell.BatteryCellType.UV),
                new IBatteryCellData() {
                    @Override
                    public int getTier() {
                        return 8;
                    }

                    @Override
                    public long getCapacity() {
                        return 2400000000L;
                    }

                    @Nonnull
                    @Override
                    public String getBatteryName() {
                        return "uv";
                    }
                });

        MAP_EST_BATTERIES.put(GTLiteMetaBlocks.BATTERY_CELL.getState(BlockBatteryCell.BatteryCellType.UHV),
                new IBatteryCellData() {
                    @Override
                    public int getTier() {
                        return 9;
                    }

                    @Override
                    public long getCapacity() {
                        return 4800000000L;
                    }

                    @Nonnull
                    @Override
                    public String getBatteryName() {
                        return "uhv";
                    }
                });

        MAP_EST_BATTERIES.put(GTLiteMetaBlocks.BATTERY_CELL.getState(BlockBatteryCell.BatteryCellType.UEV),
                new IBatteryCellData() {
                    @Override
                    public int getTier() {
                        return 10;
                    }

                    @Override
                    public long getCapacity() {
                        return 9600000000L;
                    }

                    @Nonnull
                    @Override
                    public String getBatteryName() {
                        return "uev";
                    }
                });

        MAP_EST_BATTERIES.put(GTLiteMetaBlocks.BATTERY_CELL.getState(BlockBatteryCell.BatteryCellType.UIV),
                new IBatteryCellData() {
                    @Override
                    public int getTier() {
                        return 11;
                    }

                    @Override
                    public long getCapacity() {
                        return 19200000000L;
                    }

                    @Nonnull
                    @Override
                    public String getBatteryName() {
                        return "uiv";
                    }
                });

        MAP_EST_BATTERIES.put(GTLiteMetaBlocks.BATTERY_CELL.getState(BlockBatteryCell.BatteryCellType.UXV),
                new IBatteryCellData() {
                    @Override
                    public int getTier() {
                        return 12;
                    }

                    @Override
                    public long getCapacity() {
                        return 38400000000L;
                    }

                    @Nonnull
                    @Override
                    public String getBatteryName() {
                        return "uxv";
                    }
                });

        MAP_EST_BATTERIES.put(GTLiteMetaBlocks.BATTERY_CELL.getState(BlockBatteryCell.BatteryCellType.OpV),
                new IBatteryCellData() {
                    @Override
                    public int getTier() {
                        return 13;
                    }

                    @Override
                    public long getCapacity() {
                        return 76800000000L;
                    }

                    @Nonnull
                    @Override
                    public String getBatteryName() {
                        return "opv";
                    }
                });

        MAP_EST_BATTERIES.put(GTLiteMetaBlocks.BATTERY_CELL.getState(BlockBatteryCell.BatteryCellType.MAX),
                new IBatteryCellData() {
                    @Override
                    public int getTier() {
                        return 14;
                    }

                    @Override
                    public long getCapacity() {
                        return Long.MAX_VALUE;
                    }

                    @Nonnull
                    @Override
                    public String getBatteryName() {
                        return "max";
                    }
                });

    }
}