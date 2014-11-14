package main.flowstoneenergy.tileentities.machines;

import cofh.api.energy.IEnergyHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

/**
 * Created by Bart on 14-11-2014.
 */
public class TileEntityMachineCooler extends TileEntityMachineBase implements IEnergyHandler, IFluidHandler {

    public TileEntityMachineCooler() {
        items = new ItemStack[2];
        maxTicks = 150;
        energyRequired = 1600;
        energyCapacity = 32000;
    }


    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        return energy.getMaxReceive();
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

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        return tank.fill(resource, doFill);
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        return null;
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        return null;
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid) {
        return (fluid == tank.getFluid().getFluid());
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        return false;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        return new FluidTankInfo[]{new FluidTankInfo(tank)};
    }

    public FluidTank getTank() {
        return tank;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int side) {
        return (slot == 1);
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, int side) {
        return (slot == 2);
    }

    @Override
    public String getInventoryName() {
        return "Cooler Machine";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return true;
    }

}
