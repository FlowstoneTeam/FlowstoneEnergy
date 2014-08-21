package main.flowstoneenergy.items.flowarmor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.core.client.armor.FlowstoneArmorModel;
import main.flowstoneenergy.core.utils.KeyboardHelper;
import main.flowstoneenergy.core.utils.TextHelper;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemArmorFlowLeggings extends ItemArmor {

	private int maxFE = 10000;
	public int currentFE = 0;

    public ItemArmorFlowLeggings(ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
	    this.setCreativeTab(FlowstoneEnergy.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".flow.leggings");
        this.setTextureName(ModInfo.MODID + ":armor/flowLeggings");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase player, ItemStack stack, int slot) {

        ModelBiped model = new FlowstoneArmorModel(0.5F);

        model.bipedBody.isHidden = true;
        model.bipedHead.isHidden = true;
        model.bipedLeftArm.isHidden = true;
        model.bipedRightArm.isHidden = true;

        model.isSneak = player.isSneaking();
        model.isRiding = player.isRiding();
        model.isChild = player.isChild();

        return model;

    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack Stack, Entity entity, int Slot, String type) {
        return ModInfo.MODID + ":textures/armor/flowstoneArmor.png";
    }

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

		if(!KeyboardHelper.isShiftDown()) {
			list.add(TextHelper.shiftForMoreInfo);
		} else {
			list.add(TextHelper.GREEN + currentFE + "/" + maxFE + TextHelper.localize("info.fe.tooltip.stored"));
			list.add("More information should come soon.");
		}
	}
}