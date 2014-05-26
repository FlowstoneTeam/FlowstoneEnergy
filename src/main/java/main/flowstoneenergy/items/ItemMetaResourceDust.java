package main.flowstoneenergy.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;


public class ItemMetaResourceDust extends Item {

    public IIcon[] icon = new IIcon[500];

    public ItemMetaResourceDust() {
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "itemDustCoal";
                break;
            }
            case 1: {
                name = "itemDustIron";
                break;
            }
            case 2: {
                name = "itemDustGold";
                break;
            }
            case 3: {
                name = "itemDustCopper";
                break;
            }
            case 4: {
                name = "itemDustTin";
                break;
            }
            case 5: {
                name = "itemDustLead";
                break;
            }
            case 6: {
                name = "itemDustSilver";
                break;
            }
            case 7: {
                name = "itemDustEnderSmall";
                break;
            }
            case 8: {
                name = "itemDustEnder";
                break;
            }
            case 9: {
                name = "itemDustNickel";
                break;
            }
            case 10: {
                name = "itemDustInvar";
                break;
            }
            case 11: {
                name = "itemDustElectrum";
                break;
            }

            default:
                name = "nothing";
                break;
        }
        return getUnlocalizedName() + "." + name;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ri) {
        this.icon[0] = ri.registerIcon(ModInfo.MODID + ":dusts/coalDust");
        this.icon[1] = ri.registerIcon(ModInfo.MODID + ":dusts/ironDust");
        this.icon[2] = ri.registerIcon(ModInfo.MODID + ":dusts/goldDust");
        this.icon[3] = ri.registerIcon(ModInfo.MODID + ":dusts/copperDust");
        this.icon[4] = ri.registerIcon(ModInfo.MODID + ":dusts/tinDust");
        this.icon[5] = ri.registerIcon(ModInfo.MODID + ":dusts/leadDust");
        this.icon[6] = ri.registerIcon(ModInfo.MODID + ":dusts/silverDust");
        this.icon[7] = ri.registerIcon(ModInfo.MODID + ":dusts/smallEnderDust");
        this.icon[8] = ri.registerIcon(ModInfo.MODID + ":dusts/enderDust");
        this.icon[9] = ri.registerIcon(ModInfo.MODID + ":dusts/nickelDust");
        this.icon[10] = ri.registerIcon(ModInfo.MODID + ":dusts/invarDust");
        this.icon[11] = ri.registerIcon(ModInfo.MODID + ":dusts/electrumDust");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List list) {
        for (int i = 0; i <= 11; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }
}
