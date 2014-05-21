package main.flowstoneenergy.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockIngotStorage extends Block {
    public IIcon[] icon = new IIcon[16];

    public BlockIngotStorage() {
        super(Material.iron);
        this.setHardness(0.5F);
        this.setCreativeTab(FlowstoneEnergy.tab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        this.icon[0] = ir.registerIcon(ModInfo.MODID + ":blockedingots/blockCopper");
        this.icon[1] = ir.registerIcon(ModInfo.MODID + ":blockedingots/blockTin");
        this.icon[2] = ir.registerIcon(ModInfo.MODID + ":blockedingots/blockLead");
        this.icon[3] = ir.registerIcon(ModInfo.MODID + ":blockedingots/blockSilver");
        this.icon[4] = ir.registerIcon(ModInfo.MODID + ":blockedingots/blockEnder");
        this.icon[5] = ir.registerIcon(ModInfo.MODID + ":blockedingots/blockNickel");
        this.icon[6] = ir.registerIcon(ModInfo.MODID + ":blockedingots/blockInvar");
        this.icon[7] = ir.registerIcon(ModInfo.MODID + ":blockedingots/blockElectrum");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.icon[meta];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < 8; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
}
