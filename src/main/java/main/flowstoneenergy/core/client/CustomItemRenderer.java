/*
package main.flowstoneenergy.core.client;

import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.core.client.blocks.ModelMachineWorkbench;
import main.flowstoneenergy.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CustomItemRenderer implements IItemRenderer {

    private final ModelMachineWorkbench workbenchModel = new ModelMachineWorkbench();
    private ResourceLocation workbenchTexture = new ResourceLocation(ModInfo.MODID, "textures/blocks/machines/machineWorkbench.png");

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    // DON'T TOUCH THESE NUMBERS IT TOOK POPPY AN HOUR TO GET IT RIGHT
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        if (item == null || item.getItem() == null)
            return;

        if (Block.getBlockFromItem(item.getItem()) != BlockRegistry.machineWorkbench)
            return;

        switch (type) {
            case ENTITY: // item entity
                renderWorkbench(0.5F, 15F, -0.5F, 0.09F);
                break;

            case EQUIPPED: // third person in hand
                renderWorkbench(2F, 15F, 5F, 0.10F);
                break;

            case EQUIPPED_FIRST_PERSON: // first person in hand
                renderWorkbench(1F, 19F, 7F, 0.08F);
                break;

            case INVENTORY: // the item in inventories
                renderWorkbench(-0.01F, 10F, 0.0F, 0.1F);
                break;

            default:
        }

    }

    private void renderWorkbench(float x, float y, float z, float size) {

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(workbenchTexture);
        GL11.glPushMatrix(); // start
        GL11.glScalef(size, size, size);
        GL11.glTranslatef(x, y, z); // size
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(-90, 0, 1, 0);
        workbenchModel.renderAll();
        GL11.glPopMatrix(); // end
    }
}
*/