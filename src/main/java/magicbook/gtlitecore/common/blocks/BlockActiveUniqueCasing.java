package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantActiveBlock;
import gregtech.api.items.toolitem.ToolClasses;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

public class BlockActiveUniqueCasing extends VariantActiveBlock<BlockActiveUniqueCasing.ActiveCasingType> {
    public BlockActiveUniqueCasing() {
        super(Material.IRON);
        setTranslationKey("active_unique_casing");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel(ToolClasses.WRENCH, 2);
        setDefaultState(this.getState(ActiveCasingType.ADVANCED_ASSEMBLY_LINE_CASING));
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum ActiveCasingType implements IStringSerializable {
        ADVANCED_ASSEMBLY_LINE_CASING("advanced_assembly_line_casing"),
        ADVANCED_ASSEMBLY_CONTROL_CASING("advanced_assembly_control_casing"),
        BIOWARE_COMPUTING_CASING("bioware_computing_casing"),
        ULTIMATE_ENGINE_INTAKE_CASING("ultimate_engine_intake_casing");
        private final String name;

        ActiveCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return this.name;
        }
    }
}
