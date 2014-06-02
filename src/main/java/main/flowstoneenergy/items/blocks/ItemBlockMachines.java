package main.flowstoneenergy.items.blocks;

import main.flowstoneenergy.blocks.machines.BlockMachines;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

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
                name = "heatedOven";
                break;
            }
            case 1: {
                name = "oreTumbler";
                break;
            }
            case 2: {
                name = "flowstoneBottler";
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
                name = "machineWorkbench";
                break;
            }
            case 6: {
                name = "liquifier";
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
