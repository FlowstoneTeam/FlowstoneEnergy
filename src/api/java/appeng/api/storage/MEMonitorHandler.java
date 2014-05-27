package appeng.api.storage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import appeng.api.AEApi;
import appeng.api.config.AccessRestriction;
import appeng.api.config.Actionable;
import appeng.api.networking.security.BaseActionSource;
import appeng.api.storage.data.IAEStack;
import appeng.api.storage.data.IItemList;

/**
 * Common implementation of a simple class that monitors injection/extraction of a inventory to send events to a list of
 * listeners.
 * 
 * @param <StackType>
 */
public class MEMonitorHandler<StackType extends IAEStack> implements IMEMonitor<StackType>
{

	private final IMEInventoryHandler<StackType> internalHandler;
	private final IItemList<StackType> cachedList = AEApi.instance().storage().createItemList();
	private final HashMap<IMEMonitorHandlerReciever<StackType>, Object> listeners = new HashMap<IMEMonitorHandlerReciever<StackType>, Object>();

	protected boolean hasChanged = true;

	protected IMEInventoryHandler<StackType> getHandler()
	{
		return internalHandler;
	}

	protected void postChange(StackType diff, BaseActionSource src)
	{
		hasChanged = true;// need to update the cache.
		Iterator<Entry<IMEMonitorHandlerReciever<StackType>, Object>> i = listeners.entrySet().iterator();
		while (i.hasNext())
		{
			Entry<IMEMonitorHandlerReciever<StackType>, Object> o = i.next();
			IMEMonitorHandlerReciever<StackType> recv = o.getKey();
			if ( recv.isValid( o.getValue() ) )
				recv.postChange( this, diff, src );
			else
				i.remove();
		}
	}

	private StackType monitorDiffrence(IAEStack original, StackType leftOvers, boolean extraction, BaseActionSource src)
	{
		StackType diff = (StackType) original.copy();

		if ( extraction )
			diff.setStackSize( leftOvers == null ? 0 : -leftOvers.getStackSize() );
		else if ( leftOvers != null )
			diff.decStackSize( leftOvers.getStackSize() );

		if ( diff.getStackSize() != 0 )
			postChange( diff, src );

		return leftOvers;
	}

	public MEMonitorHandler(IMEInventoryHandler<StackType> t) {
		internalHandler = t;
	}

	@Override
	public void addListener(IMEMonitorHandlerReciever<StackType> l, Object verificationToken)
	{
		listeners.put( l, verificationToken );
	}

	@Override
	public void removeListener(IMEMonitorHandlerReciever<StackType> l)
	{
		listeners.remove( l );
	}

	@Override
	public StackType injectItems(StackType input, Actionable mode, BaseActionSource src)
	{
		if ( mode == Actionable.SIMULATE )
			return getHandler().injectItems( input, mode, src );
		return monitorDiffrence( (StackType) input.copy(), getHandler().injectItems( input, mode, src ), false, src );
	}

	@Override
	public StackType extractItems(StackType request, Actionable mode, BaseActionSource src)
	{
		if ( mode == Actionable.SIMULATE )
			return getHandler().extractItems( request, mode, src );
		return monitorDiffrence( (StackType) request.copy(), getHandler().extractItems( request, mode, src ), true, src );
	}

	@Override
	public IItemList<StackType> getStorageList()
	{
		if ( hasChanged )
		{
			hasChanged = false;
			cachedList.resetStatus();
			return getAvailableItems( cachedList );
		}

		return cachedList;
	}

	@Override
	public IItemList<StackType> getAvailableItems(IItemList out)
	{
		return getHandler().getAvailableItems( out );
	}

	@Override
	public StorageChannel getChannel()
	{
		return getHandler().getChannel();
	}

	@Override
	public AccessRestriction getAccess()
	{
		return getHandler().getAccess();
	}

	@Override
	public boolean isPrioritized(StackType input)
	{
		return getHandler().isPrioritized( input );
	}

	@Override
	public boolean canAccept(StackType input)
	{
		return getHandler().canAccept( input );
	}

	@Override
	public int getPriority()
	{
		return getHandler().getPriority();
	}

	@Override
	public int getSlot()
	{
		return getHandler().getSlot();
	}

}
