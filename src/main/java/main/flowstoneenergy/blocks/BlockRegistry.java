package main.flowstoneenergy.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.blocks.machines.*;
import main.flowstoneenergy.items.blocks.ItemBlockIngotStorage;
import main.flowstoneenergy.items.blocks.ItemBlockOres;
import net.minecraft.block.Block;

public class BlockRegistry {

    //machines
    public static Block energizedOreTumbler;
    public static Block heatedOven;
    public static Block flowstoneBottler;
    public static Block metalMixer;
    public static Block autoCrafter;
    public static Block machineBox;
    public static Block machineWorkbench;
    public static Block lumberMill;

    public static Block ingotStorage;

    //ores
    public static Block blockOres;

    public static void registerBlocks() {
        //machines
        energizedOreTumbler = new BlockMachineEnergizedOreTumbler();
        GameRegistry.registerBlock(energizedOreTumbler, energizedOreTumbler.getUnlocalizedName());
        heatedOven = new BlockMachineHeatedOven();
        GameRegistry.registerBlock(heatedOven, heatedOven.getUnlocalizedName());
        flowstoneBottler = new BlockMachineFlowstoneBottler();
        GameRegistry.registerBlock(flowstoneBottler, flowstoneBottler.getUnlocalizedName());
        autoCrafter = new BlockMachineAutoCraftingTable();
        GameRegistry.registerBlock(autoCrafter, autoCrafter.getUnlocalizedName());
        metalMixer = new BlockMachineMetalMixer();
        GameRegistry.registerBlock(metalMixer, metalMixer.getUnlocalizedName());
        machineBox = new BlockMachineBox();
        GameRegistry.registerBlock(machineBox, machineBox.getUnlocalizedName());
        machineWorkbench = new BlockMachineWorkbench();
        GameRegistry.registerBlock(machineWorkbench, machineWorkbench.getUnlocalizedName());
        lumberMill = new BlockMachineLumberMill();
        GameRegistry.registerBlock(lumberMill, lumberMill.getUnlocalizedName());

        //blocks
        ingotStorage = new BlockIngotStorage().setBlockName("blockIngotStorage");
        GameRegistry.registerBlock(ingotStorage, ItemBlockIngotStorage.class, "BlockIngotStorage");

        //ores
        blockOres = new BlockOres();
        GameRegistry.registerBlock(blockOres, ItemBlockOres.class, blockOres.getUnlocalizedName());
    }
}
