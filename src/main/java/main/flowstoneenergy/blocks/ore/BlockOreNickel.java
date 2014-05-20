package main.flowstoneenergy.blocks.ore;

import main.flowstoneenergy.ModInfo;
import net.minecraft.block.BlockOre;

public class BlockOreNickel extends BlockOre{
	public BlockOreNickel() {
		super();
		this.setHardness(7);
		this.setBlockName(ModInfo.MODID+".NickelOre");
		this.setBlockTextureName(ModInfo.MODID+":ores/nickelOre");
	}

}
