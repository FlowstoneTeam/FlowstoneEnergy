package main.flowstoneenergy.gui;

import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.containers.ContainerMachineLiquifier;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineLiquifier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class BlockGuiLiquifier extends GuiContainer {

    public static final ResourceLocation oreTumblerGui = new ResourceLocation(ModInfo.MODID, "textures/guis/liquifierGui.png");
    @SuppressWarnings("unused")
    private ContainerMachineLiquifier container;
    private TileEntityMachineLiquifier te;
    String containerName = "Item Liquifier";

    public BlockGuiLiquifier(EntityPlayer player, TileEntityMachineLiquifier tile) {
        super(new ContainerMachineLiquifier(player, tile));
        this.container = (ContainerMachineLiquifier) this.inventorySlots;
        this.te = tile;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        fontRendererObj.drawString(containerName, xSize / 2 - fontRendererObj.getStringWidth(containerName) / 2, 6, 4210752);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(oreTumblerGui);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

        int i1 = this.te.getScaledProgress(24);
        this.drawTexturedModalRect(xStart + 81, yStart + 34, 176, 14, i1 + 1, 16);

        Tessellator tess = Tessellator.instance;
        tess.startDrawingQuads();
        tess.addVertexWithUV(129, 7, 0, 129, 7);
        tess.addVertexWithUV(158, 7, 0, 158, 7);
        tess.addVertexWithUV(158, 78, 0, 158, 78);
        tess.addVertexWithUV(129, 78, 0, 129, 78);
        tess.draw();
    }
}
