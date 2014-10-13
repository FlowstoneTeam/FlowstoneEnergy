package main.flowstoneenergy.items.battery;

import main.flowstoneenergy.core.libs.ModInfo;

public class ItemBatteryFlowstoneTierThree extends ItemBatteryFlowstoneBase {


    public ItemBatteryFlowstoneTierThree() {
        super();
        this.setTextureName(ModInfo.MODID + ":batteries/tierThree");
        this.setUnlocalizedName(ModInfo.MODID + ".flowstone.battery.tier.three");
        this.setMaxPower(10000);
        this.setCurrentPower(0);
    }
}
