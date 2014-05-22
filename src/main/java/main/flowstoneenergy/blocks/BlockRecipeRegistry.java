package main.flowstoneenergy.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.items.ItemRegistry;
import main.flowstoneenergy.tileentities.recipes.RecipesMachineWorkbench;
import net.minecraft.item.ItemStack;

public class BlockRecipeRegistry {

	private static void registerBlockRecipes() {
		GameRegistry.addRecipe(new ItemStack(BlockRegistry.machineBox), "III", "I I", "III", 'I', new ItemStack(ItemRegistry.metaResourceIngot, 1, 6));
	}

	private static void registerWorkbenchRecipes() {
		RecipesMachineWorkbench.AddRecipe(new ItemStack(BlockRegistry.machineBox), new ItemStack(ItemRegistry.metaResourceGear, 1, 2), new ItemStack(ItemRegistry.metaResourceGear, 1, 2), new ItemStack(BlockRegistry.heatedOven), 200);
	}

	public static void registerBlockFullRecipes() {
		registerBlockRecipes();
		registerWorkbenchRecipes();
	}
}
