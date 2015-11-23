package main.flowstoneenergy.core.client.gui;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BookPage {
    private int startNDX = 0;
    private int endNDX = 12;
    private ItemGuiManual parent;

    public BookPage(ItemGuiManual parent, int startIndex) {
        this.parent = parent;
        this.startNDX = startIndex;
    }

    protected static void renderItem(RenderItem itemRenderer, int x, int y, Item block) {
        itemRenderer.renderItemIntoGUI(new ItemStack(block), x, y);
    }

}