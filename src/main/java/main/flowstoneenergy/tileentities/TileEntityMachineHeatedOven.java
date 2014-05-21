package main.flowstoneenergy.tileentities;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

public class TileEntityMachineHeatedOven extends TileEntityMachineBox {
    public static final int INV_SIZE = 2;
    private int ticksLeft = 0;
    private int maxTicks = 150;

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineHeatedOven() {
        items = new ItemStack[2];
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
    public boolean isItemValidForSlot(int var1, ItemStack var2) {
        return true;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return null;
    }

    @Override
    public boolean canInsertItem(int var1, ItemStack var2, int var3) {
        return true;
    }

    @Override
    public boolean canExtractItem(int var1, ItemStack var2, int var3) {
        return true;
    }

    public void func_145951_a(String displayName) {
        this.field_145958_o = displayName;
    }

    @Override
    public void updateEntity() {
        if (items[0] != null) {

            if (this.canSmelt()) {
                ticksLeft++;
            } else {
                ticksLeft = 0;
            }

            if (ticksLeft == maxTicks) {
                ticksLeft = 0;
                smelt();
            }
        }
    }

    public void smelt() {
        if (this.canSmelt()) {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.items[0]);

            if (this.items[1] == null) {
                this.items[1] = itemstack.copy();
            } else if (this.items[1].getItem() == itemstack.getItem()) {
                this.items[1].stackSize += itemstack.stackSize;
            }

            --this.items[0].stackSize;

            if (this.items[0].stackSize <= 0) {
                this.items[0] = null;
            }
        }
    }

    private boolean canSmelt() {
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
        if (maxTicks == 0) return 0;
        return ticksLeft * scale / maxTicks;
    }

    @Override
    public final Packet getDescriptionPacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        writeToNBT(nbt);

        S35PacketUpdateTileEntity packet = new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);

        return packet;
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        NBTTagCompound nbt = pkt.func_148857_g();

        readFromNBT(nbt);
    }

    @Override
    public void markDirty() {
        super.markDirty(); // Mark dirty for gamesave
        if (worldObj.isRemote) {
            return;
        }
        System.out.println();
        this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord); // Update block + TE via Network
    }
}
