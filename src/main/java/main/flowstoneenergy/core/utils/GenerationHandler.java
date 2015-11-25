package main.flowstoneenergy.core.utils;

import net.minecraftforge.fml.common.IWorldGenerator;
import main.flowstoneenergy.core.libs.ConfigHandler;
import main.flowstoneenergy.blocks.BlockRegistry;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class GenerationHandler implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimensionId()) {
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
            BlockPos blockPos = new BlockPos(firstBlockXCoord, 0, firstBlockZCoord);
            int tinY = rand.nextInt(40);
            int copperY = rand.nextInt(64);
            int leadY = rand.nextInt(30);
            int silverY = rand.nextInt(30);
            int nickelY = rand.nextInt(22);
            int apliteY = rand.nextInt(55);

            if (ConfigHandler.useFECopper)
                (new WorldGenMinable(BlockRegistry.blockOres.getStateFromMeta(0), 4, BlockHelper.forBlock(Blocks.stone))).generate(world, rand, blockPos.add(0, copperY, 0));
            if (ConfigHandler.useFETin)
                (new WorldGenMinable(BlockRegistry.blockOres.getStateFromMeta(1), 4, BlockHelper.forBlock(Blocks.stone))).generate(world, rand, blockPos.add(0, tinY, 0));
            if (ConfigHandler.useFELead)
                (new WorldGenMinable(BlockRegistry.blockOres.getStateFromMeta(2), 4, BlockHelper.forBlock(Blocks.stone))).generate(world, rand, blockPos.add(0, leadY, 0));
            if (ConfigHandler.useFESilver)
                (new WorldGenMinable(BlockRegistry.blockOres.getStateFromMeta(3), 4, BlockHelper.forBlock(Blocks.stone))).generate(world, rand, blockPos.add(0,silverY, 0));
            if (ConfigHandler.useFENickel)
                (new WorldGenMinable(BlockRegistry.blockOres.getStateFromMeta(4), 4, BlockHelper.forBlock(Blocks.stone))).generate(world, rand, blockPos.add(0,nickelY, 0));
            if (ConfigHandler.useFEApalite)
                (new WorldGenMinable(BlockRegistry.aplite.getDefaultState(), 30, BlockHelper.forBlock(Blocks.stone))).generate(world, rand, blockPos.add(0, apliteY, 0));
                
        }

    }
}