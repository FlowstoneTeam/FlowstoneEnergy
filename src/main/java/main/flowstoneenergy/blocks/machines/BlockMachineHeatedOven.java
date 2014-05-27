package main.flowstoneenergy.blocks.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.interfaces.IFlowWrenchable;
import main.flowstoneenergy.items.tools.ItemToolFlowwrench;
import main.flowstoneenergy.tileentities.TileEntityMachineHeatedOven;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMachineHeatedOven extends BlockMachineSidedTexure implements IFlowWrenchable {

    public static boolean onOff;
    @SuppressWarnings("unused")
    private static boolean canBreak;

    public BlockMachineHeatedOven() {
        this.setHardness(12);
        this.setBlockName(ModInfo.MODID + ".HeatedOven");
        this.setBlockTextureName(ModInfo.MODID + ":machines/machine_Side");
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
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityMachineHeatedOven();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (!world.isRemote) {
            if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemToolFlowwrench) {
            } else
                player.openGui(FlowstoneEnergy.instance, 1, world, x, y, z);
        }
        return super.onBlockActivated(world, x, y, z, player, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
    }

    @Override
    public boolean canWrenchRemove() {
        return true;
    }
}
