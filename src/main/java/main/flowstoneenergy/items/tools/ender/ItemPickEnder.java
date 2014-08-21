package main.flowstoneenergy.items.tools.ender;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.item.ItemPickaxe;

public class ItemPickEnder extends ItemPickaxe {

    public ItemPickEnder(ToolMaterial material) {
        super(material);
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".ender.pickaxe");
        this.setTextureName(ModInfo.MODID + ":tools/enderPickaxe");
    }
}
