package main.flowstoneenergy.tileentities.transport;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEntityPipeBase extends TileEntity implements ITickable {
    public EnumFacing[] connections = new EnumFacing[6];

    @Override
    public void update() {
    }

    public void updateConnections() {
        return;
    }

    public boolean onlyOneOpposite(EnumFacing[] directions) {
        return false;
    }

    public boolean isOpposite(EnumFacing firstDirection, EnumFacing secondDirection) {
        return false;
    }

    public boolean isValidInventory(BlockPos pos) {
        return false;
    }

    public boolean isPipe(BlockPos pos) {
        return false;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
    }
}
