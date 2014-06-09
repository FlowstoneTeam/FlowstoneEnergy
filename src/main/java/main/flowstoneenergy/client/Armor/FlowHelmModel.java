package main.flowstoneenergy.client.Armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FlowHelmModel extends ModelBiped {

    // fields
    ModelRenderer HFPlate1;
    ModelRenderer HFPlate2;
    ModelRenderer HFPlate3;
    ModelRenderer HFPlate4;
    ModelRenderer HFHolder1;
    ModelRenderer HFHolder2;
    ModelRenderer HRPlate1;
    ModelRenderer HRPlate2;
    ModelRenderer HLPlate1;
    ModelRenderer HLPlate2;
    ModelRenderer HUPlate1;
    ModelRenderer HUPlate2;

    public FlowHelmModel(float f) {

        super(f, 0, 64, 64);

        textureWidth = 64;
        textureHeight = 64;

        HFPlate1 = new ModelRenderer(this, 0, 35);
        HFPlate1.addBox(-4F, -8F, -5F, 1, 7, 1);
        HFPlate1.setRotationPoint(0F, 0F, 0F);
        HFPlate1.setTextureSize(64, 64);
        HFPlate1.mirror = true;
        setRotation(HFPlate1, 0F, 0F, 0F);
        HFPlate2 = new ModelRenderer(this, 0, 32);
        HFPlate2.addBox(-3F, -2F, -5F, 1, 2, 1);
        HFPlate2.setRotationPoint(0F, 0F, 0F);
        HFPlate2.setTextureSize(64, 64);
        HFPlate2.mirror = true;
        setRotation(HFPlate2, 0F, 0F, 0F);
        HFPlate3 = new ModelRenderer(this, 0, 35);
        HFPlate3.addBox(3F, -8F, -5F, 1, 7, 1);
        HFPlate3.setRotationPoint(0F, 0F, 0F);
        HFPlate3.setTextureSize(64, 64);
        HFPlate3.mirror = true;
        setRotation(HFPlate3, 0F, 0F, 0F);
        HFPlate4 = new ModelRenderer(this, 0, 32);
        HFPlate4.addBox(2F, -2F, -5F, 1, 2, 1);
        HFPlate4.setRotationPoint(0F, 0F, 0F);
        HFPlate4.setTextureSize(64, 64);
        HFPlate4.mirror = true;
        setRotation(HFPlate4, 0F, 0F, 0F);
        HFHolder1 = new ModelRenderer(this, 0, 43);
        HFHolder1.addBox(-1F, -8F, -5F, 2, 3, 1);
        HFHolder1.setRotationPoint(0F, 0F, 0F);
        HFHolder1.setTextureSize(64, 64);
        HFHolder1.mirror = true;
        setRotation(HFHolder1, 0F, 0F, 0F);
        HFHolder2 = new ModelRenderer(this, 0, 47);
        HFHolder2.addBox(-2F, -8F, -5F, 4, 2, 1);
        HFHolder2.setRotationPoint(0F, 0F, 0F);
        HFHolder2.setTextureSize(64, 64);
        HFHolder2.mirror = true;
        setRotation(HFHolder2, 0F, 0F, 0F);
        HRPlate1 = new ModelRenderer(this, 10, 32);
        HRPlate1.addBox(-6F, -8F, -1F, 1, 2, 2);
        HRPlate1.setRotationPoint(0F, 0F, 0F);
        HRPlate1.setTextureSize(64, 64);
        HRPlate1.mirror = true;
        setRotation(HRPlate1, 0.2617994F, -0.2617994F, 0F);
        HRPlate2 = new ModelRenderer(this, 10, 36);
        HRPlate2.addBox(-6F, -8F, -1F, 1, 1, 4);
        HRPlate2.setRotationPoint(0F, 0F, 0F);
        HRPlate2.setTextureSize(64, 64);
        HRPlate2.mirror = true;
        setRotation(HRPlate2, 0.2617994F, -0.2617994F, 0F);
        HLPlate1 = new ModelRenderer(this, 10, 41);
        HLPlate1.addBox(5F, -8F, -1F, 1, 2, 2);
        HLPlate1.setRotationPoint(0F, 0F, 0F);
        HLPlate1.setTextureSize(64, 64);
        HLPlate1.mirror = true;
        setRotation(HLPlate1, 0.2617994F, 0.2617994F, 0F);
        HLPlate2 = new ModelRenderer(this, 10, 45);
        HLPlate2.addBox(5F, -8F, -1F, 1, 1, 4);
        HLPlate2.setRotationPoint(0F, 0F, 0F);
        HLPlate2.setTextureSize(64, 64);
        HLPlate2.mirror = true;
        setRotation(HLPlate2, 0.2617994F, 0.2617994F, 0F);
        HUPlate1 = new ModelRenderer(this, 10, 50);
        HUPlate1.addBox(-2F, -9.8F, -2F, 4, 1, 2);
        HUPlate1.setRotationPoint(0F, 0F, 0F);
        HUPlate1.setTextureSize(64, 64);
        HUPlate1.mirror = true;
        setRotation(HUPlate1, 0.2617994F, 0F, 0F);
        HUPlate2 = new ModelRenderer(this, 10, 53);
        HUPlate2.addBox(-1F, -9.8F, -2F, 2, 1, 3);
        HUPlate2.setRotationPoint(0F, 0F, 0F);
        HUPlate2.setTextureSize(64, 64);
        HUPlate2.mirror = true;
        setRotation(HUPlate2, 0.2617994F, 0F, 0F);

        this.bipedHead.addChild(HFPlate1);
        this.bipedHead.addChild(HFPlate2);
        this.bipedHead.addChild(HFPlate3);
        this.bipedHead.addChild(HFPlate4);
        this.bipedHead.addChild(HFHolder1);
        this.bipedHead.addChild(HFHolder2);
        this.bipedHead.addChild(HRPlate1);
        this.bipedHead.addChild(HRPlate2);
        this.bipedHead.addChild(HLPlate1);
        this.bipedHead.addChild(HLPlate2);
        this.bipedHead.addChild(HUPlate1);
        this.bipedHead.addChild(HUPlate2);

    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {

        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;

    }

}
