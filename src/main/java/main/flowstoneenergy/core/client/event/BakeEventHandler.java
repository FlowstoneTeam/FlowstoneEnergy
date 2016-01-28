package main.flowstoneenergy.core.client.event;

import main.flowstoneenergy.core.client.models.SmartModelMachines;
import main.flowstoneenergy.core.proxies.ClientProxy;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BakeEventHandler {

    public static BakeEventHandler INSTANCE = new BakeEventHandler(); 
    
    @SubscribeEvent
    public void onModelBakeEvent(ModelBakeEvent event){
        TextureMap blockMap = FMLClientHandler.instance().getClient().getTextureMapBlocks();
        TextureAtlasSprite textures[]  = new TextureAtlasSprite[15];
        textures[0] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/machine_Top");
        textures[1] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/machine_Bottom");
        textures[2] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/machine_Side_0");
        textures[3] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/oreTumbler_Front");
        textures[4] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/oreTumbler_Front_Active");
        textures[5] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/flowstoneBottler_Front");
        textures[6] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/flowstoneBottler_Front_Activate");
        textures[7] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/furnace_Front");
        textures[8] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/furnace_Front_Active");
        textures[9] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/lumberMill_Front");
        textures[10] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/lumberMill_Front_Active");
        textures[11] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/metalMixer_Front");
        textures[12] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/metalMixer_Front_Active");
        textures[13] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/cooler_Front");
        textures[14] = blockMap.getAtlasSprite("flowstoneenergy:blocks/machines/cooler_Front_Active");
        
        
        IBakedModel machineModel = new SmartModelMachines(textures);
        
        event.modelRegistry.putObject(ClientProxy.machinesBlockLocation, machineModel);
        event.modelRegistry.putObject(ClientProxy.machinesItemLocation, machineModel);
    }
}
