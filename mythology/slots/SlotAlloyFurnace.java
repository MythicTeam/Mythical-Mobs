package mythology.slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotAlloyFurnace extends Slot
{
public SlotAlloyFurnace(EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k)
{
         super(iinventory, i, j, k);
}
/**
         * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
         */
public boolean isItemValid(ItemStack itemstack)
{
         return false;
}
/**
         * Called when the player picks up an item from an inventory slot
         */
public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
{
         this.onCrafting(par2ItemStack);
         super.onPickupFromSlot(par1EntityPlayer, par2ItemStack);
}
}