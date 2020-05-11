package net.lasernet.xuj.blocks;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.lasernet.xuj.HydraulicPressRecipes;
import net.lasernet.xuj.gui.ContainerHydraulicPress;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEntityHydraulicPress extends TileEntity implements ITickable, ISidedInventory
{
    private static final int[] SLOTS_TOP = new int[] {0};
    private static final int[] SLOTS_BOTTOM = new int[] {2, 1};
    private static final int[] SLOTS_SIDES = new int[] {1};
    public int pressingTick = 0;
    private boolean isPressing = false;
    private ItemStack[] pressItemStacks = new ItemStack[] {ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY};

    public void doPressing()
    {
        if (this.pressItemStacks[0] != ItemStack.EMPTY && this.pressItemStacks[0] != null && this.pressItemStacks[1] != ItemStack.EMPTY && this.pressItemStacks[1] != null && (this.pressItemStacks[2] == ItemStack.EMPTY || this.pressItemStacks[2] == null || this.pressItemStacks[2].getUnlocalizedName().equals("tile.air")))
        {
            HydraulicPressRecipes.HPRecipe hydraulicpressrecipes$hprecipe = HydraulicPressRecipes.instance().getPressResult(this.pressItemStacks[0], this.pressItemStacks[1]);
            System.out.println((Object)hydraulicpressrecipes$hprecipe);

            if (hydraulicpressrecipes$hprecipe != null)
            {
                this.isPressing = true;
            }
        }
    }

    /**
     * Like the old updateEntity(), except more generic.
     */
    public void update()
    {
        if (this.pressingTick > 9)
        {
            if (!this.world.isRemote && this.pressItemStacks[1] != ItemStack.EMPTY && this.pressItemStacks[0] != ItemStack.EMPTY)
            {
                HydraulicPressRecipes.HPRecipe hydraulicpressrecipes$hprecipe = HydraulicPressRecipes.instance().getPressResult(this.pressItemStacks[0], this.pressItemStacks[1]);

                if (hydraulicpressrecipes$hprecipe != null)
                {
                    if (!hydraulicpressrecipes$hprecipe.ShouldKeepFirstItem())
                    {
                        this.pressItemStacks[0] = ItemStack.EMPTY;
                    }

                    this.pressItemStacks[1] = ItemStack.EMPTY;
                    this.pressItemStacks[2] = hydraulicpressrecipes$hprecipe.getResult();
                    this.markDirty();
                }
            }

            this.pressingTick = 0;
            this.isPressing = false;
        }
        else if (this.isPressing)
        {
            ++this.pressingTick;
        }
    }

    public void onLoad()
    {
        this.world.markBlockRangeForRenderUpdate(this.pos, this.pos);
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.pressItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");

            if (j >= 0 && j < this.pressItemStacks.length)
            {
                this.pressItemStacks[j] = nbttagcompound == null ? ItemStack.EMPTY : new ItemStack(nbttagcompound);
            }
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.pressItemStacks.length; ++i)
        {
            if (this.pressItemStacks[i] != ItemStack.EMPTY)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);

                if (this.pressItemStacks[i] != ItemStack.EMPTY && this.pressItemStacks[i] != null)
                {
                    this.pressItemStacks[i].writeToNBT(nbttagcompound);
                }

                nbttaglist.appendTag(nbttagcompound);
            }
        }

        compound.setTag("Items", nbttaglist);
        return compound;
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

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.pressItemStacks.length;
    }

    @Nullable

    /**
     * Returns the stack in the given slot.
     */
    public ItemStack getStackInSlot(int index)
    {
        return this.pressItemStacks[index];
    }

    @Nullable

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    public ItemStack decrStackSize(int index, int count)
    {
        List<ItemStack> list = new ArrayList<ItemStack>();

        for (ItemStack itemstack : this.pressItemStacks)
        {
            list.add(itemstack);
        }

        return ItemStackHelper.getAndSplit(list, index, count);
    }

    @Nullable

    /**
     * Removes a stack from the given slot and returns it.
     */
    public ItemStack removeStackFromSlot(int index)
    {
        List<ItemStack> list = new ArrayList<ItemStack>();

        for (ItemStack itemstack : this.pressItemStacks)
        {
            list.add(itemstack);
        }

        return ItemStackHelper.getAndRemove(list, index);
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int index, @Nullable ItemStack stack)
    {
        boolean flag = false;

        if (stack != ItemStack.EMPTY && stack != null && this.pressItemStacks[index] != ItemStack.EMPTY && this.pressItemStacks[index] != null)
        {
            if (stack.isItemEqual(this.pressItemStacks[index]) && ItemStack.areItemStackTagsEqual(stack, this.pressItemStacks[index]))
            {
                boolean flag1 = true;
            }
            else
            {
                boolean flag2 = false;
            }
        }

        this.pressItemStacks[index] = stack;

        if (stack != ItemStack.EMPTY && stack.getCount() > this.getInventoryStackLimit())
        {
            stack.splitStack(this.getInventoryStackLimit());
        }
    }

    /**
     * Returns true if this thing is named
     */
    public boolean hasCustomName()
    {
        return false;
    }

    public void setCustomInventoryName(String p_145951_1_)
    {
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
     */
    public int getInventoryStackLimit()
    {
        return 1;
    }

    private boolean canpress()
    {
        if (this.pressItemStacks[0] == ItemStack.EMPTY)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = HydraulicPressRecipes.instance().getPressResult(this.pressItemStacks[0], this.pressItemStacks[1]).getResult();

            if (itemstack == ItemStack.EMPTY)
            {
                return false;
            }
            else if (this.pressItemStacks[2] == ItemStack.EMPTY)
            {
                return true;
            }
            else if (!this.pressItemStacks[2].isItemEqual(itemstack))
            {
                return false;
            }
            else
            {
                int i = this.pressItemStacks[2].getCount() + itemstack.getCount();
                return i <= this.getInventoryStackLimit() && i <= this.pressItemStacks[2].getMaxStackSize();
            }
        }
    }

    public void pressItem()
    {
        if (this.canpress())
        {
            ItemStack itemstack = HydraulicPressRecipes.instance().getPressResult(this.pressItemStacks[0], this.pressItemStacks[1]).getResult();

            if (this.pressItemStacks[2] == ItemStack.EMPTY)
            {
                this.pressItemStacks[2] = itemstack.copy();
            }
            else if (this.pressItemStacks[2].getItem() == itemstack.getItem())
            {
                this.pressItemStacks[2].splitStack(itemstack.getCount() - 1);
            }

            if (this.pressItemStacks[0].getItem() == Item.getItemFromBlock(Blocks.SPONGE) && this.pressItemStacks[0].getMetadata() == 1 && this.pressItemStacks[1] != ItemStack.EMPTY && this.pressItemStacks[1].getItem() == Items.BUCKET)
            {
                this.pressItemStacks[1] = new ItemStack(Items.WATER_BUCKET);
            }

            this.pressItemStacks[0].splitStack(this.pressItemStacks[0].getCount() - 1);

            if (this.pressItemStacks[0].getCount() <= 0)
            {
                this.pressItemStacks[0] = ItemStack.EMPTY;
            }
        }
    }

    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public void openInventory(EntityPlayer player)
    {
    }

    public void closeInventory(EntityPlayer player)
    {
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot. For
     * guis use Slot.isItemValid
     */
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        if (index == 2)
        {
            return false;
        }
        else
        {
            return index != 1 ? true : true;
        }
    }

    public int[] getSlotsForFace(EnumFacing side)
    {
        return side == EnumFacing.DOWN ? SLOTS_BOTTOM : (side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side.
     */
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
    {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side.
     */
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
    {
        if (direction == EnumFacing.DOWN && index == 1)
        {
            Item item = stack.getItem();

            if (item != Items.WATER_BUCKET && item != Items.BUCKET)
            {
                return false;
            }
        }

        return true;
    }

    public String getGuiID()
    {
        return "minecraft:furnace";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerHydraulicPress(playerInventory, this);
    }

    public int getField(int id)
    {
        return 0;
    }

    public void setField(int id, int value)
    {
    }

    public int getFieldCount()
    {
        return 0;
    }

    public void clear()
    {
    }

    /**
     * Get the name of this object. For players this returns their username
     */
    public String getName()
    {
        return "hydraulicpress";
    }

    public boolean func_191420_l()
    {
        return false;
    }

    /**
     * Don't rename this method to canInteractWith due to conflicts with Container
     */
    public boolean isUsableByPlayer(EntityPlayer player)
    {
        return true;
    }

	@Override
	public boolean isEmpty() {
		return false;
	}
}
