package main.flowstoneenergy.items.tools.ender;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.item.ItemSpade;

public class ItemShovelEnder extends ItemSpade {

    public ItemShovelEnder(ToolMaterial material) {
        super(material);
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".ender.shovel");
        this.setTextureName(ModInfo.MODID + ":tools/enderShovel");
    }
}
