package main.flowstoneenergy.items.flowarmor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.client.armor.FlowstoneArmorModel;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorFlowLeggings extends ItemArmor {

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
}