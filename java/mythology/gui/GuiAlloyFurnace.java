package mythology.gui;

import org.lwjgl.opengl.GL11;

import mythology.MythologyMod;
import mythology.containers.ContainerAlloyFurnace;
import mythology.tileentities.TileEntityAlloyFurnace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiAlloyFurnace extends GuiContainer{

	public static ResourceLocation texture = new ResourceLocation( MythologyMod.modid + ":textures/gui/AlloyFurnace.png");
	public TileEntityAlloyFurnace alloyFurnace;
	
	public GuiAlloyFurnace(InventoryPlayer inventoryPlayer, TileEntityAlloyFurnace entity) {
		super(new ContainerAlloyFurnace(inventoryPlayer,entity));
		
		this.alloyFurnace = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = this.alloyFurnace.hasCustomInventoryName() ? this.alloyFurnace.getInventoryName() : I18n.format("Alloy Furnace", new Object[0]);
	
		this.fontRendererObj.drawString(name, this.xSize -64 - this.fontRendererObj.getStringWidth(name), 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
	
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(this.alloyFurnace.isBurning()){
			int k = this.alloyFurnace.getBurnTimeRemainingScaled(12);
			drawTexturedModalRect(guiLeft + 33, guiTop + 36 + 12 - k, 176, 12-k, 14, k + 2);
		}
		
		int k = this.alloyFurnace.getCookProgressScaled(24);
		drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 14, k + 1, 16);
		
	}

}
