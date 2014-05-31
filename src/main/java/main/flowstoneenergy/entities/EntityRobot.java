package main.flowstoneenergy.entities;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityRobot extends EntityAnimal implements IEntityAdditionalSpawnData {

    private boolean charged;

    public EntityRobot(World world) {
        super(world);
        setSize(1.5F, 0.6F);
    }

    public boolean isCharged() {
        return charged;
    }

    public void setCharged() {
        charged = true;
    }
    
    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7D);
    }

    @Override
    public AxisAlignedBB getBoundingBox() {
        return boundingBox;
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entity) {
        if (entity != riddenByEntity)
            return entity.boundingBox;
        else
            return null;
    }

    @Override
    public double getMountedYOffset() {
        return -0.015;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (!worldObj.isRemote) {
            if (riddenByEntity != null) {
                motionY = 0.2;
            } else if (worldObj.isAirBlock((int) posX, (int) posY - 1, (int) posZ)) {
                motionY = -0.1;
            } else {
                motionY = 0;
            }
        }
        setPosition(posX + motionX, posY + motionY, posZ + motionZ);
    }

    @Override
    public boolean canBeCollidedWith() {
        return !isDead;
    }

    @Override
    protected void entityInit() {

    }

    @Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
        charged = nbt.getBoolean("Charged");
    }

    @Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
        nbt.setBoolean("Charged", charged);
    }

    @Override
    public void writeSpawnData(ByteBuf data) {
        data.writeBoolean(charged);
    }

    @Override
    public void readSpawnData(ByteBuf data) {
        charged = data.readBoolean();
    }

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}

}
