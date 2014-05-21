package main.flowstoneenergy.items.tools;

import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.interfaces.IWrenchable;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class ItemToolFlowwrench extends ItemTool {

    public ItemToolFlowwrench() {
		super(-1F, ToolMaterial.IRON, null);
		this.setMaxDamage(49);
		this.setUnlocalizedName(ModInfo.MODID + ".flowwrench");
        this.setTextureName(ModInfo.MODID + ":tools/flowwrench");
	}

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase) {
    	return false;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
        Block block = world.getBlock(x, y, z);
        if (player.isSneaking()) {
            if (block instanceof IWrenchable) {
                world.setBlock(x, y, z, Blocks.air);
                if (!world.isRemote) {
                    world.spawnEntityInWorld(new EntityItem(world, (double) x, (double) y, (double) z, new ItemStack(block)));
                }
                itemStack.damageItem(1, player);
            }
        }
        return true;
    }
}
