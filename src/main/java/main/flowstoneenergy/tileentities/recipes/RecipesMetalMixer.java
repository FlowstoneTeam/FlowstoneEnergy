package main.flowstoneenergy.tileentities.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class RecipesMetalMixer {
	public static List<Recipe2_1> recipe11List = new ArrayList<Recipe2_1>();

    public static void AddRecipe(ItemStack input1, ItemStack input2, ItemStack output, int time)
    {
        Recipe2_1 r = new Recipe2_1(input1, input2, output, time);
        recipe11List.add(r);
    }

    public static Recipe2_1 GetRecipeFromStack(ItemStack stack1, ItemStack stack2)
    {
        if (stack1 == null || stack2 == null) return null;
        for (Recipe2_1 r : recipe11List)
        {
            if (r.getInput1().getItem().equals(stack1.getItem()) && r.getInput2().getItem().equals(stack2.getItem()))
                return r;
            if (r.getInput2().getItem().equals(stack1.getItem()) && r.getInput1().getItem().equals(stack2.getItem()))
                return r;
        }
        return null;
    }

    public static Recipe2_1[] GetRecipesFromStack(ItemStack stack)
    {
        List<Recipe2_1> out = new ArrayList<Recipe2_1>();
        if (stack == null) return null;
        for (Recipe2_1 r : recipe11List)
        {
            if (r.getInput1().getItem().equals(stack.getItem()) || r.getInput2().getItem().equals(stack.getItem()))
                out.add(r);
        }
        return out.toArray(new Recipe2_1[0]);
    }
}
