package main.flowstoneenergy.client.Armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FlowBootsModel extends ModelBiped {

    // fields
    ModelRenderer BRFPlate1;
    ModelRenderer BRFPlate2;
    ModelRenderer BRFPlate3;
    ModelRenderer BRSupport1;
    ModelRenderer BRSupport2;
    ModelRenderer BLFPlate1;
    ModelRenderer BLFPlate2;
    ModelRenderer BLFPlate3;
    ModelRenderer BLSupport1;
    ModelRenderer BLSupport2;

    public FlowBootsModel(float f) {

        super(f, 0, 64, 64);

        textureWidth = 64;
        textureHeight = 64;

        BRFPlate1 = new ModelRenderer(this, 0, 32);
        BRFPlate1.addBox(-2F, 3F, -3F, 3, 3, 1);
        BRFPlate1.setRotationPoint(0F, 0F, 0F);
        BRFPlate1.setTextureSize(64, 64);
        BRFPlate1.mirror = true;
        setRotation(BRFPlate1, 0F, 0F, 0F);
        BRFPlate2 = new ModelRenderer(this, 0, 36);
        BRFPlate2.addBox(-1F, 3F, -3F, 2, 4, 1);
        BRFPlate2.setRotationPoint(0F, 0F, 0F);
        BRFPlate2.setTextureSize(64, 64);
        BRFPlate2.mirror = true;
        setRotation(BRFPlate2, 0F, 0F, 0F);
        BRFPlate3 = new ModelRenderer(this, 0, 41);
        BRFPlate3.addBox(0F, 3F, -3F, 1, 5, 1);
        BRFPlate3.setRotationPoint(0F, 0F, 0F);
        BRFPlate3.setTextureSize(64, 64);
        BRFPlate3.mirror = true;
        setRotation(BRFPlate3, 0F, 0F, 0F);
        BRSupport1 = new ModelRenderer(this, 0, 47);
        BRSupport1.addBox(-3F, 3F, -2F, 1, 3, 2);
        BRSupport1.setRotationPoint(0F, 0F, 0F);
        BRSupport1.setTextureSize(64, 64);
        BRSupport1.mirror = true;
        setRotation(BRSupport1, 0F, -0.1745329F, 0F);
        BRSupport2 = new ModelRenderer(this, 0, 52);
        BRSupport2.addBox(-3F, 3F, -2F, 1, 2, 3);
        BRSupport2.setRotationPoint(0F, 0F, 0F);
        BRSupport2.setTextureSize(64, 64);
        BRSupport2.mirror = true;
        setRotation(BRSupport2, 0F, -0.1745329F, 0F);
        BLFPlate1 = new ModelRenderer(this, 8, 32);
        BLFPlate1.addBox(-1F, 3F, -3F, 3, 3, 1);
        BLFPlate1.setRotationPoint(0F, 0F, 0F);
        BLFPlate1.setTextureSize(64, 64);
        BLFPlate1.mirror = true;
        setRotation(BLFPlate1, 0F, 0F, 0F);
        BLFPlate2 = new ModelRenderer(this, 8, 36);
        BLFPlate2.addBox(-1F, 3F, -3F, 2, 4, 1);
        BLFPlate2.setRotationPoint(0F, 0F, 0F);
        BLFPlate2.setTextureSize(64, 64);
        BLFPlate2.mirror = true;
        setRotation(BLFPlate2, 0F, 0F, 0F);
        BLFPlate3 = new ModelRenderer(this, 8, 41);
        BLFPlate3.addBox(-1F, 3F, -3F, 1, 5, 1);
        BLFPlate3.setRotationPoint(0F, 0F, 0F);
        BLFPlate3.setTextureSize(64, 64);
        BLFPlate3.mirror = true;
        setRotation(BLFPlate3, 0F, 0F, 0F);
        BLSupport1 = new ModelRenderer(this, 8, 47);
        BLSupport1.addBox(2F, 3F, -2F, 1, 3, 2);
        BLSupport1.setRotationPoint(0F, 0F, 0F);
        BLSupport1.setTextureSize(64, 64);
        BLSupport1.mirror = true;
        setRotation(BLSupport1, 0F, 0.1745329F, 0F);
        BLSupport2 = new ModelRenderer(this, 8, 52);
        BLSupport2.addBox(2F, 3F, -2F, 1, 2, 3);
        BLSupport2.setRotationPoint(0F, 0F, 0F);
        BLSupport2.setTextureSize(64, 64);
        BLSupport2.mirror = true;
        setRotation(BLSupport2, 0F, 0.1745329F, 0F);

        this.bipedRightLeg.addChild(BRFPlate1);
        this.bipedRightLeg.addChild(BRFPlate2);
        this.bipedRightLeg.addChild(BRFPlate3);
        this.bipedRightLeg.addChild(BRSupport1);
        this.bipedRightLeg.addChild(BRSupport2);
        this.bipedLeftLeg.addChild(BLFPlate1);
        this.bipedLeftLeg.addChild(BLFPlate2);
        this.bipedLeftLeg.addChild(BLFPlate3);
        this.bipedLeftLeg.addChild(BLSupport1);
        this.bipedLeftLeg.addChild(BLSupport2);

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