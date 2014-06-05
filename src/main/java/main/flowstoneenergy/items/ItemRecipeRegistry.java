package main.flowstoneenergy.items;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.tileentities.recipes.RecipesEnergizedOreTumbler;
import main.flowstoneenergy.tileentities.recipes.RecipesMachineWorkbench;
import main.flowstoneenergy.utils.OreDictHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemRecipeRegistry {

    private static void registerShapedRecipes() {
        //tool recipes (vanilla crafting recipe)
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.flowwrench), new Object[]{"X X", " Y ", " X ", 'X', "ingotLead", 'Y', "gearStone"}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.enderSword), new Object[]{" X ", " X ", " Y ", 'X', "ingotEnderium", 'Y', "stickWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.enderPick), new Object[]{"XXX", " Y ", " Y ", 'X', "ingotEnderium", 'Y', "stickWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.enderShovel), new Object[]{" X ", " Y ", " Y ", 'X', "ingotEnderium", 'Y', "stickWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.enderAxe), new Object[]{"XX ", "XY ", " Y ", 'X', "ingotEnderium", 'Y', "stickWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.enderHoe), new Object[]{"XX ", " Y ", " Y ", 'X', "ingotEnderium", 'Y', "stickWood"}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.electrumSword), new Object[]{" X ", " X ", " Y ", 'X', "ingotElectrum", 'Y', "stickWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.electrumPick), new Object[]{"XXX", " Y ", " Y ", 'X', "ingotElectrum", 'Y', "stickWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.electrumShovel), new Object[]{" X ", " Y ", " Y ", 'X', "ingotElectrum", 'Y', "stickWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.electrumAxe), new Object[]{"XX ", "XY ", " Y ", 'X', "ingotElectrum", 'Y', "stickWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.electrumHoe), new Object[]{"XX ", " Y ", " Y ", 'X', "ingotElectrum", 'Y', "stickWood"}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.tierOne), new Object[]{" R ", "RIR", "ICI", 'R', Items.redstone, 'I', "ingotIron", 'C', "ingotCopper"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.tierTwo), new Object[]{" R ", "LBL", "LRL", 'R', Items.redstone, 'L', "ingotLead", 'B', ItemRegistry.tierOne}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.tierThree), new Object[]{" R ", "IBI", "IRI", 'R', Items.redstone, 'I', "ingotInvar", 'B', ItemRegistry.tierTwo}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.tierFour), new Object[]{" R ", "EBE", "ERE", 'R', Items.redstone, 'E', "ingotElectrum", 'B', ItemRegistry.tierThree}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.tierFive), new Object[]{" R ", "EBE", "ERE", 'R', Items.redstone, 'I', "ingotEnderium", 'B', ItemRegistry.tierFour}));

        //gear recipes (vanilla crafting recipe)
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 0), new Object[]{" X ", "XXX", " X ", 'X', "stickWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 1), new Object[]{" X ", "XYX", " X ", 'X', "stone", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 2), new Object[]{" X ", "XYX", " X ", 'X', "ingotIron", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 3), new Object[]{" X ", "XYX", " X ", 'X', "ingotGold", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 4), new Object[]{" X ", "XYX", " X ", 'X', "gemQuartz", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 5), new Object[]{" X ", "XYX", " X ", 'X', "gemDiamond", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 6), new Object[]{" X ", "XYX", " X ", 'X', "ingotCopper", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 7), new Object[]{" X ", "XYX", " X ", 'X', "ingotTin", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 8), new Object[]{" X ", "XYX", " X ", 'X', "ingotLead", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 9), new Object[]{" X ", "XYX", " X ", 'X', "ingotSilver", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 10), new Object[]{" X ", "XYX", " X ", 'X', "ingotEnderium", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 11), new Object[]{" X ", "XYX", " X ", 'X', "ingotElectrum", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 12), new Object[]{" X ", "XYX", " X ", 'X', "ingotNickel", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 0), new Object[]{" X ", "XYX", " X ", 'X', "ingotInvar", 'Y', "gearWood"}));

        //food recipes
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.metaResourceUtensil, 1, 4), "C C", " C ", "   ", 'C', Items.clay_ball);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.metaResourceUtensil, 1, 3), "   ", "   ", "CCC", 'C', Items.clay_ball);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.metaResourceUtensil, 1, 1), " S ", "S S", "  C", 'S', Items.string, 'C', new ItemStack(Items.dye, 1, 3));
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.metaResourceUtensil, 1, 2), " I ", " I ", " I ", 'I', Items.iron_ingot);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.tea), " S ", " U ", "MCT", 'S', new ItemStack(ItemRegistry.metaResourceUtensil, 1, 2), 'U', Items.sugar, 'M', Items.milk_bucket, 'C', new ItemStack(ItemRegistry.metaResourceUtensil, 1, 0), 'T', new ItemStack(ItemRegistry.metaResourceUtensil, 1, 1));
    }

    private static void registerShapelessRecipes() {
        //ender dust recipe
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.metaResourceDust, 1, 8), new ItemStack(ItemRegistry.metaResourceDust, 1, 7), new ItemStack(ItemRegistry.metaResourceDust, 1, 7));

        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.metaResourceUtensil, 1, 0), new ItemStack(ItemRegistry.metaResourceUtensil, 1, 4), new ItemStack(ItemRegistry.metaResourceUtensil, 1, 3));
    }

    private static void registerReverseStorageRecipes() {
        for (int i = 0; i <= 8; i++) {
            GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.metaResourceIngot, 9, i), new ItemStack(BlockRegistry.ingotStorage, 1, i));
        }
    }

    private static void registerSmeltingRecipes() {
        //Block to ingot smelting recipes (vanilla furnace)
        OreDictHandler.furnaceOreDictRecipes("oreCopper", new ItemStack(ItemRegistry.metaResourceIngot, 1, 0), 0.7F);
        OreDictHandler.furnaceOreDictRecipes("oreTin", new ItemStack(ItemRegistry.metaResourceIngot, 1, 1), 0.7F);
        OreDictHandler.furnaceOreDictRecipes("oreLead", new ItemStack(ItemRegistry.metaResourceIngot, 1, 2), 1.0F);
        OreDictHandler.furnaceOreDictRecipes("oreSilver", new ItemStack(ItemRegistry.metaResourceIngot, 1, 3), 1.0F);
        OreDictHandler.furnaceOreDictRecipes("oreNickel", new ItemStack(ItemRegistry.metaResourceIngot, 1, 5), 1.0F);

        //Dust to ingot smelting recipes (vanilla furnace)
        OreDictHandler.furnaceOreDictRecipes("dustIron", new ItemStack(Items.iron_ingot), 0.35F);
        OreDictHandler.furnaceOreDictRecipes("dustGold", new ItemStack(Items.gold_ingot), 0.5F);
        OreDictHandler.furnaceOreDictRecipes("dustCopper", new ItemStack(ItemRegistry.metaResourceIngot, 1, 0), 0.35F);
        OreDictHandler.furnaceOreDictRecipes("dustTin", new ItemStack(ItemRegistry.metaResourceIngot, 1, 1), 0.35F);
        OreDictHandler.furnaceOreDictRecipes("dustLead", new ItemStack(ItemRegistry.metaResourceIngot, 1, 2), 0.5F);
        OreDictHandler.furnaceOreDictRecipes("dustSilver", new ItemStack(ItemRegistry.metaResourceIngot, 1, 3), 0.5F);
        OreDictHandler.furnaceOreDictRecipes("dustEnderium", new ItemStack(ItemRegistry.metaResourceIngot, 1, 4), 1.0F);
        OreDictHandler.furnaceOreDictRecipes("dustNickel", new ItemStack(ItemRegistry.metaResourceIngot, 1, 5), 0.5F);
        OreDictHandler.furnaceOreDictRecipes("dustInvar", new ItemStack(ItemRegistry.metaResourceIngot, 1, 6), 0.5F);
        OreDictHandler.furnaceOreDictRecipes("dustElectrum", new ItemStack(ItemRegistry.metaResourceIngot, 1, 7), 0.5F);

        //raw to cooked smelting recipes (vanilla furnace)
        GameRegistry.addSmelting(ItemRegistry.rawBacon, new ItemStack(ItemRegistry.cookedBacon), 0.35F);
    }

    private static void registerTumblerRecipes() {
        //Ores to dust
        OreDictHandler.tumblerOreDictRecipes("oreIron", new ItemStack(ItemRegistry.metaResourceDust, 2, 1), 200);
        OreDictHandler.tumblerOreDictRecipes("oreGold", new ItemStack(ItemRegistry.metaResourceDust, 2, 2), 200);
        OreDictHandler.tumblerOreDictRecipes("oreCopper", new ItemStack(ItemRegistry.metaResourceDust, 2, 3), 200);
        OreDictHandler.tumblerOreDictRecipes("oreTin", new ItemStack(ItemRegistry.metaResourceDust, 2, 4), 200);
        OreDictHandler.tumblerOreDictRecipes("oreLead", new ItemStack(ItemRegistry.metaResourceDust, 2, 5), 200);
        OreDictHandler.tumblerOreDictRecipes("oreSilver", new ItemStack(ItemRegistry.metaResourceDust, 2, 6), 200);
        OreDictHandler.tumblerOreDictRecipes("oreNickel", new ItemStack(ItemRegistry.metaResourceDust, 2, 9), 200);

        //Ingot to dust
        OreDictHandler.tumblerOreDictRecipes("gemCoal", new ItemStack(ItemRegistry.metaResourceDust, 1, 0), 200);
        OreDictHandler.tumblerOreDictRecipes("ingotIron", new ItemStack(ItemRegistry.metaResourceDust, 1, 1), 100);
        OreDictHandler.tumblerOreDictRecipes("ingotGold", new ItemStack(ItemRegistry.metaResourceDust, 1, 2), 100);
        OreDictHandler.tumblerOreDictRecipes("ingotCopper", new ItemStack(ItemRegistry.metaResourceDust, 1, 3), 100);
        OreDictHandler.tumblerOreDictRecipes("ingotTin", new ItemStack(ItemRegistry.metaResourceDust, 1, 4), 100);
        OreDictHandler.tumblerOreDictRecipes("ingotLead", new ItemStack(ItemRegistry.metaResourceDust, 1, 5), 100);
        OreDictHandler.tumblerOreDictRecipes("ingotSilver", new ItemStack(ItemRegistry.metaResourceDust, 1, 6), 100);
        OreDictHandler.tumblerOreDictRecipes("ingotEnderium", new ItemStack(ItemRegistry.metaResourceDust, 1, 8), 100);
        OreDictHandler.tumblerOreDictRecipes("ingotNickel", new ItemStack(ItemRegistry.metaResourceDust, 1, 9), 100);
        OreDictHandler.tumblerOreDictRecipes("ingotInvar", new ItemStack(ItemRegistry.metaResourceDust, 1, 10), 100);
        OreDictHandler.tumblerOreDictRecipes("ingotElectrum", new ItemStack(ItemRegistry.metaResourceDust, 1, 11), 100);

        //Other things
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(Items.ender_pearl), new ItemStack(ItemRegistry.metaResourceDust, 1, 7), 300);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(Items.porkchop), new ItemStack(ItemRegistry.rawBacon), 200);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(Items.cooked_porkchop), new ItemStack(ItemRegistry.cookedBacon), 200);
        OreDictHandler.tumblerOreDictRecipes("stone", new ItemStack(Blocks.cobblestone), 150);
        OreDictHandler.tumblerOreDictRecipes("glass", new ItemStack(Blocks.sand), 100);
        OreDictHandler.tumblerOreDictRecipes("cobblestone", new ItemStack(Blocks.sand), 150);
        OreDictHandler.tumblerOreDictRecipes("sand", new ItemStack(Blocks.gravel), 150);
        OreDictHandler.tumblerOreDictRecipes("gravel", new ItemStack(Items.flint), 200);
    }

    private static void registerMixerRecipes() {
        OreDictHandler.mixerOreDictRecipes("ingotIron", "ingotNickel", new ItemStack(ItemRegistry.metaResourceIngot, 2, 6), 300);
        OreDictHandler.mixerOreDictRecipes("dustIron", "dustNickel", new ItemStack(ItemRegistry.metaResourceDust, 2, 10), 200);
        OreDictHandler.mixerOreDictRecipes("ingotGold", "ingotSilver", new ItemStack(ItemRegistry.metaResourceIngot, 2, 7), 300);
        OreDictHandler.mixerOreDictRecipes("dustGold", "dustSilver", new ItemStack(ItemRegistry.metaResourceDust, 2, 11), 200);
        OreDictHandler.mixerOreDictRecipes("oreGold", "oreSilver", new ItemStack(ItemRegistry.metaResourceIngot, 4, 7), 300);
    }

    private static void registerWorkbenchRecipes() {
        RecipesMachineWorkbench.addRecipe(new ItemStack(ItemRegistry.flowwrench), new ItemStack(ItemRegistry.tierThree), new ItemStack(ItemRegistry.metaResourceGear, 1, 4), new ItemStack(ItemRegistry.pneumaticFlowwrench), 300);
    }

    public static void registerFullRecipes() {
        registerSmeltingRecipes();
        registerShapedRecipes();
        registerReverseStorageRecipes();
        registerShapelessRecipes();
        registerTumblerRecipes();
        registerMixerRecipes();
        registerWorkbenchRecipes();
    }
}