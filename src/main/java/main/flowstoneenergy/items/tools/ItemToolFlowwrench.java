package main.flowstoneenergy.items.tools;

import cpw.mods.fml.common.Optional.Interface;
import cpw.mods.fml.common.Optional.Method;
//import buildcraft.api.tools.IToolWrench;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.core.interfaces.IFlowWrenchable;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

//TODO: Enable after update
//@Interface(iface = "buildcraft.api.tools.IToolWrench", modid = "BuildCraft|Core")
public class ItemToolFlowwrench extends Item /*implements IToolWrench */{

    public ItemToolFlowwrench() {
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setMaxDamage(49);
        this.setUnlocalizedName(ModInfo.MODID + ".flowwrench");
        this.setTextureName(ModInfo.MODID + ":tools/flowwrench");
        this.setMaxStackSize(1);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase) {
        return true;
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
    // TODO: Enable after update
    /*
    @Override
    @Method(modid = "BuildCraft|Core")
    public boolean canWrench(EntityPlayer player, int x, int y, int z) {
        return true;
    }

    @Override
    @Method(modid = "BuildCraft|Core")
    public void wrenchUsed(EntityPlayer player, int x, int y, int z) {
    }
    */
}