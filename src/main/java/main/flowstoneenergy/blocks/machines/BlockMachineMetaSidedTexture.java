package main.flowstoneenergy.blocks.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.items.tools.ItemToolFlowwrench;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineBase;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public abstract class BlockMachineMetaSidedTexture extends BlockMachineBox {

    public IIcon top;
    public IIcon bottom;
    public IIcon frontOn[];
    public static IIcon frontOff[];


    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemToolFlowwrench) {
            return false;
        } else {
            return true;
        }
    }


    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess access, int x, int y, int z, int side) {
        TileEntityMachineBase tile = (TileEntityMachineBase) access.getTileEntity(x, y, z);
        int i = access.getBlockMetadata(x, y, z);

        if (side == 0) {
            return this.bottom;
        } else if (side == 1) {
            return this.top;
        } else if (side != tile.facing) {
            return this.blockIcon;
        } else if (tile.ticksLeft != 0) {
            return this.frontOn[i];
        } else {
            return this.frontOff[i];
        }

    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (side <= 1) {
            return this.top;
        }
        if (side == 3) {
            return this.frontOff[meta];
        }
        return this.blockIcon;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
        dropItems(world, x, y, z);
        world.removeTileEntity(x, y, z);
        super.breakBlock(world, x, y, z, par5, par6);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
        int facing = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        TileEntityMachineBase tile = (TileEntityMachineBase) world.getTileEntity(x, y, z);

        if (facing == 0) tile.facing = 2;
        else if (facing == 1) tile.facing = 5;
        else if (facing == 2) tile.facing = 3;
        else if (facing == 3) tile.facing = 4;
    }

    private void dropItems(World world, int x, int y, int z) {
        Random rand = new Random();

        TileEntity tileEntity = world.getTileEntity(x, y, z);
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

                EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

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
    public int damageDropped(int meta) {
        return meta;
    }
}
