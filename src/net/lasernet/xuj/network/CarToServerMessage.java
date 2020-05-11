package net.lasernet.xuj.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class CarToServerMessage implements IMessage
{
    public int type;
    private int entityID;
    private float stAngle;
    private float acceltick;
    private boolean burnout;
    private boolean oversteer;

    public CarToServerMessage()
    {
    }

    public CarToServerMessage(int entityID, float stAngle, float acceltick, boolean burnout, boolean isOversteer)
    {
        this.entityID = entityID;
        this.stAngle = stAngle;
        this.acceltick = acceltick;
        this.burnout = burnout;
        this.oversteer = isOversteer;
    }

    public void fromBytes(ByteBuf buf)
    {
        this.entityID = buf.readInt();
        this.acceltick = buf.readFloat();
        this.burnout = buf.readBoolean();
        this.oversteer = buf.readBoolean();
        this.stAngle = buf.readFloat();
    }

    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.entityID);
        buf.writeFloat(this.acceltick);
        buf.writeBoolean(this.burnout);
        buf.writeBoolean(this.oversteer);
        buf.writeFloat(this.stAngle);
    }

    public int getEntityID()
    {
        return this.entityID;
    }

    public float getStAngle()
    {
        return this.stAngle;
    }

    public float getAcceltick()
    {
        return this.acceltick;
    }

    public boolean isBurnout()
    {
        return this.burnout;
    }

    public boolean isOversteer()
    {
        return this.oversteer;
    }
}
