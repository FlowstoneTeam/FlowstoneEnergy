package main.flowstoneenergy.items.tools;

import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.Method;
//import buildcraft.api.tools.IToolWrench;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.core.interfaces.IFlowWrenchable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

//TODO: Enable after update
//@Interface(iface = "buildcraft.api.tools.IToolWrench", modid = "BuildCraft|Core")
public class ItemToolFlowwrench extends Item /*implements IToolWrench */{

    public ItemToolFlowwrench() {
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setMaxDamage(49);
        this.setUnlocalizedName(ModInfo.MODID + ".flowwrench");
        //this.setTextureName(ModInfo.MODID + ":tools/flowwrench");
        this.setMaxStackSize(1);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, BlockPos pos, EntityLivingBase entityLivingBase) {
        return true;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        IBlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();
        if (player.isSneaking()) {
            if (block instanceof IFlowWrenchable) {
                world.setBlockToAir(pos);
                if (!world.isRemote) {
                    world.spawnEntityInWorld(new EntityItem(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(block)));
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