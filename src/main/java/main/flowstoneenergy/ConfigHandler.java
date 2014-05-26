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
    public static boolean capesOn;
    public static int teleEnchant;

    public static void configOptions(Configuration config) {
        config.load();

		//General
	    capesOn = config.get(general, "Enable showing capes", true, "This config option is to enable or disable capes for people who have them. Seriously, you shouldn't touch that unless you have another cape and it conflicts with it.").getBoolean(capesOn);

	    //Enchantments
	    teleEnchant = config.get(enchant, "Teleport Enchanment Id", 40).getInt(teleEnchant);
	    
	    //Ores
        useFECopper = config.get(oreConfig, "Enable Flowstone Energy Copper", true).getBoolean(useFECopper);
        useFETin = config.get(oreConfig, "Enable Flowstone Energy Tin", true).getBoolean(useFETin);
        useFELead = config.get(oreConfig, "Enable Flowstone Energy Lead", true).getBoolean(useFELead);
        useFESilver = config.get(oreConfig, "Enable Flowstone Energy Silver", true).getBoolean(useFESilver);
        useFENickel = config.get(oreConfig, "Enable Flowstone Energy Nickel", true).getBoolean(useFENickel);

        if (config.hasChanged()) config.save();
    }
}
