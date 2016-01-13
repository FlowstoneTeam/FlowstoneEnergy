package main.flowstoneenergy.blocks;

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

import akka.dispatch.sysmsg.Create;

public class BlockIngotStorage extends Block {
    //public IIcon[] icon = new IIcon[16];

    public final static PropertyEnum<EnumIngotStorage> TYPE = PropertyEnum.create("type", EnumIngotStorage.class);

    public BlockIngotStorage() {
        super(Material.iron);
        this.setHardness(0.5F);
        this.setCreativeTab(FlowstoneEnergy.blockTab);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumIngotStorage.COPPER));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = getDefaultState();

        switch (meta) {
            case 0:
                return state.withProperty(TYPE, EnumIngotStorage.COPPER);
            case 1:
                return state.withProperty(TYPE, EnumIngotStorage.TIN);
            case 2:
                return state.withProperty(TYPE, EnumIngotStorage.LEAD);
            case 3:
                return state.withProperty(TYPE, EnumIngotStorage.SILVER);
            case 4:
                return state.withProperty(TYPE, EnumIngotStorage.ENDER);     
            case 5:
                return state.withProperty(TYPE, EnumIngotStorage.NICKEL);                
            case 6:
                return state.withProperty(TYPE, EnumIngotStorage.INVAR);
            case 7:
                return state.withProperty(TYPE, EnumIngotStorage.ELECTRUM);
        }

        return state;
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
        return new ItemStack(this, 1, getMetaFromState(state));
    }

    /*@Override
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
    }*/

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < 8; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    public int damageDropped(IBlockState blockState) {
        return getMetaFromState(blockState);
    }

    public static enum EnumIngotStorage implements IStringSerializable {

        COPPER("copper", 0),
        TIN("tin", 1),
        LEAD("lead", 2),
        SILVER("silver", 3),
        ENDER("ender", 4),
        NICKEL("nickel", 5),
        INVAR("invar", 6),
        ELECTRUM("electrum", 7)
        ;

        private String name;
        private int meta;

        EnumIngotStorage(String name, int meta) {
            this.name = name;
            this.meta = meta;
        }

        public int getMeta() {
            return meta;
        }

        @Override
        public String getName() {
            return name;
        }
        
        @Override
        public String toString() {
            return name;
        }
    }
}