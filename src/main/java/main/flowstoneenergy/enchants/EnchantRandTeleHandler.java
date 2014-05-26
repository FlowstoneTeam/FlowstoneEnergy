package main.flowstoneenergy.enchants;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantRandTeleHandler {
	@SubscribeEvent
	public void RandomTeleport(LivingHurtEvent event) {
		World world = event.entity.worldObj;
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