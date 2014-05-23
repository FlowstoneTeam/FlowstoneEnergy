package main.flowstoneenergy.entities;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityRobot extends Entity implements IEntityAdditionalSpawnData {
	
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
			}else if (worldObj.isAirBlock((int)posX, (int)posY - 1, (int)posZ)){
				motionY = -0.1;
			}else{
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
	public boolean interactFirst(EntityPlayer player) {
		if (!worldObj.isRemote && riddenByEntity == null) {
			player.mountEntity(this);
		}
		
		return true;
	}

	@Override
	protected void entityInit() {
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt) {
		charged = nbt.getBoolean("Charged");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt) {
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
	
}
