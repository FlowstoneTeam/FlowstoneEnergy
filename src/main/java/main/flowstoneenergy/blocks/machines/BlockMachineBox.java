package main.flowstoneenergy.blocks.machines;

import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.interfaces.IWrenchable;
import main.flowstoneenergy.utils.BlockUtils;
import main.flowstoneenergy.utils.ItemUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockMachineBox extends Block implements IWrenchable {

    public BlockMachineBox() {
        super(Material.iron);
        this.setBlockName(ModInfo.MODID + ".MachineBox");
        this.setBlockTextureName(ModInfo.MODID + ":machines/machine_Side");
    }

    @Override
    public boolean canWrenchRemove() {
        return true;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        checkInput(world, x, y, z, player);
        return true;
    }

    private void checkInput(World world, int x, int y, int z, EntityPlayer player) {
        if (player.getHeldItem() == new ItemStack(ItemUtils.metaResourceGear, 1, 1)) {
            player.setItemInUse(null, 0);
            world.setBlock(x, y, z, BlockUtils.heatedOven);
        } else if (player.getHeldItem() == new ItemStack(ItemUtils.metaResourceGear, 1, 2)) {
            player.setItemInUse(null, 0);
            world.setBlock(x, y, z, BlockUtils.energizedOreTumbler);
        }
    }
}
