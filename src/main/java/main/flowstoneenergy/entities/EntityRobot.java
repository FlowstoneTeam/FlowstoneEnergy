package main.flowstoneenergy.entities;

import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import main.flowstoneenergy.core.libs.ConfigHandler;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityRobot extends EntityGolem implements IEntityAdditionalSpawnData {

    private boolean charged;
    public int taskNum = 0;
    public EntityRobot instance;

    public EntityRobot(World world) {
        super(world);
        if (ConfigHandler.debugMode)
            charged = true;
        setHealth(20);
        setAIMoveSpeed(0.5F);
        setSize(0.9F, 0.6F);
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

    @Override
    public String getLivingSound() {
        return ModInfo.MODID + ":robotTalk";
    }

    @Override
    public String getHurtSound() {
        return ModInfo.MODID + ":robotHurt";
    }

    @Override
    protected String getDeathSound() {
        return ModInfo.MODID + ":robotDeath";
    }

    public boolean isCharged() {
        return charged;
    }

    public void setCharged() {
        if (!charged) {
            charged = true;
            // worldObj.updateEntity(this);
        } else
            charged = false;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
    }

    @Override
    protected boolean isMovementBlocked() {
        if (charged)
            return false;
        else
            return true;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entity) {
        if (entity != riddenByEntity)
            return entity.getEntityBoundingBox();
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

    @Override
    public void writeSpawnData(ByteBuf data) {
        data.writeBoolean(charged);
    }

    @Override
    public void readSpawnData(ByteBuf data) {
        charged = data.readBoolean();
    }

    public void defend(World world, int radius, int damage, double x, double y, double z) {
    }

    public void transferItems(World world, double x, double y, double z) {
    }

    public void build(World world, double x, double y, double z) {
    }

    public void destroyBlocks(World world, double x, double y, double z) {
    }

}