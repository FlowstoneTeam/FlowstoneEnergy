package main.flowstoneenergy.items.flowarmor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.client.Armor.FlowBootsModel;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorFlowBoots extends ItemArmor {

    public ItemArmorFlowBoots(ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
	    this.setCreativeTab(FlowstoneEnergy.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".flow.boots");
        this.setTextureName(ModInfo.MODID + ":armor/flowBoots");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase Player, ItemStack stack, int slot) {
        ModelBiped model = new FlowBootsModel(0.5F);

        model.isSneak = Player.isSneaking();
        model.isRiding = Player.isRiding();
        model.isChild = Player.isChild();

        return model;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack Stack, Entity entity, int Slot, String type) {
        return ModInfo.MODID + ":textures/armor/flowBoots.png";
    }
}