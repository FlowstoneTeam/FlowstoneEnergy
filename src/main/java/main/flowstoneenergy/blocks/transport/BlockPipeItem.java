package main.flowstoneenergy.blocks.transport;

import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.blocks.machines.BlockMachineBox;
import main.flowstoneenergy.core.interfaces.IFlowWrenchable;
import main.flowstoneenergy.tileentities.transport.TileEntityItemPipe;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockPipeItem extends BlockMachineBox implements IFlowWrenchable {

    float pixel = 1F / 16F;

    public BlockPipeItem() {
        this.setLightOpacity(0);
        this.setUnlocalizedName(ModInfo.MODID + ".item.pipe");
        //this.setBlockTextureName(ModInfo.MODID + ":transport/itemPipeIcon");
        this.setHardness(7);
        this.setBlockBounds(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state) {
        TileEntityItemPipe pipe = (TileEntityItemPipe) world.getTileEntity(pos);

        // FIXME: switch to direction enum
        /*
        if (pipe != null) {
            float minX = 11 * pixel / 2 - (pipe.connections[5] != null ? (11 * pixel / 2) : 0);
            float minZ = 11 * pixel / 2 - (pipe.connections[2] != null ? (11 * pixel / 2) : 0);
            float minY = 11 * pixel / 2 - (pipe.connections[1] != null ? (11 * pixel / 2) : 0);
            float maxZ = 1 - 11 * pixel / 2 + (pipe.connections[4] != null ? (11 * pixel / 2) : 0);
            float maxY = 1 - 11 * pixel / 2 + (pipe.connections[0] != null ? (11 * pixel / 2) : 0);
            float maxX = 1 - 11 * pixel / 2 + (pipe.connections[3] != null ? (11 * pixel / 2) : 0);

            setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
        }
        */

        return AxisAlignedBB.fromBounds(pos.getX() + minX, pos.getY() + minY, pos.getZ() + minZ, pos.getX() + maxX, pos.getY() + maxY, pos.getZ() + maxZ);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(World world, BlockPos pos) {
        TileEntityItemPipe pipe = (TileEntityItemPipe) world.getTileEntity(pos);

        // FIXME: Switch to direction enum
        /*
        if (pipe != null) {
            float minX = 11 * pixel / 2 - (pipe.connections[5] != null ? (11 * pixel / 2) : 0);
            float minZ = 11 * pixel / 2 - (pipe.connections[2] != null ? (11 * pixel / 2) : 0);
            float minY = 11 * pixel / 2 - (pipe.connections[1] != null ? (11 * pixel / 2) : 0);
            float maxZ = 1 - 11 * pixel / 2 + (pipe.connections[4] != null ? (11 * pixel / 2) : 0);
            float maxY = 1 - 11 * pixel / 2 + (pipe.connections[0] != null ? (11 * pixel / 2) : 0);
            float maxX = 1 - 11 * pixel / 2 + (pipe.connections[3] != null ? (11 * pixel / 2) : 0);

            setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
        }
        */

        return AxisAlignedBB.fromBounds(pos.getX() + minX, pos.getY() + minY, pos.getZ() + minZ, pos.getX() + maxX, pos.getY() + maxY, pos.getZ()  + maxZ);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    /*
    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon(ModInfo.MODID + ":transport/itemPipeIcon");
    }
    */

    @Override
    public TileEntity createTileEntity(World world, IBlockState blockState) {
        return new TileEntityItemPipe();
    }

    @Override
    public boolean canWrenchRemove() {
        return true;
    }
}