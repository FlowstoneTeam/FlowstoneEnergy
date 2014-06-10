package main.flowstoneenergy.tileentities.recipes;

import com.google.common.collect.ImmutableList;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RecipesEnergizedOreTumbler {

    public static ArrayList<Recipe1_1> recipe11List = new ArrayList<Recipe1_1>();

    public static void addRecipe(ItemStack input, ItemStack output, int time) {
        Recipe1_1 r = new Recipe1_1(input, output, time);
        recipe11List.add(r);
    }

    public static Recipe1_1 getRecipeFromStack(ItemStack stack) {
        if (stack == null) return null;
        for (Recipe1_1 r : recipe11List) {
            if (r.getInput().getItem().equals(stack.getItem()) && r.getInput().getItemDamage() == stack.getItemDamage())
                return r;
        }
        return null;
    }

    public static Recipe1_1[] getRecipesFromStack(ItemStack stack)
    {
        List<Recipe1_1> out = new ArrayList<Recipe1_1>();
        if (stack == null) return null;
        for (Recipe1_1 r : recipe11List)
        {
            if (r.getInput().getItem().equals(stack.getItem()))
                out.add(r);
        }
        return out.toArray(new Recipe1_1[0]);
    }


    public static List<Recipe1_1> getAllRecipes()
    {
        return ImmutableList.copyOf(recipe11List);
    }
}
