package mythology.containers;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mythology.recipes.AlloyRecipes;
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
	public int dualCookTime;
	/** The start time for this fuel */
	public int dualBurnTime;
	/** How long time left before cooked */
	public int lastItemBurnTime;
	
	public static final int INPUT_1 = 0, INPUT_2 = 1, FUEL = 2, OUTPUT = 3;

	public ContainerAlloyFurnace(InventoryPlayer inventory, TileEntityAlloyFurnace tileentity) {
		this.alloyFurnace = tileentity;
		
		this.addSlotToContainer(new Slot(tileentity, INPUT_1, 21, 17));
		this.addSlotToContainer(new Slot(tileentity, INPUT_2, 44, 17));
		this.addSlotToContainer(new Slot(tileentity, FUEL, 33, 53));
		this.addSlotToContainer(new SlotAlloyFurnace(inventory.player, tileentity, OUTPUT, 116, 35));
        for (int i = 0; i < 3; i++)
        {
                for (int k = 0; k < 9; k++)
                {
                        this.addSlotToContainer(new Slot(inventory, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
                }
        }
        for (int j = 0; j < 9; j++)
        {
                this.addSlotToContainer(new Slot(inventory, j, 8 + j * 18, 142));
        }
}
public void addCraftingToCrafters(ICrafting par1ICrafting)
{
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.alloyFurnace.dualCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.alloyFurnace.dualBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.alloyFurnace.currentItemBurnTime);
}
/**
        * Looks for changes made in the container, sends them to every listener.
        */
public void detectAndSendChanges()
{
        super.detectAndSendChanges();
        for (int var1 = 0; var1 < this.crafters.size(); ++var1)
        {
                ICrafting var2 = (ICrafting)this.crafters.get(var1);
                if (this.dualCookTime != this.alloyFurnace.dualCookTime)
                {
                        var2.sendProgressBarUpdate(this, 0, this.alloyFurnace.dualCookTime);
                }
                if (this.dualBurnTime != this.alloyFurnace.dualBurnTime)
                {
                        var2.sendProgressBarUpdate(this, 1, this.alloyFurnace.dualBurnTime);
                }
                if (this.lastItemBurnTime != this.alloyFurnace.currentItemBurnTime)
                {
                        var2.sendProgressBarUpdate(this, 2, this.alloyFurnace.currentItemBurnTime);
                }
        }
        this.dualCookTime = this.alloyFurnace.dualCookTime;
        this.dualBurnTime = this.alloyFurnace.dualBurnTime;
        this.lastItemBurnTime = this.alloyFurnace.currentItemBurnTime;
}

public void updateProgressBar(int i, int j)
{
        if (i == 0)
        {
        	alloyFurnace.dualCookTime = j;
        }
        if (i == 1)
        {
        	alloyFurnace.dualBurnTime = j;
        }
        if (i == 2)
        {
        	alloyFurnace.currentItemBurnTime = j;
        }
}
/**
* Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
*/
public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
{
ItemStack itemstack = null;
Slot slot = (Slot)this.inventorySlots.get(par2);

if (slot != null && slot.getHasStack())
{
ItemStack itemstack1 = slot.getStack();
itemstack = itemstack1.copy();

if (par2 == OUTPUT)
{

if (!this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+36+1, true))
{
return null;
}

slot.onSlotChange(itemstack1, itemstack);
}
else if (par2 != FUEL && par2 != INPUT_1 && par2 != INPUT_2)
{
if (AlloyRecipes.getSmeltingResult(itemstack1.getItem(), itemstack1.getItem()) != null)
{
	
if (!this.mergeItemStack(itemstack1, INPUT_1, INPUT_2+1, false))
{
return null;
}
}
else if (TileEntityAlloyFurnace.isItemFuel(itemstack1))
{
if (!this.mergeItemStack(itemstack1, FUEL, FUEL+1, false))
{
return null;
}
}
else if (par2 >= OUTPUT+1 && par2 < OUTPUT+28)
{
if (!this.mergeItemStack(itemstack1, OUTPUT+28, OUTPUT+37, false))
{
return null;
}
}
else if (par2 >= OUTPUT+28 && par2 < OUTPUT+37 && !this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+28, false))
{
return null;
}
}
else if (!this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+37, false))
{
return null;
}

if (itemstack1.stackSize == 0)
{
slot.putStack((ItemStack)null);
}
else
{
slot.onSlotChanged();
}

if (itemstack1.stackSize == itemstack.stackSize)
{
return null;
}

slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
}
return itemstack;
}

public boolean canInteractWith(EntityPlayer entityplayer)
{
        return alloyFurnace.isUseableByPlayer(entityplayer);
}
}