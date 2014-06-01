package main.flowstoneenergy.gui;

import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.containers.ContainerMachineHeatedOven;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineHeatedOven;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class BlockGuiHeatedOven extends GuiContainer {

    public static final ResourceLocation oreTumblerGui = new ResourceLocation(ModInfo.MODID, "textures/guis/heatedOvenGui.png");
    @SuppressWarnings("unused")
    private ContainerMachineHeatedOven container;
    private TileEntityMachineHeatedOven te;
    String containerName = "Heated Oven";

    public BlockGuiHeatedOven(EntityPlayer player, TileEntityMachineHeatedOven tile) {
        super(new ContainerMachineHeatedOven(player, tile));
        this.container = (ContainerMachineHeatedOven) this.inventorySlots;
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
    }
}