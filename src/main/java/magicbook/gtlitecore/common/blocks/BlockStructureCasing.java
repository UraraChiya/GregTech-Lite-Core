package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class BlockStructureCasing extends VariantBlock<BlockStructureCasing.StructureCasingType> {

    public BlockStructureCasing() {
        super(Material.IRON);
        this.setTranslationKey("structure_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(StructureCasingType.MARAGING_STEEL_250_CASING));
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum StructureCasingType implements IStringSerializable {
        MARAGING_STEEL_250_CASING("maraging_steel_250_casing"),
        RURIDIT_CASING("ruridit_casing"),
        OSMIRIDIUM_CASING("osmiridium_casing"),
        ADVANCED_GRATE_CASING("advanced_grate_casing"),
        FLUXED_ELECTRUM_CASING("fluxed_electrum_casing"),
        RHODIUM_CASING("rhodium_casing"),
        NAQUADAH_ALLOY_CASING("naquadah_alloy_casing"),
        FORCE_FIELD_CONSTRAINED_CASING("force_field_constrained_casing"),
        INCOLOY_020_CASING("incoloy_020_casing"),
        TANTALUM_CARBIDE_CASING("tantalum_carbide_casing"),
        NAQUADAH_CASING("naquadah_casing"),
        NAQUADAH_GEARBOX_CASING("naquadah_gearbox_casing"),
        HATTRIUM_CASING("hattrium_casing"),
        CIRCULATIVE_COOLING_CASING("circulative_cooling_casing"),
        DURALUMINIUM_ALLOY_CASING("duraluminium_alloy_casing");

        private final String name;

        StructureCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }
    }
}
