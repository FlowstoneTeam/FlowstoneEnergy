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

    protected IIcon[] icons = new IIcon[16];

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
        icons[0] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_0");
        icons[1] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_1");
        icons[2] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_2");
        icons[3] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_3");
        icons[4] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_4");
        icons[5] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_5");
        icons[6] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_6");
        icons[7] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_7");
        icons[8] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_8");
        icons[9] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_9");
        icons[10] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_10");
        icons[11] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_11");
        icons[12] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_12");
        icons[13] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_13");
        icons[14] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_14");
        icons[15] = ir.registerIcon(ModInfo.MODID + ":decorative/strongGlass_15");
    }

    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return true;
    }
}
