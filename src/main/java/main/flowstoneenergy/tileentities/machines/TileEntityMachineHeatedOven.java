package main.flowstoneenergy.tileentities.machines;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class TileEntityMachineHeatedOven extends TileEntityMachineBase {

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineHeatedOven() {
        items = new ItemStack[2];
        maxTicks = 150;
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
        if (FurnaceRecipes.smelting().getSmeltingResult(stack) != null) return true;
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

        if (items[0] != null) {

            if (this.canSmelt()) {
                ticksLeft++;
                worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            } else {
                ticksLeft = 0;
                resetTimeAndTexture();
            }

            if (ticksLeft == maxTicks) {
                ticksLeft = 0;
                smelt();
            }
        }

        if (this.items[0] == null && ticksLeft > 0) {
            resetTimeAndTexture();
        }
    }

    public void smelt() {
        if (this.canSmelt()) {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.items[0]);

            if (this.items[1] == null) {
                this.items[1] = itemstack.copy();
            } else if (this.items[1].getItem() == itemstack.getItem()) {
                this.items[1].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.items[0].stackSize;

            if (this.items[0].stackSize <= 0) {
                this.items[0] = null;
            }
        }
    }

    private boolean canSmelt() {
        if (this.items[0] == null) {
            return false;
        } else {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.items[0]);
            if (itemstack == null) return false;
            if (this.items[1] == null) return true;
            if (!this.items[1].isItemEqual(itemstack)) return false;
            int result = items[1].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.items[1].getMaxStackSize();
        }
    }

    public int getScaledProgress(int scale) {
        if (maxTicks == 0) {
            return 0;
        }
        return ticksLeft * scale / maxTicks;
    }
}
