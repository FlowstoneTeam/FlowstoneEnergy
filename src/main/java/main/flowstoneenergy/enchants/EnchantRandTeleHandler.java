package main.flowstoneenergy.enchants;

import java.util.Random;

import main.flowstoneenergy.FlowstoneEnergy;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantRandTeleHandler {
	@SubscribeEvent
	public void RandomTeleport(LivingAttackEvent event) {
		EntityPlayer attacker = event.source;
		Entity defender = event.entity;
		World world = event.entity.worldObj;
		if(world.isRemote) return;
        	if(event.source.getEntity() == null) return;
        	if(!(event.source.getEntity() instanceof EntityPlayer)) return;
        	if(attacker.getHeldItem() == null) return;
        	if(!attacker.getHeldItem().isItemEnchanted());
        	if(!(EnchantmentHelper.getEnchantments(attacker.getHeldItem()).containsKey(EnchantRegistry.randTeleEnchant.effectId))) return;
        	teleport(world, event.source.getEntity());
	}
	
	public void teleport(World world, Entity entity) {
		Random rand = new Random();
		if (rand.nextBoolean()) entity.posX += rand.nextDouble() + (rand.nextInt(5 - 0) + 0); else entity.posX -= rand.nextDouble() + (rand.nextInt(5 - 0) + 0);
		entity.posY += 40;
		if (rand.nextBoolean()) entity.posZ += rand.nextDouble() + (rand.nextInt(5 - 0) + 0); else entity.posZ -= rand.nextDouble() + (rand.nextInt(5 - 0) + 0);
		while (world.getBlock((int)entity.posX, (int)entity.posY - 1, (int)entity.posZ) == Blocks.air) {
			entity.posY -= 1;
		}
				
		entity.setPosition(entity.posX, entity.posY, entity.posZ);
	}
}
