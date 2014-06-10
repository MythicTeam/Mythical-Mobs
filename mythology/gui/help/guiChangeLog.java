package mythology.gui.help;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import mythology.MythologyMod;
import mythology.init.MythologyRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;

public class guiChangeLog extends GuiScreen{
	
	private static URL u;
	private static InputStream is = null;
	private static DataInputStream dis;
	private static String s;
	
	private static ResourceLocation texture = new ResourceLocation( MythologyMod.modid + ":textures/gui/Help_Menu/ChangeLog.png");
	
	private final int xSizeOfTexture = 256;
	private final int ySizeOfTexture = 256;
	
	public static boolean checkUpdate;
	
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
		fontRendererObj.drawString("v" + MythologyMod.version + " " + MythologyMod.versiobState, posX + 5, posY + 3, 4210752);
		
		URL website;
		try {
			
			website = new URL("http://pastebin.com/raw.php?i=8ApjKbwQ");
            HttpURLConnection urlConnect = (HttpURLConnection)website.openConnection();
            Object objData = urlConnect.getContent();
            BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));
            if(urlConnect.getContent() != null) {
				String changes;
				while ((changes = in.readLine()) != null)
					fontRendererObj.drawString(changes, posX + 10, posY + 38, 4210752);
					in.close();
            } else {
            	fontRendererObj.drawString("Check Internet Connection!", posX + 10, posY + 38, 4210752);
            	in.close();
            }
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.drawScreen(x, y, f);
	}
	
	public void initGui() {
		this.buttonList.clear();

		int posX = (this.width - xSizeOfTexture) / 2 + 50;
		int posY = (this.height - ySizeOfTexture) / 2 + 45;
		
		URL website;
		
		try {
			website = new URL("http://pastebin.com/download.php?i=qzKzQctW");
			BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));
			String inputLine;
			
			HttpURLConnection urlConnect = (HttpURLConnection)website.openConnection();
			if(urlConnect.getContent() != null) {
				while ((inputLine = in.readLine()) != null) {
					if(inputLine.equals(MythologyMod.version)) {
						this.buttonList.add(new GuiButton(1, posX + 36, posY + 140, 102, 20, "Back"));
					} else {
						this.buttonList.add(new GuiButton(1, posX + 9, posY + 140, 75, 20, "Back"));
						this.buttonList.add(new GuiButton(0, posX + 91, posY + 140, 75, 20, "Update"));
					}
					in.close();
				}
			} else {
				this.buttonList.add(new GuiButton(1, posX + 36, posY + 140, 102, 20, "Back"));
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		BufferedReader br = null;
		 
		try {
 
			String current = new java.io.File( "." ).getCanonicalPath();
			
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(current + "/mods/mythical/changeLog.txt"));
 
			while ((sCurrentLine = br.readLine()) != null) {
				//this.buttonList.add(new GuiButton(0, posX + 36, posY + 140, 102, 20, sCurrentLine));
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void actionPerformed(GuiButton button) {
		switch(button.id) {
			case 0:
				this.mc.displayGuiScreen(new guiUpdate(null));
				break;
			case 1: 
				this.mc.displayGuiScreen(new guiHelp(null));
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
