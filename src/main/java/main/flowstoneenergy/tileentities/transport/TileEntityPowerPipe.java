package main.flowstoneenergy.tileentities.transport;

import net.minecraft.inventory.IInventory;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class TileEntityPowerPipe extends TileEntityPipeBase {
    @Override
    public void update() {
        super.update();
        updateConnections();
    }

    @Override
    public boolean onlyOneOpposite(EnumFacing[] directions) {
        EnumFacing mainDirection = null;
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
        if (isPipe(this.pos.up())) {
            connections[0] = EnumFacing.UP;
        } else {
            connections[0] = null;
        }
        if (isPipe(this.pos.down())) {
            connections[1] = EnumFacing.DOWN;
        } else {
            connections[1] = null;
        }
        if (isPipe(this.pos.north()) || isValidInventory(this.pos.north())) {
            connections[2] = EnumFacing.NORTH;
        } else {
            connections[2] = null;
        }
        if (isPipe(this.pos.east()) || isValidInventory(this.pos.east())) {
            connections[3] = EnumFacing.EAST;
        } else {
            connections[3] = null;
        }
        if (isPipe(this.pos.south()) || isValidInventory(this.pos.south())) {
            connections[4] = EnumFacing.SOUTH;
        } else {
            connections[4] = null;
        }
        if (isPipe(this.pos.west()) || isValidInventory(this.pos.west())) {
            connections[5] = EnumFacing.WEST;
        } else {
            connections[5] = null;
        }
    }

    @Override
    public boolean isValidInventory(BlockPos pos) {
        if (worldObj.getTileEntity(pos) != null) {
            return worldObj.getTileEntity(pos) instanceof IInventory;
        } else {
            return false;
        }
    }

    @Override
    public boolean isPipe(BlockPos pos) {
        if (worldObj.getTileEntity(pos) != null) {
            return worldObj.getTileEntity(pos) instanceof TileEntityPowerPipe;
        } else {
            return false;
        }
    }

    @Override
    public boolean isOpposite(EnumFacing firstDirection, EnumFacing secondDirection) {
        return firstDirection.getOpposite() == secondDirection;
    }
}
