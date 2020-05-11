package net.lasernet.xuj;

import ic2.api.item.IC2Items;
import java.util.List;
import java.util.Random;
import net.lasernet.xuj.blocks.BlockEngineHoist;
import net.lasernet.xuj.carparts.CarPart;
import net.lasernet.xuj.carparts.EnumCarType;
import net.lasernet.xuj.entity.EntityCar;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces.PieceWeight;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import net.minecraft.world.gen.structure.StructureVillagePieces.Village;
import net.minecraftforge.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

public class VillageGarage extends Village
{
    private int groundLevel = -1;

    public VillageGarage()
    {
    }

    public VillageGarage(Start villagePiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, EnumFacing facing)
    {
        super(villagePiece, par2);
        this.setCoordBaseMode(facing);
        this.boundingBox = par4StructureBoundingBox;
    }

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at
     * the end, it adds Fences...
     */
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox box)
    {
        if (this.groundLevel < 0)
        {
            this.groundLevel = this.getAverageGroundLevel(world, box);

            if (this.groundLevel < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.groundLevel - this.boundingBox.maxY + 4 - 1, 0);
        }

        this.fillWithBlocks(world, box, 0, 0, 0, 7, 4, 7, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        this.clearEntities(world, 0, 0, 0, 7, 4, 6);
        this.fillWithBlocks(world, box, 0, 0, 0, 7, 0, 7, Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState(), false);
        this.fillWithBlocks(world, box, 0, 4, 0, 7, 4, 7, Blocks.STONEBRICK.getDefaultState(), Blocks.STONEBRICK.getDefaultState(), false);
        this.fillWithBlocks(world, box, 0, 1, 0, 0, 3, 7, Blocks.BRICK_BLOCK.getDefaultState(), Blocks.BRICK_BLOCK.getDefaultState(), false);
        this.fillWithBlocks(world, box, 0, 1, 0, 7, 3, 0, Blocks.BRICK_BLOCK.getDefaultState(), Blocks.BRICK_BLOCK.getDefaultState(), false);
        this.fillWithBlocks(world, box, 7, 1, 0, 7, 3, 7, Blocks.BRICK_BLOCK.getDefaultState(), Blocks.BRICK_BLOCK.getDefaultState(), false);
        this.fillWithBlocks(world, box, 0, 1, 6, 7, 3, 7, Blocks.BRICK_BLOCK.getDefaultState(), Blocks.BRICK_BLOCK.getDefaultState(), false);
        this.fillWithBlocks(world, box, 2, 1, 0, 4, 3, 0, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        this.placeCrate(world, this.getCoordBaseMode().rotateY(), rand, 6, 1, 1);
        this.placeCar(world, this.getCoordBaseMode(), rand, 3, 1, 3);
        this.placeHoist(world, this.getCoordBaseMode().rotateY(), rand, 5, 1, 3);
        return true;
    }

    protected void placeCrate(World world, EnumFacing facing, Random random, int x, int y, int z)
    {
        int i = this.getXWithOffset(x, z);
        int j = this.getYWithOffset(y);
        int k = this.getZWithOffset(x, z);
        BlockPos blockpos = new BlockPos(i, j, k);
        world.setBlockState(blockpos, Blocks.CHEST.getDefaultState().withProperty(BlockChest.FACING, facing));
        TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(blockpos);

        for (int l = 0; l < 5; ++l)
        {
            int i1 = random.nextInt(18);

            if (i1 < 5)
            {
                List<ItemStack> list = CarPart.getGeneralStacks();
                tileentitychest.setInventorySlotContents(random.nextInt(27), list.get(random.nextInt(list.size())));
            }
            else if (i1 == 5)
            {
                tileentitychest.setInventorySlotContents(random.nextInt(27), new ItemStack(ModItems.itemCarBox, 1));
            }
            else if (i1 == 10)
            {
                tileentitychest.setInventorySlotContents(random.nextInt(27), getIC2FluidCell("ethanol", random.nextInt(950) + 50));
            }
            else if (i1 == 9)
            {
                tileentitychest.setInventorySlotContents(random.nextInt(27), new ItemStack(ModItems.wd40Item, 1));
            }
        }
    }

    protected void placeHoist(World world, EnumFacing facing, Random random, int x, int y, int z)
    {
        int i = this.getXWithOffset(x, z);
        int j = this.getYWithOffset(y);
        int k = this.getZWithOffset(x, z);
        BlockPos blockpos = new BlockPos(i, j, k);
        world.setBlockState(blockpos, ((BlockEngineHoist)ModBlocks.blockEngineHoist).getStateFromMeta(facing.getIndex()));
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.setInteger("x", blockpos.getX());
        nbttagcompound.setInteger("y", blockpos.getY());
        nbttagcompound.setInteger("z", blockpos.getZ());
        int[] aint = CarPart.engineIDs();
        nbttagcompound.setInteger("engine", aint[random.nextInt(aint.length)]);
        world.getTileEntity(blockpos).readFromNBT(nbttagcompound);
    }

    protected void placeCar(World world, EnumFacing facing, Random random, int x, int y, int z)
    {
        int i = this.getXWithOffset(x, z);
        int j = this.getYWithOffset(y);
        int k = this.getZWithOffset(x, z);
        BlockPos blockpos = new BlockPos(i, j, k);
        EntityCar entitycar = EntityCar.createCar(random.nextInt(EnumCarType.values().length - 1), world);
        entitycar.setPosition((double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ());
        entitycar.rotationYaw = facing.getHorizontalAngle() + 90.0F;
        world.spawnEntity(entitycar);
    }

    protected void clearEntities(World world, int x, int y, int z, int x1, int y1, int z1)
    {
        int i = this.getXWithOffset(x, z);
        int j = this.getYWithOffset(y);
        int k = this.getZWithOffset(x, z);
        BlockPos blockpos = new BlockPos(i, j, k);
        int l = this.getXWithOffset(x1, z1);
        int i1 = this.getYWithOffset(y1);
        int j1 = this.getZWithOffset(x1, z1);
        BlockPos blockpos1 = new BlockPos(l, i1, j1);

        for (Entity entity : world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockpos, blockpos1)))
        {
            entity.setDead();
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

    public static class VillageManager implements IVillageCreationHandler
    {
        public Village buildComponent(PieceWeight villagePiece, Start startPiece, List<StructureComponent> pieces, Random random, int p1, int p2, int p3, EnumFacing facing, int p5)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, 8, 5, 8, facing);
            return VillageGarage.canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null ? new VillageGarage(startPiece, p5, random, structureboundingbox, facing) : null;
        }

        public PieceWeight getVillagePieceWeight(Random random, int i)
        {
            return new PieceWeight(VillageGarage.class, 15, MathHelper.getInt(random, 0 + i, 1 + i));
        }

        public Class<?> getComponentClass()
        {
            return VillageGarage.class;
        }
    }
}
