package main.flowstoneenergy.utils;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.tileentities.*;

public class TileEntityUtils {
    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityMachineOreTumbler.class, "tileEntityOreTumbler");
        GameRegistry.registerTileEntity(TileEntityMachineHeatedOven.class, "tileEntityHeatedOven");
        GameRegistry.registerTileEntity(TileEntityMachineFlowstoneBottler.class, "tileEntityFlowstoneBottler");
        GameRegistry.registerTileEntity(TileEntityMachineMetalMixer.class, "tileEntityMetalMixer");
        GameRegistry.registerTileEntity(TileEntityMachineWorkbench.class, "tileEntityMachineWorkbench");
    }
}
