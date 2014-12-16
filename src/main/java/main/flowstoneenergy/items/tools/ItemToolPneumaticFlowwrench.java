package main.flowstoneenergy.items.tools;

import cofh.api.block.IDismantleable;
import ic2.api.tile.IWrenchable;
import main.flowstoneenergy.core.interfaces.IOmniWrenchable;
import main.flowstoneenergy.core.libs.ConfigHandler;
import main.flowstoneenergy.core.libs.ModInfo;
import main.flowstoneenergy.core.interfaces.IFlowWrenchable;
import main.flowstoneenergy.core.utils.BlockHelper;
import main.flowstoneenergy.core.utils.KeyboardHelper;
import main.flowstoneenergy.core.utils.ServerHelper;
import main.flowstoneenergy.core.utils.TextHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockLever;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import pneumaticCraft.api.IHeatExchangerLogic;
import pneumaticCraft.api.block.IPneumaticWrenchable;
import pneumaticCraft.api.client.pneumaticHelmet.IBlockTrackEntry;
import pneumaticCraft.api.client.pneumaticHelmet.IEntityTrackEntry;
import pneumaticCraft.api.client.pneumaticHelmet.IHackableBlock;
import pneumaticCraft.api.client.pneumaticHelmet.IHackableEntity;
import pneumaticCraft.api.drone.IPathfindHandler;
import pneumaticCraft.api.item.IInventoryItem;

import java.util.*;

public class ItemToolPneumaticFlowwrench extends ItemToolFlowwrench implements IOmniWrenchable {

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
    public boolean canWrench(EntityPlayer player, int x, int y, int z) {
        return true;
    }

    @Override
    public void wrenchUsed(EntityPlayer player, int x, int y, int z) {

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

    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int hitSide, float hitX, float hitY, float hitZ) {
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);

		/* IDismantleable Compat */
        if (ServerHelper.isServerWorld(world) && player.isSneaking() && block instanceof IDismantleable && ((IDismantleable) block).canDismantle(player, world, x, y, z)) {
            ((IDismantleable)block).dismantleBlock(player, world, x, y, z, false);
            return true;
        }

		/* Rotation Handling */
        if (BlockHelper.canRotate(block)) {
            if (player.isSneaking()) {
                world.setBlockMetadataWithNotify(x, y, z, BlockHelper.rotateVanillaBlockAlt(world, block, x, y, z), 3);
				/*if (ServerHelper.isClientWorld(world)) {
					String soundName = block.stepSound.getBreakSound();
					FMLClientHandler.instance().getClient().getSoundHandler().playSound(new SoundBase(soundName, 1.0F, 0.6F));
				}*/
            } else {
                world.setBlockMetadataWithNotify(x, y, z, BlockHelper.rotateVanillaBlock(world, block, x, y, z), 3);
				/*if (ServerHelper.isClientWorld(world)) {
					String soundName = block.stepSound.getBreakSound();
					FMLClientHandler.instance().getClient().getSoundHandler().playSound(new SoundBase(soundName, 1.0F, 0.8F));
				}*/
            }
            return ServerHelper.isServerWorld(world);
        } else if (!player.isSneaking() && block.rotateBlock(world, x, y, z, ForgeDirection.getOrientation(hitSide))) {
            player.swingItem();
            return ServerHelper.isServerWorld(world);
        }

		/* Flowstone Energy Compat */

        if (block instanceof IFlowWrenchable) {
            if (player.isSneaking()) {
                world.setBlockToAir(x, y, z);
                if (ServerHelper.isServerWorld(world)) {
                    world.spawnEntityInWorld(new EntityItem(world, (double) x, (double) y, (double) z, new ItemStack(block, 1, meta)));
                }
            }
        }

		/* Industrial Craft 2 */
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof IWrenchable) {
            IWrenchable wrenchable = (IWrenchable) tile;
            if (player.isSneaking()) {
                hitSide = BlockHelper.SIDE_OPPOSITE[hitSide];
            }
            if (wrenchable.wrenchCanSetFacing(player, hitSide)) {
                if (ServerHelper.isServerWorld(world)) {
                    wrenchable.setFacing((short) hitSide);
                }
            } else if (wrenchable.wrenchCanRemove(player)) {
                ItemStack dropBlock = wrenchable.getWrenchDrop(player);

                if (dropBlock != null) {
                    world.setBlockToAir(x, y, z);
                    if (ServerHelper.isServerWorld(world)) {
                        List<ItemStack> drops = block.getDrops(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
                        if (drops.isEmpty()) {
                            drops.add(dropBlock);
                        } else {
                            drops.set(0, dropBlock);
                        }
                        for (ItemStack drop : drops) {
                            float f = 1.0F;
                            double x2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
                            double y2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
                            double z2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
                            EntityItem entity = new EntityItem(world, x + x2, y + y2, z + z2, drop);
                            entity.delayBeforeCanPickup = 10;
                            world.spawnEntityInWorld(entity);
                        }
                    }
                }
            }
            return ServerHelper.isServerWorld(world);
        }

        if (block instanceof IPneumaticWrenchable && ServerHelper.isServerWorld(world)) {
            if (((IPneumaticWrenchable) block).rotateBlock(world, player, x, y, z, ForgeDirection.getOrientation(hitSide))) {
                //NetworkHandler.sendToAllAround(new PacketPlaySound(Sounds.PNEUMATIC_WRENCH, x, y, z, 1.0F, 1.0F, false), world);
                return true;
            }
        }
        return false;
    }

    /* PneumaticCraft Drone Compat */
    @Override
    public boolean itemInteractionForEntity(ItemStack iStack, EntityPlayer player, EntityLivingBase entity){
        if(!player.worldObj.isRemote) {
            if(entity.isEntityAlive() && entity instanceof IPneumaticWrenchable) {
                if(((IPneumaticWrenchable)entity).rotateBlock(entity.worldObj, player, 0, 0, 0, ForgeDirection.UNKNOWN)) {
                    //NetworkHandler.sendToAllAround(new PacketPlaySound(Sounds.PNEUMATIC_WRENCH, entity.posX, entity.posY, entity.posZ, 1.0F, 1.0F, false), entity.worldObj);
                    return true;
                }
            }
        }
        return false;
    }

    /* ICarpentersHammer (Carpenter's Blocks) */
    @Override
    public void onHammerUse(World world, EntityPlayer player) {

    }

    @Override
    public boolean canUseHammer(World world, EntityPlayer player) {
        return true;
    }

    /* IToolCrowbar (RailCraft) */
    @Override
    public boolean canWhack(EntityPlayer player, ItemStack crowbar, int x, int y, int z) {
        return true;
    }

    @Override
    public void onWhack(EntityPlayer player, ItemStack crowbar, int x, int y, int z) {
        player.swingItem();
    }

    @Override
    public boolean canLink(EntityPlayer player, ItemStack crowbar, EntityMinecart cart) {
        return player.isSneaking();
    }

    @Override
    public void onLink(EntityPlayer player, ItemStack crowbar, EntityMinecart cart) {
        player.swingItem();
    }

    @Override
    public boolean canBoost(EntityPlayer player, ItemStack crowbar, EntityMinecart cart) {
        return !player.isSneaking();
    }

    @Override
    public void onBoost(EntityPlayer player, ItemStack crowbar, EntityMinecart cart) {
        player.swingItem();
    }

    /* IToolHammer (CoFH Mods) */
    @Override
    public boolean isUsable(ItemStack itemStack, EntityLivingBase entityLivingBase, int i, int i2, int i3) {
        return true;
    }

    @Override
    public void toolUsed(ItemStack itemStack, EntityLivingBase entityLivingBase, int i, int i2, int i3) {

    }

    /* IAEWrench (Applied Energistics 2) */
    @Override
    public boolean canWrench(ItemStack wrench, EntityPlayer player, int x, int y, int z) {
        return true;
    }

    @Override
    public ArrayList<ItemStack> dismantleBlock(EntityPlayer player, World world, int x, int y, int z, boolean returnDrops) {
        return null;
    }

    @Override
    public boolean canDismantle(EntityPlayer player, World world, int x, int y, int z) {
        return false;
    }

    @Override
    public boolean canWrenchRemove() {
        return false;
    }

    @Override
    public void registerEntityTrackEntry(Class<? extends IEntityTrackEntry> aClass) {

    }

    @Override
    public void registerBlockTrackEntry(IBlockTrackEntry iBlockTrackEntry) {

    }

    @Override
    public void addHackable(Class<? extends Entity> aClass, Class<? extends IHackableEntity> aClass2) {

    }

    @Override
    public void addHackable(Block block, Class<? extends IHackableBlock> aClass) {

    }

    @Override
    public List<IHackableEntity> getCurrentEntityHacks(Entity entity) {
        return null;
    }

    @Override
    public void addPathfindableBlock(Block block, IPathfindHandler iPathfindHandler) {

    }

    @Override
    public void registerInventoryItem(IInventoryItem iInventoryItem) {

    }

    @Override
    public IHeatExchangerLogic getHeatExchangerLogic() {
        return null;
    }

    @Override
    public void registerBlockExchanger(Block block, double v, double v2) {

    }

    @Override
    public void registerFuel(Fluid fluid, int i) {

    }

    @Override
    public int getProtectingSecurityStations(World world, int i, int i2, int i3, EntityPlayer player, boolean b) {
        return 0;
    }

    @Override
    public void registerConcealableRenderId(int i) {

    }

    @Override
    public void registerXPLiquid(Fluid fluid, int i) {

    }

    @Override
    public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int side) {
        return false;
    }

    @Override
    public short getFacing() {
        return 0;
    }

    @Override
    public void setFacing(short facing) {

    }

    @Override
    public boolean wrenchCanRemove(EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public float getWrenchDropRate() {
        return 0;
    }

    @Override
    public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        return null;
    }
}