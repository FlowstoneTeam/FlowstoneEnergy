package main.flowstoneenergy.proxies;

import main.flowstoneenergy.client.entities.FlowstoneRobot;
import main.flowstoneenergy.client.entities.RenderRobot;
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