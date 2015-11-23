package main.flowstoneenergy.tileentities.machines;

//import cofh.api.energy.IEnergyHandler;
import main.flowstoneenergy.tileentities.recipes.Recipe2_1;
import main.flowstoneenergy.tileentities.recipes.RecipesMetalMixer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

//TODO: Enable after update
public class TileEntityMachineMetalMixer extends TileEntityMachineBase /*implements IEnergyHandler*/ {

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineMetalMixer() {
        maxTicks = 100;
        energyRequired = 2000;
        //energy.setMaxExtract(2000);
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
        if (slot != 0 || slot != 1)
            return false;
        for (Recipe2_1 r : RecipesMetalMixer.recipe21List) {
            if (r.getInput1().isItemEqual(stack) || r.getInput2().isItemEqual(stack))
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
        return slot == 2 || slot == 3;
    }

    public void func_145951_a(String displayName) {
        this.field_145958_o = displayName;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if (canMix()) {
            if (ticksLeft >= maxTicks) {
                mixMetals();
                resetTimeAndTexture();
            } else {
                ticksLeft++;
                markDirty();
            }

        } else {
            resetTimeAndTexture();
        }

    }

    private boolean canMix() {

        if (items[0] == null || items[1] == null)
            return false;

        Recipe2_1 recipe = RecipesMetalMixer.getRecipeFromStack(items[0], items[1]);
        if (recipe == null || recipe.getOutput() == null)
            return false;

        ItemStack output = recipe.getOutput();
        boolean suitableForOutput1 = (items[2] != null && output.isItemEqual(items[2]) || items[2] == null);
        boolean suitableForOutput2 = (items[3] != null && output.isItemEqual(items[3]) || items[3] == null);
        if (!suitableForOutput1 || !suitableForOutput2)
            return false;

        int totalAvailableSpace = output.getMaxStackSize() * 2;
        if (suitableForOutput1) {
            if (items[2] != null)
                totalAvailableSpace -= items[2].stackSize;
        } else {
            totalAvailableSpace -= output.getMaxStackSize();
        }

        if (suitableForOutput2) {
            if (items[3] != null)
                totalAvailableSpace -= items[3].stackSize;
        } else {
            totalAvailableSpace -= output.getMaxStackSize();
        }

        if (totalAvailableSpace < output.stackSize)
            return false;

        // TODO: Enable after update
        /* int availableEnergy = energy.extractEnergy(energyRequired, true);
        if (availableEnergy < energyRequired)
            return false;*/

        return true;
    }

    private void mixMetals() {
        if (items[0] == null || items[1] == null)
            return;
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

        items[0].stackSize--;
        if (items[0].stackSize <= 0) {
            items[0] = null;
        }
        items[1].stackSize--;
        if (items[1].stackSize <= 0) {
            items[1] = null;
        }

        // TODO: Enable after update
        //energy.extractEnergy(energyRequired, false);
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
    */
}
