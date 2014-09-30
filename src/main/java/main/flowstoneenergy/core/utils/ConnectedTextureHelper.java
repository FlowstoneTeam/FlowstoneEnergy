package main.flowstoneenergy.core.utils;

import main.flowstoneenergy.core.libs.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class ConnectedTextureHelper {
	private static int[] textureIDs = new int[256];
	
	/*
	 * THIS IS A TEMPORARY MEASURE UNTIL WE HAVE FANCY CONNECTED TEXTURES, 
	 * AT WHICH POINT IN TIME THIS WILL BE REPLACED WITH CONSTANTS!!!
	 * 
	 * --Candi<3
	 */
	
	static
	{
		int counter = 0;
		
		for( int a = 0; a < 2; a++ )
		{
			for( int b = 0; b < 2; b++ )
			{
				for( int c = 0; c < 2; c++ )
				{
					for( int d = 0; d < 2; d++ )
					{
						for( int e = 0; e < 2; e++ )
						{
							for( int f = 0; f < 2; f++ )
							{
								for( int g = 0; g < 2; g++ )
								{
									for( int h = 0; h < 2; h++ )
									{
										String s = a + "" + b + "" + c + "" + d + "" + e + "" + f + "" + g + "" + h;
										int texture = 0;
										
										boolean down = s.charAt( 1 ) == '0';
										boolean right = s.charAt( 3 ) == '0';
										boolean left = s.charAt( 4 ) == '0';
										boolean up = s.charAt( 6 ) == '0';
										
										if( up && down && left && right )
										{
											textureIDs[counter] = 0;
										}
										
										if( up && !down && left && right )
										{
											textureIDs[counter] = 1;
										}
										
										if( !up && down && left && right )
										{
											textureIDs[counter] = 2;
										}
										
										if( up && down && left && !right )
										{
											textureIDs[counter] = 3;
										}
										
										if( up && down && !left && right )
										{
											textureIDs[counter] = 4;
										}
										
										if( up && down && !left && !right )
										{
											textureIDs[counter] = 5;
										}
										
										if( !up && !down && left && right )
										{
											textureIDs[counter] = 6;
										}
										
										if( !up && down && left && !right )
										{
											textureIDs[counter] = 7;
										}
										
										if( !up && down && !left && right )
										{
											textureIDs[counter] = 8;
										}
										
										if( up && !down && left && !right )
										{
											textureIDs[counter] = 9;
										}
										
										if( up && !down && !left && right )
										{
											textureIDs[counter] = 10;
										}
										
										if( !up && down && !left && !right )
										{
											textureIDs[counter] = 11;
										}
										
										if( up && !down && !left && !right )
										{
											textureIDs[counter] = 12;
										}
										
										if( !up && !down && left && !right )
										{
											textureIDs[counter] = 13;
										}
										
										if( !up && !down && !left && right )
										{
											textureIDs[counter] = 14;
										}
										
										if( !up && !down && !left && !right )
										{
											textureIDs[counter] = 15;
										}
										
										counter++;
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static IIcon getConnectedBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side, IIcon[] icons, Block callingBlock) {
        if (!ConfigHandler.useConnectedTextures) {
            return icons[0];
        }
        
        boolean[] occupied = new boolean[8];
        
        for( int i = 0; i < occupied.length; i++ )
        {
        	occupied[i] = false;
        }
        
        switch( side )
        {
        	case 0:
        	case 1:
        		occupied[0] = Block.getIdFromBlock(blockAccess.getBlock(x - 1, y, z - 1)) == Block.getIdFromBlock( callingBlock );
                occupied[1] = Block.getIdFromBlock(blockAccess.getBlock(x, y, z - 1)) == Block.getIdFromBlock( callingBlock );
                occupied[2] = Block.getIdFromBlock(blockAccess.getBlock(x + 1, y, z - 1)) == Block.getIdFromBlock( callingBlock );
                occupied[3] = Block.getIdFromBlock(blockAccess.getBlock(x - 1, y, z)) == Block.getIdFromBlock( callingBlock );
                occupied[4] = Block.getIdFromBlock(blockAccess.getBlock(x + 1, y, z)) == Block.getIdFromBlock( callingBlock );
                occupied[5] = Block.getIdFromBlock(blockAccess.getBlock(x - 1, y, z + 1)) == Block.getIdFromBlock( callingBlock );
                occupied[6] = Block.getIdFromBlock(blockAccess.getBlock(x, y, z + 1)) == Block.getIdFromBlock( callingBlock );
                occupied[7] = Block.getIdFromBlock(blockAccess.getBlock(x + 1, y, z + 1)) == Block.getIdFromBlock( callingBlock );
        		break;
        		
        	case 2:
        	case 3:
        		occupied[0] = Block.getIdFromBlock(blockAccess.getBlock(x + (side == 2 ? 1 : - 1), y + 1, z)) == Block.getIdFromBlock( callingBlock );
                occupied[1] = Block.getIdFromBlock(blockAccess.getBlock(x, y + 1, z)) == Block.getIdFromBlock( callingBlock );
                occupied[2] = Block.getIdFromBlock(blockAccess.getBlock(x + (side == 3 ? 1 : - 1), y + 1, z)) == Block.getIdFromBlock( callingBlock );
                occupied[3] = Block.getIdFromBlock(blockAccess.getBlock(x + (side == 2 ? 1 : - 1), y, z)) == Block.getIdFromBlock( callingBlock );
                occupied[4] = Block.getIdFromBlock(blockAccess.getBlock(x + (side == 3 ? 1 : - 1), y, z)) == Block.getIdFromBlock( callingBlock );
                occupied[5] = Block.getIdFromBlock(blockAccess.getBlock(x + (side == 2 ? 1 : - 1), y - 1, z)) == Block.getIdFromBlock( callingBlock );
                occupied[6] = Block.getIdFromBlock(blockAccess.getBlock(x, y - 1, z)) == Block.getIdFromBlock( callingBlock );
                occupied[7] = Block.getIdFromBlock(blockAccess.getBlock(x + (side == 3 ? 1 : - 1), y - 1, z)) == Block.getIdFromBlock( callingBlock );
        		break;
        		
        	case 4:
        	case 5:
        		occupied[0] = Block.getIdFromBlock(blockAccess.getBlock(x, y + 1, z + (side == 5 ? 1 : - 1))) == Block.getIdFromBlock( callingBlock );
                occupied[1] = Block.getIdFromBlock(blockAccess.getBlock(x, y + 1, z)) == Block.getIdFromBlock( callingBlock );
                occupied[2] = Block.getIdFromBlock(blockAccess.getBlock(x, y + 1, z + (side == 4 ? 1 : - 1))) == Block.getIdFromBlock( callingBlock );
                occupied[3] = Block.getIdFromBlock(blockAccess.getBlock(x, y, z + (side == 5 ? 1 : - 1))) == Block.getIdFromBlock( callingBlock );
                occupied[4] = Block.getIdFromBlock(blockAccess.getBlock(x, y, z + (side == 4 ? 1 : - 1))) == Block.getIdFromBlock( callingBlock );
                occupied[5] = Block.getIdFromBlock(blockAccess.getBlock(x, y - 1, z + (side == 5 ? 1 : - 1))) == Block.getIdFromBlock( callingBlock );
                occupied[6] = Block.getIdFromBlock(blockAccess.getBlock(x, y - 1, z)) == Block.getIdFromBlock( callingBlock );
                occupied[7] = Block.getIdFromBlock(blockAccess.getBlock(x, y - 1, z + (side == 4 ? 1 : - 1))) == Block.getIdFromBlock( callingBlock );
        		break;
        }
        
        int textureID = 0;
        
        for( int i = 0; i < occupied.length; i++ )
        {
        	if( occupied[i] )
        	{
        		textureID += Math.pow( 2, i );
        	}
        }
        
        if( textureID > 0 && textureID < textureIDs.length )
        {
        	System.out.println( x + "," + y + "," + z + " @ Side " + side + " = " + textureID );
        	
        	return icons[textureIDs[textureID]];
        }
        else
        {
        	return icons[0];
        }
    }	
}
