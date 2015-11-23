package main.flowstoneenergy.blocks.machines;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineWorkbench;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockMachineWorkbench extends BlockMachineSidedTexture {

    public BlockMachineWorkbench() {
        this.setLightOpacity(0);
        this.setUnlocalizedName(ModInfo.MODID + ".machine.workbench");
        //this.setBlockTextureName(ModInfo.MODID + ":machines/machine_Side_0");
        this.setHardness(7);
        this.setCreativeTab(FlowstoneEnergy.blockTab);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            player.openGui(FlowstoneEnergy.instance, 4, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    /*@Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon(ModInfo.MODID + ":machines/machine_Side_0");
    }
    */

    @Override
    public TileEntity createTileEntity(World world, IBlockState blockState) {
        return new TileEntityMachineWorkbench();
    }
}
