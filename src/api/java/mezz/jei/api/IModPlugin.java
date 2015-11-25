package mezz.jei.api;

import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeHandler;

/**
 * The main class for a plugin.
 * This class must not import anything that could be missing at runtime (i.e. code from any mod).
 */
public interface IModPlugin {

	/** Returns true if this plugin's mod is loaded. */
	boolean isModLoaded();

	Iterable<? extends IRecipeCategory> getRecipeCategories();

	Iterable<? extends IRecipeHandler> getRecipeHandlers();

	Iterable<Object> getRecipes();

}
