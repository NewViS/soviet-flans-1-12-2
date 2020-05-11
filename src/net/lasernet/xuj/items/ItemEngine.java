package net.lasernet.xuj.items;

import java.util.List;
import net.lasernet.xuj.XujMod;
import net.lasernet.xuj.carparts.CarPart;
import net.lasernet.xuj.carparts.CarPartEngine;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemEngine extends ItemBase
{
    public ItemEngine()
    {
        super("engine");
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (tab == XujMod.tabXuj)
        {
            int i = 0;
            int j = 0;

            for (CarPart carpart : CarPart.partList)
            {
                if (carpart instanceof CarPartEngine)
                {
                    items.add(i, new ItemStack(this, 1, j + 1));
                    ++i;
                }

                ++j;
            }
        }
    }

    public boolean isValid(ItemStack stack)
    {
        return stack.getMetadata() > 4;
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        if (this.isValid(stack))
        {
            CarPart carpart = CarPart.partList.get(stack.getMetadata() - 1);
            tooltip.add("\u00a7a" + carpart.title);
            tooltip.add("\u00a7aFits: " + carpart.carFor.getName());
            tooltip.add("\u00a78" + carpart.description);
        }
        else
        {
            tooltip.add("\u00a74This is not much of a part");
        }
    }
}
