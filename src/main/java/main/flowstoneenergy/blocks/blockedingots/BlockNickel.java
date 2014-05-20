package main.flowstoneenergy.blocks.blockedingots;

import main.flowstoneenergy.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNickel extends Block{
	public BlockNickel() {
		super(Material.iron);
		this.setHardness(0.5F);
		this.setBlockName(ModInfo.MODID+".NickelBlock");
		this.setBlockTextureName(ModInfo.MODID+":blockedingots/blockNickel");
	}

}
