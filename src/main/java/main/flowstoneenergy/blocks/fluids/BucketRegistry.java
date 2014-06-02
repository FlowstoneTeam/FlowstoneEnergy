package main.flowstoneenergy.blocks.fluids;

import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.items.ItemRegistry;
import main.flowstoneenergy.utils.BucketHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class BucketRegistry {
	public static void registerBucket() {
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("flowstone", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ItemRegistry.flowstoneBucket), new ItemStack(Items.bucket));
        BucketHandler.INSTANCE.buckets.put(BlockRegistry.flowstoneBlock, ItemRegistry.flowstoneBucket);
        //FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("fluidBlaze", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ItemRegistry.fluidBlazeBucket), new ItemStack(Items.bucket));
        BucketHandler.INSTANCE.buckets.put(BlockRegistry.fluidBlazeBlock, ItemRegistry.fluidBlazeBucket);
	}
}
