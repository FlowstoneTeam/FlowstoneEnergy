package main.flowstoneenergy.blocks.blockedingots;

import main.flowstoneenergy.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTin extends Block{
	public BlockTin() {
		super(Material.iron);
		this.setHardness(0.5F);
		this.setBlockName(ModInfo.MODID+".TinBlock");
		this.setBlockTextureName(ModInfo.MODID+":blockedingots/blockTin");
	}

}
