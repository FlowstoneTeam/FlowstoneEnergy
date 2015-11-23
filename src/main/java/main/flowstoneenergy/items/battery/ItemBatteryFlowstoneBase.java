package main.flowstoneenergy.items.battery;

import java.util.List;



//import cofh.api.energy.IEnergyContainerItem;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.core.utils.KeyboardHelper;
import main.flowstoneenergy.core.utils.TextHelper;
import main.flowstoneenergy.entities.EntityRobot;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

//TODO: Enable after update
public class ItemBatteryFlowstoneBase extends Item /*implements IEnergyContainerItem */{

    private int maxPower = 0;
    private int currentPower = 0;
    private int powerRate = 50;

    public ItemBatteryFlowstoneBase() {
        super();
        this.setCreativeTab(FlowstoneEnergy.tab);
        this.setMaxStackSize(1);
    }

    /**
     * Sets the battery's max power. for use in constructor only.
     * 
     * @param maxPower
     *            max power amount.
     */
    protected void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    /**
     * Gets the battery's max power.
     * 
     * @param stack
     *            ItemStack to get the max power from
     * @return max power amount.
     */
    public int getMaxPower(ItemStack stack) {
        return this.maxPower;
    }

    /**
     * Sets the battery's current power charge. for use in constructor only.
     * 
     * @param currentPower
     *            current power charge amount.
     */
    protected void setCurrentPower(int currentPower) {
        this.currentPower = currentPower;
    }

    /**
     * Sets the battery's current power charge.
     * 
     * @param stack
     *            Battery ItemStack.
     * @param currentPower
     *            current power charge amount.
     */
    public void setCurrentPower(ItemStack stack, int currentPower) {

        if (stack == null || stack.getItem() == null)
            return;

        if (!(stack.getItem() instanceof ItemBatteryFlowstoneBase))
            return;

        if (currentPower < 0)
            currentPower = 0;

        if (currentPower > maxPower)
            currentPower = maxPower;

        NBTTagCompound compound = stack.getTagCompound();
        if (compound == null)
            compound = new NBTTagCompound();

        NBTTagCompound powerCompound = compound.getCompoundTag("flowstonePower");
        if (powerCompound == null)
            powerCompound = new NBTTagCompound();

        powerCompound.setInteger("currentPower", currentPower);

        compound.setTag("flowstonePower", powerCompound);

        stack.setTagCompound(compound);
    }

    /**
     * Gets the battery's current power.
     * 
     * @param stack
     *            the ItemStack to retrieve the current power from.
     * @return current power charge amount.
     */
    public int getCurrentPower(ItemStack stack) {
        NBTTagCompound compound = stack.getTagCompound();
        if (compound == null)
            return 0;

        NBTTagCompound powerCompound = compound.getCompoundTag("flowstonePower");
        if (powerCompound == null)
            return 0;

        return powerCompound.getInteger("currentPower");
    }

    /**
     * ItemStack creation Factory.
     * 
     * @battery Battery Item to create the ItemStack from.
     * @return ItemStack
     */
    public ItemStack createItemStack() {
        ItemStack stack = new ItemStack(this);

        writeNBTTags(stack);

        return stack;
    }

    /**
     * Checks if the battery is charged.
     * 
     * @param stack
     *            Battery ItemStack.
     * @return true if the battery is fully charged </br> false otherwise.
     */
    public boolean isFullyCharged(ItemStack stack) {
        if (!(stack.getItem() instanceof ItemBatteryFlowstoneBase))
            return false;

        readNBTTags(stack);

        if (currentPower >= maxPower) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        EntityRobot robot = new EntityRobot(world);
        robot.setPosition(pos.getX(), pos.getY(), pos.getZ());
        if (!world.isRemote && player.isSneaking()) {
            robot.setCharged();
            world.updateEntity(robot);
            itemStack.setItemDamage(0);
            /**
             * if (isCharged(itemStack.getItemDamage())) { robot.setCharged();
             * itemStack.setItemDamage(0); }
             **/
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void getSubItems(Item item, CreativeTabs creatvieTab, List<ItemStack> list) {
        if (item == this) {
            list.add(this.createItemStack());
        }
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        if (!KeyboardHelper.isShiftDown()) {
            list.add(TextHelper.shiftForMoreInfo);
        } else {
            if (stack.getTagCompound() != null && stack.getTagCompound().getCompoundTag("flowstonePower") != null) {
                list.add(TextHelper.GREEN + this.getCurrentPower(stack) + "/" + this.getMaxPower(stack) + TextHelper.localize("info.fe.tooltip.stored"));

            } else
                list.add(TextHelper.GREEN + this.currentPower + "/" + this.maxPower + TextHelper.localize("info.fe.tooltip.stored"));
            list.add(TextHelper.localize("info.fe.tooltip.use") + " " + TextHelper.localize("info.fe.control.sneak") + " " + TextHelper.localize("info.fe.tooltip.activate"));
        }
    }

    protected void readNBTTags(ItemStack stack) {
        NBTTagCompound compound = stack.getTagCompound();
        if (compound == null)
            compound = new NBTTagCompound();

        NBTTagCompound powerCompound = compound.getCompoundTag("flowstonePower");
        if (powerCompound == null)
            powerCompound = new NBTTagCompound();

        this.maxPower = powerCompound.getInteger("maxPower");
        this.currentPower = powerCompound.getInteger("currentPower");
    }

    protected void writeNBTTags(ItemStack stack) {
        NBTTagCompound compound = stack.getTagCompound();

        if (compound == null)
            compound = new NBTTagCompound();

        NBTTagCompound powerCompound = new NBTTagCompound();

        powerCompound.setInteger("maxPower", this.maxPower);
        powerCompound.setInteger("currentPower", this.currentPower);

        compound.setTag("flowstonePower", powerCompound);

        stack.setTagCompound(compound);
    }

    /* ************** Start IEnergyContainerItem implementation ************** */
    // TODO: Enable after update
    /*
    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {

        if (container == null || container.getItem() == null)
            return 0;

        if (!(container.getItem() instanceof ItemBatteryFlowstoneBase))
            return 0;

        int received = maxReceive;

        if (received > powerRate)
            received = powerRate;

        int currentStackPower = getCurrentPower(container);

        if ((received + currentStackPower) >= maxPower)
            received = maxPower - currentStackPower;

        if (!simulate) {
            setCurrentPower(container, received + currentStackPower);
        }

        return received;
    }

    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {

        if (container == null || container.getItem() == null)
            return 0;

        if (!(container.getItem() instanceof ItemBatteryFlowstoneBase))
            return 0;

        int extract = maxExtract;

        if (extract > powerRate)
            extract = powerRate;

        int currentStackPower = getCurrentPower(container);

        if ((currentStackPower - extract) < 0)
            extract = currentStackPower;

        if (!simulate) {
            setCurrentPower(container, currentStackPower - extract);
        }

        return extract;
    }

    @Override
    public int getEnergyStored(ItemStack container) {
        return getCurrentPower(container);
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        return getMaxPower(container);
    }
     */
    /* ************** End IEnergyContainerItem implementation ************** */
}
