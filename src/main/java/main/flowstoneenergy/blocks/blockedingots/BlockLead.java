package main.flowstoneenergy.blocks.blockedingots;

import main.flowstoneenergy.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLead extends Block{
	public BlockLead() {
		super(Material.iron);
		this.setHardness(0.5F);
		this.setBlockName(ModInfo.MODID+".LeadBlock");
		this.setBlockTextureName(ModInfo.MODID+":blockedingots/blockLead");
	}

}
