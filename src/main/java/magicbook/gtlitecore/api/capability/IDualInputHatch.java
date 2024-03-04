package magicbook.gtlitecore.api.capability;

import net.minecraft.item.ItemStack;

import java.util.Iterator;
import java.util.Optional;

public interface IDualInputHatch {
    boolean justUpdated();

    Iterator<? extends IDualInputInventory> inventories();

    void updateTexture(int id);

    void updateCraftingIcon(ItemStack icon);

    Optional<IDualInputInventory> getFirstNonEmptyInventory();

    public boolean supportsFluids();
}
