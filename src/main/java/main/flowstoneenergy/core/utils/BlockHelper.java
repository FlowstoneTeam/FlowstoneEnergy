package main.flowstoneenergy.core.utils;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockHelper {

    public static byte[] rotateType = new byte[4096];
    public static final int[][] SIDE_COORD_MOD = new int[][]{{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {-1, 0, 0}, {1, 0, 0}};
    public static float[][] SIDE_COORD_AABB = new float[][]{{1.0F, -2.0F, 1.0F}, {1.0F, 2.0F, 1.0F}, {1.0F, 1.0F, 1.0F}, {1.0F, 1.0F, 2.0F}, {1.0F, 1.0F, 1.0F}, {2.0F, 1.0F, 1.0F}};
    public static final byte[] SIDE_LEFT = new byte[]{(byte)4, (byte)5, (byte)5, (byte)4, (byte)2, (byte)3};
    public static final byte[] SIDE_RIGHT = new byte[]{(byte)5, (byte)4, (byte)4, (byte)5, (byte)3, (byte)2};
    public static final byte[] SIDE_OPPOSITE = new byte[]{(byte)1, (byte)0, (byte)3, (byte)2, (byte)5, (byte)4};
    public static final byte[] SIDE_ABOVE = new byte[]{(byte)3, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1};
    public static final byte[] SIDE_BELOW = new byte[]{(byte)2, (byte)3, (byte)0, (byte)0, (byte)0, (byte)0};
    public static final byte[] ROTATE_CLOCK_Y = new byte[]{(byte)0, (byte)1, (byte)4, (byte)5, (byte)3, (byte)2};
    public static final byte[] ROTATE_CLOCK_Z = new byte[]{(byte)5, (byte)4, (byte)2, (byte)3, (byte)0, (byte)1};
    public static final byte[] ROTATE_CLOCK_X = new byte[]{(byte)2, (byte)3, (byte)1, (byte)0, (byte)4, (byte)5};
    public static final byte[] ROTATE_COUNTER_Y = new byte[]{(byte)0, (byte)1, (byte)5, (byte)4, (byte)2, (byte)3};
    public static final byte[] ROTATE_COUNTER_Z = new byte[]{(byte)4, (byte)5, (byte)2, (byte)3, (byte)1, (byte)0};
    public static final byte[] ROTATE_COUNTER_X = new byte[]{(byte)3, (byte)2, (byte)0, (byte)1, (byte)4, (byte)5};
    public static final byte[] INVERT_AROUND_Y = new byte[]{(byte)0, (byte)1, (byte)3, (byte)2, (byte)5, (byte)4};
    public static final byte[] INVERT_AROUND_Z = new byte[]{(byte)1, (byte)0, (byte)2, (byte)3, (byte)5, (byte)4};
    public static final byte[] INVERT_AROUND_X = new byte[]{(byte)1, (byte)0, (byte)3, (byte)2, (byte)4, (byte)5};
    public static final byte[][] ICON_ROTATION_MAP = new byte[6][];

    private BlockHelper() {
    }

    public static int getHighestY(World var0, int var1, int var2) {
        return var0.getChunkFromBlockCoords(var1, var2).getTopFilledSegment() + 16;
    }

    public static int getSurfaceBlockY(World var0, int var1, int var2) {
        int var3 = var0.getChunkFromBlockCoords(var1, var2).getTopFilledSegment() + 16;

        Block var4;
        do {
            --var3;
            if(var3 <= 0) {
                break;
            }

            var4 = var0.getBlock(var1, var3, var2);
        } while(var4.isAir(var0, var1, var3, var2) || var4.isLeaves(var0, var1, var3, var2) || var4.isReplaceable(var0, var1, var3, var2) || var4.canBeReplacedByLeaves(var0, var1, var3, var2));

        return var3;
    }

    public static int getTopBlockY(World var0, int var1, int var2) {
        int var3 = var0.getChunkFromBlockCoords(var1, var2).getTopFilledSegment() + 16;

        Block var4;
        do {
            --var3;
            if(var3 <= 0) {
                break;
            }

            var4 = var0.getBlock(var1, var3, var2);
        } while(var4.isAir(var0, var1, var3, var2));

        return var3;
    }

    public static MovingObjectPosition getCurrentMovingObjectPosition(EntityPlayer var0, double var1) {
        Vec3 var3 = Vec3.createVectorHelper(var0.posX, var0.posY, var0.posZ);
        Vec3 var4 = var0.getLook(1.0F);
        var3.yCoord += (double)var0.getEyeHeight();
        var4 = var3.addVector(var4.xCoord * var1, var4.yCoord * var1, var4.zCoord * var1);
        return var0.worldObj.rayTraceBlocks(var3, var4);
    }

    public static MovingObjectPosition getCurrentMovingObjectPosition(EntityPlayer var0) {
        return getCurrentMovingObjectPosition(var0, var0.capabilities.isCreativeMode?5.0D:4.5D);
    }

    public static int getCurrentMousedOverSide(EntityPlayer var0) {
        MovingObjectPosition var1 = getCurrentMovingObjectPosition(var0);
        return var1 == null?0:var1.sideHit;
    }

    public static int determineXZPlaceFacing(EntityLivingBase var0) {
        int var1 = MathHelper.floor_double((double) (var0.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        switch(var1) {
            case 0:
                return 2;
            case 1:
                return 5;
            case 2:
                return 3;
            case 3:
                return 4;
            default:
                return 3;
        }
    }

    public static boolean isEqual(Block var0, Block var1) {
        return var0 == var1?true:(var0 == null | var1 == null?false:var0.equals(var1) || var0.isAssociatedBlock(var1));
    }

    public static TileEntity getAdjacentTileEntity(World var0, int var1, int var2, int var3, ForgeDirection var4) {
        return var0 == null?null:var0.getTileEntity(var1 + var4.offsetX, var2 + var4.offsetY, var3 + var4.offsetZ);
    }

    public static TileEntity getAdjacentTileEntity(World var0, int var1, int var2, int var3, int var4) {
        return var0 == null?null:getAdjacentTileEntity(var0, var1, var2, var3, ForgeDirection.values()[var4]);
    }

    public static TileEntity getAdjacentTileEntity(TileEntity var0, ForgeDirection var1) {
        return var0 == null?null:getAdjacentTileEntity(var0.getWorldObj(), var0.xCoord, var0.yCoord, var0.zCoord, var1);
    }

    public static TileEntity getAdjacentTileEntity(TileEntity var0, int var1) {
        return var0 == null?null:getAdjacentTileEntity(var0.getWorldObj(), var0.xCoord, var0.yCoord, var0.zCoord, ForgeDirection.values()[var1]);
    }

    public static int determineAdjacentSide(TileEntity var0, int var1, int var2, int var3) {
        return var2 > var0.yCoord?1:(var2 < var0.yCoord?0:(var3 > var0.zCoord?3:(var3 < var0.zCoord?2:(var1 > var0.xCoord?5:4))));
    }

    public static int[] getAdjacentCoordinatesForSide(MovingObjectPosition var0) {
        return getAdjacentCoordinatesForSide(var0.blockX, var0.blockY, var0.blockZ, var0.sideHit);
    }

    public static int[] getAdjacentCoordinatesForSide(int var0, int var1, int var2, int var3) {
        return new int[]{var0 + SIDE_COORD_MOD[var3][0], var1 + SIDE_COORD_MOD[var3][1], var2 + SIDE_COORD_MOD[var3][2]};
    }

    public static AxisAlignedBB getAdjacentAABBForSide(MovingObjectPosition var0) {
        return getAdjacentAABBForSide(var0.blockX, var0.blockY, var0.blockZ, var0.sideHit);
    }

    public static AxisAlignedBB getAdjacentAABBForSide(int var0, int var1, int var2, int var3) {
        return AxisAlignedBB.getBoundingBox((double)(var0 + SIDE_COORD_MOD[var3][0]), (double)(var1 + SIDE_COORD_MOD[var3][1]), (double)(var2 + SIDE_COORD_MOD[var3][2]), (double)((float)var0 + SIDE_COORD_AABB[var3][0]), (double)((float)var1 + SIDE_COORD_AABB[var3][1]), (double)((float)var2 + SIDE_COORD_AABB[var3][2]));
    }

    public static int getLeftSide(int var0) {
        return SIDE_LEFT[var0];
    }

    public static int getRightSide(int var0) {
        return SIDE_RIGHT[var0];
    }

    public static int getOppositeSide(int var0) {
        return SIDE_OPPOSITE[var0];
    }

    public static int getAboveSide(int var0) {
        return SIDE_ABOVE[var0];
    }

    public static int getBelowSide(int var0) {
        return SIDE_BELOW[var0];
    }

    public static boolean canRotate(Block var0) {
        return rotateType[Block.getIdFromBlock(var0)] != 0;
    }

    public static int rotateVanillaBlock(World var0, Block var1, int var2, int var3, int var4) {
        int var5 = Block.getIdFromBlock(var1);
        int var6 = var0.getBlockMetadata(var2, var3, var4);
        switch(rotateType[var5]) {
            case -1:
            case 0:
            default:
                return var6;
            case 1:
                return SIDE_LEFT[var6];
            case 2:
                if(var6 < 6) {
                    ++var6;
                    return var6 % 6;
                }

                return var6;
            case 3:
                if(var6 < 2) {
                    ++var6;
                    return var6 % 2;
                }

                return var6;
            case 4:
                ++var6;
                return var6 % 4;
            case 5:
                ++var6;
                return var6 % 8;
            case 6:
                int var7 = var6 & 12;
                int var8 = var6 & 3;
                ++var8;
                return var7 + var8 % 4;
            case 7:
                return (var6 + 4) % 12;
            case 8:
                return (var6 + 8) % 16;
            case 9:
                int[] var9 = new int[3];

                for(int var11 = 2; var11 < 6; ++var11) {
                    var9 = getAdjacentCoordinatesForSide(var2, var3, var4, var11);
                    if(isEqual(var0.getBlock(var9[0], var9[1], var9[2]), var1)) {
                        var0.setBlockMetadataWithNotify(var9[0], var9[1], var9[2], SIDE_OPPOSITE[var6], 1);
                        return SIDE_OPPOSITE[var6];
                    }
                }

                return SIDE_LEFT[var6];
            case 10:
                byte var10 = 0;
                if(var6 > 7) {
                    var6 -= 8;
                    var10 = 8;
                }

                if(var6 == 5) {
                    return 6 + var10;
                } else if(var6 == 6) {
                    return 5 + var10;
                } else if(var6 == 7) {
                    return 0 + var10;
                } else {
                    if(var6 == 0) {
                        return 7 + var10;
                    }

                    return var6 + var10;
                }
            case 11:
                ++var6;
                return var6 % 16;
        }
    }

    public static int rotateVanillaBlockAlt(World var0, Block var1, int var2, int var3, int var4) {
        int var5 = Block.getIdFromBlock(var1);
        int var6 = var0.getBlockMetadata(var2, var3, var4);
        switch(rotateType[var5]) {
            case -1:
            case 0:
            default:
                return var6;
            case 1:
                return SIDE_RIGHT[var6];
            case 2:
                if(var6 < 6) {
                    return (var6 + 5) % 6;
                }

                return var6;
            case 3:
                if(var6 < 2) {
                    ++var6;
                    return var6 % 2;
                }

                return var6;
            case 4:
                return (var6 + 3) % 4;
            case 5:
                return (var6 + 7) % 8;
            case 6:
                int var7 = var6 & 12;
                int var8 = var6 & 3;
                return var7 + (var8 + 3) % 4;
            case 7:
                return (var6 + 8) % 12;
            case 8:
                return (var6 + 8) % 16;
            case 9:
                int[] var9 = new int[3];

                for(int var11 = 2; var11 < 6; ++var11) {
                    var9 = getAdjacentCoordinatesForSide(var2, var3, var4, var11);
                    if(isEqual(var0.getBlock(var9[0], var9[1], var9[2]), var1)) {
                        var0.setBlockMetadataWithNotify(var9[0], var9[1], var9[2], SIDE_OPPOSITE[var6], 1);
                        return SIDE_OPPOSITE[var6];
                    }
                }

                return SIDE_RIGHT[var6];
            case 10:
                byte var10 = 0;
                if(var6 > 7) {
                    var6 -= 8;
                    var10 = 8;
                }

                if(var6 == 5) {
                    return 6 + var10;
                } else if(var6 == 6) {
                    return 5 + var10;
                } else if(var6 == 7) {
                    return 0 + var10;
                } else if(var6 == 0) {
                    return 7 + var10;
                }
            case 11:
                ++var6;
                return var6 % 16;
        }
    }

    public static List<ItemStack> breakBlock(World var0, int var1, int var2, int var3, Block var4, int var5, boolean var6, boolean var7) {
        if(var4.getBlockHardness(var0, var1, var2, var3) == -1.0F) {
            return new LinkedList();
        } else {
            int var8 = var0.getBlockMetadata(var1, var2, var3);
            Object var9 = null;
            if(var7 && var4.canSilkHarvest(var0, (EntityPlayer)null, var1, var2, var3, var8)) {
                var9 = new LinkedList();
                ((List)var9).add(createStackedBlock(var4, var8));
            } else {
                var9 = var4.getDrops(var0, var1, var2, var3, var8, var5);
            }

            if(!var6) {
                return (List)var9;
            } else {
                var0.playAuxSFXAtEntity((EntityPlayer)null, 2001, var1, var2, var3, Block.getIdFromBlock(var4) + (var8 << 12));
                var0.setBlockToAir(var1, var2, var3);
                List var10 = var0.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox((double)(var1 - 2), (double)(var2 - 2), (double)(var3 - 2), (double)(var1 + 3), (double)(var2 + 3), (double)(var3 + 3)));

                for(int var11 = 0; var11 < var10.size(); ++var11) {
                    EntityItem var12 = (EntityItem)var10.get(var11);
                    if(!var12.isDead && var12.getEntityItem().stackSize > 0) {
                        ((List)var9).add(var12.getEntityItem());
                        var12.worldObj.removeEntity(var12);
                    }
                }

                return (List)var9;
            }
        }
    }

    public static ItemStack createStackedBlock(Block var0, int var1) {
        Item var2 = Item.getItemFromBlock(var0);
        return var2.getHasSubtypes()?new ItemStack(var2, 1, var1):new ItemStack(var2, 1, 0);
    }

    static {
        ICON_ROTATION_MAP[0] = new byte[]{(byte)0, (byte)1, (byte)2, (byte)3, (byte)4, (byte)5};
        ICON_ROTATION_MAP[1] = new byte[]{(byte)1, (byte)0, (byte)2, (byte)3, (byte)4, (byte)5};
        ICON_ROTATION_MAP[2] = new byte[]{(byte)3, (byte)2, (byte)0, (byte)1, (byte)4, (byte)5};
        ICON_ROTATION_MAP[3] = new byte[]{(byte)3, (byte)2, (byte)1, (byte)0, (byte)5, (byte)4};
        ICON_ROTATION_MAP[4] = new byte[]{(byte)3, (byte)2, (byte)5, (byte)4, (byte)0, (byte)1};
        ICON_ROTATION_MAP[5] = new byte[]{(byte)3, (byte)2, (byte)4, (byte)5, (byte)1, (byte)0};
        rotateType[Block.getIdFromBlock(Blocks.bed)] = -1;
        rotateType[Block.getIdFromBlock(Blocks.stone_slab)] = 8;
        rotateType[Block.getIdFromBlock(Blocks.wooden_slab)] = 8;
        rotateType[Block.getIdFromBlock(Blocks.rail)] = 3;
        rotateType[Block.getIdFromBlock(Blocks.golden_rail)] = 3;
        rotateType[Block.getIdFromBlock(Blocks.detector_rail)] = 3;
        rotateType[Block.getIdFromBlock(Blocks.activator_rail)] = 3;
        rotateType[Block.getIdFromBlock(Blocks.pumpkin)] = 4;
        rotateType[Block.getIdFromBlock(Blocks.lit_pumpkin)] = 4;
        rotateType[Block.getIdFromBlock(Blocks.furnace)] = 1;
        rotateType[Block.getIdFromBlock(Blocks.lit_furnace)] = 1;
        rotateType[Block.getIdFromBlock(Blocks.ender_chest)] = 1;
        rotateType[Block.getIdFromBlock(Blocks.trapped_chest)] = 9;
        rotateType[Block.getIdFromBlock(Blocks.chest)] = 9;
        rotateType[Block.getIdFromBlock(Blocks.dispenser)] = 2;
        rotateType[Block.getIdFromBlock(Blocks.sticky_piston)] = 2;
        rotateType[Block.getIdFromBlock(Blocks.piston)] = 2;
        rotateType[Block.getIdFromBlock(Blocks.hopper)] = 2;
        rotateType[Block.getIdFromBlock(Blocks.dropper)] = 2;
        rotateType[Block.getIdFromBlock(Blocks.unpowered_repeater)] = 6;
        rotateType[Block.getIdFromBlock(Blocks.unpowered_comparator)] = 6;
        rotateType[Block.getIdFromBlock(Blocks.powered_repeater)] = 6;
        rotateType[Block.getIdFromBlock(Blocks.powered_comparator)] = 6;
        rotateType[Block.getIdFromBlock(Blocks.lever)] = 10;
        rotateType[Block.getIdFromBlock(Blocks.standing_sign)] = 11;
        rotateType[Block.getIdFromBlock(Blocks.oak_stairs)] = 5;
        rotateType[Block.getIdFromBlock(Blocks.stone_stairs)] = 5;
        rotateType[Block.getIdFromBlock(Blocks.brick_stairs)] = 5;
        rotateType[Block.getIdFromBlock(Blocks.stone_brick_stairs)] = 5;
        rotateType[Block.getIdFromBlock(Blocks.nether_brick_stairs)] = 5;
        rotateType[Block.getIdFromBlock(Blocks.sandstone_stairs)] = 5;
        rotateType[Block.getIdFromBlock(Blocks.spruce_stairs)] = 5;
        rotateType[Block.getIdFromBlock(Blocks.birch_stairs)] = 5;
        rotateType[Block.getIdFromBlock(Blocks.jungle_stairs)] = 5;
        rotateType[Block.getIdFromBlock(Blocks.quartz_stairs)] = 5;
    }

    public static final class RotationType {
        public static final int PREVENT = -1;
        public static final int FOUR_WAY = 1;
        public static final int SIX_WAY = 2;
        public static final int RAIL = 3;
        public static final int PUMPKIN = 4;
        public static final int STAIRS = 5;
        public static final int REDSTONE = 6;
        public static final int LOG = 7;
        public static final int SLAB = 8;
        public static final int CHEST = 9;
        public static final int LEVER = 10;
        public static final int SIGN = 11;

        public RotationType() {
        }
    }
}