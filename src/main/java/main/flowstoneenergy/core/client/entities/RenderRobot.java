package main.flowstoneenergy.core.client.entities;

import main.flowstoneenergy.entities.EntityRobot;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderRobot extends RenderLiving<EntityRobot> {
    protected FlowstoneRobot model;

    public RenderRobot(RenderManager renderManager, FlowstoneRobot model, float shadowSize) {
        super(renderManager, model, shadowSize);
        //FIXME: Remove if not needed
        this.shadowSize = 0.5F;
        model = new FlowstoneRobot();
    }

    public void doRender(EntityRobot robot, double x, double y, double z, float yaw, float partialTicks) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x, (float) y, (float) z);
        GL11.glRotatef(180.0F - yaw, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);

        model.render(robot, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityRobot entity) {
        if (entity.isCharged())
            return new ResourceLocation(ModInfo.MODID + ":textures/models/FlowstoneRobot.png");
        else
            return new ResourceLocation(ModInfo.MODID + ":textures/models/FlowstoneRobot_off.png");
    }

}