package main.flowstoneenergy.core.containers;

import main.flowstoneenergy.tileentities.machines.TileEntityMachineWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;

public class ContainerMachineWorkbench extends Container {
    public ContainerMachineWorkbench(EntityPlayer player, TileEntityMachineWorkbench tile) {
        createSlots(tile, player);
        bindPlayerInventory(player.inventory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.isUseableByPlayer(player);
    }

    private boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    private void createSlots(TileEntityMachineWorkbench tile, EntityPlayer player) {
        addSlotToContainer(new Slot(tile, 0, 29, 16));
        addSlotToContainer(new Slot(tile, 1, 52, 16));
        addSlotToContainer(new Slot(tile, 2, 75, 16));
        addSlotToContainer(new SlotFurnaceOutput(player, tile, 3, 129, 34));
    }

    private void bindPlayerInventory(InventoryPlayer inv) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inv, i, 8 + i * 18, 142));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 3) {
                if (!this.mergeItemStack(itemstack1, 4, 40, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (par2 != 0 && par2 != 1 && par2 != 2) {
                if (slot.isItemValid(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 0, 3, false)) {
                        return null;
                    }
                } else if (par2 >= 4 && par2 < 31) {
                    if (!this.mergeItemStack(itemstack1, 31, 40, false)) {
                        return null;
                    }
                } else if (par2 >= 31 && par2 < 40 && !this.mergeItemStack(itemstack1, 3, 31, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 4, 40, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack) null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}
