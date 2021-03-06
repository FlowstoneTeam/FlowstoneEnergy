package main.flowstoneenergy.tileentities.recipes;

import com.google.common.collect.ImmutableList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class RecipesMachineWorkbench {

    public static ArrayList<Recipe3_1> recipe31List = new ArrayList<Recipe3_1>();

    public static void addRecipe(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack output, int time) {
        Recipe3_1 r = new Recipe3_1(input1, input2, input3, output, time);
        recipe31List.add(r);
    }

    public static void addOreDictRecipe(String ore1, String ore2, String ore3, ItemStack output, int time) {
        List<ItemStack> ores1 = OreDictionary.getOres(ore1);
        List<ItemStack> ores2 = OreDictionary.getOres(ore2);
        List<ItemStack> ores3 = OreDictionary.getOres(ore3);
        if (ores1 != null && ores1.size() > 0 && ores2 != null && ores2.size() > 0 && ores3 != null && ores3.size() > 0) {
            for (ItemStack oreList1 : OreDictionary.getOres(ore1)) {
                for (ItemStack oreList2 : OreDictionary.getOres(ore2)) {
                    for (ItemStack oreList3 : OreDictionary.getOres(ore3)) {
                        RecipesMachineWorkbench.addRecipe(oreList1, oreList2, oreList3, output, time);
                    }
                }
            }
        }
    }

    public static void addOreDictRecipe(String ore1, String ore2, String ore3, String output, int time, int stackSize) {
        List<ItemStack> ores1 = OreDictionary.getOres(ore1);
        List<ItemStack> ores2 = OreDictionary.getOres(ore2);
        List<ItemStack> ores3 = OreDictionary.getOres(ore3);
        List<ItemStack> outputs = OreDictionary.getOres(output);
        if (ores1 != null && ores1.size() > 0 && ores2 != null && ores2.size() > 0 && ores3 != null && ores3.size() > 0 && output != null && outputs.size() > 0) {
            for (ItemStack oreList1 : OreDictionary.getOres(ore1)) {
                for (ItemStack oreList2 : OreDictionary.getOres(ore2)) {
                    for (ItemStack oreList3 : OreDictionary.getOres(ore3)) {
                        ItemStack outputsFinal = outputs.get(0);
                        outputsFinal.stackSize = stackSize;
                        RecipesMachineWorkbench.addRecipe(oreList1, oreList2, oreList3, outputsFinal, time);
                    }
                }
            }
        }
    }

    public static Recipe3_1 getRecipeFromStack(ItemStack stack1, ItemStack stack2, ItemStack stack3) {
        if (stack1 == null || stack2 == null || stack3 == null)
            return null;
        for (Recipe3_1 r : recipe31List) {
            if (r.getInput1().getItem().equals(stack1.getItem()) && r.getInput2().getItem().equals(stack2.getItem()) && r.getInput3().getItem().equals(stack3.getItem())
                    && r.getInput1().getItemDamage() == stack1.getItemDamage() && r.getInput2().getItemDamage() == stack2.getItemDamage()
                    && r.getInput3().getItemDamage() == stack3.getItemDamage()) {
                return r;
            }
            if (r.getInput1().getItem().equals(stack1.getItem()) && r.getInput2().getItem().equals(stack3.getItem()) && r.getInput3().getItem().equals(stack2.getItem())
                    && r.getInput1().getItemDamage() == stack1.getItemDamage() && r.getInput2().getItemDamage() == stack3.getItemDamage()
                    && r.getInput3().getItemDamage() == stack2.getItemDamage()) {
                return r;
            }
            if (r.getInput1().getItem().equals(stack2.getItem()) && r.getInput2().getItem().equals(stack1.getItem()) && r.getInput3().getItem().equals(stack3.getItem())
                    && r.getInput1().getItemDamage() == stack2.getItemDamage() && r.getInput2().getItemDamage() == stack1.getItemDamage()
                    && r.getInput3().getItemDamage() == stack3.getItemDamage()) {
                return r;
            }
            if (r.getInput1().getItem().equals(stack3.getItem()) && r.getInput2().getItem().equals(stack2.getItem()) && r.getInput3().getItem().equals(stack1.getItem())
                    && r.getInput1().getItemDamage() == stack3.getItemDamage() && r.getInput2().getItemDamage() == stack2.getItemDamage()
                    && r.getInput3().getItemDamage() == stack1.getItemDamage()) {
                return r;
            }
            if (r.getInput1().getItem().equals(stack3.getItem()) && r.getInput2().getItem().equals(stack1.getItem()) && r.getInput3().getItem().equals(stack2.getItem())
                    && r.getInput1().getItemDamage() == stack3.getItemDamage() && r.getInput2().getItemDamage() == stack1.getItemDamage()
                    && r.getInput3().getItemDamage() == stack2.getItemDamage()) {
                return r;
            }
            if (r.getInput1().getItem().equals(stack2.getItem()) && r.getInput2().getItem().equals(stack3.getItem()) && r.getInput3().getItem().equals(stack1.getItem())
                    && r.getInput1().getItemDamage() == stack2.getItemDamage() && r.getInput3().getItemDamage() == stack3.getItemDamage()
                    && r.getInput3().getItemDamage() == stack1.getItemDamage()) {
                return r;
            }
        }
        return null;
    }

    public static Recipe3_1[] getRecipesFromStack(ItemStack stack) {
        List<Recipe3_1> out = new ArrayList<Recipe3_1>();
        if (stack == null)
            return null;
        for (Recipe3_1 r : recipe31List) {
            if (r.getInput1().isItemEqual(stack) || r.getInput2().isItemEqual(stack) || r.getInput3().isItemEqual(stack))
                out.add(r);
        }
        return out.toArray(new Recipe3_1[0]);
    }

    public static List<Recipe3_1> getAllRecipes() {
        return ImmutableList.copyOf(recipe31List);
    }

}