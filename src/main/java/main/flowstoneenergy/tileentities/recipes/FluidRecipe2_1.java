package main.flowstoneenergy.tileentities.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class FluidRecipe2_1 {
	private ItemStack input1;
    private ItemStack input2;
    private FluidStack output;
    private int amount;
    private int time;
	
	public FluidRecipe2_1(ItemStack input1, ItemStack input2, FluidStack output, int amount, int time) {
        this.input1 = input1.copy();
        this.input2 = input2.copy();
        this.output = output.copy();
        this.amount = amount;
        this.time = time;
    }
	
	public ItemStack getInput1() {
        return input1;
    }

    public ItemStack getInput2() {
        return input2;
    }

    public FluidStack getOutput() {
        return output;
    }

    public int getAmount() {
        return amount;
    }

    public int getTime() {
        return time;
    }
}
