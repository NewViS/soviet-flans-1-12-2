package net.lasernet.xuj;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeHandler;
import net.lasernet.xuj.gui.GUIHydraulicPress;
import net.minecraft.item.ItemStack;

public class XujModJEIPlugin extends BlankModPlugin
{
    public void register(IModRegistry registry)
    {
        IGuiHelper iguihelper = registry.getJeiHelpers().getGuiHelper();
        registry.addRecipeCategories(new IRecipeCategory[] {new HydraulicPressRecipeCategory(iguihelper)});
        registry.addRecipeHandlers(new IRecipeHandler[] {new HydraulicPressRecipeHandler()});
        registry.addRecipeClickArea(GUIHydraulicPress.class, 79, 53, 24, 17, new String[] {"xuj-hp"});
        //registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.blockHydraulicPress), new String[] {"xuj-hp"});
        registry.addRecipes(HydraulicPressRecipes.instance().getPressList());
    }
}
