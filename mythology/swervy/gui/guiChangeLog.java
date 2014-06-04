package mythology.swervy.gui;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import mythology.MythologyMod;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class guiChangeLog extends GuiScreen{
	
public static ResourceLocation texture = new ResourceLocation( MythologyMod.modid + ":textures/gui/ChangeLog.png");

	private final int xSizeOfTexture = 256;
	private final int ySizeOfTexture = 256;
	
	public guiChangeLog(EntityPlayer player) {
		super();
		this.allowUserInput = true;
	}
	
	@Override
	public void drawScreen(int x, int y, float f) {
		boolean flag = Mouse.isButtonDown(0);
		
		drawDefaultBackground();
	
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
	
		int posX = (this.width - xSizeOfTexture) / 2 + 50;
		int posY = (this.height - ySizeOfTexture) / 2 + 45;
	
		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		fontRendererObj.drawString("v" + MythologyMod.version, posX + 5, posY + 3, 4210752);
		
		super.drawScreen(x, y, f);
	}
	
	public void initGui() {
		
		this.buttonList.clear();

		int posX = (this.width - xSizeOfTexture) / 2 + 50;
		int posY = (this.height - ySizeOfTexture) / 2 + 45;
		
		

	}


	
	@Override
	protected void keyTyped(char par1, int par2) {
	if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
		this.mc.thePlayer.closeScreen(); 
		}
	}
	
	public void updateScreen() {
		
	}
	
	public void onGuiClosed() {
		
	}
	
	public boolean doesGuiPauseGame() {
        return true;
    }
}
