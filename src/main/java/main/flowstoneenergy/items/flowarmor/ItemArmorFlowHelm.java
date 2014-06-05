package main.flowstoneenergy.items.flowarmor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.client.Armor.FlowHelmModel;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorFlowHelm extends ItemArmor {

    public ItemArmorFlowHelm(ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
	    this.setCreativeTab(FlowstoneEnergy.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".flow.helm");
        this.setTextureName(ModInfo.MODID + ":armor/flowHelm");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase player, ItemStack stack, int slot) {
        ModelBiped model = new FlowHelmModel(0.5F);

        model.isSneak = player.isSneaking();
        model.isRiding = player.isRiding();
        model.isChild = player.isChild();

        return model;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack Stack, Entity entity, int Slot, String type) {
        return ModInfo.MODID + ":textures/armor/flowHelm.png";
    }
}