package main.flowstoneenergy.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.items.ItemRegistry;
import main.flowstoneenergy.tileentities.recipes.RecipesMachineWorkbench;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class BlockRecipeRegistry {

    private static void registerBlockRecipes() {
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.machineBox), "III", "I I", "III", 'I', new ItemStack(ItemRegistry.metaResourceIngot, 1, 0));
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.machines, 1, 5), "GCG", "CMC", "GCG", 'G', new ItemStack(ItemRegistry.metaResourceGear, 1, 1), 'C', Blocks.crafting_table, 'M', new ItemStack(BlockRegistry.machineBox));
    }

    private static void registerStorageRecipes() {
        GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 0), "III", "III", "III", 'I', new ItemStack(ItemRegistry.metaResourceIngot, 1, 0));
        GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 1), "III", "III", "III", 'I', new ItemStack(ItemRegistry.metaResourceIngot, 1, 1));
        GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 2), "III", "III", "III", 'I', new ItemStack(ItemRegistry.metaResourceIngot, 1, 2));
        GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 3), "III", "III", "III", 'I', new ItemStack(ItemRegistry.metaResourceIngot, 1, 3));
        GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 4), "III", "III", "III", 'I', new ItemStack(ItemRegistry.metaResourceIngot, 1, 4));
        GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 5), "III", "III", "III", 'I', new ItemStack(ItemRegistry.metaResourceIngot, 1, 5));
        GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 6), "III", "III", "III", 'I', new ItemStack(ItemRegistry.metaResourceIngot, 1, 6));
        GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 7), "III", "III", "III", 'I', new ItemStack(ItemRegistry.metaResourceIngot, 1, 7));
    }

    private static void registerWorkbenchRecipes() {
        RecipesMachineWorkbench.addRecipe(new ItemStack(BlockRegistry.machineBox), new ItemStack(ItemRegistry.metaResourceGear, 1, 2), new ItemStack(ItemRegistry.metaResourceGear, 1, 2), new ItemStack(BlockRegistry.machines, 1, 3), 200);
        RecipesMachineWorkbench.addRecipe(new ItemStack(BlockRegistry.machineBox), new ItemStack(ItemRegistry.metaResourceGear, 1, 1), new ItemStack(ItemRegistry.metaResourceGear, 1, 2), new ItemStack(BlockRegistry.machines, 1, 2), 200);
        RecipesMachineWorkbench.addRecipe(new ItemStack(BlockRegistry.machineBox), new ItemStack(ItemRegistry.metaResourceGear, 1, 2), new ItemStack(ItemRegistry.metaResourceGear, 1, 3), new ItemStack(BlockRegistry.machines, 1, 0), 200);
        RecipesMachineWorkbench.addRecipe(new ItemStack(BlockRegistry.machineBox), new ItemStack(ItemRegistry.metaResourceGear, 1, 4), new ItemStack(ItemRegistry.metaResourceGear, 1, 3), new ItemStack(BlockRegistry.machines, 1, 1), 200);
        RecipesMachineWorkbench.addRecipe(new ItemStack(BlockRegistry.machineBox), new ItemStack(ItemRegistry.metaResourceGear, 1, 13), new ItemStack(ItemRegistry.metaResourceGear, 1, 13), new ItemStack(BlockRegistry.machines, 1, 4), 200);
    }

    public static void registerFullRecipes() {
        registerBlockRecipes();
        registerWorkbenchRecipes();
        registerStorageRecipes();
    }
}
