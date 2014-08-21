package main.flowstoneenergy.items.tools.electrum;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.item.ItemPickaxe;

public class ItemPickElectrum extends ItemPickaxe {

	public ItemPickElectrum(ToolMaterial material) {
		super(material);
		this.setCreativeTab(FlowstoneEnergy.tab);
		this.setUnlocalizedName(ModInfo.MODID + ".electrum.pickaxe");
		this.setTextureName(ModInfo.MODID + ":tools/electrumPickaxe");
	}
}
