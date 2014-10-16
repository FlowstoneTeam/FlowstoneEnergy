package main.flowstoneenergy.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemBlockGenerators extends ItemBlockMachines {

    public ItemBlockGenerators(Block block) {
        super(block);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        String name = "";
        
        int damage = itemStack.getItemDamage();
        switch (damage){
            case 0:
                name = "coal";
                break;
            case 1:
                name = "flowstone";
                break;
            case 2:
                name = "lava";
                break;
            case 3:
                name = "solar";
                break;
            default:
                name = "unknown";
        }
        
        name = getUnlocalizedName() + "." + name;
        
        return name;
    }

}
