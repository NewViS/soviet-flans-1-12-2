package net.lasernet.xuj.blocks;

import net.lasernet.xuj.XujMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block
{
    protected String name;

    public BlockBase(Material material, String name)
    {
        super(material);
        this.setCreativeTab(XujMod.tabXuj);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
    }
}
