package main.flowstoneenergy.items.battery;

import main.flowstoneenergy.core.libs.ModInfo;

public class ItemBatteryFlowstoneTierOne extends ItemBatteryFlowstoneBase {

    public ItemBatteryFlowstoneTierOne() {
        super();
        //this.setTextureName(ModInfo.MODID + ":batteries/tierOne");
        this.setUnlocalizedName(ModInfo.MODID + ".flowstone.battery.tier.one");
        this.setMaxPower(100);
        this.setCurrentPower(0);
    }

}
