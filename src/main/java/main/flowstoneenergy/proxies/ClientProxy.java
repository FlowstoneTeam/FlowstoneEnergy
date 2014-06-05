package main.flowstoneenergy.proxies;

import main.flowstoneenergy.client.Entities.FlowstoneRobot;
import main.flowstoneenergy.client.Entities.RenderRobot;
import main.flowstoneenergy.entities.EntityRobot;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void initSounds() {
    }

    @Override
    public void initRenderers() {
        super.initRenderers();
    	RenderingRegistry.registerEntityRenderingHandler(EntityRobot.class, new RenderRobot(new FlowstoneRobot(),0.3F));
    }

}