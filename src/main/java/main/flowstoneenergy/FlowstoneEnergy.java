package main.flowstoneenergy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.blocks.BlockRecipeRegistry;
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.blocks.fluids.BucketRegistry;
import main.flowstoneenergy.blocks.fluids.FluidRecipeRegistry;
import main.flowstoneenergy.enchants.EnchantRandTeleHandler;
import main.flowstoneenergy.enchants.EnchantRegistry;
import main.flowstoneenergy.entities.FEEntityRegistry;
import main.flowstoneenergy.core.events.EntityEventHandler;
import main.flowstoneenergy.core.client.gui.BlockCreativeTab;
import main.flowstoneenergy.core.client.gui.CreativeTab;
import main.flowstoneenergy.core.client.gui.GuiHandler;
import main.flowstoneenergy.items.ItemRecipeRegistry;
import main.flowstoneenergy.items.ItemRegistry;
import main.flowstoneenergy.core.libs.ConfigHandler;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.core.proxies.CommonProxy;
import main.flowstoneenergy.tileentities.TERegistry;
import main.flowstoneenergy.core.utils.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class FlowstoneEnergy {
    public static CreativeTabs blockTab = new BlockCreativeTab("FlowstoneEnergyBlocks");
    public static CreativeTabs tab = new CreativeTab("FlowstoneEnergyItems");
    public static Logger logger = LogManager.getLogger(ModInfo.NAME);

    @Instance("flowstoneenergy")
    public static FlowstoneEnergy instance;
    Configuration config;

    @SidedProxy(clientSide = ModInfo.CLIENTPROXY, serverSide = ModInfo.COMMONPROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        ConfigHandler.configOptions(config);

        MinecraftForge.EVENT_BUS.register(new EnchantRandTeleHandler());
        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
        EnchantRegistry.registerEnchants();
        BlockRegistry.registerBlocks();
        ItemRegistry.registerItems();
        FluidRecipeRegistry.registerFluidRecipes();
        TERegistry.registerTileEntities();
        BucketRegistry.registerBucket();

        OreDictHandler.registerOreDict();
        GameRegistry.registerWorldGenerator(new GenerationHandler(), 2);
        NetworkRegistry.INSTANCE.registerGuiHandler(FlowstoneEnergy.instance, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());
        PacketHandler.init();

        proxy.load();
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        FEEntityRegistry.init();
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        ItemRecipeRegistry.registerFullRecipes();
        BlockRecipeRegistry.registerFullRecipes();
    }
}
