package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

public class BlockQuantumComputerCasing extends VariantBlock<BlockQuantumComputerCasing.QCCasingType> {

    public BlockQuantumComputerCasing() {
        super(Material.IRON);
        this.setTranslationKey("quantum_computer_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(BlockQuantumComputerCasing.QCCasingType.COMPUTER_CASING));
    }

    public enum QCCasingType implements IStringSerializable {
        COMPUTER_CASING("computer_casing"),
        ADVANCED_COMPUTER_CASING("advanced_computer_casing"),
        HEAT_VENT("heat_vent");

        private final String name;

        QCCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return this.name;
        }

        @Nonnull
        @Override
        public String toString() {
            return this.getName();
        }
    }
}
