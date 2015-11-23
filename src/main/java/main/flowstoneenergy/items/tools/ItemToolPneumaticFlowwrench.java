package main.flowstoneenergy.items.tools;

//import ic2.api.tile.IWrenchable;
import main.flowstoneenergy.core.libs.ConfigHandler;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.core.interfaces.IFlowWrenchable;
import main.flowstoneenergy.core.utils.KeyboardHelper;
import main.flowstoneenergy.core.utils.TextHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockLever;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.*;

public class ItemToolPneumaticFlowwrench extends ItemToolFlowwrench {

    Random rand = new Random();
    private int maxFE = 10000;
    public int currentFE = 0;
    private final Set<Class<? extends Block>> shiftRotations = new HashSet<Class<? extends Block>>();
    public static final byte[] opposite = {1, 0, 3, 2, 5, 4};
    private boolean icInstalled = true;
    private boolean bcInstalled = true;
    private boolean aeInstalled = true;
    private boolean eiInstalled = true;

    public ItemToolPneumaticFlowwrench() {
        super();
        this.setUnlocalizedName(ModInfo.MODID + ".pneumatic.flowwrench");
        this.setTextureName(ModInfo.MODID + ":tools/pneumaticFlowwrench");
        this.setMaxStackSize(1);
        shiftRotations.add(BlockLever.class);
        shiftRotations.add(BlockButton.class);
        shiftRotations.add(BlockChest.class);
    }

    private boolean isShiftRotation(Class<? extends Block> cls) {
        for (Class<? extends Block> shift : shiftRotations) {
            if (shift.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        if (!KeyboardHelper.isShiftDown()) {
            list.add(TextHelper.shiftForMoreInfo);
        } else {
            list.add(TextHelper.GREEN + currentFE + "/" + maxFE + TextHelper.localize("info.fe.tooltip.stored"));
            list.add(" ");
            list.add(TextHelper.ITALIC + TextHelper.localize("info.fe.tooltip.installed"));
            if (icInstalled) {
                list.add(TextHelper.localize("info.fe.tooltip.installed.ic2"));
            }
            if (aeInstalled) {
                list.add(TextHelper.localize("info.fe.tooltip.installed.ae"));
            }
            if (bcInstalled) {
                list.add(TextHelper.localize("info.fe.tooltip.installed.bc"));
            }
            if (eiInstalled) {
                list.add(TextHelper.localize("info.fe.tooltip.installed.ei"));
            }
        }
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int hitSide, float hitX, float hitY, float hitZ) {
        // FE
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);
        TileEntity te = world.getTileEntity(x, y, z);
        if (block instanceof IFlowWrenchable) {
            if (player.isSneaking()) {
                world.setBlock(x, y, z, Blocks.air);
                if (!world.isRemote) {
                    world.spawnEntityInWorld(new EntityItem(world, (double) x, (double) y, (double) z, new ItemStack(block, 1, meta)));
                }
                itemStack.damageItem(1, player);
            }
        }
        // IC2
        /*
        if (icInstalled || ConfigHandler.debugMode) {
            if (te instanceof IWrenchable) {
                IWrenchable wrenchable = (IWrenchable) te;
                ItemStack wrenchDrop = wrenchable.getWrenchDrop(player);
                ArrayList<ItemStack> drops = block.getDrops(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
                if (player.isSneaking()) {
                    hitSide = opposite[hitSide];
                }
                if (wrenchable.wrenchCanSetFacing(player, hitSide)) {
                    if (!world.isRemote) {
                        wrenchable.setFacing((short) hitSide);
                    }
                } else if (wrenchable.wrenchCanRemove(player)) {
                    if (wrenchDrop != null) {
                        if (drops.isEmpty()) {
                            drops.add(wrenchDrop);
                        } else {
                            drops.set(0, wrenchDrop);
                        }
                    }

                    world.setBlockToAir(x, y, z);
                    if (!world.isRemote) {
                        for (ItemStack drop : drops) {
                            world.spawnEntityInWorld(new EntityItem(world, (double) x, (double) y, (double) z, drop));
                        }
                    }
                }
            }
        }
        */

        // BC/AE2
        if (bcInstalled || ConfigHandler.debugMode) {
            if (block == null) {
                return false;
            }

            if (player.isSneaking() != isShiftRotation(block.getClass())) {
                return false;
            }

            if (block.rotateBlock(world, x, y, z, ForgeDirection.getOrientation(hitSide))) {
                player.swingItem();
                return !world.isRemote;
            }
        }
        player.swingItem();
        return true;
    }
}