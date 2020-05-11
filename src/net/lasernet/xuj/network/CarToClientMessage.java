package net.lasernet.xuj.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class CarToClientMessage implements IMessage
{
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public int type;
    private int entityID;
    private int color;
    private byte[] carparts;
    private float stAngle;
    private float acceltick;
    private boolean burnout;
    private boolean oversteer;
    private String player;
    private NBTTagCompound fuel;

    public CarToClientMessage()
    {
    }

    public CarToClientMessage(int entityID, String player, int color, float stAngle, NBTTagCompound fuel)
    {
        this.entityID = entityID;
        this.player = player;
        this.type = 0;
        this.color = color;
        this.stAngle = stAngle;
        this.fuel = fuel;
    }

    public CarToClientMessage(int entityID, String player, int color, byte[] carparts, float stAngle, NBTTagCompound fuel)
    {
        this.entityID = entityID;
        this.player = player;
        this.type = 1;
        this.color = color;
        this.carparts = carparts;
        this.stAngle = stAngle;
        this.fuel = fuel;
    }

    public CarToClientMessage(int entityID, String player, float stAngle, float acceltick, boolean burnout, boolean oversteer, NBTTagCompound fuel)
    {
        this.entityID = entityID;
        this.player = player;
        this.type = 2;
        this.stAngle = stAngle;
        this.acceltick = acceltick;
        this.burnout = burnout;
        this.oversteer = oversteer;
        this.fuel = fuel;
    }

    public void fromBytes(ByteBuf buf)
    {
        this.entityID = buf.readInt();
        this.type = buf.readInt();
        byte[] abyte = new byte[buf.readInt()];

        if (abyte.length > 0)
        {
            buf.readBytes(abyte);
            this.player = new String(abyte);
        }

        try
        {
            byte[] abyte1 = new byte[buf.readInt()];
            buf.readBytes(abyte1);
            this.fuel = JsonToNBT.getTagFromJson(new String(abyte1));
        }
        catch (NBTException nbtexception)
        {
            nbtexception.printStackTrace();
        }

        if (this.type != 2)
        {
            this.color = buf.readInt();
        }
        else
        {
            this.acceltick = buf.readFloat();
            this.burnout = buf.readBoolean();
            this.oversteer = buf.readBoolean();
        }

        try
        {
            this.stAngle = buf.readFloat();
        }
        catch (IndexOutOfBoundsException var5)
        {
            ;
        }

        try
        {
            if (this.type == 1)
            {
                this.carparts = new byte[buf.readInt()];
                buf.readBytes(this.carparts);
            }
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            indexoutofboundsexception.printStackTrace();
        }
    }

    public void toBytes(ByteBuf buf)
    {
        if (this.player == null)
        {
            this.player = "";
        }

        buf.writeInt(this.entityID);
        buf.writeInt(this.type);
        buf.writeInt(this.player.length());

        if (this.player.length() > 0)
        {
            buf.writeBytes(this.player.getBytes());
        }

        buf.writeInt(this.fuel.toString().getBytes().length);
        buf.writeBytes(this.fuel.toString().getBytes());

        if (this.type != 2)
        {
            buf.writeInt(this.color);
        }
        else
        {
            buf.writeFloat(this.acceltick);
            buf.writeBoolean(this.burnout);
            buf.writeBoolean(this.oversteer);
        }

        buf.writeFloat(this.stAngle);

        if (this.type == 1)
        {
            buf.writeInt(this.carparts.length);
            buf.writeBytes(this.carparts);
        }
    }

    public String getPlayer()
    {
        return this.player;
    }

    public NBTTagCompound getFuel()
    {
        return this.fuel;
    }

    public int getEntityID()
    {
        return this.entityID;
    }

    public int getColor()
    {
        return this.color;
    }

    public byte[] getCarparts()
    {
        return this.carparts;
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
