package main.flowstoneenergy.core.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import main.flowstoneenergy.items.ItemRegistry;
import main.flowstoneenergy.core.utils.PlayerHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class EntityEventHandler {

    public static final String FLOWSTONEENERGY_PERSIST_TAG = "FlowstoneEnergy";
    public static final String GIVEN_GUIDE_TAG = "givenGuide";

    @SubscribeEvent()
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        final Entity entity = event.entity;
        if (!event.world.isRemote && entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            NBTTagCompound persistTag = PlayerHelper.getModPlayerPersistTag(player, "FlowstoneEnergy");

            boolean shouldGiveManual = ItemRegistry.manual != null && !persistTag.getBoolean(GIVEN_GUIDE_TAG);
            if (shouldGiveManual) {
                ItemStack manual = new ItemStack(ItemRegistry.manual);
                if (!player.inventory.addItemStackToInventory(manual)) {
                    dropItemStackInWorld(player.worldObj, player.posX, player.posY, player.posZ, manual);
                }
                persistTag.setBoolean(GIVEN_GUIDE_TAG, true);
            }
        }
    }

    public static EntityItem dropItemStackInWorld(World worldObj, double x, double y, double z, ItemStack stack) {
        float f = 0.7F;
        float d0 = worldObj.rand.nextFloat() * f + (1.0F - f) * 0.5F;
        float d1 = worldObj.rand.nextFloat() * f + (1.0F - f) * 0.5F;
        float d2 = worldObj.rand.nextFloat() * f + (1.0F - f) * 0.5F;
        EntityItem entityitem = new EntityItem(worldObj, x + d0, y + d1, z + d2, stack);
        //TODO: investigate why this is needed
        entityitem.setPickupDelay(1);
        if (stack.hasTagCompound()) {
            entityitem.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
        }
        worldObj.spawnEntityInWorld(entityitem);
        return entityitem;
    }
}
