package main.flowstoneenergy.blocks.ore;

import main.flowstoneenergy.ModInfo;
import net.minecraft.block.BlockOre;

public class BlockOreSilver extends BlockOre {
    public BlockOreSilver() {
        super();
        this.setHardness(7);
        this.setBlockName(ModInfo.MODID + ".SilverOre");
        this.setBlockTextureName(ModInfo.MODID + ":ores/SilverOre");
    }
}
