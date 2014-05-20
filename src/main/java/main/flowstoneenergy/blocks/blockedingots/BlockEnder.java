package main.flowstoneenergy.blocks.blockedingots;

import main.flowstoneenergy.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockEnder extends Block{
	public BlockEnder() {
		super(Material.iron);
		this.setHardness(0.75F);
		this.setBlockName(ModInfo.MODID+".EnderBlock");
		this.setBlockTextureName(ModInfo.MODID+":blockedingots/blockEnder");
	}

}
