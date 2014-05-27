package appeng.api.parts.layers;

import ic2.api.energy.tile.IEnergySink;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import appeng.api.parts.IPart;
import appeng.api.parts.LayerBase;

public class LayerIEnergySink extends LayerBase implements IEnergySink
{

	@Override
	public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction)
	{
		IPart part = getPart( direction );
		if ( part instanceof IEnergySink )
			return ((IEnergySink) part).acceptsEnergyFrom( emitter, direction );
		return false;
	}

	@Override
	public double demandedEnergyUnits()
	{
		// this is a flawed implementation, that requires a change to the IC2 API.

		double maxRequired = 0;

		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS)
		{
			IPart part = getPart( dir );
			if ( part instanceof IEnergySink )
			{
				// use lower number cause ic2 deletes power it sends that isn't recieved.
				maxRequired = Math.min( maxRequired, ((IEnergySink) part).demandedEnergyUnits() );
			}
		}

		return maxRequired;
	}

	@Override
	public double injectEnergyUnits(ForgeDirection directionFrom, double amount)
	{
		IPart part = getPart( directionFrom );
		if ( part instanceof IEnergySink )
			return ((IEnergySink) part).injectEnergyUnits( directionFrom, amount );
		return amount;
	}

	@Override
	public int getMaxSafeInput()
	{
		return Integer.MAX_VALUE; // no real options here...
	}

}
