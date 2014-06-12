package main.flowstoneenergy.items.battery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.utils.TextHelper;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.utils.KeyboardHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBatteryFlowstoneTierThree extends ItemBatteryFlowstoneTierOne {

    private int maxFE = 10000;
    public int currentFE = 0;

    public ItemBatteryFlowstoneTierThree() {
        super();
        this.setTextureName(ModInfo.MODID + ":batteries/tierThree");
        this.setUnlocalizedName(ModInfo.MODID + ".flowstone.battery.tier.three");
        this.setMaxStackSize(1);
    }

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		if(!KeyboardHelper.isShiftDown()) {
			list.add(TextHelper.shiftForMoreInfo);
		}else if(KeyboardHelper.isShiftDown()) {
			list.add(TextHelper.GREEN + currentFE + "/" + maxFE + " " + TextHelper.localize("info.flowstoneenergy.tooltip.stored") + TextHelper.END);
			list.add(TextHelper.ORANGE + TextHelper.ITALIC + TextHelper.localize("info.flowstoneenergy.key.rightclick") + " " + TextHelper.END +  TextHelper.LIGHT_GRAY +  TextHelper.localize("info.flowstoneenergy.tooltip.enable") + TextHelper.END);
		}
	}
}
