package main.flowstoneenergy.items.battery;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.entities.EntityRobot;
import main.flowstoneenergy.core.utils.KeyboardHelper;
import main.flowstoneenergy.core.utils.TextHelper;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemBatteryFlowstoneTierOne extends Item {

    private int maxFE = 100;
    public int currentFE = 0;

    public ItemBatteryFlowstoneTierOne() {
        super();
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setTextureName(ModInfo.MODID + ":batteries/tierOne");
        this.setUnlocalizedName(ModInfo.MODID + ".flowstone.battery.tier.one");
        this.setMaxStackSize(1);
    }

    public boolean isCharged(int maxFE) {
        return maxFE >= 10;
    }

    @Override
    public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        EntityRobot robot = new EntityRobot(world);
        if (!world.isRemote && player.isSneaking()) {
            EntityRobot.setCharged();
            world.updateEntity(robot);
            itemStack.setItemDamage(0);
            /**
            if (isCharged(itemStack.getItemDamage())) {
                robot.setCharged();
                itemStack.setItemDamage(0);
            }
             **/
            return true;
        } else {
            return false;
        }
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
