package main.flowstoneenergy.blocks.blockedingots;

import main.flowstoneenergy.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockElectrum extends Block{
	public BlockElectrum() {
		super(Material.iron);
		this.setHardness(0.5F);
		this.setBlockName(ModInfo.MODID+".ElectrumBlock");
		this.setBlockTextureName(ModInfo.MODID+":blockedingots/blockElectrum");
	}
}
