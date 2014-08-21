package main.flowstoneenergy.items.battery;

import main.flowstoneenergy.core.utils.KeyboardHelper;
import main.flowstoneenergy.core.utils.TextHelper;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBatteryFlowstoneTierFive extends ItemBatteryFlowstoneTierOne {

    private int maxFE = 1000000;
    public int currentFE = 0;

    public ItemBatteryFlowstoneTierFive() {
        super();
        this.setTextureName(ModInfo.MODID + ":batteries/tierFive");
        this.setUnlocalizedName(ModInfo.MODID + ".flowstone.battery.tier.five");
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
