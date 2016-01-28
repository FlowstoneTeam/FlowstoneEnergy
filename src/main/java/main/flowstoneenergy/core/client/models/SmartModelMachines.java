package main.flowstoneenergy.core.client.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.primitives.Ints;

import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.blocks.machines.BlockMachines;
import main.flowstoneenergy.core.utils.Vector3f;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.ISmartBlockModel;
import net.minecraftforge.client.model.ISmartItemModel;
import net.minecraftforge.common.property.IExtendedBlockState;

public class SmartModelMachines implements IBakedModel, ISmartItemModel, ISmartBlockModel {

    // 0: top, 1: bottom, 2: side, meta + 3: front off, meta + 4: front on.
    private TextureAtlasSprite textures[]; 
    private EnumFacing front = EnumFacing.NORTH;
    private boolean operating;
    private int meta;
    
    public SmartModelMachines(TextureAtlasSprite[] textures) {
        this(textures, null);
    }
    
    public SmartModelMachines(TextureAtlasSprite[] textures, IExtendedBlockState state) {
        this.textures = textures;
        if (state != null){
            this.front = EnumFacing.getFront(state.getValue(BlockMachines.hiddenProperties[0]));
            this.operating = false;
            if (state.getValue(BlockMachines.hiddenProperties[1]) == 1) {
                this.operating = true;
            }
            
            this.meta = state.getValue(BlockMachines.TYPE).getMeta();
        }
    }
    
    @Override
    public IBakedModel handleBlockState(IBlockState state) {
        return new SmartModelMachines(textures, (IExtendedBlockState)state);
    }

    @Override
    public IBakedModel handleItemState(ItemStack stack) {
        
        IExtendedBlockState state = (IExtendedBlockState)BlockRegistry.machines.getStateFromMeta(stack.getItemDamage());
        state = state.withProperty(BlockMachines.hiddenProperties[0], 2).withProperty(BlockMachines.hiddenProperties[1], 0);
        return new SmartModelMachines(textures, (IExtendedBlockState)state);
    }

    @Override
    public List<BakedQuad> getFaceQuads(EnumFacing face) {
        return Collections.emptyList();
    }

    @Override
    public List<BakedQuad> getGeneralQuads() {
        ArrayList<BakedQuad> quads = new ArrayList<BakedQuad>();
        for (EnumFacing face : EnumFacing.values()) {
            quads.add(createQuadFace(face, getTextureForFace(face)));
        }
        return quads;
    }
    
    private BakedQuad createQuadFace(EnumFacing face, TextureAtlasSprite texture){
        return new BakedQuad(createQuadVerticesData(0, 1, 1, 0, 1, face, texture), -1, face);
    }
    
    private int[] createQuadVerticesData(float x1, float x2, float y, float z1, float z2, EnumFacing face, TextureAtlasSprite texture) {
        Vector3f vertex1 = rotateFace(x1 - 0.5F, y - 0.5F, z1 - 0.5F, face);
        vertex1.add(0.5F, 0.5F, 0.5F);
        
        Vector3f vertex2 = rotateFace(x1 - 0.5F, y - 0.5F, z2 - 0.5F, face);
        vertex2.add(0.5F, 0.5F, 0.5F);
        
        Vector3f vertex3 = rotateFace(x2 - 0.5F, y - 0.5F, z2 - 0.5F, face);
        vertex3.add(0.5F, 0.5F, 0.5F);
        
        Vector3f vertex4 = rotateFace(x2 - 0.5F, y - 0.5F, z1 - 0.5F, face);
        vertex4.add(0.5F, 0.5F, 0.5F);
        
        int u1 = 0, v1 = 0, u2 = 16, v2 = 16;
        
        int vertexData [][]  = new int[4][7];
        
        switch(face){
            case EAST:
                vertexData[0] = createVertexData(vertex1, -1, texture, u2, v1);
                vertexData[1] = createVertexData(vertex2, -1, texture, u1, v1);
                vertexData[2] = createVertexData(vertex3, -1, texture, u1, v2);
                vertexData[3] = createVertexData(vertex4, -1, texture, u2, v2);
                break;
            case NORTH:
                vertexData[0] = createVertexData(vertex1, -1, texture, u2, v2);
                vertexData[1] = createVertexData(vertex2, -1, texture, u2, v1);
                vertexData[2] = createVertexData(vertex3, -1, texture, u1, v1);
                vertexData[3] = createVertexData(vertex4, -1, texture, u1, v2);
                break;
            case WEST:
                vertexData[0] = createVertexData(vertex1, -1, texture, u1, v2);
                vertexData[1] = createVertexData(vertex2, -1, texture, u2, v2);
                vertexData[2] = createVertexData(vertex3, -1, texture, u2, v1);
                vertexData[3] = createVertexData(vertex4, -1, texture, u1, v1);
                break;
            default:
                vertexData[0] = createVertexData(vertex1, -1, texture, u1, v1);
                vertexData[1] = createVertexData(vertex2, -1, texture, u1, v2);
                vertexData[2] = createVertexData(vertex3, -1, texture, u2, v2);
                vertexData[3] = createVertexData(vertex4, -1, texture, u2, v1);
        }
        
        return Ints.concat(vertexData[0], vertexData[1], vertexData[2], vertexData[3]);
    }
    
    private Vector3f rotateFace(float x, float y, float z , EnumFacing side) {
        
        Vector3f vector = new Vector3f();
        
        switch(side) {
            /*case DOWN:  return new Vec3( x, -y, -z);
            case UP:    return new Vec3( x,  y,  z);
            case NORTH: return new Vec3( x,  z, -y);
            case SOUTH: return new Vec3( x, -z,  y);
            case WEST:  return new Vec3(-y,  x,  z);
            case EAST:  return new Vec3( y, -x,  z);*/
            
            case DOWN:  
                vector.x = x;
                vector.y = -y;
                vector.z = -z;
                break;
            case UP:    
                vector.x = x;
                vector.y = y;
                vector.z = z;
                break;
            case NORTH: 
                vector.x = x;
                vector.y = z;
                vector.z = -y;
                break;
            case SOUTH: 
                vector.x = x;
                vector.y = -z;
                vector.z = y;
                break;
            case WEST:  
                vector.x = -y;
                vector.y = x;
                vector.z = z;
                break;
            case EAST:  
                vector.x = y;
                vector.y = -x;
                vector.z = z;
                break;
        }
        return vector;
    }
    
    private int[] createVertexData(Vector3f vertex, int color, TextureAtlasSprite texture, float u, float v) {
        return new int[] {
                Float.floatToRawIntBits(vertex.x),
                Float.floatToRawIntBits(vertex.y),
                Float.floatToRawIntBits(vertex.z),
                color,
                Float.floatToRawIntBits(texture.getInterpolatedU(u)),
                Float.floatToRawIntBits(texture.getInterpolatedV(v)),
                0
        };
    }
    
    private TextureAtlasSprite getTextureForFace(EnumFacing face) {
        if(face == EnumFacing.UP)
            return textures[0];
        if (face == EnumFacing.DOWN)
            return textures[1];
        
        if (face == front) {
            int textureIndex = 3 + (meta * 2);
            if (operating)
                return textures[textureIndex + 1];
            else
                return textures[textureIndex];
        }
        
        return textures[2];
    }

    @Override
    public boolean isAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return true;
    }

    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return textures[2];
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return ItemCameraTransforms.DEFAULT;
    }

}
