package net.lasernet.xuj;

import java.util.Collections;
import java.util.List;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class HydraulicPressRecipeWrapper extends BlankRecipeWrapper
{
    private final List<ItemStack> inputs;
    private final ItemStack output;

    public HydraulicPressRecipeWrapper(List<ItemStack> inputs, ItemStack output)
    {
        this.inputs = inputs;
        this.output = output;
    }

    public void getIngredients(IIngredients ingredients)
    {
        ingredients.setInputs(ItemStack.class, this.inputs);
        ingredients.setOutput(ItemStack.class, this.output);
    }

    public List<ItemStack> getInputs()
    {
        return this.inputs;
    }

    public List<ItemStack> getOutputs()
    {
        return Collections.<ItemStack>singletonList(this.output);
    }

    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
    {
    }
}
