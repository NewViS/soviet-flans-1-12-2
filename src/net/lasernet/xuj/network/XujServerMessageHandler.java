package net.lasernet.xuj.network;

import net.lasernet.xuj.entity.EntityCar;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class XujServerMessageHandler implements IMessageHandler<CarToServerMessage, IMessage>
{
    public IMessage onMessage(CarToServerMessage message, MessageContext ctx)
    {
        EntityPlayerMP entityplayermp = ctx.getServerHandler().player;

        try
        {
            EntityCar entitycar = (EntityCar)entityplayermp.getServerWorld().getEntityByID(message.getEntityID());
            entitycar.setSteeringAngle(message.getStAngle());
            entitycar.setAccelerationTick(message.getAcceltick());
            entitycar.setBurnout(message.isBurnout());
            entitycar.setOversteer(message.isOversteer());
        }
        catch (NullPointerException var5)
        {
            ;
        }

        return null;
    }
}
