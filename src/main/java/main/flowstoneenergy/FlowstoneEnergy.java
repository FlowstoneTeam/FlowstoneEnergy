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
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.events.CapeEventHandler;
import main.flowstoneenergy.gui.CreativeTab;
import main.flowstoneenergy.gui.GuiHandler;
import main.flowstoneenergy.items.ItemRegistry;
import main.flowstoneenergy.items.RecipeRegistry;
import main.flowstoneenergy.tileentities.TERegistry;
import main.flowstoneenergy.tileentities.recipes.RecipesHeatedOven;
import main.flowstoneenergy.utils.GenerationHandler;
import main.flowstoneenergy.utils.oreDictHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.util.Map;
import java.util.Map.Entry;

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
        ItemRegistry.registerItems();
	    RecipeRegistry.registerRecipes();
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
        Map<?, ?> smelting = FurnaceRecipes.smelting().getSmeltingList();
        for (Entry<?, ?> kvp : smelting.entrySet()) {
            ItemStack output = (ItemStack) kvp.getValue();
            ItemStack input = (ItemStack) kvp.getKey();
            RecipesHeatedOven.AddRecipe(input, output, 200);
        }
    }
}
