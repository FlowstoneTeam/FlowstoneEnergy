package appeng.api.networking.security;

import appeng.api.networking.IGridHost;

public class MachineSource extends BaseActionSource
{

	public final IGridHost via;

	@Override
	boolean isMachine()
	{
		return true;
	}

	public MachineSource(IGridHost v) {
		via = v;
	}

}
