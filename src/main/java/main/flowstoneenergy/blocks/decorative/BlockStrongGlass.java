package main.flowstoneenergy.blocks.decorative;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.core.utils.ConnectedTextureHelper;
import main.flowstoneenergy.blocks.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStrongGlass extends Block {

    public static final int NUMBER_OF_ICONS = 47;
    protected IIcon[] icons = new IIcon[NUMBER_OF_ICONS];

    public BlockStrongGlass() {
        super(Material.iron);
        this.setHardness(0.5F);
        this.setStepSound(soundTypeGlass);
        this.setCreativeTab(FlowstoneEnergy.blockTab);
        this.setBlockName(ModInfo.MODID + ".strong.glass");
        this.setBlockTextureName(ModInfo.MODID + ":decorative/strongGlass_0");
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
        Block b1 = blockAccess.getBlock(x, y, z);
        if (b1 == this || b1 == BlockRegistry.strongGlass) {
            return false;
        }
        return super.shouldSideBeRendered(blockAccess, x, y, z, side);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        return blockAccess.getBlockMetadata(x, y, z) == 15 ? icons[0] : ConnectedTextureHelper.getConnectedBlockTexture(blockAccess, x, y, z, side, icons, this);
    }

    @Override
    public void registerBlockIcons(IIconRegister ir) {
        blockIcon = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_0");
        
        for( int i = 0; i < NUMBER_OF_ICONS; i++ )
        {
            icons[i] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_" + i);
        }
    }

    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return true;
    }
}
