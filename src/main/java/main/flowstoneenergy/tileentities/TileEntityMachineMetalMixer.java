package main.flowstoneenergy.tileentities;

import main.flowstoneenergy.tileentities.recipes.Recipe2_1;
import main.flowstoneenergy.tileentities.recipes.RecipesMetalMixer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMachineMetalMixer extends TileEntity implements ISidedInventory {

    private ItemStack[] items = new ItemStack[4];
    public static final int INV_SIZE = 2;
    private int ticksLeft = 0;
    private int maxTicks = 0;

    @SuppressWarnings("unused")
    private String field_145958_o;

    @Override
    public int getSizeInventory() {
        return items.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return items[slot];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (this.items[i] != null) {
            ItemStack itemstack;

            if (this.items[i].stackSize <= j) {
                itemstack = this.items[i];
                this.items[i] = null;
                return itemstack;
            } else {
                itemstack = this.items[i].splitStack(j);

                if (this.items[i].stackSize == 0) {
                    this.items[i] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if (this.items[i] != null) {
            ItemStack itemstack = this.items[i];
            this.items[i] = null;
            return itemstack;
        } else {
        }

        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        this.items[i] = itemstack;

        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
            itemstack.stackSize = this.getInventoryStackLimit();
        }
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
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer var1) {
        return true;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }

    @Override
    public boolean isItemValidForSlot(int var1, ItemStack var2) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        // TODO Auto-generated method stub
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
        //Something in input and nothing currently processing
        if (items[0] != null && items[1] != null && ticksLeft == 0) {
            Recipe2_1 r = RecipesMetalMixer.GetRecipeFromStack(items[0], items[1]);
            if (r != null) {
                maxTicks = r.getTime();
            }
        }
        //Actual processing
        if (ticksLeft < maxTicks && RecipesMetalMixer.GetRecipeFromStack(items[0], items[1]) != null) {
            if (items[2] == null || RecipesMetalMixer.GetRecipeFromStack(items[0], items[1]).getOutput().getItem().equals(items[2].getItem())) {
                ticksLeft++;
            } else {
                ticksLeft = 0;
            }
        }
        if (RecipesMetalMixer.GetRecipeFromStack(items[0], items[1]) == null && ticksLeft > 0) {
            ticksLeft = 0;
        }
        if (ticksLeft == maxTicks && maxTicks != 0) {
            ticksLeft = 0;
            mixMetals();
        }
    }

    private void mixMetals() {
        if (items[0] == null || items[1] == null) return;
        ItemStack res = RecipesMetalMixer.GetRecipeFromStack(items[0], items[1]).getOutput();
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
