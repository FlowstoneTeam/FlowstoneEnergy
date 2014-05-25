package main.flowstoneenergy.items;

import main.flowstoneenergy.items.battery.ItemBatteryFlowstoneTierFive;
import main.flowstoneenergy.items.battery.ItemBatteryFlowstoneTierFour;
import main.flowstoneenergy.items.battery.ItemBatteryFlowstoneTierOne;
import main.flowstoneenergy.items.battery.ItemBatteryFlowstoneTierThree;
import main.flowstoneenergy.items.battery.ItemBatteryFlowstoneTierTwo;
import main.flowstoneenergy.items.food.FoodBacon;
import main.flowstoneenergy.items.food.FoodCookedBacon;
import main.flowstoneenergy.items.food.FoodTea;
import main.flowstoneenergy.items.food.ItemMetaResourceUtensil;
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
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
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
	public static Item tea;
	
	//utensils
	public static Item metaResourceUtensil;
	
	//random shit
	public static Item spawnEgg;

	public static void registerItems() {
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
		tea = new FoodTea();
		GameRegistry.registerItem(tea, tea.getUnlocalizedName());
		
		//utensils
		metaResourceUtensil = new ItemMetaResourceUtensil().setUnlocalizedName("itemMetadataResourceUtensil");
		GameRegistry.registerItem(metaResourceUtensil, "ItemMetadataResourceUtensil");
		
		//random shit
		spawnEgg = new ItemSpawnEggRobot();
		GameRegistry.registerItem(spawnEgg, spawnEgg.getUnlocalizedName());
	}
}
