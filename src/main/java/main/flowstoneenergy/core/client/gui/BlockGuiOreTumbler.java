package main.flowstoneenergy.core.client.gui;

import java.util.ArrayList;

import main.flowstoneenergy.core.containers.ContainerMachineOreTumbler;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineOreTumbler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

public class BlockGuiOreTumbler extends GuiContainer {

    public static final ResourceLocation oreTumblerGui = new ResourceLocation(ModInfo.MODID, "textures/guis/oreTumblerGui.png");
    @SuppressWarnings("unused")
    private ContainerMachineOreTumbler container;
    private TileEntityMachineOreTumbler te;
    String containerName = "Energized Ore Tumbler";

    public BlockGuiOreTumbler(EntityPlayer player, TileEntityMachineOreTumbler tile) {
        super(new ContainerMachineOreTumbler(player, tile));
        this.container = (ContainerMachineOreTumbler) this.inventorySlots;
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

        int powerBarHeight = this.te.getEnergyStored(ForgeDirection.UNKNOWN) * 50 / this.te.getMaxEnergyStored(ForgeDirection.UNKNOWN);
        int powerBarY = yStart + 10 + 51 - powerBarHeight;
        if (powerBarHeight > 0)
            this.drawTexturedModalRect(xStart + 12, powerBarY, 177, 32, 12, powerBarHeight);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float mouseAngle) {
        super.drawScreen(mouseX, mouseY, mouseAngle);

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;

        if ((xStart + 12 <= mouseX) && (xStart + 24 > mouseX) && (yStart + 10 <= mouseY) && (yStart + 60 > mouseY)) {
            String energyStatus = "Energy: ";
            energyStatus += this.te.getEnergyStored(ForgeDirection.UNKNOWN) + " / " + this.te.getMaxEnergyStored(ForgeDirection.UNKNOWN);
            energyStatus += " RF";
            ArrayList<String> toolTipList = new ArrayList<String>();
            toolTipList.add(energyStatus);
            drawHoveringText(toolTipList, mouseX, mouseY, fontRendererObj);
        }
    }
}