package main.flowstoneenergy.core.slots;

import cofh.api.energy.IEnergyContainerItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCharging extends Slot {

    public SlotCharging(IInventory inventory, int slotIndex, int xPosition, int yPosition) {
        super(inventory, slotIndex, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        if (stack == null || stack.getItem() == null)
            return false;

        if (stack.getItem() instanceof IEnergyContainerItem)
            return true;
        else
            return false;
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }

}
