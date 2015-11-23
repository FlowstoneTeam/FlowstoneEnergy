package main.flowstoneenergy.core.utils;

import java.util.HashMap;
import java.util.Map;

import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class BucketHandler {
    public static BucketHandler INSTANCE = new BucketHandler();
    public Map<Block, Item> buckets = new HashMap<Block, Item>();

    private BucketHandler() {
    }

    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event) {

        ItemStack result = fillCustomBucket(event.world, event.target);

        if (result == null)
            return;

        event.result = result;
        event.setResult(Result.ALLOW);
    }

    private ItemStack fillCustomBucket(World world, MovingObjectPosition pos) {

        BlockPos blockPos = pos.getBlockPos();
        IBlockState blockState = world.getBlockState(blockPos);
        Block block = blockState.getBlock();
        int metadata = block.getMetaFromState(blockState);

        Item bucket = buckets.get(block);
        if (bucket != null && metadata == 0) {
            world.setBlockToAir(blockPos);
            return new ItemStack(bucket);
        } else
            return null;

    }
}
