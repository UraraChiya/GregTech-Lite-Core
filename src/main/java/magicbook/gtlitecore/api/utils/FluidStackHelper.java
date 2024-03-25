package magicbook.gtlitecore.api.utils;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fluids.FluidStack;

import java.io.IOException;

/**
 * Fluid Stack Helper.
 *
 * <p>
 *     This class is a completion of the class {@link FluidStack},
 *     add some interaction method about fluid stack, nbt tag and packet buffer.
 *     This class is based on MCTian-mi's work (on MIT License):
 *      <a href="https://github.com/MCTian-mi/GregicProbe">Gregic Probe</a>,
 *     and used for {@link magicbook.gtlitecore.integration.theoneprobe.FluidStackElement}.
 *     The thought train referred to my friend Gate Guardian's work,
 *      <a href="https://github.com/EpimorphismMC/Monazite">Monazite</a>.
 * </p>
 */
public class FluidStackHelper {

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
