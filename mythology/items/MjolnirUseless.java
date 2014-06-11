package mythology.items;

import mythology.MythologyMod;
import mythology.init.MythicalItems;
import mythology.init.MythicalTools;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MjolnirUseless extends MythItem {

	public MjolnirUseless() {
		super("mjolnirUseless", "You aren't strong enough to use this.");
        this.maxStackSize = 1;
        setFull3D();
        setTextureName(MythologyMod.modid + ":mjolnir");
	}
	
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5)
    {
    	if (entity instanceof EntityPlayer){
    		EntityPlayer player = ((EntityPlayer)entity);
        	if(player.inventory.hasItem(MythicalItems.jarngreipr)){
        		player.inventory.consumeInventoryItem(this);
        		player.inventory.addItemStackToInventory(new ItemStack(MythicalTools.mjolnir));
        	}
    	}
    }    
}
