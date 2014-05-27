package main.flowstoneenergy.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOres extends ItemBlock {

    public ItemBlockOres(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "copper";
                break;
            }
            case 1: {
                name = "tin";
                break;
            }
            case 2: {
                name = "lead";
                break;
            }
            case 3: {
                name = "silver";
                break;
            }
            case 4: {
                name = "nickel";
                break;
            }
            default:
                name = "nothing";
        }
        return getUnlocalizedName() + "." + name;
    }

    @Override
    public int getMetadata(int par1) {
        return par1;
    }
}
