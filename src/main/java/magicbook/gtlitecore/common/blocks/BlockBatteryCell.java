package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantBlock;
import magicbook.gtlitecore.api.metatileentity.multi.IBatteryCellData;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class BlockBatteryCell extends VariantBlock<BlockBatteryCell.BatteryCellType> {

    public BlockBatteryCell() {
        super(Material.IRON);
        this.setTranslationKey("battery_cell");
        this.setHardness(5.0F);
        this.setResistance(10.0f);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 4);
        this.setDefaultState(this.getState(BatteryCellType.HV));
    }

    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack,
                               @Nullable World world,
                               @Nonnull List<String> tooltip,
                               @Nonnull ITooltipFlag advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        BatteryCellType batteryCellType = this.getState(stack);
        tooltip.add(I18n.format("gtlitecore.machine.energy_storage_tower.cell_capacity", batteryCellType.getCapacity()));
    }

    public enum BatteryCellType implements IStringSerializable, IBatteryCellData {
        HV(3, 75000000L),
        EV(4, 150000000L),
        IV(5, 300000000L),
        LuV(6, 600000000L),
        ZPM(7, 1200000000L),
        UV(8, 2400000000L),
        UHV(9, 4800000000L),
        UEV(10, 9600000000L),
        UIV(11, 19200000000L),
        UXV(12, 38400000000L),
        OpV(13, 76800000000L),
        MAX(14, Long.MAX_VALUE);

        private final int tier;
        private final long capacity;

        private BatteryCellType(int tier, long capacity) {
            this.tier = tier;
            this.capacity = capacity;
        }

        public int getTier() {
            return this.tier;
        }

        public long getCapacity() {
            return this.capacity;
        }

        @Nonnull
        @Override
        public String getBatteryName() {
            return this.name().toLowerCase();
        }

        @Nonnull
        @Override
        public String getName() {
            return this.getBatteryName();
        }
    }
}
