package main.flowstoneenergy.items;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import net.minecraft.item.Item;

public class ItemArtificialFeather extends Item{
    public ItemArtificialFeather() {
        super();
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setTextureName(ModInfo.MODID + ":artificialFeather");
        this.setUnlocalizedName(ModInfo.MODID + ".artificial.feather");
    }

}
