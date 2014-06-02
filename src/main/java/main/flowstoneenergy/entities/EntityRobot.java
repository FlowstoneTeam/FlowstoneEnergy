package main.flowstoneenergy.entities;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGolem;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityRobot extends EntityGolem implements IEntityAdditionalSpawnData {

    private boolean charged;

    public EntityRobot(World world) {
        super(world);
        setHealth(20);
        setSize(1.0F, 0.6F);
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
    public void onUpdate() {
        super.onUpdate();
	}

    @Override
    public boolean canBeCollidedWith() {
        return !isDead;
    }

    @Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
        charged = nbt.getBoolean("Charged");
    }

    @Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
        nbt.setBoolean("Charged", charged);
    }
}
