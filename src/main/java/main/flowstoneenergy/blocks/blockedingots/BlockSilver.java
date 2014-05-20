package main.flowstoneenergy.blocks.blockedingots;

import main.flowstoneenergy.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSilver extends Block{
	public BlockSilver() {
		super(Material.iron);
		this.setHardness(0.25F);
		this.setBlockName(ModInfo.MODID+".SilverBlock");
		this.setBlockTextureName(ModInfo.MODID+":blockedingots/blockSilver");
	}

}
