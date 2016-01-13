package main.flowstoneenergy.blocks.upgrades;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.tileentities.machines.TileEntityUpgrade;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockUpgradeBase extends BlockContainer {
    //public IIcon icon[] = new IIcon[16];

    public BlockUpgradeBase() {
        super(Material.iron);
        this.setCreativeTab(FlowstoneEnergy.blockTab);
    }

    /*
    @Override
    public void registerBlockIcons(IIconRegister register) {
        return;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return null;
    }
    */

    @Override
    @Deprecated
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityUpgrade();
    }
    
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityUpgrade();
    }
}
