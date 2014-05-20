package main.flowstoneenergy;

import main.flowstoneenergy.utils.ItemUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTab extends CreativeTabs{
	public CreativeTab(String lable) 
	{
		super(lable);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() 
	{
		return ItemUtils.pneumaticFlowwrench;
	}
}
