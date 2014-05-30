package mythology.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;
import mythology.blocks.BlockAlloyFurnace;
import mythology.recipes.AlloyRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAlloyFurnace extends TileEntity implements ISidedInventory {

    private String localizedName;

    //Gui Slots
    private ItemStack[] slots = new ItemStack[4];

    private static final int[] slots_top = new int[] {
        0
    };
    private static final int[] slots_top2 = new int[] {
        1
    };
    private static final int[] slots_bot = new int[] {
        2, 3
    };
    private static final int[] slots_side = new int[] {
        3
    };

    public int furnaceSpeed = 250;
    public int burnTime;
    public int currentItemBurnTime;
    public int cookTime;

    public int getSizeInventory() {
        return this.slots.length;
    }

    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.localizedName : "container.alloyFurnace";
    }

    public boolean hasCustomInventoryName() {
        return this.localizedName != null && this.localizedName.length() > 0;
    }

    public void setGuiDisplayName(String displayName) {
        this.localizedName = displayName;
    }

    @
    Override
    public ItemStack getStackInSlot(int i) {
        return this.slots[i];
    }

    @
    Override
    public ItemStack decrStackSize(int i, int j) {
        if (this.slots[i] != null) {
            ItemStack itemstack;
            if (this.slots[i].stackSize <= j) {
                itemstack = this.slots[i];

                this.slots[i] = null;

                return itemstack;
            } else {
                itemstack = this.slots[i].splitStack(j);

                if (this.slots[i].stackSize == 0) {
                    this.slots[i] = null;
                }
                return itemstack;
            }

        }
        return null;
    }

    @
    Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if (this.slots[i] != null) {
            ItemStack itemstack = this.slots[i];
            this.slots[i] = null;
            return itemstack;
        }

        return null;

    }

    @
    Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        this.slots[i] = itemstack;

        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
            itemstack.stackSize = this.getInventoryStackLimit();
        }

    }

    @
    Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        NBTTagList list = nbt.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound compound = (NBTTagCompound) list.getCompoundTagAt(i);
            byte b = compound.getByte("Slot");

            if (b >= 0 && b < this.slots.length) {
                this.slots[b] = ItemStack.loadItemStackFromNBT(compound);
            }
        }

        this.burnTime = (int) nbt.getShort("BurnTime");
        this.cookTime = (int) nbt.getShort("CookTime");
        this.currentItemBurnTime = (int) nbt.getShort("CurrentBurnTime");

        if (nbt.hasKey("CustomName")) {
            this.localizedName = nbt.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setShort("BurnTime", (short) this.burnTime);
        nbt.setShort("CookTime", (short) this.cookTime);
        nbt.setShort("CurrentBurnTime", (short) this.currentItemBurnTime);

        NBTTagList list = new NBTTagList();

        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] != null) {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setByte("Slot", (byte) i);
                this.slots[i].writeToNBT(compound);
                list.appendTag(compound);
            }
        }

        nbt.setTag("Items", list);

        if (this.hasCustomInventoryName()) {
            nbt.setString("CustomName", this.localizedName);
        }
    }

    @
    Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    @
    Override
    public void openInventory() {}

    @
    Override
    public void closeInventory() {}

    public void updateEntity() {
        boolean flag = this.burnTime > 0;
        boolean flag1;

        if (this.burnTime > 0) {
            this.burnTime--;
        }

        if (!this.worldObj.isRemote) {
            if (this.burnTime == 0 && this.canSmelt()) {
                this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[2]);

                if (this.burnTime > 0) {
                    if (this.slots[2] != null) {
                        this.slots[2].stackSize--;

                        if (this.slots[2].stackSize == 0) {
                            this.slots[2] = this.slots[2].getItem().getContainerItem(this.slots[2]);
                        }
                    }
                }
            }
        }

        if (this.isBurning() && this.canSmelt()) {
            this.cookTime++;

            if (this.cookTime == this.furnaceSpeed) {
                this.cookTime = 0;
                this.smeltItem();
                flag1 = true;
            } else {
                this.cookTime = 0;
            }
        }

        if (flag != this.burnTime > 0) {
            BlockAlloyFurnace.updateAlloyFurnaceBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
        }



    }

    private boolean canSmelt() {
        if (this.slots[0] == null) {
            return false;
        } else if (this.slots[1] == null) {
            return false;
        } else {
            ItemStack itemstack = AlloyRecipes.getSmeltingResult(slots[0].getItem(), slots[1].getItem());

            if (itemstack == null) return false;
            if (this.slots[3] == null) return true;
            if (!this.slots[3].isItemEqual(itemstack)) return false;

            int result = this.slots[3].stackSize + itemstack.stackSize;

            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }

    private void smeltItem() {
        if (this.canSmelt()) {
            ItemStack itemstack = AlloyRecipes.getSmeltingResult(slots[0].getItem(), slots[1].getItem());

            if (this.slots[3] == null) {
                this.slots[3] = itemstack.copy();
            } else if (this.slots[3].isItemEqual(itemstack)) {
                this.slots[3].stackSize += itemstack.stackSize;
            }

            this.slots[0].stackSize--;

            if (this.slots[0].stackSize <= 0) {
                this.slots[0] = null;
            }

            this.slots[1].stackSize--;

            if (this.slots[1].stackSize <= 0) {
                this.slots[1] = null;
            }
        }
    }


    public boolean isBurning() {
        return this.burnTime > 0;
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

    public static boolean isItemFuel(ItemStack itemstack) {
        return getItemBurnTime(itemstack) > 0;
    }

    @
    Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        return i == 3 ? false : (i == 2 ? isItemFuel(itemstack) : true);
    }

    @
    Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return var1 == 0 ? slots_top : (var1 == 1 ? slots_top2 : var1 == 2 ? slots_bot : slots_side);
    }

    @
    Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        return this.isItemValidForSlot(i, itemstack);
    }

    @
    Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
    }

    public int getBurnTimeRemainingScaled(int i) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = this.furnaceSpeed;
        }

        return this.burnTime * i / this.currentItemBurnTime;

    }

    public int getCookProgressScaled(int i) {
        return this.cookTime * i / this.furnaceSpeed;

    }


}