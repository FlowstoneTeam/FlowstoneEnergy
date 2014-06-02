package main.flowstoneenergy.tileentities.machines;

import main.flowstoneenergy.tileentities.recipes.RecipesEnergizedOreTumbler;
import main.flowstoneenergy.tileentities.recipes.Recipe1_1;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

public class TileEntityMachineLiquifier extends TileEntityMachineBase implements IFluidHandler {

    FluidTank tank = new FluidTank(10000);

	@SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineLiquifier() {
        this.sideCache = new byte[] { 1, 1, 2, 2, 2, 2 };
        items = new ItemStack[2];
        maxTicks = 150;
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
        if (slot != 0) return false;
        for (Recipe1_1 r : RecipesEnergizedOreTumbler.recipe11List) {
            if (r.getInput().getItem().equals(stack.getItem())) return true;
        }
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[]{0, 1};
    }

    @Override
    public boolean canInsertItem(int var1, ItemStack var2, int var3) {
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

        if (items[0] != null) {

            if (this.canLiquify()) {
                ticksLeft++;
                worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            } else {
                ticksLeft = 0;
                resetTimeAndTexture();
            }

            if (ticksLeft == maxTicks) {
                ticksLeft = 0;
                liquify();
            }
        }

        if (this.items[0] == null && ticksLeft > 0) {
            resetTimeAndTexture();
        }
    }

    public void liquify() {
        
    }

    private boolean canLiquify() {
        if (this.items[0] == null) {
            return false;
        } else {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.items[0]);
            if (itemstack == null) return false;
            if (this.items[1] == null) return true;
            if (!this.items[1].isItemEqual(itemstack)) return false;
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
    public int fill(ForgeDirection forgeDirection, FluidStack fluidStack, boolean b) {
        return 0;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        if ((from == ForgeDirection.UNKNOWN) || (this.sideCache[from.ordinal()] != 2)) {
            return null;
        }
        if ((resource == null) || (!resource.isFluidEqual(this.tank.getFluid()))) {
            return null;
        }
        return this.tank.drain(resource.amount, doDrain);
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        if ((from != ForgeDirection.UNKNOWN) && (this.sideCache[from.ordinal()] != 2)) {
            return null;
        }
        return this.tank.drain(maxDrain, doDrain);
    }

    @Override
    public boolean canFill(ForgeDirection forgeDirection, Fluid fluid) {
        return true;
    }

    @Override
    public boolean canDrain(ForgeDirection forgeDirection, Fluid fluid) {
        return true;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection forgeDirection) {
        return new FluidTankInfo[2];
    }
}
