package main.flowstoneenergy.items.tools;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class ItemFlowstoneBucket extends ItemBucket { 
  
    public ItemFlowstoneBucket(Block block) { 
        super(block); 
        this.maxStackSize = 1; 
        this.setContainerItem(Items.bucket); 
        this.setTextureName(ModInfo.MODID + ":tools/flowstoneBucket"); 
        this.setCreativeTab(FlowstoneEnergy.tab); 
        this.setUnlocalizedName(ModInfo.MODID + ".flowstone.bucket"); 
    } 
}
