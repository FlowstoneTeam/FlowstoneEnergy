package main.flowstoneenergy.core.client.gui;

import java.util.ArrayList;

import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.core.containers.ContainerMachineMetalMixer;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineMetalMixer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class BlockGuiMetalMixer extends GuiContainer {

    public static final ResourceLocation metalMixerGui = new ResourceLocation(ModInfo.MODID, "textures/guis/metalMixerGui.png");
    @SuppressWarnings("unused")
    private ContainerMachineMetalMixer container;
    private TileEntityMachineMetalMixer te;
    private String containerName = "Metal Mixer";

    public BlockGuiMetalMixer(EntityPlayer player, TileEntityMachineMetalMixer tile) {
        super(new ContainerMachineMetalMixer(player, tile));
        this.container = (ContainerMachineMetalMixer) this.inventorySlots;
        this.te = tile;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        fontRendererObj.drawString(containerName, xSize / 2 - fontRendererObj.getStringWidth(containerName) / 2, 6, 4210752);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(metalMixerGui);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

        int i1 = this.te.getScaledProgress(24);
        this.drawTexturedModalRect(xStart + 81, yStart + 34, 176, 14, i1 + 1, 16);

        // TODO: Enable after update
        /*
        int powerBarHeight = this.te.getEnergyStored(ForgeDirection.UNKNOWN) * 50 / this.te.getMaxEnergyStored(ForgeDirection.UNKNOWN);
        int powerBarY = yStart + 10 + 51 - powerBarHeight;
        if (powerBarHeight > 0)
            this.drawTexturedModalRect(xStart + 12, powerBarY, 177, 32, 12, powerBarHeight);
         */
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float mouseAngle) {
        super.drawScreen(mouseX, mouseY, mouseAngle);

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;

        // TODO: Enable after update
        /*
        if ((xStart + 12 <= mouseX) && (xStart + 24 > mouseX) && (yStart + 10 <= mouseY) && (yStart + 60 > mouseY)) {
            String energyStatus = "Energy: ";
            energyStatus += this.te.getEnergyStored(ForgeDirection.UNKNOWN) + " / " + this.te.getMaxEnergyStored(ForgeDirection.UNKNOWN);
            energyStatus += " RF";
            ArrayList<String> toolTipList = new ArrayList<String>();
            toolTipList.add(energyStatus);
            drawHoveringText(toolTipList, mouseX, mouseY, fontRendererObj);
        }
        */
    }
}
