package main.flowstoneenergy.items;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemMetaResourceIngots extends Item {

    //public IIcon[] icon = new IIcon[500];

    public ItemMetaResourceIngots() {
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "itemIngotCopper";
                break;
            }
            case 1: {
                name = "itemIngotTin";
                break;
            }
            case 2: {
                name = "itemIngotLead";
                break;
            }
            case 3: {
                name = "itemIngotSilver";
                break;
            }
            case 4: {
                name = "itemIngotEnder";
                break;
            }
            case 5: {
                name = "itemIngotNickel";
                break;
            }
            case 6: {
                name = "itemIngotInvar";
                break;
            }
            case 7: {
                name = "itemIngotElectrum";
                break;
            }

            default:
                name = "nothing";
                break;
        }
        return getUnlocalizedName() + "." + name;
    }
/*
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ri) {
        this.icon[0] = ri.registerIcon(ModInfo.MODID + ":ingots/copperIngot");
        this.icon[1] = ri.registerIcon(ModInfo.MODID + ":ingots/tinIngot");
        this.icon[2] = ri.registerIcon(ModInfo.MODID + ":ingots/leadIngot");
        this.icon[3] = ri.registerIcon(ModInfo.MODID + ":ingots/silverIngot");
        this.icon[4] = ri.registerIcon(ModInfo.MODID + ":ingots/enderIngot");
        this.icon[5] = ri.registerIcon(ModInfo.MODID + ":ingots/nickelIngot");
        this.icon[6] = ri.registerIcon(ModInfo.MODID + ":ingots/invarIngot");
        this.icon[7] = ri.registerIcon(ModInfo.MODID + ":ingots/electrumIngot");
    }
    */

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
        for (int i = 0; i <= 7; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }
}
