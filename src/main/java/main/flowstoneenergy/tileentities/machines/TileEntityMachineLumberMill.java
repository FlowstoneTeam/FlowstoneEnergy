package main.flowstoneenergy.tileentities.machines;

import main.flowstoneenergy.tileentities.recipes.Recipe1_1;
import main.flowstoneenergy.tileentities.recipes.RecipesLumberMill;
import net.minecraft.item.ItemStack;

public class TileEntityMachineLumberMill extends TileEntityMachineBase {

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineLumberMill() {
        items = new ItemStack[2];
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        if (slot != 0) return false;
        for (Recipe1_1 r : RecipesLumberMill.recipe11List) {
            if (r.getInput().getItem().equals(stack.getItem())) return true;
        }
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[]{0, 1};
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int side) {
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
            Recipe1_1 r = RecipesLumberMill.getRecipeFromStack(items[0]);
            if (r != null) {
                maxTicks = r.getTime();
            }
        }
        if (ticksLeft < maxTicks && RecipesLumberMill.getRecipeFromStack(items[0]) != null) {
            Recipe1_1 r = RecipesLumberMill.getRecipeFromStack(items[0]);
            if (items[1] == null || (r.getOutput().isItemEqual(items[1]) && r.getOutput().getMaxStackSize() > items[1].stackSize + 4)) {
                ticksLeft++;
                worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            } else {
                ticksLeft = 0;
                resetTimeAndTexture();
            }
        }
        if (RecipesLumberMill.getRecipeFromStack(items[0]) == null && ticksLeft > 0) {
            ticksLeft = 0;
            resetTimeAndTexture();
        }
        if (ticksLeft == maxTicks) {
            ticksLeft = 0;
            smelt();
        }
    }

    private void smelt() {
        if (RecipesLumberMill.getRecipeFromStack(items[0]) == null) return;
        ItemStack res = RecipesLumberMill.getRecipeFromStack(items[0]).getOutput();
        if (items[1] == null)
            items[1] = res.copy();
        else
            items[1].stackSize += res.stackSize;


        items[0].stackSize--;
        if (items[0].stackSize <= 0) {
            items[0] = null;
        }
    }

    public int getScaledProgress(int scale) {
        if (maxTicks == 0) return 0;
        return ticksLeft * scale / maxTicks;
    }
}
