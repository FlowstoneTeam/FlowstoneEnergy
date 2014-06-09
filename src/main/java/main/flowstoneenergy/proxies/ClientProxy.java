package main.flowstoneenergy.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.client.Blocks.RenderMachineWorkbench;
import main.flowstoneenergy.client.CustomItemRenderer;
import main.flowstoneenergy.client.Entities.FlowstoneRobot;
import main.flowstoneenergy.client.Entities.RenderRobot;
import main.flowstoneenergy.entities.EntityRobot;
import cpw.mods.fml.client.registry.RenderingRegistry;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineWorkbench;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

    @Override
    public void initSounds() {
    }

    @Override
    public void initRenderers() {
        super.initRenderers();
    	RenderingRegistry.registerEntityRenderingHandler(EntityRobot.class, new RenderRobot(new FlowstoneRobot(),0.3F));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMachineWorkbench.class, new RenderMachineWorkbench());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.machineWorkbench), new CustomItemRenderer());
    }

}