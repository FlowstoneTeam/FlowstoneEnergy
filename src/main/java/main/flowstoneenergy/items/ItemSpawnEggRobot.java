package main.flowstoneenergy.items;

import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.entities.EntityRobot;
import main.flowstoneenergy.gui.CreativeTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSpawnEggRobot extends Item {

    public ItemSpawnEggRobot() {
        this.setUnlocalizedName(ModInfo.MODID + ".robot.spawn.egg");
        this.setTextureName(ModInfo.MODID + ":spawnRobot");
        this.setCreativeTab(CreativeTab.tabMisc);
    }

    @Override
    public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            EntityRobot robot = new EntityRobot(world);
            robot.posX = x + 0.5;
            robot.posY = x + 1.5;
            robot.posZ = x + 0.5;

            world.spawnEntityInWorld(robot);
            return true;
        } else {
            return false;
        }
    }
}
