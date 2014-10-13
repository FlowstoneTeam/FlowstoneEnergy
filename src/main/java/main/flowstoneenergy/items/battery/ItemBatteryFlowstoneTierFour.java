package main.flowstoneenergy.items.battery;

import main.flowstoneenergy.core.libs.ModInfo;

public class ItemBatteryFlowstoneTierFour extends ItemBatteryFlowstoneBase {

    public ItemBatteryFlowstoneTierFour() {
        super();
        this.setTextureName(ModInfo.MODID + ":batteries/tierFour");
        this.setUnlocalizedName(ModInfo.MODID + ".flowstone.battery.tier.four");
        this.setMaxPower(100000);
        this.setCurrentPower(0);
    }
}
