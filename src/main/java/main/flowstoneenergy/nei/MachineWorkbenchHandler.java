package main.flowstoneenergy.nei;

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import main.flowstoneenergy.libs.ModInfo;
import main.flowstoneenergy.client.gui.BlockGuiMachineWorkbench;
import main.flowstoneenergy.tileentities.recipes.Recipe3_1;
import main.flowstoneenergy.tileentities.recipes.RecipesMachineWorkbench;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MachineWorkbenchHandler extends TemplateRecipeHandler {

    class CachedMachineWorkbenchRecipe extends CachedRecipe {

        private ItemStack input1;
        private ItemStack input2;
        private ItemStack input3;
        private ItemStack output;

        public CachedMachineWorkbenchRecipe(Recipe3_1 r) {
            this.input1 = r.getInput1();
            this.input2 = r.getInput2();
            this.input3 = r.getInput3();
            this.output = r.getOutput();
        }

        @Override
        public PositionedStack getResult() {
            return new PositionedStack(output, 124, 23);
        }

        @Override
        public List<PositionedStack> getIngredients() {
            ArrayList<PositionedStack> stacks = new ArrayList<PositionedStack>();
            stacks.add(new PositionedStack(input2, 24, 5));
            stacks.add(new PositionedStack(input1, 47, 5));
            stacks.add(new PositionedStack(input3, 70, 5));
            return stacks;
        }
    }

    @Override
    public String getGuiTexture() {
        return ModInfo.MODID + ":textures/guis/machineWorkbenchGui.png";
    }

    @Override
    public String getRecipeName() {
        return StatCollector.translateToLocal("Machine Workbench");
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals("item"))
            loadCraftingRecipes((ItemStack) results[0]);
        else if (outputId.equals("allMWB")) {
            for (Recipe3_1 r : RecipesMachineWorkbench.getAllRecipes()) {
                arecipes.add(new CachedMachineWorkbenchRecipe(r));
            }
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for (Recipe3_1 r : RecipesMachineWorkbench.getAllRecipes()) {
            if (r.getOutput().isItemEqual(result))
                arecipes.add(new CachedMachineWorkbenchRecipe(r));
        }
    }

    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients) {
        if (ingredients.length == 0) return;
        if ("item".equals(inputId)) {
            for (Recipe3_1 r : RecipesMachineWorkbench.getRecipesFromStack((ItemStack) ingredients[0]))
                arecipes.add(new CachedMachineWorkbenchRecipe(r));
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
            case 0://right
                this.drawTexturedModalRect(x, y, tx, ty, var, h, w, h);
                break;
            case 1://down
                this.drawTexturedModalRect(x, y, tx, ty, w, var, w, h);
                break;
            case 2://left
                this.drawTexturedModalRect(x + w - var, y, tx + w - var, ty, var, h, w, h);
                break;
            case 3://up
                this.drawTexturedModalRect(x, y + h - var, tx, ty + h - var, w, var, w, h);
                break;
        }
    }

    @Override
    public void loadTransferRects() {
        RecipeTransferRect rect = new RecipeTransferRect(new Rectangle(93, 25, 24, 17), "allMWB");
        transferRects.add(rect);
        List<Class<? extends GuiContainer>> guis = new ArrayList<Class<? extends GuiContainer>>();
        guis.add(BlockGuiMachineWorkbench.class);
        RecipeTransferRectHandler.registerRectsToGuis(guis, transferRects);
    }
}
