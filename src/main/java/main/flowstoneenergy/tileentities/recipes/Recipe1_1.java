package main.flowstoneenergy.tileentities.recipes;

import net.minecraft.item.ItemStack;

public class Recipe1_1 {

    private ItemStack input;
    private ItemStack output;
    private int time;
    private int powerRequired;

    /**
     * Creates a recipe with 1 input and one output
     *
     * @param input
     *            Input item stack
     * @param output
     *            Output item stack
     * @param time
     *            Time in ticks
     */
    public Recipe1_1(ItemStack input, ItemStack output, int time, int powerRequired) {
        this.input = input.copy();
        this.output = output.copy();
        this.time = time;
        this.powerRequired = powerRequired;
    }

    public ItemStack getInput() {
        return input;
    }

    public ItemStack getOutput() {
        return output;
    }

    public int getTime() {
        return time;
    }

    public int getPowerRequired() {
        return powerRequired;
    }
}
