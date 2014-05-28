package main.flowstoneenergy.blocks.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.tileentities.*;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class BlockMachines extends BlockMachineMetaSidedTexture {

    public BlockMachines() {
        frontOff = new IIcon[16];
        frontOn = new IIcon[16];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {

        this.blockIcon = icon.registerIcon(ModInfo.MODID + ":machines/machine_Side");
        this.top = icon.registerIcon(ModInfo.MODID + ":machines/machine_Top");

        //ore tumbler
        this.frontOn[0] = icon.registerIcon(ModInfo.MODID + ":machines/oreTumbler_Front_Active");
        this.frontOff[0] = icon.registerIcon(ModInfo.MODID + ":machines/oreTumbler_Front");

        //flowstone bottler
        this.frontOn[1] = icon.registerIcon(ModInfo.MODID + ":machines/flowstoneBottler_Front_Active");
        this.frontOff[1] = icon.registerIcon(ModInfo.MODID + ":machines/flowstoneBottler_Front");

        //heated oven
        this.frontOn[2] = icon.registerIcon(ModInfo.MODID + ":machines/furnace_Front_Active");
        this.frontOff[2] = icon.registerIcon(ModInfo.MODID + ":machines/furnace_Front");

        //lumber mill
        this.frontOn[3] = icon.registerIcon(ModInfo.MODID + ":machines/lumberMill_Front_Active");
        this.frontOff[3] = icon.registerIcon(ModInfo.MODID + ":machines/lumberMill_Front");

        //metal mixer
        this.frontOn[4] = icon.registerIcon(ModInfo.MODID + ":machines/furnace_Front_Active");
        this.frontOff[4] = icon.registerIcon(ModInfo.MODID + ":machines/furnace_Front");

        //machine workbench
        this.frontOn[5] = icon.registerIcon(ModInfo.MODID + ":machines/furnace_Front_Active");
        this.frontOff[5] = icon.registerIcon(ModInfo.MODID + ":machines/furnace_Front");
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i <= 5; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    public TileEntity createTileEntity(World world, int meta) {
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
            return new TileEntityMachineWorkbench();
        }
        return super.createTileEntity(world, meta);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {

        TileEntityMachineBase tile = (TileEntityMachineBase) world.getTileEntity(x, y, z);

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
        } else if (!world.isRemote && tile instanceof TileEntityMachineWorkbench) {
            player.openGui(FlowstoneEnergy.instance, 4, world, x, y, z);
        }
        return true;
    }
}
