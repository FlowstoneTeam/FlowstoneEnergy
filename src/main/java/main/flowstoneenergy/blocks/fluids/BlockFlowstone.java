package main.flowstoneenergy.blocks.fluids;

import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFlowstone extends BlockFluidClassic {

    /*
    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;
    */

    public BlockFlowstone(Fluid fluid) {
        super(fluid, Material.water);
        this.setTemperature(300);
        this.setUnlocalizedName(ModInfo.MODID + ".flowstoneBlock");
    }

    /*
    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1) ? stillIcon : flowingIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        stillIcon = register.registerIcon(ModInfo.MODID + ":fluids/stillFlowstone");
        flowingIcon = register.registerIcon(ModInfo.MODID + ":fluids/flowingFlowstone");
        BlockRegistry.flowstone.setIcons(stillIcon, flowingIcon);
        this.blockIcon = stillIcon;
    }
    */

    @Override
    public boolean canDisplace(IBlockAccess world, BlockPos pos) {
        if (world.getBlockState(pos).getBlock().getMaterial().isLiquid())
            return false;
        return super.canDisplace(world, pos);
    }

    @Override
    public boolean displaceIfPossible(World world, BlockPos pos) {
        if (world.getBlockState(pos).getBlock().getMaterial().isLiquid())
            return false;
        return super.displaceIfPossible(world, pos);
    }
}
