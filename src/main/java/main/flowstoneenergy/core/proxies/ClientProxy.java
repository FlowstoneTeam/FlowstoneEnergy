package main.flowstoneenergy.core.proxies;

import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.core.client.CustomItemRenderer;
import main.flowstoneenergy.core.client.blocks.RenderMachineWorkbench;
import main.flowstoneenergy.core.client.entities.FlowstoneRobot;
import main.flowstoneenergy.core.client.entities.RenderRobot;
import main.flowstoneenergy.core.client.transport.RenderFluidPipe;
import main.flowstoneenergy.core.client.transport.RenderItemPipe;
import main.flowstoneenergy.core.client.transport.RenderPowerPipe;
import main.flowstoneenergy.entities.EntityRobot;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineWorkbench;
import main.flowstoneenergy.tileentities.transport.TileEntityFluidPipe;
import main.flowstoneenergy.tileentities.transport.TileEntityItemPipe;
import main.flowstoneenergy.tileentities.transport.TileEntityPowerPipe;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void initSounds() {
    }

    @Override
    public void initRenderers() {
        super.initRenderers();
        RenderManager renderManager = FMLClientHandler.instance().getClient().getRenderManager();
        RenderingRegistry.registerEntityRenderingHandler(EntityRobot.class, new RenderRobot(renderManager, new FlowstoneRobot(), 0.3F));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMachineWorkbench.class, new RenderMachineWorkbench());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityItemPipe.class, new RenderItemPipe());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFluidPipe.class, new RenderFluidPipe());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPowerPipe.class, new RenderPowerPipe());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.machineWorkbench), new CustomItemRenderer());
    }

}