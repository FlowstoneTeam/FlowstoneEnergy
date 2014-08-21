package main.flowstoneenergy.items.food;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.item.ItemFood;

public class FoodCookedBacon extends ItemFood {

    public FoodCookedBacon() {
        super(4, true);
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setAlwaysEdible();
        this.setTextureName(ModInfo.MODID + ":food/baconCooked");
        this.setUnlocalizedName(ModInfo.MODID + ".cooked.bacon");
    }

}
