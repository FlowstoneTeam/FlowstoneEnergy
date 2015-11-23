package main.flowstoneenergy.enchants;

import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;

public class EnchantRandTele extends Enchantment {
    public EnchantRandTele(int enchID, int enchWeight) {
        super(enchID, null, enchWeight, EnumEnchantmentType.WEAPON);
        this.setName(ModInfo.MODID + ".randomTeleport");
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinEnchantability(int level) {
        return 25;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return canApply(stack);
    }

    @Override
    public boolean canApply(ItemStack itemStack) {
        return this.type.canEnchantItem(itemStack.getItem());
    }

    public static void addToBookList(Enchantment enchantment) {
        com.google.common.collect.ObjectArrays.concat(enchantmentsBookList, enchantment);
    }
}