package mythology.model.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStrawHat extends ModelBiped {
	ModelRenderer Cap;	
	

	public ModelStrawHat(float f) {
		textureWidth = 64;
		textureHeight = 32;

		Cap = new ModelRenderer(this, 0, 0);
		Cap.addBox(-6F, -6F, -6F, 12, 1, 12);
		Cap.setRotationPoint(0F, 0F, 0F);
		Cap.setTextureSize(64, 32);
		Cap.mirror = true;
		setRotation(Cap, 0F, 0F, 0F);
        this.bipedHead.addChild(Cap);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		Cap.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
