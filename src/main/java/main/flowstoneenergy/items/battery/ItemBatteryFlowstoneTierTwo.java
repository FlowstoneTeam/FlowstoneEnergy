package main.flowstoneenergy.items.battery;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.utils.KeyboardHelper;
import main.flowstoneenergy.utils.TextHelper;

public class ItemBatteryFlowstoneTierTwo extends ItemBatteryFlowstoneTierOne {
	private int maxFE = 1000;
	public int currentFE = 0;
	
	public ItemBatteryFlowstoneTierTwo() {
		super();
		this.setTextureName(ModInfo.MODID + ":batteries/tierFour");
		this.setUnlocalizedName(ModInfo.MODID + ".flowstone.battery.tier.two");
		this.setMaxStackSize(1);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(TextHelper.shiftForMoreInfo);
    	if (!KeyboardHelper.isShiftDown()) {
			return;
		}
    	list.remove(1);
		list.add(currentFE + "/" + maxFE + "FE Stored");
		list.add("RIGHT CLICK to activate");
	}
}
