package main.flowstoneenergy.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.tileentities.recipes.RecipesLumberMill;
import main.flowstoneenergy.tileentities.recipes.RecipesMachineWorkbench;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class BlockRecipeRegistry {

    private static void registerBlockRecipes() {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.machineBox, 1, 0), new Object[]{"XXX", "X X", "XXX", 'X', "ingotCopper"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.machineWorkbench), new Object[]{"XYX", "YZY", "XYX", 'X', "gearStone", 'Y', Blocks.crafting_table, 'Z', "machineBasic"}));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockRegistry.aplite, 1, 1), new ItemStack(BlockRegistry.aplite, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockRegistry.aplite, 1, 2), new ItemStack(BlockRegistry.aplite, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockRegistry.aplite, 1, 3), new ItemStack(BlockRegistry.aplite, 1, 4));
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.aplite, 1, 1), new ItemStack(BlockRegistry.aplite, 1, 0), 0.1F);
    }

    private static void registerStorageRecipes() {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 0), new Object[]{"XXX", "XXX", "XXX", 'X', "ingotCopper"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 1), new Object[]{"XXX", "XXX", "XXX", 'X', "ingotTin"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 2), new Object[]{"XXX", "XXX", "XXX", 'X', "ingotLead"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 3), new Object[]{"XXX", "XXX", "XXX", 'X', "ingotSilver"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 4), new Object[]{"XXX", "XXX", "XXX", 'X', "ingotEnderium"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 5), new Object[]{"XXX", "XXX", "XXX", 'X', "ingotNickel"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 6), new Object[]{"XXX", "XXX", "XXX", 'X', "ingotInvar"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.ingotStorage, 1, 7), new Object[]{"XXX", "XXX", "XXX", 'X', "ingotElectrum"}));
    }

    private static void registerWorkbenchRecipes() {
        RecipesMachineWorkbench.addOreDictRecipe("machineBasic", "gearIron", "gearGold", new ItemStack(BlockRegistry.machines, 1, 0), 200);
        RecipesMachineWorkbench.addOreDictRecipe("machineBasic", "gearGold", "gearQuartz", new ItemStack(BlockRegistry.machines, 1, 1), 200);
        RecipesMachineWorkbench.addOreDictRecipe("machineBasic", "gearStone", "gearIron", new ItemStack(BlockRegistry.machines, 1, 2), 200);
        RecipesMachineWorkbench.addOreDictRecipe("machineBasic", "gearIron", "gearIron", new ItemStack(BlockRegistry.machines, 1, 3), 200);
        RecipesMachineWorkbench.addOreDictRecipe("machineBasic", "gearLead", "gearNickel", new ItemStack(BlockRegistry.machines, 1, 4), 200);
        RecipesMachineWorkbench.addOreDictRecipe("machineBasic", "gearQuartz", "gearDiamond", new ItemStack(BlockRegistry.machines, 1, 6), 200);
        RecipesMachineWorkbench.addOreDictRecipe("machineBasic", "gearDiamond", "gearQuartz", new ItemStack(BlockRegistry.machines, 1, 7), 200);
        RecipesMachineWorkbench.addOreDictRecipe("machineBasic", "gearIron", "tableCrafting", new ItemStack(BlockRegistry.machines, 1, 8), 200);
    }

    private static void registerLumberMillRecipes() {
        RecipesLumberMill.addOreDictRecipe("logWood", new ItemStack(Blocks.planks, 6, 0), 200);
    }

    public static void registerFullRecipes() {
        registerBlockRecipes();
        registerWorkbenchRecipes();
        registerStorageRecipes();
        registerLumberMillRecipes();
    }
}