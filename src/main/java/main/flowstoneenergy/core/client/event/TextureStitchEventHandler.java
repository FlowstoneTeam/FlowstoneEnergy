package main.flowstoneenergy.core.client.event;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TextureStitchEventHandler {
    
    public static TextureStitchEventHandler INSTANCE = new TextureStitchEventHandler();
    
    @SubscribeEvent
    public void onPreTextureStiching(TextureStitchEvent.Pre event){
        if (event.map == FMLClientHandler.instance().getClient().getTextureMapBlocks()){
            event.map.registerSprite(new ResourceLocation("flowstoneenergy:blocks/machines/machine_Top"));
            event.map.registerSprite(new ResourceLocation("flowstoneenergy:blocks/machines/machine_Bottom"));
            event.map.registerSprite(new ResourceLocation("flowstoneenergy:blocks/machines/oreTumbler_Front"));
            event.map.registerSprite(new ResourceLocation("flowstoneenergy:blocks/machines/oreTumbler_Front_Active"));
            event.map.registerSprite(new ResourceLocation("flowstoneenergy:blocks/machines/flowstoneBottler_Front"));
            event.map.registerSprite(new ResourceLocation("flowstoneenergy:blocks/machines/flowstoneBottler_Front_Activate"));
            event.map.registerSprite(new ResourceLocation("flowstoneenergy:blocks/machines/furnace_Front"));
            event.map.registerSprite(new ResourceLocation("flowstoneenergy:blocks/machines/furnace_Front_Active"));
            event.map.registerSprite(new ResourceLocation("flowstoneenergy:blocks/machines/lumberMill_Front"));
            event.map.registerSprite(new ResourceLocation("flowstoneenergy:blocks/machines/lumberMill_Front_Active"));
            event.map.registerSprite(new ResourceLocation("flowstoneenergy:blocks/machines/metalMixer_Front"));
            event.map.registerSprite(new ResourceLocation("flowstoneenergy:blocks/machines/metalMixer_Front_Active"));
            event.map.registerSprite(new ResourceLocation("flowstoneenergy:blocks/machines/cooler_Front"));
            event.map.registerSprite(new ResourceLocation("flowstoneenergy:blocks/machines/cooler_Front_Active"));
        }
        
    }
    @SubscribeEvent
    public void onPostTextureStichting(TextureStitchEvent.Post event){
        
    }
}
