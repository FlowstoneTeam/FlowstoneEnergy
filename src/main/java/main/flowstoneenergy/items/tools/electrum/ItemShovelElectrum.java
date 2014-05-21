package main.flowstoneenergy.items.tools.electrum;

import main.flowstoneenergy.ModInfo;
import net.minecraft.item.ItemSpade;

public class ItemShovelElectrum extends ItemSpade {
	public ItemShovelElectrum(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(ModInfo.MODID + ".electrum.shovel");
		this.setTextureName(ModInfo.MODID + ":tools/electrumShovel");
	}
}
