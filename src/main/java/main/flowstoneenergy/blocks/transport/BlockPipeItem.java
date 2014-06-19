package main.flowstoneenergy.blocks.transport;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.blocks.machines.BlockMachineBox;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineWorkbench;
<<<<<<< HEAD
import main.flowstoneenergy.tileentities.transport.TileEntityItemPipe;
=======
>>>>>>> dc6d4a50b1dc369a2e067214e91816783cd79306
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPipeItem extends BlockMachineBox {

    public BlockPipeItem() {
        this.setLightOpacity(0);
        this.setBlockName(ModInfo.MODID + ".item.pipe");
        this.setBlockTextureName(ModInfo.MODID + ":transport/itemPipe");
        this.setHardness(7);
        this.setCreativeTab(FlowstoneEnergy.blockTab);
    }

    @Override
<<<<<<< HEAD
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        return false;
    }

    @Override
    public int getRenderType() {
=======
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
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
>>>>>>> dc6d4a50b1dc369a2e067214e91816783cd79306
        return -1;
    }

    @Override
<<<<<<< HEAD
    public boolean isOpaqueCube() {
=======
    public boolean isOpaqueCube()
    {
>>>>>>> dc6d4a50b1dc369a2e067214e91816783cd79306
        return false;
    }

    @Override
<<<<<<< HEAD
    public boolean renderAsNormalBlock() {
=======
    public boolean renderAsNormalBlock()
    {
>>>>>>> dc6d4a50b1dc369a2e067214e91816783cd79306
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
<<<<<<< HEAD
    public void registerBlockIcons(IIconRegister icon) {
=======
    public void registerBlockIcons(IIconRegister icon)
    {
>>>>>>> dc6d4a50b1dc369a2e067214e91816783cd79306
        this.blockIcon = icon.registerIcon(ModInfo.MODID + ":machines/machine_Side");
    }

    @Override
<<<<<<< HEAD
    public TileEntity createNewTileEntity(World world, int var2) {
        return new TileEntityItemPipe();
=======
    public TileEntity createNewTileEntity(World world, int var2)
    {
        return new TileEntityMachineWorkbench();
>>>>>>> dc6d4a50b1dc369a2e067214e91816783cd79306
    }
}
