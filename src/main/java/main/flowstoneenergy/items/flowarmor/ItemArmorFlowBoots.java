package main.flowstoneenergy.items.flowarmor;

import main.flowstoneenergy.ModInfo;
import net.minecraft.item.ItemArmor;

public class ItemArmorFlowBoots extends ItemArmor {
	public ItemArmorFlowBoots(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(ModInfo.MODID+".flow.boots");
		this.setTextureName(ModInfo.MODID+":armor/flowBoots");
	}
}