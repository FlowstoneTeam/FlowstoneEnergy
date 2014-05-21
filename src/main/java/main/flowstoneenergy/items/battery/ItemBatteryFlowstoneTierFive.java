package main.flowstoneenergy.items.battery;

import main.flowstoneenergy.ModInfo;

public class ItemBatteryFlowstoneTierFive extends ItemBatteryFlowstoneTierOne {
	public ItemBatteryFlowstoneTierFive() {
		super();
		this.setTextureName(ModInfo.MODID + ":batteries/tierFive");
		this.setUnlocalizedName(ModInfo.MODID + ".flowstone.battery.tier.five");
		this.setMaxStackSize(1);
	}
}
