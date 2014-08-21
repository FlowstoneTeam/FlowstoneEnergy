package main.flowstoneenergy.items.tools.electrum;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.item.ItemHoe;

public class ItemHoeElectrum extends ItemHoe {
	public ItemHoeElectrum(ToolMaterial material) {
		super(material);
		this.setCreativeTab(FlowstoneEnergy.tab);
		this.setUnlocalizedName(ModInfo.MODID + ".electrum.hoe");
		this.setTextureName(ModInfo.MODID + ":tools/electrumHoe");
	}
}
