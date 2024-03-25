package magicbook.gtlitecore.api.utils;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.util.BlockInfo;
import gregtech.api.util.TextFormattingUtil;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class GTLiteUtils {

    /**
     * @param name  Name in gtlitecore's namespace, used to init some internal things in gtlitecore.
     * @return      GregTech Lite resource location (namespace), pay attention, do not use gtliteId() in Materials init.
     */
    @Nonnull
    public static ResourceLocation gtliteId(@Nonnull String name) {
        return new ResourceLocation("gtlitecore", name);
    }

    /**
     * @param number  Long number.
     * @return        Just a rewrite of formatNumbers(), please see {@link TextFormattingUtil#formatNumbers(long)}.
     */
    public static String formatNumbers(long number) {
        return TextFormattingUtil.formatNumbers(number);
    }

    /**
     * @param number  Double number.
     * @return        Just a rewrite of formatNumbers(), please see {@link TextFormattingUtil#formatNumbers(double)}.
     */
    public static String formatNumbers(double number) {
        return TextFormattingUtil.formatNumbers(number);
    }

    /**
     * @param tag           NBT tag.
     * @param key           Key.
     * @param defaultValue  Default value.
     * @return              If tag has special key, then return integer of key (value), if not, then return default value.
     */
    public static int getOrDefault(NBTTagCompound tag,
                                   String key,
                                   int defaultValue){
        if (tag.hasKey(key)) {
            return tag.getInteger(key);
        }
        return defaultValue;
    }

    /**
     * @return  Used to check if multiblock part has tier and set its related info.
     */
    public static <T> T getOrDefault(BooleanSupplier canGet,
                                     Supplier<T> getter,
                                     T defaultValue){
        return canGet.getAsBoolean() ? getter.get() : defaultValue;
    }

    /**
     * @param lists  List.
     * @return       List size, used to get ArrayList<List<IBlockState>> in some block tier multiblocks,
     *               please see: {@link magicbook.gtlitecore.common.metatileentities.multi.electric.adv.MetaTileEntityPreciseAssembler}.
     */
    public static <T> int maxLength(List<List<T>> lists) {
        return lists.stream()
                    .mapToInt(List::size)
                    .max()
                    .orElse(0);
    }

    /**
     * @param list    List.
     * @param length  List size.
     * @return        The final list, used to recheck list of IBlockState in some block tier multiblocks,
     *                please see: {@link magicbook.gtlitecore.common.metatileentities.multi.electric.adv.MetaTileEntityPreciseAssembler}.
     */
    public static <T> List<T> consistentList(List<T> list,
                                             int length) {
        if (list.size() >= length) {
            return list;
        }
        List<T> finalList = new ArrayList<>(list);
        T last = list.get(list.size() - 1);
        for (int i = 0; i < length - list.size(); i++) {
            finalList.add(last);
        }
        return finalList;
    }

    /**
     * @param tile  MetaTileEntity.
     * @return      MetaTileEntityHolder, used to get special block info in Traceability Predicate.
     *              Please see: {@link magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate#ROTOR_HOLDER}.
     */
    public static MetaTileEntityHolder getTileEntity(MetaTileEntity tile) {
        MetaTileEntityHolder holder = new MetaTileEntityHolder();
        holder.setMetaTileEntity(tile);
        holder.getMetaTileEntity().onPlacement();
        holder.getMetaTileEntity().setFrontFacing(EnumFacing.SOUTH);
        return holder;
    }

    /**
     * @param allowedStates  Allowed Block States.
     * @return               Used to build upgrade multiblock.
     */
    public static Supplier<BlockInfo[]> getCandidates(IBlockState... allowedStates) {
        return () -> Arrays.stream(allowedStates)
                .map(state -> new BlockInfo(state, null))
                .toArray(BlockInfo[]::new);
    }

    /**
     * @param metaTileEntities  Allowed Meta Tile Entities.
     * @return                  Used to build upgrade multiblock.
     */
    public static Supplier<BlockInfo[]> getCandidates(MetaTileEntity... metaTileEntities) {
        return () -> Arrays.stream(metaTileEntities)
                .filter(Objects::nonNull)
                .map(tile -> new BlockInfo(MetaBlocks.MACHINE.getDefaultState(), getTileEntity(tile)))
                .toArray(BlockInfo[]::new);
    }

    /**
     * @param value  Int value.
     * @param min    Min value.
     * @param max    Max value.
     * @return       If value < min value, then return min, if value >= min, then return min(value, max).
     */
    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        } else {
            return Math.min(value, max);
        }
    }

    /**
     * @param value  Double value.
     * @param min    Min value.
     * @param max    Max value.
     * @return       If value < min value, then return min, if value >= min, then return min(value, max).
     */
    public static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        }else {
            return Math.min(value, max);
        }
    }

    /**
     * @param values  Long value.
     * @return        Summarized values.
     */
    public static BigInteger summarizedValue(long[] values) {
        BigInteger retValue = BigInteger.ZERO;
        long currentSum = 0;

        for (long value : values) {
            if (currentSum != 0 && value > Long.MAX_VALUE - currentSum) {
                retValue = retValue.add(BigInteger.valueOf(currentSum));
                currentSum = 0;
            }
            currentSum += value;
        }

        if (currentSum != 0) {
            retValue = retValue.add(BigInteger.valueOf(currentSum));
        }

        return retValue;
    }

    /**
     * @param stack  Item stack.
     * @return       Item stack id.
     */
    public static int stackToInt(ItemStack stack) {
        if (isStackInvalid(stack))
            return 0;
        return itemToInt(stack.getItem(), stack.getMetadata());
    }

    /**
     * @param item  Item stack.
     * @param meta  Meta data of item stack.
     * @return      Item stack id.
     */
    public static int itemToInt(Item item, int meta) {
        return Item.getIdFromItem(item) | (meta << 16);
    }

    /**
     * @param stack  Item stack.
     * @return       Check if itemstack invalid.
     */
    public static boolean isStackInvalid(Object stack) {
        return !(stack instanceof ItemStack) || ((ItemStack) stack).getCount() < 0;
    }

    /**
     * @param aStack  Item stack.
     * @return        Check if itemstack valid.
     */
    public static boolean isStackValid(Object aStack) {
        return (aStack instanceof ItemStack) && ((ItemStack) aStack).getCount() >= 0;
    }

    /**
     * @param aStack  Meta data.
     * @return        Get itemstack from meta data.
     */
    public static ItemStack intToStack(int aStack) {
        int tID = aStack & (~0 >>> 16), tMeta = aStack >>> 16;
        Item tItem = Item.getItemById(tID);
        if (tItem != null)
            return new ItemStack(tItem, 1, tMeta);
        return null;
    }

    /**
     * @param aAmount  Amount property.
     * @param aStacks  Object stack.
     * @return         Copy item stack with unsafe amount.
     */
    public static ItemStack copyAmountUnsafe(long aAmount, Object... aStacks) {
        ItemStack rStack = copy(aStacks);
        if (isStackInvalid(rStack))
            return null;
        if (aAmount > Integer.MAX_VALUE)
            aAmount = Integer.MAX_VALUE;
        else if (aAmount < 0)
            aAmount = 0;
        rStack.setCount((int) aAmount);
        return rStack;
    }

    /**
     * Rewrite of same name method in {@link ItemStack}.
     *
     * @param aStacks  Object stack.
     * @return         Copy item stack, i.e. return new item stack with the same property.
     */
    public static ItemStack copy(Object... aStacks) {
        for (Object tStack : aStacks)
            if (isStackValid(tStack))
                return ((ItemStack) tStack).copy();
        return null;
    }

}