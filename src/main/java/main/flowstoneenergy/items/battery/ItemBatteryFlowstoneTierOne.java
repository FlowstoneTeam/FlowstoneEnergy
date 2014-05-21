package main.flowstoneenergy.items.battery;

import main.flowstoneenergy.ModInfo;
import net.minecraft.item.Item;

public class ItemBatteryFlowstoneTierOne extends Item {

	public ItemBatteryFlowstoneTierOne() {
		super();
		this.setTextureName(ModInfo.MODID + ":batteries/tierOne");
		this.setUnlocalizedName(ModInfo.MODID + ".flowstone.battery.tier.one");
		this.setMaxStackSize(1);
	}

}
