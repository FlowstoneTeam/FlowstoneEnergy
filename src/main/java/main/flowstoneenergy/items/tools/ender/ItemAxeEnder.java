package main.flowstoneenergy.items.tools.ender;

import main.flowstoneenergy.ModInfo;
import net.minecraft.item.ItemAxe;

public class ItemAxeEnder extends ItemAxe {
	public ItemAxeEnder(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(ModInfo.MODID + ".ender.axe");
		this.setTextureName(ModInfo.MODID + ":tools/enderAxe");
	}
}
