package main.flowstoneenergy.core.utils;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.items.ItemRegistry;
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
        OreDictionary.registerOre("dustTinyEnder", new ItemStack(ItemRegistry.metaResourceDust, 1, 7));
        OreDictionary.registerOre("dustEnder", new ItemStack(ItemRegistry.metaResourceDust, 1, 8));
        OreDictionary.registerOre("dustNickel", new ItemStack(ItemRegistry.metaResourceDust, 1, 9));
        OreDictionary.registerOre("dustInvar", new ItemStack(ItemRegistry.metaResourceDust, 1, 10));
        OreDictionary.registerOre("dustElectrum", new ItemStack(ItemRegistry.metaResourceDust, 1, 11));

        //ingots
        OreDictionary.registerOre("ingotCopper", new ItemStack(ItemRegistry.metaResourceIngot, 1, 0));
        OreDictionary.registerOre("ingotTin", new ItemStack(ItemRegistry.metaResourceIngot, 1, 1));
        OreDictionary.registerOre("ingotLead", new ItemStack(ItemRegistry.metaResourceIngot, 1, 2));
        OreDictionary.registerOre("ingotSilver", new ItemStack(ItemRegistry.metaResourceIngot, 1, 3));
        OreDictionary.registerOre("ingotEnder", new ItemStack(ItemRegistry.metaResourceIngot, 1, 4));
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
        OreDictionary.registerOre("gearEnder", new ItemStack(ItemRegistry.metaResourceGear, 1, 10));
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
        OreDictionary.registerOre("tableCrafting", Blocks.crafting_table);
        for (int i = 0; i <= 15; i++) {
            OreDictionary.registerOre("glass", new ItemStack(Blocks.stained_glass, 1, i));
        }

        //vanilla items that should be registered IMO
        OreDictionary.registerOre("ingotIron", new ItemStack(Items.iron_ingot, 1, 0));
        OreDictionary.registerOre("ingotGold", new ItemStack(Items.gold_ingot, 1, 0));
        OreDictionary.registerOre("gemQuartz", new ItemStack(Items.quartz, 1, 0));
        OreDictionary.registerOre("gemCoal", new ItemStack(Items.coal, 1, 0));
        OreDictionary.registerOre("gemCoal", new ItemStack(Items.coal, 1, 1));

    }

    public static void furnaceOreDictRecipes(String ore, ItemStack output, float xp) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        if (ores != null && ores.size() > 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                GameRegistry.addSmelting(oreList, output, xp);
            }
        }
    }

    public static void furnaceOreDictRecipes(ItemStack input, String output, float xp, int stackSize) {
        ArrayList<ItemStack> outputs = OreDictionary.getOres(output);
        if (outputs != null && outputs.size() > 0) {
            ItemStack outputsFinal = outputs.get(0);
            outputsFinal.stackSize = stackSize;
            GameRegistry.addSmelting(input, outputsFinal, xp);
        }
    }

    public static void furnaceOreDictRecipes(String ore, String output, float xp, int stackSize) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        ArrayList<ItemStack> outputs = OreDictionary.getOres(output);
        if (ores != null && ores.size() > 0 && outputs != null && outputs.size() > 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                ItemStack outputsFinal = outputs.get(0);
                outputsFinal.stackSize = stackSize;
                GameRegistry.addSmelting(oreList, outputsFinal, xp);
            }
        }
    }
}