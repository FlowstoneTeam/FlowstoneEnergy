package main.flowstoneenergy.blocks.generators;

import java.util.List;

import main.flowstoneenergy.blocks.machines.BlockMachineMetaSidedTexture;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.tileentities.generators.TileEntityGeneratorCoal;
import main.flowstoneenergy.tileentities.generators.TileEntityGeneratorFlowstone;
import main.flowstoneenergy.tileentities.generators.TileEntityGeneratorLava;
import main.flowstoneenergy.tileentities.generators.TileEntityGeneratorSolar;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGenerator extends BlockMachineMetaSidedTexture {

    public static PropertyEnum<EnumGeneratorType> TYPE = PropertyEnum.<EnumGeneratorType>create("type", EnumGeneratorType.class);

    public BlockGenerator() {
       /* frontOff = new IIcon[4];
        frontOn = new IIcon[4];
        top = new IIcon[4];
        bottom = new IIcon[4];
        sideIcon = new IIcon[4];*/
        this.setUnlocalizedName(ModInfo.MODID + ".generator");
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumGeneratorType.COAL));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = getDefaultState();
        switch (meta) {
            case 0:
                return state.withProperty(TYPE, EnumGeneratorType.COAL);
            case 1:
                return state.withProperty(TYPE, EnumGeneratorType.FLOWSTONE);
            case 2:
                return state.withProperty(TYPE, EnumGeneratorType.LAVA);
            case 3:
                return state.withProperty(TYPE, EnumGeneratorType.SOLAR);
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
        return new ItemStack(this,1,state.getValue(TYPE).getMeta());
    }

    /*@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_0");

        // Coal Generator
        this.frontOff[0] = iconRegister.registerIcon(ModInfo.MODID + ":generators/CoalGenFront");
        this.frontOn[0] = iconRegister.registerIcon(ModInfo.MODID + ":generators/CoalGenSide");
        this.top[0] = iconRegister.registerIcon(ModInfo.MODID + ":generators/CoalGenSide");
        this.bottom[0] = iconRegister.registerIcon(ModInfo.MODID + ":generators/CoalGenSide");
        this.sideIcon[0] = iconRegister.registerIcon(ModInfo.MODID + ":generators/CoalGenSide");

        // Flowstone Generator
        this.frontOff[1] = iconRegister.registerIcon(ModInfo.MODID + ":generators/FlowstoneFront");
        this.frontOn[1] = iconRegister.registerIcon(ModInfo.MODID + ":generators/FlowstoneSide");
        this.top[1] = iconRegister.registerIcon(ModInfo.MODID + ":generators/FlowstoneSide");
        this.bottom[1] = iconRegister.registerIcon(ModInfo.MODID + ":generators/FlowstoneSide");
        this.sideIcon[1] = iconRegister.registerIcon(ModInfo.MODID + ":generators/FlowstoneSide");

        // Lava Generator
        this.frontOff[2] = iconRegister.registerIcon(ModInfo.MODID + ":generators/LavaFront");
        this.frontOn[2] = iconRegister.registerIcon(ModInfo.MODID + ":generators/LavaSide");
        this.top[2] = iconRegister.registerIcon(ModInfo.MODID + ":generators/LavaSide");
        this.bottom[2] = iconRegister.registerIcon(ModInfo.MODID + ":generators/LavaSide");
        this.sideIcon[2] = iconRegister.registerIcon(ModInfo.MODID + ":generators/LavaSide");

        // Solar Generator
        this.frontOff[3] = iconRegister.registerIcon(ModInfo.MODID + ":generators/SolarSide");
        this.frontOn[3] = iconRegister.registerIcon(ModInfo.MODID + ":generators/SolarSide");
        this.top[3] = iconRegister.registerIcon(ModInfo.MODID + ":generators/SolarTop");
        this.bottom[3] = iconRegister.registerIcon(ModInfo.MODID + ":generators/SolarSide");
        this.sideIcon[3] = iconRegister.registerIcon(ModInfo.MODID + ":generators/SolarSide");

    }*/

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
        /*for (int i = 0; i < frontOff.length; i++) {
            list.add(new ItemStack(item, 1, i));
        }*/
        for (int i = 0; i < 4; i++) {
        list.add(new ItemStack(item, 1, i));
    }
    }

    @Override    
    public TileEntity createNewTileEntity(World world, int metadata) {

        switch (metadata) {
            case 0:
                return new TileEntityGeneratorCoal();
            case 1:
                return new TileEntityGeneratorFlowstone();
            case 2:
                return new TileEntityGeneratorLava();
            case 3:
                return new TileEntityGeneratorSolar();
        }

        return super.createNewTileEntity(world, metadata);
    }
    
    public static enum EnumGeneratorType implements IStringSerializable {
        COAL("coal", 0),
        FLOWSTONE("flowstone", 1),
        LAVA("lava", 2),
        SOLAR("solar", 3);

        private String name;
        private int meta;

        EnumGeneratorType(String name, int meta) {
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
