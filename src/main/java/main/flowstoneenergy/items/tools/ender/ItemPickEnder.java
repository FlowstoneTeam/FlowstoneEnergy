package main.flowstoneenergy.items.tools.ender;

import main.flowstoneenergy.ModInfo;
import net.minecraft.item.ItemPickaxe;

public class ItemPickEnder extends ItemPickaxe {
	public ItemPickEnder(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(ModInfo.MODID + ".ender.pickaxe");
		this.setTextureName(ModInfo.MODID + ":tools/enderPickaxe");
	}
}
