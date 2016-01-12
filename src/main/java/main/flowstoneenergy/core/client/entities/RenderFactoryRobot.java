package main.flowstoneenergy.core.client.entities;

import main.flowstoneenergy.entities.EntityRobot;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFactoryRobot implements IRenderFactory<EntityRobot> {

    @Override
    public Render<? super EntityRobot> createRenderFor(RenderManager manager) {
        return new RenderRobot(manager, new FlowstoneRobot(), 0.5F);
    }

}
