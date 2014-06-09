package main.flowstoneenergy.client;

import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.client.blocks.ModelMachineWorkbench;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class CustomItemRenderer implements IItemRenderer {

    private final ModelMachineWorkbench model1 = new ModelMachineWorkbench();
    private ResourceLocation text = new ResourceLocation(ModInfo.MODID, "textures/blocks/machines/machineWorkbench.png");

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    //DON'T TOUCH THESE NUMBERS IT TOOK POPPY AN HOUR TO GET IT RIGHT
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {
            case ENTITY: {
                renderWorkbench(0.5F, 15F, -0.5F, 0.09F);
                return;
            }
            case EQUIPPED: {
                renderWorkbench(2F, 15F, 5F, 0.10F);
                return;
            }
            case EQUIPPED_FIRST_PERSON: {
                renderWorkbench(1F, 19F, 7F, 0.08F);
                return;
            }
            case INVENTORY: {
                renderWorkbench(-0.01F, 10F, 0.0F, 0.10F);
                return;
            }
            default:
                return;
        }

    }

    private void renderWorkbench(float x, float y, float z, float size) {

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(text);
        GL11.glPushMatrix(); // start
        GL11.glScalef(size,size,size);
        GL11.glTranslatef(x, y, z); // size
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(-90, 0, 1, 0);
        model1.renderAll();
        GL11.glPopMatrix(); // end
    }
}