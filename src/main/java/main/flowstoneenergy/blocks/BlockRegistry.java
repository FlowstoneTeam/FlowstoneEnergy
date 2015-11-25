package main.flowstoneenergy.blocks;

import main.flowstoneenergy.blocks.decorative.BlockAplite;
import main.flowstoneenergy.blocks.decorative.BlockStrongGlass;
import main.flowstoneenergy.blocks.decorative.BlockStrongGlassPane;
import main.flowstoneenergy.blocks.fluids.BlockFlowstone;
import main.flowstoneenergy.blocks.fluids.BlockFluidBlaze;
import main.flowstoneenergy.blocks.generators.BlockGenerator;
import main.flowstoneenergy.blocks.machines.BlockMachineBox;
import main.flowstoneenergy.blocks.machines.BlockMachineWorkbench;
import main.flowstoneenergy.blocks.machines.BlockMachines;
import main.flowstoneenergy.blocks.transport.BlockPipeFluid;
import main.flowstoneenergy.blocks.transport.BlockPipeItem;
import main.flowstoneenergy.blocks.transport.BlockPipePower;
import main.flowstoneenergy.blocks.upgrades.BlockUpgrades;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.items.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {

    // machines
    public static Block machineBox;
    public static Block machineWorkbench;
    public static Block machines;

    // decorative
    public static Block strongGlass;
    public static Block strongGlassPane;

    // other
    public static Block ingotStorage;
    public static Block aplite;
    public static Block upgrades;

    // transport
    public static Block itemPipe;
    public static Block fluidPipe;
    public static Block powerPipe;

    // ores
    public static Block blockOres;

    // fluids
    public static Fluid flowstone;
    public static Block flowstoneBlock;
    public static Fluid fluidBlaze;
    public static Block fluidBlazeBlock;
    
    // generators
    public static Block generator;

    public static void registerBlocks() {
        // machines
        machineBox = new BlockMachineBox();
        GameRegistry.registerBlock(machineBox, "machine_box");
        machineWorkbench = new BlockMachineWorkbench();
        GameRegistry.registerBlock(machineWorkbench, "machine_workbench");
        machines = new BlockMachines().setUnlocalizedName("blockMachines");
        GameRegistry.registerBlock(machines, ItemBlockMachines.class, "machines");

        // decorative
        strongGlass = new BlockStrongGlass();
        GameRegistry.registerBlock(strongGlass, "strong_glass");
        strongGlassPane = new BlockStrongGlassPane();
        GameRegistry.registerBlock(strongGlassPane, "strong_glass_pane");

        // other
        ingotStorage = new BlockIngotStorage().setUnlocalizedName("blockIngotStorage");
        GameRegistry.registerBlock(ingotStorage, ItemBlockIngotStorage.class, "ingot_storage");
        aplite = new BlockAplite().setUnlocalizedName("blockAplite");
        GameRegistry.registerBlock(aplite, ItemBlockAplite.class, "aplite");
        upgrades = new BlockUpgrades().setUnlocalizedName("blockUpgrades");
        GameRegistry.registerBlock(upgrades, ItemBlockUpgrades.class, "upgrades");

        // transport
        itemPipe = new BlockPipeItem();
        GameRegistry.registerBlock(itemPipe, "item_pipe");
        fluidPipe = new BlockPipeFluid();
        GameRegistry.registerBlock(fluidPipe, "fluid_pipe");
        powerPipe = new BlockPipePower();
        GameRegistry.registerBlock(powerPipe, "power_pipe");

        // ores
        blockOres = new BlockOres();
        GameRegistry.registerBlock(blockOres, ItemBlockOres.class, "ores");

        // fluids
        ResourceLocation stillFlowstone = new ResourceLocation(ModInfo.MODID + ":textures/blocks/fluids/stillFlowstone.png");
        ResourceLocation flowingFlowstone = new ResourceLocation(ModInfo.MODID + ":textures/blocks/fluids/flowingFlowstone.png");
        flowstone = new Fluid("flowstone", stillFlowstone, flowingFlowstone);
        FluidRegistry.registerFluid(flowstone);
        flowstoneBlock = new BlockFlowstone(flowstone);
        GameRegistry.registerBlock(flowstoneBlock, "fluid_flowstone");

        ResourceLocation stillFluidBlaze = new ResourceLocation(ModInfo.MODID + ":textures/blocks/fluids/stillLiquidBlaze.png");
        ResourceLocation flowingFluidBlaze = new ResourceLocation(ModInfo.MODID + ":textures/blocks/fluids/flowingLiquidBlaze.png");
        fluidBlaze = new Fluid("fluidBlaze", stillFluidBlaze, flowingFluidBlaze);
        FluidRegistry.registerFluid(fluidBlaze);
        fluidBlazeBlock = new BlockFluidBlaze(fluidBlaze);
        GameRegistry.registerBlock(fluidBlazeBlock, "fluid_blaze");
        
        // generator
        generator = new BlockGenerator();
        GameRegistry.registerBlock(generator, ItemBlockGenerators.class, "generator");
    }
}
