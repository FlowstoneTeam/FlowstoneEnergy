package main.flowstoneenergy.items.tools.electrum;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.item.ItemSword;

public class ItemSwordElectrum extends ItemSword {

    public ItemSwordElectrum(ToolMaterial material) {
        super(material);
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".electrum.sword");
        this.setTextureName(ModInfo.MODID + ":tools/electrumSword");
    }
}
