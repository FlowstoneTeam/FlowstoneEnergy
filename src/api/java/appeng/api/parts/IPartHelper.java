package appeng.api.parts;

import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergySource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fluids.IFluidHandler;
import buildcraft.api.power.IPowerEmitter;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.transport.IPipeConnection;

public interface IPartHelper
{

	/**
	 * Register a new layer with the part layer system, this allows you to write an in between between tile entities and
	 * parts.
	 * 
	 * AE By Default includes,
	 * 
	 * 1. {@link ISidedInventory} ( and by extension IInventory. )
	 * 
	 * 2. {@link IFluidHandler} Forge Fluids
	 * 
	 * 3. {@link IPowerEmitter} BC Power output.
	 * 
	 * 4. {@link IPowerReceptor} BC Power input.
	 * 
	 * 5. {@link IEnergySink} IC2 Power input.
	 * 
	 * 6. {@link IEnergySource} IC2 Power output.
	 * 
	 * 7. {@link IPipeConnection} BC Pipe Connections
	 * 
	 * As long as a valid layer is registered for a interface you can simply implement that interface on a part get
	 * implement it.
	 * 
	 * @return true on success, false on failure, usually a error will be logged as well.
	 */
	boolean registerNewLayer(String string, Class<?> layerInterface);

	/**
	 * Register IBusItem with renderer
	 */
	void setItemBusRenderer(IPartItem i);

	/**
	 * use in use item, to try and place a IBusItem
	 * 
	 * @param is
	 *            ItemStack of an item which implements {@link IPartItem}
	 * @param x
	 * @param y
	 * @param z
	 * @param side
	 * @param player
	 * @param world
	 * @return
	 */
	boolean placeBus(ItemStack is, int x, int y, int z, int side, EntityPlayer player, World world);

}
