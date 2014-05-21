package main.flowstoneenergy.items.tools;

import java.util.Random;

import main.flowstoneenergy.ModInfo;

public class ItemToolPneumaticFlowwrench extends ItemToolFlowwrench {
	Random rand = new Random();

    public ItemToolPneumaticFlowwrench() {
        super();
        this.setUnlocalizedName(ModInfo.MODID + ".pneumatic.flowwrench");
        this.setTextureName(ModInfo.MODID + ":tools/pneumaticFlowwrench");
    }
}
