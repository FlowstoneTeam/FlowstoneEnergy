package main.flowstoneenergy.items.tools;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class ItemLiquidBlazeBucket extends ItemBucket {

    public ItemLiquidBlazeBucket(Block block) {
        super(block);
        this.maxStackSize = 1;
        this.setContainerItem(Items.bucket);
        //this.setTextureName(ModInfo.MODID + ":tools/fluidBlazeBucket");
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".liquid.blaze.bucket");
    }
}
