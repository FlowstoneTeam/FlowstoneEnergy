package main.flowstoneenergy.tileentities.chests;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IWorldNameable;

public class TileEntitySecureChest extends TileEntity implements ISidedInventory, IWorldNameable{

    public byte[] sideCache = {0, 0, 0, 0, 0, 0};
    public ItemStack[] items;
    public int facing;
    public int ticksLeft = 0;
    public int maxTicks = 0;
    public int divisionFactor = 0;

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return false;
    }

    @Override
    public int getSizeInventory() {
        return items.length;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public ItemStack getStackInSlot(int var1) {
        if (var1 > items.length)
            return null;
        return items[var1];
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
        return this.worldObj.getTileEntity(this.pos) != this ? false
                : par1EntityPlayer.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public void resetTimeAndTexture() {
        ticksLeft = 0;
        worldObj.markBlockForUpdate(this.pos);
    }

    @Override
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
        this.items[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        if (this.items[index] != null) {
            ItemStack itemstack = this.items[index];
            this.items[index] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    @Override
    public ItemStack decrStackSize(int par1, int par2) {
        if (this.items[par1] != null) {
            ItemStack itemstack;

            if (this.items[par1].stackSize <= par2) {
                itemstack = this.items[par1];
                this.items[par1] = null;
                return itemstack;
            } else {
                itemstack = this.items[par1].splitStack(par2);

                if (this.items[par1].stackSize == 0) {
                    this.items[par1] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        NBTTagList nbttaglist = tagCompound.getTagList("Items", 10);
        this.items = new ItemStack[this.getSizeInventory()];

        facing = tagCompound.getInteger("facing");
        ticksLeft = tagCompound.getInteger("ticksLeft");

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.items.length) {
                this.items[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.items.length; ++i) {
            if (this.items[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                this.items[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        tagCompound.setTag("Items", nbttaglist);
        tagCompound.setInteger("facing", facing);
        tagCompound.setInteger("ticksLeft", ticksLeft);
    }

    @Override
    public final Packet<?> getDescriptionPacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        writeToNBT(nbt);

        S35PacketUpdateTileEntity packet = new S35PacketUpdateTileEntity(pos, 0, nbt);

        return packet;
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        NBTTagCompound nbt = pkt.getNbtCompound();
        readFromNBT(nbt);
    }

    @Override
    public void markDirty() {
        super.markDirty(); // Mark dirty for gamesave
        if (worldObj.isRemote) {
            return;
        }
        this.worldObj.markBlockForUpdate(pos); // Update
                                               // block + TE
                                               // via Network
    }

    @Override
    public int[] getSlotsForFace(EnumFacing facing) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStack, EnumFacing facing) {
        return true;
    }

    @Override
    public boolean canExtractItem(int index, ItemStack itemStack, EnumFacing facing) {
        return true;
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
