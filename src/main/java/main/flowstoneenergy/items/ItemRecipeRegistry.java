package main.flowstoneenergy.items;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.tileentities.recipes.RecipesEnergizedOreTumbler;
import main.flowstoneenergy.tileentities.recipes.RecipesMetalMixer;
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

        //gear recipes (vanilla crafting recipe)
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 0), new Object[]{" X ", "XXX", " X ", 'X', "stickWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 1), new Object[]{" X ", "XYX", " X ", 'X', "blockStone", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 2), new Object[]{" X ", "XYX", " X ", 'X', "ingotIron", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 3), new Object[]{" X ", "XYX", " X ", 'X', "ingotGold", 'Y', "gearWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.metaResourceGear, 1, 4), new Object[]{" X ", "XYX", " X ", 'X', "quartzNether", 'Y', "gearWood"}));
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
//        GameRegistry.addRecipe(new ItemStack(ItemRegistry.metaResourceUtensil, 1, 0), " C ", " S ", "   ", 'C', new ItemStack(ItemRegistry.metaResourceUtensil, 1, 4), 'S', new ItemStack(ItemRegistry.metaResourceUtensil, 1, 3));
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
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOres, 1, 0), new ItemStack(ItemRegistry.metaResourceIngot, 1, 0), 0.7F);
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOres, 1, 1), new ItemStack(ItemRegistry.metaResourceIngot, 1, 1), 0.7F);
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOres, 1, 2), new ItemStack(ItemRegistry.metaResourceIngot, 1, 2), 1.0F);
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOres, 1, 3), new ItemStack(ItemRegistry.metaResourceIngot, 1, 3), 1.0F);

        //Dust to ingot smelting recipes (vanilla furnace)
        GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 1), new ItemStack(Items.iron_ingot), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 2), new ItemStack(Items.gold_ingot), 0.5F);
        GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 3), new ItemStack(ItemRegistry.metaResourceIngot, 1, 0), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 4), new ItemStack(ItemRegistry.metaResourceIngot, 1, 1), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 5), new ItemStack(ItemRegistry.metaResourceIngot, 1, 2), 0.5F);
        GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 6), new ItemStack(ItemRegistry.metaResourceIngot, 1, 3), 0.5F);
        GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 8), new ItemStack(ItemRegistry.metaResourceIngot, 1, 4), 1.0F);
        GameRegistry.addSmelting(new ItemStack(ItemRegistry.metaResourceDust, 1, 9), new ItemStack(ItemRegistry.metaResourceIngot, 1, 5), 0.5F);

        //raw to cooked smelting recipes (vanilla furnace)
        GameRegistry.addSmelting(ItemRegistry.rawBacon, new ItemStack(ItemRegistry.cookedBacon), 0.35F);
    }

    private static void registerTumblerRecipes() {
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(Items.coal), new ItemStack(ItemRegistry.metaResourceDust, 1, 0), 200);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(Blocks.iron_ore), new ItemStack(ItemRegistry.metaResourceDust, 2, 1), 200);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(Blocks.gold_ore), new ItemStack(ItemRegistry.metaResourceDust, 2, 2), 200);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(BlockRegistry.blockOres, 1, 0), new ItemStack(ItemRegistry.metaResourceDust, 2, 3), 200);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(BlockRegistry.blockOres, 1, 1), new ItemStack(ItemRegistry.metaResourceDust, 2, 4), 200);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(BlockRegistry.blockOres, 1, 2), new ItemStack(ItemRegistry.metaResourceDust, 2, 5), 200);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(BlockRegistry.blockOres, 1, 3), new ItemStack(ItemRegistry.metaResourceDust, 2, 6), 200);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(BlockRegistry.blockOres, 1, 4), new ItemStack(ItemRegistry.metaResourceDust, 2, 9), 200);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(Items.ender_pearl), new ItemStack(ItemRegistry.metaResourceDust, 1, 7), 300);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(Items.porkchop), new ItemStack(ItemRegistry.rawBacon), 200);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(Items.cooked_porkchop), new ItemStack(ItemRegistry.cookedBacon), 200);

        //Ingot to dust
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(ItemRegistry.metaResourceIngot, 1, 0), new ItemStack(ItemRegistry.metaResourceDust, 1, 3), 100);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(ItemRegistry.metaResourceIngot, 1, 1), new ItemStack(ItemRegistry.metaResourceDust, 1, 4), 100);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(ItemRegistry.metaResourceIngot, 1, 2), new ItemStack(ItemRegistry.metaResourceDust, 1, 5), 100);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(ItemRegistry.metaResourceIngot, 1, 3), new ItemStack(ItemRegistry.metaResourceDust, 1, 6), 100);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(ItemRegistry.metaResourceIngot, 1, 4), new ItemStack(ItemRegistry.metaResourceDust, 1, 8), 100);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(ItemRegistry.metaResourceIngot, 1, 5), new ItemStack(ItemRegistry.metaResourceDust, 1, 9), 100);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(ItemRegistry.metaResourceIngot, 1, 6), new ItemStack(ItemRegistry.metaResourceDust, 1, 10), 100);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(ItemRegistry.metaResourceIngot, 1, 7), new ItemStack(ItemRegistry.metaResourceDust, 1, 11), 100);

        //Other things
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(Blocks.stone), new ItemStack(Blocks.cobblestone), 150);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(Blocks.glass), new ItemStack(Blocks.sand), 150);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.sand), 150);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(Blocks.sand), new ItemStack(Blocks.gravel), 150);
        RecipesEnergizedOreTumbler.addRecipe(new ItemStack(Blocks.gravel), new ItemStack(Items.flint), 200);
    }

    private static void registerMixerRecipes() {
        RecipesMetalMixer.addRecipe(new ItemStack(Items.iron_ingot), new ItemStack(ItemRegistry.metaResourceIngot, 1, 5), new ItemStack(ItemRegistry.metaResourceIngot, 3, 6), 300);
        RecipesMetalMixer.addRecipe(new ItemStack(Items.gold_ingot), new ItemStack(ItemRegistry.metaResourceIngot, 2, 3), new ItemStack(ItemRegistry.metaResourceIngot, 2, 7), 300);
    }

    public static void registerFullRecipes() {
        registerSmeltingRecipes();
        registerShapedRecipes();
        registerReverseStorageRecipes();
        registerShapelessRecipes();
        registerTumblerRecipes();
        registerMixerRecipes();
    }

}