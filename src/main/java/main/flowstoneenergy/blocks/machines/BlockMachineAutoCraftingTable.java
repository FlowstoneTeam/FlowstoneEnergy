package main.flowstoneenergy.blocks.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.interfaces.IWrenchable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockMachineAutoCraftingTable extends BlockMachineBox implements IWrenchable {
    private IIcon top;
    private IIcon bottom;

    public BlockMachineAutoCraftingTable() {
        this.setHardness(12);
        this.setBlockName(ModInfo.MODID + ".AutoCraftingTable");
        this.setBlockTextureName(ModInfo.MODID + ":machines/autocraftingTable_Side");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 1) {
            return this.top;
        } else if (side == 0) {
            return this.bottom;
        } else {
            return this.blockIcon;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon(ModInfo.MODID + ":machines/autocraftingTable_Side");
        this.bottom = icon.registerIcon(ModInfo.MODID + ":machines/autocraftingTable_Bottom");
        this.top = icon.registerIcon(ModInfo.MODID + ":machines/autocraftingTable_Top");
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return null;
    }

    @Override
    public boolean canWrenchRemove() {
        return true;
    }

}
