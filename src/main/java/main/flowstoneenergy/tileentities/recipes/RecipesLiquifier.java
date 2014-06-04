package main.flowstoneenergy.tileentities.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class RecipesLiquifier {
	public static List<FluidRecipe2_1> recipe21List = new ArrayList<FluidRecipe2_1>();

    public static void addRecipe(ItemStack input1, ItemStack input2, FluidStack output, int amount, int time) {
    	FluidRecipe2_1 r = new FluidRecipe2_1(input1, input2, output, amount,time);
        recipe21List.add(r);
    }

    public static FluidRecipe2_1 getRecipeFromStack(ItemStack stack1, ItemStack stack2) {
        if (stack1 == null || stack2 == null) return null;
        for (FluidRecipe2_1 r : recipe21List) {
            if (r.getInput1().getItem().equals(stack1.getItem()) && r.getInput2().getItem().equals(stack2.getItem())
                    && r.getInput1().getItemDamage() == stack1.getItemDamage() && r.getInput2().getItemDamage() == stack2.getItemDamage())
                return r;
            if (r.getInput2().getItem().equals(stack1.getItem()) && r.getInput1().getItem().equals(stack2.getItem())
                    && r.getInput2().getItemDamage() == stack1.getItemDamage() && r.getInput1().getItemDamage() == stack2.getItemDamage())
                return r;
        }
        return null;
    }

    public static FluidRecipe2_1[] getRecipesFromStack(ItemStack stack) {
        List<FluidRecipe2_1> out = new ArrayList<FluidRecipe2_1>();
        if (stack == null) return null;
        for (FluidRecipe2_1 r : recipe21List) {
            if (r.getInput1().getItem().equals(stack.getItem()) || r.getInput2().getItem().equals(stack.getItem()))
                out.add(r);
        }
        return out.toArray(new FluidRecipe2_1[0]);
    }
}
