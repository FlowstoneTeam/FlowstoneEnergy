package main.flowstoneenergy.items.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.utils.KeyboardHelper;
import main.flowstoneenergy.utils.TextHelper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class ItemFlowstoneManual extends Item {
    public static IIcon[] icon = new IIcon[2];
    public static IIcon currentIcon;

    public ItemFlowstoneManual() {
        super();
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setTextureName(ModInfo.MODID + ":tools/manual");
        this.setUnlocalizedName(ModInfo.MODID + ".flowstone.manual");
	    this.setMaxStackSize(1);
    }

    @Override
    public void registerIcons(IIconRegister ir) {
        icon[0] = ir.registerIcon(ModInfo.MODID + ":tools/manual");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":tools/manualOpen");
        this.itemIcon = icon[0];
        currentIcon = icon[0];
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        currentIcon = icon[1];
        player.openGui(FlowstoneEnergy.instance, 9, world, (int)player.posX, (int)player.posY, (int)player.posZ);
        return itemStack;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        return this.currentIcon;
    }

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		if(!KeyboardHelper.isShiftDown()) {
			list.add(TextHelper.shiftForMoreInfo);
		}else if(KeyboardHelper.isShiftDown()) {
			list.add(TextHelper.LIGHT_GRAY + TextHelper.localize("info.flowstoneenergy.tooltip.basics"));
			list.add(TextHelper.ORANGE + TextHelper.ITALIC + TextHelper.localize("info.flowstoneenergy.key.rightclick") + " " + TextHelper.LIGHT_GRAY + TextHelper.localize("info.flowstoneenergy.tooltip.bookinfo"));

		}
	}
}
