package main.flowstoneenergy.core.proxies;

import main.flowstoneenergy.blocks.BlockIngotStorage.EnumIngotStorage;
import main.flowstoneenergy.blocks.BlockOres.EnumOreTypes;
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.blocks.decorative.BlockAplite.EnumApliteTypes;
import main.flowstoneenergy.blocks.upgrades.BlockUpgrades.EnumUpgradeType;
//import main.flowstoneenergy.core.client.CustomItemRenderer;
import main.flowstoneenergy.core.client.blocks.RenderMachineWorkbench;
import main.flowstoneenergy.core.client.entities.FlowstoneRobot;
import main.flowstoneenergy.core.client.entities.RenderFactoryRobot;
import main.flowstoneenergy.core.client.entities.RenderRobot;
import main.flowstoneenergy.core.client.transport.RenderFluidPipe;
import main.flowstoneenergy.core.client.transport.RenderItemPipe;
import main.flowstoneenergy.core.client.transport.RenderPowerPipe;
import main.flowstoneenergy.entities.EntityRobot;
import main.flowstoneenergy.items.ItemRegistry;
import main.flowstoneenergy.tileentities.machines.TileEntityMachineWorkbench;
import main.flowstoneenergy.tileentities.transport.TileEntityFluidPipe;
import main.flowstoneenergy.tileentities.transport.TileEntityItemPipe;
import main.flowstoneenergy.tileentities.transport.TileEntityPowerPipe;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.ModelLoader;
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
        RenderingRegistry.registerEntityRenderingHandler(EntityRobot.class, new RenderFactoryRobot());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMachineWorkbench.class, new RenderMachineWorkbench());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityItemPipe.class, new RenderItemPipe());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFluidPipe.class, new RenderFluidPipe());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPowerPipe.class, new RenderPowerPipe());
        //MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.machineWorkbench), new CustomItemRenderer());
    }
    
    @Override
    public void initModels() {
        initModelsBlocks();
        initModelsItems();
    }

    private void initModelsBlocks() {
        
        // Machines
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.machineBox),0, new ModelResourceLocation("flowstoneenergy:block/machine_box", "inventory"));
        
        // Ores
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.blockOres),EnumOreTypes.COPPER.getMeta(), new ModelResourceLocation("flowstoneenergy:ores", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.blockOres),EnumOreTypes.TIN.getMeta(), new ModelResourceLocation("flowstoneenergy:ore_tin", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.blockOres),EnumOreTypes.LEAD.getMeta(), new ModelResourceLocation("flowstoneenergy:ore_lead", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.blockOres),EnumOreTypes.SILVER.getMeta(), new ModelResourceLocation("flowstoneenergy:ore_silver", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.blockOres),EnumOreTypes.NICKEL.getMeta(), new ModelResourceLocation("flowstoneenergy:ore_nickle", "inventory"));
        
        // IngotStorage
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.ingotStorage),EnumIngotStorage.COPPER.getMeta(), new ModelResourceLocation("flowstoneenergy:ingot_storage", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.ingotStorage),EnumIngotStorage.TIN.getMeta(), new ModelResourceLocation("flowstoneenergy:ingotstorage/tin", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.ingotStorage),EnumIngotStorage.LEAD.getMeta(), new ModelResourceLocation("flowstoneenergy:ingotstorage/lead", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.ingotStorage),EnumIngotStorage.SILVER.getMeta(), new ModelResourceLocation("flowstoneenergy:ingotstorage/silver", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.ingotStorage),EnumIngotStorage.ENDER.getMeta(), new ModelResourceLocation("flowstoneenergy:ingotstorage/ender", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.ingotStorage),EnumIngotStorage.NICKEL.getMeta(), new ModelResourceLocation("flowstoneenergy:ingotstorage/nickel", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.ingotStorage),EnumIngotStorage.INVAR.getMeta(), new ModelResourceLocation("flowstoneenergy:ingotstorage/invar", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.ingotStorage),EnumIngotStorage.ELECTRUM.getMeta(), new ModelResourceLocation("flowstoneenergy:ingotstorage/electrum", "inventory"));
        
        // Aplite
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.aplite),EnumApliteTypes.ORE.getMeta(), new ModelResourceLocation("flowstoneenergy:aplite", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.aplite),EnumApliteTypes.COBBLE.getMeta(), new ModelResourceLocation("flowstoneenergy:aplite/cobble", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.aplite),EnumApliteTypes.BRICK.getMeta(), new ModelResourceLocation("flowstoneenergy:aplite/brick", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.aplite),EnumApliteTypes.SMALL_BRICK.getMeta(), new ModelResourceLocation("flowstoneenergy:aplite/small_brick", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.aplite),EnumApliteTypes.CHISELED.getMeta(), new ModelResourceLocation("flowstoneenergy:aplite/chiseled", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.aplite),EnumApliteTypes.BLOCK.getMeta(), new ModelResourceLocation("flowstoneenergy:aplite/block", "inventory"));
        
        // upgrades
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.upgrades),EnumUpgradeType.SPEED.getMeta(), new ModelResourceLocation("flowstoneenergy:upgrades", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.upgrades),EnumUpgradeType.ITEM_CAPACITY.getMeta(), new ModelResourceLocation("flowstoneenergy:upgrades/item_capacity", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.upgrades),EnumUpgradeType.ENERGY_CAPACITY.getMeta(), new ModelResourceLocation("flowstoneenergy:upgrades/energy_capacity", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.upgrades),EnumUpgradeType.ENERGY_EFFICIENCY.getMeta(), new ModelResourceLocation("flowstoneenergy:upgrades/energy_efficiency", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.upgrades),EnumUpgradeType.PROCESS_AMOUNT.getMeta(), new ModelResourceLocation("flowstoneenergy:upgrades/process_amount", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.upgrades),EnumUpgradeType.CREATIVE.getMeta(), new ModelResourceLocation("flowstoneenergy:upgrades/creative", "inventory"));
        
    }

    private void initModelsItems() {
        
        // Dusts
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceDust, 0, new ModelResourceLocation("flowstoneenergy:dust/coal", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceDust, 1, new ModelResourceLocation("flowstoneenergy:dust/iron", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceDust, 2, new ModelResourceLocation("flowstoneenergy:dust/gold", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceDust, 3, new ModelResourceLocation("flowstoneenergy:dust/copper", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceDust, 4, new ModelResourceLocation("flowstoneenergy:dust/tin", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceDust, 5, new ModelResourceLocation("flowstoneenergy:dust/lead", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceDust, 6, new ModelResourceLocation("flowstoneenergy:dust/silver", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceDust, 7, new ModelResourceLocation("flowstoneenergy:dust/small_ender", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceDust, 8, new ModelResourceLocation("flowstoneenergy:dust/ender", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceDust, 9, new ModelResourceLocation("flowstoneenergy:dust/nickel", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceDust, 10, new ModelResourceLocation("flowstoneenergy:dust/invar", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceDust, 11, new ModelResourceLocation("flowstoneenergy:dust/electrum", "inventory"));

        // Ingots
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceIngot, 0, new ModelResourceLocation("flowstoneenergy:ingot/copper", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceIngot, 1, new ModelResourceLocation("flowstoneenergy:ingot/tin", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceIngot, 2, new ModelResourceLocation("flowstoneenergy:ingot/lead", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceIngot, 3, new ModelResourceLocation("flowstoneenergy:ingot/silver", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceIngot, 4, new ModelResourceLocation("flowstoneenergy:ingot/ender", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceIngot, 5, new ModelResourceLocation("flowstoneenergy:ingot/nickel", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceIngot, 6, new ModelResourceLocation("flowstoneenergy:ingot/invar", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceIngot, 7, new ModelResourceLocation("flowstoneenergy:ingot/electrum", "inventory"));

        // Gears
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceGear, 0, new ModelResourceLocation("flowstoneenergy:gear/wood", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceGear, 1, new ModelResourceLocation("flowstoneenergy:gear/stone", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceGear, 2, new ModelResourceLocation("flowstoneenergy:gear/iron", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceGear, 3, new ModelResourceLocation("flowstoneenergy:gear/gold", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceGear, 4, new ModelResourceLocation("flowstoneenergy:gear/quartz", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceGear, 5, new ModelResourceLocation("flowstoneenergy:gear/diamond", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceGear, 6, new ModelResourceLocation("flowstoneenergy:gear/copper", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceGear, 7, new ModelResourceLocation("flowstoneenergy:gear/tin", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceGear, 8, new ModelResourceLocation("flowstoneenergy:gear/lead", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceGear, 9, new ModelResourceLocation("flowstoneenergy:gear/silver", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceGear, 10, new ModelResourceLocation("flowstoneenergy:gear/ender", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceGear, 11, new ModelResourceLocation("flowstoneenergy:gear/electrum", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceGear, 12, new ModelResourceLocation("flowstoneenergy:gear/nickel", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.metaResourceGear, 13, new ModelResourceLocation("flowstoneenergy:gear/invar", "inventory"));

        // Batteries
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.tierOne, 0, new ModelResourceLocation("flowstoneenergy:battery_tier_one", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.tierTwo, 0, new ModelResourceLocation("flowstoneenergy:battery_tier_two", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.tierThree, 0, new ModelResourceLocation("flowstoneenergy:battery_tier_three", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.tierFour, 0, new ModelResourceLocation("flowstoneenergy:battery_tier_four", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.tierFive, 0, new ModelResourceLocation("flowstoneenergy:battery_tier_five", "inventory"));
        
        // Wrench
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.flowwrench, 0, new ModelResourceLocation("flowstoneenergy:flowwrench", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.pneumaticFlowwrench, 0, new ModelResourceLocation("flowstoneenergy:flowwrench_pneumatic", "inventory"));
        
        // Tools
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.enderSword, 0, new ModelResourceLocation("flowstoneenergy:ender_sword", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.enderPick, 0, new ModelResourceLocation("flowstoneenergy:ender_pick", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.enderHoe, 0, new ModelResourceLocation("flowstoneenergy:ender_hoe", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.enderShovel, 0, new ModelResourceLocation("flowstoneenergy:ender_shovel", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.enderAxe, 0, new ModelResourceLocation("flowstoneenergy:ender_axe", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.electrumSword, 0, new ModelResourceLocation("flowstoneenergy:electrum_sword", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.electrumPick, 0, new ModelResourceLocation("flowstoneenergy:electrum_pick", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.electrumHoe, 0, new ModelResourceLocation("flowstoneenergy:electrum_hoe", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.electrumShovel, 0, new ModelResourceLocation("flowstoneenergy:electrum_shovel", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.electrumAxe, 0, new ModelResourceLocation("flowstoneenergy:electrum_axe", "inventory"));

        // Armor
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.flowBoots, 0, new ModelResourceLocation("flowstoneenergy:flow_boots", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.flowLeggings, 0, new ModelResourceLocation("flowstoneenergy:flow_leggings", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.flowChestplate, 0, new ModelResourceLocation("flowstoneenergy:flow_chestplate", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.flowHelm, 0, new ModelResourceLocation("flowstoneenergy:flow_helmet", "inventory"));

        // Misc
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.manual, 0, new ModelResourceLocation("flowstoneenergy:manual", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.flowstoneBucket, 0, new ModelResourceLocation("flowstoneenergy:bucket_flowstone", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemRegistry.fluidBlazeBucket, 0, new ModelResourceLocation("flowstoneenergy:bucket_blaze", "inventory"));

    }

}