package main.flowstoneenergy.client.transport;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPipe extends ModelBase
{
    //fields
    ModelRenderer PipeOutputRight;
    ModelRenderer PipeOutputLeft;
    ModelRenderer PipeOutputTop;
    ModelRenderer PipeOutputBottom;
    ModelRenderer PipeOutputFront;
    ModelRenderer PipeOutputBack;
    ModelRenderer LongPipeTopToBottom;
    ModelRenderer LongPipeBackToFront;
    ModelRenderer PipePlacedCeperate;
    ModelRenderer LongPipeRightToLeft;
    ModelRenderer LongPipeConnected;

    public ModelPipe()
    {
        textureWidth = 128;
        textureHeight = 64;

        PipeOutputRight = new ModelRenderer(this, 16, 4);
        PipeOutputRight.addBox(0F, 0F, 0F, 2, 6, 6);
        PipeOutputRight.setRotationPoint(-8F, 13F, -3F);
        PipeOutputRight.setTextureSize(128, 64);
        PipeOutputRight.mirror = true;
        setRotation(PipeOutputRight, 0F, 0F, 0F);
        PipeOutputRight.mirror = false;
        PipeOutputLeft = new ModelRenderer(this, 0, 4);
        PipeOutputLeft.addBox(0F, 0F, 0F, 2, 6, 6);
        PipeOutputLeft.setRotationPoint(6F, 13F, -3F);
        PipeOutputLeft.setTextureSize(128, 64);
        PipeOutputLeft.mirror = true;
        setRotation(PipeOutputLeft, 0F, 0F, 0F);
        PipeOutputLeft.mirror = false;
        PipeOutputTop = new ModelRenderer(this, 0, 28);
        PipeOutputTop.addBox(0F, 0F, 0F, 2, 6, 6);
        PipeOutputTop.setRotationPoint(-3F, 8F, -3F);
        PipeOutputTop.setTextureSize(128, 64);
        PipeOutputTop.mirror = true;
        setRotation(PipeOutputTop, 0F, 1.570796F, 1.570796F);
        PipeOutputTop.mirror = false;
        PipeOutputBottom = new ModelRenderer(this, 16, 28);
        PipeOutputBottom.addBox(0F, 0F, 0F, 2, 6, 6);
        PipeOutputBottom.setRotationPoint(-3F, 22F, -3F);
        PipeOutputBottom.setTextureSize(128, 64);
        PipeOutputBottom.mirror = true;
        setRotation(PipeOutputBottom, 0F, 1.570796F, 1.570796F);
        PipeOutputBottom.mirror = false;
        PipeOutputFront = new ModelRenderer(this, 16, 16);
        PipeOutputFront.addBox(0F, 0F, 0F, 2, 6, 6);
        PipeOutputFront.setRotationPoint(-3F, 13F, -6F);
        PipeOutputFront.setTextureSize(128, 64);
        PipeOutputFront.mirror = true;
        setRotation(PipeOutputFront, 0F, 1.570796F, 0F);
        PipeOutputFront.mirror = false;
        PipeOutputBack = new ModelRenderer(this, 0, 16);
        PipeOutputBack.addBox(0F, 0F, 0F, 2, 6, 6);
        PipeOutputBack.setRotationPoint(-3F, 13F, 8F);
        PipeOutputBack.setTextureSize(128, 64);
        PipeOutputBack.mirror = true;
        setRotation(PipeOutputBack, 0F, 1.570796F, 0F);
        PipeOutputBack.mirror = false;
        LongPipeTopToBottom = new ModelRenderer(this, 0, 40);
        LongPipeTopToBottom.addBox(0F, 0F, 0F, 4, 12, 4);
        LongPipeTopToBottom.setRotationPoint(-2F, 10F, -2F);
        LongPipeTopToBottom.setTextureSize(128, 64);
        LongPipeTopToBottom.mirror = true;
        setRotation(LongPipeTopToBottom, 0F, 0F, 0F);
        LongPipeTopToBottom.mirror = false;
        LongPipeBackToFront = new ModelRenderer(this, 32, 48);
        LongPipeBackToFront.addBox(0F, 0F, 0F, 4, 4, 12);
        LongPipeBackToFront.setRotationPoint(-2F, 14F, -6F);
        LongPipeBackToFront.setTextureSize(128, 64);
        LongPipeBackToFront.mirror = true;
        setRotation(LongPipeBackToFront, 0F, 0F, 0F);
        LongPipeBackToFront.mirror = false;
        PipePlacedCeperate = new ModelRenderer(this, 32, 40);
        PipePlacedCeperate.addBox(0F, 0F, 0F, 4, 4, 4);
        PipePlacedCeperate.setRotationPoint(-15F, 14F, -2F);
        PipePlacedCeperate.setTextureSize(128, 64);
        PipePlacedCeperate.mirror = true;
        setRotation(PipePlacedCeperate, 0F, 0F, 0F);
        PipePlacedCeperate.mirror = false;
        LongPipeRightToLeft = new ModelRenderer(this, 0, 56);
        LongPipeRightToLeft.addBox(0F, 0F, 0F, 12, 4, 4);
        LongPipeRightToLeft.setRotationPoint(-6F, 14F, -2F);
        LongPipeRightToLeft.setTextureSize(128, 64);
        LongPipeRightToLeft.mirror = true;
        setRotation(LongPipeRightToLeft, 0F, 0F, 0F);
        LongPipeRightToLeft.mirror = false;
        LongPipeConnected = new ModelRenderer(this, 64, 56);
        LongPipeConnected.addBox(0F, 0F, 0F, 18, 4, 4);
        LongPipeConnected.setRotationPoint(12F, 14F, -2F);
        LongPipeConnected.setTextureSize(128, 64);
        LongPipeConnected.mirror = true;
        setRotation(LongPipeConnected, 0F, 0F, 0F);
        LongPipeConnected.mirror = false;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        PipeOutputRight.render(f5);
        PipeOutputLeft.render(f5);
        PipeOutputTop.render(f5);
        PipeOutputBottom.render(f5);
        PipeOutputFront.render(f5);
        PipeOutputBack.render(f5);
        LongPipeTopToBottom.render(f5);
        LongPipeBackToFront.render(f5);
        PipePlacedCeperate.render(f5);
        LongPipeRightToLeft.render(f5);
        LongPipeConnected.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    public void renderAll(){
        this.LongPipeTopToBottom.render(0.625F);
    }
}
