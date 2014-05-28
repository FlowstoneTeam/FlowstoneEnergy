package main.flowstoneenergy.tileentities.recipes;

import net.minecraft.item.ItemStack;

public class Recipe3_1 {

    private ItemStack input1;
    private ItemStack input2;
    private ItemStack input3;
    private ItemStack output;
    private int time;

    public Recipe3_1(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack output, int time) {
        this.input1 = input1.copy();
        this.input2 = input2.copy();
        this.input3 = input3.copy();
        this.output = output.copy();
        this.time = time;
    }

	//Center
    public ItemStack getInput1() {
        return input1;
    }

	//Left
    public ItemStack getInput2() {
        return input2;
    }

	//Right
    public ItemStack getInput3() {
        return input3;
    }

    public ItemStack getOutput() {
        return output;
    }

    public int getTime() {
        return time;
    }

}