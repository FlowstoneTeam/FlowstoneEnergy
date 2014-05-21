package main.flowstoneenergy.items.tools;

import java.util.Random;

import main.flowstoneenergy.ModInfo;

public class ItemToolPneumaticFlowwrench extends ItemToolFlowwrench {
	Random rand = new Random();
	private int maxFE = 10000;
	public int currentFE = 0;

    public ItemToolPneumaticFlowwrench() {
        super();
        this.setUnlocalizedName(ModInfo.MODID + ".pneumatic.flowwrench");
        this.setTextureName(ModInfo.MODID + ":tools/pneumaticFlowwrench");
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
    	list.add(TextHelper.shiftForMoreInfo);
    	if (!KeyboardHelper.isShiftDown()) {
			return;
		}
    	list.remove(1);
		list.add(currentFE + "/" + maxFE + "FE Stored");
	}
}
