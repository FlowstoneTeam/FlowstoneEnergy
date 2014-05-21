package main.flowstoneenergy.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;

public class TERegistry {
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityMachineOreTumbler.class, "tileEntityOreTumbler");
		GameRegistry.registerTileEntity(TileEntityMachineHeatedOven.class, "tileEntityHeatedOven");
		GameRegistry.registerTileEntity(TileEntityMachineFlowstoneBottler.class, "tileEntityFlowstoneBottler");
		GameRegistry.registerTileEntity(TileEntityMachineMetalMixer.class, "tileEntityMetalMixer");
		GameRegistry.registerTileEntity(TileEntityMachineWorkbench.class, "tileEntityMachineWorkbench");
		GameRegistry.registerTileEntity(TileEntityMachineLumberMill.class, "tileEntityMachineLumberMill");
	}
}
