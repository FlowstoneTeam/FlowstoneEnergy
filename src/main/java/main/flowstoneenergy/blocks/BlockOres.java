package main.flowstoneenergy.blocks;

import java.util.List;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockOres extends BlockOre {
    //public IIcon[] icon = new IIcon[16];

    public BlockOres() {
        super();
        this.setHardness(2F);
        this.setUnlocalizedName(ModInfo.MODID + ".ores");
        this.setCreativeTab(FlowstoneEnergy.blockTab);
    }

    /*@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        this.icon[0] = ir.registerIcon(ModInfo.MODID + ":ores/copperOre");
        this.icon[1] = ir.registerIcon(ModInfo.MODID + ":ores/tinOre");
        this.icon[2] = ir.registerIcon(ModInfo.MODID + ":ores/leadOre");
        this.icon[3] = ir.registerIcon(ModInfo.MODID + ":ores/silverOre");
        this.icon[4] = ir.registerIcon(ModInfo.MODID + ":ores/nickelOre");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.icon[meta];
    }
    */

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < 5; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    public int damageDropped(IBlockState blockState) {
        return getMetaFromState(blockState);
    }
}
