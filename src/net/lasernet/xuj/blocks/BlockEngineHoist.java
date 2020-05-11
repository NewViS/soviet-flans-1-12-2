package net.lasernet.xuj.blocks;

import java.util.List;
import net.lasernet.xuj.BlockTileEntity;
import net.lasernet.xuj.ModItems;
import net.lasernet.xuj.carparts.CarPart;
import net.lasernet.xuj.carparts.CarPartEngine;
import net.lasernet.xuj.entity.EntityCar;
import net.lasernet.xuj.items.ItemEngine;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockEngineHoist extends BlockTileEntity<TileEntityEngineHoist>
{
    public BlockEngineHoist()
    {
        super(Material.IRON, "enginehoist");
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockHorizontal.FACING, EnumFacing.NORTH));
        this.setHardness(1.5F);
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = playerIn.getHeldItem(hand);
            TileEntityEngineHoist tileentityenginehoist = (TileEntityEngineHoist)worldIn.getTileEntity(pos);

            if (itemstack != ItemStack.EMPTY && itemstack.getItem() instanceof ItemEngine)
            {
                if (tileentityenginehoist.getEngine() == null && CarPart.partList.get(itemstack.getMetadata() - 1) != null)
                {
                    tileentityenginehoist.setEngine((CarPartEngine)CarPart.partList.get(itemstack.getMetadata() - 1));
                    playerIn.setHeldItem(hand, ItemStack.EMPTY);
                }
            }
            else if (itemstack != ItemStack.EMPTY && itemstack.getUnlocalizedName().equals("tile.lever"))
            {
                EnumFacing enumfacing = (EnumFacing)state.getProperties().get(BlockHorizontal.FACING);
                AxisAlignedBB axisalignedbb = null;

                switch (enumfacing)
                {
                    case EAST:
                        axisalignedbb = new AxisAlignedBB(pos.north(1).down(1), pos.east(6).south(1).up(2));
                        break;

                    case NORTH:
                        axisalignedbb = new AxisAlignedBB(pos.east(1).down(1), pos.north(6).west(1).up(2));
                        break;

                    case WEST:
                        axisalignedbb = new AxisAlignedBB(pos.north(1).down(1), pos.west(6).south(1).up(2));
                        break;

                    case SOUTH:
                        axisalignedbb = new AxisAlignedBB(pos.east(1).down(1), pos.south(6).west(1).up(2));
                }

                List<EntityCar> list = worldIn.getEntitiesWithinAABB(EntityCar.class, axisalignedbb);

                if (list.size() > 0)
                {
                    EntityCar entitycar = list.get(0);
                    CarPartEngine carpartengine = entitycar.getEngine();

                    if (carpartengine != null && tileentityenginehoist.engine == null)
                    {
                        tileentityenginehoist.setEngine(carpartengine);
                        entitycar.setEngine((CarPartEngine)null);
                    }
                    else if (carpartengine == null && tileentityenginehoist.engine != null)
                    {
                        entitycar.setEngine(tileentityenginehoist.engine);
                        tileentityenginehoist.setEngine((CarPartEngine)null);
                    }
                }
            }
            else if (tileentityenginehoist.getEngine() != null)
            {
                worldIn.spawnEntity(new EntityItem(worldIn, (double)pos.getX(), (double)(pos.getY() + 1), (double)pos.getZ(), new ItemStack(ModItems.itemEngine, 1, CarPart.getID(tileentityenginehoist.getEngine()) + 1)));
                tileentityenginehoist.setEngine((CarPartEngine)null);
            }

            tileentityenginehoist.markDirty();
            worldIn.notifyBlockUpdate(pos, state, state, 3);
            worldIn.scheduleBlockUpdate(pos, state.getBlock(), 10, 0);
            worldIn.markAndNotifyBlock(pos, worldIn.getChunkFromBlockCoords(pos), state, state, 0);
            return true;
        }
    }

    /**
     * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
     */
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntityEngineHoist tileentityenginehoist = (TileEntityEngineHoist)worldIn.getTileEntity(pos);

        if (tileentityenginehoist.getEngine() != null)
        {
            worldIn.spawnEntity(new EntityItem(worldIn, (double)pos.getX(), (double)(pos.getY() + 1), (double)pos.getZ(), new ItemStack(ModItems.itemEngine, 1, CarPart.getID(tileentityenginehoist.getEngine()) + 1)));
        }

        super.breakBlock(worldIn, pos, state);
    }

    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.setDefaultFacing(worldIn, pos, state);
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.north());
            IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
            IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
            IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
            EnumFacing enumfacing = (EnumFacing)state.getValue(BlockHorizontal.FACING);

            if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(BlockHorizontal.FACING, enumfacing), 2);
        }
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {BlockHorizontal.FACING});
    }

    /**
     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(BlockHorizontal.FACING, placer.getHorizontalFacing().getOpposite());
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(BlockHorizontal.FACING, enumfacing);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(BlockHorizontal.FACING)).getIndex();
    }

    /**
     * Indicate if a material is a normal solid opaque cube
     */
    public boolean isBlockNormalCube(IBlockState state)
    {
        return false;
    }

    /**
     * Used for nearly all game logic (non-rendering) purposes. Use Forge-provided isNormalCube(IBlockAccess, BlockPos)
     * instead.
     */
    public boolean isNormalCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    /**
     * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
     * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
     */
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }

    public Class<TileEntityEngineHoist> getTileEntityClass()
    {
        return TileEntityEngineHoist.class;
    }

    public TileEntityEngineHoist createTileEntity(World world, IBlockState state)
    {
        return new TileEntityEngineHoist();
    }
}
