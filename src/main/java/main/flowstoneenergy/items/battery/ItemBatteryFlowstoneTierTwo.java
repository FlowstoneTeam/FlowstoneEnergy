package main.flowstoneenergy.items.battery;

import main.flowstoneenergy.core.libs.ModInfo;

public class ItemBatteryFlowstoneTierTwo extends ItemBatteryFlowstoneBase {

    public ItemBatteryFlowstoneTierTwo() {
        super();
        //this.setTextureName(ModInfo.MODID + ":batteries/tierTwo");
        this.setUnlocalizedName(ModInfo.MODID + ".flowstone.battery.tier.two");
        this.setMaxPower(1000);
        this.setCurrentPower(0);
    }
}
