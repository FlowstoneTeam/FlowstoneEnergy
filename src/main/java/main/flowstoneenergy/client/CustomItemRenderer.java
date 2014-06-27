package main.flowstoneenergy.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.client.blocks.ModelMachineWorkbench;
import main.flowstoneenergy.client.transport.ModelPipe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class CustomItemRenderer implements IItemRenderer {

    private final ModelMachineWorkbench workbenchModel = new ModelMachineWorkbench();
    private ResourceLocation workbenchTexture = new ResourceLocation(ModInfo.MODID, "textures/blocks/machines/machineWorkbench.png");
    private final ModelPipe itemPipeModel = new ModelPipe();
    private ResourceLocation itemPipeTexture = new ResourceLocation(ModInfo.MODID, "textures/blocks/transport/itemPipe.png");

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
            case ENTITY: { //item entity
                if (item.getItem() == new ItemStack(BlockRegistry.machineWorkbench).getItem())
                    renderWorkbench(0.5F, 15F, -0.5F, 0.09F);
                if (item.getItem() == new ItemStack(BlockRegistry.itemPipe).getItem())
                    renderItemPipe(0.5F, 15F, -0.5F, 0.15F);
                return;
            }
            case EQUIPPED: { //third person in hand
                if (item.getItem() == new ItemStack(BlockRegistry.machineWorkbench).getItem())
                    renderWorkbench(2F, 15F, 5F, 0.10F);
                if (item.getItem() == new ItemStack(BlockRegistry.itemPipe).getItem())
                    renderItemPipe(2F, 15F, 5F, 0.15F);
                return;
            }
            case EQUIPPED_FIRST_PERSON: { //first person in hand
                if (item.getItem() == new ItemStack(BlockRegistry.machineWorkbench).getItem())
                    renderWorkbench(1F, 19F, 7F, 0.08F);
                if (item.getItem() == new ItemStack(BlockRegistry.itemPipe).getItem())
                    renderItemPipe(1F, 19F, 7F, 0.08F);
                return;
            }
            case INVENTORY: { //the item in inventories
                if (item.getItem() == new ItemStack(BlockRegistry.machineWorkbench).getItem())
                    renderWorkbench(-0.01F, 10F, 0.0F, 0.1F);
                if (item.getItem() == new ItemStack(BlockRegistry.itemPipe).getItem())
                    renderItemPipe(-0.01F, 10F, 0.0F, 0.18F);
                return;
            }
            default:
                return;
        }

    }

    private void renderWorkbench(float x, float y, float z, float size) {

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(workbenchTexture);
        GL11.glPushMatrix(); // start
        GL11.glScalef(size,size,size);
        GL11.glTranslatef(x, y, z); // size
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(-90, 0, 1, 0);
        workbenchModel.renderAll();
        GL11.glPopMatrix(); // end
    }

    private void renderItemPipe(float x, float y, float z, float size) {

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(itemPipeTexture);
        GL11.glPushMatrix(); // start
        GL11.glScalef(size,size,size);
        GL11.glTranslatef(x, y, z); // size
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(-90, 0, 1, 0);
        itemPipeModel.renderAll();
        GL11.glPopMatrix(); // end
    }
}