package main.flowstoneenergy.blocks.upgrades;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

import java.util.List;

public class BlockUpgrades extends BlockUpgradeBase {
    public static PropertyEnum<EnumUpgradeType> TYPE = PropertyEnum.create("type", EnumUpgradeType.class);
    
    public BlockUpgrades() {
        super();
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumUpgradeType.SPEED));
    }
    
    
    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = getDefaultState();
        
        switch(meta)
        {
            case 0:
                return state.withProperty(TYPE, EnumUpgradeType.SPEED);
            case 1:
                return state.withProperty(TYPE, EnumUpgradeType.ITEM_CAPACITY);
            case 2:
                return state.withProperty(TYPE, EnumUpgradeType.ENERGY_CAPACITY);
            case 3:
                return state.withProperty(TYPE, EnumUpgradeType.ENERGY_EFFICIENCY);
            case 4:
                return state.withProperty(TYPE, EnumUpgradeType.PROCESS_AMOUNT);
            case 5:
                return state.withProperty(TYPE, EnumUpgradeType.CREATIVE);
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
    
/*
    @Override
    public void registerBlockIcons(IIconRegister register) {
        icon[0] = register.registerIcon(ModInfo.MODID + ":upgrades/speed");
        icon[1] = register.registerIcon(ModInfo.MODID + ":upgrades/itemCapacity");
        icon[2] = register.registerIcon(ModInfo.MODID + ":upgrades/energyCapacity");
        icon[3] = register.registerIcon(ModInfo.MODID + ":upgrades/energyEfficiency");
        icon[4] = register.registerIcon(ModInfo.MODID + ":upgrades/processAmount");
        icon[5] = register.registerIcon(ModInfo.MODID + ":upgrades/creative");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (meta != 0) {
            switch (meta) {
                case 1: {
                    return icon[1];
                }
                case 2: {
                    return icon[2];
                }
                case 3: {
                    return icon[3];
                }
                case 4: {
                    return icon[4];
                }
                case 5: {
                    return icon[5];
                }
            }
        }
        return icon[0];
    }
*/
    @Override
    public int getRenderType() {
        return 3;
    }
   
    @SuppressWarnings({"unchecked", "rawtypes"})
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i <= 5; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    public int damageDropped(IBlockState blockState) {
        int meta = getMetaFromState(blockState);
        return meta;
    }
    
    public static enum EnumUpgradeType implements IStringSerializable{
        SPEED("speed", 0),
        ITEM_CAPACITY("item_capacity", 1),
        ENERGY_CAPACITY("energy_capacity", 2),
        ENERGY_EFFICIENCY("energy_efficiency", 3),
        PROCESS_AMOUNT("process_amount", 4),
        CREATIVE("creative", 5)
        ;
        
        private String name;
        private int meta;
        
        private EnumUpgradeType(String name, int meta)
        {
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
