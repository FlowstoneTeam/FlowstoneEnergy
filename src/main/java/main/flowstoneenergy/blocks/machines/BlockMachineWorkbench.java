package main.flowstoneenergy.blocks.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.interfaces.IWrenchable;
import main.flowstoneenergy.items.tools.ItemToolFlowwrench;
import main.flowstoneenergy.tileentities.TileEntityMachineWorkbench;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMachineWorkbench extends BlockMachineBox implements IWrenchable {

    private IIcon top;
    private IIcon frontOn;
    private IIcon frontOff;
    private boolean onOff;
    @SuppressWarnings("unused")
    private static boolean canBreak;

    public BlockMachineWorkbench() {
        this.setHardness(12);
        this.setBlockName(ModInfo.MODID + ".MachineWorkbench");
        this.setBlockTextureName(ModInfo.MODID + ":machines/machine_Side");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (!onOff) {
            return side == 3 ? this.frontOff : (side == 0 ? this.top : (side != meta ? this.blockIcon : this.frontOff));
        } else {
            return side == 3 ? this.frontOn : (side == 0 ? this.top : (side != meta ? this.blockIcon : this.frontOn));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon(ModInfo.MODID + ":machines/machine_Side");
        this.frontOn = icon.registerIcon(ModInfo.MODID + ":machines/furnace_Front_Active");
        this.frontOff = icon.registerIcon(ModInfo.MODID + ":machines/furnace_Front");
        this.top = icon.registerIcon(ModInfo.MODID + ":machines/machine_Top");
    }

    public static void updateFurnaceBlockState(boolean onOff, World world, int x, int y, int z) {
        int l = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        canBreak = true;

        if (onOff) {
            world.setBlock(x, y, z, Blocks.lit_furnace);
        } else {
            world.setBlock(x, y, z, Blocks.furnace);
        }

        canBreak = false;
        world.setBlockMetadataWithNotify(x, y, z, l, 2);

        if (tileentity != null) {
            tileentity.validate();
            world.setTileEntity(x, y, z, tileentity);
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
        int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (itemStack.hasDisplayName()) {
            ((TileEntityMachineWorkbench) world.getTileEntity(x, y, z)).func_145951_a(itemStack.getDisplayName());
        }
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityMachineWorkbench();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (!world.isRemote) {
            if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemToolFlowwrench) {
            } else
                player.openGui(FlowstoneEnergy.instance, 4, world, x, y, z);
        }
        return super.onBlockActivated(world, x, y, z, player, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
    }

    @Override
    public boolean canWrenchRemove() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess access, int i, int j, int k, int side) {
        return super.getIcon(access, i, j, k, side);
    }

}
