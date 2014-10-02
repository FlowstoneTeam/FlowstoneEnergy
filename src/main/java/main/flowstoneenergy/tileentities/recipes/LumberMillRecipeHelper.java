package main.flowstoneenergy.tileentities.recipes;

import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class LumberMillRecipeHelper {

    public static Item getItemOutput() {
        if (OreDictionary.getOres("plankWood").size() != 0) {
            for (int i = 0; i <= OreDictionary.getOres("plankWood").size(); i++) {
                return OreDictionary.getOres("plankWood").get(i).getItem();
            }
        }
        return null;
    }

    public static Item getRequiredItemInput() {
        if (OreDictionary.getOres("plankWood").size() != 0) {
            for (int i = 0; i <= OreDictionary.getOres("plankWood").size(); i++) {

            }
        }
        return null;
    }
}
