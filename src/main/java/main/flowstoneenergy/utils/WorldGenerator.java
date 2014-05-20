package main.flowstoneenergy.utils;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenerator implements IWorldGenerator 
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId) 
		{
		case -1:
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			break;
		}
	}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) 
	{
		for (int k = 0; k < 10; k++) 
		{
			int firstBlockXCoord = chunkX + rand.nextInt(16);
			int firstBlockZCoord = chunkZ + rand.nextInt(16);
			int tinY = rand.nextInt(40);
			int copperY = rand.nextInt(64);
			int leadY = rand.nextInt(30);

			(new WorldGenMinable(BlockUtils.copperOre, 13)).generate(world, rand, firstBlockXCoord, copperY, firstBlockZCoord);
			(new WorldGenMinable(BlockUtils.tinOre, 13)).generate(world, rand, firstBlockXCoord, tinY, firstBlockZCoord);
			(new WorldGenMinable(BlockUtils.leadOre, 13)).generate(world, rand, firstBlockXCoord, leadY, firstBlockZCoord);
		}

	}
}
