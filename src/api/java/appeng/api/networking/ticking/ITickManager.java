package appeng.api.networking.ticking;

import appeng.api.networking.IGridCache;
import appeng.api.networking.IGridNode;

/**
 * 
 * The network tick manager.
 * 
 */
public interface ITickManager extends IGridCache
{

	/**
	 * immediately sets the node to tick, only valid if your node is marked as
	 * "Alertable" in its TickingRequest
	 * 
	 * Sleeping Devices Still Alertable, and alerting them does not wake them.
	 * 
	 * @param node
	 */
	boolean alertDevice(IGridNode node);

	/**
	 * 
	 * disables ticking for your device.
	 * 
	 * @param node
	 * 
	 */
	boolean sleepDevice(IGridNode node);

	/**
	 * 
	 * enables ticking for your device, undoes a sleepDevice call.
	 * 
	 * @param node
	 * @return
	 * 
	 */
	boolean wakeDevice(IGridNode node);

}
