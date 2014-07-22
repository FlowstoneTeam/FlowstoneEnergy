package main.flowstoneenergy.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.items.tools.ItemFlowstoneManual;
import main.flowstoneenergy.utils.TextHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
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
    private static final int BOOK_BTN_BL = 2;

    public static final int WIDTH = 175;
    public static final int HEIGHT = 228;

    public static List<BookPage> pages = new ArrayList<BookPage>();

    private GuiButton next;
    private GuiButton prev;
    private GuiButton blocks;
    private GuiButton items;
    private GuiButton power;
    private GuiButton compat;

    private int pageIndex = 0;
    private int bookTotalPages = 15;

    public int bookXStart;

    public ItemGuiManual() {

    }

    @Override
    public void initGui() {
        super.initGui();

        bookXStart = (width - WIDTH) / 2;

        buttonList.add(next = new GuiButtonPageChange(BOOK_BTN_NEXT, bookXStart + WIDTH - 26, 210, false));
        buttonList.add(prev = new GuiButtonPageChange(BOOK_BTN_PREV, bookXStart + 10, 210, true));
        //buttonList.add(blocks = new GuiButtonPageChange(BOOK_BTN_BL, bookXStart + 20, 210, false));

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
            case 1: drawIndexPage(); break;
            case 2: drawScreenTwo(); break;
            case 3: drawScreenThree(); break;
            case 4: drawScreenFour(); break;
            case 5: drawScreenFive(); break;
            case 6: drawScreenSix(); break;
            case 7: drawScreenSeven(); break;
            case 8: drawScreenEight(); break;
            case 9: drawScreenNine(); break;
            case 10: drawScreenTen(); break;
            case 11: drawScreenEleven(); break;
            case 12: drawScreenTwelve(); break;
            case 13: drawScreenThirteen(); break;
            case 14: drawScreenFourteen(); break;
        }
    }

    protected void drawStartScreen() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.main"), bookXStart + 70, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(TextHelper.localize("gui.manual.info.main"), bookXStart + 20, 60, WIDTH-40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawIndexPage() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.index"), bookXStart + 70, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawString(TextHelper.localize("gui.manual.info.index.1"), bookXStart + 20, 60, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }
	
	private void drawScreenTwo() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.2"), bookXStart + 55, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(TextHelper.localize("gui.manual.info.2"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
	}

    private void drawScreenThree() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.3"), bookXStart + 42, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(TextHelper.localize("gui.manual.info.3"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenFour() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.4"), bookXStart + 35, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(TextHelper.localize("gui.manual.info.4"), bookXStart + 20, 60, WIDTH-40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenFive() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.5"), bookXStart + 58, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(TextHelper.localize("gui.manual.info.5"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenSix() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.6"), bookXStart + 45, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(TextHelper.localize("gui.manual.info.6"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenSeven() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.7"), bookXStart + 61, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(TextHelper.localize("gui.manual.info.7"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenEight() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.8"), bookXStart + 54, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(TextHelper.localize("gui.manual.info.8"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenNine() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.9"), bookXStart + 52, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(TextHelper.localize("gui.manual.info.9"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenTen() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.10"), bookXStart + 54, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(TextHelper.localize("gui.manual.info.10"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenEleven() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.11"), bookXStart + 23, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(TextHelper.localize("gui.manual.info.11"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenTwelve() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.12"), bookXStart + 21, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(TextHelper.localize("gui.manual.info.12"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }
    
    private void drawScreenThirteen() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.13"), bookXStart + 23, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(TextHelper.localize("gui.manual.info.13"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
        fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    private void drawScreenFourteen() {
        fontRendererObj.drawString(TextHelper.localize("gui.manual.title.14"), bookXStart + 16, 20, 0x000000);

        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(TextHelper.localize("gui.manual.info.14"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
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