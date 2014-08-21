package main.flowstoneenergy.items.food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemMetaResourceUtensil extends Item {

    public IIcon[] icon = new IIcon[500];

    public ItemMetaResourceUtensil() {
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "teaCup";
                break;
            }
            case 1: {
                name = "teaBag";
                break;
            }
            case 2: {
                name = "spoon";
                break;
            }
            case 3: {
                name = "saucer";
                break;
            }
            case 4: {
                name = "cup";
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
        this.icon[0] = ri.registerIcon(ModInfo.MODID + ":food/teaCup");
        this.icon[1] = ri.registerIcon(ModInfo.MODID + ":food/teaBag");
        this.icon[2] = ri.registerIcon(ModInfo.MODID + ":food/spoon");
        this.icon[3] = ri.registerIcon(ModInfo.MODID + ":food/saucer");
        this.icon[4] = ri.registerIcon(ModInfo.MODID + ":food/cup");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List list) {
        for (int i = 0; i <= 4; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }
}
