package net.lasernet.xuj.items;

import java.util.List;
import net.lasernet.xuj.XujMod;
import net.lasernet.xuj.carparts.EnumCarType;
import net.lasernet.xuj.entity.EntityCar;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemCarBox extends ItemBase
{
    public ItemCarBox()
    {
        super("carbox");
        this.setMaxStackSize(1);
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (tab == XujMod.tabXuj)
        {
            try
            {
                items.add(new ItemStack(this, 1));

                for (EnumCarType enumcartype : EnumCarType.values())
                {
                    if (enumcartype.toInt() >= 0)
                    {
                        ItemStack itemstack = new ItemStack(this, 1);
                        NBTTagCompound nbttagcompound = new NBTTagCompound();
                        nbttagcompound.setInteger("cartype", enumcartype.toInt());
                        itemstack.setTagCompound(nbttagcompound);
                        items.add(itemstack);
                    }
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote)
        {
            ItemStack itemstack = player.getHeldItem(hand);
            NBTTagCompound nbttagcompound;

            if (itemstack.hasTagCompound())
            {
                nbttagcompound = itemstack.getTagCompound();
            }
            else
            {
                nbttagcompound = new NBTTagCompound();
            }

            if (nbttagcompound.getSize() > 0)
            {
                EntityCar entitycar = EntityCar.createCar(nbttagcompound.getInteger("cartype"), worldIn);
                entitycar.setPositionAndRotation((double)pos.getX(), (double)((float)pos.getY() + 1.0F), (double)pos.getZ(), -player.getRotationYawHead() + 90.0F, 0.0F);

                if (nbttagcompound.hasKey("color"))
                {
                    entitycar.setColor(nbttagcompound.getInteger("color"));
                }

                if (nbttagcompound.hasKey("fuel"))
                {
                    entitycar.setFuel(nbttagcompound.getCompoundTag("fuel"));
                }

                if (nbttagcompound.hasKey("carparts"))
                {
                    entitycar.setCarParts(nbttagcompound.getByteArray("carparts"));
                }

                if (worldIn.spawnEntity(entitycar))
                {
                    itemstack.setTagCompound((NBTTagCompound)null);
                }
            }
        }

        return EnumActionResult.SUCCESS;
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("\u00a7aAllows you to store a car in your pocket");

        if (stack.hasTagCompound())
        {
            NBTTagCompound nbttagcompound = stack.getTagCompound();

            if (nbttagcompound.getSize() > 0)
            {
                tooltip.add("\u00a7aCar: " + EnumCarType.getByID(nbttagcompound.getInteger("cartype")).getName());

                if (nbttagcompound.hasKey("carparts"))
                {
                    tooltip.add("\u00a7aParts count: " + nbttagcompound.getByteArray("carparts").length);
                }
            }
        }
        else
        {
            tooltip.add("\u00a74Empty");
        }
    }
}
