package main.flowstoneenergy.core.utils;

import main.flowstoneenergy.core.libs.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class ConnectedTextureHelper {

	private static int getIconNumber(int side, boolean shouldConnectNorth, boolean shouldConnectSouth, boolean shouldConnectEast, boolean shouldConnectWest, boolean shouldConnectTop, boolean shouldConnectBottom) {
		boolean connectsUp = shouldConnectNorth;
    	boolean connectsDown = shouldConnectSouth;
    	boolean connectsRight = shouldConnectEast;
    	boolean connectsLeft = shouldConnectWest;
    	
    	switch(side) {
    		//bottom
    		case 0:
    			connectsUp = shouldConnectEast;
    			connectsDown = shouldConnectWest;
    			connectsLeft = shouldConnectNorth;
    			connectsRight = shouldConnectSouth;
    			break;
    		//top
    		case 1:
    			connectsUp = shouldConnectEast;
    			connectsDown = shouldConnectWest;
    			connectsLeft = shouldConnectNorth;
    			connectsRight = shouldConnectSouth;
    			break;
    			
    		//east
    		case 2:
    			connectsUp = shouldConnectTop;
    			connectsDown = shouldConnectBottom;
    			connectsRight = shouldConnectNorth;
    			connectsLeft = shouldConnectSouth;
    			break;
    		
    		//west
    		case 3:
    			connectsUp = shouldConnectTop;
    			connectsDown = shouldConnectBottom;
    			connectsRight = shouldConnectSouth;
    			connectsLeft = shouldConnectNorth;
    			break;
    			
    		//north
    		case 4:
    			connectsUp = shouldConnectTop;
    			connectsDown = shouldConnectBottom;
    			connectsLeft = shouldConnectEast;
    			connectsRight = shouldConnectWest;
    			break;
    			
    		//south
    		case 5:
    			connectsUp = shouldConnectTop;
    			connectsDown = shouldConnectBottom;
    			connectsLeft = shouldConnectWest;
    			connectsRight = shouldConnectEast;
    		break;
    	}
    	
    	if(connectsUp && connectsDown && connectsLeft && connectsRight) {
    		return 15;
		}
		if(!connectsUp && connectsDown && connectsLeft && connectsRight) {
			return 12;
		}
		if(connectsUp && !connectsDown && connectsLeft && connectsRight) {
			return 11;
		}
		if(connectsUp && connectsDown && !connectsLeft && connectsRight) {
			return 13;
		}
		if(connectsUp && connectsDown && connectsLeft && !connectsRight) {
			return 14;
		}
		if(!connectsUp && !connectsDown && connectsLeft && connectsRight) {
			return 5;
		}
		if(!connectsUp && connectsDown && !connectsLeft && connectsRight) {
			return 9;
		}
		if(!connectsUp && connectsDown && connectsLeft && !connectsRight) {
			return 10;
		}
		if(connectsUp && !connectsDown && !connectsLeft && connectsRight) {
			return 7;
		}
		if(connectsUp && !connectsDown && connectsLeft && !connectsRight) {
			return 8;
		}
		if(connectsUp && connectsDown && !connectsLeft && !connectsRight) {
			return 6;
		}
		if(!connectsUp && !connectsDown && !connectsLeft && connectsRight) {
			return 3;
		}
		if(!connectsUp && connectsDown && !connectsLeft && !connectsRight) {
			return 1;
		}
		if(!connectsDown && !connectsDown && connectsLeft && !connectsRight) {
			return 4;
		}
		if(connectsUp && !connectsDown && !connectsLeft && !connectsRight) {
			return 2;
		}
		if(!connectsUp && !connectsDown && !connectsLeft && !connectsRight) {
			return 0;
		}
		
		return -1;
	}
	
	public static IIcon getConnectedBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side, IIcon[] icons, Block callingBlock) {
        if (!ConfigHandler.useConnectedTextures) {
            return icons[0];
        }
        
        boolean shouldConnectSouth = false, shouldConnectNorth = false, shouldConnectEast = false, shouldConnectWest = false, shouldConnectTop = false, shouldConnectBottom = false;
        
            if (shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlock(x - 1, y, z), blockAccess.getBlockMetadata(x - 1, y, z), callingBlock)) {
                shouldConnectNorth = true;
            }

            if (shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlock(x + 1, y, z), blockAccess.getBlockMetadata(x + 1, y, z), callingBlock)) {
                shouldConnectSouth = true;
            }

            if (shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlock(x, y, z - 1), blockAccess.getBlockMetadata(x, y, z - 1), callingBlock)) {
                shouldConnectEast = true;
            }

            if (shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlock(x, y, z + 1), blockAccess.getBlockMetadata(x, y, z + 1), callingBlock)) {
                shouldConnectWest = true;
            }
            
            if (shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlock(x, y + 1, z), blockAccess.getBlockMetadata(x, y + 1, z), callingBlock)) {
                shouldConnectTop = true;
            }
            
            if (shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlock(x, y - 1, z), blockAccess.getBlockMetadata(x, y - 1, z), callingBlock)) {
                shouldConnectBottom = true;
            }

            int icon = ConnectedTextureHelper.getIconNumber(side, shouldConnectNorth, shouldConnectSouth, shouldConnectEast, shouldConnectWest, shouldConnectTop, shouldConnectBottom);
    		
            if(icon > -1) {
            	return icons[icon];
            } else {
            	return icons[0];
            }
    }
    
    private static boolean shouldConnectToBlock(IBlockAccess blockAccess, int x, int y, int z, Block block, int metadata, Block callingBlock) {
        return block == callingBlock;
    }
	
}
