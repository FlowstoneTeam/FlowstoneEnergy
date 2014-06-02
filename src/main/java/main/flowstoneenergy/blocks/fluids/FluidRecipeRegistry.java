package main.flowstoneenergy.blocks.fluids;

import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.items.ItemRegistry;
import main.flowstoneenergy.tileentities.recipes.RecipesLiquifier;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class FluidRecipeRegistry {
    public static void registerFluidRecipes() {
        RecipesLiquifier.addRecipe(new ItemStack(Items.gold_ingot), new ItemStack(Items.glowstone_dust), new FluidStack(BlockRegistry.flowstone, 100), 200);
    }
}
