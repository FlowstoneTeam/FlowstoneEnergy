package main.flowstoneenergy.tileentities.machines;

//import cofh.api.energy.IEnergyHandler;
import main.flowstoneenergy.tileentities.recipes.RecipesEnergizedOreTumbler;
import main.flowstoneenergy.tileentities.recipes.Recipe1_1;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;

//TODO: Enable after update
public class TileEntityMachineOreTumbler extends TileEntityMachineBase /*implements IEnergyHandler*/ {

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineOreTumbler() {
        items = new ItemStack[2];
        // TODO: Enable after update
        //this.energy.setMaxExtract(2000);
    }

    @Override
    public String getName() {
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
        for (Recipe1_1 r : RecipesEnergizedOreTumbler.recipe11List) {
            if (r.getInput().getItem().equals(stack.getItem()))
                return true;
        }
        return false;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return new int[]{0, 1};
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, EnumFacing side) {
        return true;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, EnumFacing side) {
        return slot == 1;
    }

    public void func_145951_a(String displayName) {
        this.field_145958_o = displayName;
    }

    @Override
    public void update() {
        super.update();

        if (items[0] != null && ticksLeft == 0) {
            Recipe1_1 r = RecipesEnergizedOreTumbler.getRecipeFromStack(items[0]);
            if (r != null) {
                maxTicks = r.getTime() - (r.getTime() * divisionFactor);
            }
        }
        // TODO: Enable after update
        /*int availablePower = this.energy.extractEnergy(2000, true);
        if (ticksLeft < maxTicks && RecipesEnergizedOreTumbler.getRecipeFromStack(items[0]) != null && availablePower >= 2000) {
            Recipe1_1 r = RecipesEnergizedOreTumbler.getRecipeFromStack(items[0]);
            if (items[1] == null || (r.getOutput().isItemEqual(items[1]) && r.getOutput().getMaxStackSize() > items[1].stackSize)) {
                ticksLeft++;
                worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            } else {
                ticksLeft = 0;
                resetTimeAndTexture();
            }
        }*/
        if (RecipesEnergizedOreTumbler.getRecipeFromStack(items[0]) == null && ticksLeft > 0) {
            ticksLeft = 0;
            resetTimeAndTexture();
        }
        if (ticksLeft == maxTicks) {
            ticksLeft = 0;
            oreDouble();
        }
    }

    private void oreDouble() {
        if (RecipesEnergizedOreTumbler.getRecipeFromStack(items[0]) != null) {
            ItemStack res = RecipesEnergizedOreTumbler.getRecipeFromStack(items[0]).getOutput();
            if (items[1] == null)
                items[1] = res.copy();
            else
                items[1].stackSize += res.stackSize;

            items[0].stackSize--;
            // TODO: Enable after update
            //energy.extractEnergy(2000, false);

            if (items[0].stackSize <= 0) {
                items[0] = null;
            }

        }
    }

    public int getScaledProgress(int scale) {
        if (maxTicks == 0)
            return 0;
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
    /*
    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        int recived = energy.receiveEnergy(maxReceive, simulate);
        if (!simulate)
            this.markDirty();
        return recived;
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
    */
}