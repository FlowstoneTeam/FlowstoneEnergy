package appeng.api.networking.security;

import net.minecraft.entity.player.EntityPlayer;
import appeng.api.networking.IGridHost;

public class PlayerSource extends BaseActionSource
{

	public final EntityPlayer player;
	public final IGridHost via;

	@Override
	boolean isPlayer()
	{
		return true;
	}

	public PlayerSource(EntityPlayer p, IGridHost v) {
		player = p;
		via = v;
	}

}
