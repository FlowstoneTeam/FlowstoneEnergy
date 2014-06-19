package main.flowstoneenergy.client.transport;

import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.blocks.BlockRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderItemPipe extends TileEntitySpecialRenderer {

    private ResourceLocation text = new ResourceLocation(ModInfo.MODID, "textures/blocks/transport/itemPipe.png");
    private final ModelPipe model = new ModelPipe();

    public RenderItemPipe() {

    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        World world = te.getWorldObj();
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(text);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 90.0F, 0.0F, 90.0F);
        if (world.getBlock((int)x, (int)y - 1, (int)z) == BlockRegistry.itemPipe) {
            this.model.LongPipeTopToBottom.render(0.625F);
        }
        if (world.getBlock((int)x, (int)y + 1, (int)z) == BlockRegistry.itemPipe) {
            this.model.LongPipeTopToBottom.render(0.625F);
        }
        if (world.getBlock((int)x + 1, (int)y, (int)z) == BlockRegistry.itemPipe) {
            this.model.LongPipeRightToLeft.render(0.625F);
        }
        if (world.getBlock((int)x - 1, (int)y, (int)z) == BlockRegistry.itemPipe) {
            this.model.LongPipeRightToLeft.render(0.625F);
        }
        if (world.getBlock((int)x, (int)y, (int)z + 1) == BlockRegistry.itemPipe) {
            this.model.LongPipeBackToFront.render(0.625F);
        }
        if (world.getBlock((int)x, (int)y, (int)z - 1) == BlockRegistry.itemPipe) {
            this.model.LongPipeBackToFront.render(0.625F);
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    public void renderAll(){
    }
}
