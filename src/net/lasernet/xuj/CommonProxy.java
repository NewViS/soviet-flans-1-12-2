package net.lasernet.xuj;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.text.translation.I18n;

public class CommonProxy
{
    public void preInit()
    {
    }

    public void registerItemRenderer(Item item, int meta, String id)
    {
    }

    public void registerRender(Block block)
    {
    }

    public String localize(String unlocalized, Object... args)
    {
        return I18n.translateToLocalFormatted(unlocalized, args);
    }

    public void registerRender(Block block, String name)
    {
    }

    public void registerFullItemRenderer(Item item, int meta, String id)
    {
    }
}
