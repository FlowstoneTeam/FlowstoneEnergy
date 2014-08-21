package main.flowstoneenergy.items.tools.ender;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.item.ItemHoe;

public class ItemHoeEnder extends ItemHoe {

    public ItemHoeEnder(ToolMaterial material) {
        super(material);
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".ender.hoe");
        this.setTextureName(ModInfo.MODID + ":tools/enderHoe");
    }
}
