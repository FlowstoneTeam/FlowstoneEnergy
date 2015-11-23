package main.flowstoneenergy.tileentities.machines;

/*import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;*/
import main.flowstoneenergy.blocks.upgrades.BlockUpgrades;
import main.flowstoneenergy.tileentities.recipes.Recipe1_1;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;

//TODO: Enable after update
public class TileEntityMachineHeatedOven extends TileEntityMachineBase /*implements IEnergyHandler */{

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineHeatedOven() {
        items = new ItemStack[2];
        maxTicks = 150;
        energyRequired = 1600;
        energyCapacity = 32000;
    }

    @Override
    public String getCommandSenderName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return true;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        if (slot != 0)
            return false;
        if (FurnaceRecipes.instance().getSmeltingResult(stack) != null)
            return true;
        return false;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return new int[]{0, 1};
    }

    @Override
    public boolean canInsertItem(int slotId, ItemStack itemStack, EnumFacing side) {
        return true;
    }

    @Override
    public boolean canExtractItem(int slotId, ItemStack itemStack, EnumFacing side) {
        return slotId == 1;
    }

    public void func_145951_a(String displayName) {
        this.field_145958_o = displayName;
    }

    @Override
    public void update() {
        super.update();

        if (upgradeCheckTimer >= 20) {
            getUpgrades();
        } else {
            upgradeCheckTimer++;
        }

        // TODO: Enable after update
        /*
        if (items[0] != null && this.canSmelt() && energy.getEnergyStored() >= energyRequired) {
            if (ticksLeft == maxTicks) {
                smelt();
                resetTimeAndTexture();
            } else {
                ticksLeft++;
            }
        } else {*/
            resetTimeAndTexture();
        //}

    }

    // && energy.getEnergyStored() >= 1600
    public void smelt() {
        if (this.canSmelt()) {
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.items[0]);
            if (this.items[1] == null) {
                this.items[1] = itemstack.copy();
            } else if (this.items[1].getItem() == itemstack.getItem()) {
                this.items[1].stackSize += itemstack.stackSize; // Forge BugFix:
                                                                // Results may
                                                                // have multiple
                                                                // items
            }

            --this.items[0].stackSize;

            if (this.items[0].stackSize <= 0) {
                this.items[0] = null;
            }
            // TODO: Enable after update
            //energy.extractEnergy(1600, false);
        }
    }

    private boolean canSmelt() {
        if (this.items[0] == null) {
            return false;
        } else {
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.items[0]);
            if (itemstack == null)
                return false;
            if (this.items[1] == null)
                return true;
            if (!this.items[1].isItemEqual(itemstack))
                return false;
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

    @Override
    public int getField(int id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setField(int id, int value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getFieldCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public IChatComponent getDisplayName() {
        // TODO Auto-generated method stub
        return null;
    }

    // TODO: Enable after update
    /*@Override
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
    }*/
}
