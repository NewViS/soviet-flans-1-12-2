package net.lasernet.xuj;

//import blusunrize.immersiveengineering.common.IEContent;
import ic2.api.item.IC2Items;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class HydraulicPressRecipes
{
    private static final HydraulicPressRecipes Press_BASE = new HydraulicPressRecipes();
    private final List<HydraulicPressRecipes.HPRecipe> PressList = new ArrayList<HydraulicPressRecipes.HPRecipe>();

    public static HydraulicPressRecipes instance()
    {
        return Press_BASE;
    }

    private HydraulicPressRecipes()
    {
        /*this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 0), new ItemStack(IEContent.itemMetal, 1, 0), new ItemStack(IEContent.itemMetal, 1, 30), true, "", "ingotCopper");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 0), new ItemStack(IEContent.itemMetal, 1, 1), new ItemStack(IEContent.itemMetal, 1, 31), true, "", "ingotAluminum");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 0), new ItemStack(IEContent.itemMetal, 1, 2), new ItemStack(IEContent.itemMetal, 1, 32), true, "", "ingotLead");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 0), new ItemStack(IEContent.itemMetal, 1, 3), new ItemStack(IEContent.itemMetal, 1, 33), true, "", "ingotSilver");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 0), new ItemStack(IEContent.itemMetal, 1, 4), new ItemStack(IEContent.itemMetal, 1, 34), true, "", "ingotNickel");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 0), new ItemStack(IEContent.itemMetal, 1, 5), new ItemStack(IEContent.itemMetal, 1, 35), true, "", "ingotUranium");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 0), new ItemStack(IEContent.itemMetal, 1, 6), new ItemStack(IEContent.itemMetal, 1, 36), true, "", "ingotConstantan");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 0), new ItemStack(IEContent.itemMetal, 1, 7), new ItemStack(IEContent.itemMetal, 1, 37), true, "", "ingotElectrum");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 0), new ItemStack(IEContent.itemMetal, 1, 8), new ItemStack(IEContent.itemMetal, 1, 38), true, "", "ingotSteel");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 0), IC2Items.getItem("ingot", "bronze"), IC2Items.getItem("plate", "bronze"), true, "", "ingotBronze");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 0), IC2Items.getItem("ingot", "tin"), IC2Items.getItem("plate", "tin"), true, "", "ingotTin");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 2), new ItemStack(Items.IRON_INGOT, 1), new ItemStack(IEContent.itemMaterial, 1, 1), true, "", "ingotIron");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 2), new ItemStack(IEContent.itemMetal, 1, 8), new ItemStack(IEContent.itemMaterial, 1, 2), true, "", "ingotSteel");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 2), new ItemStack(IEContent.itemMetal, 1, 1), new ItemStack(IEContent.itemMaterial, 1, 3), true, "", "ingotAluminum");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 4), new ItemStack(IEContent.itemMetal, 1, 0), new ItemStack(IEContent.itemMaterial, 1, 20), true, "", "ingotCopper");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 4), new ItemStack(IEContent.itemMetal, 1, 1), new ItemStack(IEContent.itemMaterial, 1, 22), true, "", "ingotAluminum");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 4), new ItemStack(IEContent.itemMetal, 1, 7), new ItemStack(IEContent.itemMaterial, 1, 21), true, "", "ingotElectrum");
        this.addOrePressRecipe(new ItemStack(IEContent.itemMold, 1, 4), new ItemStack(IEContent.itemMetal, 1, 8), new ItemStack(IEContent.itemMaterial, 1, 23), true, "", "ingotSteel");
        this.addPressRecipe(new ItemStack(IEContent.itemMold, 1, 0), new ItemStack(Items.IRON_INGOT), new ItemStack(IEContent.itemMetal, 1, 39), true);
        this.addPressRecipe(new ItemStack(IEContent.itemMold, 1, 0), new ItemStack(Items.GOLD_INGOT), new ItemStack(IEContent.itemMetal, 1, 40), true);
    */
    }

    public void addPress(Item a, Item b, ItemStack stack)
    {
        this.addPressRecipe(new ItemStack(a, 1, 32767), new ItemStack(b, 1, 32767), stack);
    }

    public void addPressRecipe(ItemStack a, ItemStack b, ItemStack stack)
    {
        this.PressList.add(new HydraulicPressRecipes.HPRecipe(new ItemStack[] {a, b, stack}));
    }

    public void addPressRecipe(ItemStack a, ItemStack b, ItemStack stack, boolean shouldKeepFirstItem)
    {
        this.PressList.add(new HydraulicPressRecipes.HPRecipe(new ItemStack[] {a, b, stack}, shouldKeepFirstItem));
    }

    public void addOrePressRecipe(ItemStack a, ItemStack b, ItemStack stack, boolean shouldKeepFirstItem, String... names)
    {
        this.PressList.add((new HydraulicPressRecipes.HPRecipe(new ItemStack[] {a, b, stack}, shouldKeepFirstItem)).setOreDict().setOrenames(names));
    }

    @Nullable
    public HydraulicPressRecipes.HPRecipe getPressResult(ItemStack a, ItemStack b)
    {
        if (a != null && b != null)
        {
            for (HydraulicPressRecipes.HPRecipe hydraulicpressrecipes$hprecipe : this.PressList)
            {
                if (hydraulicpressrecipes$hprecipe.isOredict())
                {
                    if (this.compareOreDict(a, b, hydraulicpressrecipes$hprecipe))
                    {
                        return hydraulicpressrecipes$hprecipe;
                    }
                }
                else if (this.compareItemStacks(a, hydraulicpressrecipes$hprecipe.stacks[0]) && this.compareItemStacks(b, hydraulicpressrecipes$hprecipe.stacks[1]))
                {
                    return hydraulicpressrecipes$hprecipe;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    private boolean compareOreDict(ItemStack a, ItemStack b, HydraulicPressRecipes.HPRecipe re)
    {
        boolean flag = false;
        boolean flag1 = false;

        if (!re.orenames[0].equals(""))
        {
            for (ItemStack itemstack : OreDictionary.getOres(re.orenames[0]))
            {
                if (this.compareItemStacks(a, itemstack))
                {
                    flag = true;
                    break;
                }
            }
        }
        else
        {
            flag = this.compareItemStacks(a, re.getStacks()[0]);
        }

        if (!re.orenames[1].equals(""))
        {
            for (ItemStack itemstack1 : OreDictionary.getOres(re.orenames[1]))
            {
                if (this.compareItemStacks(b, itemstack1))
                {
                    flag1 = true;
                    break;
                }
            }
        }
        else
        {
            flag = this.compareItemStacks(b, re.getStacks()[1]);
        }

        return flag && flag1;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public List<HydraulicPressRecipes.HPRecipe> getPressList()
    {
        return this.PressList;
    }

    public boolean fitsInFirst(ItemStack itemstack1)
    {
        label33:

        for (HydraulicPressRecipes.HPRecipe hydraulicpressrecipes$hprecipe : this.PressList)
        {
            if (hydraulicpressrecipes$hprecipe.isOredict() && hydraulicpressrecipes$hprecipe.orenames[0] != "")
            {
                List<ItemStack> list = OreDictionary.getOres(hydraulicpressrecipes$hprecipe.orenames[0]);
                Iterator iterator = list.iterator();

                while (true)
                {
                    if (!iterator.hasNext())
                    {
                        continue label33;
                    }

                    ItemStack itemstack = (ItemStack)iterator.next();

                    if (this.compareItemStacks(itemstack1, itemstack))
                    {
                        break;
                    }
                }

                return true;
            }
            else if (this.compareItemStacks(itemstack1, hydraulicpressrecipes$hprecipe.stacks[0]))
            {
                return true;
            }
        }

        return false;
    }

    public static class HPRecipe
    {
        private String[] orenames = new String[] {"", ""};
        private ItemStack[] stacks;
        private boolean shouldKeepFirstItem = false;
        private boolean oredict = false;

        public HPRecipe(ItemStack[] stacks)
        {
            this.stacks = stacks;
        }

        public HPRecipe(ItemStack[] stacks, boolean shouldKeepFirstItem)
        {
            this.stacks = stacks;
            this.shouldKeepFirstItem = shouldKeepFirstItem;
        }

        public HydraulicPressRecipes.HPRecipe setOrenames(String... orenames)
        {
            this.orenames = orenames;
            return this;
        }

        public boolean isOredict()
        {
            return this.oredict;
        }

        public HydraulicPressRecipes.HPRecipe setOreDict()
        {
            this.oredict = true;
            return this;
        }

        public ItemStack[] getStacks()
        {
            return this.stacks;
        }

        public boolean ShouldKeepFirstItem()
        {
            return this.shouldKeepFirstItem;
        }

        public ItemStack getResult()
        {
            return this.stacks[2].copy();
        }

        public String[] getOreNames()
        {
            return this.orenames;
        }
    }
}
