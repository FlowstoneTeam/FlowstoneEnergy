package main.flowstoneenergy.core.client.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FlowstoneArmorModel extends ModelBiped {
    ModelRenderer front1;
    ModelRenderer front2;
    ModelRenderer front3;
    ModelRenderer front4;
    ModelRenderer righta1;
    ModelRenderer righta2;
    ModelRenderer righta3;
    ModelRenderer lefta1;
    ModelRenderer lefta2;
    ModelRenderer lefta3;
    ModelRenderer rightl1;
    ModelRenderer rightl2;
    ModelRenderer rightl3;
    ModelRenderer rightl4;
    ModelRenderer head1;
    ModelRenderer head2;

    public FlowstoneArmorModel(float scale) {
        super(scale, 0.0F, 64, 64);

        textureWidth = 64;
        textureHeight = 64;

        front1 = new ModelRenderer(this, 0, 32);
        front1.addBox(-1F, 1F, -2.5F, 2, 4, 1);
        front1.setRotationPoint(0F, 0F, 0F);
        front1.setTextureSize(64, 64);
        front1.mirror = true;
        setRotation(front1, 0F, 0F, 0F);
        front1.mirror = false;
        front2 = new ModelRenderer(this, 0, 37);
        front2.addBox(-2F, 2F, -2.533333F, 1, 2, 1);
        front2.setRotationPoint(0F, 0F, 0F);
        front2.setTextureSize(64, 64);
        front2.mirror = true;
        setRotation(front2, 0F, 0F, 0F);
        front2.mirror = false;
        front3 = new ModelRenderer(this, 0, 37);
        front3.addBox(1F, 2F, -2.5F, 1, 2, 1);
        front3.setRotationPoint(0F, 0F, 0F);
        front3.setTextureSize(64, 64);
        front3.mirror = true;
        setRotation(front3, 0F, 0F, 0F);
        front3.mirror = false;
        front4 = new ModelRenderer(this, 0, 40);
        front4.addBox(-1F, 2F, -3F, 2, 2, 1);
        front4.setRotationPoint(0F, 0F, 0F);
        front4.setTextureSize(64, 64);
        front4.mirror = true;
        setRotation(front4, 0F, 0F, 0F);
        front4.mirror = false;
        righta1 = new ModelRenderer(this, 0, 44);
        righta1.addBox(-5F, -3F, -1F, 1, 8, 3);
        righta1.setRotationPoint(0F, 0F, 0F);
        righta1.setTextureSize(64, 64);
        righta1.mirror = true;
        setRotation(righta1, 0.3490659F, -0.2617994F, 0F);
        righta1.mirror = false;
        righta2 = new ModelRenderer(this, 0, 55);
        righta2.addBox(-5F, -3F, 2F, 1, 4, 1);
        righta2.setRotationPoint(0F, 0F, 0F);
        righta2.setTextureSize(64, 64);
        righta2.mirror = true;
        setRotation(righta2, 0.3490659F, -0.2617994F, 0F);
        righta2.mirror = false;
        righta3 = new ModelRenderer(this, 0, 60);
        righta3.addBox(-5F, 5F, -1F, 1, 1, 2);
        righta3.setRotationPoint(0F, 0F, 0F);
        righta3.setTextureSize(64, 64);
        righta3.mirror = true;
        setRotation(righta3, 0.3490659F, -0.2617994F, 0F);
        righta3.mirror = false;
        lefta1 = new ModelRenderer(this, 8, 32);
        lefta1.addBox(4F, -3F, -1F, 1, 8, 3);
        lefta1.setRotationPoint(0F, 0F, 0F);
        lefta1.setTextureSize(64, 64);
        lefta1.mirror = true;
        setRotation(lefta1, 0.3490659F, 0.2617994F, 0F);
        lefta1.mirror = false;
        lefta2 = new ModelRenderer(this, 8, 43);
        lefta2.addBox(4F, -3F, 2F, 1, 4, 1);
        lefta2.setRotationPoint(0F, 0F, 0F);
        lefta2.setTextureSize(64, 64);
        lefta2.mirror = true;
        setRotation(lefta2, 0.3490659F, 0.2617994F, 0F);
        lefta2.mirror = false;
        lefta3 = new ModelRenderer(this, 8, 48);
        lefta3.addBox(4F, 5F, -1F, 1, 1, 2);
        lefta3.setRotationPoint(0F, 0F, 0F);
        lefta3.setTextureSize(64, 64);
        lefta3.mirror = true;
        setRotation(lefta3, 0.3490659F, 0.2617994F, 0F);
        lefta3.mirror = false;
        rightl1 = new ModelRenderer(this, 16, 32);
        rightl1.addBox(-2F, 2F, -3F, 3, 2, 1);
        rightl1.setRotationPoint(-0F, 0F, 0F);
        rightl1.setTextureSize(64, 64);
        rightl1.mirror = true;
        setRotation(rightl1, 0F, 0F, 0F);
        rightl1.mirror = false;
        rightl2 = new ModelRenderer(this, 16, 35);
        rightl2.addBox(-1F, 4F, -3F, 2, 2, 1);
        rightl2.setRotationPoint(-0F, 0F, 0F);
        rightl2.setTextureSize(64, 64);
        rightl2.mirror = true;
        setRotation(rightl2, 0F, 0F, 0F);
        rightl2.mirror = false;
        rightl3 = new ModelRenderer(this, 16, 38);
        rightl3.addBox(0F, 6F, -3F, 1, 1, 1);
        rightl3.setRotationPoint(-0F, 0F, 0F);
        rightl3.setTextureSize(64, 64);
        rightl3.mirror = true;
        setRotation(rightl3, 0F, 0F, 0F);
        rightl3.mirror = false;
        rightl4 = new ModelRenderer(this, 16, 40);
        rightl4.addBox(-1F, 2F, -3F, 2, 2, 1);
        rightl4.setRotationPoint(-0F, 0F, 0F);
        rightl4.setTextureSize(64, 64);
        rightl4.mirror = true;
        setRotation(rightl4, 0F, 1.047198F, 0F);
        rightl4.mirror = false;
        head1 = new ModelRenderer(this, 16, 43);
        head1.addBox(-2F, -8F, -5F, 4, 2, 1);
        head1.setRotationPoint(0F, 0F, 0F);
        head1.setTextureSize(64, 64);
        head1.mirror = true;
        setRotation(head1, 0F, 0F, 0F);
        head1.mirror = false;
        head2 = new ModelRenderer(this, 16, 46);
        head2.addBox(-1F, -6F, -5F, 2, 1, 1);
        head2.setRotationPoint(0F, 0F, 0F);
        head2.setTextureSize(64, 64);
        head2.mirror = true;
        setRotation(head2, 0F, 0F, 0F);
        head2.mirror = false;

        this.bipedBody.addChild(front1);
        this.bipedBody.addChild(front2);
        this.bipedBody.addChild(front3);
        this.bipedBody.addChild(front4);
        this.bipedHead.addChild(head1);
        this.bipedHead.addChild(head2);
        this.bipedRightArm.addChild(righta1);
        this.bipedRightArm.addChild(righta2);
        this.bipedRightArm.addChild(righta3);
        this.bipedLeftArm.addChild(lefta1);
        this.bipedLeftArm.addChild(lefta2);
        this.bipedLeftArm.addChild(lefta3);
        this.bipedLeftArm.addChild(lefta3);
        this.bipedRightLeg.addChild(rightl1);
        this.bipedRightLeg.addChild(rightl2);
        this.bipedRightLeg.addChild(rightl3);
        this.bipedRightLeg.addChild(rightl4);
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

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}
