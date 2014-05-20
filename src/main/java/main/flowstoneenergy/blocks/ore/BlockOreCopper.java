package main.flowstoneenergy.blocks.ore;

import main.flowstoneenergy.ModInfo;
import net.minecraft.block.BlockOre;

public class BlockOreCopper extends BlockOre {
	public BlockOreCopper() {
		super();
		this.setHardness(3);
		this.setBlockName(ModInfo.MODID+".LeadOre");
		this.setBlockTextureName(ModInfo.MODID+":ores/leadOre");
	}
}
