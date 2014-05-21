package main.flowstoneenergy.items.tools.electrum;

import main.flowstoneenergy.ModInfo;
import net.minecraft.item.ItemHoe;

public class ItemHoeElectrum extends ItemHoe {
	public ItemHoeElectrum(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(ModInfo.MODID + ".electrum.hoe");
		this.setTextureName(ModInfo.MODID + ":tools/electrumHoe");
	}
}
