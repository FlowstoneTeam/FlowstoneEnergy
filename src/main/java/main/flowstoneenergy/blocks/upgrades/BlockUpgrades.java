package main.flowstoneenergy.blocks.upgrades;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockUpgrades extends BlockUpgradeBase {
    public BlockUpgrades() {
        super();
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        icon[0] = register.registerIcon(ModInfo.MODID + ":upgrades/speed");
        icon[1] = register.registerIcon(ModInfo.MODID + ":upgrades/itemCapacity");
        icon[2] = register.registerIcon(ModInfo.MODID + ":upgrades/energyCapacity");
        icon[3] = register.registerIcon(ModInfo.MODID + ":upgrades/energyEfficiency");
        icon[4] = register.registerIcon(ModInfo.MODID + ":upgrades/processAmount");
        icon[5] = register.registerIcon(ModInfo.MODID + ":upgrades/creative");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (meta != 0) {
            switch (meta) {
                case 1: {
                    return icon[1];
                }
                case 2: {
                    return icon[2];
                }
                case 3: {
                    return icon[3];
                }
                case 4: {
                    return icon[4];
                }
                case 5: {
                    return icon[5];
                }
            }
        }
        return icon[0];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i <= 5; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }



    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
