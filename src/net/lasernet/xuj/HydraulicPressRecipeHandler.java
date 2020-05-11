package net.lasernet.xuj;

import java.util.ArrayList;
import java.util.List;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraftforge.oredict.OreDictionary;

public class HydraulicPressRecipeHandler implements IRecipeHandler<HydraulicPressRecipes.HPRecipe>
{
    public String getRecipeCategoryUid(HydraulicPressRecipes.HPRecipe arg0)
    {
        return "xuj-hp";
    }

    public Class<HydraulicPressRecipes.HPRecipe> getRecipeClass()
    {
        return HydraulicPressRecipes.HPRecipe.class;
    }

    public IRecipeWrapper getRecipeWrapper(HydraulicPressRecipes.HPRecipe arg0)
    {
        if (arg0 == null)
        {
            return null;
        }
        else
        {
            List list = new ArrayList();

            if (arg0.isOredict() && arg0.getOreNames()[0] != "")
            {
                list.add(OreDictionary.getOres(arg0.getOreNames()[0]));
            }
            else
            {
                list.add(arg0.getStacks()[0]);
            }

            if (arg0.isOredict() && arg0.getOreNames()[1] != "")
            {
                list.add(OreDictionary.getOres(arg0.getOreNames()[1]));
            }
            else
            {
                list.add(arg0.getStacks()[1]);
            }

            return new HydraulicPressRecipeWrapper(list, arg0.getResult());
        }
    }

    public boolean isRecipeValid(HydraulicPressRecipes.HPRecipe arg0)
    {
        return true;
    }
}
