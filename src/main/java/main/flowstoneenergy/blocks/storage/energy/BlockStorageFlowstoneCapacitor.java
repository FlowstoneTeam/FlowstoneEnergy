package main.flowstoneenergy.blocks.storage.energy;

import main.flowstoneenergy.FlowstoneEnergy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockStorageFlowstoneCapacitor extends Block {

    protected BlockStorageFlowstoneCapacitor(Material material) {
        super(material);
        this.setCreativeTab(FlowstoneEnergy.blockTab);
    }

}
