package mythology.gui.help;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import mythology.MythologyMod;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class guiUpdate extends GuiScreen {
	
	public static ResourceLocation texture = new ResourceLocation(MythologyMod.modid + ":textures/gui/Help_Menu/Update.png");
	
	private final int xSizeOfTexture = 256;
	private final int ySizeOfTexture = 256;
	
	public guiUpdate(EntityPlayer player) {
		super();
		this.allowUserInput = true;
	}
	
	@Override
	public void drawScreen(int x, int y, float f) {
		boolean flag = Mouse.isButtonDown(0);
		super.drawScreen(x, y, f);
		drawDefaultBackground();
	
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
	
		int posX = (this.width - xSizeOfTexture) / 2 + 50;
		int posY = (this.height - ySizeOfTexture) / 2 + 60;
	
		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		
		if(guiChangeLog.checkUpdate == false) {
			fontRendererObj.drawString("v" + MythologyMod.version + " " + MythologyMod.versiobState, posX + 5, posY + 3, 4210752);
			fontRendererObj.drawString("Do you want to update?", posX + 33, posY + 32, 4210752);
		}
		
		super.drawScreen(x, y, f);
	}
	
	public void initGui() {
		this.buttonList.clear();

		int posX = (this.width - xSizeOfTexture) / 2 + 50;
		int posY = (this.height - ySizeOfTexture) / 2 + 25;
		
		this.buttonList.add(new GuiButton(0, posX + 40, posY + 77, 102, 20, "Yes"));
		this.buttonList.add(new GuiButton(1, posX + 40, posY + 100, 102, 20, "No"));
	}
	
	public void actionPerformed(GuiButton button) {
		switch(button.id) {
			case 0: 
				
				break;
			case 1:
				this.mc.displayGuiScreen(new guiChangeLog(null));
				break;
			default:
		}
	}

	
	@Override
	protected void keyTyped(char par1, int par2) {
	if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
		this.mc.thePlayer.closeScreen(); 
		}
	}
	
	public boolean doesGuiPauseGame() {
        return true;
    }
}
