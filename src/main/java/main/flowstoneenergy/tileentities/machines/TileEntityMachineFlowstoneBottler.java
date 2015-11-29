package main.flowstoneenergy.tileentities.machines;

/*import cofh.api.energy.IEnergyContainerItem;
import cofh.api.energy.IEnergyHandler;*/
import main.flowstoneenergy.tileentities.recipes.RecipesFlowstoneBottler;
import main.flowstoneenergy.tileentities.recipes.Recipe1_1;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;

//TODO: Enable after update
public class TileEntityMachineFlowstoneBottler extends TileEntityMachineBase /*implements IEnergyHandler*/ {

    @SuppressWarnings("unused")
    private String field_145958_o;
    private int ratePerTick = 50;

    public TileEntityMachineFlowstoneBottler() {
        items = new ItemStack[2];
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
        if (stack == null || stack.getItem() == null)
            return false;

        if (slot != 0)
            return false;

        // TODO: Enable after update
        /*if (stack.getItem() instanceof IEnergyContainerItem)
            return true;*/
        else
            return false;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return new int[]{0, 1};
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, EnumFacing side) {
        return true;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, EnumFacing side) {
        return slot == 1;
    }

    public void func_145951_a(String displayName) {
        this.field_145958_o = displayName;
    }

    @Override
    public void update() {
        super.update();

        if ((items[0] == null) || (items[0].getItem() == null)) {
            ticksLeft = 0;
            maxTicks = 0;
            resetTimeAndTexture();
            return;
        }

        // TODO: Enable after update
        /*
        if (items[0].getItem() instanceof IEnergyContainerItem && items[1] == null) {

            IEnergyContainerItem energyContainer = (IEnergyContainerItem) items[0].getItem();

            int maxCap = energyContainer.getEnergyStored(items[0]);
            maxTicks = maxCap / ratePerTick;

            chargeItem();

            ticksLeft++;

            markDirty();

        } else {*/
            ticksLeft = 0;
            maxTicks = 0;
            resetTimeAndTexture();
        //}
    }

    private void chargeItem() {

        // TODO: Enable after update
        /*
        IEnergyContainerItem energyContainer = (IEnergyContainerItem) items[0].getItem();

        int extracted = energy.extractEnergy(ratePerTick, true);
        extracted = energyContainer.receiveEnergy(items[0], extracted, true);
        extracted = energy.extractEnergy(extracted, false);
        energyContainer.receiveEnergy(items[0], extracted, false);

        if (extracted <= 0) {
            ticksLeft = 0;
            resetTimeAndTexture();
            if (items[1] == null)
                items[1] = items[0].copy();
            items[0].stackSize--;
            if (items[0].stackSize <= 0) {
                items[0] = null;
            }
        }*/
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
