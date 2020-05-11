package net.lasernet.xuj.gui;

import net.lasernet.xuj.carparts.CarPart;
import net.lasernet.xuj.carparts.EnumCarType;
import net.lasernet.xuj.entity.EntityCar;
import net.lasernet.xuj.items.ItemCarPart;
import net.lasernet.xuj.items.ItemEngine;
import net.lasernet.xuj.items.ItemWheels;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerCar extends Container
{
    private EntityCar car;
    private ContainerCar.CarItemHandeler inv;
    private boolean canEditWheels = false;

    public ContainerCar(IInventory playerInv, final EntityCar car, final boolean canEditWheels)
    {
        this.car = car;
        this.canEditWheels = canEditWheels;
        this.inv = new ContainerCar.CarItemHandeler(this);
        int i = 0;

        for (CarPart carpart : car.getCarParts())
        {
            if (i < 9)
            {
                this.inv.setItem(i, CarPart.getItemStack(carpart));
            }

            ++i;
        }

        for (int j = 0; j < 3; ++j)
        {
            for (int i1 = 0; i1 < 3; ++i1)
            {
                this.addSlotToContainer(new SlotItemHandler(this.inv, i1 + j * 3, 8 + i1 * 18, 17 + j * 18)
                {
                    public boolean isItemValid(ItemStack stack)
                    {
                        if (stack.getItem() instanceof ItemEngine)
                        {
                            return false;
                        }
                        else if (stack.getItem() instanceof ItemWheels && canEditWheels)
                        {
                            for (int l1 = 0; l1 < 9; ++l1)
                            {
                                if (ContainerCar.this.inv.getStackInSlot(l1) != ItemStack.EMPTY && ContainerCar.this.inv.getStackInSlot(l1).getMetadata() == stack.getMetadata())
                                {
                                    return false;
                                }
                            }

                            CarPart carpart2 = CarPart.partList.get(stack.getMetadata() - 1);

                            if (carpart2.carFor != car.getCarType() && carpart2.carFor != EnumCarType.ANY)
                            {
                                return false;
                            }
                            else
                            {
                                return true;
                            }
                        }
                        else if (stack.getItem() instanceof ItemCarPart)
                        {
                            for (int k1 = 0; k1 < 9; ++k1)
                            {
                                if (ContainerCar.this.inv.getStackInSlot(k1) != ItemStack.EMPTY && ContainerCar.this.inv.getStackInSlot(k1).getMetadata() == stack.getMetadata())
                                {
                                    return false;
                                }
                            }

                            CarPart carpart1 = CarPart.partList.get(stack.getMetadata() - 1);

                            if (carpart1.carFor != car.getCarType() && carpart1.carFor != EnumCarType.ANY)
                            {
                                return false;
                            }
                            else
                            {
                                return true;
                            }
                        }
                        else
                        {
                            return false;
                        }
                    }
                    public boolean canTakeStack(EntityPlayer playerIn)
                    {
                        if (this.getStack().getItem() instanceof ItemEngine)
                        {
                            return false;
                        }
                        else
                        {
                            return canEditWheels || !(this.getStack().getItem() instanceof ItemWheels);
                        }
                    }
                });
            }
        }

        for (int k = 0; k < 3; ++k)
        {
            for (int j1 = 0; j1 < 9; ++j1)
            {
                this.addSlotToContainer(new Slot(playerInv, j1 + k * 9 + 9, 8 + j1 * 18, 84 + k * 18));
            }
        }

        for (int l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(playerInv, l, 8 + l * 18, 142));
        }
    }

    /**
     * Take a stack from the specified inventory slot.
     */
    public ItemStack transferStackInSlot(EntityPlayer player, int index)
    {
        return ItemStack.EMPTY;
    }

    /**
     * Determines whether supplied player can use this container
     */
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return true;
    }

    public EntityCar getCar()
    {
        return this.car;
    }

    public static class CarItemHandeler implements IItemHandlerModifiable
    {
        private InventoryBasic inv = new InventoryBasic("carinventory", false, 9);
        private ContainerCar cont;

        public CarItemHandeler(ContainerCar containerCar)
        {
            this.cont = containerCar;
        }

        public int getSlots()
        {
            return 9;
        }

        public ItemStack getStackInSlot(int slot)
        {
            return this.inv.getStackInSlot(slot);
        }

        public ItemStack insertItem(int slot, ItemStack stack, boolean simulate)
        {
            if (this.inv.getStackInSlot(slot) == ItemStack.EMPTY)
            {
                if (simulate)
                {
                    return ItemStack.EMPTY;
                }
                else
                {
                    this.inv.setInventorySlotContents(slot, stack);
                    return ItemStack.EMPTY;
                }
            }
            else
            {
                return stack;
            }
        }

        public ItemStack extractItem(int slot, int amount, boolean simulate)
        {
            if (this.inv.getStackInSlot(slot) == ItemStack.EMPTY)
            {
                return ItemStack.EMPTY;
            }
            else if (this.inv.getStackInSlot(slot).getItem() instanceof ItemEngine)
            {
                return ItemStack.EMPTY;
            }
            else if (simulate)
            {
                return this.inv.getStackInSlot(slot);
            }
            else
            {
                ItemStack itemstack = this.inv.getStackInSlot(slot);
                int i = 0;

                for (int j = 0; j < this.cont.car.getCarParts().size(); ++j)
                {
                    if (CarPart.getID((CarPart)this.cont.car.getCarParts().get(j)) == itemstack.getMetadata() - 1)
                    {
                        this.cont.car.removeCarPart(j);
                    }
                }

                this.inv.setInventorySlotContents(slot, ItemStack.EMPTY);
                return itemstack;
            }
        }

        public void setStackInSlot(int slot, ItemStack stack)
        {
            try
            {
                if (CarPart.partList.get(stack.getMetadata() - 1) == null)
                {
                    return;
                }
            }
            catch (Exception var4)
            {
                return;
            }

            this.cont.car.addCarPart(CarPart.partList.get(stack.getMetadata() - 1), stack);
            this.inv.setInventorySlotContents(slot, stack);
        }

        public void setItem(int slot, ItemStack stack)
        {
            this.inv.setInventorySlotContents(slot, stack);
        }

        public int getSlotLimit(int slot)
        {
            return 9;
        }
    }
}
