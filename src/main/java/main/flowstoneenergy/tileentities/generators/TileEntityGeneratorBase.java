package main.flowstoneenergy.tileentities.generators;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineBase;

public class TileEntityGeneratorBase extends TileEntityMachineBase{

    public TileEntityGeneratorBase() {
        items = new ItemStack [0]; //TODO: To be removed
    }
    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, EnumFacing side) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, EnumFacing side) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getCommandSenderName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasCustomName() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        // TODO Auto-generated method stub
        return false;
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

}
