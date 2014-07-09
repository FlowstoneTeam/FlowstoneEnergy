package main.flowstoneenergy.tileentities.transport;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityPipeBase extends TileEntity {
    public ForgeDirection[] connections = new ForgeDirection[6];

    @Override
    public void updateEntity() {
        super.updateEntity();
    }

    public void updateConnections() {
        return;
    }

    public boolean onlyOneOpposite(ForgeDirection[] directions) {
        return false;
    }

    public boolean isOpposite(ForgeDirection firstDirection, ForgeDirection secondDirection) {
        return false;
    }

    public boolean isValidInventory(int x, int y, int z) {
        return false;
    }

    public boolean isPipe(int x, int y, int z) {
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
