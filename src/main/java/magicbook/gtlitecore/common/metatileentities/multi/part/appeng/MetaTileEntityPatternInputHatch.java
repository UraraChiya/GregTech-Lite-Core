package magicbook.gtlitecore.common.metatileentities.multi.part.appeng;

import appeng.api.AEApi;
import appeng.api.implementations.ICraftingPatternItem;
import appeng.api.implementations.IPowerChannelState;
import appeng.api.networking.GridFlags;
import appeng.api.networking.IGridNode;
import appeng.api.networking.crafting.ICraftingPatternDetails;
import appeng.api.networking.crafting.ICraftingProvider;
import appeng.api.networking.crafting.ICraftingProviderHelper;
import appeng.api.storage.IMEMonitor;
import appeng.api.storage.channels.IFluidStorageChannel;
import appeng.api.storage.channels.IItemStorageChannel;
import appeng.api.storage.data.IAEFluidStack;
import appeng.api.storage.data.IAEItemStack;
import appeng.api.util.AEPartLocation;
import appeng.api.util.DimensionalCoord;
import appeng.helpers.ICustomNameObject;
import appeng.helpers.ItemStackHelper;
import appeng.me.GridAccessException;
import appeng.me.helpers.AENetworkProxy;
import appeng.me.helpers.BaseActionSource;
import appeng.me.helpers.IGridProxyable;
import appeng.util.Platform;
import com.glodblock.github.common.item.ItemFluidPacket;
import com.glodblock.github.common.item.fake.FakeItemRegister;
import gregtech.api.GTValues;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.common.metatileentities.multi.multiblockpart.appeng.MetaTileEntityAEHostablePart;
import magicbook.gtlitecore.api.capability.IDualInputHatch;
import magicbook.gtlitecore.api.capability.IDualInputInventory;
import magicbook.gtlitecore.api.capability.ISharedItemGetter;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fluids.FluidStack;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public class MetaTileEntityPatternInputHatch extends MetaTileEntityAEHostablePart implements IPowerChannelState, ICraftingProvider, IGridProxyable, IDualInputHatch, ICustomNameObject {

    //  inventory is used for storing patterns, circuit and manual slot (typically not consumable items).
    private static final int MAX_PATTERN_COUNT = 4 * 9;
    private static final int SLOT_MANUAL_SIZE = 9;
    private static final int MAX_INV_COUNT = MAX_PATTERN_COUNT + SLOT_MANUAL_SIZE + 1;
    private static final int SLOT_CIRCUIT = MAX_PATTERN_COUNT;
    private static final int SLOT_MANUAL_START = SLOT_CIRCUIT + 1;
    private static final int MANUAL_SLOT_WINDOW = 10;
    private BaseActionSource requestSource = null;
    private @Nullable AENetworkProxy gridProxy = null;

    //  holds all internal inventories.
    private PatternSlot[] internalInventory = new PatternSlot[MAX_PATTERN_COUNT];

    //  hash map for faster look up of pattern slots, not necessarily all valid.
    private Map<ICraftingPatternDetails, PatternSlot> patternDetailsPatternSlotMap = new HashMap<>(MAX_PATTERN_COUNT);

    private boolean needPatternSync = true;
    private boolean justHadNewItems = false;

    private String customName = null;
    private boolean supportFluids;
    private boolean additionalConnection = false;

    public MetaTileEntityPatternInputHatch(ResourceLocation metaTileEntityId,
                                           int tier,
                                           boolean isExportHatch,
                                           boolean supportFluids) {
        super(metaTileEntityId, GTValues.LuV, false);
        this.supportFluids = supportFluids;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityPatternInputHatch(metaTileEntityId, GTValues.LuV, isExportHatch, supportFluids);
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }

    @Override
    public boolean isPowered() {
        return getProxy() != null && getProxy().isPowered();
    }

    @Nullable
    @Override
    public IGridNode getGridNode(@Nonnull AEPartLocation aePartLocation) {
        return Objects.requireNonNull(getProxy()).getNode();
    }

    @Override
    public AENetworkProxy getProxy() {
        if (gridProxy == null) {
            gridProxy = new AENetworkProxy(this, "proxy", MetaTileEntities.PATTERN_INPUT_HATCH.getItemStack(), true);
            gridProxy.setFlags(GridFlags.REQUIRE_CHANNEL);
            updateValidGridProxySides();
        }
        return this.gridProxy;
    }

    private void updateValidGridProxySides() {
        Objects.requireNonNull(getProxy()).setValidSides(EnumSet.of(getFrontFacing()));
    }

    @Override
    public DimensionalCoord getLocation() {
        return new DimensionalCoord(Objects.requireNonNull(this.getWorld().getTileEntity(getPos())));
    }

    @Override
    public void securityBreak() {

    }

    @Override
    public void provideCrafting(ICraftingProviderHelper iCraftingProviderHelper) {

    }

    @Override
    public boolean pushPattern(ICraftingPatternDetails iCraftingPatternDetails, InventoryCrafting inventoryCrafting) {
        return false;
    }

    @Override
    public boolean isBusy() {
        return false;
    }

    @Override
    public String getCustomInventoryName() {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public void setCustomName(String s) {

    }

    @Override
    public boolean isWorkingEnabled() {
        return false;
    }

    @Override
    public void setWorkingEnabled(boolean b) {

    }

    @Override
    public boolean justUpdated() {
        return false;
    }

    @Override
    public Iterator<? extends IDualInputInventory> inventories() {
        return null;
    }

    @Override
    public void updateTexture(int id) {

    }

    @Override
    public void updateCraftingIcon(ItemStack icon) {

    }

    @Override
    public Optional<IDualInputInventory> getFirstNonEmptyInventory() {
        return Optional.empty();
    }

    @Override
    public boolean supportsFluids() {
        return false;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
        //  save internal inventory
        NBTTagList internalInventoryNbt = new NBTTagList();
        for (int i = 0; i < internalInventory.length; i++) {
            if (internalInventory[i] != null) {
                NBTTagCompound internalInventorySlotNbt = new NBTTagCompound();
                internalInventorySlotNbt.setInteger("patternSlot", i);
                internalInventorySlotNbt.setTag("patternSlotNBT", internalInventory[i].writeToNBT(new NBTTagCompound()));
                internalInventoryNbt.appendTag(internalInventorySlotNbt);
            }
        }
        nbtTagCompound.setTag("internalInventory", internalInventoryNbt);
        if (customName != null)
            nbtTagCompound.setString("customName", customName);
        Objects.requireNonNull(getProxy()).writeToNBT(nbtTagCompound);
        return nbtTagCompound;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        //  load internal inventory
        NBTTagList internalInventoryNbt = nbtTagCompound.getTagList("internalInventory", Constants.NBT.TAG_COMPOUND);
        for (int i = 0; i < internalInventoryNbt.tagCount(); i++) {
            NBTTagCompound internalInventorySlotNbt = internalInventoryNbt.getCompoundTagAt(i);
            int patternSlot = internalInventorySlotNbt.getInteger("patternSlot");
            NBTTagCompound patternSlotNbt = internalInventorySlotNbt.getCompoundTag("patternSlotNBT");
            ItemStack pattern = ItemStackHelper.stackFromNBT(patternSlotNbt.getCompoundTag("pattern"));
            if (pattern != null) {
                internalInventory[patternSlot] = new PatternSlot(pattern, patternSlotNbt, this.getWorld(), this::getSharedItems);
            } else {
                GTLiteLog.logger.warn("An error occurred while loading contents of ME Pattern Input Hatch. This pattern has been voided: " + patternSlotNbt);
            }
        }

        //public ItemStack[] getSharedItems() {
        //    ItemStack[] sharedItems = new ItemStack[SLOT_MANUAL_SIZE + 1];
        //    sharedItems[0] = mInventory[SLOT_CIRCUIT];
        //    System.arraycopy(mInventory, SLOT_MANUAL_START, sharedItems, 1, SLOT_MANUAL_SIZE);
        //    return withoutNulls(sharedItems, ItemStack[]::new);
        //}

        //  migrate from 4×8 to 4×9 pattern inventory
        int oldPatternCount = 4 * 8;
        int oldSlotManual = oldPatternCount + 1;
        int oldSlotCircuit = oldPatternCount;

        //if (internalInventory[oldSlotManual] == null) {
        //}

        //if (internalInventory[oldSlotCircuit] == null) {
        //}

        //  reconstruct patternDetailsPatternSlotMap
        patternDetailsPatternSlotMap.clear();
        for (PatternSlot patternSlot : internalInventory) {
            if (patternSlot != null) {
                patternDetailsPatternSlotMap.put(patternSlot.getPatternDetails(), patternSlot);
            }
        }

        if (nbtTagCompound.hasKey("customName"))
            customName = nbtTagCompound.getString("customName");
        additionalConnection = nbtTagCompound.getBoolean("additionalConnection");
        Objects.requireNonNull(getProxy()).readFromNBT(nbtTagCompound);
    }

    //  This inner class build internal inventory of each pattern slot (in the pattern input hatch).
    public static class PatternSlot implements IDualInputInventory {
        private final ItemStack pattern;
        private final ICraftingPatternDetails patternDetails;
        private final List<ItemStack> itemInventory;
        private final List<FluidStack> fluidInventory;
        private final ISharedItemGetter sharedItemGetter;

        public PatternSlot(ItemStack pattern,
                           World world,
                           ISharedItemGetter getter) {
            this.pattern = pattern;
            this.patternDetails = ((ICraftingPatternItem) Objects.requireNonNull(pattern.getItem())).getPatternForItem(pattern, world);
            this.itemInventory = new ArrayList<>();
            this.fluidInventory = new ArrayList<>();
            this.sharedItemGetter = getter;
        }

        public PatternSlot(ItemStack pattern,
                           NBTTagCompound nbt,
                           World world,
                           ISharedItemGetter getter) {
            this.pattern = pattern;
            this.patternDetails = ((ICraftingPatternItem) Objects.requireNonNull(pattern.getItem())).getPatternForItem(pattern, world);
            this.itemInventory = new ArrayList<>();
            this.fluidInventory = new ArrayList<>();
            this.sharedItemGetter = getter;

            //  item inventory
            NBTTagList inventory = nbt.getTagList("inventory", Constants.NBT.TAG_COMPOUND);
            //  check all inventory tags.
            for (int i = 0; i < inventory.tagCount(); i++) {
                NBTTagCompound tagCompound = inventory.getCompoundTagAt(i);
                //  fixme this transform is unchecked...I want to get a item from nbt, but idk what can i do...
                //var itemStack = loadItem(tagCompound, tagCompound.toString()); //  fixme idk why ItemStack does not has loadItemStackFromNBT() method as same as FluidStack class.

                //  testing fix! use ae2 method!
                var itemStack = ItemStackHelper.stackFromNBT(tagCompound);

                //  if item stack is not null, then add items to item inventory.
                if (itemStack != null) {
                    if (itemStack.getMaxStackSize() > 0) {
                        itemInventory.add(itemStack);
                    }
                } else {
                    GTLiteLog.logger.warn("An error occurred while loading contents of ME Pattern Input Hatch. This item has been voided: " + tagCompound);
                }
            }

            //  fluid inventory
            NBTTagList inventoryFluid = nbt.getTagList("fluidInventory", Constants.NBT.TAG_COMPOUND);
            //  check all fluid inventory tag, same as above.
            for (int i = 0; i < inventoryFluid.tagCount(); i++) {
                NBTTagCompound tagCompound = inventoryFluid.getCompoundTagAt(i);
                var fluidStack = FluidStack.loadFluidStackFromNBT(tagCompound);
                //  if fluid stack is not null, then add fluids to fluid inventory.
                if (fluidStack != null) {
                    if (fluidStack.amount > 0) {
                        fluidInventory.add(fluidStack);
                    }
                } else {
                    GTLiteLog.logger.warn("An error occurred while loading contents of ME Pattern Input Hatch. This fluid has been voided: " + tagCompound);
                }
            }
        }

        //  fixme how can i fix this method? i need a method to load item stack from nbt tag.
        //public static ItemStack loadItem(NBTTagCompound nbtTagCompound,
        //                                 String tagName) {
        //    return loadItem(nbtTagCompound.getCompoundTag(tagName), tagName);
        //}

        public boolean hasChanged(ItemStack newPattern,
                                  World world) {
            return newPattern == null || (!ItemStack.areItemStacksEqual(pattern, newPattern) && !this.patternDetails.equals(((ICraftingPatternItem) Objects.requireNonNull(pattern.getItem())).getPatternForItem(newPattern, world)));
        }

        //  if (one unit, e.g. 1, 1L,...) item/fluid is empty, then it should be safe to assume all other is empty,
        //  or at least won;t require a recipe check, as long as the pattern is ane.
        private boolean isEmpty() {
            if (!itemInventory.isEmpty())
                return itemInventory.get(0) == null || itemInventory.get(0).getMaxStackSize() <= 0;
            if (!fluidInventory.isEmpty())
                return fluidInventory.get(0) == null || fluidInventory.get(0).amount <= 0;
            return true;
        }

        @Override
        public ItemStack[] getItemInputs() {
            if (isEmpty())
                return new ItemStack[0];
            return ArrayUtils.addAll(itemInventory.toArray(new ItemStack[0]), sharedItemGetter.getSharedItem());
        }

        @Override
        public FluidStack[] getFluidInputs() {
            if (isEmpty())
                return new FluidStack[0];
            return fluidInventory.toArray(new FluidStack[0]);
        }

        public ICraftingPatternDetails getPatternDetails() {
            return patternDetails;
        }

        public void refund(AENetworkProxy proxy,
                           BaseActionSource src) throws GridAccessException {
            //  item storage
            IMEMonitor<IAEItemStack> sg = proxy.getStorage().getInventory(AEApi.instance().storage().getStorageChannel(IItemStorageChannel.class));
            //  check items in item inventory, powered it in AE2 item storage channel (hmmm...todo and fixme this method maybe have some problems).
            for (ItemStack itemStack : itemInventory) {
                if (itemStack == null || itemStack.getMaxStackSize() == 0)
                    continue;
                IAEItemStack rest = Platform.poweredInsert(proxy.getEnergy(), sg, Objects.requireNonNull(AEApi.instance().storage().getStorageChannel(IItemStorageChannel.class).createStack(itemStack)), src);
                //  fixme maybe needs to AT this parameter, i.e. itemStack.stackSize (this parameter is private).
                var count = itemStack.getCount();
                count = rest != null && rest.getStackSize() > 0 ? (int) rest.getStackSize() : 0;
            }

            //  fluid storage
            IMEMonitor<IAEFluidStack> fsg = proxy.getStorage().getInventory(AEApi.instance().storage().getStorageChannel(IFluidStorageChannel.class));
            //  check fluids in fluid inventory, powered it in AE2 fluid storage channel
            for (FluidStack fluidStack : fluidInventory) {
                if (fluidStack == null || fluidStack.amount == 0)
                    continue;
                IAEFluidStack rest = Platform.poweredInsert(proxy.getEnergy(), fsg, Objects.requireNonNull(AEApi.instance().storage().getStorageChannel(IFluidStorageChannel.class).createStack(fluidStack)), src);
                fluidStack.amount = rest != null & rest.getStackSize() > 0 ? (int) rest.getStackSize() : 0;
            }
        }

        public boolean insertItemsAndFluids(InventoryCrafting inventoryCrafting) {
            int errorIndex = -1; //  overflow may occur at this index
            for (int i = 0; i <inventoryCrafting.getSizeInventory(); i++) {
                ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
                if (itemStack == null)
                    continue;
                boolean inserted = false;
                if (itemStack.getItem() instanceof ItemFluidPacket) { // insert fluid (from AE2FC)
                    // var fluidStack = ItemFluidPacket.isFluidPacket(itemStack); // fixme how can i get fluid stack by item stack

                    //  testing fix
                    var fluidStack = (FluidStack) FakeItemRegister.getStack(itemStack);
                    if (fluidStack == null)
                        continue;

                    for (var fluid : fluidInventory) {
                        if (!fluid.isFluidEqual(fluidStack))
                            continue;
                        if (Integer.MAX_VALUE - fluidStack.amount < fluid.amount) {
                            errorIndex = i; //  overflow detected
                            break;
                        }
                        fluid.amount += fluidStack.amount;
                        inserted = true;
                        break;
                    }
                    if (errorIndex != -1)
                        break;
                    if (!inserted)
                        fluidInventory.add(fluidStack);
                } else { // insert item
                    for (var item : itemInventory) {
                        if (!itemStack.isItemEqual(item))
                            continue;
                        if (Integer.MAX_VALUE - itemStack.getMaxStackSize() < item.getCount()) {
                            errorIndex = i; //  overflow detected
                            break;
                        }
                        var count = item.getCount();
                        count += item.getCount();
                        inserted = true;
                        break;
                    }
                    if (errorIndex != -1)
                        break;
                    if (!inserted)
                        itemInventory.add(itemStack);
                }
            }
            if (errorIndex != -1) { //  need to rollback
                //  clean up the inserted items/fluids
                for (int i = 0; i < errorIndex; ++i) {
                    var itemStack = inventoryCrafting.getStackInSlot(i);
                    if (itemStack == null)
                        continue;
                    if (itemStack.getItem() instanceof ItemFluidPacket) { //  remove fluid
                        var fluidStack = (FluidStack) FakeItemRegister.getStack(itemStack);
                        if (fluidStack == null)
                            continue;
                        for (var fluid : fluidInventory) {
                            if (fluid.isFluidEqual(fluidStack)) {
                                fluid.amount -= fluidStack.amount;
                                break;
                            }
                        }
                    } else { //  remove item
                        for (var item : itemInventory) {
                            if (item.isItemEqual(itemStack)) {
                                var count = item.getCount();
                                count -= item.getCount();
                                break;
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound) {
            //  Pattern NBT
            nbtTagCompound.setTag("pattern", pattern.writeToNBT(new NBTTagCompound()));

            //  Item Inventory NBT
            NBTTagList itemInventoryNbt = new NBTTagList();
            for (ItemStack itemStack : this.itemInventory) {
                itemInventoryNbt.appendTag(saveItem(itemStack));
            }
            nbtTagCompound.setTag("inventory", itemInventoryNbt);

            //  Fluid Inventory NBT
            NBTTagList fluidInventoryNbt = new NBTTagList();
            for (FluidStack fluidStack : this.fluidInventory) {
                fluidInventoryNbt.appendTag(fluidStack.writeToNBT(new NBTTagCompound()));
            }
            nbtTagCompound.setTag("fluidInventory", fluidInventoryNbt);
            return nbtTagCompound;
        }

        public static void saveItem(NBTTagCompound aParentTag,
                                    String aTagName,
                                    ItemStack aStack) {
            if (aStack != null)
                aParentTag.setTag(aTagName, saveItem(aStack));
        }

        public static NBTTagCompound saveItem(ItemStack aStack) {
            if (aStack == null)
                return new NBTTagCompound();
            NBTTagCompound t = new NBTTagCompound();
            aStack.writeToNBT(t);
            if (aStack.getCount() > Byte.MAX_VALUE)
                t.setInteger("Count", aStack.getCount());
            return t;
        }
    }

}
