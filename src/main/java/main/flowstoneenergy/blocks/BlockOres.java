package main.flowstoneenergy.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockOres extends BlockOre {
    public IIcon[] icon = new IIcon[16];

    public BlockOres() {
        super();
        this.setHardness(5F);
        this.setBlockName(ModInfo.MODID + ".ores");
        this.setCreativeTab(FlowstoneEnergy.tab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        this.icon[0] = ir.registerIcon(ModInfo.MODID + ":ores/copperOre");
        this.icon[1] = ir.registerIcon(ModInfo.MODID + ":ores/TinOre");
        this.icon[2] = ir.registerIcon(ModInfo.MODID + ":ores/leadOre");
        this.icon[3] = ir.registerIcon(ModInfo.MODID + ":ores/SilverOre");
        this.icon[4] = ir.registerIcon(ModInfo.MODID + ":ores/nickelOre");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.icon[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < 5; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
}
