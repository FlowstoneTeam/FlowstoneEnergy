package main.flowstoneenergy.tileentities;

import net.minecraft.item.ItemStack;

public class TileEntityMachineAutoCraftingTable extends TileEntityMachineBox {
    public static final int INV_SIZE = 2;
    private int ticksLeft = 0;
    private int maxTicks = 0;

    @SuppressWarnings("unused")
    private String field_145958_o;

    public TileEntityMachineAutoCraftingTable() {
        items = new ItemStack[10];
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
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        return i != 0;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        return i == 0;
    }

    public void func_145951_a(String displayName) {
        this.field_145958_o = displayName;
    }

    @Override
    public void updateEntity() {

    }

    @SuppressWarnings("unused")
	private void craft() {
        // if (RecipesHeatedOven.GetRecipeFromStack(items[0]) == null) return;
        // ItemStack res = RecipesHeatedOven.GetRecipeFromStack(items[0]).getOutput();
        //  if (items[1] == null)
       // items[1] = res.copy();
        //   else
        //      items[1].stackSize += res.stackSize;


        items[0].stackSize--;
        if (items[0].stackSize <= 0) {
            items[0] = null;
        }
    }

    public int getScaledProgress(int scale) {
        if (maxTicks == 0) return 0;
        return ticksLeft * scale / maxTicks;
    }
}
