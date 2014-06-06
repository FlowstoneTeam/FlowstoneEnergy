package main.flowstoneenergy.blocks.machines;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.interfaces.IFlowWrenchable;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMachineBox extends BlockContainer implements IFlowWrenchable {

    public BlockMachineBox() {
        super(Material.iron);
        this.setBlockName(ModInfo.MODID + ".MachineBox");
        this.setBlockTextureName(ModInfo.MODID + ":machines/machine_Side");
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(FlowstoneEnergy.blockTab);
        this.setHardness(7);
    }

    @Override
    public boolean canWrenchRemove() {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return null;
    }
}
