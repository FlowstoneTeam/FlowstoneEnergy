package main.flowstoneenergy.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockUpgrades extends ItemBlock {

    public ItemBlockUpgrades(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "speed";
                break;
            }
            case 1: {
                name = "itemCapacity";
                break;
            }
            case 2: {
                name = "energyCapacity";
                break;
            }
            case 3: {
                name = "energyStorage";
                break;
            }
            case 4: {
                name = "processAmount";
                break;
            }
            default:
                name = "nothing";
        }
        return getUnlocalizedName() + "." + name;
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}
