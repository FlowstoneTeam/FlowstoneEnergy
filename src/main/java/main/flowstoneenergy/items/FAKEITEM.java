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
        l.add(new ItemStack(ItemRegistry.tierOne));
        l.add(new ItemStack(ItemRegistry.tierTwo));
        l.add(new ItemStack(ItemRegistry.tierThree));
        l.add(new ItemStack(ItemRegistry.tierFour));
        l.add(new ItemStack(ItemRegistry.tierFive));
    }
}
