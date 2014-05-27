package main.flowstoneenergy.entities;

import cpw.mods.fml.common.registry.EntityRegistry;
import main.flowstoneenergy.FlowstoneEnergy;

public class FEEntityRegistry {

    public static void init() {
        EntityRegistry.registerModEntity(EntityRobot.class, "EntityRobot", 0, FlowstoneEnergy.instance, 80, 3, true);
    }

}
