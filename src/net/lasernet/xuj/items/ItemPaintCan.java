package net.lasernet.xuj.items;

import java.util.List;
import net.lasernet.xuj.XujMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemPaintCan extends ItemBase
{
    public ItemPaintCan()
    {
        super("paintcan");
        this.setMaxDamage(0);
        this.setMaxStackSize(1);
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (tab == XujMod.tabXuj)
        {
            items.add(new ItemStack(this, 1));

            for (int i = 0; i < 16; ++i)
            {
                items.add(new ItemStack(this, 1, i + 1));
            }
        }
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        if (this.getMetadata(stack) > 0)
        {
            String s = EnumDyeColor.byDyeDamage(this.getMetadata(stack) - 1).getName();
            tooltip.add("\u00a7a" + s.substring(0, 1).toUpperCase() + s.substring(1, s.length()));
        }
        else
        {
            tooltip.add("\u00a74Empty Paint Can");
        }
    }
}
