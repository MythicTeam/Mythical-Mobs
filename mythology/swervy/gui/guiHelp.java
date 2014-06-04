package mythology.swervy.gui;

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

public class guiHelp extends GuiScreen {
	
	public static ResourceLocation texture = new ResourceLocation( MythologyMod.modid + ":textures/gui/Help.png");
	
	private final int xSizeOfTexture = 256;
	private final int ySizeOfTexture = 256;
	
	public guiHelp(EntityPlayer player) {
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
		int posY = (this.height - ySizeOfTexture) / 2 + 35;
	
		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		fontRendererObj.drawString("v" + MythologyMod.version, posX + 5, posY + 3, 4210752);
	
		super.drawScreen(x, y, f);
	}
	
	public void initGui() {
		this.buttonList.clear();

		int posX = (this.width - xSizeOfTexture) / 2 + 50;
		int posY = (this.height - ySizeOfTexture) / 2 + 45;
		
		this.buttonList.add(new GuiButton(0, posX + 30, posY + 38, 102, 20, "Change Log"));
		this.buttonList.add(new GuiButton(1, posX + 30, posY + 66, 102, 20, "Crafting Recipes"));
		this.buttonList.add(new GuiButton(2, posX + 30, posY + 94, 102, 20, "Smelting Recipes"));
		this.buttonList.add(new GuiButton(3, posX + 30, posY + 122, 102, 20, "Mobs List"));
		this.buttonList.add(new GuiButton(4, posX + 30, posY + 150, 102, 20, "Mythical Forums"));
	}
	
	public void actionPerformed(GuiButton button) {
		switch(button.id) {
			case 0: 
				this.mc.displayGuiScreen(new guiChangeLog(null));
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				try {
					Desktop.getDesktop().browse(new URI("http://mythicalcraft.comli.com/"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
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
	
	public void updateScreen() {
		
	}
	
	public void onGuiClosed() {
		
	}
	
	public boolean doesGuiPauseGame() {
        return true;
    }
}
