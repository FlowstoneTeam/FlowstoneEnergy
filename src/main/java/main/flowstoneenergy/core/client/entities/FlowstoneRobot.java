package main.flowstoneenergy.core.client.entities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class FlowstoneRobot extends ModelBase {
    // fields
    ModelRenderer head;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer chest;
    ModelRenderer neck;
    ModelRenderer hip;
    ModelRenderer pelvis;
    ModelRenderer energycore;
    ModelRenderer abdomenleft;
    ModelRenderer abdomenright;

    public FlowstoneRobot() {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-2F, -3F, -2F, 4, 3, 4);
        head.setRotationPoint(0F, 11F, 0F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 26, 0);
        rightarm.addBox(-2F, -1F, -1.5F, 2, 6, 3);
        rightarm.setRotationPoint(-3F, 12.6F, 0F);
        rightarm.setTextureSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 16, 0);
        leftarm.addBox(0F, -1F, -1.5F, 2, 6, 3);
        leftarm.setRotationPoint(3F, 12.6F, 0F);
        leftarm.setTextureSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 8, 7);
        rightleg.addBox(-2F, 0F, -1F, 2, 6, 2);
        rightleg.setRotationPoint(-2F, 18F, 0F);
        rightleg.setTextureSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 7);
        leftleg.addBox(0F, 0F, -1F, 2, 6, 2);
        leftleg.setRotationPoint(2F, 18F, 0F);
        leftleg.setTextureSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        chest = new ModelRenderer(this, 16, 9);
        chest.addBox(-3F, 0F, -2F, 6, 3, 4);
        chest.setRotationPoint(0F, 12F, 0F);
        chest.setTextureSize(64, 32);
        chest.mirror = true;
        setRotation(chest, 0F, 0F, 0F);
        neck = new ModelRenderer(this, 0, 15);
        neck.addBox(-2.5F, 0F, -1.5F, 5, 1, 3);
        neck.setRotationPoint(0F, 11F, 0F);
        neck.setTextureSize(64, 32);
        neck.mirror = true;
        setRotation(neck, 0F, 0F, 0F);
        hip = new ModelRenderer(this, 16, 16);
        hip.addBox(-3F, 0F, -2F, 6, 2, 4);
        hip.setRotationPoint(0F, 16F, 0F);
        hip.setTextureSize(64, 32);
        hip.mirror = true;
        setRotation(hip, 0F, 0F, 0F);
        pelvis = new ModelRenderer(this, 0, 19);
        pelvis.addBox(-2F, 0F, -1.5F, 4, 1, 3);
        pelvis.setRotationPoint(0F, 18F, 0F);
        pelvis.setTextureSize(64, 32);
        pelvis.mirror = true;
        setRotation(pelvis, 0F, 0F, 0F);
        energycore = new ModelRenderer(this, 0, 27);
        energycore.addBox(-1F, 0F, -1F, 2, 1, 2);
        energycore.setRotationPoint(0F, 15F, 0F);
        energycore.setTextureSize(64, 32);
        energycore.mirror = true;
        setRotation(energycore, 0F, 0F, 0F);
        abdomenleft = new ModelRenderer(this, 0, 23);
        abdomenleft.addBox(1.5F, 0F, -1.5F, 1, 1, 3);
        abdomenleft.setRotationPoint(0F, 15F, 0F);
        abdomenleft.setTextureSize(64, 32);
        abdomenleft.mirror = true;
        setRotation(abdomenleft, 0F, 0F, 0F);
        abdomenright = new ModelRenderer(this, 8, 23);
        abdomenright.addBox(-2.5F, 0F, -1.5F, 1, 1, 3);
        abdomenright.setRotationPoint(0F, 15F, 0F);
        abdomenright.setTextureSize(64, 32);
        abdomenright.mirror = true;
        setRotation(abdomenright, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        rightarm.render(f5);
        leftarm.render(f5);
        rightleg.render(f5);
        leftleg.render(f5);
        chest.render(f5);
        neck.render(f5);
        hip.render(f5);
        pelvis.render(f5);
        energycore.render(f5);
        abdomenleft.render(f5);
        abdomenright.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.rotateAngleY = f4 / (180F / (float) Math.PI);
        this.head.rotateAngleX = f5 / (180F / (float) Math.PI);
        this.leftleg.rotateAngleX = MathHelper.cos(f * 1.5F) * 1.4F * f1;
        this.rightleg.rotateAngleX = MathHelper.cos(f * 1.5F + (float) Math.PI) * 1.4F * f1;
        this.leftarm.rotateAngleX = MathHelper.cos(f * 1.5F) * 1.4F * f1;
        this.rightarm.rotateAngleX = MathHelper.cos(f * 1.5F + (float) Math.PI) * 1.4F * f1;
    }
}
