/**
 * Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team
 * http://www.mod-buildcraft.com
 *
 * The BuildCraft API is distributed under the terms of the MIT License.
 * Please check the contents of the license, which should be located
 * as "LICENSE.API" in the BuildCraft source code distribution.
 */
package buildcraft.api.statements;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;

public class StatementParameterItemStack implements IStatementParameter {
	
	protected ItemStack stack;

	@Override
	public IIcon getIcon() {
		return null;
	}

	@Override
	public ItemStack getItemStack() {
		return stack;
	}

	@Override
	public void onClick(IStatementContainer source, IStatement stmt, ItemStack stack, StatementMouseClick mouse) {
		if (stack != null) {
			this.stack = stack.copy();
			this.stack.stackSize = 1;
		} else {
			this.stack = null;
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		if (stack != null) {
			NBTTagCompound tagCompound = new NBTTagCompound();
			stack.writeToNBT(tagCompound);
			compound.setTag("stack", tagCompound);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		stack = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("stack"));
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof StatementParameterItemStack) {
			StatementParameterItemStack param = (StatementParameterItemStack) object;

			return ItemStack.areItemStacksEqual(stack, param.stack)
					&& ItemStack.areItemStackTagsEqual(stack, param.stack);
		} else {
			return false;
		}
	}

	@Override
	public String getDescription() {
		if (stack != null) {
			return stack.getDisplayName();
		} else {
			return "";
		}
	}

	@Override
	public String getUniqueTag() {
		return "buildcraft:stack";
	}

	@Override
	public void registerIcons(IIconRegister iconRegister) {
		
	}

	@Override
	public IStatementParameter rotateLeft() {
		return this;
	}
}
