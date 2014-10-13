package main.flowstoneenergy.items;

import cpw.mods.fml.common.registry.GameRegistry;
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.items.battery.*;
import main.flowstoneenergy.items.flowarmor.ItemArmorFlowBoots;
import main.flowstoneenergy.items.flowarmor.ItemArmorFlowChestplate;
import main.flowstoneenergy.items.flowarmor.ItemArmorFlowHelm;
import main.flowstoneenergy.items.flowarmor.ItemArmorFlowLeggings;
import main.flowstoneenergy.items.tools.*;
import main.flowstoneenergy.items.tools.electrum.*;
import main.flowstoneenergy.items.tools.ender.*;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemRegistry {

    // Tool Materials
    public static final ToolMaterial ender = EnumHelper.addToolMaterial("ENDER_TOOL_MATERIAL", Integer.MAX_VALUE, 2000, 16.0F, 12, 45);
    public static final ToolMaterial electrum = EnumHelper.addToolMaterial("ELECTRUM_TOOL_MATERIAL", 4, 1000, 12.0F, 8, 25);

    // armour materials
    public static final ArmorMaterial flowfield = EnumHelper.addArmorMaterial("flowfield", -1, new int[]{1, 2, 3, 4}, 0);

    // batteries
    public static ItemBatteryFlowstoneBase tierOne;
    public static ItemBatteryFlowstoneBase tierTwo;
    public static ItemBatteryFlowstoneBase tierThree;
    public static ItemBatteryFlowstoneBase tierFour;
    public static ItemBatteryFlowstoneBase tierFive;

    // tools
    public static Item flowwrench;
    public static Item pneumaticFlowwrench;
    public static Item enderSword;
    public static Item enderHoe;
    public static Item enderAxe;
    public static Item enderPick;
    public static Item enderShovel;
    public static Item electrumSword;
    public static Item electrumHoe;
    public static Item electrumAxe;
    public static Item electrumPick;
    public static Item electrumShovel;
    public static Item manual;

    // armour
    public static Item flowBoots;
    public static Item flowLeggings;
    public static Item flowChestplate;
    public static Item flowHelm;

    // resources
    public static Item metaResourceDust;
    public static Item metaResourceIngot;
    public static Item metaResourceGear;

    // utensils
    public static Item metaResourceUtensil;

    // misc
    public static Item flowstoneBucket;
    public static Item fluidBlazeBucket;

    public static void registerItems() {
        // Metadata Item
        metaResourceDust = new ItemMetaResourceDust().setUnlocalizedName("itemMetadataResourceDust");
        GameRegistry.registerItem(metaResourceDust, "ItemMetadataResourceDust");
        metaResourceIngot = new ItemMetaResourceIngots().setUnlocalizedName("itemMetadataResourceIngot");
        GameRegistry.registerItem(metaResourceIngot, "ItemMetadataResourceIngot");
        metaResourceGear = new ItemMetaResourceGears().setUnlocalizedName("itemMetadataResourceGear");
        GameRegistry.registerItem(metaResourceGear, "ItemMetadataResourceGear");

        // batteries
        tierOne = new ItemBatteryFlowstoneTierOne();
        GameRegistry.registerItem(tierOne, tierOne.getUnlocalizedName());
        tierTwo = new ItemBatteryFlowstoneTierTwo();
        GameRegistry.registerItem(tierTwo, tierTwo.getUnlocalizedName());
        tierThree = new ItemBatteryFlowstoneTierThree();
        GameRegistry.registerItem(tierThree, tierThree.getUnlocalizedName());
        tierFour = new ItemBatteryFlowstoneTierFour();
        GameRegistry.registerItem(tierFour, tierFour.getUnlocalizedName());
        tierFive = new ItemBatteryFlowstoneTierFive();
        GameRegistry.registerItem(tierFive, tierFive.getUnlocalizedName());

        // tools
        flowwrench = new ItemToolFlowwrench();
        GameRegistry.registerItem(flowwrench, flowwrench.getUnlocalizedName());
        pneumaticFlowwrench = new ItemToolPneumaticFlowwrench();
        GameRegistry.registerItem(pneumaticFlowwrench, pneumaticFlowwrench.getUnlocalizedName());
        enderSword = new ItemSwordEnder(ender);
        GameRegistry.registerItem(enderSword, enderSword.getUnlocalizedName());
        enderPick = new ItemPickEnder(ender);
        GameRegistry.registerItem(enderPick, enderPick.getUnlocalizedName());
        enderHoe = new ItemHoeEnder(ender);
        GameRegistry.registerItem(enderHoe, enderHoe.getUnlocalizedName());
        enderShovel = new ItemShovelEnder(ender);
        GameRegistry.registerItem(enderShovel, enderShovel.getUnlocalizedName());
        enderAxe = new ItemAxeEnder(ender);
        GameRegistry.registerItem(enderAxe, enderAxe.getUnlocalizedName());
        electrumSword = new ItemSwordElectrum(electrum);
        GameRegistry.registerItem(electrumSword, electrumSword.getUnlocalizedName());
        electrumPick = new ItemPickElectrum(electrum);
        GameRegistry.registerItem(electrumPick, electrumPick.getUnlocalizedName());
        electrumHoe = new ItemHoeElectrum(electrum);
        GameRegistry.registerItem(electrumHoe, electrumHoe.getUnlocalizedName());
        electrumShovel = new ItemShovelElectrum(electrum);
        GameRegistry.registerItem(electrumShovel, electrumShovel.getUnlocalizedName());
        electrumAxe = new ItemAxeElectrum(electrum);
        GameRegistry.registerItem(electrumAxe, electrumAxe.getUnlocalizedName());
        manual = new ItemFlowstoneManual();
        GameRegistry.registerItem(manual, manual.getUnlocalizedName());

        // armour
        flowBoots = new ItemArmorFlowBoots(flowfield, 0, 3);
        GameRegistry.registerItem(flowBoots, flowBoots.getUnlocalizedName());
        flowLeggings = new ItemArmorFlowLeggings(flowfield, 0, 2);
        GameRegistry.registerItem(flowLeggings, flowLeggings.getUnlocalizedName());
        flowChestplate = new ItemArmorFlowChestplate(flowfield, 0, 1);
        GameRegistry.registerItem(flowChestplate, flowChestplate.getUnlocalizedName());
        flowHelm = new ItemArmorFlowHelm(flowfield, 0, 0);
        GameRegistry.registerItem(flowHelm, flowHelm.getUnlocalizedName());

        // misc
        flowstoneBucket = new ItemFlowstoneBucket(BlockRegistry.flowstoneBlock);
        GameRegistry.registerItem(flowstoneBucket, flowstoneBucket.getUnlocalizedName());
        fluidBlazeBucket = new ItemLiquidBlazeBucket(BlockRegistry.fluidBlazeBlock);
        GameRegistry.registerItem(fluidBlazeBucket, fluidBlazeBucket.getUnlocalizedName());
    }
}
