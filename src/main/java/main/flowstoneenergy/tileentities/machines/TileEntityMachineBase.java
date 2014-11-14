package main.flowstoneenergy.tileentities.machines;

import cofh.api.energy.EnergyStorage;
import main.flowstoneenergy.blocks.upgrades.BlockUpgrades;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidTank;

public abstract class TileEntityMachineBase extends TileEntity implements ISidedInventory {

    public byte[] sideCache = {0, 0, 0, 0, 0, 0};
    public ItemStack[] items;
    public int facing;
    public int ticksLeft = 0;
    public int maxTicks = 0;
    public int energyRequired = 0;
    public int energyCapacity = 32000;
    public int divisionFactor = 0;
    public int upgradeCheckTimer = 0;
    public EnergyStorage energy = new EnergyStorage(energyCapacity, 1000);
    public FluidTank tank = new FluidTank(10000);

    public boolean[] Upgrade0 = new boolean[6];
    public boolean[] Upgrade1 = new boolean[6];
    public boolean[] Upgrade2 = new boolean[6];
    public boolean[] Upgrade3 = new boolean[6];
    public boolean[] Upgrade4 = new boolean[6];
    public boolean[] Upgrade5 = new boolean[6];

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
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
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false
                : par1EntityPlayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    public void resetTimeAndTexture() {
        ticksLeft = 0;
        if (items[0] == null)
            worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
    }

    @Override
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
        this.items[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int par1) {
        if (this.items[par1] != null) {
            ItemStack itemstack = this.items[par1];
            this.items[par1] = null;
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
        energy.readFromNBT(tagCompound);
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
        energy.writeToNBT(tagCompound);
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

        this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord); // Update
                                                                  // block + TE
                                                                  // via Network
    }

    public void getUpgrade() {

        for (int i = 0; i < Upgrade0.length; i++) {
            Upgrade0[i] = false;
            Upgrade1[i] = false;
            Upgrade2[i] = false;
            Upgrade3[i] = false;
            Upgrade4[i] = false;
            Upgrade5[i] = false;
        }

        upgradeCheckTimer = 0;
        // up
        if (worldObj.getBlockMetadata(xCoord, yCoord + 1, zCoord) == 0 && worldObj.getBlock(xCoord, yCoord + 1, zCoord) instanceof BlockUpgrades) {
            Upgrade0[0] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord + 1, zCoord) == 1 && worldObj.getBlock(xCoord, yCoord + 1, zCoord) instanceof BlockUpgrades) {
            Upgrade1[0] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord + 1, zCoord) == 2 && worldObj.getBlock(xCoord, yCoord + 1, zCoord) instanceof BlockUpgrades) {
            Upgrade2[0] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord + 1, zCoord) == 3 && worldObj.getBlock(xCoord, yCoord + 1, zCoord) instanceof BlockUpgrades) {
            Upgrade3[0] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord + 1, zCoord) == 4 && worldObj.getBlock(xCoord, yCoord + 1, zCoord) instanceof BlockUpgrades) {
            Upgrade4[0] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord + 1, zCoord) == 5 && worldObj.getBlock(xCoord, yCoord + 1, zCoord) instanceof BlockUpgrades) {
            Upgrade5[0] = true;
        }
        // down
        if (worldObj.getBlockMetadata(xCoord, yCoord - 1, zCoord) == 0 && worldObj.getBlock(xCoord, yCoord - 1, zCoord) instanceof BlockUpgrades) {
            Upgrade0[1] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord - 1, zCoord) == 1 && worldObj.getBlock(xCoord, yCoord - 1, zCoord) instanceof BlockUpgrades) {
            Upgrade1[1] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord - 1, zCoord) == 2 && worldObj.getBlock(xCoord, yCoord - 1, zCoord) instanceof BlockUpgrades) {
            Upgrade2[1] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord - 1, zCoord) == 3 && worldObj.getBlock(xCoord, yCoord - 1, zCoord) instanceof BlockUpgrades) {
            Upgrade3[1] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord - 1, zCoord) == 4 && worldObj.getBlock(xCoord, yCoord - 1, zCoord) instanceof BlockUpgrades) {
            Upgrade4[1] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord - 1, zCoord) == 5 && worldObj.getBlock(xCoord, yCoord - 1, zCoord) instanceof BlockUpgrades) {
            Upgrade5[1] = true;
        }
        // north
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord - 1) == 0 && worldObj.getBlock(xCoord, yCoord, zCoord - 1) instanceof BlockUpgrades) {
            Upgrade0[2] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord - 1) == 1 && worldObj.getBlock(xCoord, yCoord, zCoord - 1) instanceof BlockUpgrades) {
            Upgrade1[2] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord - 1) == 2 && worldObj.getBlock(xCoord, yCoord, zCoord - 1) instanceof BlockUpgrades) {
            Upgrade2[2] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord - 1) == 3 && worldObj.getBlock(xCoord, yCoord, zCoord - 1) instanceof BlockUpgrades) {
            Upgrade3[2] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord - 1) == 4 && worldObj.getBlock(xCoord, yCoord, zCoord - 1) instanceof BlockUpgrades) {
            Upgrade4[2] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord - 1) == 5 && worldObj.getBlock(xCoord, yCoord, zCoord - 1) instanceof BlockUpgrades) {
            Upgrade5[2] = true;
        }
        // east
        if (worldObj.getBlockMetadata(xCoord + 1, yCoord, zCoord) == 0 && worldObj.getBlock(xCoord + 1, yCoord, zCoord) instanceof BlockUpgrades) {
            Upgrade0[3] = true;
        }
        if (worldObj.getBlockMetadata(xCoord + 1, yCoord, zCoord) == 1 && worldObj.getBlock(xCoord + 1, yCoord, zCoord) instanceof BlockUpgrades) {
            Upgrade1[3] = true;
        }
        if (worldObj.getBlockMetadata(xCoord + 1, yCoord, zCoord) == 2 && worldObj.getBlock(xCoord + 1, yCoord, zCoord) instanceof BlockUpgrades) {
            Upgrade2[3] = true;
        }
        if (worldObj.getBlockMetadata(xCoord + 1, yCoord, zCoord) == 3 && worldObj.getBlock(xCoord + 1, yCoord, zCoord) instanceof BlockUpgrades) {
            Upgrade3[3] = true;
        }
        if (worldObj.getBlockMetadata(xCoord + 1, yCoord, zCoord) == 4 && worldObj.getBlock(xCoord + 1, yCoord, zCoord) instanceof BlockUpgrades) {
            Upgrade4[3] = true;
        }
        if (worldObj.getBlockMetadata(xCoord + 1, yCoord, zCoord) == 5 && worldObj.getBlock(xCoord + 1, yCoord, zCoord) instanceof BlockUpgrades) {
            Upgrade5[3] = true;
        }
        // south
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord + 1) == 0 && worldObj.getBlock(xCoord, yCoord, zCoord + 1) instanceof BlockUpgrades) {
            Upgrade0[4] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord + 1) == 1 && worldObj.getBlock(xCoord, yCoord, zCoord + 1) instanceof BlockUpgrades) {
            Upgrade1[4] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord + 1) == 2 && worldObj.getBlock(xCoord, yCoord, zCoord + 1) instanceof BlockUpgrades) {
            Upgrade2[4] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord + 1) == 3 && worldObj.getBlock(xCoord, yCoord, zCoord + 1) instanceof BlockUpgrades) {
            Upgrade3[4] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord + 1) == 4 && worldObj.getBlock(xCoord, yCoord, zCoord + 1) instanceof BlockUpgrades) {
            Upgrade4[4] = true;
        }
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord + 1) == 5 && worldObj.getBlock(xCoord, yCoord, zCoord + 1) instanceof BlockUpgrades) {
            Upgrade5[4] = true;
        }
        // west
        if (worldObj.getBlockMetadata(xCoord - 1, yCoord, zCoord) == 0 && worldObj.getBlock(xCoord - 1, yCoord, zCoord) instanceof BlockUpgrades) {
            Upgrade0[5] = true;
        }
        if (worldObj.getBlockMetadata(xCoord - 1, yCoord, zCoord) == 1 && worldObj.getBlock(xCoord - 1, yCoord, zCoord) instanceof BlockUpgrades) {
            Upgrade1[5] = true;
        }
        if (worldObj.getBlockMetadata(xCoord - 1, yCoord, zCoord) == 2 && worldObj.getBlock(xCoord - 1, yCoord, zCoord) instanceof BlockUpgrades) {
            Upgrade2[5] = true;
        }
        if (worldObj.getBlockMetadata(xCoord - 1, yCoord, zCoord) == 3 && worldObj.getBlock(xCoord - 1, yCoord, zCoord) instanceof BlockUpgrades) {
            Upgrade3[5] = true;
        }
        if (worldObj.getBlockMetadata(xCoord - 1, yCoord, zCoord) == 4 && worldObj.getBlock(xCoord - 1, yCoord, zCoord) instanceof BlockUpgrades) {
            Upgrade4[5] = true;
        }
        if (worldObj.getBlockMetadata(xCoord - 1, yCoord, zCoord) == 5 && worldObj.getBlock(xCoord - 1, yCoord, zCoord) instanceof BlockUpgrades) {
            Upgrade5[5] = true;
        }

        if (Upgrade0[0] || Upgrade0[1] || Upgrade0[2] || Upgrade0[3] || Upgrade0[4] || Upgrade0[5]) {

        }
        if (Upgrade2[0] || Upgrade2[1] || Upgrade2[2] || Upgrade2[3] || Upgrade2[4] || Upgrade2[5]) {

        }
        if (Upgrade3[0] || Upgrade3[1] || Upgrade3[2] || Upgrade3[3] || Upgrade3[4] || Upgrade3[5]) {

        }

        // * if(Upgrade0 > 0){
        // ticksLeft = ticksLeft - (ticksLeft/100*(25*Upgrade0));
        // System.out.println(ticksLeft);
        // }
        // if(Upgrade2 > 0){
        // energyCapacity = 32000 + (32000/100*(10*energyCapacity));
        // System.out.println(energyCapacity);
        // }
        // if(Upgrade3 > 0){
        // energyRequired = energyRequired -
        // (energyRequired/100*(15*energyRequired));
        // System.out.println(energyRequired);
        // }
    }
}
