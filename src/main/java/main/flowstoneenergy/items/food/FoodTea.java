package main.flowstoneenergy.items.food;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.libs.ModInfo;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class FoodTea extends ItemFood {

    public FoodTea() {
        super(4, false);
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setTextureName(ModInfo.MODID + ":food/tea");
        this.setUnlocalizedName(ModInfo.MODID + ".tea");
        this.setAlwaysEdible();
        this.setMaxStackSize(1);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.drink;
    }
}