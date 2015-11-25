package main.flowstoneenergy.entities;

import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import main.flowstoneenergy.core.libs.ConfigHandler;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityRobot extends EntityGolem implements IEntityAdditionalSpawnData {

    private boolean charged;
    public int taskNum = 0;
    public EntityRobot instance;

    public EntityRobot(World world) {
        super(world);
        setSize(0.8F, 1.0F);
        if (ConfigHandler.debugMode)
            charged = true;
        ((PathNavigateGround)this.getNavigator()).setAvoidsWater(true);
        this.tasks.addTask(6, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
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
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
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

    @Override
    public float getEyeHeight() {
        return 0.95F;
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