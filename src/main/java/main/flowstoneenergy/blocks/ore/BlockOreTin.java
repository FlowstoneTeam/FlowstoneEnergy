package main.flowstoneenergy.blocks.ore;

import main.flowstoneenergy.ModInfo;
import net.minecraft.block.BlockOre;

public class BlockOreTin extends BlockOre {
    public BlockOreTin() {
        super();
        this.setHardness(7);
        this.setBlockName(ModInfo.MODID + ".TinOre");
        this.setBlockTextureName(ModInfo.MODID + ":ores/TinOre");
    }
}
