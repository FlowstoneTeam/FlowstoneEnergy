package main.flowstoneenergy.core.client.blocks;

import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineWorkbench;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderMachineWorkbench extends TileEntitySpecialRenderer<TileEntityMachineWorkbench> {

    private ResourceLocation text = new ResourceLocation(ModInfo.MODID, "textures/blocks/machines/machineWorkbench.png");
    private final ModelMachineWorkbench model = new ModelMachineWorkbench();

    public RenderMachineWorkbench() {

    }

    @Override
    public void renderTileEntityAt(TileEntityMachineWorkbench te, double x, double y, double z, float partialTicks, int destroyStage) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(text);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 90.0F, 0.0F, 90.0F);
        this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    public void renderAll() {
    }

}