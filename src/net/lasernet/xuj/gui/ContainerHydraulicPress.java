package net.lasernet.xuj.gui;

import javax.annotation.Nullable;
import net.lasernet.xuj.HydraulicPressRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ContainerHydraulicPress extends Container
{
    private IInventory pressInventory;

    public ContainerHydraulicPress(InventoryPlayer playerInv, IInventory pressInventory)
    {
        this.pressInventory = pressInventory;
        this.addSlotToContainer(new Slot(pressInventory, 0, 56, 17)
        {
            public int getSlotStackLimit()
            {
                return 1;
            }
            public int getItemStackLimit(ItemStack stack)
            {
                return 1;
            }
        });
        this.addSlotToContainer(new Slot(pressInventory, 1, 56, 53)
        {
            public int getSlotStackLimit()
            {
                return 1;
            }
            public int getItemStackLimit(ItemStack stack)
            {
                return 1;
            }
        });
        this.addSlotToContainer(new ContainerHydraulicPress.SlotPressOutput(playerInv.player, pressInventory, 2, 116, 53));

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k)
        {
            this.addSlotToContainer(new Slot(playerInv, k, 8 + k * 18, 142));
        }
    }

    /**
     * Take a stack from the specified inventory slot.
     */
    public ItemStack transferStackInSlot(EntityPlayer player, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index != 1 && index != 0)
            {
                if (HydraulicPressRecipes.instance().fitsInFirst(itemstack1))
                {
                    int j = itemstack1.getCount() - 1;

                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return ItemStack.EMPTY;
                    }

                    itemstack1.splitStack(j);
                }
                else if (HydraulicPressRecipes.instance().getPressResult(((Slot)this.inventorySlots.get(0)).getStack(), itemstack1) != null)
                {
                    int i = itemstack1.getCount() - 1;

                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return ItemStack.EMPTY;
                    }

                    itemstack1.splitStack(i);
                }
                else if (index >= 3 && index < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.getCount() == 0)
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }

    /**
     * Determines whether supplied player can use this container
     */
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return true;
    }

    public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.pressInventory);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
    }

    static class SlotPressOutput extends Slot
    {
        private final EntityPlayer thePlayer;
        private int removeCount;

        public SlotPressOutput(EntityPlayer player, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
        {
            super(inventoryIn, slotIndex, xPosition, yPosition);
            this.thePlayer = player;
        }

        public boolean isItemValid(@Nullable ItemStack stack)
        {
            return false;
        }

        public ItemStack decrStackSize(int amount)
        {
            if (this.getHasStack())
            {
                this.removeCount += Math.min(amount, this.getStack().getCount());
            }

            return super.decrStackSize(amount);
        }

        public void onPickupFromSlot(EntityPlayer playerIn, ItemStack stack)
        {
            this.onCrafting(stack);
            super.onTake(playerIn, stack);
        }

        protected void onCrafting(ItemStack stack, int amount)
        {
            this.removeCount += amount;
            this.onCrafting(stack);
        }

        protected void onCrafting(ItemStack stack)
        {
            stack.onCrafting(this.thePlayer.world, this.thePlayer, this.removeCount);
            this.removeCount = 0;
            FMLCommonHandler.instance().firePlayerSmeltedEvent(this.thePlayer, stack);
        }
    }
}
