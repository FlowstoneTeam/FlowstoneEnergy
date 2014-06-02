package main.flowstoneenergy.utils;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.items.ItemRegistry;
import main.flowstoneenergy.tileentities.recipes.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class OreDictHandler {

    public static void registerOreDict() {
        //dusts
        OreDictionary.registerOre("dustCoal", new ItemStack(ItemRegistry.metaResourceDust, 1, 0));
        OreDictionary.registerOre("dustIron", new ItemStack(ItemRegistry.metaResourceDust, 1, 1));
        OreDictionary.registerOre("dustGold", new ItemStack(ItemRegistry.metaResourceDust, 1, 2));
        OreDictionary.registerOre("dustCopper", new ItemStack(ItemRegistry.metaResourceDust, 1, 3));
        OreDictionary.registerOre("dustTin", new ItemStack(ItemRegistry.metaResourceDust, 1, 4));
        OreDictionary.registerOre("dustLead", new ItemStack(ItemRegistry.metaResourceDust, 1, 5));
        OreDictionary.registerOre("dustSilver", new ItemStack(ItemRegistry.metaResourceDust, 1, 6));
        OreDictionary.registerOre("dustTinyEnderium", new ItemStack(ItemRegistry.metaResourceDust, 1, 7));
        OreDictionary.registerOre("dustEnderium", new ItemStack(ItemRegistry.metaResourceDust, 1, 8));
        OreDictionary.registerOre("dustNickel", new ItemStack(ItemRegistry.metaResourceDust, 1, 9));
        OreDictionary.registerOre("dustInvar", new ItemStack(ItemRegistry.metaResourceDust, 1, 10));
        OreDictionary.registerOre("dustElectrum", new ItemStack(ItemRegistry.metaResourceDust, 1, 11));

        //ingots
        OreDictionary.registerOre("ingotCopper", new ItemStack(ItemRegistry.metaResourceIngot, 1, 0));
        OreDictionary.registerOre("ingotTin", new ItemStack(ItemRegistry.metaResourceIngot, 1, 1));
        OreDictionary.registerOre("ingotLead", new ItemStack(ItemRegistry.metaResourceIngot, 1, 2));
        OreDictionary.registerOre("ingotSilver", new ItemStack(ItemRegistry.metaResourceIngot, 1, 3));
        OreDictionary.registerOre("ingotEnderium", new ItemStack(ItemRegistry.metaResourceIngot, 1, 4));
        OreDictionary.registerOre("ingotNickel", new ItemStack(ItemRegistry.metaResourceIngot, 1, 5));
        OreDictionary.registerOre("ingotInvar", new ItemStack(ItemRegistry.metaResourceIngot, 1, 6));
        OreDictionary.registerOre("ingotElectrum", new ItemStack(ItemRegistry.metaResourceIngot, 1, 7));

        //ores
        OreDictionary.registerOre("oreCopper", new ItemStack(BlockRegistry.blockOres, 1, 0));
        OreDictionary.registerOre("oreTin", new ItemStack(BlockRegistry.blockOres, 1, 1));
        OreDictionary.registerOre("oreLead", new ItemStack(BlockRegistry.blockOres, 1, 2));
        OreDictionary.registerOre("oreSilver", new ItemStack(BlockRegistry.blockOres, 1, 3));
        OreDictionary.registerOre("oreNickel", new ItemStack(BlockRegistry.blockOres, 1, 4));

        //blocks
        OreDictionary.registerOre("blockCopper", new ItemStack(BlockRegistry.ingotStorage, 1, 0));
        OreDictionary.registerOre("blockTin", new ItemStack(BlockRegistry.ingotStorage, 1, 1));
        OreDictionary.registerOre("blockLead", new ItemStack(BlockRegistry.ingotStorage, 1, 2));
        OreDictionary.registerOre("blockSilver", new ItemStack(BlockRegistry.ingotStorage, 1, 3));
        OreDictionary.registerOre("blockEnder", new ItemStack(BlockRegistry.ingotStorage, 1, 4));
        OreDictionary.registerOre("blockNickel", new ItemStack(BlockRegistry.ingotStorage, 1, 5));
        OreDictionary.registerOre("blockInvar", new ItemStack(BlockRegistry.ingotStorage, 1, 6));
        OreDictionary.registerOre("blockElectrum", new ItemStack(BlockRegistry.ingotStorage, 1, 7));
        OreDictionary.registerOre("machineBasic", new ItemStack(BlockRegistry.machineBox));

        //gears
        OreDictionary.registerOre("gearWood", new ItemStack(ItemRegistry.metaResourceGear, 1, 0));
        OreDictionary.registerOre("gearStone", new ItemStack(ItemRegistry.metaResourceGear, 1, 1));
        OreDictionary.registerOre("gearIron", new ItemStack(ItemRegistry.metaResourceGear, 1, 2));
        OreDictionary.registerOre("gearGold", new ItemStack(ItemRegistry.metaResourceGear, 1, 3));
        OreDictionary.registerOre("gearQuartz", new ItemStack(ItemRegistry.metaResourceGear, 1, 4));
        OreDictionary.registerOre("gearDiamond", new ItemStack(ItemRegistry.metaResourceGear, 1, 5));
        OreDictionary.registerOre("gearCopper", new ItemStack(ItemRegistry.metaResourceGear, 1, 6));
        OreDictionary.registerOre("gearTin", new ItemStack(ItemRegistry.metaResourceGear, 1, 7));
        OreDictionary.registerOre("gearLead", new ItemStack(ItemRegistry.metaResourceGear, 1, 8));
        OreDictionary.registerOre("gearSilver", new ItemStack(ItemRegistry.metaResourceGear, 1, 9));
        OreDictionary.registerOre("gearEnderium", new ItemStack(ItemRegistry.metaResourceGear, 1, 10));
        OreDictionary.registerOre("gearElectrum", new ItemStack(ItemRegistry.metaResourceGear, 1, 11));
        OreDictionary.registerOre("gearNickel", new ItemStack(ItemRegistry.metaResourceGear, 1, 12));
        OreDictionary.registerOre("gearInvar", new ItemStack(ItemRegistry.metaResourceGear, 1, 13));

        //tools
        OreDictionary.registerOre("toolWrench", ItemRegistry.flowwrench);
        OreDictionary.registerOre("toolWrench", ItemRegistry.pneumaticFlowwrench);

        //vanilla blocks that should be registered IMO
        OreDictionary.registerOre("gravel", Blocks.gravel);
        OreDictionary.registerOre("sand", Blocks.sand);
        OreDictionary.registerOre("glass", Blocks.glass);
        for (int i = 0; i <= 15; i++) {
            OreDictionary.registerOre("glass", new ItemStack(Blocks.stained_glass, 1, i));
        }

        //vanilla items that should be registered IMO
        OreDictionary.registerOre("ingotIron", Items.iron_ingot);
        OreDictionary.registerOre("ingotGold", Items.gold_ingot);
        OreDictionary.registerOre("gemNetherQuartz", Items.quartz);
        OreDictionary.registerOre("gemCoal", new ItemStack(Items.coal, 1, 0));
        OreDictionary.registerOre("gemCoal", new ItemStack(Items.coal, 1, 1));

    }

    public static void tumblerOreDictRecipes(String ore, ItemStack output, int time) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        if (ores != null && ores.size() >= 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                RecipesEnergizedOreTumbler.addRecipe(oreList, output, time);
            }
        }
    }

    public static void furnaceOreDictRecipes(String ore, ItemStack output, float xp) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        if (ores != null && ores.size() >= 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                GameRegistry.addSmelting(oreList, output, xp);
            }
        }
    }

    public static void lumberMillOreDictRecipes(String ore, ItemStack output, int time) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        if (ores != null && ores.size() >= 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                RecipesLumberMill.addRecipe(oreList, output, time);
            }
        }
    }

    public static void bottlerOreDictRecipes(String ore, ItemStack output, int time) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        if (ores != null && ores.size() >= 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                RecipesFlowstoneBottler.addRecipe(oreList, output, time);
            }
        }
    }

    public static void mixerOreDictRecipes(String ore1, String ore2, ItemStack output, int time) {
        ArrayList<ItemStack> ores1 = OreDictionary.getOres(ore1);
        ArrayList<ItemStack> ores2 = OreDictionary.getOres(ore2);
        if (ores1 != null && ores1.size() >= 0 && ores2 != null && ores2.size() >= 0) {
            for (ItemStack oreList1 : OreDictionary.getOres(ore1)) {
                for (ItemStack oreList2 : OreDictionary.getOres(ore2)) {
                    RecipesMetalMixer.addRecipe(oreList1, oreList2, output, time);
                }
            }
        }
    }

    public static void machineWorkbenchOreDictRecipes(String ore1, String ore2, String ore3, ItemStack output, int time) {
        ArrayList<ItemStack> ores1 = OreDictionary.getOres(ore1);
        ArrayList<ItemStack> ores2 = OreDictionary.getOres(ore2);
        ArrayList<ItemStack> ores3 = OreDictionary.getOres(ore3);
        if (ores1 != null && ores1.size() >= 0 && ores2 != null && ores2.size() >= 0 && ores3 != null && ores3.size() >= 0) {
            for (ItemStack oreList1 : OreDictionary.getOres(ore1)) {
                for (ItemStack oreList2 : OreDictionary.getOres(ore2)) {
                    for (ItemStack oreList3 : OreDictionary.getOres(ore3)) {
                        RecipesMachineWorkbench.addRecipe(oreList1, oreList2, oreList3, output, time);
                    }
                }
            }
        }
    }
}