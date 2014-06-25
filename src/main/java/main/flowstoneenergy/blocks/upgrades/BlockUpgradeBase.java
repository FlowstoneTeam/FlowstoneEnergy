package main.flowstoneenergy.blocks.upgrades;

import main.flowstoneenergy.FlowstoneEnergy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockUpgradeBase extends BlockContainer {
    public IIcon icon[] = new IIcon[16];
    public BlockUpgradeBase() {
        super(Material.iron);
        this.setCreativeTab(FlowstoneEnergy.blockTab);
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        return;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return null;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return null;
    }
}
