package main.flowstoneenergy.utils;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.tileentities.recipes.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class MachineRecipeHelper {

    public static void tumblerOreDictRecipes(String ore, ItemStack output, int time) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        if (ores != null && ores.size() > 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                RecipesEnergizedOreTumbler.addRecipe(oreList, output, time);
            }
        }
    }

    public static void tumblerOreDictRecipes(String ore, String output, int time, int stackSize) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        ArrayList<ItemStack> outputs = OreDictionary.getOres(output);
        if (ores != null && ores.size() > 0 && outputs != null && outputs.size() > 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                ItemStack outputsFinal = outputs.get(0);
                outputsFinal.stackSize = stackSize;
                RecipesEnergizedOreTumbler.addRecipe(oreList, outputsFinal, time);
            }
        }
    }


    public static void furnaceOreDictRecipes(String ore, ItemStack output, float xp) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        if (ores != null && ores.size() > 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                GameRegistry.addSmelting(oreList, output, xp);
            }
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

    public static void lumberMillOreDictRecipes(String ore, ItemStack output, int time) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        if (ores != null && ores.size() > 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                RecipesLumberMill.addRecipe(oreList, output, time);
            }
        }
    }

    public static void lumberMillOreDictRecipes(String ore, String output, int time, int stackSize) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        ArrayList<ItemStack> outputs = OreDictionary.getOres(output);
        if (ores != null && ores.size() > 0 && outputs != null && outputs.size() > 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                ItemStack outputsFinal = outputs.get(0);
                outputsFinal.stackSize = stackSize;
                RecipesLumberMill.addRecipe(oreList, outputsFinal, time);
            }
        }
    }

    public static void bottlerOreDictRecipes(String ore, ItemStack output, int time) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        if (ores != null && ores.size() > 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                RecipesFlowstoneBottler.addRecipe(oreList, output, time);
            }
        }
    }

    public static void bottlerOreDictRecipes(String ore, String output, int time, int stackSize) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(ore);
        ArrayList<ItemStack> outputs = OreDictionary.getOres(output);
        if (ores != null && ores.size() > 0 && outputs != null && outputs.size() > 0) {
            for (ItemStack oreList : OreDictionary.getOres(ore)) {
                ItemStack outputsFinal = outputs.get(0);
                outputsFinal.stackSize = stackSize;
                RecipesFlowstoneBottler.addRecipe(oreList, outputsFinal, time);
            }
        }
    }

    public static void mixerOreDictRecipes(String ore1, String ore2, ItemStack output, int time) {
        ArrayList<ItemStack> ores1 = OreDictionary.getOres(ore1);
        ArrayList<ItemStack> ores2 = OreDictionary.getOres(ore2);
        if (ores1 != null && ores1.size() > 0 && ores2 != null && ores2.size() > 0) {
            for (ItemStack oreList1 : OreDictionary.getOres(ore1)) {
                for (ItemStack oreList2 : OreDictionary.getOres(ore2)) {
                    RecipesMetalMixer.addRecipe(oreList1, oreList2, output, time);
                }
            }
        }
    }

    public static void mixerOreDictRecipes(String ore1, String ore2, String output, int time, int stackSize) {
        ArrayList<ItemStack> ores1 = OreDictionary.getOres(ore1);
        ArrayList<ItemStack> ores2 = OreDictionary.getOres(ore2);
        ArrayList<ItemStack> outputs = OreDictionary.getOres(output);
        if (ores1 != null && ores1.size() > 0 && ores2 != null && ores2.size() > 0 && output != null && outputs.size() > 0) {
            for (ItemStack oreList1 : OreDictionary.getOres(ore1)) {
                for (ItemStack oreList2 : OreDictionary.getOres(ore2)) {
                    ItemStack outputsFinal = outputs.get(0);
                    outputsFinal.stackSize = stackSize;
                    RecipesMetalMixer.addRecipe(oreList1, oreList2, outputsFinal, time);
                }
            }
        }
    }

    public static void machineWorkbenchOreDictRecipes(String ore1, String ore2, String ore3, ItemStack output, int time) {
        ArrayList<ItemStack> ores1 = OreDictionary.getOres(ore1);
        ArrayList<ItemStack> ores2 = OreDictionary.getOres(ore2);
        ArrayList<ItemStack> ores3 = OreDictionary.getOres(ore3);
        if (ores1 != null && ores1.size() > 0 && ores2 != null && ores2.size() > 0 && ores3 != null && ores3.size() > 0) {
            for (ItemStack oreList1 : OreDictionary.getOres(ore1)) {
                for (ItemStack oreList2 : OreDictionary.getOres(ore2)) {
                    for (ItemStack oreList3 : OreDictionary.getOres(ore3)) {
                        RecipesMachineWorkbench.addRecipe(oreList1, oreList2, oreList3, output, time);
                    }
                }
            }
        }
    }

    public static void machineWorkbenchOreDictRecipes(String ore1, String ore2, String ore3, String output, int time, int stackSize) {
        ArrayList<ItemStack> ores1 = OreDictionary.getOres(ore1);
        ArrayList<ItemStack> ores2 = OreDictionary.getOres(ore2);
        ArrayList<ItemStack> ores3 = OreDictionary.getOres(ore3);
        ArrayList<ItemStack> outputs = OreDictionary.getOres(output);
        if (ores1 != null && ores1.size() > 0 && ores2 != null && ores2.size() > 0 && ores3 != null && ores3.size() > 0 && output != null && outputs.size() > 0) {
            for (ItemStack oreList1 : OreDictionary.getOres(ore1)) {
                for (ItemStack oreList2 : OreDictionary.getOres(ore2)) {
                    for (ItemStack oreList3 : OreDictionary.getOres(ore3)) {
                        ItemStack outputsFinal = outputs.get(0);
                        outputsFinal.stackSize = stackSize;
                        RecipesMachineWorkbench.addRecipe(oreList1, oreList2, oreList3, outputsFinal, time);
                    }
                }
            }
        }
    }
}
