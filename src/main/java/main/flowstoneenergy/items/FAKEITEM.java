package main.flowstoneenergy.items;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.blocks.BlockRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class FAKEITEM extends Item {
    public FAKEITEM() {
        super();
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setUnlocalizedName(".fake.item");
        this.setTextureName(ModInfo.MODID + ":fakeItem");
        this.setHasSubtypes(true);
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void getSubItems(Item item, CreativeTabs tab, List l) {
        l.add(new ItemStack(ItemRegistry.flowwrench));
        l.add(new ItemStack(ItemRegistry.pneumaticFlowwrench));
        l.add(new ItemStack(BlockRegistry.machineBox));
        l.add(new ItemStack(BlockRegistry.heatedOven));
        l.add(new ItemStack(BlockRegistry.energizedOreTumbler));
        l.add(new ItemStack(BlockRegistry.flowstoneBottler));
        l.add(new ItemStack(BlockRegistry.metalMixer));
        l.add(new ItemStack(BlockRegistry.machineWorkbench));
        l.add(new ItemStack(BlockRegistry.machineLumberMill));
        l.add(new ItemStack(BlockRegistry.autoCrafter));
        l.add(new ItemStack(BlockRegistry.copperOre));
        l.add(new ItemStack(BlockRegistry.tinOre));
        l.add(new ItemStack(BlockRegistry.leadOre));
        l.add(new ItemStack(BlockRegistry.silverOre));
        l.add(new ItemStack(BlockRegistry.nickelOre));
        l.add(new ItemStack(ItemRegistry.cookedBacon));
        l.add(new ItemStack(ItemRegistry.rawBacon));
    }
}
