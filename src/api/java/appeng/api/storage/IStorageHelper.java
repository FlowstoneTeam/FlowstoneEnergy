package appeng.api.storage;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import appeng.api.networking.energy.IEnergySource;
import appeng.api.networking.security.BaseActionSource;
import appeng.api.storage.data.IAEFluidStack;
import appeng.api.storage.data.IAEItemStack;
import appeng.api.storage.data.IItemList;

public interface IStorageHelper
{

	/**
	 * @param is
	 *            An ItemStack
	 * 
	 * @return a new instance of {@link IAEItemStack} from a MC {@link ItemStack}
	 */
	IAEItemStack createItemStack(ItemStack is);

	/**
	 * @param is
	 *            A FluidStack
	 * 
	 * @return a new instance of {@link IAEFluidStack} from a Forge {@link FluidStack}
	 */
	IAEFluidStack createFluidStack(FluidStack is);

	/**
	 * @return a new instance of {@link IItemList}
	 */
	IItemList createItemList();

	/**
	 * use energy from energy, to remove request items from cell, at the request of src.
	 * 
	 * @param energy
	 * @param cell
	 * @param request
	 * @param src
	 * @return items that successfully extracted.
	 */
	IAEItemStack poweredExtraction(IEnergySource energy, IMEInventory<IAEItemStack> cell, IAEItemStack request, BaseActionSource src);

	/**
	 * use energy from energy, to inject input items into cell, at the request of src
	 * 
	 * @param energy
	 * @param cell
	 * @param input
	 * @param src
	 * @return items that failed to insert.
	 */
	IAEItemStack poweredInsert(IEnergySource energy, IMEInventory<IAEItemStack> cell, IAEItemStack input, BaseActionSource src);

}
