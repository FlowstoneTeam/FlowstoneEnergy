package main.flowstoneenergy.gui;

import main.flowstoneenergy.containers.ContainerMachineFlowstoneBottler;
import main.flowstoneenergy.containers.ContainerMachineHeatedOven;
import main.flowstoneenergy.containers.ContainerMachineMetalMixer;
import main.flowstoneenergy.containers.ContainerMachineOreTumbler;
import main.flowstoneenergy.containers.ContainerMachineWorkbench;
import main.flowstoneenergy.tileentities.TileEntityMachineFlowstoneBottler;
import main.flowstoneenergy.tileentities.TileEntityMachineHeatedOven;
import main.flowstoneenergy.tileentities.TileEntityMachineMetalMixer;
import main.flowstoneenergy.tileentities.TileEntityMachineOreTumbler;
import main.flowstoneenergy.tileentities.TileEntityMachineWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		System.out.println("Server Active");
		if (entity != null) {
			switch(ID) {
			case 0: return new ContainerMachineOreTumbler(player,(TileEntityMachineOreTumbler)entity);
			case 1: return new ContainerMachineHeatedOven(player,(TileEntityMachineHeatedOven)entity);
			case 2: return new ContainerMachineFlowstoneBottler(player,(TileEntityMachineFlowstoneBottler)entity);
			case 3: return new ContainerMachineMetalMixer(player, (TileEntityMachineMetalMixer)entity);
			case 4: return new ContainerMachineWorkbench(player, (TileEntityMachineWorkbench)entity);
			}
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		System.out.println("Client Active");
		if (entity != null) {
			switch(ID) {
			case 0: return new BlockGuiOreTumbler(player,(TileEntityMachineOreTumbler)entity);
			case 1: return new BlockGuiHeatedOven(player,(TileEntityMachineHeatedOven)entity);
			case 2: return new BlockGuiFlowstoneBottler(player,(TileEntityMachineFlowstoneBottler)entity);
			case 3: return new BlockGuiMetalMixer(player, (TileEntityMachineMetalMixer)entity);
			case 4: return new BlockGuiMachineWorkbench(player, (TileEntityMachineWorkbench)entity);
			}
		}
		return null;
	}
}