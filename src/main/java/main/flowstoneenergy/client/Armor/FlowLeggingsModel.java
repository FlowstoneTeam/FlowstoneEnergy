package main.flowstoneenergy.client.Armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FlowLeggingsModel extends ModelBiped {

    // fields
    ModelRenderer LFBelt;
    ModelRenderer LFJewel;
    ModelRenderer LRPlate;
    ModelRenderer LLPlate;

    public FlowLeggingsModel(float f) {

        super(f, 0, 64, 64);

        textureWidth = 64;
        textureHeight = 64;

        LFBelt = new ModelRenderer(this, 0, 32);
        LFBelt.addBox(-4F, 10F, -3F, 8, 1, 1);
        LFBelt.setRotationPoint(0F, 0F, 0F);
        LFBelt.setTextureSize(64, 64);
        LFBelt.mirror = true;
        setRotation(LFBelt, 0F, 0F, 0F);
        LFJewel = new ModelRenderer(this, 0, 34);
        LFJewel.addBox(-1F, 10F, -3F, 2, 2, 1);
        LFJewel.setRotationPoint(0F, 0F, 0F);
        LFJewel.setTextureSize(64, 64);
        LFJewel.mirror = true;
        setRotation(LFJewel, 0F, 0F, 0F);
        LRPlate = new ModelRenderer(this, 0, 37);
        LRPlate.addBox(-3F, -1F, -2F, 1, 6, 4);
        LRPlate.setRotationPoint(0F, 0F, 0F);
        LRPlate.setTextureSize(64, 64);
        LRPlate.mirror = true;
        setRotation(LRPlate, 0F, 0F, 0.1745329F);
        LLPlate = new ModelRenderer(this, 10, 37);
        LLPlate.addBox(2F, -1F, -2F, 1, 6, 4);
        LLPlate.setRotationPoint(0F, 0F, 0F);
        LLPlate.setTextureSize(64, 64);
        LLPlate.mirror = true;
        setRotation(LLPlate, 0F, 0F, -0.1745329F);

        this.bipedBody.addChild(LFBelt);
        this.bipedBody.addChild(LFJewel);
        this.bipedRightLeg.addChild(LRPlate);
        this.bipedLeftLeg.addChild(LLPlate);

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