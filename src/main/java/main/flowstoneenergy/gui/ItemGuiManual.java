package main.flowstoneenergy.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.items.ItemRegistry;
import main.flowstoneenergy.items.tools.ItemFlowstoneManual;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.glColor4f;

@SideOnly(Side.CLIENT)
public class ItemGuiManual extends GuiScreen{
    static ResourceLocation gui = new ResourceLocation(ModInfo.MODID, "textures/guis/book.png");

    private static final int BOOK_BTN_NEXT = 0;
    private static final int BOOK_BTN_PREV = 1;

    public static final int WIDTH = 175;
    public static final int HEIGHT = 228;

    public static List<BookPage> pages = new ArrayList<BookPage>();

    private GuiButton next;
    private GuiButton prev;

    private int pageIndex = 0;
    private int bookTotalPages = 14;

    public int bookXStart;

    public ItemGuiManual() {

    }

    @Override
    public void initGui() {
        super.initGui();

        bookXStart = (width - WIDTH) / 2;

        buttonList.add(next = new GuiButtonPageChange(BOOK_BTN_NEXT, bookXStart + WIDTH - 26, 210, false));
        buttonList.add(prev = new GuiButtonPageChange(BOOK_BTN_PREV, bookXStart + 10, 210, true));

        updateButtons();
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        switch (button.id)
        {
            case BOOK_BTN_NEXT:
                pageIndex++;
                break;
            case BOOK_BTN_PREV:
                --pageIndex;
                break;
        }
        updateButtons();
    }

    private void updateButtons()
    {
        this.next.visible = (this.pageIndex < this.bookTotalPages - 1);
        this.prev.visible = this.pageIndex > 0;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float renderPartials) {
        drawBackground();
        drawForeground();

        super.drawScreen(mouseX, mouseY, renderPartials);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    protected void keyTyped(char c, int key) {
        if (key == Keyboard.KEY_ESCAPE) {
            ItemFlowstoneManual.currentIcon = ItemFlowstoneManual.icon[0];
            mc.displayGuiScreen(null);
        }
    }

    protected void drawBackground() {
        mc.renderEngine.bindTexture(gui);
        drawTexturedModalRect(bookXStart, 5, 0, 0, WIDTH, HEIGHT);
    }

    public void drawForeground() {
        switch (pageIndex) {
            case 0: drawStartScreen(); break;
            case 1: drawScreenTwo(); break;
            case 2: drawScreenThree(); break;
            case 3: drawScreenFour(); break;
            case 4: drawScreenFive(); break;
            case 5: drawScreenSix(); break;
            case 6: drawScreenSeven(); break;
            case 7: drawScreenEight(); break;
            case 8: drawScreenNine(); break;
            case 9: drawScreenTen(); break;
            case 10: drawScreenEleven(); break;
            case 11: drawScreenTwelve(); break;
            case 12: drawScreenThirteen(); break;
            case 13: drawScreenFourteen(); break;
        }
    }

    protected void drawStartScreen() {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.manual.mainTitle"), bookXStart + 70, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(StatCollector.translateToLocal("gui.manual.mainPage"), bookXStart + 20, 60, WIDTH-40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages+1), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }
	
	private void drawScreenTwo() {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.manual.page2"), bookXStart + 45, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(StatCollector.translateToLocal("gui.manual.pageText2"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages+1), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
	}

    private void drawScreenThree() {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.manual.page3"), bookXStart + 45, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(StatCollector.translateToLocal("gui.manual.pageText3"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages+1), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenFour() {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.manual.page4"), bookXStart + 45, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(StatCollector.translateToLocal("gui.manual.pageText4"), bookXStart + 20, 60, WIDTH-40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages+1), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenFive() {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.manual.page5"), bookXStart + 45, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(StatCollector.translateToLocal("gui.manual.pageText5"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages+1), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenSix() {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.manual.page6"), bookXStart + 45, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(StatCollector.translateToLocal("gui.manual.pageText6"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages+1), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenSeven() {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.manual.page7"), bookXStart + 45, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(StatCollector.translateToLocal("gui.manual.pageText7"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages+1), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenEight() {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.manual.page8"), bookXStart + 45, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(StatCollector.translateToLocal("gui.manual.pageText8"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages+1), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenNine() {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.manual.page9"), bookXStart + 45, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(StatCollector.translateToLocal("gui.manual.pageText9"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages+1), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenTen() {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.manual.page10"), bookXStart + 45, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(StatCollector.translateToLocal("gui.manual.pageText10"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages+1), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenEleven() {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.manual.page11"), bookXStart + 45, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(StatCollector.translateToLocal("gui.manual.pageText11"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages+1), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenTwelve() {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.manual.page12"), bookXStart + 45, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(StatCollector.translateToLocal("gui.manual.pageText12"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages+1), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }
    
    private void drawScreenThirteen() {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.manual.page13"), bookXStart + 45, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(StatCollector.translateToLocal("gui.manual.pageText13"), bookXStart + 20, 60, WIDTH-40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages+1), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenFourteen() {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.manual.page14"), bookXStart + 45, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(StatCollector.translateToLocal("gui.manual.pageText14"), bookXStart + 20, 60, WIDTH-40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    public class GuiButtonPageChange extends GuiButton
    {
        private final boolean previous;

        public GuiButtonPageChange(int id, int x, int y, boolean previous) {
            super(id, x, y, 16, 16, "");
            this.previous = previous;
        }

        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY) {
            if (visible) {
                boolean mouseOver = mouseX >= xPosition && mouseY >= yPosition && mouseX < xPosition + width && mouseY < yPosition + height;
                glColor4f(1, 1, 1, 1);
                mc.renderEngine.bindTexture(gui);
                int u = 175;
                int v = 0;

                if (mouseOver) {
                    v += 17;
                }

                if (previous) {
                    u += 17;
                }

                GL11.glPushMatrix();

                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glColor4f(1, 1, 1, 1);

                drawTexturedModalRect(xPosition, yPosition, u, v, width, height);

                GL11.glEnable(GL11.GL_LIGHTING);

                GL11.glPopMatrix();
            }
        }
    }
}