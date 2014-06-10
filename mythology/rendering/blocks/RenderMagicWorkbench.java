package mythology.rendering.blocks;

import org.lwjgl.opengl.GL11;

import mythology.MythologyMod;
import mythology.model.blocks.MagicWorkbench;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderMagicWorkbench extends TileEntitySpecialRenderer {

	private static ResourceLocation texture = new ResourceLocation(MythologyMod.modid + ":textures/blocks/blocks/MagicWorkbench.png");
	private MagicWorkbench model;
	
	public RenderMagicWorkbench() {
		this.model = new MagicWorkbench();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
