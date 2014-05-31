package main.flowstoneenergy.tileentities.recipes;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class RecipesMachineWorkbench {

    public static ArrayList<Recipe3_1> recipe31List = new ArrayList<Recipe3_1>();

    public static void addRecipe(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack output, int time) {
        Recipe3_1 r = new Recipe3_1(input1, input2, input3, output, time);
        recipe31List.add(r);
    }

    public static Recipe3_1 getRecipeFromStack(ItemStack stack1, ItemStack stack2, ItemStack stack3) {
        if (stack1 == null || stack2 == null || stack3 == null) return null;
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
}