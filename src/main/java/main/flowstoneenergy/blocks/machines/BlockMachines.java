package main.flowstoneenergy.blocks.machines;

import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.tileentities.machines.*;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockMachines extends BlockMachineMetaSidedTexture {

    public static final PropertyEnum<EnumMachineTypes> TYPE = PropertyEnum.create("type", EnumMachineTypes.class);

    public static final IUnlistedProperty<Integer>[] hiddenProperties = new IUnlistedProperty[2];

    static {
        hiddenProperties[0] = Properties.toUnlisted(PropertyInteger.create("facing", 0, 5));
        hiddenProperties[1] = Properties.toUnlisted(PropertyInteger.create("operating", 0, 1));
    }

    public BlockMachines() {
        /*frontOff = new IIcon[16];
        frontOn = new IIcon[16];
        top = new IIcon[16];
        bottom = new IIcon[16];
        sideIcon = new IIcon[16];*/
        setCreativeTab(FlowstoneEnergy.blockTab);
        //setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumMachineTypes.ORE_TUMBLER));
    }
    

    /*
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon(ModInfo.MODID + ":machines/machine_Side_0");

        // ore tumbler
        this.frontOn[0] = icon.registerIcon(ModInfo.MODID + ":machines/oreTumbler_Front_Active");
        this.frontOff[0] = icon.registerIcon(ModInfo.MODID + ":machines/oreTumbler_Front");
        this.top[0] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Top");
        this.bottom[0] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Bottom");
        this.sideIcon[0] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Side_0");

        // flowstone bottler
        this.frontOn[1] = icon.registerIcon(ModInfo.MODID + ":machines/flowstoneBottler_Front_Activate");
        this.frontOff[1] = icon.registerIcon(ModInfo.MODID + ":machines/flowstoneBottler_Front");
        this.top[1] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Top");
        this.bottom[1] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Bottom");
        this.sideIcon[1] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Side_0");

        // heated oven
        this.frontOn[2] = icon.registerIcon(ModInfo.MODID + ":machines/furnace_Front_Active");
        this.frontOff[2] = icon.registerIcon(ModInfo.MODID + ":machines/furnace_Front");
        this.top[2] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Top");
        this.bottom[2] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Bottom");
        this.sideIcon[2] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Side_0");

        // lumber mill
        this.frontOn[3] = icon.registerIcon(ModInfo.MODID + ":machines/lumberMill_Front_Active");
        this.frontOff[3] = icon.registerIcon(ModInfo.MODID + ":machines/lumberMill_Front");
        this.top[3] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Top");
        this.bottom[3] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Bottom");
        this.sideIcon[3] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Side_0");

        // metal mixer
        this.frontOn[4] = icon.registerIcon(ModInfo.MODID + ":machines/metalMixer_Front_Active");
        this.frontOff[4] = icon.registerIcon(ModInfo.MODID + ":machines/metalMixer_Front");
        this.top[4] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Top");
        this.bottom[4] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Bottom");
        this.sideIcon[4] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Side_0");

        // cooler
        this.frontOn[5] = icon.registerIcon(ModInfo.MODID + ":machines/cooler_Front_Active");
        this.frontOff[5] = icon.registerIcon(ModInfo.MODID + ":machines/cooler_Front");
        this.top[5] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Top");
        this.bottom[5] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Bottom");
        this.sideIcon[5] = icon.registerIcon(ModInfo.MODID + ":machines/machine_Side_0");
    }
    */
    
    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = getDefaultState();
        switch (meta)
        {
            case 0:
                return state.withProperty(TYPE, EnumMachineTypes.ORE_TUMBLER);
            case 1:
                return state.withProperty(TYPE, EnumMachineTypes.BOTTLER);
            case 2:
                return state.withProperty(TYPE, EnumMachineTypes.HEATED_OVEN);
            case 3:
                return state.withProperty(TYPE, EnumMachineTypes.LUMBER_MILL);
            case 4:
                return state.withProperty(TYPE, EnumMachineTypes.METAL_MIXER);
            case 5:
                return state.withProperty(TYPE, EnumMachineTypes.COOLER);
        }
        return state;
    }
    
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPE).getMeta();
    }

    @Override
    protected ItemStack createStackedBlock(IBlockState state) {
        return new ItemStack(this,1,getMetaFromState(state));
    }

    @Override
    protected BlockState createBlockState() {
        IProperty<?>[] visiableProperties = {TYPE};

        return new ExtendedBlockState(this, visiableProperties, hiddenProperties);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state;
    }

    @Override
    public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
        IExtendedBlockState extendedState = (IExtendedBlockState)state;
        TileEntity tileEntity = world.getTileEntity(pos);
        if (tileEntity != null && tileEntity instanceof TileEntityMachineBase) {

            int front = ((TileEntityMachineBase)tileEntity).facing;
            extendedState = extendedState.withProperty(hiddenProperties[0], front);
            int operating = 0;
            if (((TileEntityMachineBase)tileEntity).ticksLeft != 0) {
                operating = 1;
            }
            extendedState = extendedState.withProperty(hiddenProperties[1], operating);
        }
        return extendedState;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i <= 5; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState blockState) {
        int meta = getMetaFromState(blockState);
        if (meta == 0) {
            return new TileEntityMachineOreTumbler();
        }
        if (meta == 1) {
            return new TileEntityMachineFlowstoneBottler();
        }
        if (meta == 2) {
            return new TileEntityMachineHeatedOven();
        }
        if (meta == 3) {
            return new TileEntityMachineLumberMill();
        }
        if (meta == 4) {
            return new TileEntityMachineMetalMixer();
        }
        if (meta == 5) {
            return new TileEntityMachineCooler();
        }
        return super.createTileEntity(world, blockState);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {

        TileEntityMachineBase tile = (TileEntityMachineBase) world.getTileEntity(pos);

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        if (!world.isRemote && tile instanceof TileEntityMachineOreTumbler) {
            player.openGui(FlowstoneEnergy.instance, 0, world, x, y, z);
        } else if (!world.isRemote && tile instanceof TileEntityMachineFlowstoneBottler) {
            player.openGui(FlowstoneEnergy.instance, 2, world, x, y, z);
        } else if (!world.isRemote && tile instanceof TileEntityMachineHeatedOven) {
            player.openGui(FlowstoneEnergy.instance, 1, world, x, y, z);
        } else if (!world.isRemote && tile instanceof TileEntityMachineLumberMill) {
            player.openGui(FlowstoneEnergy.instance, 5, world, x, y, z);
        } else if (!world.isRemote && tile instanceof TileEntityMachineMetalMixer) {
            player.openGui(FlowstoneEnergy.instance, 3, world, x, y, z);
        }

        return true;
    }
    
    public enum EnumMachineTypes implements IStringSerializable {
        ORE_TUMBLER("ore_tumbler", 0),
        BOTTLER("bottler", 1),
        HEATED_OVEN("heated_over", 2),
        LUMBER_MILL("lumber_mill", 3),
        METAL_MIXER("metal_mixer", 4),
        COOLER("cooler", 5)
        ;
        private String name;
        private int meta;
        EnumMachineTypes(String name, int meta){
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
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
