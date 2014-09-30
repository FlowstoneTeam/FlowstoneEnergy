package main.flowstoneenergy.blocks.decorative;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.core.utils.ConnectedTextureHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockStrongGlassPane extends BlockPane {

    protected IIcon[] icons = new IIcon[16];

    public BlockStrongGlassPane() {
        super(ModInfo.MODID + ":decorative/strongGlass_0", ModInfo.MODID + ":blockedingots/blockLead", Material.glass, true);
        this.setStepSound(soundTypeGlass);
        this.setBlockName(ModInfo.MODID + ".strong.glass.pane");
        this.setBlockTextureName(ModInfo.MODID + ":decorative/strongGlass_0");
        this.setCreativeTab(FlowstoneEnergy.blockTab);
        this.setHardness(0.5F);
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    /*
     * public boolean shouldSideBeRendered() { return true; }
     */

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
    @SideOnly(Side.CLIENT)
    public IIcon func_150097_e() {
        return icons[0];
    }

    @Override
    public void registerBlockIcons(IIconRegister ir) {
        super.registerBlockIcons(ir);
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
}