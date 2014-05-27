package appeng.api.implementations.guiobjects;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import appeng.api.networking.IGridHost;

/**
 * Obtained via {@link IGuiItem} getGuiObject
 */
public interface INetworkTool extends IInventory
{

	IGridHost getGridHost(); // null for most purposes.

	public ItemStack getItemStack();

}
