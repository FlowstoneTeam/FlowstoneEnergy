package main.flowstoneenergy.blocks.decorative;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

import java.util.List;

import scala.reflect.internal.Trees.Super;

public class BlockAplite extends Block {
    //public IIcon[] icon = new IIcon[8];
    public static PropertyEnum<EnumApliteTypes> TYPE = PropertyEnum.<EnumApliteTypes>create("type", EnumApliteTypes.class);

    public BlockAplite() {
        super(Material.rock);
        this.setHardness(1F);
        this.setUnlocalizedName(ModInfo.MODID + ".aplite");
        this.setCreativeTab(FlowstoneEnergy.blockTab);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumApliteTypes.ORE));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = getDefaultState();
        switch (meta) {
            case 0:
                return state.withProperty(TYPE, EnumApliteTypes.ORE);
            case 1:
                return state.withProperty(TYPE, EnumApliteTypes.COBBLE);
            case 2:
                return state.withProperty(TYPE, EnumApliteTypes.BRICK);
            case 4:
                return state.withProperty(TYPE, EnumApliteTypes.SMALL_BRICK);
            case 5:
                return state.withProperty(TYPE, EnumApliteTypes.BLOCK);
        }
        return super.getStateFromMeta(meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPE).getMeta();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, TYPE);
    }

    @Override
    protected ItemStack createStackedBlock(IBlockState state) {
        return new ItemStack(this, 1, state.getValue(TYPE).getMeta());
    }

    /*
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

*/
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < 6; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    public int damageDropped(IBlockState blockState) {
        // FIXME: make it proper
        /*if (meta == 0) {
            return 1;
        }
        return meta;*/
        return getMetaFromState(blockState);
    }
    
    public static enum EnumApliteTypes implements IStringSerializable {
        ORE("ore", 0),
        COBBLE("cobble", 1),
        BRICK("brick", 2),
        SMALL_BRICK("small_brick", 3),
        CHISELED("chiseled", 4),
        BLOCK ("block", 5);

        private String name;
        private int meta;

        EnumApliteTypes(String name, int meta) {
            this.name = name;
            this.meta = meta;
        }

        @Override
        public String getName() {
            return this.name;
        }

        public int getMeta() {
            return this.meta;
        }
    }
}