package main.flowstoneenergy.items.tools.ender;

import main.flowstoneenergy.ModInfo;
import net.minecraft.item.ItemSpade;

public class ItemShovelEnder extends ItemSpade{
	public ItemShovelEnder(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(ModInfo.MODID+".ender.shovel");
		this.setTextureName(ModInfo.MODID + ":tools/enderShovel");
	}
}
