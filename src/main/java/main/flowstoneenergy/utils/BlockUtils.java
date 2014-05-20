package main.flowstoneenergy.utils;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.ConfigOptions;
import main.flowstoneenergy.blocks.BlockIngotStorage;
import main.flowstoneenergy.blocks.machines.*;
import main.flowstoneenergy.blocks.ore.*;
import main.flowstoneenergy.items.blocks.ItemBlockIngotStorage;
import main.flowstoneenergy.tileentities.recipes.RecipesMachineWorkbench;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BlockUtils {

    //machines
    public static Block energizedOreTumbler;
    public static Block heatedOven;
    public static Block flowstoneBottler;
    public static Block metalMixer;
    public static Block autoCrafter;
    public static Block machineBox;
    public static Block machineWorkbench;

    public static Block ingotStorage;

    //ores
    public static Block copperOre;
    public static Block tinOre;
    public static Block leadOre;
    public static Block silverOre;
    public static Block nickelOre;

    private static void registerBlocks() {
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

        //blocks
        ingotStorage = new BlockIngotStorage().setBlockName("blockIngotStorage");
        GameRegistry.registerBlock(ingotStorage, ItemBlockIngotStorage.class, "BlockIngotStorage");

        //ores
        copperOre = new BlockOreCopper();
        if (ConfigOptions.useFECopper) GameRegistry.registerBlock(copperOre, copperOre.getLocalizedName());
        tinOre = new BlockOreTin();
        if (ConfigOptions.useFETin) GameRegistry.registerBlock(tinOre, tinOre.getUnlocalizedName());
        leadOre = new BlockOreLead();
        if (ConfigOptions.useFELead) GameRegistry.registerBlock(leadOre, leadOre.getUnlocalizedName());
        silverOre = new BlockOreSilver();
        if (ConfigOptions.useFESilver) GameRegistry.registerBlock(silverOre, silverOre.getUnlocalizedName());
        nickelOre = new BlockOreNickel();
        if (ConfigOptions.useFENickel) GameRegistry.registerBlock(nickelOre, nickelOre.getUnlocalizedName());
    }

    private static void registerShapedRecipes() {

    }

    private static void registerShapelessRecipes() {

    }

    private static void registerSmeltingRecipes() {

    }

    private static void registerMWRecipes() {
        RecipesMachineWorkbench.AddRecipe(new ItemStack(machineBox), new ItemStack(ItemUtils.metaResourceGear, 1, 2), new ItemStack(ItemUtils.metaResourceGear, 1, 2), new ItemStack(heatedOven), 200);
    }

    private static void registerOreDict() {
        OreDictionary.registerOre("oreCopper", copperOre);
        OreDictionary.registerOre("oreTin", tinOre);
        OreDictionary.registerOre("oreLead", leadOre);
        OreDictionary.registerOre("oreSilver", silverOre);
    }

    public static void registerFullBlocks() {
        registerBlocks();
        registerSmeltingRecipes();
        registerShapedRecipes();
        registerShapelessRecipes();
        registerOreDict();
        registerMWRecipes();
    }
}
