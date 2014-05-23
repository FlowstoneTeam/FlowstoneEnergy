package main.flowstoneenergy.client;
/**
import org.lwjgl.opengl.GL11;

import main.flowstoneenergy.entities.EntityRobot;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderRobot extends Render{
	/**
	protected ModelRobot model;
	
	public RenderRobot() {
		shadowSize = 0.5F;
		model = new ModelRobot();
	}
	
	public void renderRobot(EntityRobot robot, double x, double y, double z, float yaw, float partialTickTime) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glRotatef(180.0F - yaw, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		
		func_110777_b(robot);
		
		model.render(robot, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		
		GL11.glPopMatrix();
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime) {
		// TODO Auto-generated method stub
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return null;
	}
}
	*/