package net.lasernet.xuj.network;

import net.lasernet.xuj.entity.EntityCar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class XujClientMessageHandler implements IMessageHandler<CarToClientMessage, IMessage>
{
    public IMessage onMessage(CarToClientMessage message, MessageContext ctx)
    {
        WorldClient worldclient = Minecraft.getMinecraft().world;

        try
        {
            Entity entity = worldclient.getEntityByID(message.getEntityID());

            if (entity == null)
            {
                System.out.println("Entity null for id" + message.getEntityID());
                return null;
            }

            if (!(entity instanceof EntityCar))
            {
                System.out.println("Entity not a car for id" + message.getEntityID());
                return null;
            }

            EntityCar entitycar = (EntityCar)entity;

            if (message.type != 2)
            {
                entitycar.setColor(message.getColor());
            }

            if (message.type == 1)
            {
                entitycar.setCarParts(message.getCarparts());
            }

            entitycar.setActivePlayer(message.getPlayer());

            if (!entitycar.isActiveClient())
            {
                entitycar.setSteeringAngle(message.getStAngle());

                if (message.type == 2)
                {
                    entitycar.setBurnout(message.isBurnout());
                    entitycar.setOversteer(message.isOversteer());
                    entitycar.setAccelerationTick(message.getAcceltick());
                }
            }

            if (message.getFuel() != null)
            {
                entitycar.setFuel(message.getFuel());
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return null;
    }
}
