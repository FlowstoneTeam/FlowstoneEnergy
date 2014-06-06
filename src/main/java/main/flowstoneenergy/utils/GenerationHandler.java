package main.flowstoneenergy.utils;

import cpw.mods.fml.common.IWorldGenerator;
import main.flowstoneenergy.ConfigHandler;
import main.flowstoneenergy.blocks.BlockRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class GenerationHandler implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case -1:
                break;
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                break;
        }
    }

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        for (int k = 0; k < 10; k++) {
            int firstBlockXCoord = chunkX + rand.nextInt(16);
            int firstBlockZCoord = chunkZ + rand.nextInt(16);
            int tinY = rand.nextInt(40);
            int copperY = rand.nextInt(64);
            int leadY = rand.nextInt(30);
            int silverY = rand.nextInt(30);
            int nickelY = rand.nextInt(22);
            int apaliteY = rand.nextInt(55);

            if (ConfigHandler.useFECopper)
                (new WorldGenMinable(BlockRegistry.blockOres, 0, 4, Blocks.stone)).generate(world, rand, firstBlockXCoord, copperY, firstBlockZCoord);
            if (ConfigHandler.useFETin)
                (new WorldGenMinable(BlockRegistry.blockOres, 1, 4, Blocks.stone)).generate(world, rand, firstBlockXCoord, tinY, firstBlockZCoord);
            if (ConfigHandler.useFELead)
                (new WorldGenMinable(BlockRegistry.blockOres, 2, 4, Blocks.stone)).generate(world, rand, firstBlockXCoord, leadY, firstBlockZCoord);
            if (ConfigHandler.useFESilver)
                (new WorldGenMinable(BlockRegistry.blockOres, 3, 4, Blocks.stone)).generate(world, rand, firstBlockXCoord, silverY, firstBlockZCoord);
            if (ConfigHandler.useFENickel)
                (new WorldGenMinable(BlockRegistry.blockOres, 4, 4, Blocks.stone)).generate(world, rand, firstBlockXCoord, nickelY, firstBlockZCoord);
            if (ConfigHandler.useFEApalite)
                (new WorldGenMinable(BlockRegistry.aplite, 0, 30, Blocks.stone)).generate(world, rand, firstBlockXCoord, apaliteY, firstBlockZCoord);
        }

    }
}