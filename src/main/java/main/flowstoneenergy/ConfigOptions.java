package main.flowstoneenergy;

import net.minecraftforge.common.config.Configuration;

public class ConfigOptions {
	public static boolean useFECopper;
	public static boolean useFETin;
	public static boolean useFELead;
	public static boolean useFESilver;
	public static boolean useFENickel;
	public static boolean capesOn;
	public static void configOptions(Configuration config) {
		config.load();
		
		useFECopper = config.get("Ores Configurations", "Enable Flowstone Energy Copper", true).getBoolean(useFECopper);
		useFETin = config.get("Ores Configurations", "Enable Flowstone Energy Tin", true).getBoolean(useFETin);
		useFELead = config.get("Ores Configurations", "Enable Flowstone Energy Lead", true).getBoolean(useFELead);
		useFESilver = config.get("Ores Configurations", "Enable Flowstone Energy Silver", true).getBoolean(useFESilver);
		useFENickel = config.get("Ores Configurations", "Enable Flowstone Energy Nickel", true).getBoolean(useFENickel);
		capesOn = config.get(Configuration.CATEGORY_GENERAL, "Enable showing capes", true, "This config option is to enable or disable capes for people who have them. " + "Seriously, you shouldn't touch that unless you have another cape and " + "it conflicts with it.").getBoolean(capesOn);
		
		if (config.hasChanged()) config.save();
	}
}
