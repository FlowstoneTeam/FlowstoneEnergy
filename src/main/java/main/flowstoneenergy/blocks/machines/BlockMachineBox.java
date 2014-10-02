package main.flowstoneenergy.blocks.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.core.utils.ConnectedTextureHelper;
import main.flowstoneenergy.core.interfaces.IFlowWrenchable;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMachineBox extends BlockContainer implements IFlowWrenchable {

    protected IIcon[] icons = new IIcon[16];

    public BlockMachineBox() {
        super(Material.iron);
        this.setBlockName(ModInfo.MODID + ".MachineBox");
        this.setCreativeTab(FlowstoneEnergy.blockTab);
        this.setBlockTextureName(ModInfo.MODID + ":machines/machine_Side_0");
        this.setStepSound(soundTypeMetal);
        this.setHardness(7);
    }

    @Override
    public boolean canWrenchRemove() {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 15 ? icons[0]
                : ConnectedTextureHelper.getConnectedBlockTexture(par1IBlockAccess, par2, par3, par4, par5, icons, this);
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        blockIcon = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_0");
        icons[0] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_0");
        icons[1] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_1");
        icons[2] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_2");
        icons[3] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_3");
        icons[4] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_4");
        icons[5] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_5");
        icons[6] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_6");
        icons[7] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_7");
        icons[8] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_8");
        icons[9] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_9");
        icons[10] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_10");
        icons[11] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_11");
        icons[12] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_12");
        icons[13] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_13");
        icons[14] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_14");
        icons[15] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_15");
    }
}
