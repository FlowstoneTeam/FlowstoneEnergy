package main.flowstoneenergy.tileentities.recipes;

import net.minecraft.item.ItemStack;

public class Recipe2_1 {
    private ItemStack input1;
    private ItemStack input2;
    private ItemStack output;
    private int time;

    /**
     * Creates a new recipe with 2 inputs and one output.
     *
     * @param input1 1st Input item stack
     * @param input2 2nd Input item stack
     * @param output Output item stack
     * @param time   Time in ticks
     */
    public Recipe2_1(ItemStack input1, ItemStack input2, ItemStack output, int time) {
        this.input1 = input1.copy();
        this.input2 = input2.copy();
        this.output = output.copy();
        this.time = time;
    }

    public ItemStack getInput1() {
        return input1;
    }

    public ItemStack getInput2() {
        return input2;
    }

    public ItemStack getOutput() {
        return output;
    }

    public int getTime() {
        return time;
    }
}
