package main.flowstoneenergy.blocks.machines;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import main.flowstoneenergy.items.tools.ItemToolFlowwrench;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineBase;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public abstract class BlockMachineMetaSidedTexture extends BlockMachineBox {

    /*
    public IIcon top[];
    public IIcon bottom[];
    public IIcon frontOn[];
    public IIcon sideIcon[];
    public IIcon frontOff[];
    */

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, net.minecraft.util.EnumFacing side, float hitX, float hitY, float hitZ) {
        if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemToolFlowwrench) {
            return false;
        } else {
            return true;
        }
    }

    /*
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess access, int x, int y, int z, int side) {
        TileEntityMachineBase tile = (TileEntityMachineBase) access.getTileEntity(x, y, z);
        int i = access.getBlockMetadata(x, y, z);

        if (side == 0) {
            return this.bottom[i];
        } else if (side == 1) {
            return this.top[i];
        } else if (side != tile.facing) {
            return this.sideIcon[i];
        } else if (tile.ticksLeft != 0) {
            return this.frontOn[i];
        } else {
            return this.frontOff[i];
        }

    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (meta >= 0) {
            if (side <= 1) {
                if (meta >= 0) {
                    return this.top[meta];
                } else {
                    return this.blockIcon;
                }
            }
            if (side == 3) {
                if (meta >= 0) {
                    return this.frontOff[meta];
                } else {
                    return this.blockIcon;
                }
            }
            return this.sideIcon[meta];
        } else {
            return this.blockIcon;
        }
    }

*/
  
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        dropItems(world, pos);
        world.removeTileEntity(pos);
        super.breakBlock(world, pos, state);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack itemStack) {
        int facing = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        TileEntityMachineBase tile = (TileEntityMachineBase) world.getTileEntity(pos);

        if (facing == 0)
            tile.facing = 2;
        else if (facing == 1)
            tile.facing = 5;
        else if (facing == 2)
            tile.facing = 3;
        else if (facing == 3)
            tile.facing = 4;
    }

    private void dropItems(World world, BlockPos pos) {
        Random rand = new Random();

        TileEntity tileEntity = world.getTileEntity(pos);
        if (!(tileEntity instanceof IInventory)) {
            return;
        }
        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack item = inventory.getStackInSlot(i);

            if (item != null && item.stackSize > 0) {
                float rx = rand.nextFloat() * 0.8F + 0.1F;
                float ry = rand.nextFloat() * 0.8F + 0.1F;
                float rz = rand.nextFloat() * 0.8F + 0.1F;

                EntityItem entityItem = new EntityItem(world, pos.getX() + rx, pos.getY() + ry, pos.getZ() + rz, new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

                if (item.hasTagCompound()) {
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                item.stackSize = 0;
            }
        }
    }

    @Override
    public int damageDropped(IBlockState blockState) {
        return getMetaFromState(blockState);
    }
}
