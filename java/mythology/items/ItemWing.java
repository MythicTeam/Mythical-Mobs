package mythology.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWing extends MythItem{

	public ItemWing(String name, String lore) {
		super(name, lore);		
	}
	
    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
    	player.motionY++;
        return false;
    }
}
