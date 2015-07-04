/**
 * Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team
 * http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.api.robots;

import net.minecraft.tileentity.TileEntity;

import buildcraft.api.core.BlockIndex;

public class ResourceIdRequest extends ResourceId {

	public ResourceIdRequest() {

	}

	public ResourceIdRequest(TileEntity tile, int i) {
		index = new BlockIndex(tile);
		localId = i;
	}

}
