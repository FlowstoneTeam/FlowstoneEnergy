package main.flowstoneenergy.gui;

import main.flowstoneenergy.containers.ContainerMachineWorkbench;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineWorkbench;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class BlockGuiMachineWorkbench extends GuiContainer {

    public static final ResourceLocation metalMixerGui = new ResourceLocation(ModInfo.MODID, "textures/guis/machineWorkbenchGui.png");
    @SuppressWarnings("unused")
    private ContainerMachineWorkbench container;
    private TileEntityMachineWorkbench te;
    private String containerName = "Machine Workbench";

    public BlockGuiMachineWorkbench(EntityPlayer player, TileEntityMachineWorkbench tile) {
        super(new ContainerMachineWorkbench(player, tile));
        this.container = (ContainerMachineWorkbench) this.inventorySlots;
        this.te = tile;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        fontRendererObj.drawString(containerName, xSize / 2 - fontRendererObj.getStringWidth(containerName) / 2, 2, 4210752);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 4, 4210752);
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
        this.drawTexturedModalRect(xStart + 96, yStart + 35, 176, 14, i1 + 1, 16);

    }
}
