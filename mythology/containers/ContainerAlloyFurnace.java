package mythology.containers;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mythology.slots.SlotAlloyFurnace;
import mythology.tileentities.TileEntityAlloyFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ContainerAlloyFurnace extends Container {

	private TileEntityAlloyFurnace alloyFurnace;
	/** How long this furnace will continue to burn for (fuel) */
	public int lastBurnTime;
	/** The start time for this fuel */
	public int lastItemBurnTime;
	/** How long time left before cooked */
	public int lastCookTime;

	public ContainerAlloyFurnace(InventoryPlayer inventory, TileEntityAlloyFurnace tileentity) {
		this.alloyFurnace = tileentity;
		
		this.addSlotToContainer(new Slot(tileentity, 0, 21, 17));
		this.addSlotToContainer(new Slot(tileentity, 1, 44, 17));
		this.addSlotToContainer(new Slot(tileentity, 2, 33, 53));
		this.addSlotToContainer(new SlotAlloyFurnace(inventory.player, tileentity, 3, 116, 35));
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(inventory, j + i*9 + 9, 8 + j*18, 84 + i*18));
			}
		}
		
		for(int i = 0; i < 9; i++){
			this.addSlotToContainer(new Slot(inventory, i, 8 + i*18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting icrafting){
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.alloyFurnace.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.alloyFurnace.cookTime);
		icrafting.sendProgressBarUpdate(this, 2, this.alloyFurnace.burnTime);
		icrafting.sendProgressBarUpdate(this, 3, this.alloyFurnace.currentItemBurnTime);

	}
	
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.crafters.size(); i++){
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.alloyFurnace.cookTime){
				icrafting.sendProgressBarUpdate(this, 0, this.alloyFurnace.cookTime);
			}
			
			if(this.lastCookTime != this.alloyFurnace.cookTime){
				icrafting.sendProgressBarUpdate(this, 1, this.alloyFurnace.cookTime);
			}
			
			if(this.lastBurnTime != this.alloyFurnace.burnTime){
				icrafting.sendProgressBarUpdate(this, 2, this.alloyFurnace.burnTime);
			}
			
			if(this.lastItemBurnTime != this.alloyFurnace.currentItemBurnTime){
				icrafting.sendProgressBarUpdate(this, 3, this.alloyFurnace.currentItemBurnTime);
			}
		}
		
		this.lastCookTime = this.alloyFurnace.cookTime;
		this.lastBurnTime = this.alloyFurnace.burnTime;
		this.lastItemBurnTime = this.alloyFurnace.currentItemBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int newValue){
		if(slot == 0) this.alloyFurnace.cookTime = newValue;
		if(slot == 1) this.alloyFurnace.cookTime = newValue;
		if(slot == 2) this.alloyFurnace.burnTime = newValue;
		if(slot == 3) this.alloyFurnace.currentItemBurnTime = newValue;
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int clickedSlotNumber){
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(clickedSlotNumber);
		
		if(slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if(clickedSlotNumber == 3){
				if(!this.mergeItemStack(itemstack1, 3, 39, true)){
					return null;
				}
				
				slot.onSlotChange(itemstack1, itemstack);
			}else if(clickedSlotNumber != 2 && clickedSlotNumber != 0 && clickedSlotNumber != 1){
				if(FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null){
					if(!this.mergeItemStack(itemstack1, 0, 1, false)){
						return null;
					}
				}else if(TileEntityAlloyFurnace.isItemFuel(itemstack1)){
					if(!this.mergeItemStack(itemstack1, 2, 3, false)){
						return null;
					}
				}else if(clickedSlotNumber >= 4 && clickedSlotNumber < 31){
					if(!this.mergeItemStack(itemstack1, 31, 40, false)){
						return null;
					}
				}else if(clickedSlotNumber >= 31 && clickedSlotNumber < 40){
					if(!this.mergeItemStack(itemstack1, 4, 31, false)){
						return null;
					}
				}
			}else if(!this.mergeItemStack(itemstack1, 4, 40, false)){
				return null;
			}
			
			if(itemstack1.stackSize == 0){
				slot.putStack((ItemStack)null);
			}else{
				slot.onSlotChanged();
			}
			
			if(itemstack1.stackSize == itemstack.stackSize){ 
				return null;
			}
			
			slot.onPickupFromSlot(player, itemstack1);
		}
		
		return itemstack;

		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return this.alloyFurnace.isUseableByPlayer(entityplayer);
	}

}
