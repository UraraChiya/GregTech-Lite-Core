package magicbook.gtlitecore.api.utils;

import io.netty.buffer.ByteBuf;
import magicbook.gtlitecore.integration.theoneprobe.FluidStackElement;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fluids.FluidStack;

import java.io.IOException;

/**
 * Fluid Stack Helper
 *
 * <p>
 *     This class is a completion of the class {@link FluidStack},
 *     add some interaction method about fluid stack, nbt tag and packet buffer.
 *     This class is based on MCTian-mi's work (on MIT License):
 *      <a href="https://github.com/MCTian-mi/GregicProbe">Gregic Probe</a>,
 *     and used for {@link FluidStackElement}.
 *     The thought train referred to my friend Gate Guardian's work,
 *      <a href="https://github.com/EpimorphismMC/Monazite">Monazite</a>.
 * </p>
 */
public class FluidStackHelper {

    /**
     * Read Fluid Stack Data from {@code ByteBuf}.
     *
     * @param dataIn  Data which from {@code ByteBuf}.
     * @return        Fluid Stack Data (read from {@code ByteBuf}).
     */
    public static FluidStack readFromBuf(ByteBuf dataIn) {
        PacketBuffer buf = new PacketBuffer(dataIn);
        try {
            NBTTagCompound nbt = buf.readCompoundTag();
            FluidStack fluidStack = FluidStack.loadFluidStackFromNBT(nbt);
            if (fluidStack != null) {
                fluidStack.amount = buf.readInt();
            }
            return fluidStack;
        } catch (IOException e) {
            GTLiteLog.logger.error("Cannot read fluid stack info from buffer!");
            return null;
        }
    }

    /**
     * Write Fluid Stack Data to {@code ByteBuf}.
     *
     * @param dataOut     Target buffer of data which will write to it.
     * @param fluidStack  Fluid Stack.
     */
    public static void writeToBuf(ByteBuf dataOut, FluidStack fluidStack) {
        PacketBuffer buf = new PacketBuffer(dataOut);
        NBTTagCompound nbt = new NBTTagCompound();
        fluidStack.writeToNBT(nbt);
        try {
            buf.writeCompoundTag(nbt);
            buf.writeInt(fluidStack.amount);
        } catch (Exception e) {
            GTLiteLog.logger.error("Cannot write fluid stack info to buffer!");
        }
    }
}
