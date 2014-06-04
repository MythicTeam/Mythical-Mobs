package baubles.common.network;

import baubles.common.lib.PlayerHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;

public class EventHandlerNetwork {
	
	@SubscribeEvent    
	public void playerLoggedInEvent (PlayerEvent.PlayerLoggedInEvent event)    {    
		Side side = FMLCommonHandler.instance().getEffectiveSide();        
		if (side == Side.SERVER) {
			PlayerHandler.clearPlayerBaubles(event.player);
			PlayerHandler.loadPlayerBaubles(event.player);
			for (int a=0;a<4;a++)
				PlayerHandler.getPlayerBaubles(event.player).syncSlotToClients(a);
		}
	}
	
	@SubscribeEvent    
	public void playerUpdateEvent (PlayerEvent event)    {  
		Side side = FMLCommonHandler.instance().getEffectiveSide();        
		if (side == Side.SERVER) {
			PlayerHandler.savePlayerBaubles(event.player);
		}
	}
	
}
