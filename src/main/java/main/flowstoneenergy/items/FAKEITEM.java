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
        l.add(new ItemStack(BlockRegistry.machineBox));
        l.add(new ItemStack(BlockRegistry.heatedOven));
        l.add(new ItemStack(BlockRegistry.energizedOreTumbler));
        l.add(new ItemStack(BlockRegistry.flowstoneBottler));
        l.add(new ItemStack(BlockRegistry.metalMixer));
        l.add(new ItemStack(BlockRegistry.machineWorkbench));
        l.add(new ItemStack(BlockRegistry.lumberMill));
        l.add(new ItemStack(BlockRegistry.autoCrafter));
        l.add(new ItemStack(ItemRegistry.flowwrench));
        l.add(new ItemStack(ItemRegistry.pneumaticFlowwrench));
        l.add(new ItemStack(ItemRegistry.tierOne));
        l.add(new ItemStack(ItemRegistry.tierTwo));
        l.add(new ItemStack(ItemRegistry.tierThree));
        l.add(new ItemStack(ItemRegistry.tierFour));
        l.add(new ItemStack(ItemRegistry.tierFive));
        l.add(new ItemStack(ItemRegistry.cookedBacon));
        l.add(new ItemStack(ItemRegistry.rawBacon));
        l.add(new ItemStack(ItemRegistry.enderSword));
        l.add(new ItemStack(ItemRegistry.enderPick));
        l.add(new ItemStack(ItemRegistry.enderAxe));
        l.add(new ItemStack(ItemRegistry.enderShovel));
        l.add(new ItemStack(ItemRegistry.enderHoe));
        l.add(new ItemStack(ItemRegistry.electrumSword));
        l.add(new ItemStack(ItemRegistry.electrumPick));
        l.add(new ItemStack(ItemRegistry.electrumAxe));
        l.add(new ItemStack(ItemRegistry.electrumShovel));
        l.add(new ItemStack(ItemRegistry.electrumHoe));
    }
}
