package mythology.handlers;

import mythology.init.MythicalArmor;
import mythology.init.MythicalItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MythEventHandler {
	
	@SubscribeEvent
	public void LivingDropsEvent(LivingDeathEvent event){
		Entity entity = event.entity;
		if(!entity.worldObj.isRemote && event.source.getEntity() instanceof EntityPlayer){
			EntityPlayer player = ((EntityPlayer)event.source.getEntity());
			if (player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).isItemEqual(new ItemStack(MythicalArmor.bronzeLeggings))){
				player.addChatComponentMessage(new ChatComponentText("Item in slot 1: " + player.inventory.armorItemInSlot(1).getDisplayName()));
				entity.dropItem(Items.diamond, 1);
			}
		}
	}

	
	//TODO Move those events to item classes (See Mjolnir)
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
	
	@SubscribeEvent
	public void onBreaking(BreakSpeed event)
	{
		if (event.entity instanceof EntityPlayer) {

		EntityPlayer player = (EntityPlayer) event.entity;

			if (player.inventory.hasItem(MythicalItems.tier1GmBreakToken)) {
				event.newSpeed = event.originalSpeed * 2;
			}
			if (player.inventory.hasItem(MythicalItems.tier2GmBreakToken)) {
				event.newSpeed = event.originalSpeed * 4;
			}
			if (player.inventory.hasItem(MythicalItems.tier3GmBreakToken)) {
				event.newSpeed = event.originalSpeed * 8;
			}
			if (player.inventory.hasItem(MythicalItems.tier1GmBreakToken) && player.inventory.hasItem(MythicalItems.tier2GmBreakToken)) {
				event.newSpeed = event.originalSpeed * 6;
			}
			if (player.inventory.hasItem(MythicalItems.tier2GmBreakToken) && player.inventory.hasItem(MythicalItems.tier3GmBreakToken)) {
				event.newSpeed = event.originalSpeed * 12;
			}
			if (player.inventory.hasItem(MythicalItems.tier1GmBreakToken) && player.inventory.hasItem(MythicalItems.tier2GmBreakToken) && player.inventory.hasItem(MythicalItems.tier3GmBreakToken)) {
				event.newSpeed = event.originalSpeed * 14;
			}
			if (player.inventory.hasItem(MythicalItems.tier1GmBreakToken) && player.inventory.hasItem(MythicalItems.tier3GmBreakToken)) {
				event.newSpeed = event.originalSpeed * 10;
			}
		}
	}
}
