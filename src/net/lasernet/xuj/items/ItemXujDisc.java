package net.lasernet.xuj.items;

import java.util.List;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemXujDisc extends ItemRecord
{
    public ResourceLocation res;
    public String music;

    public ItemXujDisc(String name, String music)
    {
        super(name, new SoundEvent(new ResourceLocation("xujmod", music)));
        this.setMaxStackSize(1);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.music = music;
    }

    @SideOnly(Side.CLIENT)

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add(this.getRecordNameLocal());
    }

    public String getRecordNameLocal()
    {
        return this.music;
    }

    /**
     * Return an item rarity from EnumRarity
     */
    public EnumRarity getRarity(ItemStack itemStack)
    {
        return EnumRarity.RARE;
    }
}
