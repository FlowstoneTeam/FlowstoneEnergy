package main.flowstoneenergy.tileentities;

import main.flowstoneenergy.tileentities.recipes.Recipe2_1;
import main.flowstoneenergy.tileentities.recipes.RecipesMetalMixer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

public class TileEntityMachineMetalMixer extends TileEntityMachineBox {
    public static final int INV_SIZE = 4;
    private int ticksLeft = 0;
    private int maxTicks = 0;

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineMetalMixer() {
        items = new ItemStack[INV_SIZE];
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
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        if (slot != 0 || slot != 1) return false;
        for (Recipe2_1 r : RecipesMetalMixer.recipe21List) {
        	if (r.getInput1().getItem().equals(stack.getItem())||r.getInput2().getItem().equals(stack.getItem())) return true;
        }
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[] { 0, 1, 2, 3 };
    }

    @Override
    public boolean canInsertItem(int var1, ItemStack var2, int var3) {
        return true;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, int side) {
        return slot == 2;
    }

    public void func_145951_a(String displayName) {
        this.field_145958_o = displayName;
    }

    @Override
    public void updateEntity() {
        //Something in input and nothing currently processing
        if (items[0] != null && items[1] != null && ticksLeft == 0) {
            Recipe2_1 r = RecipesMetalMixer.GetRecipeFromStack(items[0], items[1]);
            if (r != null) {
                maxTicks = r.getTime();
            }
        }
        //Actual processing
        if (ticksLeft < maxTicks && RecipesMetalMixer.GetRecipeFromStack(items[0], items[1]) != null) {
            if (items[2] == null || RecipesMetalMixer.GetRecipeFromStack(items[0], items[1]).getOutput().getItem().equals(items[2].getItem())) {
                ticksLeft++;
            } else {
                ticksLeft = 0;
            }
        }
        if (RecipesMetalMixer.GetRecipeFromStack(items[0], items[1]) == null && ticksLeft > 0) {
            ticksLeft = 0;
        }
        if (ticksLeft == maxTicks && maxTicks != 0) {
            ticksLeft = 0;
            mixMetals();
        }
    }

    private void mixMetals() {
        if (items[0] == null || items[1] == null) return;
        ItemStack res = RecipesMetalMixer.GetRecipeFromStack(items[0], items[1]).getOutput();
        if (items[2] == null)
            items[2] = res.copy();
        else if (items[2].stackSize == res.getMaxStackSize())
            if (items[3] == null)
                items[3] = res.copy();
            else
                items[3].stackSize += res.stackSize;
        else
            items[2].stackSize += res.stackSize;

        items[0].stackSize -= 2;
        if (items[0].stackSize <= 0) {
            items[0] = null;
        }
        items[1].stackSize--;
        if (items[1].stackSize <= 0) {
            items[1] = null;
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

}
