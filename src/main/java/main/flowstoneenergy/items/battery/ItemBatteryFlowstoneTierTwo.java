package main.flowstoneenergy.items.battery;

import main.flowstoneenergy.ModInfo;

public class ItemBatteryFlowstoneTierTwo extends ItemBatteryFlowstoneTierOne{
	public ItemBatteryFlowstoneTierTwo() {
		super();
		this.setTextureName(ModInfo.MODID+":batteries/tierFour");
		this.setUnlocalizedName(ModInfo.MODID+".flowstone.battery.tier.two");
	}
}
