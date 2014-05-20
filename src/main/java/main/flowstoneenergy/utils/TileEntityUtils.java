package main.flowstoneenergy.utils;

import main.flowstoneenergy.tileentities.TileEntityMachineFlowstoneBottler;
import main.flowstoneenergy.tileentities.TileEntityMachineHeatedOven;
import main.flowstoneenergy.tileentities.TileEntityMachineMetalMixer;
import main.flowstoneenergy.tileentities.TileEntityMachineOreTumbler;
import main.flowstoneenergy.tileentities.TileEntityMachineWorkbench;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityUtils {
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityMachineOreTumbler.class, "tileEntityOreTumbler");
		GameRegistry.registerTileEntity(TileEntityMachineHeatedOven.class, "tileEntityHeatedOven");
		GameRegistry.registerTileEntity(TileEntityMachineFlowstoneBottler.class, "tileEntityFlowstoneBottler");
		GameRegistry.registerTileEntity(TileEntityMachineMetalMixer.class, "tileEntityMetalMixer");
		GameRegistry.registerTileEntity(TileEntityMachineWorkbench.class, "tileEntityMachineWorkbench");
	}
}
