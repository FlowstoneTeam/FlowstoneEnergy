package main.flowstoneenergy.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.tileentities.machines.*;
import main.flowstoneenergy.tileentities.transport.TileEntityFluidPipe;
import main.flowstoneenergy.tileentities.transport.TileEntityItemPipe;

public class TERegistry {

    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityMachineOreTumbler.class, ModInfo.MODID + ":" + "tileEntityOreTumbler");
        GameRegistry.registerTileEntity(TileEntityMachineHeatedOven.class, ModInfo.MODID + ":" + "tileEntityHeatedOven");
        GameRegistry.registerTileEntity(TileEntityMachineFlowstoneBottler.class, ModInfo.MODID + ":" + "tileEntityFlowstoneBottler");
        GameRegistry.registerTileEntity(TileEntityMachineMetalMixer.class, ModInfo.MODID + ":" + "tileEntityMetalMixer");
        GameRegistry.registerTileEntity(TileEntityMachineWorkbench.class, ModInfo.MODID + ":" + "tileEntityMachineWorkbench");
        GameRegistry.registerTileEntity(TileEntityMachineLumberMill.class, ModInfo.MODID + ":" + "tileEntityMachineLumberMill");
        GameRegistry.registerTileEntity(TileEntityItemPipe.class, ModInfo.MODID + ":" + "tileEntityFluidPipe");
        GameRegistry.registerTileEntity(TileEntityFluidPipe.class, ModInfo.MODID + ":" + "tileEntityItemPipe");
    }
}
