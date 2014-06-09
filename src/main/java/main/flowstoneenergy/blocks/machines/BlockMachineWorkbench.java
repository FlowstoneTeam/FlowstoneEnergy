package main.flowstoneenergy.blocks.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineWorkbench;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockMachineWorkbench extends BlockMachineMetaSidedTexture{

    public BlockMachineWorkbench() {
        this.setLightOpacity(0);
        this.setBlockName(ModInfo.MODID + ".machine.workbench");
        this.setBlockTextureName(ModInfo.MODID + ":machines/machine_Side");
        this.setHardness(7);
        this.setCreativeTab(FlowstoneEnergy.blockTab);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (!world.isRemote)
        {
            player.openGui(FlowstoneEnergy.instance, 4, world, x, y, z);
        }
        return true;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.blockIcon = icon.registerIcon(ModInfo.MODID + ":machines/machine_Side");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int var2)
    {
        return new TileEntityMachineWorkbench();
    }
}
