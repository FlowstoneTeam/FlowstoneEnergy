package main.flowstoneenergy.blocks.ore;

import main.flowstoneenergy.ModInfo;
import net.minecraft.block.BlockOre;

public class BlockOreLead extends BlockOre {
    public BlockOreLead() {
        super();
        this.setHardness(7);
        this.setBlockName(ModInfo.MODID + ".LeadOre");
        this.setBlockTextureName(ModInfo.MODID + ":ores/leadOre");
    }
}
