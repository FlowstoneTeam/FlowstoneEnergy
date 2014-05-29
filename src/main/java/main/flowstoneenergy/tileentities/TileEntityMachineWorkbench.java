package main.flowstoneenergy.tileentities;

import main.flowstoneenergy.tileentities.recipes.Recipe3_1;
import main.flowstoneenergy.tileentities.recipes.RecipesMachineWorkbench;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityMachineWorkbench extends TileEntityMachineBase {

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineWorkbench() {
        items = new ItemStack[10];
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
    public boolean isItemValidForSlot(int var1, ItemStack var2) {
        return true;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return null;
    }

    @Override
    public boolean canInsertItem(int var1, ItemStack var2, int var3) {
        return true;
    }

    @Override
    public boolean canExtractItem(int var1, ItemStack var2, int var3) {
        return true;
    }

    public void func_145951_a(String displayName) {
        this.field_145958_o = displayName;
    }

    @Override
    public void updateEntity() {
        if (items[0] != null && items[1] != null && ticksLeft == 0) {
            Recipe3_1 r = RecipesMachineWorkbench.getRecipeFromStack(items[0], items[1], items[2]);
            if (r != null) {
                maxTicks = r.getTime();
            }
        }

        if (ticksLeft < maxTicks && RecipesMachineWorkbench.getRecipeFromStack(items[0], items[1], items[2]) != null) {
            if (items[2] == null || RecipesMachineWorkbench.getRecipeFromStack(items[0], items[1], items[2]).getOutput().getItem().equals(items[2].getItem())) {
                ticksLeft++;
                worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            } else {
                ticksLeft = 0;
                resetTimeAndTexture();
            }
        }
        if (RecipesMachineWorkbench.getRecipeFromStack(items[0], items[1], items[2]) == null && ticksLeft > 0) {
            ticksLeft = 0;
            resetTimeAndTexture();
        }
        if (ticksLeft == maxTicks && maxTicks != 0) {
            ticksLeft = 0;
            createMachine();
        }
    }

    private void createMachine() {
        if (items[0] == null || items[1] == null || items[2] == null) return;
        ItemStack res = RecipesMachineWorkbench.getRecipeFromStack(items[0], items[1], items[2]).getOutput();
        if (items[3] == null)
            items[3] = res.copy();
        else
            items[3].stackSize += res.stackSize;

        for (int i = 1; i <= 4; i++) {
            items[i].stackSize--;
            if (items[i].stackSize <= 0) {
                items[i] = null;
            }
        }
    }

    public int getScaledProgress(int scale) {
        if (maxTicks == 0) return 0;
        return ticksLeft * scale / maxTicks;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setBoolean("onOff", false);
    }
}
