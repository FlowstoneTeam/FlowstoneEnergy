package main.flowstoneenergy.utils;

import main.flowstoneenergy.ConfigOptions;
import main.flowstoneenergy.blocks.blockedingots.BlockCopper;
import main.flowstoneenergy.blocks.blockedingots.BlockElectrum;
import main.flowstoneenergy.blocks.blockedingots.BlockEnder;
import main.flowstoneenergy.blocks.blockedingots.BlockInvar;
import main.flowstoneenergy.blocks.blockedingots.BlockLead;
import main.flowstoneenergy.blocks.blockedingots.BlockNickel;
import main.flowstoneenergy.blocks.blockedingots.BlockSilver;
import main.flowstoneenergy.blocks.blockedingots.BlockTin;
import main.flowstoneenergy.blocks.machines.BlockMachineAutoCraftingTable;
import main.flowstoneenergy.blocks.machines.BlockMachineBox;
import main.flowstoneenergy.blocks.machines.BlockMachineEnergizedOreTumbler;
import main.flowstoneenergy.blocks.machines.BlockMachineFlowstoneBottler;
import main.flowstoneenergy.blocks.machines.BlockMachineHeatedOven;
import main.flowstoneenergy.blocks.machines.BlockMachineMetalMixer;
import main.flowstoneenergy.blocks.machines.BlockMachineWorkbench;
import main.flowstoneenergy.blocks.ore.BlockOreCopper;
import main.flowstoneenergy.blocks.ore.BlockOreLead;
import main.flowstoneenergy.blocks.ore.BlockOreNickel;
import main.flowstoneenergy.blocks.ore.BlockOreSilver;
import main.flowstoneenergy.blocks.ore.BlockOreTin;
import main.flowstoneenergy.tileentities.recipes.RecipesMachineWorkbench;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockUtils {
	
	//machines
	public static Block energizedOreTumbler;
	public static Block heatedOven;
	public static Block flowstoneBottler;
	public static Block metalMixer;
	public static Block autoCrafter;
	public static Block machineBox;
	public static Block machineWorkbench;
	
	//blocks
	public static Block copper;
	public static Block tin;
	public static Block lead;
	public static Block silver;
	public static Block nickel;
	public static Block electrum;
	public static Block invar;
	public static Block ender;
	
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
		copper = new BlockCopper();
		GameRegistry.registerBlock(copper, copper.getUnlocalizedName());
		tin = new BlockTin();
		GameRegistry.registerBlock(tin, tin.getUnlocalizedName());
		lead = new BlockLead();
		GameRegistry.registerBlock(lead, lead.getUnlocalizedName());
		silver = new BlockSilver();
		GameRegistry.registerBlock(silver, silver.getUnlocalizedName());
		nickel = new BlockNickel();
		GameRegistry.registerBlock(nickel, nickel.getUnlocalizedName());
		invar = new BlockInvar();
		GameRegistry.registerBlock(invar, invar.getUnlocalizedName());
		electrum = new BlockElectrum();
		GameRegistry.registerBlock(electrum, electrum.getUnlocalizedName());
		ender = new BlockEnder();
		GameRegistry.registerBlock(ender, ender.getUnlocalizedName());
		
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
