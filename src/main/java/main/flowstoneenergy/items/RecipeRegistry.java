package main.flowstoneenergy.items;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.tileentities.recipes.RecipesEnergizedOreTumbler;
import main.flowstoneenergy.tileentities.recipes.RecipesMetalMixer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeRegistry {

	private static void registerShapedRecipes() {
		//tool recipes (vanilla crafting recipe)
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.flowwrench), "L L", " I ", " L ", 'L', new ItemStack(ItemRegistry.metaResourceIngot, 1, 2), 'I', new ItemStack(ItemRegistry.metaResourceGear, 1, 1));
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.enderSword), " E ", " E ", " S ", 'E', new ItemStack(ItemRegistry.metaResourceIngot, 1, 4), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.electrumSword), " E ", " E ", " S ", 'E', new ItemStack(ItemRegistry.metaResourceIngot, 1, 7), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.enderPick), "EEE", " S ", " S ", 'E', new ItemStack(ItemRegistry.metaResourceIngot, 1, 4), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.electrumPick), "EEE", " S ", " S ", 'E', new ItemStack(ItemRegistry.metaResourceIngot, 1, 7), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.enderAxe), "EE ", "ES ", " S ", 'E', new ItemStack(ItemRegistry.metaResourceIngot, 1, 4), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.electrumAxe), "EE ", "ES ", " S ", 'E', new ItemStack(ItemRegistry.metaResourceIngot, 1, 7), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.enderShovel), " E ", " S ", " S ", 'E', new ItemStack(ItemRegistry.metaResourceIngot, 1, 4), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.electrumShovel), " E ", " S ", " S ", 'E', new ItemStack(ItemRegistry.metaResourceIngot, 1, 7), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.enderHoe), "EE ", " S ", " S ", 'E', new ItemStack(ItemRegistry.metaResourceIngot, 1, 4), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.electrumHoe), "EE ", " S ", " S ", 'E', new ItemStack(ItemRegistry.metaResourceIngot, 1, 7), 'S', Items.stick);

		//gear recipes (vanilla crafting recipe)
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 0), " S ", "SSS", " S ", 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 1), " S ", "SGS", " S ", 'S', Blocks.stone, 'G', new ItemStack(ItemRegistry.metaResourceGear, 1, 0));
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 2), " I ", "IGI", " I ", 'I', Items.iron_ingot, 'G', new ItemStack(ItemRegistry.metaResourceGear, 1, 0));
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 3), " C ", "CGC", " C ", 'C', new ItemStack(ItemRegistry.metaResourceIngot, 1, 0), 'G', new ItemStack(ItemRegistry.metaResourceGear, 1, 0));
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 4), " T ", "TGT", " T ", 'T', new ItemStack(ItemRegistry.metaResourceIngot, 1, 1), 'G', new ItemStack(ItemRegistry.metaResourceGear, 1, 0));
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 5), " L ", "LGL", " L ", 'L', new ItemStack(ItemRegistry.metaResourceIngot, 1, 2), 'G', new ItemStack(ItemRegistry.metaResourceGear, 1, 0));
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 6), " S ", "SGS", " S ", 'S', new ItemStack(ItemRegistry.metaResourceIngot, 1, 3), 'G', new ItemStack(ItemRegistry.metaResourceGear, 1, 0));
	}

	private static void registerShapelessRecipes() {
		//ender dust recipe
		GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.metaResourceDust, 1, 8), new ItemStack(ItemRegistry.metaResourceDust, 1, 7), new ItemStack(ItemRegistry.metaResourceDust, 1, 7));
	}

	private static void registerSmeltingRecipes() {
		//Block to ingot smelting recipes (vanilla furnace)
		GameRegistry.addSmelting(BlockRegistry.copperOre, new ItemStack(ItemRegistry.metaResourceIngot, 1, 0), 0.7F);
		GameRegistry.addSmelting(BlockRegistry.tinOre, new ItemStack(ItemRegistry.metaResourceIngot, 1, 1), 0.7F);
		GameRegistry.addSmelting(BlockRegistry.leadOre, new ItemStack(ItemRegistry.metaResourceIngot, 1, 2), 1.0F);
		GameRegistry.addSmelting(BlockRegistry.silverOre, new ItemStack(ItemRegistry.metaResourceIngot, 1, 3), 1.0F);

		//Dust to ingot smelting recipes (vanilla furnace)
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 1), new ItemStack(Items.iron_ingot), 0.35F);
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 2), new ItemStack(Items.gold_ingot), 0.5F);
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 3), new ItemStack(ItemRegistry.metaResourceIngot, 1, 0), 0.35F);
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 4), new ItemStack(ItemRegistry.metaResourceIngot, 1, 1), 0.35F);
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 5), new ItemStack(ItemRegistry.metaResourceIngot, 1, 2), 0.5F);
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 6), new ItemStack(ItemRegistry.metaResourceIngot, 1, 3), 0.5F);
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 7), new ItemStack(ItemRegistry.metaResourceIngot, 1, 4), 1.0F);


		//raw to cooked smelting recipes (vanilla furnace)
		GameRegistry.addSmelting(ItemRegistry.rawBacon, new ItemStack(ItemRegistry.cookedBacon), 0.35F);
	}

	private static void registerTumblerRecipes() {
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(Items.coal), new ItemStack(ItemRegistry.metaResourceDust, 1, 0), 200);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(Blocks.iron_ore), new ItemStack(ItemRegistry.metaResourceDust, 2, 1), 200);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(Blocks.gold_ore), new ItemStack(ItemRegistry.metaResourceDust, 2, 2), 200);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(BlockRegistry.copperOre), new ItemStack(ItemRegistry.metaResourceDust, 2, 3), 200);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(BlockRegistry.tinOre), new ItemStack(ItemRegistry.metaResourceDust, 2, 4), 200);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(BlockRegistry.leadOre), new ItemStack(ItemRegistry.metaResourceDust, 2, 5), 200);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(BlockRegistry.silverOre), new ItemStack(ItemRegistry.metaResourceDust, 2, 6), 200);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(Items.ender_pearl), new ItemStack(ItemRegistry.metaResourceDust, 1, 7), 300);
		RecipesEnergizedOreTumbler.AddRecipe(new ItemStack(BlockRegistry.nickelOre), new ItemStack(ItemRegistry.metaResourceDust, 2, 9), 200);
	}

	private static void registerMixerRecipes() {
		RecipesMetalMixer.AddRecipe(new ItemStack(Items.iron_ingot), new ItemStack(ItemRegistry.metaResourceIngot, 1, 5), new ItemStack(ItemRegistry.metaResourceIngot, 3, 6), 300);
		RecipesMetalMixer.AddRecipe(new ItemStack(Items.gold_ingot), new ItemStack(ItemRegistry.metaResourceIngot, 2, 3), new ItemStack(ItemRegistry.metaResourceIngot, 2, 7), 300);
	}

	public static void registerRecipes() {
		registerSmeltingRecipes();
		registerShapedRecipes();
		registerShapelessRecipes();
		registerTumblerRecipes();
		registerMixerRecipes();
	}

}
