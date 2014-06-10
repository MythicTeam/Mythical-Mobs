package mythology.handlers;

import java.util.EnumSet;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import mythology.MythologyMod;
import mythology.gui.help.guiHelp;
import mythology.init.MythologyRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyInputHandler extends KeyHandler {
	
	public Random rand;
	public static World world;
	public Minecraft mc;
	public KeyBinding GUIkey;

	
	/**
	 * KeyInputEvent is in the FML package, so we must register to the FML event
	 * bus
	 */
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {
		
		//Open Help GUI
		if (!FMLClientHandler.instance().isGUIOpen(guiHelp.class)) {
			if (KeyHandler.keyMagicHelp.isPressed()) {
				FMLClientHandler.instance().getClient().displayGuiScreen(new guiHelp(null));
			}
		}
	}

}