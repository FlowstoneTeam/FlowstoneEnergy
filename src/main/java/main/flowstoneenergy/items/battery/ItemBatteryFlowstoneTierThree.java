package main.flowstoneenergy.items.battery;

import main.flowstoneenergy.ModInfo;

public class ItemBatteryFlowstoneTierThree extends ItemBatteryFlowstoneTierOne{
	public ItemBatteryFlowstoneTierThree() {
		super();
		this.setTextureName(ModInfo.MODID+":batteries/tierThree");
		this.setUnlocalizedName(ModInfo.MODID+".flowstone.battery.tier.three");
	}
}
