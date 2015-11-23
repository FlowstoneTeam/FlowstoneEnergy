package main.flowstoneenergy.items;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemMetaResourceGears extends Item {

    //public IIcon[] icon = new IIcon[500];

    public ItemMetaResourceGears() {
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "itemGearWood";
                break;
            }
            case 1: {
                name = "itemGearStone";
                break;
            }
            case 2: {
                name = "itemGearIron";
                break;
            }
            case 3: {
                name = "itemGearGold";
                break;
            }
            case 4: {
                name = "itemGearQuartz";
                break;
            }
            case 5: {
                name = "itemGearDiamond";
                break;
            }
            case 6: {
                name = "itemGearCopper";
                break;
            }
            case 7: {
                name = "itemGearTin";
                break;
            }
            case 8: {
                name = "itemGearLead";
                break;
            }
            case 9: {
                name = "itemGearSilver";
                break;
            }
            case 10: {
                name = "itemGearEnder";
                break;
            }
            case 11: {
                name = "itemGearElectrum";
                break;
            }
            case 12: {
                name = "itemGearNickel";
                break;
            }
            case 13: {
                name = "itemGearInvar";
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
        this.icon[0] = ri.registerIcon(ModInfo.MODID + ":gears/gearWood");
        this.icon[1] = ri.registerIcon(ModInfo.MODID + ":gears/gearStone");
        this.icon[2] = ri.registerIcon(ModInfo.MODID + ":gears/gearIron");
        this.icon[3] = ri.registerIcon(ModInfo.MODID + ":gears/gearGold");
        this.icon[4] = ri.registerIcon(ModInfo.MODID + ":gears/gearQuartz");
        this.icon[5] = ri.registerIcon(ModInfo.MODID + ":gears/gearDiamond");
        this.icon[6] = ri.registerIcon(ModInfo.MODID + ":gears/gearCopper");
        this.icon[7] = ri.registerIcon(ModInfo.MODID + ":gears/gearTin");
        this.icon[8] = ri.registerIcon(ModInfo.MODID + ":gears/gearLead");
        this.icon[9] = ri.registerIcon(ModInfo.MODID + ":gears/gearSilver");
        this.icon[10] = ri.registerIcon(ModInfo.MODID + ":gears/gearEnder");
        this.icon[11] = ri.registerIcon(ModInfo.MODID + ":gears/gearElectrum");
        this.icon[12] = ri.registerIcon(ModInfo.MODID + ":gears/gearNickel");
        this.icon[13] = ri.registerIcon(ModInfo.MODID + ":gears/gearInvar");
    }
    */

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
        for (int i = 0; i <= 13; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }
}
