package main.flowstoneenergy.tileentities.machines;

//import cofh.api.energy.IEnergyHandler;
import main.flowstoneenergy.tileentities.recipes.Recipe1_1;
import main.flowstoneenergy.tileentities.recipes.RecipesLumberMill;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

//TODO: Enable after update
public class TileEntityMachineLumberMill extends TileEntityMachineBase /*implements IEnergyHandler*/ {

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineLumberMill() {
        maxTicks = 100;
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
        if (slot != 0)
            return false;
        for (Recipe1_1 r : RecipesLumberMill.recipe11List) {
            if (r.getInput().getItem().equals(stack.getItem()))
                return true;
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

        if (canSaw()) {

            if (ticksLeft >= maxTicks) {
                saw();
                resetTimeAndTexture();
            } else {
                ticksLeft++;
                markDirty();
            }
        } else {
            resetTimeAndTexture();
        }
    }

    private boolean canSaw() {
        if (items[0] == null)
            return false;

        Recipe1_1 recipe = RecipesLumberMill.getRecipeFromStack(items[0]);
        if (recipe.getInput() == null || recipe.getOutput() == null)
            return false;

        ItemStack output = recipe.getOutput();
        if (items[1] != null && !output.isItemEqual(items[1]))
            return false;

        if (items[1] != null && output.getMaxStackSize() < items[1].stackSize + output.stackSize)
            return false;

        int recipeEnergy = recipe.getPowerRequired();
        // TODO: Enable after update
        /*
        int availableEnergy = energy.extractEnergy(recipeEnergy, true);
        if (recipeEnergy <= 0 || (availableEnergy - recipeEnergy) < 0)
            return false;
            */

        return true;
    }

    private void saw() {
        Recipe1_1 recipe = RecipesLumberMill.getRecipeFromStack(items[0]);
        if (recipe == null)
            return;
        ItemStack res = RecipesLumberMill.getRecipeFromStack(items[0]).getOutput();
        if (items[1] == null)
            items[1] = res.copy();
        else
            items[1].stackSize += res.stackSize;

        items[0].stackSize--;

        // TODO: Enable after update
        //energy.extractEnergy(recipe.getPowerRequired(), false);

        if (items[0].stackSize <= 0) {
            items[0] = null;
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
