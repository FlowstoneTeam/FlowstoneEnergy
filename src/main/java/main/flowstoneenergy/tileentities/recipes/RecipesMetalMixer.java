package main.flowstoneenergy.tileentities.recipes;

import com.google.common.collect.ImmutableList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class RecipesMetalMixer {

    public static List<Recipe2_1> recipe21List = new ArrayList<Recipe2_1>();

    public static void addRecipe(ItemStack input1, ItemStack input2, ItemStack output, int time) {
        Recipe2_1 r = new Recipe2_1(input1, input2, output, time);
        recipe21List.add(r);
    }

    public static void addOreDictRecipe(String ore1, String ore2, ItemStack output, int time) {
        ArrayList<ItemStack> ores1 = OreDictionary.getOres(ore1);
        ArrayList<ItemStack> ores2 = OreDictionary.getOres(ore2);
        if (ores1 != null && ores1.size() > 0 && ores2 != null && ores2.size() > 0) {
            for (ItemStack oreList1 : OreDictionary.getOres(ore1)) {
                for (ItemStack oreList2 : OreDictionary.getOres(ore2)) {
                    addRecipe(oreList1, oreList2, output, time);
                }
            }
        }
    }

    public static void addOreDictRecipe(ItemStack input1, ItemStack input2, String output, int time, int stackSize) {
        ArrayList<ItemStack> outputs = OreDictionary.getOres(output);
        if (output != null && outputs.size() > 0) {
            ItemStack outputsFinal = outputs.get(0);
            outputsFinal.stackSize = stackSize;
            addRecipe(input1, input2, outputsFinal, time);
        }
    }

    public static void addOreDictRecipe(String ore1, String ore2, String output, int time, int stackSize) {
        ArrayList<ItemStack> ores1 = OreDictionary.getOres(ore1);
        ArrayList<ItemStack> ores2 = OreDictionary.getOres(ore2);
        ArrayList<ItemStack> outputs = OreDictionary.getOres(output);
        if (ores1 != null && ores1.size() > 0 && ores2 != null && ores2.size() > 0 && output != null && outputs.size() > 0) {
            for (ItemStack oreList1 : OreDictionary.getOres(ore1)) {
                for (ItemStack oreList2 : OreDictionary.getOres(ore2)) {
                    ItemStack outputsFinal = outputs.get(0);
                    outputsFinal.stackSize = stackSize;
                    addRecipe(oreList1, oreList2, outputsFinal, time);
                }
            }
        }
    }

    public static Recipe2_1 getRecipeFromStack(ItemStack stack1, ItemStack stack2) {
        if (stack1 == null || stack2 == null)
            return null;
        for (Recipe2_1 r : recipe21List) {
            if (r.getInput1().getItem().equals(stack1.getItem()) && r.getInput2().getItem().equals(stack2.getItem()) && r.getInput1().getItemDamage() == stack1.getItemDamage()
                    && r.getInput2().getItemDamage() == stack2.getItemDamage())
                return r;
            if (r.getInput2().getItem().equals(stack1.getItem()) && r.getInput1().getItem().equals(stack2.getItem()) && r.getInput2().getItemDamage() == stack1.getItemDamage()
                    && r.getInput1().getItemDamage() == stack2.getItemDamage())
                return r;
        }
        return null;
    }

    public static Recipe2_1[] getRecipesFromStack(ItemStack stack) {
        List<Recipe2_1> out = new ArrayList<Recipe2_1>();
        if (stack == null)
            return null;
        for (Recipe2_1 r : recipe21List) {
            if (r.getInput1().isItemEqual(stack) || r.getInput2().isItemEqual(stack))
                out.add(r);
        }
        return out.toArray(new Recipe2_1[0]);
    }

    public static List<Recipe2_1> getAllRecipes() {
        return ImmutableList.copyOf(recipe21List);
    }
}
