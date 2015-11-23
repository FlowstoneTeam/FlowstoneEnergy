package main.flowstoneenergy.tileentities.machines;

//import cofh.api.energy.IEnergyHandler;
import main.flowstoneenergy.tileentities.recipes.RecipesMachineWorkbench;
import main.flowstoneenergy.tileentities.recipes.Recipe3_1;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

//TODO: Enable after update
public class TileEntityMachineWorkbench extends TileEntityMachineBase /*implements IEnergyHandler */{

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineWorkbench() {
        items = new ItemStack[4];
        // TODO: Enable after update
        //energy.setMaxExtract(2000);
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
    public boolean isItemValidForSlot(int var1, ItemStack var2) {
        return true;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
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
        super.updateEntity();

        if (items[0] != null && items[1] != null && items[2] != null && ticksLeft == 0) {
            Recipe3_1 r = RecipesMachineWorkbench.getRecipeFromStack(items[0], items[1], items[2]);
            if (r != null) {
                maxTicks = r.getTime();
            }
        }

        if (ticksLeft < maxTicks && RecipesMachineWorkbench.getRecipeFromStack(items[0], items[1], items[2]) != null) {
            if (items[3] == null
                    || (RecipesMachineWorkbench.getRecipeFromStack(items[0], items[1], items[2]).getOutput().getItem().equals(items[3].getItem()) && RecipesMachineWorkbench.getRecipeFromStack(items[0], items[1], items[2]).getOutput().getItemDamage() == items[3].getItemDamage())) {
                ticksLeft++;
                worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            } else {
                ticksLeft = 0;
                resetTimeAndTexture();
            }
        }
        if (RecipesMachineWorkbench.getRecipeFromStack(items[0], items[1], items[2]) == null && ticksLeft > 0) {
            ticksLeft = 0;
            resetTimeAndTexture();
        }
        if (ticksLeft == maxTicks) {
            ticksLeft = 0;
            createMachine();
        }
    }

    private void createMachine() {
        if (items[0] == null || items[1] == null || items[2] == null)
            return;
        if (RecipesMachineWorkbench.getRecipeFromStack(items[0], items[1], items[2]) != null) {
            ItemStack res = RecipesMachineWorkbench.getRecipeFromStack(items[0], items[1], items[2]).getOutput();
            if (items[3] == null)
                items[3] = res.copy();
            else
                items[3].stackSize += res.stackSize;

            for (int i = 0; i <= 2; i++) {
                items[i].stackSize--;
                if (items[i].stackSize <= 0) {
                    items[i] = null;
                }
            }
            // TODO: Enable after update
            //energy.extractEnergy(2000, false);
        }
    }

    public int getScaledProgress(int scale) {
        if (maxTicks == 0)
            return 0;
        return ticksLeft * scale / maxTicks;
    }

    // TODO: Enable after update
    /*
    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        int received = energy.receiveEnergy(maxReceive, simulate);
        if (!simulate)
            this.markDirty();
        return received;
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
