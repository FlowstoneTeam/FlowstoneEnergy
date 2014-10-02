package main.flowstoneenergy.nei;

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.core.client.gui.BlockGuiMachineWorkbench;
import main.flowstoneenergy.tileentities.recipes.Recipe1_1;
import main.flowstoneenergy.tileentities.recipes.RecipesLumberMill;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LumberMillHandler extends TemplateRecipeHandler {
    class CachedLumberMillRecipe extends TemplateRecipeHandler.CachedRecipe {

        private ItemStack input1;
        private ItemStack output;

        public CachedLumberMillRecipe(Recipe1_1 r) {
            this.input1 = r.getInput();
            this.output = r.getOutput();
        }

        @Override
        public PositionedStack getResult() {
            return new PositionedStack(output, 124, 23);
        }

        @Override
        public List<PositionedStack> getIngredients() {
            ArrayList<PositionedStack> stacks = new ArrayList<PositionedStack>();
            stacks.add(new PositionedStack(input1, 47, 5));
            return stacks;
        }
    }

    @Override
    public String getGuiTexture() {
        return ModInfo.MODID + ":textures/guis/heatedOvenGui.png";
    }

    @Override
    public String getRecipeName() {
        return StatCollector.translateToLocal("Lumber Mill");
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals("item"))
            loadCraftingRecipes((ItemStack) results[0]);
        else if (outputId.equals("allOT")) {
            for (Recipe1_1 r : RecipesLumberMill.getAllRecipes()) {
                arecipes.add(new CachedLumberMillRecipe(r));
            }
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for (Recipe1_1 r : RecipesLumberMill.getAllRecipes()) {
            if (r.getOutput().isItemEqual(result))
                arecipes.add(new CachedLumberMillRecipe(r));
        }
    }

    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients) {
        if (ingredients.length == 0)
            return;
        if ("item".equals(inputId)) {
            for (Recipe1_1 r : RecipesLumberMill.getRecipesFromStack((ItemStack) ingredients[0]))
                arecipes.add(new CachedLumberMillRecipe(r));
        }
    }

    @Override
    public void drawExtras(int recipe) {

    }

    public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6, int w, int h) {
        float f = (float) 1 / w;
        float f1 = (float) 1 / h;
        Tessellator tess = Tessellator.instance;
        tess.startDrawingQuads();
        tess.addVertexWithUV((double) (par1 + 0), (double) (par2 + par6), 0.0F, (double) ((float) (par3 + 0) * f), (double) ((float) (par4 + par6) * f1));
        tess.addVertexWithUV((double) (par1 + par5), (double) (par2 + par6), 0.0F, (double) ((float) (par3 + par5) * f), (double) ((float) (par4 + par6) * f1));
        tess.addVertexWithUV((double) (par1 + par5), (double) (par2 + 0), 0.0F, (double) ((float) (par3 + par5) * f), (double) ((float) (par4 + 0) * f1));
        tess.addVertexWithUV((double) (par1 + 0), (double) (par2 + 0), 0.0F, (double) ((float) (par3 + 0) * f), (double) ((float) (par4 + 0) * f1));
        tess.draw();
    }

    @Override
    public void drawProgressBar(int x, int y, int tx, int ty, int w, int h, float completion, int direction) {
        if (direction > 3) {
            completion = 1 - completion;
            direction %= 4;
        }
        int var = (int) (completion * (direction % 2 == 0 ? w : h));

        switch (direction) {
            case 0:// right
                this.drawTexturedModalRect(x, y, tx, ty, var, h, w, h);
                break;
            case 1:// down
                this.drawTexturedModalRect(x, y, tx, ty, w, var, w, h);
                break;
            case 2:// left
                this.drawTexturedModalRect(x + w - var, y, tx + w - var, ty, var, h, w, h);
                break;
            case 3:// up
                this.drawTexturedModalRect(x, y + h - var, tx, ty + h - var, w, var, w, h);
                break;
        }
    }

    @Override
    public void loadTransferRects() {
        TemplateRecipeHandler.RecipeTransferRect rect = new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(77, 25, 24, 17), "allOT");
        transferRects.add(rect);
        List<Class<? extends GuiContainer>> guis = new ArrayList<Class<? extends GuiContainer>>();
        guis.add(BlockGuiMachineWorkbench.class);
        TemplateRecipeHandler.RecipeTransferRectHandler.registerRectsToGuis(guis, transferRects);
    }
}
