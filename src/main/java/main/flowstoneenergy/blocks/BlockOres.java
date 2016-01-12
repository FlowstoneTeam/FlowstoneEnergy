package main.flowstoneenergy.blocks;

import java.util.List;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.block.BlockOre;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockOres extends BlockOre {
    //public IIcon[] icon = new IIcon[16];
    public final static PropertyEnum<EnumOreTypes> TYPE = PropertyEnum.<EnumOreTypes> create("type", EnumOreTypes.class);

    public BlockOres() {
        super();
        this.setHardness(2F);
        this.setUnlocalizedName(ModInfo.MODID + ".ores");
        this.setCreativeTab(FlowstoneEnergy.blockTab);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumOreTypes.COPPER));

    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = this.getDefaultState();
        switch (meta) {
            case 0:
                return state.withProperty(TYPE, EnumOreTypes.COPPER);
            case 1:
                return state.withProperty(TYPE, EnumOreTypes.TIN);
            case 2:
                return state.withProperty(TYPE, EnumOreTypes.LEAD);
            case 3:
                return state.withProperty(TYPE, EnumOreTypes.SILVER);
            case 4:
                return state.withProperty(TYPE, EnumOreTypes.NICKEL);
        }
        return super.getStateFromMeta(meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumOreTypes) state.getValue(TYPE)).getMeta();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, TYPE);
    }

    @Override
    protected ItemStack createStackedBlock(IBlockState state) {
        return new ItemStack(this, 1, getMetaFromState(state));
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

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List<ItemStack> list) {
        for (int i = 0; i < 5; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    public int damageDropped(IBlockState blockState) {
        return getMetaFromState(blockState);
    }

    public static enum EnumOreTypes implements IStringSerializable {
        COPPER("copper", 0),
        TIN("tin", 1),
        LEAD("lead", 2),
        SILVER("silver", 3),
        NICKEL("nickel", 4);

        private String name;
        private int meta;

        EnumOreTypes(String name, int meta) {
            this.name = name;
            this.meta = meta;
        }

        @Override
        public String getName() {
            return this.name;
        }

        public int getMeta() {
            return meta;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
