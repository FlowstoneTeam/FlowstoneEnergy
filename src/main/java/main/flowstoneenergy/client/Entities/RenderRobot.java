package main.flowstoneenergy.client.entities;

import main.flowstoneenergy.entities.EntityRobot;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.ModInfo;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderRobot extends RenderLiving {
	protected FlowstoneRobot model;
	
	public RenderRobot(FlowstoneRobot model, float par2) {
		super(model, par2);
		shadowSize = 0.5F;
		model = new FlowstoneRobot();
	}
	
	public void renderRobot(EntityRobot robot, double x, double y, double z, float yaw, float partialTickTime) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glRotatef(180.0F - yaw, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		
		model.render(robot, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		
		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime) {
		super.doRender(entity, x, y, z, yaw, partialTickTime);
	}

	@Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        if (EntityRobot.isCharged())
            return new ResourceLocation(ModInfo.MODID + ":textures/models/FlowstoneRobot.png");
        else
            return new ResourceLocation(ModInfo.MODID + ":textures/models/FlowstoneRobot_off.png");
    }
}