package main.flowstoneenergy.blocks.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.core.libs.ConfigHandler;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.core.interfaces.IFlowWrenchable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMachineBox extends BlockContainer implements IFlowWrenchable {

	protected IIcon[] icons = new IIcon[16];

    public BlockMachineBox() {
        super(Material.iron);
        this.setBlockName(ModInfo.MODID + ".MachineBox");
        this.setCreativeTab(FlowstoneEnergy.blockTab);
        this.setBlockTextureName(ModInfo.MODID + ":machines/machine_Side_0");
        this.setStepSound(soundTypeMetal);
        this.setHardness(7);
    }

    @Override
    public boolean canWrenchRemove() {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return null;
    }

		@Override
		@SideOnly(Side.CLIENT)
		public IIcon getIcon(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
			return par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 15 ? icons[0] : getConnectedBlockTexture(par1IBlockAccess, par2, par3, par4, par5, icons);
		}

		public boolean shouldConnectToBlock(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, Block par5, int par6) {
			return par5 == (Block) this;
		}

		public IIcon getConnectedBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5, IIcon[] icons) {
			if (!ConfigHandler.useConnectedTextures) {
				return icons[0];
			}

			boolean isOpenUp = false, isOpenDown = false, isOpenLeft = false, isOpenRight = false;

			switch (par5) {
				case 0:
					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
						isOpenDown = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
						isOpenUp = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
						isOpenLeft = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
						isOpenRight = true;
					}

					if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
						return icons[15];
					} else if (isOpenUp && isOpenDown && isOpenLeft) {
						return icons[11];
					} else if (isOpenUp && isOpenDown && isOpenRight) {
						return icons[12];
					} else if (isOpenUp && isOpenLeft && isOpenRight) {
						return icons[13];
					} else if (isOpenDown && isOpenLeft && isOpenRight) {
						return icons[14];
					} else if (isOpenDown && isOpenUp) {
						return icons[5];
					} else if (isOpenLeft && isOpenRight) {
						return icons[6];
					} else if (isOpenDown && isOpenLeft) {
						return icons[8];
					} else if (isOpenDown && isOpenRight) {
						return icons[10];
					} else if (isOpenUp && isOpenLeft) {
						return icons[7];
					} else if (isOpenUp && isOpenRight) {
						return icons[9];
					} else if (isOpenDown) {
						return icons[3];
					} else if (isOpenUp) {
						return icons[4];
					} else if (isOpenLeft) {
						return icons[2];
					} else if (isOpenRight) {
						return icons[1];
					}
					break;
				case 1:
					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
						isOpenDown = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
						isOpenUp = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
						isOpenLeft = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
						isOpenRight = true;
					}

					if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
						return icons[15];
					} else if (isOpenUp && isOpenDown && isOpenLeft) {
						return icons[11];
					} else if (isOpenUp && isOpenDown && isOpenRight) {
						return icons[12];
					} else if (isOpenUp && isOpenLeft && isOpenRight) {
						return icons[13];
					} else if (isOpenDown && isOpenLeft && isOpenRight) {
						return icons[14];
					} else if (isOpenDown && isOpenUp) {
						return icons[5];
					} else if (isOpenLeft && isOpenRight) {
						return icons[6];
					} else if (isOpenDown && isOpenLeft) {
						return icons[8];
					} else if (isOpenDown && isOpenRight) {
						return icons[10];
					} else if (isOpenUp && isOpenLeft) {
						return icons[7];
					} else if (isOpenUp && isOpenRight) {
						return icons[9];
					} else if (isOpenDown) {
						return icons[3];
					} else if (isOpenUp) {
						return icons[4];
					} else if (isOpenLeft) {
						return icons[2];
					} else if (isOpenRight) {
						return icons[1];
					}
					break;
				case 2:
					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
						isOpenDown = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
						isOpenUp = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
						isOpenLeft = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
						isOpenRight = true;
					}

					if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
						return icons[15];
					} else if (isOpenUp && isOpenDown && isOpenLeft) {
						return icons[13];
					} else if (isOpenUp && isOpenDown && isOpenRight) {
						return icons[14];
					} else if (isOpenUp && isOpenLeft && isOpenRight) {
						return icons[11];
					} else if (isOpenDown && isOpenLeft && isOpenRight) {
						return icons[12];
					} else if (isOpenDown && isOpenUp) {
						return icons[6];
					} else if (isOpenLeft && isOpenRight) {
						return icons[5];
					} else if (isOpenDown && isOpenLeft) {
						return icons[9];
					} else if (isOpenDown && isOpenRight) {
						return icons[10];
					} else if (isOpenUp && isOpenLeft) {
						return icons[7];
					} else if (isOpenUp && isOpenRight) {
						return icons[8];
					} else if (isOpenDown) {
						return icons[1];
					} else if (isOpenUp) {
						return icons[2];
					} else if (isOpenLeft) {
						return icons[4];
					} else if (isOpenRight) {
						return icons[3];
					}
					break;
				case 3:
					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
						isOpenDown = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
						isOpenUp = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
						isOpenLeft = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
						isOpenRight = true;
					}

					if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
						return icons[15];
					} else if (isOpenUp && isOpenDown && isOpenLeft) {
						return icons[13];
					} else if (isOpenUp && isOpenDown && isOpenRight) {
						return icons[14];
					} else if (isOpenUp && isOpenLeft && isOpenRight) {
						return icons[11];
					} else if (isOpenDown && isOpenLeft && isOpenRight) {
						return icons[12];
					} else if (isOpenDown && isOpenUp) {
						return icons[6];
					} else if (isOpenLeft && isOpenRight) {
						return icons[5];
					} else if (isOpenDown && isOpenLeft) {
						return icons[9];
					} else if (isOpenDown && isOpenRight) {
						return icons[10];
					} else if (isOpenUp && isOpenLeft) {
						return icons[7];
					} else if (isOpenUp && isOpenRight) {
						return icons[8];
					} else if (isOpenDown) {
						return icons[1];
					} else if (isOpenUp) {
						return icons[2];
					} else if (isOpenLeft) {
						return icons[4];
					} else if (isOpenRight) {
						return icons[3];
					}
					break;
				case 4:
					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
						isOpenDown = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
						isOpenUp = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
						isOpenLeft = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
						isOpenRight = true;
					}

					if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
						return icons[15];
					} else if (isOpenUp && isOpenDown && isOpenLeft) {
						return icons[14];
					} else if (isOpenUp && isOpenDown && isOpenRight) {
						return icons[13];
					} else if (isOpenUp && isOpenLeft && isOpenRight) {
						return icons[11];
					} else if (isOpenDown && isOpenLeft && isOpenRight) {
						return icons[12];
					} else if (isOpenDown && isOpenUp) {
						return icons[6];
					} else if (isOpenLeft && isOpenRight) {
						return icons[5];
					} else if (isOpenDown && isOpenLeft) {
						return icons[10];
					} else if (isOpenDown && isOpenRight) {
						return icons[9];
					} else if (isOpenUp && isOpenLeft) {
						return icons[8];
					} else if (isOpenUp && isOpenRight) {
						return icons[7];
					} else if (isOpenDown) {
						return icons[1];
					} else if (isOpenUp) {
						return icons[2];
					} else if (isOpenLeft) {
						return icons[3];
					} else if (isOpenRight) {
						return icons[4];
					}
					break;
				case 5:
					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
						isOpenDown = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
						isOpenUp = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
						isOpenLeft = true;
					}

					if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
						isOpenRight = true;
					}

					if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
						return icons[15];
					} else if (isOpenUp && isOpenDown && isOpenLeft) {
						return icons[14];
					} else if (isOpenUp && isOpenDown && isOpenRight) {
						return icons[13];
					} else if (isOpenUp && isOpenLeft && isOpenRight) {
						return icons[11];
					} else if (isOpenDown && isOpenLeft && isOpenRight) {
						return icons[12];
					} else if (isOpenDown && isOpenUp) {
						return icons[6];
					} else if (isOpenLeft && isOpenRight) {
						return icons[5];
					} else if (isOpenDown && isOpenLeft) {
						return icons[10];
					} else if (isOpenDown && isOpenRight) {
						return icons[9];
					} else if (isOpenUp && isOpenLeft) {
						return icons[8];
					} else if (isOpenUp && isOpenRight) {
						return icons[7];
					} else if (isOpenDown) {
						return icons[1];
					} else if (isOpenUp) {
						return icons[2];
					} else if (isOpenLeft) {
						return icons[3];
					} else if (isOpenRight) {
						return icons[4];
					}
					break;
			}

			return icons[0];
		}

		@Override
		public void registerBlockIcons (IIconRegister par1IconRegister) {
			blockIcon = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_0");
			icons[0] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_0");
			icons[1] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_1");
			icons[2] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_2");
			icons[3] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_3");
			icons[4] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_4");
			icons[5] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_5");
			icons[6] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_6");
			icons[7] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_7");
			icons[8] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_8");
			icons[9] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_9");
			icons[10] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_10");
			icons[11] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_11");
			icons[12] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_12");
			icons[13] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_13");
			icons[14] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_14");
			icons[15] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/machine_Side_15");
		}
}
