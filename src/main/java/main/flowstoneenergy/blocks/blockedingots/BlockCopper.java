package main.flowstoneenergy.blocks.blockedingots;

import main.flowstoneenergy.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCopper extends Block{

	public BlockCopper() {
		super(Material.iron);
		this.setHardness(0.35F);
		this.setBlockName(ModInfo.MODID+".CopperBlock");
		this.setBlockTextureName(ModInfo.MODID+":blockedingots/blockCopper");
	}

}
