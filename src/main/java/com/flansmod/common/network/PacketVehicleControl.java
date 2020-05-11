package com.flansmod.common.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import com.flansmod.common.driveables.DriveableData;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityVehicle;

public class PacketVehicleControl extends PacketDriveableControl
{
	public boolean doors;
	public float floatred;
	public float floatgreen;
	public float floatblue;
	
	public PacketVehicleControl()
	{
	}
	
	public PacketVehicleControl(EntityDriveable driveable)
	{
		super(driveable);
		EntityVehicle vehicle = (EntityVehicle)driveable;
		DriveableData data = vehicle.getDriveableData();
		doors = vehicle.varDoor;
		floatred = data.fr;
		floatgreen = data.fg;
		floatblue = data.fb;
		doors = vehicle.varDoor;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf data)
	{
		super.encodeInto(ctx, data);
		data.writeBoolean(doors);
    	data.writeFloat(floatred);
    	data.writeFloat(floatgreen);
    	data.writeFloat(floatblue);
	}
	
	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data)
	{
		super.decodeInto(ctx, data);
		doors = data.readBoolean();
		floatred = data.readFloat();
		floatgreen = data.readFloat();
		floatblue = data.readFloat();
	}
	
	@Override
	protected void updateDriveable(EntityDriveable driveable, boolean clientSide)
	{
		super.updateDriveable(driveable, clientSide);
		EntityVehicle vehicle = (EntityVehicle)driveable;
		vehicle.varDoor = doors;
		DriveableData data = vehicle.getDriveableData();
		data.fr = floatred;
		data.fg = floatgreen;
		data.fb = floatblue;
	}
}
