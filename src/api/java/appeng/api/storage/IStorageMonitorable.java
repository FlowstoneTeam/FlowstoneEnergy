package appeng.api.storage;

import appeng.api.storage.data.IAEFluidStack;
import appeng.api.storage.data.IAEItemStack;

public interface IStorageMonitorable
{

	/**
	 * Access the item inventory for the monitorable storage.
	 */
	IMEMonitor<IAEItemStack> getItemInventory();

	/**
	 * Access the fluid inventory for the monitorable storage.
	 */
	IMEMonitor<IAEFluidStack> getFluidInventory();

}
