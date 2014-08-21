package main.flowstoneenergy.blocks.decorative;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockAplite extends Block {
    public IIcon[] icon = new IIcon[8];

    public BlockAplite() {
        super(Material.rock);
        this.setHardness(1F);
        this.setBlockName(ModInfo.MODID + ".aplite");
        this.setCreativeTab(FlowstoneEnergy.blockTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        icon[0] = ir.registerIcon(ModInfo.MODID + ":ores/apliteOre");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":decorative/apliteCobble");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":decorative/apliteBrick");
        icon[3] = ir.registerIcon(ModInfo.MODID + ":decorative/apliteSmallBrick");
        icon[4] = ir.registerIcon(ModInfo.MODID + ":decorative/apliteChiseled");
        icon[5] = ir.registerIcon(ModInfo.MODID + ":decorative/apliteBlock");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.icon[meta];
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < 6; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    public int damageDropped(int meta) {
        if (meta == 0) {
            return 1;
        }
        return meta;
    }
}