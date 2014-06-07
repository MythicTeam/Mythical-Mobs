package mythology.tileentities;
import cpw.mods.fml.common.registry.GameRegistry;
import mythology.blocks.BlockAlloyFurnace;
import mythology.init.MythicalIngot;
import mythology.recipes.AlloyRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAlloyFurnace extends TileEntity implements IInventory {
    private ItemStack blastItemStacks[];
    public int dualBurnTime;
    public int currentItemBurnTime;
    public int dualCookTime;
    private String customName;
    public TileEntityAlloyFurnace() {
        blastItemStacks = new ItemStack[4];
        dualBurnTime = 0;
        currentItemBurnTime = 0;
        dualCookTime = 0;
    }

    public int getSizeInventory() {
        return blastItemStacks.length;
    }

    public ItemStack getStackInSlot(int i) {
        return blastItemStacks[i];
    }
    public void setInventorySlotContainers(int i, ItemStack itemstack) {
        blastItemStacks[i] = itemstack;
        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
            itemstack.stackSize = getInventoryStackLimit();
        }
    }

    public void readFromNBT(NBTTagCompound nbttagcompound) {
        super.readFromNBT(nbttagcompound);
        NBTTagList list = nbttagcompound.getTagList("Items", 10);
        blastItemStacks = new ItemStack[getSizeInventory()];
        for (int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound) list.getCompoundTagAt(i);
            byte byte0 = nbttagcompound1.getByte("Slot");
            if (byte0 >= 0 && byte0 < blastItemStacks.length) {
                blastItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
        dualBurnTime = nbttagcompound.getShort("BurnTime");
        dualCookTime = nbttagcompound.getShort("CookTime");
        currentItemBurnTime = getItemBurnTime(blastItemStacks[1]);
    }

    public void writeToNBT(NBTTagCompound nbttagcompound) {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setShort("BurnTime", (short) dualBurnTime);
        nbttagcompound.setShort("CookTime", (short) dualCookTime);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < blastItemStacks.length; i++) {
            if (blastItemStacks[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                blastItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        nbttagcompound.setTag("Items", nbttaglist);
    }

    public int getInventoryStackLimit() {
        return 64;
    }
    public int getCookProgressScaled(int i) {
        return (dualCookTime * i) / 200;
    }
    public int getBurnTimeRemainingScaled(int i) {
        if (currentItemBurnTime == 0) {
            currentItemBurnTime = 200;
        }
        return (dualBurnTime * i) / currentItemBurnTime;
    }
    public boolean isBurning() {
        return dualBurnTime > 0;
    }
    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity() {
        boolean flag = dualBurnTime > 0;
        boolean flag1 = false;
        if (dualBurnTime > 0) {
            dualBurnTime--;
        }
        if (!worldObj.isRemote) {
            if (dualBurnTime == 0 && canSmelt()) {
                currentItemBurnTime = dualBurnTime = getItemBurnTime(blastItemStacks[2]);
                if (dualBurnTime > 0) {
                    flag1 = true;
                    if (blastItemStacks[2] != null) {
                        if (blastItemStacks[2].stackSize == 0) {
                            blastItemStacks[2] = new ItemStack(blastItemStacks[2].getItem().setFull3D());
                        } else {
                            blastItemStacks[2].stackSize--;
                        }
                        if (blastItemStacks[2].stackSize == 0) {
                            blastItemStacks[2] = null;
                        }
                    }
                }
            }
            if (isBurning() && canSmelt()) {
                dualCookTime++;
                if (dualCookTime == 200) {
                    dualCookTime = 0;
                    smeltItem();
                    flag1 = true;
                }
            } else {
                dualCookTime = 0;
            }
            if (flag != (dualBurnTime > 0)) {
                flag1 = true;
                BlockAlloyFurnace.updateAlloyFurnaceBlockState(this.dualBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }
        if (flag1) {
            markDirty();
        }
    }
    private boolean canSmelt() {
        if (blastItemStacks[0] == null || blastItemStacks[1] == null) {
            return false;
        }
        ItemStack itemstack = AlloyRecipes.getSmeltingResult(blastItemStacks[0].getItem(), blastItemStacks[1].getItem());
        if (itemstack == null) {
            return false;
        }
        if (blastItemStacks[3] == null) {
            return true;
        }
        if (!blastItemStacks[3].isItemEqual(itemstack)) {
            return false;
        }
        if (blastItemStacks[3].stackSize < getInventoryStackLimit() && blastItemStacks[3].stackSize < blastItemStacks[3].getMaxStackSize()) {
            return true;
        } else {
            return blastItemStacks[3].stackSize > itemstack.getMaxStackSize();
        }
    }
    private void smeltItem() {
        if (this.canSmelt()) {
            ItemStack itemstack = AlloyRecipes.getSmeltingResult(blastItemStacks[0].getItem(), blastItemStacks[1].getItem());

            if (this.blastItemStacks[3] == null) {
                this.blastItemStacks[3] = itemstack.copy();
            } else if (this.blastItemStacks[3].isItemEqual(itemstack)) {
                this.blastItemStacks[3].stackSize += itemstack.stackSize;
            }

            this.blastItemStacks[0].stackSize--;

            if (this.blastItemStacks[0].stackSize <= 0) {
                this.blastItemStacks[0] = null;
            }

            this.blastItemStacks[1].stackSize--;

            if (this.blastItemStacks[1].stackSize <= 0) {
                this.blastItemStacks[1] = null;
            }
        }
    }
    public static int getItemBurnTime(ItemStack itemstack) {
        if (itemstack == null) {
            return 0;
        } else {
            Item i = itemstack.getItem();

            if (i instanceof ItemBlock && Block.getBlockFromItem(i) != Blocks.air) {
                Block block = Block.getBlockFromItem(i);

                if (block == Blocks.wooden_slab) {
                    return 150;
                }
                if (block.getMaterial() == Material.wood) {
                    return 300;
                }
                if (block == Blocks.coal_block) {
                    return 16000;
                }
            }

            if (i instanceof ItemHoe && ((ItemHoe) i).getToolMaterialName().equals("WOOD")) return 200;
            if (i instanceof ItemSword && ((ItemSword) i).getToolMaterialName().equals("WOOD")) return 200;
            if (i instanceof ItemTool && ((ItemTool) i).getToolMaterialName().equals("WOOD")) return 200;
            if (i == Items.stick) return 100;
            if (i == Items.coal) return 1600;
            if (i == Items.lava_bucket) return 20000;
            if (i == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (i == Items.blaze_rod) return 2400;

            return GameRegistry.getFuelValue(itemstack);
        }

    }
    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this) {
            return false;
        } else {
            return entityplayer.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D;
        }
    }
    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int i, int j) {
        if (blastItemStacks[i] != null) {
            if (blastItemStacks[i].stackSize <= j) {
                ItemStack itemstack = blastItemStacks[i];
                blastItemStacks[i] = null;
                return itemstack;
            }
            ItemStack itemstack1 = blastItemStacks[i].splitStack(j);
            if (blastItemStacks[i].stackSize == 0) {
                blastItemStacks[i] = null;
            }
            return itemstack1;
        } else {
            return null;
        }
    }
    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        blastItemStacks[i] = itemstack;
        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
            itemstack.stackSize = getInventoryStackLimit();
        }
    }
    /**
     * Returns the name of the inventory.
     */
    public String getInventoryName() {
        return "container.alloyFurnace";
    }
    public void openInventory() {}
    public void closeInventory() {}
    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int i) {
        if (blastItemStacks[i] != null) {
            ItemStack itemstack = blastItemStacks[i];
            blastItemStacks[i] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    @
    Override
    public boolean hasCustomInventoryName() {
        return (this.customName != null) && (this.customName.length() > 0);
    }
    public void setCustomName(String name) {
        this.customName = name;
    }
    public static boolean isItemFuel(ItemStack itemstack) {
        return getItemBurnTime(itemstack) > 0;
    }@
    Override
    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
        return par1 == 3 ? false : (par1 == 2 ? isItemFuel(par2ItemStack) : true);
    }




}