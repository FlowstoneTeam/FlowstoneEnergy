package main.flowstoneenergy.tileentities.machines;

import main.flowstoneenergy.tileentities.recipes.Recipe1_1;
import main.flowstoneenergy.tileentities.recipes.RecipesEnergizedOreTumbler;
import net.minecraft.item.ItemStack;

public class TileEntityMachineOreTumbler extends TileEntityMachineBase {

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineOreTumbler() {
        items = new ItemStack[2];
    }

    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        if (slot != 0) return false;
        for (Recipe1_1 r : RecipesEnergizedOreTumbler.recipe11List) {
            if (r.getInput().getItem().equals(stack.getItem())) return true;
        }
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[]{0, 1};
    }

    @Override
    public boolean canInsertItem(int var1, ItemStack var2, int var3) {
        return true;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, int side) {
        return slot == 1;
    }

    public void func_145951_a(String displayName) {
        this.field_145958_o = displayName;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if (items[0] != null && ticksLeft == 0) {
            Recipe1_1 r = RecipesEnergizedOreTumbler.getRecipeFromStack(items[0]);
            if (r != null) {
                maxTicks = r.getTime();
            }
        }
        if (ticksLeft < maxTicks && RecipesEnergizedOreTumbler.getRecipeFromStack(items[0]) != null) {
            if (items[1] == null || RecipesEnergizedOreTumbler.getRecipeFromStack(items[0]).getOutput().getItem().equals(items[1].getItem())) {
                ticksLeft++;
                worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            } else {
                ticksLeft = 0;
                resetTimeAndTexture();
            }
        }
        if (RecipesEnergizedOreTumbler.getRecipeFromStack(items[0]) == null && ticksLeft > 0) {
            ticksLeft = 0;
            resetTimeAndTexture();
        }
        if (ticksLeft == maxTicks) {
            ticksLeft = 0;
            oreDouble();
        }
    }

    private void oreDouble() {
        if (RecipesEnergizedOreTumbler.getRecipeFromStack(items[0]) != null) {
            ItemStack res = RecipesEnergizedOreTumbler.getRecipeFromStack(items[0]).getOutput();
            if (items[1] == null)
                items[1] = res.copy();
            else
                items[1].stackSize += res.stackSize;


            items[0].stackSize--;
            if (items[0].stackSize <= 0) {
                items[0] = null;
            }
        }
    }

    public int getScaledProgress(int scale) {
        if (maxTicks == 0) return 0;
        return ticksLeft * scale / maxTicks;
    }
}