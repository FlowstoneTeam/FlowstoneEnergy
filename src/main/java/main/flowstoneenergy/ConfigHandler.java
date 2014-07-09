package main.flowstoneenergy;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	//Categories
	public static String general = "General";
	public static String enchant = "Enchantments";
	public static String oreConfig = "Ore Configuration";

	//Options
    public static boolean useFECopper;
    public static boolean useFETin;
    public static boolean useFELead;
    public static boolean useFESilver;
    public static boolean useFENickel;
    public static boolean useFEApalite;
	public static boolean useConnectedTextures;
    public static boolean capesOn;
    public static int teleEnchant;
    public static boolean debugMode;
    public static boolean drawInsidePipes;

    public static void configOptions(Configuration config) {
        config.load();

		//General
	    capesOn = config.get(general, "Enable showing capes", true, "This config option is to enable or disable capes for people who have them. Seriously, you shouldn't touch that unless you have another cape and it conflicts with it.").getBoolean(capesOn);
	    debugMode = config.get(general, "Enable debug mode", false).getBoolean(debugMode);
	    useConnectedTextures = config.get(general, "Enable connected textures for machines", true).getBoolean(useConnectedTextures);
        drawInsidePipes = config.get(general, "Enable inside of pipes", true).getBoolean(drawInsidePipes);
	    
	    //Enchantments
	    teleEnchant = config.get(enchant, "Teleport Enchanment Id", 40).getInt(teleEnchant);
	    
	    //Ores
        useFECopper = config.get(oreConfig, "Enable Flowstone Energy copper generation", true).getBoolean(useFECopper);
        useFETin = config.get(oreConfig, "Enable Flowstone Energy tin generation", true).getBoolean(useFETin);
        useFELead = config.get(oreConfig, "Enable Flowstone Energy lead generation", true).getBoolean(useFELead);
        useFESilver = config.get(oreConfig, "Enable Flowstone Energy silver generation", true).getBoolean(useFESilver);
        useFENickel = config.get(oreConfig, "Enable Flowstone Energy nickel generation", true).getBoolean(useFENickel);
        useFEApalite = config.get(oreConfig, "Enable Flowstone Energy apalite generation", true).getBoolean(useFEApalite);

        if (config.hasChanged()) config.save();
    }
}
