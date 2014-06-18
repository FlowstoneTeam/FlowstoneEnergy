package main.flowstoneenergy.items.food;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import net.minecraft.item.ItemFood;

public class FoodBacon extends ItemFood {

    public FoodBacon() {
        super(1, true);
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".raw.bacon");
        this.setTextureName(ModInfo.MODID + ":food/bacon");
    }
}
