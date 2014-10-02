package main.flowstoneenergy.tileentities.transport;

import net.minecraft.inventory.IInventory;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityItemPipe extends TileEntityPipeBase {
    @Override
    public void updateEntity() {
        super.updateEntity();
        updateConnections();
    }

    @Override
    public boolean onlyOneOpposite(ForgeDirection[] directions) {
        ForgeDirection mainDirection = null;
        boolean isOpposite = false;

        for (int i = 0; i < directions.length; i++) {
            if (mainDirection == null && directions[i] != null) {
                mainDirection = directions[i];
            }
            if (directions[i] != null && mainDirection != directions[i]) {
                if (!isOpposite(mainDirection, directions[i])) {
                    return false;
                } else {
                    isOpposite = true;
                }
            }
        }
        return isOpposite;
    }

    public void updateConnections() {
        // DO NOT MAKE THESE ELSE IF STATEMENTS, IT BREAKS IT. I TRIED - Poppy
        if (isPipe(xCoord, yCoord + 1, zCoord)) {
            connections[0] = ForgeDirection.UP;
        } else {
            connections[0] = null;
        }
        if (isPipe(xCoord, yCoord - 1, zCoord)) {
            connections[1] = ForgeDirection.DOWN;
        } else {
            connections[1] = null;
        }
        if (isPipe(xCoord, yCoord, zCoord - 1) || isValidInventory(xCoord, yCoord, zCoord - 1)) {
            connections[2] = ForgeDirection.NORTH;
        } else {
            connections[2] = null;
        }
        if (isPipe(xCoord + 1, yCoord, zCoord) || isValidInventory(xCoord + 1, yCoord, zCoord)) {
            connections[3] = ForgeDirection.EAST;
        } else {
            connections[3] = null;
        }
        if (isPipe(xCoord, yCoord, zCoord + 1) || isValidInventory(xCoord, yCoord, zCoord + 1)) {
            connections[4] = ForgeDirection.SOUTH;
        } else {
            connections[4] = null;
        }
        if (isPipe(xCoord - 1, yCoord, zCoord) || isValidInventory(xCoord - 1, yCoord, zCoord)) {
            connections[5] = ForgeDirection.WEST;
        } else {
            connections[5] = null;
        }
    }

    @Override
    public boolean isValidInventory(int x, int y, int z) {
        if (worldObj.getTileEntity(x, y, z) != null) {
            return worldObj.getTileEntity(x, y, z) instanceof IInventory;
        } else {
            return false;
        }
    }

    @Override
    public boolean isPipe(int x, int y, int z) {
        if (worldObj.getTileEntity(x, y, z) != null) {
            return worldObj.getTileEntity(x, y, z) instanceof TileEntityItemPipe;
        } else {
            return false;
        }
    }

    @Override
    public boolean isOpposite(ForgeDirection firstDirection, ForgeDirection secondDirection) {
        if (firstDirection.equals(ForgeDirection.NORTH) && secondDirection.equals(ForgeDirection.SOUTH) || firstDirection.equals(ForgeDirection.SOUTH)
                && secondDirection.equals(ForgeDirection.NORTH)) {
            return true;
        }
        if (firstDirection.equals(ForgeDirection.EAST) && secondDirection.equals(ForgeDirection.WEST) || firstDirection.equals(ForgeDirection.WEST)
                && secondDirection.equals(ForgeDirection.EAST)) {
            return true;
        }
        if (firstDirection.equals(ForgeDirection.DOWN) && secondDirection.equals(ForgeDirection.UP) || firstDirection.equals(ForgeDirection.UP)
                && secondDirection.equals(ForgeDirection.DOWN)) {
            return true;
        }

        return false;
    }
}
