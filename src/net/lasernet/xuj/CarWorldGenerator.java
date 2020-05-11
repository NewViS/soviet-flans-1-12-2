package net.lasernet.xuj;

import ic2.api.item.IC2Items;
import java.util.List;
import java.util.Random;
import net.lasernet.xuj.blocks.BlockEngineHoist;
import net.lasernet.xuj.carparts.CarPart;
import net.lasernet.xuj.carparts.EnumCarType;
import net.lasernet.xuj.entity.EntityCar;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class CarWorldGenerator implements IWorldGenerator
{
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        if (world.provider.getDimension() == 0 && random.nextInt(120) == 5)
        {
            int i = chunkX * 16 + random.nextInt(16);
            int j = chunkZ * 16 + random.nextInt(16);
            int k = world.getHeight(i, j);
            BlockPos blockpos = new BlockPos(i, k, j);

            if (world.isAirBlock(blockpos.up()) && world.getBlockState(blockpos.down()) != null)
            {
                Block block = world.getBlockState(blockpos.down()).getBlock();

                if (!(block instanceof BlockGrass) && !(block instanceof BlockSand) && !(block instanceof BlockStone) && !(block instanceof BlockDirt) && !block.getLocalizedName().toLowerCase().contains("grass"))
                {
                    return;
                }

                System.out.println("Got one boi (Garage) at " + blockpos);
                blockpos = blockpos.down();

                for (int l = 0; l < 7; ++l)
                {
                    for (int i1 = 0; i1 < 8; ++i1)
                    {
                        for (int j1 = 0; j1 < 4; ++j1)
                        {
                            world.setBlockToAir(blockpos.east(l).north(i1).up(j1));
                        }
                    }
                }

                for (int l1 = 0; l1 < 7; ++l1)
                {
                    for (int k3 = 0; k3 < 8; ++k3)
                    {
                        world.setBlockState(blockpos.east(l1).north(k3), Blocks.STONE.getDefaultState());
                    }
                }

                for (int i2 = 0; i2 < 7; ++i2)
                {
                    for (int l3 = 0; l3 < 3; ++l3)
                    {
                        world.setBlockState(blockpos.east(i2).up(l3 + 1), Blocks.STONEBRICK.getDefaultState());
                    }
                }

                for (int j2 = 0; j2 < 8; ++j2)
                {
                    for (int i4 = 0; i4 < 3; ++i4)
                    {
                        world.setBlockState(blockpos.north(j2).up(i4 + 1), Blocks.STONEBRICK.getDefaultState());
                    }
                }

                for (int k2 = 0; k2 < 8; ++k2)
                {
                    for (int j4 = 0; j4 < 3; ++j4)
                    {
                        world.setBlockState(blockpos.east(6).north(k2).up(j4 + 1), Blocks.STONEBRICK.getDefaultState());
                    }
                }

                for (int l2 = 0; l2 < 3; ++l2)
                {
                    world.setBlockState(blockpos.north(7).east(1).up(l2 + 1), Blocks.STONEBRICK.getDefaultState());
                }

                for (int i3 = 0; i3 < 3; ++i3)
                {
                    world.setBlockState(blockpos.north(7).east(5).up(i3 + 1), Blocks.STONEBRICK.getDefaultState());
                }

                for (int j3 = 0; j3 < 7; ++j3)
                {
                    for (int k4 = 0; k4 < 8; ++k4)
                    {
                        world.setBlockState(blockpos.east(j3).north(k4).up(4), Blocks.COBBLESTONE.getDefaultState());
                    }
                }

                BlockPos blockpos1 = blockpos.north(3).east(3).up();

                if (random.nextBoolean())
                {
                    world.setBlockState(blockpos1, ((BlockEngineHoist)ModBlocks.blockEngineHoist).getStateFromMeta(EnumFacing.NORTH.getIndex()));
                    NBTTagCompound nbttagcompound = new NBTTagCompound();
                    nbttagcompound.setInteger("x", blockpos1.getX());
                    nbttagcompound.setInteger("y", blockpos1.getY());
                    nbttagcompound.setInteger("z", blockpos1.getZ());
                    int[] aint = CarPart.engineIDs();
                    nbttagcompound.setInteger("engine", aint[random.nextInt(aint.length)]);
                    world.getTileEntity(blockpos1).readFromNBT(nbttagcompound);
                }
                else
                {
                    EntityCar entitycar = EntityCar.createCar(random.nextInt(EnumCarType.values().length - 1), world);
                    entitycar.setPosition((double)blockpos1.getX(), (double)blockpos1.getY(), (double)blockpos1.getZ());
                    entitycar.rotationYaw = 90.0F;
                    world.spawnEntity(entitycar);
                }

                world.setBlockState(blockpos1.south(2), Blocks.CHEST.getDefaultState());
                TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(blockpos1.south(2));

                for (int l4 = 0; l4 < 5; ++l4)
                {
                    int k1 = random.nextInt(18);

                    if (k1 < 5)
                    {
                        List<ItemStack> list = CarPart.getGeneralStacks();
                        tileentitychest.setInventorySlotContents(random.nextInt(27), list.get(random.nextInt(list.size())));
                    }
                    else if (k1 == 5)
                    {
                        tileentitychest.setInventorySlotContents(random.nextInt(27), new ItemStack(ModItems.itemCarBox, 1));
                    }
                    else if (k1 == 10)
                    {
                        tileentitychest.setInventorySlotContents(random.nextInt(27), getIC2FluidCell("ethanol", random.nextInt(1000)));
                    }
                    else if (k1 == 9)
                    {
                        tileentitychest.setInventorySlotContents(random.nextInt(27), new ItemStack(ModItems.wd40Item, 1));
                    }
                }
            }
        }
    }

    public static ItemStack getIC2FluidCell(String fluidName, int ammount)
    {
        ItemStack itemstack = IC2Items.getItem("fluid_cell");
        NBTTagCompound nbttagcompound = itemstack.serializeNBT();
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
        nbttagcompound1.setString("FluidName", fluidName);
        nbttagcompound1.setInteger("Amount", ammount);
        NBTTagCompound nbttagcompound2 = new NBTTagCompound();
        nbttagcompound2.setTag("fluid", nbttagcompound1);
        nbttagcompound.setTag("tag", nbttagcompound2);
        itemstack.deserializeNBT(nbttagcompound);
        return itemstack;
    }
}
