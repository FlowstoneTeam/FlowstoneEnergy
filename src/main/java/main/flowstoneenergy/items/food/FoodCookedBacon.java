package main.flowstoneenergy.items.food;

import main.flowstoneenergy.ModInfo;
import net.minecraft.item.ItemFood;

public class FoodCookedBacon extends ItemFood {

    public FoodCookedBacon() {
        super(4, true);
        this.setAlwaysEdible();
        this.setTextureName(ModInfo.MODID + ":food/baconCooked");
        this.setUnlocalizedName(ModInfo.MODID + ".cooked.bacon");
    }

}
