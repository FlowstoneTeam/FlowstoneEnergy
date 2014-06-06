package main.flowstoneenergy.client.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FlowChestModel extends ModelBiped {

    // fields
    ModelRenderer FL1Plate1;
    ModelRenderer FL1Plate2;
    ModelRenderer FL1Plate3;
    ModelRenderer FL2Plate1;
    ModelRenderer FL2Plate2;
    ModelRenderer FL2Plate3;
    ModelRenderer BL1Plate1;
    ModelRenderer BL1Plate2;
    ModelRenderer BL1Plate3;
    ModelRenderer SPad1;
    ModelRenderer SPad2;
    ModelRenderer SFill;
    ModelRenderer SLDeco1;
    ModelRenderer SLDeco2;
    ModelRenderer SUDeco1;
    ModelRenderer SUDeco2;
    ModelRenderer GPlate1;
    ModelRenderer GPlate2;
    ModelRenderer GPlate3;
    ModelRenderer GSupport1;
    ModelRenderer GSupport2;
    ModelRenderer GSupport3;
    ModelRenderer GSupport4;

    public FlowChestModel(float f) {

        super(f, 0, 64, 64);

        textureWidth = 64;
        textureHeight = 64;

        FL1Plate1 = new ModelRenderer(this, 0, 32);
        FL1Plate1.addBox(-4F, 0F, -3F, 8, 4, 1);
        FL1Plate1.setRotationPoint(0F, 0F, 0F);
        FL1Plate1.setTextureSize(64, 32);
        FL1Plate1.mirror = true;
        setRotation(FL1Plate1, 0F, 0F, 0F);
        FL1Plate2 = new ModelRenderer(this, 0, 37);
        FL1Plate2.addBox(-3F, 0F, -3F, 6, 5, 1);
        FL1Plate2.setRotationPoint(0F, 0F, 0F);
        FL1Plate2.setTextureSize(64, 32);
        FL1Plate2.mirror = true;
        setRotation(FL1Plate2, 0F, 0F, 0F);
        FL1Plate3 = new ModelRenderer(this, 0, 43);
        FL1Plate3.addBox(-2F, 0F, -3F, 4, 6, 1);
        FL1Plate3.setRotationPoint(0F, 0F, 0F);
        FL1Plate3.setTextureSize(64, 32);
        FL1Plate3.mirror = true;
        setRotation(FL1Plate3, 0F, 0F, 0F);
        FL2Plate1 = new ModelRenderer(this, 0, 50);
        FL2Plate1.addBox(-3F, 0F, -4F, 6, 3, 1);
        FL2Plate1.setRotationPoint(0F, 0F, 0F);
        FL2Plate1.setTextureSize(64, 32);
        FL2Plate1.mirror = true;
        setRotation(FL2Plate1, 0F, 0F, 0F);
        FL2Plate2 = new ModelRenderer(this, 0, 54);
        FL2Plate2.addBox(-2F, 0F, -4F, 4, 4, 1);
        FL2Plate2.setRotationPoint(0F, 0F, 0F);
        FL2Plate2.setTextureSize(64, 32);
        FL2Plate2.mirror = true;
        setRotation(FL2Plate2, 0F, 0F, 0F);
        FL2Plate3 = new ModelRenderer(this, 18, 32);
        FL2Plate3.addBox(-1F, 0F, -4F, 2, 5, 1);
        FL2Plate3.setRotationPoint(0F, 0F, 0F);
        FL2Plate3.setTextureSize(64, 32);
        FL2Plate3.mirror = true;
        setRotation(FL2Plate3, 0F, 0F, 0F);
        BL1Plate1 = new ModelRenderer(this, 0, 32);
        BL1Plate1.addBox(-4F, 0F, 2F, 8, 4, 1);
        BL1Plate1.setRotationPoint(0F, 0F, 0F);
        BL1Plate1.setTextureSize(64, 32);
        BL1Plate1.mirror = true;
        setRotation(BL1Plate1, 0F, 0F, 0F);
        BL1Plate2 = new ModelRenderer(this, 0, 37);
        BL1Plate2.addBox(-3F, 0F, 2F, 6, 5, 1);
        BL1Plate2.setRotationPoint(0F, 0F, 0F);
        BL1Plate2.setTextureSize(64, 32);
        BL1Plate2.mirror = true;
        setRotation(BL1Plate2, 0F, 0F, 0F);
        BL1Plate3 = new ModelRenderer(this, 0, 43);
        BL1Plate3.addBox(-2F, 0F, 2F, 4, 6, 1);
        BL1Plate3.setRotationPoint(0F, 0F, 0F);
        BL1Plate3.setTextureSize(64, 32);
        BL1Plate3.mirror = true;
        setRotation(BL1Plate3, 0F, 0F, 0F);
        SPad1 = new ModelRenderer(this, 18, 38);
        SPad1.addBox(-6F, -4F, -2.5F, 7, 1, 5);
        SPad1.setRotationPoint(0F, 0F, 0F);
        SPad1.setTextureSize(64, 32);
        SPad1.mirror = true;
        setRotation(SPad1, 0F, 0F, -0.6981317F);
        SPad2 = new ModelRenderer(this, 18, 44);
        SPad2.addBox(0F, -6F, -2.5F, 1, 3, 5);
        SPad2.setRotationPoint(0F, 0F, 0F);
        SPad2.setTextureSize(64, 32);
        SPad2.mirror = true;
        setRotation(SPad2, 0F, 0F, -0.6981317F);
        SFill = new ModelRenderer(this, 18, 52);
        SFill.addBox(-5F, -5F, -1.5F, 5, 1, 3);
        SFill.setRotationPoint(0F, 0F, 0F);
        SFill.setTextureSize(64, 32);
        SFill.mirror = true;
        setRotation(SFill, 0F, 0F, -0.6981317F);
        SLDeco1 = new ModelRenderer(this, 18, 56);
        SLDeco1.addBox(-7F, -4F, -2.5F, 8, 1, 1);
        SLDeco1.setRotationPoint(0F, 0F, 0F);
        SLDeco1.setTextureSize(64, 32);
        SLDeco1.mirror = true;
        setRotation(SLDeco1, 0F, 0F, -0.6981317F);
        SLDeco2 = new ModelRenderer(this, 18, 56);
        SLDeco2.addBox(-7F, -4F, 1.5F, 8, 1, 1);
        SLDeco2.setRotationPoint(0F, 0F, 0F);
        SLDeco2.setTextureSize(64, 32);
        SLDeco2.mirror = true;
        setRotation(SLDeco2, 0F, 0F, -0.6981317F);
        SUDeco1 = new ModelRenderer(this, 18, 58);
        SUDeco1.addBox(0F, -7F, -2.5F, 1, 4, 1);
        SUDeco1.setRotationPoint(0F, 0F, 0F);
        SUDeco1.setTextureSize(64, 32);
        SUDeco1.mirror = true;
        setRotation(SUDeco1, 0F, 0F, -0.6981317F);
        SUDeco2 = new ModelRenderer(this, 18, 58);
        SUDeco2.addBox(0F, -7F, 1.5F, 1, 4, 1);
        SUDeco2.setRotationPoint(0F, 0F, 0F);
        SUDeco2.setTextureSize(64, 32);
        SUDeco2.mirror = true;
        setRotation(SUDeco2, 0F, 0F, -0.6981317F);
        GPlate1 = new ModelRenderer(this, 42, 32);
        GPlate1.addBox(-4F, 2F, -2F, 1, 4, 4);
        GPlate1.setRotationPoint(0F, 0F, 0F);
        GPlate1.setTextureSize(64, 32);
        GPlate1.mirror = true;
        setRotation(GPlate1, 0F, 0F, 0F);
        GPlate2 = new ModelRenderer(this, 42, 40);
        GPlate2.addBox(-4F, 2F, -1F, 1, 6, 2);
        GPlate2.setRotationPoint(0F, 0F, 0F);
        GPlate2.setTextureSize(64, 32);
        GPlate2.mirror = true;
        setRotation(GPlate2, 0F, 0F, 0F);
        GPlate3 = new ModelRenderer(this, 42, 48);
        GPlate3.addBox(-5F, 2F, -1F, 1, 3, 2);
        GPlate3.setRotationPoint(0F, 0F, 0F);
        GPlate3.setTextureSize(64, 32);
        GPlate3.mirror = true;
        setRotation(GPlate3, 0F, 0F, 0F);
        GSupport1 = new ModelRenderer(this, 42, 53);
        GSupport1.addBox(-3F, 2F, -3F, 1, 4, 1);
        GSupport1.setRotationPoint(0F, 0F, 0F);
        GSupport1.setTextureSize(64, 32);
        GSupport1.mirror = true;
        setRotation(GSupport1, 0F, 0F, 0F);
        GSupport2 = new ModelRenderer(this, 42, 58);
        GSupport2.addBox(-3F, 2F, -3F, 2, 2, 1);
        GSupport2.setRotationPoint(0F, 0F, 0F);
        GSupport2.setTextureSize(64, 32);
        GSupport2.mirror = true;
        setRotation(GSupport2, 0F, 0F, 0F);
        GSupport3 = new ModelRenderer(this, 42, 53);
        GSupport3.addBox(-3F, 2F, 2F, 1, 4, 1);
        GSupport3.setRotationPoint(0F, 0F, 0F);
        GSupport3.setTextureSize(64, 32);
        GSupport3.mirror = true;
        setRotation(GSupport3, 0F, 0F, 0F);
        GSupport4 = new ModelRenderer(this, 42, 58);
        GSupport4.addBox(-3F, 2F, 2F, 2, 2, 1);
        GSupport4.setRotationPoint(0F, 0F, 0F);
        GSupport4.setTextureSize(64, 32);
        GSupport4.mirror = true;
        setRotation(GSupport4, 0F, 0F, 0F);

        this.bipedBody.addChild(FL1Plate1);
        this.bipedBody.addChild(FL1Plate2);
        this.bipedBody.addChild(FL1Plate3);
        this.bipedBody.addChild(FL2Plate1);
        this.bipedBody.addChild(FL2Plate2);
        this.bipedBody.addChild(FL2Plate3);
        this.bipedBody.addChild(BL1Plate1);
        this.bipedBody.addChild(BL1Plate2);
        this.bipedBody.addChild(BL1Plate3);
        this.bipedRightArm.addChild(SPad1);
        this.bipedRightArm.addChild(SPad2);
        this.bipedRightArm.addChild(SFill);
        this.bipedRightArm.addChild(SUDeco1);
        this.bipedRightArm.addChild(SUDeco2);
        this.bipedRightArm.addChild(SLDeco1);
        this.bipedRightArm.addChild(SLDeco2);
        this.bipedRightArm.addChild(GPlate1);
        this.bipedRightArm.addChild(GPlate2);
        this.bipedRightArm.addChild(GPlate3);
        this.bipedRightArm.addChild(GSupport1);
        this.bipedRightArm.addChild(GSupport2);
        this.bipedRightArm.addChild(GSupport3);
        this.bipedRightArm.addChild(GSupport4);

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
