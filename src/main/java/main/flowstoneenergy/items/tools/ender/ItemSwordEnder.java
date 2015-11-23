package main.flowstoneenergy.items.tools.ender;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.item.ItemSword;

public class ItemSwordEnder extends ItemSword {

    public ItemSwordEnder(ToolMaterial material) {
        super(material);
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".ender.sword");
        //this.setTextureName(ModInfo.MODID + ":tools/enderSword");
    }
}
