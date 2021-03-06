package main.flowstoneenergy.core.client.gui;

import net.minecraftforge.fml.common.network.IGuiHandler;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.containers.*;
import main.flowstoneenergy.tileentities.machines.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
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
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
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
            }
        } else if (ID == 9) {
            FlowstoneEnergy.logger.info("Open Gui");
            return new ItemGuiManual();
        }
        return null;
    }
}