package main.flowstoneenergy.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.items.ItemRegistry;
import main.flowstoneenergy.tileentities.recipes.RecipesMachineWorkbench;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class BlockRecipeRegistry {

    private static void registerBlockRecipes() {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.machineBox), new Object[]{"XXX", "X X", "XXX", 'X', "ingotCopper"}));
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.machines, 1, 5), "GCG", "CMC", "GCG", 'G', new ItemStack(ItemRegistry.metaResourceGear, 1, 1), 'C', Blocks.crafting_table, 'M', new ItemStack(BlockRegistry.machineBox));
    }

    private static void registerStorageRecipes() {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 0), new Object[]{"XXX", "XXX", "XXX", 'X', "ingotCopper"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 1), new Object[]{"XXX", "X X", "XXX", 'X', "ingotTin"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 2), new Object[]{"XXX", "X X", "XXX", 'X', "ingotLead"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 3), new Object[]{"XXX", "X X", "XXX", 'X', "ingotSilver"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 4), new Object[]{"XXX", "X X", "XXX", 'X', "ingotEnderium"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 5), new Object[]{"XXX", "X X", "XXX", 'X', "ingotNickel"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 6), new Object[]{"XXX", "X X", "XXX", 'X', "ingotInvar"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 7), new Object[]{"XXX", "X X", "XXX", 'X', "ingotElectrum"}));
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
