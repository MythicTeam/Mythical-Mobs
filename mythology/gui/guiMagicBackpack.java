package mythology.gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import mythology.MythologyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class guiMagicBackpack extends GuiScreen {
	
	public static ResourceLocation texture = new ResourceLocation(MythologyMod.modid + ":textures/gui/MagicBackpack.png");
	
	private final int xSizeOfTexture = 256;
	private final int ySizeOfTexture = 256;
	
	public guiMagicBackpack(EntityPlayer player) {
		super();
		this.allowUserInput = true;
	}

	@Override
	public void drawScreen(int x, int y, float f) {
		boolean flag = Mouse.isButtonDown(0);
		
		drawDefaultBackground();
	
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
	
		int posX = (this.width - xSizeOfTexture) / 2 + 40;
		int posY = (this.height - ySizeOfTexture) / 2 + 55;
	
		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		//fontRendererObj.drawString("v" + MythologyMod.version + " " + MythologyMod.versiobState, posX + 5, posY + 3, 4210752);
	
		super.drawScreen(x, y, f);
	}
	
	public boolean doesGuiPauseGame() {
        return true;
    }
}
