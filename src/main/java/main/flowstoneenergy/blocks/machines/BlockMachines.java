package main.flowstoneenergy.blocks.machines;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.tileentities.machines.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.List;

public class BlockMachines extends BlockMachineMetaSidedTexture {

    public BlockMachines() {
        /*frontOff = new IIcon[16];
        frontOn = new IIcon[16];
        top = new IIcon[16];
        bottom = new IIcon[16];
        sideIcon = new IIcon[16];*/
        setCreativeTab(FlowstoneEnergy.blockTab);
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
}
