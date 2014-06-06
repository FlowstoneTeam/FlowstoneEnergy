package main.flowstoneenergy.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockAplite extends ItemBlock {

    public ItemBlockAplite(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "ore";
                break;
            }
            case 1: {
                name = "cobble";
                break;
            }
            case 2: {
                name = "brick";
                break;
            }
            case 3: {
                name = "smallBrick";
                break;
            }
            case 4: {
                name = "chiseled";
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