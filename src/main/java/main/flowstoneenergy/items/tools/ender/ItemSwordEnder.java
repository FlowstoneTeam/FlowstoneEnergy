package main.flowstoneenergy.items.tools.ender;

import main.flowstoneenergy.ModInfo;
import net.minecraft.item.ItemSword;

public class ItemSwordEnder extends ItemSword {
	public ItemSwordEnder(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(ModInfo.MODID + ".ender.sword");
		this.setTextureName(ModInfo.MODID + ":tools/enderSword");
	}
}
