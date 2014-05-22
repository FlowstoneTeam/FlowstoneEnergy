package main.flowstoneenergy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import main.flowstoneenergy.blocks.BlockRecipeRegistry;
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.events.CapeEventHandler;
import main.flowstoneenergy.gui.CreativeTab;
import main.flowstoneenergy.gui.GuiHandler;
import main.flowstoneenergy.items.ItemRecipeRegistry;
import main.flowstoneenergy.items.ItemRegistry;
import main.flowstoneenergy.tileentities.TERegistry;
import main.flowstoneenergy.utils.GenerationHandler;
import main.flowstoneenergy.utils.oreDictHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class FlowstoneEnergy {
    public static CreativeTabs tab = new CreativeTab("FlowstoneEnergy");
    @Instance
    public static FlowstoneEnergy instance;
    Configuration config;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        ConfigHandler.configOptions(config);
        BlockRegistry.registerFullBlocks();
	    BlockRecipeRegistry.registerBlockFullRecipes();
        ItemRegistry.registerItems();
	    ItemRecipeRegistry.registerRecipes();
        TERegistry.registerTileEntities();
	    oreDictHandler.registerOreDict();
        GameRegistry.registerWorldGenerator(new GenerationHandler(), 10);
        NetworkRegistry.INSTANCE.registerGuiHandler(FlowstoneEnergy.instance, new GuiHandler());
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT && ConfigHandler.capesOn) {
            MinecraftForge.EVENT_BUS.register(new CapeEventHandler());
        }
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    }
}
