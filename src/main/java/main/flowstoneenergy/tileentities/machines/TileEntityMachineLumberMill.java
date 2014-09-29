package main.flowstoneenergy.tileentities.machines;

import cofh.api.energy.IEnergyHandler;
import main.flowstoneenergy.tileentities.recipes.Recipe1_1;
import main.flowstoneenergy.tileentities.recipes.RecipesLumberMill;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityMachineLumberMill extends TileEntityMachineBase implements IEnergyHandler {

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineLumberMill() {
        items = new ItemStack[2];
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        if (slot != 0) return false;
        for (Recipe1_1 r : RecipesLumberMill.recipe11List) {
            if (r.getInput().getItem().equals(stack.getItem())) return true;
        }
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[]{0, 1};
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int side) {
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
//(r.getOutput().isItemEqual(items[1]) && items[1].getMaxStackSize() > items[1].stackSize + 6)|| items[1].stackSize == 0
//energy.getEnergyStored() > r.getPowerRequired()
        if (worldObj.isRemote)return;
        Recipe1_1 r = RecipesLumberMill.getRecipeFromStack(items[0]);

        if(items[0] != null && r != null && (r.getOutput().isItemEqual(items[1]) && items[1].getMaxStackSize() > items[1].stackSize + 6)|| items[1].stackSize == 0) {
            if(ticksLeft >= maxTicks ){
                energy.extractEnergy(r.getPowerRequired(), true);
                smelt();
                resetTimeAndTexture();
            }else{
                ticksLeft++;
            }
        }else{
            resetTimeAndTexture();
        }
    }

    private void smelt() {
        if (RecipesLumberMill.getRecipeFromStack(items[0]) == null) return;
        ItemStack res = RecipesLumberMill.getRecipeFromStack(items[0]).getOutput();
        if (items[1] == null)
            items[1] = res.copy();
        else
            items[1].stackSize += res.stackSize;


        items[0].stackSize--;
        if (items[0].stackSize <= 0) {
            items[0] = null;
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
