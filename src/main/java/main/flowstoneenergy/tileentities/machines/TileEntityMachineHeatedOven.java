package main.flowstoneenergy.tileentities.machines;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import main.flowstoneenergy.blocks.upgrades.BlockUpgrades;
import main.flowstoneenergy.tileentities.recipes.Recipe1_1;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityMachineHeatedOven extends TileEntityMachineBase implements IEnergyHandler {

    @SuppressWarnings("unused")
    private String field_145958_o;


    public TileEntityMachineHeatedOven() {
        items = new ItemStack[2];
        maxTicks = 150;
        energyRequired = 1600;
        energyCapacity = 32000;
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
        if (worldObj.isRemote) return;
        if (items[0] != null  && this.canSmelt() && energy.getEnergyStored() >= energyRequired) {
            if (ticksLeft == maxTicks) {
                smelt();
                energy.extractEnergy(1600, true);
                resetTimeAndTexture();
            }
            else{
                ticksLeft++;
            }
        }
        else{
            resetTimeAndTexture();
        }

    }
//&& energy.getEnergyStored() >= 1600
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

    public void getUpgrade(){
        if (worldObj.getBlock(xCoord, yCoord+1, zCoord) instanceof BlockUpgrades){

        }
    }



    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        return energy.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {
        return energy.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return energy.getMaxEnergyStored();
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return true;
    }
}
