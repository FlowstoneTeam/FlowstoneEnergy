package main.flowstoneenergy.enchants;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantRandTeleHandler {
	@SubscribeEvent
	public void RandomTeleport(LivingAttackEvent event) {
		if(event.entity.worldObj.isRemote) return;
        if(event.source.getEntity() == null) return;
        if(!(event.source.getEntity() instanceof EntityPlayer)) return;
        teleport(world, (EntityPlayer) event.source.getEntity());
	}
	
	public void teleport(World world, Entity , double x, double y, double z) {
		if(entity.getHeldItem() == null) return;
        if(!entity.getHeldItem().isItemEnchanted());
        if(!(EnchantmentHelper.getEnchantments(entity.getHeldItem()).containsKey(HackeryMod.enchantVirus.effectId))) return;
		Random rand = new Random();
		if (rand.nextBoolean()) event.entity.posX += rand.nextDouble() + (rand.nextInt(5 - 0) + 0); else event.entity.posX -= rand.nextDouble() + (rand.nextInt(5 - 0) + 0);
		event.entity.posY += 40;
		if (rand.nextBoolean()) event.entity.posZ += rand.nextDouble() + (rand.nextInt(5 - 0) + 0); else event.entity.posZ -= rand.nextDouble() + (rand.nextInt(5 - 0) + 0);
		while (world.getBlock((int)event.entity.posX, (int)event.entity.posY - 1, (int)event.entity.posZ) == Blocks.air) {
			event.entity.posY -= 1;
		}
				
		event.entity.setPosition(event.entity.posX, event.entity.posY, event.entity.posZ);
	}
}
