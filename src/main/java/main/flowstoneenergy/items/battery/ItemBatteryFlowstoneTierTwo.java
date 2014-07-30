package main.flowstoneenergy.items.battery;

import main.flowstoneenergy.utils.KeyboardHelper;
import main.flowstoneenergy.utils.TextHelper;
import main.flowstoneenergy.libs.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBatteryFlowstoneTierTwo extends ItemBatteryFlowstoneTierOne {

    private int maxFE = 1000;
    public int currentFE = 0;

    public ItemBatteryFlowstoneTierTwo() {
        super();
        this.setTextureName(ModInfo.MODID + ":batteries/tierTwo");
        this.setUnlocalizedName(ModInfo.MODID + ".flowstone.battery.tier.two");
        this.setMaxStackSize(1);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        if(!KeyboardHelper.isShiftDown()) {
		    list.add(TextHelper.shiftForMoreInfo);
	    } else {
		    list.add(TextHelper.GREEN + currentFE + "/" + maxFE + TextHelper.localize("info.fe.tooltip.stored"));
		    list.add(TextHelper.localize("info.fe.tooltip.use") + " " + TextHelper.localize("info.fe.control.sneak") + " " + TextHelper.localize("info.fe.tooltip.activate"));
	    }
    }
}
