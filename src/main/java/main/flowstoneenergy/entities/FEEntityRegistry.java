package main.flowstoneenergy.entities;

import main.flowstoneenergy.FlowstoneEnergy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import cpw.mods.fml.common.registry.EntityRegistry;

public class FEEntityRegistry {

    public static void init() {
        EntityRegistry.registerModEntity(EntityRobot.class, "EntityRobot", EntityRegistry.findGlobalUniqueEntityId(), FlowstoneEnergy.instance, 80, 3, true);
        
        registerEntityEgg(EntityRobot.class, 0, 0);
    }

    @SuppressWarnings("unchecked")
    public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor)
    {
        int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(Integer.valueOf(id), entity);
        EntityList.entityEggs.put(Integer.valueOf(id), new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
    }
        
    public static int getUniqueEntityId()
    {
    	int startEntityId = 400;
        do
        {
            ++startEntityId ;
        }
        while (EntityList.getStringFromID(startEntityId) != null);

        return startEntityId;
    }
}
