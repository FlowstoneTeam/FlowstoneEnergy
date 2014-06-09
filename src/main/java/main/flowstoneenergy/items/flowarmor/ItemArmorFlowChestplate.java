package main.flowstoneenergy.items.flowarmor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.client.Armor.FlowChestModel;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorFlowChestplate extends ItemArmor {

    public ItemArmorFlowChestplate(ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
	    this.setCreativeTab(FlowstoneEnergy.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".flow.chestplate");
        this.setTextureName(ModInfo.MODID + ":Armor/flowChest");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase player, ItemStack stack, int slot) {
        ModelBiped model = new FlowChestModel(0.5F);

        model.isSneak = player.isSneaking();
        model.isRiding = player.isRiding();
        model.isChild = player.isChild();

        if (player instanceof EntityPlayer) {
            EntityPlayer Player = (EntityPlayer) player;

            ItemStack ItemInUse = Player.getHeldItem();

            model.heldItemRight = ItemInUse != null ? 1 : 0;

            if (ItemInUse != null && Player.getItemInUseCount() > 0) {
                EnumAction Action = ItemInUse.getItemUseAction();

                if (Action == EnumAction.block) {
                    model.heldItemRight = 3;
                } else if (Action == EnumAction.bow) {
                    model.aimedBow = true;
                }
            }
        }

        return model;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack Stack, Entity entity, int Slot, String type) {
        return ModInfo.MODID + ":textures/Armor/flowChest.png";
    }
}