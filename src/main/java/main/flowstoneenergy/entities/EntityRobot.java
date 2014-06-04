package main.flowstoneenergy.entities;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import main.flowstoneenergy.ConfigHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityRobot extends EntityIronGolem implements IEntityAdditionalSpawnData {

    private static boolean charged;
	public static int taskNum = 0;
    public static EntityRobot instance;

    public EntityRobot(World world) {
        super(world);
        setHealth(20);
        setSize(1.0F, 0.6F);
    }
	
	public void setTask(int taskNum) {
		switch (taskNum) {
		case 0:
			return;
		case 1:
			transferItems(this.worldObj, this.posX, this.posY, this.posZ);
		case 2:
			build(this.worldObj, this.posX, this.posY, this.posZ);
		case 3:
			destroyBlocks(this.worldObj, this.posX, this.posY, this.posZ);
		case 4:
			defend(this.worldObj, 7, 4, this.posX, this.posY, this.posZ);
		}
	}

    public static boolean isCharged() {
        return charged;
    }

    public static void setCharged() {
        if (!charged) {
            charged = true;
            //worldObj.updateEntity(this);
        } else charged = false;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
    }

    @Override
    protected boolean isMovementCeased() {
        if (!isCharged())
            return true;
        else
            return false;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
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
    public void onUpdate() {
		if (charged || ConfigHandler.debugMode) {
			super.onUpdate();
            setTask(taskNum);
		}
	}

    @Override
    public boolean canBeCollidedWith() { return !isDead; }

    @Override
	public void readEntityFromNBT(NBTTagCompound nbt) { charged = nbt.getBoolean("Charged"); }

    @Override
	public void writeEntityToNBT(NBTTagCompound nbt) { nbt.setBoolean("Charged", charged);}

    @Override
    public void writeSpawnData(ByteBuf data) { data.writeBoolean(charged); }

    @Override
    public void readSpawnData(ByteBuf data) { charged = data.readBoolean(); }

    public void defend(World world, int radius, int damage, double x, double y, double z) {}

    public void transferItems(World world, double x, double y, double z) {}

    public void build(World world, double x, double y, double z) {}

    public void destroyBlocks(World world, double x, double y, double z) {}

}