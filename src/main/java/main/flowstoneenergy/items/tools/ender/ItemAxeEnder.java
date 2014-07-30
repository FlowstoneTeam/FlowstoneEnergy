package main.flowstoneenergy.items.tools.ender;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.libs.ModInfo;
import net.minecraft.item.ItemAxe;

public class ItemAxeEnder extends ItemAxe {

    public ItemAxeEnder(ToolMaterial material) {
        super(material);
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".ender.axe");
        this.setTextureName(ModInfo.MODID + ":tools/enderAxe");
    }
}
