package main.flowstoneenergy.core.utils;

import main.flowstoneenergy.core.libs.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public class ConnectedTextureHelper {
    private static int[] textureIDs = {0, 0, 12, 12, 0, 0, 12, 12, 1, 1, 4, 13, 1, 1, 4, 13, 3, 3, 5, 5, 3, 3, 15, 15, 2, 2, 7, 31, 2, 2, 29, 14, 0, 0, 12, 12, 0, 0, 12, 12, 1, 1, 4, 13, 1, 1, 4, 13, 3, 3, 5, 5, 3, 3, 15, 15, 2, 2, 7, 31, 2, 2, 29, 14, 36, 36, 24, 24, 36, 36, 24, 24, 16, 16, 6, 28, 16, 16, 6, 28, 17, 17, 19, 19, 17, 17, 43, 43, 18, 18, 46, 9, 18, 18, 21, 22, 36, 36, 24, 24, 36, 36, 24, 24, 37, 37, 30, 25, 37, 37, 30, 25, 17, 17, 19, 19, 17, 17, 43, 43, 40, 40, 8, 23, 40, 40, 34, 45, 0, 0, 12, 12, 0, 0, 12, 12, 1, 1, 4, 13, 1, 1, 4, 13, 3, 3, 5, 5, 3, 3, 15, 15, 2, 2, 7, 31, 2, 2, 29, 14, 0, 0, 12, 12, 0, 0, 12, 12, 1, 1, 4, 13, 1, 1, 4, 13, 3, 3, 5, 5, 3, 3, 15, 15, 2, 2, 7, 31, 2, 2, 29, 14, 36, 36, 24, 24, 36, 36, 24, 24, 16, 16, 6, 28, 16, 16, 6, 28, 39, 39, 41, 41, 39, 39, 27, 27, 42, 42, 20, 35, 42, 42, 10, 44, 36, 36, 24, 24, 36, 36, 24, 24, 37, 37, 30, 25, 37, 37, 30, 25, 39, 39, 41, 41, 39, 39, 27, 27, 38, 38, 11, 33, 38, 38, 32, 26};

    // preserving logic as IIcon was removed
    /*public static IIcon getConnectedBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side, IIcon[] icons, Block callingBlock) {
        if (!ConfigHandler.useConnectedTextures) {
            return icons[0];
        }

        boolean[] occupied = new boolean[8];

        for (int i = 0; i < occupied.length; i++) {
            occupied[i] = false;
        }

        switch (side) {
            case 0:
            case 1:
                occupied[0] = Block.getIdFromBlock(blockAccess.getBlock(x - 1, y, z - 1)) == Block.getIdFromBlock(callingBlock);
                occupied[1] = Block.getIdFromBlock(blockAccess.getBlock(x, y, z - 1)) == Block.getIdFromBlock(callingBlock);
                occupied[2] = Block.getIdFromBlock(blockAccess.getBlock(x + 1, y, z - 1)) == Block.getIdFromBlock(callingBlock);
                occupied[3] = Block.getIdFromBlock(blockAccess.getBlock(x - 1, y, z)) == Block.getIdFromBlock(callingBlock);
                occupied[4] = Block.getIdFromBlock(blockAccess.getBlock(x + 1, y, z)) == Block.getIdFromBlock(callingBlock);
                occupied[5] = Block.getIdFromBlock(blockAccess.getBlock(x - 1, y, z + 1)) == Block.getIdFromBlock(callingBlock);
                occupied[6] = Block.getIdFromBlock(blockAccess.getBlock(x, y, z + 1)) == Block.getIdFromBlock(callingBlock);
                occupied[7] = Block.getIdFromBlock(blockAccess.getBlock(x + 1, y, z + 1)) == Block.getIdFromBlock(callingBlock);
                break;

            case 2:
            case 3:
                occupied[0] = Block.getIdFromBlock(blockAccess.getBlock(x + (side == 2 ? 1 : -1), y + 1, z)) == Block.getIdFromBlock(callingBlock);
                occupied[1] = Block.getIdFromBlock(blockAccess.getBlock(x, y + 1, z)) == Block.getIdFromBlock(callingBlock);
                occupied[2] = Block.getIdFromBlock(blockAccess.getBlock(x + (side == 3 ? 1 : -1), y + 1, z)) == Block.getIdFromBlock(callingBlock);
                occupied[3] = Block.getIdFromBlock(blockAccess.getBlock(x + (side == 2 ? 1 : -1), y, z)) == Block.getIdFromBlock(callingBlock);
                occupied[4] = Block.getIdFromBlock(blockAccess.getBlock(x + (side == 3 ? 1 : -1), y, z)) == Block.getIdFromBlock(callingBlock);
                occupied[5] = Block.getIdFromBlock(blockAccess.getBlock(x + (side == 2 ? 1 : -1), y - 1, z)) == Block.getIdFromBlock(callingBlock);
                occupied[6] = Block.getIdFromBlock(blockAccess.getBlock(x, y - 1, z)) == Block.getIdFromBlock(callingBlock);
                occupied[7] = Block.getIdFromBlock(blockAccess.getBlock(x + (side == 3 ? 1 : -1), y - 1, z)) == Block.getIdFromBlock(callingBlock);
                break;

            case 4:
            case 5:
                occupied[0] = Block.getIdFromBlock(blockAccess.getBlock(x, y + 1, z + (side == 5 ? 1 : -1))) == Block.getIdFromBlock(callingBlock);
                occupied[1] = Block.getIdFromBlock(blockAccess.getBlock(x, y + 1, z)) == Block.getIdFromBlock(callingBlock);
                occupied[2] = Block.getIdFromBlock(blockAccess.getBlock(x, y + 1, z + (side == 4 ? 1 : -1))) == Block.getIdFromBlock(callingBlock);
                occupied[3] = Block.getIdFromBlock(blockAccess.getBlock(x, y, z + (side == 5 ? 1 : -1))) == Block.getIdFromBlock(callingBlock);
                occupied[4] = Block.getIdFromBlock(blockAccess.getBlock(x, y, z + (side == 4 ? 1 : -1))) == Block.getIdFromBlock(callingBlock);
                occupied[5] = Block.getIdFromBlock(blockAccess.getBlock(x, y - 1, z + (side == 5 ? 1 : -1))) == Block.getIdFromBlock(callingBlock);
                occupied[6] = Block.getIdFromBlock(blockAccess.getBlock(x, y - 1, z)) == Block.getIdFromBlock(callingBlock);
                occupied[7] = Block.getIdFromBlock(blockAccess.getBlock(x, y - 1, z + (side == 4 ? 1 : -1))) == Block.getIdFromBlock(callingBlock);
                break;
        }

        int textureID = 0;
        String textureIDString = "";

        for (boolean b : occupied) {
            textureIDString += (b) ? ("1") : ("0");
        }

        textureID = Integer.parseInt(textureIDString, 2);

        if (textureID > 0 && textureID < textureIDs.length) {

            int iconID = textureIDs[textureID];

            if (iconID > 0 && iconID < icons.length) {
                return icons[iconID];
            } else {
                return icons[0];
            }

        } else {
            return icons[0];
        }
    }
    */
}
