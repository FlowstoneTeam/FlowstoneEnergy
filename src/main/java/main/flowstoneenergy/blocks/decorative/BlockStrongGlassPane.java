package main.flowstoneenergy.blocks.decorative;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.libs.ModInfo;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

public class BlockStrongGlassPane extends BlockPane{

	public BlockStrongGlassPane() {
		super(ModInfo.MODID + ":decorative/strongGlass_0", ModInfo.MODID + ":blockedingots/blockLead", Material.glass, true);
        this.setStepSound(soundTypeGlass);
		this.setBlockName(ModInfo.MODID + ".strong.glass.pane");
		this.setBlockTextureName(ModInfo.MODID + ":decorative/strongGlass_0");
		this.setCreativeTab(FlowstoneEnergy.blockTab);
		this.setHardness(0.5F);
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