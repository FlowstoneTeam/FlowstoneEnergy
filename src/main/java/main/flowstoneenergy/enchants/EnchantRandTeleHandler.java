package main.flowstoneenergy.enchants;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import java.util.Random;

public class EnchantRandTeleHandler {
    @SubscribeEvent
    public void RandomTeleport(LivingAttackEvent event) {
        if (event.source.getEntity() instanceof EntityPlayer) {
            EntityPlayer attacker = (EntityPlayer) event.source.getEntity();
            Entity defender = event.entity;
            World world = event.entity.worldObj;
            if (world.isRemote)
                return;
            if (event.source.getEntity() == null)
                return;
            if (!(event.source.getEntity() instanceof EntityPlayer))
                return;
            if (attacker.getHeldItem() == null)
                return;
            if (!attacker.getHeldItem().isItemEnchanted())
                ;
            if (!(EnchantmentHelper.getEnchantments(attacker.getHeldItem()).containsKey(EnchantRegistry.randTeleEnchant.effectId)))
                return;
            teleport(world, defender);
        }
    }

    public void teleport(World world, Entity entity) {
        Random rand = new Random();
        world.playSoundEffect(entity.posX + 0.5D, entity.posY + 0.5D, entity.posZ + 0.5D, "mob.endermen.portal", 1.0F, world.rand.nextFloat() * 0.1F + 0.9F);
        if (rand.nextBoolean())
            entity.posX += rand.nextDouble() + (rand.nextInt(5 - 0) + 0);
        else
            entity.posX -= rand.nextDouble() + (rand.nextInt(5 - 0) + 0);
        entity.posY += 40;
        if (rand.nextBoolean())
            entity.posZ += rand.nextDouble() + (rand.nextInt(5 - 0) + 0);
        else
            entity.posZ -= rand.nextDouble() + (rand.nextInt(5 - 0) + 0);
        while (world.getBlockState(entity.getPosition().down()).getBlock() == Blocks.air) {
            entity.posY -= 1;
        }
        entity.setPosition(entity.posX, entity.posY, entity.posZ);
    }
}
