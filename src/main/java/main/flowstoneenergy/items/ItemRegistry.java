package main.flowstoneenergy.items;

import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.items.battery.ItemBatteryFlowstoneTierFive;
import main.flowstoneenergy.items.battery.ItemBatteryFlowstoneTierFour;
import main.flowstoneenergy.items.battery.ItemBatteryFlowstoneTierOne;
import main.flowstoneenergy.items.battery.ItemBatteryFlowstoneTierThree;
import main.flowstoneenergy.items.battery.ItemBatteryFlowstoneTierTwo;
import main.flowstoneenergy.items.food.FoodBacon;
import main.flowstoneenergy.items.food.FoodCookedBacon;
import main.flowstoneenergy.items.tools.ItemToolFlowwrench;
import main.flowstoneenergy.items.tools.ItemToolPneumaticFlowwrench;
import main.flowstoneenergy.items.tools.electrum.ItemAxeElectrum;
import main.flowstoneenergy.items.tools.electrum.ItemHoeElectrum;
import main.flowstoneenergy.items.tools.electrum.ItemPickElectrum;
import main.flowstoneenergy.items.tools.electrum.ItemShovelElectrum;
import main.flowstoneenergy.items.tools.electrum.ItemSwordElectrum;
import main.flowstoneenergy.items.tools.ender.ItemAxeEnder;
import main.flowstoneenergy.items.tools.ender.ItemHoeEnder;
import main.flowstoneenergy.items.tools.ender.ItemPickEnder;
import main.flowstoneenergy.items.tools.ender.ItemShovelEnder;
import main.flowstoneenergy.items.tools.ender.ItemSwordEnder;
import main.flowstoneenergy.tileentities.recipes.RecipesEnergizedOreTumbler;
import main.flowstoneenergy.tileentities.recipes.RecipesMetalMixer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegistry {
	//Tool Materials
	public static final ToolMaterial ender = EnumHelper.addToolMaterial("ender", 3, 500, 8.0F, 0, 25);
	public static final ToolMaterial electrum = EnumHelper.addToolMaterial("electrum", 2, 250, 4.0F, 0, 15);

	//fake item
	public static Item fakeItem;

	//batteries
	public static Item tierOne;
	public static Item tierTwo;
	public static Item tierThree;
	public static Item tierFour;
	public static Item tierFive;

	//tools
	public static Item flowwrench;
	public static Item pneumaticFlowwrench;
	public static Item enderSword;
	public static Item enderHoe;
	public static Item enderAxe;
	public static Item enderPick;
	public static Item enderShovel;
	public static Item electrumSword;
	public static Item electrumHoe;
	public static Item electrumAxe;
	public static Item electrumPick;
	public static Item electrumShovel;

	//Metadata item replacing all the resources
	public static Item metaResourceDust;
	public static Item metaResourceIngot;
	public static Item metaResourceGear;

	//food
	public static Item rawBacon;
	public static Item cookedBacon;

	private static void registerItems() {
		//fake item
		fakeItem = new FAKEITEM();
		GameRegistry.registerItem(fakeItem, fakeItem.getUnlocalizedName());

		//Metadata Item
		metaResourceDust = new ItemMetaResourceDust().setUnlocalizedName("itemMetadataResourceDust");
		GameRegistry.registerItem(metaResourceDust, "ItemMetadataResourceDust");
		metaResourceIngot = new ItemMetaResourceIngots().setUnlocalizedName("itemMetadataResourceIngot");
		GameRegistry.registerItem(metaResourceIngot, "ItemMetadataResourceIngot");
		metaResourceGear = new ItemMetaResourceGears().setUnlocalizedName("itemMetadataResourceGear");
		GameRegistry.registerItem(metaResourceGear, "ItemMetadataResourceGear");

		//batteries
		tierOne = new ItemBatteryFlowstoneTierOne();
		GameRegistry.registerItem(tierOne, tierOne.getUnlocalizedName());
		tierTwo = new ItemBatteryFlowstoneTierTwo();
		GameRegistry.registerItem(tierTwo, tierTwo.getUnlocalizedName());
		tierThree = new ItemBatteryFlowstoneTierThree();
		GameRegistry.registerItem(tierThree, tierThree.getUnlocalizedName());
		tierFour = new ItemBatteryFlowstoneTierFour();
		GameRegistry.registerItem(tierFour, tierFour.getUnlocalizedName());
		tierFive = new ItemBatteryFlowstoneTierFive();
		GameRegistry.registerItem(tierFive, tierFive.getUnlocalizedName());

		//tools
		flowwrench = new ItemToolFlowwrench();
		GameRegistry.registerItem(flowwrench, flowwrench.getUnlocalizedName());
		pneumaticFlowwrench = new ItemToolPneumaticFlowwrench();
		GameRegistry.registerItem(pneumaticFlowwrench, pneumaticFlowwrench.getUnlocalizedName());
		enderSword = new ItemSwordEnder(ender);
		GameRegistry.registerItem(enderSword, enderSword.getUnlocalizedName());
		enderPick = new ItemPickEnder(ender);
		GameRegistry.registerItem(enderPick, enderPick.getUnlocalizedName());
		enderHoe = new ItemHoeEnder(ender);
		GameRegistry.registerItem(enderHoe, enderHoe.getUnlocalizedName());
		enderShovel = new ItemShovelEnder(ender);
		GameRegistry.registerItem(enderShovel, enderShovel.getUnlocalizedName());
		enderAxe = new ItemAxeEnder(ender);
		GameRegistry.registerItem(enderAxe, enderAxe.getUnlocalizedName());
		electrumSword = new ItemSwordElectrum(electrum);
		GameRegistry.registerItem(electrumSword, electrumSword.getUnlocalizedName());
		electrumPick = new ItemPickElectrum(electrum);
		GameRegistry.registerItem(electrumPick, electrumPick.getUnlocalizedName());
		electrumHoe = new ItemHoeElectrum(electrum);
		GameRegistry.registerItem(electrumHoe, electrumHoe.getUnlocalizedName());
		electrumShovel = new ItemShovelElectrum(electrum);
		GameRegistry.registerItem(electrumShovel, electrumShovel.getUnlocalizedName());
		electrumAxe = new ItemAxeElectrum(electrum);
		GameRegistry.registerItem(electrumAxe, electrumAxe.getUnlocalizedName());

		//food
		cookedBacon = new FoodCookedBacon();
		GameRegistry.registerItem(cookedBacon, cookedBacon.getUnlocalizedName());
		rawBacon = new FoodBacon();
		GameRegistry.registerItem(rawBacon, rawBacon.getUnlocalizedName());
	}

	private static void registerShapedRecipes() {
		//tool recipes (vanilla crafting recipe)
		GameRegistry.addRecipe(new ItemStack(flowwrench), "L L", " I ", " L ", 'L', new ItemStack(metaResourceIngot, 1, 2), 'I', new ItemStack(metaResourceGear, 1, 18));
		GameRegistry.addRecipe(new ItemStack(enderSword), " E ", " E ", " S ", 'E', new ItemStack(metaResourceIngot, 1, 4), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(electrumSword), " E ", " E ", " S ", 'E', new ItemStack(metaResourceIngot, 1, 7), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(enderPick), "EEE", " S ", " S ", 'E', new ItemStack(metaResourceIngot, 1, 4), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(electrumPick), "EEE", " S ", " S ", 'E', new ItemStack(metaResourceIngot, 1, 7), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(enderAxe), "EE ", "ES ", " S ", 'E', new ItemStack(metaResourceIngot, 1, 4), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(electrumAxe), "EE ", "ES ", " S ", 'E', new ItemStack(metaResourceIngot, 1, 7), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(enderShovel), " E ", " S ", " S ", 'E', new ItemStack(metaResourceIngot, 1, 4), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(electrumShovel), " E ", " S ", " S ", 'E', new ItemStack(metaResourceIngot, 1, 7), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(enderHoe), "EE ", " S ", " S ", 'E', new ItemStack(metaResourceIngot, 1, 4), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(electrumHoe), "EE ", " S ", " S ", 'E', new ItemStack(metaResourceIngot, 1, 7), 'S', Items.stick);

		//gear recipes (vanilla crafting recipe)
		GameRegistry.addRecipe(new ItemStack(metaResourceGear, 1, 0), " S ", "SSS", " S ", 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(metaResourceGear, 1, 1), " S ", "SGS", " S ", 'S', Blocks.stone, 'G', new ItemStack(metaResourceGear, 1, 0));
		GameRegistry.addRecipe(new ItemStack(metaResourceGear, 1, 2), " I ", "IGI", " I ", 'I', Items.iron_ingot, 'G', new ItemStack(metaResourceGear, 1, 0));
		GameRegistry.addRecipe(new ItemStack(metaResourceGear, 1, 3), " C ", "CGC", " C ", 'C', new ItemStack(metaResourceIngot, 1, 0), 'G', new ItemStack(metaResourceGear, 1, 0));
		GameRegistry.addRecipe(new ItemStack(metaResourceGear, 1, 4), " T ", "TGT", " T ", 'T', new ItemStack(metaResourceIngot, 1, 1), 'G', new ItemStack(metaResourceGear, 1, 0));
		GameRegistry.addRecipe(new ItemStack(metaResourceGear, 1, 5), " L ", "LGL", " L ", 'L', new ItemStack(metaResourceIngot, 1, 2), 'G', new ItemStack(metaResourceGear, 1, 0));
		GameRegistry.addRecipe(new ItemStack(metaResourceGear, 1, 6), " S ", "SGS", " S ", 'S', new ItemStack(metaResourceIngot, 1, 3), 'G', new ItemStack(metaResourceGear, 1, 0));
	}

	private static void registerShapelessRecipes() {
		//ender dust recipe
		GameRegistry.addShapelessRecipe(new ItemStack(metaResourceDust, 1, 8), new ItemStack(metaResourceDust, 1, 7), new ItemStack(metaResourceDust, 1, 7));
	}

	private static void registerSmeltingRecipes() {
		//Block to ingot smelting recipes (vanilla furnace)
		GameRegistry.addSmelting(BlockRegistry.copperOre, new ItemStack(metaResourceIngot, 1, 0), 0.7F);
		GameRegistry.addSmelting(BlockRegistry.tinOre, new ItemStack(metaResourceIngot, 1, 1), 0.7F);
		GameRegistry.addSmelting(BlockRegistry.leadOre, new ItemStack(metaResourceIngot, 1, 2), 1.0F);
		GameRegistry.addSmelting(BlockRegistry.silverOre, new ItemStack(metaResourceIngot, 1, 3), 1.0F);

		//Dust to ingot smelting recipes (vanilla furnace)
		GameRegistry.addSmelting(new ItemStack(metaResourceDust, 1, 1), new ItemStack(Items.iron_ingot), 0.35F);
		GameRegistry.addSmelting(new ItemStack(metaResourceDust, 1, 2), new ItemStack(Items.gold_ingot), 0.5F);
		GameRegistry.addSmelting(new ItemStack(metaResourceDust, 1, 3), new ItemStack(metaResourceIngot, 1, 0), 0.35F);
		GameRegistry.addSmelting(new ItemStack(metaResourceDust, 1, 4), new ItemStack(metaResourceIngot, 1, 1), 0.35F);
		GameRegistry.addSmelting(new ItemStack(metaResourceDust, 1, 5), new ItemStack(metaResourceIngot, 1, 2), 0.5F);
		GameRegistry.addSmelting(new ItemStack(metaResourceDust, 1, 6), new ItemStack(metaResourceIngot, 1, 3), 0.5F);
		GameRegistry.addSmelting(new ItemStack(metaResourceDust, 1, 7), new ItemStack(metaResourceIngot, 1, 4), 1.0F);

		//raw to cooked smelting recipes (vanilla furnace)
		GameRegistry.addSmelting(rawBacon, new ItemStack(cookedBacon), 0.35F);
	}

	private static void registerOreDict() {
		//dusts
		OreDictionary.registerOre("dustCopper", new ItemStack(metaResourceDust, 1, 3));
		OreDictionary.registerOre("dustTin", new ItemStack(metaResourceDust, 1, 4));
		OreDictionary.registerOre("dustLead", new ItemStack(metaResourceDust, 1, 5));
		OreDictionary.registerOre("dustSilver", new ItemStack(metaResourceDust, 1, 6));

		//ingots
		OreDictionary.registerOre("ingotCopper", new ItemStack(metaResourceIngot, 1, 0));
		OreDictionary.registerOre("ingotTin", new ItemStack(metaResourceIngot, 1, 1));
		OreDictionary.registerOre("ingotLead", new ItemStack(metaResourceIngot, 1, 2));
		OreDictionary.registerOre("ingotSilver", new ItemStack(metaResourceIngot, 1, 3));
		OreDictionary.registerOre("ingotEnderium", new ItemStack(metaResourceIngot, 1, 4));

		//gears
		OreDictionary.registerOre("gearWood", new ItemStack(metaResourceGear, 1, 0));
		OreDictionary.registerOre("gearStone", new ItemStack(metaResourceGear, 1, 1));
		OreDictionary.registerOre("gearIron", new ItemStack(metaResourceGear, 1, 2));
		OreDictionary.registerOre("gearGold", new ItemStack(metaResourceGear, 1, 3));
		OreDictionary.registerOre("gearQuartz", new ItemStack(metaResourceGear, 1, 4));
		OreDictionary.registerOre("gearDiamond", new ItemStack(metaResourceGear, 1, 5));
		OreDictionary.registerOre("gearCopper", new ItemStack(metaResourceGear, 1, 6));
		OreDictionary.registerOre("gearTin", new ItemStack(metaResourceGear, 1, 7));
		OreDictionary.registerOre("gearLead", new ItemStack(metaResourceGear, 1, 8));
		OreDictionary.registerOre("gearSilver", new ItemStack(metaResourceGear, 1, 9));
	}

	private static void registerTumblerRecipes() {
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(Items.coal), new ItemStack(metaResourceDust, 1, 0), 200);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(Blocks.iron_ore), new ItemStack(metaResourceDust, 2, 1), 200);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(Blocks.gold_ore), new ItemStack(metaResourceDust, 2, 2), 200);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(BlockRegistry.copperOre), new ItemStack(metaResourceDust, 2, 3), 200);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(BlockRegistry.tinOre), new ItemStack(metaResourceDust, 2, 4), 200);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(BlockRegistry.leadOre), new ItemStack(metaResourceDust, 2, 5), 200);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(BlockRegistry.silverOre), new ItemStack(metaResourceDust, 2, 6), 200);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(Items.ender_pearl), new ItemStack(metaResourceDust, 1, 7), 300);
	}

	private static void registerMixerRecipes() {
		RecipesMetalMixer.AddRecipe(new ItemStack(Items.iron_ingot), new ItemStack(metaResourceIngot, 1, 5), new ItemStack(metaResourceIngot, 3, 6), 300);
		RecipesMetalMixer.AddRecipe(new ItemStack(Items.gold_ingot), new ItemStack(metaResourceIngot, 2, 3), new ItemStack(metaResourceIngot, 2, 7), 300);
	}

	public static void registerFullBlocks() {
		registerItems();
		registerSmeltingRecipes();
		registerShapedRecipes();
		registerShapelessRecipes();
		registerOreDict();
		registerTumblerRecipes();
		registerMixerRecipes();
	}
}
