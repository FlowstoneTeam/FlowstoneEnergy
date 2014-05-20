package main.flowstoneenergy.items.tools;

import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.interfaces.IWrenchable;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemToolPneumaticFlowwrench extends Item {

	public ItemToolPneumaticFlowwrench() {
		super();
		this.setUnlocalizedName(ModInfo.MODID+".pneumatic.flowwrench");
		this.setTextureName(ModInfo.MODID+":tools/pneumaticFlowwrench");
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		Block block = world.getBlock(x, y, z);
		if (player.isSneaking()) {
			if (block instanceof IWrenchable) {
				world.setBlock(x, y, z, Blocks.air);
				if (!world.isRemote) {
					world.spawnEntityInWorld(new EntityItem(world, (double)x, (double)y, (double)z, new ItemStack(block)));
				}
			}
		}
		return true;
	}
}
