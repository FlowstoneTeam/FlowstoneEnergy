package main.flowstoneenergy.items.tools.electrum;

import main.flowstoneenergy.ModInfo;
import net.minecraft.item.ItemPickaxe;

public class ItemPickElectrum extends ItemPickaxe {

	public ItemPickElectrum(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(ModInfo.MODID + ".electrum.pickaxe");
		this.setTextureName(ModInfo.MODID + ":tools/electrumPickaxe");
	}
}
