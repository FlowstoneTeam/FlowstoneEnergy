package main.flowstoneenergy.tileentities.machines;

import cofh.api.energy.IEnergyHandler;
import main.flowstoneenergy.tileentities.recipes.Recipe2_1;
import main.flowstoneenergy.tileentities.recipes.RecipesMetalMixer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityMachineMetalMixer extends TileEntityMachineBase implements IEnergyHandler {

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineMetalMixer() {
        maxTicks = 100;
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
        super.updateEntity();
        Recipe2_1 r = RecipesMetalMixer.getRecipeFromStack(items[0], items[1]);
        if(items[0] != null && items[1] != null && r != null && (items[2] != null || items[3] != null) && (r.getOutput().isItemEqual(items[2]) && items[2].getMaxStackSize() >= items[2].stackSize + 2) && energy.getEnergyStored() >= 2000){
            if(ticksLeft >= maxTicks){
                energy.extractEnergy(2000, true);
                ticksLeft = 0;
                mixMetals();
                resetTimeAndTexture();
            }else{
                ticksLeft++;
            }

        } else{
            ticksLeft = 0;
        }

        if(items[0] != null && items[1] != null && r != null && items[2] == null && items[3] == null && energy.getEnergyStored() >= 2000){
            if(ticksLeft >= maxTicks){
                this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
                energy.extractEnergy(2000, true);
                ticksLeft = 0;
                mixMetals();
                ticksLeft = 0;
            }else{
                ticksLeft++;
            }
        }  else {
            ticksLeft = 0;
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
