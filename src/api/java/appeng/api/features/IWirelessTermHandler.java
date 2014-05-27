package appeng.api.features;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.network.Player;

/**
 * A handler for a wireless terminal.
 */
public interface IWirelessTermHandler
{

	/**
	 * @param is
	 * @return true, if usePower, hasPower, etc... can be called for the provided item
	 */
	boolean canHandle(ItemStack is);

	/**
	 * use an amount of power, in AE units
	 * 
	 * @param amount
	 *            is in AE units ( 5 per MJ ), if you return false, the item
	 *            should be dead and return false for hasPower
	 * @param is
	 * @return
	 */
	boolean usePower(Player player, float amount, ItemStack is);

	/**
	 * gets the power status of the item.
	 * 
	 * @param is
	 * @return returns true if there is any power left.
	 */
	boolean hasPower(Player player, ItemStack is);

	/**
	 * Used to get the current key from the item.
	 * 
	 * @param player
	 * @param item
	 * @return
	 */
	String getEncryptionKey(ItemStack item);

	/**
	 * Encode the wireless frequency via the Controller.
	 * 
	 * @param item
	 *            the wireless terminal.
	 * @param encKey
	 *              the wireless encryption key.
	 * @param name
	 *            null for now.
	 */
	void setEncryptionKey(ItemStack item, String encKey, String name);
}