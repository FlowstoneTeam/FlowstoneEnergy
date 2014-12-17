package main.flowstoneenergy.core.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.items.tools.ItemFlowstoneManual;
import main.flowstoneenergy.core.utils.TextHelper;
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
public class ItemGuiManual extends GuiScreen {
    private static final int xOffset[] = new int[]{70, 70, 55, 42, 35, 58, 45, 61, 54, 52, 54, 23, 21, 23, 16};

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
        // buttonList.add(blocks = new GuiButtonPageChange(BOOK_BTN_BL,
        // bookXStart + 20, 210, false));

        updateButtons();
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        switch (button.id) {
            case BOOK_BTN_NEXT:
                pageIndex++;
                break;
            case BOOK_BTN_PREV:
                --pageIndex;
                break;
        }
        updateButtons();
    }

    private void updateButtons() {
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
        String unlocalized_title = "gui.manual.title.";
        String unlocalized_info = "gui.manual.info.";

        switch (pageIndex) {
            case 0:
                unlocalized_title += "main";
                unlocalized_info += "main";
                break;
            case 1:
                unlocalized_title += "index";
                unlocalized_info += "index.1";
                break;
            default:
                if (pageIndex >= 2 && pageIndex <= 14) {
                    unlocalized_title += pageIndex;
                    unlocalized_info += pageIndex;
                }
                break;
        }

        if (!unlocalized_title.equals("") && !unlocalized_info.equals("")) {
            fontRendererObj.drawString(TextHelper.localize(unlocalized_title), bookXStart + xOffset[pageIndex], 20, 0x000000);

            boolean unicode = fontRendererObj.getUnicodeFlag();
            fontRendererObj.setUnicodeFlag(true);
            fontRendererObj.drawSplitString(TextHelper.localize(unlocalized_info), bookXStart + 20, 60, WIDTH - 40, 0x000000);
            fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
            fontRendererObj.setUnicodeFlag(unicode);
        }
    }

    public class GuiButtonPageChange extends GuiButton {
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