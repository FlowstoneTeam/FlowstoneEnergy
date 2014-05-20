package main.flowstoneenergy.tileentities.recipes;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class RecipesHeatedOven {
    public static ArrayList<Recipe1_1> recipe11List = new ArrayList<Recipe1_1>();


    public static void AddRecipe(ItemStack input, ItemStack output, int time) {
        Recipe1_1 r = new Recipe1_1(input, output, time);
        recipe11List.add(r);
    }


    public static Recipe1_1 GetRecipeFromStack(ItemStack stack) {
        if (stack == null) return null;
        for (Recipe1_1 r : recipe11List) {
            if (r.getInput().getItem().equals(stack.getItem())) return r;
        }
        return null;
    }
}