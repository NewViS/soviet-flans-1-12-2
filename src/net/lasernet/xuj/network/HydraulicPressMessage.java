package net.lasernet.xuj.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class HydraulicPressMessage implements IMessage
{
    private BlockPos p;

    public HydraulicPressMessage()
    {
    }

    public HydraulicPressMessage(BlockPos p)
    {
        this.p = p;
    }

    public void fromBytes(ByteBuf buf)
    {
        int i = buf.readInt();
        int j = buf.readInt();
        int k = buf.readInt();
        this.p = new BlockPos(i, j, k);
    }

    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.p.getX());
        buf.writeInt(this.p.getY());
        buf.writeInt(this.p.getZ());
    }

    public BlockPos getPos()
    {
        return this.p;
    }
}
