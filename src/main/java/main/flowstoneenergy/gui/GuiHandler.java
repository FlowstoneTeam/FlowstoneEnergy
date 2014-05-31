package main.flowstoneenergy.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import main.flowstoneenergy.containers.*;
import main.flowstoneenergy.tileentities.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        System.out.println("Server Active");
        if (entity != null) {
            switch (ID) {
                case 0:
                    return new ContainerMachineOreTumbler(player, (TileEntityMachineOreTumbler) entity);
                case 1:
                    return new ContainerMachineHeatedOven(player, (TileEntityMachineHeatedOven) entity);
                case 2:
                    return new ContainerMachineFlowstoneBottler(player, (TileEntityMachineFlowstoneBottler) entity);
                case 3:
                    return new ContainerMachineMetalMixer(player, (TileEntityMachineMetalMixer) entity);
                case 4:
                    return new ContainerMachineWorkbench(player, (TileEntityMachineWorkbench) entity);
                case 5:
                    return new ContainerMachineLumberMill(player, (TileEntityMachineLumberMill) entity);
                case 6:
                    return new ContainerMachineLiquifier(player, (TileEntityMachineLiquifier) entity);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        System.out.println("Client Active");
        if (entity != null) {
            switch (ID) {
                case 0:
                    return new BlockGuiOreTumbler(player, (TileEntityMachineOreTumbler) entity);
                case 1:
                    return new BlockGuiHeatedOven(player, (TileEntityMachineHeatedOven) entity);
                case 2:
                    return new BlockGuiFlowstoneBottler(player, (TileEntityMachineFlowstoneBottler) entity);
                case 3:
                    return new BlockGuiMetalMixer(player, (TileEntityMachineMetalMixer) entity);
                case 4:
                    return new BlockGuiMachineWorkbench(player, (TileEntityMachineWorkbench) entity);
                case 5:
                    return new BlockGuiLumberMill(player, (TileEntityMachineLumberMill) entity);
                case 6:
                    return new BlockGuiLiquifier(player, (TileEntityMachineLiquifier) entity);
            }
        }
        return null;
    }
}