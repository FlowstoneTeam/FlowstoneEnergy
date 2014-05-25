package main.flowstoneenergy.items.food;

import main.flowstoneenergy.ModInfo;
import net.minecraft.item.ItemFood;

public class FoodTea extends ItemFood {
	public FoodTea() {
		super(4, false);
		this.setTextureName(ModInfo.MODID + ":food/tea");
		this.setUnlocalizedName(ModInfo.MODID + ".tea");
		this.setAlwaysEdible();
		this.setMaxStackSize(1);
	}
}