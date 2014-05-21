package main.flowstoneenergy.items.tools.ender;

import main.flowstoneenergy.ModInfo;
import net.minecraft.item.ItemHoe;

public class ItemHoeEnder extends ItemHoe{
	public ItemHoeEnder(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(ModInfo.MODID + ".ender.hoe");
		this.setTextureName(ModInfo.MODID + ":tools/enderHoe");
	}
}
