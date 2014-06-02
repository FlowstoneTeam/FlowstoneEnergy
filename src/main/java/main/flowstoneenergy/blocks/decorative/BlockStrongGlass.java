package main.flowstoneenergy.blocks.decorative;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStrongGlass extends Block {

	public BlockStrongGlass() {
		super(Material.iron);
		this.setHardness(0.5F);
		this.setStepSound(soundTypeGlass);
		this.setCreativeTab(FlowstoneEnergy.tab);
		this.setBlockName(ModInfo.MODID + ".strong.glass");
		this.setBlockTextureName(ModInfo.MODID + ":decorative/strongGlass");
	}
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

	public boolean shouldSideBeRendered() {
        return true;
    }

}
