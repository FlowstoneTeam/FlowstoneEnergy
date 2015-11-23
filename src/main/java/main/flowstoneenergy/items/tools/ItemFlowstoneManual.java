package main.flowstoneenergy.items.tools;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.core.utils.KeyboardHelper;
import main.flowstoneenergy.core.utils.TextHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemFlowstoneManual extends Item {
    // TODO: port icon logic
    /*public static IIcon[] icon = new IIcon[2];
    public static IIcon currentIcon;*/

    public ItemFlowstoneManual() {
        super();
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setMaxStackSize(1);
        //this.setTextureName(ModInfo.MODID + ":tools/manual");
        this.setUnlocalizedName(ModInfo.MODID + ".flowstone.manual");
    }

    /*
    @Override
    public void registerIcons(IIconRegister ir) {
        icon[0] = ir.registerIcon(ModInfo.MODID + ":tools/manual");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":tools/manualOpen");
        this.itemIcon = icon[0];
        currentIcon = icon[0];
    }
*/
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        //currentIcon = icon[1];
        player.openGui(FlowstoneEnergy.instance, 9, world, (int) player.posX, (int) player.posY, (int) player.posZ);
        return itemStack;
    }

    /*
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        return this.currentIcon;
    }
    */

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> list, boolean advanced) {
        list.add(TextHelper.shiftForMoreInfo);
        if (!KeyboardHelper.isShiftDown()) {
            return;
        }
        list.remove(1);
        list.add("This manual will help the player ");
        list.add("learn all about how to use the");
        list.add("Flowstone Energy mod!");
        list.add("Written by the Flowstone Team");
        list.add("For your benefit");
        list.add("");
        list.add("RIGHT CLICK to open");
    }
}