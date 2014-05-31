package mythology.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemWing extends MythItem{

	public ItemWing(String name, String lore) {
		super(name, lore);		
	}
	
    @Override
    public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player)
    {
        if (player.fallDistance>0)
        {
            player.addExhaustion(0.1f);
            player.motionY += 0.8;
            player.fallDistance = 0;
        }
        return stack;
    }
}
