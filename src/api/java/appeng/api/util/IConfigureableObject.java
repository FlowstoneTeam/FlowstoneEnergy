package appeng.api.util;

/**
 * Implemented by various Tiles or Parts in AE
 */
public interface IConfigureableObject
{

	/**
	 * get the config manager for the object.
	 * 
	 * @return
	 */
	IConfigManager getConfigManager();

}
