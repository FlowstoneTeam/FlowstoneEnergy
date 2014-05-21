package main.flowstoneenergy.tileentities;

import main.flowstoneenergy.tileentities.recipes.Recipe1_1;
import main.flowstoneenergy.tileentities.recipes.RecipesLumberMill;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

public class TileEntityMachineLumberMill extends TileEntityMachineBox{
	public static final int INV_SIZE = 2;
    private int ticksLeft = 0;
    private int maxTicks = 0;

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineLumberMill() {
        items = new ItemStack[2];
    }

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int var1, ItemStack var2, int var3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int var1, ItemStack var2, int var3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		// TODO Auto-generated method stub
		return false;
	}

	public void func_145951_a(String displayName) {
        this.field_145958_o = displayName;
    }

    @Override
    public void updateEntity() {
        if (items[0] != null && ticksLeft == 0) {
            Recipe1_1 r = RecipesLumberMill.GetRecipeFromStack(items[0]);
            if (r != null) {
                maxTicks = r.getTime();
            }
        }
        if (ticksLeft < maxTicks && RecipesLumberMill.GetRecipeFromStack(items[0]) != null) {
            if (items[1] == null || RecipesLumberMill.GetRecipeFromStack(items[0]).getOutput().getItem().equals(items[1].getItem())) {
                ticksLeft++;
            } else {
                ticksLeft = 0;
            }
        }
        if (RecipesLumberMill.GetRecipeFromStack(items[0]) == null && ticksLeft > 0) {
            ticksLeft = 0;
        }
        if (ticksLeft == maxTicks) {
            ticksLeft = 0;
            smelt();
        }
    }

    private void smelt() {
        if (RecipesLumberMill.GetRecipeFromStack(items[0]) == null) return;
        ItemStack res = RecipesLumberMill.GetRecipeFromStack(items[0]).getOutput();
        if (items[1] == null)
            items[1] = res.copy();
        else
            items[1].stackSize += res.stackSize;


        items[0].stackSize--;
        if (items[0].stackSize <= 0) {
            items[0] = null;
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
