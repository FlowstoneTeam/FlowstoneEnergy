package main.flowstoneenergy.enchants;

import main.flowstoneenergy.ConfigHandler;

public class EnchantRegistry {
    public static EnchantRandTele randTeleEnchant;

    public static void initEnchants() {
        randTeleEnchant = new EnchantRandTele(ConfigHandler.teleEnchant, 0);
    }
}
