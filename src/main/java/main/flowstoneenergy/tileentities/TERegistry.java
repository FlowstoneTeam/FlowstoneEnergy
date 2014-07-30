package main.flowstoneenergy.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.libs.ModInfo;
import main.flowstoneenergy.tileentities.machines.*;
import main.flowstoneenergy.tileentities.transport.TileEntityFluidPipe;
import main.flowstoneenergy.tileentities.transport.TileEntityItemPipe;
import main.flowstoneenergy.tileentities.upgrades.*;

public class TERegistry {

    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityMachineOreTumbler.class, ModInfo.MODID + ":" + "tileEntityOreTumbler");
        GameRegistry.registerTileEntity(TileEntityMachineHeatedOven.class, ModInfo.MODID + ":" + "tileEntityHeatedOven");
        GameRegistry.registerTileEntity(TileEntityMachineFlowstoneBottler.class, ModInfo.MODID + ":" + "tileEntityFlowstoneBottler");
        GameRegistry.registerTileEntity(TileEntityMachineMetalMixer.class, ModInfo.MODID + ":" + "tileEntityMetalMixer");
        GameRegistry.registerTileEntity(TileEntityMachineWorkbench.class, ModInfo.MODID + ":" + "tileEntityMachineWorkbench");
        GameRegistry.registerTileEntity(TileEntityMachineLumberMill.class, ModInfo.MODID + ":" + "tileEntityMachineLumberMill");
        GameRegistry.registerTileEntity(TileEntityMachineLiquifier.class, ModInfo.MODID + ":" + "tileEntityMachineLiquifier");
        GameRegistry.registerTileEntity(TileEntityMachineInfuser.class, ModInfo.MODID + ":" + "tileEntityMachineInfuser");
        GameRegistry.registerTileEntity(TileEntityMachineAutoCraftingTable.class, ModInfo.MODID + ":" + "tileEntityMachineAutocrafter");
        GameRegistry.registerTileEntity(TileEntityUpgradeSpeed.class, ModInfo.MODID + ":" + "tileEntityUpgradeSpeed");
        GameRegistry.registerTileEntity(TileEntityItemPipe.class, ModInfo.MODID + ":" + "tileEntityFluidPipe");
        GameRegistry.registerTileEntity(TileEntityFluidPipe.class, ModInfo.MODID + ":" + "tileEntityItemPipe");
    }
}
