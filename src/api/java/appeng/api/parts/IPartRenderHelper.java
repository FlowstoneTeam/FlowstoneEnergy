package appeng.api.parts;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

public interface IPartRenderHelper
{

	/**
	 * sets the Render Helpers Block Bounds. 0.0 - 16.0 block coords.
	 * 
	 * No complaints about the size, I like using pixels :P
	 * 
	 * @param minX
	 * @param minY
	 * @param minZ
	 * @param maxX
	 * @param maxY
	 * @param maxZ
	 */
	void setBounds(float minX, float minY, float minZ, float maxX, float maxY, float maxZ);

	/**
	 * static renderer
	 * 
	 * render a single face.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param ico
	 * @param face
	 * @param renderer
	 */
	void renderFace(int x, int y, int z, Icon ico, ForgeDirection face, RenderBlocks renderer);

	/**
	 * static renderer
	 * 
	 * render a box with a cut out box in the center.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param ico
	 * @param face
	 * @param edgeThickness
	 * @param renderer
	 */
	void renderFaceCutout(int x, int y, int z, Icon ico, ForgeDirection face, float edgeThickness, RenderBlocks renderer);

	/**
	 * static renderer
	 * 
	 * render a block of specified bounds.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param renderer
	 */
	void renderBlock(int x, int y, int z, RenderBlocks renderer);

	/**
	 * render a single face in inventory renderer.
	 * 
	 * @param icon
	 * @param south
	 * @param renderer
	 */
	void renderInventoryFace(Icon icon, ForgeDirection south, RenderBlocks renderer);

	/**
	 * render a box in inventory renderer.
	 * 
	 * @param renderer
	 */
	void renderInventoryBox(RenderBlocks renderer);

	/**
	 * inventory, and static renderer.
	 * 
	 * set unique icons for each side of the block.
	 * 
	 * @param Down
	 * @param Up
	 * @param North
	 * @param South
	 * @param West
	 * @param East
	 */
	void setTexture(Icon Down, Icon Up, Icon North, Icon South, Icon West, Icon East);

	/**
	 * inventory, and static renderer.
	 * 
	 * set all sides to a single icon.
	 * 
	 * @param ico
	 */
	void setTexture(Icon ico);

	/**
	 * configure the color multiplier for the inventory renderer.
	 * 
	 * @param whiteVariant
	 */
	void setInvColor(int whiteVariant);

	/**
	 * @return the block used for rendering, might need it for some reason...
	 */
	Block getBlock();

	/**
	 * @return the east vector in world directions, rather then renderer
	 */
	ForgeDirection getWorldX();

	/**
	 * @return the up vector in world directions, rather then renderer.
	 */
	ForgeDirection getWorldY();

	/**
	 * @return the forward vector in world directions, rather then renderer.
	 */
	ForgeDirection getWorldZ();

	/**
	 * Pre-Calculates default lighting for the part, call this before using the render helper to render anything else to
	 * get simplified, but faster lighting for more then one block.
	 * 
	 * Only worth it if you render more then 1 block.
	 */
	void useSimpliedRendering(int x, int y, int z, IPart p);

	/**
	 * disables, useSimpliedRendering.
	 */
	void normalRendering();

}