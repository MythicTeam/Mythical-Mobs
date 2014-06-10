package mythology.model.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MagicWorkbench extends ModelBase {
	
    ModelRenderer Base;
    ModelRenderer Magic_Cube;
    ModelRenderer Magic;

    public MagicWorkbench() {
        textureWidth = 64;
        textureHeight = 64;

        Base = new ModelRenderer(this, 0, 0);
        Base.addBox(-2F, 0F, -2F, 16, 5, 18);
        Base.setRotationPoint(-6F, 19F, -7F);
        Base.setTextureSize(64, 64);
        Base.mirror = true;
        setRotation(Base, 0F, 0F, 0F);
        Magic_Cube = new ModelRenderer(this, 0, 41);
        Magic_Cube.addBox(-3F, -2F, -3F, 6, 6, 6);
        Magic_Cube.setRotationPoint(0F, 11F, 0F);
        Magic_Cube.setTextureSize(64, 64);
        Magic_Cube.mirror = true;
        setRotation(Magic_Cube, 0.3839724F, 0.8552113F, 0.6457718F);
        Magic = new ModelRenderer(this, 0, 23);
        Magic.addBox(0F, 0F, 0F, 16, 0, 18);
        Magic.setRotationPoint(-8F, 17F, -9F);
        Magic.setTextureSize(64, 64);
        Magic.mirror = true;
        setRotation(Magic, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Base.render(f5);
        Magic_Cube.render(f5);
        Magic.render(f5);
    }
    
    public void renderModel(float f) {
    	 Base.render(f);
         Magic_Cube.render(f);
         Magic.render(f);
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