package main.flowstoneenergy.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMachines extends ItemBlock {

    public ItemBlockMachines(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "oreTumbler";
                break;
            }
            case 1: {
                name = "flowstoneBottler";
                break;
            }
            case 2: {
                name = "heatedOven";
                break;
            }
            case 3: {
                name = "lumberMill";
                break;
            }
            case 4: {
                name = "metalMixer";
                break;
            }
            case 5: {
                name = "liquifier";
                break;
            }
            case 6: {
                name = "liquidInfuser";
                break;
            }
            case 7: {
                name = "autoCrafter";
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
