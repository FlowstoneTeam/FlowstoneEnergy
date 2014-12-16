package main.flowstoneenergy.core.interfaces;

import appeng.api.implementations.items.IAEWrench;
import buildcraft.api.tools.IToolWrench;
import cofh.api.block.IDismantleable;
import cofh.api.item.IToolHammer;
import com.carpentersblocks.api.ICarpentersHammer;
import ic2.api.tile.IWrenchable;
import mods.railcraft.api.core.items.IToolCrowbar;
import pneumaticCraft.api.PneumaticRegistry.IPneumaticCraftInterface;

/**
 * Created by poppypoppop on 16/12/2014.
 */
public interface IOmniWrenchable extends IFlowWrenchable, IToolCrowbar, IPneumaticCraftInterface, IAEWrench, IWrenchable, IDismantleable, IToolHammer, ICarpentersHammer, IToolWrench {
}
