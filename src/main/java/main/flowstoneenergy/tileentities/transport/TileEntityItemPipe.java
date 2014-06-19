package main.flowstoneenergy.tileentities.transport;

import main.flowstoneenergy.tileentities.machines.TileEntityMachineBase;
import net.minecraft.item.ItemStack;

public class TileEntityItemPipe extends TileEntityMachineBase {

    @Override
    public int[] getAccessibleSlotsFromSide(int i) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemStack, int i2) {
        return false;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemStack, int i2) {
        return false;
    }

    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return false;
    }
}
