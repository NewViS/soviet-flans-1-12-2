package net.lasernet.xuj.items;

import net.lasernet.xuj.XujMod;
import net.minecraft.item.Item;

public class ItemBase extends Item
{
    protected String name;

    public ItemBase(String name)
    {
        this.setCreativeTab(XujMod.tabXuj);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
    }
}
