package main.flowstoneenergy.items.battery;

import main.flowstoneenergy.core.libs.ModInfo;

public class ItemBatteryFlowstoneTierFive extends ItemBatteryFlowstoneBase {

    public ItemBatteryFlowstoneTierFive() {
        super();
        //this.setTextureName(ModInfo.MODID + ":batteries/tierFive");
        this.setUnlocalizedName(ModInfo.MODID + ".flowstone.battery.tier.five");
        this.setMaxPower(1000000);
        this.setCurrentPower(0);
    }
}
