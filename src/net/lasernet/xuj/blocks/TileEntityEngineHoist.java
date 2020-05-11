package net.lasernet.xuj.blocks;

import net.lasernet.xuj.carparts.CarPart;
import net.lasernet.xuj.carparts.CarPartEngine;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityEngineHoist extends TileEntity
{
    protected CarPartEngine engine = null;

    public CarPartEngine getEngine()
    {
        return this.engine;
    }

    public void onLoad()
    {
        this.world.markBlockRangeForRenderUpdate(this.pos, this.pos);
    }

    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
        return true;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        if (this.engine != null)
        {
            compound.setInteger("engine", CarPart.getID(this.engine));
        }

        return super.writeToNBT(compound);
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        if (compound.hasKey("engine"))
        {
            this.engine = (CarPartEngine)CarPart.partList.get(compound.getInteger("engine"));
        }
        else
        {
            this.engine = null;
        }
    }

    public SPacketUpdateTileEntity getUpdatePacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new SPacketUpdateTileEntity(this.pos, 0, nbttagcompound);
    }

    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
    {
        this.readFromNBT(pkt.getNbtCompound());
    }

    public NBTTagCompound getUpdateTag()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return nbttagcompound;
    }

    public void handleUpdateTag(NBTTagCompound tag)
    {
        this.readFromNBT(tag);
    }

    public NBTTagCompound getTileData()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return nbttagcompound;
    }

    public void setEngine(CarPartEngine engine)
    {
        this.engine = engine;
    }
}
