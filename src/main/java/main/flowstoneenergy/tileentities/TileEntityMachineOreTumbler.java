package main.flowstoneenergy.tileentities;

import main.flowstoneenergy.tileentities.recipes.Recipe1_1;
import main.flowstoneenergy.tileentities.recipes.RecipesEnergizedOreTumbler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMachineOreTumbler extends TileEntity implements ISidedInventory{
	private ItemStack[] items = new ItemStack[2];
	public static final int INV_SIZE = 2;
	private int ticksLeft = 0;
	private int maxTicks = 0;

	@SuppressWarnings("unused")
	private String field_145958_o;

	@Override
	public int getSizeInventory() {
		return items.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return items[slot];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (this.items[i] != null) {
			ItemStack itemstack;

			if (this.items[i].stackSize <= j) {
				itemstack = this.items[i];
				this.items[i] = null;
				return itemstack;
			} else {
				itemstack = this.items[i].splitStack(j);

				if (this.items[i].stackSize == 0) {
					this.items[i] = null;
				}

				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.items[i] != null) {
			ItemStack itemstack = this.items[i];
			this.items[i] = null;
			return itemstack;
		} else {
		}

		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.items[i] = itemstack;

		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}
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
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return true;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		// TODO Auto-generated method stub
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
		if (items[0] != null && ticksLeft == 0)
        {
            Recipe1_1 r = RecipesEnergizedOreTumbler.GetRecipeFromStack(items[0]);
            if (r != null)
            {
                maxTicks = r.getTime();
            }
        }
        if (ticksLeft < maxTicks && RecipesEnergizedOreTumbler.GetRecipeFromStack(items[0])!=null)
        {
            if(items[1]==null||RecipesEnergizedOreTumbler.GetRecipeFromStack(items[0]).getOutput().getItem().equals(items[1].getItem()))
            {
                ticksLeft++;
            }
            else
            {
                ticksLeft=0;
            }
        }
        if(RecipesEnergizedOreTumbler.GetRecipeFromStack(items[0])==null&&ticksLeft>0)
        {
            ticksLeft=0;
        }
        if (ticksLeft == maxTicks)
        {
            ticksLeft = 0;
            oreDouble();
        }
	}
	
    private void oreDouble()
    {
        if(RecipesEnergizedOreTumbler.GetRecipeFromStack(items[0])==null) return;
        ItemStack res = RecipesEnergizedOreTumbler.GetRecipeFromStack(items[0]).getOutput();
        if (items[1] == null)
        	items[1] = res.copy();
        else
        	items[1].stackSize += res.stackSize;


        items[0].stackSize--;
        if (items[0].stackSize <= 0)
        {
        	items[0] = null;
        }
    }

    public int getScaledProgress(int scale)
    {
        if(maxTicks==0) return 0;
        return ticksLeft * scale/maxTicks;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList nbttaglist = nbt.getTagList("Items", items.length);
		this.items = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); i++) {
			NBTTagCompound nbtSlot = (NBTTagCompound) nbttaglist.getCompoundTagAt(i);
			int var1 = nbtSlot.getByte("Slot") & 255;

			if (var1 >= 0 && var1 < this.items.length) {
				this.items[var1] = ItemStack.loadItemStackFromNBT(nbtSlot);
			}
		}
    }
    
    @Override
    public void writeToNBT(NBTTagCompound nbt) {
    	super.writeToNBT(nbt);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i] != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				this.items[i].writeToNBT(tag);
				nbttaglist.appendTag(tag);
			}
		}

		nbt.setTag("Items", nbttaglist);
		nbt.setBoolean("onOff", false);
    }
	
	@Override
	public void markDirty() {
		super.markDirty(); // Mark dirty for gamesave
		if (worldObj.isRemote) {
			return;
		}
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord); // Update block + TE via Network
	}
}