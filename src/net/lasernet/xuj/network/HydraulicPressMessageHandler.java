package net.lasernet.xuj.network;

import net.lasernet.xuj.blocks.TileEntityHydraulicPress;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class HydraulicPressMessageHandler implements IMessageHandler<HydraulicPressMessage, IMessage>
{
    public IMessage onMessage(HydraulicPressMessage message, MessageContext ctx)
    {
        EntityPlayerMP entityplayermp = ctx.getServerHandler().player;

        try
        {
            TileEntityHydraulicPress tileentityhydraulicpress = (TileEntityHydraulicPress)entityplayermp.getServerWorld().getTileEntity(message.getPos());
            tileentityhydraulicpress.doPressing();
        }
        catch (NullPointerException var5)
        {
            ;
        }

        return null;
    }
}
