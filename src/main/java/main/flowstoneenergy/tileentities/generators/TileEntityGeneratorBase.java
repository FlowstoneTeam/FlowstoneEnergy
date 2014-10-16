package main.flowstoneenergy.tileentities.generators;

import net.minecraft.item.ItemStack;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineBase;

public class TileEntityGeneratorBase extends TileEntityMachineBase{

    public TileEntityGeneratorBase() {
        items = new ItemStack [0]; //TODO: To be removed
    }
    @Override
    public int[] getAccessibleSlotsFromSide(int slot) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, int side) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, int side) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getInventoryName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        // TODO Auto-generated method stub
        return false;
    }

}
