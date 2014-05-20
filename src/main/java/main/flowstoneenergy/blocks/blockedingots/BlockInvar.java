package main.flowstoneenergy.blocks.blockedingots;

import main.flowstoneenergy.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInvar extends Block{
	public BlockInvar() {
		super(Material.iron);
		this.setHardness(0.5F);
		this.setBlockName(ModInfo.MODID+".InvarBlock");
		this.setBlockTextureName(ModInfo.MODID+":blockedingots/blockInvar");
	}
}
