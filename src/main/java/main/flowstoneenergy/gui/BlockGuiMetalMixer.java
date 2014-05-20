package main.flowstoneenergy.gui;

import org.lwjgl.opengl.GL11;

import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.containers.ContainerMachineMetalMixer;
import main.flowstoneenergy.tileentities.TileEntityMachineMetalMixer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class BlockGuiMetalMixer extends GuiContainer{

	public static final ResourceLocation metalMixerGui = new ResourceLocation(ModInfo.MODID,"textures/guis/metalMixerGui.png");
	@SuppressWarnings("unused")
	private ContainerMachineMetalMixer container;
	private TileEntityMachineMetalMixer te;
	private String containerName = "Metal Mixer";

	public BlockGuiMetalMixer(EntityPlayer player, TileEntityMachineMetalMixer tile) {
		super(new ContainerMachineMetalMixer(player,tile));
		this.container = (ContainerMachineMetalMixer)this.inventorySlots;
		this.te = tile;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		fontRendererObj.drawString(containerName , xSize / 2 - fontRendererObj.getStringWidth(containerName) / 2, 6, 4210752);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(metalMixerGui);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

        int i1 = this.te.getScaledProgress(24);
        this.drawTexturedModalRect(xStart + 81, yStart + 34, 176, 14, i1 + 1, 16);

	}
}
