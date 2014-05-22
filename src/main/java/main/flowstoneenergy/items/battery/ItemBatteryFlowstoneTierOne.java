package main.flowstoneenergy.items.battery;

import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.utils.KeyboardHelper;
import main.flowstoneenergy.utils.TextHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBatteryFlowstoneTierOne extends Item {
	private int maxFE = 100;
	public int currentFE = 0;
	
	public ItemBatteryFlowstoneTierOne() {
		super();
		this.setTextureName(ModInfo.MODID + ":batteries/tierOne");
		this.setUnlocalizedName(ModInfo.MODID + ".flowstone.battery.tier.one");
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
