package main.flowstoneenergy.items.tools;

import buildcraft.api.tools.IToolWrench;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.interfaces.IFlowWrenchable;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemToolFlowwrench extends Item implements IToolWrench {

    public ItemToolFlowwrench() {
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setMaxDamage(49);
        this.setUnlocalizedName(ModInfo.MODID + ".flowwrench");
        this.setTextureName(ModInfo.MODID + ":tools/flowwrench");
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
        Block block = world.getBlock(x, y, z);
        if (player.isSneaking()) {
            if (block instanceof IFlowWrenchable) {
                world.setBlock(x, y, z, Blocks.air);
                if (!world.isRemote) {
                    world.spawnEntityInWorld(new EntityItem(world, (double) x, (double) y, (double) z, new ItemStack(block)));
                }
                itemStack.damageItem(1, player);
            }
        }
        return true;
    }

    @Override
    public boolean canWrench(EntityPlayer player, int x, int y, int z) {
        return true;
    }

    @Override
    public void wrenchUsed(EntityPlayer player, int x, int y, int z) {
    }
}
