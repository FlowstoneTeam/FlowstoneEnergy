package main.flowstoneenergy.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.blocks.machines.*;
import main.flowstoneenergy.items.blocks.ItemBlockIngotStorage;
import main.flowstoneenergy.items.blocks.ItemBlockMachines;
import main.flowstoneenergy.items.blocks.ItemBlockOres;
import net.minecraft.block.Block;

public class BlockRegistry {

    //machines
    public static Block autoCrafter;
    public static Block machineBox;
    public static Block machines;

    public static Block ingotStorage;

    //ores
    public static Block blockOres;

    public static void registerBlocks() {
        //machines
        autoCrafter = new BlockMachineAutoCraftingTable();
        GameRegistry.registerBlock(autoCrafter, autoCrafter.getUnlocalizedName());
        machineBox = new BlockMachineBox();
        GameRegistry.registerBlock(machineBox, machineBox.getUnlocalizedName());
        machines = new BlockMachines().setBlockName("blockMachines");
        GameRegistry.registerBlock(machines, ItemBlockMachines.class, "BlockMachines");

        //blocks
        ingotStorage = new BlockIngotStorage().setBlockName("blockIngotStorage");
        GameRegistry.registerBlock(ingotStorage, ItemBlockIngotStorage.class, "BlockIngotStorage");

        //ores
        blockOres = new BlockOres();
        GameRegistry.registerBlock(blockOres, ItemBlockOres.class, blockOres.getUnlocalizedName());
    }
}
