package main.flowstoneenergy.items;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.utils.BlockUtils;
import main.flowstoneenergy.utils.ItemUtils;
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
        l.add(new ItemStack(ItemUtils.flowwrench));
        l.add(new ItemStack(ItemUtils.pneumaticFlowwrench));
        l.add(new ItemStack(BlockUtils.machineBox));
        l.add(new ItemStack(BlockUtils.heatedOven));
        l.add(new ItemStack(BlockUtils.energizedOreTumbler));
        l.add(new ItemStack(BlockUtils.flowstoneBottler));
        l.add(new ItemStack(BlockUtils.metalMixer));
        l.add(new ItemStack(BlockUtils.machineWorkbench));
        l.add(new ItemStack(BlockUtils.autoCrafter));
        l.add(new ItemStack(BlockUtils.copperOre));
        l.add(new ItemStack(BlockUtils.tinOre));
        l.add(new ItemStack(BlockUtils.leadOre));
        l.add(new ItemStack(BlockUtils.silverOre));
        l.add(new ItemStack(BlockUtils.nickelOre));
        l.add(new ItemStack(ItemUtils.cookedBacon));
        l.add(new ItemStack(ItemUtils.rawBacon));
    }
}
