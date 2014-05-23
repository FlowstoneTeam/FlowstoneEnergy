package main.flowstoneenergy.entities;

import main.flowstoneenergy.FlowstoneEnergy;
import cpw.mods.fml.common.registry.EntityRegistry;

public class FEEntityRegistry {
	public static void init() {
		EntityRegistry.registerModEntity(EntityRobot.class, "EntityRobot", 0, FlowstoneEnergy.instance, 80, 3, true);
	}
	
}
