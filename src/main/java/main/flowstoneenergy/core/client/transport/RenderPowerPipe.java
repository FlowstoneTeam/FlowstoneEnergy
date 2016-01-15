package main.flowstoneenergy.core.client.transport;

import main.flowstoneenergy.core.libs.ConfigHandler;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.tileentities.transport.TileEntityPowerPipe;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderPowerPipe extends TileEntitySpecialRenderer<TileEntityPowerPipe> {
    private ResourceLocation text = new ResourceLocation(ModInfo.MODID, "textures/blocks/transport/powerPipe.png");
    float pixel = 1F / 16F;
    float texturePixel = 1F / 32F;
    boolean drawInside = ConfigHandler.drawInsidePipes;

    public RenderPowerPipe() {

    }

    @Override
    public void renderTileEntityAt(TileEntityPowerPipe pipe, double translationX, double translationY, double translationZ, float partialTicks, int destroyStage) {
        GL11.glTranslated(translationX, translationY, translationZ);
        GL11.glDisable(GL11.GL_LIGHTING);
        bindTexture(text);

        {
            if (!pipe.onlyOneOpposite(pipe.connections)) {
                drawCore(pipe);
                for (int i = 0; i < pipe.connections.length; i++) {
                    if (pipe.connections[i] != null) {
                        drawConnection(pipe.connections[i]);
                    }
                }
            } else {
                for (int i = 0; i < pipe.connections.length; i++) {
                    if (pipe.connections[i] != null) {
                        drawStraight(pipe.connections[i]);
                        break;
                    }
                }
            }
        }

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glTranslated(-translationX, -translationY, -translationZ);
    }

    public void drawCore(TileEntityPowerPipe tileEntity) {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();

        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        {
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * texturePixel, 5 * texturePixel);

            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * texturePixel, 5 * texturePixel);

            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * texturePixel, 5 * texturePixel);

            addVertexWithUV(worldRenderer, 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * texturePixel, 5 * texturePixel);

            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * texturePixel, 5 * texturePixel);

            addVertexWithUV(worldRenderer, 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * texturePixel, 5 * texturePixel);

            if (drawInside) {
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * texturePixel, 5 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);

                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * texturePixel, 5 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);

                addVertexWithUV(worldRenderer, 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * texturePixel, 5 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);

                addVertexWithUV(worldRenderer, 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * texturePixel, 5 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);

                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * texturePixel, 5 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);

                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * texturePixel, 5 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);
            }
        }
        tessellator.draw();        
    }

    public void drawConnection(EnumFacing direction) {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();

        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        {
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            if (direction.equals(EnumFacing.UP)) {
                // rotate
            } else if (direction.equals(EnumFacing.DOWN)) {
                GL11.glRotatef(180, 1, 0, 0);
            } else if (direction.equals(EnumFacing.SOUTH)) {
                GL11.glRotatef(90, 1, 0, 0);
            } else if (direction.equals(EnumFacing.NORTH)) {
                GL11.glRotatef(270, 1, 0, 0);
            } else if (direction.equals(EnumFacing.WEST)) {
                GL11.glRotatef(90, 0, 0, 1);
            } else if (direction.equals(EnumFacing.EAST)) {
                GL11.glRotatef(270, 0, 0, 1);
            }
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);

            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);

            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);

            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);

            if (drawInside) {
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);

                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);

                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);

                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * texturePixel, 5 * texturePixel);
            }
        }
        tessellator.draw();
        
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        if (direction.equals(EnumFacing.UP)) {
            // rotate
        } else if (direction.equals(EnumFacing.DOWN)) {
            GL11.glRotatef(-180, 1, 0, 0);
        } else if (direction.equals(EnumFacing.SOUTH)) {
            GL11.glRotatef(-90, 1, 0, 0);
        } else if (direction.equals(EnumFacing.NORTH)) {
            GL11.glRotatef(-270, 1, 0, 0);
        } else if (direction.equals(EnumFacing.WEST)) {
            GL11.glRotatef(-90, 0, 0, 1);
        } else if (direction.equals(EnumFacing.EAST)) {
            GL11.glRotatef(-270, 0, 0, 1);
        }
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
    }

    public void drawStraight(EnumFacing direction) {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();

        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        {
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            if (direction.equals(EnumFacing.SOUTH) || direction.equals(EnumFacing.NORTH)) {
                GL11.glRotatef(90, 1, 0, 0);
            } else if (direction.equals(EnumFacing.WEST) || direction.equals(EnumFacing.EAST)) {
                GL11.glRotatef(90, 0, 0, 1);
            }
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 0, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 26 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 26 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 0, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            addVertexWithUV(worldRenderer, 11 * pixel / 2, 0, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 11 * pixel / 2, 26 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 11 * pixel / 2, 26 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 0, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 0, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 11 * pixel / 2, 26 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 26 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 0, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            addVertexWithUV(worldRenderer, 11 * pixel / 2, 0, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 26 * texturePixel, 5 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 11 * pixel / 2, 26 * texturePixel, 0 * texturePixel);
            addVertexWithUV(worldRenderer, 11 * pixel / 2, 0, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            if (drawInside) {
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 0, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 26 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 26 * texturePixel, 5 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 0, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);

                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 0, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 11 * pixel / 2, 26 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 11 * pixel / 2, 26 * texturePixel, 5 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 0, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);

                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 0, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 26 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 1, 11 * pixel / 2, 26 * texturePixel, 5 * texturePixel);
                addVertexWithUV(worldRenderer, 1 - 11 * pixel / 2, 0, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);

                addVertexWithUV(worldRenderer, 11 * pixel / 2, 0, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 11 * pixel / 2, 26 * texturePixel, 0 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 26 * texturePixel, 5 * texturePixel);
                addVertexWithUV(worldRenderer, 11 * pixel / 2, 0, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            }
        }
        tessellator.draw();

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        if (direction.equals(EnumFacing.SOUTH) || direction.equals(EnumFacing.NORTH)) {
            GL11.glRotatef(-90, 1, 0, 0);
        } else if (direction.equals(EnumFacing.WEST) || direction.equals(EnumFacing.EAST)) {
            GL11.glRotatef(-90, 0, 0, 1);
        }
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
    }

    private static void addVertexWithUV(WorldRenderer renderer, double x, double y, double z, double u, double v)
    {
        renderer.pos(x, y, z).tex(u, v).endVertex();
    }
}
