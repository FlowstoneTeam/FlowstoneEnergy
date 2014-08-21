package main.flowstoneenergy.enchants;

import main.flowstoneenergy.core.libs.ConfigHandler;

public class EnchantRegistry {
    public static EnchantRandTele randTeleEnchant;

    public static void registerEnchants() {
        randTeleEnchant = new EnchantRandTele(ConfigHandler.teleEnchant, 0);
    }
}
