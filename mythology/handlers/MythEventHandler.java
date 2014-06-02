package mythology.handlers;

import mythology.init.MythicalItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MythEventHandler {

	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			ItemStack heldItem = player.getHeldItem();
			if (player.inventory.hasItem(MythicalItems.flyToken)) {
				player.capabilities.allowFlying = true;
			} else if(!player.capabilities.allowFlying && player.capabilities.isFlying){
				player.capabilities.isFlying = false;
			} else {
				player.capabilities.allowFlying = player.capabilities.isCreativeMode ? true
						: false;
			}
			if (heldItem != null && heldItem.getItem() == MythicalItems.noclipToken) {
				player.noClip = true;
			} else {
				player.noClip = false;
			}
		}
	}
}
