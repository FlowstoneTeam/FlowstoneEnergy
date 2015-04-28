package main.flowstoneenergy.tileentities.machines;

import cofh.api.energy.EnergyStorage;
import main.flowstoneenergy.blocks.upgrades.BlockUpgrades;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
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

    public int[] upgrades;

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

    //use this in the onUpdate() function
    public void getUpgrades() {
        for (int i = 0; i < ForgeDirection.VALID_DIRECTIONS.length; i++) {
            upgrades[i] = -1;
            ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
            Block block = worldObj.getBlock(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
            if (block instanceof BlockUpgrades) {
                upgrades[i] = block.getDamageValue(worldObj, this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
            }
        }
    }

    //use this to get the amount of upgrades the block has around it
    //input "speed" for speed upgrade, "itemCap" for item capacity, "energyCap" for energy capacity
    //"efficiency" for efficiency upgrade, "amount" for item amount upgrade, "creative" for creative upgrade
    public int getUpgrade(String upgradeName) {
        int speed = 0; //speed upgrade
        int itemCapacity = 0; //item capacity upgrade
        int energyCapacity = 0; //energy capacity upgrade
        int efficiency = 0; //energy efficiency upgrade
        int amount = 0; //item amount upgrade
        int creative = 0; //creative upgrade
        for(int upgrade : upgrades)
        {
            switch(upgrade)
            {
                case -1:
                {
                    break;
                }
                case 0:
                {
                    speed += 1;
                    break;
                }
                case 1:
                {
                    itemCapacity += 1;
                    break;
                }
                case 2:
                {
                    energyCapacity += 1;
                    break;
                }
                case 3:
                {
                    efficiency += 1;
                    break;
                }
                case 4:
                {
                    amount += 1;
                    break;
                }
                default:
                {
                    creative += 1;
                    break;
                }
            }
        }
        if( upgradeName.equals("speed")) {
            return speed;
        } else if(upgradeName.equals("itemCap")){
            return itemCapacity;
        } else if(upgradeName.equals("energyCap")){
            return energyCapacity;
        } else if(upgradeName.equals("efficiency")){
            return efficiency;
        } else if(upgradeName.equals("amount")){
            return amount;
        } else if (upgradeName.equals("creative")) {
            return creative;
        } else return 0;
    }

}
