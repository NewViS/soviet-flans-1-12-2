package net.lasernet.xuj;

import java.util.List;
import javax.annotation.Nonnull;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.IDrawableAnimated.StartDirection;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class HydraulicPressRecipeCategory extends BlankRecipeCategory
{
    private static final ResourceLocation BG_TEXTURE = new ResourceLocation("xujmod", "textures/gui/hydraulicpressjei.png");
    @Nonnull
    private final IDrawable background;
    @Nonnull
    private final IDrawableAnimated progressBar;

    public HydraulicPressRecipeCategory(IGuiHelper guiHelper)
    {
        this.background = guiHelper.createDrawable(BG_TEXTURE, 3, 0, 168, 67);
        IDrawableStatic idrawablestatic = guiHelper.createDrawable(BG_TEXTURE, 176, 14, 24, 17);
        this.progressBar = guiHelper.createAnimatedDrawable(idrawablestatic, 70, StartDirection.LEFT, false);
    }

    public IDrawable getBackground()
    {
        return this.background;
    }

    public String getTitle()
    {
        return "Hydraulic Press";
    }

    public String getUid()
    {
        return "xuj-hp";
    }

    public void setRecipe(IRecipeLayout arg0, IRecipeWrapper arg1, IIngredients arg2)
    {
        IGuiItemStackGroup iguiitemstackgroup = arg0.getItemStacks();
        iguiitemstackgroup.init(0, true, 52, 5);
        iguiitemstackgroup.init(1, true, 52, 41);
        iguiitemstackgroup.init(2, false, 112, 41);

        if (arg1 instanceof HydraulicPressRecipeWrapper)
        {
            HydraulicPressRecipeWrapper hydraulicpressrecipewrapper = (HydraulicPressRecipeWrapper)arg1;
            List list = hydraulicpressrecipewrapper.getInputs();

            for (int i = 0; i < list.size(); ++i)
            {
                Object object = list.get(i);

                if (object != null)
                {
                    iguiitemstackgroup.set(i, (ItemStack)object);
                }
            }

            iguiitemstackgroup.set(2, hydraulicpressrecipewrapper.getOutputs());
        }
    }

    public String getModName()
    {
        return "xujmod";
    }
}
