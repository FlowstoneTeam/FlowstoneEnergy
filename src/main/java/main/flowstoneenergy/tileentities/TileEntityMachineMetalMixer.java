package main.flowstoneenergy.tileentities;

import main.flowstoneenergy.tileentities.recipes.Recipe2_1;
import main.flowstoneenergy.tileentities.recipes.RecipesMetalMixer;
import net.minecraft.item.ItemStack;

public class TileEntityMachineMetalMixer extends TileEntityMachineBase {

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineMetalMixer() {
        items = new ItemStack[4];
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
        if (slot != 0 || slot != 1) return false;
        for (Recipe2_1 r : RecipesMetalMixer.recipe21List) {
            if (r.getInput1().getItem().equals(stack.getItem()) || r.getInput2().getItem().equals(stack.getItem()))
                return true;
        }
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[]{0, 1, 2, 3};
    }

    @Override
    public boolean canInsertItem(int var1, ItemStack var2, int var3) {
        return true;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, int side) {
        return slot == 2;
    }

    public void func_145951_a(String displayName) {
        this.field_145958_o = displayName;
    }

    @Override
    public void updateEntity() {

        if (items[0] != null && items[1] != null && ticksLeft == 0) {
            Recipe2_1 r = RecipesMetalMixer.getRecipeFromStack(items[0], items[1]);
            if (r != null) {
                maxTicks = r.getTime();
            }
        }

        if (ticksLeft < maxTicks && RecipesMetalMixer.getRecipeFromStack(items[0], items[1]) != null) {
            if (items[2] == null || RecipesMetalMixer.getRecipeFromStack(items[0], items[1]).getOutput().getItem().equals(items[2].getItem())) {
                ticksLeft++;
                worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            } else {
                ticksLeft = 0;
                resetTimeAndTexture();
            }
        }
        if (RecipesMetalMixer.getRecipeFromStack(items[0], items[1]) == null && ticksLeft > 0) {
            ticksLeft = 0;
            resetTimeAndTexture();
        }
        if (ticksLeft == maxTicks && maxTicks != 0) {
            ticksLeft = 0;
            mixMetals();
        }
    }

    private void mixMetals() {
        if (items[0] == null || items[1] == null) return;
        ItemStack res = RecipesMetalMixer.getRecipeFromStack(items[0], items[1]).getOutput();
        if (items[2] == null)
            items[2] = res.copy();
        else if (items[2].stackSize == res.getMaxStackSize())
            if (items[3] == null)
                items[3] = res.copy();
            else
                items[3].stackSize += res.stackSize;
        else
            items[2].stackSize += res.stackSize;

        items[0].stackSize -= 2;
        if (items[0].stackSize <= 0) {
            items[0] = null;
        }
        items[1].stackSize--;
        if (items[1].stackSize <= 0) {
            items[1] = null;
        }
    }

    public int getScaledProgress(int scale) {
        if (maxTicks == 0) return 0;
        return ticksLeft * scale / maxTicks;
    }
}
