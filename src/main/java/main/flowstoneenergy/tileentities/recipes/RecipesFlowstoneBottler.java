package main.flowstoneenergy.tileentities.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class RecipesFlowstoneBottler {

    public static ArrayList<Recipe1_1> recipe11List = new ArrayList<Recipe1_1>();

    public static void addRecipe(ItemStack input, ItemStack output, int time, int powerRequired) {
        Recipe1_1 r = new Recipe1_1(input, output, time, powerRequired);
        recipe11List.add(r);
    }

    public static void addOreDictRecipe(String ore, ItemStack output, int time, int powerRequired) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        if (ores != null && ores.size() > 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                addRecipe(oreList, output, time, powerRequired);
            }
        }
    }

    public static void addOreDictRecipe(ItemStack input, String output, int time, int stackSize, int powerRequired) {
        ArrayList<ItemStack> outputs = OreDictionary.getOres(output);
        if (outputs != null && outputs.size() > 0) {
            ItemStack outputsFinal = outputs.get(0);
            outputsFinal.stackSize = stackSize;
            addRecipe(input, outputsFinal, time, powerRequired);
        }
    }

    public static void addOreDictRecipe(String ore, String output, int time, int stackSize, int powerRequired) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        ArrayList<ItemStack> outputs = OreDictionary.getOres(output);
        if (ores != null && ores.size() > 0 && outputs != null && outputs.size() > 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                ItemStack outputsFinal = outputs.get(0);
                outputsFinal.stackSize = stackSize;
                addRecipe(oreList, outputsFinal, time, powerRequired);
            }
        }
    }

    public static Recipe1_1 getRecipeFromStack(ItemStack stack) {
        if (stack == null)
            return null;
        for (Recipe1_1 r : recipe11List) {
            if (r.getInput().getItem().equals(stack.getItem()) && r.getInput().getItemDamage() == stack.getItemDamage())
                return r;
        }
        return null;
    }
}